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

package com.mb.service.persistence;

import aQute.bnd.annotation.ProviderType;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public interface PhatVayFinder {

	public java.util.List<com.mb.model.PhatVay> getPhatVaySaoKe(
			String maCTV, int loaiPhatVay, java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.mb.model.PhatVay getPhatVayByNgayThuTruocLast()
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.mb.model.PhatVay> getPhatVayDeThuTienTruoc(
			String maCTV, java.util.Date ngayThuTienTu)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.mb.model.PhatVay> findCTV_NgayThuTien(
			String maCTV, java.util.Date ngayThuTien)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.mb.model.PhatVay> findBase(
			String soKU, String maCTV, String maKhachHang,
			java.util.Date createDateTu, java.util.Date createDateDen,
			java.util.Date ngayBatDauTu, java.util.Date ngayBatDauDen,
			java.util.Date ngayTatToanTu, java.util.Date ngayTatToanDen,
			String trangThai, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countBase(
			String soKU, String maCTV, String maKhachHang,
			java.util.Date createDateTu, java.util.Date createDateDen,
			java.util.Date ngayBatDauTu, java.util.Date ngayBatDauDen,
			java.util.Date ngayTatToanTu, java.util.Date ngayTatToanDen,
			String trangThai)
		throws com.liferay.portal.kernel.exception.SystemException;

}