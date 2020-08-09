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
public interface LichSuThuPhatChiFinder {

	public Object[] getTongLichSuTraTien_CTV_TAINGAY(
			String maCTV, java.util.Date ngay, java.util.Date ngayXuLy)
		throws com.liferay.portal.kernel.exception.SystemException;

	public Double getSoTienVay_CTV_TAINGAY(String maCTV, java.util.Date ngay)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.mb.model.LichSuThuPhatChi>
			findByCTV_Loai_Createdate_NgayXuLy(
				String maCTV, int loai, java.util.Date ngayTaoTu,
				java.util.Date ngayTaoDen, java.util.Date ngayXuLyTu,
				java.util.Date ngayXuLyDen, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<Object[]> getLichSuThuPhatChi_MaCTV_Createdate(
			String maCTV, java.util.Date createdate)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.mb.model.LichSuThuPhatChi>
			findByPhatVay_Createdate_Loai(
				long phatVayId, java.util.Date ngayTaoTu,
				java.util.Date ngayTaoDen, String loai)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.mb.model.LichSuThuPhatChi>
			findByCTV_Loai_Createdate(
				String maCTV, int loai, java.util.Date ngayTaoTu,
				java.util.Date ngayTaoDen, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException;

}