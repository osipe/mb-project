<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="com.mb.service.TaiKhoanDoiUngLocalServiceUtil"%>
<%@page import="com.mb.model.TaiKhoanDoiUng"%>
<%@page import="java.util.List"%>
<%@page import="com.mb.service.LichSuTaiKhoanDauKyLocalServiceUtil"%>
<%@page import="com.mb.model.LichSuTaiKhoanDauKy"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/danhmuc/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	long lichSuTaiKhoanDauKyId = ParamUtil.getLong(request, "lichSuTaiKhoanDauKyId");
	LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy = LichSuTaiKhoanDauKyLocalServiceUtil.createLichSuTaiKhoanDauKy(0L);
	if(lichSuTaiKhoanDauKyId > 0){
		lichSuTaiKhoanDauKy = LichSuTaiKhoanDauKyLocalServiceUtil.fetchLichSuTaiKhoanDauKy(lichSuTaiKhoanDauKyId);
	}
	if(lichSuTaiKhoanDauKy == null){
		lichSuTaiKhoanDauKy = LichSuTaiKhoanDauKyLocalServiceUtil.createLichSuTaiKhoanDauKy(0L);
	}
	Locale localeEn = new Locale("en", "EN");
    NumberFormat df = NumberFormat.getInstance(localeEn);
	List<TaiKhoanDoiUng> items = TaiKhoanDoiUngLocalServiceUtil.findBase( 0, "", "", 1, -1, -1, null);
%>
<c:set var="lichSuTaiKhoanDauKy" value="<%=lichSuTaiKhoanDauKy %>"></c:set>
<aui:form name="frmAdd">
	<table class="info table-pa5 aui-w100">
		<tr>
			<td>
				<aui:input name="thang" class="input-text" label="Tháng" value="<%=lichSuTaiKhoanDauKy.getThang()%>">
					<aui:validator name="required" errorMessage="Tháng không được bỏ trống!" />
					<aui:validator name="digits"/>
				</aui:input>
			</td>
			<td>
				<aui:input name="nam" class="input-text" label="Năm" value="<%=lichSuTaiKhoanDauKy.getNam()%>">
					<aui:validator name="required" errorMessage="Năm không được bỏ trống!" />
					<aui:validator name="digits"/>
				</aui:input>
			</td>
		</tr>
		<tr>
			<td>
				<aui:select name="taiKhoanDoiUngId" label="Tài khoản đối ứng">
					 <c:forEach items="<%= items%>" var="item">
						 	<aui:option value="${item.taiKhoanDoiUngId}" label="${item.ten}" selected="${item.taiKhoanDoiUngId == lichSuTaiKhoanDauKy.taiKhoanDoiUngId}"/>
					</c:forEach>
					<aui:validator name="required" errorMessage="Tài khoản đối ứng không được bỏ trống!" />
				</aui:select>
			</td>
			<td>
				<aui:input name="soTienTon" onkeypress="_formatNumber();" class="input-text" label="Số tiền tồn" value="<%=(lichSuTaiKhoanDauKy.getSoTienTon() != null && lichSuTaiKhoanDauKy.getSoTienTon() > 0) ? df.format(lichSuTaiKhoanDauKy.getSoTienTon()) : "0"%>"/>
			</td>
		</tr>
		<tr>
			<td>
				<button id="<portlet:namespace />luu" type="button" class="btn btn-labeled btn-default" onclick="save(true);">
					<span class="btn-label"><i class="glyphicon glyphicon-floppy-disk"></i></span><%=lichSuTaiKhoanDauKyId == 0 ? "Lưu" : "Cập nhật" %>
				</button>
				<%
					if(lichSuTaiKhoanDauKyId == 0){
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
				<portlet:namespace />lichSuTaiKhoanDauKyId : '<%=lichSuTaiKhoanDauKyId %>',
				<portlet:namespace />thang : form.one('#<portlet:namespace />thang').val(),
				<portlet:namespace />nam : form.one('#<portlet:namespace />nam').val(),
				<portlet:namespace />taiKhoanDoiUngId : form.one('#<portlet:namespace />taiKhoanDoiUngId').val(),
				<portlet:namespace />soTienTon : form.one('#<portlet:namespace />soTienTon').val()
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
	                   					toastr.success('Thêm đầu kỳ thành công', 'Thông báo!');
	                   				}
	                   			}else{
	                   				if(data.exception.indexOf('class com.dm.exception.TrungDuLieuDauKy') > -1){
	                   					toastr.warning('Dữ liệu đầu kỳ đã có', 'Cảnh báo!');
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