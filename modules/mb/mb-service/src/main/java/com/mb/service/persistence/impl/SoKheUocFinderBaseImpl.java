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

import com.mb.model.SoKheUoc;
import com.mb.service.persistence.SoKheUocPersistence;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SoKheUocFinderBaseImpl extends BasePersistenceImpl<SoKheUoc> {

	public SoKheUocFinderBaseImpl() {
		setModelClass(SoKheUoc.class);
	}

	/**
	 * Returns the so khe uoc persistence.
	 *
	 * @return the so khe uoc persistence
	 */
	public SoKheUocPersistence getSoKheUocPersistence() {
		return soKheUocPersistence;
	}

	/**
	 * Sets the so khe uoc persistence.
	 *
	 * @param soKheUocPersistence the so khe uoc persistence
	 */
	public void setSoKheUocPersistence(
		SoKheUocPersistence soKheUocPersistence) {

		this.soKheUocPersistence = soKheUocPersistence;
	}

	@BeanReference(type = SoKheUocPersistence.class)
	protected SoKheUocPersistence soKheUocPersistence;

}