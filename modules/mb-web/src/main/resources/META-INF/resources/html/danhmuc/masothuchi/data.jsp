<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="com.mb.model.MaSoThuChi"%>
<%@page import="quanly.portlet.danhmuc.masothuchi.MaSoThuChiComparator"%>
<%@page import="com.mb.service.MaSoThuChiLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/danhmuc/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String maSearch = ParamUtil.getString(request, "maSearch");
	String dienGiaiSearch = ParamUtil.getString(request, "dienGiaiSearch");
	int loaiSearch = ParamUtil.getInteger(request, "loaiSearch");
	int hoatDongSearch = ParamUtil.getInteger(request, "hoatDongSearch");
	int count = MaSoThuChiLocalServiceUtil.countBase(maSearch, dienGiaiSearch, loaiSearch, hoatDongSearch);
	Locale localeEn = new Locale("en", "EN");
    NumberFormat df = NumberFormat.getInstance(localeEn);
%>
<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="maSearch" value="<%= maSearch %>" />
	<portlet:param name="dienGiaiSearch" value="<%= dienGiaiSearch %>" />
	<portlet:param name="loaiSearch" value="<%= String.valueOf(loaiSearch) %>" />
	<portlet:param name="hoatDongSearch" value="<%= String.valueOf(hoatDongSearch)%>" />
	<portlet:param name="mvcPath" value="/html/danhmuc/masothuchi/data.jsp" />
</liferay-portlet:renderURL>
<div id="<portlet:namespace />recordSearchContainer">
	<liferay-ui:search-container  delta="20"  emptyResultsMessage="Không có kết quả nào được tìm thấy!" iteratorURL="<%=iteratorURL %>" total="<%=count %>" >
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
		 	MaSoThuChiComparator obc = new MaSoThuChiComparator(orderByCol,ascending);
		 	searchContainer.setOrderByCol(orderByCol);
		 	searchContainer.setOrderByType(orderByType);
		 	searchContainer.setOrderByComparator(obc);
		 
			List<MaSoThuChi> items = MaSoThuChiLocalServiceUtil.findBase(maSearch, dienGiaiSearch, loaiSearch, hoatDongSearch, searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
		 %>
		 <liferay-ui:search-container-results results="<%= items %>" />
		 <liferay-ui:search-container-row className="com.mb.model.MaSoThuChi" modelVar="maSoThuChi" keyProperty="maSoThuChiId" > 
			<portlet:renderURL var="editURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
				<portlet:param name="mvcPath" value="/html/danhmuc/masothuchi/add.jsp" />
				<portlet:param name="maSoThuChiId" value="<%=String.valueOf(maSoThuChi.getMaSoThuChiId())%>" />
			</portlet:renderURL>
			<portlet:resourceURL var="hoatDongURL" id="hoatDongURL">
				<portlet:param name="maSoThuChiId" value="<%=String.valueOf(maSoThuChi.getMaSoThuChiId())%>" />
			</portlet:resourceURL>
				<%
					String editAction = "openDialogEdit('" + editURL + "');";
					String hoatDongAction = "hoatDong('" + hoatDongURL + "');";
			 	%>
			 <liferay-ui:search-container-column-text cssClass="text-center" name="Mã số" value="${maSoThuChi.ma}" orderable="true" orderableProperty="ma"/>
			 <liferay-ui:search-container-column-text cssClass="text-center" name="Loại" value="${maSoThuChi.loai == 1 ? 'Thu' : 'Chi'}"/> 
			 <liferay-ui:search-container-column-text cssClass="text-center" name="Diễn giải" value="${maSoThuChi.dienGiai}" orderable="true" orderableProperty="dienGiai"/> 
			  <liferay-ui:search-container-column-text name="Thao tác" cssClass="aui-w10 text-center">
			 	<a href="javascript:void(0);" onclick="<%=editAction %>" title="Sửa">
			 		<span style="color:#ff3d00e8"><i class="glyphicon glyphicon-edit"></i></span>
			 	</a>
			 	<a href="javascript:void(0);" onclick="<%=hoatDongAction %>" title='<%=maSoThuChi.getHoatDong() ? "Ngưng hoạt động" : "Hoạt động" %>'>
			 		<span style='<%=maSoThuChi.getHoatDong() ? "color:#ff3d00e8" :  "color:blue"%>'><i class='<%=maSoThuChi.getHoatDong() ? "glyphicon glyphicon-off" : "glyphicon glyphicon-play-circle"%>'></i></span>
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
				height : 600,
				modal : true,
				width : 700
			},
			id : '<portlet:namespace />dialogAdd',
			title : 'Sửa Thông tin mã số',
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
                   					toastr.success('Thêm mã số thành công', 'Thông báo!');
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