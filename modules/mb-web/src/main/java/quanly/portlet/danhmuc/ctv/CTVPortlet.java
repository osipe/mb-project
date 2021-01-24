package quanly.portlet.danhmuc.ctv;

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
import com.mb.model.ChiNhanh;
import com.mb.model.CongTacVien;
import com.mb.service.ChiNhanhLocalServiceUtil;
import com.mb.service.CongTacVienLocalServiceUtil;
import com.mb.service.PhatVayLocalServiceUtil;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import quanly.constants.QuanlyPortletKeys;

/**
 * @author Annn
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/html/danhmuc/ctv/view.jsp",
		"javax.portlet.display-name=" + QuanlyPortletKeys.ctv, "javax.portlet.name=" + QuanlyPortletKeys.ctv,
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
public class CTVPortlet extends MVCPortlet {
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
		if (resourceId.equals("addCTVURL")) {
			kq = addCTVURL(resourceRequest, resourceResponse, serviceContext);
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
			long congTacVienId = ParamUtil.getLong(resourceRequest, "congTacVienId");
			if (congTacVienId > 0) {
				CongTacVien ctv = CongTacVienLocalServiceUtil.fetchCongTacVien(congTacVienId);
				ctv.setHoatDong(!ctv.getHoatDong());
				CongTacVienLocalServiceUtil.updateCongTacVien(ctv, serviceContext);
			}
		} catch (Exception e) {
			e.printStackTrace();
			kq.putException(e);
		}
		return kq;
	}

	public JSONObject addCTVURL(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ServiceContext serviceContext) {
		JSONObject kq = JSONFactoryUtil.createJSONObject();
		try {
			long chiNhanhId = ParamUtil.getLong(resourceRequest, "chiNhanhId");
			long congTacVienId = ParamUtil.getLong(resourceRequest, "congTacVienId");
			String maCongTacVien = ParamUtil.getString(resourceRequest, "maCongTacVien");
			String hoTen = ParamUtil.getString(resourceRequest, "hoTen");
			String soCMND = ParamUtil.getString(resourceRequest, "soCMND");
			String duNoToiDaStr = ParamUtil.getString(resourceRequest, "duNoToiDa");
			String duNoToiDaTheChapStr = ParamUtil.getString(resourceRequest, "duNoToiDaTheChap");
			Double duNoToiDa = Double.valueOf(0);
			Double duNoToiDaTheChap = Double.valueOf(0);
			if (Validator.isNotNull(duNoToiDaStr)) {
				duNoToiDaStr = duNoToiDaStr.replaceAll(",", "");
				duNoToiDa = GetterUtil.getDouble(duNoToiDaStr);
			}
			if (Validator.isNotNull(duNoToiDaTheChapStr)) {
				duNoToiDaTheChapStr = duNoToiDaTheChapStr.replaceAll(",", "");
				duNoToiDaTheChap = GetterUtil.getDouble(duNoToiDaTheChapStr);
			}
			String diaChi = ParamUtil.getString(resourceRequest, "diaChi");
			String ghiChu = ParamUtil.getString(resourceRequest, "ghiChu");
			if (duNoToiDaTheChap > duNoToiDa) {
				kq.put("exception", "ERRORDATA");
			} else {
				CongTacVien ctv = CongTacVienLocalServiceUtil.createCongTacVien(0L);
				boolean hoatDong = true;
				if (congTacVienId > 0) {
					ctv = CongTacVienLocalServiceUtil.fetchCongTacVien(congTacVienId);
					hoatDong = ctv.getHoatDong();
				}
				if (chiNhanhId > 0 && ctv.getChiNhanhId() != chiNhanhId) {
					ChiNhanh chinhanh = ChiNhanhLocalServiceUtil.fetchChiNhanh(chiNhanhId);
					if (chinhanh != null) {
						ctv.setTenChiNhanh(chinhanh.getTen());
					}
					PhatVayLocalServiceUtil.updateChiNhanh(maCongTacVien, chiNhanhId);
				}
				ctv.setChiNhanhId(chiNhanhId);
				ctv.setMa(maCongTacVien);
				ctv.setHoTen(hoTen);
				ctv.setSoCMND(soCMND);
				ctv.setDuNoToiDa(duNoToiDa);
				ctv.setDuNoToiDaTheChap(duNoToiDaTheChap);
				ctv.setDiaChi(diaChi);
				ctv.setGhiChu(ghiChu);
				ctv.setHoatDong(hoatDong);
				CongTacVienLocalServiceUtil.addOrUpdateCongTacVien(ctv, serviceContext);
			}
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