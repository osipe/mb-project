package quanly.portlet.ketoan.so;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.mb.model.DsPhieuTaiKhoan;
import com.mb.model.LichSuTaiKhoanDauKy;
import com.mb.model.Phieu;
import com.mb.model.TaiKhoanDoiUng;
import com.mb.service.DsPhieuTaiKhoanLocalServiceUtil;
import com.mb.service.LichSuTaiKhoanDauKyLocalServiceUtil;
import com.mb.service.TaiKhoanDoiUngLocalServiceUtil;

import quanly.constants.FileType;
import quanly.constants.QuanlyPortletKeys;
import quanly.dto.LichSuThuChiDTO;
import quanly.dto.TongSoDTO;
import quanly.portlet.danhmuc.taikhoandoiung.TaiKhoanDoiUngComparator;
import quanly.util.JasperReportUtil;

/**
 * @author Annn
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/html/ketoan/so/view.jsp",
		"javax.portlet.display-name=" + QuanlyPortletKeys.so, "javax.portlet.name=" + QuanlyPortletKeys.so,
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
public class SoPortlet extends MVCPortlet {
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
		if (resourceId.equals("capNhatDuLieuDauKyURL")) {
			kq = capNhatDuLieuDauKyURL(resourceRequest, resourceResponse, serviceContext);
		} else if (resourceId.equals("inSoCaiURL")) {
			kq = printSoCai(resourceRequest, resourceResponse, serviceContext);
		} else if (resourceId.equals("inSoQuyTienMatURL")) {
			kq = printSoQuyTienMat(resourceRequest, resourceResponse, serviceContext);
		} else if (resourceId.equals("inTongSoURL")) {
			kq = printTongSo(resourceRequest, resourceResponse, serviceContext);
		}
		PrintWriter writer = resourceResponse.getWriter();
		writer.print(kq.toString());
		writer.flush();
		writer.close();

	}

	public JSONObject printTongSo(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ServiceContext serviceContext) throws IOException {
		JSONObject kq = JSONFactoryUtil.createJSONObject();
		int thang = ParamUtil.getInteger(resourceRequest, "thang");
		int nam = ParamUtil.getInteger(resourceRequest, "nam");
		int typeIn = ParamUtil.getInteger(resourceRequest, "typeIn");
		TaiKhoanDoiUng taiKhoanTienMat = TaiKhoanDoiUngLocalServiceUtil
				.fetchBySoHieu(PropsUtil.get("config.taikhoantienmat"));
		if (taiKhoanTienMat != null) {
			try {
				InputStream in = null;
				OutputStream outStream = resourceResponse.getPortletOutputStream();
				resourceResponse.setContentType("application/XLSX");
				String tenFile = typeIn == 1 ? "TONG_SO.docx" : "TONG_SO.xlsx";
				resourceResponse.setProperty("Content-Disposition", "attachment; filename=\"" + tenFile + "\"");
				in = getServletContext().getResourceAsStream("report/TONG_SO.jasper");
				Map<String, Object> parameters = new HashMap<String, Object>();
				parameters.put("thang", thang);
				parameters.put("nam", nam);
				Calendar calTu = Calendar.getInstance();
				calTu.set(nam, thang - 1, 1);
				Date ngayChungTuTu = calTu.getTime();
				Calendar calDen = Calendar.getInstance();
				calDen.set(nam, thang - 1, CalendarUtil.getDaysInMonth(calTu));
				Date ngayChungTuDen = calDen.getTime();
				Collection<Object> collections = new ArrayList<Object>();
				DecimalFormat df = new DecimalFormat("###,###.###");

				Double soTienThuTM = GetterUtil.getDouble("0");
				Double soTienChiTM = GetterUtil.getDouble("0");
				LichSuTaiKhoanDauKy lichSuTaiKhoanDauKyTM = LichSuTaiKhoanDauKyLocalServiceUtil
						.fetchByTaiKhoanDoiUngId_Nam_Thang(taiKhoanTienMat.getTaiKhoanDoiUngId(), nam, thang);
				List<DsPhieuTaiKhoan> dsPhieuTaiKhoansTM = DsPhieuTaiKhoanLocalServiceUtil
						.getDSThuChiByTaiKhoanNgayChungTu(taiKhoanTienMat.getTaiKhoanDoiUngId(), "", ngayChungTuTu,
								ngayChungTuDen, 1, -1, -1, null);
				for (DsPhieuTaiKhoan dsPhieuTaiKhoan : dsPhieuTaiKhoansTM) {
					// 1 Thu
					if (dsPhieuTaiKhoan.getPhieu().getLoai() == 1) {
						soTienThuTM += dsPhieuTaiKhoan.getSoTien();
						// 2 Chi
					} else if (dsPhieuTaiKhoan.getPhieu().getLoai() == 2) {
						soTienChiTM += dsPhieuTaiKhoan.getSoTien();
					}
				}
				Double soTienTonTM = (lichSuTaiKhoanDauKyTM != null && lichSuTaiKhoanDauKyTM.getSoTienTon() != null)
						? lichSuTaiKhoanDauKyTM.getSoTienTon()
						: GetterUtil.getDouble("0");
				soTienTonTM = soTienTonTM + soTienThuTM - soTienChiTM;
				collections.add(new TongSoDTO("I.", taiKhoanTienMat.getTen(), taiKhoanTienMat.getSoHieu(),
						(lichSuTaiKhoanDauKyTM != null && lichSuTaiKhoanDauKyTM.getSoTienTon() != null)
								? df.format(lichSuTaiKhoanDauKyTM.getSoTienTon())
								: "",
						df.format(soTienThuTM), df.format(soTienChiTM), df.format(soTienTonTM)));

				TaiKhoanDoiUngComparator comparator = new TaiKhoanDoiUngComparator("CAST(soHieu AS bigint)",true);
				List<TaiKhoanDoiUng> taiKhoanDoiUngs = TaiKhoanDoiUngLocalServiceUtil
						.findBase(taiKhoanTienMat.getTaiKhoanDoiUngId(), "", "", 1, -1, -1, comparator);
				int muc = 0;
				for (TaiKhoanDoiUng taiKhoanDoiUng : taiKhoanDoiUngs) {
					Double soTienThu = GetterUtil.getDouble("0");
					Double soTienChi = GetterUtil.getDouble("0");
					muc++;
					LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy = LichSuTaiKhoanDauKyLocalServiceUtil
							.fetchByTaiKhoanDoiUngId_Nam_Thang(taiKhoanDoiUng.getTaiKhoanDoiUngId(), nam, thang);
					List<DsPhieuTaiKhoan> dsPhieuTaiKhoans = DsPhieuTaiKhoanLocalServiceUtil
							.getDSThuChiByTaiKhoanNgayChungTu(taiKhoanDoiUng.getTaiKhoanDoiUngId(), "", ngayChungTuTu,
									ngayChungTuDen, 1, -1, -1, null);
					for (DsPhieuTaiKhoan dsPhieuTaiKhoan : dsPhieuTaiKhoans) {
						// 1 Thu
						if (dsPhieuTaiKhoan.getPhieu().getLoai() == 1) {
							soTienThu += dsPhieuTaiKhoan.getSoTien();
							// 2 Chi
						} else if (dsPhieuTaiKhoan.getPhieu().getLoai() == 2) {
							soTienChi += dsPhieuTaiKhoan.getSoTien();
						}
					}
					Double soTienTon = (lichSuTaiKhoanDauKy != null && lichSuTaiKhoanDauKy.getSoTienTon() != null)
							? lichSuTaiKhoanDauKy.getSoTienTon()
							: GetterUtil.getDouble("0");
					if (taiKhoanDoiUng.getSoHieu().equals(PropsUtil.get("config.taikhoanthuvon"))) {
						soTienTon = soTienTon + soTienChi - soTienThu;
					} else {
						soTienTon = soTienTon + soTienThu - soTienChi;
					}
					collections.add(new TongSoDTO(muc + ".", taiKhoanDoiUng.getTen(), taiKhoanDoiUng.getSoHieu(),
							(lichSuTaiKhoanDauKy != null && lichSuTaiKhoanDauKy.getSoTienTon() != null)
									? df.format(lichSuTaiKhoanDauKy.getSoTienTon())
									: "",
							df.format(soTienThu), df.format(soTienChi), df.format(soTienTon)));
				}
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

	public JSONObject printSoQuyTienMat(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ServiceContext serviceContext) throws IOException {
		JSONObject kq = JSONFactoryUtil.createJSONObject();
		int thang = ParamUtil.getInteger(resourceRequest, "thang");
		int nam = ParamUtil.getInteger(resourceRequest, "nam");
		int typeIn = ParamUtil.getInteger(resourceRequest, "typeIn");
		long taiKhoanDoiUngId = ParamUtil.getLong(resourceRequest, "taiKhoanDoiUngId");
		if (taiKhoanDoiUngId > 0 && thang > 0 && nam > 0) {
			try {
				InputStream in = null;
				OutputStream outStream = resourceResponse.getPortletOutputStream();
				resourceResponse.setContentType("application/XLSX");
				String tenFile = typeIn == 1 ? "SO_QUY.docx" : "SO_QUY.xlsx";
				resourceResponse.setProperty("Content-Disposition", "attachment; filename=\"" + tenFile + "\"");
				in = getServletContext().getResourceAsStream("report/SO_QUY_TIEN_MAT.jasper");
				Map<String, Object> parameters = new HashMap<String, Object>();
				TaiKhoanDoiUng tkdu = TaiKhoanDoiUngLocalServiceUtil.fetchTaiKhoanDoiUng(taiKhoanDoiUngId);
				parameters.put("tenTaiKhoan", tkdu.getTen());
				parameters.put("soHieuTaiKhoan", tkdu.getSoHieu());
				parameters.put("tenCongTy", GetterUtil.getString(PropsUtil.get("thongtin.cty.ten")));
				parameters.put("diaChiCongTy", GetterUtil.getString(PropsUtil.get("thongtin.cty.diachi")));
				parameters.put("thang", thang);
				parameters.put("nam", nam);
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				DecimalFormat df = new DecimalFormat("###,###.###");
				LichSuTaiKhoanDauKy dauKy = LichSuTaiKhoanDauKyLocalServiceUtil
						.fetchByTaiKhoanDoiUngId_Nam_Thang(taiKhoanDoiUngId, nam, thang);
				Double soTien = dauKy.getSoTienTon() != null ? dauKy.getSoTienTon() : GetterUtil.getDouble("0");
				Collection<Object> collections = new ArrayList<Object>();
				if (dauKy != null) {
					LichSuThuChiDTO lichSuThuChiDTO = new LichSuThuChiDTO("", "", "", "", "", "SO DAU KY", "", "", "",
							dauKy.getSoTienTon() > 0 ? df.format(dauKy.getSoTienTon()) : "");
					collections.add(lichSuThuChiDTO);
				}
				Calendar calTu = Calendar.getInstance();
				calTu.set(nam, thang - 1, 1);
				Date ngayChungTuTu = calTu.getTime();
				Calendar calDen = Calendar.getInstance();
				calDen.set(nam, thang - 1, CalendarUtil.getDaysInMonth(calTu));
				Date ngayChungTuDen = calDen.getTime();
				List<DsPhieuTaiKhoan> dsPhieuTaiKhoans = DsPhieuTaiKhoanLocalServiceUtil
						.getDSThuChiByTaiKhoanNgayChungTu(taiKhoanDoiUngId, "", ngayChungTuTu, ngayChungTuDen, 1, -1,
								-1, null);
				SimpleDateFormat sdfSo = new SimpleDateFormat("ddMMyyyy");
				if (CollectionUtils.isNotEmpty(dsPhieuTaiKhoans)) {
					boolean inNgay = true;
					String ngayChungTu = "";
					String ngayGhiSo = "";
					for (DsPhieuTaiKhoan dsPhieuTaiKhoan : dsPhieuTaiKhoans) {
						String soHieuThu = "";
						String soHieuChi = "";
						String dienGiai = "";
						String tenTaiKhoanDoiUng = "";
						String soTienThu = "";
						String soTienChi = "";
						String soTienTon = "";
						if (dsPhieuTaiKhoan.getPhieu() != null) {
							Phieu phieu = dsPhieuTaiKhoan.getPhieu();
							if (phieu.getNgayGhiSo() != null && !ngayGhiSo.equals(sdf.format(phieu.getNgayGhiSo()))) {
								ngayGhiSo = sdf.format(phieu.getNgayGhiSo());
								inNgay = true;
							} else {
								inNgay = false;
							}
							dienGiai = phieu.getCtv().getHoTen() + "( " + dsPhieuTaiKhoan.getDienGiaiTheoDoi() + " )";
							if (phieu.getLoai() == 1 && dsPhieuTaiKhoan.getSoTien() > 0) {
								soTienThu = df.format(dsPhieuTaiKhoan.getSoTien());
								soTien += dsPhieuTaiKhoan.getSoTien();
								soTienTon = "+" + soTienThu;
								soHieuThu = phieu.getSoPhieu() + "/" + sdfSo.format(dsPhieuTaiKhoan.getNgayChungTu())
										+ phieu.getMaMSThuChi();
							}
							if (phieu.getLoai() == 2 && dsPhieuTaiKhoan.getSoTien() > 0) {
								soTienChi = df.format(dsPhieuTaiKhoan.getSoTien());
								soTien -= dsPhieuTaiKhoan.getSoTien();
								soTienTon = "-" + soTienChi;
								soHieuChi = phieu.getSoPhieu() + "/" + sdfSo.format(dsPhieuTaiKhoan.getNgayChungTu())
										+ phieu.getMaMSThuChi();
							}
						}
						if (dsPhieuTaiKhoan.getTaiKhoanDoiUng() != null) {
							tenTaiKhoanDoiUng = dsPhieuTaiKhoan.getTaiKhoanDoiUng().getTen() + "( "
									+ dsPhieuTaiKhoan.getTaiKhoanDoiUng().getSoHieu() + " )";
						}
						LichSuThuChiDTO lichSuThuChiDTO = new LichSuThuChiDTO(ngayChungTu, inNgay ? ngayGhiSo : "", "",
								soHieuThu, soHieuChi, dienGiai, tenTaiKhoanDoiUng, soTienThu, soTienChi, soTienTon);
						collections.add(lichSuThuChiDTO);
					}
					if (dauKy != null) {
						LichSuThuChiDTO lichSuThuChiDTO = new LichSuThuChiDTO("", "", "", "", "", "SO CUOI THANG", "",
								"", "", soTien > 0 ? df.format(soTien) : "-" + df.format(Math.abs(soTien)));
						collections.add(lichSuThuChiDTO);
					}
					JasperReportUtil.exportReport(in, outStream, parameters, collections,
							typeIn == 1 ? FileType.DOCX : FileType.XLSX);
					outStream.flush();
				}
			} catch (Exception e) {
				e.printStackTrace();
				kq.putException(e);
			} finally {
			}
		}
		return kq;
	}

	public JSONObject printSoCai(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ServiceContext serviceContext) throws IOException {
		JSONObject kq = JSONFactoryUtil.createJSONObject();
		int thang = ParamUtil.getInteger(resourceRequest, "thang");
		int nam = ParamUtil.getInteger(resourceRequest, "nam");
		int typeIn = ParamUtil.getInteger(resourceRequest, "typeIn");
		long taiKhoanDoiUngId = ParamUtil.getLong(resourceRequest, "taiKhoanDoiUngId");
		if (taiKhoanDoiUngId > 0 && thang > 0 && nam > 0) {
			try {
				TaiKhoanDoiUng tkdu = TaiKhoanDoiUngLocalServiceUtil.fetchTaiKhoanDoiUng(taiKhoanDoiUngId);
				InputStream in = null;
				OutputStream outStream = resourceResponse.getPortletOutputStream();
				resourceResponse.setContentType("application/XLSX");
				String tenFile = typeIn == 1 ? tkdu.getTen() + ".docx" : tkdu.getTen() + ".xlsx";
				resourceResponse.setProperty("Content-Disposition", "attachment; filename=\"" + tenFile + "\"");
				in = getServletContext().getResourceAsStream("report/SO_CAI.jasper");
				Map<String, Object> parameters = new HashMap<String, Object>();
				parameters.put("tenTaiKhoan", tkdu.getTen());
				parameters.put("soHieuTaiKhoan", tkdu.getSoHieu());
				parameters.put("tenCongTy", GetterUtil.getString(PropsUtil.get("thongtin.cty.ten")));
				parameters.put("diaChiCongTy", GetterUtil.getString(PropsUtil.get("thongtin.cty.diachi")));
				parameters.put("thang", thang);
				parameters.put("nam", nam);
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				DecimalFormat df = new DecimalFormat("###,###.###");
				LichSuTaiKhoanDauKy dauKy = LichSuTaiKhoanDauKyLocalServiceUtil
						.fetchByTaiKhoanDoiUngId_Nam_Thang(taiKhoanDoiUngId, nam, thang);
				Double soTien = dauKy != null && dauKy.getSoTienTon() != null ? dauKy.getSoTienTon()
						: GetterUtil.getDouble("0");
				Collection<Object> collections = new ArrayList<Object>();
				if (dauKy != null) {
					LichSuThuChiDTO lichSuThuChiDTO = new LichSuThuChiDTO("", "", "", "", "", "DAU KY", "", "", "",
							dauKy.getSoTienTon() != null ? df.format(dauKy.getSoTienTon()) : "");
					collections.add(lichSuThuChiDTO);
				}
				Calendar calTu = Calendar.getInstance();
				calTu.set(nam, thang - 1, 1);
				Date ngayChungTuTu = calTu.getTime();
				Calendar calDen = Calendar.getInstance();
				calDen.set(nam, thang - 1, CalendarUtil.getDaysInMonth(calTu));
				Date ngayChungTuDen = calDen.getTime();
				List<DsPhieuTaiKhoan> dsPhieuTaiKhoans = DsPhieuTaiKhoanLocalServiceUtil
						.getDSThuChiByTaiKhoanNgayChungTu(taiKhoanDoiUngId, "", ngayChungTuTu, ngayChungTuDen, 1, -1,
								-1, null);
				if (CollectionUtils.isNotEmpty(dsPhieuTaiKhoans)) {
					boolean inNgay = true;
					boolean inNgayChungTu = true;
					String ngayChungTu = "";
					String ngayGhiSo = "";
					for (DsPhieuTaiKhoan dsPhieuTaiKhoan : dsPhieuTaiKhoans) {
						String soHieu = "";
						String dienGiai = "";
						String tenTaiKhoanDoiUng = "";
						String soTienThu = "";
						String soTienChi = "";
						if (dsPhieuTaiKhoan.getPhieu() != null) {
							inNgayChungTu = true;
							inNgay = true;
							Phieu phieu = dsPhieuTaiKhoan.getPhieu();
							if (phieu.getNgayGhiSo() != null && !ngayGhiSo.equals(sdf.format(phieu.getNgayGhiSo()))) {
								ngayGhiSo = sdf.format(phieu.getNgayGhiSo());
								inNgay = true;
							} else {
								inNgay = false;
							}
							if (!ngayChungTu.equals(sdf.format(dsPhieuTaiKhoan.getNgayChungTu()))) {
								ngayChungTu = sdf.format(dsPhieuTaiKhoan.getNgayChungTu());
								inNgayChungTu = true;
							} else {
								inNgayChungTu = false;
							}
							soHieu = phieu.getSoPhieu();
							dienGiai = phieu.getMaSoThuChi().getDienGiai();

							if (tkdu.getSoHieu().equals(PropsUtil.get("config.taikhoanthuvon"))) {
								// 1 Thu
								if (phieu.getLoai() == 1) {
									soTienThu = dsPhieuTaiKhoan.getSoTien() != null
											? df.format(dsPhieuTaiKhoan.getSoTien())
											: "0";
									soTien -= dsPhieuTaiKhoan.getSoTien();
									// 2 Chi
								} else if (phieu.getLoai() == 2) {
									soTienChi = dsPhieuTaiKhoan.getSoTien() != null
											? df.format(dsPhieuTaiKhoan.getSoTien())
											: "0";
									soTien += dsPhieuTaiKhoan.getSoTien();
								}
							} else {
								// 1 Thu
								if (phieu.getLoai() == 1) {
									soTienThu = dsPhieuTaiKhoan.getSoTien() != null
											? df.format(dsPhieuTaiKhoan.getSoTien())
											: "0";
									soTien += dsPhieuTaiKhoan.getSoTien();
									// 2 Chi
								} else if (phieu.getLoai() == 2) {
									soTienChi = dsPhieuTaiKhoan.getSoTien() != null
											? df.format(dsPhieuTaiKhoan.getSoTien())
											: "0";
									soTien -= dsPhieuTaiKhoan.getSoTien();
								}
							}
						}
						if (dsPhieuTaiKhoan.getTaiKhoanDoiUng() != null) {
							tenTaiKhoanDoiUng = dsPhieuTaiKhoan.getTaiKhoanDoiUng().getTen() + "( "
									+ dsPhieuTaiKhoan.getTaiKhoanDoiUng().getSoHieu() + " )";
						}
						LichSuThuChiDTO lichSuThuChiDTO = new LichSuThuChiDTO(inNgayChungTu ? ngayChungTu : "",
								inNgay ? ngayGhiSo : "", soHieu, "", "", dienGiai, tenTaiKhoanDoiUng, soTienThu,
								soTienChi, soTien != null ? df.format(soTien) : "0");
						collections.add(lichSuThuChiDTO);
					}
					if (dauKy != null) {
						LichSuThuChiDTO lichSuThuChiDTO = new LichSuThuChiDTO("", "", "", "", "", "SO CUOI THANG", "",
								"", "", soTien != null ? df.format(soTien) : "0");
						collections.add(lichSuThuChiDTO);
					}
					JasperReportUtil.exportReport(in, outStream, parameters, collections,
							typeIn == 1 ? FileType.DOCX : FileType.XLSX);
					outStream.flush();
				}
			} catch (Exception e) {
				e.printStackTrace();
				kq.putException(e);
			} finally {
			}
		}
		return kq;
	}

	public JSONObject capNhatDuLieuDauKyURL(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ServiceContext serviceContext) {
		JSONObject kq = JSONFactoryUtil.createJSONObject();
		long taiKhoanDoiUngId = ParamUtil.getLong(resourceRequest, "taiKhoanDoiUngId");
		int nam = ParamUtil.getInteger(resourceRequest, "nam");
		int thang = ParamUtil.getInteger(resourceRequest, "thang");
		if (taiKhoanDoiUngId > 0) {
			TaiKhoanDoiUng taiKhoanDoiUng = TaiKhoanDoiUngLocalServiceUtil.fetchTaiKhoanDoiUng(taiKhoanDoiUngId);
			if (taiKhoanDoiUng != null) {
				if (taiKhoanDoiUng.getLoaiTaiKhoan() == 2) {
					try {
						TaiKhoanDoiUng taiKhoanThuVon = TaiKhoanDoiUngLocalServiceUtil
								.fetchBySoHieu(PropsUtil.get("config.taikhoanthuvon"));
						if (taiKhoanThuVon != null) {
							Calendar calTu = Calendar.getInstance();
							calTu.set(nam, thang - 1, 1);
							Date ngayChungTuTu = calTu.getTime();
							Calendar calDen = Calendar.getInstance();
							calDen.set(nam, thang - 1, CalendarUtil.getDaysInMonth(calTu));
							Date ngayChungTuDen = calDen.getTime();
							LichSuTaiKhoanDauKy dauKy = LichSuTaiKhoanDauKyLocalServiceUtil
									.fetchByTaiKhoanDoiUngId_Nam_Thang(taiKhoanDoiUngId, nam, thang);
							List<DsPhieuTaiKhoan> dsPhieuTaiKhoans = DsPhieuTaiKhoanLocalServiceUtil
									.getDSThuChiByTaiKhoanNgayChungTu(taiKhoanThuVon.getTaiKhoanDoiUngId(),
											taiKhoanDoiUng.getSoHieu(), ngayChungTuTu, ngayChungTuDen, 1, -1, -1, null);
							if (dauKy != null) {
								Double soTienTon = dauKy.getSoTienTon();
								Double soTienThu = dauKy.getSoTienThu() != null ? dauKy.getSoTienThu()
										: GetterUtil.getDouble("0");
								Double soTienChi = dauKy.getSoTienChi() != null ? dauKy.getSoTienChi()
										: GetterUtil.getDouble("0");
								if (CollectionUtils.isNotEmpty(dsPhieuTaiKhoans)) {
									if (thang == 12) {
										nam++;
										thang = 0;
									}
									for (DsPhieuTaiKhoan item : dsPhieuTaiKhoans) {
										if (item.getPhieu() != null) {
											if (item.getPhieu().getLoai() == 1) {
												soTienThu  += item.getSoTien();
												soTienTon -= item.getSoTien();
											} else if (item.getPhieu().getLoai() == 2) {
												soTienTon += item.getSoTien();
												soTienChi  += item.getSoTien();
											}
										}
									}
									LichSuTaiKhoanDauKy cuoiThang = LichSuTaiKhoanDauKyLocalServiceUtil
											.fetchByTaiKhoanDoiUngId_Nam_Thang(taiKhoanDoiUngId, nam, thang + 1);
									if (cuoiThang == null) {
										cuoiThang = LichSuTaiKhoanDauKyLocalServiceUtil.createLichSuTaiKhoanDauKy(0L);
									}
									cuoiThang.setSoTienChi(soTienChi);
									cuoiThang.setSoTienThu(soTienThu);
									cuoiThang.setNam(nam);
									cuoiThang.setTaiKhoanDoiUngId(taiKhoanDoiUngId);
									cuoiThang.setThang(thang + 1);
									cuoiThang.setSoTienTon(soTienTon);
									cuoiThang.setHoatDong(true);
									LichSuTaiKhoanDauKyLocalServiceUtil.addOrUpdateLichSuTaiKhoanDauKy(cuoiThang,
											serviceContext);
								}
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
						kq.putException(e);
					}
				} else if (taiKhoanDoiUng.getLoaiTaiKhoan() == 1) {
					if (taiKhoanDoiUng.getSoHieu().equals(PropsUtil.get("config.taikhoanthuvon"))) {
						try {
							Calendar calTu = Calendar.getInstance();
							calTu.set(nam, thang - 1, 1);
							Date ngayChungTuTu = calTu.getTime();
							Calendar calDen = Calendar.getInstance();
							calDen.set(nam, thang - 1, CalendarUtil.getDaysInMonth(calTu));
							Date ngayChungTuDen = calDen.getTime();
							LichSuTaiKhoanDauKy dauKy = LichSuTaiKhoanDauKyLocalServiceUtil
									.fetchByTaiKhoanDoiUngId_Nam_Thang(taiKhoanDoiUngId, nam, thang);
							List<DsPhieuTaiKhoan> dsPhieuTaiKhoans = DsPhieuTaiKhoanLocalServiceUtil
									.getDSThuChiByTaiKhoanNgayChungTu(taiKhoanDoiUngId, "", ngayChungTuTu,
											ngayChungTuDen, 1, -1, -1, null);
							if (dauKy != null) {
								Double soTienTon = dauKy.getSoTienTon();
								Double soTienThu = dauKy.getSoTienThu() != null ? dauKy.getSoTienThu()
										: GetterUtil.getDouble("0");
								Double soTienChi = dauKy.getSoTienChi() != null ? dauKy.getSoTienChi()
										: GetterUtil.getDouble("0");
								if (CollectionUtils.isNotEmpty(dsPhieuTaiKhoans)) {
									if (thang == 12) {
										nam++;
										thang = 0;
									}
									for (DsPhieuTaiKhoan item : dsPhieuTaiKhoans) {
										if (item.getPhieu() != null) {
											if (item.getPhieu().getLoai() == 1) {
												soTienThu  += item.getSoTien();
												soTienTon -= item.getSoTien();
											} else if (item.getPhieu().getLoai() == 2) {
												soTienTon += item.getSoTien();
												soTienChi  += item.getSoTien();
											}
										}
									}
									LichSuTaiKhoanDauKy cuoiThang = LichSuTaiKhoanDauKyLocalServiceUtil
											.fetchByTaiKhoanDoiUngId_Nam_Thang(taiKhoanDoiUngId, nam, thang + 1);
									if (cuoiThang == null) {
										cuoiThang = LichSuTaiKhoanDauKyLocalServiceUtil.createLichSuTaiKhoanDauKy(0L);
									}
									cuoiThang.setSoTienChi(soTienChi);
									cuoiThang.setSoTienThu(soTienThu);
									cuoiThang.setNam(nam);
									cuoiThang.setTaiKhoanDoiUngId(taiKhoanDoiUngId);
									cuoiThang.setThang(thang + 1);
									cuoiThang.setSoTienTon(soTienTon);
									cuoiThang.setHoatDong(true);
									LichSuTaiKhoanDauKyLocalServiceUtil.addOrUpdateLichSuTaiKhoanDauKy(cuoiThang,
											serviceContext);
								}
							}
						} catch (Exception e) {
							e.printStackTrace();
							kq.putException(e);
						}
					} else {
						try {
							Calendar calTu = Calendar.getInstance();
							calTu.set(nam, thang - 1, 1);
							Date ngayChungTuTu = calTu.getTime();
							Calendar calDen = Calendar.getInstance();
							calDen.set(nam, thang - 1, CalendarUtil.getDaysInMonth(calTu));
							Date ngayChungTuDen = calDen.getTime();
							LichSuTaiKhoanDauKy dauKy = LichSuTaiKhoanDauKyLocalServiceUtil
									.fetchByTaiKhoanDoiUngId_Nam_Thang(taiKhoanDoiUngId, nam, thang);
							List<DsPhieuTaiKhoan> dsPhieuTaiKhoans = DsPhieuTaiKhoanLocalServiceUtil
									.getDSThuChiByTaiKhoanNgayChungTu(taiKhoanDoiUngId, "", ngayChungTuTu,
											ngayChungTuDen, 1, -1, -1, null);
							if (dauKy != null) {
								Double soTienTon = dauKy.getSoTienTon();
								Double soTienThu = dauKy.getSoTienThu() != null ? dauKy.getSoTienThu()
										: GetterUtil.getDouble("0");
								Double soTienChi = dauKy.getSoTienChi() != null ? dauKy.getSoTienChi()
										: GetterUtil.getDouble("0");
								if (CollectionUtils.isNotEmpty(dsPhieuTaiKhoans)) {
									if (thang == 12) {
										nam++;
										thang = 0;
									}
									for (DsPhieuTaiKhoan item : dsPhieuTaiKhoans) {
										if (item.getPhieu() != null) {
											if (item.getPhieu().getLoai() == 1) {
												soTienTon += item.getSoTien();
												soTienThu += item.getSoTien();
											} else if (item.getPhieu().getLoai() == 2) {
												soTienTon -= item.getSoTien();
												soTienChi += item.getSoTien();
											}
										}
									}
									LichSuTaiKhoanDauKy cuoiThang = LichSuTaiKhoanDauKyLocalServiceUtil
											.fetchByTaiKhoanDoiUngId_Nam_Thang(taiKhoanDoiUngId, nam, thang + 1);
									if (cuoiThang == null) {
										cuoiThang = LichSuTaiKhoanDauKyLocalServiceUtil.createLichSuTaiKhoanDauKy(0L);
									}
									cuoiThang.setSoTienChi(soTienChi);
									cuoiThang.setSoTienThu(soTienThu);
									cuoiThang.setNam(nam);
									cuoiThang.setTaiKhoanDoiUngId(taiKhoanDoiUngId);
									cuoiThang.setThang(thang + 1);
									cuoiThang.setSoTienTon(soTienTon);
									cuoiThang.setHoatDong(true);
									LichSuTaiKhoanDauKyLocalServiceUtil.addOrUpdateLichSuTaiKhoanDauKy(cuoiThang,
											serviceContext);
								}
							}
						} catch (Exception e) {
							e.printStackTrace();
							kq.putException(e);
						}
					}
				}
			}

		}
		return kq;
	}

}