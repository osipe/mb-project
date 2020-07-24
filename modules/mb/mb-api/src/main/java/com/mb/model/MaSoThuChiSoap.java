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
 * This class is used by SOAP remote services, specifically {@link com.mb.service.http.MaSoThuChiServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class MaSoThuChiSoap implements Serializable {

	public static MaSoThuChiSoap toSoapModel(MaSoThuChi model) {
		MaSoThuChiSoap soapModel = new MaSoThuChiSoap();

		soapModel.setMaSoThuChiId(model.getMaSoThuChiId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setMa(model.getMa());
		soapModel.setDienGiai(model.getDienGiai());
		soapModel.setLoai(model.getLoai());
		soapModel.setHoatDong(model.getHoatDong());

		return soapModel;
	}

	public static MaSoThuChiSoap[] toSoapModels(MaSoThuChi[] models) {
		MaSoThuChiSoap[] soapModels = new MaSoThuChiSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MaSoThuChiSoap[][] toSoapModels(MaSoThuChi[][] models) {
		MaSoThuChiSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MaSoThuChiSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MaSoThuChiSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MaSoThuChiSoap[] toSoapModels(List<MaSoThuChi> models) {
		List<MaSoThuChiSoap> soapModels = new ArrayList<MaSoThuChiSoap>(
			models.size());

		for (MaSoThuChi model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MaSoThuChiSoap[soapModels.size()]);
	}

	public MaSoThuChiSoap() {
	}

	public long getPrimaryKey() {
		return _maSoThuChiId;
	}

	public void setPrimaryKey(long pk) {
		setMaSoThuChiId(pk);
	}

	public long getMaSoThuChiId() {
		return _maSoThuChiId;
	}

	public void setMaSoThuChiId(long maSoThuChiId) {
		_maSoThuChiId = maSoThuChiId;
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

	public String getMa() {
		return _ma;
	}

	public void setMa(String ma) {
		_ma = ma;
	}

	public String getDienGiai() {
		return _dienGiai;
	}

	public void setDienGiai(String dienGiai) {
		_dienGiai = dienGiai;
	}

	public int getLoai() {
		return _loai;
	}

	public void setLoai(int loai) {
		_loai = loai;
	}

	public Boolean getHoatDong() {
		return _hoatDong;
	}

	public void setHoatDong(Boolean hoatDong) {
		_hoatDong = hoatDong;
	}

	private long _maSoThuChiId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _ma;
	private String _dienGiai;
	private int _loai;
	private Boolean _hoatDong;

}