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

import com.mb.model.Phieu;
import com.mb.service.persistence.PhieuPersistence;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PhieuFinderBaseImpl extends BasePersistenceImpl<Phieu> {

	public PhieuFinderBaseImpl() {
		setModelClass(Phieu.class);
	}

	/**
	 * Returns the phieu persistence.
	 *
	 * @return the phieu persistence
	 */
	public PhieuPersistence getPhieuPersistence() {
		return phieuPersistence;
	}

	/**
	 * Sets the phieu persistence.
	 *
	 * @param phieuPersistence the phieu persistence
	 */
	public void setPhieuPersistence(PhieuPersistence phieuPersistence) {
		this.phieuPersistence = phieuPersistence;
	}

	@BeanReference(type = PhieuPersistence.class)
	protected PhieuPersistence phieuPersistence;

}