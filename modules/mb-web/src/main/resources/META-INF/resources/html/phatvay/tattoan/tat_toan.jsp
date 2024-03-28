<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/danhmuc/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<portlet:renderURL var="addURL"
	windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="dialogId" value="dialogAdd" />
	<portlet:param name="mvcPath" value="/html/phatvay/tattoan/add_tat_toan.jsp" />
</portlet:renderURL>
<%
	String oppenDialogAdd = "openDialog('"+addURL.toString() + "','Chọn phát vay tất toán','dialogAdd');";
%>
<aui:form name="fmDanhSach">
	<table class="info table-pa5 aui-w100">
		<tr>
			<td class="aui-w50">
				<aui:select name="maCTVSearch" label="Cộng tác viên" cssClass="input-select2" onchange="showThongTinTatToan();">
					 <aui:option value=" " label="Chọn" />
					 <c:forEach items="<%= ctvs%>" var="item">
					 	<aui:option value="${item.ma}" label="${item.hoTen} - ${item.ma}"/>
					</c:forEach>
				</aui:select>
			</td>
			<td class="aui-w50">
				<aui:input cssClass="input-date" name="ngayTatToan" label="Ngày tất toán" placeholder="dd/MM/yyyy" onchange="reloadByDate();">
				</aui:input>
			</td>
		</tr>
	</table>
	<table class="info table-pa5 aui-w100">
			<tr>
				<td>
					<button id="<portlet:namespace />tatToanBtn" type="button" class="btn btn-labeled btn-danger" onclick="tatToan();">
						<span class="btn-label"><i class="glyphicon glyphicon-piggy-bank"></i></span>Tất toán
					</button>
					<button id="<portlet:namespace />inPhieuTatToan" type="button" class="btn btn-info btn-labeled" onclick="printPhieuTatToan();">
						<span class="btn-label"><i class="glyphicon glyphicon-print"></i></span>In Phiếu Tất Toán
					</button>
				</td>
			</tr>
	</table>
	<div id="<portlet:namespace />messCTV" class="alert alert-warning">
	  <strong>Vui lòng chọn cộng tác viên muốn tất toán phát vay</strong>
	</div>
	<table id="<portlet:namespace />tableTatToan" class="table-pa5 table-border-all aui-w100 hide">
		<thead>
			<tr>
				<th class="aui-w3"><a class="icon-add" onclick="<%=oppenDialogAdd%>" href="javascript:void(0)"><i class="glyphicon glyphicon-plus"></i></a></th>
			    <th>Thông tin phát vay</th>
			    <th>Thông tin khách hàng</th>
			    <th>Thông tin lãi suất</th>
			    <th>Thông tin tất toán</th>
			 </tr>
		</thead>
		 <tbody>
			<tr>
				<td colspan="5" class="empty text-center">Vui lòng thêm phát vay muốn tất toán</td>
			</tr>
		</tbody>
		<tfoot>
			<tr id="<portlet:namespace />footTatToan" class="hide">
				<td colspan="4" style="color:#ff3d00e8;font-weight: bold;" class=" text-center">TỔNG</td>
				<td style="font-weight: bold;">
					Vốn trả : <span id="<portlet:namespace />tongTraVon" style="font-style: italic;color:#ff3d00e8;"></span><br/>
					Lãi trả : <span id="<portlet:namespace />tongTraLai" style="font-style: italic;color:#ff3d00e8;"></span><br/>
					Tổng trả : <span id="<portlet:namespace />tongTra" style="font-style: italic;color:#ff3d00e8;"></span>
				</td>
			</tr>
	  </tfoot>
	</table>
