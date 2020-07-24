<%@page import="java.util.Locale"%>
<%@page import="com.mb.model.TaiKhoanDoiUng"%>
<%@page import="com.mb.service.TaiKhoanDoiUngLocalServiceUtil"%>
<%@page import="java.util.Date"%>
<%@page import="org.apache.commons.collections.CollectionUtils"%>
<%@page import="com.mb.service.DsPhieuTaiKhoanLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mb.model.DsPhieuTaiKhoan"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.mb.service.CongTacVienLocalServiceUtil"%>
<%@page import="com.mb.model.CongTacVien"%>
<%@page import="com.mb.service.MaSoThuChiLocalServiceUtil"%>
<%@page import="com.mb.model.MaSoThuChi"%>
<%@page import="java.util.List"%>
<%@page import="com.mb.service.PhieuLocalServiceUtil"%>
<%@page import="com.mb.model.Phieu"%>
<%@page import="com.liferay.portal.kernel.util.LocaleUtil"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/ketoan/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int loai = ParamUtil.getInteger(request, "loai");
	long phieuId = ParamUtil.getLong(request, "phieuId");
	Phieu phieu = PhieuLocalServiceUtil.createPhieu(0L);
	List<DsPhieuTaiKhoan> dsPhieuTaiKhoans = new ArrayList<DsPhieuTaiKhoan>();
	if (phieuId > 0) {
		phieu = PhieuLocalServiceUtil.fetchPhieu(phieuId);
		dsPhieuTaiKhoans = DsPhieuTaiKhoanLocalServiceUtil.findByPhieuId(phieuId);
	}
	if (phieu == null) {
		phieu = PhieuLocalServiceUtil.createPhieu(0L);
	}
	List<MaSoThuChi> maSoThuChis = MaSoThuChiLocalServiceUtil.findByLoai_HoatDong(loai, true);
	List<CongTacVien> congTacViens = CongTacVienLocalServiceUtil.findBase("", "", "", "", 1, -1, -1, null);
	List<TaiKhoanDoiUng> taiKhoanDoiUngs = TaiKhoanDoiUngLocalServiceUtil.findByLoaiTaiKhoan_HoatDong(1, true);
	Locale localeEn = new Locale("en", "EN");
    NumberFormat df = NumberFormat.getInstance(localeEn);
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	Date now = new Date();
%>
<c:set var="phieu" value="<%=phieu%>" />
<c:set var="df" value="<%=df%>" />
<c:set var="sdf" value="<%=sdf%>" />
<c:set var="now" value="<%=now%>" />
<aui:form name="frmAdd">
	<table class="info table-pa5 aui-w100">
		<tr>
			<td><aui:input class="input-text" name="soPhieu"
					label="Số Phiếu" style="font-weight: bold;color: #0006ff;"
					 value="<%=phieu.getSoPhieu()%>">
					<aui:validator name="required"
						errorMessage="Số Phiếu không được bỏ trống!" />
				</aui:input></td>
		</tr>
		<tr>
			<td><aui:select name="maMSThuChi" label="Mã số"
					onchange="changeMaSo();" cssClass="input-select2">
					<aui:option value=" " label="Chọn" />
					<c:forEach items="<%=maSoThuChis%>" var="item">
						<aui:option value="${item.ma}" label="${item.ma}"
							selected="${item.ma.equals(phieu.maMSThuChi)}" />
					</c:forEach>
					<aui:validator name="required"
						errorMessage="Mã số không được bỏ trống!" />
				</aui:select></td>
			<td><aui:input class="input-text" name="dienGiaiMaSoThuChi"
					label="Diễn giải" style="font-weight: bold;color: #0006ff;"
					readonly="true"
					value='<%=phieu.getMaSoThuChi() != null ? phieu.getMaSoThuChi().getDienGiai() : ""%>'>
				</aui:input></td>
		</tr>
		<tr>
			<td><aui:select name="maCTV" label="Cộng tác viên"
					onchange="changeCTV();" cssClass="input-select2">
					<aui:option value=" " label="Chọn" />
					<c:forEach items="<%=congTacViens%>" var="item">
						<aui:option value="${item.ma}" label="${item.hoTen}"
							selected="${item.ma.equals(phieu.maCTV)}" />
					</c:forEach>
					<aui:validator name="required"
						errorMessage="Cộng tác viên không được bỏ trống!" />
				</aui:select></td>
			<td><aui:input class="input-text" onkeypress="_formatNumber();"
					name="soTien" label="Số tiền"
					value="${phieu.soTien > 0 ? df.format(phieu.soTien) : ''}">
					<aui:validator name="required"
						errorMessage="Số tiền không được bỏ trống!" />
				</aui:input></td>
		</tr>
		<tr>
			<td colspan="2"><aui:input class="input-text" name="diaChiCTV"
					label="Địa chỉ" style="font-weight: bold;color: #0006ff;"
					readonly="true"
					value='<%=phieu.getCtv() != null ? phieu.getCtv().getDiaChi() : ""%>'>
				</aui:input></td>
		</tr>
		<tr>
			<td><aui:input cssClass="input-date" name="ngayChungTu"
					label="Ngày chứng từ " placeholder="dd/MM/yyyy"
					value="${not empty phieu.ngayChungTu ? sdf.format(phieu.ngayChungTu) : sdf.format(now)}">
					<aui:validator name="required"
						errorMessage="Ngày chứng từ không được bỏ trống!" />
				</aui:input></td>
			<td><aui:input cssClass="input-date" name="ngayGhiSo"
					label="Ngày ghi sổ " placeholder="dd/MM/yyyy"
					value="${not empty phieu.ngayGhiSo ? sdf.format(phieu.ngayGhiSo) : sdf.format(now)}">
					<aui:validator name="required"
						errorMessage="Ngày ghi sổ không được bỏ trống!" />
				</aui:input></td>
		</tr>
	</table>
	<div id="<portlet:namespace />dsTaiKhoanDoiUng" class="aui-w100"
		style="padding: 2% 5% 2% 5%">
		<div class="aui-w100">Danh sách tài khoản đối ứng</div>
		<table id="<portlet:namespace />dsTaiKhoanDoiUngTable"
			style="padding: 0% 0% 1% 0%" class="table-border-all aui-w100">
			<thead>
				<tr>
					<th class="aui-w3"><a class="icon-add"
						href="javascript:void(0)"><i class="glyphicon glyphicon-plus"></i></a></th>
					<th>Tài khoản đối ứng<span style="color: #ffc107;">*</span></th>
					<th>Mã số theo dõi<span style="color: #ffc107;">*</span></th>
					<th>Diễn giải <span style="color: #ffc107;">*</span></th>
					<th>Giá trị PS<span style="color: #ffc107;">*</span></th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="<%=CollectionUtils.isNotEmpty(dsPhieuTaiKhoans)%>">
						<%
							int i = 0;
							for (DsPhieuTaiKhoan item : dsPhieuTaiKhoans) {
								i++;
						%>
						<tr id="<%=i%>" class="result-row" />
						<td class="aui-w3"><span><a class="icon-delete"
								href="javascript:void(0)"><i
									class="glyphicon glyphicon-trash"></i></a></span></td>
						<td>
							<aui:select name='<%="taiKhoanDoiUngId_" + i%>' label=" " cssClass="input-select2">
								 <aui:option value="0" label="Chọn" />
								 <%
								 	for(TaiKhoanDoiUng taiKhoanDoiUng : taiKhoanDoiUngs){
								 %>
								 	<aui:option value="<%=taiKhoanDoiUng.getTaiKhoanDoiUngId() %>" label="<%=taiKhoanDoiUng.getTen() %>" selected="<%=taiKhoanDoiUng.getTaiKhoanDoiUngId() == item.getTaiKhoanDoiUngId()  %>">
								 	</aui:option>
								 <%
								 	}
								 %>
								<aui:validator name="required" errorMessage="Không được bỏ trống!" />
							</aui:select>
						<td>
							<aui:select name='<%="maTheoDoi_" + i%>' label=" " cssClass="input-select2">
								 <aui:option value="0" label="Chọn" />
								 <%
								 	for(CongTacVien congTacVien : congTacViens){
								 %>
								 	<aui:option value="<%=congTacVien.getMa() %>" label="<%=congTacVien.getMa() %>" selected="<%=congTacVien.getMa().equals(item.getMaTheoDoi())%>">
								 	</aui:option>
								 <%
								 	}
								 %>
								<aui:validator name="required" errorMessage="Không được bỏ trống!" />
							</aui:select>
						</td>
						<td>
							<aui:input class="input-text" name='<%="dienGiaiTheoDoi_" + i%>' label=" " value="<%=item.getDienGiaiTheoDoi() %>">
								<aui:validator name="required" errorMessage="Không được bỏ trống!" />
							</aui:input>
						</td>
						<td>
							<aui:input class="input-text" onkeypress="_formatNumber();" name='<%="soTienTheoDoi_" + i%>' label=" " value='<%=item.getSoTien() > 0 ? df.format(item.getSoTien()) : ""%>'>
								<aui:validator name="required" errorMessage="Không được bỏ trống!" />
							</aui:input>
						</td>
						<%
							}
						%>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="5" class="empty text-center">Không có dữ liệu</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
	<table class="info table-pa5 aui-w100">
		<tr>
			<td>
				<button id="<portlet:namespace />luu" type="button"
					class="btn btn-labeled btn-default" onclick="save(true);">
					<span class="btn-label"><i
						class="glyphicon glyphicon-floppy-disk"></i></span><%=phieuId == 0 ? "Lưu" : "Cập nhật"%>
				</button> <%
 	if (phieuId == 0) {
 %>
				<button id="<portlet:namespace />luuvanhaptiep"
					onclick="save(false);" type="button"
					class="btn btn-labeled btn-primary">
					<span class="btn-label"><i class="glyphicon glyphicon-copy"></i></span>Lưu
					và nhập tiếp
				</button> <%
 	}
 %>
				<button id="<portlet:namespace />dong"
					onclick="Liferay.Util.getOpener().dongPopup();" type="button"
					class="btn btn-labeled btn-danger">
					<span class="btn-label"><i
						class="glyphicon glyphicon-remove-circle"></i></span>Đóng
				</button>
			</td>
		</tr>
	</table>
