<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="org.apache.commons.collections.CollectionUtils"%>
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
.text-right {
	text-align: right;
}

.td-overflow {
	overflow-x: scroll;
	width: max-content;
}
</style>
<%
	long chiNhanhIdSearch = ParamUtil.getLong(request, "chiNhanhIdSearch");
	String maCTVSearch = ParamUtil.getString(request, "maCTVSearch");
	long ngayBatDauTuSearchTime = ParamUtil.getLong(request, "ngayBatDauTuSearchTime");
	Date ngay = ngayBatDauTuSearchTime > 0 ? new Date(ngayBatDauTuSearchTime) : null;
	int count = CongTacVienLocalServiceUtil.countCTVSaoKe(chiNhanhIdSearch,maCTVSearch, ngay);
	Locale localeEn = new Locale("en", "EN");
    NumberFormat df = NumberFormat.getInstance(localeEn);
    
	Double tongDuNoToiDaAll = GetterUtil.getDouble("0");
	
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	Object[] sumDaTra = LichSuThuPhatChiLocalServiceUtil.getTongLichSuTraTien_CTV_TAINGAY(chiNhanhIdSearch,maCTVSearch, ngay ,null,0);
	Object[] sumPhatVay = LichSuThuPhatChiLocalServiceUtil.getSumPhatVay_CTV_TAINGAY(chiNhanhIdSearch, maCTVSearch, ngay,0);
	
	
	Double tongTienVayAll =sumPhatVay != null && sumPhatVay[0] != null ? GetterUtil.getDouble(sumPhatVay[0],0.0)  : 0.0;
	Double tongGocNgayAll = sumPhatVay != null && sumPhatVay[1] != null ? GetterUtil.getDouble(sumPhatVay[1],0.0) : 0.0 ;
	Double tongLaiNgayAll = sumPhatVay != null && sumPhatVay[2] != null ? GetterUtil.getDouble(sumPhatVay[2],0.0)  : 0.0;
	
	Double tongGocDaThuAll = sumDaTra != null && sumDaTra[2] != null ? GetterUtil.getDouble(sumDaTra[2],0.0)  : 0.0 ;
	Double tongLaiDaThuAll = sumDaTra != null && sumDaTra[1] != null ? GetterUtil.getDouble(sumDaTra[1],0.0)  : 0.0;
	Double tongDuNoGocAll = tongTienVayAll - tongGocDaThuAll;
	
	
	
%>
<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/html/thongke/sao_ke_kh/data.jsp" />
	<portlet:param name="chiNhanhIdSearch"
		value="<%=String.valueOf(chiNhanhIdSearch)%>" />
	<portlet:param name="maCTVSearch" value="<%=maCTVSearch%>" />
	<portlet:param name="ngayBatDauTuSearchTime"
		value="<%=String.valueOf(ngayBatDauTuSearchTime)%>" />
