<%@page import="com.mb.service.ChiNhanhLocalServiceUtil"%>
<%@page import="com.mb.model.ChiNhanh"%>
<%@page import="java.util.List"%>
<%@page import="com.mb.model.CongTacVien"%>
<%@page import="com.mb.service.CongTacVienLocalServiceUtil"%>
<%@page import="java.util.Locale"%>
<%@page import="com.liferay.portal.kernel.util.LocaleUtil"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/danhmuc/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<ChiNhanh> chiNhanhs = ChiNhanhLocalServiceUtil.findByHoatDong(true);
	long congTacVienId = ParamUtil.getLong(request, "congTacVienId");
	CongTacVien ctv = CongTacVienLocalServiceUtil.createCongTacVien(0L);
	if(congTacVienId > 0){
		ctv = CongTacVienLocalServiceUtil.fetchCongTacVien(congTacVienId);
	}
	if(ctv == null){
		ctv = CongTacVienLocalServiceUtil.createCongTacVien(0L);
	}
	Locale localeEn = new Locale("en", "EN");
    NumberFormat df = NumberFormat.getInstance(localeEn);
%>
<aui:form name="frmAdd">
	<table class="info table-pa5 aui-w100">
		<tr>
			<td>
				<aui:input class="input-text" name="maCongTacVien" label="Mã CTV" value="<%=ctv.getMa() %>">
					<aui:validator name="required" errorMessage="Mã CTV không được bỏ trống!" />
				</aui:input></td>
			<td>
				<aui:select name="chiNhanhId" label="Chi nhánh" cssClass="input-select2" onchange="search();">
				 <c:forEach items="<%= chiNhanhs%>" var="item">
					 	<aui:option value="${item.chiNhanhId}" label="${item.ten} - ${item.ma}"/>
					</c:forEach>
				</aui:select>
			</td>
		</tr>
		<tr>
			<td>
				<aui:input name="hoTen" class="input-text" label="Họ tên" value="<%=ctv.getHoTen() %>">
					<aui:validator name="required" errorMessage="Họ tên không được bỏ trống!" />
				</aui:input>
			</td>
			<td>
				<aui:input name="soCMND" class="input-text" label="Số CMND" value="<%=ctv.getSoCMND() %>">
					<aui:validator name="required" errorMessage="Họ tên không được bỏ trống!" />
				</aui:input>
			</td>
		</tr>
		<tr>
			<td>
				<aui:input name="duNoToiDa" onkeypress="_formatNumber();" class="input-text" label="Dư nợ tối đa" value="<%=ctv.getDuNoToiDa() == null ? "0" : df.format(ctv.getDuNoToiDa()) %>">
				</aui:input>
			</td>
			<td>
				<aui:input name="duNoToiDaTheChap" onkeypress="_formatNumber();" class="input-text" label="Dư nợ tối đa thế chấp" value="<%=ctv.getDuNoToiDaTheChap() == null ? "0" : df.format(ctv.getDuNoToiDaTheChap()) %>">
				</aui:input>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<aui:input name="diaChi" class="input-text" label="Địa chỉ" value="<%=ctv.getDiaChi() %>">
				</aui:input>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<aui:input name="ghiChu" class="input-text" label="Ghi chú" value="<%=ctv.getGhiChu() %>">
				</aui:input>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<button id="<portlet:namespace />luu" type="button" class="btn btn-labeled btn-default" onclick="save(true);">
					<span class="btn-label"><i class="glyphicon glyphicon-floppy-disk"></i></span><%=congTacVienId == 0 ? "Lưu" : "Cập nhật" %>
				</button>
				<%
					if(congTacVienId == 0){
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
<portlet:resourceURL var="addCTVURL" id="addCTVURL"></portlet:resourceURL>
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
				<portlet:namespace />congTacVienId : '<%=congTacVienId %>',
				<portlet:namespace />chiNhanhId : A.one('#<portlet:namespace />chiNhanhId').val(),
				<portlet:namespace />maCongTacVien : A.one('#<portlet:namespace />maCongTacVien').val(),
				<portlet:namespace />hoTen : A.one('#<portlet:namespace />hoTen').val(),
				<portlet:namespace />soCMND : A.one('#<portlet:namespace />soCMND').val(),
				<portlet:namespace />duNoToiDaTheChap : A.one('#<portlet:namespace />duNoToiDaTheChap').val(),
				<portlet:namespace />duNoToiDa : A.one('#<portlet:namespace />duNoToiDa').val(),
				<portlet:namespace />diaChi : A.one('#<portlet:namespace />diaChi').val(),
				<portlet:namespace />ghiChu : A.one('#<portlet:namespace />ghiChu').val()
			}
			A.io.request('${addCTVURL}', {
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
	                   					toastr.success('Thêm cộng tác viên thành công', 'Thông báo!');
	                   				}
	                   			}else{
	                   				if(data.exception.indexOf('class com.dm.exception.TrungMaException') > -1){
	                   					toastr.warning('Mã cộng tác viên đã tồn tại', 'Cảnh báo!');
	                   				}else if(data.exception.indexOf('class com.dm.exception.TrungSoCMNDException') > -1){
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