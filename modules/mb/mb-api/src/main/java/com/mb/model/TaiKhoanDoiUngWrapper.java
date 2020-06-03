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
 * This class is a wrapper for {@link TaiKhoanDoiUng}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaiKhoanDoiUng
 * @generated
 */
@ProviderType
public class TaiKhoanDoiUngWrapper
	implements TaiKhoanDoiUng, ModelWrapper<TaiKhoanDoiUng> {

	public TaiKhoanDoiUngWrapper(TaiKhoanDoiUng taiKhoanDoiUng) {
		_taiKhoanDoiUng = taiKhoanDoiUng;
	}

	@Override
	public Class<?> getModelClass() {
		return TaiKhoanDoiUng.class;
	}

	@Override
	public String getModelClassName() {
		return TaiKhoanDoiUng.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("taiKhoanDoiUngId", getTaiKhoanDoiUngId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("taiKhoanDoiUngChaId", getTaiKhoanDoiUngChaId());
		attributes.put("soHieu", getSoHieu());
		attributes.put("ten", getTen());
		attributes.put("hoatDong", getHoatDong());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long taiKhoanDoiUngId = (Long)attributes.get("taiKhoanDoiUngId");

		if (taiKhoanDoiUngId != null) {
			setTaiKhoanDoiUngId(taiKhoanDoiUngId);
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

		Long taiKhoanDoiUngChaId = (Long)attributes.get("taiKhoanDoiUngChaId");

		if (taiKhoanDoiUngChaId != null) {
			setTaiKhoanDoiUngChaId(taiKhoanDoiUngChaId);
		}

		String soHieu = (String)attributes.get("soHieu");

		if (soHieu != null) {
			setSoHieu(soHieu);
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
		return new TaiKhoanDoiUngWrapper(
			(TaiKhoanDoiUng)_taiKhoanDoiUng.clone());
	}

	@Override
	public int compareTo(TaiKhoanDoiUng taiKhoanDoiUng) {
		return _taiKhoanDoiUng.compareTo(taiKhoanDoiUng);
	}

	/**
	 * Returns the company ID of this tai khoan doi ung.
	 *
	 * @return the company ID of this tai khoan doi ung
	 */
	@Override
	public long getCompanyId() {
		return _taiKhoanDoiUng.getCompanyId();
	}

	/**
	 * Returns the create date of this tai khoan doi ung.
	 *
	 * @return the create date of this tai khoan doi ung
	 */
	@Override
	public Date getCreateDate() {
		return _taiKhoanDoiUng.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _taiKhoanDoiUng.getExpandoBridge();
	}

	/**
	 * Returns the group ID of this tai khoan doi ung.
	 *
	 * @return the group ID of this tai khoan doi ung
	 */
	@Override
	public long getGroupId() {
		return _taiKhoanDoiUng.getGroupId();
	}

	/**
	 * Returns the hoat dong of this tai khoan doi ung.
	 *
	 * @return the hoat dong of this tai khoan doi ung
	 */
	@Override
	public Boolean getHoatDong() {
		return _taiKhoanDoiUng.getHoatDong();
	}

	/**
	 * Returns the modified date of this tai khoan doi ung.
	 *
	 * @return the modified date of this tai khoan doi ung
	 */
	@Override
	public Date getModifiedDate() {
		return _taiKhoanDoiUng.getModifiedDate();
	}

	/**
	 * Returns the primary key of this tai khoan doi ung.
	 *
	 * @return the primary key of this tai khoan doi ung
	 */
	@Override
	public long getPrimaryKey() {
		return _taiKhoanDoiUng.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _taiKhoanDoiUng.getPrimaryKeyObj();
	}

	/**
	 * Returns the so hieu of this tai khoan doi ung.
	 *
	 * @return the so hieu of this tai khoan doi ung
	 */
	@Override
	public String getSoHieu() {
		return _taiKhoanDoiUng.getSoHieu();
	}

	/**
	 * Returns the tai khoan doi ung cha ID of this tai khoan doi ung.
	 *
	 * @return the tai khoan doi ung cha ID of this tai khoan doi ung
	 */
	@Override
	public long getTaiKhoanDoiUngChaId() {
		return _taiKhoanDoiUng.getTaiKhoanDoiUngChaId();
	}

	/**
	 * Returns the tai khoan doi ung ID of this tai khoan doi ung.
	 *
	 * @return the tai khoan doi ung ID of this tai khoan doi ung
	 */
	@Override
	public long getTaiKhoanDoiUngId() {
		return _taiKhoanDoiUng.getTaiKhoanDoiUngId();
	}

	/**
	 * Returns the ten of this tai khoan doi ung.
	 *
	 * @return the ten of this tai khoan doi ung
	 */
	@Override
	public String getTen() {
		return _taiKhoanDoiUng.getTen();
	}

	/**
	 * Returns the user ID of this tai khoan doi ung.
	 *
	 * @return the user ID of this tai khoan doi ung
	 */
	@Override
	public long getUserId() {
		return _taiKhoanDoiUng.getUserId();
	}

	/**
	 * Returns the user name of this tai khoan doi ung.
	 *
	 * @return the user name of this tai khoan doi ung
	 */
	@Override
	public String getUserName() {
		return _taiKhoanDoiUng.getUserName();
	}

	/**
	 * Returns the user uuid of this tai khoan doi ung.
	 *
	 * @return the user uuid of this tai khoan doi ung
	 */
	@Override
	public String getUserUuid() {
		return _taiKhoanDoiUng.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _taiKhoanDoiUng.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _taiKhoanDoiUng.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _taiKhoanDoiUng.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _taiKhoanDoiUng.isNew();
	}

	@Override
	public void persist() {
		_taiKhoanDoiUng.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_taiKhoanDoiUng.setCachedModel(cachedModel);
	}

	/**
	 * Sets the company ID of this tai khoan doi ung.
	 *
	 * @param companyId the company ID of this tai khoan doi ung
	 */
	@Override
	public void setCompanyId(long companyId) {
		_taiKhoanDoiUng.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this tai khoan doi ung.
	 *
	 * @param createDate the create date of this tai khoan doi ung
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_taiKhoanDoiUng.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_taiKhoanDoiUng.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_taiKhoanDoiUng.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_taiKhoanDoiUng.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the group ID of this tai khoan doi ung.
	 *
	 * @param groupId the group ID of this tai khoan doi ung
	 */
	@Override
	public void setGroupId(long groupId) {
		_taiKhoanDoiUng.setGroupId(groupId);
	}

	/**
	 * Sets the hoat dong of this tai khoan doi ung.
	 *
	 * @param hoatDong the hoat dong of this tai khoan doi ung
	 */
	@Override
	public void setHoatDong(Boolean hoatDong) {
		_taiKhoanDoiUng.setHoatDong(hoatDong);
	}

	/**
	 * Sets the modified date of this tai khoan doi ung.
	 *
	 * @param modifiedDate the modified date of this tai khoan doi ung
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_taiKhoanDoiUng.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_taiKhoanDoiUng.setNew(n);
	}

	/**
	 * Sets the primary key of this tai khoan doi ung.
	 *
	 * @param primaryKey the primary key of this tai khoan doi ung
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_taiKhoanDoiUng.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_taiKhoanDoiUng.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the so hieu of this tai khoan doi ung.
	 *
	 * @param soHieu the so hieu of this tai khoan doi ung
	 */
	@Override
	public void setSoHieu(String soHieu) {
		_taiKhoanDoiUng.setSoHieu(soHieu);
	}

	/**
	 * Sets the tai khoan doi ung cha ID of this tai khoan doi ung.
	 *
	 * @param taiKhoanDoiUngChaId the tai khoan doi ung cha ID of this tai khoan doi ung
	 */
	@Override
	public void setTaiKhoanDoiUngChaId(long taiKhoanDoiUngChaId) {
		_taiKhoanDoiUng.setTaiKhoanDoiUngChaId(taiKhoanDoiUngChaId);
	}

	/**
	 * Sets the tai khoan doi ung ID of this tai khoan doi ung.
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID of this tai khoan doi ung
	 */
	@Override
	public void setTaiKhoanDoiUngId(long taiKhoanDoiUngId) {
		_taiKhoanDoiUng.setTaiKhoanDoiUngId(taiKhoanDoiUngId);
	}

	/**
	 * Sets the ten of this tai khoan doi ung.
	 *
	 * @param ten the ten of this tai khoan doi ung
	 */
	@Override
	public void setTen(String ten) {
		_taiKhoanDoiUng.setTen(ten);
	}

	/**
	 * Sets the user ID of this tai khoan doi ung.
	 *
	 * @param userId the user ID of this tai khoan doi ung
	 */
	@Override
	public void setUserId(long userId) {
		_taiKhoanDoiUng.setUserId(userId);
	}

	/**
	 * Sets the user name of this tai khoan doi ung.
	 *
	 * @param userName the user name of this tai khoan doi ung
	 */
	@Override
	public void setUserName(String userName) {
		_taiKhoanDoiUng.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this tai khoan doi ung.
	 *
	 * @param userUuid the user uuid of this tai khoan doi ung
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_taiKhoanDoiUng.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<TaiKhoanDoiUng>
		toCacheModel() {

		return _taiKhoanDoiUng.toCacheModel();
	}

	@Override
	public TaiKhoanDoiUng toEscapedModel() {
		return new TaiKhoanDoiUngWrapper(_taiKhoanDoiUng.toEscapedModel());
	}

	@Override
	public String toString() {
		return _taiKhoanDoiUng.toString();
	}

	@Override
	public TaiKhoanDoiUng toUnescapedModel() {
		return new TaiKhoanDoiUngWrapper(_taiKhoanDoiUng.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _taiKhoanDoiUng.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TaiKhoanDoiUngWrapper)) {
			return false;
		}

		TaiKhoanDoiUngWrapper taiKhoanDoiUngWrapper =
			(TaiKhoanDoiUngWrapper)obj;

		if (Objects.equals(
				_taiKhoanDoiUng, taiKhoanDoiUngWrapper._taiKhoanDoiUng)) {

			return true;
		}

		return false;
	}

	@Override
	public TaiKhoanDoiUng getWrappedModel() {
		return _taiKhoanDoiUng;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _taiKhoanDoiUng.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _taiKhoanDoiUng.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_taiKhoanDoiUng.resetOriginalValues();
	}

	private final TaiKhoanDoiUng _taiKhoanDoiUng;

}