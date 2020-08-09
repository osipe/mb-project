<%@page import="com.mb.service.LaiSuatLocalServiceUtil"%>
<%@page import="com.mb.model.LaiSuat"%>
<%@page import="java.util.Locale"%>
<%@page import="com.liferay.portal.kernel.util.LocaleUtil"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/danhmuc/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	long laiSuatId = ParamUtil.getLong(request, "laiSuatId");
	LaiSuat ls = LaiSuatLocalServiceUtil.createLaiSuat(0L);
	if(laiSuatId > 0){
		ls = LaiSuatLocalServiceUtil.fetchLaiSuat(laiSuatId);
	}
	if(ls == null){
		ls = LaiSuatLocalServiceUtil.createLaiSuat(0L);
	}
	Locale localeEn = new Locale("en", "EN");
    NumberFormat df = NumberFormat.getInstance(localeEn);
%>
<c:set value="<%=ls %>" var="ls"/>
<c:set value="<%=df %>" var="df"/>
<aui:form name="frmAdd">
	<table class="info table-pa5 aui-w100">
		<tr>
			<td>
				<aui:input class="input-text" onkeypress="_formatNumber();" onchange="tinhLaiSuat()" name="soTienVay" label="Số tiền vay" value="${not empty ls.soTienVay ? df.format(ls.soTienVay) : ''}">
					<aui:validator name="required" errorMessage="Số tiền vay không được bỏ trống!" />
				</aui:input>
			</td>
			<td>
				<aui:input name="thoiHan" class="input-text" label="Thời hạn" onchange="tinhLaiSuat()" value="${ls.thoiHan}">
					<aui:validator name="digits" errorMessage="Thời hạn phải là số" />
					<aui:validator name="required" errorMessage="Thời hạn không được bỏ trống!" />
				</aui:input>
			</td>
			<td>
				<aui:input class="input-text" onkeypress="isNumber(event);" onchange="tinhLaiSuat()" name="laiSuatVay" label="Lãi suất vay" value="${ls.laiSuatVay}">
					<aui:validator name="required" errorMessage="Lãi suất vay không được bỏ trống!" />
				</aui:input>
			</td>
		</tr>
		<tr>
			<td>
				<aui:input class="input-text" onchange="_formatNumber();" name="laiNgay" label="Tiền lãi ngày" value="${ls.laiNgay}" readonly="true">
				</aui:input>
			</td>
			<td>
				<aui:input class="input-text" onchange="_formatNumber();"  name="gocNgay"  label="Tiền gốc ngày" value="${ls.gocNgay}" readonly="true">
				</aui:input>
			</td>
			<td>
				<aui:input class="input-text" onchange="_formatNumber();"  name="gocNgayCuoi" label="Tiền gốc ngày cuối" value="${ls.gocNgayCuoi}" readonly="true">
				</aui:input>
			</td>
		</tr>
		<tr>
			<td colspan="3">
				<button id="<portlet:namespace />luu" type="button" class="btn btn-labeled btn-default" onclick="save(true);">
					<span class="btn-label"><i class="glyphicon glyphicon-floppy-disk"></i></span><%=laiSuatId == 0 ? "Lưu" : "Cập nhật" %>
				</button>
				<%
					if(laiSuatId == 0){
				%>
					<button id="<portlet:namespace />luuvanhaptiep" onclick="save(false);" type="button" class="btn btn-labeled btn-primary">
						<span class="btn-label"><i class="glyphicon glyphicon-copy"></i></span>Lưu và nhập tiếp
					</button>
				<%
					} 
				%>
				<button id="<portlet:namespace />dong" onclick="Liferay.Util.getOpener().dongPopup();" type="button"class="btn btn-labeled btn-danger">
					<span class="btn-label"><i class="glyphicon glyphicon-remove-circle"></i></span>Đóng
				</button>
			</td>
		</tr>
	</table>
