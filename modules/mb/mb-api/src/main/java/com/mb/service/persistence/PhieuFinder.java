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
public interface PhieuFinder {

	public java.util.List<com.mb.model.Phieu> findBase(
			String maCTV, String maMSThuChi, String soPhieu,
			java.util.Date ngayChungTuTu, java.util.Date ngayChungTuDen,
			int loai, int hoatDong, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countBase(
			String maCTV, String maMSThuChi, String soPhieu,
			java.util.Date ngayChungTuTu, java.util.Date ngayChungTuDen,
			int loai, int hoatDong)
		throws com.liferay.portal.kernel.exception.SystemException;

}