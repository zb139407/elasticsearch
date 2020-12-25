package com.antu.elastic.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author: zhangBin 1394078687@qq.com
 * @description: TODO
 * @date: 2020/12/23 15:58
 */
@Data
public class Bdcqzs {
    /**
     * 标识码
     */
    private String bsm;

    /**
     * IID
     */
    private String iid;

    /**
     * 登记机构简称
     */
    private String djjg;

    /**
     * 登记时间
     */
    private Date djsj;

    /**
     * 登记年
     */
    private String djn;

    /**
     * 登记月
     */
    private String djy;

    /**
     * 登记日
     */
    private String djr;

    /**
     * 年度顺序号（D）
     */
    private String ndsxh;

    /**
     * 不动产权证号
     */
    private String bdcqzh;

    /**
     * 印刷号
     */
    private String ysh;

    /**
     * 编号
     */
    private String bh;

    /**
     * 权利人名称
     */
    private String qlrmc;

    /**
     * 权利人证件名称
     */
    private String qlrzjmc;

    /**
     * 权利人证件号码
     */
    private String qlrzjhm;

    /**
     * 坐落
     */
    private String zl;

    /**
     * 共有情况
     */
    private String gyqk;

    /**
     * 不动产单元号
     */
    private String bdcdyh;

    /**
     * 权利类型
     */
    private String qllx;

    /**
     * 权利性质
     */
    private String qlxz;

    /**
     * 用途
     */
    private String yt;

    /**
     * 面积
     */
    private String mj;

    /**
     * 使用开始日期
     */
    private Date syksrq;

    /**
     * 使用终止日期
     */
    private Date syzzrq;

    /**
     * 使用期限
     */
    private String syqx;

    /**
     * 权利其他情况
     */
    private String qlqtqk;

    /**
     * 附记
     */
    private String sf;

    /**
     * 证书A字段，填写省简称
     */
    private String zsac;

    /**
     * 证书B字段，填写登记年度
     */
    private String zsbc;

    /**
     * 证书C字段，填写区县名
     */
    private String zscc;

    /**
     * 创建人
     */
    private String cjr;

    /**
     * 创建日期
     */
    private Date cjsj;

    /**
     * 修改人
     */
    private String xgr;

    /**
     * 修改时间
     */
    private Date xgsj;

    /**
     * 是否注销
     */
    private Integer sfzx;

    /**
     * 注销时间
     */
    private Date zxsj;

    /**
     * 区县编号
     */
    private Integer fSiteId;

    /**
     * 权利人叠加
     */
    private String allqlr;

    /**
     *
     */
    private Integer inputIndex;

    /**
     * 宗地图
     */
    private byte[] zdt;

    /**
     * 房产图
     */
    private byte[] fct;

    /**
     * 宗地代码
     */
    private String zddm;

    /**
     * 图幅号
     */
    private String tfh;

    /**
     * 户型结构
     */
    private String hxjgname;

    /**
     * 专用建筑面积
     */
    private String zyjzmj;

    /**
     * 逻辑幢号
     */
    private String ljzh;

    /**
     * 总层数
     */
    private Integer zcs;

    /**
     * 分摊建筑面积
     */
    private String ftjzmj;

    /**
     * 户号
     */
    private Integer hh;

    /**
     * 层号
     */
    private String ch;

    /**
     * 建筑面积
     */
    private String jzmj;

    /**
     * 宗地面积
     */
    private String zdmj;

    /**
     * 证书二维码
     */
    private String zsewm;

    /**
     * 是否已经打印
     */
    private Integer isprint;

    /**
     * 用于保证生成证书号的IID，主要用于顺便生成宗地证书相应的虚拟IID
     */
    private String sczshiid;

    /**
     * 权利其他情况备份
     */
    private String qlqtqkbf;

    /**
     * 附记备份
     */
    private String sfbf;

    /**
     * 打证人
     */
    private String dzr;

    /**
     * 打证时间
     */
    private Date dzsj;

    /**
     * 是否废证
     */
    private Integer isfz;

    /**
     * 打证人所在部门
     */
    private String dzrszbm;

    /**
     * 分层分户图二维码内容
     */
    private String qrfcfht;

    /**
     * 宗地图二维码内容
     */
    private String qrzdt;

    /**
     * 电子证照统一编号
     */
    private String tybh;

    /**
     * 发放时间
     */
    private Date ffsj;
}
