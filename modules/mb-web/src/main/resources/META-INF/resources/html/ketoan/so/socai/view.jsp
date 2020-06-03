<%@page import="com.mb.service.TaiKhoanDoiUngLocalServiceUtil"%>
<%@page import="com.mb.model.TaiKhoanDoiUng"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ include file="/html/ketoan/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<portlet:renderURL var="searchURLSoCai"
windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<portlet:param name="mvcPath" value="/html/ketoan/so/socai/data.jsp" />
</portlet:renderURL>
<%
	List<TaiKhoanDoiUng> items = TaiKhoanDoiUngLocalServiceUtil.findBase( 0, "", "", 1, -1, -1, null);
%>
<aui:form name="frm">
<table class="aui-w100">
		<tr>
			<td style="width: 10%;">
				<aui:select name="thangSoCaiSearch" label="Tháng" onchange="searchSoCai();">
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
				<aui:select name="namSoCaiSearch" label="Năm" onchange="searchSoCai();">
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
			<td style="width: 10%;">
				<aui:select name="taiKhoanDoiUngIdSoCaiSearch" label="Tài khoản" onchange="searchSoCai();">
					 <c:forEach items="<%= items%>" var="item">
						 	<aui:option value="${item.taiKhoanDoiUngId}" label="${item.ten}"/>
					</c:forEach>
				</aui:select>
			</td>
			
		</tr>
</table>
<div id="<portlet:namespace />contentDataTableSoCai" style="overflow-x: scroll;font-size: small;" name="<portlet:namespace />contentDataTableSoCai"></div>
</aui:form>
<aui:script use="aui-base,aui-io-plugin-deprecated,aui-loading-mask-deprecated">
AUI().ready(['aui-base'], function(A) {
	var contentDataTable = A.one('#<portlet:namespace />contentDataTableSoCai');
	var loadingMask = new A.LoadingMask(
		{
			target: A.getBody()
		}
	);
	Liferay.provide(window,'searchSoCai', function(){
		loadingMask.show();
		var data = {
			'<portlet:namespace/>namSearch' : A.one('#<portlet:namespace />namSoCaiSearch').val(),
			'<portlet:namespace/>thangSearch' : A.one('#<portlet:namespace />thangSoCaiSearch').val(),
        	'<portlet:namespace/>taiKhoanDoiUngIdSearch' : A.one('#<portlet:namespace />taiKhoanDoiUngIdSoCaiSearch').val()
        }
		contentDataTable.plug(A.Plugin.IO,{
            autoLoad: false,
            uri : '${searchURLSoCai}',
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
	searchSoCai();
});
</aui:script>