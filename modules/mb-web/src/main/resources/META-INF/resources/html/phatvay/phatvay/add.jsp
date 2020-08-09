<%@page import="quanly.portlet.danhmuc.ctv.CongTacVienComparator"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.mb.service.LoaiTaiSanLocalServiceUtil"%>
<%@page import="com.mb.model.LoaiTaiSan"%>
<%@page import="org.apache.commons.collections.CollectionUtils"%>
<%@page import="com.mb.service.TaiSanThueChapLocalServiceUtil"%>
<%@page import="com.mb.model.TaiSanThueChap"%>
<%@page import="com.mb.service.PhatVayLocalServiceUtil"%>
<%@page import="com.mb.model.PhatVay"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.mb.service.LaiSuatLocalServiceUtil"%>
<%@page import="com.mb.model.LaiSuat"%>
<%@page import="com.mb.service.CongTacVienLocalServiceUtil"%>
<%@page import="com.mb.model.CongTacVien"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Locale"%>
<%@page import="com.liferay.portal.kernel.util.LocaleUtil"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/danhmuc/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String dialogId =  ParamUtil.getString(request, "dialogId");
	List<LaiSuat> laiSuats = LaiSuatLocalServiceUtil.findBase(GetterUtil.getDouble(0), GetterUtil.getDouble(0), 0, 1, -1, -1, null);
	CongTacVienComparator congTacVienComparator = new  CongTacVienComparator("ma",true);
	List<CongTacVien> ctvs = CongTacVienLocalServiceUtil.findBase("", "", "", "", 1, -1, -1, congTacVienComparator);
	long phatVayId = ParamUtil.getLong(request, "phatVayId");
	PhatVay phatVay = null;
	if(phatVayId > 0){
		phatVay = PhatVayLocalServiceUtil.fetchPhatVay(phatVayId);
	}
	if(phatVay == null){
		phatVay = PhatVayLocalServiceUtil.createPhatVay(0L);
	}
	Locale localeEn = new Locale("en", "EN");
    NumberFormat df = NumberFormat.getInstance(localeEn);
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	Date now = new  Date();
	Calendar cal = Calendar.getInstance();
	cal.add(Calendar.DATE, 2);
	Date ngayBatDau = phatVay.getNgayBatDau() != null ? phatVay.getNgayBatDau() : cal.getTime();
	Date createDate = phatVay.getCreateDate() != null ? phatVay.getCreateDate() : now;
	List<TaiSanThueChap> taiSanThueChaps = TaiSanThueChapLocalServiceUtil.findByPhatVayId(phatVayId);
	List<LoaiTaiSan> loaiTaiSans = LoaiTaiSanLocalServiceUtil.findBase( "", "", "", 1, -1, -1, null);
	String ngayKetThucStr = "";
	if(phatVay.getNgayKetThuc() != null){
		ngayKetThucStr = sdf.format(phatVay.getNgayKetThuc());
	}
