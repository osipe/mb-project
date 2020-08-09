<%@page import="quanly.portlet.danhmuc.ctv.CongTacVienComparator"%>
<%@page import="com.mb.service.CongTacVienLocalServiceUtil"%>
<%@page import="com.mb.model.CongTacVien"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DecimalFormat"%>
<%@ include file="/html/phatvay/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	DecimalFormat df = new DecimalFormat("###,###.###");
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	CongTacVienComparator congTacVienComparator = new  CongTacVienComparator("ma",true);
	List<CongTacVien> ctvs = CongTacVienLocalServiceUtil.findBase( "", "", "", "", 1, -1, -1, congTacVienComparator);
%>
<c:set value="<%=df%>" var="df" />
<aui:form name="frm">
	<ul class="nav nav-tabs" id="myTab" role="tablist">
		<li class="nav-item">
			<a class="nav-link active" id="tatToanKU-tab" onclick="search();" data-toggle="tab" href="#<portlet:namespace />tatToanKU" role="tab" aria-controls="<portlet:namespace />tatToanKU" aria-selected="false">Tất toán</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" id="lichSuTatToan-tab" onclick="searchLichSu();" data-toggle="tab" href="#<portlet:namespace />lichSuTatToan" role="tab" aria-controls="<portlet:namespace />lichSuTatToan" aria-selected="true">Lịch sử tất toán</a>
		</li>
	</ul>
	<div class="tab-content" id="myTabContent" style="overflow-x: scroll;font-size: small;">
		<div class="tab-pane fade show active" id="<portlet:namespace />tatToanKU" role="tabpanel" aria-labelledby="tatToanKU-tab">
			<%@ include file="/html/phatvay/tattoan/tat_toan.jsp"%>
		</div>
		<div class="tab-pane fade show" id="<portlet:namespace />lichSuTatToan" role="tabpanel" aria-labelledby="lichSuTatToan-tab">
			<%@ include file="/html/phatvay/tattoan/lichsutattoan/lich_su_tat_toan.jsp"%>
		</div>
	</div>
</aui:form>
<aui:script
	use="aui-base,aui-io-plugin-deprecated,aui-loading-mask-deprecated,node-event-simulate,liferay-util-list-fields,liferay-util-window,liferay-portlet-url">
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
	Liferay.provide(window,'searchLichSu', function(){
		var divContent = A.one('#<portlet:namespace />contentDataTableLichSu');
		if(divContent){
			var ngayTatToanSearch = 0;
			var pattern = /(\d{2})\/(\d{2})\/(\d{4})/;
			var ngayTatToanSearchVal = A.one('#<portlet:namespace />ngayTatToanSearch').val();
			if (('' != ngayTatToanSearchVal && pattern.test(ngayTatToanSearchVal)) && 'dd/MM/yyyy' != ngayTatToanSearchVal) {
				var date = new Date(ngayTatToanSearchVal.replace(pattern, '$3-$2-$1'));
				ngayTatToanSearch = date.getTime();
			}
			var data = {
				'<portlet:namespace/>ngayTatToanSearch' : ngayTatToanSearch,
	        	'<portlet:namespace/>maCTVSearch' : A.one('#<portlet:namespace />maCTVSearchLichSu').val()
	        }
			divContent.plug(A.Plugin.IO,{
	            autoLoad: false,
	            uri : '${searchLichSuURL}',
				data : data
	        });
	        var contentIO = divContent.io;
	       	contentIO.after('success', function() {
	       		divContent.all('input[type=checkbox]').each(function(node){
					if(node.attr('name').indexOf('allRowIds') > 0 || node.attr('name').indexOf('rowIds') > 0){
						node.on('change',function(){
							showBtn();
						});
					}
				});
				showBtn();
			});
	        if(contentIO){
				contentIO.start();
	        }
		}
	});
	Liferay.provide(window,'search', function(){
		var divContent = A.one('#<portlet:namespace />contentDataTable');
		if(divContent){
			var maCTV = A.one('#<portlet:namespace />maCTVSearch').val();
			var data = {
				'<portlet:namespace/>soKUSearch' : A.one('#<portlet:namespace />soKUSearch').val(),
	        	'<portlet:namespace/>maCTVSearch' : maCTV
	        }
			divContent.plug(A.Plugin.IO,{
	            autoLoad: false,
	            uri : '${searchURL}',
				data : data
	        });
	        var contentIO = divContent.io;
	    	contentIO.after('success', function() {
	       		divContent.all('input[type=checkbox]').each(function(node){
					if(node.attr('name').indexOf('allRowIds') > 0 || node.attr('name').indexOf('rowIds') > 0){
						node.on('change',function(){
							var phatVayIds = Liferay.Util.listCheckedExcept(divContent, '<portlet:namespace />allRowIds');
							if(phatVayIds != ''){
								getThongTinTatToan();
							}
							showThongTinTatToan();
						});
					}
				});
				showThongTinTatToan();
			});
	        if(contentIO){
				contentIO.start();
	        }
		}
	});
	search();
});
</aui:script>