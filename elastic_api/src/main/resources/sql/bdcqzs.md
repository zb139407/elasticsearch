sample
===
*简单查询

	select
	    @pageTag(){
	        #use("cols")#
	    @}
	from BDCQZS  where  #use("condition")#

cols
===
	BSM,IID,DJJG,DJSJ,DJN,DJY,DJR,NDSXH,BDCQZH,YSH,BH,QLRMC,QLRZJMC,QLRZJHM,ZL,GYQK,BDCDYH,QLLX,QLXZ,YT,MJ,SYKSRQ,SYZZRQ,SYQX,QLQTQK,SF,ZSAC,ZSBC,ZSCC,CJR,CJSJ,XGR,XGSJ,SFZX,ZXSJ,F_SITE_ID,ALLQLR,INPUT_INDEX,ZDT,FCT,ZDDM,TFH,HXJGNAME,ZYJZMJ,LJZH,ZCS,FTJZMJ,HH,CH,JZMJ,ZDMJ,ZSEWM,ISPRINT,SCZSHIID,QLQTQKBF,SFBF,DZR,DZSJ,ISFZ,DZRSZBM,QRFCFHT,QRZDT,TYBH,FFSJ
condition
===

	1 = 1
	@if(!isEmpty(bsm)){
	 and BSM=#bsm#
	@}
	@if(!isEmpty(iid)){
	 and IID=#iid#
	@}
	@if(!isEmpty(djjg)){
	 and DJJG=#djjg#
	@}
	@if(!isEmpty(djsj)){
	 and DJSJ=#djsj#
	@}
	@if(!isEmpty(djn)){
	 and DJN=#djn#
	@}
	@if(!isEmpty(djy)){
	 and DJY=#djy#
	@}
	@if(!isEmpty(djr)){
	 and DJR=#djr#
	@}
	@if(!isEmpty(ndsxh)){
	 and NDSXH=#ndsxh#
	@}
	@if(!isEmpty(bdcqzh)){
	 and BDCQZH=#bdcqzh#
	@}
	@if(!isEmpty(ysh)){
	 and YSH=#ysh#
	@}
	@if(!isEmpty(bh)){
	 and BH=#bh#
	@}
	@if(!isEmpty(qlrmc)){
	 and QLRMC=#qlrmc#
	@}
	@if(!isEmpty(qlrzjmc)){
	 and QLRZJMC=#qlrzjmc#
	@}
	@if(!isEmpty(qlrzjhm)){
	 and QLRZJHM=#qlrzjhm#
	@}
	@if(!isEmpty(zl)){
	 and ZL=#zl#
	@}
	@if(!isEmpty(gyqk)){
	 and GYQK=#gyqk#
	@}
	@if(!isEmpty(bdcdyh)){
	 and BDCDYH=#bdcdyh#
	@}
	@if(!isEmpty(qllx)){
	 and QLLX=#qllx#
	@}
	@if(!isEmpty(qlxz)){
	 and QLXZ=#qlxz#
	@}
	@if(!isEmpty(yt)){
	 and YT=#yt#
	@}
	@if(!isEmpty(mj)){
	 and MJ=#mj#
	@}
	@if(!isEmpty(syksrq)){
	 and SYKSRQ=#syksrq#
	@}
	@if(!isEmpty(syzzrq)){
	 and SYZZRQ=#syzzrq#
	@}
	@if(!isEmpty(syqx)){
	 and SYQX=#syqx#
	@}
	@if(!isEmpty(qlqtqk)){
	 and QLQTQK=#qlqtqk#
	@}
	@if(!isEmpty(sf)){
	 and SF=#sf#
	@}
	@if(!isEmpty(zsac)){
	 and ZSAC=#zsac#
	@}
	@if(!isEmpty(zsbc)){
	 and ZSBC=#zsbc#
	@}
	@if(!isEmpty(zscc)){
	 and ZSCC=#zscc#
	@}
	@if(!isEmpty(cjr)){
	 and CJR=#cjr#
	@}
	@if(!isEmpty(cjsj)){
	 and CJSJ=#cjsj#
	@}
	@if(!isEmpty(xgr)){
	 and XGR=#xgr#
	@}
	@if(!isEmpty(xgsj)){
	 and XGSJ=#xgsj#
	@}
	@if(!isEmpty(sfzx)){
	 and SFZX=#sfzx#
	@}
	@if(!isEmpty(zxsj)){
	 and ZXSJ=#zxsj#
	@}
	@if(!isEmpty(fSiteId)){
	 and F_SITE_ID=#fSiteId#
	@}
	@if(!isEmpty(allqlr)){
	 and ALLQLR=#allqlr#
	@}
	@if(!isEmpty(inputIndex)){
	 and INPUT_INDEX=#inputIndex#
	@}
	@if(!isEmpty(zdt)){
	 and ZDT=#zdt#
	@}
	@if(!isEmpty(fct)){
	 and FCT=#fct#
	@}
	@if(!isEmpty(zddm)){
	 and ZDDM=#zddm#
	@}
	@if(!isEmpty(tfh)){
	 and TFH=#tfh#
	@}
	@if(!isEmpty(hxjgname)){
	 and HXJGNAME=#hxjgname#
	@}
	@if(!isEmpty(zyjzmj)){
	 and ZYJZMJ=#zyjzmj#
	@}
	@if(!isEmpty(ljzh)){
	 and LJZH=#ljzh#
	@}
	@if(!isEmpty(zcs)){
	 and ZCS=#zcs#
	@}
	@if(!isEmpty(ftjzmj)){
	 and FTJZMJ=#ftjzmj#
	@}
	@if(!isEmpty(hh)){
	 and HH=#hh#
	@}
	@if(!isEmpty(ch)){
	 and CH=#ch#
	@}
	@if(!isEmpty(jzmj)){
	 and JZMJ=#jzmj#
	@}
	@if(!isEmpty(zdmj)){
	 and ZDMJ=#zdmj#
	@}
	@if(!isEmpty(zsewm)){
	 and ZSEWM=#zsewm#
	@}
	@if(!isEmpty(isprint)){
	 and ISPRINT=#isprint#
	@}
	@if(!isEmpty(sczshiid)){
	 and SCZSHIID=#sczshiid#
	@}
	@if(!isEmpty(qlqtqkbf)){
	 and QLQTQKBF=#qlqtqkbf#
	@}
	@if(!isEmpty(sfbf)){
	 and SFBF=#sfbf#
	@}
	@if(!isEmpty(dzr)){
	 and DZR=#dzr#
	@}
	@if(!isEmpty(dzsj)){
	 and DZSJ=#dzsj#
	@}
	@if(!isEmpty(isfz)){
	 and ISFZ=#isfz#
	@}
	@if(!isEmpty(dzrszbm)){
	 and DZRSZBM=#dzrszbm#
	@}
	@if(!isEmpty(qrfcfht)){
	 and QRFCFHT=#qrfcfht#
	@}
	@if(!isEmpty(qrzdt)){
	 and QRZDT=#qrzdt#
	@}
	@if(!isEmpty(tybh)){
	 and TYBH=#tybh#
	@}
	@if(!isEmpty(ffsj)){
	 and FFSJ=#ffsj#
	@}

