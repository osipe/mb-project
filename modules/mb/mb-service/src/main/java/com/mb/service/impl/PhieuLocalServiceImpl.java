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

import com.liferay.portal.kernel.exception.NoSuchUserException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.mb.exception.TrungSoKUException;
import com.mb.model.Phieu;
import com.mb.service.base.PhieuLocalServiceBaseImpl;

/**
 * The implementation of the phieu local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.mb.service.PhieuLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PhieuLocalServiceBaseImpl
 */
public class PhieuLocalServiceImpl extends PhieuLocalServiceBaseImpl {

	public Phieu addOrUpdatePhieu(Phieu phieu, ServiceContext serviceContext)
			throws SystemException, NoSuchUserException, TrungSoKUException {
		if (phieu.getPhieuId() > 0) {
			return updatePhieu(phieu, serviceContext);
		} else {
			return addPhieu(phieu, serviceContext);
		}
	}

	public Phieu addPhieu(Phieu phieu, ServiceContext serviceContext)
			throws SystemException, NoSuchUserException, TrungSoKUException {
		Date now = new Date();
		User user = userPersistence.findByPrimaryKey(serviceContext.getUserId());
		long phieuId = counterLocalService.increment(Phieu.class.getName());
		phieu.setPhieuId(phieuId);
		phieu.setGroupId(serviceContext.getScopeGroupId());
		phieu.setCompanyId(user.getCompanyId());
		phieu.setUserId(user.getUserId());
		phieu.setUserName(user.getFullName());
		phieu.setCreateDate(serviceContext.getCreateDate(now));
		phieu.setModifiedDate(serviceContext.getModifiedDate(now));
		phieu.setExpandoBridgeAttributes(serviceContext);
		addPhieu(phieu);
		return phieu;
	}

	public Phieu updatePhieu(Phieu phieu, ServiceContext serviceContext)
			throws SystemException, NoSuchUserException, TrungSoKUException {
		phieu.setExpandoBridgeAttributes(serviceContext);
		updatePhieu(phieu);
		return phieu;
	}

	public List<Phieu> findBase(String maCTV,String maMSThuChi, String soPhieu, Date ngayChungTuTu, Date ngayChungTuDen, int loai, int hoatDong,
			int start, int end, OrderByComparator obc) throws SystemException {
		return phieuFinder.findBase(maCTV,maMSThuChi,soPhieu, ngayChungTuTu, ngayChungTuDen, loai, hoatDong, start, end, obc);
	}

	public int countBase(String maCTV,String maMSThuChi, String soPhieu, Date ngayChungTuTu, Date ngayChungTuDen, int loai, int hoatDong)
			throws SystemException {
		return phieuFinder.countBase(maCTV,maMSThuChi,soPhieu, ngayChungTuTu, ngayChungTuDen, loai, hoatDong);

	}

}