<%@page import="com.mb.service.LichSuThuPhatChiLocalServiceUtil"%>
<%@page import="com.mb.model.LichSuThuPhatChi"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="quanly.portlet.phatvay.phatvay.PhatVayComparator"%>
<%@page import="com.mb.service.PhatVayLocalServiceUtil"%>
<%@page import="com.mb.model.PhatVay"%>
<%@page import="java.util.Date"%>
<%@page import="quanly.portlet.danhmuc.ctv.CongTacVienComparator"%>
<%@page import="com.mb.model.CongTacVien"%>
<%@page import="com.mb.service.CongTacVienLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/thongke/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
.text-right{
	text-align: right;
}
.td-overflow{
	overflow-x: scroll;
	width: max-content;
}
</style>
<%
	String maCTVSearch = ParamUtil.getString(request, "maCTVSearch");
	long ngayBatDauTuSearchTime = ParamUtil.getLong(request, "ngayBatDauTuSearchTime");
	Date ngay = ngayBatDauTuSearchTime > 0 ? new Date(ngayBatDauTuSearchTime) : null;
	List<CongTacVien> items = CongTacVienLocalServiceUtil.getCTVSaoKe(maCTVSearch,ngay);
	int count = items.size();
	DecimalFormat df = new DecimalFormat("###,###.###");
	Double tongDuNoToiDaAll = GetterUtil.getDouble("0");
	Double tongTienVayAll = GetterUtil.getDouble("0");
	Double tongGocNgayAll = GetterUtil.getDouble("0");
	Double tongLaiNgayAll = GetterUtil.getDouble("0");
	Double tongGocDaThuAll = GetterUtil.getDouble("0");
	Double tongLaiDaThuAll = GetterUtil.getDouble("0");
	Double tongDuNoGocAll = GetterUtil.getDouble("0");
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
%>
<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/html/thongke/sao_ke_kh/data.jsp" />
	<portlet:param name="maCTVSearch" value="<%=maCTVSearch%>" />
	<portlet:param name="ngayBatDauTuSearchTime" value="<%=String.valueOf(ngayBatDauTuSearchTime)%>" />
