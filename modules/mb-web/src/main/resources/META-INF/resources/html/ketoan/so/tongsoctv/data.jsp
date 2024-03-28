<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="quanly.portlet.danhmuc.taikhoandoiung.TaiKhoanDoiUngComparator"%>
<%@page import="com.liferay.portal.kernel.util.CalendarUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.mb.service.DsPhieuTaiKhoanLocalServiceUtil"%>
<%@page import="com.mb.model.DsPhieuTaiKhoan"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.mb.model.LichSuTaiKhoanDauKy"%>
<%@page import="com.mb.service.LichSuTaiKhoanDauKyLocalServiceUtil"%>
<%@page import="com.mb.service.TaiKhoanDoiUngLocalServiceUtil"%>
<%@page import="com.mb.model.TaiKhoanDoiUng"%>
<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/ketoan/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	int namSearch = ParamUtil.getInteger(request, "namSearch");
	int thangSearch = ParamUtil.getInteger(request, "thangSearch");
	Calendar calTu = Calendar.getInstance();
	calTu.set(namSearch, thangSearch - 1 ,1);
	Date ngayChungTuTu = calTu.getTime();
	Calendar calDen = Calendar.getInstance();
	calDen.set(namSearch, thangSearch - 1,CalendarUtil.getDaysInMonth(calTu));
	Date ngayChungTuDen = calDen.getTime();
	Locale localeEn = new Locale("en", "EN");
    NumberFormat df = NumberFormat.getInstance(localeEn);
 %>
<h4 align="center"><b><u>TỔNG SỔ CỘNG TÁC VIÊN</u></b></h4>
<div class="btn-group" style="float: right;">
  <button type="button" class="btn btn-primary dropdown-toggle dropdown-toggle-split" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">In Sổ</button>
  <div class="dropdown-menu">
    <a class="dropdown-item" href="#" onClick="inTongSoCTV(1); return false;">
    	<img alt="Không tìm thấy file" width="20" height="20" src='<%=themeDisplay.getPathThemeImages() + "/file_system/small/docx.png"%>'>
    	DOCX
    </a>
    <a class="dropdown-item" href="#" onClick="inTongSoCTV(2); return false;">
    	<img alt="Không tìm thấy file" width="20" height="20" src='<%=themeDisplay.getPathThemeImages() + "/file_system/small/xlsx.png"%>'>
    	XLSX
    </a>
  </div>
</div>
<table id="<portlet:namespace />dsTaiKhoanDoiUngTable" style="padding:0% 0% 1% 0%" class="table-border-all aui-w100">
	<thead>
			<tr>
				<th style="width: 5%;">STT</th>
			    <th>Diễn giải</th>
			    <th style="width: 15%;">Đầu kỳ</th>
			    <th style="width: 15%;">Thu</th>
			    <th style="width: 15%;">Chi</th>
			    <th style="width: 15%;">Tồn</th>
			 </tr>
	</thead>
	 <tbody>
		<%
			Double tongTonDauKy =  GetterUtil.getDouble("0");
			Double tongSoTienThu =  GetterUtil.getDouble("0");
			Double tongSoTienChi =  GetterUtil.getDouble("0");
			Double tongSoTienTon =  GetterUtil.getDouble("0");
			List<TaiKhoanDoiUng> taiKhoanDoiUngs =  TaiKhoanDoiUngLocalServiceUtil.findByLoaiTaiKhoan_HoatDong(2, true);
			int muc = 0;
			TaiKhoanDoiUng taiKhoanThuVon = null;
			try{
				taiKhoanThuVon = TaiKhoanDoiUngLocalServiceUtil.fetchBySoHieu(PropsUtil.get("config.taikhoanthuvon"));
			}catch(Exception e){}
			for(TaiKhoanDoiUng taiKhoanDoiUng : taiKhoanDoiUngs){
				Double soTienThu =  GetterUtil.getDouble("0");
				Double soTienChi =  GetterUtil.getDouble("0");
				LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy =  LichSuTaiKhoanDauKyLocalServiceUtil.fetchByTaiKhoanDoiUngId_Nam_Thang(taiKhoanDoiUng.getTaiKhoanDoiUngId(), namSearch, thangSearch);
				List<DsPhieuTaiKhoan> dsPhieuTaiKhoans = DsPhieuTaiKhoanLocalServiceUtil.getDSThuChiByTaiKhoanNgayChungTu(taiKhoanThuVon.getTaiKhoanDoiUngId(),taiKhoanDoiUng != null ? taiKhoanDoiUng.getSoHieu() : "", ngayChungTuTu, ngayChungTuDen, 1, -1, -1, null);
				Double soTienTon = (lichSuTaiKhoanDauKy != null && lichSuTaiKhoanDauKy.getSoTienTon() != null) ? lichSuTaiKhoanDauKy.getSoTienTon() : GetterUtil.getDouble("0");
				tongTonDauKy += soTienTon;
				for(DsPhieuTaiKhoan dsPhieuTaiKhoan : dsPhieuTaiKhoans){
					//1 Thu
					if(dsPhieuTaiKhoan.getPhieu().getLoai() == 1){
						soTienThu += dsPhieuTaiKhoan.getSoTien();
						soTienTon -=  dsPhieuTaiKhoan.getSoTien();
					//2 Chi
					}else if(dsPhieuTaiKhoan.getPhieu().getLoai() == 2){
						soTienChi += dsPhieuTaiKhoan.getSoTien();
						soTienTon +=  dsPhieuTaiKhoan.getSoTien();
					}
				}
				tongSoTienThu += soTienThu;
				tongSoTienChi += soTienChi;
				tongSoTienTon += soTienTon;
				if(soTienTon != 0){
					muc++;
		%>
		<tr class="result-row">
	 		<td><span style="margin-left: 2em;"><%=muc + "."%></span></td>
	 		<td><span style="margin-left: 2em;"><%=taiKhoanDoiUng.getTen()%></span></td>
	 		<td><%= (lichSuTaiKhoanDauKy != null && lichSuTaiKhoanDauKy.getSoTienTon() != null) ? df.format(lichSuTaiKhoanDauKy.getSoTienTon()) : "0"%></td>
	 		<td><%=df.format(soTienThu)%></td>
	 		<td><%=df.format(soTienChi)%></td>
	 		<td><%=df.format(soTienTon)%></td>
		</tr>
		<%
			}}
		%>
		<tr class="result-row">
	 		<td colspan="2"><span style="margin-left: 2em;">Tổng</span></td>
	 		<td><%= df.format(tongTonDauKy)%></td>
	 		<td><%=df.format(tongSoTienThu)%></td>
	 		<td><%=df.format(tongSoTienChi)%></td>
	 		<td><%=df.format(tongSoTienTon)%></td>
		</tr>
	</tbody>
</table>
<portlet:resourceURL var="inTongSoCTVURL" id="inTongSoCTVURL">
	<portlet:param name="nam" value="<%=String.valueOf(namSearch)%>" />
	<portlet:param name="thang" value="<%=String.valueOf(thangSearch)%>" />
</portlet:resourceURL>
<aui:script use="aui-base,aui-io-plugin-deprecated,aui-loading-mask-deprecated">
AUI().ready(['aui-base'], function(A) {
	var loadingMask = new A.LoadingMask(
		{
			target: A.getBody()
		}
	);
	Liferay.provide(window,'inTongSoCTV', function(type){
		var url = '${inTongSoCTVURL}';
		url += '&<portlet:namespace/>typeIn=' + type;
		window.location.href = url;
	});
});
</aui:script>
