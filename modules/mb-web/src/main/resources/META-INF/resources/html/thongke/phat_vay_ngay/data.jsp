<%@page import="java.text.SimpleDateFormat"%>
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
<%
	long ngayPhatVaySearchTime = ParamUtil.getLong(request, "ngayPhatVaySearch");
	Date ngayPhatVay = ngayPhatVaySearchTime != 0 ? new Date(ngayPhatVaySearchTime) : null;
	List<CongTacVien> items = CongTacVienLocalServiceUtil.getCTVPhatVayNgay(ngayPhatVay, ngayPhatVay);
	DecimalFormat df = new DecimalFormat("###,###.###");
	Double tongTienPhatVay = GetterUtil.getDouble("0");
%>
<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="ngayPhatVaySearch" value="<%= String.valueOf(ngayPhatVaySearchTime)%>" />
	<portlet:param name="mvcPath" value="/html/thongke/phat_vay_ngay/data.jsp" />
</liferay-portlet:renderURL>
<div id="<portlet:namespace />recordSearchContainer">
	<div style="text-align: right;"><span class="note-span">(Đơn vị : VND)</span></div>
	<liferay-ui:search-container  delta="<%=items.size() %>"  emptyResultsMessage="Không có kết quả nào được tìm thấy!" iteratorURL="<%=iteratorURL %>" total="<%=items.size()  %>" >
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
			 	Double tongTienKhacHang = GetterUtil.getDouble("0");
			 	PhatVayComparator obcPhatVay = new PhatVayComparator("createdate",true);
		 		List<PhatVay> phatVays = PhatVayLocalServiceUtil.findBase("", congTacVien.getMa(), "", ngayPhatVay, ngayPhatVay,null,null, null, null, null, -1, -1, obcPhatVay);
			 %>
			 <liferay-ui:search-container-column-text cssClass="aui-w10" name="SỐ KU">
			 	<span style="color:#ff3d00e8;font-weight: bold;"><%=index + 1 %></span>
			 	<%
			 		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			 		for(PhatVay item : phatVays){
			 			tongTienKhacHang += item.getSoTienVay();
			 			tongTienPhatVay += item.getSoTienVay();
			 			
			 	%>
			 		<br/>
			 		<span style="font-style: italic;"><%=item.getSoKU()%></span>
			 	<%
			 		}
			 	%>
			 </liferay-ui:search-container-column-text>
			  <liferay-ui:search-container-column-text cssClass="aui-w10" name="MÃ">
			 	<span style="color:#ff3d00e8;font-weight: bold;"><%=congTacVien.getMa() %></span>
			 	<%
			 		for(PhatVay item : phatVays){
			 	%>
			 		<br/>
			 		<span style="font-style: italic;"><%=item.getKhachHang().getMa() %></span>
			 	<%
			 		}
			 	%>
			 </liferay-ui:search-container-column-text>
			  <liferay-ui:search-container-column-text cssClass="aui-w15" name="HỌ TÊN">
			 	<span style="color:#ff3d00e8;font-weight: bold;"><%=congTacVien.getHoTen() %></span>
			 	<%
			 		for(PhatVay item : phatVays){
			 	%>
			 		<br/>
			 		<span style="font-style: italic;"><%=item.getKhachHang().getHoTen() %></span>
			 	<%
			 		}
			 	%>
			 </liferay-ui:search-container-column-text>
			  <liferay-ui:search-container-column-text cssClass="aui-w10" name="NGÀY PHÁT VAY">
		 		<%
			 		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			 		for(PhatVay item : phatVays){
			 			
			 	%>
			 		<br/>
			 		<span style="font-style: italic;"><%=item.getCreateDate() != null ? sdf.format(item.getCreateDate()) : ""%></span>
			 	<%
			 		}
			 	%>
			 </liferay-ui:search-container-column-text>
			 <liferay-ui:search-container-column-text name="ĐỊA CHỈ">
			 	<%
			 		for(PhatVay item : phatVays){
			 	%>
			 		<br/>
			 		<span style="font-style: italic;"><%= item.getKhachHang() != null ? item.getKhachHang().getDiaChi() : " "%></span>
			 	<%
			 		}
			 	%>
			 </liferay-ui:search-container-column-text>
			 <liferay-ui:search-container-column-text name="KỲ HẠN">
			 	<%
			 		for(PhatVay item : phatVays){
			 	%>
			 		<br/>
			 		<span style="font-style: italic;"><%=item.getThoiHan() %></span>
			 	<%
			 		}
			 	%>
			 </liferay-ui:search-container-column-text>
			 <liferay-ui:search-container-column-text name="SỐ TIỀN">
			 	<span style="color:#ff3d00e8;font-weight: bold;"><%=tongTienKhacHang > 0 ? df.format(tongTienKhacHang) : "" %></span>
			 	<%
			 		for(PhatVay item : phatVays){
			 	%>
			 		<br/>
			 		<span style="font-style: italic;"><%=item.getSoTienVay() > 0 ? df.format(item.getSoTienVay()) : "" %></span>
			 	<%
			 		}
			 	%>
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
    	var td1Node = A.Node.create('<td class="table-cell text-center first" colspan="6"/>');
    	td1Node.append(A.Node.create('<span style="color:#ff3d00e8;font-weight: bold;">TỔNG</span>'));
    	
    	var td2Node = A.Node.create('<td class="table-cell text-left last"/>');
    	td2Node.append(A.Node.create('<span style="color:#ff3d00e8;font-weight: bold;"><%=tongTienPhatVay > 0 ? df.format(tongTienPhatVay) : "0" %></span>'));
    	
    	trNode.append(td1Node);
    	trNode.append(td2Node);
    	tbody.append(trNode);
    }
});	
</aui:script>