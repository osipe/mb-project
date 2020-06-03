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
 * This class is a wrapper for {@link LaiSuat}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LaiSuat
 * @generated
 */
@ProviderType
public class LaiSuatWrapper implements LaiSuat, ModelWrapper<LaiSuat> {

	public LaiSuatWrapper(LaiSuat laiSuat) {
		_laiSuat = laiSuat;
	}

	@Override
	public Class<?> getModelClass() {
		return LaiSuat.class;
	}

	@Override
	public String getModelClassName() {
		return LaiSuat.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("laiSuatId", getLaiSuatId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("soTienVay", getSoTienVay());
		attributes.put("thoiHan", getThoiHan());
		attributes.put("laiSuatVay", getLaiSuatVay());
		attributes.put("gocNgay", getGocNgay());
		attributes.put("laiNgay", getLaiNgay());
		attributes.put("gocNgayCuoi", getGocNgayCuoi());
		attributes.put("hoatDong", getHoatDong());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long laiSuatId = (Long)attributes.get("laiSuatId");

		if (laiSuatId != null) {
			setLaiSuatId(laiSuatId);
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

		Boolean hoatDong = (Boolean)attributes.get("hoatDong");

		if (hoatDong != null) {
			setHoatDong(hoatDong);
		}
	}

	@Override
	public Object clone() {
		return new LaiSuatWrapper((LaiSuat)_laiSuat.clone());
	}

	@Override
	public int compareTo(LaiSuat laiSuat) {
		return _laiSuat.compareTo(laiSuat);
	}

	/**
	 * Returns the company ID of this lai suat.
	 *
	 * @return the company ID of this lai suat
	 */
	@Override
	public long getCompanyId() {
		return _laiSuat.getCompanyId();
	}

	/**
	 * Returns the create date of this lai suat.
	 *
	 * @return the create date of this lai suat
	 */
	@Override
	public Date getCreateDate() {
		return _laiSuat.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _laiSuat.getExpandoBridge();
	}

	/**
	 * Returns the goc ngay of this lai suat.
	 *
	 * @return the goc ngay of this lai suat
	 */
	@Override
	public Double getGocNgay() {
		return _laiSuat.getGocNgay();
	}

	/**
	 * Returns the goc ngay cuoi of this lai suat.
	 *
	 * @return the goc ngay cuoi of this lai suat
	 */
	@Override
	public Double getGocNgayCuoi() {
		return _laiSuat.getGocNgayCuoi();
	}

	/**
	 * Returns the group ID of this lai suat.
	 *
	 * @return the group ID of this lai suat
	 */
	@Override
	public long getGroupId() {
		return _laiSuat.getGroupId();
	}

	/**
	 * Returns the hoat dong of this lai suat.
	 *
	 * @return the hoat dong of this lai suat
	 */
	@Override
	public Boolean getHoatDong() {
		return _laiSuat.getHoatDong();
	}

	/**
	 * Returns the lai ngay of this lai suat.
	 *
	 * @return the lai ngay of this lai suat
	 */
	@Override
	public Double getLaiNgay() {
		return _laiSuat.getLaiNgay();
	}

	/**
	 * Returns the lai suat ID of this lai suat.
	 *
	 * @return the lai suat ID of this lai suat
	 */
	@Override
	public long getLaiSuatId() {
		return _laiSuat.getLaiSuatId();
	}

	/**
	 * Returns the lai suat vay of this lai suat.
	 *
	 * @return the lai suat vay of this lai suat
	 */
	@Override
	public Double getLaiSuatVay() {
		return _laiSuat.getLaiSuatVay();
	}

	/**
	 * Returns the modified date of this lai suat.
	 *
	 * @return the modified date of this lai suat
	 */
	@Override
	public Date getModifiedDate() {
		return _laiSuat.getModifiedDate();
	}

	/**
	 * Returns the primary key of this lai suat.
	 *
	 * @return the primary key of this lai suat
	 */
	@Override
	public long getPrimaryKey() {
		return _laiSuat.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _laiSuat.getPrimaryKeyObj();
	}

	/**
	 * Returns the so tien vay of this lai suat.
	 *
	 * @return the so tien vay of this lai suat
	 */
	@Override
	public Double getSoTienVay() {
		return _laiSuat.getSoTienVay();
	}

	/**
	 * Returns the thoi han of this lai suat.
	 *
	 * @return the thoi han of this lai suat
	 */
	@Override
	public int getThoiHan() {
		return _laiSuat.getThoiHan();
	}

	/**
	 * Returns the user ID of this lai suat.
	 *
	 * @return the user ID of this lai suat
	 */
	@Override
	public long getUserId() {
		return _laiSuat.getUserId();
	}

	/**
	 * Returns the user name of this lai suat.
	 *
	 * @return the user name of this lai suat
	 */
	@Override
	public String getUserName() {
		return _laiSuat.getUserName();
	}

	/**
	 * Returns the user uuid of this lai suat.
	 *
	 * @return the user uuid of this lai suat
	 */
	@Override
	public String getUserUuid() {
		return _laiSuat.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _laiSuat.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _laiSuat.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _laiSuat.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _laiSuat.isNew();
	}

	@Override
	public void persist() {
		_laiSuat.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_laiSuat.setCachedModel(cachedModel);
	}

	/**
	 * Sets the company ID of this lai suat.
	 *
	 * @param companyId the company ID of this lai suat
	 */
	@Override
	public void setCompanyId(long companyId) {
		_laiSuat.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this lai suat.
	 *
	 * @param createDate the create date of this lai suat
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_laiSuat.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_laiSuat.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_laiSuat.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_laiSuat.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the goc ngay of this lai suat.
	 *
	 * @param gocNgay the goc ngay of this lai suat
	 */
	@Override
	public void setGocNgay(Double gocNgay) {
		_laiSuat.setGocNgay(gocNgay);
	}

	/**
	 * Sets the goc ngay cuoi of this lai suat.
	 *
	 * @param gocNgayCuoi the goc ngay cuoi of this lai suat
	 */
	@Override
	public void setGocNgayCuoi(Double gocNgayCuoi) {
		_laiSuat.setGocNgayCuoi(gocNgayCuoi);
	}

	/**
	 * Sets the group ID of this lai suat.
	 *
	 * @param groupId the group ID of this lai suat
	 */
	@Override
	public void setGroupId(long groupId) {
		_laiSuat.setGroupId(groupId);
	}

	/**
	 * Sets the hoat dong of this lai suat.
	 *
	 * @param hoatDong the hoat dong of this lai suat
	 */
	@Override
	public void setHoatDong(Boolean hoatDong) {
		_laiSuat.setHoatDong(hoatDong);
	}

	/**
	 * Sets the lai ngay of this lai suat.
	 *
	 * @param laiNgay the lai ngay of this lai suat
	 */
	@Override
	public void setLaiNgay(Double laiNgay) {
		_laiSuat.setLaiNgay(laiNgay);
	}

	/**
	 * Sets the lai suat ID of this lai suat.
	 *
	 * @param laiSuatId the lai suat ID of this lai suat
	 */
	@Override
	public void setLaiSuatId(long laiSuatId) {
		_laiSuat.setLaiSuatId(laiSuatId);
	}

	/**
	 * Sets the lai suat vay of this lai suat.
	 *
	 * @param laiSuatVay the lai suat vay of this lai suat
	 */
	@Override
	public void setLaiSuatVay(Double laiSuatVay) {
		_laiSuat.setLaiSuatVay(laiSuatVay);
	}

	/**
	 * Sets the modified date of this lai suat.
	 *
	 * @param modifiedDate the modified date of this lai suat
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_laiSuat.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_laiSuat.setNew(n);
	}

	/**
	 * Sets the primary key of this lai suat.
	 *
	 * @param primaryKey the primary key of this lai suat
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_laiSuat.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_laiSuat.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the so tien vay of this lai suat.
	 *
	 * @param soTienVay the so tien vay of this lai suat
	 */
	@Override
	public void setSoTienVay(Double soTienVay) {
		_laiSuat.setSoTienVay(soTienVay);
	}

	/**
	 * Sets the thoi han of this lai suat.
	 *
	 * @param thoiHan the thoi han of this lai suat
	 */
	@Override
	public void setThoiHan(int thoiHan) {
		_laiSuat.setThoiHan(thoiHan);
	}

	/**
	 * Sets the user ID of this lai suat.
	 *
	 * @param userId the user ID of this lai suat
	 */
	@Override
	public void setUserId(long userId) {
		_laiSuat.setUserId(userId);
	}

	/**
	 * Sets the user name of this lai suat.
	 *
	 * @param userName the user name of this lai suat
	 */
	@Override
	public void setUserName(String userName) {
		_laiSuat.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this lai suat.
	 *
	 * @param userUuid the user uuid of this lai suat
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_laiSuat.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<LaiSuat> toCacheModel() {
		return _laiSuat.toCacheModel();
	}

	@Override
	public LaiSuat toEscapedModel() {
		return new LaiSuatWrapper(_laiSuat.toEscapedModel());
	}

	@Override
	public String toString() {
		return _laiSuat.toString();
	}

	@Override
	public LaiSuat toUnescapedModel() {
		return new LaiSuatWrapper(_laiSuat.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _laiSuat.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LaiSuatWrapper)) {
			return false;
		}

		LaiSuatWrapper laiSuatWrapper = (LaiSuatWrapper)obj;

		if (Objects.equals(_laiSuat, laiSuatWrapper._laiSuat)) {
			return true;
		}

		return false;
	}

	@Override
	public LaiSuat getWrappedModel() {
		return _laiSuat;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _laiSuat.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _laiSuat.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_laiSuat.resetOriginalValues();
	}

	private final LaiSuat _laiSuat;

}