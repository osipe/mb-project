package quanly.portlet.thongke.thu_phat_chi_ngay;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
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
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.mb.model.CauHinhThuTienTruoc;
import com.mb.model.CongTacVien;
import com.mb.model.LichSuThuPhatChi;
import com.mb.model.PhatVay;
import com.mb.service.CauHinhThuTienTruocLocalServiceUtil;
import com.mb.service.CongTacVienLocalServiceUtil;
import com.mb.service.LichSuThuPhatChiLocalServiceUtil;
import com.mb.service.PhatVayLocalServiceUtil;

import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import quanly.constants.FileType;
import quanly.constants.QuanlyPortletKeys;
import quanly.constants.TrangThaiPhatVayEnum;
import quanly.dto.CongTacVienDTO;
import quanly.dto.LichSuThuPhatChDTO;
import quanly.portlet.danhmuc.cauhinhthutientruoc.CauHinhThuTienTruocComparator;
import quanly.util.DocSo;
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
		} else if (resourceId.equals("printPhieuThuTienHangNgay")) {
			kq = printPhieuThuTienHangNgay(resourceRequest, resourceResponse, serviceContext);
		} else if (resourceId.equals("xoaLichSuThuTienHangNgay")) {
			kq = xoaLichSuThuTienHangNgay(resourceRequest, resourceResponse, serviceContext);
		} else if (resourceId.equals("xoaThuTruoc")) {
			kq = xoaThuTruoc(resourceRequest, resourceResponse, serviceContext);
		} else if (resourceId.equals("printPhieuThuTienTruoc")) {
			kq = printPhieuThuTruoc(resourceRequest, resourceResponse, serviceContext);
		}
		PrintWriter writer = resourceResponse.getWriter();
		writer.print(kq.toString());
		writer.flush();
		writer.close();

	}

	private JSONObject getLichSuThanhToan(PhatVay pv) {
		JSONObject result = JSONFactoryUtil.createJSONObject();
		Object[] lsTraTien = LichSuThuPhatChiLocalServiceUtil
				.getTongLichSuTraTien_PhayVayId_ChiNhanhId_Loai(pv.getPhatVayId(), 0, 3);
		Object[] lsTraTienTraTienTruoc = LichSuThuPhatChiLocalServiceUtil
				.getTongLichSuTraTien_PhayVayId_ChiNhanhId_Loai(pv.getPhatVayId(), 0, 4);
		Double tongVonDaThu = GetterUtil.getDouble(lsTraTien[2]);
		int soNgayDaThu = GetterUtil.getInteger(tongVonDaThu / pv.getGocNgay());
		Double tongVonDaThuTruoc = GetterUtil.getDouble(lsTraTienTraTienTruoc[2]);
		int soNgayDaThuTruoc = GetterUtil.getInteger(tongVonDaThuTruoc / pv.getGocNgay());
		result.put("soNgayDaThu", soNgayDaThu);
		result.put("soNgayDaThuTruoc", soNgayDaThuTruoc);
		return result;
	}

	public JSONObject printPhieuThuTruoc(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ServiceContext serviceContext) throws IOException {
		JSONObject kq = JSONFactoryUtil.createJSONObject();
		Map<String, Object> map = new HashMap<String, Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		long ngayThuTienTime = ParamUtil.getLong(resourceRequest, "ngayThuTien");
		long ngayXuLyTime = ParamUtil.getLong(resourceRequest, "ngayXuLyTime");
		Date ngayThuTien = ngayThuTienTime != 0 ? new Date(ngayThuTienTime) : null;
		long chiNhanhId = ParamUtil.getLong(resourceRequest, "chiNhanhId");
		String maCTV = ParamUtil.getString(resourceRequest, "maCTV");
		InputStream in = null;
		OutputStream outStream = resourceResponse.getPortletOutputStream();
		try {
			Locale localeEn = new Locale("en", "EN");
			NumberFormat df = NumberFormat.getInstance(localeEn);
			List<CongTacVienDTO> congTacVienDTOs = new ArrayList<CongTacVienDTO>();
			List<CongTacVien> items = CongTacVienLocalServiceUtil.getCTVThuPhatChi(maCTV, ngayThuTien, ngayThuTien);
			for (CongTacVien ctv : items) {
				List<Object[]> lichSuThuPhatChDTOs = LichSuThuPhatChiLocalServiceUtil
						.getLichSuThuPhatChi_MaCTV_Createdate(ctv.getMa(), ngayThuTien);
				for (Object[] item : lichSuThuPhatChDTOs) {
					if (GetterUtil.getInteger(item[0]) == 4) {
						String ngayXuLyStr = GetterUtil.getString(item[1]);
						Double tongVonTra = GetterUtil.getDouble(item[2]);
						Double tongLaiTra = GetterUtil.getDouble(item[3]);
						Double soTienVay = LichSuThuPhatChiLocalServiceUtil.getSoTienVay_CTV_TAINGAY(chiNhanhId,
								ctv.getMa(), ngayThuTien);
						Object[] tongTienDaTra = LichSuThuPhatChiLocalServiceUtil
								.getTongLichSuTraTien_CTV_TAINGAY(chiNhanhId, ctv.getMa(), ngayThuTien, null, 0);

						Double tongduNoGoc = soTienVay - GetterUtil.getDouble(tongTienDaTra[2], 0.0);

						CongTacVienDTO ctvDTO = new CongTacVienDTO(ctv.getMa(), ctv.getMa(), ctv.getHoTen(),
								ctv.getDiaChi(), df.format(tongVonTra), df.format(tongLaiTra),
								df.format(tongLaiTra + tongVonTra),
								DocSo.docSo(GetterUtil.getLong(tongLaiTra + tongVonTra)), df.format(tongduNoGoc), "",
								"", "", "", null, null, "", "", "");
						congTacVienDTOs.add(ctvDTO);
					}
				}
			}

			String nameFile = "THU_TIEN_TRUOC_" + new SimpleDateFormat("ddMMyyyy").format(ngayThuTien);
			if (Validator.isNotNull(maCTV)) {
				nameFile = maCTV + "_" + new SimpleDateFormat("ddMMyyyy").format(ngayThuTien);
			}
			resourceResponse.setContentType("application/DOCX");
			resourceResponse.setProperty("Content-Disposition", "attachment; filename=\"" + nameFile + ".docx\"");
			in = getServletContext().getResourceAsStream("report/MAU_THU_TIEN_TRUOC.docx");

			IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in, TemplateEngineKind.Freemarker);
			IContext iContext = report.createContext();
			map.put("TEN_CONG_TY", GetterUtil.getString(PropsUtil.get("thongtin.cty.ten")));
			map.put("DIA_CHI_CONG_TY", GetterUtil.getString(PropsUtil.get("thongtin.cty.diachi")));
			map.put("SO_DIEN_THOAI_CONG_TY", GetterUtil.getString(PropsUtil.get("thongtin.cty.sodienthoai")));
			map.put("TRA_CUU", sdf.format(ngayThuTien));

			iContext.putMap(map);
			iContext.put("ctvs", congTacVienDTOs);
			report.process(iContext, outStream);

		} catch (Exception e) {
			e.printStackTrace();
			kq.putException(e);
		} finally {
		}
		outStream.flush();
		return kq;
	}

	public JSONObject xoaThuTruoc(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ServiceContext serviceContext) {
		JSONObject kq = JSONFactoryUtil.createJSONObject();
		String maCTV = ParamUtil.getString(resourceRequest, "maCTV");
		long ngayXuLyTime = ParamUtil.getLong(resourceRequest, "ngayXuLyTime");
		long ngayBatDauTuTime = ParamUtil.getLong(resourceRequest, "ngayBatDauTuTime");
		Date ngayBatDauTu = ngayBatDauTuTime != 0 ? new Date(ngayBatDauTuTime) : null;
		Date ngayXuLy = ngayXuLyTime != 0 ? new Date(ngayXuLyTime) : null;
		try {

			List<PhatVay> pv = LichSuThuPhatChiLocalServiceUtil.getPhatVayByCTV_Loai_Createdate_NgayXuLy(maCTV, 4,
					ngayBatDauTu, ngayBatDauTu, ngayXuLy, ngayXuLy, -1, -1);
			LichSuThuPhatChiLocalServiceUtil.deleteByCTV_Loai_Createdate_NgayXuLy(maCTV, 4, ngayBatDauTu, ngayBatDauTu,
					ngayXuLy, ngayXuLy);
			for (PhatVay item : pv) {
				JSONObject result = getLichSuThanhToan(item);
				item.setSoLanDaThu(result.getInt("soNgayDaThu"));
				item.setSoNgayThuTruoc(result.getInt("soNgayDaThuTruoc"));
				item.setNgayThuTruocTu(null);
				item.setNgayThuTruocDen(null);
				if (result.getInt("soNgayDaThuTruoc") > 0) {
					item.setTrangThai(TrangThaiPhatVayEnum.CO_THU_TIEN_TRUOC.getValue());
				} else {
					item.setTrangThai(TrangThaiPhatVayEnum.CHUA_THANH_TOAN.getValue());
				}
				PhatVayLocalServiceUtil.addOrUpdatePhatVay(item, serviceContext);
			}
		} catch (Exception e) {
			e.printStackTrace();
			kq.putException(e);
		}
		return kq;
	}

	public JSONObject xoaLichSuThuTienHangNgay(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ServiceContext serviceContext) {
		JSONObject kq = JSONFactoryUtil.createJSONObject();
		String maCTV = ParamUtil.getString(resourceRequest, "maCTV");
		long ngayXuLyTime = ParamUtil.getLong(resourceRequest, "ngayXuLyTime");
		long ngayBatDauTuTime = ParamUtil.getLong(resourceRequest, "ngayBatDauTu");
		Date ngayBatDauTu = ngayBatDauTuTime != 0 ? new Date(ngayBatDauTuTime) : null;
		Date ngayXuLy = ngayXuLyTime != 0 ? new Date(ngayXuLyTime) : null;
		try {

			List<PhatVay> pv = LichSuThuPhatChiLocalServiceUtil.getPhatVayByCTV_Loai_Createdate_NgayXuLy(maCTV, 3,
					ngayBatDauTu, ngayBatDauTu, ngayXuLy, ngayXuLy, -1, -1);
			LichSuThuPhatChiLocalServiceUtil.deleteByCTV_Loai_Createdate_NgayXuLy(maCTV, 3, ngayBatDauTu, ngayBatDauTu,
					ngayXuLy, ngayXuLy);
			for (PhatVay item : pv) {
				JSONObject result = getLichSuThanhToan(item);
				item.setSoLanDaThu(result.getInt("soNgayDaThu"));
				item.setSoNgayThuTruoc(result.getInt("soNgayDaThuTruoc"));
				List<CauHinhThuTienTruoc> cauHinhs = CauHinhThuTienTruocLocalServiceUtil.findBase(0, 1, -1, -1,
						new CauHinhThuTienTruocComparator("nam", false));
				if (result.getInt("soNgayDaThuTruoc") > 0) {
					Calendar cal = Calendar.getInstance();
					cal.setTime(item.getNgayBatDau());
					cal.add(Calendar.DATE, result.getInt("soNgayDaThu") - 1);
					Calendar ngayBatDauThuTet = Calendar.getInstance();
					ngayBatDauThuTet.setTime(cauHinhs.get(0).getNgayTu());
					Calendar ngayKetThucThuTet = Calendar.getInstance();
					ngayKetThucThuTet.setTime(cauHinhs.get(0).getNgayDen());
					if(cal.getTimeInMillis()<= ngayBatDauThuTet.getTimeInMillis()) {
						item.setNgayDaThuCuoi(cal.getTime());
					}else {
						cal.add(Calendar.DATE, result.getInt("soNgayDaThuTruoc"));
						item.setNgayDaThuCuoi(cal.getTime());
					}
					item.setTrangThai(TrangThaiPhatVayEnum.CO_THU_TIEN_TRUOC.getValue());
				} else {
					Calendar cal = Calendar.getInstance();
					cal.setTime(item.getNgayBatDau());
					cal.add(Calendar.DATE, result.getInt("soNgayDaThu") - 1);
					item.setNgayDaThuCuoi(cal.getTime());
					item.setTrangThai(TrangThaiPhatVayEnum.CHUA_THANH_TOAN.getValue());
				}
				PhatVayLocalServiceUtil.addOrUpdatePhatVay(item, serviceContext);
			}
		} catch (Exception e) {
			e.printStackTrace();
			kq.putException(e);
		}
		return kq;
	}

	public JSONObject printPhieuThuTienHangNgay(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ServiceContext serviceContext) throws IOException {
		JSONObject kq = JSONFactoryUtil.createJSONObject();
		Map<String, Object> map = new HashMap<String, Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		long ngayThuTienTime = ParamUtil.getLong(resourceRequest, "ngayThuTien");
		long ngayXuLyTime = ParamUtil.getLong(resourceRequest, "ngayXuLyTime");
		Date ngayThuTien = ngayThuTienTime != 0 ? new Date(ngayThuTienTime) : null;
		Date ngayXuLy = ngayXuLyTime != 0 ? new Date(ngayXuLyTime) : null;
		long chiNhanhId = ParamUtil.getLong(resourceRequest, "chiNhanhId");
		String maCTV = ParamUtil.getString(resourceRequest, "maCTV");
		InputStream in = null;
		OutputStream outStream = resourceResponse.getPortletOutputStream();
		try {
			Locale localeEn = new Locale("en", "EN");
			NumberFormat df = NumberFormat.getInstance(localeEn);
			List<CongTacVienDTO> congTacVienDTOs = new ArrayList<CongTacVienDTO>();
			List<CongTacVien> items = CongTacVienLocalServiceUtil.getCTVThuPhatChi(maCTV, ngayThuTien, ngayThuTien);
			for (CongTacVien ctv : items) {
				List<Object[]> lichSuThuPhatChDTOs = LichSuThuPhatChiLocalServiceUtil
						.getLichSuThuPhatChi_MaCTV_Createdate(ctv.getMa(), ngayThuTien);
				for (Object[] item : lichSuThuPhatChDTOs) {
					if (GetterUtil.getInteger(item[0]) == 3) {
						String ngayXuLyStr = GetterUtil.getString(item[1]);
						if (ngayXuLy == null || (ngayXuLy != null && sdf.format(ngayXuLy).equals(ngayXuLyStr))) {
							Double tongVonTra = GetterUtil.getDouble(item[2]);
							Double tongLaiTra = GetterUtil.getDouble(item[3]);
							Double soTienVay = LichSuThuPhatChiLocalServiceUtil.getSoTienVay_CTV_TAINGAY(chiNhanhId,
									ctv.getMa(), ngayThuTien);
							Object[] tongTienDaTra = LichSuThuPhatChiLocalServiceUtil.getTongLichSuTraTien_CTV_TAINGAY(
									chiNhanhId, ctv.getMa(), ngayThuTien, sdf.parse(ngayXuLyStr), 0);

							Double tongduNoGoc = soTienVay - GetterUtil.getDouble(tongTienDaTra[2], 0.0);

							CongTacVienDTO ctvDTO = new CongTacVienDTO(
									ctv.getMa() + "/" + new SimpleDateFormat("ddMMyyyy").format(sdf.parse(ngayXuLyStr)),
									ctv.getMa(), ctv.getHoTen(), ctv.getDiaChi(), df.format(tongVonTra),
									df.format(tongLaiTra), df.format(tongLaiTra + tongVonTra),
									DocSo.docSo(GetterUtil.getLong(tongLaiTra + tongVonTra)), df.format(tongduNoGoc),
									"", "", "", "", null, null, ngayXuLyStr.substring(0, 2),
									ngayXuLyStr.substring(3, 5), ngayXuLyStr.substring(6, 10));
							congTacVienDTOs.add(ctvDTO);
						}
					}
				}
			}

			String nameFile = "THU_TIEN_NGAY_" + new SimpleDateFormat("ddMMyyyy").format(ngayThuTien);
			if (Validator.isNotNull(maCTV)) {
				nameFile = maCTV + "_" + new SimpleDateFormat("ddMMyyyy").format(ngayThuTien);
			}
			resourceResponse.setContentType("application/DOCX");
			resourceResponse.setProperty("Content-Disposition", "attachment; filename=\"" + nameFile + ".docx\"");
			in = getServletContext().getResourceAsStream("report/MAU_THU_TIEN_HANG_NGAY.docx");

			IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in, TemplateEngineKind.Freemarker);
			IContext iContext = report.createContext();
			map.put("TEN_CONG_TY", GetterUtil.getString(PropsUtil.get("thongtin.cty.ten")));
			map.put("DIA_CHI_CONG_TY", GetterUtil.getString(PropsUtil.get("thongtin.cty.diachi")));
			map.put("SO_DIEN_THOAI_CONG_TY", GetterUtil.getString(PropsUtil.get("thongtin.cty.sodienthoai")));
			map.put("TRA_CUU", sdf.format(ngayThuTien));

			iContext.putMap(map);
			iContext.put("ctvs", congTacVienDTOs);
			report.process(iContext, outStream);

		} catch (Exception e) {
			e.printStackTrace();
			kq.putException(e);
		} finally {
		}
		outStream.flush();
		return kq;
	}

	public JSONObject inThuPhatChiNgay(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ServiceContext serviceContext) throws IOException {
		JSONObject kq = JSONFactoryUtil.createJSONObject();
		String maCTV = ParamUtil.getString(resourceRequest, "maCTV");
		int typeIn = ParamUtil.getInteger(resourceRequest, "typeIn");
		long ngayTuTime = ParamUtil.getLong(resourceRequest, "ngayTuTime");
		Date ngayBatDauTu = ngayTuTime != 0 ? new Date(ngayTuTime) : null;
		List<CongTacVien> items = CongTacVienLocalServiceUtil.getCTVThuPhatChi(maCTV, ngayBatDauTu, ngayBatDauTu);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale localeEn = new Locale("en", "EN");
		NumberFormat df = NumberFormat.getInstance(localeEn);
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
				Double tongTienChiAll = GetterUtil.getDouble("0");
				Double tongTienVonAll = GetterUtil.getDouble("0");
				Double tongTienLaiAll = GetterUtil.getDouble("0");
				for (CongTacVien item : items) {
					index++;
					Double tongTienChiCTV = GetterUtil.getDouble("0");
					Double tongTienVonCTV = GetterUtil.getDouble("0");
					Double tongTienLaiCTV = GetterUtil.getDouble("0");

					Double tienVonPV = GetterUtil.getDouble("0");
					Double tienLaiPV = GetterUtil.getDouble("0");
					Double tongTienPV = GetterUtil.getDouble("0");

					Double tienVonTT = GetterUtil.getDouble("0");
					Double tienLaiTT = GetterUtil.getDouble("0");

					Double tienVonTHN = GetterUtil.getDouble("0");
					Double tienLaiTHN = GetterUtil.getDouble("0");

					Double tienVonThuTruoc = GetterUtil.getDouble("0");
					Double tienLaiThuTruoc = GetterUtil.getDouble("0");
					LichSuThuPhatChiComparator comparator = new LichSuThuPhatChiComparator("createdate", true);
					List<LichSuThuPhatChi> lichSuThuPhatChis = LichSuThuPhatChiLocalServiceUtil
							.findByCTV_Loai_Createdate(item.getMa(), 0, ngayBatDauTu, ngayBatDauTu, -1, -1, comparator);
					List<LichSuThuPhatChDTO> lichSuThuPhatChDTOs = new ArrayList<LichSuThuPhatChDTO>();
					if (CollectionUtils.isNotEmpty(lichSuThuPhatChis)) {
						for (LichSuThuPhatChi lichSuThuPhatChi : lichSuThuPhatChis) {
							if (lichSuThuPhatChi.getLoai() == 1) {
								tienVonPV += lichSuThuPhatChi.getTongSoTienVonTra();
								tienLaiPV += lichSuThuPhatChi.getTongSoTienLaiTra();
								tongTienPV += lichSuThuPhatChi.getSoTien();
							} else if (lichSuThuPhatChi.getLoai() == 2) {
								tienVonTT += lichSuThuPhatChi.getTongSoTienVonTra();
								tienLaiTT += lichSuThuPhatChi.getTongSoTienLaiTra();
							} else if (lichSuThuPhatChi.getLoai() == 3) {
								tienVonTHN += lichSuThuPhatChi.getTongSoTienVonTra();
								tienLaiTHN += lichSuThuPhatChi.getTongSoTienLaiTra();
							} else if (lichSuThuPhatChi.getLoai() == 4) {
								tienVonThuTruoc += lichSuThuPhatChi.getTongSoTienVonTra();
								tienLaiThuTruoc += lichSuThuPhatChi.getTongSoTienLaiTra();
							}
						}
						if (tongTienPV > 0) {
							LichSuThuPhatChDTO phatVay = new LichSuThuPhatChDTO("", PropsUtil.get("phat-vay"),
									ngayBatDauTu != null ? sdf.format(ngayBatDauTu) : "",
									tongTienPV > 0 ? df.format(tongTienPV) : "0",
									tienVonPV > 0 ? df.format(tienVonPV) : "0",
									tienLaiPV > 0 ? df.format(tienLaiPV) : "0", "0", 1);
							lichSuThuPhatChDTOs.add(phatVay);
						}
						if ((tienVonTT + tienLaiTT) > 0) {
							LichSuThuPhatChDTO tatToan = new LichSuThuPhatChDTO("", PropsUtil.get("tat-toan"),
									ngayBatDauTu != null ? sdf.format(ngayBatDauTu) : "", "0", tienVonTT > 0 ? df.format(tienVonTT) : "0",
									tienLaiTT > 0 ? df.format(tienLaiTT) : "0", df.format(tienLaiTT + tienVonTT), 2);
							lichSuThuPhatChDTOs.add(tatToan);
						}
						if ((tienVonTHN + tienLaiTHN) > 0) {
							LichSuThuPhatChDTO thuHangNgay = new LichSuThuPhatChDTO("", PropsUtil.get("thu-hang-ngay"),
									ngayBatDauTu != null ? sdf.format(ngayBatDauTu) : "", "0",
									tienVonTHN > 0 ? df.format(tienVonTHN) : "0",
									tienLaiTHN > 0 ? df.format(tienLaiTHN) : "0", df.format(tienLaiTHN + tienVonTHN),
									3);
							lichSuThuPhatChDTOs.add(thuHangNgay);
						}
						if ((tienVonThuTruoc + tienLaiThuTruoc) > 0) {
							LichSuThuPhatChDTO thuTruoc = new LichSuThuPhatChDTO("", PropsUtil.get("thu-tien-truoc"),
									ngayBatDauTu != null ? sdf.format(ngayBatDauTu) : "", "0", tienVonThuTruoc > 0 ? df.format(tienVonThuTruoc) : "0",
									tienLaiThuTruoc > 0 ? df.format(tienLaiThuTruoc) : "0",
									df.format(tienVonThuTruoc + tienLaiThuTruoc), 4);
							lichSuThuPhatChDTOs.add(thuTruoc);
						}
					}
					tongTienChiCTV = tongTienPV;
					tongTienVonCTV = tienVonTT + tienVonTHN + tienVonThuTruoc;
					tongTienLaiCTV = tienLaiTT + tienLaiTHN + tienLaiThuTruoc;

					tongTienChiAll += tongTienChiCTV;
					tongTienVonAll += tongTienVonCTV;
					tongTienLaiAll += tongTienLaiCTV;

					LichSuThuPhatChDTO lsCTV = new LichSuThuPhatChDTO(String.valueOf(index), item.getHoTen(), "",
							tongTienChiCTV > 0 ? df.format(tongTienChiCTV) : "",
							tongTienVonCTV > 0 ? df.format(tongTienVonCTV) : "",
							tongTienLaiCTV > 0 ? df.format(tongTienLaiCTV) : "",
							df.format(tongTienVonCTV + tongTienLaiCTV), 0);
					collections.add(lsCTV);
					collections.addAll(lichSuThuPhatChDTOs);
				}
				parameters.put("tongVon", tongTienVonAll > 0 ? df.format(tongTienVonAll) : "");
				parameters.put("tongLai", tongTienLaiAll > 0 ? df.format(tongTienLaiAll) : "");
				parameters.put("tongThu", df.format(tongTienVonAll + tongTienLaiAll));
				parameters.put("tongChi", df.format(tongTienChiAll));
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