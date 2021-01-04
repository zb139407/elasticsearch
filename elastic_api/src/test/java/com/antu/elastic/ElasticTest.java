package com.antu.elastic;

import com.alibaba.fastjson.JSON;
import com.antu.elastic.mapper.BdcqzsDao;
import com.antu.elastic.mapper.XsFdcq2Dao;
import com.antu.elastic.pojo.Bdcqzs;
import com.antu.elastic.pojo.XsFdcq2;
import com.antu.elastic.repository.BdcqzsRepository;
import com.antu.elastic.repository.XsFdcq2Repository;
import org.beetl.sql.core.SQLReady;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author: zhangBin 1394078687@qq.com
 * @description: TODO
 * @date: 2020/12/29 14:32
 */
@SpringBootTest
public class ElasticTest {
    @Autowired
    private BdcqzsDao bdcqzsDao;

    @Autowired
    private XsFdcq2Dao xsFdcq2Dao;

    @Autowired
    private BdcqzsRepository bdcqzsRepository;

    @Autowired
    private XsFdcq2Repository xsFdcq2Repository;

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Autowired
    private ElasticUtil elasticUtil;

    @Test
    void testInsertBdcqzs1() throws IOException {
        String countSql = "select count(1) from bdcqzs where djsj is not null";
        int count = bdcqzsDao.getSQLManager().execute(new SQLReady(countSql), Integer.class).get(0);
        int start = 0;
        while (start <= count) {
            String sql = "select * from (select rownum as num, t.* from netobdc.bdcqzs t where djsj is not null and rownum <= " + (start + 1000) + ") temp where temp.num > " + start;
            List<Bdcqzs> list = bdcqzsDao.getSQLManager().execute(new SQLReady(sql), Bdcqzs.class);
            // 批量处理请求
            BulkRequest bulkRequest = new BulkRequest();
            bulkRequest.timeout("100s");
            for (Bdcqzs bdcqzs : list) {
                bulkRequest.add(
                        new IndexRequest("netobdc_bdcqzs")
                                .source(JSON.toJSONString(bdcqzs), XContentType.JSON)
                );
            }
            BulkResponse bulkResponse = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
            System.out.println((start + 1000) + "：" + bulkResponse.hasFailures());
            start += 1000;
        }
    }

    @Test
    void testInsertXsFdcq21() throws IOException {
        String countSql = "select count(1) from bdcinfo.xs_fdcq2 where djsj is not null";
        int count = xsFdcq2Dao.getSQLManager().execute(new SQLReady(countSql), Integer.class).get(0);
        int start = 0;
        while (start <= count) {
            String sql = "select * from (select rownum as num, t.* from bdcinfo.xs_fdcq2 t where djsj is not null and rownum <= " + (start + 1000) + ") temp where temp.num > " + start;
            List<XsFdcq2> list = xsFdcq2Dao.getSQLManager().execute(new SQLReady(sql), XsFdcq2.class);
            // 批量处理请求
            BulkRequest bulkRequest = new BulkRequest();
            bulkRequest.timeout("100s");
            for (XsFdcq2 xsFdcq2 : list) {
                bulkRequest.add(
                        new IndexRequest("bdcinfo_xs_fdcq2")
                                .source(JSON.toJSONString(xsFdcq2), XContentType.JSON)
                );
            }
            BulkResponse bulkResponse = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
            System.out.println((start + 1000) + "：" + bulkResponse.hasFailures());
            start += 1000;
        }
    }

    @Test
    void testInsertBdcqzs2() throws IOException {
        String countSql = "select count(1) from bdcqzs where djsj is not null";
        int count = bdcqzsDao.getSQLManager().execute(new SQLReady(countSql), Integer.class).get(0);
        long start = 0;
        while (start <= 10000) {
            Long totalHits = elasticUtil.getTotalHits("bdcqzs");
            String sql = "select * from (select rownum as num, t.* from netobdc.bdcqzs t where djsj is not null and rownum <= " + (start + 10000) + ") temp where temp.num > " + start;
            List<Bdcqzs> list = bdcqzsDao.getSQLManager().execute(new SQLReady(sql), Bdcqzs.class);
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setId(totalHits + i);
            }
            bdcqzsRepository.saveAll(list);
            System.out.println((start + 10000));
            start += 10000;
        }
    }

    @Test
    void testInsertXsFdcq22() throws IOException {
        String countSql = "select count(1) from bdcinfo.xs_fdcq2 where djsj is not null";
        int count = xsFdcq2Dao.getSQLManager().execute(new SQLReady(countSql), Integer.class).get(0);
        int start = 0;
        while (start <= count) {
            Long totalHits = elasticUtil.getTotalHits("bdcinfo_xs_fdcq2");
            String sql = "select * from (select rownum as num, t.* from bdcinfo.xs_fdcq2 t where djsj is not null and rownum <= " + (start + 10000) + ") temp where temp.num > " + start;
            List<XsFdcq2> list = xsFdcq2Dao.getSQLManager().execute(new SQLReady(sql), XsFdcq2.class);
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setId(totalHits + i);
            }
            xsFdcq2Repository.saveAll(list);
            System.out.println((start + 10000));
            start += 10000;
        }
    }

    @Test
    void testSearch1() throws IOException {
        // 搜索请求对象
        SearchRequest searchRequest = new SearchRequest("netobdc_bdcqzs");

        // 搜索源构建对象
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        // 布尔查询
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();

        // 定义匹配查询
        boolQueryBuilder.must(QueryBuilders.matchPhraseQuery("allqlr", "戴"));
        boolQueryBuilder.must(QueryBuilders.matchPhraseQuery("qlrmc", "戴元"));

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

        System.out.println(list.size());
        System.out.println(list);
    }

    @Test
    void searchSort() throws IOException {
        // 搜索请求对象
        SearchRequest searchRequest = new SearchRequest("netobdc_bdcqzs");

        // 搜索源构建对象
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder().trackTotalHits(true).sort("_id", SortOrder.DESC);

        // 全匹配
        MatchAllQueryBuilder matchAllQueryBuilder = QueryBuilders.matchAllQuery();
        // 搜索方式
        searchSourceBuilder.query(matchAllQueryBuilder);
        // 向搜索请求对象中添加搜索源
        searchRequest.source(searchSourceBuilder);
        // 执行搜索，向es发出http请求
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        // 获取搜索结果
        SearchHits hits = searchResponse.getHits();
        System.out.println(hits.getTotalHits().value);
    }
}
