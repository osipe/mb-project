package quanly.portlet.thongke.thu_phat_chi_ngay;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.collections.CollectionUtils;
import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.mb.model.CongTacVien;
import com.mb.model.LichSuThuPhatChi;
import com.mb.service.CongTacVienLocalServiceUtil;
import com.mb.service.LichSuThuPhatChiLocalServiceUtil;

import quanly.constants.FileType;
import quanly.constants.QuanlyPortletKeys;
import quanly.dto.LichSuThuPhatChDTO;
import quanly.portlet.danhmuc.ctv.CongTacVienComparator;
import quanly.util.JasperReportUtil;

/**
 * @author Annn
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/html/thongke/thu_phat_chi_ngay/view.jsp",
		"javax.portlet.display-name=" + QuanlyPortletKeys.thuPhatChiNgay,
		"javax.portlet.name=" + QuanlyPortletKeys.thuPhatChiNgay, "javax.portlet.resource-bundle=content.Language",
		"com.liferay.portlet.footer-portlet-javascript=/plugins/toastr/toastr.min.js",
		"com.liferay.portlet.footer-portlet-css=/plugins/toastr/toastr.min.css",
		"com.liferay.portlet.footer-portlet-javascript=/plugins/jquery/jquery.priceformat.js",
		"com.liferay.portlet.footer-portlet-javascript=/plugins/jquery-ui/jquery-ui.min.js",
		"com.liferay.portlet.footer-portlet-css=/plugins/jquery-ui/jquery-ui.min.css",
		"com.liferay.portlet.footer-portlet-javascript=/plugins/jquery/jquery.ui.datepicker-vi.js",
		"com.liferay.portlet.footer-portlet-javascript=/plugins/jquery/jquery.mask.min.js",
		"com.liferay.portlet.footer-portlet-javascript=/plugins/select2/select2.js",
		"com.liferay.portlet.footer-portlet-css=/plugins/select2/select2.css",
		"javax.portlet.security-role-ref=power-user,user",
		"com.liferay.portlet.footer-portlet-javascript=/js/main.js", }, service = Portlet.class)
public class ThuPhatChiNgayPortlet extends MVCPortlet {
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		String resourceId = resourceRequest.getResourceID();
		JSONObject kq = JSONFactoryUtil.createJSONObject();
		ServiceContext serviceContext = new ServiceContext();
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		serviceContext.setScopeGroupId(themeDisplay.getScopeGroupId());
		serviceContext.setCompanyId(themeDisplay.getCompanyGroupId());
		serviceContext.setUserId(themeDisplay.getUserId());
		if (resourceId.equals("inThuPhatChiNgay")) {
			kq = inThuPhatChiNgay(resourceRequest, resourceResponse, serviceContext);
		}
		PrintWriter writer = resourceResponse.getWriter();
		writer.print(kq.toString());
		writer.flush();
		writer.close();

	}

	public JSONObject inThuPhatChiNgay(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ServiceContext serviceContext) throws IOException {
		JSONObject kq = JSONFactoryUtil.createJSONObject();
		String maCTV = ParamUtil.getString(resourceRequest, "maCTV");
		int typeIn = ParamUtil.getInteger(resourceRequest, "typeIn");
		long ngayTuTime = ParamUtil.getLong(resourceRequest, "ngayTuTime");
		Date ngayBatDauTu = ngayTuTime != 0 ? new Date(ngayTuTime) : null;
		CongTacVienComparator obc = new CongTacVienComparator("createdate", true);
		List<CongTacVien> items = CongTacVienLocalServiceUtil.findBase(maCTV, "", "", "", 1, -1, -1, obc);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("###,###.###");
		if (CollectionUtils.isNotEmpty(items)) {
			try {
				InputStream in = null;
				OutputStream outStream = resourceResponse.getPortletOutputStream();
				resourceResponse.setContentType("application/XLSX");
				String tenFile = typeIn == 1 ? "TONGHOP_THUPHATCHI.docx" : "TONGHOP_THUPHATCHI.xlsx";
				resourceResponse.setProperty("Content-Disposition", "attachment; filename=\"" + tenFile + "\"");
				in = getServletContext().getResourceAsStream("report/TONG_HOP_THU_PHAT_CHI.jasper");
				Map<String, Object> parameters = new HashMap<String, Object>();
				Collection<Object> collections = new ArrayList<Object>();
				parameters.put("ngayIn", sdf.format(new Date()));
				if (ngayBatDauTu != null) {
					parameters.put("ngayThongKe", sdf.format(ngayBatDauTu));
				}
				int index = 0;
				Double tongTienAll = GetterUtil.getDouble("0");
				Double tongTienVonAll = GetterUtil.getDouble("0");
				Double tongTienLaiAll = GetterUtil.getDouble("0");
				for (CongTacVien item : items) {
					index++;
					LichSuThuPhatChiComparator comparator = new LichSuThuPhatChiComparator("createdate", true);
					List<LichSuThuPhatChi> lichSuThuPhatChis = LichSuThuPhatChiLocalServiceUtil
							.findByCTV_Loai_Createdate(item.getMa(), 0, ngayBatDauTu, ngayBatDauTu, -1, -1,
									comparator);
					List<LichSuThuPhatChDTO> lichSuThuPhatChDTOs = new ArrayList<LichSuThuPhatChDTO>();
					Double tongTien = GetterUtil.getDouble("0");
					Double tongTienVon = GetterUtil.getDouble("0");
					Double tongTienLai = GetterUtil.getDouble("0");
					if (CollectionUtils.isNotEmpty(lichSuThuPhatChis)) {
						Double tienVonPV = GetterUtil.getDouble("0");
					 	Double tienLaiPV = GetterUtil.getDouble("0");
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
						for (LichSuThuPhatChi lichSuThuPhatChi : lichSuThuPhatChis) {
							tongTien += lichSuThuPhatChi.getSoTien();
							tongTienVon += lichSuThuPhatChi.getTongSoTienVonTra();
							tongTienLai += lichSuThuPhatChi.getTongSoTienLaiTra();
							if(lichSuThuPhatChi.getLoai() == 1){
				 				tienVonPV += lichSuThuPhatChi.getTongSoTienVonTra();
				 				tienLaiPV += lichSuThuPhatChi.getTongSoTienLaiTra();
				 				tongTienPV += lichSuThuPhatChi.getSoTien();
				 			}else if(lichSuThuPhatChi.getLoai() == 2){
				 				tienVonTT += lichSuThuPhatChi.getTongSoTienVonTra();
				 				tienLaiTT += lichSuThuPhatChi.getTongSoTienLaiTra();
				 				tongTienTT += lichSuThuPhatChi.getSoTien();
				 			}else if(lichSuThuPhatChi.getLoai() == 3){
				 				tienVonTHN += lichSuThuPhatChi.getTongSoTienVonTra();
				 				tienLaiTHN += lichSuThuPhatChi.getTongSoTienLaiTra();
				 				tongTienTHN += lichSuThuPhatChi.getSoTien();
				 			}else if(lichSuThuPhatChi.getLoai() == 4){
				 				tienVonThuTruoc += lichSuThuPhatChi.getTongSoTienVonTra();
				 				tienLaiThuTruoc += lichSuThuPhatChi.getTongSoTienLaiTra();
				 				tongTienThuTruoc += lichSuThuPhatChi.getSoTien();
				 			}
						}
				 		if(tongTienPV > 0){
				 			LichSuThuPhatChDTO phatVay = new LichSuThuPhatChDTO("","phat-vay", ngayBatDauTu != null ? sdf.format(ngayBatDauTu) : "", tongTienPV > 0 ? df.format(tongTienPV) : "0",tienVonPV > 0 ? df.format(tienVonPV) : "0",tienLaiPV > 0 ? df.format(tienLaiPV) : "0");
					 		lichSuThuPhatChDTOs.add(phatVay);
				 		}
				 		if(tongTienTT > 0){
					 		LichSuThuPhatChDTO tatToan = new LichSuThuPhatChDTO("","tat-toan", ngayBatDauTu != null ? sdf.format(ngayBatDauTu) : "", tongTienTT > 0 ? df.format(tongTienTT) : "0",tienVonTT > 0 ? df.format(tienVonTT) : "0",tienLaiTT > 0 ? df.format(tienLaiTT) : "0");
					 		lichSuThuPhatChDTOs.add(tatToan);
				 		}
				 		if(tongTienTHN > 0){
					 		LichSuThuPhatChDTO thuHangNgay = new LichSuThuPhatChDTO("","thu-hang-ngay", ngayBatDauTu != null ? sdf.format(ngayBatDauTu) : "", tongTienTHN > 0 ? df.format(tongTienTHN) : "0",tienVonTHN > 0 ? df.format(tienVonTHN) : "0",tienLaiTHN > 0 ? df.format(tienLaiTHN) : "0");
					 		lichSuThuPhatChDTOs.add(thuHangNgay);
				 		}
				 		if(tongTienThuTruoc > 0){
					 		LichSuThuPhatChDTO thuTruoc = new LichSuThuPhatChDTO("","thu-tien-tet", ngayBatDauTu != null ? sdf.format(ngayBatDauTu) : "", tongTienThuTruoc > 0 ? df.format(tongTienThuTruoc) : "0",tienVonThuTruoc > 0 ? df.format(tienVonThuTruoc) : "0",tienLaiThuTruoc > 0 ? df.format(tienLaiThuTruoc) : "0");
					 		lichSuThuPhatChDTOs.add(thuTruoc);
				 		}
					}
					LichSuThuPhatChDTO lsCTV = new LichSuThuPhatChDTO(String.valueOf(index), item.getHoTen(), "", tongTien > 0 ? df.format(tongTien) : "", tongTienVon > 0 ? df.format(tongTienVon) : "",tongTienLai > 0 ? df.format(tongTienLai) : "");
					collections.add(lsCTV);
					collections.addAll(lichSuThuPhatChDTOs);
					tongTienAll += tongTien;
					tongTienVonAll += tongTienVon;
					tongTienLaiAll += tongTienLai;
				}
				parameters.put("tongVon", tongTienVonAll > 0 ? df.format(tongTienVonAll) : "");
				parameters.put("tongLai", tongTienLaiAll > 0 ? df.format(tongTienLaiAll) : "");
				parameters.put("tongSoTien", tongTienAll > 0 ? df.format(tongTienAll) : "");
				JasperReportUtil.exportReport(in, outStream, parameters, collections,
						typeIn == 1 ? FileType.DOCX : FileType.XLSX);
				outStream.flush();
			} catch (Exception e) {
				e.printStackTrace();
				kq.putException(e);
			} finally {
			}
		}
		return kq;
	}

}