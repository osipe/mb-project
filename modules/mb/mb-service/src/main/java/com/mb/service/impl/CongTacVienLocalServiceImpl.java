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
import com.mb.model.CongTacVien;
import com.mb.service.base.CongTacVienLocalServiceBaseImpl;

/**
 * The implementation of the cong tac vien local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.mb.service.CongTacVienLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CongTacVienLocalServiceBaseImpl
 */
public class CongTacVienLocalServiceImpl
	extends CongTacVienLocalServiceBaseImpl {
	public CongTacVien addOrUpdateCongTacVien(CongTacVien congTacVien, ServiceContext serviceContext)
			throws SystemException, PortalException, TrungSoCMNDException, TrungMaException {
		if (congTacVien.getCongTacVienId() > 0) {
			return updateCongTacVien(congTacVien, serviceContext);
		} else {
			return addCongTacVien(congTacVien, serviceContext);
		}
	}

	public CongTacVien addCongTacVien(CongTacVien congTacVien, ServiceContext serviceContext)
			throws SystemException, PortalException, TrungSoCMNDException, TrungMaException {
		Date now = new Date();
		User user = userPersistence.findByPrimaryKey(serviceContext.getUserId());
		long congTacVienId = counterLocalService.increment(CongTacVien.class.getName());
		congTacVien.setCongTacVienId(congTacVienId);
		validate(congTacVien);
		congTacVien.setGroupId(serviceContext.getScopeGroupId());
		congTacVien.setCompanyId(user.getCompanyId());
		congTacVien.setUserId(user.getUserId());
		congTacVien.setUserName(user.getFullName());
		congTacVien.setCreateDate(serviceContext.getCreateDate(now));
		congTacVien.setModifiedDate(serviceContext.getModifiedDate(now));
		congTacVien.setExpandoBridgeAttributes(serviceContext);
		addCongTacVien(congTacVien);
		return congTacVien;
	}

	public CongTacVien updateCongTacVien(CongTacVien congTacVien, ServiceContext serviceContext)
			throws SystemException, PortalException, TrungSoCMNDException, TrungMaException {
		validate(congTacVien);
		congTacVien.setExpandoBridgeAttributes(serviceContext);
		updateCongTacVien(congTacVien);
		return congTacVien;
	}

	private void validate(CongTacVien congTacVien)
			throws SystemException, PortalException, TrungSoCMNDException, TrungMaException {
		validateTrungMa(congTacVien.getCongTacVienId(), congTacVien.getMa());
		validateTrungSoCMND(congTacVien.getCongTacVienId(), congTacVien.getSoCMND());
	}

	private void validateTrungMa(long congTacVienId, String ma)
			throws SystemException, PortalException, TrungMaException {
		if (Validator.isNotNull(ma)) {
			CongTacVien congTacVien = fetchByMa(ma);
			if (congTacVien != null && congTacVien.getCongTacVienId() != congTacVienId) {
				throw new TrungMaException();
			}
		}
	}

	private void validateTrungSoCMND(long congTacVienId, String soCMND)
			throws SystemException, PortalException, TrungSoCMNDException {
		if (Validator.isNotNull(soCMND)) {
			CongTacVien congTacVien = fetchBySoCMND(soCMND);
			if (congTacVien != null && congTacVien.getCongTacVienId() != congTacVienId) {
				throw new TrungSoCMNDException();
			}
		}
	}

	public CongTacVien fetchByMa(String ma) throws SystemException {
		return congTacVienPersistence.fetchByMa(ma);
	}

	public CongTacVien fetchBySoCMND(String soCMND) throws SystemException {
		return congTacVienPersistence.fetchBySoCMND(soCMND);
	}

	public List<CongTacVien> findBase(String ma, String hoTen, String soCMND, String diaChi,
			int hoatDong, int start, int end, OrderByComparator obc) throws SystemException {
		return congTacVienFinder.findBase( ma, hoTen, soCMND, diaChi, hoatDong, start, end, obc);
	}

	public int countBase(String ma, String hoTen, String soCMND, String diaChi, int hoatDong)
			throws SystemException {
		return congTacVienFinder.countBase( ma, hoTen, soCMND, diaChi, hoatDong);

	}
	public List<CongTacVien> getCTVSaoKe(String maCTV,Date ngayTaoTu) throws SystemException {
		return congTacVienFinder.getCTVSaoKe(maCTV,ngayTaoTu);
	}
	public List<CongTacVien> getCTVPhatVayNgay(Date ngayTaoTu,Date ngayTaoDen) throws SystemException {
		return congTacVienFinder.getCTVPhatVayNgay(ngayTaoTu, ngayTaoDen);
	}
}