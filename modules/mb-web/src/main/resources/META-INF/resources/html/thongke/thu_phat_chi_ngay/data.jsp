<%@page import="quanly.dto.LichSuThuPhatChDTO"%>
<%@page import="quanly.portlet.thongke.thu_phat_chi_ngay.LichSuThuPhatChiComparator"%>
<%@page import="com.mb.service.LichSuThuPhatChiLocalServiceUtil"%>
<%@page import="com.mb.model.LichSuThuPhatChi"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
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
<%
	String maCTVSearch = ParamUtil.getString(request, "maCTVSearch");
	long ngayBatDauTuSearchTime = ParamUtil.getLong(request, "ngayBatDauTuSearch");
	int thanhToanSearch = ParamUtil.getInteger(request, "thanhToanSearch");
	Date ngayBatDauTu = ngayBatDauTuSearchTime != 0 ? new Date(ngayBatDauTuSearchTime) : null;
	int count = CongTacVienLocalServiceUtil.countBase(maCTVSearch, "", "", "", 1);
	DecimalFormat df = new DecimalFormat("###,###.###");
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Double tongVon = GetterUtil.getDouble("0");
	Double tongLai = GetterUtil.getDouble("0");
	Double tongPhatVay = GetterUtil.getDouble("0");
%>
<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="maCTVSearch" value="<%= String.valueOf(maCTVSearch)%>" />
	<portlet:param name="ngayBatDauTuSearch" value="<%= String.valueOf(ngayBatDauTuSearchTime)%>" />
	<portlet:param name="mvcPath" value="/html/thongke/thu_phat_chi_ngay/data.jsp" />
