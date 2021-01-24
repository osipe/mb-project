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
import com.mb.model.ChiNhanh;
import com.mb.model.CongTacVien;
import com.mb.service.base.ChiNhanhLocalServiceBaseImpl;

/**
 * The implementation of the chi nhanh local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.mb.service.ChiNhanhLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ChiNhanhLocalServiceBaseImpl
 */
public class ChiNhanhLocalServiceImpl extends ChiNhanhLocalServiceBaseImpl {

	public ChiNhanh addOrUpdateChiNhanh(ChiNhanh chiNhanh, ServiceContext serviceContext)
			throws SystemException, PortalException, TrungSoCMNDException, TrungMaException {
		if (chiNhanh.getChiNhanhId() > 0) {
			return updateChiNhanh(chiNhanh, serviceContext);
		} else {
			return addChiNhanh(chiNhanh, serviceContext);
		}
	}

	public ChiNhanh addChiNhanh(ChiNhanh chiNhanh, ServiceContext serviceContext)
			throws SystemException, PortalException, TrungSoCMNDException, TrungMaException {
		Date now = new Date();
		User user = userPersistence.findByPrimaryKey(serviceContext.getUserId());
		long chiNhanhId = counterLocalService.increment(ChiNhanh.class.getName());
		chiNhanh.setChiNhanhId(chiNhanhId);
		validate(chiNhanh);
		chiNhanh.setGroupId(serviceContext.getScopeGroupId());
		chiNhanh.setCompanyId(user.getCompanyId());
		chiNhanh.setUserId(user.getUserId());
		chiNhanh.setUserName(user.getFullName());
		chiNhanh.setCreateDate(serviceContext.getCreateDate(now));
		chiNhanh.setModifiedDate(serviceContext.getModifiedDate(now));
		chiNhanh.setExpandoBridgeAttributes(serviceContext);
		addChiNhanh(chiNhanh);
		return chiNhanh;
	}

	public ChiNhanh updateChiNhanh(ChiNhanh chiNhanh, ServiceContext serviceContext)
			throws SystemException, PortalException, TrungSoCMNDException, TrungMaException {
		validate(chiNhanh);
		chiNhanh.setExpandoBridgeAttributes(serviceContext);
		updateChiNhanh(chiNhanh);
		return chiNhanh;
	}

	private void validate(ChiNhanh chiNhanh)
			throws SystemException, PortalException, TrungSoCMNDException, TrungMaException {
		validateTrungMa(chiNhanh.getChiNhanhId(), chiNhanh.getMa());
	}

	private void validateTrungMa(long chiNhanhId, String ma) throws SystemException, PortalException, TrungMaException {
		if (Validator.isNotNull(ma)) {
			ChiNhanh chiNhanh = fetchByMa(ma);
			if (chiNhanh != null && chiNhanh.getChiNhanhId() != chiNhanhId) {
				throw new TrungMaException();
			}
		}
	}

	public ChiNhanh fetchByMa(String ma) throws SystemException {
		return chiNhanhPersistence.fetchByMa(ma);
	}

	public List<ChiNhanh> findByHoatDong(boolean hoatDong) throws SystemException {
		return chiNhanhPersistence.findByHoatDong(hoatDong);
	}

	public List<ChiNhanh> findBase(String ma, String ten, int hoatDong, int start, int end, OrderByComparator obc)
			throws SystemException {
		return chiNhanhFinder.findBase(ma, ten, hoatDong, start, end, obc);
	}

	public int countBase(String ma, String ten, int hoatDong) throws SystemException {
		return chiNhanhFinder.countBase(ma, ten, hoatDong);

	}
}