</liferay-portlet:renderURL>
<!-- style="width: max-content;min-width: 100%;" -->
<div id="<portlet:namespace />recordSearchContainer">
	<div style="text-align: right;">
		<span class="note-span">(Đơn vị : VND)</span>
	</div>
	<liferay-ui:search-container delta="1"
		emptyResultsMessage="Không có kết quả nào được tìm thấy!"
		iteratorURL="<%=iteratorURL %>" total="<%=count %>">
		<%
		 	String orderByType = ParamUtil.getString(request, "orderByType"); 
		 	String orderByCol = ParamUtil.getString(request, "orderByCol"); 
		 	if(Validator.isNull(orderByType)){
		 		orderByType = "asc";
		 	}
		 	if(Validator.isNull(orderByCol)){
		 		orderByCol = "ma";
		 	}
		 	boolean ascending = true;
		 	if("desc".equals(orderByType)){
		 		ascending = false;
		 	}
		 	CongTacVienComparator obc = new CongTacVienComparator(orderByCol,ascending);
		 	searchContainer.setOrderByCol(orderByCol);
		 	searchContainer.setOrderByType(orderByType);
		 	searchContainer.setOrderByComparator(obc);
		 	List<CongTacVien> items = CongTacVienLocalServiceUtil.getCTVSaoKePhanTrang(chiNhanhIdSearch, maCTVSearch,ngay,searchContainer.getStart(), searchContainer.getEnd());
			%>
		<liferay-ui:search-container-results results="<%= items %>" />
		<liferay-ui:search-container-row className="com.mb.model.CongTacVien"
			modelVar="congTacVien" keyProperty="congTacVienId" indexVar="index">
			<%
			 	Double tongTienVay = GetterUtil.getDouble("0");
				Double tongGocNgay = GetterUtil.getDouble("0");
				Double tongLaiNgay = GetterUtil.getDouble("0");
				Double tongGocDaThu = GetterUtil.getDouble("0");
				Double tongLaiDaThu = GetterUtil.getDouble("0");
				Double tongDuNoGoc = GetterUtil.getDouble("0");
				tongDuNoToiDaAll += congTacVien.getDuNoToiDa();
				PhatVayComparator obcPhatVay = new PhatVayComparator("createdate",true);
		 		Double duNoToiDaTinChap = GetterUtil.getDouble("0");
		 		if(congTacVien.getDuNoToiDa() > congTacVien.getDuNoToiDaTheChap()){
		 			duNoToiDaTinChap = congTacVien.getDuNoToiDa() - congTacVien.getDuNoToiDaTheChap();
		 		}
			 
			 %>
			<liferay-ui:search-container-column-text>
				<table style="width: 100%;" class="table table-borderless">
					<tr>
						<td class="aui-w20" rowspan="2"><span
							style="color: blue; font-weight: bold;">TÊN CTV : <%= congTacVien.getHoTen() %></span>
						</td>
						<td class="aui-w15" rowspan="2"><span
							style="color: blue; font-weight: bold;">MÃ SỐ : <%= congTacVien.getMa() %></span>
						</td>
						<td class="aui-w20" rowspan="2"><span
							style="color: blue; font-weight: bold;">TỔNG ĐỊNH MỨC DƯ
								NỢ : <%=congTacVien.getDuNoToiDa() > 0 ? df.format(congTacVien.getDuNoToiDa()) : "0" %></span>
						</td>
						<td class="aui-w20"><span
							style="color: blue; font-weight: bold;">ĐỊNH MỨC TÍN CHẤP
								: <%=duNoToiDaTinChap > 0 ? df.format(duNoToiDaTinChap) : "0" %></span>
						</td>
					</tr>
					<tr>
						<td class="aui-w20"><span
							style="color: blue; font-weight: bold;">ĐỊNH MỨC THẾ CHẤP
								: <%=congTacVien.getDuNoToiDaTheChap() > 0 ? df.format(congTacVien.getDuNoToiDaTheChap()) : "0" %></span>
						</td>
					</tr>
				</table>
				<table style="width: 100%;">
					<th>SỐ KU</th>
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
			 			List<PhatVay> phatVayTinChaps = PhatVayLocalServiceUtil.getPhatVaySaoKe(chiNhanhIdSearch, congTacVien.getMa(),2, ngay);
			 			Double tongTienVayTinChap = GetterUtil.getDouble("0");
			 			Double tongTienGocNgayTinChap = GetterUtil.getDouble("0");
			 			Double tongTienLaiNgayTinChap = GetterUtil.getDouble("0");
			 			Double tongGocDaThuTinChap = GetterUtil.getDouble("0");
			 			Double tongLaiDaThuTinChap = GetterUtil.getDouble("0");
			 			Double tongDuNoGocTinChap = GetterUtil.getDouble("0");
			 			if(CollectionUtils.isNotEmpty(phatVayTinChaps)){
			 				for(PhatVay item : phatVayTinChaps){
			 					List<LichSuThuPhatChi> lichSuThuPhatChis = LichSuThuPhatChiLocalServiceUtil.findByPhatVay_Createdate_Loai(chiNhanhIdSearch,item.getPhatVayId(), null, ngay, "3,4");
			 					tongTienVayTinChap += item.getSoTienVay();
			 					tongTienGocNgayTinChap += item.getGocNgay();
			 					tongTienLaiNgayTinChap += item.getLaiNgay();
			 					for(LichSuThuPhatChi lichSuThuPhatChi : lichSuThuPhatChis){
			 						tongGocDaThuTinChap += lichSuThuPhatChi.getTongSoTienVonTra();
			 						tongLaiDaThuTinChap += lichSuThuPhatChi.getTongSoTienLaiTra();
					 			}
			 				}
			 				tongDuNoGocTinChap = tongTienVayTinChap - tongGocDaThuTinChap;
			 				
			 		%>
					<tr>
						<td
							style="text-align: center; font-weight: bold; text-decoration: underline;"
							colspan="6">TÍN CHẤP</td>
						<td
							style="text-align: center; font-weight: bold; text-decoration: underline;"><%=tongTienVayTinChap > 0 ? df.format(tongTienVayTinChap) : "0" %></td>
						<td
							style="text-align: center; font-weight: bold; text-decoration: underline;"><%=tongTienGocNgayTinChap > 0 ? df.format(tongTienGocNgayTinChap) : "0" %></td>
						<td
							style="text-align: center; font-weight: bold; text-decoration: underline;"><%=tongTienLaiNgayTinChap > 0 ? df.format(tongTienLaiNgayTinChap) : "0" %><ins></td>
						<td
							style="text-align: center; font-weight: bold; text-decoration: underline;"><%=tongGocDaThuTinChap > 0 ? df.format(tongGocDaThuTinChap) : "0" %></td>
						<td
							style="text-align: center; font-weight: bold; text-decoration: underline;"><%=tongLaiDaThuTinChap > 0 ? df.format(tongLaiDaThuTinChap) : "0" %></td>
						<td
							style="text-align: center; font-weight: bold; text-decoration: underline;"><%=tongDuNoGocTinChap > 0 ? df.format(tongDuNoGocTinChap) : "0" %></td>
					</tr>
					<%
				 			for(PhatVay item : phatVayTinChaps){
				 				Double gocDaThu = GetterUtil.getDouble("0");
					 			Double laiDaThu = GetterUtil.getDouble("0");
					 			Double duGoc =  item.getSoTienVay();
			 					List<LichSuThuPhatChi> lichSuThuPhatChis = LichSuThuPhatChiLocalServiceUtil.findByPhatVay_Createdate_Loai(chiNhanhIdSearch, item.getPhatVayId(), null, ngay, "3,4");
			 					for(LichSuThuPhatChi lichSuThuPhatChi : lichSuThuPhatChis){
			 						gocDaThu += lichSuThuPhatChi.getTongSoTienVonTra();
					 				laiDaThu += lichSuThuPhatChi.getTongSoTienLaiTra();
					 				duGoc -= lichSuThuPhatChi.getTongSoTienVonTra();
					 			}
			 					Double soLanDaThu =  gocDaThu/item.getGocNgay();
			 			%>
					<tr>
						<td><%=item.getSoKU() %></td>
						<td><%=item.getKhachHang() != null ? item.getKhachHang().getHoTen()  : "" %></td>
						<td><span data-toggle="tooltip"
							title="<%=item.getKhachHang() != null ? item.getKhachHang().getDiaChi() : ""%>"><%=(item.getKhachHang() != null && Validator.isNotNull(item.getKhachHang().getDiaChi()) && item.getKhachHang().getDiaChi().length() > 40) ? item.getKhachHang().getDiaChi().substring(0, 40) + "..." : item.getKhachHang().getDiaChi() %></span>
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
					<%} %>

					<%
			 			} 
			 		%>
					<%
			 			List<PhatVay> phatVayThueChaps = PhatVayLocalServiceUtil.getPhatVaySaoKe(chiNhanhIdSearch, congTacVien.getMa(),1, ngay);
			 			Double tongTienVayThueChap = GetterUtil.getDouble("0");
			 			Double tongTienGocNgayThueChap = GetterUtil.getDouble("0");
			 			Double tongTienLaiNgayThueChap = GetterUtil.getDouble("0");
			 			Double tongGocDaThuThueChap = GetterUtil.getDouble("0");
			 			Double tongLaiDaThuThueChap = GetterUtil.getDouble("0");
			 			Double tongDuNoGocThueChap = GetterUtil.getDouble("0");
			 			if(CollectionUtils.isNotEmpty(phatVayThueChaps)){
			 				for(PhatVay item : phatVayThueChaps){
			 					List<LichSuThuPhatChi> lichSuThuPhatChis = LichSuThuPhatChiLocalServiceUtil.findByPhatVay_Createdate_Loai(chiNhanhIdSearch, item.getPhatVayId(), null, ngay, "3,4");
			 					tongTienVayThueChap += item.getSoTienVay();
			 					tongTienGocNgayThueChap += item.getGocNgay();
			 					tongTienLaiNgayThueChap += item.getLaiNgay();
			 					for(LichSuThuPhatChi lichSuThuPhatChi : lichSuThuPhatChis){
			 						tongGocDaThuThueChap += lichSuThuPhatChi.getTongSoTienVonTra();
			 						tongLaiDaThuThueChap += lichSuThuPhatChi.getTongSoTienLaiTra();
					 			}
			 				}
			 				tongDuNoGocThueChap = tongTienVayThueChap - tongGocDaThuThueChap;
			 				
			 		%>
					<tr>
						<td
							style="text-align: center; font-weight: bold; text-decoration: underline;"
							colspan="6">THẾ CHẤP</td>
						<td
							style="text-align: center; font-weight: bold; text-decoration: underline;"><%=tongTienVayThueChap > 0 ? df.format(tongTienVayThueChap) : "0" %></td>
						<td
							style="text-align: center; font-weight: bold; text-decoration: underline;"><%=tongTienGocNgayThueChap > 0 ? df.format(tongTienGocNgayThueChap) : "0" %></td>
						<td
							style="text-align: center; font-weight: bold; text-decoration: underline;"><%=tongTienLaiNgayThueChap > 0 ? df.format(tongTienLaiNgayThueChap) : "0" %><ins></td>
						<td
							style="text-align: center; font-weight: bold; text-decoration: underline;"><%=tongGocDaThuThueChap > 0 ? df.format(tongGocDaThuThueChap) : "0" %></td>
						<td
							style="text-align: center; font-weight: bold; text-decoration: underline;"><%=tongLaiDaThuThueChap > 0 ? df.format(tongLaiDaThuThueChap) : "0" %></td>
						<td
							style="text-align: center; font-weight: bold; text-decoration: underline;"><%=tongDuNoGocThueChap > 0 ? df.format(tongDuNoGocThueChap) : "0" %></td>
					</tr>
					<%
				 			for(PhatVay item : phatVayThueChaps){
				 				Double gocDaThu = GetterUtil.getDouble("0");
					 			Double laiDaThu = GetterUtil.getDouble("0");
					 			Double duGoc =  item.getSoTienVay();
			 					List<LichSuThuPhatChi> lichSuThuPhatChis = LichSuThuPhatChiLocalServiceUtil.findByPhatVay_Createdate_Loai(chiNhanhIdSearch, item.getPhatVayId(), null, ngay, "3,4");
			 					for(LichSuThuPhatChi lichSuThuPhatChi : lichSuThuPhatChis){
			 						gocDaThu += lichSuThuPhatChi.getTongSoTienVonTra();
					 				laiDaThu += lichSuThuPhatChi.getTongSoTienLaiTra();
					 				duGoc -= lichSuThuPhatChi.getTongSoTienVonTra();
					 			}
			 					Double soLanDaThu =  gocDaThu/item.getGocNgay();
			 			%>
					<tr>
						<td><%=item.getSoKU() %></td>
						<td><%=item.getKhachHang() != null ? item.getKhachHang().getHoTen()  : "" %></td>
						<td><span data-toggle="tooltip"
							title="<%=item.getKhachHang() != null ? item.getKhachHang().getDiaChi() : ""%>"><%=(item.getKhachHang() != null && Validator.isNotNull(item.getKhachHang().getDiaChi()) && item.getKhachHang().getDiaChi().length() > 40) ? item.getKhachHang().getDiaChi().substring(0, 40) + "..." : item.getKhachHang().getDiaChi() %></span>
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
					<%} %>

					<%
			 			} 
			 		%>

					<%
			 			tongTienVay = tongTienVayTinChap + tongTienVayThueChap;
			 			tongGocNgay = tongTienGocNgayTinChap + tongTienGocNgayThueChap;
			 			tongLaiNgay = tongTienLaiNgayTinChap + tongTienLaiNgayThueChap;
			 			tongGocDaThu = tongGocDaThuTinChap + tongGocDaThuThueChap;
			 			tongLaiDaThu = tongLaiDaThuTinChap + tongLaiDaThuThueChap;
			 			tongDuNoGoc = tongDuNoGocTinChap + tongDuNoGocThueChap;
			 			
			 		%>
					<tr>
						<td style="text-align: center; color: red; font-weight: bold;"
							colspan="6">TỔNG</td>
						<td style="color: red; font-weight: bold;"><%=tongTienVay > 0 ? df.format(tongTienVay) : "0"%></td>
						<td style="color: red; font-weight: bold;"><%=tongGocNgay > 0 ? df.format(tongGocNgay) : "0"%></td>
						<td style="color: red; font-weight: bold;"><%=tongLaiNgay > 0 ? df.format(tongLaiNgay) : "0"%></td>
						<td style="color: red; font-weight: bold;"><%=tongGocDaThu > 0 ? df.format(tongGocDaThu) : "0"%></td>
						<td style="color: red; font-weight: bold;"><%=tongLaiDaThu > 0 ? df.format(tongLaiDaThu) : "0"%></td>
						<td style="color: red; font-weight: bold;"><%=tongDuNoGoc > 0 ? df.format(tongDuNoGoc) : "0"%></td>
					</tr>
				</table>
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</div>

