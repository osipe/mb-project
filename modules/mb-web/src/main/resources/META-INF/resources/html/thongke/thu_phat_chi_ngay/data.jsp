<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="com.mb.service.LichSuThuPhatChiLocalServiceUtil"%>
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
	List<CongTacVien> items  = CongTacVienLocalServiceUtil.getCTVThuPhatChi(maCTVSearch, ngayBatDauTu, ngayBatDauTu);
	Locale localeEn = new Locale("en", "EN");
    NumberFormat df = NumberFormat.getInstance(localeEn);
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
<portlet:renderURL var="xemChiTietHangNgayURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/html/thongke/thu_phat_chi_ngay/chi_tiet_thu_hang_ngay.jsp" />
	<portlet:param name="ngayBatDauTu"  value="<%= String.valueOf(ngayBatDauTuSearchTime)%>" />
</portlet:renderURL>
<portlet:resourceURL var="printPhieuThuTienHangNgay" id="printPhieuThuTienHangNgay">
</portlet:resourceURL>
<div id="<portlet:namespace />recordSearchContainer">
	<div style="text-align: right;"><span class="note-span">(Đơn vị : VND)</span></div>
	<liferay-ui:search-container  delta="<%=items.size() %>"  emptyResultsMessage="Không có kết quả nào được tìm thấy!" iteratorURL="<%=iteratorURL %>" total="<%=items.size() %>" >
		 <liferay-ui:search-container-results results="<%= items %>" />
		 <liferay-ui:search-container-row className="com.mb.model.CongTacVien" modelVar="congTacVien" keyProperty="congTacVienId" indexVar="index"> 
			 <%
			 	Double tienVonCTV = GetterUtil.getDouble("0");
			 	Double tienLaiCTV = GetterUtil.getDouble("0");
			 	Double tongPhatVayCTV = GetterUtil.getDouble("0");
			 	List<Object[]> lichSuThuPhatChDTOs = LichSuThuPhatChiLocalServiceUtil.getLichSuThuPhatChi_MaCTV_Createdate(congTacVien.getMa(), ngayBatDauTu);
	 		%>
			  <liferay-ui:search-container-column-text cssClass="aui-w10" name="STT">
			 	<span style="color:#ff3d00e8;font-weight: bold;"><%=index + 1%></span>
			 	<%
			 		for(Object[] item : lichSuThuPhatChDTOs){
			 			tienVonCTV += GetterUtil.getDouble(item[2]);
			 			tienLaiCTV += GetterUtil.getDouble(item[3]);
			 			if(GetterUtil.getInteger(item[0]) == 1){
			 				tongPhatVayCTV +=  GetterUtil.getDouble(item[4]);
			 			}
			 			
			 			tongVon += GetterUtil.getDouble(item[2]);
			 			tongLai += GetterUtil.getDouble(item[3]);
			 			if(GetterUtil.getInteger(item[0]) == 1){
			 				tongPhatVay +=  GetterUtil.getDouble(item[4]);
			 			}
			 	%>
			 		<br/>
			 		<%
			 			if(GetterUtil.getInteger(item[0]) == 3 && ngayBatDauTuSearchTime != 0){
			 				String ngayXuLyStr = GetterUtil.getString(item[1]);
			 				Date ngayXuLy = sdf.parse(ngayXuLyStr);
			 				long ngayXuLyTime = ngayXuLy != null ? ngayXuLy.getTime() : 0;
			 				String clickIn = "printPhieuThuTienHangNgay('" +congTacVien.getMa() + "','"+ ngayXuLyTime +"');" ;
			 				String clickView = "xemChiTietThuTienHangNgay('" +congTacVien.getMa() + "','"+ ngayXuLyTime +"');" ;
			 		%>
				 		<a href="javascript:void(0);" onclick="<%=clickIn %>" title="In phiếu thu"><i class="glyphicon glyphicon-print"></i></a>
				 		<a href="javascript:void(0);" onclick="<%=clickView %>" title="Xem chi tiết"><i class="glyphicon glyphicon-search"></i></a>
					<%}else{%>
						<span style="font-style: italic;"></span>
			 	<%
					}}
			 	%>
			 </liferay-ui:search-container-column-text>
			 <liferay-ui:search-container-column-text name="Tên">
			 	<span style="color:#ff3d00e8;font-weight: bold;"><%=congTacVien.getHoTen()%></span>
			 	<%
			 		String tenLoai = "";
			 		for(Object[] item : lichSuThuPhatChDTOs){
			 			if(GetterUtil.getInteger(item[0]) == 1){
			 				tenLoai = "Phát vay";
			 			} else if(GetterUtil.getInteger(item[0]) == 2){
			 				tenLoai = "Tất toán";
			 			} else if(GetterUtil.getInteger(item[0]) == 3){
			 				tenLoai = "Thu hằng ngày";
			 			} else if(GetterUtil.getInteger(item[0]) == 4){
			 				tenLoai = "Thu tết";
			 			}
			 	%>
			 		<br/>
			 		<span style="font-style: italic;"><%=tenLoai%></span>
			 	<%
			 		}
			 	%>
			 </liferay-ui:search-container-column-text>
			 <liferay-ui:search-container-column-text name="Ngày">
			 	<span style="color:#ff3d00e8;font-weight: bold;">#####</span>
			 	<%
			 		for(Object[] item : lichSuThuPhatChDTOs){
			 	%>
			 		<br/>
			 		<span style="font-style: italic;"><%=GetterUtil.getString(item[1],"#####") %></span>
			 	<%
			 		}
			 	%>
			 </liferay-ui:search-container-column-text>
			  <liferay-ui:search-container-column-text name="Thu vốn">
			 	<span style="color:#ff3d00e8;font-weight: bold;"><%=tienVonCTV > 0 ? df.format(tienVonCTV) : 0 %></span>
			 	<%
			 	for(Object[] item : lichSuThuPhatChDTOs){
			 	%>
			 		<br/>
			 		<span style="font-style: italic;"><%=df.format(GetterUtil.getDouble(item[2]))%></span>
			 	<%
			 		}
			 	%>
			 </liferay-ui:search-container-column-text>
			  <liferay-ui:search-container-column-text name="Thu lãi">
			 	<span style="color:#ff3d00e8;font-weight: bold;"><%=tienLaiCTV > 0 ? df.format(tienLaiCTV) : 0 %> </span>
			 	<%
				for(Object[] item : lichSuThuPhatChDTOs){
			 	%>
			 		<br/>
			 		<span style="font-style: italic;"><%=df.format(GetterUtil.getDouble(item[3])) %></span>
			 	<%
			 		}
			 	%>
			 </liferay-ui:search-container-column-text>
			 <liferay-ui:search-container-column-text name="Tổng thu">
			 	<span style="color:#ff3d00e8;font-weight: bold;"><%=df.format(tienLaiCTV + tienVonCTV) %> </span>
			 	<%
			 		for(Object[] item : lichSuThuPhatChDTOs){
			 			Double tongThu = GetterUtil.getDouble(item[2]) + GetterUtil.getDouble(item[3]);
			 	%>
			 		<br/>
			 		<span style="font-style: italic;"><%=(tongThu != null && tongThu > 0) ? df.format(tongThu) : '0'%></span>
			 	<%
			 		}
			 	%>
			 </liferay-ui:search-container-column-text>
			  <liferay-ui:search-container-column-text name="Chi phát vay">
			 	<span style="color:#ff3d00e8;font-weight: bold;"> <%=tongPhatVayCTV > 0 ? df.format(tongPhatVayCTV) : 0 %> </span>
			 	<%
			 	for(Object[] item : lichSuThuPhatChDTOs){
			 	%>
			 		<br/>
			 		<span style="font-style: italic;"><%=GetterUtil.getInteger(item[0]) == 1 ? df.format(GetterUtil.getDouble(item[4])) : "0" %></span>
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
    Liferay.provide(window,'xemChiTietThuTienHangNgay', function(maCTV,ngayXuLyTime){
    	var url = '${xemChiTietHangNgayURL}';
    	url += '&<portlet:namespace/>maCTV=' + maCTV;
    	url += '&<portlet:namespace/>ngayXuLyTime=' + ngayXuLyTime;
		Liferay.Util.openWindow({
			dialog : {
				centered : true,
				height : 1000,
				modal : true,
				width : 1200
			},
			id : '<portlet:namespace />dialogChiTiet',
			title : 'Lịch sử thu hằng ngày ' + '<%= sdf.format(ngayBatDauTu) %>',
			uri : url
		});
	});
    Liferay.provide(window,'printPhieuThuTienHangNgay', function(maCTV,ngayXuLyTime){
		var url = '${printPhieuThuTienHangNgay}';
		url += '&<portlet:namespace/>ngayThuTien=' + '<%=ngayBatDauTuSearchTime %>';
		url += '&<portlet:namespace/>maCTV=' + maCTV;
		url += '&<portlet:namespace/>ngayXuLyTime=' + ngayXuLyTime;
		 window.open(url);
	});
});	
</aui:script>