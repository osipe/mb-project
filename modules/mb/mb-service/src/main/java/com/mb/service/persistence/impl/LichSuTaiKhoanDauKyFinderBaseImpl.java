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

import com.mb.model.LichSuTaiKhoanDauKy;
import com.mb.service.persistence.LichSuTaiKhoanDauKyPersistence;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LichSuTaiKhoanDauKyFinderBaseImpl
	extends BasePersistenceImpl<LichSuTaiKhoanDauKy> {

	public LichSuTaiKhoanDauKyFinderBaseImpl() {
		setModelClass(LichSuTaiKhoanDauKy.class);
	}

	/**
	 * Returns the lich su tai khoan dau ky persistence.
	 *
	 * @return the lich su tai khoan dau ky persistence
	 */
	public LichSuTaiKhoanDauKyPersistence getLichSuTaiKhoanDauKyPersistence() {
		return lichSuTaiKhoanDauKyPersistence;
	}

	/**
	 * Sets the lich su tai khoan dau ky persistence.
	 *
	 * @param lichSuTaiKhoanDauKyPersistence the lich su tai khoan dau ky persistence
	 */
	public void setLichSuTaiKhoanDauKyPersistence(
		LichSuTaiKhoanDauKyPersistence lichSuTaiKhoanDauKyPersistence) {

		this.lichSuTaiKhoanDauKyPersistence = lichSuTaiKhoanDauKyPersistence;
	}

	@BeanReference(type = LichSuTaiKhoanDauKyPersistence.class)
	protected LichSuTaiKhoanDauKyPersistence lichSuTaiKhoanDauKyPersistence;

}