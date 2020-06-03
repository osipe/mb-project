<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/phatvay/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<aui:form name="fmLichSu">
	<table class="info table-pa5 aui-w100">
			<tr>
				<td class="aui-w50">
					<aui:select name="maCTVSearchLichSu" label="Cộng tác viên" cssClass="input-select2" onchange="searchLichSu();">
						 <aui:option value=" " label="Chọn" />
						 <c:forEach items="<%= ctvs%>" var="item">
						 	<aui:option value="${item.ma}" label="${item.hoTen}"/>
						</c:forEach>
					</aui:select>
				</td>
				<td>
					<aui:input cssClass="input-date" name="ngayTatToanSearch" label="Ngày tất toán" placeholder="dd/MM/yyyy" onchange="searchLichSu();">
					</aui:input>
				</td>
			</tr>
			<tr>
				<td  colspan="2">
					<button id="<portlet:namespace />boTatToanLichSu" type="button" class="btn btn-labeled btn-danger hide" onclick="boTatToan();">
						<span class="btn-label"><i class="glyphicon glyphicon-remove"></i></span>Bỏ tất toán
					</button>
					<button id="<portlet:namespace />inPhieuTatToanLichSu" type="button" class="btn btn-labeled btn-info" onclick="printPhieuTatToanLichSu();">
						<span class="btn-label"><i class="glyphicon glyphicon-print "></i></span>In Phiếu Tất Toán
					</button>
				</td>
			</tr>
		<tr>
			<td colspan="2">
				<div id="<portlet:namespace />contentDataTableLichSu" name="<portlet:namespace />contentDataTableLichSu"></div>
			<td>
		</tr>
	</table>
	<table class="info table-pa5 aui-w100">
	</table>
</aui:form>
<portlet:renderURL var="searchLichSuURL"
	windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<portlet:param name="mvcPath" value="/html/phatvay/tattoan/lichsutattoan/danh_sach_phat_vay_da_tat_toan.jsp" />
</portlet:renderURL>
<portlet:resourceURL var="boTatToanURL" id="boTatToanURL"></portlet:resourceURL>
<portlet:resourceURL var="printPhieuTatToanLichSu" id="printPhieuTatToan"></portlet:resourceURL>
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
	var contentDataTable = A.one('#<portlet:namespace />contentDataTableLichSu');
	var loadingMask = new A.LoadingMask(
		{
			target: A.getBody()
		}
	);
	Liferay.provide(window,'showBtn', function(){
		var phatVayIds = Liferay.Util.listCheckedExcept(contentDataTable, '<portlet:namespace />allRowIds');
		if(A.one('#<portlet:namespace />maCTVSearchLichSu').val() != ' ' && A.one('#<portlet:namespace />maCTVSearchLichSu').val() != '' && phatVayIds != ''){
			A.one('#<portlet:namespace />boTatToanLichSu').show();
			A.one('#<portlet:namespace />inPhieuTatToanLichSu').show();	
		}else{
			A.one('#<portlet:namespace />boTatToanLichSu').hide();	
			A.one('#<portlet:namespace />inPhieuTatToanLichSu').hide();	
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
	Liferay.provide(window,'boTatToan', function(){
		var check = confirm('Bạn có chắc thực hiện thao tác này ?');
		var phatVayIds = Liferay.Util.listCheckedExcept(contentDataTable, '<portlet:namespace />allRowIds');
		if (check && phatVayIds != '') {
			loadingMask.show();
			A.io.request('${boTatToanURL}', {
		               method: 'post',
		               data : {
		               	'<portlet:namespace />phatVayIds' : phatVayIds
		               },
		               on: {
		                   success: function() {
		                   		if(this.get('responseData')){
		                   			var data = JSON.parse(this.get('responseData'));
		                   			if(!data.exception){
	                   					searchLichSu();
	                   					search();
	                   					toastr.success('Đã bỏ tất toán phát vay thành công', 'Thông báo!');
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
	Liferay.provide(window,'printPhieuTatToanLichSu', function(){
		var url = '${printPhieuTatToanLichSu}';
		var ngayTatToanSearch = 0;
		var pattern = /(\d{2})\/(\d{2})\/(\d{4})/;
		var ngayTatToanSearchVal = A.one('#<portlet:namespace />ngayTatToanSearch').val();
		if (('' != ngayTatToanSearchVal && pattern.test(ngayTatToanSearchVal)) && 'dd/MM/yyyy' != ngayTatToanSearchVal) {
			var date = new Date(ngayTatToanSearchVal.replace(pattern, '$3-$2-$1'));
			ngayTatToanSearch = date.getTime();
		}
		url += '&<portlet:namespace/>ngayTatToanTime=' + ngayTatToanSearch;
		var phatVayIds = Liferay.Util.listCheckedExcept(contentDataTable, '<portlet:namespace />allRowIds');
		url += '&<portlet:namespace/>phatVayIds=' + phatVayIds;
		url += '&<portlet:namespace/>maCTV=' + A.one('#<portlet:namespace />maCTVSearchLichSu').val();
		window.location.href = url;
	});
});
</aui:script>