
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.mb.service.KhachHangLocalServiceUtil"%>
<%@page import="com.mb.model.KhachHang"%>
<%@page import="com.mb.service.CongTacVienLocalServiceUtil"%>
<%@page import="com.mb.model.CongTacVien"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ include file="/html/thongke/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	Date now = new Date();
%>
<portlet:renderURL var="searchURL" windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<portlet:param name="mvcPath" value="/html/thongke/phat_vay_ngay/data.jsp" />
</portlet:renderURL>
<aui:form name="frm">
<h3 style="text-align: center;">BẢNG KÊ PHÁT VAY NGÀY</h3>
<table class="info table-pa5 aui-w100">
	<tr>
		<td>
			<aui:input cssClass="input-date" name="ngayBatDauSearch" label="Ngày phát vay" placeholder="dd/MM/yyyy" value="<%=sdf.format(now) %>" onchange="search();">
			</aui:input>
		</td>
	</tr>
	<tr>
		<td>
			<div class="btn-group">
			  <button type="button" class="btn btn-primary dropdown-toggle dropdown-toggle-split" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">In phát vay ngày</button>
			  <div class="dropdown-menu">
			    <a class="dropdown-item" href="#" onClick="inPhatVayNgay(1); return false;">
			    	<img alt="Không tìm thấy file" width="20" height="20" src='<%=themeDisplay.getPathThemeImages() + "/file_system/small/docx.png"%>'>
			    	DOCX
			    </a>
			    <a class="dropdown-item" href="#" onClick="inPhatVayNgay(2); return false;">
			    	<img alt="Không tìm thấy file" width="20" height="20" src='<%=themeDisplay.getPathThemeImages() + "/file_system/small/xlsx.png"%>'>
			    	XLSX
			    </a>
			  </div>
			</div>
		</td>
	</tr>
</table>
<div id="<portlet:namespace />contentDataTable" style="overflow-x: scroll;font-size: small;" name="<portlet:namespace />contentDataTable"></div>
</aui:form>
<portlet:resourceURL var="inPhatVayNgay" id="inPhatVayNgay"/>
<aui:script use="aui-base,aui-io-plugin-deprecated,aui-loading-mask-deprecated">
AUI().ready(['aui-base'], function(A) {
	$('.input-date').datepicker();
	$('.input-date').mask('99/99/9999');
	var contentDataTable = A.one('#<portlet:namespace />contentDataTable');
	var loadingMask = new A.LoadingMask(
		{
			target: A.getBody()
		}
	);
	Liferay.provide(window,'search', function(){
		var ngayBatDauTuSearch = 0;
		var pattern = /(\d{2})\/(\d{2})\/(\d{4})/;
		var ngayBatDauSearchVal = A.one('#<portlet:namespace />ngayBatDauSearch').val();
		if (('' != ngayBatDauSearchVal && pattern.test(ngayBatDauSearchVal)) && 'dd/MM/yyyy' != ngayBatDauSearchVal) {
			var dateTu = new Date(ngayBatDauSearchVal.replace(pattern, '$3-$2-$1'));
			ngayBatDauTuSearch = dateTu.getTime();
		}
		var data = {
        	'<portlet:namespace/>ngayPhatVaySearch' : ngayBatDauTuSearch,
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
	Liferay.provide(window,'inPhatVayNgay', function(type){
		var ngayBatDauTuSearch = 0;
		var pattern = /(\d{2})\/(\d{2})\/(\d{4})/;
		var ngayBatDauSearchVal = A.one('#<portlet:namespace />ngayBatDauSearch').val();
		if (('' != ngayBatDauSearchVal && pattern.test(ngayBatDauSearchVal)) && 'dd/MM/yyyy' != ngayBatDauSearchVal) {
			var dateTu = new Date(ngayBatDauSearchVal.replace(pattern, '$3-$2-$1'));
			ngayBatDauTuSearch = dateTu.getTime();
		}
		var url = '${inPhatVayNgay}';
		url += '&<portlet:namespace/>ngayPhatVayTime=' + ngayBatDauTuSearch;
		url += '&<portlet:namespace/>typeIn=' + type;
		window.location.href = url;
	});
});
</aui:script>