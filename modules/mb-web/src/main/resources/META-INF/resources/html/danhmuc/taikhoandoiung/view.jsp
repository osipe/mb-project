
<%@page import="com.mb.service.TaiKhoanDoiUngLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.mb.model.TaiKhoanDoiUng"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ include file="/html/danhmuc/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<portlet:renderURL var="addURL"
	windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/html/danhmuc/taikhoandoiung/add.jsp" />
</portlet:renderURL>
<portlet:renderURL var="searchURL"
	windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<portlet:param name="mvcPath" value="/html/danhmuc/taikhoandoiung/data.jsp" />
</portlet:renderURL>
<%
	List<TaiKhoanDoiUng> taiKhoanDoiUngs = TaiKhoanDoiUngLocalServiceUtil.findBase(0, "", "", 0, -1, -1, null);
%>
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
					<aui:input class="input-text" name="tenSearch" label="Tên tài khoản">
					</aui:input>
				</td>
				<td>
					<aui:input name="soHieuSearch" class="input-text" label="Số hiệu">
					</aui:input>
				</td>
			</tr>
			<tr>
				<td>
					<aui:select name="taiKhoanDoiUngChaIdSearch" label="Tài khoản cha">
						<aui:option value=" " label="Chọn" />
						 <c:forEach items="<%= taiKhoanDoiUngs%>" var="item">
						 	<aui:option value="${item.taiKhoanDoiUngId}" label="${item.ten}"/>
						</c:forEach>
					</aui:select>
				</td>
				<td>
					<aui:select name="hoatDongSearch" label="Hoạt động">
						 <aui:option value="0" label="Tất cả" />
					 	 <aui:option value="1" label="Hoạt động" selected="true" />
						 <aui:option value="2" label="Ngưng hoạt động" />
					</aui:select>
				</td>
			</tr>
			<tr>
				<td  colspan="3">
					<button  type="button" class="btn-search-file btn" id="idSeachBtn" onclick="search();">Tìm kiếm</button>
				</td>
			</tr>
		</table>
	</div>
</fieldset>
<div id="<portlet:namespace />contentDataTable" style="overflow-x: scroll;font-size: small;" name="<portlet:namespace />contentDataTable"></div>
</aui:form>
<aui:script use="aui-base,aui-io-plugin-deprecated,aui-loading-mask-deprecated">
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
        	'<portlet:namespace/>tenSearch' : A.one('#<portlet:namespace />tenSearch').val(),
        	'<portlet:namespace/>soHieuSearch' : A.one('#<portlet:namespace />soHieuSearch').val(),
        	'<portlet:namespace/>taiKhoanDoiUngChaIdSearch' : A.one('#<portlet:namespace />taiKhoanDoiUngChaIdSearch').val(),
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
			title : 'Thêm tài khoản đối ứng',
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
		toastr.success('Thêm tài khoản đối ứng thành công', 'Thông báo!');
	});
	search();
});
</aui:script>