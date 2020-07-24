<%@page import="com.mb.model.TaiKhoanDoiUng"%>
<%@page import="quanly.portlet.danhmuc.taikhoandoiung.TaiKhoanDoiUngComparator"%>
<%@page import="com.mb.service.TaiKhoanDoiUngLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/danhmuc/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String tenSearch = ParamUtil.getString(request, "tenSearch");
	String soHieuSearch = ParamUtil.getString(request, "soHieuSearch");
	long taiKhoanDoiUngChaIdSearch = ParamUtil.getLong(request, "taiKhoanDoiUngChaIdSearch");
	int hoatDongSearch = ParamUtil.getInteger(request, "hoatDongSearch");
	int count = TaiKhoanDoiUngLocalServiceUtil.countBase(taiKhoanDoiUngChaIdSearch, soHieuSearch, tenSearch, hoatDongSearch);
	DecimalFormat df = new DecimalFormat("###,###.###");
%>
<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="tenSearch" value="<%= tenSearch %>" />
	<portlet:param name="soHieuSearch" value="<%= soHieuSearch %>" />
	<portlet:param name="taiKhoanDoiUngChaIdSearch" value="<%= String.valueOf(taiKhoanDoiUngChaIdSearch) %>" />
	<portlet:param name="hoatDongSearch" value="<%= String.valueOf(hoatDongSearch)%>" />
	<portlet:param name="mvcPath" value="/html/danhmuc/taikhoandoiung/data.jsp" />
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
		 	TaiKhoanDoiUngComparator obc = new TaiKhoanDoiUngComparator(orderByCol,ascending);
		 	searchContainer.setOrderByCol(orderByCol);
		 	searchContainer.setOrderByType(orderByType);
		 	searchContainer.setOrderByComparator(obc);
		 
			List<TaiKhoanDoiUng> items = TaiKhoanDoiUngLocalServiceUtil.findBase( taiKhoanDoiUngChaIdSearch, soHieuSearch, tenSearch, hoatDongSearch, searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
		 %>
		 <liferay-ui:search-container-results results="<%= items %>" />
		 <liferay-ui:search-container-row className="com.mb.model.TaiKhoanDoiUng" modelVar="taiKhoanDoiUng" keyProperty="taiKhoanDoiUngId" > 
			<portlet:renderURL var="editURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
				<portlet:param name="mvcPath" value="/html/danhmuc/taikhoandoiung/add.jsp" />
				<portlet:param name="taiKhoanDoiUngId" value="<%=String.valueOf(taiKhoanDoiUng.getTaiKhoanDoiUngId())%>" />
			</portlet:renderURL>
			<portlet:resourceURL var="hoatDongURL" id="hoatDongURL">
				<portlet:param name="taiKhoanDoiUngId" value="<%=String.valueOf(taiKhoanDoiUng.getTaiKhoanDoiUngId())%>" />
			</portlet:resourceURL>
				<%
					String editAction = "openDialogEdit('" + editURL + "');";
					String hoatDongAction = "hoatDong('" + hoatDongURL + "');";
					String tenTaiKhoanCha = "";
					if(taiKhoanDoiUng.getTaiKhoanDoiUngChaId() > 0){
						try{
							TaiKhoanDoiUng taiKhoanCha = TaiKhoanDoiUngLocalServiceUtil.fetchTaiKhoanDoiUng(taiKhoanDoiUng.getTaiKhoanDoiUngChaId());
							if(taiKhoanCha != null){
								tenTaiKhoanCha = taiKhoanCha.getTen();
							}
						}catch(Exception e){
						}
					}
					
			 	%>
		 
			 <liferay-ui:search-container-column-text cssClass="text-center" name="Tên tài khoản" value="${taiKhoanDoiUng.ten}" orderable="true" orderableProperty="ten"/>
			 <liferay-ui:search-container-column-text cssClass="text-center" name="Số hiệu" value="${taiKhoanDoiUng.soHieu}" orderable="true" orderableProperty="soHieu"/> 
			 <liferay-ui:search-container-column-text cssClass="text-center" name="Tài khoản cha" value="<%=tenTaiKhoanCha %>" orderable="true" orderableProperty="taiKhoanDoiUngChaId"/> 
			 <liferay-ui:search-container-column-text cssClass="text-center" name="Diễn giải theo dõi" value="${taiKhoanDoiUng.dienGiaiTheoDoi}"  orderable="true" orderableProperty="dienGiaiTheoDoi"/> 
			  <liferay-ui:search-container-column-text name="Thao tác" cssClass="aui-w10 text-center">
			 	<a href="javascript:void(0);" onclick="<%=editAction %>" title="Sửa">
			 		<span style="color:#ff3d00e8"><i class="glyphicon glyphicon-edit"></i></span>
			 	</a>
			 	<a href="javascript:void(0);" onclick="<%=hoatDongAction %>" title='<%=taiKhoanDoiUng.getHoatDong() ? "Ngưng hoạt động" : "Hoạt động" %>'>
			 		<span style='<%=taiKhoanDoiUng.getHoatDong() ? "color:#ff3d00e8" :  "color:blue"%>'><i class='<%=taiKhoanDoiUng.getHoatDong() ? "glyphicon glyphicon-off" : "glyphicon glyphicon-play-circle"%>'></i></span>
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
			title : 'Sửa thông tin tài khoản đối ứng',
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
                   					toastr.success('Thêm tài khoản đối ứng thành công', 'Thông báo!');
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