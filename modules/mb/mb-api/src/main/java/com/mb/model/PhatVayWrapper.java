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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link PhatVay}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PhatVay
 * @generated
 */
@ProviderType
public class PhatVayWrapper implements PhatVay, ModelWrapper<PhatVay> {

	public PhatVayWrapper(PhatVay phatVay) {
		_phatVay = phatVay;
	}

	@Override
	public Class<?> getModelClass() {
		return PhatVay.class;
	}

	@Override
	public String getModelClassName() {
		return PhatVay.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("phatVayId", getPhatVayId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("ngayTao", getNgayTao());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("maCTV", getMaCTV());
		attributes.put("maKhachHang", getMaKhachHang());
		attributes.put("soKU", getSoKU());
		attributes.put("createDate", getCreateDate());
		attributes.put("ngayBatDau", getNgayBatDau());
		attributes.put("ngayKetThuc", getNgayKetThuc());
		attributes.put("loaiPhatVay", getLoaiPhatVay());
		attributes.put("soLanDaThu", getSoLanDaThu());
		attributes.put("ngayDaThuCuoi", getNgayDaThuCuoi());
		attributes.put("soTienVay", getSoTienVay());
		attributes.put("thoiHan", getThoiHan());
		attributes.put("laiSuatVay", getLaiSuatVay());
		attributes.put("gocNgay", getGocNgay());
		attributes.put("laiNgay", getLaiNgay());
		attributes.put("gocNgayCuoi", getGocNgayCuoi());
		attributes.put("soNgayThuTruoc", getSoNgayThuTruoc());
		attributes.put("ngayThuTruocTu", getNgayThuTruocTu());
		attributes.put("ngayThuTruocDen", getNgayThuTruocDen());
		attributes.put("ngayTatToan", getNgayTatToan());
		attributes.put("trangThai", getTrangThai());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long phatVayId = (Long)attributes.get("phatVayId");

		if (phatVayId != null) {
			setPhatVayId(phatVayId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date ngayTao = (Date)attributes.get("ngayTao");

		if (ngayTao != null) {
			setNgayTao(ngayTao);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String maCTV = (String)attributes.get("maCTV");

		if (maCTV != null) {
			setMaCTV(maCTV);
		}

		String maKhachHang = (String)attributes.get("maKhachHang");

		if (maKhachHang != null) {
			setMaKhachHang(maKhachHang);
		}

		String soKU = (String)attributes.get("soKU");

		if (soKU != null) {
			setSoKU(soKU);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date ngayBatDau = (Date)attributes.get("ngayBatDau");

		if (ngayBatDau != null) {
			setNgayBatDau(ngayBatDau);
		}

		Date ngayKetThuc = (Date)attributes.get("ngayKetThuc");

		if (ngayKetThuc != null) {
			setNgayKetThuc(ngayKetThuc);
		}

		Integer loaiPhatVay = (Integer)attributes.get("loaiPhatVay");

		if (loaiPhatVay != null) {
			setLoaiPhatVay(loaiPhatVay);
		}

		Integer soLanDaThu = (Integer)attributes.get("soLanDaThu");

		if (soLanDaThu != null) {
			setSoLanDaThu(soLanDaThu);
		}

		Date ngayDaThuCuoi = (Date)attributes.get("ngayDaThuCuoi");

		if (ngayDaThuCuoi != null) {
			setNgayDaThuCuoi(ngayDaThuCuoi);
		}

		Double soTienVay = (Double)attributes.get("soTienVay");

		if (soTienVay != null) {
			setSoTienVay(soTienVay);
		}

		Integer thoiHan = (Integer)attributes.get("thoiHan");

		if (thoiHan != null) {
			setThoiHan(thoiHan);
		}

		Double laiSuatVay = (Double)attributes.get("laiSuatVay");

		if (laiSuatVay != null) {
			setLaiSuatVay(laiSuatVay);
		}

		Double gocNgay = (Double)attributes.get("gocNgay");

		if (gocNgay != null) {
			setGocNgay(gocNgay);
		}

		Double laiNgay = (Double)attributes.get("laiNgay");

		if (laiNgay != null) {
			setLaiNgay(laiNgay);
		}

		Double gocNgayCuoi = (Double)attributes.get("gocNgayCuoi");

		if (gocNgayCuoi != null) {
			setGocNgayCuoi(gocNgayCuoi);
		}

		Integer soNgayThuTruoc = (Integer)attributes.get("soNgayThuTruoc");

		if (soNgayThuTruoc != null) {
			setSoNgayThuTruoc(soNgayThuTruoc);
		}

		Date ngayThuTruocTu = (Date)attributes.get("ngayThuTruocTu");

		if (ngayThuTruocTu != null) {
			setNgayThuTruocTu(ngayThuTruocTu);
		}

		Date ngayThuTruocDen = (Date)attributes.get("ngayThuTruocDen");

		if (ngayThuTruocDen != null) {
			setNgayThuTruocDen(ngayThuTruocDen);
		}

		Date ngayTatToan = (Date)attributes.get("ngayTatToan");

		if (ngayTatToan != null) {
			setNgayTatToan(ngayTatToan);
		}

		Integer trangThai = (Integer)attributes.get("trangThai");

		if (trangThai != null) {
			setTrangThai(trangThai);
		}
	}

	@Override
	public Object clone() {
		return new PhatVayWrapper((PhatVay)_phatVay.clone());
	}

	@Override
	public int compareTo(PhatVay phatVay) {
		return _phatVay.compareTo(phatVay);
	}

	/**
	 * Returns the company ID of this phat vay.
	 *
	 * @return the company ID of this phat vay
	 */
	@Override
	public long getCompanyId() {
		return _phatVay.getCompanyId();
	}

	@Override
	public CongTacVien getCongTacVien() {
		return _phatVay.getCongTacVien();
	}

	/**
	 * Returns the create date of this phat vay.
	 *
	 * @return the create date of this phat vay
	 */
	@Override
	public Date getCreateDate() {
		return _phatVay.getCreateDate();
	}

	@Override
	public Double getDuNoGoc() {
		return _phatVay.getDuNoGoc();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _phatVay.getExpandoBridge();
	}

	/**
	 * Returns the goc ngay of this phat vay.
	 *
	 * @return the goc ngay of this phat vay
	 */
	@Override
	public Double getGocNgay() {
		return _phatVay.getGocNgay();
	}

	/**
	 * Returns the goc ngay cuoi of this phat vay.
	 *
	 * @return the goc ngay cuoi of this phat vay
	 */
	@Override
	public Double getGocNgayCuoi() {
		return _phatVay.getGocNgayCuoi();
	}

	/**
	 * Returns the group ID of this phat vay.
	 *
	 * @return the group ID of this phat vay
	 */
	@Override
	public long getGroupId() {
		return _phatVay.getGroupId();
	}

	@Override
	public KhachHang getKhachHang() {
		return _phatVay.getKhachHang();
	}

	/**
	 * Returns the lai ngay of this phat vay.
	 *
	 * @return the lai ngay of this phat vay
	 */
	@Override
	public Double getLaiNgay() {
		return _phatVay.getLaiNgay();
	}

	/**
	 * Returns the lai suat vay of this phat vay.
	 *
	 * @return the lai suat vay of this phat vay
	 */
	@Override
	public Double getLaiSuatVay() {
		return _phatVay.getLaiSuatVay();
	}

	/**
	 * Returns the loai phat vay of this phat vay.
	 *
	 * @return the loai phat vay of this phat vay
	 */
	@Override
	public int getLoaiPhatVay() {
		return _phatVay.getLoaiPhatVay();
	}

	/**
	 * Returns the ma ctv of this phat vay.
	 *
	 * @return the ma ctv of this phat vay
	 */
	@Override
	public String getMaCTV() {
		return _phatVay.getMaCTV();
	}

	/**
	 * Returns the ma khach hang of this phat vay.
	 *
	 * @return the ma khach hang of this phat vay
	 */
	@Override
	public String getMaKhachHang() {
		return _phatVay.getMaKhachHang();
	}

	/**
	 * Returns the modified date of this phat vay.
	 *
	 * @return the modified date of this phat vay
	 */
	@Override
	public Date getModifiedDate() {
		return _phatVay.getModifiedDate();
	}

	/**
	 * Returns the ngay bat dau of this phat vay.
	 *
	 * @return the ngay bat dau of this phat vay
	 */
	@Override
	public Date getNgayBatDau() {
		return _phatVay.getNgayBatDau();
	}

	/**
	 * Returns the ngay da thu cuoi of this phat vay.
	 *
	 * @return the ngay da thu cuoi of this phat vay
	 */
	@Override
	public Date getNgayDaThuCuoi() {
		return _phatVay.getNgayDaThuCuoi();
	}

	/**
	 * Returns the ngay ket thuc of this phat vay.
	 *
	 * @return the ngay ket thuc of this phat vay
	 */
	@Override
	public Date getNgayKetThuc() {
		return _phatVay.getNgayKetThuc();
	}

	/**
	 * Returns the ngay tao of this phat vay.
	 *
	 * @return the ngay tao of this phat vay
	 */
	@Override
	public Date getNgayTao() {
		return _phatVay.getNgayTao();
	}

	/**
	 * Returns the ngay tat toan of this phat vay.
	 *
	 * @return the ngay tat toan of this phat vay
	 */
	@Override
	public Date getNgayTatToan() {
		return _phatVay.getNgayTatToan();
	}

	/**
	 * Returns the ngay thu truoc den of this phat vay.
	 *
	 * @return the ngay thu truoc den of this phat vay
	 */
	@Override
	public Date getNgayThuTruocDen() {
		return _phatVay.getNgayThuTruocDen();
	}

	/**
	 * Returns the ngay thu truoc tu of this phat vay.
	 *
	 * @return the ngay thu truoc tu of this phat vay
	 */
	@Override
	public Date getNgayThuTruocTu() {
		return _phatVay.getNgayThuTruocTu();
	}

	/**
	 * Returns the phat vay ID of this phat vay.
	 *
	 * @return the phat vay ID of this phat vay
	 */
	@Override
	public long getPhatVayId() {
		return _phatVay.getPhatVayId();
	}

	/**
	 * Returns the primary key of this phat vay.
	 *
	 * @return the primary key of this phat vay
	 */
	@Override
	public long getPrimaryKey() {
		return _phatVay.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _phatVay.getPrimaryKeyObj();
	}

	/**
	 * Returns the so ku of this phat vay.
	 *
	 * @return the so ku of this phat vay
	 */
	@Override
	public String getSoKU() {
		return _phatVay.getSoKU();
	}

	/**
	 * Returns the so lan da thu of this phat vay.
	 *
	 * @return the so lan da thu of this phat vay
	 */
	@Override
	public int getSoLanDaThu() {
		return _phatVay.getSoLanDaThu();
	}

	/**
	 * Returns the so ngay thu truoc of this phat vay.
	 *
	 * @return the so ngay thu truoc of this phat vay
	 */
	@Override
	public int getSoNgayThuTruoc() {
		return _phatVay.getSoNgayThuTruoc();
	}

	@Override
	public Double getSoTienThuNgay() {
		return _phatVay.getSoTienThuNgay();
	}

	/**
	 * Returns the so tien vay of this phat vay.
	 *
	 * @return the so tien vay of this phat vay
	 */
	@Override
	public Double getSoTienVay() {
		return _phatVay.getSoTienVay();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray
		getTaiSanThueChapJSONArray() {

		return _phatVay.getTaiSanThueChapJSONArray();
	}

	/**
	 * Returns the thoi han of this phat vay.
	 *
	 * @return the thoi han of this phat vay
	 */
	@Override
	public int getThoiHan() {
		return _phatVay.getThoiHan();
	}

	/**
	 * Returns the trang thai of this phat vay.
	 *
	 * @return the trang thai of this phat vay
	 */
	@Override
	public int getTrangThai() {
		return _phatVay.getTrangThai();
	}

	/**
	 * Returns the user ID of this phat vay.
	 *
	 * @return the user ID of this phat vay
	 */
	@Override
	public long getUserId() {
		return _phatVay.getUserId();
	}

	/**
	 * Returns the user name of this phat vay.
	 *
	 * @return the user name of this phat vay
	 */
	@Override
	public String getUserName() {
		return _phatVay.getUserName();
	}

	/**
	 * Returns the user uuid of this phat vay.
	 *
	 * @return the user uuid of this phat vay
	 */
	@Override
	public String getUserUuid() {
		return _phatVay.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _phatVay.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _phatVay.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _phatVay.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _phatVay.isNew();
	}

	@Override
	public void persist() {
		_phatVay.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_phatVay.setCachedModel(cachedModel);
	}

	/**
	 * Sets the company ID of this phat vay.
	 *
	 * @param companyId the company ID of this phat vay
	 */
	@Override
	public void setCompanyId(long companyId) {
		_phatVay.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this phat vay.
	 *
	 * @param createDate the create date of this phat vay
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_phatVay.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_phatVay.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_phatVay.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_phatVay.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the goc ngay of this phat vay.
	 *
	 * @param gocNgay the goc ngay of this phat vay
	 */
	@Override
	public void setGocNgay(Double gocNgay) {
		_phatVay.setGocNgay(gocNgay);
	}

	/**
	 * Sets the goc ngay cuoi of this phat vay.
	 *
	 * @param gocNgayCuoi the goc ngay cuoi of this phat vay
	 */
	@Override
	public void setGocNgayCuoi(Double gocNgayCuoi) {
		_phatVay.setGocNgayCuoi(gocNgayCuoi);
	}

	/**
	 * Sets the group ID of this phat vay.
	 *
	 * @param groupId the group ID of this phat vay
	 */
	@Override
	public void setGroupId(long groupId) {
		_phatVay.setGroupId(groupId);
	}

	/**
	 * Sets the lai ngay of this phat vay.
	 *
	 * @param laiNgay the lai ngay of this phat vay
	 */
	@Override
	public void setLaiNgay(Double laiNgay) {
		_phatVay.setLaiNgay(laiNgay);
	}

	/**
	 * Sets the lai suat vay of this phat vay.
	 *
	 * @param laiSuatVay the lai suat vay of this phat vay
	 */
	@Override
	public void setLaiSuatVay(Double laiSuatVay) {
		_phatVay.setLaiSuatVay(laiSuatVay);
	}

	/**
	 * Sets the loai phat vay of this phat vay.
	 *
	 * @param loaiPhatVay the loai phat vay of this phat vay
	 */
	@Override
	public void setLoaiPhatVay(int loaiPhatVay) {
		_phatVay.setLoaiPhatVay(loaiPhatVay);
	}

	/**
	 * Sets the ma ctv of this phat vay.
	 *
	 * @param maCTV the ma ctv of this phat vay
	 */
	@Override
	public void setMaCTV(String maCTV) {
		_phatVay.setMaCTV(maCTV);
	}

	/**
	 * Sets the ma khach hang of this phat vay.
	 *
	 * @param maKhachHang the ma khach hang of this phat vay
	 */
	@Override
	public void setMaKhachHang(String maKhachHang) {
		_phatVay.setMaKhachHang(maKhachHang);
	}

	/**
	 * Sets the modified date of this phat vay.
	 *
	 * @param modifiedDate the modified date of this phat vay
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_phatVay.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_phatVay.setNew(n);
	}

	/**
	 * Sets the ngay bat dau of this phat vay.
	 *
	 * @param ngayBatDau the ngay bat dau of this phat vay
	 */
	@Override
	public void setNgayBatDau(Date ngayBatDau) {
		_phatVay.setNgayBatDau(ngayBatDau);
	}

	/**
	 * Sets the ngay da thu cuoi of this phat vay.
	 *
	 * @param ngayDaThuCuoi the ngay da thu cuoi of this phat vay
	 */
	@Override
	public void setNgayDaThuCuoi(Date ngayDaThuCuoi) {
		_phatVay.setNgayDaThuCuoi(ngayDaThuCuoi);
	}

	/**
	 * Sets the ngay ket thuc of this phat vay.
	 *
	 * @param ngayKetThuc the ngay ket thuc of this phat vay
	 */
	@Override
	public void setNgayKetThuc(Date ngayKetThuc) {
		_phatVay.setNgayKetThuc(ngayKetThuc);
	}

	/**
	 * Sets the ngay tao of this phat vay.
	 *
	 * @param ngayTao the ngay tao of this phat vay
	 */
	@Override
	public void setNgayTao(Date ngayTao) {
		_phatVay.setNgayTao(ngayTao);
	}

	/**
	 * Sets the ngay tat toan of this phat vay.
	 *
	 * @param ngayTatToan the ngay tat toan of this phat vay
	 */
	@Override
	public void setNgayTatToan(Date ngayTatToan) {
		_phatVay.setNgayTatToan(ngayTatToan);
	}

	/**
	 * Sets the ngay thu truoc den of this phat vay.
	 *
	 * @param ngayThuTruocDen the ngay thu truoc den of this phat vay
	 */
	@Override
	public void setNgayThuTruocDen(Date ngayThuTruocDen) {
		_phatVay.setNgayThuTruocDen(ngayThuTruocDen);
	}

	/**
	 * Sets the ngay thu truoc tu of this phat vay.
	 *
	 * @param ngayThuTruocTu the ngay thu truoc tu of this phat vay
	 */
	@Override
	public void setNgayThuTruocTu(Date ngayThuTruocTu) {
		_phatVay.setNgayThuTruocTu(ngayThuTruocTu);
	}

	/**
	 * Sets the phat vay ID of this phat vay.
	 *
	 * @param phatVayId the phat vay ID of this phat vay
	 */
	@Override
	public void setPhatVayId(long phatVayId) {
		_phatVay.setPhatVayId(phatVayId);
	}

	/**
	 * Sets the primary key of this phat vay.
	 *
	 * @param primaryKey the primary key of this phat vay
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_phatVay.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_phatVay.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the so ku of this phat vay.
	 *
	 * @param soKU the so ku of this phat vay
	 */
	@Override
	public void setSoKU(String soKU) {
		_phatVay.setSoKU(soKU);
	}

	/**
	 * Sets the so lan da thu of this phat vay.
	 *
	 * @param soLanDaThu the so lan da thu of this phat vay
	 */
	@Override
	public void setSoLanDaThu(int soLanDaThu) {
		_phatVay.setSoLanDaThu(soLanDaThu);
	}

	/**
	 * Sets the so ngay thu truoc of this phat vay.
	 *
	 * @param soNgayThuTruoc the so ngay thu truoc of this phat vay
	 */
	@Override
	public void setSoNgayThuTruoc(int soNgayThuTruoc) {
		_phatVay.setSoNgayThuTruoc(soNgayThuTruoc);
	}

	/**
	 * Sets the so tien vay of this phat vay.
	 *
	 * @param soTienVay the so tien vay of this phat vay
	 */
	@Override
	public void setSoTienVay(Double soTienVay) {
		_phatVay.setSoTienVay(soTienVay);
	}

	@Override
	public void setTaiSanThueChapJSONArray(
		com.liferay.portal.kernel.json.JSONArray taiSanThueChapJSONArray) {

		_phatVay.setTaiSanThueChapJSONArray(taiSanThueChapJSONArray);
	}

	/**
	 * Sets the thoi han of this phat vay.
	 *
	 * @param thoiHan the thoi han of this phat vay
	 */
	@Override
	public void setThoiHan(int thoiHan) {
		_phatVay.setThoiHan(thoiHan);
	}

	/**
	 * Sets the trang thai of this phat vay.
	 *
	 * @param trangThai the trang thai of this phat vay
	 */
	@Override
	public void setTrangThai(int trangThai) {
		_phatVay.setTrangThai(trangThai);
	}

	/**
	 * Sets the user ID of this phat vay.
	 *
	 * @param userId the user ID of this phat vay
	 */
	@Override
	public void setUserId(long userId) {
		_phatVay.setUserId(userId);
	}

	/**
	 * Sets the user name of this phat vay.
	 *
	 * @param userName the user name of this phat vay
	 */
	@Override
	public void setUserName(String userName) {
		_phatVay.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this phat vay.
	 *
	 * @param userUuid the user uuid of this phat vay
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_phatVay.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<PhatVay> toCacheModel() {
		return _phatVay.toCacheModel();
	}

	@Override
	public PhatVay toEscapedModel() {
		return new PhatVayWrapper(_phatVay.toEscapedModel());
	}

	@Override
	public String toString() {
		return _phatVay.toString();
	}

	@Override
	public PhatVay toUnescapedModel() {
		return new PhatVayWrapper(_phatVay.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _phatVay.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PhatVayWrapper)) {
			return false;
		}

		PhatVayWrapper phatVayWrapper = (PhatVayWrapper)obj;

		if (Objects.equals(_phatVay, phatVayWrapper._phatVay)) {
			return true;
		}

		return false;
	}

	@Override
	public PhatVay getWrappedModel() {
		return _phatVay;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _phatVay.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _phatVay.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_phatVay.resetOriginalValues();
	}

	private final PhatVay _phatVay;

}