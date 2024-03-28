<%@page import="com.mb.service.TaiKhoanDoiUngLocalServiceUtil"%>
<%@page import="com.mb.model.TaiKhoanDoiUng"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ include file="/html/ketoan/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<portlet:renderURL var="searchURLSoCai"
windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<portlet:param name="mvcPath" value="/html/ketoan/so/soCTV/data.jsp" />
</portlet:renderURL>
<%
	List<TaiKhoanDoiUng> itemCTVs = TaiKhoanDoiUngLocalServiceUtil.findByLoaiTaiKhoan_HoatDong(2, true);
%>
<aui:form name="frm">
<table class="aui-w100">
		<tr>
			<td style="width: 10%;">
				<aui:select name="thangSoCTVSearch" label="Tháng" onchange="searchSoCTV();">
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
				<aui:select name="namSoCTVSearch" label="Năm" onchange="searchSoCTV();">
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
				<aui:select name="taiKhoanDoiUngIdSoCTVSearch" label="Tài khoản" onchange="searchSoCTV();" cssClass="input-select2">
					 <aui:option value="-1" label="Tất cả" />
					 <c:forEach items="<%= itemCTVs%>" var="item">
						 	<aui:option value="${item.taiKhoanDoiUngId}" label="${item.ten} - ${item.soHieu}"/>
					</c:forEach>
				</aui:select>
			</td>
			
		</tr>
</table>
<div id="<portlet:namespace />contentDataTableSoCTV" style="overflow-x: scroll;font-size: small;" name="<portlet:namespace />contentDataTableSoCTV"></div>
</aui:form>
<aui:script use="aui-base,aui-io-plugin-deprecated,aui-loading-mask-deprecated">
AUI().ready(['aui-base'], function(A) {
	var contentDataTable = A.one('#<portlet:namespace />contentDataTableSoCTV');
	var loadingMask = new A.LoadingMask(
		{
			target: A.getBody()
		}
	);
	Liferay.provide(window,'searchSoCTV', function(){
		loadingMask.show();
		var data = {
			'<portlet:namespace/>namSearch' : A.one('#<portlet:namespace />namSoCTVSearch').val(),
			'<portlet:namespace/>thangSearch' : A.one('#<portlet:namespace />thangSoCTVSearch').val(),
        	'<portlet:namespace/>taiKhoanDoiUngIdSoCTVSearch' : A.one('#<portlet:namespace />taiKhoanDoiUngIdSoCTVSearch').val()
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
	searchSoCTV();
});
</aui:script>