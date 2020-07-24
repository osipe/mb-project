<%@page import="com.mb.service.TaiKhoanDoiUngLocalServiceUtil"%>
<%@page import="com.mb.model.TaiKhoanDoiUng"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ include file="/html/ketoan/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<portlet:renderURL var="searchURLTongSo"
windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<portlet:param name="mvcPath" value="/html/ketoan/so/tongSo/data.jsp" />
</portlet:renderURL>
<aui:form name="frm">
<table class="aui-w100">
		<tr>
			<td style="width: 10%;">
				<aui:select name="thangTongSoSearch" label="Tháng" onchange="searchTongSo();">
					<%
						for (int i = 1; i <= 12; i++) {
					%>
					<aui:option value="<%=i%>" label='<%="Tháng " + i%>'
						selected="<%=i == thang%>" />
					<%
						}
					%>
				</aui:select>
			</td>
			<td style="width: 10%;">
				<aui:select name="namTongSoSearch" label="Năm" onchange="searchTongSo();">
					<%
						for (int i = nam - 5; i <= nam; i++) {
					%>
					<aui:option value="<%=i%>" label='<%="Năm " + i%>'
						selected="<%=i == nam%>" />
					<%
						}
					%>
				</aui:select>
			</td>
		</tr>
</table>
<div id="<portlet:namespace />contentDataTableTongSo" style="overflow-x: scroll;font-size: small;" name="<portlet:namespace />contentDataTableTongSo"></div>
</aui:form>
<aui:script use="aui-base,aui-io-plugin-deprecated,aui-loading-mask-deprecated">
AUI().ready(['aui-base'], function(A) {
	var contentDataTable = A.one('#<portlet:namespace />contentDataTableTongSo');
	var loadingMask = new A.LoadingMask(
		{
			target: A.getBody()
		}
	);
	Liferay.provide(window,'searchTongSo', function(){
		loadingMask.show();
		var data = {
			'<portlet:namespace/>namSearch' : A.one('#<portlet:namespace />namTongSoSearch').val(),
			'<portlet:namespace/>thangSearch' : A.one('#<portlet:namespace />thangTongSoSearch').val(),
        }
		contentDataTable.plug(A.Plugin.IO,{
            autoLoad: false,
            uri : '${searchURLTongSo}',
			data : data,
			after: {
				success: function() {
					loadingMask.hide();
				}
			}
        });
        var contentIO = contentDataTable.io;
        if(contentIO){
			contentIO.start();
        }
        loadingMask.hide();
	});
	searchTongSo();
});
</aui:script>