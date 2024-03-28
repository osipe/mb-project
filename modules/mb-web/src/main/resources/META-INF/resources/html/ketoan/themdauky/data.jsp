<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="quanly.portlet.ketoan.themdauky.LichSuTaiKhoanDauComparator"%>
<%@page import="com.mb.service.TaiKhoanDoiUngLocalServiceUtil"%>
<%@page import="com.mb.model.TaiKhoanDoiUng"%>
<%@page import="com.mb.model.LichSuTaiKhoanDauKy"%>
<%@page import="com.mb.service.LichSuTaiKhoanDauKyLocalServiceUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/ketoan/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	int namSearch = ParamUtil.getInteger(request, "namSearch");
	long taiKhoanDoiUngIdSearch = ParamUtil.getLong(request, "taiKhoanDoiUngIdSearch");
	Locale localeEn = new Locale("en", "EN");
    NumberFormat df = NumberFormat.getInstance(localeEn);
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	int count = LichSuTaiKhoanDauKyLocalServiceUtil.countBase(namSearch,0,taiKhoanDoiUngIdSearch);
%>
<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="namSearch" value="<%= String.valueOf(namSearch) %>" />
	<portlet:param name="taiKhoanDoiUngIdSearch" value="<%= String.valueOf(taiKhoanDoiUngIdSearch)%>" />
	<portlet:param name="mvcPath" value="/html/ketoan/themdauky/data.jsp" />
</liferay-portlet:renderURL>
<portlet:resourceURL var="xoaDauKyURL" id="xoaDauKyURL">
</portlet:resourceURL>
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
		 		orderByCol = "modifiedDate";
		 	}
		 	boolean ascending = true;
		 	if("desc".equals(orderByType)){
		 		ascending = false;
		 	}
		 	LichSuTaiKhoanDauComparator obc = new LichSuTaiKhoanDauComparator(orderByCol,ascending);
		 	searchContainer.setOrderByCol(orderByCol);
		 	searchContainer.setOrderByType(orderByType);
		 	searchContainer.setOrderByComparator(obc);
		 
			List<LichSuTaiKhoanDauKy> items = LichSuTaiKhoanDauKyLocalServiceUtil.findBase(namSearch,0,taiKhoanDoiUngIdSearch, searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
		 %>
		 <liferay-ui:search-container-results results="<%= items %>" />
		 <liferay-ui:search-container-row className="com.mb.model.LichSuTaiKhoanDauKy" modelVar="lichSuTaiKhoanDauKy" keyProperty="lichSuTaiKhoanDauKyId" > 
			<portlet:renderURL var="editURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
				<portlet:param name="mvcPath" value="/html/ketoan/themdauky/add.jsp" />
				<portlet:param name="lichSuTaiKhoanDauKyId" value="<%=String.valueOf(lichSuTaiKhoanDauKy.getLichSuTaiKhoanDauKyId())%>" />
			</portlet:renderURL>
				<%
					String editAction = "openDialogEdit('" + editURL + "');";
					String xoaDauKyAction =  "xoaDauKy('" + lichSuTaiKhoanDauKy.getLichSuTaiKhoanDauKyId() + "');";
					TaiKhoanDoiUng tkdu = TaiKhoanDoiUngLocalServiceUtil.fetchTaiKhoanDoiUng(lichSuTaiKhoanDauKy.getTaiKhoanDoiUngId());
			 	%>
			 <liferay-ui:search-container-column-text cssClass="aui-w10 text-center" name="Tên tài khoản đối ứng">
			 	<%=tkdu != null ? tkdu.getTen() : ""%>
			 </liferay-ui:search-container-column-text>
			  <liferay-ui:search-container-column-text cssClass="aui-w10 text-center" name="Tháng" orderable="true" orderableProperty="thang">
			 	<%=lichSuTaiKhoanDauKy.getThang()%>
			 </liferay-ui:search-container-column-text>
			  <liferay-ui:search-container-column-text cssClass="aui-w10 text-center" name="Năm" orderable="true" orderableProperty="nam">
			 	<%=lichSuTaiKhoanDauKy.getNam()%>
			 </liferay-ui:search-container-column-text>
			   <liferay-ui:search-container-column-text cssClass="aui-w10 text-center" name="Số tiền">
			 	<%=lichSuTaiKhoanDauKy.getSoTienTon() != null ? df.format(lichSuTaiKhoanDauKy.getSoTienTon()) : ""%>
			 </liferay-ui:search-container-column-text>
			  <liferay-ui:search-container-column-text name="Thao tác" cssClass="aui-w10 text-center">
			 	<a href="javascript:void(0);" onclick="<%=editAction %>" title="Sửa">
			 		<span style="color:#ff3d00e8"><i class="glyphicon glyphicon-edit"></i></span>
			 	</a>
			 	<a href="javascript:void(0);" onclick="<%=xoaDauKyAction %>" title="Xóa"><i class="glyphicon glyphicon-trash"></i></a>
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
	Liferay.provide(window,'openDialogEdit', function(url){
		Liferay.Util.openWindow({
			dialog : {
				centered : true,
				height : 600,
				modal : true,
				width : 700
			},
			id : '<portlet:namespace />dialogAdd',
			title : 'Sửa dữ liệu đầu kỳ',
			uri : url
		});
	});
	Liferay.provide(window,'xoaDauKy', function(lichSuTaiKhoanDauKyId){
		loadingMask.show();
			var data = {
				'<portlet:namespace />lichSuTaiKhoanDauKyId' : lichSuTaiKhoanDauKyId,
			}
			A.io.request('${xoaDauKyURL}', {
	               method: 'post',
	               data : data,
	               on: {
	                   success: function() {
	                   		if(this.get('responseData')){
	                   			var data = JSON.parse(this.get('responseData'));
	                   			if(!data.exception){
	                   				toastr.success('Yêu cầu thực hiện thành công');
	                   				pageIO.set('uri', '${iteratorURL}');
    								pageIO.start();
	                   			}else{
                   					toastr.error('Yêu cầu thực hiện không thành công', 'Lỗi!');
	                   			}
	                   		}
	                   }
	              }
	        });
        loadingMask.hide();
	});
});	
</aui:script>