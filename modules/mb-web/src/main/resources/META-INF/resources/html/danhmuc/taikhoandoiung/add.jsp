<%@page import="java.util.List"%>
<%@page import="com.mb.service.TaiKhoanDoiUngLocalServiceUtil"%>
<%@page import="com.mb.model.TaiKhoanDoiUng"%>
<%@page import="com.liferay.portal.kernel.util.LocaleUtil"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/danhmuc/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	long taiKhoanDoiUngId = ParamUtil.getLong(request, "taiKhoanDoiUngId");
	TaiKhoanDoiUng taiKhoanDoiUng = TaiKhoanDoiUngLocalServiceUtil.createTaiKhoanDoiUng(0L);
	if(taiKhoanDoiUngId > 0){
		taiKhoanDoiUng = TaiKhoanDoiUngLocalServiceUtil.fetchTaiKhoanDoiUng(taiKhoanDoiUngId);
	}
	if(taiKhoanDoiUng == null){
		taiKhoanDoiUng = TaiKhoanDoiUngLocalServiceUtil.createTaiKhoanDoiUng(0L);
	}
	DecimalFormat df = new DecimalFormat("###,###.###");
	List<TaiKhoanDoiUng> taiKhoanDoiUngs = TaiKhoanDoiUngLocalServiceUtil.findBase(0, "", "", 0, -1, -1, null);
%>
<c:set var="taiKhoanDoiUng" value="<%=taiKhoanDoiUng %>"/>
<aui:form name="frmAdd">
	<table class="info table-pa5 aui-w100">
		<tr>
			<td>
				<aui:select name="taiKhoanDoiUngChaId" label="Tài khoản cha">
					<aui:option value=" " label="Chọn" />
					 <c:forEach items="<%= taiKhoanDoiUngs%>" var="item">
					 	<aui:option value="${item.taiKhoanDoiUngId}" label="${item.ten}" selected="${taiKhoanDoiUng.taiKhoanDoiUngChaId ==  item.taiKhoanDoiUngId}"/>
					</c:forEach>
				</aui:select>
			</td>
			<td>
				<aui:select name="loaiTaiKhoan" label="Loại tài khoản">
					<aui:option value="1" label="Công ty" selected = "${taiKhoanDoiUng.loaiTaiKhoan == 1}" />
					<aui:option value="2" label="Cộng tác viên" selected = "${taiKhoanDoiUng.loaiTaiKhoan == 2}"/>
				</aui:select>
			</td>
		</tr>
		<tr>
			<td>
				<aui:input class="input-text" name="ten" label="Tên tài khoản" value="<%=taiKhoanDoiUng.getTen()%>">
					<aui:validator name="required" errorMessage="Tên không được bỏ trống!" />
				</aui:input></td>
			<td>
				<aui:input name="soHieu" class="input-text" label="Số hiệu tài khoản" value="<%=taiKhoanDoiUng.getSoHieu()%>">
					<aui:validator name="required" errorMessage="Số hiệu không được bỏ trống!" />
				</aui:input>
			</td>
		</tr>
		<tr>
			<td>
				<button id="<portlet:namespace />luu" type="button" class="btn btn-labeled btn-default" onclick="save(true);">
					<span class="btn-label"><i class="glyphicon glyphicon-floppy-disk"></i></span><%=taiKhoanDoiUngId == 0 ? "Lưu" : "Cập nhật" %>
				</button>
				<%
					if(taiKhoanDoiUngId == 0){
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
				<portlet:namespace />taiKhoanDoiUngId : '<%=taiKhoanDoiUngId %>',
				<portlet:namespace />taiKhoanDoiUngChaId : form.one('#<portlet:namespace />taiKhoanDoiUngChaId').val(),
				<portlet:namespace />ten : form.one('#<portlet:namespace />ten').val(),
				<portlet:namespace />soHieu : form.one('#<portlet:namespace />soHieu').val(),
				<portlet:namespace />loaiTaiKhoan : form.one('#<portlet:namespace />loaiTaiKhoan').val()
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
	                   					toastr.success('Thêm tài khoản đối ứng thành công', 'Thông báo!');
	                   				}
	                   			}else{
	                   				if(data.exception.indexOf('class com.dm.exception.TrungSoHieu') > -1){
	                   					toastr.warning('Số hiệu tài khoản đã tồn tại', 'Cảnh báo!');
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