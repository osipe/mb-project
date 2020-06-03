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
import com.mb.exception.TrungDuLieuDauKyException;
import com.mb.model.LichSuTaiKhoanDauKy;
import com.mb.service.base.LichSuTaiKhoanDauKyLocalServiceBaseImpl;

/**
 * The implementation of the lich su tai khoan dau ky local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.mb.service.LichSuTaiKhoanDauKyLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LichSuTaiKhoanDauKyLocalServiceBaseImpl
 */
public class LichSuTaiKhoanDauKyLocalServiceImpl extends LichSuTaiKhoanDauKyLocalServiceBaseImpl {
	public LichSuTaiKhoanDauKy addOrUpdateLichSuTaiKhoanDauKy(LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy,
			ServiceContext serviceContext) throws SystemException, PortalException {
		if (lichSuTaiKhoanDauKy.getLichSuTaiKhoanDauKyId() > 0) {
			return updateLichSuTaiKhoanDauKy(lichSuTaiKhoanDauKy, serviceContext);
		} else {
			return addLichSuTaiKhoanDauKy(lichSuTaiKhoanDauKy, serviceContext);
		}
	}

	public LichSuTaiKhoanDauKy addLichSuTaiKhoanDauKy(LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy,
			ServiceContext serviceContext) throws SystemException, PortalException, TrungDuLieuDauKyException {
		Date now = new Date();
		User user = userPersistence.findByPrimaryKey(serviceContext.getUserId());
		long lichSuTaiKhoanDauKyId = counterLocalService.increment(LichSuTaiKhoanDauKy.class.getName());
		lichSuTaiKhoanDauKy.setLichSuTaiKhoanDauKyId(lichSuTaiKhoanDauKyId);
		validate(lichSuTaiKhoanDauKy);
		lichSuTaiKhoanDauKy.setGroupId(serviceContext.getScopeGroupId());
		lichSuTaiKhoanDauKy.setCompanyId(user.getCompanyId());
		lichSuTaiKhoanDauKy.setUserId(user.getUserId());
		lichSuTaiKhoanDauKy.setUserName(user.getFullName());
		lichSuTaiKhoanDauKy.setCreateDate(now);
		lichSuTaiKhoanDauKy.setModifiedDate(now);
		lichSuTaiKhoanDauKy.setExpandoBridgeAttributes(serviceContext);
		addLichSuTaiKhoanDauKy(lichSuTaiKhoanDauKy);
		return lichSuTaiKhoanDauKy;
	}

	public LichSuTaiKhoanDauKy updateLichSuTaiKhoanDauKy(LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy,
			ServiceContext serviceContext) throws SystemException, PortalException, TrungDuLieuDauKyException {
		validate(lichSuTaiKhoanDauKy);
		lichSuTaiKhoanDauKy.setExpandoBridgeAttributes(serviceContext);
		updateLichSuTaiKhoanDauKy(lichSuTaiKhoanDauKy);
		return lichSuTaiKhoanDauKy;
	}

	private void validate(LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy)
			throws SystemException, PortalException, TrungDuLieuDauKyException {
		validateTrungDauKy(lichSuTaiKhoanDauKy.getLichSuTaiKhoanDauKyId(), lichSuTaiKhoanDauKy.getTaiKhoanDoiUngId(),
				lichSuTaiKhoanDauKy.getNam(), lichSuTaiKhoanDauKy.getThang());
	}

	private void validateTrungDauKy(long lichSuTaiKhoanDauKyId, long taiKhoanDoiUngId, int nam, int thang)
			throws SystemException, PortalException {
		LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy = fetchByTaiKhoanDoiUngId_Nam_Thang(taiKhoanDoiUngId, nam, thang);
		if (lichSuTaiKhoanDauKy != null && lichSuTaiKhoanDauKy.getLichSuTaiKhoanDauKyId() != lichSuTaiKhoanDauKyId) {
			throw new TrungDuLieuDauKyException();
		}
	}

	public List<LichSuTaiKhoanDauKy> findByTaiKhoanDoiUngId(long taiKhoanDoiUngId) throws SystemException {
		return lichSuTaiKhoanDauKyPersistence.findByTaiKhoanDoiUngId(taiKhoanDoiUngId);
	}

	public LichSuTaiKhoanDauKy fetchByTaiKhoanDoiUngId_Nam_Thang(long taiKhoanDoiUngId, int nam, int thang)
			throws SystemException {
		return lichSuTaiKhoanDauKyPersistence.fetchByTaiKhoanDoiUngId_Nam_Thang(taiKhoanDoiUngId, nam, thang);
	}

	public int countBase(int nam, int thang, long taiKhoanDoiUngId) throws SystemException {
		return lichSuTaiKhoanDauKyFinder.countBase(nam, thang, taiKhoanDoiUngId);
	}

	public List<LichSuTaiKhoanDauKy> findBase(int nam, int thang, long taiKhoanDoiUngId, int start, int end,
			OrderByComparator obc) throws SystemException {
		return lichSuTaiKhoanDauKyFinder.findBase(nam, thang, taiKhoanDoiUngId, start, end, obc);
	}
}