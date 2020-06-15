package quanly.portlet.danhmuc.taikhoandoiung;

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
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.mb.exception.TrungMaException;
import com.mb.exception.TrungSoCMNDException;
import com.mb.exception.TrungSoHieuException;
import com.mb.model.TaiKhoanDoiUng;
import com.mb.service.TaiKhoanDoiUngLocalServiceUtil;

import quanly.constants.QuanlyPortletKeys;

/**
 * @author Annn
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/html/danhmuc/taikhoandoiung/view.jsp",
		"javax.portlet.display-name=" + QuanlyPortletKeys.taiKhoanDoiUng,
		"javax.portlet.name=" + QuanlyPortletKeys.taiKhoanDoiUng, "javax.portlet.resource-bundle=content.Language",
		"com.liferay.portlet.footer-portlet-javascript=/plugins/toastr/toastr.min.js",
		"com.liferay.portlet.footer-portlet-css=/plugins/toastr/toastr.min.css",
		"com.liferay.portlet.footer-portlet-javascript=/plugins/jquery/jquery-3.2.1.min.js",
		"com.liferay.portlet.footer-portlet-javascript=/plugins/jquery/jquery.priceformat.js",
		"com.liferay.portlet.footer-portlet-javascript=/plugins/jquery/jquery.ui.datepicker-vi.js",
		"com.liferay.portlet.footer-portlet-javascript=/plugins/jquery-ui/jquery-ui.min.js",
		"com.liferay.portlet.footer-portlet-css=/plugins/jquery-ui/jquery-ui.min.css",
		"javax.portlet.security-role-ref=power-user,user",
		"com.liferay.portlet.footer-portlet-javascript=/js/main.js", }, service = Portlet.class)
public class TaiKhoanDoiUngPortlet extends MVCPortlet {
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
		} else if (resourceId.equals("hoatDongURL")) {
			kq = hoatDongURL(resourceRequest, resourceResponse, serviceContext);
		}
		PrintWriter writer = resourceResponse.getWriter();
		writer.print(kq.toString());
		writer.flush();
		writer.close();

	}

	public JSONObject hoatDongURL(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ServiceContext serviceContext) {
		JSONObject kq = JSONFactoryUtil.createJSONObject();
		try {
			long taiKhoanDoiUngId = ParamUtil.getLong(resourceRequest, "taiKhoanDoiUngId");
			if (taiKhoanDoiUngId > 0) {
				TaiKhoanDoiUng taiKhoanDoiUng = TaiKhoanDoiUngLocalServiceUtil.fetchTaiKhoanDoiUng(taiKhoanDoiUngId);
				taiKhoanDoiUng.setHoatDong(!taiKhoanDoiUng.getHoatDong());
				TaiKhoanDoiUngLocalServiceUtil.updateTaiKhoanDoiUng(taiKhoanDoiUng);
			}
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
			long taiKhoanDoiUngId = ParamUtil.getLong(resourceRequest, "taiKhoanDoiUngId");
			long taiKhoanDoiUngChaId = ParamUtil.getLong(resourceRequest, "taiKhoanDoiUngChaId");
			String ten = ParamUtil.getString(resourceRequest, "ten");
			String soHieu = ParamUtil.getString(resourceRequest, "soHieu");
			int loaiTaiKhoan = ParamUtil.getInteger(resourceRequest, "loaiTaiKhoan");
			TaiKhoanDoiUng taiKhoanDoiUng = TaiKhoanDoiUngLocalServiceUtil.createTaiKhoanDoiUng(0L);
			boolean hoatDong = true;
			if (taiKhoanDoiUngId > 0) {
				taiKhoanDoiUng = TaiKhoanDoiUngLocalServiceUtil.fetchTaiKhoanDoiUng(taiKhoanDoiUngId);
				hoatDong = taiKhoanDoiUng.getHoatDong();
			}
			taiKhoanDoiUng.setLoaiTaiKhoan(loaiTaiKhoan);
			taiKhoanDoiUng.setTen(ten);
			taiKhoanDoiUng.setTaiKhoanDoiUngChaId(taiKhoanDoiUngChaId);
			taiKhoanDoiUng.setSoHieu(soHieu);
			taiKhoanDoiUng.setHoatDong(hoatDong);
			TaiKhoanDoiUngLocalServiceUtil.addOrUpdateCongTacVien(taiKhoanDoiUng, serviceContext);
		}  catch (TrungSoHieuException e) {
			kq.putException(e);
		} catch (Exception e) {
			e.printStackTrace();
			kq.putException(e);
		}
		return kq;
	}
}