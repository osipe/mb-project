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
	TaiKhoanDoiUng taiKhoanTienMat = TaiKhoanDoiUngLocalServiceUtil.fetchBySoHieu(PropsUtil.get("config.taikhoantienmat"));
	DecimalFormat df = new DecimalFormat("###,###.###");
	if(taiKhoanTienMat == null){
%>
	<div>Chưa cấu hình tài khoản tiền mặt !!</div>
<%
	}else{
%>
<h4 align="center"><b><u>TỔNG SỔ</u></b></h4>
<div class="btn-group" style="float: right;">
  <button type="button" class="btn btn-primary dropdown-toggle dropdown-toggle-split" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">In Sổ Cái</button>
  <div class="dropdown-menu">
    <a class="dropdown-item" href="#" onClick="inTongSo(1); return false;">
    	<img alt="Không tìm thấy file" width="20" height="20" src='<%=themeDisplay.getPathThemeImages() + "/file_system/small/docx.png"%>'>
    	DOCX
    </a>
    <a class="dropdown-item" href="#" onClick="inTongSo(2); return false;">
    	<img alt="Không tìm thấy file" width="20" height="20" src='<%=themeDisplay.getPathThemeImages() + "/file_system/small/xlsx.png"%>'>
    	XLSX
    </a>
  </div>
</div>
<table id="<portlet:namespace />dsTaiKhoanDoiUngTable" style="padding:0% 0% 1% 0%" class="table-border-all aui-w100">
	<thead>
			<tr>
				<th style="width: 5%;">Mục</th>
			    <th>Tên tài khoản</th>
			    <th style="width: 10%;">Số hiệu</th>
			    <th style="width: 15%;">Đầu kỳ</th>
			    <th style="width: 15%;">Thu</th>
			    <th style="width: 15%;">Chi</th>
			    <th style="width: 15%;">Tồn</th>
			 </tr>
	</thead>
	 <tbody>
	 	<%
		 	Double soTienThuTM =  GetterUtil.getDouble("0");
			Double soTienChiTM =  GetterUtil.getDouble("0");
			LichSuTaiKhoanDauKy lichSuTaiKhoanDauKyTM =  LichSuTaiKhoanDauKyLocalServiceUtil.fetchByTaiKhoanDoiUngId_Nam_Thang(taiKhoanTienMat.getTaiKhoanDoiUngId(), namSearch, thangSearch);
			List<DsPhieuTaiKhoan> dsPhieuTaiKhoansTM = DsPhieuTaiKhoanLocalServiceUtil.getDSThuChiByTaiKhoanNgayChungTu(taiKhoanTienMat.getTaiKhoanDoiUngId(),"", ngayChungTuTu, ngayChungTuDen, 1, -1, -1, null);
			for(DsPhieuTaiKhoan dsPhieuTaiKhoan : dsPhieuTaiKhoansTM){
				//1 Thu
				if(dsPhieuTaiKhoan.getPhieu().getLoai() == 1){
					soTienThuTM += dsPhieuTaiKhoan.getSoTien();
				//2 Chi
				}else if(dsPhieuTaiKhoan.getPhieu().getLoai() == 2){
					soTienChiTM += dsPhieuTaiKhoan.getSoTien();
				}
			}
			Double soTienTonTM = (lichSuTaiKhoanDauKyTM != null && lichSuTaiKhoanDauKyTM.getSoTienTon() != null) ? lichSuTaiKhoanDauKyTM.getSoTienTon() : GetterUtil.getDouble("0");
			soTienTonTM =  soTienTonTM + soTienThuTM - soTienChiTM;
	 	%>
	 	<tr class="result-row">
	 		<td>I.</td>
	 		<td style="font-weight: bold;text-decoration: underline;"><%=taiKhoanTienMat.getTen()%></td>
	 		<td style="font-weight: bold;text-decoration: underline;"><%=taiKhoanTienMat.getSoHieu()%></td>
	 		<td style="font-weight: bold;text-decoration: underline;"><%= (lichSuTaiKhoanDauKyTM != null && lichSuTaiKhoanDauKyTM.getSoTienTon() != null) ? df.format(lichSuTaiKhoanDauKyTM.getSoTienTon()) : "0"%></td>
	 		<td style="font-weight: bold;text-decoration: underline;"><%=df.format(soTienThuTM)%></td>
	 		<td style="font-weight: bold;text-decoration: underline;"><%=df.format(soTienChiTM)%></td>
	 		<td style="font-weight: bold;text-decoration: underline;"><%=df.format(soTienTonTM)%></td>
		</tr>
		<%
			TaiKhoanDoiUngComparator comparator = new TaiKhoanDoiUngComparator("CAST(soHieu AS bigint)",true);
			List<TaiKhoanDoiUng> taiKhoanDoiUngs =  TaiKhoanDoiUngLocalServiceUtil.findBase(taiKhoanTienMat.getTaiKhoanDoiUngId(), "", "", 1, -1, -1, comparator);
		%>
		<%
			int muc = 0;
			for(TaiKhoanDoiUng taiKhoanDoiUng : taiKhoanDoiUngs){
				Double soTienThu =  GetterUtil.getDouble("0");
				Double soTienChi =  GetterUtil.getDouble("0");
				muc++;
				LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy =  LichSuTaiKhoanDauKyLocalServiceUtil.fetchByTaiKhoanDoiUngId_Nam_Thang(taiKhoanDoiUng.getTaiKhoanDoiUngId(), namSearch, thangSearch);
				List<DsPhieuTaiKhoan> dsPhieuTaiKhoans = DsPhieuTaiKhoanLocalServiceUtil.getDSThuChiByTaiKhoanNgayChungTu(taiKhoanDoiUng.getTaiKhoanDoiUngId(),"", ngayChungTuTu, ngayChungTuDen, 1, -1, -1, null);
				for(DsPhieuTaiKhoan dsPhieuTaiKhoan : dsPhieuTaiKhoans){
					//1 Thu
					if(dsPhieuTaiKhoan.getPhieu().getLoai() == 1){
						soTienThu += dsPhieuTaiKhoan.getSoTien();
					//2 Chi
					}else if(dsPhieuTaiKhoan.getPhieu().getLoai() == 2){
						soTienChi += dsPhieuTaiKhoan.getSoTien();
					}
				}
				Double soTienTon = (lichSuTaiKhoanDauKy != null && lichSuTaiKhoanDauKy.getSoTienTon() != null) ? lichSuTaiKhoanDauKy.getSoTienTon() : GetterUtil.getDouble("0");
				if(taiKhoanDoiUng.getSoHieu().equals(PropsUtil.get("config.taikhoanthuvon"))){
					soTienTon =  soTienTon + soTienChi - soTienThu;
				}else{
					soTienTon =  soTienTon + soTienThu - soTienChi;
				}
		%>
			<tr class="result-row">
	 		<td><span style="margin-left: 2em;"><%=muc + "."%></span></td>
	 		<td><span style="margin-left: 2em;"><%=taiKhoanDoiUng.getTen()%></span></td>
	 		<td><%=taiKhoanDoiUng.getSoHieu()%></td>
	 		<td><%= (lichSuTaiKhoanDauKy != null && lichSuTaiKhoanDauKy.getSoTienTon() != null) ? df.format(lichSuTaiKhoanDauKy.getSoTienTon()) : "0"%></td>
	 		<td><%=df.format(soTienThu)%></td>
	 		<td><%=df.format(soTienChi)%></td>
	 		<td><%=df.format(soTienTon)%></td>
		</tr>
		<%
			}
		%>
	</tbody>
</table>
<%		
	}
%>
<portlet:resourceURL var="inTongSoURL" id="inTongSoURL">
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
	Liferay.provide(window,'inTongSo', function(type){
		var url = '${inTongSoURL}';
		url += '&<portlet:namespace/>typeIn=' + type;
		window.location.href = url;
	});
});
</aui:script>
