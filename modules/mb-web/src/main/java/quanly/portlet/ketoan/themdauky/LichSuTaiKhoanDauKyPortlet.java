package quanly.portlet.ketoan.themdauky;

import java.io.IOException;
import java.io.PrintWriter;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.mb.exception.TrungDuLieuDauKyException;
import com.mb.model.LichSuTaiKhoanDauKy;
import com.mb.service.LichSuTaiKhoanDauKyLocalServiceUtil;

import quanly.constants.QuanlyPortletKeys;

/**
 * @author Annn
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/html/ketoan/themdauky/view.jsp",
		"javax.portlet.display-name=" + QuanlyPortletKeys.themDauKy, "javax.portlet.name=" + QuanlyPortletKeys.themDauKy,
		"javax.portlet.resource-bundle=content.Language",
		"com.liferay.portlet.footer-portlet-javascript=/plugins/toastr/toastr.min.js",
		"com.liferay.portlet.footer-portlet-css=/plugins/toastr/toastr.min.css",
		"com.liferay.portlet.footer-portlet-javascript=/plugins/jquery/jquery-3.2.1.min.js",
		"com.liferay.portlet.footer-portlet-javascript=/plugins/jquery/jquery.priceformat.js",
		"com.liferay.portlet.footer-portlet-javascript=/plugins/jquery/jquery.ui.datepicker-vi.js",
		"com.liferay.portlet.footer-portlet-javascript=/plugins/jquery-ui/jquery-ui.min.js",
		"com.liferay.portlet.footer-portlet-css=/plugins/jquery-ui/jquery-ui.min.css",
		"javax.portlet.security-role-ref=power-user,user",
		"com.liferay.portlet.footer-portlet-javascript=/js/main.js", }, service = Portlet.class)
public class LichSuTaiKhoanDauKyPortlet extends MVCPortlet {
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
		if (resourceId.equals("addURL")) {
			kq = addURL(resourceRequest, resourceResponse, serviceContext);
		} else if (resourceId.equals("xoaDauKyURL")) {
			kq = xoaDauKyURL(resourceRequest, resourceResponse, serviceContext);
		}
		PrintWriter writer = resourceResponse.getWriter();
		writer.print(kq.toString());
		writer.flush();
		writer.close();

	}
	public JSONObject xoaDauKyURL(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ServiceContext serviceContext) {
		JSONObject kq = JSONFactoryUtil.createJSONObject();
		try {
			long lichSuTaiKhoanDauKyId = ParamUtil.getLong(resourceRequest, "lichSuTaiKhoanDauKyId");
			LichSuTaiKhoanDauKyLocalServiceUtil.deleteLichSuTaiKhoanDauKy(lichSuTaiKhoanDauKyId);
		} catch (TrungDuLieuDauKyException e) {
			kq.putException(e);
		} catch (Exception e) {
			e.printStackTrace();
			kq.putException(e);
		}
		return kq;
	}

	public JSONObject addURL(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ServiceContext serviceContext) {
		JSONObject kq = JSONFactoryUtil.createJSONObject();
		try {
			long lichSuTaiKhoanDauKyId = ParamUtil.getLong(resourceRequest, "lichSuTaiKhoanDauKyId");
			int thang = ParamUtil.getInteger(resourceRequest, "thang");
			int nam = ParamUtil.getInteger(resourceRequest, "nam");
			long taiKhoanDoiUngId = ParamUtil.getLong(resourceRequest, "taiKhoanDoiUngId");
			String soTienTonStr = ParamUtil.getString(resourceRequest, "soTienTon");
			Double soTienTon = GetterUtil.getDouble("0");
			if (Validator.isNotNull(soTienTonStr)) {
				soTienTon = GetterUtil.getDouble(soTienTonStr.replaceAll(",", ""));
			}
			LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy = LichSuTaiKhoanDauKyLocalServiceUtil.createLichSuTaiKhoanDauKy(0L);
			if (lichSuTaiKhoanDauKyId > 0) {
				lichSuTaiKhoanDauKy = LichSuTaiKhoanDauKyLocalServiceUtil.fetchLichSuTaiKhoanDauKy(lichSuTaiKhoanDauKyId);
			}
			lichSuTaiKhoanDauKy.setHoatDong(true);
			lichSuTaiKhoanDauKy.setNam(nam);
			lichSuTaiKhoanDauKy.setThang(thang);
			lichSuTaiKhoanDauKy.setTaiKhoanDoiUngId(taiKhoanDoiUngId);
			lichSuTaiKhoanDauKy.setSoTienTon(soTienTon);
			lichSuTaiKhoanDauKy.setSoTienChi(0.0);
			lichSuTaiKhoanDauKy.setSoTienThu(0.0);
			LichSuTaiKhoanDauKyLocalServiceUtil.addOrUpdateLichSuTaiKhoanDauKy(lichSuTaiKhoanDauKy, serviceContext);
		} catch (TrungDuLieuDauKyException e) {
			kq.putException(e);
		} catch (Exception e) {
			e.printStackTrace();
			kq.putException(e);
		}
		return kq;
	}

}