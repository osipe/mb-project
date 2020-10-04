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

import com.mb.model.CauHinhThuTienTruoc;
import com.mb.service.persistence.CauHinhThuTienTruocPersistence;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CauHinhThuTienTruocFinderBaseImpl
	extends BasePersistenceImpl<CauHinhThuTienTruoc> {

	public CauHinhThuTienTruocFinderBaseImpl() {
		setModelClass(CauHinhThuTienTruoc.class);
	}

	/**
	 * Returns the cau hinh thu tien truoc persistence.
	 *
	 * @return the cau hinh thu tien truoc persistence
	 */
	public CauHinhThuTienTruocPersistence getCauHinhThuTienTruocPersistence() {
		return cauHinhThuTienTruocPersistence;
	}

	/**
	 * Sets the cau hinh thu tien truoc persistence.
	 *
	 * @param cauHinhThuTienTruocPersistence the cau hinh thu tien truoc persistence
	 */
	public void setCauHinhThuTienTruocPersistence(
		CauHinhThuTienTruocPersistence cauHinhThuTienTruocPersistence) {

		this.cauHinhThuTienTruocPersistence = cauHinhThuTienTruocPersistence;
	}

	@BeanReference(type = CauHinhThuTienTruocPersistence.class)
	protected CauHinhThuTienTruocPersistence cauHinhThuTienTruocPersistence;

}