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
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.mb.model.DsPhieuTaiKhoan;
import com.mb.model.Phieu;
import com.mb.service.DsPhieuTaiKhoanLocalServiceUtil;
import com.mb.service.base.DsPhieuTaiKhoanLocalServiceBaseImpl;

/**
 * The implementation of the ds phieu tai khoan local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.mb.service.DsPhieuTaiKhoanLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DsPhieuTaiKhoanLocalServiceBaseImpl
 */
public class DsPhieuTaiKhoanLocalServiceImpl extends DsPhieuTaiKhoanLocalServiceBaseImpl {
	public void addOrUpdateDsPhieuTaiKhoan(Phieu phieu, ServiceContext serviceContext)
			throws SystemException, NoSuchUserException {
		if (phieu.getPhieuId() > 0 && phieu.getDsPhieuTaiKhoanJSONArray() != null
				&& phieu.getDsPhieuTaiKhoanJSONArray().length() > 0) {
			removeByPhieuId(phieu.getPhieuId());
			for (int i = 0; i < phieu.getDsPhieuTaiKhoanJSONArray().length(); i++) {
				JSONObject item = phieu.getDsPhieuTaiKhoanJSONArray().getJSONObject(i);
				DsPhieuTaiKhoan dsPhieuTaiKhoan = DsPhieuTaiKhoanLocalServiceUtil.createDsPhieuTaiKhoan(0L);
				dsPhieuTaiKhoan.setPhieuId(phieu.getPhieuId());
				dsPhieuTaiKhoan.setNgayChungTu(phieu.getNgayChungTu());
				dsPhieuTaiKhoan.setTenCTV(phieu.getHoTenCTV());
				dsPhieuTaiKhoan.setMaCTV(phieu.getMaCTV());
				dsPhieuTaiKhoan.setTaiKhoanDoiUngId(item.getLong("taiKhoanDoiUngId"));
				dsPhieuTaiKhoan.setMaTheoDoi(item.getString("maTheoDoi"));
				dsPhieuTaiKhoan.setDienGiaiTheoDoi(item.getString("dienGiaiTheoDoi"));
				if (Validator.isNotNull(item.getString("soTienTheoDoi"))) {
					dsPhieuTaiKhoan
							.setSoTien(GetterUtil.getDouble(item.getString("soTienTheoDoi").replaceAll(",", "")));
				}
				dsPhieuTaiKhoan.setHoatDong(true);
				addDsPhieuTaiKhoan(dsPhieuTaiKhoan, serviceContext);
			}
		} else if (phieu.getPhieuId() > 0) {
			removeByPhieuId(phieu.getPhieuId());
		}

	}

	public DsPhieuTaiKhoan addDsPhieuTaiKhoan(DsPhieuTaiKhoan dsPhieuTaiKhoan, ServiceContext serviceContext)
			throws SystemException, NoSuchUserException {
		Date now = new Date();
		User user = userPersistence.findByPrimaryKey(serviceContext.getUserId());
		long dsPhieuTaiKhoanId = counterLocalService.increment(DsPhieuTaiKhoan.class.getName());
		dsPhieuTaiKhoan.setDsPhieuTaiKhoanId(dsPhieuTaiKhoanId);
		dsPhieuTaiKhoan.setGroupId(serviceContext.getScopeGroupId());
		dsPhieuTaiKhoan.setCompanyId(user.getCompanyId());
		dsPhieuTaiKhoan.setUserId(user.getUserId());
		dsPhieuTaiKhoan.setUserName(user.getFullName());
		dsPhieuTaiKhoan.setCreateDate(serviceContext.getCreateDate(now));
		dsPhieuTaiKhoan.setModifiedDate(serviceContext.getModifiedDate(now));
		dsPhieuTaiKhoan.setExpandoBridgeAttributes(serviceContext);
		addDsPhieuTaiKhoan(dsPhieuTaiKhoan);
		return dsPhieuTaiKhoan;
	}

	public DsPhieuTaiKhoan updateDsPhieuTaiKhoan(DsPhieuTaiKhoan dsPhieuTaiKhoan, ServiceContext serviceContext)
			throws SystemException {
		dsPhieuTaiKhoan.setExpandoBridgeAttributes(serviceContext);
		updateDsPhieuTaiKhoan(dsPhieuTaiKhoan);
		return dsPhieuTaiKhoan;
	}

	public List<DsPhieuTaiKhoan> findByTaiKhoanDoiUngId_HoatDong(long taiKhoanDoiUngId, boolean hoatDong)
			throws SystemException {
		return dsPhieuTaiKhoanPersistence.findByTaiKhoanDoiUngId_HoatDong(taiKhoanDoiUngId, hoatDong);
	}

	public List<DsPhieuTaiKhoan> findByPhieuId(long phieuId) throws SystemException {
		return dsPhieuTaiKhoanPersistence.findByPhieuId(phieuId);
	}

	public void removeByPhieuId(long phieuId) throws SystemException {
		dsPhieuTaiKhoanPersistence.removeByPhieuId(phieuId);
	}

	public List<DsPhieuTaiKhoan> getDSThuChiByTaiKhoanNgayChungTu(long taiKhoanDoiUngId, String maCTV,
			Date ngayChungTuTu, Date ngayChungTuDen, int hoatDong, int start, int end, OrderByComparator obc)
			throws SystemException {
		return dsPhieuTaiKhoanFinder.getDSThuChiByTaiKhoanNgayChungTu(taiKhoanDoiUngId, maCTV, ngayChungTuTu,
				ngayChungTuDen, hoatDong, start, end, obc);
	}

}