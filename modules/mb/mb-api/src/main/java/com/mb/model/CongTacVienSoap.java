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
 * This class is used by SOAP remote services, specifically {@link com.mb.service.http.CongTacVienServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class CongTacVienSoap implements Serializable {

	public static CongTacVienSoap toSoapModel(CongTacVien model) {
		CongTacVienSoap soapModel = new CongTacVienSoap();

		soapModel.setCongTacVienId(model.getCongTacVienId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setChiNhanhId(model.getChiNhanhId());
		soapModel.setTenChiNhanh(model.getTenChiNhanh());
		soapModel.setMa(model.getMa());
		soapModel.setHoTen(model.getHoTen());
		soapModel.setSoCMND(model.getSoCMND());
		soapModel.setDuNoToiDa(model.getDuNoToiDa());
		soapModel.setDuNoToiDaTheChap(model.getDuNoToiDaTheChap());
		soapModel.setDiaChi(model.getDiaChi());
		soapModel.setGhiChu(model.getGhiChu());
		soapModel.setHoatDong(model.getHoatDong());

		return soapModel;
	}

	public static CongTacVienSoap[] toSoapModels(CongTacVien[] models) {
		CongTacVienSoap[] soapModels = new CongTacVienSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CongTacVienSoap[][] toSoapModels(CongTacVien[][] models) {
		CongTacVienSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CongTacVienSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CongTacVienSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CongTacVienSoap[] toSoapModels(List<CongTacVien> models) {
		List<CongTacVienSoap> soapModels = new ArrayList<CongTacVienSoap>(
			models.size());

		for (CongTacVien model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CongTacVienSoap[soapModels.size()]);
	}

	public CongTacVienSoap() {
	}

	public long getPrimaryKey() {
		return _congTacVienId;
	}

	public void setPrimaryKey(long pk) {
		setCongTacVienId(pk);
	}

	public long getCongTacVienId() {
		return _congTacVienId;
	}

	public void setCongTacVienId(long congTacVienId) {
		_congTacVienId = congTacVienId;
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

	public long getChiNhanhId() {
		return _chiNhanhId;
	}

	public void setChiNhanhId(long chiNhanhId) {
		_chiNhanhId = chiNhanhId;
	}

	public String getTenChiNhanh() {
		return _tenChiNhanh;
	}

	public void setTenChiNhanh(String tenChiNhanh) {
		_tenChiNhanh = tenChiNhanh;
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

	public Double getDuNoToiDa() {
		return _duNoToiDa;
	}

	public void setDuNoToiDa(Double duNoToiDa) {
		_duNoToiDa = duNoToiDa;
	}

	public Double getDuNoToiDaTheChap() {
		return _duNoToiDaTheChap;
	}

	public void setDuNoToiDaTheChap(Double duNoToiDaTheChap) {
		_duNoToiDaTheChap = duNoToiDaTheChap;
	}

	public String getDiaChi() {
		return _diaChi;
	}

	public void setDiaChi(String diaChi) {
		_diaChi = diaChi;
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

	private long _congTacVienId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _chiNhanhId;
	private String _tenChiNhanh;
	private String _ma;
	private String _hoTen;
	private String _soCMND;
	private Double _duNoToiDa;
	private Double _duNoToiDaTheChap;
	private String _diaChi;
	private String _ghiChu;
	private Boolean _hoatDong;

}