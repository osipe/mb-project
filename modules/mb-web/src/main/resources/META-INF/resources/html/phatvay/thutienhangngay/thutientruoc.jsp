<%@page import="quanly.portlet.danhmuc.cauhinhthutientruoc.CauHinhThuTienTruocComparator"%>
<%@page import="org.apache.commons.collections.CollectionUtils"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.mb.service.CauHinhThuTienTruocLocalServiceUtil"%>
<%@page import="com.mb.model.CauHinhThuTienTruoc"%>
<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.mb.service.CongTacVienLocalServiceUtil"%>
<%@page import="com.mb.model.CongTacVien"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/phatvay/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String dialogId =  ParamUtil.getString(request, "dialogId");
	String maCTVSearch =  ParamUtil.getString(request, "maCTVSearch");
	CongTacVien ctv = CongTacVienLocalServiceUtil.fetchByMa(maCTVSearch);
	int namNow = Calendar.getInstance().get(Calendar.YEAR);
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	List<CauHinhThuTienTruoc> cauHinhs = CauHinhThuTienTruocLocalServiceUtil.findBase(0, 1, -1, -1, new CauHinhThuTienTruocComparator("nam",false));
	CauHinhThuTienTruoc cauHinh = CollectionUtils.isNotEmpty(cauHinhs) ? cauHinhs.get(0) : null;
	if(ctv == null){
	 	ctv = CongTacVienLocalServiceUtil.createCongTacVien(0L);
	}
	String ngayBatDauThuTienCauHinh = PropsUtil.get("config.ngaythutientruocstart") + "/" + namNow;
	String ngayKetThucThuTienCauHinh = PropsUtil.get("config.ngaythutientruocend") + "/" + namNow;
	if(sdf.parse(ngayKetThucThuTienCauHinh).getTime() <= Calendar.getInstance().getTimeInMillis()){
		 ngayBatDauThuTienCauHinh = PropsUtil.get("config.ngaythutientruocstart") + "/" + (namNow + 1);
		 ngayKetThucThuTienCauHinh = PropsUtil.get("config.ngaythutientruocend") + "/" + (namNow + 1);
	}
%>
<aui:form name="frmThuTienTruoc">
	
	<h3 align="center"><%=ctv.getHoTen() %></h3>
	<table class="info table-pa5 aui-w100">
			<tr>
				<td>
					<aui:input readonly ="true" name="ngayThuTienTu" value='<%=cauHinh != null && cauHinh.getNgayTu() != null ? sdf.format(cauHinh.getNgayTu()) : ""%>' label="Ngày thu tiền từ" placeholder="dd/MM/yyyy" onchange="searchURL();">
						<aui:validator name="required" errorMessage="Ngày thu tiền từ không được bỏ trống!" />
					</aui:input>
				</td>
				<td>
					<aui:input readonly ="true" name="ngayThuTienDen" value='<%=cauHinh != null && cauHinh.getNgayDen() != null ? sdf.format(cauHinh.getNgayDen()) : ""%>' label="Ngày thu tiền đến" placeholder="dd/MM/yyyy" onchange="searchURL();">
						<aui:validator name="required" errorMessage="Ngày thu tiền đến không được bỏ trống!" />
					</aui:input>
				</td>
			</tr>
			<tr>
				<td  colspan="2" style="text-align: center;">
					<button id="<portlet:namespace />luuThuTienTruocBtn" type="button" class="btn btn-labeled btn-danger" onclick="thuTienTruoc();">
						<span class="btn-label"><i class="glyphicon glyphicon-ok"></i></span>Xác nhận đã thu
					</button>
					<button id="<portlet:namespace />inPhieuThuTienTruoc" type="button" class="btn btn-labeled btn-info" onclick="printPhieuThuTienTruoc();">
						<span class="btn-label"><i class="glyphicon glyphicon-print "></i></span>In Phiếu Thu
					</button>
				</td>
			</tr>
			<tr>
				<%
					if(cauHinh != null){
						
				%>
					<td colspan="2">
						<div id="<portlet:namespace />contentDataTableThuTienTruoc" style="overflow-x: scroll;font-size: small;" name="<portlet:namespace />contentDataTableThuTienTruoc"></div>
					<td>
				<%} else{ %>
					<td colspan="2">
						<div id="<portlet:namespace />contentDataTableThuTienTruoc" style="overflow-x: scroll;font-size: small;" name="<portlet:namespace />contentDataTableThuTienTruoc">
							Chưa có cấu hinh thu tiền tết.
						</div>
					<td>
				<%} %>
	</table>
