/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.mb.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.mb.exception.TrungMaException;
import com.mb.model.MaSoTheoDoi;
import com.mb.service.base.MaSoTheoDoiLocalServiceBaseImpl;

/**
 * The implementation of the ma so theo doi local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.mb.service.MaSoTheoDoiLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MaSoTheoDoiLocalServiceBaseImpl
 */
public class MaSoTheoDoiLocalServiceImpl extends MaSoTheoDoiLocalServiceBaseImpl {

	public MaSoTheoDoi addOrUpdateMaSoThuChi(MaSoTheoDoi maSoTheoDoi, ServiceContext serviceContext)
			throws SystemException, PortalException, TrungMaException {
		if (maSoTheoDoi.getMaSoTheoDoiId() > 0) {
			return updateMaSoTheoDoi(maSoTheoDoi, serviceContext);
		} else {
			return addMaSoTheoDoi(maSoTheoDoi, serviceContext);
		}
	}

	public MaSoTheoDoi addMaSoTheoDoi(MaSoTheoDoi maSoTheoDoi, ServiceContext serviceContext)
			throws SystemException, PortalException {
		Date now = new Date();
		User user = userPersistence.findByPrimaryKey(serviceContext.getUserId());
		long maSoTheoDoiId = counterLocalService.increment(MaSoTheoDoi.class.getName());
		maSoTheoDoi.setMaSoTheoDoiId(maSoTheoDoiId);
		maSoTheoDoi.setGroupId(serviceContext.getScopeGroupId());
		maSoTheoDoi.setCompanyId(user.getCompanyId());
		maSoTheoDoi.setUserId(user.getUserId());
		maSoTheoDoi.setUserName(user.getFullName());
		maSoTheoDoi.setCreateDate(serviceContext.getCreateDate(now));
		maSoTheoDoi.setModifiedDate(serviceContext.getModifiedDate(now));
		maSoTheoDoi.setExpandoBridgeAttributes(serviceContext);
		addMaSoTheoDoi(maSoTheoDoi);
		return maSoTheoDoi;
	}

	public MaSoTheoDoi updateMaSoTheoDoi(MaSoTheoDoi maSoTheoDoi, ServiceContext serviceContext)
			throws SystemException, PortalException {
		maSoTheoDoi.setExpandoBridgeAttributes(serviceContext);
		updateMaSoTheoDoi(maSoTheoDoi);
		return maSoTheoDoi;
	}
	public MaSoTheoDoi fetchByMa(String ma) throws SystemException {
		return maSoTheoDoiPersistence.fetchByMa(ma);
	}
	public List<MaSoTheoDoi> findBase(String ma, String dienGiai, int hoatDong, int start, int end,
			OrderByComparator obc) throws SystemException {
		return maSoTheoDoiFinder.findBase(ma, dienGiai, hoatDong, start, end, obc);
	}

	public int countBase(String ma, String dienGiai, int hoatDong) throws SystemException {
		return maSoTheoDoiFinder.countBase(ma, dienGiai, hoatDong);
	}
}