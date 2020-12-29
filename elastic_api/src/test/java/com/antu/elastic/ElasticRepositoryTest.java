package com.antu.elastic;

import com.alibaba.fastjson.JSON;
import com.antu.elastic.mapper.BdcqzsDao;
import com.antu.elastic.pojo.Bdcqzs;
import com.antu.elastic.repository.BdcqzsRepository;
import org.beetl.sql.core.SQLReady;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.FuzzyQueryBuilder;
import org.elasticsearch.index.query.MatchPhraseQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

import java.io.IOException;
import java.util.*;

/**
 * @author: zhangBin 1394078687@qq.com
 * @description: TODO
 * @date: 2020/12/28 17:42
 */
@SpringBootTest
public class ElasticRepositoryTest {
    @Autowired
    private BdcqzsRepository bdcqzsRepository;

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Autowired
    private BdcqzsDao bdcqzsDao;

    @Test
    void save() {
        String countSql = "select count(1) from bdcqzs where djsj is not null";
        int count = bdcqzsDao.getSQLManager().execute(new SQLReady(countSql), Integer.class).get(0);
        int start = 970000;
        while (start <= count) {
            String sql = "select * from (select rownum as num, t.bsm, t.iid, t.allqlr, t.qlrmc, t.bdcqzh from netobdc.bdcqzs t where djsj is not null and rownum <= " + (start + 10000) + ") temp where temp.num > " + start;
            List<Bdcqzs> list = bdcqzsDao.getSQLManager().execute(new SQLReady(sql), Bdcqzs.class);
            bdcqzsRepository.saveAll(list);
            System.out.println((start + 10000));
            start += 10000;
        }
    }

    @Test
    void test() {
        Bdcqzs bdcqzs = new Bdcqzs();
        bdcqzs.setDjsj(new Date());
        bdcqzsRepository.save(bdcqzs);
    }

    @Test
    void get() throws IOException {
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("cjr", "夏海华");
        // 搜索请求对象
        SearchRequest searchRequest = new SearchRequest("netobdc_bdcqzs");
        // 搜索源构建对象
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        // 布尔查询
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();

        // 定义匹配查询  matchPhraseQuery可代替精确匹配  matchQuery相似度匹配
        queryMap.forEach((key, value) -> {
            MatchPhraseQueryBuilder matchPhraseQueryBuilder = QueryBuilders.matchPhraseQuery(key, value);
            boolQueryBuilder.must(matchPhraseQueryBuilder);
        });
        // 搜索方式 布尔查询
        searchSourceBuilder.query(boolQueryBuilder);
        // 向搜索请求对象中添加搜索源
        searchRequest.source(searchSourceBuilder);
        // 执行搜索，向es发出http请求
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        // 获取搜索结果
        SearchHits hits = searchResponse.getHits();
        // 得到匹配度高的文档
        SearchHit[] searchHits = hits.getHits();
        List<Map<String, Object>> list = new ArrayList<>();
        for (SearchHit hit : searchHits) {
            Map<String, Object> map = hit.getSourceAsMap();
            list.add(map);
        }
        System.out.println(list);
    }
}
