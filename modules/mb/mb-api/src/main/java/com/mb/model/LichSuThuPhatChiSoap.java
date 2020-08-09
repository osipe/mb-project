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
 * This class is used by SOAP remote services, specifically {@link com.mb.service.http.LichSuThuPhatChiServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class LichSuThuPhatChiSoap implements Serializable {

	public static LichSuThuPhatChiSoap toSoapModel(LichSuThuPhatChi model) {
		LichSuThuPhatChiSoap soapModel = new LichSuThuPhatChiSoap();

		soapModel.setLichSuThuPhatChiId(model.getLichSuThuPhatChiId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setPhatVayId(model.getPhatVayId());
		soapModel.setMaCTV(model.getMaCTV());
		soapModel.setSoTien(model.getSoTien());
		soapModel.setTongSoTienVonTra(model.getTongSoTienVonTra());
		soapModel.setTongSoTienLaiTra(model.getTongSoTienLaiTra());
		soapModel.setNgayXuLy(model.getNgayXuLy());
		soapModel.setLoai(model.getLoai());
		soapModel.setTrangThaiPhatVayHienTai(
			model.getTrangThaiPhatVayHienTai());

		return soapModel;
	}

	public static LichSuThuPhatChiSoap[] toSoapModels(
		LichSuThuPhatChi[] models) {

		LichSuThuPhatChiSoap[] soapModels =
			new LichSuThuPhatChiSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LichSuThuPhatChiSoap[][] toSoapModels(
		LichSuThuPhatChi[][] models) {

		LichSuThuPhatChiSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new LichSuThuPhatChiSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LichSuThuPhatChiSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LichSuThuPhatChiSoap[] toSoapModels(
		List<LichSuThuPhatChi> models) {

		List<LichSuThuPhatChiSoap> soapModels =
			new ArrayList<LichSuThuPhatChiSoap>(models.size());

		for (LichSuThuPhatChi model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LichSuThuPhatChiSoap[soapModels.size()]);
	}

	public LichSuThuPhatChiSoap() {
	}

	public long getPrimaryKey() {
		return _lichSuThuPhatChiId;
	}

	public void setPrimaryKey(long pk) {
		setLichSuThuPhatChiId(pk);
	}

	public long getLichSuThuPhatChiId() {
		return _lichSuThuPhatChiId;
	}

	public void setLichSuThuPhatChiId(long lichSuThuPhatChiId) {
		_lichSuThuPhatChiId = lichSuThuPhatChiId;
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

	public String getMaCTV() {
		return _maCTV;
	}

	public void setMaCTV(String maCTV) {
		_maCTV = maCTV;
	}

	public Double getSoTien() {
		return _soTien;
	}

	public void setSoTien(Double soTien) {
		_soTien = soTien;
	}

	public Double getTongSoTienVonTra() {
		return _tongSoTienVonTra;
	}

	public void setTongSoTienVonTra(Double tongSoTienVonTra) {
		_tongSoTienVonTra = tongSoTienVonTra;
	}

	public Double getTongSoTienLaiTra() {
		return _tongSoTienLaiTra;
	}

	public void setTongSoTienLaiTra(Double tongSoTienLaiTra) {
		_tongSoTienLaiTra = tongSoTienLaiTra;
	}

	public Date getNgayXuLy() {
		return _ngayXuLy;
	}

	public void setNgayXuLy(Date ngayXuLy) {
		_ngayXuLy = ngayXuLy;
	}

	public int getLoai() {
		return _loai;
	}

	public void setLoai(int loai) {
		_loai = loai;
	}

	public int getTrangThaiPhatVayHienTai() {
		return _trangThaiPhatVayHienTai;
	}

	public void setTrangThaiPhatVayHienTai(int trangThaiPhatVayHienTai) {
		_trangThaiPhatVayHienTai = trangThaiPhatVayHienTai;
	}

	private long _lichSuThuPhatChiId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _phatVayId;
	private String _maCTV;
	private Double _soTien;
	private Double _tongSoTienVonTra;
	private Double _tongSoTienLaiTra;
	private Date _ngayXuLy;
	private int _loai;
	private int _trangThaiPhatVayHienTai;

}