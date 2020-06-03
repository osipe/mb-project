
<%@page import="com.mb.service.LoaiTaiSanLocalServiceUtil"%>
<%@page import="com.mb.model.LoaiTaiSan"%>
<%@page import="com.mb.service.KhachHangLocalServiceUtil"%>
<%@page import="com.mb.model.KhachHang"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ include file="/html/phatvay/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	List<KhachHang> khachHangs = KhachHangLocalServiceUtil.findBase("", "", "", "", "", 1, -1, -1, null);
	List<LoaiTaiSan> loaiTaiSans = LoaiTaiSanLocalServiceUtil.findBase("", "", "", 1, -1, -1, null);
%>
<portlet:renderURL var="searchURL"
	windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<portlet:param name="mvcPath" value="/html/phatvay/taisanthechap/data.jsp" />
</portlet:renderURL>
<aui:form name="frm">
<fieldset class="fieldset-border">
	<legend class="legend-border">
		<a data-toggle="collapse" data-target="#idSearchAdvance" href="javascript:void(0);"
			class="collapsed title-fieldset" aria-expanded="false">Thông tin tìm kiếm</a>
	</legend>
	<div id="idSearchAdvance" class="collapse">
		<table class="info table-pa5 aui-w100">
			<tr>
				<td>
					<aui:input name="soKUSearch" class="input-text" label="Số KU">
					</aui:input>
				</td>
				<td>
					<aui:select name="maKhachHangSearch" label="Khách hàng" cssClass="input-select2">
						 <aui:option value=" " label="Chọn" />
						 <c:forEach items="<%= khachHangs%>" var="item">
						 	<aui:option value="${item.ma}" label="${item.hoTen}"/>
						</c:forEach>
					</aui:select>
				</td>
			</tr>
			<tr>
				<td>
					<aui:input name="tenSearch" class="input-text" label="Tên tài sản">
					</aui:input>
				</td>
				<td>
					<aui:select name="loaiTaSanSearch" label="Loại tài sản" cssClass="input-select2">
						 <aui:option value=" " label="Chọn" />
						 <c:forEach items="<%= loaiTaiSans%>" var="item">
						 	<aui:option value="${item.loaiTaiSanId}" label="${item.ten}"/>
						</c:forEach>
					</aui:select>
				</td>
			</tr>
			<tr>
				<td  colspan="2">
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
	$('.input-date').datepicker();
	$('.input-date').mask('99/99/9999');
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
		var data = {
			'<portlet:namespace/>soKUSearch' : A.one('#<portlet:namespace />soKUSearch').val(),
        	'<portlet:namespace/>maKhachHangSearch' : A.one('#<portlet:namespace />maKhachHangSearch').val(),
        	'<portlet:namespace/>tenSearch' : A.one('#<portlet:namespace />tenSearch').val(),
        	'<portlet:namespace/>loaiTaSanSearch' : A.one('#<portlet:namespace />loaiTaSanSearch').val(),
        }
		contentDataTable.plug(A.Plugin.IO,{
            autoLoad: false,
            uri : '${searchURL}',
			data : data
        });
        var contentIO = contentDataTable.io;
        if(contentIO){
			contentIO.start();
        }
	});
	search();
});
</aui:script>