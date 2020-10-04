<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="com.mb.service.LichSuThuPhatChiLocalServiceUtil"%>
<%@page import="com.mb.model.LichSuThuPhatChi"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="quanly.portlet.phatvay.phatvay.PhatVayComparator"%>
<%@page import="com.mb.service.PhatVayLocalServiceUtil"%>
<%@page import="com.mb.model.PhatVay"%>
<%@page import="java.util.Date"%>
<%@page import="quanly.portlet.danhmuc.ctv.CongTacVienComparator"%>
<%@page import="com.mb.model.CongTacVien"%>
<%@page import="com.mb.service.CongTacVienLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/thongke/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
.text-right{
	text-align: right;
}
</style>
<%
	String maCTVSearch = ParamUtil.getString(request, "maCTVSearch");
	long ngayBatDauTuSearchTime = ParamUtil.getLong(request, "ngayBatDauTuSearchTime");
	Date ngay = ngayBatDauTuSearchTime > 0 ? new Date(ngayBatDauTuSearchTime) : null;
	List<CongTacVien> items = CongTacVienLocalServiceUtil.getCTVSaoKe(maCTVSearch,ngay);
	int count = items.size();
	Double tongDuNoToiDaAll = GetterUtil.getDouble("0");
	Double tongTienVayAll = GetterUtil.getDouble("0");
	Double tongGocNgayAll = GetterUtil.getDouble("0");
	Double tongLaiNgayAll = GetterUtil.getDouble("0");
	Double tongGocDaThuAll = GetterUtil.getDouble("0");
	Double tongLaiDaThuAll = GetterUtil.getDouble("0");
	Double tongDuNoGocAll = GetterUtil.getDouble("0");
	Locale localeEn = new Locale("en", "EN");
    NumberFormat df = NumberFormat.getInstance(localeEn);
%>
<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/html/thongke/sao_ke_ctv/data.jsp" />
	<portlet:param name="maCTVSearch" value="<%=maCTVSearch%>" />
	<portlet:param name="ngayBatDauTuSearchTime" value="<%=String.valueOf(ngayBatDauTuSearchTime)%>" />
