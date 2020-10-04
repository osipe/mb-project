
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="java.util.Date"%>
<%@page import="com.mb.service.CongTacVienLocalServiceUtil"%>
<%@page import="com.mb.model.CongTacVien"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ include file="/html/danhmuc/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Date now = new Date();
	int nam = GetterUtil.getInteger(new SimpleDateFormat("yyyy").format(now));
%>
<portlet:renderURL var="addURL"
	windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/html/danhmuc/cauhinhthutientruoc/add.jsp" />
</portlet:renderURL>
<portlet:renderURL var="searchURL"
	windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<portlet:param name="mvcPath" value="/html/danhmuc/cauhinhthutientruoc/data.jsp" />
</portlet:renderURL>
<aui:form name="frm">
<button type="button" class="btn btn-labeled btn-danger"
	onclick="openDialog();">
	<span class="btn-label"><i
		class="glyphicon glyphicon-plus"></i></span>Thêm
</button>
<fieldset class="fieldset-border">
	<legend class="legend-border">
		<a data-toggle="collapse" data-target="#idSearchAdvance" href="javascript:void(0);"
			class="collapsed title-fieldset" aria-expanded="false">Thông tin tìm kiếm</a>
	</legend>
	<div id="idSearchAdvance" class="collapse">
		<table class="info table-pa5 aui-w100">
			<tr>
				<td>
					<aui:select name="namSearch" label="Cộng tác viên" cssClass="input-select2" onchange="search();">
						 <aui:option value="0" label="Chọn" />
						 <%
						for (int i = nam - 5; i <= nam + 5; i++) {
					%>
					<aui:option value="<%=i%>" label='<%="Năm " + i%>'
						selected="<%=i == nam + 1%>" />
					<%
						}
					%>
					</aui:select>
				</td>
				<td>
					<aui:select name="hoatDongSearch" label="Hoạt động"  onchange="search();">
						 <aui:option value="0" label="Tất cả" />
					 	 <aui:option value="1" label="Hoạt động" selected="true" />
						 <aui:option value="2" label="Ngưng hoạt động" />
					</aui:select>
				</td>
			</tr>
		</table>
	</div>
</fieldset>
<div id="<portlet:namespace />contentDataTable" style="overflow-x: scroll;font-size: small;" name="<portlet:namespace />contentDataTable"></div>
</aui:form>
<aui:script use="aui-base,aui-io-plugin-deprecated,aui-loading-mask-deprecated">
AUI().ready(['aui-base'], function(A) {
	$('.input-select2').select2({
		placeholder : 'Chọn',
		allowClear : true,
		language : {
			noResults : function() {
				return '';
			}
		}
	});
	var contentDataTable = A.one('#<portlet:namespace />contentDataTable');
	var loadingMask = new A.LoadingMask(
		{
			target: A.getBody()
		}
	);
	Liferay.provide(window,'search', function(){
		loadingMask.show();
		var data = {
			'<portlet:namespace/>namSearch' : A.one('#<portlet:namespace />namSearch').val(),
        	'<portlet:namespace/>hoatDongSearch' : A.one('#<portlet:namespace />hoatDongSearch').val()
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
			title : 'Thêm cấu hình',
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
		toastr.success('Thêm cấu hình thành công', 'Thông báo!');
	});
	search();
});
</aui:script>