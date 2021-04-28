<%@page import="quanly.portlet.danhmuc.ctv.CongTacVienComparator"%>
<%@page import="com.mb.service.CongTacVienLocalServiceUtil"%>
<%@page import="com.mb.model.CongTacVien"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/phatvay/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<portlet:renderURL var="thuTienTruocURL"
	windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="dialogId" value="dialogThuTienTruoc" />
	<portlet:param name="mvcPath" value="/html/phatvay/thutienhangngay/thutientruoc.jsp" />
</portlet:renderURL>
<%
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	CongTacVienComparator congTacVienComparator = new  CongTacVienComparator("ma",true);
	List<CongTacVien> ctvs = CongTacVienLocalServiceUtil.findBase( "", "", "", "", 1, -1, -1, congTacVienComparator);
	String oppenThuTienTruoc = "openDialogThuTienTruoc('"+thuTienTruocURL.toString() + "','Thu tiền tết','dialogThuTienTruoc');";
%>
<aui:form name="fmLichSu">
	<table class="info table-pa5 aui-w100">
			<tr>
				<td class="aui-w50">
					<aui:select name="maCTVSearch" label="Cộng tác viên" cssClass="input-select2" onchange="searchURL();showHideThuTienTet();">
						 <aui:option value=" " label="Tất cả" />
						 <c:forEach items="<%= ctvs%>" var="item">
						 	<aui:option value="${item.ma}" label="${item.hoTen} - ${item.ma}"/>
						</c:forEach>
					</aui:select>
				</td>
				<td>
					<aui:input cssClass="input-date" name="ngayThuTienSearch" label="Ngày thu tiền" placeholder="dd/MM/yyyy" value="<%=sdf.format(new Date()) %>" onchange="searchURL();">
					</aui:input>
				</td>
			</tr>
			<tr>
				<td  colspan="2">
					<button id="<portlet:namespace />thuTienBtn" type="button" class="btn btn-labeled btn-danger" onclick="thuTien();">
						<span class="btn-label"><i class="glyphicon glyphicon-ok"></i></span>Xác nhận đã thu
					</button>
					<button id="<portlet:namespace />thuTienTruocBtn" type="button" class="btn-labeled btn btn-success" onclick="<%=oppenThuTienTruoc%>">
						<span class="btn-label"><i class="glyphicon glyphicon-send"></i></span>Thu tiền tết
					</button>
					<button id="<portlet:namespace />inPhieuThuHangNgay" type="button" class="btn btn-labeled btn-info" onclick="printPhieuThuTienHangNgay();">
						<span class="btn-label"><i class="glyphicon glyphicon-print "></i></span>In Phiếu Thu
					</button>
				</td>
			</tr>
		<tr>
			<td colspan="2">
				<div id="<portlet:namespace />contentDataTable" style="overflow-x: scroll;font-size: small;" name="<portlet:namespace />contentDataTable"></div>
			<td>
		</tr>
	</table>
	<table class="info table-pa5 aui-w100">
	</table>
</aui:form>
<portlet:renderURL var="searchURL"
	windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<portlet:param name="mvcPath" value="/html/phatvay/thutienhangngay/data.jsp" />
