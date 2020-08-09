
<%@page import="quanly.portlet.danhmuc.ctv.CongTacVienComparator"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.mb.service.CongTacVienLocalServiceUtil"%>
<%@page import="com.mb.model.CongTacVien"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ include file="/html/thongke/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<portlet:renderURL var="searchURL" windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<portlet:param name="mvcPath" value="/html/thongke/sao_ke_kh/data.jsp" />
</portlet:renderURL>
<%
	CongTacVienComparator congTacVienComparator = new  CongTacVienComparator("ma",true);
	List<CongTacVien> ctvs = CongTacVienLocalServiceUtil.findBase( "", "", "", "", 1, -1, -1, congTacVienComparator);
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	Date now = new Date();
%>
<aui:form name="frm">
<h3 style="text-align: center;">TỔNG HỢP SAO KÊ DƯ NỢ KHÁCH HÀNG</h3>
<table class="info table-pa5 aui-w100">
	<tr>
		<td>
			<aui:select name="maCTVSearch" label="Cộng tác viên" cssClass="input-select2" onchange="search();">
				 <aui:option value=" " label="Tất cả" />
				 <c:forEach items="<%= ctvs%>" var="item">
				 	<aui:option value="${item.ma}" label="${item.hoTen} - ${item.ma}"/>
				</c:forEach>
			</aui:select>
		</td>
		<td>
			<aui:input cssClass="input-date" name="ngayBatDauSearch" label="Ngày" placeholder="dd/MM/yyyy" value="<%=sdf.format(now) %>" onchange="search();">
			</aui:input>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<button id="<portlet:namespace />in" type="button" class="btn btn-labeled btn-primary" onclick="inSaoKe();">
				<span class="btn-label"><i class="glyphicon glyphicon-print"></i></span>In sao kê dư nợ
			</button>
		</td>
	</tr>
</table>
<div id="<portlet:namespace />contentDataTable" style="overflow-x: scroll;font-size: small;" name="<portlet:namespace />contentDataTable"></div>
</aui:form>
<portlet:resourceURL var="inSaoKeDuNoKHURL" id="inSaoKeDuNoKH"></portlet:resourceURL>
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
		var ngayBatDauSearch = 0;
		var pattern = /(\d{2})\/(\d{2})\/(\d{4})/;
		var ngayBatDauSearchVal = A.one('#<portlet:namespace />ngayBatDauSearch').val();
		if (('' != ngayBatDauSearchVal && pattern.test(ngayBatDauSearchVal)) && 'dd/MM/yyyy' != ngayBatDauSearchVal) {
			var dateTu = new Date(ngayBatDauSearchVal.replace(pattern, '$3-$2-$1'));
			ngayBatDauTuSearch = dateTu.getTime();
		}
		var data = {
        	'<portlet:namespace/>maCTVSearch' : A.one('#<portlet:namespace />maCTVSearch').val(),
        	'<portlet:namespace/>ngayBatDauTuSearchTime' : ngayBatDauTuSearch
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
	Liferay.provide(window,'inSaoKe', function(){
		var ngayBatDauSearch = 0;
		var pattern = /(\d{2})\/(\d{2})\/(\d{4})/;
		var ngayBatDauSearchVal = A.one('#<portlet:namespace />ngayBatDauSearch').val();
		if (('' != ngayBatDauSearchVal && pattern.test(ngayBatDauSearchVal)) && 'dd/MM/yyyy' != ngayBatDauSearchVal) {
			var date = new Date(ngayBatDauSearchVal.replace(pattern, '$3-$2-$1'));
			ngayBatDauSearch = date.getTime();
		}
		var url = '${inSaoKeDuNoKHURL}';
		url += '&<portlet:namespace/>ngayTime=' + ngayBatDauSearch;
		url += '&<portlet:namespace/>maCTVSearch=' + A.one('#<portlet:namespace />maCTVSearch').val();
		window.location.href = url;
	});
});
</aui:script>