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

package com.mb.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.mb.service.http.DsPhieuTaiKhoanServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class DsPhieuTaiKhoanSoap implements Serializable {

	public static DsPhieuTaiKhoanSoap toSoapModel(DsPhieuTaiKhoan model) {
		DsPhieuTaiKhoanSoap soapModel = new DsPhieuTaiKhoanSoap();

		soapModel.setDsPhieuTaiKhoanId(model.getDsPhieuTaiKhoanId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setPhieuId(model.getPhieuId());
		soapModel.setNgayChungTu(model.getNgayChungTu());
		soapModel.setTaiKhoanDoiUngId(model.getTaiKhoanDoiUngId());
		soapModel.setMaTheoDoi(model.getMaTheoDoi());
		soapModel.setDienGiaiTheoDoi(model.getDienGiaiTheoDoi());
		soapModel.setSoTien(model.getSoTien());
		soapModel.setTenCTV(model.getTenCTV());
		soapModel.setMaCTV(model.getMaCTV());
		soapModel.setHoatDong(model.getHoatDong());

		return soapModel;
	}

	public static DsPhieuTaiKhoanSoap[] toSoapModels(DsPhieuTaiKhoan[] models) {
		DsPhieuTaiKhoanSoap[] soapModels =
			new DsPhieuTaiKhoanSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DsPhieuTaiKhoanSoap[][] toSoapModels(
		DsPhieuTaiKhoan[][] models) {

		DsPhieuTaiKhoanSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new DsPhieuTaiKhoanSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DsPhieuTaiKhoanSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DsPhieuTaiKhoanSoap[] toSoapModels(
		List<DsPhieuTaiKhoan> models) {

		List<DsPhieuTaiKhoanSoap> soapModels =
			new ArrayList<DsPhieuTaiKhoanSoap>(models.size());

		for (DsPhieuTaiKhoan model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DsPhieuTaiKhoanSoap[soapModels.size()]);
	}

	public DsPhieuTaiKhoanSoap() {
	}

	public long getPrimaryKey() {
		return _dsPhieuTaiKhoanId;
	}

	public void setPrimaryKey(long pk) {
		setDsPhieuTaiKhoanId(pk);
	}

	public long getDsPhieuTaiKhoanId() {
		return _dsPhieuTaiKhoanId;
	}

	public void setDsPhieuTaiKhoanId(long dsPhieuTaiKhoanId) {
		_dsPhieuTaiKhoanId = dsPhieuTaiKhoanId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getPhieuId() {
		return _phieuId;
	}

	public void setPhieuId(long phieuId) {
		_phieuId = phieuId;
	}

	public Date getNgayChungTu() {
		return _ngayChungTu;
	}

	public void setNgayChungTu(Date ngayChungTu) {
		_ngayChungTu = ngayChungTu;
	}

	public long getTaiKhoanDoiUngId() {
		return _taiKhoanDoiUngId;
	}

	public void setTaiKhoanDoiUngId(long taiKhoanDoiUngId) {
		_taiKhoanDoiUngId = taiKhoanDoiUngId;
	}

	public String getMaTheoDoi() {
		return _maTheoDoi;
	}

	public void setMaTheoDoi(String maTheoDoi) {
		_maTheoDoi = maTheoDoi;
	}

	public String getDienGiaiTheoDoi() {
		return _dienGiaiTheoDoi;
	}

	public void setDienGiaiTheoDoi(String dienGiaiTheoDoi) {
		_dienGiaiTheoDoi = dienGiaiTheoDoi;
	}

	public Double getSoTien() {
		return _soTien;
	}

	public void setSoTien(Double soTien) {
		_soTien = soTien;
	}

	public String getTenCTV() {
		return _tenCTV;
	}

	public void setTenCTV(String tenCTV) {
		_tenCTV = tenCTV;
	}

	public String getMaCTV() {
		return _maCTV;
	}

	public void setMaCTV(String maCTV) {
		_maCTV = maCTV;
	}

	public Boolean getHoatDong() {
		return _hoatDong;
	}

	public void setHoatDong(Boolean hoatDong) {
		_hoatDong = hoatDong;
	}

	private long _dsPhieuTaiKhoanId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _phieuId;
	private Date _ngayChungTu;
	private long _taiKhoanDoiUngId;
	private String _maTheoDoi;
	private String _dienGiaiTheoDoi;
	private Double _soTien;
	private String _tenCTV;
	private String _maCTV;
	private Boolean _hoatDong;

}