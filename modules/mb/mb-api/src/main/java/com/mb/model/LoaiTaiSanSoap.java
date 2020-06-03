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
 * This class is used by SOAP remote services, specifically {@link com.mb.service.http.LoaiTaiSanServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class LoaiTaiSanSoap implements Serializable {

	public static LoaiTaiSanSoap toSoapModel(LoaiTaiSan model) {
		LoaiTaiSanSoap soapModel = new LoaiTaiSanSoap();

		soapModel.setLoaiTaiSanId(model.getLoaiTaiSanId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTen(model.getTen());
		soapModel.setMa(model.getMa());
		soapModel.setGhiChu(model.getGhiChu());
		soapModel.setHoatDong(model.getHoatDong());

		return soapModel;
	}

	public static LoaiTaiSanSoap[] toSoapModels(LoaiTaiSan[] models) {
		LoaiTaiSanSoap[] soapModels = new LoaiTaiSanSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LoaiTaiSanSoap[][] toSoapModels(LoaiTaiSan[][] models) {
		LoaiTaiSanSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LoaiTaiSanSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LoaiTaiSanSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LoaiTaiSanSoap[] toSoapModels(List<LoaiTaiSan> models) {
		List<LoaiTaiSanSoap> soapModels = new ArrayList<LoaiTaiSanSoap>(
			models.size());

		for (LoaiTaiSan model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LoaiTaiSanSoap[soapModels.size()]);
	}

	public LoaiTaiSanSoap() {
	}

	public long getPrimaryKey() {
		return _loaiTaiSanId;
	}

	public void setPrimaryKey(long pk) {
		setLoaiTaiSanId(pk);
	}

	public long getLoaiTaiSanId() {
		return _loaiTaiSanId;
	}

	public void setLoaiTaiSanId(long loaiTaiSanId) {
		_loaiTaiSanId = loaiTaiSanId;
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

	public String getTen() {
		return _ten;
	}

	public void setTen(String ten) {
		_ten = ten;
	}

	public String getMa() {
		return _ma;
	}

	public void setMa(String ma) {
		_ma = ma;
	}

	public String getGhiChu() {
		return _ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		_ghiChu = ghiChu;
	}

	public Boolean getHoatDong() {
		return _hoatDong;
	}

	public void setHoatDong(Boolean hoatDong) {
		_hoatDong = hoatDong;
	}

	private long _loaiTaiSanId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _ten;
	private String _ma;
	private String _ghiChu;
	private Boolean _hoatDong;

}