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

import com.mb.model.Phieu;
import com.mb.model.TaiKhoanDoiUng;
import com.mb.service.PhieuLocalServiceUtil;
import com.mb.service.TaiKhoanDoiUngLocalServiceUtil;

import aQute.bnd.annotation.ProviderType;

/**
 * The extended model implementation for the DsPhieuTaiKhoan service. Represents
 * a row in the &quot;ketoan_dsphieutaikhoan&quot; database table, with each
 * column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class.
 * Whenever methods are added, rerun ServiceBuilder to copy their definitions
 * into the <code>com.mb.model.DsPhieuTaiKhoan<code> interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
@ProviderType
public class DsPhieuTaiKhoanImpl extends DsPhieuTaiKhoanBaseImpl {
	private TaiKhoanDoiUng taiKhoanDoiUng;
	private Phieu phieu;

	public DsPhieuTaiKhoanImpl() {
	}

	public Phieu getPhieu() {
		if (getPhieuId() > 0) {
			try {
				phieu = PhieuLocalServiceUtil.fetchPhieu(getPhieuId());
			} catch (Exception e) {
			}
		}
		return phieu;
	}

	public TaiKhoanDoiUng getTaiKhoanDoiUng() {
		if (getTaiKhoanDoiUngId() > 0) {
			try {
				taiKhoanDoiUng = TaiKhoanDoiUngLocalServiceUtil.fetchTaiKhoanDoiUng(getTaiKhoanDoiUngId());
			} catch (Exception e) {
			}
		}
		return taiKhoanDoiUng;
	}

}