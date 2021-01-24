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
 * This class is used by SOAP remote services, specifically {@link com.mb.service.http.ChiNhanhServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class ChiNhanhSoap implements Serializable {

	public static ChiNhanhSoap toSoapModel(ChiNhanh model) {
		ChiNhanhSoap soapModel = new ChiNhanhSoap();

		soapModel.setChiNhanhId(model.getChiNhanhId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setMa(model.getMa());
		soapModel.setTen(model.getTen());
		soapModel.setHoatDong(model.getHoatDong());

		return soapModel;
	}

	public static ChiNhanhSoap[] toSoapModels(ChiNhanh[] models) {
		ChiNhanhSoap[] soapModels = new ChiNhanhSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ChiNhanhSoap[][] toSoapModels(ChiNhanh[][] models) {
		ChiNhanhSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ChiNhanhSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ChiNhanhSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ChiNhanhSoap[] toSoapModels(List<ChiNhanh> models) {
		List<ChiNhanhSoap> soapModels = new ArrayList<ChiNhanhSoap>(
			models.size());

		for (ChiNhanh model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ChiNhanhSoap[soapModels.size()]);
	}

	public ChiNhanhSoap() {
	}

	public long getPrimaryKey() {
		return _chiNhanhId;
	}

	public void setPrimaryKey(long pk) {
		setChiNhanhId(pk);
	}

	public long getChiNhanhId() {
		return _chiNhanhId;
	}

	public void setChiNhanhId(long chiNhanhId) {
		_chiNhanhId = chiNhanhId;
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

	public String getTen() {
		return _ten;
	}

	public void setTen(String ten) {
		_ten = ten;
	}

	public Boolean getHoatDong() {
		return _hoatDong;
	}

	public void setHoatDong(Boolean hoatDong) {
		_hoatDong = hoatDong;
	}

	private long _chiNhanhId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _ma;
	private String _ten;
	private Boolean _hoatDong;

}