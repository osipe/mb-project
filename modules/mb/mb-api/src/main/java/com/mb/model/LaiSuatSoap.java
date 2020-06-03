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
 * This class is used by SOAP remote services, specifically {@link com.mb.service.http.LaiSuatServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class LaiSuatSoap implements Serializable {

	public static LaiSuatSoap toSoapModel(LaiSuat model) {
		LaiSuatSoap soapModel = new LaiSuatSoap();

		soapModel.setLaiSuatId(model.getLaiSuatId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setSoTienVay(model.getSoTienVay());
		soapModel.setThoiHan(model.getThoiHan());
		soapModel.setLaiSuatVay(model.getLaiSuatVay());
		soapModel.setGocNgay(model.getGocNgay());
		soapModel.setLaiNgay(model.getLaiNgay());
		soapModel.setGocNgayCuoi(model.getGocNgayCuoi());
		soapModel.setHoatDong(model.getHoatDong());

		return soapModel;
	}

	public static LaiSuatSoap[] toSoapModels(LaiSuat[] models) {
		LaiSuatSoap[] soapModels = new LaiSuatSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LaiSuatSoap[][] toSoapModels(LaiSuat[][] models) {
		LaiSuatSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LaiSuatSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LaiSuatSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LaiSuatSoap[] toSoapModels(List<LaiSuat> models) {
		List<LaiSuatSoap> soapModels = new ArrayList<LaiSuatSoap>(
			models.size());

		for (LaiSuat model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LaiSuatSoap[soapModels.size()]);
	}

	public LaiSuatSoap() {
	}

	public long getPrimaryKey() {
		return _laiSuatId;
	}

	public void setPrimaryKey(long pk) {
		setLaiSuatId(pk);
	}

	public long getLaiSuatId() {
		return _laiSuatId;
	}

	public void setLaiSuatId(long laiSuatId) {
		_laiSuatId = laiSuatId;
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

	public Double getSoTienVay() {
		return _soTienVay;
	}

	public void setSoTienVay(Double soTienVay) {
		_soTienVay = soTienVay;
	}

	public int getThoiHan() {
		return _thoiHan;
	}

	public void setThoiHan(int thoiHan) {
		_thoiHan = thoiHan;
	}

	public Double getLaiSuatVay() {
		return _laiSuatVay;
	}

	public void setLaiSuatVay(Double laiSuatVay) {
		_laiSuatVay = laiSuatVay;
	}

	public Double getGocNgay() {
		return _gocNgay;
	}

	public void setGocNgay(Double gocNgay) {
		_gocNgay = gocNgay;
	}

	public Double getLaiNgay() {
		return _laiNgay;
	}

	public void setLaiNgay(Double laiNgay) {
		_laiNgay = laiNgay;
	}

	public Double getGocNgayCuoi() {
		return _gocNgayCuoi;
	}

	public void setGocNgayCuoi(Double gocNgayCuoi) {
		_gocNgayCuoi = gocNgayCuoi;
	}

	public Boolean getHoatDong() {
		return _hoatDong;
	}

	public void setHoatDong(Boolean hoatDong) {
		_hoatDong = hoatDong;
	}

	private long _laiSuatId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private Double _soTienVay;
	private int _thoiHan;
	private Double _laiSuatVay;
	private Double _gocNgay;
	private Double _laiNgay;
	private Double _gocNgayCuoi;
	private Boolean _hoatDong;

}