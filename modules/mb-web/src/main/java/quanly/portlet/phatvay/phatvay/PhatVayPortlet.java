package quanly.portlet.phatvay.phatvay;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.json.JSONArray;
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
import com.mb.exception.TrungMaException;
import com.mb.exception.TrungSoCMNDException;
import com.mb.model.CongTacVien;
import com.mb.model.KhachHang;
import com.mb.model.LaiSuat;
import com.mb.model.LoaiTaiSan;
import com.mb.model.PhatVay;
import com.mb.model.SoKheUoc;
import com.mb.service.CongTacVienLocalServiceUtil;
import com.mb.service.KhachHangLocalServiceUtil;
import com.mb.service.LaiSuatLocalServiceUtil;
import com.mb.service.LoaiTaiSanLocalServiceUtil;
import com.mb.service.PhatVayLocalServiceUtil;
import com.mb.service.SoKheUocLocalServiceUtil;

import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import quanly.constants.QuanlyPortletKeys;
import quanly.constants.TrangThaiPhatVayEnum;
import quanly.util.DocSo;

/**
 * @author Annn
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/html/phatvay/phatvay/view.jsp",
		"javax.portlet.display-name=" + QuanlyPortletKeys.phatVay, "javax.portlet.name=" + QuanlyPortletKeys.phatVay,
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
public class PhatVayPortlet extends MVCPortlet {
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
		if (resourceId.equals("save")) {
			kq = save(resourceRequest, resourceResponse, serviceContext);
		} else if (resourceId.equals("addKhachHangURL")) {
			kq = addKhachHangURL(resourceRequest, resourceResponse, serviceContext);
		} else if (resourceId.equals("hoatDongURL")) {
			kq = hoatDongURL(resourceRequest, resourceResponse, serviceContext);
		} else if (resourceId.equals("getKhachHangByCongTacVien")) {
			kq = getKhachHang(resourceRequest, resourceResponse, serviceContext);
		} else if (resourceId.equals("getThongTinLaiSuat")) {
			kq = getThongTinLaiSuat(resourceRequest, resourceResponse, serviceContext);
		} else if (resourceId.equals("getLoaiTaiSan")) {
			kq = getLoaiTaiSan(resourceRequest, resourceResponse, serviceContext);
		} else if (resourceId.equals("getNgayKetThuc")) {
			kq = getNgayKetThuc(resourceRequest, resourceResponse, serviceContext);
		} else if (resourceId.equals("inPhieuThu")) {
			kq = inPhieuThu(resourceRequest, resourceResponse, serviceContext);
		} else if (resourceId.equals("xoaURL")) {
			kq = xoaURL(resourceRequest, resourceResponse, serviceContext);
		} else if (resourceId.equals("checkPhatVayKhachHang")) {
			kq = checkPhatVayKhachHang(resourceRequest, resourceResponse, serviceContext);
		}
		PrintWriter writer = resourceResponse.getWriter();
		writer.print(kq.toString());
		writer.flush();
		writer.close();

	}
	public JSONObject checkPhatVayKhachHang(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ServiceContext serviceContext) {
		JSONObject kq = JSONFactoryUtil.createJSONObject();
		try {
			String maCTV = ParamUtil.getString(resourceRequest, "maCTV");
			String maKhachHang = ParamUtil.getString(resourceRequest, "maKhachHang");
			int soPhatVay = PhatVayLocalServiceUtil.countBase("", maCTV, maKhachHang, null, null, null, null, null,
					null, "1,4");
			kq.put("soPhatVayChuaTatToan", soPhatVay);
		}catch (Exception e) {
			kq.putException(e);
		}
		return kq;
	}

	public JSONObject addKhachHangURL(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ServiceContext serviceContext) {
		JSONObject kq = JSONFactoryUtil.createJSONObject();
		try {
			long khachHangId = ParamUtil.getLong(resourceRequest, "khachHangId");
			String ma = ParamUtil.getString(resourceRequest, "ma");
			String maCTV = ParamUtil.getString(resourceRequest, "maCTV");
			String hoTen = ParamUtil.getString(resourceRequest, "hoTen");
			String soCMND = ParamUtil.getString(resourceRequest, "soCMND");
			String diaChi = ParamUtil.getString(resourceRequest, "diaChi");
			KhachHang kh = KhachHangLocalServiceUtil.createKhachHang(0L);
			boolean hoatDong = true;
			if (khachHangId > 0) {
				kh = KhachHangLocalServiceUtil.fetchKhachHang(khachHangId);
				hoatDong = kh.getHoatDong();
			}
			kh.setMa(ma);
			kh.setMaCTV(maCTV);
			kh.setHoTen(hoTen);
			kh.setSoCMND(soCMND);
			kh.setDiaChi(diaChi);
			kh.setHoatDong(hoatDong);
			KhachHangLocalServiceUtil.addOrUpdateKhachHang(kh, serviceContext);
		} catch (TrungSoCMNDException e) {
			kq.putException(e);
		} catch (TrungMaException e) {
			kq.putException(e);
		} catch (Exception e) {
			e.printStackTrace();
			kq.putException(e);
		}
		return kq;
	}

	public JSONObject inPhieuThu(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ServiceContext serviceContext) throws IOException {
		JSONObject kq = JSONFactoryUtil.createJSONObject();
		int soNgayTatToan = ParamUtil.getInteger(resourceRequest, "soNgayTatToan");
		long phatVayId = ParamUtil.getLong(resourceRequest, "phatVayId");
		InputStream in = null;
		OutputStream outStream = resourceResponse.getPortletOutputStream();
		if (phatVayId > 0) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Locale localeEn = new Locale("en", "EN");
			    NumberFormat df = NumberFormat.getInstance(localeEn);
				PhatVay phatVay = PhatVayLocalServiceUtil.fetchPhatVay(phatVayId);
				Date ngayIn = new Date();
				if (phatVay != null) {
					Double tongSoTienPhaiThu = GetterUtil.getDouble(0);
					Double soTienGocPhaiThu = GetterUtil.getDouble(0);
					Double soTienLaiPhaiThu = GetterUtil.getDouble(0);
					Double duNoGocTonSau = GetterUtil.getDouble(0);
					if (phatVay.getSoLanDaThu() + soNgayTatToan < phatVay.getThoiHan()) {
						soTienGocPhaiThu = phatVay.getGocNgay() * soNgayTatToan;
						soTienLaiPhaiThu = phatVay.getLaiNgay() * soNgayTatToan;
						tongSoTienPhaiThu = soTienGocPhaiThu + soTienLaiPhaiThu;
						duNoGocTonSau = phatVay.getDuNoGoc() - soTienGocPhaiThu;
					} else if (phatVay.getSoLanDaThu() + soNgayTatToan == phatVay.getThoiHan()) {
						soTienGocPhaiThu = phatVay.getDuNoGoc();
						soTienLaiPhaiThu = phatVay.getLaiNgay() * soNgayTatToan;
						tongSoTienPhaiThu = soTienGocPhaiThu + soTienLaiPhaiThu;
					}
					resourceResponse.setContentType("application/DOCX");
					resourceResponse.setProperty("Content-Disposition",
							"attachment; filename=\"PHIEU_THU_TAT_TOAN.docx\"");
					in = getServletContext().getResourceAsStream("report/MAU_TAT_TOAN.docx");

					IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in, TemplateEngineKind.Freemarker);
					IContext iContext = report.createContext();
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("TEN_CONG_TY", GetterUtil.getString(PropsUtil.get("thongtin.cty.ten")));
					map.put("DIA_CHI_CONG_TY", GetterUtil.getString(PropsUtil.get("thongtin.cty.diachi")));
					map.put("SO_DIEN_THOAI_CONG_TY", GetterUtil.getString(PropsUtil.get("thongtin.cty.sodienthoai")));
					map.put("SO", phatVay.getSoKU());
					map.put("MA_SO", phatVay.getKhachHang().getMa());
					map.put("NGAY", sdf.format(ngayIn).substring(0, 2));
					map.put("THANG", sdf.format(ngayIn).substring(3, 5));
					map.put("NAM", sdf.format(ngayIn).substring(6, 10));
					map.put("HO_TEN_KHACH_HANG", phatVay.getKhachHang().getHoTen());
					map.put("DIA_CHI_KHACH_HANG", phatVay.getKhachHang().getDiaChi());
					map.put("VON_TRA", df.format(soTienGocPhaiThu).replaceAll(",", "."));
					map.put("LAI_TRA", df.format(soTienLaiPhaiThu).replaceAll(",", "."));
					map.put("TONG_TIEN", df.format(tongSoTienPhaiThu).replaceAll(",", "."));
					map.put("DU_NO_GOC", df.format(duNoGocTonSau).replaceAll(",", "."));
					map.put("TONG_TIEN_BANG_CHU", DocSo.docSo(GetterUtil.getLong(tongSoTienPhaiThu)));
					iContext.putMap(map);
					report.process(iContext, outStream);
					outStream.flush();
				}
			} catch (Exception e) {
				e.printStackTrace();
				kq.putException(e);
			} finally {
			}
		}
		return kq;
	}

	public JSONObject getNgayKetThuc(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ServiceContext serviceContext) {
		JSONObject kq = JSONFactoryUtil.createJSONObject();
		String ngayKetThucString = "";
		long ngayBatDauTime = ParamUtil.getLong(resourceRequest, "ngayBatDauTime");
		long laiSuatId = ParamUtil.getLong(resourceRequest, "laiSuatId");
		if (ngayBatDauTime != 0 && laiSuatId > 0) {
			try {
				LaiSuat ls = LaiSuatLocalServiceUtil.fetchLaiSuat(laiSuatId);
				int thoiHan = ls.getThoiHan();
				long thoiHanTime = GetterUtil.getLong(thoiHan) * 24 * 60 * 60 * 1000;
				Date ngayKetThuc = new Date(ngayBatDauTime + thoiHanTime);
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				ngayKetThucString = sdf.format(ngayKetThuc);
			} catch (Exception e) {
				e.printStackTrace();
				kq.putException(e);
			}
		}
		kq.put("ngayKetThuc", ngayKetThucString);
		return kq;
	}

	public JSONObject getLoaiTaiSan(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ServiceContext serviceContext) {
		JSONObject kq = JSONFactoryUtil.createJSONObject();
		List<LoaiTaiSan> loaiTaiSans = new ArrayList<LoaiTaiSan>();
		try {
			loaiTaiSans = LoaiTaiSanLocalServiceUtil.findBase("", "", "", 1, -1, -1, null);
		} catch (Exception e) {
			e.printStackTrace();
			kq.putException(e);
		}
		kq.put("loaiTaiSans", loaiTaiSans);
		return kq;
	}

	public JSONObject getThongTinLaiSuat(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ServiceContext serviceContext) {
		JSONObject kq = JSONFactoryUtil.createJSONObject();
		long laiSuatId = ParamUtil.getLong(resourceRequest, "laiSuatId");
		LaiSuat laiSuat = null;
		try {
			laiSuat = LaiSuatLocalServiceUtil.fetchLaiSuat(laiSuatId);
			kq.put("laiSuat", JSONFactoryUtil.createJSONObject(JSONFactoryUtil.looseSerialize(laiSuat)));
		} catch (Exception e) {
			e.printStackTrace();
			kq.putException(e);
		}
		return kq;
	}

	public JSONObject getKhachHang(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ServiceContext serviceContext) {
		JSONObject kq = JSONFactoryUtil.createJSONObject();
		List<KhachHang> khachHangs = new ArrayList<KhachHang>();
		try {
			String maCTV = ParamUtil.getString(resourceRequest, "maCTV");
			if (Validator.isNotNull(maCTV)) {
				khachHangs = KhachHangLocalServiceUtil.findByMaCTV(maCTV);
				SoKheUoc soKU = SoKheUocLocalServiceUtil.fetchByCauTruc(maCTV);
				if (soKU == null) {
					soKU = SoKheUocLocalServiceUtil.createSoKheUoc(0L);
					soKU.setCauTruc(maCTV);
					soKU.setSo(1);
					soKU = SoKheUocLocalServiceUtil.addSoKheUoc(soKU, serviceContext);
				}
				kq.put("soKU", soKU.getSoKheUocDayDu());
			}
			try {
			} catch (Exception e) {
				e.printStackTrace();
				kq.putException(e);
			}

		} catch (Exception e) {
			e.printStackTrace();
			kq.putException(e);
		}
		kq.put("khachHangs", khachHangs);
		return kq;
	}

	public JSONObject hoatDongURL(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ServiceContext serviceContext) {
		JSONObject kq = JSONFactoryUtil.createJSONObject();
		try {
			long congTacVienId = ParamUtil.getLong(resourceRequest, "congTacVienId");
			if (congTacVienId > 0) {
				CongTacVien ctv = CongTacVienLocalServiceUtil.fetchCongTacVien(congTacVienId);
				ctv.setHoatDong(!ctv.getHoatDong());
				CongTacVienLocalServiceUtil.updateCongTacVien(ctv, serviceContext);
			}
		} catch (Exception e) {
			e.printStackTrace();
			kq.putException(e);
		}
		return kq;
	}

	public JSONObject xoaURL(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ServiceContext serviceContext) {
		JSONObject kq = JSONFactoryUtil.createJSONObject();
		try {
			long phatVayId = ParamUtil.getLong(resourceRequest, "phatVayId");
			if (phatVayId > 0) {
				PhatVayLocalServiceUtil.xoaToanBoThongTinPhatVay(phatVayId);
			}
		} catch (Exception e) {
			e.printStackTrace();
			kq.putException(e);
		}
		return kq;
	}

	public JSONObject save(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ServiceContext serviceContext) {
		JSONObject kq = JSONFactoryUtil.createJSONObject();
		try {
			PhatVay phatVay = PhatVayLocalServiceUtil.createPhatVay(0L);
			long phatVayId = ParamUtil.getLong(resourceRequest, "phatVayId");
			String soKU = ParamUtil.getString(resourceRequest, "soKU");
			String maCTV = ParamUtil.getString(resourceRequest, "maCTV");
			String maKhachHang = ParamUtil.getString(resourceRequest, "maKhachHang");
			String soTienVayStr = ParamUtil.getString(resourceRequest, "soTienVay");
			Double soTienVay = GetterUtil.getDouble(soTienVayStr.replaceAll(",", ""));
			int thoiHan = ParamUtil.getInteger(resourceRequest, "thoiHan");
			String laiSuatVayStr = ParamUtil.getString(resourceRequest, "laiSuatVay");
			Double laiSuatVay = GetterUtil.getDouble(laiSuatVayStr.replaceAll(",", ""));
			String tienLaiNgayStr = ParamUtil.getString(resourceRequest, "tienLaiNgay");
			Double tienLaiNgay = GetterUtil.getDouble(tienLaiNgayStr.replaceAll(",", ""));
			String tienGocNgayStr = ParamUtil.getString(resourceRequest, "tienGocNgay");
			Double tienGocNgay = GetterUtil.getDouble(tienGocNgayStr.replaceAll(",", ""));
			String tienGocNgayCuoiStr = ParamUtil.getString(resourceRequest, "tienGocNgayCuoi");
			Double tienGocNgayCuoi = GetterUtil.getDouble(tienGocNgayCuoiStr.replaceAll(",", ""));
			int loaiPhatVay = ParamUtil.getInteger(resourceRequest, "loaiPhatVay");
			long ngayBatDauTime = ParamUtil.getLong(resourceRequest, "ngayBatDauTime");
			Date ngayBatDau = ngayBatDauTime != 0 ? new Date(ngayBatDauTime) : null;
			long ngayKetThucTime = ParamUtil.getLong(resourceRequest, "ngayKetThucTime");
			Date ngayKetThuc = ngayKetThucTime != 0 ? new Date(ngayKetThucTime) : null;
			long createDateTime = ParamUtil.getLong(resourceRequest, "createDateTime");
			Date createDate = createDateTime != 0 ? new Date(createDateTime) : null;
			SoKheUoc soKheUoc = null;
			if (phatVayId > 0) {
				phatVay = PhatVayLocalServiceUtil.fetchPhatVay(phatVayId);
			}
			int number = GetterUtil.getInteger(soKU.substring(maCTV.length(), soKU.length()));
			try {
				soKheUoc = SoKheUocLocalServiceUtil.fetchByCauTruc(maCTV);
			} catch (Exception e) {
				e.printStackTrace();
				kq.putException(e);
			}
			if (soKheUoc == null) {
				soKheUoc = SoKheUocLocalServiceUtil.createSoKheUoc(0L);
				soKheUoc.setCauTruc(maCTV);
				soKheUoc.setSo(0);
				soKheUoc = SoKheUocLocalServiceUtil.addSoKheUoc(soKheUoc, serviceContext);
			}
			phatVay.setCreateDate(createDate);
			phatVay.setSoKU(soKU);
			phatVay.setSoTienVay(soTienVay);
			phatVay.setThoiHan(thoiHan);
			phatVay.setLaiSuatVay(laiSuatVay);
			phatVay.setGocNgay(tienGocNgay);
			phatVay.setLaiNgay(tienLaiNgay);
			phatVay.setGocNgayCuoi(tienGocNgayCuoi);
			phatVay.setNgayBatDau(ngayBatDau);
			phatVay.setNgayKetThuc(ngayKetThuc);
			if (loaiPhatVay == 1) {
				String taiSanTheChapString = ParamUtil.getString(resourceRequest, "taiSanTheChap");
				JSONArray taiSanTheChaps = JSONFactoryUtil.createJSONArray(taiSanTheChapString);
				phatVay.setTaiSanThueChapJSONArray(taiSanTheChaps);
			}
			CongTacVien ctv = CongTacVienLocalServiceUtil.fetchByMa(maCTV);
			phatVay.setMaKhachHang(maKhachHang);
			phatVay.setMaCTV(maCTV);
			phatVay.setChiNhanhId(ctv.getChiNhanhId());
			phatVay.setLoaiPhatVay(loaiPhatVay);
			phatVay.setNgayKetThuc(ngayKetThuc);
			phatVay.setTrangThai(TrangThaiPhatVayEnum.CHUA_THANH_TOAN.getValue());
			PhatVayLocalServiceUtil.addOrUpdatePhatVay(phatVay, serviceContext);
			PhatVayLocalServiceUtil.addOrUpdateThongTinLienQuan(phatVay, serviceContext);
			if (soKheUoc.getSo() <= number) {
				soKheUoc.setSo(number + 1);
				SoKheUocLocalServiceUtil.updateSoKheUoc(soKheUoc, serviceContext);
			}
		} catch (Exception e) {
			e.printStackTrace();
			kq.putException(e);
		}
		return kq;
	}
}