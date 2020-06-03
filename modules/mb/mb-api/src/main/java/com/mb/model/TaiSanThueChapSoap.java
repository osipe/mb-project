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
 * This class is used by SOAP remote services, specifically {@link com.mb.service.http.TaiSanThueChapServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class TaiSanThueChapSoap implements Serializable {

	public static TaiSanThueChapSoap toSoapModel(TaiSanThueChap model) {
		TaiSanThueChapSoap soapModel = new TaiSanThueChapSoap();

		soapModel.setTaiSanThueChapId(model.getTaiSanThueChapId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setPhatVayId(model.getPhatVayId());
		soapModel.setSoKU(model.getSoKU());
		soapModel.setMaKhachHang(model.getMaKhachHang());
		soapModel.setLoaiTaiSanId(model.getLoaiTaiSanId());
		soapModel.setGiaTriTaiSan(model.getGiaTriTaiSan());
		soapModel.setThongTinTaiSan(model.getThongTinTaiSan());
		soapModel.setTen(model.getTen());
		soapModel.setGhiChu(model.getGhiChu());

		return soapModel;
	}

	public static TaiSanThueChapSoap[] toSoapModels(TaiSanThueChap[] models) {
		TaiSanThueChapSoap[] soapModels = new TaiSanThueChapSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TaiSanThueChapSoap[][] toSoapModels(
		TaiSanThueChap[][] models) {

		TaiSanThueChapSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new TaiSanThueChapSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TaiSanThueChapSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TaiSanThueChapSoap[] toSoapModels(
		List<TaiSanThueChap> models) {

		List<TaiSanThueChapSoap> soapModels = new ArrayList<TaiSanThueChapSoap>(
			models.size());

		for (TaiSanThueChap model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TaiSanThueChapSoap[soapModels.size()]);
	}

	public TaiSanThueChapSoap() {
	}

	public long getPrimaryKey() {
		return _taiSanThueChapId;
	}

	public void setPrimaryKey(long pk) {
		setTaiSanThueChapId(pk);
	}

	public long getTaiSanThueChapId() {
		return _taiSanThueChapId;
	}

	public void setTaiSanThueChapId(long taiSanThueChapId) {
		_taiSanThueChapId = taiSanThueChapId;
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

	public long getPhatVayId() {
		return _phatVayId;
	}

	public void setPhatVayId(long phatVayId) {
		_phatVayId = phatVayId;
	}

	public String getSoKU() {
		return _soKU;
	}

	public void setSoKU(String soKU) {
		_soKU = soKU;
	}

	public String getMaKhachHang() {
		return _maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		_maKhachHang = maKhachHang;
	}

	public long getLoaiTaiSanId() {
		return _loaiTaiSanId;
	}

	public void setLoaiTaiSanId(long loaiTaiSanId) {
		_loaiTaiSanId = loaiTaiSanId;
	}

	public Double getGiaTriTaiSan() {
		return _giaTriTaiSan;
	}

	public void setGiaTriTaiSan(Double giaTriTaiSan) {
		_giaTriTaiSan = giaTriTaiSan;
	}

	public String getThongTinTaiSan() {
		return _thongTinTaiSan;
	}

	public void setThongTinTaiSan(String thongTinTaiSan) {
		_thongTinTaiSan = thongTinTaiSan;
	}

	public String getTen() {
		return _ten;
	}

	public void setTen(String ten) {
		_ten = ten;
	}

	public String getGhiChu() {
		return _ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		_ghiChu = ghiChu;
	}

	private long _taiSanThueChapId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _phatVayId;
	private String _soKU;
	private String _maKhachHang;
	private long _loaiTaiSanId;
	private Double _giaTriTaiSan;
	private String _thongTinTaiSan;
	private String _ten;
	private String _ghiChu;

}