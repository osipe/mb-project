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
 * This class is used by SOAP remote services, specifically {@link com.mb.service.http.MaSoTheoDoiServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class MaSoTheoDoiSoap implements Serializable {

	public static MaSoTheoDoiSoap toSoapModel(MaSoTheoDoi model) {
		MaSoTheoDoiSoap soapModel = new MaSoTheoDoiSoap();

		soapModel.setMaSoTheoDoiId(model.getMaSoTheoDoiId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setMa(model.getMa());
		soapModel.setDienGiai(model.getDienGiai());
		soapModel.setHoatDong(model.getHoatDong());

		return soapModel;
	}

	public static MaSoTheoDoiSoap[] toSoapModels(MaSoTheoDoi[] models) {
		MaSoTheoDoiSoap[] soapModels = new MaSoTheoDoiSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MaSoTheoDoiSoap[][] toSoapModels(MaSoTheoDoi[][] models) {
		MaSoTheoDoiSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MaSoTheoDoiSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MaSoTheoDoiSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MaSoTheoDoiSoap[] toSoapModels(List<MaSoTheoDoi> models) {
		List<MaSoTheoDoiSoap> soapModels = new ArrayList<MaSoTheoDoiSoap>(
			models.size());

		for (MaSoTheoDoi model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MaSoTheoDoiSoap[soapModels.size()]);
	}

	public MaSoTheoDoiSoap() {
	}

	public long getPrimaryKey() {
		return _maSoTheoDoiId;
	}

	public void setPrimaryKey(long pk) {
		setMaSoTheoDoiId(pk);
	}

	public long getMaSoTheoDoiId() {
		return _maSoTheoDoiId;
	}

	public void setMaSoTheoDoiId(long maSoTheoDoiId) {
		_maSoTheoDoiId = maSoTheoDoiId;
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

	public Boolean getHoatDong() {
		return _hoatDong;
	}

	public void setHoatDong(Boolean hoatDong) {
		_hoatDong = hoatDong;
	}

	private long _maSoTheoDoiId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _ma;
	private String _dienGiai;
	private Boolean _hoatDong;

}