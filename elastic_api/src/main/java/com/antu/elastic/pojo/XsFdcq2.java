package com.antu.elastic.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: zhangBin 1394078687@qq.com
 * @description: TODO
 * @date: 2020/12/29 15:34
 */
@Data
@Document(indexName = "bdcinfo_xs_fdcq2", type = "_doc", replicas = 0)
public class XsFdcq2 {
    /**
     * id
     */
    @Id
    private Long id;

    /**
     * 标识码
     */
    @Field(type = FieldType.Keyword)
    private String bsm;

    /**
     * 业务号
     */
    @Field(type = FieldType.Keyword)
    private String ywh;

    /**
     * 不动产单元号
     */
    @Field(type = FieldType.Keyword)
    private String bdcdyh;

    /**
     * 不动产权证号
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    private String bdcqzh;

    /**
     * 房地坐落
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    private String fdzl;

    /**
     * 登簿人
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    private String dbr;

    /**
     * 登记机构
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    private String djjg;

    /**
     * 登记类型
     */
    @Field(type = FieldType.Keyword)
    private String djlx;

    /**
     * 登记时间
     */
    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss||epoch_millis")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date djsj;

    /**
     * 登记小类
     */
    @Field(type = FieldType.Keyword)
    private String djxl;

    /**
     * 登记原因
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    private String djyy;

    /**
     * 独用土地面积
     */
    @Field(type = FieldType.Double)
    private Double dytdmj;

    /**
     * 自然幢号
     */
    @Field(type = FieldType.Keyword)
    private String zrzh;

    /**
     * 总层数
     */
    @Field(type = FieldType.Integer)
    private Integer zcs;

    /**
     * 房地产交易价格
     */
    @Field(type = FieldType.Double)
    private Double fdcjyjg;

    /**
     * 建筑面积
     */
    @Field(type = FieldType.Double)
    private Double jzmj;

    /**
     * 套内建筑面积
     */
    @Field(type = FieldType.Double)
    private Double zyjzmj;

    /**
     * 分摊建筑面积
     */
    @Field(type = FieldType.Double)
    private Double ftjzmj;

    /**
     * 分摊土地面积
     */
    @Field(type = FieldType.Double)
    private Double fttdmj;

    /**
     * 房屋结构
     */
    @Field(type = FieldType.Keyword)
    private String fwjg;

    /**
     * 房屋性质
     */
    @Field(type = FieldType.Keyword)
    private String fwxz;

    /**
     * 规划用途
     */
    @Field(type = FieldType.Keyword)
    private String ghyt;

    /**
     * 权利类型
     */
    @Field(type = FieldType.Keyword)
    private String qllx;

    /**
     * 权利性质
     */
    @Field(type = FieldType.Keyword)
    private String qlxz;

    /**
     * 土地使用权结束时间
     */
    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss||epoch_millis")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date tdsyjssj;

    /**
     * 土地使用权人
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    private String tdsyqr;

    /**
     * 土地使用权起始时间
     */
    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss||epoch_millis")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date tdsyqssj;

    /**
     * 用途
     */
    @Field(type = FieldType.Keyword)
    private String yt;

    /**
     * 土地证号
     */
    @Field(type = FieldType.Keyword)
    private String ytdzh;

    /**
     * 登记类型名称
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    private String djlxname;

    /**
     * 权利类型名称
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    private String qllxname;

    /**
     * 规划用途名称
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    private String ghytname;

    /**
     * 房屋结构名称
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    private String fwjgname;

    /**
     * 权利性质名称
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    private String qlxzname;

    /**
     * 土地用途名称
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    private String ytname;

    /**
     * 竣工时间
     */
    @Field(type = FieldType.Keyword)
    private String jgsj;

    /**
     * 产别
     */
    @Field(type = FieldType.Keyword)
    private String realtype;

    /**
     * 首次取得时间
     */
    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss||epoch_millis")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date scqdsj;

    /**
     * 来案号
     */
    @Field(type = FieldType.Keyword)
    private String lah;

