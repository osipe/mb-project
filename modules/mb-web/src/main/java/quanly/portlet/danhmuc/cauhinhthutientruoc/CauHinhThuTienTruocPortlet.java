package quanly.portlet.danhmuc.cauhinhthutientruoc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

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
import com.mb.model.CauHinhThuTienTruoc;
import com.mb.service.CauHinhThuTienTruocLocalServiceUtil;

import quanly.constants.QuanlyPortletKeys;

/**
 * @author Annn
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/html/danhmuc/cauhinhthutientruoc/view.jsp",
		"javax.portlet.display-name=" + QuanlyPortletKeys.cauhinhthutientruoc,
		"javax.portlet.name=" + QuanlyPortletKeys.cauhinhthutientruoc, "javax.portlet.resource-bundle=content.Language",
		"com.liferay.portlet.footer-portlet-javascript=/plugins/toastr/toastr.min.js",
		"com.liferay.portlet.footer-portlet-css=/plugins/toastr/toastr.min.css",
		"com.liferay.portlet.footer-portlet-javascript=/plugins/jquery/jquery.priceformat.js",
		"com.liferay.portlet.footer-portlet-javascript=/plugins/jquery-ui/jquery-ui.min.js",
		"com.liferay.portlet.footer-portlet-css=/plugins/jquery-ui/jquery-ui.min.css",
		"com.liferay.portlet.footer-portlet-javascript=/plugins/select2/select2.js",
		"com.liferay.portlet.footer-portlet-css=/plugins/select2/select2.css",
		"com.liferay.portlet.footer-portlet-javascript=/plugins/jquery/jquery.ui.datepicker-vi.js",
		"com.liferay.portlet.footer-portlet-css=/plugins/jquery-ui/jquery-ui.min.css",
		"com.liferay.portlet.footer-portlet-javascript=/plugins/jquery/jquery.mask.min.js",
		"javax.portlet.security-role-ref=power-user,user",
		"com.liferay.portlet.footer-portlet-javascript=/js/main.js", }, service = Portlet.class)
public class CauHinhThuTienTruocPortlet extends MVCPortlet {
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
		if (resourceId.equals("add")) {
			kq = add(resourceRequest, resourceResponse, serviceContext);
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
			long cauHinhThuTienTruocId = ParamUtil.getLong(resourceRequest, "cauHinhThuTienTruocId");
			CauHinhThuTienTruoc cauHinhThuTienTruoc = CauHinhThuTienTruocLocalServiceUtil.createCauHinhThuTienTruoc(0L);
			if (cauHinhThuTienTruocId > 0) {
				cauHinhThuTienTruoc = CauHinhThuTienTruocLocalServiceUtil
						.fetchCauHinhThuTienTruoc(cauHinhThuTienTruocId);
				cauHinhThuTienTruoc.setHoatDong(!cauHinhThuTienTruoc.getHoatDong());
				CauHinhThuTienTruocLocalServiceUtil.updateCauHinhThuTienTruoc(cauHinhThuTienTruoc);
			}
		} catch (Exception e) {
			e.printStackTrace();
			kq.putException(e);
		}
		return kq;
	}

	public JSONObject add(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ServiceContext serviceContext) {
		JSONObject kq = JSONFactoryUtil.createJSONObject();
		try {
			long cauHinhThuTienTruocId = ParamUtil.getLong(resourceRequest, "cauHinhThuTienTruocId");
			int nam = ParamUtil.getInteger(resourceRequest, "nam");
			CauHinhThuTienTruoc CauHinhThuTienTruocCheck =  CauHinhThuTienTruocLocalServiceUtil.fetchByNam(nam);
			if(CauHinhThuTienTruocCheck != null && CauHinhThuTienTruocCheck.getCauHinhThuTienTruocId() != cauHinhThuTienTruocId) {
				kq.put("exception","Trung-Nam");
				kq.put("TrungNam",true);
				 throw new Exception();
			}
			
			long ngayTuTime = ParamUtil.getLong(resourceRequest, "ngayTuTime");
			long ngayDenTime = ParamUtil.getLong(resourceRequest, "ngayDenTime");
			Date ngayTu = ngayTuTime != 0 ? new Date(ngayTuTime) : null;
			Date ngayDen = ngayDenTime != 0 ? new Date(ngayDenTime) : null;
			boolean hoatDong = true;
			CauHinhThuTienTruoc cauHinhThuTienTruoc = CauHinhThuTienTruocLocalServiceUtil.createCauHinhThuTienTruoc(0L);
			if (cauHinhThuTienTruocId > 0) {
				cauHinhThuTienTruoc = CauHinhThuTienTruocLocalServiceUtil
						.fetchCauHinhThuTienTruoc(cauHinhThuTienTruocId);
			}
			if (cauHinhThuTienTruoc == null) {
				cauHinhThuTienTruoc = CauHinhThuTienTruocLocalServiceUtil.createCauHinhThuTienTruoc(0L);
			}
			cauHinhThuTienTruoc.setNam(nam);
			cauHinhThuTienTruoc.setNgayDen(ngayDen);
			cauHinhThuTienTruoc.setNgayTu(ngayTu);
			cauHinhThuTienTruoc.setHoatDong(hoatDong);
			CauHinhThuTienTruocLocalServiceUtil.addOrUpdate(cauHinhThuTienTruoc, serviceContext);
		} catch (Exception e) {
			e.printStackTrace();
			kq.putException(e);
		}
		return kq;
	}
}