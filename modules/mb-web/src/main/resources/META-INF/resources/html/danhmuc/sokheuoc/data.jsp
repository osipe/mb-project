<%@page import="com.mb.model.SoKheUoc"%>
<%@page import="quanly.portlet.danhmuc.soku.SoKheUocComparator"%>
<%@page import="com.mb.service.SoKheUocLocalServiceUtil"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/danhmuc/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String cauTruc = ParamUtil.getString(request, "cauTruc");
	int count = SoKheUocLocalServiceUtil.countBase(cauTruc);
	Locale localeEn = new Locale("en", "EN");
	NumberFormat df = NumberFormat.getInstance(localeEn);
%>
<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="cauTruc" value="<%=cauTruc%>" />
	<portlet:param name="mvcPath" value="/html/danhmuc/masothuchi/data.jsp" />
</liferay-portlet:renderURL>
<div id="<portlet:namespace />recordSearchContainer">
	<liferay-ui:search-container delta="20"
		emptyResultsMessage="Không có kết quả nào được tìm thấy!"
		iteratorURL="<%=iteratorURL%>" total="<%=count%>">
		<%
			String orderByType = ParamUtil.getString(request, "orderByType");
				String orderByCol = ParamUtil.getString(request, "orderByCol");
				if (Validator.isNull(orderByType)) {
					orderByType = "desc";
				}
				if (Validator.isNull(orderByCol)) {
					orderByCol = "soKheUocId";
				}
				boolean ascending = true;
				if ("desc".equals(orderByType)) {
					ascending = false;
				}
				SoKheUocComparator obc = new SoKheUocComparator(orderByCol, ascending);
				searchContainer.setOrderByCol(orderByCol);
				searchContainer.setOrderByType(orderByType);
				searchContainer.setOrderByComparator(obc);

				List<SoKheUoc> items = SoKheUocLocalServiceUtil.findBase(cauTruc, searchContainer.getStart(),
						searchContainer.getEnd(), searchContainer.getOrderByComparator());
		%>
		<liferay-ui:search-container-results results="<%=items%>" />
		<liferay-ui:search-container-row className="com.mb.model.SoKheUoc"
			modelVar="soKheUoc" keyProperty="soKheUocId">
			<portlet:renderURL var="editURL"
				windowState="<%=LiferayWindowState.POP_UP.toString()%>">
				<portlet:param name="mvcPath" value="/html/danhmuc/sokheuoc/add.jsp" />
				<portlet:param name="soKheUocId"
					value="<%=String.valueOf(soKheUoc.getSoKheUocId())%>" />
			</portlet:renderURL>
			<%
				String editAction = "openDialogEdit('" + editURL + "');";
			%>
			<liferay-ui:search-container-column-text cssClass="text-center"
				name="Cấu trúc" value="${soKheUoc.cauTruc}" orderable="true"
				orderableProperty="cauTruc" />
			<liferay-ui:search-container-column-text cssClass="text-center"
				name="Số" value="${soKheUoc.so}" orderable="true"
				orderableProperty="so" />
			<liferay-ui:search-container-column-text name="Thao tác"
				cssClass="aui-w10 text-center">
				<a href="javascript:void(0);" onclick="<%=editAction%>" title="Sửa">
					<span style="color: #ff3d00e8"><i
						class="glyphicon glyphicon-edit"></i></span>
				</a>
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</div>

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
});	
</aui:script>