    /**
     * 权属状态
     */
    @Field(type = FieldType.Keyword)
    private String qszt;

    /**
     * 全书状态名称
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    private String qsztname;

    /**
     * 一对多的bdcdyh
     */
    @Field(type = FieldType.Keyword)
    private String bdcdyhH;

    /**
     * 权利人名称
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    private String qlrmc;

    /**
     * 证件类别
     */
    @Field(type = FieldType.Keyword)
    private String zjlb;

    /**
     * 证件类别名称
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    private String zjlbname;

    /**
     * 证件号码
     */
    @Field(type = FieldType.Keyword)
    private String zjhm;

    /**
     * 原权利人名称
     */
    @Field(type = FieldType.Keyword)
    private String yqlrmc;

    /**
     * 原权利人证件类别
     */
    @Field(type = FieldType.Keyword)
    private String yqlrzjlb;

    /**
     * 原权利人证件类别名称
     */
    @Field(type = FieldType.Keyword)
    private String yqlrzjlbname;

    /**
     * 原权利人证件号码
     */
    @Field(type = FieldType.Keyword)
    private String yqlrzjhm;

    /**
     * 宗地代码
     */
    @Field(type = FieldType.Keyword)
    private String zddm;

    /**
     * h标识码
     */
    @Field(type = FieldType.Keyword)
    private String hbsm;

    /**
     * 附记
     */
    @Field(type = FieldType.Keyword)
    private String fj;

    /**
     * 原房产户编号
     */
    @Field(type = FieldType.Keyword)
    private String houseid;

    /**
     * 原房产丘权号
     */
    @Field(type = FieldType.Keyword)
    private String hillrealno;

    /**
     * 核实人
     */
    @Field(type = FieldType.Keyword)
    private String hsr;

    /**
     * 核实时间
     */
    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss||epoch_millis")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date hssj;

    /**
     * 来源不动产权证号
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    private String lybdcqzh;

    /**
     * 区县代码
     */
    @Field(type = FieldType.Keyword)
    private String qxdm;

    /**
     * 数据来源
     */
    @Field(type = FieldType.Integer)
    private Integer sjly;

    /**
     * 原房产选房序号
     */
    @Field(type = FieldType.Keyword)
    private String xfxh;

    /**
     * 原房产证号
     */
    @Field(type = FieldType.Keyword)
    private String yfczh;

    /**
     * 原地籍库户的bsm
     */
    @Field(type = FieldType.Keyword)
    private String ygthbsm;

    /**
     * 房产竣工时间
     */
    @Field(type = FieldType.Integer)
    private Integer yjgsj;

    /**
     * 要素代码
     */
    @Field(type = FieldType.Keyword)
    private String ysdm;

    /**
     * 原地籍库的syqxx的bsm
     */
    @Field(type = FieldType.Keyword)
    private String ysyqbsm;

    /**
     * 房产业务编号
     */
    @Field(type = FieldType.Keyword)
    private String fcywbh;

    /**
     * 房产登记类型编码
     */
    @Field(type = FieldType.Keyword)
    private String fcdjlxbm;

    /**
     * 房产登记类型名称
     */
    @Field(type = FieldType.Keyword)
    private String fcdjlxms;

    /**
     * 房产登记小磊编码
     */
    @Field(type = FieldType.Keyword)
    private String fcdjxlbm;

    /**
     * 房产登记小类名称
     */
    @Field(type = FieldType.Keyword)
    private String fcdjxlms;

    /**
     * 不动产登记类型
     */
    @Field(type = FieldType.Keyword)
    private String blddjlx;

    /**
     * 房产建筑年代
     */
    @Field(type = FieldType.Keyword)
    private String builddate;

    /**
     * 房产用途
     */
    @Field(type = FieldType.Keyword)
    private String fcuse;

    /**
     * 房产房屋结构
     */
    @Field(type = FieldType.Keyword)
    private String fcstructure;

