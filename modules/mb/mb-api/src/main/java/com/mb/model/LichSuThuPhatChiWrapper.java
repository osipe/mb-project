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
 * This class is a wrapper for {@link LichSuThuPhatChi}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LichSuThuPhatChi
 * @generated
 */
@ProviderType
public class LichSuThuPhatChiWrapper
	implements LichSuThuPhatChi, ModelWrapper<LichSuThuPhatChi> {

	public LichSuThuPhatChiWrapper(LichSuThuPhatChi lichSuThuPhatChi) {
		_lichSuThuPhatChi = lichSuThuPhatChi;
	}

	@Override
	public Class<?> getModelClass() {
		return LichSuThuPhatChi.class;
	}

	@Override
	public String getModelClassName() {
		return LichSuThuPhatChi.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("lichSuThuPhatChiId", getLichSuThuPhatChiId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("chiNhanhId", getChiNhanhId());
		attributes.put("phatVayId", getPhatVayId());
		attributes.put("maCTV", getMaCTV());
		attributes.put("soTien", getSoTien());
		attributes.put("tongSoTienVonTra", getTongSoTienVonTra());
		attributes.put("tongSoTienLaiTra", getTongSoTienLaiTra());
		attributes.put("soLanThuDaThuTruoc", getSoLanThuDaThuTruoc());
		attributes.put("soLanThu", getSoLanThu());
		attributes.put("soLanThuDaThu", getSoLanThuDaThu());
		attributes.put("ngayDaThuCuoiTruoc", getNgayDaThuCuoiTruoc());
		attributes.put("ngayXuLy", getNgayXuLy());
		attributes.put("loai", getLoai());
		attributes.put("trangThaiPhatVayHienTai", getTrangThaiPhatVayHienTai());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long lichSuThuPhatChiId = (Long)attributes.get("lichSuThuPhatChiId");

		if (lichSuThuPhatChiId != null) {
			setLichSuThuPhatChiId(lichSuThuPhatChiId);
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

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long chiNhanhId = (Long)attributes.get("chiNhanhId");

		if (chiNhanhId != null) {
			setChiNhanhId(chiNhanhId);
		}

		Long phatVayId = (Long)attributes.get("phatVayId");

		if (phatVayId != null) {
			setPhatVayId(phatVayId);
		}

		String maCTV = (String)attributes.get("maCTV");

		if (maCTV != null) {
			setMaCTV(maCTV);
		}

		Double soTien = (Double)attributes.get("soTien");

		if (soTien != null) {
			setSoTien(soTien);
		}

		Double tongSoTienVonTra = (Double)attributes.get("tongSoTienVonTra");

		if (tongSoTienVonTra != null) {
			setTongSoTienVonTra(tongSoTienVonTra);
		}

		Double tongSoTienLaiTra = (Double)attributes.get("tongSoTienLaiTra");

		if (tongSoTienLaiTra != null) {
			setTongSoTienLaiTra(tongSoTienLaiTra);
		}

		Integer soLanThuDaThuTruoc = (Integer)attributes.get(
			"soLanThuDaThuTruoc");

		if (soLanThuDaThuTruoc != null) {
			setSoLanThuDaThuTruoc(soLanThuDaThuTruoc);
		}

		Integer soLanThu = (Integer)attributes.get("soLanThu");

		if (soLanThu != null) {
			setSoLanThu(soLanThu);
		}

		Integer soLanThuDaThu = (Integer)attributes.get("soLanThuDaThu");

		if (soLanThuDaThu != null) {
			setSoLanThuDaThu(soLanThuDaThu);
		}

		Date ngayDaThuCuoiTruoc = (Date)attributes.get("ngayDaThuCuoiTruoc");

		if (ngayDaThuCuoiTruoc != null) {
			setNgayDaThuCuoiTruoc(ngayDaThuCuoiTruoc);
		}

		Date ngayXuLy = (Date)attributes.get("ngayXuLy");

		if (ngayXuLy != null) {
			setNgayXuLy(ngayXuLy);
		}

		Integer loai = (Integer)attributes.get("loai");

		if (loai != null) {
			setLoai(loai);
		}

		Integer trangThaiPhatVayHienTai = (Integer)attributes.get(
			"trangThaiPhatVayHienTai");

		if (trangThaiPhatVayHienTai != null) {
			setTrangThaiPhatVayHienTai(trangThaiPhatVayHienTai);
		}
	}

	@Override
	public Object clone() {
		return new LichSuThuPhatChiWrapper(
			(LichSuThuPhatChi)_lichSuThuPhatChi.clone());
	}

	@Override
	public int compareTo(LichSuThuPhatChi lichSuThuPhatChi) {
		return _lichSuThuPhatChi.compareTo(lichSuThuPhatChi);
	}

	/**
	 * Returns the chi nhanh ID of this lich su thu phat chi.
	 *
	 * @return the chi nhanh ID of this lich su thu phat chi
	 */
	@Override
	public long getChiNhanhId() {
		return _lichSuThuPhatChi.getChiNhanhId();
	}

	/**
	 * Returns the company ID of this lich su thu phat chi.
	 *
	 * @return the company ID of this lich su thu phat chi
	 */
	@Override
	public long getCompanyId() {
		return _lichSuThuPhatChi.getCompanyId();
	}

	/**
	 * Returns the create date of this lich su thu phat chi.
	 *
	 * @return the create date of this lich su thu phat chi
	 */
	@Override
	public Date getCreateDate() {
		return _lichSuThuPhatChi.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _lichSuThuPhatChi.getExpandoBridge();
	}

	/**
	 * Returns the group ID of this lich su thu phat chi.
	 *
	 * @return the group ID of this lich su thu phat chi
	 */
	@Override
	public long getGroupId() {
		return _lichSuThuPhatChi.getGroupId();
	}

	/**
	 * Returns the lich su thu phat chi ID of this lich su thu phat chi.
	 *
	 * @return the lich su thu phat chi ID of this lich su thu phat chi
	 */
	@Override
	public long getLichSuThuPhatChiId() {
		return _lichSuThuPhatChi.getLichSuThuPhatChiId();
	}

	/**
	 * Returns the loai of this lich su thu phat chi.
	 *
	 * @return the loai of this lich su thu phat chi
	 */
	@Override
	public int getLoai() {
		return _lichSuThuPhatChi.getLoai();
	}

	/**
	 * Returns the ma ctv of this lich su thu phat chi.
	 *
	 * @return the ma ctv of this lich su thu phat chi
	 */
	@Override
	public String getMaCTV() {
		return _lichSuThuPhatChi.getMaCTV();
	}

	/**
	 * Returns the modified date of this lich su thu phat chi.
	 *
	 * @return the modified date of this lich su thu phat chi
	 */
	@Override
	public Date getModifiedDate() {
		return _lichSuThuPhatChi.getModifiedDate();
	}

	/**
	 * Returns the ngay da thu cuoi truoc of this lich su thu phat chi.
	 *
	 * @return the ngay da thu cuoi truoc of this lich su thu phat chi
	 */
	@Override
	public Date getNgayDaThuCuoiTruoc() {
		return _lichSuThuPhatChi.getNgayDaThuCuoiTruoc();
	}

	/**
	 * Returns the ngay xu ly of this lich su thu phat chi.
	 *
	 * @return the ngay xu ly of this lich su thu phat chi
	 */
	@Override
	public Date getNgayXuLy() {
		return _lichSuThuPhatChi.getNgayXuLy();
	}

	/**
	 * Returns the phat vay ID of this lich su thu phat chi.
	 *
	 * @return the phat vay ID of this lich su thu phat chi
	 */
	@Override
	public long getPhatVayId() {
		return _lichSuThuPhatChi.getPhatVayId();
	}

	/**
	 * Returns the primary key of this lich su thu phat chi.
	 *
	 * @return the primary key of this lich su thu phat chi
	 */
	@Override
	public long getPrimaryKey() {
		return _lichSuThuPhatChi.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _lichSuThuPhatChi.getPrimaryKeyObj();
	}

	/**
	 * Returns the so lan thu of this lich su thu phat chi.
	 *
	 * @return the so lan thu of this lich su thu phat chi
	 */
	@Override
	public int getSoLanThu() {
		return _lichSuThuPhatChi.getSoLanThu();
	}

	/**
	 * Returns the so lan thu da thu of this lich su thu phat chi.
	 *
	 * @return the so lan thu da thu of this lich su thu phat chi
	 */
	@Override
	public int getSoLanThuDaThu() {
		return _lichSuThuPhatChi.getSoLanThuDaThu();
	}

	/**
	 * Returns the so lan thu da thu truoc of this lich su thu phat chi.
	 *
	 * @return the so lan thu da thu truoc of this lich su thu phat chi
	 */
	@Override
	public int getSoLanThuDaThuTruoc() {
		return _lichSuThuPhatChi.getSoLanThuDaThuTruoc();
	}

	/**
	 * Returns the so tien of this lich su thu phat chi.
	 *
	 * @return the so tien of this lich su thu phat chi
	 */
	@Override
	public Double getSoTien() {
		return _lichSuThuPhatChi.getSoTien();
	}

	/**
	 * Returns the tong so tien lai tra of this lich su thu phat chi.
	 *
	 * @return the tong so tien lai tra of this lich su thu phat chi
	 */
	@Override
	public Double getTongSoTienLaiTra() {
		return _lichSuThuPhatChi.getTongSoTienLaiTra();
	}

	/**
	 * Returns the tong so tien von tra of this lich su thu phat chi.
	 *
	 * @return the tong so tien von tra of this lich su thu phat chi
	 */
	@Override
	public Double getTongSoTienVonTra() {
		return _lichSuThuPhatChi.getTongSoTienVonTra();
	}

	/**
	 * Returns the trang thai phat vay hien tai of this lich su thu phat chi.
	 *
	 * @return the trang thai phat vay hien tai of this lich su thu phat chi
	 */
	@Override
	public int getTrangThaiPhatVayHienTai() {
		return _lichSuThuPhatChi.getTrangThaiPhatVayHienTai();
	}

	/**
	 * Returns the user ID of this lich su thu phat chi.
	 *
	 * @return the user ID of this lich su thu phat chi
	 */
	@Override
	public long getUserId() {
		return _lichSuThuPhatChi.getUserId();
	}

	/**
	 * Returns the user name of this lich su thu phat chi.
	 *
	 * @return the user name of this lich su thu phat chi
	 */
	@Override
	public String getUserName() {
		return _lichSuThuPhatChi.getUserName();
	}

	/**
	 * Returns the user uuid of this lich su thu phat chi.
	 *
	 * @return the user uuid of this lich su thu phat chi
	 */
	@Override
	public String getUserUuid() {
		return _lichSuThuPhatChi.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _lichSuThuPhatChi.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _lichSuThuPhatChi.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _lichSuThuPhatChi.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _lichSuThuPhatChi.isNew();
	}

	@Override
	public void persist() {
		_lichSuThuPhatChi.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_lichSuThuPhatChi.setCachedModel(cachedModel);
	}

	/**
	 * Sets the chi nhanh ID of this lich su thu phat chi.
	 *
	 * @param chiNhanhId the chi nhanh ID of this lich su thu phat chi
	 */
	@Override
	public void setChiNhanhId(long chiNhanhId) {
		_lichSuThuPhatChi.setChiNhanhId(chiNhanhId);
	}

	/**
	 * Sets the company ID of this lich su thu phat chi.
	 *
	 * @param companyId the company ID of this lich su thu phat chi
	 */
	@Override
	public void setCompanyId(long companyId) {
		_lichSuThuPhatChi.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this lich su thu phat chi.
	 *
	 * @param createDate the create date of this lich su thu phat chi
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_lichSuThuPhatChi.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_lichSuThuPhatChi.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_lichSuThuPhatChi.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_lichSuThuPhatChi.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the group ID of this lich su thu phat chi.
	 *
	 * @param groupId the group ID of this lich su thu phat chi
	 */
	@Override
	public void setGroupId(long groupId) {
		_lichSuThuPhatChi.setGroupId(groupId);
	}

	/**
	 * Sets the lich su thu phat chi ID of this lich su thu phat chi.
	 *
	 * @param lichSuThuPhatChiId the lich su thu phat chi ID of this lich su thu phat chi
	 */
	@Override
	public void setLichSuThuPhatChiId(long lichSuThuPhatChiId) {
		_lichSuThuPhatChi.setLichSuThuPhatChiId(lichSuThuPhatChiId);
	}

	/**
	 * Sets the loai of this lich su thu phat chi.
	 *
	 * @param loai the loai of this lich su thu phat chi
	 */
	@Override
	public void setLoai(int loai) {
		_lichSuThuPhatChi.setLoai(loai);
	}

	/**
	 * Sets the ma ctv of this lich su thu phat chi.
	 *
	 * @param maCTV the ma ctv of this lich su thu phat chi
	 */
	@Override
	public void setMaCTV(String maCTV) {
		_lichSuThuPhatChi.setMaCTV(maCTV);
	}

	/**
	 * Sets the modified date of this lich su thu phat chi.
	 *
	 * @param modifiedDate the modified date of this lich su thu phat chi
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_lichSuThuPhatChi.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_lichSuThuPhatChi.setNew(n);
	}

	/**
	 * Sets the ngay da thu cuoi truoc of this lich su thu phat chi.
	 *
	 * @param ngayDaThuCuoiTruoc the ngay da thu cuoi truoc of this lich su thu phat chi
	 */
	@Override
	public void setNgayDaThuCuoiTruoc(Date ngayDaThuCuoiTruoc) {
		_lichSuThuPhatChi.setNgayDaThuCuoiTruoc(ngayDaThuCuoiTruoc);
	}

	/**
	 * Sets the ngay xu ly of this lich su thu phat chi.
	 *
	 * @param ngayXuLy the ngay xu ly of this lich su thu phat chi
	 */
	@Override
	public void setNgayXuLy(Date ngayXuLy) {
		_lichSuThuPhatChi.setNgayXuLy(ngayXuLy);
	}

	/**
	 * Sets the phat vay ID of this lich su thu phat chi.
	 *
	 * @param phatVayId the phat vay ID of this lich su thu phat chi
	 */
	@Override
	public void setPhatVayId(long phatVayId) {
		_lichSuThuPhatChi.setPhatVayId(phatVayId);
	}

	/**
	 * Sets the primary key of this lich su thu phat chi.
	 *
	 * @param primaryKey the primary key of this lich su thu phat chi
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_lichSuThuPhatChi.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_lichSuThuPhatChi.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the so lan thu of this lich su thu phat chi.
	 *
	 * @param soLanThu the so lan thu of this lich su thu phat chi
	 */
	@Override
	public void setSoLanThu(int soLanThu) {
		_lichSuThuPhatChi.setSoLanThu(soLanThu);
	}

	/**
	 * Sets the so lan thu da thu of this lich su thu phat chi.
	 *
	 * @param soLanThuDaThu the so lan thu da thu of this lich su thu phat chi
	 */
	@Override
	public void setSoLanThuDaThu(int soLanThuDaThu) {
		_lichSuThuPhatChi.setSoLanThuDaThu(soLanThuDaThu);
	}

	/**
	 * Sets the so lan thu da thu truoc of this lich su thu phat chi.
	 *
	 * @param soLanThuDaThuTruoc the so lan thu da thu truoc of this lich su thu phat chi
	 */
	@Override
	public void setSoLanThuDaThuTruoc(int soLanThuDaThuTruoc) {
		_lichSuThuPhatChi.setSoLanThuDaThuTruoc(soLanThuDaThuTruoc);
	}

	/**
	 * Sets the so tien of this lich su thu phat chi.
	 *
	 * @param soTien the so tien of this lich su thu phat chi
	 */
	@Override
	public void setSoTien(Double soTien) {
		_lichSuThuPhatChi.setSoTien(soTien);
	}

	/**
	 * Sets the tong so tien lai tra of this lich su thu phat chi.
	 *
	 * @param tongSoTienLaiTra the tong so tien lai tra of this lich su thu phat chi
	 */
	@Override
	public void setTongSoTienLaiTra(Double tongSoTienLaiTra) {
		_lichSuThuPhatChi.setTongSoTienLaiTra(tongSoTienLaiTra);
	}

	/**
	 * Sets the tong so tien von tra of this lich su thu phat chi.
	 *
	 * @param tongSoTienVonTra the tong so tien von tra of this lich su thu phat chi
	 */
	@Override
	public void setTongSoTienVonTra(Double tongSoTienVonTra) {
		_lichSuThuPhatChi.setTongSoTienVonTra(tongSoTienVonTra);
	}

	/**
	 * Sets the trang thai phat vay hien tai of this lich su thu phat chi.
	 *
	 * @param trangThaiPhatVayHienTai the trang thai phat vay hien tai of this lich su thu phat chi
	 */
	@Override
	public void setTrangThaiPhatVayHienTai(int trangThaiPhatVayHienTai) {
		_lichSuThuPhatChi.setTrangThaiPhatVayHienTai(trangThaiPhatVayHienTai);
	}

	/**
	 * Sets the user ID of this lich su thu phat chi.
	 *
	 * @param userId the user ID of this lich su thu phat chi
	 */
	@Override
	public void setUserId(long userId) {
		_lichSuThuPhatChi.setUserId(userId);
	}

	/**
	 * Sets the user name of this lich su thu phat chi.
	 *
	 * @param userName the user name of this lich su thu phat chi
	 */
	@Override
	public void setUserName(String userName) {
		_lichSuThuPhatChi.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this lich su thu phat chi.
	 *
	 * @param userUuid the user uuid of this lich su thu phat chi
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_lichSuThuPhatChi.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<LichSuThuPhatChi>
		toCacheModel() {

		return _lichSuThuPhatChi.toCacheModel();
	}

	@Override
	public LichSuThuPhatChi toEscapedModel() {
		return new LichSuThuPhatChiWrapper(_lichSuThuPhatChi.toEscapedModel());
	}

	@Override
	public String toString() {
		return _lichSuThuPhatChi.toString();
	}

	@Override
	public LichSuThuPhatChi toUnescapedModel() {
		return new LichSuThuPhatChiWrapper(
			_lichSuThuPhatChi.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _lichSuThuPhatChi.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LichSuThuPhatChiWrapper)) {
			return false;
		}

		LichSuThuPhatChiWrapper lichSuThuPhatChiWrapper =
			(LichSuThuPhatChiWrapper)obj;

		if (Objects.equals(
				_lichSuThuPhatChi, lichSuThuPhatChiWrapper._lichSuThuPhatChi)) {

			return true;
		}

		return false;
	}

	@Override
	public LichSuThuPhatChi getWrappedModel() {
		return _lichSuThuPhatChi;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _lichSuThuPhatChi.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _lichSuThuPhatChi.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_lichSuThuPhatChi.resetOriginalValues();
	}

	private final LichSuThuPhatChi _lichSuThuPhatChi;

}