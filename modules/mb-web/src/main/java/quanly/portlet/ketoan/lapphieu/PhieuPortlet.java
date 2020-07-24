package quanly.portlet.ketoan.lapphieu;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.collections.CollectionUtils;
import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.mb.model.CongTacVien;
import com.mb.model.DsPhieuTaiKhoan;
import com.mb.model.MaSoThuChi;
import com.mb.model.Phieu;
import com.mb.model.QuanLyMaSo;
import com.mb.model.TaiKhoanDoiUng;
import com.mb.service.CongTacVienLocalServiceUtil;
import com.mb.service.DsPhieuTaiKhoanLocalServiceUtil;
import com.mb.service.MaSoThuChiLocalServiceUtil;
import com.mb.service.PhieuLocalServiceUtil;
import com.mb.service.QuanLyMaSoLocalServiceUtil;
import com.mb.service.TaiKhoanDoiUngLocalServiceUtil;

import quanly.constants.QuanlyPortletKeys;

/**
 * @author Annn
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/html/ketoan/lapphieu/view.jsp",
		"javax.portlet.display-name=" + QuanlyPortletKeys.phieu, "javax.portlet.name=" + QuanlyPortletKeys.phieu,
		"javax.portlet.resource-bundle=content.Language",
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
public class PhieuPortlet extends MVCPortlet {
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
		} else if (resourceId.equals("getSoPhieuURL")) {
			kq = getSoPhieuURL(resourceRequest, resourceResponse, serviceContext);
		} else if (resourceId.equals("getMaSoThuChiURL")) {
			kq = getMaSoThuChiURL(resourceRequest, resourceResponse, serviceContext);
		} else if (resourceId.equals("getCTVURL")) {
			kq = getCTVURL(resourceRequest, resourceResponse, serviceContext);
		} else if (resourceId.equals("getTaiKhoanDoiUngURL")) {
			kq = getTaiKhoanDoiUngURL(resourceRequest, resourceResponse, serviceContext);
		} else if (resourceId.equals("getMaSoTheoDoiURL")) {
			kq = getMaSoTheoDoiURL(resourceRequest, resourceResponse, serviceContext);
		} else if (resourceId.equals("getDienGiaiTheoDoiURL")) {
			kq = getDienGiaiTheoDoiURL(resourceRequest, resourceResponse, serviceContext);
		}
		PrintWriter writer = resourceResponse.getWriter();
		writer.print(kq.toString());
		writer.flush();
		writer.close();

	}
	public JSONObject getDienGiaiTheoDoiURL(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ServiceContext serviceContext) {
		JSONObject kq = JSONFactoryUtil.createJSONObject();
		try {
			long taiKhoanDoiUngId = ParamUtil.getLong(resourceRequest, "taiKhoanDoiUngId");
			if(taiKhoanDoiUngId > 0) {
				TaiKhoanDoiUng taikhoan = TaiKhoanDoiUngLocalServiceUtil.fetchTaiKhoanDoiUng(taiKhoanDoiUngId);
				if(taikhoan != null) {
					kq.put("dienGiaiTheoDoi", taikhoan.getDienGiaiTheoDoi());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			kq.putException(e);
		}
		return kq;
	}

	public JSONObject getMaSoTheoDoiURL(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ServiceContext serviceContext) {
		JSONObject kq = JSONFactoryUtil.createJSONObject();
		List<CongTacVien> congTacViens = new ArrayList<CongTacVien>();
		try {
			congTacViens = CongTacVienLocalServiceUtil.findBase("", "", "", "", 1, -1, -1, null);
			if (CollectionUtils.isNotEmpty(congTacViens)) {
				JSONArray array = JSONFactoryUtil.createJSONArray(JSONFactoryUtil.looseSerialize(congTacViens));
				kq.put("congTacViens", array);
			}
		} catch (Exception e) {
			e.printStackTrace();
			kq.putException(e);
		}
		return kq;
	}

	public JSONObject getTaiKhoanDoiUngURL(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ServiceContext serviceContext) {
		JSONObject kq = JSONFactoryUtil.createJSONObject();
		List<TaiKhoanDoiUng> taiKhoanDoiUngs = new ArrayList<TaiKhoanDoiUng>();
		try {
			taiKhoanDoiUngs = TaiKhoanDoiUngLocalServiceUtil.findByLoaiTaiKhoan_HoatDong(1, true);
			if (CollectionUtils.isNotEmpty(taiKhoanDoiUngs)) {
				JSONArray array = JSONFactoryUtil.createJSONArray(JSONFactoryUtil.looseSerialize(taiKhoanDoiUngs));
				kq.put("taiKhoanDoiUngs", array);
			}
		} catch (Exception e) {
			e.printStackTrace();
			kq.putException(e);
		}
		return kq;
	}

	public JSONObject getCTVURL(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ServiceContext serviceContext) {
		JSONObject kq = JSONFactoryUtil.createJSONObject();
		try {
			String maCTV = ParamUtil.getString(resourceRequest, "maCTV");
			if (Validator.isNotNull(maCTV)) {
				CongTacVien ctv = CongTacVienLocalServiceUtil.fetchByMa(maCTV);
				if (ctv != null) {
					kq.put("diaChiCTV", ctv.getDiaChi());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			kq.putException(e);
		}
		return kq;
	}

	public JSONObject getMaSoThuChiURL(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ServiceContext serviceContext) {
		JSONObject kq = JSONFactoryUtil.createJSONObject();
		try {
			String maMSThuChi = ParamUtil.getString(resourceRequest, "maMSThuChi");
			int loai = ParamUtil.getInteger(resourceRequest, "loai");
			if (Validator.isNotNull(maMSThuChi)) {
				MaSoThuChi mstc = MaSoThuChiLocalServiceUtil.fetchByMa_Loai_HoatDong(maMSThuChi, loai, true);
				if (mstc != null) {
					kq.put("dienGiai", mstc.getDienGiai());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			kq.putException(e);
		}
		return kq;
	}

	public JSONObject getSoPhieuURL(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ServiceContext serviceContext) {
		JSONObject kq = JSONFactoryUtil.createJSONObject();
		try {
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			int loai = ParamUtil.getInteger(resourceRequest, "loai");
			long ngayChungTuTime = ParamUtil.getLong(resourceRequest, "ngayChungTuTime");
			Date ngayChungTu = ngayChungTuTime != 0 ? new Date(ngayChungTuTime) : now;
			if (loai > 0) {
				QuanLyMaSo quanLyMaSo = QuanLyMaSoLocalServiceUtil.fetchByKey(sdf.format(ngayChungTu) + "_" + loai);
				if (quanLyMaSo == null) {
					quanLyMaSo = QuanLyMaSoLocalServiceUtil.createQuanLyMaSo(0L);
					quanLyMaSo.setSo(0);
					quanLyMaSo.setKey(sdf.format(ngayChungTu) + "_" + loai);
					quanLyMaSo = QuanLyMaSoLocalServiceUtil.addQuanLyMaSo(quanLyMaSo, serviceContext);
				}
				kq.put("soPhieu", quanLyMaSo.getSo() + 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			kq.putException(e);
		}
		return kq;
	}

	public JSONObject hoatDongURL(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ServiceContext serviceContext) {
		JSONObject kq = JSONFactoryUtil.createJSONObject();
		try {
			long phieuId = ParamUtil.getLong(resourceRequest, "phieuId");
			if (phieuId > 0) {
				List<DsPhieuTaiKhoan> dsPhieuTaiKhoans = DsPhieuTaiKhoanLocalServiceUtil.findByPhieuId(phieuId);
				for (DsPhieuTaiKhoan item : dsPhieuTaiKhoans) {
					item.setHoatDong(!item.getHoatDong());
					DsPhieuTaiKhoanLocalServiceUtil.updateDsPhieuTaiKhoan(item, serviceContext);
				}
				Phieu phieu = PhieuLocalServiceUtil.fetchPhieu(phieuId);
				phieu.setHoatDong(!phieu.getHoatDong());
				PhieuLocalServiceUtil.updatePhieu(phieu, serviceContext);
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
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			long phieuId = ParamUtil.getLong(resourceRequest, "phieuId");
			String maMSThuChi = ParamUtil.getString(resourceRequest, "maMSThuChi");
			String maCTV = ParamUtil.getString(resourceRequest, "maCTV");
			String soTien = ParamUtil.getString(resourceRequest, "soTien");
			int soPhieu = ParamUtil.getInteger(resourceRequest, "soPhieu");
			long ngayChungTuTime = ParamUtil.getLong(resourceRequest, "ngayChungTuTime");
			Date ngayChungTu = ngayChungTuTime != 0 ? new Date(ngayChungTuTime) : null;
			long ngayGhiSoTime = ParamUtil.getLong(resourceRequest, "ngayGhiSoTime");
			Date ngayGhiSo = ngayGhiSoTime != 0 ? new Date(ngayGhiSoTime) : null;
			int loai = ParamUtil.getInteger(resourceRequest, "loai");
			Phieu phieu = PhieuLocalServiceUtil.createPhieu(0L);
			boolean hoatDong = true;
			int soPhieuDaTonTai = PhieuLocalServiceUtil.countBase("", "", String.valueOf(soPhieu), ngayChungTu,
					ngayChungTu, loai, 1);
			boolean error = false;
			if (phieuId > 0) {
				phieu = PhieuLocalServiceUtil.fetchPhieu(phieuId);
				hoatDong = phieu.getHoatDong();
				if (soPhieuDaTonTai > 0) {
					List<Phieu> phieus = PhieuLocalServiceUtil.findBase("", "", String.valueOf(soPhieu), ngayChungTu,
							ngayChungTu, loai, 1, -1, -1, null);
					if(!phieus.contains(phieu)) {
						error = true;
						kq.put("exception", "TonSo");
					}
				}
			} else {
				if (soPhieuDaTonTai > 0) {
					error = true;
					kq.put("exception", "TonSo");
				}
			}
			if (!error) {
				phieu.setMaCTV(maCTV);
				if (Validator.isNotNull(maCTV)) {
					CongTacVien ctv = CongTacVienLocalServiceUtil.fetchByMa(maCTV);
					if (ctv != null) {
						phieu.setHoTenCTV(ctv.getHoTen());
						phieu.setDiaChi(ctv.getDiaChi());
					}
				}
				phieu.setNgayChungTu(ngayChungTu);
				phieu.setSoPhieu(String.valueOf(soPhieu));
				phieu.setNgayGhiSo(ngayGhiSo);
				phieu.setMaMSThuChi(maMSThuChi);
				phieu.setLoai(loai);
				if (Validator.isNotNull(soTien)) {
					phieu.setSoTien(GetterUtil.getDouble(soTien.replaceAll(",", "")));
				}
				phieu.setHoatDong(hoatDong);
				PhieuLocalServiceUtil.addOrUpdatePhieu(phieu, serviceContext);
				String dsPhieuTaiKhoan = ParamUtil.getString(resourceRequest, "dsPhieuTaiKhoan");
				if (Validator.isNotNull(dsPhieuTaiKhoan)) {
					JSONArray dsPhieuTaiKhoanJSONArray = JSONFactoryUtil.createJSONArray(dsPhieuTaiKhoan);
					phieu.setDsPhieuTaiKhoanJSONArray(dsPhieuTaiKhoanJSONArray);
					DsPhieuTaiKhoanLocalServiceUtil.addOrUpdateDsPhieuTaiKhoan(phieu, serviceContext);
				}
				if (loai > 0 && phieuId == 0) {
					QuanLyMaSo quanLyMaSo = QuanLyMaSoLocalServiceUtil.fetchByKey(sdf.format(ngayChungTu) + "_" + loai);
					if (quanLyMaSo == null) {
						quanLyMaSo = QuanLyMaSoLocalServiceUtil.createQuanLyMaSo(0L);
						quanLyMaSo.setSo(soPhieu);
						quanLyMaSo.setKey(sdf.format(ngayChungTu) + "_" + loai);
						quanLyMaSo = QuanLyMaSoLocalServiceUtil.addQuanLyMaSo(quanLyMaSo, serviceContext);
					} else {
						quanLyMaSo.setSo(soPhieu);
						QuanLyMaSoLocalServiceUtil.updateQuanLyMaSo(quanLyMaSo, serviceContext);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			kq.putException(e);
		}
		return kq;
	}
}