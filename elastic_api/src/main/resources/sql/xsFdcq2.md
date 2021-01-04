sample
===
*简单查询

	select
	    @pageTag(){
	        #use("cols")#
	    @}
	from XS_FDCQ2  where  #use("condition")#

cols
===
	BSM,YWH,BDCDYH,BDCQZH,FDZL,DBR,DJJG,DJLX,DJSJ,DJXL,DJYY,DYTDMJ,ZRZH,ZCS,FDCJYJG,JZMJ,ZYJZMJ,FTJZMJ,FTTDMJ,FWJG,FWXZ,GHYT,QLLX,QLXZ,TDSYJSSJ,TDSYQR,TDSYQSSJ,YT,YTDZH,DJLXNAME,QLLXNAME,GHYTNAME,FWJGNAME,QLXZNAME,YTNAME,JGSJ,REALTYPE,SCQDSJ,LAH,QSZT,QSZTNAME,BDCDYH_H,QLRMC,ZJLB,ZJLBNAME,ZJHM,YQLRMC,YQLRZJLB,YQLRZJLBNAME,YQLRZJHM,ZDDM,HBSM,FJ,HOUSEID,HILLREALNO,HSR,HSSJ,LYBDCQZH,QXDM,SJLY,XFXH,YFCZH,YGTHBSM,YJGSJ,YSDM,YSYQBSM,FCYWBH,FCDJLXBM,FCDJLXMS,FCDJXLBM,FCDJXLMS,BLDDJLX,BUILDDATE,FCUSE,FCSTRUCTURE,SFSC,SZC_N,F_SITE_ID,FWXZNAME,YQLR,SCDJSJ,CREATETIME,NJGHYT,HCYCQDJ,HCBZ,HCSJ,HCRY,QXZT,ISCANCEL,DOCID,FROMSOURCE,JGSJTEMP,MJDW,MJDWNAME,SZC,NJ_JYBZ,NJ_SZC,QQH,CQLY,QLZT,FLBZ,ZJZMJ,FJZMJ,XGNR_QL,TDZL,FXBZ,SHR
