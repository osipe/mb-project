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

package com.mb.model.impl;

import com.liferay.portal.kernel.util.Validator;
import com.mb.model.CongTacVien;
import com.mb.service.CongTacVienLocalServiceUtil;

import aQute.bnd.annotation.ProviderType;

/**
 * The extended model implementation for the KhachHang service. Represents a row
 * in the &quot;dm_khachhang&quot; database table, with each column mapped to a
 * property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class.
 * Whenever methods are added, rerun ServiceBuilder to copy their definitions
 * into the <code>com.mb.model.KhachHang<code> interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
@ProviderType
public class KhachHangImpl extends KhachHangBaseImpl {
	private CongTacVien congTacVien;

	public KhachHangImpl() {
	}

	public CongTacVien getCongTacVien() {
		if (Validator.isNotNull(getMaCTV())) {
			try {
				congTacVien = CongTacVienLocalServiceUtil.fetchByMa(getMaCTV());
			} catch (Exception e) {
			}
		}
		return congTacVien;
	}

	public void setCongTacVien(CongTacVien congTacVien) {
		this.congTacVien = congTacVien;
	}
}