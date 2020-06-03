package quanly.portlet.phatvay.thutienhangngay;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.mb.model.CongTacVien;
import com.mb.model.LichSuThuPhatChi;
import com.mb.model.PhatVay;
import com.mb.service.CongTacVienLocalServiceUtil;
import com.mb.service.LichSuThuPhatChiLocalServiceUtil;
import com.mb.service.PhatVayLocalServiceUtil;

import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;
import quanly.constants.QuanlyPortletKeys;
import quanly.constants.TrangThaiPhatVayEnum;
import quanly.dto.CongTacVienDTO;
import quanly.util.DocSo;

/**
 * @author Annn
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/html/phatvay/thutienhangngay/view.jsp",
		"javax.portlet.display-name=" + QuanlyPortletKeys.thuTienHangNgay,
		"javax.portlet.name=" + QuanlyPortletKeys.thuTienHangNgay, "javax.portlet.resource-bundle=content.Language",
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
public class ThuTienHangNgayPortlet extends MVCPortlet {
	private static long time1Ngay = 86399990;

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
		if (resourceId.equals("thuTienURL")) {
			kq = thuTienURL(resourceRequest, resourceResponse, serviceContext);
		} else if (resourceId.equals("printPhieuThuTienHangNgay")) {
			kq = printPhieuThuTienHangNgay(resourceRequest, resourceResponse, serviceContext);
		} else if (resourceId.equals("thuTienTruocURL")) {
			kq = thuTienTruocURL(resourceRequest, resourceResponse, serviceContext);
		} else if (resourceId.equals("printPhieuThuTienTruoc")) {
			kq = printPhieuThuTienTruoc(resourceRequest, resourceResponse, serviceContext);
		}
		PrintWriter writer = resourceResponse.getWriter();
		writer.print(kq.toString());
		writer.flush();
		writer.close();

	}

	public JSONObject thuTienURL(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ServiceContext serviceContext) {
		JSONObject kq = JSONFactoryUtil.createJSONObject();
		long ngayThuTienTime = ParamUtil.getLong(resourceRequest, "ngayThuTien");
		Date ngayThuTien = ngayThuTienTime != 0 ? new Date(ngayThuTienTime) : null;
		String maCTVSearch = ParamUtil.getString(resourceRequest, "maCTVSearch");
		if (Validator.isNotNull(ngayThuTien)) {
			try {
				List<CongTacVien> items = CongTacVienLocalServiceUtil.findBase(maCTVSearch, "", "", "", 1, -1, -1,
						null);
				for (CongTacVien item : items) {
					Double tongVonTra = GetterUtil.getDouble("0");
					Double tongLaiTra = GetterUtil.getDouble("0");
					List<PhatVay> phatVays = PhatVayLocalServiceUtil.findCTV_NgayThuTien(item.getMa(), ngayThuTien);
					if (CollectionUtils.isNotEmpty(phatVays)) {
						for (PhatVay pv : phatVays) {
							Double vonTra = GetterUtil.getDouble("0");
							Double laiTra = GetterUtil.getDouble("0");
							if (pv.getTrangThai() == 4) {
								Calendar calNgayThuTien = Calendar.getInstance();
								calNgayThuTien.setTime(ngayThuTien);
								Calendar calNgayKetThuc = Calendar.getInstance();
								calNgayKetThuc.setTime(pv.getNgayKetThuc());
								Calendar calNgayBatDau = Calendar.getInstance();
								calNgayBatDau.setTime(pv.getNgayBatDau());
								Calendar calNgayDaThuTruocTu = Calendar.getInstance();
								calNgayDaThuTruocTu.setTime(pv.getNgayThuTruocTu());
								Calendar calNgayDaThuTruocDen = Calendar.getInstance();
								calNgayDaThuTruocDen.setTime(pv.getNgayThuTruocDen());
								if (CalendarUtil.getGTDate(calNgayThuTien).getTime() >= CalendarUtil
										.getGTDate(calNgayKetThuc).getTime()) {
									tongVonTra += pv.getDuNoGoc();
									vonTra = pv.getDuNoGoc();
									tongLaiTra += (pv.getLaiNgay()
											* (pv.getThoiHan() - (pv.getSoLanDaThu() + pv.getSoNgayThuTruoc())));
									laiTra = (pv.getLaiNgay()
											* (pv.getThoiHan() - (pv.getSoLanDaThu() + pv.getSoNgayThuTruoc())));
									pv.setNgayDaThuCuoi(pv.getNgayKetThuc());
									pv.setSoLanDaThu(pv.getThoiHan());
									pv.setTrangThai(TrangThaiPhatVayEnum.DA_THANH_TOAN.getValue());
									pv.setNgayThuTruocTu(null);
									pv.setNgayThuTruocDen(null);
									pv.setSoNgayThuTruoc(0);
								} else if (CalendarUtil.getGTDate(calNgayThuTien).getTime() >= CalendarUtil
										.getGTDate(calNgayDaThuTruocTu).getTime()) {
									if (CalendarUtil.getGTDate(calNgayThuTien).getTime() >= CalendarUtil
											.getGTDate(calNgayDaThuTruocDen).getTime()) {
										int tongNgayDaThu = (int) ((CalendarUtil.getLTDate(calNgayThuTien).getTime()
												- CalendarUtil.getGTDate(calNgayBatDau).getTime()) / time1Ngay);
										int soNgayPhaiThu = tongNgayDaThu
												- (pv.getSoNgayThuTruoc() + pv.getSoLanDaThu());
										tongVonTra += (soNgayPhaiThu * pv.getGocNgay());
										tongLaiTra += (soNgayPhaiThu * pv.getLaiNgay());
										vonTra = (soNgayPhaiThu * pv.getGocNgay());
										laiTra = (soNgayPhaiThu * pv.getLaiNgay());
										pv.setNgayDaThuCuoi(CalendarUtil.getLTDate(calNgayThuTien));
										pv.setSoLanDaThu(tongNgayDaThu);
										pv.setTrangThai(TrangThaiPhatVayEnum.CHUA_THANH_TOAN.getValue());
										pv.setNgayThuTruocTu(null);
										pv.setNgayThuTruocDen(null);
										pv.setSoNgayThuTruoc(0);
									} else {
										int tongNgayDaThu = (int) ((CalendarUtil.getLTDate(calNgayDaThuTruocDen)
												.getTime() - CalendarUtil.getGTDate(calNgayBatDau).getTime())
												/ time1Ngay);
										int soNgayPhaiThu = tongNgayDaThu
												- (pv.getSoNgayThuTruoc() + pv.getSoLanDaThu());
										tongVonTra += (soNgayPhaiThu * pv.getGocNgay());
										tongLaiTra += (soNgayPhaiThu * pv.getLaiNgay());
										vonTra = (soNgayPhaiThu * pv.getGocNgay());
										laiTra = (soNgayPhaiThu * pv.getLaiNgay());
										pv.setNgayDaThuCuoi(CalendarUtil.getLTDate(calNgayDaThuTruocDen));
										pv.setSoLanDaThu(tongNgayDaThu);
										pv.setTrangThai(TrangThaiPhatVayEnum.CHUA_THANH_TOAN.getValue());
										pv.setNgayThuTruocTu(null);
										pv.setNgayThuTruocDen(null);
										pv.setSoNgayThuTruoc(0);
									}
								} else {
									pv.setNgayDaThuCuoi(ngayThuTien);
									int soLanDaThu = (int) ((CalendarUtil.getLTDate(calNgayThuTien).getTime()
											- CalendarUtil.getGTDate(calNgayBatDau).getTime()) / time1Ngay);
									tongVonTra += ((soLanDaThu - pv.getSoLanDaThu()) * pv.getGocNgay());
									tongLaiTra += ((soLanDaThu - pv.getSoLanDaThu()) * pv.getLaiNgay());
									vonTra = ((soLanDaThu - pv.getSoLanDaThu()) * pv.getGocNgay());
									laiTra = ((soLanDaThu - pv.getSoLanDaThu()) * pv.getLaiNgay());
									pv.setSoLanDaThu(soLanDaThu);
								}
							} else {
								Calendar calNgayThuTien = Calendar.getInstance();
								calNgayThuTien.setTime(ngayThuTien);
								Calendar calNgayKetThuc = Calendar.getInstance();
								calNgayKetThuc.setTime(pv.getNgayKetThuc());
								Calendar calNgayBatDau = Calendar.getInstance();
								calNgayBatDau.setTime(pv.getNgayBatDau());
								if (CalendarUtil.getGTDate(calNgayThuTien).getTime() >= CalendarUtil
										.getGTDate(calNgayKetThuc).getTime()) {
									tongVonTra += pv.getDuNoGoc();
									tongLaiTra += (pv.getLaiNgay() * (pv.getThoiHan() - pv.getSoLanDaThu()));
									vonTra = pv.getDuNoGoc();
									laiTra = (pv.getLaiNgay() * (pv.getThoiHan() - pv.getSoLanDaThu()));
									pv.setNgayDaThuCuoi(pv.getNgayKetThuc());
									pv.setSoLanDaThu(pv.getThoiHan());
									pv.setTrangThai(TrangThaiPhatVayEnum.DA_THANH_TOAN.getValue());
								} else {
									int soLanDaThu = (int) ((CalendarUtil.getLTDate(calNgayThuTien).getTime()
											- CalendarUtil.getGTDate(calNgayBatDau).getTime()) / time1Ngay);
									tongVonTra += ((soLanDaThu - pv.getSoLanDaThu()) * pv.getGocNgay());
									tongLaiTra += ((soLanDaThu - pv.getSoLanDaThu()) * pv.getLaiNgay());
									vonTra = ((soLanDaThu - pv.getSoLanDaThu()) * pv.getGocNgay());
									laiTra = ((soLanDaThu - pv.getSoLanDaThu()) * pv.getLaiNgay());
									pv.setNgayDaThuCuoi(ngayThuTien);
									pv.setSoLanDaThu(soLanDaThu);
								}
							}
							PhatVayLocalServiceUtil.addOrUpdatePhatVay(pv, serviceContext);
							LichSuThuPhatChi lichSuThuPhatChi = LichSuThuPhatChiLocalServiceUtil
									.createLichSuThuPhatChi(0L);
							lichSuThuPhatChi.setMaCTV(item.getMa());
							lichSuThuPhatChi.setPhatVayId(pv.getPhatVayId());
							lichSuThuPhatChi.setLoai(3);
							lichSuThuPhatChi.setSoTien(vonTra + laiTra);
							lichSuThuPhatChi.setTongSoTienLaiTra(laiTra);
							lichSuThuPhatChi.setTongSoTienVonTra(vonTra);
							lichSuThuPhatChi.setTrangThaiPhatVayHienTai(pv.getTrangThai());
							LichSuThuPhatChiLocalServiceUtil.addLichSuThuPhatChi(lichSuThuPhatChi, serviceContext);
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				kq.putException(e);
			}
		}
		return kq;
	}

	public JSONObject printPhieuThuTienHangNgay(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ServiceContext serviceContext) throws IOException {
		JSONObject kq = JSONFactoryUtil.createJSONObject();
		long ngayThuTienTime = ParamUtil.getLong(resourceRequest, "ngayThuTien");
		Date ngayThuTien = ngayThuTienTime != 0 ? new Date(ngayThuTienTime) : null;
		String maCTVSearch = ParamUtil.getString(resourceRequest, "maCTVSearch");
		InputStream in = null;
		OutputStream outStream = resourceResponse.getPortletOutputStream();
		if (Validator.isNotNull(ngayThuTien)) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				DecimalFormat df = new DecimalFormat("###,###.###");
				List<CongTacVien> items = CongTacVienLocalServiceUtil.findBase(maCTVSearch, "", "", "", 1, -1, -1,
						null);
				List<CongTacVienDTO> congTacVienDTOs = new ArrayList<CongTacVienDTO>();
				for (CongTacVien item : items) {
					List<PhatVay> phatVays = PhatVayLocalServiceUtil.findCTV_NgayThuTien(item.getMa(), ngayThuTien);
					if (CollectionUtils.isNotEmpty(phatVays)) {
						Double tongVonTra = GetterUtil.getDouble("0");
						Double tongLaiTra = GetterUtil.getDouble("0");
						Double tongduNoGoc = GetterUtil.getDouble("0");
						for (PhatVay pv : phatVays) {
							if (pv.getTrangThai() == 4) {
								Calendar calNgayThuTien = Calendar.getInstance();
								calNgayThuTien.setTime(ngayThuTien);
								Calendar calNgayKetThuc = Calendar.getInstance();
								calNgayKetThuc.setTime(pv.getNgayKetThuc());
								Calendar calNgayBatDau = Calendar.getInstance();
								calNgayBatDau.setTime(pv.getNgayBatDau());
								Calendar calNgayDaThuTruocTu = Calendar.getInstance();
								calNgayDaThuTruocTu.setTime(pv.getNgayThuTruocTu());
								Calendar calNgayDaThuTruocDen = Calendar.getInstance();
								calNgayDaThuTruocDen.setTime(pv.getNgayThuTruocDen());
								if (CalendarUtil.getGTDate(calNgayThuTien).getTime() >= CalendarUtil
										.getGTDate(calNgayKetThuc).getTime()) {
									tongVonTra += pv.getDuNoGoc();
									tongLaiTra += (pv.getLaiNgay()
											* (pv.getThoiHan() - (pv.getSoLanDaThu() + pv.getSoNgayThuTruoc())));

								} else if (CalendarUtil.getGTDate(calNgayThuTien).getTime() >= CalendarUtil
										.getGTDate(calNgayDaThuTruocTu).getTime()) {
									if (CalendarUtil.getGTDate(calNgayThuTien).getTime() >= CalendarUtil
											.getGTDate(calNgayDaThuTruocDen).getTime()) {
										int tongNgayDaThu = (int) ((CalendarUtil.getLTDate(calNgayThuTien).getTime()
												- CalendarUtil.getGTDate(calNgayBatDau).getTime()) / time1Ngay);
										int soNgayPhaiThu = tongNgayDaThu
												- (pv.getSoNgayThuTruoc() + pv.getSoLanDaThu());
										tongVonTra += (soNgayPhaiThu * pv.getGocNgay());
										tongLaiTra += (soNgayPhaiThu * pv.getLaiNgay());
										tongduNoGoc += (pv.getDuNoGoc() - (soNgayPhaiThu * pv.getGocNgay()));
									} else {
										int tongNgayDaThu = (int) ((CalendarUtil.getLTDate(calNgayDaThuTruocDen)
												.getTime() - CalendarUtil.getGTDate(calNgayBatDau).getTime())
												/ time1Ngay);
										int soNgayPhaiThu = tongNgayDaThu
												- (pv.getSoNgayThuTruoc() + pv.getSoLanDaThu());
										tongVonTra += (soNgayPhaiThu * pv.getGocNgay());
										tongLaiTra += (soNgayPhaiThu * pv.getLaiNgay());
										tongduNoGoc += (pv.getDuNoGoc() - (soNgayPhaiThu * pv.getGocNgay()));
									}
								} else {
									int soLanDaThu = (int) ((CalendarUtil.getLTDate(calNgayThuTien).getTime()
											- CalendarUtil.getGTDate(calNgayBatDau).getTime()) / time1Ngay);
									tongVonTra += ((soLanDaThu - pv.getSoLanDaThu()) * pv.getGocNgay());
									tongLaiTra += ((soLanDaThu - pv.getSoLanDaThu()) * pv.getLaiNgay());
									tongduNoGoc += (pv.getDuNoGoc()
											- ((soLanDaThu - pv.getSoLanDaThu()) * pv.getGocNgay()));
								}

							} else {
								Calendar calNgayThuTien = Calendar.getInstance();
								calNgayThuTien.setTime(ngayThuTien);
								Calendar calNgayKetThuc = Calendar.getInstance();
								calNgayKetThuc.setTime(pv.getNgayKetThuc());
								Calendar calNgayBatDau = Calendar.getInstance();
								calNgayBatDau.setTime(pv.getNgayBatDau());
								if (CalendarUtil.getGTDate(calNgayThuTien).getTime() >= CalendarUtil
										.getGTDate(calNgayKetThuc).getTime()) {
									tongVonTra += pv.getDuNoGoc();
									tongLaiTra += (pv.getLaiNgay() * (pv.getThoiHan() - pv.getSoLanDaThu()));
								} else {
									int soLanDaThu = (int) ((CalendarUtil.getLTDate(calNgayThuTien).getTime()
											- CalendarUtil.getGTDate(calNgayBatDau).getTime()) / time1Ngay);
									tongVonTra += ((soLanDaThu - pv.getSoLanDaThu()) * pv.getGocNgay());
									tongLaiTra += ((soLanDaThu - pv.getSoLanDaThu()) * pv.getLaiNgay());
									tongduNoGoc += (pv.getDuNoGoc()
											- ((soLanDaThu - pv.getSoLanDaThu()) * pv.getGocNgay()));
								}
							}

						}
						congTacVienDTOs.add(new CongTacVienDTO(
								item.getMa() + "/" + new SimpleDateFormat("ddMMyyyy").format(ngayThuTien), item.getMa(),
								item.getHoTen(), item.getDiaChi(), df.format(tongVonTra).replaceAll(",", "."),
								df.format(tongLaiTra).replaceAll(",", "."),
								df.format(tongLaiTra + tongVonTra).replaceAll(",", "."),
								DocSo.docSo(GetterUtil.getLong(tongLaiTra + tongVonTra)),
								df.format(tongduNoGoc).replaceAll(",", "."), "", "", "", "", null, null));
					}
				}
				String nameFile = "THU_TIEN_NGAY_" + new SimpleDateFormat("ddMMyyyy").format(ngayThuTien);
				if (Validator.isNotNull(maCTVSearch)) {
					nameFile = maCTVSearch + "_" + new SimpleDateFormat("ddMMyyyy").format(ngayThuTien);
				}
				resourceResponse.setContentType("application/DOCX");
				resourceResponse.setProperty("Content-Disposition", "attachment; filename=\"" + nameFile + ".docx\"");
				in = getServletContext().getResourceAsStream("report/MAU_THU_TIEN_HANG_NGAY.docx");

				IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in, TemplateEngineKind.Velocity);
				IContext iContext = report.createContext();
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("TEN_CONG_TY", GetterUtil.getString(PropsUtil.get("thongtin.cty.ten")));
				map.put("DIA_CHI_CONG_TY", GetterUtil.getString(PropsUtil.get("thongtin.cty.diachi")));
				map.put("SO_DIEN_THOAI_CONG_TY", GetterUtil.getString(PropsUtil.get("thongtin.cty.sodienthoai")));
				map.put("NGAY", sdf.format(ngayThuTien).substring(0, 2));
				map.put("THANG", sdf.format(ngayThuTien).substring(3, 5));
				map.put("NAM", sdf.format(ngayThuTien).substring(6, 10));

				FieldsMetadata metadata = new FieldsMetadata();
				metadata.addFieldAsList("ctvs.so");
				metadata.addFieldAsList("ctvs.maSo");
				metadata.addFieldAsList("ctvs.hoTen");
				metadata.addFieldAsList("ctvs.diaChi");
				metadata.addFieldAsList("ctvs.vonTra");
				metadata.addFieldAsList("ctvs.laiTra");
				metadata.addFieldAsList("ctvs.tongTien");
				metadata.addFieldAsList("ctvs.tongTienBangChu");
				metadata.addFieldAsList("ctvs.duNoGoc");
				report.setFieldsMetadata(metadata);
				iContext.putMap(map);
				iContext.put("ctvs", congTacVienDTOs);
				report.process(iContext, outStream);

			} catch (Exception e) {
				e.printStackTrace();
				kq.putException(e);
			} finally {
			}
		}
		outStream.flush();
		return kq;
	}

	public JSONObject thuTienTruocURL(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ServiceContext serviceContext) {
		JSONObject kq = JSONFactoryUtil.createJSONObject();
		long ngayThuTienTuTime = ParamUtil.getLong(resourceRequest, "ngayThuTienTuTime");
		long ngayThuTienDenTime = ParamUtil.getLong(resourceRequest, "ngayThuTienDenTime");
		String maCTV = ParamUtil.getString(resourceRequest, "maCTV");
		Date ngayThuTienTu = ngayThuTienTuTime != 0 ? new Date(ngayThuTienTuTime) : null;
		Date ngayThuTienDen = ngayThuTienDenTime != 0 ? new Date(ngayThuTienDenTime) : null;
		if (Validator.isNotNull(maCTV) && ngayThuTienTu != null && ngayThuTienDen != null) {
			try {
				List<PhatVay> phatVays = PhatVayLocalServiceUtil.getPhatVayDeThuTienTruoc(maCTV, ngayThuTienTu);
				Double tongVonTra = GetterUtil.getDouble("0");
				Double tongLaiTra = GetterUtil.getDouble("0");
				if (CollectionUtils.isNotEmpty(phatVays)) {
					for (PhatVay pv : phatVays) {
						Double vonTra = GetterUtil.getDouble("0");
						Double laiTra = GetterUtil.getDouble("0");
						Calendar calTu = Calendar.getInstance();
						calTu.setTime(ngayThuTienTu);
						Calendar calDen = Calendar.getInstance();
						calDen.setTime(ngayThuTienDen);
						Calendar calNgayKetThuc = Calendar.getInstance();
						calNgayKetThuc.setTime(pv.getNgayKetThuc());
						Calendar calNgayBatDau = Calendar.getInstance();
						calNgayBatDau.setTime(pv.getNgayBatDau());
						Calendar calNgayThuCuoi = null;
						if (pv.getNgayDaThuCuoi() != null) {
							calNgayThuCuoi = Calendar.getInstance();
							calNgayThuCuoi.setTime(pv.getNgayDaThuCuoi());
							if (CalendarUtil.getGTDate(calNgayThuCuoi).getTime() == CalendarUtil.getGTDate(calTu)
									.getTime()) {
								if (CalendarUtil.getGTDate(calDen).getTime() >= CalendarUtil.getGTDate(calNgayKetThuc)
										.getTime()) {
									tongVonTra += pv.getDuNoGoc();
									tongLaiTra += (pv.getLaiNgay()
											* (pv.getThoiHan() - (pv.getSoLanDaThu() + pv.getSoNgayThuTruoc())));
									
									vonTra = pv.getDuNoGoc();
									laiTra = (pv.getLaiNgay()
											* (pv.getThoiHan() - (pv.getSoLanDaThu() + pv.getSoNgayThuTruoc())));
									pv.setNgayDaThuCuoi(pv.getNgayKetThuc());
									pv.setSoLanDaThu(pv.getThoiHan());
									pv.setTrangThai(TrangThaiPhatVayEnum.DA_THANH_TOAN.getValue());
									pv.setNgayThuTruocTu(null);
									pv.setNgayThuTruocDen(null);
									pv.setSoNgayThuTruoc(0);
								} else {
									int soLanPhaiThu = (int) ((CalendarUtil.getLTDate(calNgayKetThuc).getTime()
											- CalendarUtil.getGTDate(calTu).getTime()) / time1Ngay);
									tongVonTra += (soLanPhaiThu * pv.getGocNgay());
									tongLaiTra += (soLanPhaiThu * pv.getLaiNgay());
									
									vonTra = (soLanPhaiThu * pv.getGocNgay());
									laiTra += (soLanPhaiThu * pv.getLaiNgay());
									
									int soLanDaThu = (int) ((CalendarUtil.getLTDate(calDen).getTime()
											- CalendarUtil.getGTDate(calNgayBatDau).getTime()) / time1Ngay);
									pv.setNgayDaThuCuoi(calDen.getTime());
									pv.setSoLanDaThu(soLanDaThu);
									pv.setTrangThai(TrangThaiPhatVayEnum.CHUA_THANH_TOAN.getValue());
									pv.setNgayThuTruocTu(null);
									pv.setNgayThuTruocDen(null);
									pv.setSoNgayThuTruoc(0);
								}
							} else if (CalendarUtil.getGTDate(calNgayThuCuoi).getTime() < CalendarUtil.getGTDate(calTu)
									.getTime()) {
								if (CalendarUtil.getGTDate(calDen).getTime() >= CalendarUtil.getGTDate(calNgayKetThuc)
										.getTime()) {
									if (CalendarUtil.getGTDate(calNgayKetThuc).getTime() >= CalendarUtil
											.getGTDate(calTu).getTime()) {
										int soLanPhaiThu = (int) ((CalendarUtil.getLTDate(calNgayKetThuc).getTime()
												- CalendarUtil.getGTDate(calTu).getTime()) / time1Ngay);
										tongVonTra += (soLanPhaiThu * pv.getGocNgay());
										tongLaiTra += (soLanPhaiThu * pv.getLaiNgay());
										
										vonTra = (soLanPhaiThu * pv.getGocNgay());
										laiTra = (soLanPhaiThu * pv.getLaiNgay());
										
										pv.setTrangThai(TrangThaiPhatVayEnum.CO_THU_TIEN_TRUOC.getValue());
										pv.setNgayThuTruocTu(calTu.getTime());
										pv.setNgayThuTruocDen(calNgayKetThuc.getTime());
										pv.setSoNgayThuTruoc(soLanPhaiThu);
									}
								} else {
									int soLanPhaiThu = (int) ((CalendarUtil.getLTDate(calDen).getTime()
											- CalendarUtil.getGTDate(calTu).getTime()) / time1Ngay);
									tongVonTra += (soLanPhaiThu * pv.getGocNgay());
									tongLaiTra += (soLanPhaiThu * pv.getLaiNgay());
									
									vonTra = (soLanPhaiThu * pv.getGocNgay());
									laiTra = (soLanPhaiThu * pv.getLaiNgay());
									
									pv.setTrangThai(TrangThaiPhatVayEnum.CO_THU_TIEN_TRUOC.getValue());
									pv.setNgayThuTruocTu(calTu.getTime());
									pv.setNgayThuTruocDen(calDen.getTime());
									pv.setSoNgayThuTruoc(soLanPhaiThu);
								}
							}
						} else {
							if (CalendarUtil.getGTDate(calNgayBatDau).getTime() == CalendarUtil.getGTDate(calTu)
									.getTime()) {
								if (CalendarUtil.getGTDate(calDen).getTime() >= CalendarUtil.getGTDate(calNgayKetThuc)
										.getTime()) {
									tongVonTra += pv.getDuNoGoc();
									tongLaiTra += (pv.getLaiNgay()
											* (pv.getThoiHan() - (pv.getSoLanDaThu() + pv.getSoNgayThuTruoc())));
									
									vonTra = pv.getDuNoGoc();
									laiTra = (pv.getLaiNgay()
											* (pv.getThoiHan() - (pv.getSoLanDaThu() + pv.getSoNgayThuTruoc())));
									pv.setNgayDaThuCuoi(pv.getNgayKetThuc());
									pv.setSoLanDaThu(pv.getThoiHan());
									pv.setTrangThai(TrangThaiPhatVayEnum.DA_THANH_TOAN.getValue());
									pv.setNgayThuTruocTu(null);
									pv.setNgayThuTruocDen(null);
									pv.setSoNgayThuTruoc(0);
								} else {
									int soLanPhaiThu = (int) ((CalendarUtil.getLTDate(calDen).getTime()
											- CalendarUtil.getGTDate(calTu).getTime()) / time1Ngay);
									tongVonTra += (soLanPhaiThu * pv.getGocNgay());
									tongLaiTra += (soLanPhaiThu * pv.getLaiNgay());
									
									vonTra = (soLanPhaiThu * pv.getGocNgay());
									laiTra = (soLanPhaiThu * pv.getLaiNgay());
									
									int soLanDaThu = (int) ((CalendarUtil.getLTDate(calDen).getTime()
											- CalendarUtil.getGTDate(calNgayBatDau).getTime()) / time1Ngay);
									pv.setNgayDaThuCuoi(calDen.getTime());
									pv.setSoLanDaThu(soLanDaThu);
									pv.setTrangThai(TrangThaiPhatVayEnum.CHUA_THANH_TOAN.getValue());
									pv.setNgayThuTruocTu(null);
									pv.setNgayThuTruocDen(null);
									pv.setSoNgayThuTruoc(0);
								}
							} else if (CalendarUtil.getGTDate(calNgayBatDau).getTime() < CalendarUtil.getGTDate(calTu)
									.getTime()) {
								if (CalendarUtil.getGTDate(calDen).getTime() >= CalendarUtil.getGTDate(calNgayKetThuc)
										.getTime()) {
									int soLanPhaiThu = (int) ((CalendarUtil.getLTDate(calNgayKetThuc).getTime()
											- CalendarUtil.getGTDate(calTu).getTime()) / time1Ngay);
									tongVonTra += (soLanPhaiThu * pv.getGocNgay());
									tongLaiTra += (soLanPhaiThu * pv.getLaiNgay());
									
									vonTra = (soLanPhaiThu * pv.getGocNgay());
									laiTra = (soLanPhaiThu * pv.getLaiNgay());
									
									pv.setTrangThai(TrangThaiPhatVayEnum.CO_THU_TIEN_TRUOC.getValue());
									pv.setNgayThuTruocTu(calTu.getTime());
									pv.setNgayThuTruocDen(calNgayKetThuc.getTime());
									pv.setSoNgayThuTruoc(soLanPhaiThu);
								} else {
									int soLanPhaiThu = (int) ((CalendarUtil.getLTDate(calDen).getTime()
											- CalendarUtil.getGTDate(calTu).getTime()) / time1Ngay);
									tongVonTra += (soLanPhaiThu * pv.getGocNgay());
									tongLaiTra += (soLanPhaiThu * pv.getLaiNgay());
									
									vonTra = (soLanPhaiThu * pv.getGocNgay());
									laiTra = (soLanPhaiThu * pv.getLaiNgay());
									
									pv.setTrangThai(TrangThaiPhatVayEnum.CO_THU_TIEN_TRUOC.getValue());
									pv.setNgayThuTruocTu(calTu.getTime());
									pv.setNgayThuTruocDen(calDen.getTime());
									pv.setSoNgayThuTruoc(soLanPhaiThu);
								}
							}
						}
						PhatVayLocalServiceUtil.addOrUpdatePhatVay(pv, serviceContext);
						LichSuThuPhatChi lichSuThuPhatChi = LichSuThuPhatChiLocalServiceUtil.createLichSuThuPhatChi(0L);
						lichSuThuPhatChi.setMaCTV(pv.getMaCTV());
						lichSuThuPhatChi.setPhatVayId(pv.getPhatVayId());
						lichSuThuPhatChi.setLoai(4);
						lichSuThuPhatChi.setSoTien(vonTra + laiTra);
						lichSuThuPhatChi.setTongSoTienLaiTra(laiTra);
						lichSuThuPhatChi.setTongSoTienVonTra(vonTra);
						lichSuThuPhatChi.setTrangThaiPhatVayHienTai(pv.getTrangThai());
						LichSuThuPhatChiLocalServiceUtil.addLichSuThuPhatChi(lichSuThuPhatChi, serviceContext);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				kq.putException(e);
			}
		}
		return kq;
	}

	public JSONObject printPhieuThuTienTruoc(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ServiceContext serviceContext) throws IOException {
		JSONObject kq = JSONFactoryUtil.createJSONObject();
		long ngayThuTienTuTime = ParamUtil.getLong(resourceRequest, "ngayThuTienTuTime");
		long ngayThuTienDenTime = ParamUtil.getLong(resourceRequest, "ngayThuTienDenTime");
		Date ngayThuTienTu = ngayThuTienTuTime != 0 ? new Date(ngayThuTienTuTime) : null;
		Date ngayThuTienDen = ngayThuTienDenTime != 0 ? new Date(ngayThuTienDenTime) : null;
		String maCTVSearch = ParamUtil.getString(resourceRequest, "maCTVSearch");
		InputStream in = null;
		OutputStream outStream = resourceResponse.getPortletOutputStream();
		if (ngayThuTienTu != null && ngayThuTienDen != null) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				DecimalFormat df = new DecimalFormat("###,###.###");
				List<CongTacVien> items = CongTacVienLocalServiceUtil.findBase(maCTVSearch, "", "", "", 1, -1, -1,
						null);
				List<CongTacVienDTO> congTacVienDTOs = new ArrayList<CongTacVienDTO>();
				for (CongTacVien item : items) {
					List<PhatVay> phatVays = PhatVayLocalServiceUtil.getPhatVayDeThuTienTruoc(maCTVSearch,
							ngayThuTienTu);
					if (CollectionUtils.isNotEmpty(phatVays)) {
						Double tongVonTra = GetterUtil.getDouble("0");
						Double tongLaiTra = GetterUtil.getDouble("0");
						Double tongduNoGoc = GetterUtil.getDouble("0");
						String ngayThuTienTruoc = "";
						for (PhatVay pv : phatVays) {
							Calendar calTu = Calendar.getInstance();
							calTu.setTime(ngayThuTienTu);
							Calendar calDen = Calendar.getInstance();
							calDen.setTime(ngayThuTienDen);
							Calendar calNgayKetThuc = Calendar.getInstance();
							calNgayKetThuc.setTime(pv.getNgayKetThuc());
							Calendar calNgayBatDau = Calendar.getInstance();
							calNgayBatDau.setTime(pv.getNgayBatDau());
							Calendar calNgayThuCuoi = null;
							ngayThuTienTruoc = sdf.format(ngayThuTienTu) + " - " + sdf.format(ngayThuTienDen);
							if (pv.getNgayDaThuCuoi() != null) {
								calNgayThuCuoi = Calendar.getInstance();
								calNgayThuCuoi.setTime(pv.getNgayDaThuCuoi());
								if (CalendarUtil.getGTDate(calNgayThuCuoi).getTime() == CalendarUtil.getGTDate(calTu)
										.getTime()) {
									if (CalendarUtil.getGTDate(calDen).getTime() >= CalendarUtil
											.getGTDate(calNgayKetThuc).getTime()) {
										tongVonTra += pv.getDuNoGoc();
										tongLaiTra += (pv.getLaiNgay()
												* (pv.getThoiHan() - (pv.getSoLanDaThu() + pv.getSoNgayThuTruoc())));
									} else {
										int soLanPhaiThu = (int) ((CalendarUtil.getLTDate(calDen).getTime()
												- CalendarUtil.getGTDate(calTu).getTime()) / time1Ngay);
										tongVonTra += (soLanPhaiThu * pv.getGocNgay());
										tongLaiTra += (soLanPhaiThu * pv.getLaiNgay());
										tongduNoGoc += (pv.getDuNoGoc() - (soLanPhaiThu * pv.getGocNgay()));
									}
								} else if (CalendarUtil.getGTDate(calNgayThuCuoi).getTime() < CalendarUtil
										.getGTDate(calTu).getTime()) {
									if (CalendarUtil.getGTDate(calNgayKetThuc).getTime() >= CalendarUtil
											.getGTDate(calTu).getTime()) {
										if (CalendarUtil.getGTDate(calDen).getTime() >= CalendarUtil
												.getGTDate(calNgayKetThuc).getTime()) {
											int soLanPhaiThu = (int) ((CalendarUtil.getLTDate(calNgayKetThuc).getTime()
													- CalendarUtil.getGTDate(calTu).getTime()) / time1Ngay);
											tongVonTra += (soLanPhaiThu * pv.getGocNgay());
											tongLaiTra += (soLanPhaiThu * pv.getLaiNgay());
											tongduNoGoc += (pv.getDuNoGoc() - (soLanPhaiThu * pv.getGocNgay()));
										} else {
											int soLanPhaiThu = (int) ((CalendarUtil.getLTDate(calDen).getTime()
													- CalendarUtil.getGTDate(calTu).getTime()) / time1Ngay);
											tongVonTra += (soLanPhaiThu * pv.getGocNgay());
											tongLaiTra += (soLanPhaiThu * pv.getLaiNgay());
											tongduNoGoc += (pv.getDuNoGoc() - (soLanPhaiThu * pv.getGocNgay()));
										}
									}
								}
							} else {
								if (CalendarUtil.getGTDate(calNgayBatDau).getTime() == CalendarUtil.getGTDate(calTu)
										.getTime()) {
									if (CalendarUtil.getGTDate(calDen).getTime() >= CalendarUtil
											.getGTDate(calNgayKetThuc).getTime()) {
										tongVonTra += pv.getDuNoGoc();
										tongLaiTra += (pv.getLaiNgay()
												* (pv.getThoiHan() - (pv.getSoLanDaThu() + pv.getSoNgayThuTruoc())));
									} else {
										int soLanPhaiThu = (int) ((CalendarUtil.getLTDate(calDen).getTime()
												- CalendarUtil.getGTDate(calTu).getTime()) / time1Ngay);
										tongVonTra += (soLanPhaiThu * pv.getGocNgay());
										tongLaiTra += (soLanPhaiThu * pv.getLaiNgay());
										tongduNoGoc += (pv.getDuNoGoc() - (soLanPhaiThu * pv.getGocNgay()));
									}
								} else if (CalendarUtil.getGTDate(calNgayBatDau).getTime() < CalendarUtil
										.getGTDate(calTu).getTime()) {
									if (CalendarUtil.getGTDate(calDen).getTime() >= CalendarUtil
											.getGTDate(calNgayKetThuc).getTime()) {
										int soLanPhaiThu = (int) ((CalendarUtil.getLTDate(calNgayKetThuc).getTime()
												- CalendarUtil.getGTDate(calTu).getTime()) / time1Ngay);
										tongVonTra += (soLanPhaiThu * pv.getGocNgay());
										tongLaiTra += (soLanPhaiThu * pv.getLaiNgay());
										tongduNoGoc += (pv.getDuNoGoc() - (soLanPhaiThu * pv.getGocNgay()));
									} else {
										int soLanPhaiThu = (int) ((CalendarUtil.getLTDate(calDen).getTime()
												- CalendarUtil.getGTDate(calTu).getTime()) / time1Ngay);
										tongVonTra += (soLanPhaiThu * pv.getGocNgay());
										tongLaiTra += (soLanPhaiThu * pv.getLaiNgay());
										tongduNoGoc += (pv.getDuNoGoc() - (soLanPhaiThu * pv.getGocNgay()));
									}
								}
							}
						}
						congTacVienDTOs.add(new CongTacVienDTO(
								item.getMa() + "/" + new SimpleDateFormat("ddMMyyyy").format(new Date()), item.getMa(),
								item.getHoTen(), item.getDiaChi(), df.format(tongVonTra).replaceAll(",", "."),
								df.format(tongLaiTra).replaceAll(",", "."),
								df.format(tongLaiTra + tongVonTra).replaceAll(",", "."),
								DocSo.docSo(GetterUtil.getLong(tongLaiTra + tongVonTra)),
								df.format(tongduNoGoc).replaceAll(",", "."), ngayThuTienTruoc, "", "", "", null, null));
					}
				}
				String nameFile = "THU_TIEN_TRUOC_NGAY_" + new SimpleDateFormat("ddMMyyyy").format(new Date());
				if (Validator.isNotNull(maCTVSearch)) {
					nameFile = maCTVSearch + "_" + new SimpleDateFormat("ddMMyyyy").format(new Date());
				}
				resourceResponse.setContentType("application/DOCX");
				resourceResponse.setProperty("Content-Disposition", "attachment; filename=\"" + nameFile + ".docx\"");
				in = getServletContext().getResourceAsStream("report/MAU_THU_TIEN_TRUOC.docx");

				IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in, TemplateEngineKind.Velocity);
				IContext iContext = report.createContext();
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("TEN_CONG_TY", GetterUtil.getString(PropsUtil.get("thongtin.cty.ten")));
				map.put("DIA_CHI_CONG_TY", GetterUtil.getString(PropsUtil.get("thongtin.cty.diachi")));
				map.put("SO_DIEN_THOAI_CONG_TY", GetterUtil.getString(PropsUtil.get("thongtin.cty.sodienthoai")));
				map.put("NGAY", sdf.format(new Date()).substring(0, 2));
				map.put("THANG", sdf.format(new Date()).substring(3, 5));
				map.put("NAM", sdf.format(new Date()).substring(6, 10));

				FieldsMetadata metadata = new FieldsMetadata();
				metadata.addFieldAsList("ctvs.so");
				metadata.addFieldAsList("ctvs.maSo");
				metadata.addFieldAsList("ctvs.hoTen");
				metadata.addFieldAsList("ctvs.diaChi");
				metadata.addFieldAsList("ctvs.vonTra");
				metadata.addFieldAsList("ctvs.laiTra");
				metadata.addFieldAsList("ctvs.tongTien");
				metadata.addFieldAsList("ctvs.tongTienBangChu");
				metadata.addFieldAsList("ctvs.duNoGoc");
				metadata.addFieldAsList("ctvs.ngayThuTienTruoc");
				report.setFieldsMetadata(metadata);
				iContext.putMap(map);
				iContext.put("ctvs", congTacVienDTOs);
				report.process(iContext, outStream);

			} catch (Exception e) {
				e.printStackTrace();
				kq.putException(e);
			} finally {
			}
		}
		outStream.flush();
		return kq;
	}
}