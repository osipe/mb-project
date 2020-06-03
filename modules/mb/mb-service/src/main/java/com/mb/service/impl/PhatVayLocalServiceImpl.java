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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.mb.exception.TrungSoKUException;
import com.mb.model.LichSuThuPhatChi;
import com.mb.model.PhatVay;
import com.mb.service.base.PhatVayLocalServiceBaseImpl;

/**
 * The implementation of the phat vay local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.mb.service.PhatVayLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PhatVayLocalServiceBaseImpl
 */
public class PhatVayLocalServiceImpl extends PhatVayLocalServiceBaseImpl {
	public PhatVay addOrUpdatePhatVay(PhatVay phatVay, ServiceContext serviceContext)
			throws SystemException, NoSuchUserException, TrungSoKUException {
		if (phatVay.getPhatVayId() > 0) {
			return updatePhatVay(phatVay, serviceContext);
		} else {
			return addPhatVay(phatVay, serviceContext);
		}
	}

	public PhatVay addPhatVay(PhatVay phatVay, ServiceContext serviceContext)
			throws SystemException, NoSuchUserException, TrungSoKUException {
		Date now = new Date();
		User user = userPersistence.findByPrimaryKey(serviceContext.getUserId());
		long phatVayId = counterLocalService.increment(PhatVay.class.getName());
		phatVay.setPhatVayId(phatVayId);
		phatVay.setGroupId(serviceContext.getScopeGroupId());
		phatVay.setCompanyId(user.getCompanyId());
		phatVay.setUserId(user.getUserId());
		phatVay.setUserName(user.getFullName());
		phatVay.setNgayTao(serviceContext.getCreateDate(now));
		phatVay.setModifiedDate(serviceContext.getModifiedDate(now));
		phatVay.setExpandoBridgeAttributes(serviceContext);
		validate(phatVay);
		addPhatVay(phatVay);
		addThongTinLienQuan(phatVay, serviceContext);
		return phatVay;
	}

	public PhatVay updatePhatVay(PhatVay phatVay, ServiceContext serviceContext)
			throws SystemException, NoSuchUserException, TrungSoKUException {
		phatVay.setExpandoBridgeAttributes(serviceContext);
		validate(phatVay);
		updatePhatVay(phatVay);
		return phatVay;
	}

	private void addThongTinLienQuan(PhatVay phatVay, ServiceContext serviceContext)
			throws SystemException, NoSuchUserException {
		LichSuThuPhatChi lichSuThuPhatChi = lichSuThuPhatChiLocalService.createLichSuThuPhatChi(0L);
		lichSuThuPhatChi.setCreateDate(phatVay.getCreateDate());
		lichSuThuPhatChi.setPhatVayId(phatVay.getPhatVayId());
		lichSuThuPhatChi.setMaCTV(phatVay.getMaCTV());
		lichSuThuPhatChi.setLoai(1);
		lichSuThuPhatChi.setSoTien(phatVay.getSoTienVay());
		lichSuThuPhatChi.setTongSoTienLaiTra(Double.valueOf(0));
		lichSuThuPhatChi.setTongSoTienVonTra(Double.valueOf(0));
		lichSuThuPhatChi.setTrangThaiPhatVayHienTai(phatVay.getTrangThai());
		lichSuThuPhatChiLocalService.addLichSuThuPhatChi(lichSuThuPhatChi, serviceContext);
	}

	public void xoaToanBoThongTinPhatVay(long phatVayId) throws SystemException, PortalException {
		lichSuThuPhatChiLocalService.removeByPhatVayId(phatVayId);
		taiSanThueChapLocalService.removeByPhatVayId(phatVayId);
		deletePhatVay(phatVayId);
	}

	private void validate(PhatVay phatVay) throws SystemException, TrungSoKUException {
		validateTrungSoKU(phatVay.getPhatVayId(), phatVay.getSoKU());
	}

	private void validateTrungSoKU(long phatVayId, String soKU) throws SystemException, TrungSoKUException {
		if (Validator.isNotNull(soKU)) {
			PhatVay phatVay = fetchBySoKU(soKU);
			if (phatVay != null && phatVay.getPhatVayId() != phatVayId) {
				throw new TrungSoKUException();
			}
		}
	}

	public PhatVay fetchBySoKU(String soKU) {
		return phatVayPersistence.fetchBySoKU(soKU);
	}

	public void addOrUpdateThongTinLienQuan(PhatVay phatVay, ServiceContext serviceContext)
			throws SystemException, NoSuchUserException {
		taiSanThueChapLocalService.addOrTaiSanThueChap(phatVay, serviceContext);
	}

	public List<PhatVay> findByMaCTV(String maCTV) throws SystemException {
		return phatVayPersistence.findByMaCTV(maCTV);
	}

	public List<PhatVay> findBase(String soKU, String maCTV, String maKhachHang,Date createDateTu, Date createDateDen,Date ngayBatDauTu, Date ngayBatDauDen,
			Date ngayTatToanTu, Date ngayTatToanDen, String trangThai, int start, int end, OrderByComparator obc) {
		return phatVayFinder.findBase(soKU, maCTV, maKhachHang,createDateTu,createDateDen, ngayBatDauTu, ngayBatDauDen, ngayTatToanTu,
				ngayTatToanDen, trangThai, start, end, obc);
	}

	public List<PhatVay> findCTV_NgayThuTien(String maCTV, Date ngayThuTien) {
		return phatVayFinder.findCTV_NgayThuTien(maCTV, ngayThuTien);
	}

	public List<PhatVay> getPhatVayDeThuTienTruoc(String maCTV, Date ngayThuTienTu) {
		return phatVayFinder.getPhatVayDeThuTienTruoc(maCTV, ngayThuTienTu);
	}

	public int countBase(String soKU, String maCTV, String maKhachHang,Date createDateTu, Date createDateDen, Date ngayBatDauTu, Date ngayBatDauDen,
			Date ngayTatToanTu, Date ngayTatToanDen, String trangThai) throws SystemException {
		return phatVayFinder.countBase(soKU, maCTV, maKhachHang,createDateTu,createDateDen, ngayBatDauTu, ngayBatDauDen, ngayTatToanTu,
				ngayTatToanDen, trangThai);
	}
	public List<PhatVay> getPhatVaySaoKe(String maCTV, Date createDate) throws SystemException {
		return phatVayFinder.getPhatVaySaoKe(maCTV,createDate);
	}

}