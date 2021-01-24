package quanly.portlet.phatvay.tattoan;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.mb.model.CongTacVien;
import com.mb.model.LichSuThuPhatChi;
import com.mb.model.PhatVay;
import com.mb.service.CongTacVienLocalServiceUtil;
import com.mb.service.LichSuThuPhatChiLocalServiceUtil;
import com.mb.service.PhatVayLocalServiceUtil;

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
		"javax.portlet.init-param.view-template=/html/phatvay/tattoan/view.jsp",
		"javax.portlet.display-name=" + QuanlyPortletKeys.tatToan, "javax.portlet.name=" + QuanlyPortletKeys.tatToan,
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
public class TatToanPortlet extends MVCPortlet {
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
		if (resourceId.equals("tatToanURL")) {
			kq = tatToanURL(resourceRequest, resourceResponse, serviceContext);
		} else if (resourceId.equals("boTatToanURL")) {
			kq = boTatToanURL(resourceRequest, resourceResponse, serviceContext);
		} else if (resourceId.equals("printPhieuTatToan")) {
			kq = printPhieuTatToan(resourceRequest, resourceResponse, serviceContext);
		} else if (resourceId.equals("getThongTinTatToan")) {
			kq = getThongTinTatToan(resourceRequest, resourceResponse, serviceContext);
		} else if (resourceId.equals("getTongTienTatToan")) {
			kq = getTongTienTatToan(resourceRequest, resourceResponse, serviceContext);
		}
		PrintWriter writer = resourceResponse.getWriter();
		writer.print(kq.toString());
		writer.flush();
		writer.close();

	}

	public JSONObject getThongTinTatToan(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ServiceContext serviceContext) {
		JSONObject kq = JSONFactoryUtil.createJSONObject();
		try {
			JSONArray arrayList = JSONFactoryUtil.createJSONArray();
			String phatVayIds = ParamUtil.getString(resourceRequest, "phatVayIds");
			Locale localeEn = new Locale("en", "EN");
		    NumberFormat df = NumberFormat.getInstance(localeEn);
			String[] array = StringUtil.split(phatVayIds, ",");
			if (array != null && array.length > 0) {
				for (int i = 0; i < array.length; i++) {
					long phatVayId = Long.valueOf(array[i]);
					if (phatVayId > 0) {
						PhatVay phatVay = PhatVayLocalServiceUtil.fetchPhatVay(phatVayId);
						if(phatVay != null) {
							
							JSONObject jsonPhatVay = JSONFactoryUtil.createJSONObject(JSONFactoryUtil.looseSerialize(phatVay));
							
							int tongSoLanDaThu = phatVay.getSoLanDaThu() + phatVay.getSoNgayThuTruoc();
							jsonPhatVay.put("tongSoLanDaThu",tongSoLanDaThu );
							Double tongLaiTatToan =  (phatVay.getThoiHan() - tongSoLanDaThu) * phatVay.getLaiNgay();
							Double tongVonTatToan = phatVay.getDuNoGoc();
							jsonPhatVay.put("tongLaiTatToan",tongLaiTatToan);
							jsonPhatVay.put("tongVonTatToan", tongVonTatToan);
							jsonPhatVay.put("tongLaiTatToanStr", df.format(tongLaiTatToan));
							jsonPhatVay.put("tongVonTatToanStr",  df.format(tongVonTatToan));
							jsonPhatVay.put("soTienVayStr",  df.format(phatVay.getSoTienVay()));
							jsonPhatVay.put("laiNgayStr",  df.format(phatVay.getLaiNgay()));
							jsonPhatVay.put("gocNgayStr",  df.format(phatVay.getGocNgay()));
							jsonPhatVay.put("gocNgayCuoiStr",  df.format(phatVay.getGocNgayCuoi()));
							jsonPhatVay.put("duNoGocStr",  df.format(phatVay.getDuNoGoc()));
							jsonPhatVay.put("hoTenKhachHang",  phatVay.getKhachHang() != null ? phatVay.getKhachHang().getHoTen() : "");
							jsonPhatVay.put("hoTenCTV",  phatVay.getCongTacVien() != null ? phatVay.getCongTacVien().getHoTen() : "");
							arrayList.put(jsonPhatVay);
						}
					}
				}
			}
			kq.put("data", arrayList);
		} catch (Exception e) {
			e.printStackTrace();
			kq.putException(e);
		}
		return kq;
	}
	public JSONObject getTongTienTatToan(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ServiceContext serviceContext) {
		JSONObject kq = JSONFactoryUtil.createJSONObject();
		try {
			String phatVayIds = ParamUtil.getString(resourceRequest, "phatVayIds");
			Locale localeEn = new Locale("en", "EN");
		    NumberFormat df = NumberFormat.getInstance(localeEn);
			String[] array = StringUtil.split(phatVayIds, ",");
			Double tongLaiTatToan =  0.0;
			Double tongVonTatToan = 0.0;
			if (array != null && array.length > 0) {
				for (int i = 0; i < array.length; i++) {
					if(Validator.isNotNull(array[i]) && Long.valueOf(array[i]) > 0) {
						long phatVayId =  Long.valueOf(array[i]);
						if (phatVayId > 0) {
							PhatVay phatVay = PhatVayLocalServiceUtil.fetchPhatVay(phatVayId);
							if(phatVay != null) {
								int tongSoLanDaThu = phatVay.getSoLanDaThu() + phatVay.getSoNgayThuTruoc();
								tongLaiTatToan +=  ((phatVay.getThoiHan() - tongSoLanDaThu) * phatVay.getLaiNgay());
								tongVonTatToan += phatVay.getDuNoGoc();
							}
						}
					}
				}
			}
			kq.put("tongLaiTatToan", tongLaiTatToan);
			kq.put("tongVonTatToan", tongVonTatToan);
			kq.put("tongTatToan", tongLaiTatToan + tongVonTatToan);
			kq.put("tongLaiTatToanStr", df.format(tongLaiTatToan));
			kq.put("tongVonTatToanStr", df.format(tongVonTatToan));
			kq.put("tongTatToanStr", df.format(tongLaiTatToan + tongVonTatToan));
		} catch (Exception e) {
			e.printStackTrace();
			kq.putException(e);
		}
		return kq;
	}

	public JSONObject printPhieuTatToan(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ServiceContext serviceContext) throws IOException {
		JSONObject kq = JSONFactoryUtil.createJSONObject();
		String phatVayIds = ParamUtil.getString(resourceRequest, "phatVayIds");
		String[] array = StringUtil.split(phatVayIds, ",");
		Double tongLaiTatToan = Double.valueOf("0");
		Double tongVonTatToan = Double.valueOf("0");
		if (array != null && array.length > 0) {
			for (int i = 0; i < array.length; i++) {
				long phatVayId = Long.valueOf(array[i]);
				if (phatVayId > 0) {
					PhatVay phatVay = PhatVayLocalServiceUtil.fetchPhatVay(phatVayId);
					tongLaiTatToan += ((phatVay.getThoiHan() - (phatVay.getSoLanDaThu() + phatVay.getSoNgayThuTruoc()))
							* phatVay.getLaiNgay());
					tongVonTatToan += phatVay.getDuNoGoc();
				}
			}
		}
		String maCTV = ParamUtil.getString(resourceRequest, "maCTV");
		InputStream in = null;
		OutputStream outStream = resourceResponse.getPortletOutputStream();
		if (Validator.isNotNull(maCTV)) {
			try {
				CongTacVien ctv = CongTacVienLocalServiceUtil.fetchByMa(maCTV);
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Locale localeEn = new Locale("en", "EN");
			    NumberFormat df = NumberFormat.getInstance(localeEn);
				resourceResponse.setContentType("application/DOCX");
				resourceResponse.setProperty("Content-Disposition",
						"attachment; filename=\"PHIEU_THU_TAT_TOAN_" + maCTV.toUpperCase() + ".docx\"");
				in = getServletContext().getResourceAsStream("report/MAU_TAT_TOAN.docx");
				IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in, TemplateEngineKind.Velocity);
				IContext iContext = report.createContext();
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("TEN_CONG_TY", GetterUtil.getString(PropsUtil.get("thongtin.cty.ten")));
				map.put("DIA_CHI_CONG_TY", GetterUtil.getString(PropsUtil.get("thongtin.cty.diachi")));
				map.put("SO_DIEN_THOAI_CONG_TY", GetterUtil.getString(PropsUtil.get("thongtin.cty.sodienthoai")));
				map.put("SO", maCTV + "/" + new SimpleDateFormat("ddMMyyyy").format(new Date()));
				map.put("MA_SO", maCTV);
				map.put("NGAY", sdf.format(new Date()).substring(0, 2));
				map.put("THANG", sdf.format(new Date()).substring(3, 5));
				map.put("NAM", sdf.format(new Date()).substring(6, 10));
				map.put("HO_TEN_CTV", ctv.getHoTen());
				map.put("DIA_CHI_CTV", ctv.getDiaChi());
				map.put("VON_TRA", df.format(tongVonTatToan).replaceAll(",", "."));
				map.put("LAI_TRA", df.format(tongLaiTatToan).replaceAll(",", "."));
				map.put("TONG_TIEN", df.format(tongVonTatToan + tongLaiTatToan).replaceAll(",", "."));
				map.put("TONG_TIEN_BANG_CHU", DocSo.docSo(GetterUtil.getLong(tongVonTatToan + tongLaiTatToan)));
				iContext.putMap(map);
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

	public JSONObject tatToanURL(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ServiceContext serviceContext) {
		JSONObject kq = JSONFactoryUtil.createJSONObject();
		try {
			String phatVayIds = ParamUtil.getString(resourceRequest, "phatVayIds");
			String[] array = StringUtil.split(phatVayIds, ",");
			Double soTienGocPhaiThu = GetterUtil.getDouble(0);
			Double soTienLaiPhaiThu = GetterUtil.getDouble(0);
			String maCTV = "";
			if (array != null && array.length > 0) {
				for (int i = 0; i < array.length; i++) {
					if(Validator.isNotNull(array[i])) {
						long phatVayId = Long.valueOf(array[i]);
						if (phatVayId > 0) {
							PhatVay phatVay = PhatVayLocalServiceUtil.fetchPhatVay(phatVayId);
							if (phatVay != null) {
								maCTV = phatVay.getMaCTV();
								soTienGocPhaiThu += phatVay.getDuNoGoc();
								soTienLaiPhaiThu += ((phatVay.getThoiHan()
										- (phatVay.getSoLanDaThu() + phatVay.getSoNgayThuTruoc())) * phatVay.getLaiNgay());
								Double gocPhaithu = phatVay.getDuNoGoc();
								Double laiPhaiThu = ((phatVay.getThoiHan()
										- (phatVay.getSoLanDaThu() + phatVay.getSoNgayThuTruoc())) * phatVay.getLaiNgay());
								phatVay.setNgayTatToan(new Date());
								phatVay.setTrangThai(TrangThaiPhatVayEnum.DA_TAT_TOAN.getValue());
								PhatVayLocalServiceUtil.updatePhatVay(phatVay, serviceContext);

								LichSuThuPhatChi lichSuThuPhatChi = LichSuThuPhatChiLocalServiceUtil
										.createLichSuThuPhatChi(0L);
								lichSuThuPhatChi.setMaCTV(maCTV);
								lichSuThuPhatChi.setLoai(2);
								lichSuThuPhatChi.setPhatVayId(phatVayId);
								lichSuThuPhatChi.setChiNhanhId(phatVay.getChiNhanhId());
								lichSuThuPhatChi.setSoTien(gocPhaithu + laiPhaiThu);
								lichSuThuPhatChi.setTongSoTienLaiTra(laiPhaiThu);
								lichSuThuPhatChi.setTrangThaiPhatVayHienTai(TrangThaiPhatVayEnum.DA_TAT_TOAN.getValue());
								lichSuThuPhatChi.setTongSoTienVonTra(gocPhaithu);
								LichSuThuPhatChiLocalServiceUtil.addLichSuThuPhatChi(lichSuThuPhatChi, serviceContext);
							}
						}
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			kq.putException(e);
		}
		return kq;
	}

	public JSONObject boTatToanURL(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ServiceContext serviceContext) {
		JSONObject kq = JSONFactoryUtil.createJSONObject();
		try {
			String phatVayIds = ParamUtil.getString(resourceRequest, "phatVayIds");
			String[] array = StringUtil.split(phatVayIds, ",");
			if (array != null && array.length > 0) {
				for (int i = 0; i < array.length; i++) {
					long phatVayId = Long.valueOf(array[i]);
					if (phatVayId > 0) {
						PhatVay phatVay = PhatVayLocalServiceUtil.fetchPhatVay(phatVayId);
						if (phatVay != null) {
							phatVay.setNgayTatToan(null);
							phatVay.setTrangThai(TrangThaiPhatVayEnum.CHUA_THANH_TOAN.getValue());
							PhatVayLocalServiceUtil.addOrUpdatePhatVay(phatVay, serviceContext);
							LichSuThuPhatChiLocalServiceUtil.removeByPhatVayId_Loai(phatVayId, 2);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			kq.putException(e);
		}
		return kq;
	}
}