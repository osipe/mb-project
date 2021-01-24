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
 * This class is a wrapper for {@link CongTacVien}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CongTacVien
 * @generated
 */
@ProviderType
public class CongTacVienWrapper
	implements CongTacVien, ModelWrapper<CongTacVien> {

	public CongTacVienWrapper(CongTacVien congTacVien) {
		_congTacVien = congTacVien;
	}

	@Override
	public Class<?> getModelClass() {
		return CongTacVien.class;
	}

	@Override
	public String getModelClassName() {
		return CongTacVien.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("congTacVienId", getCongTacVienId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("chiNhanhId", getChiNhanhId());
		attributes.put("tenChiNhanh", getTenChiNhanh());
		attributes.put("ma", getMa());
		attributes.put("hoTen", getHoTen());
		attributes.put("soCMND", getSoCMND());
		attributes.put("duNoToiDa", getDuNoToiDa());
		attributes.put("duNoToiDaTheChap", getDuNoToiDaTheChap());
		attributes.put("diaChi", getDiaChi());
		attributes.put("ghiChu", getGhiChu());
		attributes.put("hoatDong", getHoatDong());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long congTacVienId = (Long)attributes.get("congTacVienId");

		if (congTacVienId != null) {
			setCongTacVienId(congTacVienId);
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

		String tenChiNhanh = (String)attributes.get("tenChiNhanh");

		if (tenChiNhanh != null) {
			setTenChiNhanh(tenChiNhanh);
		}

		String ma = (String)attributes.get("ma");

		if (ma != null) {
			setMa(ma);
		}

		String hoTen = (String)attributes.get("hoTen");

		if (hoTen != null) {
			setHoTen(hoTen);
		}

		String soCMND = (String)attributes.get("soCMND");

		if (soCMND != null) {
			setSoCMND(soCMND);
		}

		Double duNoToiDa = (Double)attributes.get("duNoToiDa");

		if (duNoToiDa != null) {
			setDuNoToiDa(duNoToiDa);
		}

		Double duNoToiDaTheChap = (Double)attributes.get("duNoToiDaTheChap");

		if (duNoToiDaTheChap != null) {
			setDuNoToiDaTheChap(duNoToiDaTheChap);
		}

		String diaChi = (String)attributes.get("diaChi");

		if (diaChi != null) {
			setDiaChi(diaChi);
		}

		String ghiChu = (String)attributes.get("ghiChu");

		if (ghiChu != null) {
			setGhiChu(ghiChu);
		}

		Boolean hoatDong = (Boolean)attributes.get("hoatDong");

		if (hoatDong != null) {
			setHoatDong(hoatDong);
		}
	}

	@Override
	public Object clone() {
		return new CongTacVienWrapper((CongTacVien)_congTacVien.clone());
	}

	@Override
	public int compareTo(CongTacVien congTacVien) {
		return _congTacVien.compareTo(congTacVien);
	}

	/**
	 * Returns the chi nhanh ID of this cong tac vien.
	 *
	 * @return the chi nhanh ID of this cong tac vien
	 */
	@Override
	public long getChiNhanhId() {
		return _congTacVien.getChiNhanhId();
	}

	/**
	 * Returns the company ID of this cong tac vien.
	 *
	 * @return the company ID of this cong tac vien
	 */
	@Override
	public long getCompanyId() {
		return _congTacVien.getCompanyId();
	}

	/**
	 * Returns the cong tac vien ID of this cong tac vien.
	 *
	 * @return the cong tac vien ID of this cong tac vien
	 */
	@Override
	public long getCongTacVienId() {
		return _congTacVien.getCongTacVienId();
	}

	/**
	 * Returns the create date of this cong tac vien.
	 *
	 * @return the create date of this cong tac vien
	 */
	@Override
	public Date getCreateDate() {
		return _congTacVien.getCreateDate();
	}

	/**
	 * Returns the dia chi of this cong tac vien.
	 *
	 * @return the dia chi of this cong tac vien
	 */
	@Override
	public String getDiaChi() {
		return _congTacVien.getDiaChi();
	}

	/**
	 * Returns the du no toi da of this cong tac vien.
	 *
	 * @return the du no toi da of this cong tac vien
	 */
	@Override
	public Double getDuNoToiDa() {
		return _congTacVien.getDuNoToiDa();
	}

	/**
	 * Returns the du no toi da the chap of this cong tac vien.
	 *
	 * @return the du no toi da the chap of this cong tac vien
	 */
	@Override
	public Double getDuNoToiDaTheChap() {
		return _congTacVien.getDuNoToiDaTheChap();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _congTacVien.getExpandoBridge();
	}

	/**
	 * Returns the ghi chu of this cong tac vien.
	 *
	 * @return the ghi chu of this cong tac vien
	 */
	@Override
	public String getGhiChu() {
		return _congTacVien.getGhiChu();
	}

	/**
	 * Returns the group ID of this cong tac vien.
	 *
	 * @return the group ID of this cong tac vien
	 */
	@Override
	public long getGroupId() {
		return _congTacVien.getGroupId();
	}

	/**
	 * Returns the hoat dong of this cong tac vien.
	 *
	 * @return the hoat dong of this cong tac vien
	 */
	@Override
	public Boolean getHoatDong() {
		return _congTacVien.getHoatDong();
	}

	/**
	 * Returns the ho ten of this cong tac vien.
	 *
	 * @return the ho ten of this cong tac vien
	 */
	@Override
	public String getHoTen() {
		return _congTacVien.getHoTen();
	}

	/**
	 * Returns the ma of this cong tac vien.
	 *
	 * @return the ma of this cong tac vien
	 */
	@Override
	public String getMa() {
		return _congTacVien.getMa();
	}

	/**
	 * Returns the modified date of this cong tac vien.
	 *
	 * @return the modified date of this cong tac vien
	 */
	@Override
	public Date getModifiedDate() {
		return _congTacVien.getModifiedDate();
	}

	/**
	 * Returns the primary key of this cong tac vien.
	 *
	 * @return the primary key of this cong tac vien
	 */
	@Override
	public long getPrimaryKey() {
		return _congTacVien.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _congTacVien.getPrimaryKeyObj();
	}

	/**
	 * Returns the so cmnd of this cong tac vien.
	 *
	 * @return the so cmnd of this cong tac vien
	 */
	@Override
	public String getSoCMND() {
		return _congTacVien.getSoCMND();
	}

	/**
	 * Returns the ten chi nhanh of this cong tac vien.
	 *
	 * @return the ten chi nhanh of this cong tac vien
	 */
	@Override
	public String getTenChiNhanh() {
		return _congTacVien.getTenChiNhanh();
	}

	/**
	 * Returns the user ID of this cong tac vien.
	 *
	 * @return the user ID of this cong tac vien
	 */
	@Override
	public long getUserId() {
		return _congTacVien.getUserId();
	}

	/**
	 * Returns the user name of this cong tac vien.
	 *
	 * @return the user name of this cong tac vien
	 */
	@Override
	public String getUserName() {
		return _congTacVien.getUserName();
	}

	/**
	 * Returns the user uuid of this cong tac vien.
	 *
	 * @return the user uuid of this cong tac vien
	 */
	@Override
	public String getUserUuid() {
		return _congTacVien.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _congTacVien.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _congTacVien.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _congTacVien.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _congTacVien.isNew();
	}

	@Override
	public void persist() {
		_congTacVien.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_congTacVien.setCachedModel(cachedModel);
	}

	/**
	 * Sets the chi nhanh ID of this cong tac vien.
	 *
	 * @param chiNhanhId the chi nhanh ID of this cong tac vien
	 */
	@Override
	public void setChiNhanhId(long chiNhanhId) {
		_congTacVien.setChiNhanhId(chiNhanhId);
	}

	/**
	 * Sets the company ID of this cong tac vien.
	 *
	 * @param companyId the company ID of this cong tac vien
	 */
	@Override
	public void setCompanyId(long companyId) {
		_congTacVien.setCompanyId(companyId);
	}

	/**
	 * Sets the cong tac vien ID of this cong tac vien.
	 *
	 * @param congTacVienId the cong tac vien ID of this cong tac vien
	 */
	@Override
	public void setCongTacVienId(long congTacVienId) {
		_congTacVien.setCongTacVienId(congTacVienId);
	}

	/**
	 * Sets the create date of this cong tac vien.
	 *
	 * @param createDate the create date of this cong tac vien
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_congTacVien.setCreateDate(createDate);
	}

	/**
	 * Sets the dia chi of this cong tac vien.
	 *
	 * @param diaChi the dia chi of this cong tac vien
	 */
	@Override
	public void setDiaChi(String diaChi) {
		_congTacVien.setDiaChi(diaChi);
	}

	/**
	 * Sets the du no toi da of this cong tac vien.
	 *
	 * @param duNoToiDa the du no toi da of this cong tac vien
	 */
	@Override
	public void setDuNoToiDa(Double duNoToiDa) {
		_congTacVien.setDuNoToiDa(duNoToiDa);
	}

	/**
	 * Sets the du no toi da the chap of this cong tac vien.
	 *
	 * @param duNoToiDaTheChap the du no toi da the chap of this cong tac vien
	 */
	@Override
	public void setDuNoToiDaTheChap(Double duNoToiDaTheChap) {
		_congTacVien.setDuNoToiDaTheChap(duNoToiDaTheChap);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_congTacVien.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_congTacVien.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_congTacVien.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the ghi chu of this cong tac vien.
	 *
	 * @param ghiChu the ghi chu of this cong tac vien
	 */
	@Override
	public void setGhiChu(String ghiChu) {
		_congTacVien.setGhiChu(ghiChu);
	}

	/**
	 * Sets the group ID of this cong tac vien.
	 *
	 * @param groupId the group ID of this cong tac vien
	 */
	@Override
	public void setGroupId(long groupId) {
		_congTacVien.setGroupId(groupId);
	}

	/**
	 * Sets the hoat dong of this cong tac vien.
	 *
	 * @param hoatDong the hoat dong of this cong tac vien
	 */
	@Override
	public void setHoatDong(Boolean hoatDong) {
		_congTacVien.setHoatDong(hoatDong);
	}

	/**
	 * Sets the ho ten of this cong tac vien.
	 *
	 * @param hoTen the ho ten of this cong tac vien
	 */
	@Override
	public void setHoTen(String hoTen) {
		_congTacVien.setHoTen(hoTen);
	}

	/**
	 * Sets the ma of this cong tac vien.
	 *
	 * @param ma the ma of this cong tac vien
	 */
	@Override
	public void setMa(String ma) {
		_congTacVien.setMa(ma);
	}

	/**
	 * Sets the modified date of this cong tac vien.
	 *
	 * @param modifiedDate the modified date of this cong tac vien
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_congTacVien.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_congTacVien.setNew(n);
	}

	/**
	 * Sets the primary key of this cong tac vien.
	 *
	 * @param primaryKey the primary key of this cong tac vien
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_congTacVien.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_congTacVien.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the so cmnd of this cong tac vien.
	 *
	 * @param soCMND the so cmnd of this cong tac vien
	 */
	@Override
	public void setSoCMND(String soCMND) {
		_congTacVien.setSoCMND(soCMND);
	}

	/**
	 * Sets the ten chi nhanh of this cong tac vien.
	 *
	 * @param tenChiNhanh the ten chi nhanh of this cong tac vien
	 */
	@Override
	public void setTenChiNhanh(String tenChiNhanh) {
		_congTacVien.setTenChiNhanh(tenChiNhanh);
	}

	/**
	 * Sets the user ID of this cong tac vien.
	 *
	 * @param userId the user ID of this cong tac vien
	 */
	@Override
	public void setUserId(long userId) {
		_congTacVien.setUserId(userId);
	}

	/**
	 * Sets the user name of this cong tac vien.
	 *
	 * @param userName the user name of this cong tac vien
	 */
	@Override
	public void setUserName(String userName) {
		_congTacVien.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this cong tac vien.
	 *
	 * @param userUuid the user uuid of this cong tac vien
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_congTacVien.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<CongTacVien>
		toCacheModel() {

		return _congTacVien.toCacheModel();
	}

	@Override
	public CongTacVien toEscapedModel() {
		return new CongTacVienWrapper(_congTacVien.toEscapedModel());
	}

	@Override
	public String toString() {
		return _congTacVien.toString();
	}

	@Override
	public CongTacVien toUnescapedModel() {
		return new CongTacVienWrapper(_congTacVien.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _congTacVien.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CongTacVienWrapper)) {
			return false;
		}

		CongTacVienWrapper congTacVienWrapper = (CongTacVienWrapper)obj;

		if (Objects.equals(_congTacVien, congTacVienWrapper._congTacVien)) {
			return true;
		}

		return false;
	}

	@Override
	public CongTacVien getWrappedModel() {
		return _congTacVien;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _congTacVien.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _congTacVien.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_congTacVien.resetOriginalValues();
	}

	private final CongTacVien _congTacVien;

}