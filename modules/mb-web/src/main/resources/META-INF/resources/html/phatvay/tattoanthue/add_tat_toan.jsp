<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/danhmuc/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Locale localeEn = new Locale("en", "EN");
	NumberFormat df = NumberFormat.getInstance(localeEn);
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	String maCTV = ParamUtil.getString(request, "maCTV");
	String dialogId = ParamUtil.getString(request, "dialogId");
	String phatVayIdAdds = ParamUtil.getString(request, "phatVayIdAdds");
%>
<aui:form name="fmDanhSach">
	<table class="info table-pa5 aui-w100">
			<tr>
				<td class="aui-w50">
					<aui:input name="soKUSearch" class="input-text" label="Số KU" onchange="search();">
					</aui:input>
				</td>
				<td class="aui-w50">
				</td>
			</tr>
			<tr>
				<td  colspan="2">
					<button id="<portlet:namespace />chon" type="button" class="btn btn-labeled" onclick="chonPhatVayTatToan();">
						<span class="btn-label"><i class="glyphicon glyphicon-ok-circle"></i></span>Chọn
					</button>
				</td>
			</tr>
			<tr>
				<td colspan="2" >
					<div id="<portlet:namespace />contentDataTable" name="<portlet:namespace />contentDataTable"></div>
				<td>
			</tr>
	</table>
</aui:form>
<portlet:renderURL var="searchURL"
	windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<portlet:param name="mvcPath" value="/html/phatvay/tattoanthue/danh_sach_phat_vay_chua_thanh_toan.jsp" />
</portlet:renderURL>
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
		var divContent = A.one('#<portlet:namespace />contentDataTable');
		if(divContent){
			var data = {
				'<portlet:namespace/>soKUSearch' : A.one('#<portlet:namespace />soKUSearch').val(),
	        	'<portlet:namespace/>maCTVSearch' : '<%=maCTV %>',
	        	'<portlet:namespace/>phatVayIdAdds' : '<%=phatVayIdAdds %>'
	        }
			divContent.plug(A.Plugin.IO,{
	            autoLoad: false,
	            uri : '${searchURL}',
				data : data
	        });
	        var contentIO = divContent.io;
	        if(contentIO){
				contentIO.start();
	        }
		}
	});
	search();
	Liferay.provide(window,'chonPhatVayTatToan', function(){
		var phatVayIds = Liferay.Util.listCheckedExcept(contentDataTable, '<portlet:namespace />allRowIds');
		Liferay.Util.getOpener().addPhatVayTatToan(phatVayIds,'<%=dialogId%>');
	});
});
</aui:script>