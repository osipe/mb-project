<%@page import="com.mb.service.CongTacVienLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.mb.model.CongTacVien"%>
<%@page import="com.mb.service.KhachHangLocalServiceUtil"%>
<%@page import="com.mb.model.KhachHang"%>
<%@page import="java.util.Locale"%>
<%@page import="com.liferay.portal.kernel.util.LocaleUtil"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/danhmuc/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	boolean manHinhPhatVay = ParamUtil.getBoolean(request, "manHinhPhatVay");
	long khachHangId = ParamUtil.getLong(request, "khachHangId");
	KhachHang kh = KhachHangLocalServiceUtil.createKhachHang(0L);
	List<CongTacVien> ctvs = CongTacVienLocalServiceUtil.findBase( "", "", "", "", 1, -1, -1, null);
	if(khachHangId > 0){
		kh = KhachHangLocalServiceUtil.fetchKhachHang(khachHangId);
	}
	if(kh == null){
		kh = KhachHangLocalServiceUtil.createKhachHang(0L);
	}
	Locale localeEn = new Locale("en", "EN");
    NumberFormat df = NumberFormat.getInstance(localeEn);
%>
<c:set value="<%=kh %>" var="kh"/>
<aui:form name="frmAddKhacHang">
	<table class="info table-pa5 aui-w100">
		<tr>
			<td>
				<aui:input class="input-text" name="ma" label="Mã" value="<%=kh.getMa() %>">
					<aui:validator name="required" errorMessage="Mã không được bỏ trống!" />
				</aui:input>
			</td>
			<td>
				<aui:select name="maCTV" label="Cộng tác viên"  cssClass="input-select2">
					 <aui:option value=" " label="Chọn"/>
					<c:forEach items="<%= ctvs%>" var="item">
						 <aui:option value="${item.ma}" label="${item.hoTen}" selected="${kh.maCTV.equals(item.ma)}"/>
					</c:forEach>
					<aui:validator name="required" errorMessage="CTV không được bỏ trống!" />
				</aui:select>
			</td>
		</tr>
		<tr>
			<td>
				<aui:input name="hoTen" class="input-text" label="Họ tên" value="<%=kh.getHoTen() %>">
					<aui:validator name="required" errorMessage="Họ tên không được bỏ trống!" />
				</aui:input>
			</td>
			<td>
				<aui:input name="soCMND" class="input-text" label="Số CMND" value="<%=kh.getSoCMND() %>">
					<aui:validator name="required" errorMessage="Họ tên không được bỏ trống!" />
				</aui:input>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<aui:input name="diaChi" class="input-text" label="Địa chỉ" value="<%=kh.getDiaChi() %>">
				</aui:input>
			</td>
		</tr>
		<tr>
			<td>
				<button id="<portlet:namespace />luu" type="button" class="btn btn-labeled btn-default" onclick="save(true);">
					<span class="btn-label"><i class="glyphicon glyphicon-floppy-disk"></i></span><%=khachHangId == 0 ? "Lưu" : "Cập nhật" %>
				</button>
				<%
					if(khachHangId == 0){
				%>
					<button onclick="save(false);" type="button" class="btn btn-labeled btn-primary">
						<span class="btn-label"><i class="glyphicon glyphicon-copy"></i></span>Lưu và nhập tiếp
					</button>
				<%
					} 
				%>
				<button onclick="Liferay.Util.getOpener().dongPopup();" type="button"class="btn btn-labeled btn-danger">
					<span class="btn-label"><i class="glyphicon glyphicon-remove-circle"></i></span>Đóng
				</button>
			</td>
		</tr>
	</table>
</aui:form>
<portlet:resourceURL var="addURL" id="addKhachHangURL"></portlet:resourceURL>
<aui:script use="aui-base,aui-io-plugin-deprecated,aui-loading-mask-deprecated">
AUI().ready(['aui-base'], function(A) {
	$('.input-select2').select2({
		placeholder : 'Chọn',
		allowClear : true,
		language : {
			noResults : function() {
				return '';
			}
		}
	});
	var form  = A.one('#<portlet:namespace />frmAddKhacHang');
	var loadingMask = new A.LoadingMask(
		{
			target: form
		}
	);
	var formValidator = Liferay.Form.get('<portlet:namespace />frmAddKhacHang').formValidator;
	Liferay.provide(window,'save', function(close){
		loadingMask.show();
		formValidator.validate();
		if(!formValidator.hasErrors()){
			var data = {
				<portlet:namespace />khachHangId : '<%=khachHangId %>',
				<portlet:namespace />maCTV : form.one('#<portlet:namespace />maCTV').val(),
				<portlet:namespace />ma : form.one('#<portlet:namespace />ma').val(),
				<portlet:namespace />hoTen : form.one('#<portlet:namespace />hoTen').val(),
				<portlet:namespace />soCMND : form.one('#<portlet:namespace />soCMND').val(),
				<portlet:namespace />diaChi : form.one('#<portlet:namespace />diaChi').val(),
			}
			console.log(data);
			A.io.request('${addURL}', {
	               method: 'post',
	               data: data,
	               on: {
	                   success: function() {
	                   		if(this.get('responseData')){
	                   			var data = JSON.parse(this.get('responseData'));
	                   			if(!data.exception){
	                   				refreshData();
	                   				if(<%= manHinhPhatVay%>){
	                   					Liferay.Util.getOpener().getDataKhachHang();
	                   				}else{
	                   					Liferay.Util.getOpener().search();
	                   				}
	                   				console.log("close : ",close);
	                   				if(close){
	                   					Liferay.Util.getOpener().dongPopup();
	                   					Liferay.Util.getOpener().thongBao();
	                   				}else{
	                   					toastr.success('Thêm khách hàng thành công', 'Thông báo!');
	                   				}
	                   			}else{
	                   				if(data.exception.indexOf('class com.dm.exception.TrungMaException') > -1){
	                   					toastr.warning('Mã khách hàng đã tồn tại', 'Cảnh báo!');
	                   				}else if(data.exception.indexOf('class com.mb.exception.TrungSoCMNDException') > -1){
	                   					toastr.warning('Số CMND đã tồn tại', 'Cảnh báo!');
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