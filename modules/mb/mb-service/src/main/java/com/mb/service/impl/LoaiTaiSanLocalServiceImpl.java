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
import com.mb.exception.TrungSoCMNDException;
import com.mb.model.LoaiTaiSan;
import com.mb.service.base.LoaiTaiSanLocalServiceBaseImpl;

/**
 * The implementation of the loai tai san local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.mb.service.LoaiTaiSanLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LoaiTaiSanLocalServiceBaseImpl
 */
public class LoaiTaiSanLocalServiceImpl extends LoaiTaiSanLocalServiceBaseImpl {

	public LoaiTaiSan addOrUpdateLoaiTaiSan(LoaiTaiSan LoaiTaiSan, ServiceContext serviceContext)
			throws SystemException, PortalException, TrungSoCMNDException, TrungMaException {
		if (LoaiTaiSan.getLoaiTaiSanId() > 0) {
			return updateLoaiTaiSan(LoaiTaiSan, serviceContext);
		} else {
			return addLoaiTaiSan(LoaiTaiSan, serviceContext);
		}
	}

	public LoaiTaiSan addLoaiTaiSan(LoaiTaiSan LoaiTaiSan, ServiceContext serviceContext)
			throws SystemException, PortalException, TrungSoCMNDException, TrungMaException {
		Date now = new Date();
		User user = userPersistence.findByPrimaryKey(serviceContext.getUserId());
		long loaiTaiSanId = counterLocalService.increment(LoaiTaiSan.class.getName());
		LoaiTaiSan.setLoaiTaiSanId(loaiTaiSanId);
		validate(LoaiTaiSan);
		LoaiTaiSan.setGroupId(serviceContext.getScopeGroupId());
		LoaiTaiSan.setCompanyId(user.getCompanyId());
		LoaiTaiSan.setUserId(user.getUserId());
		LoaiTaiSan.setUserName(user.getFullName());
		LoaiTaiSan.setCreateDate(serviceContext.getCreateDate(now));
		LoaiTaiSan.setModifiedDate(serviceContext.getModifiedDate(now));
		LoaiTaiSan.setExpandoBridgeAttributes(serviceContext);
		addLoaiTaiSan(LoaiTaiSan);
		return LoaiTaiSan;
	}

	public LoaiTaiSan updateLoaiTaiSan(LoaiTaiSan LoaiTaiSan, ServiceContext serviceContext)
			throws SystemException, PortalException, TrungSoCMNDException, TrungMaException {
		validate(LoaiTaiSan);
		LoaiTaiSan.setExpandoBridgeAttributes(serviceContext);
		updateLoaiTaiSan(LoaiTaiSan);
		return LoaiTaiSan;
	}

	private void validate(LoaiTaiSan LoaiTaiSan)
			throws SystemException, PortalException, TrungSoCMNDException, TrungMaException {
		validateTrungMa(LoaiTaiSan.getLoaiTaiSanId(), LoaiTaiSan.getMa());
	}

	private void validateTrungMa(long loaiTaiSanId, String ma)
			throws SystemException, PortalException, TrungMaException {
		if (Validator.isNotNull(ma)) {
			LoaiTaiSan LoaiTaiSan = fetchByMa(ma);
			if (LoaiTaiSan != null && LoaiTaiSan.getLoaiTaiSanId() != loaiTaiSanId) {
				throw new TrungMaException();
			}
		}
	}

	public LoaiTaiSan fetchByMa(String ma) throws SystemException {
		return loaiTaiSanPersistence.fetchByMa(ma);
	}

	public List<LoaiTaiSan> findBase(String ma, String ten, String ghiChu, int hoatDong, int start,
			int end, OrderByComparator obc) throws SystemException {
		return loaiTaiSanFinder.findBase( ma, ten, ghiChu, hoatDong, start, end, obc);
	}

	public int countBase(String ma, String ten, String ghiChu, int hoatDong)
			throws SystemException {
		return loaiTaiSanFinder.countBase( ma, ten, ghiChu, hoatDong);

	}
}