</liferay-portlet:renderURL>
<!-- style="width: max-content;min-width: 100%;" -->
<div id="<portlet:namespace />recordSearchContainer">
	<div style="text-align: right;"><span class="note-span">(Đơn vị : VND)</span></div>
	<liferay-ui:search-container  delta="20"  emptyResultsMessage="Không có kết quả nào được tìm thấy!" iteratorURL="<%=iteratorURL %>" total="<%=count %>" >
		 <%
		 	String orderByType = ParamUtil.getString(request, "orderByType"); 
		 	String orderByCol = ParamUtil.getString(request, "orderByCol"); 
		 	if(Validator.isNull(orderByType)){
		 		orderByType = "asc";
		 	}
		 	if(Validator.isNull(orderByCol)){
		 		orderByCol = "createdate";
		 	}
		 	boolean ascending = false;
		 	if("asc".equals(orderByType)){
		 		ascending = true;
		 	}
		 	CongTacVienComparator obc = new CongTacVienComparator(orderByCol,ascending);
		 	searchContainer.setOrderByCol(orderByCol);
		 	searchContainer.setOrderByType(orderByType);
		 	searchContainer.setOrderByComparator(obc);
			%>
		 <liferay-ui:search-container-results results="<%= items %>" />
		 <liferay-ui:search-container-row className="com.mb.model.CongTacVien" modelVar="congTacVien" keyProperty="congTacVienId" indexVar="index"> 
			 <%
			 	Double tongTienVay = GetterUtil.getDouble("0");
				Double tongGocNgay = GetterUtil.getDouble("0");
				Double tongLaiNgay = GetterUtil.getDouble("0");
				Double tongGocDaThu = GetterUtil.getDouble("0");
				Double tongLaiDaThu = GetterUtil.getDouble("0");
				Double tongDuNoGoc = GetterUtil.getDouble("0");
				tongDuNoToiDaAll += congTacVien.getDuNoToiDa();
				PhatVayComparator obcPhatVay = new PhatVayComparator("createdate",true);
		 		List<PhatVay> phatVays = PhatVayLocalServiceUtil.getPhatVaySaoKe(congTacVien.getMa(), ngay);
		 		Double duNoToiDaTinChap = GetterUtil.getDouble("0");
		 		if(congTacVien.getDuNoToiDa() > congTacVien.getDuNoToiDaTheChap()){
		 			duNoToiDaTinChap = congTacVien.getDuNoToiDa() - congTacVien.getDuNoToiDaTheChap();
		 		}
			 
			 %>
			 <liferay-ui:search-container-column-text>
			 	<table style="width: 100%;" class="table table-borderless">
			 		<tr>
			 			<td class="aui-w20" rowspan="2" >
				 			<span style="color: blue;font-weight: bold;">TÊN CTV : <%= congTacVien.getHoTen() %></span>
			 			</td>
			 			<td class="aui-w15" rowspan="2">
			 				<span style="color: blue;font-weight: bold;">MÃ SỐ : <%= congTacVien.getMa() %></span>
			 			</td>
			 			<td class="aui-w20" rowspan="2">
			 				<span style="color: blue;font-weight: bold;">TỔNG ĐỊNH MỨC DƯ NỢ : <%=congTacVien.getDuNoToiDa() > 0 ? df.format(congTacVien.getDuNoToiDa()) : "0" %></span>
			 			</td>
			 			<td class="aui-w20">
				 			<span style="color: blue;font-weight: bold;">ĐỊNH MỨC TÍN CHẤP : <%=duNoToiDaTinChap > 0 ? df.format(duNoToiDaTinChap) : "0" %></span>
			 			</td>
			 		</tr>
			 		<tr>
			 			<td class="aui-w20">
			 				<span style="color: blue;font-weight: bold;">ĐỊNH MỨC THẾ CHẤP : <%=congTacVien.getDuNoToiDaTheChap() > 0 ? df.format(congTacVien.getDuNoToiDaTheChap()) : "0" %></span>
			 			</td>
			 		</tr>
			 	</table>
			 	<table style="width: 100%;">
			 		<th>SỐ KU</th>
			 		<th>Mã</th>
			 		<th>Họ Tên</th>
			 		<th>Địa chỉ</th>
			 		<th>Ngày vay</th>
			 		<th>T.hạn</th>
			 		<th>Lần</th>
			 		<th>Số tiền</th>
			 		<th>Gốc ngày</th>
			 		<th>Lãi ngày</th>
			 		<th>Gốc đã thu</th>
			 		<th>Lãi đã thu</th>
			 		<th>Dư gốc</th>
			 		<%
			 		for(PhatVay item : phatVays){
			 			Double gocDaThu = GetterUtil.getDouble("0");
			 			Double laiDaThu = GetterUtil.getDouble("0");
			 			Double duGoc =  item.getSoTienVay();
			 			List<LichSuThuPhatChi> lichSuThuPhatChis = LichSuThuPhatChiLocalServiceUtil.findByPhatVay_Createdate_Loai(item.getPhatVayId(), null, ngay, "3,4");
			 			for(LichSuThuPhatChi lichSuThuPhatChi : lichSuThuPhatChis){
			 				gocDaThu += lichSuThuPhatChi.getTongSoTienVonTra();
			 				laiDaThu += lichSuThuPhatChi.getTongSoTienLaiTra();
			 				duGoc -= lichSuThuPhatChi.getTongSoTienVonTra();
			 			}
			 			tongTienVay += item.getSoTienVay();
			 			tongGocNgay += item.getGocNgay();
			 			tongLaiNgay += item.getLaiNgay();
			 			tongGocDaThu += gocDaThu;
			 			tongLaiDaThu += laiDaThu;
			 			tongDuNoGoc += duGoc;
			 			
			 			Double soLanDaThu =  gocDaThu/item.getGocNgay();
			 			
			 			tongTienVayAll += item.getSoTienVay();
			 			tongGocNgayAll += item.getGocNgay();
			 			tongLaiNgayAll += item.getLaiNgay();
			 			tongGocDaThuAll += gocDaThu;
			 			tongLaiDaThuAll += laiDaThu;
			 			tongDuNoGocAll += duGoc;
			 			
				 	%>
				 		<tr>
				 			<td><%=item.getSoKU() %></td>
				 			<td><%=item.getMaKhachHang() %></td>
				 			<td><%=item.getKhachHang() != null ? item.getKhachHang().getHoTen()  : "" %></td>
				 			<td>
				 				<span data-toggle="tooltip" title="<%=item.getKhachHang() != null ? item.getKhachHang().getDiaChi() : ""%>"><%=(item.getKhachHang() != null && Validator.isNotNull(item.getKhachHang().getDiaChi()) && item.getKhachHang().getDiaChi().length() > 40) ? item.getKhachHang().getDiaChi().substring(0, 40) + "..." : item.getKhachHang().getDiaChi() %></span>
				 			</td>
				 			<td><%=item.getCreateDate() != null ? sdf.format(item.getCreateDate()) : ""%></td>
				 			<td><%=item.getThoiHan()%></td>
				 			<td><%=GetterUtil.getInteger(soLanDaThu)%></td>
				 			<td><%=item.getSoTienVay() > 0 ? df.format(item.getSoTienVay()) : "0"%></td>
				 			<td><%=item.getGocNgay() > 0 ? df.format(item.getGocNgay()) : "0"%></td>
				 			<td><%=item.getLaiNgay() > 0 ? df.format(item.getLaiNgay())  : "0"%></td>
				 			<td><%=gocDaThu > 0 ? df.format(gocDaThu) : "0"%></td>
				 			<td><%=laiDaThu > 0 ? df.format(laiDaThu) : "0"%></td>
				 			<td><%=duGoc > 0 ? df.format(duGoc) : "0"%></td>
				 		</tr>
				 	<%
				 		}
				 	%>
				 	<tr>
				 		<td style="text-align: center;color: red;font-weight: bold;" colspan="7">TỔNG</td>
				 		<td style="color: red;font-weight: bold;"><%=tongTienVay > 0 ? df.format(tongTienVay) : "0"%></td>
				 		<td style="color: red;font-weight: bold;"><%=tongGocNgay > 0 ? df.format(tongGocNgay) : "0"%></td>
				 		<td style="color: red;font-weight: bold;"><%=tongLaiNgay > 0 ? df.format(tongLaiNgay) : "0"%></td>
				 		<td style="color: red;font-weight: bold;"><%=tongGocDaThu > 0 ? df.format(tongGocDaThu) : "0"%></td>
				 		<td style="color: red;font-weight: bold;"><%=tongLaiDaThu > 0 ? df.format(tongLaiDaThu) : "0"%></td>
				 		<td style="color: red;font-weight: bold;"><%=tongDuNoGoc > 0 ? df.format(tongDuNoGoc) : "0"%></td>
				 	</tr>
			 	</table>
			 </liferay-ui:search-container-column-text>
		 </liferay-ui:search-container-row >
		 <liferay-ui:search-iterator />
	</liferay-ui:search-container >
