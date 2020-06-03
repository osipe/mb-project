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
 * Provides a wrapper for {@link TaiSanThueChapService}.
 *
 * @author Brian Wing Shun Chan
 * @see TaiSanThueChapService
 * @generated
 */
@ProviderType
public class TaiSanThueChapServiceWrapper
	implements TaiSanThueChapService, ServiceWrapper<TaiSanThueChapService> {

	public TaiSanThueChapServiceWrapper(
		TaiSanThueChapService taiSanThueChapService) {

		_taiSanThueChapService = taiSanThueChapService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _taiSanThueChapService.getOSGiServiceIdentifier();
	}

	@Override
	public TaiSanThueChapService getWrappedService() {
		return _taiSanThueChapService;
	}

	@Override
	public void setWrappedService(TaiSanThueChapService taiSanThueChapService) {
		_taiSanThueChapService = taiSanThueChapService;
	}

	private TaiSanThueChapService _taiSanThueChapService;

}