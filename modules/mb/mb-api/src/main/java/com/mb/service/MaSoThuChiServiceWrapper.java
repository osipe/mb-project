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

package com.mb.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MaSoThuChiService}.
 *
 * @author Brian Wing Shun Chan
 * @see MaSoThuChiService
 * @generated
 */
@ProviderType
public class MaSoThuChiServiceWrapper
	implements MaSoThuChiService, ServiceWrapper<MaSoThuChiService> {

	public MaSoThuChiServiceWrapper(MaSoThuChiService maSoThuChiService) {
		_maSoThuChiService = maSoThuChiService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _maSoThuChiService.getOSGiServiceIdentifier();
	}

	@Override
	public MaSoThuChiService getWrappedService() {
		return _maSoThuChiService;
	}

	@Override
	public void setWrappedService(MaSoThuChiService maSoThuChiService) {
		_maSoThuChiService = maSoThuChiService;
	}

	private MaSoThuChiService _maSoThuChiService;

}