</liferay-portlet:renderURL>
<div id="<portlet:namespace />recordSearchContainer" style="width: max-content;min-width: 100%;">
	<div style="text-align: right;"><span class="note-span">(Đơn vị : VND)</span></div>
	<liferay-ui:search-container  delta="<%=count %>"  emptyResultsMessage="Không có kết quả nào được tìm thấy!" iteratorURL="<%=iteratorURL %>" total="<%=count %>" >
		 <%
		 	String orderByType = ParamUtil.getString(request, "orderByType"); 
		 	String orderByCol = ParamUtil.getString(request, "orderByCol"); 
		 	if(Validator.isNull(orderByType)){
		 		orderByType = "asc";
		 	}
		 	if(Validator.isNull(orderByCol)){
		 		orderByCol = "ma";
		 	}
		 	boolean ascending = true;
		 	if("desc".equals(orderByType)){
		 		ascending = false;
		 	}
		 	CongTacVienComparator obc = new CongTacVienComparator(orderByCol,ascending);
		 	searchContainer.setOrderByCol(orderByCol);
		 	searchContainer.setOrderByType(orderByType);
		 	searchContainer.setOrderByComparator(obc);
		 %>
		 <liferay-ui:search-container-results results="<%= items %>" />
		 <liferay-ui:search-container-row className="com.mb.model.CongTacVien" modelVar="congTacVien" keyProperty="congTacVienId" indexVar="index"> 
			 <%
			 	
			 	Double tongTienVay1 = GetterUtil.getDouble("0");
				Double tongGocNgay1 = GetterUtil.getDouble("0");
				Double tongLaiNgay1 = GetterUtil.getDouble("0");
				
				Double tongGocDaThu1 = GetterUtil.getDouble("0");
				Double tongLaiDaThu1 = GetterUtil.getDouble("0");
				Double tongDuNoGoc1 = GetterUtil.getDouble("0");
				
				Double tongTienVay2 = GetterUtil.getDouble("0");
				Double tongGocNgay2 = GetterUtil.getDouble("0");
				Double tongLaiNgay2 = GetterUtil.getDouble("0");
				
				Double tongGocDaThu2 = GetterUtil.getDouble("0");
				Double tongLaiDaThu2 = GetterUtil.getDouble("0");
				Double tongDuNoGoc2 = GetterUtil.getDouble("0");
				
				Double duNoToiDaTinChap = GetterUtil.getDouble("0");
		 		if(congTacVien.getDuNoToiDa() > congTacVien.getDuNoToiDaTheChap()){
		 			duNoToiDaTinChap = congTacVien.getDuNoToiDa() - congTacVien.getDuNoToiDaTheChap();
		 		}
				
				PhatVayComparator obcPhatVay = new PhatVayComparator("createdate",true);
				List<PhatVay> phatVays = PhatVayLocalServiceUtil.getPhatVaySaoKe(congTacVien.getMa(),0, ngay);
		 		for(PhatVay item : phatVays){
		 			Double gocDaThu = GetterUtil.getDouble("0");
		 			Double laiDaThu = GetterUtil.getDouble("0");
		 			Double duGoc =  item.getSoTienVay();
		 			List<LichSuThuPhatChi> lichSuThuPhatChis = LichSuThuPhatChiLocalServiceUtil.findByPhatVay_Createdate_Loai(item.getPhatVayId(), null, ngay, "3,4");
		 			for(LichSuThuPhatChi lichSuThuPhatChi : lichSuThuPhatChis){
		 				gocDaThu += lichSuThuPhatChi.getTongSoTienVonTra();
		 				laiDaThu += lichSuThuPhatChi.getTongSoTienLaiTra();
		 				duGoc -= lichSuThuPhatChi.getTongSoTienVonTra();
		 			}
		 			if(item.getLoaiPhatVay() == 1){
		 				tongTienVay1 += item.getSoTienVay();
		 				tongGocNgay1 += item.getGocNgay();
			 			tongLaiNgay1 += item.getLaiNgay();
			 			
			 			tongGocDaThu1 += gocDaThu;
			 			tongLaiDaThu1 += laiDaThu;
			 			tongDuNoGoc1 += duGoc;
			 			
		 			}else {
		 				tongTienVay2 += item.getSoTienVay();
		 				tongGocNgay2 += item.getGocNgay();
			 			tongLaiNgay2 += item.getLaiNgay();
			 			
			 			tongGocDaThu2 += gocDaThu;
			 			tongLaiDaThu2 += laiDaThu;
			 			tongDuNoGoc2 += duGoc;
		 			}
		 		}
		 		Double tongTienVay = tongTienVay1 + tongTienVay2;
				Double tongGocNgay = tongGocNgay1 + tongGocNgay2;
				Double tongLaiNgay = tongLaiNgay1 + tongLaiNgay2;
				Double tongGocDaThu = tongGocDaThu1 + tongGocDaThu2;
				Double tongLaiDaThu = tongLaiDaThu1 + tongLaiDaThu2 ;
				Double tongDuNoGoc = tongDuNoGoc1 + tongDuNoGoc2;
				tongDuNoToiDaAll += congTacVien.getDuNoToiDa();
				tongTienVayAll +=tongTienVay;
		 		tongGocNgayAll += tongGocNgay;
		 		tongLaiNgayAll += tongLaiNgay;
		 		tongGocDaThuAll += tongGocDaThu;
		 		tongLaiDaThuAll += tongLaiDaThu;
		 		tongDuNoGocAll += tongDuNoGoc;
		 		%>
			 <liferay-ui:search-container-column-text cssClass="aui-w3" name="STT">
			 	<span style="font-weight: bold;"><%=index + 1 %></span>
		 		<br/>
		 		<span>&nbsp;</span>
		 		<br/>
		 		<span>&nbsp;</span>
			 </liferay-ui:search-container-column-text>
			  <liferay-ui:search-container-column-text name="Mã CTV">
			 	<span style="font-weight: bold;"><%=congTacVien.getMa() %></span>
			 	<br/>
		 		<span>&nbsp;</span>
		 		<br/>
		 		<span>&nbsp;</span>
			 </liferay-ui:search-container-column-text>
			  <liferay-ui:search-container-column-text  name="TÊN CTV">
			 	<span style="font-weight: bold;"><%=congTacVien.getHoTen() %></span>
			 	<br/>
		 		<span>&nbsp;</span>
		 		<br/>
		 		<span>&nbsp;</span>
			 </liferay-ui:search-container-column-text>
			 <liferay-ui:search-container-column-text name="TT.CHẤP">
			 	<span style="color:#ff3d00e8;font-weight: bold;">TỔNG</span>
			 	<br/>
		 		<span style="color:blue;font-style: italic;">THẾ CHẤP</span>
		 		<br/>
		 		<span style="font-style: italic;">TÍN CHẤP</span>
			 </liferay-ui:search-container-column-text>
			 <liferay-ui:search-container-column-text name="DƯ NỢ TỐI ĐA" cssClass="aui-w10 text-right">
			 	<span style="color:#ff3d00e8;font-weight: bold;"><%=congTacVien.getDuNoToiDa() > 0 ? df.format(congTacVien.getDuNoToiDa()) : "0" %></span>
				<br/>
		 		<span style="color:blue;"><%=congTacVien.getDuNoToiDaTheChap() > 0 ? df.format(congTacVien.getDuNoToiDaTheChap()) : "0" %></span>
		 		<br/>
		 		<span><%=duNoToiDaTinChap > 0 ? df.format(duNoToiDaTinChap) : "0" %></span>
			 </liferay-ui:search-container-column-text>
			 <liferay-ui:search-container-column-text cssClass="text-right" name="TỔNG TIỀN">
			 	<span style="color:#ff3d00e8;font-weight: bold;"><%=tongTienVay > 0 ? df.format(tongTienVay)  : "0"%></span>
			 	<br/>
		 		<span style="color:blue;"><%=tongTienVay1 > 0 ? df.format(tongTienVay1)  : "0"%></span>
		 		<br/>
		 		<span><%=tongTienVay2 > 0 ? df.format(tongTienVay2)  : "0"%></span>
			 </liferay-ui:search-container-column-text>
			 <liferay-ui:search-container-column-text cssClass="text-right" name="GỐC NGÀY">
			 	<span style="color:#ff3d00e8;font-weight: bold;"><%=tongGocNgay > 0 ? df.format(tongGocNgay)  : "0"%></span>
			 	<br/>
		 		<span style="color:blue;"><%=tongGocNgay1 > 0 ? df.format(tongGocNgay1)  : "0"%></span>
		 		<br/>
		 		<span><%=tongGocNgay2 > 0 ? df.format(tongGocNgay2)  : "0"%></span>
			 </liferay-ui:search-container-column-text>
			  <liferay-ui:search-container-column-text cssClass="text-right" name="LÃI NGÀY">
		 		<span style="color:#ff3d00e8;font-weight: bold;"><%=tongLaiNgay > 0 ? df.format(tongLaiNgay)  : "0"%></span>
		 		<br/>
		 		<span style="color:blue;"><%=tongLaiNgay1 > 0 ? df.format(tongLaiNgay1)  : "0"%></span>
		 		<br/>
		 		<span><%=tongLaiNgay2 > 0 ? df.format(tongLaiNgay2)  : "0"%></span>
			 </liferay-ui:search-container-column-text>
			  <liferay-ui:search-container-column-text cssClass="text-right" name="GỐC ĐÃ THU">
		 		<span style="color:#ff3d00e8;font-weight: bold;"><%=tongGocDaThu > 0 ? df.format(tongGocDaThu)  : "0"%></span>
			 	<br/>
		 		<span style="color:blue;"><%=tongGocDaThu1 > 0 ? df.format(tongGocDaThu1)  : "0"%></span>
		 		<br/>
		 		<span><%=tongGocDaThu2 > 0 ? df.format(tongGocDaThu2)  : "0"%></span>
			 </liferay-ui:search-container-column-text>
			  <liferay-ui:search-container-column-text cssClass="text-right" name="LÃI ĐÃ THU">
		 		<span style="color:#ff3d00e8;font-weight: bold;"><%=tongLaiDaThu > 0 ? df.format(tongLaiDaThu)  : "0"%></span>
				<br/>
		 		<span style="color:blue;"><%=tongLaiDaThu1 > 0 ? df.format(tongLaiDaThu1)  : "0"%></span>
		 		<br/>
		 		<span><%=tongLaiDaThu2 > 0 ? df.format(tongLaiDaThu2)  : "0"%></span>			 </liferay-ui:search-container-column-text>
			  <liferay-ui:search-container-column-text cssClass="text-right" name="DƯ NỢ GỐC">
		 		<span style="color:#ff3d00e8;font-weight: bold;"><%=tongDuNoGoc > 0 ? df.format(tongDuNoGoc)  : "0"%></span>
		 		<br/>
		 		<span style="color:blue;"><%=tongDuNoGoc1 > 0 ? df.format(tongDuNoGoc1)  : "0"%></span>
		 		<br/>
		 		<span><%=tongDuNoGoc2 > 0 ? df.format(tongDuNoGoc2)  : "0"%></span>	
			 </liferay-ui:search-container-column-text>
		 </liferay-ui:search-container-row >
		 <liferay-ui:search-iterator />
	</liferay-ui:search-container >
