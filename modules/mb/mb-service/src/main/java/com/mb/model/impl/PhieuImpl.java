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

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.util.Validator;
import com.mb.model.CongTacVien;
import com.mb.model.MaSoThuChi;
import com.mb.service.CongTacVienLocalServiceUtil;
import com.mb.service.MaSoThuChiLocalServiceUtil;

import aQute.bnd.annotation.ProviderType;

/**
 * The extended model implementation for the Phieu service. Represents a row in
 * the &quot;ketoan_phieu&quot; database table, with each column mapped to a
 * property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class.
 * Whenever methods are added, rerun ServiceBuilder to copy their definitions
 * into the <code>com.mb.model.Phieu<code> interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
@ProviderType
public class PhieuImpl extends PhieuBaseImpl {
	private JSONArray dsPhieuTaiKhoanJSONArray;
	private CongTacVien ctv;
	private MaSoThuChi maSoThuChi;

	public PhieuImpl() {
	}

	public MaSoThuChi getMaSoThuChi() {
		if (Validator.isNotNull(getMaMSThuChi()) && getLoai() > 0) {
			try {
				maSoThuChi = MaSoThuChiLocalServiceUtil.fetchByMa_Loai_HoatDong(getMaMSThuChi(), getLoai(), true);
			} catch (Exception e) {

			}
		}
		return maSoThuChi;
	}

	public CongTacVien getCtv() {
		if (Validator.isNotNull(getMaCTV())) {
			try {
				ctv = CongTacVienLocalServiceUtil.fetchByMa(getMaCTV());
			} catch (Exception e) {

			}
		}
		return ctv;
	}

	public JSONArray getDsPhieuTaiKhoanJSONArray() {
		return dsPhieuTaiKhoanJSONArray;
	}

	public void setDsPhieuTaiKhoanJSONArray(JSONArray dsPhieuTaiKhoanJSONArray) {
		this.dsPhieuTaiKhoanJSONArray = dsPhieuTaiKhoanJSONArray;
	}

}