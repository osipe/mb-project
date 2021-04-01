package quanly.portlet.phatvay.thutienhangngay_thue;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
import com.liferay.portal.kernel.util.CalendarUtil;
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
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;
import quanly.constants.QuanlyPortletKeys;
import quanly.constants.TrangThaiPhatVayEnum;
import quanly.dto.BangKeDTO;
import quanly.dto.CongTacVienBangKe;
import quanly.dto.CongTacVienDTO;
import quanly.portlet.danhmuc.ctv.CongTacVienComparator;
import quanly.util.DocSo;

/**
 * @author Annn
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/html/phatvay/thutienhangngay_thue/view.jsp",
		"javax.portlet.display-name=" + QuanlyPortletKeys.thuTienHangNgay_Thue,
		"javax.portlet.name=" + QuanlyPortletKeys.thuTienHangNgay_Thue,
		"javax.portlet.resource-bundle=content.Language",
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
public class ThuTienHangNgay_ThuePortlet extends MVCPortlet {
	private static long time1Ngay = 86399990;

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
		if (resourceId.equals("thuTienURL")) {
			kq = thuTienURL(resourceRequest, resourceResponse, serviceContext);
		} else if (resourceId.equals("printPhieuThuTienHangNgay")) {
			kq = printPhieuThuTienHangNgay(resourceRequest, resourceResponse, serviceContext);
		} else if (resourceId.equals("thuTienTruocURL")) {
			kq = thuTienTruocURL(resourceRequest, resourceResponse, serviceContext);
		} else if (resourceId.equals("printPhieuThuTienTruoc")) {
			kq = printPhieuThuTienTruoc(resourceRequest, resourceResponse, serviceContext);
		} else if (resourceId.equals("printBangKeThue")) {
			kq = printBangKeThue(resourceRequest, resourceResponse, serviceContext);
		}
		PrintWriter writer = resourceResponse.getWriter();
		writer.print(kq.toString());
		writer.flush();
		writer.close();

	}

	private JSONObject getSoNgayPhaiThu(Date ngayThuTien, PhatVay pv) {
		JSONObject result = JSONFactoryUtil.createJSONObject();

		Calendar ngayBatDau = Calendar.getInstance();
		ngayBatDau.setTime(pv.getNgayBatDau());
		Calendar ngayKetThuc = Calendar.getInstance();
		ngayKetThuc.setTime(pv.getNgayKetThuc());

		List<CauHinhThuTienTruoc> cauHinhs = CauHinhThuTienTruocLocalServiceUtil.findAll();

		Calendar ngayThuTienCal = Calendar.getInstance();
		ngayThuTienCal.setTime(ngayThuTien);
		int soNgayKhongThu = 0;

		if (CollectionUtils.isNotEmpty(cauHinhs)) {
			Calendar ngayBatDauThuTet = Calendar.getInstance();
			ngayBatDauThuTet.setTime(cauHinhs.get(0).getNgayTu());
			Calendar ngayKetThucThuTet = Calendar.getInstance();
			ngayKetThucThuTet.setTime(cauHinhs.get(0).getNgayDen());

			Date ngayStart = null;
			Date ngayEnd = null;
			// Xác định những ngày thu tiền tết có trong phát vay
			if (CalendarUtil.getGTDate(ngayBatDauThuTet).getTime() <= CalendarUtil.getGTDate(ngayBatDau).getTime()) {
				if (CalendarUtil.getLTDate(ngayKetThucThuTet).getTime() >= CalendarUtil.getGTDate(ngayBatDau)
						.getTime()) {
					if (CalendarUtil.getLTDate(ngayKetThucThuTet).getTime() <= CalendarUtil.getLTDate(ngayKetThuc)
							.getTime()) {
						ngayStart = CalendarUtil.getGTDate(ngayBatDau);
						ngayEnd = CalendarUtil.getLTDate(ngayKetThucThuTet);
					} else {
						ngayStart = CalendarUtil.getGTDate(ngayBatDau);
						ngayEnd = CalendarUtil.getLTDate(ngayKetThuc);
					}
				} else {
					// Thu tiền tết nằm ngoài phát vay
				}
			} else if (CalendarUtil.getGTDate(ngayBatDauThuTet).getTime() <= CalendarUtil.getLTDate(ngayKetThuc)
					.getTime()) {
				if (CalendarUtil.getLTDate(ngayKetThucThuTet).getTime() <= CalendarUtil.getLTDate(ngayKetThuc)
						.getTime()) {
					ngayStart = CalendarUtil.getGTDate(ngayBatDauThuTet);
					ngayEnd = CalendarUtil.getLTDate(ngayKetThucThuTet);
				} else {
					ngayStart = CalendarUtil.getGTDate(ngayBatDauThuTet);
					ngayEnd = CalendarUtil.getLTDate(ngayKetThuc);
				}
			} else {
				// Thu tiền tết nằm ngoài phát vay
			}

			// Xác định những ngày thu tiền tết có trong phát vay - có trong ngày thu tiền
			if (ngayStart != null && ngayEnd != null) {
				if (CalendarUtil.getGTDate(ngayThuTienCal).getTime() >= ngayStart.getTime()) {
					if (CalendarUtil.getLTDate(ngayThuTienCal).getTime() <= ngayEnd.getTime()) {
						soNgayKhongThu = (int) ((CalendarUtil.getLTDate(ngayThuTienCal).getTime() - ngayStart.getTime())
								/ time1Ngay);
					} else {
						soNgayKhongThu = (int) ((ngayEnd.getTime() - ngayStart.getTime()) / time1Ngay);
					}
				} else {
					// Ngày thu tiền chưa đến thời gian thu tiền tết
				}
			}

		}

		int soNgayPhaiThu = 0;

		if (CalendarUtil.getLTDate(ngayThuTienCal).getTime() > CalendarUtil.getGTDate(ngayBatDau).getTime()) {
			if (CalendarUtil.getLTDate(ngayThuTienCal).getTime() <= CalendarUtil.getLTDate(ngayKetThuc).getTime()) {
				soNgayPhaiThu = (int) ((CalendarUtil.getLTDate(ngayThuTienCal).getTime()
						- CalendarUtil.getGTDate(ngayBatDau).getTime()) / time1Ngay);
			} else {
				soNgayPhaiThu = (int) ((CalendarUtil.getLTDate(ngayKetThuc).getTime()
						- CalendarUtil.getGTDate(ngayBatDau).getTime()) / time1Ngay);
			}
		} else {
			soNgayPhaiThu = 0;
		}
		if (soNgayPhaiThu > soNgayKhongThu) {
			result.put("soNgayThu", soNgayPhaiThu - soNgayKhongThu);
		} else {
			result.put("soNgayThu", 0);
		}
		int tongSoNgayDaThu = soNgayPhaiThu - soNgayKhongThu + pv.getSoNgayThuTruoc();

		if (tongSoNgayDaThu == pv.getThoiHan()) {
			result.put("daThanhToan", true);
		}
		return result;
	}

	public JSONObject thuTienURL(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ServiceContext serviceContext) {
		JSONObject kq = JSONFactoryUtil.createJSONObject();
		long ngayThuTienTime = ParamUtil.getLong(resourceRequest, "ngayThuTien");
		Date ngayThuTien = ngayThuTienTime != 0 ? new Date(ngayThuTienTime) : null;
		String maCTVSearch = ParamUtil.getString(resourceRequest, "maCTVSearch");
		if (Validator.isNotNull(ngayThuTien)) {
			try {
				List<CongTacVien> items = CongTacVienLocalServiceUtil.findBase(maCTVSearch, "", "", "", 1, -1, -1,
						null);
				for (CongTacVien item : items) {
					List<PhatVay> phatVays = PhatVayLocalServiceUtil.findCTV_NgayThuTien(item.getMa(), ngayThuTien);
					Double tongVonTra = GetterUtil.getDouble("0");
					Double tongLaiTra = GetterUtil.getDouble("0");
					if (CollectionUtils.isNotEmpty(phatVays)) {
						for (PhatVay pv : phatVays) {
							Double vonTra = GetterUtil.getDouble("0");
							Double laiTra = GetterUtil.getDouble("0");

							JSONObject thongTinThanhToan = getSoNgayPhaiThu(ngayThuTien, pv);
							if (thongTinThanhToan.getBoolean("daThanhToan")) {
								pv.setTrangThai(TrangThaiPhatVayEnum.DA_THANH_TOAN.getValue());
								vonTra = pv.getSoTienVay()
										- ((pv.getSoLanDaThu() + pv.getSoNgayThuTruoc()) * pv.getGocNgay());
							} else {
								vonTra = ((thongTinThanhToan.getInt("soNgayThu") - pv.getSoLanDaThu())
										* pv.getGocNgay());
							}

							laiTra = ((thongTinThanhToan.getInt("soNgayThu") - pv.getSoLanDaThu()) * pv.getLaiNgay());
							Calendar calNgayThuTien = Calendar.getInstance();
							calNgayThuTien.setTime(ngayThuTien);
							Calendar calKetThuc = Calendar.getInstance();
							calKetThuc.setTime(pv.getNgayKetThuc());
							if (CalendarUtil.getLTDate(calNgayThuTien).getTime() >= CalendarUtil.getLTDate(calKetThuc)
									.getTime()) {
								pv.setNgayDaThuCuoi(CalendarUtil.getLTDate(calKetThuc));
							} else {
								pv.setNgayDaThuCuoi(CalendarUtil.getLTDate(calNgayThuTien));
							}

							pv.setSoLanDaThu(thongTinThanhToan.getInt("soNgayThu"));
							tongVonTra += vonTra;
							tongLaiTra += laiTra;

							PhatVayLocalServiceUtil.addOrUpdatePhatVay(pv, serviceContext);
							LichSuThuPhatChi lichSuThuPhatChi = LichSuThuPhatChiLocalServiceUtil
									.createLichSuThuPhatChi(0L);
							lichSuThuPhatChi.setMaCTV(item.getMa());
							lichSuThuPhatChi.setPhatVayId(pv.getPhatVayId());
							lichSuThuPhatChi.setChiNhanhId(pv.getChiNhanhId());
							lichSuThuPhatChi.setLoai(3);
							lichSuThuPhatChi.setSoTien(vonTra + laiTra);
							lichSuThuPhatChi.setTongSoTienLaiTra(laiTra);
							lichSuThuPhatChi.setTongSoTienVonTra(vonTra);
							lichSuThuPhatChi.setTrangThaiPhatVayHienTai(pv.getTrangThai());
							lichSuThuPhatChi.setNgayXuLy(ngayThuTien);
							LichSuThuPhatChiLocalServiceUtil.addLichSuThuPhatChi(lichSuThuPhatChi, serviceContext);
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				kq.putException(e);
			}
		}
		return kq;
	}

	public JSONObject printBangKeThue(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ServiceContext serviceContext) throws IOException {
		JSONObject kq = JSONFactoryUtil.createJSONObject();
		long ngayThuTienTime = ParamUtil.getLong(resourceRequest, "ngayThuTien");
		Date ngayThuTien = ngayThuTienTime != 0 ? new Date(ngayThuTienTime) : null;
		String maCTVSearch = ParamUtil.getString(resourceRequest, "maCTVSearch");
		InputStream in = null;
		OutputStream outStream = resourceResponse.getPortletOutputStream();
		if (Validator.isNotNull(ngayThuTien)) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Locale localeEn = new Locale("en", "EN");
				NumberFormat df = NumberFormat.getInstance(localeEn);
				CongTacVienComparator obc = new CongTacVienComparator("ma", true);
				List<CongTacVien> items = CongTacVienLocalServiceUtil.findBase(maCTVSearch, "", "", "", 1, -1, -1, obc);
				List<CongTacVienBangKe> congTacVienBangKes = new ArrayList<CongTacVienBangKe>();

				for (CongTacVien item : items) {
					List<PhatVay> phatVays = PhatVayLocalServiceUtil.findCTV_NgayThuTien(item.getMa(), ngayThuTien);
					List<BangKeDTO> bangKeDTOs = new ArrayList<BangKeDTO>();
					if (CollectionUtils.isNotEmpty(phatVays)) {
						Double tongVon = GetterUtil.getDouble("0");
						Double tongLai = GetterUtil.getDouble("0");
						Double tongThue = GetterUtil.getDouble("0");
						int i = 0;
						for (PhatVay pv : phatVays) {
							i++;
							Double vonTra = GetterUtil.getDouble("0");
							Double laiTra = GetterUtil.getDouble("0");
							Double thueTra = GetterUtil.getDouble("0");
							JSONObject thongTinThanhToan = getSoNgayPhaiThu(ngayThuTien, pv);
							int soLanThuDotHienTai = thongTinThanhToan.getInt("soNgayThu") - pv.getSoLanDaThu();
							if (thongTinThanhToan.getBoolean("daThanhToan")) {
								vonTra = pv.getSoTienVay()
										- ((pv.getSoLanDaThu() + pv.getSoNgayThuTruoc()) * pv.getGocNgay());
							} else {
								vonTra = soLanThuDotHienTai * pv.getGocNgay();
							}
							laiTra = soLanThuDotHienTai * pv.getLaiNgay();
							thueTra = laiTra * 0.05;

							tongVon += vonTra;
							tongLai += laiTra;
							tongThue += thueTra;
						
							BangKeDTO bangKeDTO = new BangKeDTO(String.valueOf(i),pv.getKhachHang() != null ? pv.getKhachHang() .getHoTen() : "", df.format(vonTra), df.format(laiTra) , df.format(thueTra) , "");
							bangKeDTOs.add(bangKeDTO);
						}

						CongTacVienBangKe congTacVienBangKe = new CongTacVienBangKe(item.getHoTen(), item.getMa(),
								df.format(tongVon), df.format(tongLai), df.format(tongThue), bangKeDTOs);
						congTacVienBangKes.add(congTacVienBangKe);
					}
				}
				String nameFile = "BANG_KE_" + new SimpleDateFormat("ddMMyyyy").format(ngayThuTien);
				if (Validator.isNotNull(maCTVSearch)) {
					nameFile = "BANG_KE_" + maCTVSearch + "_" + new SimpleDateFormat("ddMMyyyy").format(ngayThuTien);
				}
				resourceResponse.setContentType("application/DOCX");
				resourceResponse.setProperty("Content-Disposition", "attachment; filename=\"" + nameFile + ".docx\"");
				in = getServletContext().getResourceAsStream("report/BANG_KE.docx");

				IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in, TemplateEngineKind.Velocity);
				IContext iContext = report.createContext();
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("ngayThongKe", sdf.format(ngayThuTien));

				FieldsMetadata metadata = new FieldsMetadata();
				report.setFieldsMetadata(metadata);
				iContext.putMap(map);
				iContext.put("ctvs", congTacVienBangKes);
				report.process(iContext, outStream);
			} catch (Exception e) {
				e.printStackTrace();
				kq.putException(e);
			} finally {
			}
		}
		outStream.flush();
		return kq;
	}

	public JSONObject printPhieuThuTienHangNgay(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ServiceContext serviceContext) throws IOException {
		JSONObject kq = JSONFactoryUtil.createJSONObject();
		long ngayThuTienTime = ParamUtil.getLong(resourceRequest, "ngayThuTien");
		Date ngayThuTien = ngayThuTienTime != 0 ? new Date(ngayThuTienTime) : null;
		String maCTVSearch = ParamUtil.getString(resourceRequest, "maCTVSearch");
		InputStream in = null;
		OutputStream outStream = resourceResponse.getPortletOutputStream();
		if (Validator.isNotNull(ngayThuTien)) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Locale localeEn = new Locale("en", "EN");
				NumberFormat df = NumberFormat.getInstance(localeEn);
				CongTacVienComparator obc = new CongTacVienComparator("ma", true);
				List<CongTacVien> items = CongTacVienLocalServiceUtil.findBase(maCTVSearch, "", "", "", 1, -1, -1, obc);
				List<CongTacVienDTO> congTacVienDTOs = new ArrayList<CongTacVienDTO>();
				for (CongTacVien item : items) {
					List<PhatVay> phatVays = PhatVayLocalServiceUtil.findCTV_NgayThuTien(item.getMa(), ngayThuTien);
					if (CollectionUtils.isNotEmpty(phatVays)) {
						Double tongVonTra = GetterUtil.getDouble("0");
						Double tongLaiTra = GetterUtil.getDouble("0");
						Double tongduNoGoc = GetterUtil.getDouble("0");

						for (PhatVay pv : phatVays) {
							Double vonTra = GetterUtil.getDouble("0");
							Double laiTra = GetterUtil.getDouble("0");
							JSONObject thongTinThanhToan = getSoNgayPhaiThu(ngayThuTien, pv);
							int soLanThuDotHienTai = thongTinThanhToan.getInt("soNgayThu") - pv.getSoLanDaThu();
							if (thongTinThanhToan.getBoolean("daThanhToan")) {
								vonTra = pv.getSoTienVay()
										- ((pv.getSoLanDaThu() + pv.getSoNgayThuTruoc()) * pv.getGocNgay());
							} else {
								vonTra = soLanThuDotHienTai * pv.getGocNgay();
							}
							laiTra = soLanThuDotHienTai * pv.getLaiNgay();

							tongVonTra += vonTra;
							tongLaiTra += laiTra;
							tongduNoGoc += (pv.getDuNoGoc() - vonTra);

						}

						congTacVienDTOs.add(new CongTacVienDTO(
								item.getMa() + "/" + new SimpleDateFormat("ddMMyyyy").format(ngayThuTien), item.getMa(),
								item.getHoTen(), item.getDiaChi(), df.format(tongVonTra).replaceAll(",", "."),
								df.format(tongLaiTra).replaceAll(",", "."),
								df.format(tongLaiTra + tongVonTra).replaceAll(",", "."),
								DocSo.docSo(GetterUtil.getLong(tongLaiTra + tongVonTra)),
								df.format(tongduNoGoc).replaceAll(",", "."), "", "", "", "", null, null,
								sdf.format(ngayThuTien).substring(0, 2), sdf.format(ngayThuTien).substring(3, 5),
								sdf.format(ngayThuTien).substring(6, 10)));
					}
				}
				String nameFile = "THU_TIEN_NGAY_" + new SimpleDateFormat("ddMMyyyy").format(ngayThuTien);
				if (Validator.isNotNull(maCTVSearch)) {
					nameFile = maCTVSearch + "_" + new SimpleDateFormat("ddMMyyyy").format(ngayThuTien);
				}
				resourceResponse.setContentType("application/DOCX");
				resourceResponse.setProperty("Content-Disposition", "attachment; filename=\"" + nameFile + ".docx\"");
				in = getServletContext().getResourceAsStream("report/MAU_THU_TIEN_HANG_NGAY.docx");

				IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in, TemplateEngineKind.Velocity);
				IContext iContext = report.createContext();
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("TRA_CUU", sdf.format(new Date()));
				map.put("TEN_CONG_TY", GetterUtil.getString(PropsUtil.get("thongtin.cty.ten")));
				map.put("DIA_CHI_CONG_TY", GetterUtil.getString(PropsUtil.get("thongtin.cty.diachi")));
				map.put("SO_DIEN_THOAI_CONG_TY", GetterUtil.getString(PropsUtil.get("thongtin.cty.sodienthoai")));

				FieldsMetadata metadata = new FieldsMetadata();
				metadata.addFieldAsList("ctvs.so");
				metadata.addFieldAsList("ctvs.maSo");
				metadata.addFieldAsList("ctvs.hoTen");
				metadata.addFieldAsList("ctvs.diaChi");
				metadata.addFieldAsList("ctvs.vonTra");
				metadata.addFieldAsList("ctvs.laiTra");
				metadata.addFieldAsList("ctvs.tongTien");
				metadata.addFieldAsList("ctvs.tongTienBangChu");
				metadata.addFieldAsList("ctvs.duNoGoc");
				report.setFieldsMetadata(metadata);
				iContext.putMap(map);
				iContext.put("ctvs", congTacVienDTOs);
				report.process(iContext, outStream);

			} catch (Exception e) {
				e.printStackTrace();
				kq.putException(e);
			} finally {
			}
		}
		outStream.flush();
		return kq;
	}

	public JSONObject thuTienTruocURL(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ServiceContext serviceContext) {
		JSONObject kq = JSONFactoryUtil.createJSONObject();
		long ngayThuTienTuTime = ParamUtil.getLong(resourceRequest, "ngayThuTienTuTime");
		long ngayThuTienDenTime = ParamUtil.getLong(resourceRequest, "ngayThuTienDenTime");
		Date ngayThuTienTu = ngayThuTienTuTime != 0 ? new Date(ngayThuTienTuTime) : null;
		Date ngayThuTienDen = ngayThuTienDenTime != 0 ? new Date(ngayThuTienDenTime) : null;
		String maCTV = ParamUtil.getString(resourceRequest, "maCTV");
		String phatVayIds = ParamUtil.getString(resourceRequest, "phatVayIds");
		if (Validator.isNotNull(maCTV) && ngayThuTienTu != null && ngayThuTienDen != null) {
			Calendar calTu = Calendar.getInstance();
			calTu.setTime(ngayThuTienTu);
			Calendar calDen = Calendar.getInstance();
			calDen.setTime(ngayThuTienDen);
			try {
				Double tongVonTra = GetterUtil.getDouble("0");
				Double tongLaiTra = GetterUtil.getDouble("0");
				String[] pvIds = phatVayIds.split(",");
				for (int i = 0; i < pvIds.length; i++) {
					if (Validator.isNotNull(pvIds[i]) && Long.valueOf(pvIds[i]) > 0) {
						PhatVay pv = PhatVayLocalServiceUtil.fetchPhatVay(Long.valueOf(pvIds[i]));
						if (pv != null) {
							Calendar calNgayKetThuc = Calendar.getInstance();
							calNgayKetThuc.setTime(pv.getNgayKetThuc());
							Calendar calNgayBatDau = Calendar.getInstance();
							calNgayBatDau.setTime(pv.getNgayBatDau());
							Double vonTra = GetterUtil.getDouble("0");
							Double laiTra = GetterUtil.getDouble("0");

							Date startDate = null;
							Date endDate = null;

							if (CalendarUtil.getGTDate(calTu).getTime() <= CalendarUtil.getGTDate(calNgayBatDau)
									.getTime()) {
								startDate = CalendarUtil.getGTDate(calNgayBatDau);
							} else {
								if (CalendarUtil.getGTDate(calTu).getTime() <= CalendarUtil.getLTDate(calNgayKetThuc)
										.getTime()) {
									startDate = CalendarUtil.getGTDate(calTu);
								}
							}
							if (CalendarUtil.getLTDate(calDen).getTime() >= CalendarUtil.getGTDate(calNgayBatDau)
									.getTime()) {
								endDate = CalendarUtil.getLTDate(calDen);
								if (endDate.getTime() >= CalendarUtil.getLTDate(calNgayKetThuc).getTime()) {
									endDate = CalendarUtil.getLTDate(calNgayKetThuc);
								}
							}

							if (startDate != null && endDate != null) {
								int soNgayThuTet = (int) ((endDate.getTime() - startDate.getTime()) / time1Ngay);
								if (soNgayThuTet + pv.getSoLanDaThu() == pv.getThoiHan()) {
									vonTra = pv.getDuNoGoc();
									pv.setTrangThai(TrangThaiPhatVayEnum.DA_THANH_TOAN.getValue());
								} else {
									vonTra = soNgayThuTet * pv.getGocNgay();
									if (soNgayThuTet > 0) {
										pv.setTrangThai(TrangThaiPhatVayEnum.CO_THU_TIEN_TRUOC.getValue());
									}

								}
								laiTra = soNgayThuTet * pv.getLaiNgay();
								tongVonTra += vonTra;
								tongLaiTra += laiTra;

								pv.setNgayThuTruocTu(startDate);
								pv.setNgayThuTruocDen(endDate);
								pv.setSoNgayThuTruoc(pv.getSoNgayThuTruoc() + soNgayThuTet);

								PhatVayLocalServiceUtil.addOrUpdatePhatVay(pv, serviceContext);
								LichSuThuPhatChi lichSuThuPhatChi = LichSuThuPhatChiLocalServiceUtil
										.createLichSuThuPhatChi(0L);
								lichSuThuPhatChi.setMaCTV(pv.getMaCTV());
								lichSuThuPhatChi.setPhatVayId(pv.getPhatVayId());
								lichSuThuPhatChi.setLoai(4);
								lichSuThuPhatChi.setSoTien(vonTra + laiTra);
								lichSuThuPhatChi.setChiNhanhId(pv.getChiNhanhId());
								lichSuThuPhatChi.setTongSoTienLaiTra(laiTra);
								lichSuThuPhatChi.setTongSoTienVonTra(vonTra);
								lichSuThuPhatChi.setTrangThaiPhatVayHienTai(pv.getTrangThai());
								LichSuThuPhatChiLocalServiceUtil.addLichSuThuPhatChi(lichSuThuPhatChi, serviceContext);
							}

						}

					}

				}

			} catch (Exception e) {
				e.printStackTrace();
				kq.putException(e);
			}
		}
		return kq;
	}

	public JSONObject printPhieuThuTienTruoc(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ServiceContext serviceContext) throws IOException {
		JSONObject kq = JSONFactoryUtil.createJSONObject();

		String phatVayIds = ParamUtil.getString(resourceRequest, "phatVayIds");
		long ngayThuTienTuTime = ParamUtil.getLong(resourceRequest, "ngayThuTienTuTime");
		long ngayThuTienDenTime = ParamUtil.getLong(resourceRequest, "ngayThuTienDenTime");
		Date ngayThuTienTu = ngayThuTienTuTime != 0 ? new Date(ngayThuTienTuTime) : null;
		Date ngayThuTienDen = ngayThuTienDenTime != 0 ? new Date(ngayThuTienDenTime) : null;
		String maCTVSearch = ParamUtil.getString(resourceRequest, "maCTVSearch");
		long chiNhanhId = ParamUtil.getLong(resourceRequest, "chiNhanhIdSearch");

		Calendar calTu = Calendar.getInstance();
		calTu.setTime(ngayThuTienTu);
		Calendar calDen = Calendar.getInstance();
		calDen.setTime(ngayThuTienDen);

		InputStream in = null;
		OutputStream outStream = resourceResponse.getPortletOutputStream();
		if (ngayThuTienTu != null && ngayThuTienDen != null) {
			try {
				CongTacVien ctv = CongTacVienLocalServiceUtil.fetchByMa(maCTVSearch);
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Locale localeEn = new Locale("en", "EN");
				NumberFormat df = NumberFormat.getInstance(localeEn);
				List<CongTacVienDTO> congTacVienDTOs = new ArrayList<CongTacVienDTO>();
				if (Validator.isNotNull(phatVayIds)) {
					Double tongVonTra = GetterUtil.getDouble("0");
					Double tongLaiTra = GetterUtil.getDouble("0");
					String ngayThuTienTruoc = sdf.format(ngayThuTienTu) + " - " + sdf.format(ngayThuTienDen);
					Object[] sums = LichSuThuPhatChiLocalServiceUtil.getTongLichSuTraTien_CTV_TAINGAY(chiNhanhId,
							maCTVSearch, new Date(), null, 0);
					Double tongSoTienvay = LichSuThuPhatChiLocalServiceUtil.getSoTienVay_CTV_TAINGAY(chiNhanhId,
							maCTVSearch, new Date());

					Double tongduNoGoc = tongSoTienvay - GetterUtil.getDouble(sums[2]);

					String[] pvIds = phatVayIds.split(",");
					for (int i = 0; i < pvIds.length; i++) {
						if (Validator.isNotNull(pvIds[i]) && Long.valueOf(pvIds[i]) > 0) {
							PhatVay pv = PhatVayLocalServiceUtil.fetchPhatVay(Long.valueOf(pvIds[i]));
							if (pv != null) {
								Calendar calNgayKetThuc = Calendar.getInstance();
								calNgayKetThuc.setTime(pv.getNgayKetThuc());
								Calendar calNgayBatDau = Calendar.getInstance();
								calNgayBatDau.setTime(pv.getNgayBatDau());
								Double vonTra = GetterUtil.getDouble("0");
								Double laiTra = GetterUtil.getDouble("0");

								Date startDate = null;
								Date endDate = null;

								if (CalendarUtil.getGTDate(calTu).getTime() <= CalendarUtil.getGTDate(calNgayBatDau)
										.getTime()) {
									if (CalendarUtil.getLTDate(calDen).getTime() >= CalendarUtil
											.getGTDate(calNgayBatDau).getTime()) {
										if (CalendarUtil.getLTDate(calDen).getTime() <= CalendarUtil
												.getLTDate(calNgayKetThuc).getTime()) {
											startDate = CalendarUtil.getGTDate(calNgayBatDau);
											endDate = CalendarUtil.getLTDate(calDen);
										} else {
											startDate = CalendarUtil.getGTDate(calNgayBatDau);
											endDate = CalendarUtil.getLTDate(calNgayKetThuc);
										}
									} else {
										// Thu tiền tết nằm ngoài phát vay
									}
								} else {
									if (CalendarUtil.getGTDate(calTu).getTime() <= CalendarUtil
											.getLTDate(calNgayKetThuc).getTime()) {
										if (CalendarUtil.getLTDate(calDen).getTime() <= CalendarUtil
												.getLTDate(calNgayKetThuc).getTime()) {
											startDate = CalendarUtil.getGTDate(calTu);
											endDate = CalendarUtil.getLTDate(calDen);
										} else {
											startDate = CalendarUtil.getGTDate(calTu);
											endDate = CalendarUtil.getLTDate(calNgayKetThuc);
										}
									} else {
										// Thu tiền tết nằm ngoài phát vay
									}
								}

								if (startDate != null && endDate != null) {
									int soNgayThuTet = (int) ((endDate.getTime() - startDate.getTime()) / time1Ngay);
									if (soNgayThuTet + pv.getSoLanDaThu() == pv.getThoiHan()) {
										vonTra = pv.getDuNoGoc();
									} else {
										vonTra = soNgayThuTet * pv.getGocNgay();
									}
									System.out.println(pv.getSoKU() + " : " + soNgayThuTet + " : " + vonTra);
									laiTra = soNgayThuTet * pv.getLaiNgay();
									tongVonTra += vonTra;
									tongLaiTra += laiTra;

									tongduNoGoc -= vonTra;
								}

							}

						}

					}
					congTacVienDTOs.add(new CongTacVienDTO(
							ctv.getMa() + "/" + new SimpleDateFormat("ddMMyyyy").format(new Date()), ctv.getMa(),
							ctv.getHoTen(), ctv.getDiaChi(), df.format(tongVonTra).replaceAll(",", "."),
							df.format(tongLaiTra).replaceAll(",", "."),
							df.format(tongLaiTra + tongVonTra).replaceAll(",", "."),
							DocSo.docSo(GetterUtil.getLong(tongLaiTra + tongVonTra)),
							df.format(tongduNoGoc).replaceAll(",", "."), ngayThuTienTruoc, "", "", "", null, null,
							sdf.format(new Date()).substring(0, 2), sdf.format(new Date()).substring(3, 5),
							sdf.format(new Date()).substring(6, 10)));

				}
				String nameFile = "THU_TIEN_TRUOC_NGAY_" + new SimpleDateFormat("ddMMyyyy").format(new Date());
				if (Validator.isNotNull(maCTVSearch)) {
					nameFile = maCTVSearch + "_" + new SimpleDateFormat("ddMMyyyy").format(new Date());
				}
				resourceResponse.setContentType("application/DOCX");
				resourceResponse.setProperty("Content-Disposition", "attachment; filename=\"" + nameFile + ".docx\"");
				in = getServletContext().getResourceAsStream("report/MAU_THU_TIEN_TRUOC.docx");

				IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in, TemplateEngineKind.Velocity);
				IContext iContext = report.createContext();
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("TEN_CONG_TY", GetterUtil.getString(PropsUtil.get("thongtin.cty.ten")));
				map.put("DIA_CHI_CONG_TY", GetterUtil.getString(PropsUtil.get("thongtin.cty.diachi")));
				map.put("SO_DIEN_THOAI_CONG_TY", GetterUtil.getString(PropsUtil.get("thongtin.cty.sodienthoai")));

				map.put("NGAY", Calendar.getInstance().get(Calendar.DATE));
				map.put("THANG", Calendar.getInstance().get(Calendar.MONTH) + 1);
				map.put("NAM", Calendar.getInstance().get(Calendar.YEAR));

				FieldsMetadata metadata = new FieldsMetadata();
				metadata.addFieldAsList("ctvs.so");
				metadata.addFieldAsList("ctvs.maSo");
				metadata.addFieldAsList("ctvs.hoTen");
				metadata.addFieldAsList("ctvs.diaChi");
				metadata.addFieldAsList("ctvs.vonTra");
				metadata.addFieldAsList("ctvs.laiTra");
				metadata.addFieldAsList("ctvs.tongTien");
				metadata.addFieldAsList("ctvs.tongTienBangChu");
				metadata.addFieldAsList("ctvs.duNoGoc");
				metadata.addFieldAsList("ctvs.ngayThuTienTruoc");
				report.setFieldsMetadata(metadata);
				iContext.putMap(map);
				iContext.put("ctvs", congTacVienDTOs);
				report.process(iContext, outStream);

			} catch (Exception e) {
				e.printStackTrace();
				kq.putException(e);
			} finally {
			}

		}
		outStream.flush();
		return kq;

	}
}