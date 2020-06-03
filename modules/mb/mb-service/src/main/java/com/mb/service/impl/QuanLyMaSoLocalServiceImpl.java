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

package com.mb.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.mb.model.QuanLyMaSo;
import com.mb.service.base.QuanLyMaSoLocalServiceBaseImpl;

/**
 * The implementation of the quan ly ma so local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.mb.service.QuanLyMaSoLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuanLyMaSoLocalServiceBaseImpl
 */
public class QuanLyMaSoLocalServiceImpl extends QuanLyMaSoLocalServiceBaseImpl {
	public QuanLyMaSo tangQuanLyMaSo(String key, ServiceContext serviceContext) throws SystemException {
		QuanLyMaSo quanLyMaSo = null;
		try {
			quanLyMaSo = fetchByKey(key);
		} catch (Exception e) {
		}
		if (quanLyMaSo != null) {
			quanLyMaSo.setSo(quanLyMaSo.getSo() + 1);
			return updateQuanLyMaSo(quanLyMaSo, serviceContext);
		}
		return null;

	}

	public QuanLyMaSo addQuanLyMaSo(QuanLyMaSo quanLyMaSo, ServiceContext serviceContext) throws SystemException {
		long quanLyMaSoId = counterLocalService.increment(QuanLyMaSo.class.getName());
		quanLyMaSo.setQuanLyMaSoId(quanLyMaSoId);
		addQuanLyMaSo(quanLyMaSo);
		return quanLyMaSo;
	}

	public QuanLyMaSo updateQuanLyMaSo(QuanLyMaSo quanLyMaSo, ServiceContext serviceContext) throws SystemException {
		quanLyMaSo.setExpandoBridgeAttributes(serviceContext);
		updateQuanLyMaSo(quanLyMaSo);
		return quanLyMaSo;
	}

	public QuanLyMaSo fetchByKey(String key) throws SystemException, PortalException {
		return quanLyMaSoPersistence.fetchByKey(key);
	}
}