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
import com.liferay.portal.kernel.util.GetterUtil;
import com.mb.model.CongTacVien;
import com.mb.model.KhachHang;
import com.mb.service.CongTacVienLocalServiceUtil;
import com.mb.service.KhachHangLocalServiceUtil;

import aQute.bnd.annotation.ProviderType;

/**
 * The extended model implementation for the PhatVay service. Represents a row
 * in the &quot;mb_phatvay&quot; database table, with each column mapped to a
 * property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class.
 * Whenever methods are added, rerun ServiceBuilder to copy their definitions
 * into the <code>com.mb.model.PhatVay<code> interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
@ProviderType
public class PhatVayImpl extends PhatVayBaseImpl {
	private JSONArray taiSanThueChapJSONArray;
	private KhachHang khachHang;
	private CongTacVien congTacVien;
	private Double duNoGoc;
	private Double soTienThuNgay;

	public Double getDuNoGoc() {
		// Nếu phát vay đã tất toán
		if (getTrangThai() == 3) {
			duNoGoc = GetterUtil.getDouble(0);
		} else {
			int soLanDaThu = getSoLanDaThu() + getSoNgayThuTruoc();
			if (soLanDaThu == getThoiHan()) {
				duNoGoc = GetterUtil.getDouble(0);
			} else if (soLanDaThu < getThoiHan()) {
				duNoGoc = getSoTienVay() - (soLanDaThu * getGocNgay());
			}
		}
		return duNoGoc;
	}

	public Double getSoTienThuNgay() {
		soTienThuNgay = getLaiNgay() + getGocNgay();
		return soTienThuNgay;
	}

	public CongTacVien getCongTacVien() {
		if (congTacVien == null) {
			try {
				congTacVien = CongTacVienLocalServiceUtil.fetchByMa(getMaCTV());
			} catch (Exception e) {
			}
		}
		return congTacVien;
	}

	public KhachHang getKhachHang() {
		if (khachHang == null) {
			try {
				khachHang = KhachHangLocalServiceUtil.fetchByMa(getMaKhachHang());
			} catch (Exception e) {
			}
		}
		return khachHang;
	}

	public JSONArray getTaiSanThueChapJSONArray() {
		return taiSanThueChapJSONArray;
	}

	public void setTaiSanThueChapJSONArray(JSONArray taiSanThueChapJSONArray) {
		this.taiSanThueChapJSONArray = taiSanThueChapJSONArray;
	}

	public PhatVayImpl() {
	}

}