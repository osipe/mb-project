package quanly.portlet.thongke.phat_vay_ngay;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.liferay.portal.kernel.util.WebKeys;
import com.mb.model.CongTacVien;
import com.mb.model.KhachHang;
import com.mb.model.PhatVay;
import com.mb.service.CongTacVienLocalServiceUtil;
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
		"javax.portlet.init-param.view-template=/html/thongke/phat_vay_ngay/view.jsp",
		"javax.portlet.display-name=" + QuanlyPortletKeys.phatVayNgay,
		"javax.portlet.name=" + QuanlyPortletKeys.phatVayNgay, "javax.portlet.resource-bundle=content.Language",
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
public class PhatVayNgayPortlet extends MVCPortlet {
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
		if (resourceId.equals("inPhatVayNgay")) {
			kq = inPhatVayNgay(resourceRequest, resourceResponse, serviceContext);
		}
		PrintWriter writer = resourceResponse.getWriter();
		writer.print(kq.toString());
		writer.flush();
		writer.close();

	}

	public JSONObject inPhatVayNgay(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ServiceContext serviceContext) throws IOException {
		JSONObject kq = JSONFactoryUtil.createJSONObject();
		int typeIn = ParamUtil.getInteger(resourceRequest, "typeIn");
		long ngayPhatVayTime = ParamUtil.getLong(resourceRequest, "ngayPhatVayTime");
		Date ngayPhatVay = ngayPhatVayTime != 0 ? new Date(ngayPhatVayTime) : null;
		List<CongTacVien> items = CongTacVienLocalServiceUtil.getCTVPhatVayNgay(ngayPhatVay, ngayPhatVay);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale localeEn = new Locale("en", "EN");
	    NumberFormat df = NumberFormat.getInstance(localeEn);
		if (CollectionUtils.isNotEmpty(items)) {
			try {
				InputStream in = null;
				OutputStream outStream = resourceResponse.getPortletOutputStream();
				resourceResponse.setContentType("application/XLSX");
				String tenFile = typeIn == 1 ? "TONGHOP_PHATVAYNGAY.docx" : "TONGHOP_PHATVAYNGAY.xlsx";
				resourceResponse.setProperty("Content-Disposition", "attachment; filename=\"" + tenFile + "\"");
				in = getServletContext().getResourceAsStream("report/PHAT_VAY_NGAY.jasper");
				Map<String, Object> parameters = new HashMap<String, Object>();
				Collection<Object> collections = new ArrayList<Object>();
				if (ngayPhatVay != null) {
					parameters.put("ngayThongKe", sdf.format(ngayPhatVay));
				}
				int index = 0;
				Double tongTienAll = GetterUtil.getDouble("0");
				for (CongTacVien item : items) {
					index++;
					Double tongTienCTV = GetterUtil.getDouble("0");
					List<PhatVayDTO> phatVayDTOs = new ArrayList<PhatVayDTO>();
					List<PhatVay> phatVays = PhatVayLocalServiceUtil.findBase("", item.getMa(), "", ngayPhatVay, ngayPhatVay,null,null, null, null, null, -1, -1, null);
					if (CollectionUtils.isNotEmpty(phatVays)) {
						for (PhatVay pv : phatVays) {
							tongTienCTV += pv.getSoTienVay();
							tongTienAll += pv.getSoTienVay();
							KhachHang kh = pv.getKhachHang();
							if(kh != null) {
								PhatVayDTO pvDTO = new PhatVayDTO(kh.getMa(), kh.getHoTen(), "", "", pv.getSoTienVay() > 0 ?  df.format(pv.getSoTienVay()) : "", "", "", "", "", "", pv.getSoKU(), "", "", String.valueOf(pv.getThoiHan()), "", kh.getDiaChi(), pv.getCreateDate() != null ? sdf.format(pv.getCreateDate()) : "", "");
								phatVayDTOs.add(pvDTO);
							}
						}
					}
					PhatVayDTO pvCTV = new PhatVayDTO(item.getMa(), item.getHoTen(), "", "", tongTienCTV > 0 ?  df.format(tongTienCTV) : "", "", "", "", "", "", String.valueOf(index), "", "", "", "", "", "", "");
					collections.add(pvCTV);
					collections.addAll(phatVayDTOs);
				}
				parameters.put("tongTienALL", tongTienAll > 0 ? df.format(tongTienAll) : "");
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