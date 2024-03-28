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

import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.mb.model.SoKheUoc;
import com.mb.model.impl.SoKheUocImpl;
import com.mb.service.base.SoKheUocLocalServiceBaseImpl;

/**
 * The implementation of the so khe uoc local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.mb.service.SoKheUocLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SoKheUocLocalServiceBaseImpl
 */
public class SoKheUocLocalServiceImpl extends SoKheUocLocalServiceBaseImpl {
	public SoKheUoc tangSoKheUoc(String cauTruc, ServiceContext serviceContext) throws SystemException {
		SoKheUoc soKheUoc = null;
		try {
			soKheUoc = fetchByCauTruc(cauTruc);
		} catch (Exception e) {
		}
		if (soKheUoc != null) {
			soKheUoc.setSo(soKheUoc.getSo() + 1);
			return updateSoKheUoc(soKheUoc, serviceContext);
		}
		return null;

	}

	public SoKheUoc addSoKheUoc(SoKheUoc soKheUoc, ServiceContext serviceContext) throws SystemException {
		long soKheUocId = counterLocalService.increment(SoKheUoc.class.getName());
		soKheUoc.setSoKheUocId(soKheUocId);
		addSoKheUoc(soKheUoc);
		return soKheUoc;
	}

	public SoKheUoc updateSoKheUoc(SoKheUoc soKheUoc, ServiceContext serviceContext) throws SystemException {
		soKheUoc.setExpandoBridgeAttributes(serviceContext);
		updateSoKheUoc(soKheUoc);
		return soKheUoc;
	}

	public SoKheUoc fetchByCauTruc(String cauTruc) throws SystemException, PortalException {
		return soKheUocPersistence.fetchByCauTruc(cauTruc);
	}

	public List<SoKheUoc> findBase(String cauTruc, int start, int end, OrderByComparator obc) throws SystemException {
		return soKheUocFinder.findBase(cauTruc, start, end, obc);
	}

	public int countBase(String cauTruc) throws SystemException {
		return soKheUocFinder.countBase(cauTruc);
	}

}