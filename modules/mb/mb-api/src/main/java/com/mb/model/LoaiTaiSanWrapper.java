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
 * This class is a wrapper for {@link LoaiTaiSan}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LoaiTaiSan
 * @generated
 */
@ProviderType
public class LoaiTaiSanWrapper implements LoaiTaiSan, ModelWrapper<LoaiTaiSan> {

	public LoaiTaiSanWrapper(LoaiTaiSan loaiTaiSan) {
		_loaiTaiSan = loaiTaiSan;
	}

	@Override
	public Class<?> getModelClass() {
		return LoaiTaiSan.class;
	}

	@Override
	public String getModelClassName() {
		return LoaiTaiSan.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("loaiTaiSanId", getLoaiTaiSanId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("ten", getTen());
		attributes.put("ma", getMa());
		attributes.put("ghiChu", getGhiChu());
		attributes.put("hoatDong", getHoatDong());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long loaiTaiSanId = (Long)attributes.get("loaiTaiSanId");

		if (loaiTaiSanId != null) {
			setLoaiTaiSanId(loaiTaiSanId);
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

		String ten = (String)attributes.get("ten");

		if (ten != null) {
			setTen(ten);
		}

		String ma = (String)attributes.get("ma");

		if (ma != null) {
			setMa(ma);
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
		return new LoaiTaiSanWrapper((LoaiTaiSan)_loaiTaiSan.clone());
	}

	@Override
	public int compareTo(LoaiTaiSan loaiTaiSan) {
		return _loaiTaiSan.compareTo(loaiTaiSan);
	}

	/**
	 * Returns the company ID of this loai tai san.
	 *
	 * @return the company ID of this loai tai san
	 */
	@Override
	public long getCompanyId() {
		return _loaiTaiSan.getCompanyId();
	}

	/**
	 * Returns the create date of this loai tai san.
	 *
	 * @return the create date of this loai tai san
	 */
	@Override
	public Date getCreateDate() {
		return _loaiTaiSan.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _loaiTaiSan.getExpandoBridge();
	}

	/**
	 * Returns the ghi chu of this loai tai san.
	 *
	 * @return the ghi chu of this loai tai san
	 */
	@Override
	public String getGhiChu() {
		return _loaiTaiSan.getGhiChu();
	}

	/**
	 * Returns the group ID of this loai tai san.
	 *
	 * @return the group ID of this loai tai san
	 */
	@Override
	public long getGroupId() {
		return _loaiTaiSan.getGroupId();
	}

	/**
	 * Returns the hoat dong of this loai tai san.
	 *
	 * @return the hoat dong of this loai tai san
	 */
	@Override
	public Boolean getHoatDong() {
		return _loaiTaiSan.getHoatDong();
	}

	/**
	 * Returns the loai tai san ID of this loai tai san.
	 *
	 * @return the loai tai san ID of this loai tai san
	 */
	@Override
	public long getLoaiTaiSanId() {
		return _loaiTaiSan.getLoaiTaiSanId();
	}

	/**
	 * Returns the ma of this loai tai san.
	 *
	 * @return the ma of this loai tai san
	 */
	@Override
	public String getMa() {
		return _loaiTaiSan.getMa();
	}

	/**
	 * Returns the modified date of this loai tai san.
	 *
	 * @return the modified date of this loai tai san
	 */
	@Override
	public Date getModifiedDate() {
		return _loaiTaiSan.getModifiedDate();
	}

	/**
	 * Returns the primary key of this loai tai san.
	 *
	 * @return the primary key of this loai tai san
	 */
	@Override
	public long getPrimaryKey() {
		return _loaiTaiSan.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _loaiTaiSan.getPrimaryKeyObj();
	}

	/**
	 * Returns the ten of this loai tai san.
	 *
	 * @return the ten of this loai tai san
	 */
	@Override
	public String getTen() {
		return _loaiTaiSan.getTen();
	}

	/**
	 * Returns the user ID of this loai tai san.
	 *
	 * @return the user ID of this loai tai san
	 */
	@Override
	public long getUserId() {
		return _loaiTaiSan.getUserId();
	}

	/**
	 * Returns the user name of this loai tai san.
	 *
	 * @return the user name of this loai tai san
	 */
	@Override
	public String getUserName() {
		return _loaiTaiSan.getUserName();
	}

	/**
	 * Returns the user uuid of this loai tai san.
	 *
	 * @return the user uuid of this loai tai san
	 */
	@Override
	public String getUserUuid() {
		return _loaiTaiSan.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _loaiTaiSan.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _loaiTaiSan.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _loaiTaiSan.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _loaiTaiSan.isNew();
	}

	@Override
	public void persist() {
		_loaiTaiSan.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_loaiTaiSan.setCachedModel(cachedModel);
	}

	/**
	 * Sets the company ID of this loai tai san.
	 *
	 * @param companyId the company ID of this loai tai san
	 */
	@Override
	public void setCompanyId(long companyId) {
		_loaiTaiSan.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this loai tai san.
	 *
	 * @param createDate the create date of this loai tai san
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_loaiTaiSan.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_loaiTaiSan.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_loaiTaiSan.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_loaiTaiSan.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the ghi chu of this loai tai san.
	 *
	 * @param ghiChu the ghi chu of this loai tai san
	 */
	@Override
	public void setGhiChu(String ghiChu) {
		_loaiTaiSan.setGhiChu(ghiChu);
	}

	/**
	 * Sets the group ID of this loai tai san.
	 *
	 * @param groupId the group ID of this loai tai san
	 */
	@Override
	public void setGroupId(long groupId) {
		_loaiTaiSan.setGroupId(groupId);
	}

	/**
	 * Sets the hoat dong of this loai tai san.
	 *
	 * @param hoatDong the hoat dong of this loai tai san
	 */
	@Override
	public void setHoatDong(Boolean hoatDong) {
		_loaiTaiSan.setHoatDong(hoatDong);
	}

	/**
	 * Sets the loai tai san ID of this loai tai san.
	 *
	 * @param loaiTaiSanId the loai tai san ID of this loai tai san
	 */
	@Override
	public void setLoaiTaiSanId(long loaiTaiSanId) {
		_loaiTaiSan.setLoaiTaiSanId(loaiTaiSanId);
	}

	/**
	 * Sets the ma of this loai tai san.
	 *
	 * @param ma the ma of this loai tai san
	 */
	@Override
	public void setMa(String ma) {
		_loaiTaiSan.setMa(ma);
	}

	/**
	 * Sets the modified date of this loai tai san.
	 *
	 * @param modifiedDate the modified date of this loai tai san
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_loaiTaiSan.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_loaiTaiSan.setNew(n);
	}

	/**
	 * Sets the primary key of this loai tai san.
	 *
	 * @param primaryKey the primary key of this loai tai san
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_loaiTaiSan.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_loaiTaiSan.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the ten of this loai tai san.
	 *
	 * @param ten the ten of this loai tai san
	 */
	@Override
	public void setTen(String ten) {
		_loaiTaiSan.setTen(ten);
	}

	/**
	 * Sets the user ID of this loai tai san.
	 *
	 * @param userId the user ID of this loai tai san
	 */
	@Override
	public void setUserId(long userId) {
		_loaiTaiSan.setUserId(userId);
	}

	/**
	 * Sets the user name of this loai tai san.
	 *
	 * @param userName the user name of this loai tai san
	 */
	@Override
	public void setUserName(String userName) {
		_loaiTaiSan.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this loai tai san.
	 *
	 * @param userUuid the user uuid of this loai tai san
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_loaiTaiSan.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<LoaiTaiSan>
		toCacheModel() {

		return _loaiTaiSan.toCacheModel();
	}

	@Override
	public LoaiTaiSan toEscapedModel() {
		return new LoaiTaiSanWrapper(_loaiTaiSan.toEscapedModel());
	}

	@Override
	public String toString() {
		return _loaiTaiSan.toString();
	}

	@Override
	public LoaiTaiSan toUnescapedModel() {
		return new LoaiTaiSanWrapper(_loaiTaiSan.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _loaiTaiSan.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LoaiTaiSanWrapper)) {
			return false;
		}

		LoaiTaiSanWrapper loaiTaiSanWrapper = (LoaiTaiSanWrapper)obj;

		if (Objects.equals(_loaiTaiSan, loaiTaiSanWrapper._loaiTaiSan)) {
			return true;
		}

		return false;
	}

	@Override
	public LoaiTaiSan getWrappedModel() {
		return _loaiTaiSan;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _loaiTaiSan.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _loaiTaiSan.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_loaiTaiSan.resetOriginalValues();
	}

	private final LoaiTaiSan _loaiTaiSan;

}