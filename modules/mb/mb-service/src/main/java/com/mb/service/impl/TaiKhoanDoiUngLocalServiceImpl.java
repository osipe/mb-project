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
import com.mb.exception.TrungSoHieuException;
import com.mb.model.TaiKhoanDoiUng;
import com.mb.service.base.TaiKhoanDoiUngLocalServiceBaseImpl;

/**
 * The implementation of the tai khoan doi ung local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.mb.service.TaiKhoanDoiUngLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaiKhoanDoiUngLocalServiceBaseImpl
 */
public class TaiKhoanDoiUngLocalServiceImpl extends TaiKhoanDoiUngLocalServiceBaseImpl {
	public TaiKhoanDoiUng addOrUpdateCongTacVien(TaiKhoanDoiUng taiKhoanDoiUng, ServiceContext serviceContext)
			throws SystemException, PortalException, TrungSoHieuException {
		if (taiKhoanDoiUng.getTaiKhoanDoiUngId() > 0) {
			return updateTaiKhoanDoiUng(taiKhoanDoiUng, serviceContext);
		} else {
			return addTaiKhoanDoiUng(taiKhoanDoiUng, serviceContext);
		}
	}

	public TaiKhoanDoiUng addTaiKhoanDoiUng(TaiKhoanDoiUng taiKhoanDoiUng, ServiceContext serviceContext)
			throws SystemException, PortalException, TrungSoHieuException {
		Date now = new Date();
		User user = userPersistence.findByPrimaryKey(serviceContext.getUserId());
		long taiKhoanDoiUngId = counterLocalService.increment(TaiKhoanDoiUng.class.getName());
		taiKhoanDoiUng.setTaiKhoanDoiUngId(taiKhoanDoiUngId);
		validate(taiKhoanDoiUng);
		taiKhoanDoiUng.setGroupId(serviceContext.getScopeGroupId());
		taiKhoanDoiUng.setCompanyId(user.getCompanyId());
		taiKhoanDoiUng.setUserId(user.getUserId());
		taiKhoanDoiUng.setUserName(user.getFullName());
		taiKhoanDoiUng.setCreateDate(serviceContext.getCreateDate(now));
		taiKhoanDoiUng.setModifiedDate(serviceContext.getModifiedDate(now));
		taiKhoanDoiUng.setExpandoBridgeAttributes(serviceContext);
		addTaiKhoanDoiUng(taiKhoanDoiUng);
		return taiKhoanDoiUng;
	}

	public TaiKhoanDoiUng updateTaiKhoanDoiUng(TaiKhoanDoiUng taiKhoanDoiUng, ServiceContext serviceContext)
			throws SystemException, PortalException, TrungSoHieuException {
		validate(taiKhoanDoiUng);
		taiKhoanDoiUng.setExpandoBridgeAttributes(serviceContext);
		updateTaiKhoanDoiUng(taiKhoanDoiUng);
		return taiKhoanDoiUng;
	}

	private void validate(TaiKhoanDoiUng taiKhoanDoiUng) throws SystemException, PortalException, TrungSoHieuException {
		validateTrungSoHieu(taiKhoanDoiUng.getTaiKhoanDoiUngId(), taiKhoanDoiUng.getSoHieu());
	}

	private void validateTrungSoHieu(long taiKhoanDoiUngId, String soHieu)
			throws SystemException, PortalException, TrungSoHieuException {
		if (Validator.isNotNull(soHieu)) {
			TaiKhoanDoiUng taiKhoanDoiUng = fetchBySoHieu(soHieu);
			if (taiKhoanDoiUng != null && taiKhoanDoiUng.getTaiKhoanDoiUngId() != taiKhoanDoiUngId) {
				throw new TrungSoHieuException();
			}
		}
	}

	public TaiKhoanDoiUng fetchBySoHieu(String soHieu) throws SystemException {
		return taiKhoanDoiUngPersistence.fetchBySoHieu(soHieu);
	}

	public List<TaiKhoanDoiUng> findBase(long taiKhoanDoiUngChaId, String soHieu, String ten, int hoatDong, int start,
			int end, OrderByComparator obc) throws SystemException {
		return taiKhoanDoiUngFinder.findBase(taiKhoanDoiUngChaId, soHieu, ten, hoatDong, start, end, obc);
	}

	public int countBase(long taiKhoanDoiUngChaId, String soHieu, String ten, int hoatDong) throws SystemException {
		return taiKhoanDoiUngFinder.countBase(taiKhoanDoiUngChaId, soHieu, ten, hoatDong);

	}

	public List<TaiKhoanDoiUng> findByLoaiTaiKhoan_HoatDong(int loaiTaiKhoan, boolean hoatDong) throws SystemException {
		return taiKhoanDoiUngPersistence.findByLoaiTaiKhoan_HoatDong(loaiTaiKhoan, hoatDong);
	}

}