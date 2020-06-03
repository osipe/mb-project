<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/danhmuc/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<aui:form name="fmDanhSach">
	<table class="info table-pa5 aui-w100">
			<tr>
				<td class="aui-w50">
					<aui:input name="soKUSearch" class="input-text" label="Số KU" onchange="search();">
					</aui:input>
				</td>
				<td class="aui-w50">
					<aui:select name="maCTVSearch" label="Cộng tác viên" cssClass="input-select2" onchange="search();">
						 <aui:option value=" " label="Chọn" />
						 <c:forEach items="<%= ctvs%>" var="item">
						 	<aui:option value="${item.ma}" label="${item.hoTen}"/>
						</c:forEach>
					</aui:select>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<fieldset id="<portlet:namespace />thongTinTatToanTong" class="fieldset-border hide">
						<h3>Thông tin tất toán</h3>
						<span style="font-weight: bold;color: #0006ff;" id="<portlet:namespace />tongVonTatToan">
						</span>
						<br/>
						<span style="font-weight: bold;color: #0006ff;" id="<portlet:namespace />tongLaiTatToan">
						</span>
					</fieldset>
				</td>
			</tr>
			<tr>
				<td  colspan="2">
					<button id="<portlet:namespace />tatToanBtn" type="button" class="btn btn-labeled btn-danger hide" onclick="tatToan();">
						<span class="btn-label"><i class="glyphicon glyphicon-piggy-bank"></i></span>Tất toán
					</button>
					<button id="<portlet:namespace />inPhieuTatToan" type="button" class="btn btn-info btn-labeled hide" onclick="printPhieuTatToan();">
						<span class="btn-label"><i class="glyphicon glyphicon-print"></i></span>In Phiếu Tất Toán
					</button>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<div id="<portlet:namespace />contentDataTable" name="<portlet:namespace />contentDataTable"></div>
				<td>
			</tr>
	</table>
	<table class="info table-pa5 aui-w100">
	</table>
</aui:form>
<portlet:renderURL var="searchURL"
	windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<portlet:param name="mvcPath" value="/html/phatvay/tattoan/danh_sach_phat_vay_chua_thanh_toan.jsp" />
</portlet:renderURL>
<portlet:resourceURL var="tatToanURL" id="tatToanURL"></portlet:resourceURL>
<portlet:resourceURL var="getThongTinTatToan" id="getThongTinTatToan"></portlet:resourceURL>
<portlet:resourceURL var="printPhieuTatToan" id="printPhieuTatToan"></portlet:resourceURL>
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
	Liferay.provide(window,'showThongTinTatToan', function(){
		var phatVayIds = Liferay.Util.listCheckedExcept(contentDataTable, '<portlet:namespace />allRowIds');
		if(A.one('#<portlet:namespace />maCTVSearch').val() != ' ' && A.one('#<portlet:namespace />maCTVSearch').val() != '' && phatVayIds != ''){
			A.one('#<portlet:namespace />tatToanBtn').show();	
			A.one('#<portlet:namespace />inPhieuTatToan').show();
			A.one('#<portlet:namespace />thongTinTatToanTong').show();
		}else{
			A.one('#<portlet:namespace />thongTinTatToanTong').hide();
			A.one('#<portlet:namespace />tatToanBtn').hide();	
			A.one('#<portlet:namespace />inPhieuTatToan').hide();	
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
	Liferay.provide(window,'tatToan', function(){
		var check = confirm('Bạn có chắc thực hiện thao tác này ?');
		var phatVayIds = Liferay.Util.listCheckedExcept(contentDataTable, '<portlet:namespace />allRowIds');
		if (check && phatVayIds != '') {
			loadingMask.show();
			A.io.request('${tatToanURL}', {
		               method: 'post',
		               data : {
		               	'<portlet:namespace />phatVayIds' : phatVayIds
		               },
		               on: {
		                   success: function() {
		                   		if(this.get('responseData')){
		                   			var data = JSON.parse(this.get('responseData'));
		                   			if(!data.exception){
	                   					search();
	                   					searchLichSu();
	                   					toastr.success('Đã tất toán phát vay thành công', 'Thông báo!');
		                   			}else{
	                   					toastr.error('Yêu cầu thực hiện không thành công', 'Lỗi!');
		                   			}
		                   		}
		                   }
		              }
	        });
	        loadingMask.hide();
		}
	});
	Liferay.provide(window,'tatToan', function(){
		var check = confirm('Bạn có chắc thực hiện thao tác này ?');
		var phatVayIds = Liferay.Util.listCheckedExcept(contentDataTable, '<portlet:namespace />allRowIds');
		if (check && phatVayIds != '') {
			loadingMask.show();
			A.io.request('${tatToanURL}', {
		               method: 'post',
		               data : {
		               	'<portlet:namespace />phatVayIds' : phatVayIds
		               },
		               on: {
		                   success: function() {
		                   		if(this.get('responseData')){
		                   			var data = JSON.parse(this.get('responseData'));
		                   			if(!data.exception){
	                   					search();
	                   					toastr.success('Đã tất toán phát vay thành công', 'Thông báo!');
		                   			}else{
	                   					toastr.error('Yêu cầu thực hiện không thành công', 'Lỗi!');
		                   			}
		                   		}
		                   }
		              }
	        });
	        loadingMask.hide();
		}
	});
	Liferay.provide(window,'getThongTinTatToan', function(){
		var phatVayIds = Liferay.Util.listCheckedExcept(contentDataTable, '<portlet:namespace />allRowIds');
		if (phatVayIds != '') {
			loadingMask.show();
			A.io.request('${getThongTinTatToan}', {
		               method: 'post',
		               data : {
		               	'<portlet:namespace />phatVayIds' : phatVayIds
		               },
		               on: {
		                   success: function() {
		                   		if(this.get('responseData')){
		                   			var data = JSON.parse(this.get('responseData'));
		                   			if(!data.exception){
		                   				A.one('#<portlet:namespace />tongVonTatToan').html('Tổng vốn trả : ' + data.tongVonTatToanStr + 'VND');
	                   					A.one('#<portlet:namespace />tongLaiTatToan').html('Tổng lãi trả : ' + data.tongLaiTatToanStr + 'VND');
		                   			}
		                   		}
		                   }
		              }
	        });
	        loadingMask.hide();
		}
	});
	Liferay.provide(window,'printPhieuTatToan', function(){
		var url = '${printPhieuTatToan}';
		var phatVayIds = Liferay.Util.listCheckedExcept(contentDataTable, '<portlet:namespace />allRowIds');
		url += '&<portlet:namespace/>phatVayIds=' + phatVayIds;
		url += '&<portlet:namespace/>maCTV=' + A.one('#<portlet:namespace />maCTVSearch').val();
		window.location.href = url;
	});
});
</aui:script>