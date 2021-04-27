<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="quanly.constants.TrangThaiPhatVayEnum"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.mb.model.CongTacVien"%>
<%@page import="quanly.portlet.danhmuc.ctv.CongTacVienComparator"%>
<%@page import="com.mb.service.CongTacVienLocalServiceUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="quanly.portlet.phatvay.phatvay.PhatVayChecker"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="quanly.portlet.phatvay.phatvay.PhatVayComparator"%>
<%@page import="com.mb.model.PhatVay"%>
<%@page import="java.util.List"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.mb.service.PhatVayLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/phatvay/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%	
	long ngayThuTienTime = ParamUtil.getLong(request, "ngayThuTien");
	Date ngayThuTienSearch = ngayThuTienTime != 0 ? new Date(ngayThuTienTime) : null;
	String maCTVSearch = ParamUtil.getString(request, "maCTVSearch");
	int count = CongTacVienLocalServiceUtil.countBase(maCTVSearch, "", "", "", 1);
	Locale localeEn = new Locale("en", "EN");
    NumberFormat df = NumberFormat.getInstance(localeEn);
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	Double tongTienVayAll = GetterUtil.getDouble("0");
	Double tongGocNgayAll = GetterUtil.getDouble("0");
	Double tongLaiNgayAll = GetterUtil.getDouble("0");
