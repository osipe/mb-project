<%@page import="quanly.constants.TrangThaiPhatVayEnum"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.mb.model.CongTacVien"%>
<%@page import="quanly.portlet.danhmuc.ctv.CongTacVienComparator"%>
<%@page import="com.mb.service.CongTacVienLocalServiceUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="quanly.portlet.phatvay.phatvay.PhatVayChecker"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="quanly.portlet.phatvay.phatvay.PhatVayComparator"%>
<%@page import="com.mb.model.PhatVay"%>
<%@page import="java.util.List"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.mb.service.PhatVayLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/phatvay/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%	
	long ngayThuTienTuTime = ParamUtil.getLong(request, "ngayThuTienTu");
	Date ngayThuTienTu = ngayThuTienTuTime != 0 ? new Date(ngayThuTienTuTime) : null;
	long ngayThuTienDenTime = ParamUtil.getLong(request, "ngayThuTienDen");
	Date ngayThuTienDen = ngayThuTienDenTime != 0 ? new Date(ngayThuTienDenTime) : null;
	String maCTVSearch = ParamUtil.getString(request, "maCTVSearch");
	int count = CongTacVienLocalServiceUtil.countBase(maCTVSearch, "", "", "", 1);
	DecimalFormat df = new DecimalFormat("###,###.###");
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
%>
<c:set value="<%=df %>" var="df"/>
<c:set value="<%=sdf %>" var="sdf"/>
<aui:form name="fm">
	<liferay-portlet:renderURL varImpl="iteratorURL">
		<portlet:param name="ngayThuTienTu" value="<%= String.valueOf(ngayThuTienTuTime) %>" />
		<portlet:param name="ngayThuTienDen" value="<%= String.valueOf(ngayThuTienDenTime) %>" />
		<portlet:param name="maCTVSearch" value="<%= String.valueOf(maCTVSearch) %>" />
		<portlet:param name="mvcPath" value="/html/phatvay/thutienhangngay/datathutientruoc.jsp" />
	</liferay-portlet:renderURL>
	<div style="text-align: right;"><span class="note-span">(Đơn vị : VND)</span></div>
	<liferay-ui:search-container  delta="10"  emptyResultsMessage="Không có kết quả nào được tìm thấy!" iteratorURL="<%=iteratorURL %>" total="<%=count %>" >
		 <%
		 	String orderByType = ParamUtil.getString(request, "orderByType"); 
		 	String orderByCol = ParamUtil.getString(request, "orderByCol"); 
		 	if(Validator.isNull(orderByType)){
		 		orderByType = "asc";
		 	}
		 	if(Validator.isNull(orderByCol)){
		 		orderByCol = "createdate";
		 	}
		 	boolean ascending = false;
		 	if("asc".equals(orderByType)){
		 		ascending = true;
		 	}
		 	CongTacVienComparator obc = new CongTacVienComparator(orderByCol,ascending);
		 	searchContainer.setOrderByCol(orderByCol);
		 	searchContainer.setOrderByType(orderByType);
		 	searchContainer.setOrderByComparator(obc);
		 
			List<CongTacVien> items = CongTacVienLocalServiceUtil.findBase( maCTVSearch, "", "", "", 1, searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
		 %>
		 <liferay-ui:search-container-results results="<%= items %>" />
		 <liferay-ui:search-container-row className="com.mb.model.CongTacVien" modelVar="congTacVien" keyProperty="congTacVienId" indexVar="index"> 
			 <%
			 	Double tongTienVay = GetterUtil.getDouble("0");
				Double tongGocNgay = GetterUtil.getDouble("0");
				Double tongLaiNgay = GetterUtil.getDouble("0");
				Double tongDuNoGoc = GetterUtil.getDouble("0");
				PhatVayComparator obcPhatVay = new PhatVayComparator("createdate",true);
		 		List<PhatVay> phatVays = PhatVayLocalServiceUtil.getPhatVayDeThuTienTruoc(maCTVSearch, ngayThuTienTu);
			 %>
			 <liferay-ui:search-container-column-text cssClass="aui-w3" name="STT">
			 	<span style="color:#ff3d00e8;font-weight: bold;"><%=index + 1 %></span>
			 	<%
			 		for(PhatVay item : phatVays){
			 			tongTienVay += item.getSoTienVay();
			 			tongGocNgay += item.getGocNgay();
			 			tongLaiNgay += item.getLaiNgay();
			 			tongDuNoGoc += item.getDuNoGoc();
			 	%>
			 		<br/>
			 		<span>&nbsp;</span>
			 	<%
			 		}
			 	%>
			 </liferay-ui:search-container-column-text>
			 <liferay-ui:search-container-column-text cssClass="aui-w7" name="SỐ KU">
			 	<span style="color:#ff3d00e8;font-weight: bold;">&nbsp;</span>
			 	<%
			 		for(PhatVay item : phatVays){
			 	%>
			 		<br/>
			 		<span><%=item.getSoKU() %></span>
			 	<%
			 		}
			 	%>
			 </liferay-ui:search-container-column-text>
			  <liferay-ui:search-container-column-text cssClass="aui-w5" name="Mã">
			 	<span style="color:#ff3d00e8;font-weight: bold;"><%=congTacVien.getMa() %></span>
			 	<%
			 		for(PhatVay item : phatVays){
			 	%>
			 		<br/>
			 		<span><%=item.getKhachHang() != null ? item.getKhachHang().getMa() : "" %></span>
			 	<%
			 		}
			 	%>
			 </liferay-ui:search-container-column-text>
			  <liferay-ui:search-container-column-text  name="TÊN">
			 	<span style="color:#ff3d00e8;font-weight: bold;"><%=congTacVien.getHoTen() %></span>
			 	<%
			 		for(PhatVay item : phatVays){
			 	%>
			 		<br/>
			 		<span><%=item.getKhachHang() != null ? item.getKhachHang().getHoTen() : "" %></span>
			 	<%
			 		}
			 	%>
			 </liferay-ui:search-container-column-text>
			 <liferay-ui:search-container-column-text cssClass="aui-w10" name="SỐ TIỀN VAY">
			 	<span style="color:#ff3d00e8;font-weight: bold;"><%=tongTienVay > 0 ? df.format(tongTienVay)  : "0"%></span>
			 	<%
			 		for(PhatVay item : phatVays){
			 	%>
			 		<br/>
			 		<span style="font-style: italic;"><%=item.getSoTienVay() > 0 ? df.format(item.getSoTienVay()) : "0"%></span>
			 	<%
			 		}
			 	%>
			 </liferay-ui:search-container-column-text>
			 <liferay-ui:search-container-column-text cssClass="aui-w10" name="GỐC NGÀY">
			 	<span style="color:#ff3d00e8;font-weight: bold;"><%=tongGocNgay > 0 ? df.format(tongGocNgay)  : "0"%></span>
			 	<%
			 		for(PhatVay item : phatVays){
			 	%>
			 		<br/>
			 		<span style="font-style: italic;"><%=item.getGocNgay() > 0 ? df.format(item.getGocNgay()) : "0"%></span>
			 	<%
			 		}
			 	%>
			 </liferay-ui:search-container-column-text>
			  <liferay-ui:search-container-column-text cssClass="aui-w7" name="LÃI NGÀY">
			 		<span style="color:#ff3d00e8;font-weight: bold;"><%=tongLaiNgay > 0 ? df.format(tongLaiNgay)  : "0"%></span>
			 	<%
			 		for(PhatVay item : phatVays){
			 	%>
			 		<br/>
			 		<span style="font-style: italic;"><%=item.getLaiNgay()> 0 ? df.format(item.getLaiNgay()) : "0"%></span>
			 	<%
			 		}
			 	%>
			 </liferay-ui:search-container-column-text>
			 <liferay-ui:search-container-column-text cssClass="aui-w7" name="SỐ TIỀN PHẢI THU (1 Ngày)">
			 		<span style="color:#ff3d00e8;font-weight: bold;"><%=(tongGocNgay + tongLaiNgay) > 0 ? df.format(tongGocNgay + tongLaiNgay)  : "0"%></span>
			 	<%
			 		for(PhatVay item : phatVays){
			 	%>
			 		<br/>
			 		<span style="font-style: italic;"><%=(item.getLaiNgay() + item.getGocNgay())> 0 ? df.format(item.getLaiNgay() + item.getGocNgay()) : "0"%></span>
			 	<%
			 		}
			 	%>
			 </liferay-ui:search-container-column-text>
		 	 <liferay-ui:search-container-column-text cssClass="aui-w7" name="NGÀY ĐÃ THU CUỐI">
			 		<span style="color:#ff3d00e8;font-weight: bold;">&nbsp;</span>
			 	<%
			 		for(PhatVay item : phatVays){
			 	%>
			 		<br/>
			 		<span style="font-style: italic;"><%=item.getNgayDaThuCuoi() != null ? sdf.format(item.getNgayDaThuCuoi()) : ("Chưa thu : " + sdf.format(item.getNgayBatDau()))%></span>
			 	<%
			 		}
			 	%>
			 </liferay-ui:search-container-column-text>
			 <liferay-ui:search-container-column-text cssClass="aui-w20" name="THU TIỀN TẾT">
			 		<span style="color:#ff3d00e8;font-weight: bold;">&nbsp;</span>
			 	<%
			 		for(PhatVay item : phatVays){
			 			String ngayThuTruoc = "";
			 			if(item.getTrangThai() == TrangThaiPhatVayEnum.CO_THU_TIEN_TRUOC.getValue() && item.getNgayThuTruocTu() != null && item.getNgayThuTruocDen() != null){
			 				ngayThuTruoc = "Đã thu trước tết" + "( " + sdf.format(item.getNgayThuTruocTu()) + " - " + sdf.format(item.getNgayThuTruocDen()) + " )";
			 			}
			 	%>
			 		<br/>
			 		<span style="font-style: italic;"><%=ngayThuTruoc%></span>
			 	<%
			 		}
			 	%>
			 </liferay-ui:search-container-column-text>
			  <%-- <liferay-ui:search-container-column-text cssClass="aui-w10" name="DƯ NỢ GỐC HIỆN TẠI">
			 		<span style="color:#ff3d00e8;font-weight: bold;"><%=tongDuNoGoc > 0 ? df.format(tongDuNoGoc)  : "0"%></span>
			 	<%
			 		for(PhatVay item : phatVays){
			 	%>
			 		<br/>
			 		<span style="font-style: italic;"><%=item.getDuNoGoc() > 0 ? df.format(item.getDuNoGoc()) : "0"%></span>
			 	<%
			 		}
			 	%>
			 </liferay-ui:search-container-column-text>
			  <liferay-ui:search-container-column-text cssClass="aui-w10" name="DƯ NỢ GỐC SAU KHI THU">
			 		<span style="color:#ff3d00e8;font-weight: bold;"><%=(tongDuNoGoc - tongGocNgay) > 0 ? df.format(tongDuNoGoc - tongGocNgay)  : "0"%></span>
			 	<%
			 		for(PhatVay item : phatVays){
			 	%>
			 		<br/>
			 		<span style="font-style: italic;"><%=(item.getDuNoGoc() - item.getGocNgay()) > 0 ? df.format(item.getDuNoGoc() - item.getGocNgay()) : "0"%></span>
			 	<%
			 		}
			 	%>
			 </liferay-ui:search-container-column-text> --%>
		 </liferay-ui:search-container-row >
		 <liferay-ui:search-iterator />
	</liferay-ui:search-container >
</aui:form>
<aui:script use="aui-base,aui-io-plugin-deprecated,aui-loading-mask-deprecated,liferay-util-list-fields">
AUI().ready(['aui-base'], function(A) {
	Liferay.Data.redirectURL = '${iteratorURL}';
	var recordSearchContainer = A.one('#<portlet:namespace />contentDataTableThuTienTruoc');
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
    	e.preventDefault();
    	Liferay.Data.redirectURL = e.currentTarget.get('href');
    	pageIO.set('uri', e.currentTarget.get('href'));
    	pageIO.start();
    });
    recordSearchContainer.all('ul.lfr-pagination-buttons.pager a').on('click', function(e) {
    	e.preventDefault();
    	Liferay.Data.redirectURL = e.currentTarget.get('href');
    	var url = e.currentTarget.get('href');
    	pageIO.set('uri', url);
    	pageIO.start();
    });
    recordSearchContainer.all('div.table-sort-liner a').on('click', function(e) {
    	e.preventDefault();
    	Liferay.Data.redirectURL = e.currentTarget.get('href');
    	pageIO.set('uri', e.currentTarget.get('href'));
    	pageIO.start();
    });
});	
</aui:script>