</aui:form>
<portlet:resourceURL var="thuTienTruocURL" id="thuTienTruocURL"></portlet:resourceURL>
<portlet:resourceURL var="printPhieuThuTienTruoc" id="printPhieuThuTienTruoc"></portlet:resourceURL>
<portlet:renderURL var="searchURL"
	windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<portlet:param name="mvcPath" value="/html/phatvay/thutienhangngay/datathutientruoc.jsp" />
</portlet:renderURL>
<aui:script use="aui-base,aui-io-plugin-deprecated,aui-loading-mask-deprecated,node-event-simulate">
AUI().ready(['aui-base','node-event-simulate'], function(A) {
	$('.input-date').datepicker();
	$('.input-date').mask('99/99/9999');
	var loadingMask = new A.LoadingMask(
		{
			target: A.getBody()
		}
	);
	var contentDataTableThuTienTruocNode = A.one('#<portlet:namespace />contentDataTableThuTienTruoc');
	Liferay.provide(window,'searchURL', function(){
		var data = {
        	'<portlet:namespace/>maCTVSearch' : '<%=maCTVSearch %>'
        }
		contentDataTableThuTienTruocNode.plug(A.Plugin.IO,{
            autoLoad: false,
            uri : '${searchURL}',
			data : data
        });
        var contentIO = contentDataTableThuTienTruocNode.io;
        if(contentIO){
			contentIO.start();
        }
	});
	var form  = A.one('#<portlet:namespace />frmThuTienTruoc');
	var formValidator = Liferay.Form.get('<portlet:namespace />frmThuTienTruoc').formValidator;
	Liferay.provide(window,'thuTienTruoc', function(){
		if('<%=cauHinh != null %>'){
			var check = confirm('Bạn có chắc thực hiện thao tác này ?');
			if (check) {
				loadingMask.show();
				formValidator.validate();
				if(!formValidator.hasErrors()){
					if(<%= cauHinh.getNgayTu().getTime()%> <=  <%= cauHinh.getNgayDen().getTime()%>){
						var phatVayIds = Liferay.Util.listCheckedExcept(contentDataTableThuTienTruocNode, '<portlet:namespace />allRowIds');
						var data = {
						'<portlet:namespace/>phatVayIds' : phatVayIds,
						'<portlet:namespace/>ngayThuTienTuTime' : '<%= cauHinh.getNgayTu().getTime()%>',
			        	'<portlet:namespace/>ngayThuTienDenTime' : '<%= cauHinh.getNgayDen().getTime()%>',
			        	'<portlet:namespace/>maCTV' : '<%=maCTVSearch %>'
			       	 	}
						A.io.request('${thuTienTruocURL}', {
				               method: 'post',
				               data : data,
				               on: {
				                   success: function() {
				                   		if(this.get('responseData')){
				                   			var data = JSON.parse(this.get('responseData'));
			                   				if(!data.exception){
				                   				Liferay.Util.getOpener().searchURL();
				                   				dongPopup();
			                   					Liferay.Util.getOpener().thongBao("Đã xác nhận thu tiền thành công");
				                   			}else{
			                   					toastr.error('Yêu cầu thực hiện không thành công', 'Lỗi!');
				                   			}
				                   		}
				                   }
				              }
			        	});
					}else{
						toastr.warning('Ngày thu tiền từ phải nhỏ hơn ngày thu tiền đến', 'Cảnh báo!');
					}
				}
			 	loadingMask.hide();
			}
		}else{
		toastr.warning('Chưa cấu hình thu tiền tết', 'Cảnh báo!');
		}
	});
	Liferay.provide(window,'dongPopup', function(){
		Liferay.Util.getOpener().dongPopup('<%=dialogId %>');
	});
	Liferay.provide(window,'printPhieuThuTienTruoc', function(){
		var phatVayIds = Liferay.Util.listCheckedExcept(contentDataTableThuTienTruocNode, '<portlet:namespace />allRowIds');
		var url = '${printPhieuThuTienTruoc}';
		url += '&<portlet:namespace/>ngayThuTienTuTime=' + '<%= cauHinh.getNgayTu().getTime()%>';
		url += '&<portlet:namespace/>ngayThuTienDenTime=' + '<%= cauHinh.getNgayDen().getTime()%>';
		url += '&<portlet:namespace/>phatVayIds=' + phatVayIds;
		url += '&<portlet:namespace/>maCTVSearch=' + '<%=maCTVSearch %>';
		window.location.href = url;
	});
	if('<%=cauHinh != null %>'){
		searchURL();
	}
	
});
</aui:script>
