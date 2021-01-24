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
 * This class is a wrapper for {@link ChiNhanh}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ChiNhanh
 * @generated
 */
@ProviderType
public class ChiNhanhWrapper implements ChiNhanh, ModelWrapper<ChiNhanh> {

	public ChiNhanhWrapper(ChiNhanh chiNhanh) {
		_chiNhanh = chiNhanh;
	}

	@Override
	public Class<?> getModelClass() {
		return ChiNhanh.class;
	}

	@Override
	public String getModelClassName() {
		return ChiNhanh.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("chiNhanhId", getChiNhanhId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("ma", getMa());
		attributes.put("ten", getTen());
		attributes.put("hoatDong", getHoatDong());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long chiNhanhId = (Long)attributes.get("chiNhanhId");

		if (chiNhanhId != null) {
			setChiNhanhId(chiNhanhId);
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

		String ma = (String)attributes.get("ma");

		if (ma != null) {
			setMa(ma);
		}

		String ten = (String)attributes.get("ten");

		if (ten != null) {
			setTen(ten);
		}

		Boolean hoatDong = (Boolean)attributes.get("hoatDong");

		if (hoatDong != null) {
			setHoatDong(hoatDong);
		}
	}

	@Override
	public Object clone() {
		return new ChiNhanhWrapper((ChiNhanh)_chiNhanh.clone());
	}

	@Override
	public int compareTo(ChiNhanh chiNhanh) {
		return _chiNhanh.compareTo(chiNhanh);
	}

	/**
	 * Returns the chi nhanh ID of this chi nhanh.
	 *
	 * @return the chi nhanh ID of this chi nhanh
	 */
	@Override
	public long getChiNhanhId() {
		return _chiNhanh.getChiNhanhId();
	}

	/**
	 * Returns the company ID of this chi nhanh.
	 *
	 * @return the company ID of this chi nhanh
	 */
	@Override
	public long getCompanyId() {
		return _chiNhanh.getCompanyId();
	}

	/**
	 * Returns the create date of this chi nhanh.
	 *
	 * @return the create date of this chi nhanh
	 */
	@Override
	public Date getCreateDate() {
		return _chiNhanh.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _chiNhanh.getExpandoBridge();
	}

	/**
	 * Returns the group ID of this chi nhanh.
	 *
	 * @return the group ID of this chi nhanh
	 */
	@Override
	public long getGroupId() {
		return _chiNhanh.getGroupId();
	}

	/**
	 * Returns the hoat dong of this chi nhanh.
	 *
	 * @return the hoat dong of this chi nhanh
	 */
	@Override
	public Boolean getHoatDong() {
		return _chiNhanh.getHoatDong();
	}

	/**
	 * Returns the ma of this chi nhanh.
	 *
	 * @return the ma of this chi nhanh
	 */
	@Override
	public String getMa() {
		return _chiNhanh.getMa();
	}

	/**
	 * Returns the modified date of this chi nhanh.
	 *
	 * @return the modified date of this chi nhanh
	 */
	@Override
	public Date getModifiedDate() {
		return _chiNhanh.getModifiedDate();
	}

	/**
	 * Returns the primary key of this chi nhanh.
	 *
	 * @return the primary key of this chi nhanh
	 */
	@Override
	public long getPrimaryKey() {
		return _chiNhanh.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _chiNhanh.getPrimaryKeyObj();
	}

	/**
	 * Returns the ten of this chi nhanh.
	 *
	 * @return the ten of this chi nhanh
	 */
	@Override
	public String getTen() {
		return _chiNhanh.getTen();
	}

	/**
	 * Returns the user ID of this chi nhanh.
	 *
	 * @return the user ID of this chi nhanh
	 */
	@Override
	public long getUserId() {
		return _chiNhanh.getUserId();
	}

	/**
	 * Returns the user name of this chi nhanh.
	 *
	 * @return the user name of this chi nhanh
	 */
	@Override
	public String getUserName() {
		return _chiNhanh.getUserName();
	}

	/**
	 * Returns the user uuid of this chi nhanh.
	 *
	 * @return the user uuid of this chi nhanh
	 */
	@Override
	public String getUserUuid() {
		return _chiNhanh.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _chiNhanh.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _chiNhanh.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _chiNhanh.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _chiNhanh.isNew();
	}

	@Override
	public void persist() {
		_chiNhanh.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_chiNhanh.setCachedModel(cachedModel);
	}

	/**
	 * Sets the chi nhanh ID of this chi nhanh.
	 *
	 * @param chiNhanhId the chi nhanh ID of this chi nhanh
	 */
	@Override
	public void setChiNhanhId(long chiNhanhId) {
		_chiNhanh.setChiNhanhId(chiNhanhId);
	}

	/**
	 * Sets the company ID of this chi nhanh.
	 *
	 * @param companyId the company ID of this chi nhanh
	 */
	@Override
	public void setCompanyId(long companyId) {
		_chiNhanh.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this chi nhanh.
	 *
	 * @param createDate the create date of this chi nhanh
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_chiNhanh.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_chiNhanh.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_chiNhanh.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_chiNhanh.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the group ID of this chi nhanh.
	 *
	 * @param groupId the group ID of this chi nhanh
	 */
	@Override
	public void setGroupId(long groupId) {
		_chiNhanh.setGroupId(groupId);
	}

	/**
	 * Sets the hoat dong of this chi nhanh.
	 *
	 * @param hoatDong the hoat dong of this chi nhanh
	 */
	@Override
	public void setHoatDong(Boolean hoatDong) {
		_chiNhanh.setHoatDong(hoatDong);
	}

	/**
	 * Sets the ma of this chi nhanh.
	 *
	 * @param ma the ma of this chi nhanh
	 */
	@Override
	public void setMa(String ma) {
		_chiNhanh.setMa(ma);
	}

	/**
	 * Sets the modified date of this chi nhanh.
	 *
	 * @param modifiedDate the modified date of this chi nhanh
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_chiNhanh.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_chiNhanh.setNew(n);
	}

	/**
	 * Sets the primary key of this chi nhanh.
	 *
	 * @param primaryKey the primary key of this chi nhanh
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_chiNhanh.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_chiNhanh.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the ten of this chi nhanh.
	 *
	 * @param ten the ten of this chi nhanh
	 */
	@Override
	public void setTen(String ten) {
		_chiNhanh.setTen(ten);
	}

	/**
	 * Sets the user ID of this chi nhanh.
	 *
	 * @param userId the user ID of this chi nhanh
	 */
	@Override
	public void setUserId(long userId) {
		_chiNhanh.setUserId(userId);
	}

	/**
	 * Sets the user name of this chi nhanh.
	 *
	 * @param userName the user name of this chi nhanh
	 */
	@Override
	public void setUserName(String userName) {
		_chiNhanh.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this chi nhanh.
	 *
	 * @param userUuid the user uuid of this chi nhanh
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_chiNhanh.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<ChiNhanh> toCacheModel() {
		return _chiNhanh.toCacheModel();
	}

	@Override
	public ChiNhanh toEscapedModel() {
		return new ChiNhanhWrapper(_chiNhanh.toEscapedModel());
	}

	@Override
	public String toString() {
		return _chiNhanh.toString();
	}

	@Override
	public ChiNhanh toUnescapedModel() {
		return new ChiNhanhWrapper(_chiNhanh.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _chiNhanh.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ChiNhanhWrapper)) {
			return false;
		}

		ChiNhanhWrapper chiNhanhWrapper = (ChiNhanhWrapper)obj;

		if (Objects.equals(_chiNhanh, chiNhanhWrapper._chiNhanh)) {
			return true;
		}

		return false;
	}

	@Override
	public ChiNhanh getWrappedModel() {
		return _chiNhanh;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _chiNhanh.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _chiNhanh.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_chiNhanh.resetOriginalValues();
	}

	private final ChiNhanh _chiNhanh;

}