</aui:form>
<portlet:resourceURL var="addURL" id="addURL"></portlet:resourceURL>
<portlet:resourceURL var="getSoPhieuURL" id="getSoPhieuURL"></portlet:resourceURL>
<portlet:resourceURL var="getMaSoThuChiURL" id="getMaSoThuChiURL"></portlet:resourceURL>
<portlet:resourceURL var="getCTVURL" id="getCTVURL"></portlet:resourceURL>
<portlet:resourceURL var="getTaiKhoanDoiUngURL"
	id="getTaiKhoanDoiUngURL"></portlet:resourceURL>
<portlet:resourceURL var="getMaSoTheoDoiURL" id="getMaSoTheoDoiURL"></portlet:resourceURL>
<portlet:resourceURL var="getDienGiaiTheoDoiURL" id="getDienGiaiTheoDoiURL"></portlet:resourceURL>
<aui:script
	use="aui-base,aui-io-plugin-deprecated,aui-loading-mask-deprecated">
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
	var form  = A.one('#<portlet:namespace />frmAdd');
	var loadingMask = new A.LoadingMask(
		{
			target: form
		}
	);
	Liferay.provide(window,'refreshData', function(){
		getSoPhieu();
		form.one('#<portlet:namespace />soTien').val('');
		var table = form.one('#<portlet:namespace />dsTaiKhoanDoiUngTable');
		var tbody = tableNode.getElementsByTagName('tbody');
		tbody.empty();
		tbody.append('<tr><td colspan="5" class="empty text-center">Không có dữ liệu</td></tr>');
	});
	<!-- Lấy dữ liệu danh mục -->
	Liferay.provide(window,'getSoPhieu', function(){
		loadingMask.show();
		var pattern = /(\d{2})\/(\d{2})\/(\d{4})/;
		var ngayChungTuVal = A.one('#<portlet:namespace />ngayChungTu').val();
		var ngayChungTu = 0;
		if (('' != ngayChungTuVal && pattern.test(ngayChungTuVal)) && 'dd/MM/yyyy' != ngayChungTuVal) {
			var date = new Date(ngayChungTuVal.replace(pattern, '$3-$2-$1'));
			ngayChungTu = date.getTime();
		}
		var data = {
				<portlet:namespace />loai : '<%=loai%>',
				<portlet:namespace />ngayChungTuTime : ngayChungTu
		}
		A.io.request('${getSoPhieuURL}', {
               method: 'post',
                data: data,
               on: {
                   success: function() {
                   		if(this.get('responseData')){
                   			var data = JSON.parse(this.get('responseData'));
                   			form.one('#<portlet:namespace />soPhieu').val(data.soPhieu);
                   		}
                   }
              }
        });
        loadingMask.hide();
	});
	Liferay.provide(window,'changeMaSo', function(){
		loadingMask.show();
		var data = {
				<portlet:namespace />maMSThuChi : form.one('#<portlet:namespace />maMSThuChi').val(),
				<portlet:namespace />loai : '<%=loai%>'
		}
		A.io.request('${getMaSoThuChiURL}', {
               method: 'post',
                data: data,
               on: {
                   success: function() {
                   		if(this.get('responseData')){
                   			var data = JSON.parse(this.get('responseData'));
                   			form.one('#<portlet:namespace />dienGiaiMaSoThuChi').val(data.dienGiai);
                   		}
                   }
              }
        });
        loadingMask.hide();
	});
	Liferay.provide(window,'changeCTV', function(){
		loadingMask.show();
		var data = {
				<portlet:namespace />maCTV : form.one('#<portlet:namespace />maCTV').val(),
		}
		A.io.request('${getCTVURL}', {
               method: 'post',
                data: data,
               on: {
                   success: function() {
                   		if(this.get('responseData')){
                   			var data = JSON.parse(this.get('responseData'));
                   			form.one('#<portlet:namespace />diaChiCTV').val(data.diaChiCTV);
                   		}
                   }
              }
        });
        loadingMask.hide();
	});
	Liferay.provide(window,'getTaiKhoanDoiUng', function(node){
		A.io.request('${getTaiKhoanDoiUngURL}', {
               method: 'post',
               on: {
                   success: function() {
                   		if(this.get('responseData')){
                   			var data = JSON.parse(this.get('responseData'));
                   			if(data.taiKhoanDoiUngs){
                   				var taiKhoanDoiUngs = A.Array.map(data.taiKhoanDoiUngs, function(item) {
									item.id = item.taiKhoanDoiUngId;
									item.text = item.ten;
									return item;
								});
								taiKhoanDoiUngs.unshift({
									id : '',
									text : 'Chọn'
								});
								node.empty().select2({
									data : taiKhoanDoiUngs
								});
	                   		}
                   		}
                   }
              }
        });
	});
	Liferay.provide(window,'getMaSoTheoDoi', function(node){
		A.io.request('${getMaSoTheoDoiURL}', {
               method: 'post',
               on: {
                   success: function() {
                   		if(this.get('responseData')){
                   			var data = JSON.parse(this.get('responseData'));
                   			if(data.congTacViens){
                   				var maSoTheoDois = A.Array.map(data.congTacViens, function(item) {
									item.id = item.ma;
									item.text = item.ma;
									item.selected = (item.ma == form.one('#<portlet:namespace />maCTV').val());
									return item;
								});
								maSoTheoDois.unshift({
									id : '',
									text : 'Chọn'
								});
								node.empty().select2({
									data : maSoTheoDois
								});
	                   		}
                   		}
                   }
              }
        });
	});
	Liferay.provide(window,'getDienGiaiTheoDoi', function(dienGiaiNode){
		 var data = {
				<portlet:namespace />maMSThuChi : form.one('#<portlet:namespace />maMSThuChi').val(),
				<portlet:namespace />loai : '<%=loai%>'
		}
		A.io.request('${getMaSoThuChiURL}', {
               method: 'post',
               data : data,
               on: {
                   success: function() {
                   		if(this.get('responseData')){
                   			var data = JSON.parse(this.get('responseData'));
                   			if(data.dienGiai){
                   				dienGiaiNode.val(data.dienGiai);
                   			}else{
                   				dienGiaiNode.val('');
                   			}
                   		}
                   }
              }
        });
	});
	if(<%=phieuId == 0%>){
		getSoPhieu();
	}
	<!-- Xử lý table -->
	var tableNode = form.one('#<portlet:namespace />dsTaiKhoanDoiUngTable');
	if(tableNode){
		var nodeAdd = tableNode.getElementsByTagName('thead').one('.icon-add');
		if(nodeAdd){
			nodeAdd.on('click',function(){
				addRowTaiKhoanDoiUng();
			});
		}
	}
	Liferay.provide(window,'addRowTaiKhoanDoiUng', function(){
		var thead = tableNode.getElementsByTagName('thead');
		var tbody = tableNode.getElementsByTagName('tbody');
		<!-- Tính len -->
		var array = tbody.all('tr').attr('id');
		var isEmpty = tbody.all('tr' + ">td.empty");
		if (isEmpty && isEmpty.size() == 1) {
			tbody.empty();
		}
		var len = array.length > 0 ? array.max() + 1 : 1;
		<!-- Tính len -->
		var tr = A.Node.create('<tr id="'+ len +'" class="result-row" />');
		
		var td0 = A.Node.create('<td class="aui-w3" />');
		var spanDel = A.Node.create('<span />');
		var nodeDel = A.Node.create('<a class="icon-delete" href="javascript:void(0)"><i class="glyphicon glyphicon-trash"></i></a>');
		nodeDel.on('click', function(event){
			deleteRow(event);
		});
		spanDel.append(nodeDel);
		td0.append(spanDel);
		
		var td1 = A.Node.create('<td />');
		var taiKhoanDoiUngIdNode =  $('<select name="<portlet:namespace />taiKhoanDoiUngId_'+len+'" class="aui-w100"></select>');
		td1.append(taiKhoanDoiUngIdNode);
		getTaiKhoanDoiUng(taiKhoanDoiUngIdNode);
		var td2 = A.Node.create('<td />');
		var maTheoDoiNode =  $('<select name="<portlet:namespace />maTheoDoi_'+len+'" class="aui-w100"></select>');
		td2.append(maTheoDoiNode);
		getMaSoTheoDoi(maTheoDoiNode);
		
		var td3 = A.Node.create('<td />');
		var dienGiaiNode =  $('<input name="<portlet:namespace />dienGiaiTheoDoi_'+len+'" class="input-text aui-w100">');
		td3.append(dienGiaiNode);
		
		var td4 = A.Node.create('<td />');
		var soTienTheoDoiNode = A.Node.create('<input name="<portlet:namespace />soTienTheoDoi_'+len+'" id="<portlet:namespace />soTienTheoDoi_'+len+'" class="input-text aui-w100">')
		td4.append(soTienTheoDoiNode);
		soTienTheoDoiNode.val(form.one('#<portlet:namespace />soTien').val());
		soTienTheoDoiNode.on('keypress',function(){
			$('#' + '<portlet:namespace />soTienTheoDoi_' + len).priceFormat({
				prefix : '',
				centsLimit : 0,
				centsSeparator : '.',
				thousandsSeparator : ',',
				clearOnEmpty : true
			});
		});
		taiKhoanDoiUngIdNode.on('change',function(){
			A.io.request('${getDienGiaiTheoDoiURL}', {
               method: 'post',
               data : {
               	'<portlet:namespace />taiKhoanDoiUngId' : taiKhoanDoiUngIdNode.val()
               },
               on: {
                   success: function() {
                   		if(this.get('responseData')){
                   			var data = JSON.parse(this.get('responseData'));
                   			if(data){
                   				dienGiaiNode.val(data.dienGiaiTheoDoi);
                   			}
                   		}
                   }
              }
        });
		});
		tr.append(td0);
		tr.append(td1);
		tr.append(td2);
		tr.append(td3);
		tr.append(td4);
		tbody.append(tr);
	});
	Liferay.provide(window,'deleteRow', function(event){
		var currentNode = event.currentTarget;
		var check = confirm('Bạn có chắc thực hiện thao tác này ?');
		if (currentNode && check) {
			var table = currentNode.ancestor('table');
			var tbody = table.getElementsByTagName('tbody');
			var row = currentNode.ancestor('tr');
			row.remove();
			if (tbody.all('tr').size() == 0) {
				tbody.append('<tr><td colspan="5" class="empty text-center">Không có dữ liệu</td></tr>');
			}
		}
	});
	var formValidator = Liferay.Form.get('<portlet:namespace />frmAdd').formValidator;
	Liferay.provide(window,'save', function(close){
		loadingMask.show();
		formValidator.validate();
		if(!formValidator.hasErrors()){
			var batLoi = false;
			var ngayChungTu = 0;
			var ngayGhiSo =0;
			var pattern = /(\d{2})\/(\d{2})\/(\d{4})/;
			var ngayChungTuVal = A.one('#<portlet:namespace />ngayChungTu').val();
			var ngayGhiSoVal = A.one('#<portlet:namespace />ngayGhiSo').val();
			if (('' != ngayChungTuVal && pattern.test(ngayChungTuVal)) && 'dd/MM/yyyy' != ngayChungTuVal) {
				var date = new Date(ngayChungTuVal.replace(pattern, '$3-$2-$1'));
				ngayChungTu = date.getTime();
			}
			if (('' != ngayGhiSoVal && pattern.test(ngayGhiSoVal)) && 'dd/MM/yyyy' != ngayGhiSoVal) {
				var date = new Date(ngayGhiSoVal.replace(pattern, '$3-$2-$1'));
				ngayGhiSo = date.getTime();
			}
			var data = {
				'<portlet:namespace />phieuId' : '<%=phieuId%>',
				'<portlet:namespace />maMSThuChi' : form.one('#<portlet:namespace />maMSThuChi').val(),
				'<portlet:namespace />maCTV' : form.one('#<portlet:namespace />maCTV').val(),
				'<portlet:namespace />soTien' : form.one('#<portlet:namespace />soTien').val(),
				'<portlet:namespace />ngayChungTuTime' : ngayChungTu,
				'<portlet:namespace />ngayGhiSoTime' : ngayGhiSo,
				'<portlet:namespace />loai' : '<%=loai%>',
				'<portlet:namespace />soPhieu' : form.one('#<portlet:namespace />soPhieu').val(),
			}
			var array = [];
			var tongSoTienTheoDoi = 0;
			var tableTheChap = form.one('#<portlet:namespace />taiSanTheChapTable');
			if(tableNode){
				tableNode.all('tr.result-row').each(function(node){
					var item = {};
					var batLoiGiaTri = false;
					node.all('select,input').each(function(component){
						if(component.attr('name')){
							var componentName = component.attr('name').replace('<portlet:namespace />','');
							var key = componentName.substring(0,componentName.indexOf('_'));
							if(key == 'taiKhoanDoiUngId' && component.val() == ''){
								batLoi = true;
								toastr.warning('Chưa chọn tài khoản đối ứng', 'Cảnh báo!');
							}else if (key == 'maTheoDoi' && component.val() == ''){
								batLoi = true;
								toastr.warning('Chưa chọn mã số theo dõi', 'Cảnh báo!');
							}else if ( key == 'soTienTheoDoi' && (component.val() == '' || component.val() == '0' || component.val() == 0) ){
								batLoi = true;
								toastr.warning('Chưa nhập số tiền', 'Cảnh báo!');
							}else{
								if ( key == 'soTienTheoDoi'){
									var soTienTheoDoi = component.val().split(',').join('');
									tongSoTienTheoDoi += Number.parseFloat(soTienTheoDoi);
								}
								item[key] = component.val();
							}
						}
					});
					if (!A.Object.isEmpty(item) && item.taiKhoanDoiUngId && item.maTheoDoi && item.soTienTheoDoi) {
						array.push(item);
					}
				});
			}
			var soTien = form.one('#<portlet:namespace />soTien').val().split(',').join('');
			if(array.length == 0){
				batLoi = true;
				toastr.warning('Chưa nhập thông tin tài khoản đối ứng', 'Cảnh báo!');
			}else{
				data['<portlet:namespace />dsPhieuTaiKhoan'] = A.JSON.stringify(array)
			}
			if(Number.parseFloat(soTien) != tongSoTienTheoDoi){
				batLoi = true;
				toastr.warning('Số tiền tài khoản đối ứng chưa khớp ', 'Cảnh báo!');
			}
			if(!batLoi){
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
	                   					toastr.success('Lập phiếu thành công', 'Thông báo!');
	                   				}
	                   			}else{
	                   				if(data.exception.indexOf('TonSo') > -1){
	                   					toastr.warning('Số phiếu đã  tồn tại', 'Thông báo!');
	                   				}else{
	                   					toastr.error('Yêu cầu thực hiện không thành công', 'Lỗi!');
	                   				}
	                   			}
	                   			getSoPhieu();
	                   		}
	                   },
	                   failure : function() {
						}
	              }
	        });
			}
        }
        loadingMask.hide();
	});
});
</aui:script>