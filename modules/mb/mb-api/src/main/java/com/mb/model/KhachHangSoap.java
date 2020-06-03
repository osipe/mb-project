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
 * This class is used by SOAP remote services, specifically {@link com.mb.service.http.KhachHangServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class KhachHangSoap implements Serializable {

	public static KhachHangSoap toSoapModel(KhachHang model) {
		KhachHangSoap soapModel = new KhachHangSoap();

		soapModel.setKhachHangId(model.getKhachHangId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setMaCTV(model.getMaCTV());
		soapModel.setMa(model.getMa());
		soapModel.setHoTen(model.getHoTen());
		soapModel.setSoCMND(model.getSoCMND());
		soapModel.setDiaChi(model.getDiaChi());
		soapModel.setHoatDong(model.getHoatDong());

		return soapModel;
	}

	public static KhachHangSoap[] toSoapModels(KhachHang[] models) {
		KhachHangSoap[] soapModels = new KhachHangSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static KhachHangSoap[][] toSoapModels(KhachHang[][] models) {
		KhachHangSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new KhachHangSoap[models.length][models[0].length];
		}
		else {
			soapModels = new KhachHangSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static KhachHangSoap[] toSoapModels(List<KhachHang> models) {
		List<KhachHangSoap> soapModels = new ArrayList<KhachHangSoap>(
			models.size());

		for (KhachHang model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new KhachHangSoap[soapModels.size()]);
	}

	public KhachHangSoap() {
	}

	public long getPrimaryKey() {
		return _khachHangId;
	}

	public void setPrimaryKey(long pk) {
		setKhachHangId(pk);
	}

	public long getKhachHangId() {
		return _khachHangId;
	}

	public void setKhachHangId(long khachHangId) {
		_khachHangId = khachHangId;
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

	public String getMaCTV() {
		return _maCTV;
	}

	public void setMaCTV(String maCTV) {
		_maCTV = maCTV;
	}

	public String getMa() {
		return _ma;
	}

	public void setMa(String ma) {
		_ma = ma;
	}

	public String getHoTen() {
		return _hoTen;
	}

	public void setHoTen(String hoTen) {
		_hoTen = hoTen;
	}

	public String getSoCMND() {
		return _soCMND;
	}

	public void setSoCMND(String soCMND) {
		_soCMND = soCMND;
	}

	public String getDiaChi() {
		return _diaChi;
	}

	public void setDiaChi(String diaChi) {
		_diaChi = diaChi;
	}

	public Boolean getHoatDong() {
		return _hoatDong;
	}

	public void setHoatDong(Boolean hoatDong) {
		_hoatDong = hoatDong;
	}

	private long _khachHangId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _maCTV;
	private String _ma;
	private String _hoTen;
	private String _soCMND;
	private String _diaChi;
	private Boolean _hoatDong;

}