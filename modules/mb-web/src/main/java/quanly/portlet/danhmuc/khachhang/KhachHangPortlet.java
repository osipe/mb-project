package quanly.portlet.danhmuc.khachhang;

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
import com.mb.model.KhachHang;
import com.mb.service.KhachHangLocalServiceUtil;

import quanly.constants.QuanlyPortletKeys;

/**
 * @author Annn
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/html/danhmuc/khachhang/view.jsp",
		"javax.portlet.display-name=" + QuanlyPortletKeys.khachHang,
		"javax.portlet.name=" + QuanlyPortletKeys.khachHang, "javax.portlet.resource-bundle=content.Language",
		"com.liferay.portlet.footer-portlet-javascript=/plugins/toastr/toastr.min.js",
		"com.liferay.portlet.footer-portlet-css=/plugins/toastr/toastr.min.css",
		"com.liferay.portlet.footer-portlet-javascript=/plugins/jquery/jquery.priceformat.js",
		"com.liferay.portlet.footer-portlet-javascript=/plugins/jquery-ui/jquery-ui.min.js",
		"com.liferay.portlet.footer-portlet-css=/plugins/jquery-ui/jquery-ui.min.css",
		"com.liferay.portlet.footer-portlet-javascript=/plugins/select2/select2.js",
		"com.liferay.portlet.footer-portlet-css=/plugins/select2/select2.css",
		"com.liferay.portlet.footer-portlet-javascript=/plugins/jquery/jquery.ui.datepicker-vi.js",
		"com.liferay.portlet.footer-portlet-css=/plugins/jquery-ui/jquery-ui.min.css",
		"javax.portlet.security-role-ref=power-user,user",
		"com.liferay.portlet.footer-portlet-javascript=/js/main.js", }, service = Portlet.class)
public class KhachHangPortlet extends MVCPortlet {
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
		if (resourceId.equals("addKhachHangURL")) {
			kq = addKhachHangURL(resourceRequest, resourceResponse, serviceContext);
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
			long khachHangId = ParamUtil.getLong(resourceRequest, "khachHangId");
			if (khachHangId > 0) {
				KhachHang kh = KhachHangLocalServiceUtil.fetchKhachHang(khachHangId);
				kh.setHoatDong(!kh.getHoatDong());
				KhachHangLocalServiceUtil.updateKhachHang(kh, serviceContext);
			}
		} catch (Exception e) {
			e.printStackTrace();
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
}