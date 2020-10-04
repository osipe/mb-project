<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.service.ServiceContext"%>
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
	long taiKhoanDoiUngIdSearch = ParamUtil.getLong(request, "taiKhoanDoiUngIdSoCaiSearch");
	TaiKhoanDoiUng taiKhoanDoiUng = TaiKhoanDoiUngLocalServiceUtil.createTaiKhoanDoiUng(0L);
	if(taiKhoanDoiUngIdSearch > 0){ 
		taiKhoanDoiUng = TaiKhoanDoiUngLocalServiceUtil.fetchTaiKhoanDoiUng(taiKhoanDoiUngIdSearch);
	}
	Calendar calTu = Calendar.getInstance();
	calTu.set(namSearch, thangSearch - 1 ,1);
	Date ngayChungTuTu = calTu.getTime();
	Calendar calDen = Calendar.getInstance();
	calDen.set(namSearch, thangSearch - 1,CalendarUtil.getDaysInMonth(calTu));
	Date ngayChungTuDen = calDen.getTime();
	Locale localeEn = new Locale("en", "EN");
    NumberFormat df = NumberFormat.getInstance(localeEn);
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	List<DsPhieuTaiKhoan> dsPhieuTaiKhoans = DsPhieuTaiKhoanLocalServiceUtil.getDSThuChiByTaiKhoanNgayChungTu(taiKhoanDoiUngIdSearch,"", ngayChungTuTu, ngayChungTuDen, 1, -1, -1, null);
	LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy = LichSuTaiKhoanDauKyLocalServiceUtil.fetchByTaiKhoanDoiUngId_Nam_Thang(taiKhoanDoiUngIdSearch, namSearch, thangSearch);
	if(lichSuTaiKhoanDauKy == null){
		lichSuTaiKhoanDauKy = LichSuTaiKhoanDauKyLocalServiceUtil.createLichSuTaiKhoanDauKy(0L);
	}
	LichSuTaiKhoanDauKy cuoiKy = LichSuTaiKhoanDauKyLocalServiceUtil.fetchByTaiKhoanDoiUngId_Nam_Thang(taiKhoanDoiUngIdSearch,thangSearch == 12 ?  namSearch + 1 : namSearch,thangSearch == 12 ? 1 : thangSearch + 1);
	if(cuoiKy == null){
		cuoiKy = LichSuTaiKhoanDauKyLocalServiceUtil.createLichSuTaiKhoanDauKy(0L);
	}
	cuoiKy.setTaiKhoanDoiUngId(taiKhoanDoiUngIdSearch);
	cuoiKy.setNam(thangSearch == 12 ?  namSearch + 1 : namSearch);
	cuoiKy.setThang(thangSearch == 12 ? 1 : thangSearch + 1);
	Double soTien = lichSuTaiKhoanDauKy.getSoTienTon() != null ? lichSuTaiKhoanDauKy.getSoTienTon() : GetterUtil.getDouble("0");
	Double soTienThu = lichSuTaiKhoanDauKy.getSoTienThu() != null ? lichSuTaiKhoanDauKy.getSoTienThu() : GetterUtil.getDouble("0");
	Double soTienChi = lichSuTaiKhoanDauKy.getSoTienChi() != null ? lichSuTaiKhoanDauKy.getSoTienChi() : GetterUtil.getDouble("0");
	Double soTienNo =  GetterUtil.getDouble("0");
	Double soTienCo =  GetterUtil.getDouble("0");

%>
<h4 align="center"><b><u>TÊN TÀI KHOẢN :</u></b>   <%=taiKhoanDoiUng.getTen() %></h4>
<h4 align="center"><b><u>SỐ HIỆU :</u></b>  <%=taiKhoanDoiUng.getSoHieu() %></h4>
<div class="btn-group" style="float: right;">
  <button type="button" class="btn btn-primary dropdown-toggle dropdown-toggle-split" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">In Sổ Cái</button>
  <div class="dropdown-menu">
    <a class="dropdown-item" href="#" onClick="inSoCai(1); return false;">
    	<img alt="Không tìm thấy file" width="20" height="20" src='<%=themeDisplay.getPathThemeImages() + "/file_system/small/docx.png"%>'>
    	DOCX
    </a>
    <a class="dropdown-item" href="#" onClick="inSoCai(2); return false;">
    	<img alt="Không tìm thấy file" width="20" height="20" src='<%=themeDisplay.getPathThemeImages() + "/file_system/small/xlsx.png"%>'>
    	XLSX
    </a>
  </div>
