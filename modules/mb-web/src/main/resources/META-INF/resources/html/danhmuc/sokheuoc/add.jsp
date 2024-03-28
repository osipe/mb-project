<%@page import="com.mb.service.SoKheUocLocalServiceUtil"%>
<%@page import="com.mb.model.SoKheUoc"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.LocaleUtil"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/danhmuc/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	long soKheUocId = ParamUtil.getLong(request, "soKheUocId");
	SoKheUoc soKheUoc = SoKheUocLocalServiceUtil.createSoKheUoc(0L);
	if (soKheUocId > 0) {
		soKheUoc = SoKheUocLocalServiceUtil.fetchSoKheUoc(soKheUocId);
	}
	if (soKheUoc == null) {
		soKheUoc = SoKheUocLocalServiceUtil.createSoKheUoc(0L);
	}
	Locale localeEn = new Locale("en", "EN");
	NumberFormat df = NumberFormat.getInstance(localeEn);
%>
<c:set var="soKheUoc" value="<%=soKheUoc%>" />
<aui:form name="frmAdd">
	<table class="info table-pa5 aui-w100">
		<tr>
			<td>
				<aui:input class="input-text" name="cauTruc" label="Cấu trúc" value="<%=soKheUoc.getCauTruc()%>">
					<aui:validator name="required" errorMessage="Cấu trúc không được bỏ trống!" />
				</aui:input>
			</td>
			<td>
				<aui:input class="input-text" type="number" name="so" label="Số" value="<%=soKheUoc.getSo()%>">
					<aui:validator name="required" errorMessage="Số không được bỏ trống!" />
				</aui:input>
			</td>
		</tr>
		
		<tr>
			<td>
				<button id="<portlet:namespace />luu" type="button"
					class="btn btn-labeled btn-default" onclick="save(true);">
					<span class="btn-label"><i
						class="glyphicon glyphicon-floppy-disk"></i></span><%=soKheUocId == 0 ? "Lưu" : "Cập nhật"%>
				</button> <%
 	if (soKheUocId == 0) {
 %>
				<button id="<portlet:namespace />luuvanhaptiep"
					onclick="save(false);" type="button"
					class="btn btn-labeled btn-primary">
					<span class="btn-label"><i class="glyphicon glyphicon-copy"></i></span>Lưu
					và nhập tiếp
				</button> <%
 	}
 %>
				<button id="<portlet:namespace />dong"
					onclick="Liferay.Util.getOpener().dongPopup();" type="button"
					class="btn btn-labeled btn-danger">
					<span class="btn-label"><i
						class="glyphicon glyphicon-remove-circle"></i></span>Đóng
				</button>
			</td>
		</tr>
	</table>
</aui:form>
<portlet:resourceURL var="addOrUpdateURL" id="addOrUpdateURL"></portlet:resourceURL>
<aui:script
	use="aui-base,aui-io-plugin-deprecated,aui-loading-mask-deprecated">
AUI().ready(['aui-base'], function(A) {
	var form  = A.one('#<portlet:namespace />frmAdd');
	var loadingMask = new A.LoadingMask(
		{
			target: form
		}
	);
	var formValidator = Liferay.Form.get('<portlet:namespace />frmAdd').formValidator;
	Liferay.provide(window,'save', function(close){
		loadingMask.show();
		formValidator.validate();
		if(!formValidator.hasErrors()){
			var data = {
				<portlet:namespace />soKheUocId : '<%=soKheUocId%>',
				<portlet:namespace />cauTruc : form.one('#<portlet:namespace />cauTruc').val(),
				<portlet:namespace />so : form.one('#<portlet:namespace />so').val()
			}
			A.io.request('${addOrUpdateURL}', {
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
	                   					toastr.success('Thêm mã số thành công', 'Thông báo!');
	                   				}
	                   			}else{
	                   				if(data.exception.indexOf('class com.dm.exception.TrungMa') > -1){
	                   					toastr.warning('Mã đã tồn tại', 'Cảnh báo!');
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