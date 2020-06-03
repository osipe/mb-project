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
 * This class is used by SOAP remote services, specifically {@link com.mb.service.http.PhieuServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class PhieuSoap implements Serializable {

	public static PhieuSoap toSoapModel(Phieu model) {
		PhieuSoap soapModel = new PhieuSoap();

		soapModel.setPhieuId(model.getPhieuId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setMaCTV(model.getMaCTV());
		soapModel.setHoTenCTV(model.getHoTenCTV());
		soapModel.setSoHopDong(model.getSoHopDong());
		soapModel.setNgayChungTu(model.getNgayChungTu());
		soapModel.setDiaChi(model.getDiaChi());
		soapModel.setSoPhieu(model.getSoPhieu());
		soapModel.setNgayGhiSo(model.getNgayGhiSo());
		soapModel.setMaMSThuChi(model.getMaMSThuChi());
		soapModel.setSoTien(model.getSoTien());
		soapModel.setChungTuKemTheo(model.getChungTuKemTheo());
		soapModel.setLoai(model.getLoai());
		soapModel.setHoatDong(model.getHoatDong());

		return soapModel;
	}

	public static PhieuSoap[] toSoapModels(Phieu[] models) {
		PhieuSoap[] soapModels = new PhieuSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PhieuSoap[][] toSoapModels(Phieu[][] models) {
		PhieuSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PhieuSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PhieuSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PhieuSoap[] toSoapModels(List<Phieu> models) {
		List<PhieuSoap> soapModels = new ArrayList<PhieuSoap>(models.size());

		for (Phieu model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PhieuSoap[soapModels.size()]);
	}

	public PhieuSoap() {
	}

	public long getPrimaryKey() {
		return _phieuId;
	}

	public void setPrimaryKey(long pk) {
		setPhieuId(pk);
	}

	public long getPhieuId() {
		return _phieuId;
	}

	public void setPhieuId(long phieuId) {
		_phieuId = phieuId;
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

	public String getHoTenCTV() {
		return _hoTenCTV;
	}

	public void setHoTenCTV(String hoTenCTV) {
		_hoTenCTV = hoTenCTV;
	}

	public String getSoHopDong() {
		return _soHopDong;
	}

	public void setSoHopDong(String soHopDong) {
		_soHopDong = soHopDong;
	}

	public Date getNgayChungTu() {
		return _ngayChungTu;
	}

	public void setNgayChungTu(Date ngayChungTu) {
		_ngayChungTu = ngayChungTu;
	}

	public String getDiaChi() {
		return _diaChi;
	}

	public void setDiaChi(String diaChi) {
		_diaChi = diaChi;
	}

	public String getSoPhieu() {
		return _soPhieu;
	}

	public void setSoPhieu(String soPhieu) {
		_soPhieu = soPhieu;
	}

	public Date getNgayGhiSo() {
		return _ngayGhiSo;
	}

	public void setNgayGhiSo(Date ngayGhiSo) {
		_ngayGhiSo = ngayGhiSo;
	}

	public String getMaMSThuChi() {
		return _maMSThuChi;
	}

	public void setMaMSThuChi(String maMSThuChi) {
		_maMSThuChi = maMSThuChi;
	}

	public Double getSoTien() {
		return _soTien;
	}

	public void setSoTien(Double soTien) {
		_soTien = soTien;
	}

	public String getChungTuKemTheo() {
		return _chungTuKemTheo;
	}

	public void setChungTuKemTheo(String chungTuKemTheo) {
		_chungTuKemTheo = chungTuKemTheo;
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

	private long _phieuId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _maCTV;
	private String _hoTenCTV;
	private String _soHopDong;
	private Date _ngayChungTu;
	private String _diaChi;
	private String _soPhieu;
	private Date _ngayGhiSo;
	private String _maMSThuChi;
	private Double _soTien;
	private String _chungTuKemTheo;
	private int _loai;
	private Boolean _hoatDong;

}