</div>

<aui:script use="aui-base,aui-io-plugin-deprecated,aui-loading-mask-deprecated">
AUI().ready(['aui-base'], function(A) {
	Liferay.Data.redirectURL = '${iteratorURL}';
	var recordSearchContainer = A.one('#<portlet:namespace />recordSearchContainer');
	var loadingMask = new A.LoadingMask(
		{
			target: recordSearchContainer
		}
	);
	var plugin = recordSearchContainer.plug(A.Plugin.IO,{
        autoLoad: false,
        failureMessage : 'Loading...'
    });
	var pageIO = plugin.io;
	recordSearchContainer.all('ul.dropdown-menu.lfr-menu-list.direction-down a').on('click', function(e) {
		console.log('123');
    	e.preventDefault();
    	Liferay.Data.redirectURL = e.currentTarget.get('href');
    	pageIO.set('uri', e.currentTarget.get('href'));
    	pageIO.start();
    });
    recordSearchContainer.all('ul.lfr-pagination-buttons.pager a').on('click', function(e) {
    	e.preventDefault();
    	Liferay.Data.redirectURL = e.currentTarget.get('href');
    	pageIO.set('uri', e.currentTarget.get('href'));
    	pageIO.start();
    });
    recordSearchContainer.all('div.table-sort-liner a').on('click', function(e) {
    	e.preventDefault();
    	Liferay.Data.redirectURL = e.currentTarget.get('href');
    	pageIO.set('uri', e.currentTarget.get('href'));
    	pageIO.start();
    });
     var table = recordSearchContainer.one('table');
    if(table){
    	var tbody = table.one('tbody');
    	var trNode = A.Node.create('<tr/>');
    	var td1Node = A.Node.create('<td class="table-cell aui-w3 first" colspan="4"/>');
    	td1Node.append(A.Node.create('<span style="color:#ff3d00e8;font-weight: bold;">TỔNG</span>'));
    	
    	var td2Node = A.Node.create('<td class="table-cell aui-w8 text-right"/>');
    	td2Node.append(A.Node.create('<span style="color:#ff3d00e8;font-weight: bold;"><%=tongDuNoToiDaAll > 0 ? df.format(tongDuNoToiDaAll) : "0" %></span>'));
    	
    	var td3Node = A.Node.create('<td class="table-cell aui-w8 text-right"/>');
    	td3Node.append(A.Node.create('<span style="color:#ff3d00e8;font-weight: bold;"><%=tongTienVayAll > 0 ? df.format(tongTienVayAll) : "0" %></span>'));
    	
    	var td4Node = A.Node.create('<td class="table-cell aui-w8 text-right"/>');
    	td4Node.append(A.Node.create('<span style="color:#ff3d00e8;font-weight: bold;"><%=tongGocNgayAll > 0 ? df.format(tongGocNgayAll) : "0" %></span>'));
    	
    	var td5Node = A.Node.create('<td class="table-cell aui-w8 text-right"/>');
    	td5Node.append(A.Node.create('<span style="color:#ff3d00e8;font-weight: bold;"><%=tongLaiNgayAll > 0 ? df.format(tongLaiNgayAll) : "0" %></span>'));
    	
    	var td6Node = A.Node.create('<td class="table-cell aui-w8 text-right"/>');
    	td6Node.append(A.Node.create('<span style="color:#ff3d00e8;font-weight: bold;"><%=tongGocDaThuAll > 0 ? df.format(tongGocDaThuAll) : "0" %></span>'));
    	
    	var td7Node = A.Node.create('<td class="table-cell aui-w8 text-right"/>');
    	td7Node.append(A.Node.create('<span style="color:#ff3d00e8;font-weight: bold;"><%=tongLaiDaThuAll > 0 ? df.format(tongLaiDaThuAll) : "0" %></span>'));
    	
    	var td8Node = A.Node.create('<td class="table-cell aui-w8 text-right last"/>');
    	td8Node.append(A.Node.create('<span style="color:#ff3d00e8;font-weight: bold;"><%=tongDuNoGocAll > 0 ? df.format(tongDuNoGocAll) : "0" %></span>'));
    	
    	trNode.append(td1Node);
    	trNode.append(td2Node);
    	trNode.append(td3Node);
    	trNode.append(td4Node);
    	trNode.append(td5Node);
    	trNode.append(td6Node);
    	trNode.append(td7Node);
    	trNode.append(td8Node);
    	tbody.append(trNode);
    }
});	
</aui:script>