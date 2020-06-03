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
import com.mb.model.KhachHang;
import com.mb.service.base.KhachHangLocalServiceBaseImpl;

/**
 * The implementation of the khach hang local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.mb.service.KhachHangLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KhachHangLocalServiceBaseImpl
 */
public class KhachHangLocalServiceImpl extends KhachHangLocalServiceBaseImpl {

	public KhachHang addOrUpdateKhachHang(KhachHang KhachHang, ServiceContext serviceContext)
			throws SystemException, PortalException, TrungSoCMNDException, TrungMaException {
		if (KhachHang.getKhachHangId() > 0) {
			return updateKhachHang(KhachHang, serviceContext);
		} else {
			return addKhachHang(KhachHang, serviceContext);
		}
	}

	public KhachHang addKhachHang(KhachHang KhachHang, ServiceContext serviceContext)
			throws SystemException, PortalException, TrungSoCMNDException, TrungMaException {
		Date now = new Date();
		User user = userPersistence.findByPrimaryKey(serviceContext.getUserId());
		long khachHangId = counterLocalService.increment(KhachHang.class.getName());
		KhachHang.setKhachHangId(khachHangId);
		validate(KhachHang);
		KhachHang.setGroupId(serviceContext.getScopeGroupId());
		KhachHang.setCompanyId(user.getCompanyId());
		KhachHang.setUserId(user.getUserId());
		KhachHang.setUserName(user.getFullName());
		KhachHang.setCreateDate(serviceContext.getCreateDate(now));
		KhachHang.setModifiedDate(serviceContext.getModifiedDate(now));
		KhachHang.setExpandoBridgeAttributes(serviceContext);
		addKhachHang(KhachHang);
		return KhachHang;
	}

	public KhachHang updateKhachHang(KhachHang KhachHang, ServiceContext serviceContext)
			throws SystemException, PortalException, TrungSoCMNDException, TrungMaException {
		validate(KhachHang);
		KhachHang.setExpandoBridgeAttributes(serviceContext);
		updateKhachHang(KhachHang);
		return KhachHang;
	}

	private void validate(KhachHang KhachHang)
			throws SystemException, PortalException, TrungSoCMNDException, TrungMaException {
		validateTrungMa(KhachHang.getKhachHangId(), KhachHang.getMa());
		validateTrungSoCMND(KhachHang.getKhachHangId(), KhachHang.getSoCMND());
	}

	private void validateTrungMa(long khachHangId, String ma)
			throws SystemException, PortalException, TrungMaException {
		if (Validator.isNotNull(ma)) {
			KhachHang KhachHang = fetchByMa(ma);
			if (KhachHang != null && KhachHang.getKhachHangId() != khachHangId) {
				throw new TrungMaException();
			}
		}
	}

	private void validateTrungSoCMND(long khachHangId, String soCMND)
			throws SystemException, PortalException, TrungSoCMNDException {
		if (Validator.isNotNull(soCMND)) {
			KhachHang KhachHang = fetchBySoCMND(soCMND);
			if (KhachHang != null && KhachHang.getKhachHangId() != khachHangId) {
				throw new TrungSoCMNDException();
			}
		}
	}

	public List<KhachHang> findByMaCTV(String maCTV) throws SystemException {
		return khachHangPersistence.findByMaCTV(maCTV);
	}

	public KhachHang fetchByMa(String ma) throws SystemException {
		return khachHangPersistence.fetchByMa(ma);
	}

	public KhachHang fetchBySoCMND(String soCMND) throws SystemException {
		return khachHangPersistence.fetchBySoCMND(soCMND);
	}

	public List<KhachHang> findBase(String ma, String maCTV, String hoTen, String soCMND, String diaChi,
			int hoatDong, int start, int end, OrderByComparator obc) throws SystemException {
		return khachHangFinder.findBase( ma, maCTV, hoTen, soCMND, diaChi, hoatDong, start, end, obc);
	}

	public int countBase(String ma, String maCTV, String hoTen, String soCMND, String diaChi,
			int hoatDong) throws SystemException {
		return khachHangFinder.countBase( ma, maCTV, hoTen, soCMND, diaChi, hoatDong);

	}
}