%>
<c:set value="<%=df %>" var="df"/>
<c:set value="<%=sdf %>" var="sdf"/>
<aui:form name="fm">
	<liferay-portlet:renderURL varImpl="iteratorURL">
		<portlet:param name="ngayThuTien" value="<%= String.valueOf(ngayThuTienTime) %>" />
		<portlet:param name="maCTVSearch" value="<%= String.valueOf(maCTVSearch) %>" />
		<portlet:param name="mvcPath" value="/html/phatvay/thutienhangngay/data.jsp" />
	</liferay-portlet:renderURL>
	<div style="text-align: right;"><span class="note-span">(Đơn vị : VND)</span></div>
	<liferay-ui:search-container  delta="20"  emptyResultsMessage="Không có kết quả nào được tìm thấy!" iteratorURL="<%=iteratorURL %>" total="<%=count %>" >
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
		 
			List<CongTacVien> items = CongTacVienLocalServiceUtil.findBase( maCTVSearch, "", "", "", 1, searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
		 %>
		 <liferay-ui:search-container-results results="<%= items %>" />
		 <liferay-ui:search-container-row className="com.mb.model.CongTacVien" modelVar="congTacVien" keyProperty="congTacVienId" indexVar="index"> 
			 <%
			 	Double tongTienVay = GetterUtil.getDouble("0");
				Double tongGocNgay = GetterUtil.getDouble("0");
				Double tongLaiNgay = GetterUtil.getDouble("0");
				Double tongDuNoGoc = GetterUtil.getDouble("0");
				PhatVayComparator obcPhatVay = new PhatVayComparator("createdate",true);
		 		List<PhatVay> phatVays = PhatVayLocalServiceUtil.findCTV_NgayThuTien(congTacVien.getMa(),ngayThuTienSearch);
			 %>
			 <liferay-ui:search-container-column-text cssClass="aui-w3" name="STT">
			 	<span style="color:#ff3d00e8;font-weight: bold;"><%=index + 1 %></span>
			 	<%
			 		for(PhatVay item : phatVays){
			 			tongTienVay += item.getSoTienVay();
			 			tongGocNgay += item.getGocNgay();
			 			tongLaiNgay += item.getLaiNgay();
			 			tongDuNoGoc += item.getDuNoGoc();
			 	%>
			 		<br/>
			 		<span>&nbsp;</span>
			 	<%
			 		}
			 	tongTienVayAll += tongTienVay;
			 	tongGocNgayAll += tongGocNgay;
			 	tongLaiNgayAll += tongLaiNgay;
			 	%>
			 </liferay-ui:search-container-column-text>
			 <liferay-ui:search-container-column-text cssClass="aui-w7" name="SỐ KU">
			 	<span style="color:#ff3d00e8;font-weight: bold;">&nbsp;</span>
			 	<%
			 		for(PhatVay item : phatVays){
			 	%>
			 		<br/>
			 		<span><%=item.getSoKU() %></span>
			 	<%
			 		}
			 	%>
			 </liferay-ui:search-container-column-text>
			  <liferay-ui:search-container-column-text  name="TÊN">
			 	<span style="color:#ff3d00e8;font-weight: bold;"><%=congTacVien.getHoTen() %></span>
			 	<%
			 		for(PhatVay item : phatVays){
			 	%>
			 		<br/>
			 		<span><%=item.getKhachHang() != null ? item.getKhachHang().getHoTen() : "" %></span>
			 	<%
			 		}
			 	%>
			 </liferay-ui:search-container-column-text>
			 <liferay-ui:search-container-column-text cssClass="aui-w10 text-right" name="SỐ TIỀN VAY">
			 	<span style="color:#ff3d00e8;font-weight: bold;"><%=tongTienVay > 0 ? df.format(tongTienVay)  : "0"%></span>
			 	<%
			 		for(PhatVay item : phatVays){
			 	%>
			 		<br/>
			 		<span style="font-style: italic;"><%=item.getSoTienVay() > 0 ? df.format(item.getSoTienVay()) : "0"%></span>
			 	<%
			 		}
			 	%>
			 </liferay-ui:search-container-column-text>
			  <liferay-ui:search-container-column-text cssClass="aui-w10 text-right" name="THỜI HẠN">
			 	<span style="color:#ff3d00e8;font-weight: bold;">&nbsp;</span>
			 	<%
			 		for(PhatVay item : phatVays){
			 	%>
			 		<br/>
			 		<span style="font-style: italic;"><%=item.getThoiHan()%></span>
			 	<%
			 		}
			 	%>
			 </liferay-ui:search-container-column-text>
			 <liferay-ui:search-container-column-text cssClass="aui-w10 text-right" name="GỐC NGÀY">
			 	<span style="color:#ff3d00e8;font-weight: bold;"><%=tongGocNgay > 0 ? df.format(tongGocNgay)  : "0"%></span>
			 	<%
			 		for(PhatVay item : phatVays){
			 	%>
			 		<br/>
			 		<span style="font-style: italic;"><%=item.getGocNgay() > 0 ? df.format(item.getGocNgay()) : "0"%></span>
			 	<%
			 		}
			 	%>
			 </liferay-ui:search-container-column-text>
			  <liferay-ui:search-container-column-text cssClass="aui-w7 text-right" name="LÃI NGÀY">
			 		<span style="color:#ff3d00e8;font-weight: bold;"><%=tongLaiNgay > 0 ? df.format(tongLaiNgay)  : "0"%></span>
			 	<%
			 		for(PhatVay item : phatVays){
			 	%>
			 		<br/>
			 		<span style="font-style: italic;"><%=item.getLaiNgay()> 0 ? df.format(item.getLaiNgay()) : "0"%></span>
			 	<%
			 		}
			 	%>
			 </liferay-ui:search-container-column-text>
			 <liferay-ui:search-container-column-text cssClass="aui-w7 text-right" name="SỐ TIỀN PHẢI THU (1 Ngày)">
			 		<span style="color:#ff3d00e8;font-weight: bold;"><%=(tongGocNgay + tongLaiNgay) > 0 ? df.format(tongGocNgay + tongLaiNgay)  : "0"%></span>
			 	<%
			 		for(PhatVay item : phatVays){
			 	%>
			 		<br/>
			 		<span style="font-style: italic;"><%=(item.getLaiNgay() + item.getGocNgay())> 0 ? df.format(item.getLaiNgay() + item.getGocNgay()) : "0"%></span>
			 	<%
			 		}
			 	%>
			 </liferay-ui:search-container-column-text>
		 	 <liferay-ui:search-container-column-text cssClass="aui-w7" name="NGÀY ĐÃ THU CUỐI">
			 		<span style="color:#ff3d00e8;font-weight: bold;">&nbsp;</span>
			 	<%
			 		for(PhatVay item : phatVays){
			 	%>
			 		<br/>
			 		<span title="<%="Chưa thu ngày : " + sdf.format(item.getNgayBatDau())%>" style="font-style: italic;"><%=item.getNgayDaThuCuoi() != null ? sdf.format(item.getNgayDaThuCuoi()) : "Chưa thu đủ"%></span>
			 	<%
			 		}
			 	%>
			 </liferay-ui:search-container-column-text>
			 <liferay-ui:search-container-column-text cssClass="aui-w20" name="THU TIỀN TẾT">
			 		<span style="color:#ff3d00e8;font-weight: bold;">&nbsp;</span>
			 	<%
			 		for(PhatVay item : phatVays){
			 			String ngayThuTruoc = "";
			 			if(item.getTrangThai() == TrangThaiPhatVayEnum.CO_THU_TIEN_TRUOC.getValue() && item.getNgayThuTruocTu() != null && item.getNgayThuTruocDen() != null){
			 				ngayThuTruoc = "Đã thu tết" + "( " + sdf.format(item.getNgayThuTruocTu()) + " - " + sdf.format(item.getNgayThuTruocDen()) + " )";
			 			}
			 	%>
			 		<br/>
			 		<span title="<%=ngayThuTruoc%>" style="font-style: italic;">Đã thu tết</span>
			 	<%
			 		}
			 	%>
			 </liferay-ui:search-container-column-text>
		 </liferay-ui:search-container-row >
		 <liferay-ui:search-iterator />
	</liferay-ui:search-container >
</aui:form>
<aui:script use="aui-base,aui-io-plugin-deprecated,aui-loading-mask-deprecated,liferay-util-list-fields">
AUI().ready(['aui-base'], function(A) {
	Liferay.Data.redirectURL = '${iteratorURL}';
	var recordSearchContainer = A.one('#<portlet:namespace />contentDataTable');
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
    	var url = e.currentTarget.get('href');
    	pageIO.set('uri', url);
    	pageIO.start();
    });
    recordSearchContainer.all('div.table-sort-liner a').on('click', function(e) {
    	e.preventDefault();
    	Liferay.Data.redirectURL = e.currentTarget.get('href');
    	pageIO.set('uri', e.currentTarget.get('href'));
    	pageIO.start();
    });
    var table = recordSearchContainer.one('table');
    console.log(<%= Validator.isNull(maCTVSearch) %>);
    if(table && <%= Validator.isNull(maCTVSearch) %>){
    	var tbody = table.one('tbody');
    	var trNode = A.Node.create('<tr/>');
    	var td1Node = A.Node.create('<td class="table-cell first text-center" colspan="4"/>');
    	td1Node.append(A.Node.create('<span style="color:#ff3d00e8;font-weight: bold;">TỔNG</span>'));
    	var td2Node = A.Node.create('<td class="table-cell text-right"/>');
    	td2Node.append(A.Node.create('<span style="color:#ff3d00e8;font-weight: bold;"><%=tongTienVayAll > 0 ? df.format(tongTienVayAll) : "0" %></span>'));
    	
    	var td3Node = A.Node.create('<td class="table-cell text-right"/>');
    	td3Node.append(A.Node.create('<span style="color:#ff3d00e8;font-weight: bold;"><%=tongGocNgayAll > 0 ? df.format(tongGocNgayAll) : "0" %></span>'));
    	
    	var td4Node = A.Node.create('<td class="table-cell text-right"/>');
    	td4Node.append(A.Node.create('<span style="color:#ff3d00e8;font-weight: bold;"><%=tongLaiNgayAll > 0 ? df.format(tongLaiNgayAll) : "0" %></span>'));
    	
    	var td5Node = A.Node.create('<td class="table-cell text-right"/>');
    	td5Node.append(A.Node.create('<span style="color:#ff3d00e8;font-weight: bold;"><%=(tongGocNgayAll + tongLaiNgayAll)  > 0 ? df.format(tongGocNgayAll + tongLaiNgayAll) : "0" %></span>'));
    	
    	var td6Node = A.Node.create('<td class="table-cell text-right"/>');
    	td6Node.append(A.Node.create('<span style="color:#ff3d00e8;font-weight: bold;"></span>'));
    	
    	var td7Node = A.Node.create('<td class="table-cell text-right last"/>');
    	td7Node.append(A.Node.create('<span style="color:#ff3d00e8;font-weight: bold;"></span>'));
    	
    	trNode.append(td1Node);
    	trNode.append(td2Node);
    	trNode.append(td3Node);
    	trNode.append(td4Node);
    	trNode.append(td5Node);
    	trNode.append(td6Node);
    	trNode.append(td7Node);
    	tbody.append(trNode);
    }
});	
</aui:script>
