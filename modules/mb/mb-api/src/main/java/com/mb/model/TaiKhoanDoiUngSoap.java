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
 * This class is used by SOAP remote services, specifically {@link com.mb.service.http.TaiKhoanDoiUngServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class TaiKhoanDoiUngSoap implements Serializable {

	public static TaiKhoanDoiUngSoap toSoapModel(TaiKhoanDoiUng model) {
		TaiKhoanDoiUngSoap soapModel = new TaiKhoanDoiUngSoap();

		soapModel.setTaiKhoanDoiUngId(model.getTaiKhoanDoiUngId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTaiKhoanDoiUngChaId(model.getTaiKhoanDoiUngChaId());
		soapModel.setSoHieu(model.getSoHieu());
		soapModel.setTen(model.getTen());
		soapModel.setDienGiaiTheoDoi(model.getDienGiaiTheoDoi());
		soapModel.setLoaiTaiKhoan(model.getLoaiTaiKhoan());
		soapModel.setHoatDong(model.getHoatDong());

		return soapModel;
	}

	public static TaiKhoanDoiUngSoap[] toSoapModels(TaiKhoanDoiUng[] models) {
		TaiKhoanDoiUngSoap[] soapModels = new TaiKhoanDoiUngSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TaiKhoanDoiUngSoap[][] toSoapModels(
		TaiKhoanDoiUng[][] models) {

		TaiKhoanDoiUngSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new TaiKhoanDoiUngSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TaiKhoanDoiUngSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TaiKhoanDoiUngSoap[] toSoapModels(
		List<TaiKhoanDoiUng> models) {

		List<TaiKhoanDoiUngSoap> soapModels = new ArrayList<TaiKhoanDoiUngSoap>(
			models.size());

		for (TaiKhoanDoiUng model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TaiKhoanDoiUngSoap[soapModels.size()]);
	}

	public TaiKhoanDoiUngSoap() {
	}

	public long getPrimaryKey() {
		return _taiKhoanDoiUngId;
	}

	public void setPrimaryKey(long pk) {
		setTaiKhoanDoiUngId(pk);
	}

	public long getTaiKhoanDoiUngId() {
		return _taiKhoanDoiUngId;
	}

	public void setTaiKhoanDoiUngId(long taiKhoanDoiUngId) {
		_taiKhoanDoiUngId = taiKhoanDoiUngId;
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

	public long getTaiKhoanDoiUngChaId() {
		return _taiKhoanDoiUngChaId;
	}

	public void setTaiKhoanDoiUngChaId(long taiKhoanDoiUngChaId) {
		_taiKhoanDoiUngChaId = taiKhoanDoiUngChaId;
	}

	public String getSoHieu() {
		return _soHieu;
	}

	public void setSoHieu(String soHieu) {
		_soHieu = soHieu;
	}

	public String getTen() {
		return _ten;
	}

	public void setTen(String ten) {
		_ten = ten;
	}

	public String getDienGiaiTheoDoi() {
		return _dienGiaiTheoDoi;
	}

	public void setDienGiaiTheoDoi(String dienGiaiTheoDoi) {
		_dienGiaiTheoDoi = dienGiaiTheoDoi;
	}

	public int getLoaiTaiKhoan() {
		return _loaiTaiKhoan;
	}

	public void setLoaiTaiKhoan(int loaiTaiKhoan) {
		_loaiTaiKhoan = loaiTaiKhoan;
	}

	public Boolean getHoatDong() {
		return _hoatDong;
	}

	public void setHoatDong(Boolean hoatDong) {
		_hoatDong = hoatDong;
	}

	private long _taiKhoanDoiUngId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _taiKhoanDoiUngChaId;
	private String _soHieu;
	private String _ten;
	private String _dienGiaiTheoDoi;
	private int _loaiTaiKhoan;
	private Boolean _hoatDong;

}