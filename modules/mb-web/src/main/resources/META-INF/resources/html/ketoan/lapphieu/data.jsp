<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="quanly.portlet.danhmuc.ctv.CongTacVienComparator"%>
<%@page import="com.mb.service.CongTacVienLocalServiceUtil"%>
<%@page import="com.mb.model.CongTacVien"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.apache.commons.collections.CollectionUtils"%>
<%@page import="com.mb.service.DsPhieuTaiKhoanLocalServiceUtil"%>
<%@page import="com.mb.model.DsPhieuTaiKhoan"%>
<%@page import="com.mb.model.Phieu"%>
<%@page import="quanly.portlet.ketoan.lapphieu.PhieuComparator"%>
<%@page import="com.mb.service.PhieuLocalServiceUtil"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/ketoan/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String maCTVSearch = ParamUtil.getString(request, "maCTVSearch");
	int loaiSearch = ParamUtil.getInteger(request, "loaiSearch");
	String maMSThuChiSearch = ParamUtil.getString(request, "maMSThuChiSearch");
	String soPhieuSearch = ParamUtil.getString(request, "soPhieuSearch");
	long ngayChungTuTuSearchTime = ParamUtil.getLong(request, "ngayChungTuTuSearch");
	Date ngayChungTuTuSearch =  ngayChungTuTuSearchTime != 0 ?  new Date(ngayChungTuTuSearchTime) : null;
	long ngayChungTuDenSearchTime = ParamUtil.getLong(request, "ngayChungTuDenSearch");
	Date ngayChungTuDenSearch =  ngayChungTuDenSearchTime != 0 ? new Date(ngayChungTuDenSearchTime) : null;
	int hoatDongSearch = ParamUtil.getInteger(request, "hoatDongSearch");
	Locale localeEn = new Locale("en", "EN");
    NumberFormat df = NumberFormat.getInstance(localeEn);
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	int count = CongTacVienLocalServiceUtil.countBase(maCTVSearch, "", "", "", 1);
%>
<c:set var="df" value="<%=df %>" />
<c:set var="sdf" value="<%=sdf %>" />
<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="maCTVSearch" value="<%= maCTVSearch %>" />
	<portlet:param name="loaiSearch"
		value="<%= String.valueOf(loaiSearch) %>" />
	<portlet:param name="maMSThuChiSearch" value="<%= maMSThuChiSearch%>" />
	<portlet:param name="soPhieuSearch" value="<%= soPhieuSearch%>" />
	<portlet:param name="ngayChungTuTuSearch"
		value="<%= String.valueOf(ngayChungTuTuSearchTime)%>" />
	<portlet:param name="ngayChungTuDenSearch"
		value="<%= String.valueOf(ngayChungTuDenSearchTime)%>" />
	<portlet:param name="hoatDongSearch"
		value="<%= String.valueOf(hoatDongSearch)%>" />
	<portlet:param name="mvcPath" value="/html/ketoan/lapphieu/data.jsp" />
