package quanly.portlet.thongke.tong_hop_sao_ke_ctv;

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

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.mb.model.CongTacVien;
import com.mb.model.LichSuThuPhatChi;
import com.mb.model.PhatVay;
import com.mb.service.CongTacVienLocalServiceUtil;
import com.mb.service.LichSuThuPhatChiLocalServiceUtil;
import com.mb.service.PhatVayLocalServiceUtil;

import quanly.constants.FileType;
import quanly.constants.QuanlyPortletKeys;
import quanly.dto.PhatVayDTO;
import quanly.util.JasperReportUtil;

/**
 * @author Annn
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/html/thongke/sao_ke_ctv/view.jsp",
		"javax.portlet.display-name=" + QuanlyPortletKeys.tongHopSaoKeDuNoCTV,
		"javax.portlet.name=" + QuanlyPortletKeys.tongHopSaoKeDuNoCTV, "javax.portlet.resource-bundle=content.Language",
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
public class TongHopSaoKeDuNoCTVPortlet extends MVCPortlet {
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
		if (resourceId.equals("inSaoKeDuNoCTV")) {
			kq = inSaoKeDuNoCTV(resourceRequest, resourceResponse, serviceContext);
		}
		PrintWriter writer = resourceResponse.getWriter();
		writer.print(kq.toString());
		writer.flush();
		writer.close();

	}

	public JSONObject inSaoKeDuNoCTV(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ServiceContext serviceContext) throws IOException {
		JSONObject kq = JSONFactoryUtil.createJSONObject();
		InputStream in = null;
		OutputStream outStream = resourceResponse.getPortletOutputStream();
		String maCTVSearch = ParamUtil.getString(resourceRequest, "maCTVSearch");
		long ngayTime = ParamUtil.getLong(resourceRequest, "ngayTime");
		Date ngaySearch = ngayTime != 0 ? new Date(ngayTime) : null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			DecimalFormat df = new DecimalFormat("###,###.###");
			resourceResponse.setContentType("application/DOCX");
			resourceResponse.setProperty("Content-Disposition", "attachment; filename=\"TONG_HOP_SAO_KE_CTV.DOCX\"");
			in = getServletContext().getResourceAsStream("report/SAO_KE_DU_NO_CTV.jasper");
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("ngayIn", sdf.format(ngaySearch));
			Double tongTienVayAll = GetterUtil.getDouble("0");
			Double tongGocNgayAll = GetterUtil.getDouble("0");
			Double tongLaiNgayAll = GetterUtil.getDouble("0");
			Double tongGocDaThuAll = GetterUtil.getDouble("0");
			Double tongLaiDaThuAll = GetterUtil.getDouble("0");
			Double tongDuNoGocAll = GetterUtil.getDouble("0");
			Double tongDuNoGocToiDaAll = GetterUtil.getDouble("0");
			Collection<Object> collections = new ArrayList<Object>();
			List<CongTacVien> congTacViens = CongTacVienLocalServiceUtil.getCTVSaoKe(maCTVSearch,ngaySearch);
			int stt = 0;
			for (CongTacVien ctv : congTacViens) {
				stt++;
				Double tongTienVay = GetterUtil.getDouble("0");
				Double tongGocNgay = GetterUtil.getDouble("0");
				Double tongLaiNgay = GetterUtil.getDouble("0");
				Double tongGocDaThu = GetterUtil.getDouble("0");
				Double tongLaiDaThu = GetterUtil.getDouble("0");
				Double tongDuNoGoc = GetterUtil.getDouble("0");

				Double tongTienVayTinChap = GetterUtil.getDouble("0");
				Double tongGocNgayTinChap = GetterUtil.getDouble("0");
				Double tongLaiNgayTinChap = GetterUtil.getDouble("0");
				Double tongGocDaThuTinChap = GetterUtil.getDouble("0");
				Double tongLaiDaThuTinChap = GetterUtil.getDouble("0");
				Double tongDuNoGocTinChap = GetterUtil.getDouble("0");

				Double tongTienVayTheChap = GetterUtil.getDouble("0");
				Double tongGocNgayTheChap = GetterUtil.getDouble("0");
				Double tongLaiNgayTheChap = GetterUtil.getDouble("0");
				Double tongGocDaThuTheChap = GetterUtil.getDouble("0");
				Double tongLaiDaThuTheChap = GetterUtil.getDouble("0");
				Double tongDuNoGocTheChap = GetterUtil.getDouble("0");

				List<PhatVay> phatVays = PhatVayLocalServiceUtil.getPhatVaySaoKe(ctv.getMa(),0, ngaySearch);
				for (PhatVay pv : phatVays) {
					Double gocDaThu = GetterUtil.getDouble("0");
		 			Double laiDaThu = GetterUtil.getDouble("0");
		 			Double duGoc =  pv.getSoTienVay();
					List<LichSuThuPhatChi> lichSuThuPhatChis = LichSuThuPhatChiLocalServiceUtil.findByPhatVay_Createdate_Loai(pv.getPhatVayId(), null, ngaySearch, "3,4");
		 			for(LichSuThuPhatChi lichSuThuPhatChi : lichSuThuPhatChis){
		 				gocDaThu += lichSuThuPhatChi.getTongSoTienVonTra();
		 				laiDaThu += lichSuThuPhatChi.getTongSoTienLaiTra();
		 				duGoc -= lichSuThuPhatChi.getTongSoTienVonTra();
		 			}
					
					if (pv.getLoaiPhatVay() != 1) {
						tongTienVayTinChap += pv.getSoTienVay();
						tongGocNgayTinChap += pv.getGocNgay();
						tongLaiNgayTinChap += pv.getLaiNgay();
						
						tongGocDaThuTinChap += gocDaThu;
						tongLaiDaThuTinChap += laiDaThu;
						tongDuNoGocTinChap += duGoc;
					} else {
						tongTienVayTheChap += pv.getSoTienVay();
						tongGocNgayTheChap += pv.getGocNgay();
						tongLaiNgayTheChap += pv.getLaiNgay();
						
						
						tongGocDaThuTheChap+= gocDaThu;
						tongLaiDaThuTheChap +=laiDaThu;
						tongDuNoGocTheChap += duGoc;
					}
					
					
					tongTienVay += pv.getSoTienVay();
					tongGocNgay += pv.getGocNgay();
					tongLaiNgay += pv.getLaiNgay();
					
					tongGocDaThu += gocDaThu;
					tongLaiDaThu += laiDaThu;
					tongDuNoGoc += duGoc;
					
					tongTienVayAll += pv.getSoTienVay();
					tongGocNgayAll += pv.getGocNgay();
					tongLaiNgayAll += pv.getLaiNgay();
					
					tongGocDaThuAll += gocDaThu;
					tongLaiDaThuAll += laiDaThu;
					tongDuNoGocAll += duGoc;
				}
				collections.add(new PhatVayDTO(ctv.getMa(), ctv.getHoTen(),  PropsUtil.get("viethoa.tong"), ctv.getDuNoToiDa() > 0 ? df.format(ctv.getDuNoToiDa()) : "",  tongTienVay > 0 ? df.format(tongTienVay) : "", tongGocNgay > 0 ? df.format(tongGocNgay) : "", tongLaiNgay > 0 ? df.format(tongLaiNgay) : "",tongGocDaThu > 0 ? df.format(tongGocDaThu) : "" , tongLaiDaThu > 0 ? df.format(tongLaiDaThu) : "",tongDuNoGoc > 0 ? df.format(tongDuNoGoc) : "" , String.valueOf(stt), "", "", "", "", "", "", ""));
				if(tongDuNoGocTheChap > 0) {
					collections.add(new PhatVayDTO("", "", PropsUtil.get("viethoa.thue-chap"), ctv.getDuNoToiDaTheChap() > 0 ? df.format(ctv.getDuNoToiDaTheChap()) : "",  tongTienVayTheChap > 0 ? df.format(tongTienVayTheChap) : "", tongGocNgayTheChap > 0 ? df.format(tongGocNgayTheChap) : "", tongLaiNgayTheChap > 0 ? df.format(tongLaiNgayTheChap) : "",tongGocDaThuTheChap > 0 ? df.format(tongGocDaThuTheChap) : "" , tongLaiDaThuTheChap > 0 ? df.format(tongLaiDaThuTheChap) : "",tongDuNoGocTheChap > 0 ? df.format(tongDuNoGocTheChap) : "" , "", "", "", "", "", "", "", ""));
				}
				if(tongDuNoGocTinChap > 0) {
					collections.add(new PhatVayDTO("", "", PropsUtil.get("viethoa.tin-chap"), (ctv.getDuNoToiDa() - ctv.getDuNoToiDaTheChap()) > 0 ? df.format(ctv.getDuNoToiDa() - ctv.getDuNoToiDaTheChap()) : "",  tongTienVayTinChap > 0 ? df.format(tongTienVayTinChap) : "", tongGocNgayTinChap > 0 ? df.format(tongGocNgayTinChap) : "", tongLaiNgayTinChap > 0 ? df.format(tongLaiNgayTinChap) : "",tongGocDaThuTinChap > 0 ? df.format(tongGocDaThuTinChap) : "" , tongLaiDaThuTinChap > 0 ? df.format(tongLaiDaThuTinChap) : "",tongDuNoGocTinChap > 0 ? df.format(tongDuNoGocTinChap) : "" , "", "", "", "", "", "", "", ""));
				}
				tongDuNoGocToiDaAll += ctv.getDuNoToiDa();
			}
			parameters.put("tongDuNoGocToiDa", tongDuNoGocToiDaAll > 0 ? df.format(tongDuNoGocToiDaAll) : "");
			parameters.put("tongTienVay", tongTienVayAll > 0 ? df.format(tongTienVayAll) : "");
			parameters.put("tongGocNgay", tongGocNgayAll > 0 ? df.format(tongGocNgayAll) : "");
			parameters.put("tongLaiNgay", tongLaiNgayAll > 0 ? df.format(tongLaiNgayAll) : "");
			parameters.put("tongGocThu", tongGocDaThuAll > 0 ? df.format(tongGocDaThuAll) : "");
			parameters.put("tongLaiThu", tongLaiDaThuAll > 0 ? df.format(tongLaiDaThuAll) : "");
			parameters.put("tongDuNoGoc", tongDuNoGocAll > 0 ? df.format(tongDuNoGocAll) : "");
			JasperReportUtil.exportReport(in, outStream, parameters, collections, FileType.DOCX);
			outStream.flush();
		} catch (Exception e) {
			e.printStackTrace();
			kq.putException(e);
		} finally {
		}
		return kq;
	}

}