</aui:form>
<portlet:resourceURL var="addURL" id="addURL"></portlet:resourceURL>
<aui:script use="aui-base,aui-io-plugin-deprecated,aui-loading-mask-deprecated,node-event-simulate">
AUI().ready(['aui-base','node-event-simulate'], function(A) {
	var form  = A.one('#<portlet:namespace />frmAdd');
	var loadingMask = new A.LoadingMask(
		{
			target: form
		}
	);
	var formValidator = Liferay.Form.get('<portlet:namespace />frmAdd').formValidator;
	Liferay.provide(window,'tinhLaiSuat', function(){
		var soTienVay = form.one('#<portlet:namespace />soTienVay').val().replace(/[,]/g, '');
		var thoiHan = form.one('#<portlet:namespace />thoiHan').val();
		var laiSuatVay = form.one('#<portlet:namespace />laiSuatVay').val();
		var gocNgay = 0;
		if(soTienVay > 0 && thoiHan > 0){
			gocNgay = Math.floor(soTienVay/thoiHan);
			var gocNgayCuoi = soTienVay - (gocNgay * (thoiHan - 1));
			form.one('#<portlet:namespace />gocNgay').val(gocNgay);
			form.one('#<portlet:namespace />gocNgayCuoi').val(gocNgayCuoi);
		}else{
			form.one('#<portlet:namespace />gocNgay').val('');
			form.one('#<portlet:namespace />gocNgayCuoi').val('');
		}
		if(soTienVay > 0 && laiSuatVay > 0 && thoiHan > 0){
			var laiNgay = Math.floor((soTienVay * laiSuatVay)/(30 * 100));
		    form.one('#<portlet:namespace />laiNgay').val(laiNgay);
		}else{
			  form.one('#<portlet:namespace />laiNgay').val('');
		}
		form.one('#<portlet:namespace />gocNgay').simulate('change');
		form.one('#<portlet:namespace />gocNgayCuoi').simulate('change');
		form.one('#<portlet:namespace />laiNgay').simulate('change');
	});
	Liferay.provide(window,'save', function(close){
		loadingMask.show();
		formValidator.validate();
		if(!formValidator.hasErrors()){
			var data = {
				<portlet:namespace />laiSuatId : '<%=laiSuatId %>',
				<portlet:namespace />soTienVay : form.one('#<portlet:namespace />soTienVay').val(),
				<portlet:namespace />thoiHan : form.one('#<portlet:namespace />thoiHan').val(),
				<portlet:namespace />laiSuatVay : form.one('#<portlet:namespace />laiSuatVay').val(),
				<portlet:namespace />gocNgay : form.one('#<portlet:namespace />gocNgay').val(),
				<portlet:namespace />laiNgay : form.one('#<portlet:namespace />laiNgay').val(),
				<portlet:namespace />gocNgayCuoi : form.one('#<portlet:namespace />gocNgayCuoi').val(),
			}
			A.io.request('${addURL}', {
	               method: 'post',
	               data: data,
	               on: {
	                   success: function() {
	                   		if(this.get('responseData')){
	                   			var data = JSON.parse(this.get('responseData'));
	                   			if(!data.exception){
	                   				refreshData();
	                   				Liferay.Util.getOpener().search();
	                   				if(close){
	                   					Liferay.Util.getOpener().dongPopup();
	                   					Liferay.Util.getOpener().thongBao();
	                   				}else{
	                   					toastr.success('Thêm danh mục lãi suất thành công', 'Thông báo!');
	                   				}
	                   			}else{
	                   				if(data.exception.indexOf('class com.dm.exception.TrungLaiSuat') > -1){
	                   					toastr.warning('Danh mục đã có loại lãi suất này', 'Cảnh báo!');
	                   				}else{
	                   					toastr.error('Yêu cầu thực hiện không thành công', 'Lỗi!');
	                   				}
	                   			}
	                   		}
	                   },
	                   failure : function() {
						}
	              }
	        });
        }
        loadingMask.hide();
	});
	Liferay.provide(window,'refreshData', function(){
		form.all('input').each(function(node){
			node.val('');
		});
	});
});
</aui:script>