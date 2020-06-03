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
 * Provides a wrapper for {@link CongTacVienService}.
 *
 * @author Brian Wing Shun Chan
 * @see CongTacVienService
 * @generated
 */
@ProviderType
public class CongTacVienServiceWrapper
	implements CongTacVienService, ServiceWrapper<CongTacVienService> {

	public CongTacVienServiceWrapper(CongTacVienService congTacVienService) {
		_congTacVienService = congTacVienService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _congTacVienService.getOSGiServiceIdentifier();
	}

	@Override
	public CongTacVienService getWrappedService() {
		return _congTacVienService;
	}

	@Override
	public void setWrappedService(CongTacVienService congTacVienService) {
		_congTacVienService = congTacVienService;
	}

	private CongTacVienService _congTacVienService;

}