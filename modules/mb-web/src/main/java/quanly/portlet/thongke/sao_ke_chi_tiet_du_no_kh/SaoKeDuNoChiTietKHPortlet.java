package quanly.portlet.thongke.sao_ke_chi_tiet_du_no_kh;

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
import com.mb.model.PhatVay;
import com.mb.service.CongTacVienLocalServiceUtil;
import com.mb.service.LichSuThuPhatChiLocalServiceUtil;
import com.mb.service.PhatVayLocalServiceUtil;

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

import org.apache.commons.collections.CollectionUtils;
import org.osgi.service.component.annotations.Component;

import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;
import quanly.constants.QuanlyPortletKeys;
import quanly.dto.PhatVayDTO;
import quanly.dto.SaoKeChiTietDTO;
import quanly.dto.TongTienDTO;

/**
 * @author Annn
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/html/thongke/sao_ke_kh/view.jsp",
		"javax.portlet.display-name=" + QuanlyPortletKeys.saoKeDuNoChiTietKH,
		"javax.portlet.name=" + QuanlyPortletKeys.saoKeDuNoChiTietKH, "javax.portlet.resource-bundle=content.Language",
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
public class SaoKeDuNoChiTietKHPortlet extends MVCPortlet {
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
		if (resourceId.equals("inSaoKeDuNoKH")) {
			kq = inSaoKeDuNoKH(resourceRequest, resourceResponse, serviceContext);
		}
		PrintWriter writer = resourceResponse.getWriter();
		writer.print(kq.toString());
		writer.flush();
		writer.close();

	}

	public JSONObject inSaoKeDuNoKH(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ServiceContext serviceContext) throws IOException {
		JSONObject kq = JSONFactoryUtil.createJSONObject();
		InputStream in = null;
		OutputStream outStream = resourceResponse.getPortletOutputStream();
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long chiNhanhId = ParamUtil.getLong(resourceRequest, "chiNhanhId");
		String maCTVSearch = ParamUtil.getString(resourceRequest, "maCTVSearch");
		long ngayTime = ParamUtil.getLong(resourceRequest, "ngayTime");
		Date ngaySearch = ngayTime != 0 ? new Date(ngayTime) : null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Locale localeEn = new Locale("en", "EN");
			NumberFormat df = NumberFormat.getInstance(localeEn);
			resourceResponse.setContentType("application/DOCX");
			resourceResponse.setProperty("Content-Disposition", "attachment; filename=\"TONG_HOP_SAO_KE_KH.docx\"");
			in = getServletContext().getResourceAsStream("report/SAO_KE_DU_NO_CHI_TIET_NEW.docx");
			IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in, TemplateEngineKind.Freemarker);
			IContext iContext = report.createContext();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("ngayThongKe", sdf.format(ngaySearch));
			List<CongTacVien> congTacViens = CongTacVienLocalServiceUtil.getCTVSaoKe(chiNhanhId, maCTVSearch,
					ngaySearch);
			List<SaoKeChiTietDTO> saoKeChiTietDTOs = new ArrayList<SaoKeChiTietDTO>();
			for (CongTacVien item : congTacViens) {
				List<PhatVayDTO> phatVayTinChapDTOs = new ArrayList<PhatVayDTO>();
				List<PhatVay> phatVayTinChaps = PhatVayLocalServiceUtil.getPhatVaySaoKe(chiNhanhId, item.getMa(), 2,
						ngaySearch);
				Double tinVayTinChap = GetterUtil.getDouble("0");
				Double gocNgayTinChap = GetterUtil.getDouble("0");
				Double laiNgayTinChap = GetterUtil.getDouble("0");
				Double gocDaThuTinChap = GetterUtil.getDouble("0");
				Double laiDaThuTinChap = GetterUtil.getDouble("0");
				Double duNoGocTinChap = GetterUtil.getDouble("0");
				if (CollectionUtils.isNotEmpty(phatVayTinChaps)) {
					for (PhatVay phatVay : phatVayTinChaps) {
						List<LichSuThuPhatChi> lichSuThuPhatChis = LichSuThuPhatChiLocalServiceUtil
								.findByPhatVay_Createdate_Loai(chiNhanhId, phatVay.getPhatVayId(), null, ngaySearch,
										"3,4");
						tinVayTinChap += phatVay.getSoTienVay();
						gocNgayTinChap += phatVay.getGocNgay();
						laiNgayTinChap += phatVay.getLaiNgay();
						Double gocDaThu = GetterUtil.getDouble("0");
						Double laiDaThu = GetterUtil.getDouble("0");
						Double duNoGoc = phatVay.getSoTienVay();
						for (LichSuThuPhatChi lichSuThuPhatChi : lichSuThuPhatChis) {
							gocDaThuTinChap += lichSuThuPhatChi.getTongSoTienVonTra();
							laiDaThuTinChap += lichSuThuPhatChi.getTongSoTienLaiTra();

							gocDaThu += lichSuThuPhatChi.getTongSoTienVonTra();
							laiDaThu += lichSuThuPhatChi.getTongSoTienLaiTra();
						}
						duNoGoc -= gocDaThu;
						Double soLanDaThu = gocDaThu / phatVay.getGocNgay();
						phatVayTinChapDTOs.add(new PhatVayDTO("", "", "", "",
								phatVay.getSoTienVay() > 0 ? df.format(phatVay.getSoTienVay()) : "",
								phatVay.getGocNgay() > 0 ? df.format(phatVay.getGocNgay()) : "",
								phatVay.getLaiNgay() > 0 ? df.format(phatVay.getLaiNgay()) : "",
								gocDaThu > 0 ? df.format(gocDaThu) : "", laiDaThu > 0 ? df.format(laiDaThu) : "",
								duNoGoc > 0 ? df.format(duNoGoc) : "", "", phatVay.getSoKU(),
								phatVay.getKhachHang() != null ? phatVay.getKhachHang().getHoTen() : "",
								String.valueOf(phatVay.getThoiHan()), String.valueOf(GetterUtil.getInteger(soLanDaThu)),
								phatVay.getKhachHang() != null ? phatVay.getKhachHang().getDiaChi() : "",
								phatVay.getCreateDate() != null ? sdf.format(phatVay.getCreateDate()) : "",
								phatVay.getKhachHang() != null ? phatVay.getKhachHang().getMa() : ""));

					}
					duNoGocTinChap = tinVayTinChap - gocDaThuTinChap;
				}
				List<PhatVayDTO> phatVayTheChapDTOs = new ArrayList<PhatVayDTO>();
				List<PhatVay> phatVayTheChaps = PhatVayLocalServiceUtil.getPhatVaySaoKe(chiNhanhId, item.getMa(), 1,
						ngaySearch);
				Double tinVayTheChap = GetterUtil.getDouble("0");
				Double gocNgayTheChap = GetterUtil.getDouble("0");
				Double laiNgayTheChap = GetterUtil.getDouble("0");
				Double gocDaThuTheChap = GetterUtil.getDouble("0");
				Double laiDaThuTheChap = GetterUtil.getDouble("0");
				Double duNoGocTheChap = GetterUtil.getDouble("0");
				if (CollectionUtils.isNotEmpty(phatVayTheChaps)) {
					for (PhatVay phatVay : phatVayTheChaps) {
						List<LichSuThuPhatChi> lichSuThuPhatChis = LichSuThuPhatChiLocalServiceUtil
								.findByPhatVay_Createdate_Loai(chiNhanhId, phatVay.getPhatVayId(), null, ngaySearch,
										"3,4");
						tinVayTheChap += phatVay.getSoTienVay();
						gocNgayTheChap += phatVay.getGocNgay();
						laiNgayTheChap += phatVay.getLaiNgay();
						Double gocDaThu = GetterUtil.getDouble("0");
						Double laiDaThu = GetterUtil.getDouble("0");
						Double duNoGoc = phatVay.getSoTienVay();
						for (LichSuThuPhatChi lichSuThuPhatChi : lichSuThuPhatChis) {
							gocDaThuTheChap += lichSuThuPhatChi.getTongSoTienVonTra();
							laiDaThuTheChap += lichSuThuPhatChi.getTongSoTienLaiTra();

							gocDaThu += lichSuThuPhatChi.getTongSoTienVonTra();
							laiDaThu += lichSuThuPhatChi.getTongSoTienLaiTra();
						}
						Double soLanDaThu = gocDaThu / phatVay.getGocNgay();
						duNoGoc -= gocDaThu;
						phatVayTheChapDTOs.add(new PhatVayDTO("", "", "", "",
								phatVay.getSoTienVay() > 0 ? df.format(phatVay.getSoTienVay()) : "0",
								phatVay.getGocNgay() > 0 ? df.format(phatVay.getGocNgay()) : "0",
								phatVay.getLaiNgay() > 0 ? df.format(phatVay.getLaiNgay()) : "0",
								gocDaThu > 0 ? df.format(gocDaThu) : "0", laiDaThu > 0 ? df.format(laiDaThu) : "0",
								duNoGoc > 0 ? df.format(duNoGoc) : "0", "", phatVay.getSoKU(),
								phatVay.getKhachHang() != null ? phatVay.getKhachHang().getHoTen() : "",
								String.valueOf(phatVay.getThoiHan()), String.valueOf(GetterUtil.getInteger(soLanDaThu)),
								phatVay.getKhachHang() != null ? phatVay.getKhachHang().getDiaChi() : "",
								phatVay.getCreateDate() != null ? sdf.format(phatVay.getCreateDate()) : "",
								phatVay.getKhachHang() != null ? phatVay.getKhachHang().getMa() : ""));

					}
					duNoGocTheChap = tinVayTheChap - gocDaThuTheChap;
				}
				TongTienDTO tongTienDTO = new TongTienDTO(df.format(tinVayTinChap + tinVayTheChap),
						df.format(gocNgayTinChap + gocNgayTheChap), df.format(laiNgayTinChap + laiNgayTheChap),
						df.format(gocDaThuTinChap + gocDaThuTheChap), df.format(laiDaThuTinChap + laiDaThuTheChap),
						df.format(duNoGocTinChap + duNoGocTheChap));
				saoKeChiTietDTOs.add(new SaoKeChiTietDTO(item.getHoTen(), item.getMa(),
						item.getDuNoToiDa() > 0 ? df.format(item.getDuNoToiDa()) : "0",
						(item.getDuNoToiDa() - item.getDuNoToiDaTheChap()) > 0
								? df.format(item.getDuNoToiDa() - item.getDuNoToiDaTheChap())
								: "0",
						item.getDuNoToiDaTheChap() > 0 ? df.format(item.getDuNoToiDaTheChap()) : "0",
						tinVayTinChap > 0 ? df.format(tinVayTinChap) : "0",
						gocNgayTinChap > 0 ? df.format(gocNgayTinChap) : "0",
						laiNgayTinChap > 0 ? df.format(laiNgayTinChap) : "0",
						gocDaThuTinChap > 0 ? df.format(gocDaThuTinChap) : "0",
						laiDaThuTinChap > 0 ? df.format(laiDaThuTinChap) : "0",
						duNoGocTinChap > 0 ? df.format(duNoGocTinChap) : "0",
						tinVayTheChap > 0 ? df.format(tinVayTheChap) : "0",
						gocNgayTheChap > 0 ? df.format(gocNgayTheChap) : "0",
						laiNgayTheChap > 0 ? df.format(laiNgayTheChap) : "0",
						gocDaThuTheChap > 0 ? df.format(gocDaThuTheChap) : "0",
						laiDaThuTheChap > 0 ? df.format(laiDaThuTheChap) : "0",
						duNoGocTheChap > 0 ? df.format(duNoGocTheChap) : "0", phatVayTinChapDTOs, phatVayTheChapDTOs,
						tongTienDTO, CollectionUtils.isNotEmpty(phatVayTinChapDTOs),
						CollectionUtils.isNotEmpty(phatVayTheChapDTOs)));
			}
			FieldsMetadata metadata = new FieldsMetadata();
			report.setFieldsMetadata(metadata);
			iContext.putMap(map);
			iContext.put("ctvs", saoKeChiTietDTOs);
			report.process(iContext, outStream);

		} catch (Exception e) {
			e.printStackTrace();
			kq.putException(e);
		} finally {
		}
		outStream.flush();
		return kq;
	}
}