condition
===

	1 = 1
	@if(!isEmpty(bsm)){
	 and BSM=#bsm#
	@}
	@if(!isEmpty(ywh)){
	 and YWH=#ywh#
	@}
	@if(!isEmpty(bdcdyh)){
	 and BDCDYH=#bdcdyh#
	@}
	@if(!isEmpty(bdcqzh)){
	 and BDCQZH=#bdcqzh#
	@}
	@if(!isEmpty(fdzl)){
	 and FDZL=#fdzl#
	@}
	@if(!isEmpty(dbr)){
	 and DBR=#dbr#
	@}
	@if(!isEmpty(djjg)){
	 and DJJG=#djjg#
	@}
	@if(!isEmpty(djlx)){
	 and DJLX=#djlx#
	@}
	@if(!isEmpty(djsj)){
	 and DJSJ=#djsj#
	@}
	@if(!isEmpty(djxl)){
	 and DJXL=#djxl#
	@}
	@if(!isEmpty(djyy)){
	 and DJYY=#djyy#
	@}
	@if(!isEmpty(dytdmj)){
	 and DYTDMJ=#dytdmj#
	@}
	@if(!isEmpty(zrzh)){
	 and ZRZH=#zrzh#
	@}
	@if(!isEmpty(zcs)){
	 and ZCS=#zcs#
	@}
	@if(!isEmpty(fdcjyjg)){
	 and FDCJYJG=#fdcjyjg#
	@}
	@if(!isEmpty(jzmj)){
	 and JZMJ=#jzmj#
	@}
	@if(!isEmpty(zyjzmj)){
	 and ZYJZMJ=#zyjzmj#
	@}
	@if(!isEmpty(ftjzmj)){
	 and FTJZMJ=#ftjzmj#
	@}
	@if(!isEmpty(fttdmj)){
	 and FTTDMJ=#fttdmj#
	@}
	@if(!isEmpty(fwjg)){
	 and FWJG=#fwjg#
	@}
	@if(!isEmpty(fwxz)){
	 and FWXZ=#fwxz#
	@}
	@if(!isEmpty(ghyt)){
	 and GHYT=#ghyt#
	@}
	@if(!isEmpty(qllx)){
	 and QLLX=#qllx#
	@}
	@if(!isEmpty(qlxz)){
	 and QLXZ=#qlxz#
	@}
	@if(!isEmpty(tdsyjssj)){
	 and TDSYJSSJ=#tdsyjssj#
	@}
	@if(!isEmpty(tdsyqr)){
	 and TDSYQR=#tdsyqr#
	@}
	@if(!isEmpty(tdsyqssj)){
	 and TDSYQSSJ=#tdsyqssj#
	@}
	@if(!isEmpty(yt)){
	 and YT=#yt#
	@}
	@if(!isEmpty(ytdzh)){
	 and YTDZH=#ytdzh#
	@}
	@if(!isEmpty(djlxname)){
	 and DJLXNAME=#djlxname#
	@}
	@if(!isEmpty(qllxname)){
	 and QLLXNAME=#qllxname#
	@}
	@if(!isEmpty(ghytname)){
	 and GHYTNAME=#ghytname#
	@}
	@if(!isEmpty(fwjgname)){
	 and FWJGNAME=#fwjgname#
	@}
	@if(!isEmpty(qlxzname)){
	 and QLXZNAME=#qlxzname#
	@}
	@if(!isEmpty(ytname)){
	 and YTNAME=#ytname#
	@}
	@if(!isEmpty(jgsj)){
	 and JGSJ=#jgsj#
	@}
	@if(!isEmpty(realtype)){
	 and REALTYPE=#realtype#
	@}
	@if(!isEmpty(scqdsj)){
	 and SCQDSJ=#scqdsj#
	@}
	@if(!isEmpty(lah)){
	 and LAH=#lah#
	@}
	@if(!isEmpty(qszt)){
	 and QSZT=#qszt#
	@}
	@if(!isEmpty(qsztname)){
	 and QSZTNAME=#qsztname#
	@}
	@if(!isEmpty(bdcdyhH)){
	 and BDCDYH_H=#bdcdyhH#
	@}
	@if(!isEmpty(qlrmc)){
	 and QLRMC=#qlrmc#
	@}
	@if(!isEmpty(zjlb)){
	 and ZJLB=#zjlb#
	@}
	@if(!isEmpty(zjlbname)){
	 and ZJLBNAME=#zjlbname#
	@}
	@if(!isEmpty(zjhm)){
	 and ZJHM=#zjhm#
	@}
	@if(!isEmpty(yqlrmc)){
	 and YQLRMC=#yqlrmc#
	@}
	@if(!isEmpty(yqlrzjlb)){
	 and YQLRZJLB=#yqlrzjlb#
	@}
	@if(!isEmpty(yqlrzjlbname)){
	 and YQLRZJLBNAME=#yqlrzjlbname#
	@}
	@if(!isEmpty(yqlrzjhm)){
	 and YQLRZJHM=#yqlrzjhm#
	@}
	@if(!isEmpty(zddm)){
	 and ZDDM=#zddm#
	@}
	@if(!isEmpty(hbsm)){
	 and HBSM=#hbsm#
	@}
	@if(!isEmpty(fj)){
	 and FJ=#fj#
	@}
	@if(!isEmpty(houseid)){
	 and HOUSEID=#houseid#
	@}
	@if(!isEmpty(hillrealno)){
	 and HILLREALNO=#hillrealno#
	@}
	@if(!isEmpty(hsr)){
	 and HSR=#hsr#
	@}
	@if(!isEmpty(hssj)){
	 and HSSJ=#hssj#
	@}
	@if(!isEmpty(lybdcqzh)){
	 and LYBDCQZH=#lybdcqzh#
	@}
	@if(!isEmpty(qxdm)){
	 and QXDM=#qxdm#
	@}
	@if(!isEmpty(sjly)){
	 and SJLY=#sjly#
	@}
	@if(!isEmpty(xfxh)){
	 and XFXH=#xfxh#
	@}
	@if(!isEmpty(yfczh)){
	 and YFCZH=#yfczh#
	@}
	@if(!isEmpty(ygthbsm)){
	 and YGTHBSM=#ygthbsm#
	@}
	@if(!isEmpty(yjgsj)){
	 and YJGSJ=#yjgsj#
	@}
	@if(!isEmpty(ysdm)){
	 and YSDM=#ysdm#
	@}
	@if(!isEmpty(ysyqbsm)){
	 and YSYQBSM=#ysyqbsm#
	@}
	@if(!isEmpty(fcywbh)){
	 and FCYWBH=#fcywbh#
	@}
	@if(!isEmpty(fcdjlxbm)){
	 and FCDJLXBM=#fcdjlxbm#
	@}
	@if(!isEmpty(fcdjlxms)){
	 and FCDJLXMS=#fcdjlxms#
	@}
	@if(!isEmpty(fcdjxlbm)){
	 and FCDJXLBM=#fcdjxlbm#
	@}
	@if(!isEmpty(fcdjxlms)){
	 and FCDJXLMS=#fcdjxlms#
	@}
	@if(!isEmpty(blddjlx)){
	 and BLDDJLX=#blddjlx#
	@}
	@if(!isEmpty(builddate)){
	 and BUILDDATE=#builddate#
	@}
	@if(!isEmpty(fcuse)){
	 and FCUSE=#fcuse#
	@}
	@if(!isEmpty(fcstructure)){
	 and FCSTRUCTURE=#fcstructure#
	@}
	@if(!isEmpty(sfsc)){
	 and SFSC=#sfsc#
	@}
	@if(!isEmpty(szcN)){
	 and SZC_N=#szcN#
	@}
	@if(!isEmpty(fSiteId)){
	 and F_SITE_ID=#fSiteId#
	@}
	@if(!isEmpty(fwxzname)){
	 and FWXZNAME=#fwxzname#
	@}
	@if(!isEmpty(yqlr)){
	 and YQLR=#yqlr#
	@}
	@if(!isEmpty(scdjsj)){
	 and SCDJSJ=#scdjsj#
	@}
	@if(!isEmpty(createtime)){
	 and CREATETIME=#createtime#
	@}
	@if(!isEmpty(njghyt)){
	 and NJGHYT=#njghyt#
	@}
	@if(!isEmpty(hcycqdj)){
	 and HCYCQDJ=#hcycqdj#
	@}
	@if(!isEmpty(hcbz)){
	 and HCBZ=#hcbz#
	@}
	@if(!isEmpty(hcsj)){
	 and HCSJ=#hcsj#
	@}
	@if(!isEmpty(hcry)){
	 and HCRY=#hcry#
	@}
	@if(!isEmpty(qxzt)){
	 and QXZT=#qxzt#
	@}
	@if(!isEmpty(iscancel)){
	 and ISCANCEL=#iscancel#
	@}
	@if(!isEmpty(docid)){
	 and DOCID=#docid#
	@}
	@if(!isEmpty(fromsource)){
	 and FROMSOURCE=#fromsource#
	@}
	@if(!isEmpty(jgsjtemp)){
	 and JGSJTEMP=#jgsjtemp#
	@}
	@if(!isEmpty(mjdw)){
	 and MJDW=#mjdw#
	@}
	@if(!isEmpty(mjdwname)){
	 and MJDWNAME=#mjdwname#
	@}
	@if(!isEmpty(szc)){
	 and SZC=#szc#
	@}
	@if(!isEmpty(njJybz)){
	 and NJ_JYBZ=#njJybz#
	@}
	@if(!isEmpty(njSzc)){
	 and NJ_SZC=#njSzc#
	@}
	@if(!isEmpty(qqh)){
	 and QQH=#qqh#
	@}
	@if(!isEmpty(cqly)){
	 and CQLY=#cqly#
	@}
	@if(!isEmpty(qlzt)){
	 and QLZT=#qlzt#
	@}
	@if(!isEmpty(flbz)){
	 and FLBZ=#flbz#
	@}
	@if(!isEmpty(zjzmj)){
	 and ZJZMJ=#zjzmj#
	@}
	@if(!isEmpty(fjzmj)){
	 and FJZMJ=#fjzmj#
	@}
	@if(!isEmpty(xgnrQl)){
	 and XGNR_QL=#xgnrQl#
	@}
	@if(!isEmpty(tdzl)){
	 and TDZL=#tdzl#
	@}
	@if(!isEmpty(fxbz)){
	 and FXBZ=#fxbz#
	@}
	@if(!isEmpty(shr)){
	 and SHR=#shr#
	@}

