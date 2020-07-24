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
 * This class is used by SOAP remote services, specifically {@link com.mb.service.http.LichSuTaiKhoanDauKyServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class LichSuTaiKhoanDauKySoap implements Serializable {

	public static LichSuTaiKhoanDauKySoap toSoapModel(
		LichSuTaiKhoanDauKy model) {

		LichSuTaiKhoanDauKySoap soapModel = new LichSuTaiKhoanDauKySoap();

		soapModel.setLichSuTaiKhoanDauKyId(model.getLichSuTaiKhoanDauKyId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTaiKhoanDoiUngId(model.getTaiKhoanDoiUngId());
		soapModel.setThang(model.getThang());
		soapModel.setNam(model.getNam());
		soapModel.setSoTienTon(model.getSoTienTon());
		soapModel.setSoTienThu(model.getSoTienThu());
		soapModel.setSoTienChi(model.getSoTienChi());
		soapModel.setHoatDong(model.getHoatDong());

		return soapModel;
	}

	public static LichSuTaiKhoanDauKySoap[] toSoapModels(
		LichSuTaiKhoanDauKy[] models) {

		LichSuTaiKhoanDauKySoap[] soapModels =
			new LichSuTaiKhoanDauKySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LichSuTaiKhoanDauKySoap[][] toSoapModels(
		LichSuTaiKhoanDauKy[][] models) {

		LichSuTaiKhoanDauKySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new LichSuTaiKhoanDauKySoap[models.length][models[0].length];
		}
		else {
			soapModels = new LichSuTaiKhoanDauKySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LichSuTaiKhoanDauKySoap[] toSoapModels(
		List<LichSuTaiKhoanDauKy> models) {

		List<LichSuTaiKhoanDauKySoap> soapModels =
			new ArrayList<LichSuTaiKhoanDauKySoap>(models.size());

		for (LichSuTaiKhoanDauKy model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new LichSuTaiKhoanDauKySoap[soapModels.size()]);
	}

	public LichSuTaiKhoanDauKySoap() {
	}

	public long getPrimaryKey() {
		return _lichSuTaiKhoanDauKyId;
	}

	public void setPrimaryKey(long pk) {
		setLichSuTaiKhoanDauKyId(pk);
	}

	public long getLichSuTaiKhoanDauKyId() {
		return _lichSuTaiKhoanDauKyId;
	}

	public void setLichSuTaiKhoanDauKyId(long lichSuTaiKhoanDauKyId) {
		_lichSuTaiKhoanDauKyId = lichSuTaiKhoanDauKyId;
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

	public long getTaiKhoanDoiUngId() {
		return _taiKhoanDoiUngId;
	}

	public void setTaiKhoanDoiUngId(long taiKhoanDoiUngId) {
		_taiKhoanDoiUngId = taiKhoanDoiUngId;
	}

	public int getThang() {
		return _thang;
	}

	public void setThang(int thang) {
		_thang = thang;
	}

	public int getNam() {
		return _nam;
	}

	public void setNam(int nam) {
		_nam = nam;
	}

	public Double getSoTienTon() {
		return _soTienTon;
	}

	public void setSoTienTon(Double soTienTon) {
		_soTienTon = soTienTon;
	}

	public Double getSoTienThu() {
		return _soTienThu;
	}

	public void setSoTienThu(Double soTienThu) {
		_soTienThu = soTienThu;
	}

	public Double getSoTienChi() {
		return _soTienChi;
	}

	public void setSoTienChi(Double soTienChi) {
		_soTienChi = soTienChi;
	}

	public Boolean getHoatDong() {
		return _hoatDong;
	}

	public void setHoatDong(Boolean hoatDong) {
		_hoatDong = hoatDong;
	}

	private long _lichSuTaiKhoanDauKyId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _taiKhoanDoiUngId;
	private int _thang;
	private int _nam;
	private Double _soTienTon;
	private Double _soTienThu;
	private Double _soTienChi;
	private Boolean _hoatDong;

}