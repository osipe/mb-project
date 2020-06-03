package quanly.portlet.danhmuc.laisuat;

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
import com.mb.exception.TrungMaException;
import com.mb.exception.TrungSoCMNDException;
import com.mb.model.LaiSuat;
import com.mb.service.LaiSuatLocalServiceUtil;

import quanly.constants.QuanlyPortletKeys;

/**
 * @author Annn
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/html/danhmuc/laisuat/view.jsp",
		"javax.portlet.display-name=" + QuanlyPortletKeys.laiSuat,
		"javax.portlet.name=" + QuanlyPortletKeys.laiSuat, "javax.portlet.resource-bundle=content.Language",
		"com.liferay.portlet.footer-portlet-javascript=/plugins/toastr/toastr.min.js",
		"com.liferay.portlet.footer-portlet-css=/plugins/toastr/toastr.min.css",
		"com.liferay.portlet.footer-portlet-javascript=/plugins/jquery/jquery-3.2.1.min.js",
		"com.liferay.portlet.footer-portlet-javascript=/plugins/jquery/jquery.priceformat.js",
		"com.liferay.portlet.footer-portlet-javascript=/plugins/jquery/jquery.ui.datepicker-vi.js",
		"com.liferay.portlet.footer-portlet-javascript=/plugins/jquery-ui/jquery-ui.min.js",
		"com.liferay.portlet.footer-portlet-css=/plugins/jquery-ui/jquery-ui.min.css",
		"javax.portlet.security-role-ref=power-user,user",
		"com.liferay.portlet.footer-portlet-javascript=/js/main.js", }, service = Portlet.class)
public class LaiSuatPortlet extends MVCPortlet {
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
			long laiSuatId = ParamUtil.getLong(resourceRequest, "laiSuatId");
			if (laiSuatId > 0) {
				LaiSuat ls = LaiSuatLocalServiceUtil.fetchLaiSuat(laiSuatId);
				ls.setHoatDong(!ls.getHoatDong());
				LaiSuatLocalServiceUtil.updateLaiSuat(ls, serviceContext);
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
			long laiSuatId = ParamUtil.getLong(resourceRequest, "laiSuatId");
			String soTienVayStr = ParamUtil.getString(resourceRequest, "soTienVay");
			Double soTienVay = Double.valueOf(0);
			if(Validator.isNotNull(soTienVayStr)) {
				soTienVayStr = soTienVayStr.replaceAll(",", "");
				soTienVay = GetterUtil.getDouble(soTienVayStr);
			}
			int thoiHan  = ParamUtil.getInteger(resourceRequest, "thoiHan");
			Double laiSuatVay = ParamUtil.getDouble(resourceRequest, "laiSuatVay");
			String gocNgayStr = ParamUtil.getString(resourceRequest, "gocNgay");
			Double gocNgay = Double.valueOf(0);
			if(Validator.isNotNull(gocNgayStr)) {
				gocNgayStr = gocNgayStr.replaceAll(",", "");
				gocNgay = GetterUtil.getDouble(gocNgayStr);
			}
			String laiNgayStr = ParamUtil.getString(resourceRequest, "laiNgay");
			Double laiNgay = Double.valueOf(0);
			if(Validator.isNotNull(laiNgayStr)) {
				laiNgayStr = laiNgayStr.replaceAll(",", "");
				laiNgay = GetterUtil.getDouble(laiNgayStr);
			}
			String gocNgayCuoiStr = ParamUtil.getString(resourceRequest, "gocNgayCuoi");
			Double gocNgayCuoi = Double.valueOf(0);
			if(Validator.isNotNull(gocNgayCuoiStr)) {
				gocNgayCuoiStr = gocNgayCuoiStr.replaceAll(",", "");
				gocNgayCuoi = GetterUtil.getDouble(gocNgayCuoiStr);
			}
			LaiSuat ls = LaiSuatLocalServiceUtil.createLaiSuat(0L);
			boolean hoatDong = true;
			if (laiSuatId > 0) {
				ls = LaiSuatLocalServiceUtil.fetchLaiSuat(laiSuatId);
				hoatDong = ls.getHoatDong();
			}
			ls.setSoTienVay(soTienVay);
			ls.setLaiSuatVay(laiSuatVay);
			ls.setThoiHan(thoiHan);
			ls.setGocNgay(gocNgay);
			ls.setLaiNgay(laiNgay);
			ls.setGocNgayCuoi(gocNgayCuoi);
			ls.setHoatDong(hoatDong);
			LaiSuatLocalServiceUtil.addOrUpdateLaiSuat(ls, serviceContext);
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