</div>
<table id="<portlet:namespace />dsTaiKhoanDoiUngTable" style="padding:0% 0% 1% 0%" class="table-border-all aui-w100">
	<thead>
			<tr>
				<th rowspan="2">Ngày ghi sổ</th>
			    <th  colspan="2">Chứng từ</th>
			    <th rowspan="2">Diễn giải</th>
			    <th rowspan="2">Tên CTV</th>
			    <th rowspan="2">Tài khoản đối ứng</th>
			    <th colspan="3">Số phát sinh</th>
			 </tr>
			 <tr >
				<th>Số hiệu</th>
			    <th>Ngày tháng</th>
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
	 		<td style="text-align: center;"><b><%=(lichSuTaiKhoanDauKy.getSoTienThu() != null && lichSuTaiKhoanDauKy.getSoTienThu() != 0)  ? df.format(lichSuTaiKhoanDauKy.getSoTienThu()) : ""%></b></td>
	 		<td style="text-align: center;"><b><%=(lichSuTaiKhoanDauKy.getSoTienChi() != null && lichSuTaiKhoanDauKy.getSoTienChi() != 0)  ? df.format(lichSuTaiKhoanDauKy.getSoTienChi()) : ""%></b></td>
	 		<td style="text-align: center;"><b><%=(lichSuTaiKhoanDauKy.getSoTienTon() != null && lichSuTaiKhoanDauKy.getSoTienTon() != 0)  ? df.format(lichSuTaiKhoanDauKy.getSoTienTon()) : ""%></b></td>
	 	</tr>
	 		<c:choose>
	 	<c:when test="<%=CollectionUtils.isNotEmpty(dsPhieuTaiKhoans)%>">
		<%
			int index = 0;
			boolean inNgay = true;
			boolean inNgayChungTu = true;
			SimpleDateFormat sdfSo = new SimpleDateFormat("ddMMyyyy");
			ServiceContext serviceContext = new ServiceContext();
			serviceContext.setScopeGroupId(themeDisplay.getScopeGroupId());
			serviceContext.setCompanyId(themeDisplay.getCompanyId());
			serviceContext.setUserId(themeDisplay.getUserId());
			String ngayChungTu = "";
			String ngayGhiSo =  "";
			for(DsPhieuTaiKhoan item : dsPhieuTaiKhoans){
				String soPhieuDayDu = "";
				String tenTaiKhoanDoiUng = "";
				String soNo = "";
				String soCo = "";
				String tenCTV = "";
				if(item.getPhieu() != null){
					soPhieuDayDu = item.getPhieu().getSoPhieu();
					if(taiKhoanDoiUng.getSoHieu().equals(PropsUtil.get("config.taikhoanthuvon"))){	
						//1 Thu
						if(item.getPhieu().getLoai() == 1){
							soTienCo += item.getSoTien();
							soTien -= item.getSoTien();
						//2 Chi
						}else if(item.getPhieu().getLoai() == 2){
							soTienNo += item.getSoTien();
							soTien += item.getSoTien();
						}
					}else{
						//1 Thu
						if(item.getPhieu().getLoai() == 1){
							soTienCo += item.getSoTien();
							soTien += item.getSoTien();
						//2 Chi
						}else if(item.getPhieu().getLoai() == 2){
							soTienNo += item.getSoTien();
							soTien -= item.getSoTien();
						}
					}
					if(item.getPhieu().getLoai() == 1 && item.getSoTien() > 0){
						soCo = df.format(item.getSoTien());
					}
					if(item.getPhieu().getLoai() == 2 && item.getSoTien() > 0){
						soNo = df.format(item.getSoTien());
					}
				}
				if(item.getTaiKhoanDoiUng() != null){
					tenTaiKhoanDoiUng = item.getTaiKhoanDoiUng().getTen() + "( " + item.getTaiKhoanDoiUng().getSoHieu() + " )";
				}
				if(item.getPhieu() != null && item.getPhieu().getNgayGhiSo() != null && !ngayGhiSo.equals(sdf.format(item.getPhieu().getNgayGhiSo()))){
					ngayGhiSo = sdf.format(item.getPhieu().getNgayGhiSo());
					inNgay = true;
				}else{
					inNgay = false;
				}
				if(!ngayChungTu.equals(sdf.format(item.getNgayChungTu()))){
					ngayChungTu = sdf.format(item.getNgayChungTu());
					inNgayChungTu = true;
				}else{
					inNgayChungTu = false;
				}
				
		%>
			<tr class="result-row">
				<td><%=inNgay ? ngayGhiSo : ""%></td>
		 		<td><%=soPhieuDayDu%></td>
		 		<td><%=inNgayChungTu ? ngayChungTu : ""%></td>
		 		<td><%=item.getDienGiaiTheoDoi()%></td>
		 		<td><%=item.getTenCTV()%></td>
		 		<td><%=tenTaiKhoanDoiUng%></td>
		 		<td><%=soCo%></td>
		 		<td><%=soNo%></td>
		 		<td><%=df.format(soTien)%></td>
			</tr>
		<%
			}
			cuoiKy.setSoTienTon(soTien);
		%>
			<tr>
		 		<td/>
		 		<td/>
		 		<td/>
		 		<td><b><u>SỐ TRONG THÁNG</u></b></td>
		 		<td/>
	 			<td/>
		 		<td style="text-align: center;"><b><%=df.format(soTienCo)%></b></td>
		 		<td style="text-align: center;"><b><%=df.format(soTienNo)%></b></td>
		 		<td style="text-align: center;"><b><%=""%></b></td>
		 	</tr>
			<tr>
		 		<td/>
		 		<td/>
		 		<td/>
		 		<td><b><u>SỐ CUỐI THÁNG</u></b></td>
		 		<td/>
	 			<td/>
		 		<td  style="text-align: center;"><b><%=df.format(soTienThu + soTienCo)%></b></td>
		 		<td  style="text-align: center;"><b><%=df.format(soTienChi + soTienNo)%></b></td>
		 		<td  style="text-align: center;"><b><%=df.format(cuoiKy.getSoTienTon())%></b></td>
		 	</tr>
		</c:when>
		<c:otherwise>
				<tr>
					<td colspan="9" class="empty text-center">Không có dữ liệu</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</tbody>
