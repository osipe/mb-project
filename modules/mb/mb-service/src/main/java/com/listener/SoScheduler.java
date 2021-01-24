/**
 * Copyright 2000-present Liferay, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.listener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.module.framework.ModuleServiceLifecycle;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelper;
import com.liferay.portal.kernel.scheduler.SchedulerEntry;
import com.liferay.portal.kernel.scheduler.SchedulerEntryImpl;
import com.liferay.portal.kernel.scheduler.SchedulerException;
import com.liferay.portal.kernel.scheduler.TimeUnit;
import com.liferay.portal.kernel.scheduler.Trigger;
import com.liferay.portal.kernel.scheduler.TriggerFactory;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.mb.model.DsPhieuTaiKhoan;
import com.mb.model.LichSuTaiKhoanDauKy;
import com.mb.model.TaiKhoanDoiUng;
import com.mb.service.DsPhieuTaiKhoanLocalServiceUtil;
import com.mb.service.LichSuTaiKhoanDauKyLocalServiceUtil;
import com.mb.service.TaiKhoanDoiUngLocalServiceUtil;

@Component(immediate = true, property = { "cron.expression=0 1 * * * ?" }, service = SoScheduler.class)
public class SoScheduler extends BaseMessageListener {
	private static final Log _log = LogFactoryUtil.getLog(SoScheduler.class);

	@Reference(target = ModuleServiceLifecycle.PORTAL_INITIALIZED, unbind = "-")
	private volatile ModuleServiceLifecycle _moduleServiceLifecycle;

	@Reference(unbind = "-")
	private volatile SchedulerEngineHelper _schedulerEngineHelper;

	@Reference(unbind = "-")
	private volatile TriggerFactory _triggerFactory;
	private static boolean ON_WORKING = false;

	@Override
	protected void doReceive(Message message) throws Exception {
		if (ON_WORKING)
			return;
		try {
			ON_WORKING = true;
			capNhatDuLieu();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ON_WORKING = false;
		}
	}

	private void capNhatDuLieu(int nam, int month) {
		_log.info("Thang :" + month);
		_log.info("nam :" + nam);
		Calendar calTu = Calendar.getInstance();
		calTu.set(Calendar.YEAR, nam);
		calTu.set(Calendar.MONTH, month - 1);
		calTu.set(Calendar.DATE, 1);
		Date ngayChungTuTu = calTu.getTime();

		Calendar calDen = Calendar.getInstance();
		calDen.set(Calendar.YEAR, nam);
		calDen.set(Calendar.MONTH, calTu.get(Calendar.MONTH));
		calDen.set(Calendar.DATE, CalendarUtil.getDaysInMonth(calTu));
		Date ngayChungTuDen = calDen.getTime();

		_log.info("Ngay tu :" + new SimpleDateFormat("dd/MM/yyyy").format(ngayChungTuTu));
		_log.info("Ngay Den :" + new SimpleDateFormat("dd/MM/yyyy").format(ngayChungTuDen));
		List<TaiKhoanDoiUng> taiKhoanDoiUngCTVs = TaiKhoanDoiUngLocalServiceUtil.findByLoaiTaiKhoan_HoatDong(2, true);
		if (CollectionUtils.isNotEmpty(taiKhoanDoiUngCTVs)) {
			TaiKhoanDoiUng taiKhoanThuVon = TaiKhoanDoiUngLocalServiceUtil
					.fetchBySoHieu(PropsUtil.get("config.taikhoanthuvon"));
			if (taiKhoanThuVon != null) {
				for (TaiKhoanDoiUng item : taiKhoanDoiUngCTVs) {
					List<DsPhieuTaiKhoan> dsPhieuTaiKhoans = DsPhieuTaiKhoanLocalServiceUtil
							.getDSThuChiByTaiKhoanNgayChungTu(taiKhoanThuVon.getTaiKhoanDoiUngId(), item.getSoHieu(),
									ngayChungTuTu, ngayChungTuDen, 1, -1, -1, null);
					try {
						LichSuTaiKhoanDauKy dauKy = LichSuTaiKhoanDauKyLocalServiceUtil
								.fetchByTaiKhoanDoiUngId_Nam_Thang(item.getTaiKhoanDoiUngId(), nam, month);
						int mounthCuoiKy = month + 1;
						int namCuoiKy = nam;
						if(month == 12) {
							mounthCuoiKy = 1;
							namCuoiKy = nam + 1;
						}
						LichSuTaiKhoanDauKy cuoiKy = LichSuTaiKhoanDauKyLocalServiceUtil
								.fetchByTaiKhoanDoiUngId_Nam_Thang(item.getTaiKhoanDoiUngId(), namCuoiKy, mounthCuoiKy);
						if (dauKy == null) {
							dauKy = LichSuTaiKhoanDauKyLocalServiceUtil.createLichSuTaiKhoanDauKy(0L);
						}
						if (cuoiKy == null) {
							cuoiKy = LichSuTaiKhoanDauKyLocalServiceUtil.createLichSuTaiKhoanDauKy(0L);
							cuoiKy.setTaiKhoanDoiUngId(item.getTaiKhoanDoiUngId());
							cuoiKy.setThang(mounthCuoiKy);
							cuoiKy.setNam(namCuoiKy);
						}
						Double soTienTon = dauKy.getSoTienTon() != null ? dauKy.getSoTienTon()
								: GetterUtil.getDouble("0");
						Double soTienThu = dauKy.getSoTienThu() != null ? dauKy.getSoTienThu()
								: GetterUtil.getDouble("0");
						Double soTienChi = dauKy.getSoTienChi() != null ? dauKy.getSoTienChi()
								: GetterUtil.getDouble("0");
						ServiceContext serviceContext = new ServiceContext();
						serviceContext.setUserId(item.getUserId());
						serviceContext.setCompanyId(item.getCompanyId());
						serviceContext.setScopeGroupId(item.getGroupId());
						for (DsPhieuTaiKhoan dsPhieuTaiKhoan : dsPhieuTaiKhoans) {
							if (dsPhieuTaiKhoan.getPhieu() != null) {
								if (dsPhieuTaiKhoan.getPhieu().getLoai() == 1) {
									soTienThu += dsPhieuTaiKhoan.getSoTien();
									soTienTon -= dsPhieuTaiKhoan.getSoTien();
								} else if (dsPhieuTaiKhoan.getPhieu().getLoai() == 2) {
									soTienTon += dsPhieuTaiKhoan.getSoTien();
									soTienChi += dsPhieuTaiKhoan.getSoTien();
								}
							}
						}
						cuoiKy.setSoTienThu(soTienThu);
						cuoiKy.setSoTienChi(soTienChi);
						cuoiKy.setHoatDong(true);
						cuoiKy.setSoTienTon(soTienTon != null ? soTienTon : GetterUtil.getDouble("0"));
						LichSuTaiKhoanDauKyLocalServiceUtil.addOrUpdateLichSuTaiKhoanDauKy(cuoiKy, serviceContext);
					} catch (Exception e) {
						e.printStackTrace();
					}

				}

			}
		}
		List<TaiKhoanDoiUng> taiKhoanDoiUngCtys = TaiKhoanDoiUngLocalServiceUtil.findByLoaiTaiKhoan_HoatDong(1, true);
		if (CollectionUtils.isNotEmpty(taiKhoanDoiUngCtys)) {
			for (TaiKhoanDoiUng item : taiKhoanDoiUngCtys) {
				if (item.getSoHieu().equals(PropsUtil.get("config.taikhoanthuvon"))) {
					try {
						LichSuTaiKhoanDauKy dauKy = LichSuTaiKhoanDauKyLocalServiceUtil
								.fetchByTaiKhoanDoiUngId_Nam_Thang(item.getTaiKhoanDoiUngId(), nam, month);
						int mounthCuoiKy = month + 1;
						int namCuoiKy = nam;
						if(month == 12) {
							mounthCuoiKy = 1;
							namCuoiKy = nam + 1;
						}
						LichSuTaiKhoanDauKy cuoiKy = LichSuTaiKhoanDauKyLocalServiceUtil
								.fetchByTaiKhoanDoiUngId_Nam_Thang(item.getTaiKhoanDoiUngId(), namCuoiKy, mounthCuoiKy);
						if (dauKy == null) {
							dauKy = LichSuTaiKhoanDauKyLocalServiceUtil.createLichSuTaiKhoanDauKy(0L);
						}
						if (cuoiKy == null) {
							cuoiKy = LichSuTaiKhoanDauKyLocalServiceUtil.createLichSuTaiKhoanDauKy(0L);
							cuoiKy.setTaiKhoanDoiUngId(item.getTaiKhoanDoiUngId());
							cuoiKy.setThang(mounthCuoiKy);
							cuoiKy.setNam(namCuoiKy);
						}
						Double soTienTon = dauKy.getSoTienTon() != null ? dauKy.getSoTienTon()
								: GetterUtil.getDouble("0");
						Double soTienThu = dauKy.getSoTienThu() != null ? dauKy.getSoTienThu()
								: GetterUtil.getDouble("0");
						Double soTienChi = dauKy.getSoTienChi() != null ? dauKy.getSoTienChi()
								: GetterUtil.getDouble("0");
						ServiceContext serviceContext = new ServiceContext();
						serviceContext.setUserId(item.getUserId());
						serviceContext.setCompanyId(item.getCompanyId());
						serviceContext.setScopeGroupId(item.getGroupId());
						List<DsPhieuTaiKhoan> dsPhieuTaiKhoans = DsPhieuTaiKhoanLocalServiceUtil
								.getDSThuChiByTaiKhoanNgayChungTu(item.getTaiKhoanDoiUngId(), "", ngayChungTuTu,
										ngayChungTuDen, 1, -1, -1, null);
						for (DsPhieuTaiKhoan dsPhieuTaiKhoan : dsPhieuTaiKhoans) {
							if (dsPhieuTaiKhoan.getPhieu() != null) {
								if (dsPhieuTaiKhoan.getPhieu().getLoai() == 1) {
									soTienThu += dsPhieuTaiKhoan.getSoTien();
									soTienTon -= dsPhieuTaiKhoan.getSoTien();
								} else if (dsPhieuTaiKhoan.getPhieu().getLoai() == 2) {
									soTienTon += dsPhieuTaiKhoan.getSoTien();
									soTienChi += dsPhieuTaiKhoan.getSoTien();
								}
							}
						}
						cuoiKy.setSoTienThu(soTienThu);
						cuoiKy.setSoTienChi(soTienChi);
						cuoiKy.setHoatDong(true);
						cuoiKy.setSoTienTon(soTienTon != null ? soTienTon : GetterUtil.getDouble("0"));
						LichSuTaiKhoanDauKyLocalServiceUtil.addOrUpdateLichSuTaiKhoanDauKy(cuoiKy, serviceContext);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					try {
						LichSuTaiKhoanDauKy dauKy = LichSuTaiKhoanDauKyLocalServiceUtil
								.fetchByTaiKhoanDoiUngId_Nam_Thang(item.getTaiKhoanDoiUngId(), nam, month);
						int mounthCuoiKy = month + 1;
						int namCuoiKy = nam;
						if(month == 12) {
							mounthCuoiKy = 1;
							namCuoiKy = nam + 1;
						}
						LichSuTaiKhoanDauKy cuoiKy = LichSuTaiKhoanDauKyLocalServiceUtil
								.fetchByTaiKhoanDoiUngId_Nam_Thang(item.getTaiKhoanDoiUngId(), namCuoiKy, mounthCuoiKy);
						if (dauKy == null) {
							dauKy = LichSuTaiKhoanDauKyLocalServiceUtil.createLichSuTaiKhoanDauKy(0L);
						}
						if (cuoiKy == null) {
							cuoiKy = LichSuTaiKhoanDauKyLocalServiceUtil.createLichSuTaiKhoanDauKy(0L);
							cuoiKy.setTaiKhoanDoiUngId(item.getTaiKhoanDoiUngId());
							cuoiKy.setThang(mounthCuoiKy);
							cuoiKy.setNam(namCuoiKy);
						}
						Double soTienTon = dauKy.getSoTienTon() != null ? dauKy.getSoTienTon()
								: GetterUtil.getDouble("0");
						Double soTienThu = dauKy.getSoTienThu() != null ? dauKy.getSoTienThu()
								: GetterUtil.getDouble("0");
						Double soTienChi = dauKy.getSoTienChi() != null ? dauKy.getSoTienChi()
								: GetterUtil.getDouble("0");
						ServiceContext serviceContext = new ServiceContext();
						serviceContext.setUserId(item.getUserId());
						serviceContext.setCompanyId(item.getCompanyId());
						serviceContext.setScopeGroupId(item.getGroupId());
						List<DsPhieuTaiKhoan> dsPhieuTaiKhoans = DsPhieuTaiKhoanLocalServiceUtil
								.getDSThuChiByTaiKhoanNgayChungTu(item.getTaiKhoanDoiUngId(), "", ngayChungTuTu,
										ngayChungTuDen, 1, -1, -1, null);
						for (DsPhieuTaiKhoan dsPhieuTaiKhoan : dsPhieuTaiKhoans) {
							if (dsPhieuTaiKhoan.getPhieu() != null) {
								if (dsPhieuTaiKhoan.getPhieu().getLoai() == 1) {
									soTienThu += dsPhieuTaiKhoan.getSoTien();
									soTienTon += dsPhieuTaiKhoan.getSoTien();
								} else if (dsPhieuTaiKhoan.getPhieu().getLoai() == 2) {
									soTienTon -= dsPhieuTaiKhoan.getSoTien();
									soTienChi += dsPhieuTaiKhoan.getSoTien();
								}
							}
						}
						cuoiKy.setSoTienThu(soTienThu);
						cuoiKy.setSoTienChi(soTienChi);
						cuoiKy.setHoatDong(true);
						cuoiKy.setSoTienTon(soTienTon != null ? soTienTon : GetterUtil.getDouble("0"));
						LichSuTaiKhoanDauKyLocalServiceUtil.addOrUpdateLichSuTaiKhoanDauKy(cuoiKy, serviceContext);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			}
		}
	}

	private void capNhatDuLieu() {
		Calendar cal = Calendar.getInstance();
		int namNow = cal.get(Calendar.YEAR);
		int monthNow = cal.get(Calendar.MONTH) + 1;
		for (int i = 1; i <= monthNow; i++) {
			if(i == 1) {
				capNhatDuLieu(namNow - 1, 12);
			}
			capNhatDuLieu(namNow, i);
		}
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) throws SchedulerException {
		Class<?> clazz = getClass();
		String className = clazz.getName();
		Trigger trigger = _triggerFactory.createTrigger(className, className, null, null, 10, TimeUnit.SECOND);
		SchedulerEntry schedulerEntry = new SchedulerEntryImpl(className, trigger);
		_schedulerEngineHelper.register(this, schedulerEntry, DestinationNames.SCHEDULER_DISPATCH);
	}

	@Deactivate
	protected void deactivate() {
		_schedulerEngineHelper.unregister(this);
	}
}