</aui:form>
<portlet:resourceURL var="tatToanURL" id="tatToanURL"></portlet:resourceURL>
<portlet:resourceURL var="printPhieuTatToan" id="printPhieuTatToan"></portlet:resourceURL>
<portlet:resourceURL var="getThongTinTatToan" id="getThongTinTatToan"></portlet:resourceURL>
<portlet:resourceURL var="getTongTienTatToan" id="getTongTienTatToan"></portlet:resourceURL>
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
	var loadingMask = new A.LoadingMask(
		{
			target: A.getBody()
		}
	);
	var maCTVCu = ' ';
	var listPhatVayIds = [];
	Liferay.provide(window,'reloadByDate', function(){
		if(listPhatVayIds && listPhatVayIds.length > 0){
			var tableNode = A.one('#<portlet:namespace />tableTatToan');
			var tbody = tableNode.getElementsByTagName('tbody');
			tbody.empty();
			tbody.append('<tr><td colspan="5" class="empty text-center">Không có dữ liệu</td></tr>');
			var ids  = listPhatVayIds.toString();
			listPhatVayIds =[];
			addPhatVayTatToan(ids);
		}
	});
	Liferay.provide(window,'showThongTinTatToan', function(){
		var maCTV = A.one('#<portlet:namespace />maCTVSearch').val();
		if(maCTV == ' '){
			A.one('#<portlet:namespace />messCTV').show();	
			A.one('#<portlet:namespace />tableTatToan').hide();
		}else{
			if(maCTVCu != maCTV && maCTVCu != ' '){
				var check = confirm('Bạn muốn thao tác cộng tác viên khác ?');
				if(check){
					A.one('#<portlet:namespace />messCTV').hide();
					A.one('#<portlet:namespace />tableTatToan').show();
					A.one('#<portlet:namespace />footTatToan').hide();
					var tableNode = A.one('#<portlet:namespace />tableTatToan');
       				var tbody = tableNode.getElementsByTagName('tbody');
					tbody.empty();
					tbody.append('<tr><td colspan="5" class="empty text-center">Không có dữ liệu</td></tr>');
					listPhatVayIds = [];
					
				}
			}else{
				A.one('#<portlet:namespace />footTatToan').hide();
				A.one('#<portlet:namespace />messCTV').hide();
				A.one('#<portlet:namespace />tableTatToan').show();
			}
		}
		maCTVCu = maCTV;
	});
	Liferay.provide(window,'openDialog', function(url,title,dialogId){
		var ngayTatToan = 0;
		var pattern = /(\d{2})\/(\d{2})\/(\d{4})/;
		var ngayTatToanVal = A.one('#<portlet:namespace />ngayTatToan').val();
		if (('' != ngayTatToanVal && pattern.test(ngayTatToanVal)) && 'dd/MM/yyyy' != ngayTatToanVal) {
			var date = new Date(ngayTatToanVal.replace(pattern, '$3-$2-$1'));
			ngayTatToan = date.getTime();
		}
		var maCTV = A.one('#<portlet:namespace />maCTVSearch').val();
		url += '&<portlet:namespace/>maCTV=' + maCTV;
		url += '&<portlet:namespace/>ngayTatToanTime=' + ngayTatToan;
		url += '&<portlet:namespace/>phatVayIdAdds=' + listPhatVayIds.toString();
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
	Liferay.provide(window,'addPhatVayTatToan', function(phatVayIdAdds,dialogId){
		var idAdds = phatVayIdAdds.split(',');
		var listAddIds = [];
	    for (var i = 0; i < idAdds.length; i++) {
			if(!containsObject(idAdds[i],listPhatVayIds)){
				listPhatVayIds.push(idAdds[i]);
				listAddIds.push(idAdds[i]);
			}
	    }
	    loadingMask.show();
	    var ngayTatToan = 0;
		var pattern = /(\d{2})\/(\d{2})\/(\d{4})/;
		var ngayTatToanVal = A.one('#<portlet:namespace />ngayTatToan').val();
		if (('' != ngayTatToanVal && pattern.test(ngayTatToanVal)) && 'dd/MM/yyyy' != ngayTatToanVal) {
			var date = new Date(ngayTatToanVal.replace(pattern, '$3-$2-$1'));
			ngayTatToan = date.getTime();
		}
		A.io.request('${getThongTinTatToan}', {
	               method: 'post',
	               data : {
	               	'<portlet:namespace />phatVayIds' : listAddIds.toString(),
	               	'<portlet:namespace />ngayTatToan' : ngayTatToan
	               },
	               on: {
	                   success: function() {
	                   		if(this.get('responseData')){
	                   			var data = JSON.parse(this.get('responseData'));
	                   			for (var i = 0; i < data.data.length; i++) {
	                   				var tableNode = A.one('#<portlet:namespace />tableTatToan');
	                   				var tbody = tableNode.getElementsByTagName('tbody');
	                   				var array = tbody.all('tr').attr('id');
	                   				var isEmpty = tbody.all('tr' + ">td.empty");
									if (isEmpty && isEmpty.size() == 1) {
										tbody.empty();
									}
									var len = array.length > 0 ? array.max() + 1 : 1;
									var tr = A.Node.create('<tr id="'+ len +'" class="result-row"/>');
									var td0 = A.Node.create('<td class="aui-w3"/>');
									var spanDel = A.Node.create('<span/>');
									var nodeDel = A.Node.create('<a class="icon-delete" href="javascript:void(0)"><i class="glyphicon glyphicon-trash"></i></a>');
									nodeDel.on('click', function(event){
										deleteRow(event);
									});
									spanDel.append(nodeDel);
									td0.append(spanDel);
									td0.append(A.Node.create('<input value="'+ data.data[i].phatVayId +'" name="<portlet:namespace />idTatToan_'+len+'" class="hide input-text aui-w100" >'));
									
									
									var td1 = A.Node.create('<td/>');
									td1.append(A.Node.create('Số KU : <span style="color:#ff3d00e8" >' + data.data[i].soKU + '</span><br/>'));
									td1.append(A.Node.create('Số tiền vay : <span style="color: blue;" >' + data.data[i].soTienVayStr + '</span><br/>'));
							  		td1.append(A.Node.create('Thời hạn : <span style="color: blue;">' + data.data[i].thoiHan + '</span><span class="note-span"> ngày</span><br/>'));
								 	td1.append(A.Node.create('Thời hạn : <span style="color: blue;">' + data.data[i].thoiHan + '</span><span class="note-span"> ngày</span><br/>'));
								 	var tenLoaiPhatVay = data.data[i].loaiPhatVay == 1 ? 'Thế chấp' :  'Tín chấp';
								 	td1.append(A.Node.create('Loại phát vay : <span style="color: blue;">'+ tenLoaiPhatVay +'</span><br/>'));
							 		td1.append(A.Node.create('<span class="note-span">(</span><span class="note-span" style="color:blue" >Lãi suất :' + data.data[i].laiSuatVay + '</span><span class="note-span">)</span>'));
									
									var td2 = A.Node.create('<td/>');
									td2.append(A.Node.create('Khách hàng : <span style="color:#ff3d00e8" >'+  data.data[i].hoTenKhachHang +'</span><br/>'));
									td2.append(A.Node.create('(Mã : <span style="color:#ff3d00e8" >'+ data.data[i].maKhachHang +'</span>)<br/>'));
									var hoTenCTV =  data.data[i].congTacVien ? data.data[i].congTacVien.hoTen : '';
									td2.append(A.Node.create('Cộng tác viên : <span style="color:#ff3d00e8" >'+ data.data[i].hoTenCTV +'</span><br/>'));
									td2.append(A.Node.create('(Mã : <span style="color:#ff3d00e8" >'+ data.data[i].maCTV +'</span>)<br/>'));
									
									var td3 = A.Node.create('<td/>');
									td3.append(A.Node.create('Lãi ngày : <span style="font-style: italic;color:blue;">'+data.data[i].laiNgayStr+'</span><br/>'));
									td3.append(A.Node.create('Gốc ngày : <span style="font-style: italic;color:blue;">'+data.data[i].gocNgayStr+'</span><br/>'));
									td3.append(A.Node.create('Gốc ngày cuối : <span style="font-style: italic;color:blue;">'+data.data[i].gocNgayCuoiStr+'</span><br/>'));
								 	td3.append(A.Node.create('Dư nợ gốc còn : <span style="font-style: italic;color:blue;">'+data.data[i].duNoGocStr+'</span><br/>'));
									td3.append(A.Node.create('	Số ngày đã thu : <span style="font-style: italic;color:blue;">'+data.data[i].tongSoLanDaThu+'</span>'));
									
									var td4 = A.Node.create('<td/>');
									td4.append(A.Node.create('Trả vốn : <span style="font-style: italic;color:#ff3d00e8;">'+data.data[i].tongVonTatToanStr+'</span><br/>'));
									td4.append(A.Node.create('Trả lãi : <span style="font-style: italic;color:#ff3d00e8;">'+data.data[i].tongLaiTatToanStr+'</span>'));
									td4.append(A.Node.create('<input value="'+ data.data[i].tongVonTatToan +'" name="<portlet:namespace />traVon_'+len+'" class="hide input-text aui-w100" >'));
									td4.append(A.Node.create('<input value="'+ data.data[i].tongLaiTatToan +'" name="<portlet:namespace />traLai_'+len+'" class="hide input-text aui-w100" >'));
									 
									tr.append(td0);
									tr.append(td1);
									tr.append(td2);
									tr.append(td3);
									tr.append(td4);
									tbody.append(tr);
							    }
							    getTongTienTatToan();
	                   		}
	                   		loadingMask.hide();
	                   }
	              }
        });
        if(dialogId){
	        var dialog = Liferay.Util.Window.getById('<portlet:namespace />' + dialogId);
			if(dialog){
				dialog.destroy();
			}
        }
	});
	Liferay.provide(window,'getTongTienTatToan', function(){
		loadingMask.show();
		
		if(listPhatVayIds.length > 0){
			var ngayTatToan = 0;
			var pattern = /(\d{2})\/(\d{2})\/(\d{4})/;
			var ngayTatToanVal = A.one('#<portlet:namespace />ngayTatToan').val();
			if (('' != ngayTatToanVal && pattern.test(ngayTatToanVal)) && 'dd/MM/yyyy' != ngayTatToanVal) {
				var date = new Date(ngayTatToanVal.replace(pattern, '$3-$2-$1'));
				ngayTatToan = date.getTime();
			}
			
			A.io.request('${getTongTienTatToan}', {
	               method: 'post',
	               data : {
	               	'<portlet:namespace />phatVayIds' : listPhatVayIds.toString(),
	               	'<portlet:namespace />ngayTatToan' : ngayTatToan,
	               },
	               on: {
	                   success: function() {
	                   		if(this.get('responseData')){
	                   			var data = JSON.parse(this.get('responseData'));
                   				A.one('#<portlet:namespace />tongTraVon').html(data.tongVonTatToanStr);	
                   				A.one('#<portlet:namespace />tongTraLai').html(data.tongLaiTatToanStr);	
                   				A.one('#<portlet:namespace />tongTra').html(data.tongTatToanStr);	
	                   		}
	                   		loadingMask.hide();
	                   }
	              }
        	});
        	A.one('#<portlet:namespace />footTatToan').show();
		}else{
			A.one('#<portlet:namespace />footTatToan').hide();
			loadingMask.hide();
		}
	});
	Liferay.provide(window,'deleteRow', function(event){
		var currentNode = event.currentTarget;
		var check = confirm('Bạn có chắc thực hiện thao tác này ?');
		if (currentNode && check) {
			var table = currentNode.ancestor('table');
			var tbody = table.getElementsByTagName('tbody');
			var row = currentNode.ancestor('tr');
			
			listPhatVayIds.splice(row.attr('id') - 1, 1);
			
			row.remove();
			if (tbody.all('tr').size() == 0) {
				tbody.append('<tr><td colspan="5" class="empty text-center">Không có dữ liệu</td></tr>');
				listPhatVayIds = [];
			}
		}
		getTongTienTatToan();
	});
	function containsObject(obj, list) {
	    var i;
	    for (i = 0; i < list.length; i++) {
	        if (list[i] === obj) {
	            return true;
	        }
	    }
	
	    return false;
	}
	Liferay.provide(window,'tatToan', function(){
		var check = confirm('Bạn có chắc thực hiện thao tác này ?');
		if (check && listPhatVayIds.length > 0) {
			loadingMask.show();
		    var ngayTatToan = new Date().getTime();
		    var pattern = /(\d{2})\/(\d{2})\/(\d{4})/;
		    var ngayTatToanVal = A.one('#<portlet:namespace />ngayTatToan').val();
		    if (('' != ngayTatToanVal && pattern.test(ngayTatToanVal)) && 'dd/MM/yyyy' != ngayTatToanVal) {
				var date = new Date(ngayTatToanVal.replace(pattern, '$3-$2-$1'));
				ngayTatToan = date.getTime();
		    }
			
			
			
			A.io.request('${tatToanURL}', {
		               method: 'post',
		               data : {
		               	'<portlet:namespace />phatVayIds' : listPhatVayIds.toString(),
		               	'<portlet:namespace />ngayTatToan' : ngayTatToan,
		               },
		               on: {
		                   success: function() {
		                   		if(this.get('responseData')){
		                   			var data = JSON.parse(this.get('responseData'));
		                   			if(!data.exception){
	                   					toastr.success('Đã tất toán phát vay thành công', 'Thông báo!');
		                   			}else{
	                   					toastr.error('Yêu cầu thực hiện không thành công', 'Lỗi!');
		                   			}
		                   		}
		                   }
		              }
	        });
	        loadingMask.hide();
		}
	});
	Liferay.provide(window,'printPhieuTatToan', function(){
		var url = '${printPhieuTatToan}';
		var ngayTatToan = 0;
		var pattern = /(\d{2})\/(\d{2})\/(\d{4})/;
		var ngayTatToanVal = A.one('#<portlet:namespace />ngayTatToan').val();
		if (('' != ngayTatToanVal && pattern.test(ngayTatToanVal)) && 'dd/MM/yyyy' != ngayTatToanVal) {
			var date = new Date(ngayTatToanVal.replace(pattern, '$3-$2-$1'));
			ngayTatToan = date.getTime();
		}
		url += '&<portlet:namespace/>ngayTatToan=' + ngayTatToan;
		url += '&<portlet:namespace/>phatVayIds=' + listPhatVayIds.toString();
		url += '&<portlet:namespace/>maCTV=' + A.one('#<portlet:namespace />maCTVSearch').val();
		window.location.href = url;
	});
});
</aui:script>