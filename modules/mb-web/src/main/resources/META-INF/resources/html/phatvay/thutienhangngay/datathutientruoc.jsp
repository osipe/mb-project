<%@page import="quanly.portlet.danhmuc.cauhinhthutientruoc.CauHinhThuTienTruocComparator"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@page import="org.apache.commons.collections.CollectionUtils"%>
<%@page import="com.mb.service.CauHinhThuTienTruocLocalServiceUtil"%>
<%@page import="com.mb.model.CauHinhThuTienTruoc"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="quanly.constants.TrangThaiPhatVayEnum"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.mb.model.CongTacVien"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
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
	List<CauHinhThuTienTruoc> cauHinhs = CauHinhThuTienTruocLocalServiceUtil.findBase(0, 1, -1, -1, new CauHinhThuTienTruocComparator("nam",false));
	CauHinhThuTienTruoc cauHinh = CollectionUtils.isNotEmpty(cauHinhs) ? cauHinhs.get(0) : null;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	String maCTVSearch = ParamUtil.getString(request, "maCTVSearch");
	List<PhatVay> phatVays = PhatVayLocalServiceUtil.getPhatVayDeThuTienTruoc(maCTVSearch, cauHinh.getNgayTu());

	Locale localeEn = new Locale("en", "EN");
    NumberFormat df = NumberFormat.getInstance(localeEn);
	
	
	String arrayChecked = ParamUtil.getString(request, "phatVayIdAdds");
	String[] checked = StringUtil.split(arrayChecked, ",");
	PhatVayChecker rowChecker = new PhatVayChecker(renderResponse, checked);
%>
<c:set value="<%=df %>" var="df"/>
<c:set value="<%=sdf %>" var="sdf"/>
<aui:form name="fm">
	<liferay-portlet:renderURL varImpl="iteratorURL">
		<portlet:param name="maCTVSearch" value="<%= String.valueOf(maCTVSearch) %>" />
		<portlet:param name="mvcPath" value="/html/phatvay/thutienhangngay/datathutientruoc.jsp" />
		<portlet:param name="phatVayIdAdds" value="<%= arrayChecked%>" />
	</liferay-portlet:renderURL>
	<div style="text-align: right;"><span class="note-span">(Đơn vị : VND)</span></div>
	<liferay-ui:search-container  delta="<%=phatVays.size() %>"  emptyResultsMessage="Không có kết quả nào được tìm thấy!" iteratorURL="<%=iteratorURL %>" total="<%=phatVays.size() %>" rowChecker="<%=rowChecker%>">
		 <liferay-ui:search-container-results results="<%= phatVays %>" />
		 <liferay-ui:search-container-row className="com.mb.model.PhatVay" modelVar="phatVay" keyProperty="phatVayId" indexVar="index"> 
			 <liferay-ui:search-container-column-text cssClass="aui-w3" name="STT">
			 	<span><%=index + 1 %></span>
			 </liferay-ui:search-container-column-text>
			 <liferay-ui:search-container-column-text cssClass="aui-w7" name="SỐ KU">
		 		<span><%=phatVay.getSoKU() %></span>
			 </liferay-ui:search-container-column-text>
			  <liferay-ui:search-container-column-text  name="TÊN">
			 	<span><%=phatVay.getKhachHang() != null ? phatVay.getKhachHang().getHoTen() : "" %></span>
			 </liferay-ui:search-container-column-text>
			 <liferay-ui:search-container-column-text cssClass="aui-w10" name="SỐ TIỀN VAY">
			 	<span style="font-style: italic;"><%=phatVay.getSoTienVay() > 0 ? df.format(phatVay.getSoTienVay()) : "0"%></span>
			 </liferay-ui:search-container-column-text>
			 <liferay-ui:search-container-column-text cssClass="aui-w10 text-right" name="THỜI HẠN">
			 	<span style="font-style: italic;"><%=phatVay.getThoiHan()%></span>
			 </liferay-ui:search-container-column-text>
			 <liferay-ui:search-container-column-text cssClass="aui-w10" name="GỐC NGÀY">
			 	<span style="font-style: italic;"><%=phatVay.getGocNgay() > 0 ? df.format(phatVay.getGocNgay()) : "0"%></span>
			 </liferay-ui:search-container-column-text>
			  <liferay-ui:search-container-column-text cssClass="aui-w7" name="LÃI NGÀY">
		 		<span style="font-style: italic;"><%=phatVay.getLaiNgay()> 0 ? df.format(phatVay.getLaiNgay()) : "0"%></span>
			 </liferay-ui:search-container-column-text>
			 <liferay-ui:search-container-column-text cssClass="aui-w7" name="SỐ TIỀN PHẢI THU (1 Ngày)">
		 		<span style="font-style: italic;"><%=(phatVay.getLaiNgay() + phatVay.getGocNgay())> 0 ? df.format(phatVay.getLaiNgay() + phatVay.getGocNgay()) : "0"%></span>
			 </liferay-ui:search-container-column-text>
		 	 <liferay-ui:search-container-column-text cssClass="aui-w7" name="NGÀY ĐÃ THU CUỐI">
			 	<span style="font-style: italic;"><%=phatVay.getNgayDaThuCuoi() != null ? sdf.format(phatVay.getNgayDaThuCuoi()) : ("Chưa thu : " + sdf.format(phatVay.getNgayBatDau()))%></span>
			 </liferay-ui:search-container-column-text>
		 </liferay-ui:search-container-row >
		 <liferay-ui:search-iterator />
	</liferay-ui:search-container >
</aui:form>
<aui:script use="aui-base,aui-io-plugin-deprecated,aui-loading-mask-deprecated,liferay-util-list-fields">
AUI().ready(['aui-base'], function(A) {
	Liferay.Data.redirectURL = '${iteratorURL}';
	var recordSearchContainer = A.one('#<portlet:namespace />contentDataTableThuTienTruoc');
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
});	
</aui:script>
