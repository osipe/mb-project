
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.mb.service.CongTacVienLocalServiceUtil"%>
<%@page import="com.mb.model.CongTacVien"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ include file="/html/thongke/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	Date now = new Date();
	List<CongTacVien> ctvs = CongTacVienLocalServiceUtil.findBase( "", "", "", "", 1, -1, -1, null);
%>
<portlet:renderURL var="searchURL" windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<portlet:param name="mvcPath" value="/html/thongke/thu_phat_chi_ngay/data.jsp" />
</portlet:renderURL>
<aui:form name="frm">
<h3 style="text-align: center;">THU PHÁT CHI NGÀY</h3>
<table class="info table-pa5 aui-w100">
	<tr>
		<td>
			<aui:select name="maCTVSearch" label="Cộng tác viên" cssClass="input-select2" onchange="search();">
				 <aui:option value=" " label="Chọn" />
				 <c:forEach items="<%= ctvs%>" var="item">
				 	<aui:option value="${item.ma}" label="${item.hoTen}"/>
				</c:forEach>
			</aui:select>
		</td>
		<td>
			<aui:input cssClass="input-date" name="ngayBatDauTuSearch" label="Ngày" placeholder="dd/MM/yyyy" value="<%=sdf.format(now) %>" onchange="search();">
			</aui:input>
		</td>
	</tr>
	<tr>
		<td  colspan="2">
			<div class="btn-group">
			  <button type="button" class="btn btn-primary dropdown-toggle dropdown-toggle-split" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			  	<span class="btn-label"><i class="glyphicon glyphicon-print "></i></span>In thu phát chi ngày
			  </button>
			  <div class="dropdown-menu">
			    <a class="dropdown-item" href="#" onClick="inThuPhatChiNgay(1); return false;">
			    	<img alt="Không tìm thấy file" width="20" height="20" src='<%=themeDisplay.getPathThemeImages() + "/file_system/small/docx.png"%>'>
			    	DOCX
			    </a>
			    <a class="dropdown-item" href="#" onClick="inThuPhatChiNgay(2); return false;">
			    	<img alt="Không tìm thấy file" width="20" height="20" src='<%=themeDisplay.getPathThemeImages() + "/file_system/small/xlsx.png"%>'>
			    	XLSX
			    </a>
			  </div>
			  
			  <button id="<portlet:namespace />inPhieuThuHangNgay" type="button" class="btn btn-labeled btn-info" onclick="printPhieuThuTienHangNgay1();">
					<span class="btn-label"><i class="glyphicon glyphicon-print "></i></span>In Phiếu Thu
				</button>
			</div>
		</td>
	</tr>
</table>
<div id="<portlet:namespace />contentDataTable" style="overflow-x: scroll;font-size: small;"  name="<portlet:namespace />contentDataTable"></div>
</aui:form>
<portlet:resourceURL var="inThuPhatChiNgay" id="inThuPhatChiNgay"/>
<portlet:resourceURL var="printPhieuThuTienHangNgay" id="printPhieuThuTienHangNgay"/>
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
		var ngayBatDauTuSearch = 0;
		var pattern = /(\d{2})\/(\d{2})\/(\d{4})/;
		var ngayBatDauTuSearchVal = A.one('#<portlet:namespace />ngayBatDauTuSearch').val();
		if (('' != ngayBatDauTuSearchVal && pattern.test(ngayBatDauTuSearchVal)) && 'dd/MM/yyyy' != ngayBatDauTuSearchVal) {
			var dateTu = new Date(ngayBatDauTuSearchVal.replace(pattern, '$3-$2-$1'));
			ngayBatDauTuSearch = dateTu.getTime();
		}
		var data = {
			'<portlet:namespace/>maCTVSearch' : A.one('#<portlet:namespace />maCTVSearch').val(),
        	'<portlet:namespace/>ngayBatDauTuSearch' : ngayBatDauTuSearch,
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
	Liferay.provide(window,'inThuPhatChiNgay', function(type){
		var ngayBatDauTuSearch = 0;
		var pattern = /(\d{2})\/(\d{2})\/(\d{4})/;
		var ngayBatDauTuSearchVal = A.one('#<portlet:namespace />ngayBatDauTuSearch').val();
		if (('' != ngayBatDauTuSearchVal && pattern.test(ngayBatDauTuSearchVal)) && 'dd/MM/yyyy' != ngayBatDauTuSearchVal) {
			var dateTu = new Date(ngayBatDauTuSearchVal.replace(pattern, '$3-$2-$1'));
			ngayBatDauTuSearch = dateTu.getTime();
		}
		var url = '${inThuPhatChiNgay}';
		url += '&<portlet:namespace/>ngayTuTime=' + ngayBatDauTuSearch;
		url += '&<portlet:namespace/>maCTV=' + A.one('#<portlet:namespace />maCTVSearch').val();
		url += '&<portlet:namespace/>typeIn=' + type;
		window.location.href = url;
	});
    Liferay.provide(window,'printPhieuThuTienHangNgay1', function(){
		var url = '${printPhieuThuTienHangNgay}';
		var ngayBatDauTuSearch = 0;
		var pattern = /(\d{2})\/(\d{2})\/(\d{4})/;
		var ngayBatDauTuSearchVal = A.one('#<portlet:namespace />ngayBatDauTuSearch').val();
		if (('' != ngayBatDauTuSearchVal && pattern.test(ngayBatDauTuSearchVal)) && 'dd/MM/yyyy' != ngayBatDauTuSearchVal) {
			var dateTu = new Date(ngayBatDauTuSearchVal.replace(pattern, '$3-$2-$1'));
			ngayBatDauTuSearch = dateTu.getTime();
		}
		url += '&<portlet:namespace/>maCTV=' +  A.one('#<portlet:namespace />maCTVSearch').val();
		url += '&<portlet:namespace/>ngayThuTien=' + ngayBatDauTuSearch;
		 window.open(url);
	});
});
</aui:script>