    /**
     * 是否删除
     */
    @Field(type = FieldType.Integer)
    private Integer sfsc;

    /**
     * 所在层？
     */
    @Field(type = FieldType.Keyword)
    private String szcN;

    /**
     *
     */
    @Field(type = FieldType.Integer)
    private Integer fSiteId;

    /**
     * 房屋性质
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    private String fwxzname;

    /**
     * 原权利人
     */
    @Field(type = FieldType.Keyword)
    private String yqlr;

    /**
     * 首次登记时间
     */
    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss||epoch_millis")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date scdjsj;

    /**
     * 创建时间
     */
    @Field(type = FieldType.Keyword)
    private String createtime;

    /**
     * 南京特有的规划用途
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    private String njghyt;

    /**
     *
     */
    @Field(type = FieldType.Keyword)
    private String hcycqdj;

    /**
     *
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    private String hcbz;

    /**
     *
     */
    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss||epoch_millis")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date hcsj;

    /**
     *
     */
    @Field(type = FieldType.Keyword)
    private String hcry;

    /***
     *
     */
    @Field(type = FieldType.Keyword)
    private String qxzt;

    /**
     *
     */
    @Field(type = FieldType.Keyword)
    private String iscancel;

    /**
     *
     */
    @Field(type = FieldType.Keyword)
    private String docid;

    /**
     *
     */
    @Field(type = FieldType.Keyword)
    private String fromsource;

    /**
     *
     */
    @Field(type = FieldType.Keyword)
    private String jgsjtemp;

    /**
     * 面积单位
     */
    @Field(type = FieldType.Keyword)
    private String mjdw;

    /**
     * 面积单位名称
     */
    @Field(type = FieldType.Keyword)
    private String mjdwname;

    /**
     * 所在层
     */
    @Field(type = FieldType.Integer)
    private Integer szc;

    /**
     * 交易备注
     */
    @Field(type = FieldType.Keyword)
    private String njJybz;

    /**
     * 所在层，对应户的CH
     */
    @Field(type = FieldType.Keyword)
    private String njSzc;

    /**
     * 丘权号
     */
    @Field(type = FieldType.Keyword)
    private String qqh;

    /**
     * 20170706新增产权来源
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    private String cqly;

    /**
     * 清理状态
     * 0  未迁出
     * 1  清理中
     * 2  完成清理
     * 3  清理过程中发现档案扫描件未找到无法清理直接归档
     * 9  无业务无档案
     * 10 无业务有档案
     * 11 无业务无丘权号
     * 12 清理过程发现户室问题
     * 13 该房屋在单系统之后办理的首次登记
     * 14 该房屋在单系统之后办理的预告登记
     * 15 该房屋在过渡期系统之后办理的首次登记,需核实关系正确性
     * 16 该房屋在过渡期系统之后办理的预告登记,需核实关系正确性
     * 17 该房屋为新建楼盘,暂未登记
     * 18 房产登记簿PUHOUSE标识无效
     */
    @Field(type = FieldType.Integer)
    private Integer qlzt;

    /**
     * 分类标注
     * 1    已核实拆除楼幢
     * 2    已核实拆除户室
     * 3    待落宗楼幢（含登记信息）
     * 4    待落宗无楼幢户室（含登记信息）
     * 5    待落宗房屋（无登记信息）
     * 6    缺房屋表户室（含登记信息）
     */
    @Field(type = FieldType.Integer)
    private Integer flbz;

    /**
     * 总建筑面积
     */
    @Field(type = FieldType.Double)
    private Double zjzmj;

    /**
     * 分建筑面积
     */
    @Field(type = FieldType.Double)
    private Double fjzmj;

    /**
     * 修改内容
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    private String xgnrQl;

    /**
     * 20180205新增土地坐落字段
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    private String tdzl;

    /**
     * 分析标注
     */
    @Field(type = FieldType.Keyword)
    private String fxbz;

    /**
     * 权属维护时，需要选择审核人
     */
    @Field(type = FieldType.Keyword)
    private String shr;
}
