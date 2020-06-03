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
 * This class is a wrapper for {@link KhachHang}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KhachHang
 * @generated
 */
@ProviderType
public class KhachHangWrapper implements KhachHang, ModelWrapper<KhachHang> {

	public KhachHangWrapper(KhachHang khachHang) {
		_khachHang = khachHang;
	}

	@Override
	public Class<?> getModelClass() {
		return KhachHang.class;
	}

	@Override
	public String getModelClassName() {
		return KhachHang.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("khachHangId", getKhachHangId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("maCTV", getMaCTV());
		attributes.put("ma", getMa());
		attributes.put("hoTen", getHoTen());
		attributes.put("soCMND", getSoCMND());
		attributes.put("diaChi", getDiaChi());
		attributes.put("hoatDong", getHoatDong());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long khachHangId = (Long)attributes.get("khachHangId");

		if (khachHangId != null) {
			setKhachHangId(khachHangId);
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

		String diaChi = (String)attributes.get("diaChi");

		if (diaChi != null) {
			setDiaChi(diaChi);
		}

		Boolean hoatDong = (Boolean)attributes.get("hoatDong");

		if (hoatDong != null) {
			setHoatDong(hoatDong);
		}
	}

	@Override
	public Object clone() {
		return new KhachHangWrapper((KhachHang)_khachHang.clone());
	}

	@Override
	public int compareTo(KhachHang khachHang) {
		return _khachHang.compareTo(khachHang);
	}

	/**
	 * Returns the company ID of this khach hang.
	 *
	 * @return the company ID of this khach hang
	 */
	@Override
	public long getCompanyId() {
		return _khachHang.getCompanyId();
	}

	@Override
	public CongTacVien getCongTacVien() {
		return _khachHang.getCongTacVien();
	}

	/**
	 * Returns the create date of this khach hang.
	 *
	 * @return the create date of this khach hang
	 */
	@Override
	public Date getCreateDate() {
		return _khachHang.getCreateDate();
	}

	/**
	 * Returns the dia chi of this khach hang.
	 *
	 * @return the dia chi of this khach hang
	 */
	@Override
	public String getDiaChi() {
		return _khachHang.getDiaChi();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _khachHang.getExpandoBridge();
	}

	/**
	 * Returns the group ID of this khach hang.
	 *
	 * @return the group ID of this khach hang
	 */
	@Override
	public long getGroupId() {
		return _khachHang.getGroupId();
	}

	/**
	 * Returns the hoat dong of this khach hang.
	 *
	 * @return the hoat dong of this khach hang
	 */
	@Override
	public Boolean getHoatDong() {
		return _khachHang.getHoatDong();
	}

	/**
	 * Returns the ho ten of this khach hang.
	 *
	 * @return the ho ten of this khach hang
	 */
	@Override
	public String getHoTen() {
		return _khachHang.getHoTen();
	}

	/**
	 * Returns the khach hang ID of this khach hang.
	 *
	 * @return the khach hang ID of this khach hang
	 */
	@Override
	public long getKhachHangId() {
		return _khachHang.getKhachHangId();
	}

	/**
	 * Returns the ma of this khach hang.
	 *
	 * @return the ma of this khach hang
	 */
	@Override
	public String getMa() {
		return _khachHang.getMa();
	}

	/**
	 * Returns the ma ctv of this khach hang.
	 *
	 * @return the ma ctv of this khach hang
	 */
	@Override
	public String getMaCTV() {
		return _khachHang.getMaCTV();
	}

	/**
	 * Returns the modified date of this khach hang.
	 *
	 * @return the modified date of this khach hang
	 */
	@Override
	public Date getModifiedDate() {
		return _khachHang.getModifiedDate();
	}

	/**
	 * Returns the primary key of this khach hang.
	 *
	 * @return the primary key of this khach hang
	 */
	@Override
	public long getPrimaryKey() {
		return _khachHang.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _khachHang.getPrimaryKeyObj();
	}

	/**
	 * Returns the so cmnd of this khach hang.
	 *
	 * @return the so cmnd of this khach hang
	 */
	@Override
	public String getSoCMND() {
		return _khachHang.getSoCMND();
	}

	/**
	 * Returns the user ID of this khach hang.
	 *
	 * @return the user ID of this khach hang
	 */
	@Override
	public long getUserId() {
		return _khachHang.getUserId();
	}

	/**
	 * Returns the user name of this khach hang.
	 *
	 * @return the user name of this khach hang
	 */
	@Override
	public String getUserName() {
		return _khachHang.getUserName();
	}

	/**
	 * Returns the user uuid of this khach hang.
	 *
	 * @return the user uuid of this khach hang
	 */
	@Override
	public String getUserUuid() {
		return _khachHang.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _khachHang.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _khachHang.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _khachHang.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _khachHang.isNew();
	}

	@Override
	public void persist() {
		_khachHang.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_khachHang.setCachedModel(cachedModel);
	}

	/**
	 * Sets the company ID of this khach hang.
	 *
	 * @param companyId the company ID of this khach hang
	 */
	@Override
	public void setCompanyId(long companyId) {
		_khachHang.setCompanyId(companyId);
	}

	@Override
	public void setCongTacVien(CongTacVien congTacVien) {
		_khachHang.setCongTacVien(congTacVien);
	}

	/**
	 * Sets the create date of this khach hang.
	 *
	 * @param createDate the create date of this khach hang
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_khachHang.setCreateDate(createDate);
	}

	/**
	 * Sets the dia chi of this khach hang.
	 *
	 * @param diaChi the dia chi of this khach hang
	 */
	@Override
	public void setDiaChi(String diaChi) {
		_khachHang.setDiaChi(diaChi);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_khachHang.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_khachHang.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_khachHang.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the group ID of this khach hang.
	 *
	 * @param groupId the group ID of this khach hang
	 */
	@Override
	public void setGroupId(long groupId) {
		_khachHang.setGroupId(groupId);
	}

	/**
	 * Sets the hoat dong of this khach hang.
	 *
	 * @param hoatDong the hoat dong of this khach hang
	 */
	@Override
	public void setHoatDong(Boolean hoatDong) {
		_khachHang.setHoatDong(hoatDong);
	}

	/**
	 * Sets the ho ten of this khach hang.
	 *
	 * @param hoTen the ho ten of this khach hang
	 */
	@Override
	public void setHoTen(String hoTen) {
		_khachHang.setHoTen(hoTen);
	}

	/**
	 * Sets the khach hang ID of this khach hang.
	 *
	 * @param khachHangId the khach hang ID of this khach hang
	 */
	@Override
	public void setKhachHangId(long khachHangId) {
		_khachHang.setKhachHangId(khachHangId);
	}

	/**
	 * Sets the ma of this khach hang.
	 *
	 * @param ma the ma of this khach hang
	 */
	@Override
	public void setMa(String ma) {
		_khachHang.setMa(ma);
	}

	/**
	 * Sets the ma ctv of this khach hang.
	 *
	 * @param maCTV the ma ctv of this khach hang
	 */
	@Override
	public void setMaCTV(String maCTV) {
		_khachHang.setMaCTV(maCTV);
	}

	/**
	 * Sets the modified date of this khach hang.
	 *
	 * @param modifiedDate the modified date of this khach hang
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_khachHang.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_khachHang.setNew(n);
	}

	/**
	 * Sets the primary key of this khach hang.
	 *
	 * @param primaryKey the primary key of this khach hang
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_khachHang.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_khachHang.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the so cmnd of this khach hang.
	 *
	 * @param soCMND the so cmnd of this khach hang
	 */
	@Override
	public void setSoCMND(String soCMND) {
		_khachHang.setSoCMND(soCMND);
	}

	/**
	 * Sets the user ID of this khach hang.
	 *
	 * @param userId the user ID of this khach hang
	 */
	@Override
	public void setUserId(long userId) {
		_khachHang.setUserId(userId);
	}

	/**
	 * Sets the user name of this khach hang.
	 *
	 * @param userName the user name of this khach hang
	 */
	@Override
	public void setUserName(String userName) {
		_khachHang.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this khach hang.
	 *
	 * @param userUuid the user uuid of this khach hang
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_khachHang.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<KhachHang>
		toCacheModel() {

		return _khachHang.toCacheModel();
	}

	@Override
	public KhachHang toEscapedModel() {
		return new KhachHangWrapper(_khachHang.toEscapedModel());
	}

	@Override
	public String toString() {
		return _khachHang.toString();
	}

	@Override
	public KhachHang toUnescapedModel() {
		return new KhachHangWrapper(_khachHang.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _khachHang.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof KhachHangWrapper)) {
			return false;
		}

		KhachHangWrapper khachHangWrapper = (KhachHangWrapper)obj;

		if (Objects.equals(_khachHang, khachHangWrapper._khachHang)) {
			return true;
		}

		return false;
	}

	@Override
	public KhachHang getWrappedModel() {
		return _khachHang;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _khachHang.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _khachHang.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_khachHang.resetOriginalValues();
	}

	private final KhachHang _khachHang;

}