</table>
<portlet:resourceURL var="capNhatDuLieuDauKyURL" id="capNhatDuLieuDauKyURL"></portlet:resourceURL>
<portlet:resourceURL var="inSoCaiURL" id="inSoCaiURL">
	<portlet:param name="nam" value="<%=String.valueOf(namSearch)%>" />
	<portlet:param name="thang" value="<%=String.valueOf(thangSearch)%>" />
	<portlet:param name="taiKhoanDoiUngId" value="<%=String.valueOf(taiKhoanDoiUngIdSearch)%>" />
</portlet:resourceURL>
<aui:script use="aui-base,aui-io-plugin-deprecated,aui-loading-mask-deprecated">
AUI().ready(['aui-base'], function(A) {
	var loadingMask = new A.LoadingMask(
		{
			target: A.getBody()
		}
	);
	Liferay.provide(window,'capNhatDuLieuDauKy', function(){
		loadingMask.show();
		A.io.request('${capNhatDuLieuDauKyURL}', {
               method: 'post',
               data: {
               	'<portlet:namespace />taiKhoanDoiUngId' : '<%=taiKhoanDoiUngIdSearch %>',
               	'<portlet:namespace />nam' : '<%=namSearch %>',
               	'<portlet:namespace />thang' : '<%=thangSearch %>'
               },
               on: {
                   success: function() {
                   		if(this.get('responseData')){
                   			var data = JSON.parse(this.get('responseData'));
                   			if(data.exception){
                   				toastr.warning('Cập nhật dữ liệu đầu kỳ lỗi', 'Cảnh báo!');
                   			}
                   		}
                   }
              }
        });
        loadingMask.hide();
	});	
	Liferay.provide(window,'inSoCai', function(type){
		var url = '${inSoCaiURL}';
		url += '&<portlet:namespace/>typeIn=' + type;
		window.location.href = url;
	});
	capNhatDuLieuDauKy();
});
</aui:script>
