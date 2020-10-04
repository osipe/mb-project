<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
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
<%@ include file="/html/danhmuc/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%	
	long ngayTatToanSearchTime = ParamUtil.getLong(request, "ngayTatToanSearch");
	Date ngayTatToanSearch = ngayTatToanSearchTime != 0 ? new Date(ngayTatToanSearchTime) : null;
	String maCTVSearch = ParamUtil.getString(request, "maCTVSearch");
	int count = PhatVayLocalServiceUtil.countBase("", maCTVSearch, "",null,null, null, null,ngayTatToanSearch,ngayTatToanSearch, "3");
	Locale localeEn = new Locale("en", "EN");
    NumberFormat df = NumberFormat.getInstance(localeEn);
	String arrayChecked = ParamUtil.getString(request, "arrayChecked");
	String[] checked = StringUtil.split(arrayChecked, ",");
	PhatVayChecker rowChecker = new PhatVayChecker(renderResponse, checked);
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
%>
<c:set value="<%=df %>" var="df"/>
<c:set value="<%=sdf %>" var="sdf"/>
<aui:form name="fmLichSu">
	<liferay-portlet:renderURL varImpl="iteratorURL">
		<portlet:param name="ngayTatToanSearch" value="<%= String.valueOf(ngayTatToanSearchTime) %>" />
		<portlet:param name="maCTVSearch" value="<%= String.valueOf(maCTVSearch) %>" />
		<portlet:param name="arrayChecked" value="<%= arrayChecked%>" />
		<portlet:param name="mvcPath" value="/html/phatvay/tattoan/lichsutattoan/danh_sach_phat_vay_da_tat_toan.jsp" />
	</liferay-portlet:renderURL>
		<div style="text-align: right;"><span class="note-span">(Đơn vị : VND)</span></div>
		<liferay-ui:search-container  delta="20"  emptyResultsMessage="Không có kết quả nào được tìm thấy!" iteratorURL="<%=iteratorURL %>" total="<%=count %>" rowChecker="<%=rowChecker%>">
			 <%
			 	String orderByType = ParamUtil.getString(request, "orderByType"); 
			 	String orderByCol = ParamUtil.getString(request, "orderByCol"); 
			 	if(Validator.isNull(orderByType)){
			 		orderByType = "desc";
			 	}
			 	if(Validator.isNull(orderByCol)){
			 		orderByCol = "createdate";
			 	}
			 	boolean ascending = true;
			 	if("desc".equals(orderByType)){
			 		ascending = false;
			 	}
			 	PhatVayComparator obc = new PhatVayComparator(orderByCol,ascending);
			 	searchContainer.setOrderByCol(orderByCol);
			 	searchContainer.setOrderByType(orderByType);
			 	searchContainer.setOrderByComparator(obc);
			 
				List<PhatVay> items =  PhatVayLocalServiceUtil.findBase("", maCTVSearch, "",null,null, null, null,ngayTatToanSearch,ngayTatToanSearch, "3", searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
		 %>
			 <liferay-ui:search-container-results results="<%= items %>" />
			 <liferay-ui:search-container-row className="com.mb.model.PhatVay" modelVar="phatVay" keyProperty="phatVayId"> 
			 	<%
				 	String soLanDaThuStr = String.valueOf(phatVay.getSoLanDaThu());
					if(phatVay.getTrangThai() == 4){
						soLanDaThuStr =  String.valueOf(phatVay.getSoLanDaThu() + phatVay.getSoNgayThuTruoc()) + " (Thu trước " + phatVay.getSoNgayThuTruoc() + " Ngày)";
					}
			 	%>
		 		 <liferay-ui:search-container-column-text cssClass="aui-w20" name="Thông tin phát vay" orderable="true"  orderableProperty="soTienVay">
		  			Số KU : <span style="color:#ff3d00e8" >${phatVay.soKU}</span>
				 	<br/>
			  		Số tiền vay : <span style="color: blue;" >${phatVay.soTienVay > 0 ? df.format(phatVay.soTienVay) : '0'}</span>
				 	<br/>
				 	Thời hạn : <span style="color: blue;">${phatVay.thoiHan}</span><span class="note-span"> ngày</span>
				 	<br/>
				 	Loại phát vay : <span style="color: blue;">${phatVay.loaiPhatVay == 1 ? 'Thế chấp' :  'Tín chấp'}</span>
				 	<br/>
				 	<span class="note-span">(</span><span class="note-span" style="color:blue" >Lãi suất :  ${phatVay.laiSuatVay}%</span><span class="note-span">)</span>
				 </liferay-ui:search-container-column-text>
			 	 <liferay-ui:search-container-column-text name="Thông tin khách hàng"  orderable="true" orderableProperty="soKU">
				 	Khách hàng : <span style="color:#ff3d00e8" >${not empty  phatVay.khachHang ? phatVay.khachHang.hoTen : ''}</span>
				 	<br/>
				 	<span class="note-span">(Mã : ${phatVay.maKhachHang})</span>
				 	<br/>
				 	Cộng tác viên : <span style="color:#ff3d00e8" >${not empty  phatVay.congTacVien ? phatVay.congTacVien.hoTen : ''}</span>
				 	<br/>
				 	<span class="note-span">(Mã : ${phatVay.maCTV})</span>
				 </liferay-ui:search-container-column-text>
				 <liferay-ui:search-container-column-text name="Thông tin lãi suất"  cssClass="aui-w25">
		 			Lãi ngày : <span style="font-style: italic;color:blue;">${phatVay.laiNgay > 0 ? df.format(phatVay.laiNgay) : '0'}</span>
				 	<br/>
				 	Gốc ngày : <span style="font-style: italic;color:blue;">${phatVay.gocNgay > 0 ? df.format(phatVay.gocNgay) : '0'}</span>
				 	<br/>
				 	Gốc ngày cuối : <span style="font-style: italic;color:blue;">${phatVay.gocNgayCuoi > 0 ? df.format(phatVay.gocNgayCuoi) : '0'}</span>
				 	<br/>
				 	Dư nợ gốc còn : <span style="font-style: italic;color:blue;">${phatVay.duNoGoc > 0 ? df.format(phatVay.duNoGoc) : '0'}</span>
				 	<br/>
				 	Số ngày đã thu : <span style="font-style: italic;color:blue;"><%=soLanDaThuStr %></span>
				 </liferay-ui:search-container-column-text>
				 <%
				 	Double traLai = (phatVay.getThoiHan()  - (phatVay.getSoLanDaThu() + phatVay.getSoNgayThuTruoc())) * phatVay.getLaiNgay();
				 %>
				 
				 <liferay-ui:search-container-column-text name="Thông tin tất toán" cssClass="aui-w20" orderable="true"  orderableProperty="soLanDaThu">
					 Trả vốn : <span style="font-style: italic;color:#ff3d00e8;">${phatVay.duNoGoc > 0 ? df.format(phatVay.duNoGoc) : '0'}</span>
					 <br/>
				 	Trả lãi : <span style="font-style: italic;color:#ff3d00e8;"><%=traLai > 0 ? df.format(traLai) : "0" %></span>
				 </liferay-ui:search-container-column-text>
			 </liferay-ui:search-container-row >
			 <liferay-ui:search-iterator />
		</liferay-ui:search-container >
</aui:form>
<aui:script use="aui-base,aui-io-plugin-deprecated,aui-loading-mask-deprecated,liferay-util-list-fields">
AUI().ready(['aui-base'], function(A) {
	Liferay.Data.redirectURL = '${iteratorURL}';
	var recordSearchContainer = A.one('#<portlet:namespace />contentDataTableLichSu');
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
