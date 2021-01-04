package com.antu.elastic.mapper;

import com.antu.elastic.pojo.XsFdcq2;
import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface XsFdcq2Dao extends BaseMapper<XsFdcq2> {
    /**
     * 简单查询
     */
    List<XsFdcq2> sample(XsFdcq2 obj);

    /**
     * 简单查询 (分页)
     *
     * @param pageNo   pageNo
     * @param pageSize pageSize
     * @param obj      obj
     * @return PageQuery
     */
    PageQuery<XsFdcq2> sample(int pageNo, int pageSize, XsFdcq2 obj);
}
