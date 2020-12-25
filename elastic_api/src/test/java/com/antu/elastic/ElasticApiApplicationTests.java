package com.antu.elastic;

import com.alibaba.fastjson.JSON;
import com.antu.elastic.mapper.BdcqzsDao;
import com.antu.elastic.pojo.Bdcqzs;
import com.antu.elastic.pojo.User;
import org.beetl.sql.core.SQLReady;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * ES 7.6.X 高级客户端API测试
 */
@SpringBootTest
class ElasticApiApplicationTests {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Autowired
    private BdcqzsDao bdcqzsDao;

    @Autowired
    private DataSource dataSource;

    @Test
    public void test() throws SQLException {
        System.out.println(dataSource.getClass());
        System.out.println(dataSource.getConnection());
    }

    // 测试索引的创建 Request
    @Test
    void testCreateIndex() throws IOException {
        // 1、创建索引请求
        // CreateIndexRequest createIndexRequest = new CreateIndexRequest("antu_index");
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("jd_goods");
        // 2、客户端执行请求IndicesClient，请求后获得响应
        CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);
        System.out.println(createIndexResponse);
    }

    // 测试获取索引
    @Test
    void testExistIndex() throws IOException {
        GetIndexRequest getIndexRequest = new GetIndexRequest("jd_goods");
        boolean exists = restHighLevelClient.indices().exists(getIndexRequest, RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    // 测试删除索引
    @Test
    void testDeleteIndex() throws IOException {
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("jd_goods");
        AcknowledgedResponse delete = restHighLevelClient.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
        System.out.println(delete.isAcknowledged());
    }

    // 测试添加文档
    @Test
    void testAddDocument() throws IOException {
        // 创建对象
        User user = new User("tom", 12);
        // 创建请求
        IndexRequest indexRequest = new IndexRequest("antu_index");
        // 规则 PUT /antu_index/_doc/1
        indexRequest.id("1");
        indexRequest.timeout(TimeValue.timeValueSeconds(1));
//        indexRequest.timeout("1s");
        // 将数据放入请求 JSON
        indexRequest.source(JSON.toJSONString(user), XContentType.JSON);
        // 客户端发送请求,获取响应结果
        IndexResponse indexResponse = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println(indexResponse.toString());
        System.out.println(indexResponse.status()); // 对应命令返回的状态 CREATED
    }

    // 测试获取文档
    @Test
    void testExistDocument() throws IOException {
        GetRequest getRequest = new GetRequest("antu_index", "1");
        // 不获取返回的_source上下文
        getRequest.fetchSourceContext(new FetchSourceContext(false));
        getRequest.storedFields("_none_");
        boolean exists = restHighLevelClient.exists(getRequest, RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    // 测试获取返回的文档信息
    @Test
    void testGetDocument() throws IOException {
        GetRequest getRequest = new GetRequest("antu_index", "1");
        GetResponse getResponse = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
        System.out.println(getResponse.getSourceAsString()); // 打印文档内容
        System.out.println(getResponse); // 返回的全部内容和命令一样
    }

    // 测试更新文档信息
    @Test
    void testUpdateDocument() throws IOException {
        UpdateRequest updateRequest = new UpdateRequest("antu_index", "1");
        updateRequest.timeout("1s");
        User user = new User("lucy", 20);
        updateRequest.doc(JSON.toJSONString(user), XContentType.JSON);
        UpdateResponse updateResponse = restHighLevelClient.update(updateRequest, RequestOptions.DEFAULT);
        System.out.println(updateResponse.status());
    }

    // 删除文档记录
    @Test
    void testDeleteDocument() throws IOException {
        DeleteRequest deleteRequest = new DeleteRequest("antu_index", "1");
        deleteRequest.timeout("1s");
        DeleteResponse deleteResponse = restHighLevelClient.delete(deleteRequest, RequestOptions.DEFAULT);
        System.out.println(deleteResponse.status());
    }

    // 特殊的，真是项目一般会大批量插入数据！
    @Test
    void testBulkRequest() throws IOException {
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout("10s");
        List<User> userList = new ArrayList<>();
        userList.add(new User("tom5", 3));
        userList.add(new User("tom6", 3));
        userList.add(new User("tom7", 3));
        userList.add(new User("tom8", 3));
        // 批量处理请求
        for (int i = 0; i < userList.size(); i++) {
            bulkRequest.add(
                    new IndexRequest("antu_index")
                            .source(JSON.toJSONString(userList.get(i)), XContentType.JSON)
            );
        }
        BulkResponse bulkResponse = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(bulkResponse.hasFailures());
    }

    @Test
    void testInsertBdcqzs() throws IOException {
        String countSql = "select count(1) from bdcqzs where djsj is not null";
        int count = bdcqzsDao.getSQLManager().execute(new SQLReady(countSql), Integer.class).get(0);
        int start = 0;
        while (start <= count) {
            String sql = "select * from (select rownum as num, t.* from netobdc.bdcqzs t where djsj is not null and rownum <= " + (start + 10000) + ") temp where temp.num > " + start;
            List<Map> list = bdcqzsDao.getSQLManager().execute(new SQLReady(sql), Map.class);
            // 批量处理请求
            BulkRequest bulkRequest = new BulkRequest();
            bulkRequest.timeout("100s");
            for (Map map : list) {
                map.remove("num");
                bulkRequest.add(
                        new IndexRequest("netobdc_bdcqzs")
                                .source(JSON.toJSONString(map), XContentType.JSON)
                );
            }
            BulkResponse bulkResponse = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
            System.out.println((start + 10000) + "：" + bulkResponse.hasFailures());
            start += 10000;
        }
    }

    @Test
    void testInsertXsFdcq2() throws IOException {
        String countSql = "select count(1) from bdcinfo.xs_fdcq2 where djsj is not null";
        int count = bdcqzsDao.getSQLManager().execute(new SQLReady(countSql), Integer.class).get(0);
        System.out.println(count);
        int start = 0;
        while (start <= count) {
            String sql = "select * from (select rownum as num, t.* from bdcinfo.xs_fdcq2 t where djsj is not null and rownum <= " + (start + 10000) + ") temp where temp.num > " + start;
            List<Map> list = bdcqzsDao.getSQLManager().execute(new SQLReady(sql), Map.class);
            BulkRequest bulkRequest = new BulkRequest();
            bulkRequest.timeout("100s");
            for (Map map : list) {
                map.remove("num");
                bulkRequest.add(
                        new IndexRequest("bdcinfo_xs_fdcq2")
                                .source(JSON.toJSONString(map), XContentType.JSON)
                );
            }
            BulkResponse bulkResponse = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
            System.out.println((start + 10000) + "：" + bulkResponse.hasFailures());
            start += 10000;
        }
    }

    @Test
    void testSize() {
        String sql = "select *count(1) from bdcqzs where djsj is not null";
        int count = bdcqzsDao.getSQLManager().execute(new SQLReady(sql), Integer.class).get(0);
        System.out.println(count);
    }


    // 批量更新

    // 批量删除

    // 查询
    // SearchRequest 搜索请求
    // SearchSourceBuilder 条件构造
    // HighlightBuilder 构建高亮
    // TermQueryBuilder 精确查询
    // MatchAllQueryBuilder 匹配全部
    @Test
    void testSearch() throws IOException {
        SearchRequest searchRequest = new SearchRequest("antu_test");
        // 构建搜索条件
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        // 查询条件 可以使用QueryBuilders工具类实现
        // QueryBuilders.termQuery 精确匹配
        // QueryBuilders.matchAllQuery 匹配所有
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("bdcdyh", "320");
//        MatchAllQueryBuilder matchAllQueryBuilder = QueryBuilders.matchAllQuery();
//        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("iid", "201706050000046");
        searchSourceBuilder.query(termQueryBuilder);
        searchSourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println(JSON.toJSONString(searchResponse.getHits()));
        System.out.println("====================================");
        for (SearchHit documentFields : searchResponse.getHits().getHits()) {
            System.out.println(documentFields.getSourceAsMap());
        }
    }

    /**
     * 搜索全部记录
     *
     * @throws: IOException
     */
    @Test
    void testSearchAll() throws IOException {

    }
}
