package com.antu.elastic.controller;

import com.alibaba.fastjson.JSON;
import com.antu.elastic.ElasticUtil;
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
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.*;

/**
 * @author: zhangBin 1394078687@qq.com
 * @description: TODO
 * @date: 2020/12/24 9:59
 */
@RestController
public class TestController {
    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Autowired
    private BdcqzsDao bdcqzsDao;

    /**
     * matchAllQuery 搜索全部记录
     * termQuery 精确查询 存在问题，可替换为matchPhraseQuery
     * termsQuery id精确匹配
     * matchQuery 相关度查询
     * multiQuery 多字段匹配
     * BoolQuery 布尔查询
     */

    /**
     * 搜索全部记录
     */
    @PostMapping("/match/all/query")
    public String matchAllQuery() {
        try {
            // 搜索请求对象
            SearchRequest searchRequest = new SearchRequest("antu_bdcqzs");

            // 搜索源构建对象
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            // 分页查询，设置起始下标，从0开始
            searchSourceBuilder.from(0);
            // 每页显示个数
            searchSourceBuilder.size(10000);

            // 搜索方式 matchAllQuery：搜索全部
            searchSourceBuilder.query(QueryBuilders.matchAllQuery());

            // source源字段过虑，第一个参数结果集包括哪些字段，第二个参数表示结果集不包括哪些字段
//            searchSourceBuilder.fetchSource(new String[]{"iid", "qlrmc", "bsm"}, new String[]{});
//            searchSourceBuilder.fetchSource(new String[]{}, new String[]{});
            // 向搜索请求对象中添加搜索源
            searchRequest.source(searchSourceBuilder);
            // 执行搜索，向es发出http请求
            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            // 获取搜索结果
            SearchHits hits = searchResponse.getHits();
            // 得到匹配度高的文档
            SearchHit[] searchHits = hits.getHits();
            List<Bdcqzs> list = new ArrayList<>();
            for (SearchHit hit : searchHits) {
                String index = hit.getIndex();
                // 文档的主键
                String id = hit.getId();
                float score = hit.getScore();
                String sourceAsString = hit.getSourceAsString();
                Bdcqzs bdcqzs = JSON.parseObject(sourceAsString, Bdcqzs.class);
                list.add(bdcqzs);
                // 源文档内容，就是数据中_source中的内容
/*                Map<String, Object> sourceAsMap = hit.getSourceAsMap();
                String iid = (String) sourceAsMap.get("iid");
                String qlrmc = (String) sourceAsMap.get("qlrmc");
                String bsm = (String) sourceAsMap.get("bsm");*/
            }
            return JSON.toJSONString(list);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    /**
     * 精确匹配 存在疑问（value长度限制等） client存在问题，可使用matchQuery代替
     */
    @PostMapping("/term/query")
    public void termQuery() {
        try {
            // 搜索请求对象
            SearchRequest searchRequest = new SearchRequest("antu_test");

            // 搜索源构建对象
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

            // 搜索方式 termQuery：精确匹配
            searchSourceBuilder.query(QueryBuilders.termQuery("qlrmc", "贺鑫"));
            // 向搜索请求对象中添加搜索源
            searchRequest.source(searchSourceBuilder);
            // 执行搜索，向es发出http请求
            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            // 获取搜索结果
            SearchHits hits = searchResponse.getHits();
            // 得到匹配度高的文档
            SearchHit[] searchHits = hits.getHits();
            List<Bdcqzs> list = new ArrayList<>();
            for (SearchHit hit : searchHits) {
                String index = hit.getIndex();
                // 文档的主键
                String id = hit.getId();
                float score = hit.getScore();
                String sourceAsString = hit.getSourceAsString();
                Bdcqzs bdcqzs = JSON.parseObject(sourceAsString, Bdcqzs.class);
                list.add(bdcqzs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据id查询
     */
    @PostMapping("/terms/query")
    public String termsQuery() {
        try {
            // 搜索请求对象
            SearchRequest searchRequest = new SearchRequest("antu_test");

            // 搜索源构建对象
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

            // 搜索方式 termsQuery：根据id查询
            String[] split = new String[]{"1", "2", "3"};
            List<String> idList = Arrays.asList(split);
            searchSourceBuilder.query(QueryBuilders.termsQuery("_id", idList));

            // 向搜索请求对象中添加搜索源
            searchRequest.source(searchSourceBuilder);
            // 执行搜索，向es发出http请求
            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            // 获取搜索结果
            SearchHits hits = searchResponse.getHits();
            // 得到匹配度高的文档
            SearchHit[] searchHits = hits.getHits();
            List<Bdcqzs> list = new ArrayList<>();
            for (SearchHit hit : searchHits) {
                String index = hit.getIndex();
                // 文档的主键
                String id = hit.getId();
                float score = hit.getScore();
                String sourceAsString = hit.getSourceAsString();
                Bdcqzs bdcqzs = JSON.parseObject(sourceAsString, Bdcqzs.class);
                list.add(bdcqzs);
            }
            return JSON.toJSONString(list);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    /**
     * 全文检索
     */
    @PostMapping("/match/query")
    public String matchQuery() {
        try {
            // 搜索请求对象
            SearchRequest searchRequest = new SearchRequest("antu_test");

            // 搜索源构建对象
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

            // 搜索方式 全文检索
            searchSourceBuilder.query(QueryBuilders.matchPhraseQuery("allqlr", "李"));

            // 向搜索请求对象中添加搜索源
            searchRequest.source(searchSourceBuilder);
            // 执行搜索，向es发出http请求
            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            // 获取搜索结果
            SearchHits hits = searchResponse.getHits();
            // 得到匹配度高的文档
            SearchHit[] searchHits = hits.getHits();
            List<Bdcqzs> list = new ArrayList<>();
            for (SearchHit hit : searchHits) {
                String index = hit.getIndex();
                // 文档的主键
                String id = hit.getId();
                float score = hit.getScore();
                String sourceAsString = hit.getSourceAsString();
                Bdcqzs bdcqzs = JSON.parseObject(sourceAsString, Bdcqzs.class);
                list.add(bdcqzs);
            }
            return JSON.toJSONString(list);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @PostMapping("/multi/query")
    public String multiQuery() {
        try {
            // 搜索请求对象
            SearchRequest searchRequest = new SearchRequest("antu_test");

            // 搜索源构建对象
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

            // 搜索方式 多字段匹配 ”叶庆秀 余洋“中添加空以分词，qlrmc,allqlr中任意一个有即可匹配， 提升boost：qlrmc字段的权重提高10倍
            searchSourceBuilder.query(QueryBuilders.multiMatchQuery("叶庆秀 余洋", "qlrmc", "allqlr").minimumShouldMatch("50%").field("qlrmc", 10));

            // 向搜索请求对象中添加搜索源
            searchRequest.source(searchSourceBuilder);
            // 执行搜索，向es发出http请求
            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            // 获取搜索结果
            SearchHits hits = searchResponse.getHits();
            // 得到匹配度高的文档
            SearchHit[] searchHits = hits.getHits();
            List<Bdcqzs> list = new ArrayList<>();
            for (SearchHit hit : searchHits) {
                String index = hit.getIndex();
                // 文档的主键
                String id = hit.getId();
                float score = hit.getScore();
                String sourceAsString = hit.getSourceAsString();
                Bdcqzs bdcqzs = JSON.parseObject(sourceAsString, Bdcqzs.class);
                list.add(bdcqzs);
            }
            return JSON.toJSONString(list);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @PostMapping("/boolean/query")
    public String booleanQuery() {
        try {
            // 搜索请求对象
            SearchRequest searchRequest = new SearchRequest("antu_bdcqzs");

            // 搜索源构建对象
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

            // 分页查询，设置起始下标，从0开始
            searchSourceBuilder.from(100);
            // 每页显示个数
            searchSourceBuilder.size(100);

            // 定义匹配查询  matchPhraseQuery可代替精确匹配  matchQuery相似度匹配
            MatchPhraseQueryBuilder zl = QueryBuilders.matchPhraseQuery("zl", "长虹路");
            MatchPhraseQueryBuilder allqlr = QueryBuilders.matchPhraseQuery("allqlr", "陈");
            MatchPhraseQueryBuilder bdcqzh = QueryBuilders.matchPhraseQuery("bdcqzh", "宁雨不动产权");

            // 布尔查询
            BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
            boolQueryBuilder.must(zl);
            boolQueryBuilder.must(allqlr);
            boolQueryBuilder.must(bdcqzh);

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
            List<Bdcqzs> list = new ArrayList<>();
            for (SearchHit hit : searchHits) {
                String index = hit.getIndex();
                // 文档的主键
                String id = hit.getId();
                float score = hit.getScore();
                String sourceAsString = hit.getSourceAsString();
                Bdcqzs bdcqzs = JSON.parseObject(sourceAsString, Bdcqzs.class);
                list.add(bdcqzs);
            }
            return JSON.toJSONString(list);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @PostMapping("/list/bdcqzs")
    public String listBdcqzs() {
        String sql = "select BSM, IID, DJJG, DJSJ, DJN, DJY, DJR, NDSXH, BDCQZH, YSH, BH, QLRMC, QLRZJMC, QLRZJHM, ZL, GYQK, BDCDYH, QLLX, QLXZ, YT, MJ, SYKSRQ, SYZZRQ, SYQX, QLQTQK, SF, ZSAC, ZSBC, ZSCC, CJR, CJSJ, XGR, XGSJ, SFZX, ZXSJ, F_SITE_ID, ALLQLR, INPUT_INDEX, ZDT, FCT, ZDDM, TFH, HXJGNAME, ZYJZMJ, LJZH, ZCS, FTJZMJ, HH, CH, JZMJ, ZDMJ, ZSEWM, ISPRINT, SCZSHIID, QLQTQKBF, SFBF, DZR, DZSJ, ISFZ, DZRSZBM, QRFCFHT, QRZDT, TYBH, FFSJ from (select BSM, IID, DJJG, DJSJ, DJN, DJY, DJR, NDSXH, BDCQZH, YSH, BH, QLRMC, QLRZJMC, QLRZJHM, ZL, GYQK, BDCDYH, QLLX, QLXZ, YT, MJ, SYKSRQ, SYZZRQ, SYQX, QLQTQK, SF, ZSAC, ZSBC, ZSCC, CJR, CJSJ, XGR, XGSJ, SFZX, ZXSJ, F_SITE_ID, ALLQLR, INPUT_INDEX, ZDT, FCT, ZDDM, TFH, HXJGNAME, ZYJZMJ, LJZH, ZCS, FTJZMJ, HH, CH, JZMJ, ZDMJ, ZSEWM, ISPRINT, SCZSHIID, QLQTQKBF, SFBF, DZR, DZSJ, ISFZ, DZRSZBM, QRFCFHT, QRZDT, TYBH, FFSJ, rownum rn from bdcqzs where allqlr like '%陈%' and zl like '%长虹路%' and bdcqzh like '%宁雨不动产权%' and djsj is not null order by rownum asc) where rn > 100 and rn <= 200";
        List<Bdcqzs> list = bdcqzsDao.getSQLManager().execute(new SQLReady(sql), Bdcqzs.class);
        return JSON.toJSONString(list);
    }

    @PostMapping("/insert/bdcqzs")
    public void insertBdcqzs() throws IOException {
        String countSql = "select count(1) from bdcqzs where djsj is not null";
        int count = bdcqzsDao.getSQLManager().execute(new SQLReady(countSql), Integer.class).get(0);
        int start = 0;
        while (start <= count) {
            String sql = "select BSM, IID, DJJG, DJSJ, DJN, DJY, DJR, NDSXH, BDCQZH, YSH, BH, QLRMC, QLRZJMC, QLRZJHM, ZL, GYQK, BDCDYH, QLLX, QLXZ, YT, MJ, SYKSRQ, SYZZRQ, SYQX, QLQTQK, SF, ZSAC, ZSBC, ZSCC, CJR, CJSJ, XGR, XGSJ, SFZX, ZXSJ, F_SITE_ID, ALLQLR, INPUT_INDEX, ZDT, FCT, ZDDM, TFH, HXJGNAME, ZYJZMJ, LJZH, ZCS, FTJZMJ, HH, CH, JZMJ, ZDMJ, ZSEWM, ISPRINT, SCZSHIID, QLQTQKBF, SFBF, DZR, DZSJ, ISFZ, DZRSZBM, QRFCFHT, QRZDT, TYBH, FFSJ from (select BSM, IID, DJJG, DJSJ, DJN, DJY, DJR, NDSXH, BDCQZH, YSH, BH, QLRMC, QLRZJMC, QLRZJHM, ZL, GYQK, BDCDYH, QLLX, QLXZ, YT, MJ, SYKSRQ, SYZZRQ, SYQX, QLQTQK, SF, ZSAC, ZSBC, ZSCC, CJR, CJSJ, XGR, XGSJ, SFZX, ZXSJ, F_SITE_ID, ALLQLR, INPUT_INDEX, ZDT, FCT, ZDDM, TFH, HXJGNAME, ZYJZMJ, LJZH, ZCS, FTJZMJ, HH, CH, JZMJ, ZDMJ, ZSEWM, ISPRINT, SCZSHIID, QLQTQKBF, SFBF, DZR, DZSJ, ISFZ, DZRSZBM, QRFCFHT, QRZDT, TYBH, FFSJ, rownum rn from bdcqzs where djsj is not null order by rownum asc) where rn > " + start + " and rn <= " + (start + 10000);
            List<Bdcqzs> bdcqzsList = bdcqzsDao.getSQLManager().execute(new SQLReady(sql), Bdcqzs.class);
            // 批量处理请求
            BulkRequest bulkRequest = new BulkRequest();
            bulkRequest.timeout("10s");
            for (int i = 0; i < bdcqzsList.size(); i++) {
                bulkRequest.add(
                        new IndexRequest("antu_bdcqzs")
                                .id("" + (start + i))
                                .source(JSON.toJSONString(bdcqzsList.get(i)), XContentType.JSON)
                );
            }
            BulkResponse bulkResponse = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
            System.out.println(start + "：" + bulkResponse.hasFailures());
            start += 10000;
        }
    }

    @Autowired
    private BdcqzsRepository bdcqzsRepository;

    @PostMapping("/search/hits")
    public String getHits() throws IOException {
        // 搜索请求对象
        SearchRequest searchRequest = new SearchRequest("netobdc_bdcqzs");
        // 搜索源构建对象
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder().trackTotalHits(true);
        MatchAllQueryBuilder matchAllQueryBuilder = QueryBuilders.matchAllQuery();
        // 搜索方式 布尔查询
        searchSourceBuilder.query(matchAllQueryBuilder);
        // 向搜索请求对象中添加搜索源
        searchRequest.source(searchSourceBuilder);
        // 执行搜索，向es发出http请求
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        // 获取搜索结果
        SearchHits hits = searchResponse.getHits();
        long value = hits.getTotalHits().value;
        return String.valueOf(value);
    }

    @Autowired
    private XsFdcq2Dao xsFdcq2Dao;

    @Autowired
    private ElasticUtil elasticUtil;

    @Autowired
    private XsFdcq2Repository xsFdcq2Repository;

    @PostMapping("/save/all")
    public String saveAll() throws IOException {
        /*String countSql = "select count(1) from bdcinfo.xs_fdcq2 where djsj is not null";
        int count = xsFdcq2Dao.getSQLManager().execute(new SQLReady(countSql), Integer.class).get(0);*/
        int start = 0;
        while (start <= 3000) {
            Long totalHits = elasticUtil.getTotalHits("bdcinfo_xs_fdcq2");
            String sql = "select * from (select rownum as num, t.* from bdcinfo.xs_fdcq2 t where djsj is not null and rownum <= " + (start + 1000) + ") temp where temp.num > " + start;
            List<XsFdcq2> list = xsFdcq2Dao.getSQLManager().execute(new SQLReady(sql), XsFdcq2.class);
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setId(totalHits + i);
            }
            xsFdcq2Repository.saveAll(list);
            System.out.println((start + 1000));
            start += 1000;
        }
        return "ok";
    }
}
