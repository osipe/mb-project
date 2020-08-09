<%@page import="java.util.Locale"%>
<%@page import="com.mb.service.MaSoThuChiLocalServiceUtil"%>
<%@page import="com.mb.model.MaSoThuChi"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.LocaleUtil"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/danhmuc/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	long maSoThuChiId = ParamUtil.getLong(request, "maSoThuChiId");
	MaSoThuChi maSoThuChi = MaSoThuChiLocalServiceUtil.createMaSoThuChi(0L);
	if(maSoThuChiId > 0){
		maSoThuChi = MaSoThuChiLocalServiceUtil.fetchMaSoThuChi(maSoThuChiId);
	}
	if(maSoThuChi == null){
		maSoThuChi = MaSoThuChiLocalServiceUtil.createMaSoThuChi(0L);
	}
	Locale localeEn = new Locale("en", "EN");
    NumberFormat df = NumberFormat.getInstance(localeEn);
%>
<aui:form name="frmAdd">
	<table class="info table-pa5 aui-w100">
		<tr>
			<td>
				<aui:input class="input-text" name="ma" label="Mã" value="<%=maSoThuChi.getMa()%>">
					<aui:validator name="required" errorMessage="Mã không được bỏ trống!" />
				</aui:input>
			</td>
			<td>
				<aui:select name="loai" label="Loại">
					 <aui:option value="0" label="Chọn"/>
					 <aui:option value="1" label="Thu" selected="<%=maSoThuChi.getLoai() == 1 %>"/>
					 <aui:option value="2" label="Chi" selected="<%=maSoThuChi.getLoai() == 2%>"/>
					 <aui:validator name="required" errorMessage="Loại không được bỏ trống!" />
				</aui:select>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<aui:input class="input-text" name="dienGiai" label="Diễn giải" value="<%=maSoThuChi.getDienGiai()%>">
					<aui:validator name="required" errorMessage="Diễn giải không được bỏ trống!" />
				</aui:input>
			</td>
		</tr>
		<tr>
			<td>
				<button id="<portlet:namespace />luu" type="button" class="btn btn-labeled btn-default" onclick="save(true);">
					<span class="btn-label"><i class="glyphicon glyphicon-floppy-disk"></i></span><%=maSoThuChiId == 0 ? "Lưu" : "Cập nhật" %>
				</button>
				<%
					if(maSoThuChiId == 0){
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
<aui:script use="aui-base,aui-io-plugin-deprecated,aui-loading-mask-deprecated">
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
				<portlet:namespace />maSoThuChiId : '<%=maSoThuChiId %>',
				<portlet:namespace />ma : form.one('#<portlet:namespace />ma').val(),
				<portlet:namespace />loai : form.one('#<portlet:namespace />loai').val(),
				<portlet:namespace />dienGiai : form.one('#<portlet:namespace />dienGiai').val()
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