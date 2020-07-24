<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="quanly.portlet.phatvay.phatvay.PhatVayChecker"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="quanly.portlet.phatvay.phatvay.PhatVayComparator"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.mb.model.PhatVay"%>
<%@page import="java.util.Date"%>
<%@page import="com.mb.service.PhatVayLocalServiceUtil"%>
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
	String maCTVSearch = ParamUtil.getString(request, "maCTVSearch");
	String maKhachHangSearch = ParamUtil.getString(request, "maKhachHangSearch");
	long ngayBatDauTuSearchTime = ParamUtil.getLong(request, "ngayBatDauTuSearch");
	long ngayBatDauDenSearchTime = ParamUtil.getLong(request, "ngayBatDauDenSearch");
	String thanhToanSearch = ParamUtil.getString(request, "thanhToanSearch");
	Date ngayBatDauTu = ngayBatDauTuSearchTime != 0 ? new Date(ngayBatDauTuSearchTime) : null;
	Date ngayBatDauDen = ngayBatDauDenSearchTime != 0 ? new Date(ngayBatDauDenSearchTime) : null;
	int count = PhatVayLocalServiceUtil.countBase(soKUSearch, maCTVSearch, maKhachHangSearch,null,null, ngayBatDauTu, ngayBatDauDen,null,null, thanhToanSearch);
	DecimalFormat df = new DecimalFormat("###,###.###");
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
%>
<c:set value="<%=df %>" var="df"/>
<c:set value="<%=sdf %>" var="sdf"/>
<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="soKUSearch" value="<%= String.valueOf(soKUSearch) %>" />
	<portlet:param name="maCTVSearch" value="<%= String.valueOf(maCTVSearch) %>" />
	<portlet:param name="maKhachHangSearch" value="<%= String.valueOf(maKhachHangSearch) %>" />
	<portlet:param name="ngayBatDauTuSearch" value="<%= String.valueOf(ngayBatDauTuSearchTime)%>" />
	<portlet:param name="ngayBatDauDenSearch" value="<%= String.valueOf(ngayBatDauDenSearchTime)%>" />
	<portlet:param name="thanhToanSearch" value="<%= thanhToanSearch%>" />
	<portlet:param name="mvcPath" value="/html/phatvay/phatvay/data.jsp" />
