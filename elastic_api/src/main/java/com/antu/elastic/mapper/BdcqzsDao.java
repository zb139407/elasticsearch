package com.antu.elastic.mapper;

import com.antu.elastic.pojo.Bdcqzs;
import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: zhangBin 1394078687@qq.com
 * @description: TODO
 * @date: 2020/12/23 16:08
 */
@Repository
public interface BdcqzsDao extends BaseMapper<Bdcqzs> {
    /**
     * 简单查询
     */
    List<Bdcqzs> sample(Bdcqzs obj);

    /**
     * 简单查询 (分页)
     *
     * @param pageNo   pageNo
     * @param pageSize pageSize
     * @param obj      obj
     * @return PageQuery
     */
    PageQuery<Bdcqzs> sample(int pageNo, int pageSize, Bdcqzs obj);
}
