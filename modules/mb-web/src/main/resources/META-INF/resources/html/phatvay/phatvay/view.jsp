
<%@page import="quanly.portlet.danhmuc.ctv.CongTacVienComparator"%>
<%@page import="com.mb.service.KhachHangLocalServiceUtil"%>
<%@page import="com.mb.model.KhachHang"%>
<%@page import="com.mb.service.CongTacVienLocalServiceUtil"%>
<%@page import="com.mb.model.CongTacVien"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ include file="/html/phatvay/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	CongTacVienComparator congTacVienComparator = new  CongTacVienComparator("ma",true);
	List<CongTacVien> ctvs = CongTacVienLocalServiceUtil.findBase( "", "", "", "", 1, -1, -1, congTacVienComparator);
	List<KhachHang> khachHangs = KhachHangLocalServiceUtil.findBase("", "", "", "", "", 1, -1, -1, null);
%>
<portlet:renderURL var="addURL"
	windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="dialogId" value="dialogAdd" />
	<portlet:param name="mvcPath" value="/html/phatvay/phatvay/add.jsp" />
</portlet:renderURL>
<portlet:renderURL var="searchURL"
	windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<portlet:param name="mvcPath" value="/html/phatvay/phatvay/data.jsp" />
</portlet:renderURL>
<aui:form name="frm">
<%
	String oppenDialogAdd = "openDialog('"+addURL.toString() + "','Thêm phát vay','dialogAdd');";
%>
<button type="button" class="btn btn-labeled btn-danger"
	onclick="<%=oppenDialogAdd%>">
	<span class="btn-label"><i
		class="glyphicon glyphicon-plus"></i></span>Thêm
</button>
<fieldset class="fieldset-border">
	<legend class="legend-border">
		<a data-toggle="collapse" data-target="#idSearchAdvance" href="javascript:void(0);"
			class="collapsed title-fieldset" aria-expanded="false">Thông tin tìm kiếm</a>
	</legend>
	<div id="idSearchAdvance" class="collapse">
		<table class="info table-pa5 aui-w100">
			<tr>
				<td>
					<aui:input name="soKUSearch" class="input-text" label="Số KU">
					</aui:input>
				</td>
				<td>
					<aui:select name="thanhToanSearch" label="Thanh toán">
						 <aui:option value="0" label="Tất cả" selected="true"/>
					 	 <aui:option value="1" label="Chưa hoàn thành thanh toán"/>
						 <aui:option value="2" label="Đã hoàn thành thanh toán"/>
						 <aui:option value="3" label="Đã tất toán"/>
						 <aui:option value="4" label="Có thu trước tết"/>
					</aui:select>
				</td>
			</tr>
			<tr>
				<td>
					<aui:select name="maCTVSearch" onchange="getDataKhachHang();" label="Cộng tác viên" cssClass="input-select2">
						 <aui:option value=" " label="Chọn" />
						 <c:forEach items="<%= ctvs%>" var="item">
						 	<aui:option value="${item.ma}" label="${item.hoTen} - ${item.ma}"/>
						</c:forEach>
					</aui:select>
				</td>
				<td>
					<aui:select name="maKhachHangSearch" label="Khách hàng" cssClass="input-select2">
						 <aui:option value=" " label="Chọn" />
						 <c:forEach items="<%= khachHangs%>" var="item">
						 	<aui:option value="${item.ma}" label="${item.hoTen}"/>
						</c:forEach>
					</aui:select>
				</td>
			</tr>
			<tr>
				<td>
					<aui:input cssClass="input-date" name="ngayBatDauTuSearch" label="Ngày bắt đầu từ" placeholder="dd/MM/yyyy">
					</aui:input>
				</td>
				<td>
					<aui:input cssClass="input-date" name="ngayBatDauDenSearch" label="Ngày bắt đầu đến" placeholder="dd/MM/yyyy">
					</aui:input>
				</td>
			</tr>
			<tr>
				<td  colspan="2">
					<button  type="button" class="btn-search-file btn" id="idSeachBtn" onclick="search();">Tìm kiếm</button>
				</td>
			</tr>
		</table>
	</div>
