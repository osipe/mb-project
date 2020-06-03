package quanly.portlet.thongke.sao_ke_chi_tiet_du_no_kh;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.mb.model.CongTacVien;
import com.mb.model.KhachHang;
import com.mb.model.LichSuThuPhatChi;
import com.mb.model.PhatVay;
import com.mb.service.CongTacVienLocalServiceUtil;
import com.mb.service.LichSuThuPhatChiLocalServiceUtil;
import com.mb.service.PhatVayLocalServiceUtil;

import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;
import quanly.constants.QuanlyPortletKeys;
import quanly.dto.CongTacVienDTO;
import quanly.dto.PhatVayDTO;
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
		String maCTVSearch = ParamUtil.getString(resourceRequest, "maCTVSearch");
		long ngayTime = ParamUtil.getLong(resourceRequest, "ngayTime");
		Date ngaySearch = ngayTime != 0 ? new Date(ngayTime) : null;
		try {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				DecimalFormat df = new DecimalFormat("###,###.###");
				resourceResponse.setContentType("application/DOCX");
				resourceResponse.setProperty("Content-Disposition", "attachment; filename=\"TONG_HOP_SAO_KE_KH.docx\"");
				in = getServletContext().getResourceAsStream("report/SAO_KE_DU_NO_CHI_TIET.docx");
				IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in, TemplateEngineKind.Velocity);
				IContext iContext = report.createContext();
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("ngayThongKe", sdf.format(ngaySearch));
				List<CongTacVien> congTacViens = CongTacVienLocalServiceUtil.getCTVSaoKe(maCTVSearch,ngaySearch);
				List<CongTacVienDTO> congTacVienDTOs = new ArrayList<CongTacVienDTO>();
				Double tongTienVayAll = GetterUtil.getDouble("0");
				Double tongGocNgayAll = GetterUtil.getDouble("0");
				Double tongLaiNgayAll = GetterUtil.getDouble("0");
				Double tongGocDaThuAll = GetterUtil.getDouble("0");
				Double tongLaiDaThuAll = GetterUtil.getDouble("0");
				Double tongDuNoGocAll = GetterUtil.getDouble("0");
				for(CongTacVien item :  congTacViens) {
					List<PhatVayDTO> phatVayDTOs = new ArrayList<PhatVayDTO>();
					List<PhatVay> phatVays = PhatVayLocalServiceUtil.getPhatVaySaoKe(item.getMa(), ngaySearch);
					phatVayDTOs.add(new PhatVayDTO("", "", "LOAI", "DN TOI DA", "SO TIEN", "GOC NGAY", "LAI NGAY", "GOC THU", "LAI THU", "DU NO GOC", "", "SO KU", "TEN", "T.HAN", "LAN", "DIA CHI", "NGAY", "MA"));
					Double tongTienVay = GetterUtil.getDouble("0");
					Double tongGocNgay = GetterUtil.getDouble("0");
					Double tongLaiNgay = GetterUtil.getDouble("0");
					Double tongGocDaThu = GetterUtil.getDouble("0");
					Double tongLaiDaThu = GetterUtil.getDouble("0");
					Double tongDuNoGoc = GetterUtil.getDouble("0");
					for (PhatVay pv : phatVays) {
						tongTienVayAll += pv.getSoTienVay();
						tongLaiNgayAll += pv.getLaiNgay();
						tongGocNgayAll += pv.getGocNgay();
						
						tongTienVay += pv.getSoTienVay();
						tongGocNgay += pv.getGocNgay();
						tongLaiNgay += pv.getLaiNgay();
						
						Double gocDaThu = GetterUtil.getDouble("0");
			 			Double laiDaThu = GetterUtil.getDouble("0");
			 			Double duGoc =  pv.getSoTienVay();
						List<LichSuThuPhatChi> lichSuThuPhatChis = LichSuThuPhatChiLocalServiceUtil.findByPhatVay_Createdate_Loai(pv.getPhatVayId(), null, ngaySearch, "3,4");
			 			for(LichSuThuPhatChi lichSuThuPhatChi : lichSuThuPhatChis){
			 				gocDaThu += lichSuThuPhatChi.getTongSoTienVonTra();
			 				laiDaThu += lichSuThuPhatChi.getTongSoTienLaiTra();
			 				duGoc -= lichSuThuPhatChi.getTongSoTienVonTra();
			 			}
			 			tongGocDaThuAll += gocDaThu;
			 			tongLaiDaThuAll += laiDaThu;
			 			tongDuNoGocAll += duGoc;
			 			
			 			tongGocDaThu += gocDaThu;
			 			tongLaiDaThu += laiDaThu;
			 			tongDuNoGoc += duGoc;
			 			
			 			Double soLanDaThu =  gocDaThu/pv.getGocNgay();
						
						KhachHang kh = pv.getKhachHang();
						PhatVayDTO phatVayDTO = new PhatVayDTO("", "", pv.getLoaiPhatVay() == 1 ? LanguageUtil.get(themeDisplay.getLocale(), "the-chap") : LanguageUtil.get(themeDisplay.getLocale(), "tin-chap"), "",  pv.getSoTienVay() > 0 ? df.format( pv.getSoTienVay()) : "", pv.getGocNgay() > 0 ? df.format( pv.getGocNgay()) : "", pv.getLaiNgay() > 0 ? df.format( pv.getLaiNgay()) : "",  gocDaThu > 0 ? df.format(gocDaThu) : "", laiDaThu > 0 ?  df.format(laiDaThu) : "", duGoc > 0 ?  df.format(duGoc) : "", "", pv.getSoKU(), kh.getHoTen(),String.valueOf(pv.getThoiHan()) , String.valueOf(GetterUtil.getInteger(soLanDaThu)), kh.getDiaChi(),pv.getCreateDate() != null ? sdf.format(pv.getCreateDate()) : "", kh.getMa());
						phatVayDTOs.add(phatVayDTO);
					}
					TongTienDTO tongTienDTO = new TongTienDTO(tongTienVay > 0 ? df.format(tongTienVay) : "0", tongGocNgay > 0 ? df.format(tongGocNgay) : "0", tongLaiNgay > 0 ? df.format(tongLaiNgay) : "0", tongGocDaThu > 0 ? df.format(tongGocDaThu) : "0" ,tongLaiDaThu > 0 ? df.format(tongLaiDaThu) : "0"  ,tongDuNoGoc > 0 ? df.format(tongDuNoGoc) : "0" );
					CongTacVienDTO ctv = new CongTacVienDTO("", item.getMa(), item.getHoTen(), item.getDiaChi(), "", "", "", "", "", "", item.getDuNoToiDaTheChap() > 0 ? df.format(item.getDuNoToiDaTheChap()) : "0" , (item.getDuNoToiDa() > item.getDuNoToiDaTheChap()) ? df.format(item.getDuNoToiDa() - item.getDuNoToiDaTheChap()) : "0" , item.getDuNoToiDa() > 0 ? df.format(item.getDuNoToiDa()) : "0", phatVayDTOs,tongTienDTO);
					congTacVienDTOs.add(ctv);
				}
				map.put("tongTienVay", tongTienVayAll > 0 ? df.format(tongTienVayAll) : "0");
				map.put("tongGocNgay", tongGocNgayAll > 0 ? df.format(tongGocNgayAll) : "0");
				map.put("tongLaiNgay", tongLaiNgayAll > 0 ? df.format(tongLaiNgayAll) : "0");
				map.put("tongGocDaThu", tongGocDaThuAll > 0 ? df.format(tongGocDaThuAll) : "0");
				map.put("tongLaiDaThu", tongLaiDaThuAll > 0 ? df.format(tongLaiDaThuAll) : "0");
				map.put("tongDuNoGoc", tongDuNoGocAll > 0 ? df.format(tongDuNoGocAll) : "0");
				FieldsMetadata metadata = new FieldsMetadata();
				metadata.addFieldAsList("ctvs.so");
				metadata.addFieldAsList("ctvs.maSo");
				metadata.addFieldAsList("ctvs.hoTen");
				metadata.addFieldAsList("ctvs.diaChi");
				metadata.addFieldAsList("ctvs.vonTra");
				metadata.addFieldAsList("ctvs.laiTra");
				metadata.addFieldAsList("ctvs.tongTien");
				metadata.addFieldAsList("ctvs.tongTienBangChu");
				metadata.addFieldAsList("ctvs.dinhMucDuNoTheChap");
				metadata.addFieldAsList("ctvs.dinhMucDuNoTinChap");
				metadata.addFieldAsList("ctvs.tongDinhMucDuNo");
				metadata.addFieldAsList("ctvs.duNoGoc");
				metadata.addFieldAsList("ctvs.phatVayDTOs");
				metadata.addFieldAsList("ctvs.tongTienDTO");
				metadata.addFieldAsList("ctvs.phatVayDTOs.soKU");
				metadata.addFieldAsList("ctvs.phatVayDTOs.maKH");
				metadata.addFieldAsList("ctvs.phatVayDTOs.hoTen");
				metadata.addFieldAsList("ctvs.phatVayDTOs.diaChi");
				report.setFieldsMetadata(metadata);
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
}