<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.mb.service.MaSoThuChiLocalServiceUtil"%>
<%@page import="com.mb.model.MaSoThuChi"%>
<%@page import="com.mb.service.CongTacVienLocalServiceUtil"%>
<%@page import="com.mb.model.CongTacVien"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ include file="/html/ketoan/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<portlet:renderURL var="addPhieuThuURL"
	windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/html/ketoan/lapphieu/add.jsp" />
	<portlet:param name="loai" value="1" />
</portlet:renderURL>
<portlet:renderURL var="addPhieuChiURL"
	windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/html/ketoan/lapphieu/add.jsp" />
	<portlet:param name="loai" value="2" />
</portlet:renderURL>
<portlet:renderURL var="searchURL"
	windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<portlet:param name="mvcPath" value="/html/ketoan/lapphieu/data.jsp" />
</portlet:renderURL>
<%
	List<CongTacVien> congTacViens = CongTacVienLocalServiceUtil.findBase("", "", "", "", 1, -1, -1, null);
	List<MaSoThuChi> maSoThuChis = MaSoThuChiLocalServiceUtil.findBase("", "", 0, 1, -1, -1, null);
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	Date now = new Date();
%>
<aui:form name="frm">
<button type="button" class="btn btn-labeled btn-primary"
	onclick="openDialog(1);">
	<span class="btn-label"><i
		class="glyphicon glyphicon-plus"></i></span>Lập phiêu thu
</button>
<button type="button" class="btn btn-labeled btn-warning"
	onclick="openDialog(2);">
	<span class="btn-label"><i
		class="	glyphicon glyphicon-minus-sign"></i></span>Lập phiêu chi
</button>
<fieldset class="fieldset-border">
	<legend class="legend-border">
		<a data-toggle="collapse" data-target="#idSearchAdvance" href="javascript:void(0);"
			class="collapsed title-fieldset" aria-expanded="false">Thông tin tìm kiếm</a>
	</legend>
	<div id="idSearchAdvance" class="collapse">
		<table class="info table-pa5 aui-w100">
			<tr>
				<td colspan="2">
					<aui:select cssClass="input-select2" name="maCTVSearch" label="Cộng tác viên" onchange="search();">
						<aui:option value=" " label="Chọn" />
						 <c:forEach items="<%= congTacViens%>" var="item">
						 	<aui:option value="${item.ma}" label="${item.hoTen}"/>
						</c:forEach>
					</aui:select>
				</td>
				<td colspan="2">
					<aui:select name="loaiSearch" label="Loại">
						 <aui:option value="0" label="Tất cả" selected="true" />
						 <aui:option value="1" label="Thu"/>
						 <aui:option value="2" label="Chi" />
					</aui:select>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<aui:select name="maMSThuChiSearch" label="Mã số">
						 <aui:option value=" " label="Chọn" />
						<c:forEach items="<%= maSoThuChis%>" var="item">
						 	<aui:option value="${item.ma}" label="${item.ma}"/>
						</c:forEach>
					</aui:select>
				</td>
				<td colspan="2">
					<aui:input name="soPhieuSearch" class="input-text" label="Số phiếu">
					</aui:input>
				</td>
			</tr>
			<tr>	
				<td>
					<aui:input cssClass="input-date" name="ngayChungTuTuSearch" label="Ngày chứng từ từ" placeholder="dd/MM/yyyy" value="<%=sdf.format(now) %>">
					</aui:input>
				</td>
				<td>
					<aui:input cssClass="input-date" name="ngayChungTuDenSearch" label="Ngày chứng từ đến" placeholder="dd/MM/yyyy" value="<%=sdf.format(now) %>">
					</aui:input>
				</td>
				<td colspan="2">
					<aui:select name="hoatDongSearch" label="Hoạt động">
						 <aui:option value="0" label="Tất cả" />
					 	 <aui:option value="1" label="Hoạt động" selected="true" />
						 <aui:option value="2" label="Ngưng hoạt động" />
					</aui:select>
				</td>
			</tr>
			<tr>
				<td  colspan="4">
					<button  type="button" class="btn-search-file btn" id="idSeachBtn" onclick="search();">Tìm kiếm</button>
				</td>
			</tr>
		</table>
	</div>
