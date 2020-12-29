package com.antu.elastic.repository;

import com.antu.elastic.pojo.Bdcqzs;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author: zhangBin 1394078687@qq.com
 * @description: TODO
 * @date: 2020/12/28 17:41
 */
public interface BdcqzsRepository extends ElasticsearchRepository<Bdcqzs, Integer> {
//    List<Bdcqzs> findByAllqlr
}
