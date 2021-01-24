package quanly.portlet.danhmuc.chinhanh;

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
import com.mb.model.ChiNhanh;
import com.mb.service.ChiNhanhLocalServiceUtil;

import quanly.constants.QuanlyPortletKeys;

/**
 * @author Annn
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/html/danhmuc/chinhanh/view.jsp",
		"javax.portlet.display-name=" + QuanlyPortletKeys.chinhanh, "javax.portlet.name=" + QuanlyPortletKeys.chinhanh,
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
public class ChiNhanhPortlet extends MVCPortlet {
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
			long chiNhanhId = ParamUtil.getLong(resourceRequest, "chiNhanhId");
			if (chiNhanhId > 0) {
				ChiNhanh cn = ChiNhanhLocalServiceUtil.fetchChiNhanh(chiNhanhId);
				cn.setHoatDong(!cn.getHoatDong());
				ChiNhanhLocalServiceUtil.updateChiNhanh(cn, serviceContext);
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
			long chiNhanhId = ParamUtil.getLong(resourceRequest, "chiNhanhId");
			String ma = ParamUtil.getString(resourceRequest, "ma");
			String ten = ParamUtil.getString(resourceRequest, "ten");
			ChiNhanh cn = ChiNhanhLocalServiceUtil.createChiNhanh(0L);
			boolean hoatDong = true;
			if (chiNhanhId > 0) {
				cn = ChiNhanhLocalServiceUtil.fetchChiNhanh(chiNhanhId);
				hoatDong = cn.getHoatDong();
			}

			cn.setMa(ma);
			cn.setTen(ten);
			cn.setHoatDong(hoatDong);
			ChiNhanhLocalServiceUtil.addOrUpdateChiNhanh(cn, serviceContext);
		} catch (TrungMaException e) {
			kq.putException(e);
		} catch (Exception e) {
			e.printStackTrace();
			kq.putException(e);
		}
		return kq;
	}
}