</portlet:renderURL>
<portlet:resourceURL var="thuTienURL" id="thuTienURL"></portlet:resourceURL>
<portlet:resourceURL var="printPhieuThuTienHangNgay" id="printPhieuThuTienHangNgay"></portlet:resourceURL>
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
	var maCTVSearchNode = A.one('#<portlet:namespace />maCTVSearch');
	var thuTienTruocBtnNode = A.one('#<portlet:namespace />thuTienTruocBtn');
	thuTienTruocBtnNode.hide();
	Liferay.provide(window,'showHideThuTienTet', function(){
		if(maCTVSearchNode.val() != '' && maCTVSearchNode.val() != ' '){
			thuTienTruocBtnNode.show();
		}else{
			thuTienTruocBtnNode.hide();
		}
	});
	Liferay.provide(window,'searchURL', function(){
		var ngayThuTien = 0;
		var pattern = /(\d{2})\/(\d{2})\/(\d{4})/;
		var ngayThuTienSearchVal = A.one('#<portlet:namespace />ngayThuTienSearch').val();
		if (('' != ngayThuTienSearchVal && pattern.test(ngayThuTienSearchVal)) && 'dd/MM/yyyy' != ngayThuTienSearchVal) {
			var date = new Date(ngayThuTienSearchVal.replace(pattern, '$3-$2-$1'));
			ngayThuTien = date.getTime();
		}
		var data = {
			'<portlet:namespace/>ngayThuTien' : ngayThuTien,
        	'<portlet:namespace/>maCTVSearch' : A.one('#<portlet:namespace />maCTVSearch').val()
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
	searchURL();
	Liferay.provide(window,'thuTien', function(){
		var check = confirm('Bạn có chắc thực hiện thao tác này ?');
		if (check) {
			loadingMask.show();
			var ngayThuTien = 0;
			var pattern = /(\d{2})\/(\d{2})\/(\d{4})/;
			var ngayThuTienSearchVal = A.one('#<portlet:namespace />ngayThuTienSearch').val();
			if (('' != ngayThuTienSearchVal && pattern.test(ngayThuTienSearchVal)) && 'dd/MM/yyyy' != ngayThuTienSearchVal) {
				var date = new Date(ngayThuTienSearchVal.replace(pattern, '$3-$2-$1'));
				ngayThuTien = date.getTime();
			}
			var data = {
				'<portlet:namespace/>ngayThuTien' : ngayThuTien,
	        	'<portlet:namespace/>maCTVSearch' : A.one('#<portlet:namespace />maCTVSearch').val()
	        }
			A.io.request('${thuTienURL}', {
		               method: 'post',
		               data : data,
		               on: {
		                   success: function() {
		                   		if(this.get('responseData')){
		                   			var data = JSON.parse(this.get('responseData'));
		                   			if(!data.exception){
	                   					searchURL();
	                   					toastr.success('Đã xác nhận thu tiền thành công', 'Thông báo!');
		                   			}else{
	                   					toastr.error('Yêu cầu thực hiện không thành công', 'Lỗi!');
		                   			}
		                   		}
               			       loadingMask.hide();
		                   }
		              }
	        });
		}
	});
	Liferay.provide(window,'printPhieuThuTienHangNgay', function(){
		var url = '${printPhieuThuTienHangNgay}';
		var ngayThuTien = 0;
		var pattern = /(\d{2})\/(\d{2})\/(\d{4})/;
		var ngayThuTienSearchVal = A.one('#<portlet:namespace />ngayThuTienSearch').val();
		if (('' != ngayThuTienSearchVal && pattern.test(ngayThuTienSearchVal)) && 'dd/MM/yyyy' != ngayThuTienSearchVal) {
			var date = new Date(ngayThuTienSearchVal.replace(pattern, '$3-$2-$1'));
			ngayThuTien = date.getTime();
		}
		url += '&<portlet:namespace/>ngayThuTien=' + ngayThuTien;
		url += '&<portlet:namespace/>maCTVSearch=' + A.one('#<portlet:namespace />maCTVSearch').val();
		window.location.href = url;
	});
	Liferay.provide(window,'openDialogThuTienTruoc', function(url,title,dialogId){
		url += '&<portlet:namespace/>maCTVSearch=' + A.one('#<portlet:namespace />maCTVSearch').val();
		Liferay.Util.openWindow({
			dialog : {
				centered : true,
				height : 800,
				modal : true,
				width : 1200
			},
			id : '<portlet:namespace />' + dialogId,
			title : title,
			uri : url
		});
	});
	Liferay.provide(window,'dongPopup', function(dialogId){
		var dialog = Liferay.Util.Window.getById('<portlet:namespace />' + dialogId);
		if(dialog){
			dialog.destroy();
		}
	});
	Liferay.provide(window,'thongBao', function(msg){
		toastr.success(msg, 'Thông báo!');
	});
});
</aui:script>