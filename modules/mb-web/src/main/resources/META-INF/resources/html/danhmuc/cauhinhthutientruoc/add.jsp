<%@page import="java.util.Calendar"%>
<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="java.util.Date"%>
<%@page import="com.mb.service.CauHinhThuTienTruocLocalServiceUtil"%>
<%@page import="com.mb.model.CauHinhThuTienTruoc"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.LocaleUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/danhmuc/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	long cauHinhThuTienTruocId = ParamUtil.getLong(request, "cauHinhThuTienTruocId");
	int namNow = Calendar.getInstance().get(Calendar.YEAR);
	int nam = namNow + 1;
	CauHinhThuTienTruoc kh = CauHinhThuTienTruocLocalServiceUtil.createCauHinhThuTienTruoc(0L);
	if(cauHinhThuTienTruocId > 0){
		kh = CauHinhThuTienTruocLocalServiceUtil.fetchCauHinhThuTienTruoc(cauHinhThuTienTruocId);
		nam = kh.getNam();
	}
	if(kh == null){
		kh = CauHinhThuTienTruocLocalServiceUtil.createCauHinhThuTienTruoc(0L);
	}
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	String ngayBatDauThuTienCauHinh = PropsUtil.get("config.ngaythutientruocstart") + "/" + (namNow + 1);
	String ngayKetThucThuTienCauHinh = PropsUtil.get("config.ngaythutientruocend") + "/" + (namNow + 1);
%>
<c:set value="<%=kh %>" var="kh"/>
<aui:form name="frmAddKhacHang">
	<table class="info table-pa5 aui-w100">
		<tr>
			<td>
				<aui:select name="nam" label="Năm"  cssClass="input-select2">
					<aui:option value=" " label="Chọn"/>
					<%
						for (int i = namNow - 5; i <= namNow + 5; i++) {
					%>
						<aui:option value="<%=i%>" label='<%="Năm " + i%>' selected="<%=i == nam%>" />
					<%
						}
					%>
					<aui:validator name="required" errorMessage="Năm không được bỏ trống!" />
				</aui:select>
			</td>
		</tr>
		<tr>
			<td>
				<aui:input cssClass="input-date" name="ngayTu" label="Ngày từ" placeholder="dd/MM/yyyy" value="<%=kh.getNgayTu() != null ? sdf.format(kh.getNgayTu()) : ngayBatDauThuTienCauHinh%>">
				</aui:input>
			</td>
			<td>
				<aui:input cssClass="input-date" name="ngayDen" label="Ngày đến" placeholder="dd/MM/yyyy" value="<%=kh.getNgayDen() != null ? sdf.format(kh.getNgayDen()) : ngayKetThucThuTienCauHinh%>">
				</aui:input>
			</td>
		</tr>
		<tr>
			<td>
				<button id="<portlet:namespace />luu" type="button" class="btn btn-labeled btn-default" onclick="save(true);">
					<span class="btn-label"><i class="glyphicon glyphicon-floppy-disk"></i></span><%=cauHinhThuTienTruocId == 0 ? "Lưu" : "Cập nhật" %>
				</button>
				<%
					if(cauHinhThuTienTruocId == 0){
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
<portlet:resourceURL var="addURL" id="add"></portlet:resourceURL>
<aui:script use="aui-base,aui-io-plugin-deprecated,aui-loading-mask-deprecated">
AUI().ready(['aui-base'], function(A) {
	$('.input-date').datepicker();
	$('.input-date').mask('99/99/9999');
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
			var ngayTuTime = 0;
			var pattern = /(\d{2})\/(\d{2})\/(\d{4})/;
			var ngayTuVal = form.one('#<portlet:namespace />ngayTu').val();
			if ('' != ngayTuVal && pattern.test(ngayTuVal) && 'dd/MM/yyyy' != ngayTuVal) {
				var date = new Date(ngayTuVal.replace(pattern, '$3-$2-$1'));
				ngayTuTime = date.getTime();
			}
			var ngayDenTime = 0;
			var ngayDenVal = form.one('#<portlet:namespace />ngayDen').val();
			if ('' != ngayDenVal && pattern.test(ngayDenVal) && 'dd/MM/yyyy' != ngayDenVal) {
				var date = new Date(ngayDenVal.replace(pattern, '$3-$2-$1'));
				ngayDenTime = date.getTime();
			}
			
			var data = {
				<portlet:namespace />cauHinhThuTienTruocId : '<%=cauHinhThuTienTruocId %>',
				<portlet:namespace />nam : form.one('#<portlet:namespace />nam').val(),
				<portlet:namespace />ngayTuTime : ngayTuTime,
				<portlet:namespace />ngayDenTime : ngayDenTime
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
	                   				if(close){
	                   					Liferay.Util.getOpener().dongPopup();
	                   					Liferay.Util.getOpener().thongBao();
	                   				}else{
	                   					toastr.success('Thêm cấu hình thành công', 'Thông báo!');
	                   				}
	                   			}else{
	                   				if(data.TrungNam){
	                   					toastr.error('Năm ' + form.one('#<portlet:namespace />nam').val() + ' đã được cấu hình', 'Lỗi!');
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