%>
<c:set value="<%=df %>" var="df"/>
<c:set value="<%=phatVay %>" var="phatVay"/>
<aui:form name="frmAdd">
	<table class="info aui-w100" style="padding-left: 5%;padding-right: 5%">
		<tr>
			<td>
				<aui:input class="input-text " name="soKU" label="Số KU" value="${phatVay.soKU}">
					<aui:validator name="required" errorMessage="Số KU không được bỏ trống!" />
				</aui:input>
			</td>
			<td>
				<aui:select name="maCTV" onchange="getDataKhachHang();" label="Cộng tác viên" cssClass="input-select2">
					 <aui:option value=" " label="Chọn" />
					 <c:forEach items="<%= ctvs%>" var="item">
					 	<aui:option value="${item.ma}" label="${item.hoTen} - ${item.ma}" selected="${phatVay.maCTV.equals(item.ma)}"/>
					</c:forEach>
					<aui:validator name="required" errorMessage="Cộng tác viên không được bỏ trống!" />
				</aui:select>
			</td>
			<td>
				<aui:select name="maKhachHang" label="Khách hàng" cssClass="input-select2">
					 <aui:option value=" " label="Chọn" />
					 <aui:validator name="required" errorMessage="Khách hàng không được bỏ trống!" />
				</aui:select>
			</td>
			<td>
				<a class="icon-add" href="javascript:void(0)" title="Thêm khách hàng" onclick="openDialogAddKhachHang()"><i class="glyphicon glyphicon-plus"></i>
			</td>
		</tr>
	</table>
	<table class="info aui-w100" style="padding-left: 5%;padding-right: 5%;padding-bottom: 2%;">
		<tr>
			<td>
				<aui:input class="input-text" onkeypress="_formatNumber();" onchange="tinhLaiSuat()" name="soTienVay" label="Số tiền vay" value="${phatVay.soTienVay > 0 ? df.format(phatVay.soTienVay) : ''}">
					<aui:validator name="required" errorMessage="Số tiền vay không được bỏ trống!" />
				</aui:input>
			</td>
			<td>
				<aui:input name="thoiHan" class="input-text" label="Thời hạn" onchange="tinhLaiSuat()" value="${phatVay.thoiHan}">
					<aui:validator name="digits" errorMessage="Thời hạn phải là số" />
					<aui:validator name="required" errorMessage="Thời hạn không được bỏ trống!" />
				</aui:input>
			</td>
			<td>
				<aui:input class="input-text" onkeypress="isNumber(event);" onchange="tinhLaiSuat()" name="laiSuatVay" label="Lãi suất vay" value="${phatVay.laiSuatVay > 0 ? phatVay.laiSuatVay : '1.5'}">
					<aui:validator name="required" errorMessage="Lãi suất vay không được bỏ trống!" />
				</aui:input>
			</td>
		</tr>
		<tr>
			<td>
				<aui:input class="input-text" onchange="_formatNumber();" name="tienLaiNgay" label="Tiền lãi ngày" readonly ="true" value="${phatVay.laiNgay > 0 ?  df.format(phatVay.laiNgay) : '' }">
				</aui:input>
			</td>
			<td >
				<aui:input class="input-text" onchange="_formatNumber();" name="tienGocNgay" label="Tiền gốc ngày" readonly ="true" value="${phatVay.gocNgay > 0?  df.format(phatVay.gocNgay) : '' }">
				</aui:input>
			</td>
			<td >
				<aui:input class="input-text" onchange="_formatNumber();" name="tienGocNgayCuoi" label="Gốc ngày cuối" readonly ="true" value="${phatVay.gocNgayCuoi > 0 ?  df.format(phatVay.gocNgayCuoi) : '' }">
				</aui:input>
			</td>
		</tr>
		<tr>
			<td>
				<aui:input cssClass="input-date" onchange="changeCreateDate();" name="createDate" label="Ngày phát vay" placeholder="dd/MM/yyyy" value="<%=sdf.format(createDate) %>">
				</aui:input>
			</td>
			<td>
				<aui:input cssClass="input-date" onchange="getNgayKetThuc();" name="ngayBatDau" label="Ngày bắt đầu thu lãi" placeholder="dd/MM/yyyy" value="<%=sdf.format(ngayBatDau) %>">
				</aui:input>
			</td>
			<td>
				<aui:input name="ngayKetThuc" label="Ngày kết thúc thu lãi" placeholder="dd/MM/yyyy" readonly="true" value="<%=ngayKetThucStr %>">
				</aui:input>
			</td>
		</tr>
		<tr>
			<td >
				<aui:select name="loaiPhatVay" onchange="loaiPhatVayChange();" label="Loại phát vay">
				 	 <aui:option value="1" label="Thế chấp" selected="${phatVay.loaiPhatVay == 1}"/>
					 <aui:option value="2" label="Tín chấp" selected="${phatVay.loaiPhatVay == 2}"/>
					 <aui:validator name="required" errorMessage="Loại phát vay không được bỏ trống!" />
				</aui:select>
			</td>
		</tr>
	</table>
	<div id="<portlet:namespace />taiSanTheChap" class ="aui-w100" style="padding:2% 5% 2% 5%">
		<div class ="aui-w100">Tài sản thế chấp</div>
		<table id="<portlet:namespace />taiSanTheChapTable" style="padding:0% 0% 1% 0%" class="table-border-all aui-w100">
			<thead>
					<tr>
						<th class="aui-w3"><a class="icon-add" href="javascript:void(0)"><i class="glyphicon glyphicon-plus"></i></a></th>
					    <th>Loại tài sản<span style="color : #ffc107;">*</span></th>
					    <th>Tên tài sản <span style="color : #ffc107;">*</span></th>
					    <th>Giá trị tài sản <span style="color : #ffc107;">*</span></th>
					     <th>Thông tin tài sản</th>
					    <th>Ghi chú</th>
					 </tr>
			</thead>
			 <tbody>
					<c:choose>
						<c:when test="<%=CollectionUtils.isNotEmpty(taiSanThueChaps)%>">
						<%
							int index = 0;
							for(TaiSanThueChap taiSanThueChap : taiSanThueChaps){
								index++;
						%>
							<tr class="result-row" id="<%=index %>">
								<td  class="aui-w3"><a class="icon-delete" href="javascript:void(0)"><i class="glyphicon glyphicon-trash"></i></a></td>
								<td>
									<aui:select name='<%="loaiTaiSan_" + index%>' label=" " cssClass="input-select2">
										 <aui:option value="0" label="Chọn" />
										 <%
										 	for(LoaiTaiSan loaiTaiSan : loaiTaiSans){
										 %>
										 	<aui:option value="<%=loaiTaiSan.getLoaiTaiSanId() %>" label="<%=loaiTaiSan.getTen() %>" selected="<%=taiSanThueChap.getLoaiTaiSanId() == loaiTaiSan.getLoaiTaiSanId() %>">
										 	</aui:option>
										 <%
										 	}
										 %>
										<aui:validator name="required" errorMessage="Không được bỏ trống!" />
									</aui:select>
								</td>
								<td>
									<aui:input class="input-text" name='<%="tenTaiSan_" + index%>' label=" " value="<%=taiSanThueChap.getTen() %>">
									</aui:input>
								</td>
								<td>
									<aui:input onkeypress="_formatNumber();" class="input-text" name='<%="giaTriTaiSan_" + index%>' label=" " value='<%=taiSanThueChap.getGiaTriTaiSan() > 0 ? df.format(taiSanThueChap.getGiaTriTaiSan())  : ""%>'>
									</aui:input>
								</td>
								<td>
									<aui:input class="input-text" name='<%="thongTinTaiSan_" + index%>' label=" " value="<%=taiSanThueChap.getThongTinTaiSan() %>">
									</aui:input>
								</td>
								<td>
									<aui:input class="input-text" name='<%="ghiChu_" + index%>' label=" " value="<%=taiSanThueChap.getGhiChu() %>">
									</aui:input>
								</td>
							</tr>
						<%
							}
								
						%>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="6" class="empty text-center">Không có dữ liệu</td>
							</tr>
						</c:otherwise>
					</c:choose>
			</tbody>
		</table>
	</div>
	<table class="info table-pa5 aui-w100">
		<tr>
			<td colspan="2">
				<button id="<portlet:namespace />luu" type="button" class="btn btn-labeled btn-default" onclick="save(true);">
					<span class="btn-label"><i class="glyphicon glyphicon-floppy-disk"></i></span><%=phatVayId == 0 ? "Lưu" : "Cập nhật" %>
				</button>
				<%
					if(phatVayId == 0){
				%>
					<button id="<portlet:namespace />luuvanhaptiep" onclick="save(false);" type="button" class="btn btn-labeled btn-primary">
						<span class="btn-label"><i class="glyphicon glyphicon-copy"></i></span>Lưu và nhập tiếp
					</button>
				<%
					} 
				%>
				<%
					String functionDong = "Liferay.Util.getOpener().dongPopup('" +dialogId+ "');";
				%>
				<button id="<portlet:namespace />dong" onclick="<%=functionDong %>" type="button"class="btn btn-labeled btn-danger">
					<span class="btn-label"><i class="glyphicon glyphicon-remove-circle"></i></span>Đóng
				</button>
			</td>
		</tr>
	</table>
