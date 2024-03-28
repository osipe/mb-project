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
public interface LichSuTaiKhoanDauKyFinder {

	public com.mb.model.LichSuTaiKhoanDauKy sumByNamThang(
			long taiKhoanDoiUngChaId, int loaiTaiKhoan, int nam, int thang)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.mb.model.LichSuTaiKhoanDauKy> findBase(
			int nam, int thang, long taiKhoanDoiUngId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countBase(int nam, int thang, long taiKhoanDoiUngId)
		throws com.liferay.portal.kernel.exception.SystemException;

}