</liferay-portlet:renderURL>
<div id="<portlet:namespace />recordSearchContainer">
	<div style="text-align: right;"><span class="note-span">(Đơn vị : VND)</span></div>
	<liferay-ui:search-container  delta="<%=count %>"  emptyResultsMessage="Không có kết quả nào được tìm thấy!" iteratorURL="<%=iteratorURL %>" total="<%=count %>" >
		 <%
		 	String orderByType = ParamUtil.getString(request, "orderByType"); 
		 	String orderByCol = ParamUtil.getString(request, "orderByCol"); 
		 	if(Validator.isNull(orderByType)){
		 		orderByType = "asc";
		 	}
		 	if(Validator.isNull(orderByCol)){
		 		orderByCol = "hoten";
		 	}
		 	boolean ascending = false;
		 	if("asc".equals(orderByType)){
		 		ascending = true;
		 	}
		 	CongTacVienComparator obc = new CongTacVienComparator(orderByCol,ascending);
		 	searchContainer.setOrderByCol(orderByCol);
		 	searchContainer.setOrderByType(orderByType);
		 	searchContainer.setOrderByComparator(obc);
			List<CongTacVien> items = CongTacVienLocalServiceUtil.findBase(maCTVSearch, "", "", "", 1, searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
		 %>
		 <liferay-ui:search-container-results results="<%= items %>" />
		 <liferay-ui:search-container-row className="com.mb.model.CongTacVien" modelVar="congTacVien" keyProperty="congTacVienId" indexVar="index"> 
			 <%
				LichSuThuPhatChiComparator comparator = new LichSuThuPhatChiComparator("createdate",true);
			 	Double tienVonCTV = GetterUtil.getDouble("0");
			 	Double tienLaiCTV = GetterUtil.getDouble("0");
			 	Double tongTienCTV = GetterUtil.getDouble("0");
		 		List<LichSuThuPhatChi> lichSuThuPhatChis = LichSuThuPhatChiLocalServiceUtil.findByCTV_Loai_Createdate(congTacVien.getMa(), 0, ngayBatDauTu, ngayBatDauTu, -1, -1, comparator);
		 		List<LichSuThuPhatChDTO> lichSuThuPhatChDTOs = new ArrayList<LichSuThuPhatChDTO>();
			 	Double tongTienPV = GetterUtil.getDouble("0");
			 	
			 	Double tienVonTT = GetterUtil.getDouble("0");
			 	Double tienLaiTT = GetterUtil.getDouble("0");
			 	Double tongTienTT = GetterUtil.getDouble("0");
			 	
			 	Double tienVonTHN = GetterUtil.getDouble("0");
			 	Double tienLaiTHN = GetterUtil.getDouble("0");
			 	Double tongTienTHN = GetterUtil.getDouble("0");
			 	
			 	Double tienVonThuTruoc = GetterUtil.getDouble("0");
			 	Double tienLaiThuTruoc = GetterUtil.getDouble("0");
			 	Double tongTienThuTruoc = GetterUtil.getDouble("0");
			 	
		 		for(LichSuThuPhatChi item : lichSuThuPhatChis){
		 			tienVonCTV += item.getTongSoTienVonTra();
		 			tienLaiCTV += item.getTongSoTienLaiTra();
		 			if(item.getLoai() == 1){
		 				tongTienPV += item.getSoTien();
		 			}else if(item.getLoai() == 2){
		 				tienVonTT += item.getTongSoTienVonTra();
		 				tienLaiTT += item.getTongSoTienLaiTra();
		 				tongTienTT += item.getSoTien();
		 			}else if(item.getLoai() == 3){
		 				tienVonTHN += item.getTongSoTienVonTra();
		 				tienLaiTHN += item.getTongSoTienLaiTra();
		 				tongTienTHN += item.getSoTien();
		 			}else if(item.getLoai() == 4){
		 				tienVonThuTruoc += item.getTongSoTienVonTra();
		 				tienLaiThuTruoc += item.getTongSoTienLaiTra();
		 				tongTienThuTruoc += item.getSoTien();
		 			}
		 		}
		 		if(tongTienPV > 0){
		 			LichSuThuPhatChDTO phatVay = new LichSuThuPhatChDTO("","Phát vay", ngayBatDauTu != null ? sdf.format(ngayBatDauTu) : "", tongTienPV > 0 ? df.format(tongTienPV) : "0", "0", "0","0");
			 		lichSuThuPhatChDTOs.add(phatVay);
		 		}
		 		if(tongTienTT > 0){
			 		LichSuThuPhatChDTO tatToan = new LichSuThuPhatChDTO("","Tất toán", ngayBatDauTu != null ? sdf.format(ngayBatDauTu) : "", "0",tienVonTT > 0 ? df.format(tienVonTT) : "0",tienLaiTT > 0 ? df.format(tienLaiTT) : "0",df.format(tienVonTT+ tienLaiTT) );
			 		lichSuThuPhatChDTOs.add(tatToan);
		 		}
		 		if(tongTienTHN > 0){
			 		LichSuThuPhatChDTO thuHangNgay = new LichSuThuPhatChDTO("","Thu hằng ngày", ngayBatDauTu != null ? sdf.format(ngayBatDauTu) : "", "0",tienVonTHN > 0 ? df.format(tienVonTHN) : "0",tienLaiTHN > 0 ? df.format(tienLaiTHN) : "0",df.format(tienVonTHN+ tienLaiTHN));
			 		lichSuThuPhatChDTOs.add(thuHangNgay);
		 		}
		 		if(tongTienThuTruoc > 0){
			 		LichSuThuPhatChDTO thuTruoc = new LichSuThuPhatChDTO("","Thu tiền tết", ngayBatDauTu != null ? sdf.format(ngayBatDauTu) : "",  "0",tienVonThuTruoc > 0 ? df.format(tienVonThuTruoc) : "0",tienLaiThuTruoc > 0 ? df.format(tienLaiThuTruoc) : "0",df.format(tienVonThuTruoc+ tienLaiThuTruoc));
			 		lichSuThuPhatChDTOs.add(thuTruoc);
		 		}
		 		tongVon += tienVonCTV;
		 		tongLai += tienLaiCTV;
		 		tongPhatVay += tongTienPV;
	 		%>
			  <liferay-ui:search-container-column-text cssClass="aui-w10" name="STT">
			 	<span style="color:#ff3d00e8;font-weight: bold;"><%=index + 1%></span>
			 	<%
			 		for(LichSuThuPhatChi item : lichSuThuPhatChis){
			 	%>
			 		<br/>
			 		<span style="font-style: italic;"> </span>
			 	<%
			 		}
			 	%>
			 </liferay-ui:search-container-column-text>
			 <liferay-ui:search-container-column-text name="Tên">
			 	<span style="color:#ff3d00e8;font-weight: bold;"><%=congTacVien.getHoTen()%></span>
			 	<%
			 		for(LichSuThuPhatChDTO item : lichSuThuPhatChDTOs){
			 	%>
			 		<br/>
			 		<span style="font-style: italic;"><%=item.getTen()%></span>
			 	<%
			 		}
			 	%>
			 </liferay-ui:search-container-column-text>
			 <liferay-ui:search-container-column-text name="Ngày">
			 	<span style="color:#ff3d00e8;font-weight: bold;"> </span>
			 	<%
			 		for(LichSuThuPhatChDTO item : lichSuThuPhatChDTOs){
			 	%>
			 		<br/>
			 		<span style="font-style: italic;"><%=item.getNgay()%></span>
			 	<%
			 		}
			 	%>
			 </liferay-ui:search-container-column-text>
			  <liferay-ui:search-container-column-text name="Thu vốn">
			 	<span style="color:#ff3d00e8;font-weight: bold;"><%=tienVonCTV > 0 ? df.format(tienVonCTV) : 0 %></span>
			 	<%
			 		for(LichSuThuPhatChDTO item : lichSuThuPhatChDTOs){
			 	%>
			 		<br/>
			 		<span style="font-style: italic;"><%=item.getTienVon()%></span>
			 	<%
			 		}
			 	%>
			 </liferay-ui:search-container-column-text>
			  <liferay-ui:search-container-column-text name="Thu lãi">
			 	<span style="color:#ff3d00e8;font-weight: bold;"><%=tienLaiCTV > 0 ? df.format(tienLaiCTV) : 0 %> </span>
			 	<%
			 		for(LichSuThuPhatChDTO item : lichSuThuPhatChDTOs){
			 	%>
			 		<br/>
			 		<span style="font-style: italic;"><%=item.getTienLai() %></span>
			 	<%
			 		}
			 	%>
			 </liferay-ui:search-container-column-text>
			 <liferay-ui:search-container-column-text name="Tổng thu">
			 	<span style="color:#ff3d00e8;font-weight: bold;"><%=df.format(tienLaiCTV + tienVonCTV) %> </span>
			 	<%
			 		for(LichSuThuPhatChDTO item : lichSuThuPhatChDTOs){
			 	%>
			 		<br/>
			 		<span style="font-style: italic;"><%=item.getTongThu()%></span>
			 	<%
			 		}
			 	%>
			 </liferay-ui:search-container-column-text>
			  <liferay-ui:search-container-column-text name="Chi phát vay">
			 	<span style="color:#ff3d00e8;font-weight: bold;"> <%=tongTienPV > 0 ? df.format(tongTienPV) : 0 %> </span>
			 	<%
			 		for(LichSuThuPhatChDTO item : lichSuThuPhatChDTOs){
			 	%>
			 		<br/>
			 		<span style="font-style: italic;"><%=item.getTienChi() %></span>
			 	<%
			 		}
			 	%>
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
		console.log('123');
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
    	var trNode = A.Node.create('<tr/>');
    	var td1Node = A.Node.create('<td style="text-align: center;" class="table-cell first " colspan="3"/>');
    	td1Node.append(A.Node.create('<span style="color:#ff3d00e8;font-weight: bold;">TỔNG</span>'));
    	
    	var td2Node = A.Node.create('<td class="table-cell text-right"/>');
    	td2Node.append(A.Node.create('<span style="color:#ff3d00e8;font-weight: bold;"><%=tongVon > 0 ? df.format(tongVon) : "0" %></span>'));
    	
    	var td3Node = A.Node.create('<td class="table-cell text-right"/>');
    	td3Node.append(A.Node.create('<span style="color:#ff3d00e8;font-weight: bold;"><%=tongLai > 0 ? df.format(tongLai) : "0" %></span>'));
    	
    	var td4Node = A.Node.create('<td class="table-cell text-right"/>');
    	td4Node.append(A.Node.create('<span style="color:#ff3d00e8;font-weight: bold;"><%= df.format(tongVon + tongLai)%></span>'));
    	
    	var td5Node = A.Node.create('<td class="table-cell text-right"/>');
    	td5Node.append(A.Node.create('<span style="color:#ff3d00e8;font-weight: bold;"><%=tongPhatVay > 0 ? df.format(tongPhatVay) : "0" %></span>'));
    	
    	
    	trNode.append(td1Node);
    	trNode.append(td2Node);
    	trNode.append(td3Node);
    	trNode.append(td4Node);
    	trNode.append(td5Node);
    	tbody.append(trNode);
    }
});	
</aui:script>