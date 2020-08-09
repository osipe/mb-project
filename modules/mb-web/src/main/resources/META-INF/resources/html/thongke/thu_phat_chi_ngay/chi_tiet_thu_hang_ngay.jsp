<%@page import="com.mb.service.CongTacVienLocalServiceUtil"%>
<%@page import="com.mb.model.CongTacVien"%>
<%@page import="org.apache.commons.collections.CollectionUtils"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.mb.service.PhatVayLocalServiceUtil"%>
<%@page import="com.mb.model.PhatVay"%>
<%@page import="com.mb.service.LichSuThuPhatChiLocalServiceUtil"%>
<%@page import="com.mb.model.LichSuThuPhatChi"%>
<%@page import="java.util.List"%>
<%@page import="quanly.portlet.thongke.thu_phat_chi_ngay.LichSuThuPhatChiComparator"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/thongke/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String maCTV = ParamUtil.getString(request, "maCTV");
	long ngayXuLyTime  = ParamUtil.getLong(request, "ngayXuLyTime");
	long ngayBatDauTuTime  = ParamUtil.getLong(request, "ngayBatDauTu");
	Date ngayBatDauTu =ngayBatDauTuTime != 0 ? new Date(ngayBatDauTuTime) : null;
	Date ngayXuLy =ngayXuLyTime != 0 ? new Date(ngayXuLyTime) : null;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	LichSuThuPhatChiComparator comparator = new LichSuThuPhatChiComparator("createdate", true);
	List<LichSuThuPhatChi> lichSu = LichSuThuPhatChiLocalServiceUtil.findByCTV_Loai_Createdate_NgayXuLy(maCTV, 3,
			ngayBatDauTu, ngayBatDauTu,ngayXuLy,ngayXuLy, -1, -1, comparator);
	DecimalFormat df = new DecimalFormat("###,###.###");
	CongTacVien ctv = CongTacVienLocalServiceUtil.fetchByMa(maCTV);
%>
<aui:form name="frm">
	<h4 align="center"><b><u>CỘNG TÁC VIÊN :</u></b> <%=ctv != null ? ctv.getHoTen() : "" %></h4>
	<h5 align="center"><b><u>THU TIỀN CHO NGÀY :</u></b> <%=ngayXuLy != null ? sdf.format(ngayXuLy) : ""%></h5>
	<div class ="aui-w100" style="padding:2% 5% 2% 5%">
		<div class ="aui-w100">Danh sách phát vay thu tiền</div>
		<table id="<portlet:namespace />taiSanTheChapTable" style="padding:0% 0% 1% 0%" class="table-border-all aui-w100">
			<thead>
					<tr>
					    <th align="center">STT</th>
					    <th align="center">Số KU</th>
					    <th align="center">Mã</th>
					    <th align="center">Tên</th>
					    <th align="center">Số tiền vay</th>
					     <th align="center">Gốc ngày</th>
					     <th align="center">Lãi ngày</th>
					     <th align="center">Gốc đã thu</th>
					     <th align="center">Lãi đã thu</th>
					     <th align="center">Tổng thu</th>
					 </tr>
			</thead>
			 <tbody>
					<c:choose>
						<c:when test="<%=CollectionUtils.isNotEmpty(lichSu)%>">
						<%
							int index = 0;
							PhatVay pv = null;
							Double tongSoTienVay = 0.0;
							Double tongGocNgay = 0.0;
							Double tongLaiNgay = 0.0;
							Double tongVonThu = 0.0;
							Double tongLaiThu = 0.0;
							Double tongThu = 0.0;
							for(LichSuThuPhatChi item : lichSu){
								index++;
								try{
									pv = PhatVayLocalServiceUtil.fetchPhatVay(item.getPhatVayId());
									tongSoTienVay += pv.getSoTienVay();
									tongGocNgay += pv.getGocNgay();
									tongLaiNgay += pv.getLaiNgay();
									tongVonThu += item.getTongSoTienVonTra();
									tongLaiThu += item.getTongSoTienLaiTra();
									tongThu += item.getSoTien();
								}catch(Exception e){
								}
								
						%>
							<tr class="result-row">
								<td align="center">
									<%=index %>
								</td>
								<td align="center">
									<%=pv != null ? pv.getSoKU() : ""%>
								</td>
								<td align="center">
									<%=pv != null ? pv.getMaKhachHang() : ""%>
								</td>
								<td align="center">
									<%=pv != null &&  pv.getKhachHang() != null ? pv.getKhachHang().getHoTen() : ""%>
								</td>
								<td align="center">
									<%=pv != null &&  pv.getSoTienVay() != null ? df.format(pv.getSoTienVay()) : ""%>
								</td>
								<td align="center">
									<%=pv != null &&  pv.getGocNgay() != null ? df.format(pv.getGocNgay()) : ""%>
								</td>
								<td align="center">
									<%=pv != null &&  pv.getLaiNgay() != null ? df.format(pv.getLaiNgay()) : ""%>
								</td>
								<td align="center">
									<%=item != null &&  item.getTongSoTienVonTra() != null ? df.format(item.getTongSoTienVonTra()) : ""%>
								</td>
								<td align="center">
									<%=item != null &&  item.getTongSoTienLaiTra() != null ? df.format(item.getTongSoTienLaiTra()) : ""%>
								</td>
								<td align="center">
									<%=item != null &&  item.getSoTien() != null ? df.format(item.getSoTien()) : ""%>
								</td>
							</tr>
						<%
							}
								
						%>
						<tr class="result-row">
							<td align="center" colspan="4" style="color:#ff3d00e8;font-weight: bold;">TỔNG</td>
							<td align="center" style="color:#ff3d00e8;font-weight: bold;"><%=df.format(tongSoTienVay) %></td>
							<td align="center" style="color:#ff3d00e8;font-weight: bold;"><%=df.format(tongGocNgay) %></td>
							<td align="center" style="color:#ff3d00e8;font-weight: bold;"><%=df.format(tongLaiNgay) %></td>
							<td align="center" style="color:#ff3d00e8;font-weight: bold;"><%=df.format(tongVonThu) %></td>
							<td align="center" style="color:#ff3d00e8;font-weight: bold;"><%=df.format(tongLaiThu) %></td>
							<td align="center" style="color:#ff3d00e8;font-weight: bold;"><%=df.format(tongThu) %></td>
						</tr>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="10" class="empty text-center">Không có dữ liệu</td>
							</tr>
						</c:otherwise>
					</c:choose>
			</tbody>
		</table>
	</div>
</aui:form>
<aui:script use="aui-base,aui-io-plugin-deprecated,aui-loading-mask-deprecated">
AUI().ready(['aui-base'], function(A) {
	$('.input-date').datepicker();
	$('.input-date').mask('99/99/9999');
	$('.input-select2').select2({
		placeholder : 'Chọn',
		allowClear : true,
		language : {
			noResults : function() {
				return '';
			}
		}
	});
});
</aui:script>