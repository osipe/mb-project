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
import com.mb.exception.TrungLaiSuatException;
import com.mb.exception.TrungMaException;
import com.mb.exception.TrungSoCMNDException;
import com.mb.model.LaiSuat;
import com.mb.service.base.LaiSuatLocalServiceBaseImpl;

/**
 * The implementation of the lai suat local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.mb.service.LaiSuatLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LaiSuatLocalServiceBaseImpl
 */
public class LaiSuatLocalServiceImpl extends LaiSuatLocalServiceBaseImpl {
	public LaiSuat addOrUpdateLaiSuat(LaiSuat LaiSuat, ServiceContext serviceContext)
			throws SystemException, PortalException, TrungSoCMNDException, TrungMaException {
		if (LaiSuat.getLaiSuatId() > 0) {
			return updateLaiSuat(LaiSuat, serviceContext);
		} else {
			return addLaiSuat(LaiSuat, serviceContext);
		}
	}

	public LaiSuat addLaiSuat(LaiSuat LaiSuat, ServiceContext serviceContext)
			throws SystemException, PortalException, TrungLaiSuatException {
		Date now = new Date();
		User user = userPersistence.findByPrimaryKey(serviceContext.getUserId());
		long laiSuatId = counterLocalService.increment(LaiSuat.class.getName());
		LaiSuat.setLaiSuatId(laiSuatId);
		validate(LaiSuat);
		LaiSuat.setGroupId(serviceContext.getScopeGroupId());
		LaiSuat.setCompanyId(user.getCompanyId());
		LaiSuat.setUserId(user.getUserId());
		LaiSuat.setUserName(user.getFullName());
		LaiSuat.setCreateDate(serviceContext.getCreateDate(now));
		LaiSuat.setModifiedDate(serviceContext.getModifiedDate(now));
		LaiSuat.setExpandoBridgeAttributes(serviceContext);
		addLaiSuat(LaiSuat);
		return LaiSuat;
	}

	public LaiSuat updateLaiSuat(LaiSuat LaiSuat, ServiceContext serviceContext)
			throws SystemException, PortalException, TrungLaiSuatException {
		validate(LaiSuat);
		LaiSuat.setExpandoBridgeAttributes(serviceContext);
		updateLaiSuat(LaiSuat);
		return LaiSuat;
	}

	private void validate(LaiSuat LaiSuat) throws SystemException, PortalException, TrungLaiSuatException {
		validateLaiSuat(LaiSuat.getLaiSuatId(), LaiSuat.getSoTienVay(), LaiSuat.getThoiHan());
	}

	private void validateLaiSuat(long laiSuatId, Double soTienVay, int thoiHan)
			throws SystemException, PortalException, TrungLaiSuatException {
		LaiSuat LaiSuat = fetchBySoTienVay_ThoiHan(soTienVay, thoiHan);
		if (LaiSuat != null && LaiSuat.getLaiSuatId() != laiSuatId) {
			throw new TrungLaiSuatException();
		}

	}

	public LaiSuat fetchBySoTienVay_ThoiHan(Double soTienVay, int thoiHan) throws SystemException, PortalException {
		return laiSuatPersistence.fetchBySoTienVay_ThoiHan(soTienVay, thoiHan);
	}

	public List<LaiSuat> findBase( Double soTienVay, Double laiSuat, int thoiHan, int hoatDong,
			int start, int end, OrderByComparator obc) throws SystemException {
		return laiSuatFinder.findBase(soTienVay, laiSuat, thoiHan, hoatDong, start, end, obc);
	}

	public int countBase(Double soTienVay, Double laiSuat, int thoiHan, int hoatDong)
			throws SystemException {
		return laiSuatFinder.countBase( soTienVay, laiSuat, thoiHan, hoatDong);

	}

}