<aui:script
	use="aui-base,aui-io-plugin-deprecated,aui-loading-mask-deprecated">
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
    	var trNodeRow = A.Node.create('<tr />');
    	var tdNodeRow = A.Node.create('<td class="table-cell" />');
    	
    	
    	var tableRow =  A.Node.create('<table style="width: 100%;"></table>');
    	var bodyRow =  A.Node.create('<tbody class="table-data"></tbody>');
    	var trNode = A.Node.create('<tr />');
    	var td2Node = A.Node.create('<td class="table-cell" />');
    	td2Node.append(A.Node.create('<span style="color: #28a745; font-weight: bold;">TỔNG TIỀN VAY</span><br />'));
    	td2Node.append(A.Node.create('<span style="color: #28a745; font-weight: bold;"><%=tongTienVayAll > 0 ? df.format(tongTienVayAll) : "0" %></span>'));
    	
    	var td3Node = A.Node.create('<td class="table-cell" />');
    	td3Node.append(A.Node.create('<span style="color: #28a745; font-weight: bold;">TỔNG GỐC NGÀY</span><br />'));
    	td3Node.append(A.Node.create('<span style="color: #28a745; font-weight: bold;"><%=tongGocNgayAll > 0 ? df.format(tongGocNgayAll) : "0" %></span>'));
    	
    	var td4Node = A.Node.create('<td class="table-cell" />');
    	td4Node.append(A.Node.create('<span style="color: #28a745; font-weight: bold;">TỔNG LÃI NGÀY</span><br />'));
    	td4Node.append(A.Node.create('<span style="color: #28a745; font-weight: bold;"><%=tongLaiNgayAll > 0 ? df.format(tongLaiNgayAll) : "0" %></span>'));
    	
    	var td5Node = A.Node.create('<td class="table-cell" />');
    	td5Node.append(A.Node.create('<span style="color: #28a745; font-weight: bold;">TỔNG GỐC ĐÃ THU</span><br />'));
    	td5Node.append(A.Node.create('<span style="color: #28a745; font-weight: bold;"><%=tongGocDaThuAll > 0 ? df.format(tongGocDaThuAll) : "0" %></span>'));
    	
    	var td6Node = A.Node.create('<td class="table-cell" />');
    	td6Node.append(A.Node.create('<span style="color: #28a745; font-weight: bold;">TỔNG LÃI ĐÃ THU</span><br />'));
    	td6Node.append(A.Node.create('<span style="color: #28a745; font-weight: bold;"> <%=tongLaiDaThuAll > 0 ? df.format(tongLaiDaThuAll) : "0" %></span>'));
    	
    	var td7Node = A.Node.create('<td class="table-cell last" />');
    	td7Node.append(A.Node.create('<span style="color: #28a745; font-weight: bold;">TỔNG DƯ NỢ GỐC</span><br />'));
    	td7Node.append(A.Node.create('<span style="color: #28a745; font-weight: bold;"><%=tongDuNoGocAll > 0 ? df.format(tongDuNoGocAll) : "0" %></span>'));
    	
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