</liferay-portlet:renderURL>
<aui:form name="fm" method="post" style="width: max-content;min-width: 100%;">
	<div style="text-align: right;"><span class="note-span">(Đơn vị : VND)</span></div>
	<button id="<portlet:namespace />tatToanBtn" type="button" class="btn btn-labeled btn-danger hide" onclick="tatToan();" 
		<span class="btn-label"><i class="glyphicon glyphicon-piggy-bank"></i></span> Tất toán
	</button>
	<liferay-ui:search-container  delta="20"  emptyResultsMessage="Không có kết quả nào được tìm thấy!" iteratorURL="<%=iteratorURL %>" total="<%=count %>">
		 <%
		 	String orderByType = ParamUtil.getString(request, "orderByType"); 
		 	String orderByCol = ParamUtil.getString(request, "orderByCol"); 
		 	if(Validator.isNull(orderByType)){
		 		orderByType = "desc";
		 	}
		 	if(Validator.isNull(orderByCol)){
		 		orderByCol = "createDate";
		 	}
		 	boolean ascending = false;
		 	if("asc".equals(orderByType)){
		 		ascending = true;
		 	}
		 	PhatVayComparator obc = new PhatVayComparator(orderByCol,ascending);
		 	searchContainer.setOrderByCol(orderByCol);
		 	searchContainer.setOrderByType(orderByType);
		 	searchContainer.setOrderByComparator(obc);
		 
			List<PhatVay> items =  PhatVayLocalServiceUtil.findBase(soKUSearch, maCTVSearch, maKhachHangSearch,null,null, ngayBatDauTu, ngayBatDauDen, null,null,thanhToanSearch, searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
	 %>
		 <liferay-ui:search-container-results results="<%= items %>" />
		 <liferay-ui:search-container-row className="com.mb.model.PhatVay" modelVar="phatVay" keyProperty="phatVayId"> 
			<portlet:renderURL var="editURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
				<portlet:param name="mvcPath" value="/html/phatvay/phatvay/add.jsp" />
				<portlet:param name="phatVayId" value="<%=String.valueOf(phatVay.getPhatVayId())%>" />
				<portlet:param name="dialogId" value="dialogAdd" />
			</portlet:renderURL>
			<portlet:resourceURL var="xoaURL" id="xoaURL">
				<portlet:param name="phatVayId" value="<%=String.valueOf(phatVay.getPhatVayId())%>" />
			</portlet:resourceURL>
				<%
					String editAction = "openDialogEdit('" + editURL + "');";
					String xoaAction = "xoaAction('" + xoaURL + "');";
					String soLanDaThuStr = String.valueOf(phatVay.getSoLanDaThu());
					if(phatVay.getTrangThai() == 4){
						soLanDaThuStr =  String.valueOf(phatVay.getSoLanDaThu() + phatVay.getSoNgayThuTruoc()) + " (Thu trước " + phatVay.getSoNgayThuTruoc() + " Ngày)";
					}
			 	%>
		 	 <liferay-ui:search-container-column-text name="Thông tin khách hàng"  orderable="true" orderableProperty="soKU">
		 	 	Số KU : <span style="color:#ff3d00e8" >${phatVay.soKU}</span>
			 	<br/>
			 	Khách hàng : <span style="color:#ff3d00e8" >${not empty  phatVay.khachHang ? phatVay.khachHang.hoTen : ''}</span>
			 	<br/>
			 	<span class="note-span">(Mã : ${phatVay.maKhachHang})</span>
			 	<br/>
			 	Cộng tác viên : <span style="color:#ff3d00e8" >${not empty  phatVay.congTacVien ? phatVay.congTacVien.hoTen : ''}</span>
			 	<br/>
			 	<span class="note-span">(Mã : ${phatVay.maCTV})</span>
			 </liferay-ui:search-container-column-text>
			 <liferay-ui:search-container-column-text cssClass="aui-w15" name="Thông tin phát vay" orderable="true"  orderableProperty="soTienVay">
		  		Số tiền vay : <span style="color: #108dfb;" >${phatVay.soTienVay > 0 ? df.format(phatVay.soTienVay) : '0'}</span>
			 	<br/>
			 	Thời hạn : <span style="color: #108dfb;">${phatVay.thoiHan}</span><span class="note-span"> ngày</span>
			 	<br/>
			 	Loại phát vay : <span style="color: #108dfb;">${phatVay.loaiPhatVay == 1 ? 'Thế chấp' :  'Tín chấp'}</span>
			 	<br/>
			 	<span class="note-span">(</span><span class="note-span" style="color:blue" >Lãi suất :  ${phatVay.laiSuatVay}%</span><span class="note-span">)</span>
			 </liferay-ui:search-container-column-text>
			 <liferay-ui:search-container-column-text name="Thông tin lãi suất"  cssClass="aui-w15">
	 			Lãi ngày : <span style="font-style: italic;color:#ff3d00e8;">${phatVay.laiNgay > 0 ? df.format(phatVay.laiNgay) : '0'}</span>
			 	<br/>
			 	Gốc ngày : <span style="font-style: italic;color:#ff3d00e8;">${phatVay.gocNgay > 0 ? df.format(phatVay.gocNgay) : '0'}</span>
			 	<br/>
			 	Gốc ngày cuối : <span style="font-style: italic;color:#ff3d00e8;">${phatVay.gocNgayCuoi > 0 ? df.format(phatVay.gocNgayCuoi) : '0'}</span>
			 </liferay-ui:search-container-column-text>
			 <liferay-ui:search-container-column-text name="Thông tin thu lãi" cssClass="aui-w20" orderable="true"  orderableProperty="soLanDaThu">
			 	Số ngày đã thu : <span style="font-style: italic;color:#108dfb;"><%=soLanDaThuStr %></span>
			 	<br/>
			 	<%
			 		if(phatVay.getTrangThai() == 4 && phatVay.getNgayThuTruocTu() != null && phatVay.getNgayThuTruocDen() != null){
			 	%>
				 	Ngày tết đã thu trước : <span style="font-style: italic;color:#108dfb;"><%=sdf.format(phatVay.getNgayThuTruocTu()) + " - " + sdf.format(phatVay.getNgayThuTruocDen()) %></span>
				 	<br/>
			 	<%
			 		}
			 	%>
			 	Số tiền thu ngày : <span style="font-style: italic;color:#108dfb;">${phatVay.soTienThuNgay > 0 ? df.format(phatVay.soTienThuNgay) : '0'}</span>
				<br/>
				Dư nợ gốc còn : <span style="font-style: italic;color:#ff3d00e8;">${phatVay.duNoGoc > 0 ? df.format(phatVay.duNoGoc) : '0'}</span>
			 </liferay-ui:search-container-column-text>
			  <liferay-ui:search-container-column-text cssClass="aui-w14" name="Thời gian" orderable="true" orderableProperty="ngayBatDau">
				  Ngày vay : <span style="font-style: italic;color: #108dfb;">${not empty phatVay.createDate ? sdf.format(phatVay.createDate) : ''}</span>
				  <br/>
				  Ngày bắt đầu : <span style="font-style: italic;color: #108dfb;">${not empty phatVay.ngayBatDau ? sdf.format(phatVay.ngayBatDau) : ''}</span>
				  <br/>
				  Ngày kết thúc : <span style="font-style: italic;color: #108dfb;">${not empty phatVay.ngayKetThuc ? sdf.format(phatVay.ngayKetThuc) : ''}</span>
				  <br/>
				  Đã thu : <span style="font-style: italic;color: #ff3d00e8;">${not empty phatVay.ngayDaThuCuoi ? sdf.format(phatVay.ngayDaThuCuoi) : ''}</span>
			 </liferay-ui:search-container-column-text>
			 <liferay-ui:search-container-column-text cssClass="aui-w8 text-center" name="Thanh toán">
			 	<%
			 		String styleThanhToan = "";
			 		String tenTrangThaiPhatVay = "";
			 		if(phatVay.getTrangThai() == 1){
			 			tenTrangThaiPhatVay = "Chưa thanh toán";
			 			styleThanhToan = "text-shadow: 3px 3px 5px #ff630b;font-weight: bold;color: black;";
			 		}else if(phatVay.getTrangThai() == 2){
			 			tenTrangThaiPhatVay = "Đã thanh toán";
			 			styleThanhToan = "text-shadow: 3px 3px 5px #1a8ac8;font-weight: bold;color: #1a8ac8;";
			 		}else if(phatVay.getTrangThai() == 3){
			 			tenTrangThaiPhatVay = "Đã tất toán";
			 			styleThanhToan = "text-shadow: 3px 3px 5px #1a8ac8;font-weight: bold;color: #ff630b;";
			 		}else if(phatVay.getTrangThai() == 4){
			 			tenTrangThaiPhatVay = "Có thu trước tết";
			 			styleThanhToan = "text-shadow: 3px 3px 5px #1a8ac8;font-weight: bold;color: #108dfb;";
			 		}
			 	%>
			 	<a href="javascript:void(0);" style="text-decoration: none" title="<%=tenTrangThaiPhatVay %>" width="35" height="35">
			 		<span style="<%=styleThanhToan%>"><%=tenTrangThaiPhatVay %></span>
			 	</a>
			 </liferay-ui:search-container-column-text>
			  <liferay-ui:search-container-column-text name="Thao tác" cssClass="aui-w8">
			 	<a href="javascript:void(0);" onclick="<%=editAction %>" title="Sửa" width="35" height="35">
			 		<span style="color:#ff3d00e8"><i class="glyphicon glyphicon-edit"></i></span>
			 	</a>
			 	<a href="javascript:void(0);" onclick="<%=xoaAction %>" title="Xóa">
			 		<span style="color:#ff3d00e8"><i class="glyphicon glyphicon-trash"></i></span>
			 	</a>
			 </liferay-ui:search-container-column-text>
		 </liferay-ui:search-container-row >
		 <liferay-ui:search-iterator />
	</liferay-ui:search-container >
</aui:form>
<aui:script use="aui-base,aui-io-plugin-deprecated,aui-loading-mask-deprecated,liferay-util-list-fields">
AUI().ready(['aui-base'], function(A) {
	Liferay.Data.redirectURL = '${iteratorURL}';
	var recordSearchContainer = A.one('#<portlet:namespace />contentDataTable');
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
	Liferay.provide(window,'xoaAction', function(url){
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
                   					toastr.success('Đã xóa phát vay thành công', 'Thông báo!');
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
