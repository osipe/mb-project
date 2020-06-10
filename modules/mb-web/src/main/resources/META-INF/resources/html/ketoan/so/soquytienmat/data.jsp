<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.apache.commons.collections.CollectionUtils"%>
<%@page import="com.mb.service.LichSuTaiKhoanDauKyLocalServiceUtil"%>
<%@page import="com.mb.model.DsPhieuTaiKhoan"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.liferay.portal.kernel.util.CalendarUtil"%>
<%@page import="com.mb.service.DsPhieuTaiKhoanLocalServiceUtil"%>
<%@page import="com.mb.model.LichSuTaiKhoanDauKy"%>
<%@page import="com.mb.model.TaiKhoanDoiUng"%>
<%@page import="quanly.portlet.danhmuc.taikhoandoiung.TaiKhoanDoiUngComparator"%>
<%@page import="com.mb.service.TaiKhoanDoiUngLocalServiceUtil"%>
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
	TaiKhoanDoiUng taiKhoanTienMat = TaiKhoanDoiUngLocalServiceUtil.fetchBySoHieu("1111");
%>
<%
	if(taiKhoanTienMat == null){
%>
	<div>Chưa cấu hình tài khoản tiền mặt !!</div>
<%
	}else{
		Calendar calTu = Calendar.getInstance();
		calTu.set(namSearch, thangSearch - 1 ,1);
		Date ngayChungTuTu = calTu.getTime();
		Calendar calDen = Calendar.getInstance();
		calDen.set(namSearch, thangSearch - 1,CalendarUtil.getDaysInMonth(calTu));
		Date ngayChungTuDen = calDen.getTime();
		DecimalFormat df = new DecimalFormat("###,###.###");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<DsPhieuTaiKhoan> dsPhieus = DsPhieuTaiKhoanLocalServiceUtil.getDSThuChiByTaiKhoanNgayChungTu(taiKhoanTienMat.getTaiKhoanDoiUngId(), ngayChungTuTu, ngayChungTuDen, 1, -1, -1, null);
		LichSuTaiKhoanDauKy dauKy = LichSuTaiKhoanDauKyLocalServiceUtil.fetchByTaiKhoanDoiUngId_Nam_Thang(taiKhoanTienMat.getTaiKhoanDoiUngId(), namSearch, thangSearch);
		if(dauKy == null){
			dauKy = LichSuTaiKhoanDauKyLocalServiceUtil.createLichSuTaiKhoanDauKy(0L);
		}
		LichSuTaiKhoanDauKy cuoiKySoQuyTienMat = LichSuTaiKhoanDauKyLocalServiceUtil.fetchByTaiKhoanDoiUngId_Nam_Thang(taiKhoanTienMat.getTaiKhoanDoiUngId(), thangSearch == 12 ?  namSearch + 1 : namSearch,thangSearch == 12 ? 1 : thangSearch + 1);
		if(cuoiKySoQuyTienMat == null){
			cuoiKySoQuyTienMat = LichSuTaiKhoanDauKyLocalServiceUtil.createLichSuTaiKhoanDauKy(0L);
		}
		Double soTien = dauKy.getSoTienTon() != null ? dauKy.getSoTienTon() : GetterUtil.getDouble("0");
		Double soTienThuThang =  GetterUtil.getDouble("0");
		Double soTienChiThang =  GetterUtil.getDouble("0");
%>
<h4 align="center"><b><u>TÊN TÀI KHOẢN :</u></b>   <%=taiKhoanTienMat.getTen() %></h4>
<h4 align="center"><b><u>SỐ HIỆU :</u></b>  <%=taiKhoanTienMat.getSoHieu() %></h4>
<div class="btn-group" style="float: right;">
 <button type="button" class="btn btn-primary dropdown-toggle dropdown-toggle-split" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">In Sổ Quỷ</button>
  <div class="dropdown-menu">
    <a class="dropdown-item" href="#" onClick="inSoQuyTienMat(1); return false;">
    	<img alt="Không tìm thấy file" width="20" height="20" src='<%=themeDisplay.getPathThemeImages() + "/file_system/small/docx.png"%>'>
    	DOCX
    </a>
    <a class="dropdown-item" href="#" onClick="inSoQuyTienMat(2); return false;">
    	<img alt="Không tìm thấy file" width="20" height="20" src='<%=themeDisplay.getPathThemeImages() + "/file_system/small/xlsx.png"%>'>
    	XLSX
    </a>
  </div>
</div>
<table id="<portlet:namespace />dsTaiKhoanDoiUngTable" style="padding:0% 0% 1% 0%" class="table-border-all aui-w100">
	<thead>
			<tr>
				<th rowspan="2">Ngày ghi sổ</th>
			    <th  colspan="2">Số phiếu</th>
			    <th rowspan="2">Diễn giải</th>
			    <th colspan="3">Số Tiền</th>
			 </tr>
			 <tr >
				<th>Thu</th>
			    <th>Chi</th>
			    <th>Thu</th>
			    <th >Chi</th>
			    <th >Tồn</th>
			 </tr>
	</thead>
	 <tbody>
	 	<tr>
	 		<td/>
	 		<td/>
	 		<td/>
	 		<td><b><u>SỐ ĐẦU KỲ</u></b></td>
	 		<td/>
	 		<td/>
	 		<td style="text-align: center;"><b><%=(dauKy.getSoTienTon() != null && dauKy.getSoTienTon() != 0)  ? df.format(dauKy.getSoTienTon()) : ""%></b></td>
	 	</tr>
	 		<c:choose>
	 	<c:when test="<%=CollectionUtils.isNotEmpty(dsPhieus)%>">
		<%
			int index = 0;
			boolean inNgay = true;
			String ngayGhiSo =  "";
			SimpleDateFormat sdfSo = new SimpleDateFormat("ddMMyyyy");
			for(DsPhieuTaiKhoan item : dsPhieus){
				String soPhieuDayDu1 = "";
				String soPhieuDayDu2 = "";
				String soTienTon = "";
				String soTienThu = "";
				String soTienChi = "";
				String dienGiai = "";
				if(item.getPhieu() != null){
					if(item.getSoTien() > 0){
						if(item.getPhieu().getLoai() == 1 ){
							soPhieuDayDu1 = item.getPhieu().getSoPhieu() + "/" + sdfSo.format(item.getNgayChungTu()) + item.getPhieu().getMaMSThuChi();
							soTienTon = "+" + df.format(item.getSoTien());
							soTienThu = df.format(item.getSoTien());
							soTien += item.getSoTien();
							soTienThuThang += item.getSoTien();
						}else if(item.getPhieu().getLoai() == 2){
							soPhieuDayDu2 = item.getPhieu().getSoPhieu() + "/" + sdfSo.format(item.getNgayChungTu()) + item.getPhieu().getMaMSThuChi();
							soTienTon = "-" + df.format(item.getSoTien());
							soTien -= item.getSoTien();
							soTienChi = df.format(item.getSoTien());
							soTienChiThang += item.getSoTien();
						}
					}
					if(item.getPhieu().getCtv() != null){
						dienGiai = item.getPhieu().getCtv().getHoTen() + "( " + item.getDienGiaiTheoDoi() + " )";
					}
				}
				if(item.getPhieu() != null && item.getPhieu().getNgayGhiSo() != null && !ngayGhiSo.equals(sdf.format(item.getPhieu().getNgayGhiSo()))){
					ngayGhiSo = sdf.format(item.getPhieu().getNgayGhiSo());
					inNgay = true;
				}else{
					inNgay = false;
				}
				
		%>
			<tr class="result-row">
				<td><%=inNgay ? ngayGhiSo : ""%></td>
		 		<td><%=soPhieuDayDu1%></td>
		 		<td><%=soPhieuDayDu2%></td>
		 		<td><%=dienGiai %></td>
		 		<td><%=soTienThu%></td>
		 		<td><%=soTienChi%></td>
		 		<td><%=soTienTon%></td>
			</tr>
		<%
			}
		%>
			<tr>
		 		<td/>
		 		<td/>
		 		<td/>
		 		<td><b><u>SỐ TRONG THÁNG</u></b></td>
		 		<td style="text-align: center;"><b><%=soTienThuThang != null  ? df.format(soTienThuThang) : ""%></b></td>
		 		<td style="text-align: center;"><b><%=soTienChiThang != null  ? df.format(soTienChiThang) : ""%></b></td>
		 		<td style="text-align: center;"><b><%=(soTienThuThang != null && soTienChiThang != null)  ? df.format(soTienThuThang - soTienChiThang) : ""%></b></td>
	 		</tr>
			<tr>
		 		<td/>
		 		<td/>
		 		<td/>
		 		<td><b><u>SỐ CUỐI THÁNG</u></b></td>
		 		<td/>
		 		<td/>
		 		<td style="text-align: center;"><b><%=(cuoiKySoQuyTienMat.getSoTienTon() != null && cuoiKySoQuyTienMat.getSoTienTon() != 0)  ? df.format(cuoiKySoQuyTienMat.getSoTienTon()) : ""%></b></td>
	 		</tr>
		</c:when>
		<c:otherwise>
				<tr>
					<td colspan="7" class="empty text-center">Không có dữ liệu</td>
				</tr>
			</c:otherwise>
		</c:choose>
		<%
			cuoiKySoQuyTienMat.setSoTienTon(soTien);
		%>
	</tbody>
</table>
<portlet:resourceURL var="inSoQuyTienMatURL" id="inSoQuyTienMatURL">
	<portlet:param name="nam" value="<%=String.valueOf(namSearch)%>" />
	<portlet:param name="thang" value="<%=String.valueOf(thangSearch)%>" />
	<portlet:param name="taiKhoanDoiUngId" value="<%=String.valueOf(taiKhoanTienMat.getTaiKhoanDoiUngId())%>" />
</portlet:resourceURL>
<aui:script use="aui-base,aui-io-plugin-deprecated,aui-loading-mask-deprecated">
AUI().ready(['aui-base'], function(A) {
	Liferay.provide(window,'inSoQuyTienMat', function(type){
		var url = '${inSoQuyTienMatURL}';
		url += '&<portlet:namespace/>typeIn=' + type;
		window.location.href = url;
	});
});
</aui:script>
<%
	}
%>
