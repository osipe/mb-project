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
 * This class is used by SOAP remote services, specifically {@link com.mb.service.http.PhatVayServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class PhatVaySoap implements Serializable {

	public static PhatVaySoap toSoapModel(PhatVay model) {
		PhatVaySoap soapModel = new PhatVaySoap();

		soapModel.setPhatVayId(model.getPhatVayId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setNgayTao(model.getNgayTao());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setChiNhanhId(model.getChiNhanhId());
		soapModel.setMaCTV(model.getMaCTV());
		soapModel.setMaKhachHang(model.getMaKhachHang());
		soapModel.setSoKU(model.getSoKU());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setNgayBatDau(model.getNgayBatDau());
		soapModel.setNgayKetThuc(model.getNgayKetThuc());
		soapModel.setLoaiPhatVay(model.getLoaiPhatVay());
		soapModel.setSoLanDaThu(model.getSoLanDaThu());
		soapModel.setNgayDaThuCuoi(model.getNgayDaThuCuoi());
		soapModel.setSoTienVay(model.getSoTienVay());
		soapModel.setThoiHan(model.getThoiHan());
		soapModel.setLaiSuatVay(model.getLaiSuatVay());
		soapModel.setGocNgay(model.getGocNgay());
		soapModel.setLaiNgay(model.getLaiNgay());
		soapModel.setGocNgayCuoi(model.getGocNgayCuoi());
		soapModel.setSoNgayThuTruoc(model.getSoNgayThuTruoc());
		soapModel.setNgayThuTruocTu(model.getNgayThuTruocTu());
		soapModel.setNgayThuTruocDen(model.getNgayThuTruocDen());
		soapModel.setNgayTatToan(model.getNgayTatToan());
		soapModel.setTrangThai(model.getTrangThai());

		return soapModel;
	}

	public static PhatVaySoap[] toSoapModels(PhatVay[] models) {
		PhatVaySoap[] soapModels = new PhatVaySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PhatVaySoap[][] toSoapModels(PhatVay[][] models) {
		PhatVaySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PhatVaySoap[models.length][models[0].length];
		}
		else {
			soapModels = new PhatVaySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PhatVaySoap[] toSoapModels(List<PhatVay> models) {
		List<PhatVaySoap> soapModels = new ArrayList<PhatVaySoap>(
			models.size());

		for (PhatVay model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PhatVaySoap[soapModels.size()]);
	}

	public PhatVaySoap() {
	}

	public long getPrimaryKey() {
		return _phatVayId;
	}

	public void setPrimaryKey(long pk) {
		setPhatVayId(pk);
	}

	public long getPhatVayId() {
		return _phatVayId;
	}

	public void setPhatVayId(long phatVayId) {
		_phatVayId = phatVayId;
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

	public Date getNgayTao() {
		return _ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		_ngayTao = ngayTao;
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

	public String getMaCTV() {
		return _maCTV;
	}

	public void setMaCTV(String maCTV) {
		_maCTV = maCTV;
	}

	public String getMaKhachHang() {
		return _maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		_maKhachHang = maKhachHang;
	}

	public String getSoKU() {
		return _soKU;
	}

	public void setSoKU(String soKU) {
		_soKU = soKU;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getNgayBatDau() {
		return _ngayBatDau;
	}

	public void setNgayBatDau(Date ngayBatDau) {
		_ngayBatDau = ngayBatDau;
	}

	public Date getNgayKetThuc() {
		return _ngayKetThuc;
	}

	public void setNgayKetThuc(Date ngayKetThuc) {
		_ngayKetThuc = ngayKetThuc;
	}

	public int getLoaiPhatVay() {
		return _loaiPhatVay;
	}

	public void setLoaiPhatVay(int loaiPhatVay) {
		_loaiPhatVay = loaiPhatVay;
	}

	public int getSoLanDaThu() {
		return _soLanDaThu;
	}

	public void setSoLanDaThu(int soLanDaThu) {
		_soLanDaThu = soLanDaThu;
	}

	public Date getNgayDaThuCuoi() {
		return _ngayDaThuCuoi;
	}

	public void setNgayDaThuCuoi(Date ngayDaThuCuoi) {
		_ngayDaThuCuoi = ngayDaThuCuoi;
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

	public int getSoNgayThuTruoc() {
		return _soNgayThuTruoc;
	}

	public void setSoNgayThuTruoc(int soNgayThuTruoc) {
		_soNgayThuTruoc = soNgayThuTruoc;
	}

	public Date getNgayThuTruocTu() {
		return _ngayThuTruocTu;
	}

	public void setNgayThuTruocTu(Date ngayThuTruocTu) {
		_ngayThuTruocTu = ngayThuTruocTu;
	}

	public Date getNgayThuTruocDen() {
		return _ngayThuTruocDen;
	}

	public void setNgayThuTruocDen(Date ngayThuTruocDen) {
		_ngayThuTruocDen = ngayThuTruocDen;
	}

	public Date getNgayTatToan() {
		return _ngayTatToan;
	}

	public void setNgayTatToan(Date ngayTatToan) {
		_ngayTatToan = ngayTatToan;
	}

	public int getTrangThai() {
		return _trangThai;
	}

	public void setTrangThai(int trangThai) {
		_trangThai = trangThai;
	}

	private long _phatVayId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _ngayTao;
	private Date _modifiedDate;
	private long _chiNhanhId;
	private String _maCTV;
	private String _maKhachHang;
	private String _soKU;
	private Date _createDate;
	private Date _ngayBatDau;
	private Date _ngayKetThuc;
	private int _loaiPhatVay;
	private int _soLanDaThu;
	private Date _ngayDaThuCuoi;
	private Double _soTienVay;
	private int _thoiHan;
	private Double _laiSuatVay;
	private Double _gocNgay;
	private Double _laiNgay;
	private Double _gocNgayCuoi;
	private int _soNgayThuTruoc;
	private Date _ngayThuTruocTu;
	private Date _ngayThuTruocDen;
	private Date _ngayTatToan;
	private int _trangThai;

}