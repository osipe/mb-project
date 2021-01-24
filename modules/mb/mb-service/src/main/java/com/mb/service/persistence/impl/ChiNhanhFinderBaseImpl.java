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

import com.mb.model.ChiNhanh;
import com.mb.service.persistence.ChiNhanhPersistence;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ChiNhanhFinderBaseImpl extends BasePersistenceImpl<ChiNhanh> {

	public ChiNhanhFinderBaseImpl() {
		setModelClass(ChiNhanh.class);
	}

	/**
	 * Returns the chi nhanh persistence.
	 *
	 * @return the chi nhanh persistence
	 */
	public ChiNhanhPersistence getChiNhanhPersistence() {
		return chiNhanhPersistence;
	}

	/**
	 * Sets the chi nhanh persistence.
	 *
	 * @param chiNhanhPersistence the chi nhanh persistence
	 */
	public void setChiNhanhPersistence(
		ChiNhanhPersistence chiNhanhPersistence) {

		this.chiNhanhPersistence = chiNhanhPersistence;
	}

	@BeanReference(type = ChiNhanhPersistence.class)
	protected ChiNhanhPersistence chiNhanhPersistence;

}