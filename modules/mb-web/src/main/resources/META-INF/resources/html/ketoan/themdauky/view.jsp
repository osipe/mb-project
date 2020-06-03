<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.mb.service.TaiKhoanDoiUngLocalServiceUtil"%>
<%@page import="com.mb.model.TaiKhoanDoiUng"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ include file="/html/ketoan/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<portlet:renderURL var="searchURL"
	windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<portlet:param name="mvcPath" value="/html/ketoan/themdauky/data.jsp" />
</portlet:renderURL>
<portlet:renderURL var="addURL"
	windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/html/ketoan/themdauky/add.jsp" />
</portlet:renderURL>
<%
	Date now = new Date();
	int thang = GetterUtil.getInteger(new SimpleDateFormat("MM").format(now));
	int nam = GetterUtil.getInteger(new SimpleDateFormat("yyyy").format(now));
	List<TaiKhoanDoiUng> items = TaiKhoanDoiUngLocalServiceUtil.findBase(0, "", "", 1, -1, -1, null);
%>
<aui:form name="frm">
	<button type="button" class="btn btn-labeled btn-danger"
		onclick="openDialog();">
		<span class="btn-label"><i class="glyphicon glyphicon-plus"></i></span>Thêm đầu kỳ
	</button>
	<table class="aui-w100">
		<tr>
			<td style="width: 10%;"><aui:select name="namSearch" label="Năm"
					onchange="search();">
					<%
						for (int i = nam - 5; i <= nam; i++) {
					%>
					<aui:option value="<%=i%>" label='<%="Năm " + i%>'
						selected="<%=i == nam%>" />
					<%
						}
					%>
				</aui:select></td>
			<td style="width: 10%;"><aui:select
					name="taiKhoanDoiUngIdSearch" label="Tài khoản"
					onchange="search();">
					 <aui:option value="0" label="Tất cả" />
					<c:forEach items="<%=items%>" var="item">
						<aui:option value="${item.taiKhoanDoiUngId}" label="${item.ten}" />
					</c:forEach>
				</aui:select></td>

		</tr>
	</table>
	<div id="<portlet:namespace />contentDataTable" style="overflow-x: scroll;font-size: small;"
		name="<portlet:namespace />contentDataTable"></div>
</aui:form>
<aui:script
	use="aui-base,aui-io-plugin-deprecated,aui-loading-mask-deprecated">
AUI().ready(['aui-base'], function(A) {
	var contentDataTable = A.one('#<portlet:namespace />contentDataTable');
	var loadingMask = new A.LoadingMask(
		{
			target: A.getBody()
		}
	);
	Liferay.provide(window,'search', function(){
		loadingMask.show();
		var data = {
			'<portlet:namespace />namSearch' : A.one('#<portlet:namespace />namSearch').val(),
        	'<portlet:namespace />taiKhoanDoiUngIdSearch' : A.one('#<portlet:namespace />taiKhoanDoiUngIdSearch').val()
        }
		contentDataTable.plug(A.Plugin.IO,{
            autoLoad: false,
            uri : '${searchURL}',
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
	Liferay.provide(window,'openDialog', function(){
		Liferay.Util.openWindow({
			dialog : {
				centered : true,
				height : 600,
				modal : true,
				width : 700
			},
			id : '<portlet:namespace />dialogAdd',
			title : 'Thêm đầu kỳ',
			uri : '${addURL}'
		});
	});
	Liferay.provide(window,'dongPopup', function(){
		var dialog = Liferay.Util.Window.getById('<portlet:namespace />dialogAdd');
		if(dialog){
			dialog.destroy();
		}
	});
	Liferay.provide(window,'thongBao', function(){
		toastr.success('Thêm đầu kỳ thành công', 'Thông báo!');
	});
	search();
});
</aui:script>