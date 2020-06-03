<%@page import="com.mb.model.LaiSuat"%>
<%@page import="com.mb.service.LaiSuatLocalServiceUtil"%>
<%@page import="quanly.portlet.danhmuc.laisuat.LaiSuatComparator"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/danhmuc/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%	
	Double soTienVaySearch = ParamUtil.getDouble(request, "soTienVaySearch");
	Double laiSuatVaySearch = ParamUtil.getDouble(request, "laiSuatVaySearch");
	int thoiHanSearch = ParamUtil.getInteger(request, "thoiHanSearch");
	int hoatDongSearch = ParamUtil.getInteger(request, "hoatDongSearch");
	int count = LaiSuatLocalServiceUtil.countBase( soTienVaySearch, laiSuatVaySearch, thoiHanSearch, hoatDongSearch);
	DecimalFormat df = new DecimalFormat("###,###.###");
%>
<c:set value="<%=df %>" var="df"/>
<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="soTienVaySearch" value="<%= String.valueOf(soTienVaySearch) %>" />
	<portlet:param name="laiSuatVaySearch" value="<%= String.valueOf(laiSuatVaySearch) %>" />
	<portlet:param name="thoiHanSearch" value="<%= String.valueOf(thoiHanSearch) %>" />
	<portlet:param name="hoatDongSearch" value="<%= String.valueOf(hoatDongSearch)%>" />
	<portlet:param name="mvcPath" value="/html/danhmuc/laisuat/data.jsp" />
</liferay-portlet:renderURL>
<div id="<portlet:namespace />recordSearchContainer">
	<div style="text-align: right;"><span class="note-span">(Đơn vị : VND)</span></div>
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
		 	LaiSuatComparator obc = new LaiSuatComparator(orderByCol,ascending);
		 	searchContainer.setOrderByCol(orderByCol);
		 	searchContainer.setOrderByType(orderByType);
		 	searchContainer.setOrderByComparator(obc);
		 
			List<LaiSuat> items =  LaiSuatLocalServiceUtil.findBase(soTienVaySearch, laiSuatVaySearch, thoiHanSearch, hoatDongSearch, searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
		 %>
		 <liferay-ui:search-container-results results="<%= items %>" />
		 <liferay-ui:search-container-row className="com.mb.model.LaiSuat" modelVar="laiSuat" keyProperty="laiSuatId" > 
			<portlet:renderURL var="editURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
				<portlet:param name="mvcPath" value="/html/danhmuc/laisuat/add.jsp" />
				<portlet:param name="laiSuatId" value="<%=String.valueOf(laiSuat.getLaiSuatId())%>" />
			</portlet:renderURL>
			<portlet:resourceURL var="hoatDongURL" id="hoatDongURL">
				<portlet:param name="laiSuatId" value="<%=String.valueOf(laiSuat.getLaiSuatId())%>" />
			</portlet:resourceURL>
				<%
					String editAction = "openDialogEdit('" + editURL + "');";
					String hoatDongAction = "hoatDong('" + hoatDongURL + "');";
			 	%>
		 
			 <liferay-ui:search-container-column-text cssClass="aui-w35" name="Thông tin danh mục lãi suất" orderable="true" orderableProperty="soTienVay">
			 	<span style="color:#ff3d00e8" >Số tiền vay : ${not empty laiSuat.soTienVay ? df.format(laiSuat.soTienVay) : ''}</span>
			 	<br/>
			 	<span style="color:blue" >Thời hạn : ${laiSuat.thoiHan} ngày</span>
			 	<br/>
			 	<span class="note-span">(Lãi suất : ${laiSuat.laiSuatVay}%)</span>
			 </liferay-ui:search-container-column-text>
			 <liferay-ui:search-container-column-text cssClass="aui-w15 text-center" name="Tiền lãi ngày" value="${not empty laiSuat.laiNgay ? df.format(laiSuat.laiNgay) : ''}"/> 
			  <liferay-ui:search-container-column-text cssClass="aui-w15 text-center" name="Tiền gốc ngày" value="${not empty laiSuat.gocNgay ? df.format(laiSuat.gocNgay) : ''}"/> 
			   <liferay-ui:search-container-column-text cssClass="aui-w15 text-center" name="Tiền gốc ngày cuối" value="${not empty laiSuat.gocNgayCuoi ? df.format(laiSuat.gocNgayCuoi) : ''}"/> 
			  <liferay-ui:search-container-column-text name="Thao tác" cssClass="aui-w10 text-center">
			 	<a href="javascript:void(0);" onclick="<%=editAction %>" title="Sửa">
			 		<span style="color:#ff3d00e8"><i class="glyphicon glyphicon-edit"></i></span>
			 	</a>
			 	<a href="javascript:void(0);" onclick="<%=hoatDongAction %>" title='<%=laiSuat.getHoatDong() ? "Ngưng hoạt động" : "Hoạt động" %>'>
			 		<span style='<%=laiSuat.getHoatDong() ? "color:#ff3d00e8" :  "color:blue"%>'><i class='<%=laiSuat.getHoatDong() ? "glyphicon glyphicon-off" : "glyphicon glyphicon-play-circle"%>'></i></span>
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
			title : 'Sửa danh mục lãi suất',
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
                   					toastr.success('Thêm danh mục lãi suất thành công', 'Thông báo!');
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