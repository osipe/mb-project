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

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
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
import com.mb.exception.TrungSoHieuException;
import com.mb.model.CongTacVien;
import com.mb.model.TaiKhoanDoiUng;
import com.mb.service.CongTacVienLocalServiceUtil;
import com.mb.service.TaiKhoanDoiUngLocalServiceUtil;

@Component(immediate = true, property = {
		"cron.expression=0 20 20 20 * ?" }, service = TaiKhoanDoiUngCTVScheduler.class)
public class TaiKhoanDoiUngCTVScheduler extends BaseMessageListener {
	private static final Log _log = LogFactoryUtil.getLog(TaiKhoanDoiUngCTVScheduler.class);

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

	private void capNhatDuLieu() throws SystemException, TrungSoHieuException, PortalException {
		_log.info("==TaiKhoanDoiUngCTVScheduler==");
		List<CongTacVien> ctv = CongTacVienLocalServiceUtil.getCongTacVienChuaCoTaiKhoanDU();
		if (CollectionUtils.isNotEmpty(ctv)) {
			for (CongTacVien item : ctv) {
				ServiceContext serviceContext = new ServiceContext();
				serviceContext.setUserId(item.getUserId());
				serviceContext.setCompanyId(item.getCompanyId());
				serviceContext.setScopeGroupId(item.getGroupId());
				TaiKhoanDoiUng taiKhoanDoiUng = TaiKhoanDoiUngLocalServiceUtil.createTaiKhoanDoiUng(0L);
				taiKhoanDoiUng.setHoatDong(true);
				taiKhoanDoiUng.setDienGiaiTheoDoi(item.getHoTen());
				taiKhoanDoiUng.setLoaiTaiKhoan(2);
				taiKhoanDoiUng.setTen(item.getHoTen());
				taiKhoanDoiUng.setTaiKhoanDoiUngChaId(0);
				taiKhoanDoiUng.setSoHieu(item.getMa());
				TaiKhoanDoiUngLocalServiceUtil.addOrUpdateCongTacVien(taiKhoanDoiUng, serviceContext);
			}
		}

	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) throws SchedulerException {
		Class<?> clazz = getClass();
		String className = clazz.getName();
		Trigger trigger = _triggerFactory.createTrigger(className, className, null, null, 5, TimeUnit.MINUTE);
		SchedulerEntry schedulerEntry = new SchedulerEntryImpl(className, trigger);
		_schedulerEngineHelper.register(this, schedulerEntry, DestinationNames.SCHEDULER_DISPATCH);
	}

	@Deactivate
	protected void deactivate() {
		_schedulerEngineHelper.unregister(this);
	}
}
