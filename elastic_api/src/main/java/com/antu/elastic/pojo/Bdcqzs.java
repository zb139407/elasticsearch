package com.antu.elastic.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * @author: zhangBin 1394078687@qq.com
 * @description: TODO
 * @date: 2020/12/23 15:58
 */
@Data
@Document(indexName = "netobdc_bdcqzs", type = "_doc", replicas = 0)
public class Bdcqzs {
    /**
     * ID
     */
    private Integer id;

    /**
     * 标识码
     */
    @Field(type = FieldType.Keyword)
    private String bsm;

    /**
     * IID
     */
    @Field(type = FieldType.Keyword)
    private String iid;

    /**
     * 登记机构简称
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    private String djjg;

    /**
     * 登记时间
     */
    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss||epoch_millis")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date djsj;

    /**
     * 登记年
     */
    @Field(type = FieldType.Keyword)
    private String djn;

    /**
     * 登记月
     */
    @Field(type = FieldType.Keyword)
    private String djy;

    /**
     * 登记日
     */
    @Field(type = FieldType.Keyword)
    private String djr;

    /**
     * 年度顺序号（D）
     */
    @Field(type = FieldType.Keyword)
    private String ndsxh;

    /**
     * 不动产权证号
     */
    @Field(type = FieldType.Text)
    private String bdcqzh;

    /**
     * 印刷号
     */
    @Field(type = FieldType.Keyword)
    private String ysh;

    /**
     * 编号
     */
    @Field(type = FieldType.Keyword)
    private String bh;

    /**
     * 权利人名称
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    private String qlrmc;

    /**
     * 权利人证件名称
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    private String qlrzjmc;

    /**
     * 权利人证件号码
     */
    @Field(type = FieldType.Keyword)
    private String qlrzjhm;

    /**
     * 坐落
     */
    @Field(type = FieldType.Text)
    private String zl;

    /**
     * 共有情况
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    private String gyqk;

    /**
     * 不动产单元号
     */
    @Field(type = FieldType.Keyword)
    private String bdcdyh;

    /**
     * 权利类型
     */
    @Field(type = FieldType.Text)
    private String qllx;

    /**
     * 权利性质
     */
    @Field(type = FieldType.Text)
    private String qlxz;

    /**
     * 用途
     */
    @Field(type = FieldType.Text)
    private String yt;

    /**
     * 面积
     */
    @Field(type = FieldType.Keyword)
    private String mj;

    /**
     * 使用开始日期
     */
    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss||epoch_millis")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date syksrq;

    /**
     * 使用终止日期
     */
    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss||epoch_millis")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date syzzrq;

    /**
     * 使用期限
     */
    @Field(type = FieldType.Keyword)
    private String syqx;

    /**
     * 权利其他情况
     */
    @Field(type = FieldType.Keyword)
    private String qlqtqk;

    /**
     * 附记
     */
    @Field(type = FieldType.Keyword)
    private String sf;

    /**
     * 证书A字段，填写省简称
     */
    @Field(type = FieldType.Keyword)
    private String zsac;

    /**
     * 证书B字段，填写登记年度
     */
    @Field(type = FieldType.Keyword)
    private String zsbc;

    /**
     * 证书C字段，填写区县名
     */
    @Field(type = FieldType.Keyword)
    private String zscc;

    /**
     * 创建人
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    private String cjr;

    /**
     * 创建日期
     */
    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss||epoch_millis")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date cjsj;

    /**
     * 修改人
     */
    @Field(type = FieldType.Keyword)
    private String xgr;

    /**
     * 修改时间
     */
    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss||epoch_millis")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date xgsj;

    /**
     * 是否注销
     */
    @Field(type = FieldType.Integer)
    private Integer sfzx;

    /**
     * 注销时间
     */
    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss||epoch_millis")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date zxsj;

    /**
     * 区县编号
     */
    @Field(type = FieldType.Integer)
    private Integer fSiteId;

    /**
     * 权利人叠加
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private String allqlr;

    /**
     *
     */
    @Field(type = FieldType.Integer)
    private Integer inputIndex;

    /**
     * 宗地图
     */
    @Field(type = FieldType.Keyword)
    private byte[] zdt;

    /**
     * 房产图
     */
    @Field(type = FieldType.Keyword)
    private byte[] fct;

    /**
     * 宗地代码
     */
    @Field(type = FieldType.Keyword)
    private String zddm;

    /**
     * 图幅号
     */
    @Field(type = FieldType.Keyword)
    private String tfh;

    /**
     * 户型结构
     */
    @Field(type = FieldType.Keyword)
    private String hxjgname;

    /**
     * 专用建筑面积
     */
    @Field(type = FieldType.Keyword)
    private String zyjzmj;

    /**
     * 逻辑幢号
     */
    @Field(type = FieldType.Keyword)
    private String ljzh;

    /**
     * 总层数
     */
    @Field(type = FieldType.Integer)
    private Integer zcs;

    /**
     * 分摊建筑面积
     */
    @Field(type = FieldType.Keyword)
    private String ftjzmj;

    /**
     * 户号
     */
    @Field(type = FieldType.Integer)
    private Integer hh;

    /**
     * 层号
     */
    @Field(type = FieldType.Keyword)
    private String ch;

    /**
     * 建筑面积
     */
    @Field(type = FieldType.Keyword)
    private String jzmj;

    /**
     * 宗地面积
     */
    @Field(type = FieldType.Keyword)
    private String zdmj;

    /**
     * 证书二维码
     */
    @Field(type = FieldType.Keyword)
    private String zsewm;

    /**
     * 是否已经打印
     */
    @Field(type = FieldType.Integer)
    private Integer isprint;

    /**
     * 用于保证生成证书号的IID，主要用于顺便生成宗地证书相应的虚拟IID
     */
    @Field(type = FieldType.Keyword)
    private String sczshiid;

    /**
     * 权利其他情况备份
     */
    @Field(type = FieldType.Keyword)
    private String qlqtqkbf;

    /**
     * 附记备份
     */
    @Field(type = FieldType.Keyword)
    private String sfbf;

    /**
     * 打证人
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    private String dzr;

    /**
     * 打证时间
     */
    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss||epoch_millis")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date dzsj;

    /**
     * 是否废证
     */
    @Field(type = FieldType.Integer)
    private Integer isfz;

    /**
     * 打证人所在部门
     */
    @Field(type = FieldType.Keyword)
    private String dzrszbm;

    /**
     * 分层分户图二维码内容
     */
    @Field(type = FieldType.Keyword)
    private String qrfcfht;

    /**
     * 宗地图二维码内容
     */
    @Field(type = FieldType.Keyword)
    private String qrzdt;

    /**
     * 电子证照统一编号
     */
    @Field(type = FieldType.Keyword)
    private String tybh;

    /**
     * 发放时间
     */
    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss||epoch_millis")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date ffsj;
}
