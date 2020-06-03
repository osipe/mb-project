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

package com.mb.service.persistence.impl;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

import com.mb.model.LichSuThuPhatChi;
import com.mb.service.persistence.LichSuThuPhatChiPersistence;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LichSuThuPhatChiFinderBaseImpl
	extends BasePersistenceImpl<LichSuThuPhatChi> {

	public LichSuThuPhatChiFinderBaseImpl() {
		setModelClass(LichSuThuPhatChi.class);
	}

	/**
	 * Returns the lich su thu phat chi persistence.
	 *
	 * @return the lich su thu phat chi persistence
	 */
	public LichSuThuPhatChiPersistence getLichSuThuPhatChiPersistence() {
		return lichSuThuPhatChiPersistence;
	}

	/**
	 * Sets the lich su thu phat chi persistence.
	 *
	 * @param lichSuThuPhatChiPersistence the lich su thu phat chi persistence
	 */
	public void setLichSuThuPhatChiPersistence(
		LichSuThuPhatChiPersistence lichSuThuPhatChiPersistence) {

		this.lichSuThuPhatChiPersistence = lichSuThuPhatChiPersistence;
	}

	@BeanReference(type = LichSuThuPhatChiPersistence.class)
	protected LichSuThuPhatChiPersistence lichSuThuPhatChiPersistence;

}