</fieldset>
<div id="<portlet:namespace />contentDataTable" name="<portlet:namespace />contentDataTable"></div>
</aui:form>
<aui:script use="aui-base,aui-io-plugin-deprecated,aui-loading-mask-deprecated">
AUI().ready(['aui-base'], function(A) {
	$('.input-date').datepicker();
	$('.input-date').mask('99/99/9999');
	$('.input-select2').select2({
		placeholder : 'Chọn',
		allowClear : true,
		language : {
			noResults : function() {
				return '';
			}
		}
	});
	var contentDataTable = A.one('#<portlet:namespace />contentDataTable');
	var loadingMask = new A.LoadingMask(
		{
			target: A.getBody()
		}
	);
	Liferay.provide(window,'search', function(){
		loadingMask.show();
		var ngayChungTuTuSearch = 0;
		var ngayChungTuDenSearch =0;
		var pattern = /(\d{2})\/(\d{2})\/(\d{4})/;
		var ngayChungTuTuSearchVal = A.one('#<portlet:namespace />ngayChungTuTuSearch').val();
		var ngayChungTuDenSearchVal = A.one('#<portlet:namespace />ngayChungTuDenSearch').val();
		if (('' != ngayChungTuTuSearchVal && pattern.test(ngayChungTuTuSearchVal)) && 'dd/MM/yyyy' != ngayChungTuTuSearchVal) {
			var dateTu = new Date(ngayChungTuTuSearchVal.replace(pattern, '$3-$2-$1'));
			ngayChungTuTuSearch = dateTu.getTime();
		}
		if (('' != ngayChungTuDenSearchVal && pattern.test(ngayChungTuDenSearchVal)) && 'dd/MM/yyyy' != ngayChungTuDenSearchVal) {
			var dateDen = new Date(ngayChungTuDenSearchVal.replace(pattern, '$3-$2-$1'));
			ngayChungTuDenSearch = dateDen.getTime();
		}
		var data = {
        	'<portlet:namespace/>maCTVSearch' : A.one('#<portlet:namespace />maCTVSearch').val(),
        	'<portlet:namespace/>loaiSearch' : A.one('#<portlet:namespace />loaiSearch').val(),
        	'<portlet:namespace/>maMSThuChiSearch' : A.one('#<portlet:namespace />maMSThuChiSearch').val(),
        	'<portlet:namespace/>soPhieuSearch' : A.one('#<portlet:namespace />soPhieuSearch').val(),
        	'<portlet:namespace/>maMSThuChiSearch' : A.one('#<portlet:namespace />maMSThuChiSearch').val(),
        	'<portlet:namespace/>ngayChungTuTuSearch' : ngayChungTuTuSearch,
        	'<portlet:namespace/>ngayChungTuDenSearch' : ngayChungTuDenSearch,
        	'<portlet:namespace/>hoatDongSearch' : A.one('#<portlet:namespace />hoatDongSearch').val()
        }
		contentDataTable.plug(A.Plugin.IO,{
            autoLoad: false,
            uri : '${searchURL}',
			data : data,
			after: {
				success: function() {
					loadingMask.hide();
				}
			}
        });
        var contentIO = contentDataTable.io;
        if(contentIO){
			contentIO.start();
        }
	});
	Liferay.provide(window,'openDialog', function(loai){
		Liferay.Util.openWindow({
			dialog : {
				centered : true,
				height : 1000,
				modal : true,
				width : 1200
			},
			id : '<portlet:namespace />dialogAdd',
			title : loai == 1 ? 'Lập phiếu thu' : 'Lập phiếu chi',
			uri : loai == 1 ? '${addPhieuThuURL}' : '${addPhieuChiURL}'
		});
	});
	Liferay.provide(window,'dongPopup', function(){
		var dialog = Liferay.Util.Window.getById('<portlet:namespace />dialogAdd');
		if(dialog){
			dialog.destroy();
		}
	});
	Liferay.provide(window,'thongBao', function(){
		toastr.success('Lập phiếu thành công', 'Thông báo!');
	});
	search();
});
</aui:script>