package com.antu.elastic;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
class ElasticJdApplicationTests {
    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Test
    void page() throws IOException {
        // 搜索请求对象
        SearchRequest searchRequest = new SearchRequest("netobdc_bdcqzs");

        // 搜索源构建对象
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder()
                .trackTotalHits(true)
                .from(20000)
                .size(50);
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
        SearchHit[] searchHits = hits.getHits();
        List<Map<String, Object>> list = new ArrayList<>();
        for (SearchHit hit : searchHits) {
            Map<String, Object> map = hit.getSourceAsMap();
            list.add(map);
        }
        System.out.println(list);
    }


}
