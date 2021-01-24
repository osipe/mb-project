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

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.mb.exception.TrungMaException;
import com.mb.exception.TrungSoCMNDException;
import com.mb.model.CauHinhThuTienTruoc;
import com.mb.service.base.CauHinhThuTienTruocLocalServiceBaseImpl;

/**
 * The implementation of the cau hinh thu tien truoc local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.mb.service.CauHinhThuTienTruocLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CauHinhThuTienTruocLocalServiceBaseImpl
 */
public class CauHinhThuTienTruocLocalServiceImpl extends CauHinhThuTienTruocLocalServiceBaseImpl {

	public CauHinhThuTienTruoc addOrUpdate(CauHinhThuTienTruoc cauHinhThuTienTruoc, ServiceContext serviceContext)
			throws SystemException, PortalException, TrungSoCMNDException, TrungMaException {
		if (cauHinhThuTienTruoc.getCauHinhThuTienTruocId() > 0) {
			return updateCauHinhThuTienTruoc(cauHinhThuTienTruoc, serviceContext);
		} else {
			return addCauHinhThuTienTruoc(cauHinhThuTienTruoc, serviceContext);
		}
	}

	public CauHinhThuTienTruoc addCauHinhThuTienTruoc(CauHinhThuTienTruoc cauHinhThuTienTruoc,
			ServiceContext serviceContext)
			throws SystemException, PortalException, TrungSoCMNDException, TrungMaException {
		Date now = new Date();
		User user = userPersistence.findByPrimaryKey(serviceContext.getUserId());
		long khachHangId = counterLocalService.increment(CauHinhThuTienTruoc.class.getName());
		cauHinhThuTienTruoc.setCauHinhThuTienTruocId(khachHangId);
		cauHinhThuTienTruoc.setGroupId(serviceContext.getScopeGroupId());
		cauHinhThuTienTruoc.setCompanyId(user.getCompanyId());
		cauHinhThuTienTruoc.setUserId(user.getUserId());
		cauHinhThuTienTruoc.setUserName(user.getFullName());
		cauHinhThuTienTruoc.setCreateDate(serviceContext.getCreateDate(now));
		cauHinhThuTienTruoc.setModifiedDate(serviceContext.getModifiedDate(now));
		cauHinhThuTienTruoc.setExpandoBridgeAttributes(serviceContext);
		addCauHinhThuTienTruoc(cauHinhThuTienTruoc);
		return cauHinhThuTienTruoc;
	}

	public CauHinhThuTienTruoc updateCauHinhThuTienTruoc(CauHinhThuTienTruoc cauHinhThuTienTruoc,
			ServiceContext serviceContext)
			throws SystemException, PortalException, TrungSoCMNDException, TrungMaException {
		cauHinhThuTienTruoc.setExpandoBridgeAttributes(serviceContext);
		updateCauHinhThuTienTruoc(cauHinhThuTienTruoc);
		return cauHinhThuTienTruoc;
	}

	public CauHinhThuTienTruoc fetchByNam(int nam) throws SystemException {
		return cauHinhThuTienTruocPersistence.fetchByNam(nam);
	}
	
	public List<CauHinhThuTienTruoc> findAll() throws SystemException {
		return cauHinhThuTienTruocPersistence.findAll();
	}
	
	public List<CauHinhThuTienTruoc> findBase(int nam, int hoatDong, int start, int end, OrderByComparator obc)
			throws SystemException {
		return cauHinhThuTienTruocFinder.findBase(nam, hoatDong, start, end, obc);
	}

	public int countBase(int nam, int hoatDong) throws SystemException {
		return cauHinhThuTienTruocFinder.countBase(nam, hoatDong);
	}
}