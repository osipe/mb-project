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

import com.mb.model.TaiSanThueChap;
import com.mb.service.persistence.TaiSanThueChapPersistence;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TaiSanThueChapFinderBaseImpl
	extends BasePersistenceImpl<TaiSanThueChap> {

	public TaiSanThueChapFinderBaseImpl() {
		setModelClass(TaiSanThueChap.class);
	}

	/**
	 * Returns the tai san thue chap persistence.
	 *
	 * @return the tai san thue chap persistence
	 */
	public TaiSanThueChapPersistence getTaiSanThueChapPersistence() {
		return taiSanThueChapPersistence;
	}

	/**
	 * Sets the tai san thue chap persistence.
	 *
	 * @param taiSanThueChapPersistence the tai san thue chap persistence
	 */
	public void setTaiSanThueChapPersistence(
		TaiSanThueChapPersistence taiSanThueChapPersistence) {

		this.taiSanThueChapPersistence = taiSanThueChapPersistence;
	}

	@BeanReference(type = TaiSanThueChapPersistence.class)
	protected TaiSanThueChapPersistence taiSanThueChapPersistence;

}