</fieldset>
<div id="<portlet:namespace />contentDataTable" style="overflow-x: scroll;font-size: small;" name="<portlet:namespace />contentDataTable"></div>
</aui:form>
<portlet:resourceURL var="getKhachHangByCongTacVienURL" id="getKhachHangByCongTacVien"></portlet:resourceURL>
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
	Liferay.provide(window,'getDataKhachHang', function(){
		loadingMask.show();
		A.io.request('${getKhachHangByCongTacVienURL}', {
               method: 'post',
               data: {
               	'<portlet:namespace />maCTV' : A.one('#<portlet:namespace />maCTVSearch').val()
               },
               on: {
                   success: function() {
                   		if(this.get('responseData')){
                   			var data = JSON.parse(this.get('responseData'));
                   			if(data.khachHangs){
                   				var khachHangs = A.Array.map(data.khachHangs, function(item) {
									item.id = item.ma;
									item.text = item.hoTen;
									return item;
								});
								khachHangs.unshift({
									id : '',
									text : 'Chọn'
								});
								$('#<portlet:namespace />maKhachHangSearch').empty().select2({
									data : khachHangs
								});
	                   		}
                   		}
                   }
              }
        });
        loadingMask.hide();
	});
	Liferay.provide(window,'search', function(){
		var ngayBatDauTuSearch = 0;
		var ngayBatDauDenSearch =0;
		var pattern = /(\d{2})\/(\d{2})\/(\d{4})/;
		var ngayBatDauTuSearchVal = A.one('#<portlet:namespace />ngayBatDauTuSearch').val();
		var ngayBatDauDenSearchVal = A.one('#<portlet:namespace />ngayBatDauDenSearch').val();
		if (('' != ngayBatDauTuSearchVal && pattern.test(ngayBatDauTuSearchVal)) && 'dd/MM/yyyy' != ngayBatDauTuSearchVal) {
			var dateTu = new Date(ngayBatDauTuSearchVal.replace(pattern, '$3-$2-$1'));
			ngayBatDauTuSearch = dateTu.getTime();
		}
		if (('' != ngayBatDauDenSearchVal && pattern.test(ngayBatDauDenSearchVal)) && 'dd/MM/yyyy' != ngayBatDauDenSearchVal) {
			var dateDen = new Date(ngayBatDauDenSearchVal.replace(pattern, '$3-$2-$1'));
			ngayBatDauDenSearch = dateDen.getTime();
		}
		var data = {
			'<portlet:namespace/>soKUSearch' : A.one('#<portlet:namespace />soKUSearch').val(),
        	'<portlet:namespace/>maCTVSearch' : A.one('#<portlet:namespace />maCTVSearch').val(),
        	'<portlet:namespace/>maKhachHangSearch' : A.one('#<portlet:namespace />maKhachHangSearch').val(),
        	'<portlet:namespace/>ngayBatDauTuSearch' : ngayBatDauTuSearch,
        	'<portlet:namespace/>ngayBatDauDenSearch' : ngayBatDauDenSearch,
        	'<portlet:namespace/>thanhToanSearch' : A.one('#<portlet:namespace />thanhToanSearch').val()
        }
		contentDataTable.plug(A.Plugin.IO,{
            autoLoad: false,
            uri : '${searchURL}',
			data : data
        });
        var contentIO = contentDataTable.io;
        if(contentIO){
			contentIO.start();
        }
	});
	Liferay.provide(window,'openDialog', function(url,title,dialogId){
		Liferay.Util.openWindow({
			dialog : {
				centered : true,
				height : 800,
				modal : true,
				width : 1300
			},
			id : '<portlet:namespace />' + dialogId,
			title : title,
			uri : url
		});
	});
	Liferay.provide(window,'dongPopup', function(dialogId){
		var dialog = Liferay.Util.Window.getById('<portlet:namespace />' + dialogId);
		if(dialog){
			dialog.destroy();
		}
	});
	Liferay.provide(window,'thongBao', function(msg){
		toastr.success(msg, 'Thông báo!');
	});
	search();
});
</aui:script>