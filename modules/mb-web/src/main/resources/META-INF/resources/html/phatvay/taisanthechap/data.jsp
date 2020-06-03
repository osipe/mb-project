<%@page import="com.mb.model.PhatVay"%>
<%@page import="quanly.portlet.phatvay.taisanthechap.TaiSanTheChapComparator"%>
<%@page import="com.mb.model.TaiSanThueChap"%>
<%@page import="com.mb.service.TaiSanThueChapLocalServiceUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/danhmuc/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%	
	String soKUSearch = ParamUtil.getString(request, "soKUSearch");
	String maKhachHangSearch = ParamUtil.getString(request, "maKhachHangSearch");
	String tenSearch = ParamUtil.getString(request, "tenSearch");
	long loaiTaSanSearch = ParamUtil.getLong(request, "loaiTaSanSearch");
	int count = TaiSanThueChapLocalServiceUtil.countBase(soKUSearch, tenSearch, maKhachHangSearch, loaiTaSanSearch);
	DecimalFormat df = new DecimalFormat("###,###.###");
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
%>
<c:set value="<%=df %>" var="df"/>
<c:set value="<%=sdf %>" var="sdf"/>
<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="soKUSearch" value="<%= String.valueOf(soKUSearch) %>" />
	<portlet:param name="maKhachHangSearch" value="<%= String.valueOf(maKhachHangSearch) %>" />
	<portlet:param name="tenSearch" value="<%= String.valueOf(tenSearch)%>" />
	<portlet:param name="loaiTaSanSearch" value="<%= String.valueOf(loaiTaSanSearch)%>" />
	<portlet:param name="mvcPath" value="/html/phatvay/taisanthechap/data.jsp" />
</liferay-portlet:renderURL>
<div id="<portlet:namespace />recordSearchContainer">
	<div style="text-align: right;"><span class="note-span">(Đơn vị : VND)</span></div>
	<liferay-ui:search-container  delta="10"  emptyResultsMessage="Không có kết quả nào được tìm thấy!" iteratorURL="<%=iteratorURL %>" total="<%=count %>" >
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
		 	TaiSanTheChapComparator obc = new TaiSanTheChapComparator(orderByCol,ascending);
		 	searchContainer.setOrderByCol(orderByCol);
		 	searchContainer.setOrderByType(orderByType);
		 	searchContainer.setOrderByComparator(obc);
			List<TaiSanThueChap> items =  TaiSanThueChapLocalServiceUtil.findBase(soKUSearch, tenSearch, maKhachHangSearch, loaiTaSanSearch, searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
		 %>
		 <liferay-ui:search-container-results results="<%= items %>" />
		 <liferay-ui:search-container-row className="com.mb.model.TaiSanThueChap" modelVar="taiSanTheChap" keyProperty="taiSanTheChapId" > 
		 	 <liferay-ui:search-container-column-text cssClass="aui-w10" name="Số KU"  orderable="true" orderableProperty="soKU">
		 	 	<span style="color:#108dfb" >${taiSanTheChap.soKU}</span>
			 </liferay-ui:search-container-column-text>
			 <liferay-ui:search-container-column-text cssClass="aui-w15" name="Tên khách hàng">
			 	<span style="color:#ff3d00e8" >${taiSanTheChap.khachHang.hoTen}</span>
			 </liferay-ui:search-container-column-text>
			 <liferay-ui:search-container-column-text cssClass="aui-w15" name="Tên tài sản"  orderable="true" orderableProperty="ten">
			 	<span style="color:#108dfb" >${taiSanTheChap.ten}</span>
			 </liferay-ui:search-container-column-text>
			 <liferay-ui:search-container-column-text cssClass="aui-w10" name="Giá trị tài sản"  orderable="true" orderableProperty="giaTriTaiSan">
			 	<span style="color:#ff3d00e8" >${taiSanTheChap.giaTriTaiSan > 0 ? df.format(taiSanTheChap.giaTriTaiSan) : ''}</span></span><span class="note-span"> VND</span>
			 </liferay-ui:search-container-column-text>
			  <liferay-ui:search-container-column-text cssClass="aui-w15" name="Thông tin tài sản">
			 	<span >${taiSanTheChap.thongTinTaiSan}</span>
			 </liferay-ui:search-container-column-text>
			  <liferay-ui:search-container-column-text name="Ghi chú"  orderable="true" orderableProperty="soKU">
			  	${taiSanTheChap.ghiChu}
			 </liferay-ui:search-container-column-text>
			 	 <liferay-ui:search-container-column-text cssClass="aui-w8 text-center" name="Thanh toán">
			 	<%
			 		String styleThanhToan = "";
			 		String tenTrangThaiPhatVay = "";
			 		PhatVay phatVay = taiSanTheChap.getPhatVay();
					if(phatVay != null){
						if(phatVay.getTrangThai() == 1){
				 			tenTrangThaiPhatVay = "Chưa thanh toán";
				 			styleThanhToan = "text-shadow: 3px 3px 5px #ff630b;font-weight: bold;color: black;";
				 		}else if(phatVay.getTrangThai() == 2){
				 			tenTrangThaiPhatVay = "Đã thanh toán";
				 			styleThanhToan = "text-shadow: 3px 3px 5px #1a8ac8;font-weight: bold;color: #1a8ac8;";
				 		}else if(phatVay.getTrangThai() == 3){
				 			tenTrangThaiPhatVay = "Đã tất toán";
				 			styleThanhToan = "text-shadow: 3px 3px 5px #1a8ac8;font-weight: bold;color: #ff630b;";
				 		}
			 		}
			 	%>
			 	<a href="javascript:void(0);" style="text-decoration: none" title="<%=tenTrangThaiPhatVay %>" width="35" height="35">
			 		<span style="<%=styleThanhToan%>"><%=tenTrangThaiPhatVay %></span>
			 	</a>
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
	Liferay.provide(window,'openDialogEdit', function(url){
		Liferay.Util.openWindow({
			dialog : {
				centered : true,
				height : 800,
				modal : true,
				width : 1300
			},
			id : '<portlet:namespace />dialogAdd',
			title : 'Sửa thông tin phát vay',
			uri : url
		});
	});
});	
</aui:script>
