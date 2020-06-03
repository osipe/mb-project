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
 * This class is a wrapper for {@link Phieu}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Phieu
 * @generated
 */
@ProviderType
public class PhieuWrapper implements Phieu, ModelWrapper<Phieu> {

	public PhieuWrapper(Phieu phieu) {
		_phieu = phieu;
	}

	@Override
	public Class<?> getModelClass() {
		return Phieu.class;
	}

	@Override
	public String getModelClassName() {
		return Phieu.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("phieuId", getPhieuId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("maCTV", getMaCTV());
		attributes.put("hoTenCTV", getHoTenCTV());
		attributes.put("soHopDong", getSoHopDong());
		attributes.put("ngayChungTu", getNgayChungTu());
		attributes.put("diaChi", getDiaChi());
		attributes.put("soPhieu", getSoPhieu());
		attributes.put("ngayGhiSo", getNgayGhiSo());
		attributes.put("maMSThuChi", getMaMSThuChi());
		attributes.put("soTien", getSoTien());
		attributes.put("chungTuKemTheo", getChungTuKemTheo());
		attributes.put("loai", getLoai());
		attributes.put("hoatDong", getHoatDong());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long phieuId = (Long)attributes.get("phieuId");

		if (phieuId != null) {
			setPhieuId(phieuId);
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

		String maCTV = (String)attributes.get("maCTV");

		if (maCTV != null) {
			setMaCTV(maCTV);
		}

		String hoTenCTV = (String)attributes.get("hoTenCTV");

		if (hoTenCTV != null) {
			setHoTenCTV(hoTenCTV);
		}

		String soHopDong = (String)attributes.get("soHopDong");

		if (soHopDong != null) {
			setSoHopDong(soHopDong);
		}

		Date ngayChungTu = (Date)attributes.get("ngayChungTu");

		if (ngayChungTu != null) {
			setNgayChungTu(ngayChungTu);
		}

		String diaChi = (String)attributes.get("diaChi");

		if (diaChi != null) {
			setDiaChi(diaChi);
		}

		String soPhieu = (String)attributes.get("soPhieu");

		if (soPhieu != null) {
			setSoPhieu(soPhieu);
		}

		Date ngayGhiSo = (Date)attributes.get("ngayGhiSo");

		if (ngayGhiSo != null) {
			setNgayGhiSo(ngayGhiSo);
		}

		String maMSThuChi = (String)attributes.get("maMSThuChi");

		if (maMSThuChi != null) {
			setMaMSThuChi(maMSThuChi);
		}

		Double soTien = (Double)attributes.get("soTien");

		if (soTien != null) {
			setSoTien(soTien);
		}

		String chungTuKemTheo = (String)attributes.get("chungTuKemTheo");

		if (chungTuKemTheo != null) {
			setChungTuKemTheo(chungTuKemTheo);
		}

		Integer loai = (Integer)attributes.get("loai");

		if (loai != null) {
			setLoai(loai);
		}

		Boolean hoatDong = (Boolean)attributes.get("hoatDong");

		if (hoatDong != null) {
			setHoatDong(hoatDong);
		}
	}

	@Override
	public Object clone() {
		return new PhieuWrapper((Phieu)_phieu.clone());
	}

	@Override
	public int compareTo(Phieu phieu) {
		return _phieu.compareTo(phieu);
	}

	/**
	 * Returns the chung tu kem theo of this phieu.
	 *
	 * @return the chung tu kem theo of this phieu
	 */
	@Override
	public String getChungTuKemTheo() {
		return _phieu.getChungTuKemTheo();
	}

	/**
	 * Returns the company ID of this phieu.
	 *
	 * @return the company ID of this phieu
	 */
	@Override
	public long getCompanyId() {
		return _phieu.getCompanyId();
	}

	/**
	 * Returns the create date of this phieu.
	 *
	 * @return the create date of this phieu
	 */
	@Override
	public Date getCreateDate() {
		return _phieu.getCreateDate();
	}

	@Override
	public CongTacVien getCtv() {
		return _phieu.getCtv();
	}

	/**
	 * Returns the dia chi of this phieu.
	 *
	 * @return the dia chi of this phieu
	 */
	@Override
	public String getDiaChi() {
		return _phieu.getDiaChi();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray
		getDsPhieuTaiKhoanJSONArray() {

		return _phieu.getDsPhieuTaiKhoanJSONArray();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _phieu.getExpandoBridge();
	}

	/**
	 * Returns the group ID of this phieu.
	 *
	 * @return the group ID of this phieu
	 */
	@Override
	public long getGroupId() {
		return _phieu.getGroupId();
	}

	/**
	 * Returns the hoat dong of this phieu.
	 *
	 * @return the hoat dong of this phieu
	 */
	@Override
	public Boolean getHoatDong() {
		return _phieu.getHoatDong();
	}

	/**
	 * Returns the ho ten ctv of this phieu.
	 *
	 * @return the ho ten ctv of this phieu
	 */
	@Override
	public String getHoTenCTV() {
		return _phieu.getHoTenCTV();
	}

	/**
	 * Returns the loai of this phieu.
	 *
	 * @return the loai of this phieu
	 */
	@Override
	public int getLoai() {
		return _phieu.getLoai();
	}

	/**
	 * Returns the ma ctv of this phieu.
	 *
	 * @return the ma ctv of this phieu
	 */
	@Override
	public String getMaCTV() {
		return _phieu.getMaCTV();
	}

	/**
	 * Returns the ma ms thu chi of this phieu.
	 *
	 * @return the ma ms thu chi of this phieu
	 */
	@Override
	public String getMaMSThuChi() {
		return _phieu.getMaMSThuChi();
	}

	@Override
	public MaSoThuChi getMaSoThuChi() {
		return _phieu.getMaSoThuChi();
	}

	/**
	 * Returns the modified date of this phieu.
	 *
	 * @return the modified date of this phieu
	 */
	@Override
	public Date getModifiedDate() {
		return _phieu.getModifiedDate();
	}

	/**
	 * Returns the ngay chung tu of this phieu.
	 *
	 * @return the ngay chung tu of this phieu
	 */
	@Override
	public Date getNgayChungTu() {
		return _phieu.getNgayChungTu();
	}

	/**
	 * Returns the ngay ghi so of this phieu.
	 *
	 * @return the ngay ghi so of this phieu
	 */
	@Override
	public Date getNgayGhiSo() {
		return _phieu.getNgayGhiSo();
	}

	/**
	 * Returns the phieu ID of this phieu.
	 *
	 * @return the phieu ID of this phieu
	 */
	@Override
	public long getPhieuId() {
		return _phieu.getPhieuId();
	}

	/**
	 * Returns the primary key of this phieu.
	 *
	 * @return the primary key of this phieu
	 */
	@Override
	public long getPrimaryKey() {
		return _phieu.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _phieu.getPrimaryKeyObj();
	}

	/**
	 * Returns the so hop dong of this phieu.
	 *
	 * @return the so hop dong of this phieu
	 */
	@Override
	public String getSoHopDong() {
		return _phieu.getSoHopDong();
	}

	/**
	 * Returns the so phieu of this phieu.
	 *
	 * @return the so phieu of this phieu
	 */
	@Override
	public String getSoPhieu() {
		return _phieu.getSoPhieu();
	}

	/**
	 * Returns the so tien of this phieu.
	 *
	 * @return the so tien of this phieu
	 */
	@Override
	public Double getSoTien() {
		return _phieu.getSoTien();
	}

	/**
	 * Returns the user ID of this phieu.
	 *
	 * @return the user ID of this phieu
	 */
	@Override
	public long getUserId() {
		return _phieu.getUserId();
	}

	/**
	 * Returns the user name of this phieu.
	 *
	 * @return the user name of this phieu
	 */
	@Override
	public String getUserName() {
		return _phieu.getUserName();
	}

	/**
	 * Returns the user uuid of this phieu.
	 *
	 * @return the user uuid of this phieu
	 */
	@Override
	public String getUserUuid() {
		return _phieu.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _phieu.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _phieu.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _phieu.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _phieu.isNew();
	}

	@Override
	public void persist() {
		_phieu.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_phieu.setCachedModel(cachedModel);
	}

	/**
	 * Sets the chung tu kem theo of this phieu.
	 *
	 * @param chungTuKemTheo the chung tu kem theo of this phieu
	 */
	@Override
	public void setChungTuKemTheo(String chungTuKemTheo) {
		_phieu.setChungTuKemTheo(chungTuKemTheo);
	}

	/**
	 * Sets the company ID of this phieu.
	 *
	 * @param companyId the company ID of this phieu
	 */
	@Override
	public void setCompanyId(long companyId) {
		_phieu.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this phieu.
	 *
	 * @param createDate the create date of this phieu
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_phieu.setCreateDate(createDate);
	}

	/**
	 * Sets the dia chi of this phieu.
	 *
	 * @param diaChi the dia chi of this phieu
	 */
	@Override
	public void setDiaChi(String diaChi) {
		_phieu.setDiaChi(diaChi);
	}

	@Override
	public void setDsPhieuTaiKhoanJSONArray(
		com.liferay.portal.kernel.json.JSONArray dsPhieuTaiKhoanJSONArray) {

		_phieu.setDsPhieuTaiKhoanJSONArray(dsPhieuTaiKhoanJSONArray);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_phieu.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_phieu.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_phieu.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the group ID of this phieu.
	 *
	 * @param groupId the group ID of this phieu
	 */
	@Override
	public void setGroupId(long groupId) {
		_phieu.setGroupId(groupId);
	}

	/**
	 * Sets the hoat dong of this phieu.
	 *
	 * @param hoatDong the hoat dong of this phieu
	 */
	@Override
	public void setHoatDong(Boolean hoatDong) {
		_phieu.setHoatDong(hoatDong);
	}

	/**
	 * Sets the ho ten ctv of this phieu.
	 *
	 * @param hoTenCTV the ho ten ctv of this phieu
	 */
	@Override
	public void setHoTenCTV(String hoTenCTV) {
		_phieu.setHoTenCTV(hoTenCTV);
	}

	/**
	 * Sets the loai of this phieu.
	 *
	 * @param loai the loai of this phieu
	 */
	@Override
	public void setLoai(int loai) {
		_phieu.setLoai(loai);
	}

	/**
	 * Sets the ma ctv of this phieu.
	 *
	 * @param maCTV the ma ctv of this phieu
	 */
	@Override
	public void setMaCTV(String maCTV) {
		_phieu.setMaCTV(maCTV);
	}

	/**
	 * Sets the ma ms thu chi of this phieu.
	 *
	 * @param maMSThuChi the ma ms thu chi of this phieu
	 */
	@Override
	public void setMaMSThuChi(String maMSThuChi) {
		_phieu.setMaMSThuChi(maMSThuChi);
	}

	/**
	 * Sets the modified date of this phieu.
	 *
	 * @param modifiedDate the modified date of this phieu
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_phieu.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_phieu.setNew(n);
	}

	/**
	 * Sets the ngay chung tu of this phieu.
	 *
	 * @param ngayChungTu the ngay chung tu of this phieu
	 */
	@Override
	public void setNgayChungTu(Date ngayChungTu) {
		_phieu.setNgayChungTu(ngayChungTu);
	}

	/**
	 * Sets the ngay ghi so of this phieu.
	 *
	 * @param ngayGhiSo the ngay ghi so of this phieu
	 */
	@Override
	public void setNgayGhiSo(Date ngayGhiSo) {
		_phieu.setNgayGhiSo(ngayGhiSo);
	}

	/**
	 * Sets the phieu ID of this phieu.
	 *
	 * @param phieuId the phieu ID of this phieu
	 */
	@Override
	public void setPhieuId(long phieuId) {
		_phieu.setPhieuId(phieuId);
	}

	/**
	 * Sets the primary key of this phieu.
	 *
	 * @param primaryKey the primary key of this phieu
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_phieu.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_phieu.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the so hop dong of this phieu.
	 *
	 * @param soHopDong the so hop dong of this phieu
	 */
	@Override
	public void setSoHopDong(String soHopDong) {
		_phieu.setSoHopDong(soHopDong);
	}

	/**
	 * Sets the so phieu of this phieu.
	 *
	 * @param soPhieu the so phieu of this phieu
	 */
	@Override
	public void setSoPhieu(String soPhieu) {
		_phieu.setSoPhieu(soPhieu);
	}

	/**
	 * Sets the so tien of this phieu.
	 *
	 * @param soTien the so tien of this phieu
	 */
	@Override
	public void setSoTien(Double soTien) {
		_phieu.setSoTien(soTien);
	}

	/**
	 * Sets the user ID of this phieu.
	 *
	 * @param userId the user ID of this phieu
	 */
	@Override
	public void setUserId(long userId) {
		_phieu.setUserId(userId);
	}

	/**
	 * Sets the user name of this phieu.
	 *
	 * @param userName the user name of this phieu
	 */
	@Override
	public void setUserName(String userName) {
		_phieu.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this phieu.
	 *
	 * @param userUuid the user uuid of this phieu
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_phieu.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Phieu> toCacheModel() {
		return _phieu.toCacheModel();
	}

	@Override
	public Phieu toEscapedModel() {
		return new PhieuWrapper(_phieu.toEscapedModel());
	}

	@Override
	public String toString() {
		return _phieu.toString();
	}

	@Override
	public Phieu toUnescapedModel() {
		return new PhieuWrapper(_phieu.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _phieu.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PhieuWrapper)) {
			return false;
		}

		PhieuWrapper phieuWrapper = (PhieuWrapper)obj;

		if (Objects.equals(_phieu, phieuWrapper._phieu)) {
			return true;
		}

		return false;
	}

	@Override
	public Phieu getWrappedModel() {
		return _phieu;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _phieu.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _phieu.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_phieu.resetOriginalValues();
	}

	private final Phieu _phieu;

}