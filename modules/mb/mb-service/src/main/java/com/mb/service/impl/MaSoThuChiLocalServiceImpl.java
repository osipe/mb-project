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
import com.liferay.portal.kernel.util.Validator;
import com.mb.exception.TrungMaException;
import com.mb.model.MaSoThuChi;
import com.mb.service.base.MaSoThuChiLocalServiceBaseImpl;

/**
 * The implementation of the ma so thu chi local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.mb.service.MaSoThuChiLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MaSoThuChiLocalServiceBaseImpl
 */
public class MaSoThuChiLocalServiceImpl extends MaSoThuChiLocalServiceBaseImpl {
	public MaSoThuChi addOrUpdateMaSoThuChi(MaSoThuChi maSoThuChi, ServiceContext serviceContext)
			throws SystemException, PortalException,TrungMaException {
		if (maSoThuChi.getMaSoThuChiId() > 0) {
			return updateMaSoThuChi(maSoThuChi, serviceContext);
		} else {
			return addMaSoThuChi(maSoThuChi, serviceContext);
		}
	}

	public MaSoThuChi addMaSoThuChi(MaSoThuChi maSoThuChi, ServiceContext serviceContext)
			throws SystemException, PortalException,TrungMaException {
		Date now = new Date();
		User user = userPersistence.findByPrimaryKey(serviceContext.getUserId());
		long maSoThuChiId = counterLocalService.increment(MaSoThuChi.class.getName());
		maSoThuChi.setMaSoThuChiId(maSoThuChiId);
		validate(maSoThuChi);
		maSoThuChi.setGroupId(serviceContext.getScopeGroupId());
		maSoThuChi.setCompanyId(user.getCompanyId());
		maSoThuChi.setUserId(user.getUserId());
		maSoThuChi.setUserName(user.getFullName());
		maSoThuChi.setCreateDate(serviceContext.getCreateDate(now));
		maSoThuChi.setModifiedDate(serviceContext.getModifiedDate(now));
		maSoThuChi.setExpandoBridgeAttributes(serviceContext);
		addMaSoThuChi(maSoThuChi);
		return maSoThuChi;
	}

	public MaSoThuChi updateMaSoThuChi(MaSoThuChi maSoThuChi, ServiceContext serviceContext)
			throws SystemException, PortalException,TrungMaException {
		validate(maSoThuChi);
		maSoThuChi.setExpandoBridgeAttributes(serviceContext);
		updateMaSoThuChi(maSoThuChi);
		return maSoThuChi;
	}

	private void validate(MaSoThuChi maSoThuChi)
			throws SystemException, PortalException,TrungMaException {
		validateTrungMa(maSoThuChi.getMaSoThuChiId(), maSoThuChi.getMa(), maSoThuChi.getLoai());
	}

	private void validateTrungMa(long maSoThuChiId, String ma, int loai)
			throws SystemException, PortalException, TrungMaException {
		if (Validator.isNotNull(ma)) {
			MaSoThuChi maSoThuChi = fetchByMa_Loai_HoatDong(ma, loai, true);
			if (maSoThuChi != null && maSoThuChi.getMaSoThuChiId() != maSoThuChiId) {
				throw new TrungMaException();
			}
			maSoThuChi = fetchByMa_Loai_HoatDong(ma, loai, false);
			if (maSoThuChi != null && maSoThuChi.getMaSoThuChiId() != maSoThuChiId) {
				throw new TrungMaException();
			}
		}
	}

	public List<MaSoThuChi> findByLoai_HoatDong(int loai, boolean hoatDong) throws SystemException {
		return maSoThuChiPersistence.findByLoai_HoatDong(loai, hoatDong);
	}

	public MaSoThuChi fetchByMa_Loai_HoatDong(String ma, int loai, boolean hoatDong) throws SystemException {
		return maSoThuChiPersistence.fetchByMa_Loai_HoatDong(ma, loai, hoatDong);
	}

	public List<MaSoThuChi> findBase(String ma, String dienGiai,int loai, int hoatDong, int start, int end,
			OrderByComparator obc) throws SystemException {
		return maSoThuChiFinder.findBase(ma, dienGiai, loai,hoatDong, start, end, obc);
	}

	public int countBase(String ma, String dienGiai,int loai, int hoatDong) throws SystemException {
		return maSoThuChiFinder.countBase(ma, dienGiai,loai, hoatDong);
	}
}