</liferay-portlet:renderURL>
<div id="<portlet:namespace />recordSearchContainer">
	<div style="text-align: right;">
		<span class="note-span">(Đơn vị : VND)</span>
	</div>
	<liferay-ui:search-container delta="30"
		emptyResultsMessage="Không có kết quả nào được tìm thấy!"
		iteratorURL="<%=iteratorURL %>" total="<%=count %>">
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
			List<CongTacVien> items = CongTacVienLocalServiceUtil.findBase(maCTVSearch, "", "", "", 1, searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
		 %>
		<liferay-ui:search-container-results results="<%= items %>" />
		<liferay-ui:search-container-row className="com.mb.model.CongTacVien"
			modelVar="congTacVien" keyProperty="congTacVienId" indexVar="index">
			<%
				PhieuComparator obcPhieu = new PhieuComparator("createdate",false);
				List<Phieu> phieus = PhieuLocalServiceUtil.findBase(congTacVien.getMa(), maMSThuChiSearch, soPhieuSearch, ngayChungTuTuSearch, ngayChungTuDenSearch, loaiSearch, hoatDongSearch, -1, -1, obcPhieu);
			%>
			<liferay-ui:search-container-column-text cssClass="text-center"
				name="Cộng tác viên">
				<span style="color: #ff3d00e8; font-weight: bold;"><%=congTacVien.getHoTen()%></span>
				<%
			 		for(Phieu item : phieus){
			 	%>
				<br />
				<span style="font-style: italic;"><%=item.getMaMSThuChi() + "-" + item.getSoPhieu() %></span>
				<%
			 		}
			 	%>
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text name="Diễn giải">
				<span style="color: #ff3d00e8; font-weight: bold;"> </span>
				<%
			 		for(Phieu item : phieus){
			 	%>
				<br />
				<span style="font-style: italic;"><%=item.getMaSoThuChi() != null ? item.getMaSoThuChi().getDienGiai() : "" %>
				</span>
				<%
			 		}
			 	%>
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text cssClass="text-center"
				name="Loại Phiếu">
				<span style="color: #ff3d00e8; font-weight: bold;"> </span>
				<%
			 		for(Phieu item : phieus){
			 	%>
				<br />
				<span style="font-style: italic;"><%=item.getLoai() == 1 ? "Thu" : "Chi"%>
				</span>
				<%
			 		}
			 	%>
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text cssClass="text-center"
				name="Số tiền">
				<span style="color: #ff3d00e8; font-weight: bold;"> </span>
				<%
			 		for(Phieu item : phieus){
			 	%>
				<br />
				<span style="font-style: italic;"><%=item.getSoTien() > 0 ? df.format(item.getSoTien()) : "0"%>
				</span>
				<%
			 		}
			 	%>
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text cssClass="text-center"
				name="Ngày chứng từ">
				<span style="color: #ff3d00e8; font-weight: bold;"> </span>
				<%
			 		for(Phieu item : phieus){
			 	%>
				<br />
				<span style="font-style: italic;"><%=item.getNgayChungTu() != null ? sdf.format(item.getNgayChungTu()) : ""%>
				</span>
				<%
			 		}
			 	%>
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text name="Thao tác"
				cssClass="aui-w10 text-center">
				<span style="color: #ff3d00e8; font-weight: bold;"> </span>
				<%
			 		for(Phieu item : phieus){
			 	%>
				<portlet:renderURL var="editURL"
					windowState="<%=LiferayWindowState.POP_UP.toString()%>">
					<portlet:param name="mvcPath" value="/html/ketoan/lapphieu/add.jsp" />
					<portlet:param name="loai"
						value="<%=String.valueOf(item.getLoai())%>" />
					<portlet:param name="phieuId"
						value="<%=String.valueOf(item.getPhieuId())%>" />
				</portlet:renderURL>
				<portlet:resourceURL var="hoatDongURL" id="hoatDongURL">
					<portlet:param name="phieuId"
						value="<%=String.valueOf(item.getPhieuId())%>" />
				</portlet:resourceURL>
				<%
						String editAction = "openDialogEdit('" + editURL + "');";
						String hoatDongAction = "hoatDong('" + hoatDongURL + "');";
						String printAction = "printPhieu('" + item.getPhieuId() + "');";
					%>
				<br />
				<a href="javascript:void(0);" onclick="<%=editAction %>" title="Sửa">
					<span style="color: #ff3d00e8"><i
						class="glyphicon glyphicon-edit"></i></span>
				</a>
				<a href="javascript:void(0);" onclick="<%=hoatDongAction %>"
					title='<%=item.getHoatDong() ? "Ngưng hoạt động" : "Hoạt động" %>'>
					<span
					style='<%=item.getHoatDong() ? "color:#ff3d00e8" :  "color:blue"%>'><i
						class='<%=item.getHoatDong() ? "glyphicon glyphicon-off" : "glyphicon glyphicon-play-circle"%>'></i></span>
				</a>
				<a href="javascript:void(0);" style="color:blue" onclick="<%=printAction %>"
					title='In phiếu'> <span><i
						class='glyphicon glyphicon-print'></i></span>
				</a>
				<%
			 		}
			 	%>
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</div>
<portlet:resourceURL var="printPhieu" id="printPhieuThuChi"></portlet:resourceURL>
<aui:script
	use="aui-base,aui-io-plugin-deprecated,aui-loading-mask-deprecated">
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
  	Liferay.provide(window,'printPhieu', function(phieuId){
		var url = '${printPhieu}';
		url += '&<portlet:namespace />phieuId=' + phieuId;	
		window.location.href = url;
	});
	Liferay.provide(window,'openDialogEdit', function(url){
		Liferay.Util.openWindow({
			dialog : {
				centered : true,
				height : 1000,
				modal : true,
				width : 1200
			},
			id : '<portlet:namespace />dialogAdd',
			title : 'Sửa thông tin phiếu',
			uri : url
		});
	});
	Liferay.provide(window,'hoatDong', function(url){
		loadingMask.show();
  		if(confirm('Bạn có chắc thực hiện thao tác này?')){
  			A.io.request(url, {
               method: 'post',
               on: {
                   success: function() {
                   		if(this.get('responseData')){
                   			var data = JSON.parse(this.get('responseData'));
                   			if(!data.exception){
                   					search();
                   					toastr.success('Thao tác thành công', 'Thông báo!');
                   			}else{
                   					toastr.error('Yêu cầu thực hiện không thành công', 'Cảnh báo!');
                   			}
                   		}
                   },
                   failure : function() {
					}
              }
        	});
  		}
        loadingMask.hide();
	});
});	
</aui:script>