</div>

<aui:script use="aui-base,aui-io-plugin-deprecated,aui-loading-mask-deprecated">
AUI().ready(['aui-base'], function(A) {
	Liferay.Data.redirectURL = '${iteratorURL}';
	var recordSearchContainer = A.one('#<portlet:namespace />recordSearchContainer');
	var loadingMask = new A.LoadingMask(
		{
			target: recordSearchContainer
		}
	);
	var plugin = recordSearchContainer.plug(A.Plugin.IO,{
        autoLoad: false,
        failureMessage : 'Loading...'
    });
	var pageIO = plugin.io;
	recordSearchContainer.all('ul.dropdown-menu.lfr-menu-list.direction-down a').on('click', function(e) {
    	e.preventDefault();
    	Liferay.Data.redirectURL = e.currentTarget.get('href');
    	pageIO.set('uri', e.currentTarget.get('href'));
    	pageIO.start();
    });
    recordSearchContainer.all('ul.lfr-pagination-buttons.pager a').on('click', function(e) {
    	e.preventDefault();
    	Liferay.Data.redirectURL = e.currentTarget.get('href');
    	pageIO.set('uri', e.currentTarget.get('href'));
    	pageIO.start();
    });
    recordSearchContainer.all('div.table-sort-liner a').on('click', function(e) {
    	e.preventDefault();
    	Liferay.Data.redirectURL = e.currentTarget.get('href');
    	pageIO.set('uri', e.currentTarget.get('href'));
    	pageIO.start();
    });
     var table = recordSearchContainer.one('table');
    if(table){
    	var tbody = table.one('tbody');
    	var trNodeRow = A.Node.create('<tr/>');
    	var tdNodeRow = A.Node.create('<td class="table-cell"/>');
    	
    	
    	var tableRow =  A.Node.create('<table style="width: 100%;"></table>');
    	var bodyRow =  A.Node.create('<tbody class="table-data"></tbody>');
    	var trNode = A.Node.create('<tr/>');
    	var td2Node = A.Node.create('<td class="table-cell"/>');
    	td2Node.append(A.Node.create('<span style="color:#28a745;font-weight: bold;">TỔNG TIỀN VAY</span><br/>'));
    	td2Node.append(A.Node.create('<span style="color:#28a745;font-weight: bold;"><%=tongTienVayAll > 0 ? df.format(tongTienVayAll) : "0" %></span>'));
    	
    	var td3Node = A.Node.create('<td class="table-cell"/>');
    	td3Node.append(A.Node.create('<span style="color:#28a745;font-weight: bold;">TỔNG GỐC NGÀY</span><br/>'));
    	td3Node.append(A.Node.create('<span style="color:#28a745;font-weight: bold;"><%=tongGocNgayAll > 0 ? df.format(tongGocNgayAll) : "0" %></span>'));
    	
    	var td4Node = A.Node.create('<td class="table-cell"/>');
    	td4Node.append(A.Node.create('<span style="color:#28a745;font-weight: bold;">TỔNG LÃI NGÀY</span><br/>'));
    	td4Node.append(A.Node.create('<span style="color:#28a745;font-weight: bold;"><%=tongLaiNgayAll > 0 ? df.format(tongLaiNgayAll) : "0" %></span>'));
    	
    	var td5Node = A.Node.create('<td class="table-cell"/>');
    	td5Node.append(A.Node.create('<span style="color:#28a745;font-weight: bold;">TỔNG GỐC ĐÃ THU</span><br/>'));
    	td5Node.append(A.Node.create('<span style="color:#28a745;font-weight: bold;"><%=tongGocDaThuAll > 0 ? df.format(tongGocDaThuAll) : "0" %></span>'));
    	
    	var td6Node = A.Node.create('<td class="table-cell"/>');
    	td6Node.append(A.Node.create('<span style="color:#28a745;font-weight: bold;">TỔNG LÃI ĐÃ THU</span><br/>'));
    	td6Node.append(A.Node.create('<span style="color:#28a745;font-weight: bold;"> <%=tongLaiDaThuAll > 0 ? df.format(tongLaiDaThuAll) : "0" %></span>'));
    	
    	var td7Node = A.Node.create('<td class="table-cell last"/>');
    	td7Node.append(A.Node.create('<span style="color:#28a745;font-weight: bold;">TỔNG DƯ NỢ GỐC</span><br/>'));
    	td7Node.append(A.Node.create('<span style="color:#28a745;font-weight: bold;"><%=tongDuNoGocAll > 0 ? df.format(tongDuNoGocAll) : "0" %></span>'));
    	
    	trNode.append(td2Node);
    	trNode.append(td3Node);
    	trNode.append(td4Node);
    	trNode.append(td5Node);
    	trNode.append(td6Node);
    	trNode.append(td7Node);
    	bodyRow.append(trNode);
    	tableRow.append(bodyRow);
    	tdNodeRow.append(tableRow);
    	trNodeRow.append(tdNodeRow);
    	tbody.prepend(trNodeRow);
    }
});	
</aui:script>