</aui:form>
<portlet:resourceURL var="getKhachHangByCongTacVienURL" id="getKhachHangByCongTacVien"></portlet:resourceURL>
<portlet:resourceURL var="getThongTinLaiSuat" id="getThongTinLaiSuat"></portlet:resourceURL>
<portlet:resourceURL var="getLoaiTaiSanURL" id="getLoaiTaiSan"></portlet:resourceURL>
<portlet:resourceURL var="saveURL" id="save"></portlet:resourceURL>
<portlet:resourceURL var="checkPhatVayKhachHang" id="checkPhatVayKhachHang"></portlet:resourceURL>
<portlet:renderURL var="addLKhachHangURL"
	windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/html/danhmuc/khachhang/add_kh.jsp" />
	<portlet:param name="manHinhPhatVay" value="true" />
</portlet:renderURL>
<aui:script use="aui-base,aui-io-plugin-deprecated,aui-loading-mask-deprecated,node-event-simulate">
AUI().ready(['aui-base','node-event-simulate'], function(A) {
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
	var formValidator = Liferay.Form.get('<portlet:namespace />frmAdd').formValidator;
	Liferay.provide(window,'openDialogAddKhachHang', function(){
		Liferay.Util.openWindow({
			dialog : {
				centered : true,
				height : 600,
				modal : true,
				width : 700
			},
			id : '<portlet:namespace />dialogKhachHangAdd',
			title : 'Thêm khách hàng',
			uri : '${addLKhachHangURL}'
		});
	});
	Liferay.provide(window,'dongPopup', function(){
		Liferay.Util.getOpener().dongPopup('dialogKhachHangAdd');
	});
	Liferay.provide(window,'thongBao', function(){
		toastr.success('Thêm khách hàng viên thành công', 'Thông báo!');
	});
	<!-- Lấy dữ liệu danh mục -->
	Liferay.provide(window,'getLoaiTaiSan', function(node){
		A.io.request('${getLoaiTaiSanURL}', {
               method: 'post',
               on: {
                   success: function() {
                   		if(this.get('responseData')){
                   			var data = JSON.parse(this.get('responseData'));
                   			if(data.loaiTaiSans){
                   				var loaiTaiSans = A.Array.map(data.loaiTaiSans, function(item) {
									item.id = item.loaiTaiSanId;
									item.text = item.ten;
									return item;
								});
								loaiTaiSans.unshift({
									id : '',
									text : 'Chọn'
								});
								node.empty().select2({
									data : loaiTaiSans
								});
	                   		}
                   		}
                   }
              }
        });
	});
	Liferay.provide(window,'tinhLaiSuat', function(){
		var soTienVay = form.one('#<portlet:namespace />soTienVay').val().replace(/[,]/g, '');
		var thoiHan = form.one('#<portlet:namespace />thoiHan').val();
		var laiSuatVay = form.one('#<portlet:namespace />laiSuatVay').val();
		var gocNgay = 0;
		if(soTienVay > 0 && thoiHan > 0){
			gocNgay = Math.round(soTienVay/thoiHan);
			var gocNgayCuoi = soTienVay - (gocNgay * (thoiHan - 1));
			form.one('#<portlet:namespace />tienGocNgay').val(gocNgay);
			form.one('#<portlet:namespace />tienGocNgayCuoi').val(gocNgayCuoi);
		}else{
			form.one('#<portlet:namespace />tienGocNgay').val('');
			form.one('#<portlet:namespace />tienGocNgayCuoi').val('');
		}
		if(soTienVay > 0 && laiSuatVay > 0 && thoiHan > 0){
			var laiNgay = Math.round((soTienVay * laiSuatVay)/(30 * 100));
		    form.one('#<portlet:namespace />tienLaiNgay').val(laiNgay);
		}else{
			  form.one('#<portlet:namespace />tienLaiNgay').val('');
		}
		form.one('#<portlet:namespace />tienGocNgay').simulate('change');
		form.one('#<portlet:namespace />tienGocNgayCuoi').simulate('change');
		form.one('#<portlet:namespace />tienLaiNgay').simulate('change');
		getNgayKetThuc();
	});
	Liferay.provide(window,'changeCreateDate', function(){
		<!-- Ngày kết thúc -->
		var createdate = 0;
		var pattern = /(\d{2})\/(\d{2})\/(\d{4})/;
		var createDateVal = form.one('#<portlet:namespace />createDate').val();
		if ('' != createDateVal && pattern.test(createDateVal) && 'dd/MM/yyyy' != createDateVal) {
			var date = new Date(createDateVal.replace(pattern, '$3-$2-$1'));
			createdate = date.getTime();
		}
		if(createdate != 0){
			var timeBatDau = createdate + (2 * 24 * 60 * 60 * 1000);
			var ngayBatDau = new Date(timeBatDau);
			var month = ngayBatDau.getMonth() + 1;
		    var day = ngayBatDau.getDate();
		    var year = ngayBatDau.getFullYear();
			if(month  < 10){
				month = "0" + month;
			}
			if(day < 10){
				day = "0" + day;
			}
			form.one('#<portlet:namespace />ngayBatDau').val(day + "/" + month + "/" + year);
			getNgayKetThuc();
		}
	});
	Liferay.provide(window,'getNgayKetThuc', function(){
		<!-- Ngày kết thúc -->
		var thoiHan = form.one('#<portlet:namespace />thoiHan').val();
		var ngayBatDau = 0;
		var pattern = /(\d{2})\/(\d{2})\/(\d{4})/;
		var ngayBatDauVal = form.one('#<portlet:namespace />ngayBatDau').val();
		if ('' != ngayBatDauVal && pattern.test(ngayBatDauVal) && 'dd/MM/yyyy' != ngayBatDauVal) {
			var date = new Date(ngayBatDauVal.replace(pattern, '$3-$2-$1'));
			ngayBatDau = date.getTime();
		}
		if(ngayBatDau != 0 && thoiHan > 0){
			var timeKetThuc = ngayBatDau + ((thoiHan - 1) * 24 * 60 * 60 * 1000);
			var ngayKetThuc = new Date(timeKetThuc);
			var month = ngayKetThuc.getMonth() + 1;
		    var day = ngayKetThuc.getDate();
		    var year = ngayKetThuc.getFullYear();
			if(month  < 10){
				month = "0" + month;
			}
			if(day < 10){
				day = "0" + day;
			}
			form.one('#<portlet:namespace />ngayKetThuc').val(day + "/" + month + "/" + year);
		}
	});
	Liferay.provide(window,'getDataKhachHang', function(){
		loadingMask.show();
		A.io.request('${getKhachHangByCongTacVienURL}', {
               method: 'post',
               data: {
               	'<portlet:namespace />maCTV' : A.one('#<portlet:namespace />maCTV').val()
               },
               on: {
                   success: function() {
                   		if(this.get('responseData')){
                   			var data = JSON.parse(this.get('responseData'));
                   			if(<%=phatVayId == 0 %> && data.soKU){
                   				 form.one('#<portlet:namespace />soKU').val(data.soKU);
							}
                   			if(data.khachHangs){
                   				var khachHangs = A.Array.map(data.khachHangs, function(item) {
									item.id = item.ma;
									item.text = item.hoTen;
									item.selected = '<%= phatVay.getMaKhachHang()%>'
									return item;
								});
								khachHangs.unshift({
									id : '',
									text : 'Chọn'
								});
								$('#<portlet:namespace />maKhachHang').empty().select2({
									data : khachHangs
								});
	                   		}
                   		}
                   }
              }
        });
        loadingMask.hide();
	});
	Liferay.provide(window,'loaiPhatVayChange', function(){
		var loaiPhatVay = A.one('#<portlet:namespace />loaiPhatVay').val();
		if(loaiPhatVay == 1){
			A.one('#<portlet:namespace />taiSanTheChap').show();
		}else{
			A.one('#<portlet:namespace />taiSanTheChap').hide();
		}
	});
	<!-- Xử lý bắt đầu -->
	loaiPhatVayChange();
	getDataKhachHang();
	<!-- Xử lý table -->
	var tableNode = form.one('#<portlet:namespace />taiSanTheChapTable');
	if(tableNode){
		var nodeAdd = tableNode.getElementsByTagName('thead').one('.icon-add');
		if(nodeAdd){
			nodeAdd.on('click',function(){
				addRowTaiSanTheChap();
			});
		}
	}
	Liferay.provide(window,'addRowTaiSanTheChap', function(){
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
		var tr = A.Node.create('<tr id="'+ len +'" class="result-row"/>');
		
		var td0 = A.Node.create('<td class="aui-w3"/>');
		var spanDel = A.Node.create('<span/>');
		var nodeDel = A.Node.create('<a class="icon-delete" href="javascript:void(0)"><i class="glyphicon glyphicon-trash"></i></a>');
		nodeDel.on('click', function(event){
			deleteRow(event);
		});
		spanDel.append(nodeDel);
		td0.append(spanDel);
		
		var td1 = A.Node.create('<td/>');
		var loaiTaiSanNode =  $('<select name="<portlet:namespace />loaiTaiSan_'+len+'" class="aui-w100"></select>');
		td1.append(loaiTaiSanNode);
		getLoaiTaiSan(loaiTaiSanNode);
		
		var td2 = A.Node.create('<td/>');
		var tenTaiSanNode = A.Node.create('<input name="<portlet:namespace />tenTaiSan_'+len+'" class="input-text aui-w100" >')
		td2.append(tenTaiSanNode);
		
		var td3 = A.Node.create('<td/>');
		var giaTriTaiSanNode = A.Node.create('<input onkeypress="_formatNumber();" name="<portlet:namespace />giaTriTaiSan_'+len+'"  id="<portlet:namespace />giaTriTaiSan_'+len+'" class="input-text aui-w100" >')
		td3.append(giaTriTaiSanNode);
		
		
		var td4 = A.Node.create('<td/>');
		var thongTinTaiSanNode = A.Node.create('<input name="<portlet:namespace />thongTinTaiSan_'+len+'"  class="input-text aui-w100" >')
		td4.append(thongTinTaiSanNode);
		
		var td5 = A.Node.create('<td/>');
		var ghiChuNode = A.Node.create('<input name="<portlet:namespace />ghiChu_'+len+'"  class="input-text aui-w100" >')
		td5.append(ghiChuNode);
		
		tr.append(td0);
		tr.append(td1);
		tr.append(td2);
		tr.append(td3);
		tr.append(td4);
		tr.append(td5);
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
				tbody.append('<tr><td colspan="6" class="empty text-center">Không có dữ liệu</td></tr>');
			}
		}
	});
	<!-- Xử lý lưu dữ liệu -->
	Liferay.provide(window,'refreshData', function(){
		form.all('input').each(function(node){
			node.val('');
		});
	});
	Liferay.provide(window,'save', function(close){
		loadingMask.show();
		if(<%=phatVayId == 0 %>){
			var data = {
				'<portlet:namespace />maCTV' : form.one('#<portlet:namespace />maCTV').val(),
				'<portlet:namespace />maKhachHang' : form.one('#<portlet:namespace />maKhachHang').val(),
			}
			A.io.request('${checkPhatVayKhachHang}', {
	               method: 'post',
	               data : data,
	               on: {
	                   success: function() {
	                   		if(this.get('responseData')){
	                   			var data = JSON.parse(this.get('responseData'));
	                   			if(!data.exception){
	                   				if(data.soPhatVayChuaTatToan > 0){
	                   						var check = confirm('Khách hàng còn phát vay chưa tất toán,có tiếp tục mở phát vay ?');
											if (check) {
												submitFrom(close);
											}
	                   				}else{
	                   					submitFrom(close);
	                   				}
	                   			}else{
                   					toastr.error('Yêu cầu thực hiện không thành công', 'Lỗi!');
	                   			}
	                   		}
	                   }
	              }
	        });
		}else{
			submitFrom(close);
		}
        loadingMask.hide();
	});
	Liferay.provide(window,'submitFrom', function(close){
		loadingMask.show();
		formValidator.validate();
		if(!formValidator.hasErrors()){
			var batLoi = false;
			var soTienVay = form.one('#<portlet:namespace />soTienVay').val().replace(/[,]/g, '');
			if(soTienVay < 1000000){
				batLoi = true;
				toastr.warning('Vui lòng nhập số tiền vay trên 1,000,000 VND', 'Cảnh báo!');
			}
			var loaiPhatVay = form.one('#<portlet:namespace />loaiPhatVay').val();
			var ngayBatDauTime = 0;
			var createDateTime = 0;
			var pattern = /(\d{2})\/(\d{2})\/(\d{4})/;
			var createDateVal = form.one('#<portlet:namespace />createDate').val();
			if ('' != createDateVal && pattern.test(createDateVal) && 'dd/MM/yyyy' != createDateVal) {
				var date = new Date(createDateVal.replace(pattern, '$3-$2-$1'));
				createDateTime = date.getTime();
			}
			var ngayBatDauVal = form.one('#<portlet:namespace />ngayBatDau').val();
			if ('' != ngayBatDauVal && pattern.test(ngayBatDauVal) && 'dd/MM/yyyy' != ngayBatDauVal) {
				var date = new Date(ngayBatDauVal.replace(pattern, '$3-$2-$1'));
				ngayBatDauTime = date.getTime();
			}
			var ngayKetThucTime = 0;
			var ngayKetThucVal = form.one('#<portlet:namespace />ngayKetThuc').val();
			if ('' != ngayKetThucVal && pattern.test(ngayKetThucVal) && 'dd/MM/yyyy' != ngayKetThucVal) {
				var date = new Date(ngayKetThucVal.replace(pattern, '$3-$2-$1'));
				ngayKetThucTime = date.getTime();
			}
			var data = {
				'<portlet:namespace />phatVayId' : '<%=phatVayId %>',
				'<portlet:namespace />maCTV' : form.one('#<portlet:namespace />maCTV').val(),
				'<portlet:namespace />soKU' : form.one('#<portlet:namespace />soKU').val(),
				'<portlet:namespace />maKhachHang' : form.one('#<portlet:namespace />maKhachHang').val(),
				'<portlet:namespace />soTienVay' : form.one('#<portlet:namespace />soTienVay').val(),
				'<portlet:namespace />thoiHan' : form.one('#<portlet:namespace />thoiHan').val(),
				'<portlet:namespace />laiSuatVay' : form.one('#<portlet:namespace />laiSuatVay').val(),
				'<portlet:namespace />tienLaiNgay' : form.one('#<portlet:namespace />tienLaiNgay').val(),
				'<portlet:namespace />tienGocNgay' : form.one('#<portlet:namespace />tienGocNgay').val(),
				'<portlet:namespace />tienGocNgayCuoi' : form.one('#<portlet:namespace />tienGocNgayCuoi').val(),
				'<portlet:namespace />ngayBatDauTime' : ngayBatDauTime,
				'<portlet:namespace />ngayKetThucTime' : ngayKetThucTime,
				'<portlet:namespace />createDateTime' : createDateTime,
				'<portlet:namespace />loaiPhatVay' : loaiPhatVay
			}
			var arrayTheChap = [];
			if(loaiPhatVay == 1){
				var tableTheChap = form.one('#<portlet:namespace />taiSanTheChapTable');
				if(tableTheChap){
					tableTheChap.all('tr.result-row').each(function(node){
						var item = {};
						var batLoiGiaTri = false;
						node.all('select,input').each(function(component){
							if(component.attr('name')){
								var componentName = component.attr('name').replace('<portlet:namespace />','');
								var key = componentName.substring(0,componentName.indexOf('_'));
								if(key == 'loaiTaiSan' && component.val() == ''){
									batLoi = true;
									toastr.warning('Chưa nhập loại tài sản', 'Cảnh báo!');
								}else if (key == 'tenTaiSan' && component.val() == ''){
									batLoi = true;
									toastr.warning('Chưa nhập tên tài sản', 'Cảnh báo!');
								}else if ( key == 'giaTriTaiSan' && component.val() == ''){
									batLoi = true;
									toastr.warning('Chưa nhập giá trị tài sản', 'Cảnh báo!');
								}else{
									item[key] = component.val();
								}
							}
						});
						if (!A.Object.isEmpty(item) && item.loaiTaiSan && item.tenTaiSan && item.giaTriTaiSan) {
							arrayTheChap.push(item);
						}
					});
				}
				if(arrayTheChap.length == 0){
					batLoi = true;
					toastr.warning('Chưa nhập thông tin tài sản thế chấp', 'Cảnh báo!');
				}else{
					data['<portlet:namespace />taiSanTheChap'] = A.JSON.stringify(arrayTheChap)
				}
			}
			if(!batLoi){
				A.io.request('${saveURL}', {
		               method: 'post',
		               data : data,
		               on: {
		                   success: function() {
		                   		if(this.get('responseData')){
		                   			var data = JSON.parse(this.get('responseData'));
		                   			if(!data.exception){
	                   					Liferay.Util.getOpener().search();
		                   				if(close){
		                   					refreshData();
		                   					Liferay.Util.getOpener().dongPopup('<%=dialogId%>');
		                   					Liferay.Util.getOpener().thongBao('<%=phatVayId > 0 ? "Cập nhật phát vay thành công" : "Thêm phát vay thành công"  %>');
		                   				}else{
		                   					form.one('#<portlet:namespace />maCTV').val('');
		                   					form.one('#<portlet:namespace />maCTV').simulate('change');
		                   					form.one('#<portlet:namespace />soKU').val('');
		                   					form.one('#<portlet:namespace />maKhachHang').val('');
		                   					form.one('#<portlet:namespace />maKhachHang').simulate('change');
		                   					form.one('#<portlet:namespace />soTienVay').val('');
		                   					form.one('#<portlet:namespace />thoiHan').val('');
		                   					form.one('#<portlet:namespace />tienLaiNgay').val('');
		                   					form.one('#<portlet:namespace />tienGocNgay').val('');
		                   					form.one('#<portlet:namespace />tienGocNgayCuoi').val('');
		                   					form.one('#<portlet:namespace />ngayKetThuc').val('');
		                   					form.one('#<portlet:namespace />loaiPhatVay').val(1);
		                   					loaiPhatVayChange();
		                   					getDataKhachHang();
		                   					toastr.success('Thêm danh phát vay thành công', 'Thông báo!');
		                   					console.log(form.one('#<portlet:namespace />laiSuatVay').val());
		                   				}
		                   			}else{
		                   				if(data.exception.indexOf('com.mb.exception.TrungSoKUException') > -1){
		                   					toastr.warning('Số KU đã tồn tại', 'Cảnh báo!');
		                   				}else{
		                   					toastr.error('Yêu cầu thực hiện không thành công', 'Lỗi!');
		                   				}
		                   			}
		                   		}
		                   }
		              }
		        });
			}
        }
        loadingMask.hide();
	});
});
</aui:script>