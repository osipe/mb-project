<%@page import="com.mb.model.LoaiTaiSan"%>
<%@page import="com.mb.service.LoaiTaiSanLocalServiceUtil"%>
<%@page import="java.util.Locale"%>
<%@page import="com.liferay.portal.kernel.util.LocaleUtil"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/danhmuc/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	long loaiTaiSanId = ParamUtil.getLong(request, "loaiTaiSanId");
	LoaiTaiSan lts = LoaiTaiSanLocalServiceUtil.createLoaiTaiSan(0L);
	if(loaiTaiSanId > 0){
		lts = LoaiTaiSanLocalServiceUtil.fetchLoaiTaiSan(loaiTaiSanId);
	}
	if(lts == null){
		lts = LoaiTaiSanLocalServiceUtil.createLoaiTaiSan(0L);
	}
	Locale localeEn = new Locale("en", "EN");
    NumberFormat df = NumberFormat.getInstance(localeEn);
%>
<c:set value="<%=lts %>" var="lts"/>
<c:set value="<%=df %>" var="df"/>
<aui:form name="frmAdd">
	<table class="info table-pa5 aui-w100">
		<tr>
			<td>
				<aui:input class="input-text" name="ten" label="Tên" value="${lts.ten}">
					<aui:validator name="required" errorMessage="Tên không được bỏ trống!" />
				</aui:input>
			</td>
			<td>
				<aui:input name="ma" class="input-text" label="Mã"  value="${lts.ma}">
					<aui:validator name="required" errorMessage="Mã không được bỏ trống!" />
				</aui:input>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<aui:input name="ghiChu" class="input-text" label="Ghi Chú"  value="${ls.ghiChu}">
				</aui:input>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<button id="<portlet:namespace />luu" type="button" class="btn btn-labeled btn-default" onclick="save(true);">
					<span class="btn-label"><i class="glyphicon glyphicon-floppy-disk"></i></span><%=loaiTaiSanId == 0 ? "Lưu" : "Cập nhật" %>
				</button>
				<%
					if(loaiTaiSanId == 0){
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
	Liferay.provide(window,'save', function(close){
		loadingMask.show();
		formValidator.validate();
		if(!formValidator.hasErrors()){
			var data = {
				<portlet:namespace />loaiTaiSanId : '<%=loaiTaiSanId %>',
				<portlet:namespace />ten : form.one('#<portlet:namespace />ten').val(),
				<portlet:namespace />ma : form.one('#<portlet:namespace />ma').val(),
				<portlet:namespace />ghiChu : form.one('#<portlet:namespace />ghiChu').val(),
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
	                   					toastr.success('Thêm danh mục loại tài sản thành công', 'Thông báo!');
	                   				}
	                   			}else{
	                   				if(data.exception.indexOf('com.mb.exception.TrungMaException') > -1){
	                   					toastr.warning('Mã loại tài sản đã tồn tại', 'Cảnh báo!');
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