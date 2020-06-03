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
 * This class is a wrapper for {@link MaSoTheoDoi}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MaSoTheoDoi
 * @generated
 */
@ProviderType
public class MaSoTheoDoiWrapper
	implements MaSoTheoDoi, ModelWrapper<MaSoTheoDoi> {

	public MaSoTheoDoiWrapper(MaSoTheoDoi maSoTheoDoi) {
		_maSoTheoDoi = maSoTheoDoi;
	}

	@Override
	public Class<?> getModelClass() {
		return MaSoTheoDoi.class;
	}

	@Override
	public String getModelClassName() {
		return MaSoTheoDoi.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("maSoTheoDoiId", getMaSoTheoDoiId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("ma", getMa());
		attributes.put("dienGiai", getDienGiai());
		attributes.put("hoatDong", getHoatDong());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long maSoTheoDoiId = (Long)attributes.get("maSoTheoDoiId");

		if (maSoTheoDoiId != null) {
			setMaSoTheoDoiId(maSoTheoDoiId);
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

		String dienGiai = (String)attributes.get("dienGiai");

		if (dienGiai != null) {
			setDienGiai(dienGiai);
		}

		Boolean hoatDong = (Boolean)attributes.get("hoatDong");

		if (hoatDong != null) {
			setHoatDong(hoatDong);
		}
	}

	@Override
	public Object clone() {
		return new MaSoTheoDoiWrapper((MaSoTheoDoi)_maSoTheoDoi.clone());
	}

	@Override
	public int compareTo(MaSoTheoDoi maSoTheoDoi) {
		return _maSoTheoDoi.compareTo(maSoTheoDoi);
	}

	/**
	 * Returns the company ID of this ma so theo doi.
	 *
	 * @return the company ID of this ma so theo doi
	 */
	@Override
	public long getCompanyId() {
		return _maSoTheoDoi.getCompanyId();
	}

	/**
	 * Returns the create date of this ma so theo doi.
	 *
	 * @return the create date of this ma so theo doi
	 */
	@Override
	public Date getCreateDate() {
		return _maSoTheoDoi.getCreateDate();
	}

	/**
	 * Returns the dien giai of this ma so theo doi.
	 *
	 * @return the dien giai of this ma so theo doi
	 */
	@Override
	public String getDienGiai() {
		return _maSoTheoDoi.getDienGiai();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _maSoTheoDoi.getExpandoBridge();
	}

	/**
	 * Returns the group ID of this ma so theo doi.
	 *
	 * @return the group ID of this ma so theo doi
	 */
	@Override
	public long getGroupId() {
		return _maSoTheoDoi.getGroupId();
	}

	/**
	 * Returns the hoat dong of this ma so theo doi.
	 *
	 * @return the hoat dong of this ma so theo doi
	 */
	@Override
	public Boolean getHoatDong() {
		return _maSoTheoDoi.getHoatDong();
	}

	/**
	 * Returns the ma of this ma so theo doi.
	 *
	 * @return the ma of this ma so theo doi
	 */
	@Override
	public String getMa() {
		return _maSoTheoDoi.getMa();
	}

	/**
	 * Returns the ma so theo doi ID of this ma so theo doi.
	 *
	 * @return the ma so theo doi ID of this ma so theo doi
	 */
	@Override
	public long getMaSoTheoDoiId() {
		return _maSoTheoDoi.getMaSoTheoDoiId();
	}

	/**
	 * Returns the modified date of this ma so theo doi.
	 *
	 * @return the modified date of this ma so theo doi
	 */
	@Override
	public Date getModifiedDate() {
		return _maSoTheoDoi.getModifiedDate();
	}

	/**
	 * Returns the primary key of this ma so theo doi.
	 *
	 * @return the primary key of this ma so theo doi
	 */
	@Override
	public long getPrimaryKey() {
		return _maSoTheoDoi.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _maSoTheoDoi.getPrimaryKeyObj();
	}

	/**
	 * Returns the user ID of this ma so theo doi.
	 *
	 * @return the user ID of this ma so theo doi
	 */
	@Override
	public long getUserId() {
		return _maSoTheoDoi.getUserId();
	}

	/**
	 * Returns the user name of this ma so theo doi.
	 *
	 * @return the user name of this ma so theo doi
	 */
	@Override
	public String getUserName() {
		return _maSoTheoDoi.getUserName();
	}

	/**
	 * Returns the user uuid of this ma so theo doi.
	 *
	 * @return the user uuid of this ma so theo doi
	 */
	@Override
	public String getUserUuid() {
		return _maSoTheoDoi.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _maSoTheoDoi.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _maSoTheoDoi.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _maSoTheoDoi.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _maSoTheoDoi.isNew();
	}

	@Override
	public void persist() {
		_maSoTheoDoi.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_maSoTheoDoi.setCachedModel(cachedModel);
	}

	/**
	 * Sets the company ID of this ma so theo doi.
	 *
	 * @param companyId the company ID of this ma so theo doi
	 */
	@Override
	public void setCompanyId(long companyId) {
		_maSoTheoDoi.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this ma so theo doi.
	 *
	 * @param createDate the create date of this ma so theo doi
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_maSoTheoDoi.setCreateDate(createDate);
	}

	/**
	 * Sets the dien giai of this ma so theo doi.
	 *
	 * @param dienGiai the dien giai of this ma so theo doi
	 */
	@Override
	public void setDienGiai(String dienGiai) {
		_maSoTheoDoi.setDienGiai(dienGiai);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_maSoTheoDoi.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_maSoTheoDoi.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_maSoTheoDoi.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the group ID of this ma so theo doi.
	 *
	 * @param groupId the group ID of this ma so theo doi
	 */
	@Override
	public void setGroupId(long groupId) {
		_maSoTheoDoi.setGroupId(groupId);
	}

	/**
	 * Sets the hoat dong of this ma so theo doi.
	 *
	 * @param hoatDong the hoat dong of this ma so theo doi
	 */
	@Override
	public void setHoatDong(Boolean hoatDong) {
		_maSoTheoDoi.setHoatDong(hoatDong);
	}

	/**
	 * Sets the ma of this ma so theo doi.
	 *
	 * @param ma the ma of this ma so theo doi
	 */
	@Override
	public void setMa(String ma) {
		_maSoTheoDoi.setMa(ma);
	}

	/**
	 * Sets the ma so theo doi ID of this ma so theo doi.
	 *
	 * @param maSoTheoDoiId the ma so theo doi ID of this ma so theo doi
	 */
	@Override
	public void setMaSoTheoDoiId(long maSoTheoDoiId) {
		_maSoTheoDoi.setMaSoTheoDoiId(maSoTheoDoiId);
	}

	/**
	 * Sets the modified date of this ma so theo doi.
	 *
	 * @param modifiedDate the modified date of this ma so theo doi
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_maSoTheoDoi.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_maSoTheoDoi.setNew(n);
	}

	/**
	 * Sets the primary key of this ma so theo doi.
	 *
	 * @param primaryKey the primary key of this ma so theo doi
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_maSoTheoDoi.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_maSoTheoDoi.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the user ID of this ma so theo doi.
	 *
	 * @param userId the user ID of this ma so theo doi
	 */
	@Override
	public void setUserId(long userId) {
		_maSoTheoDoi.setUserId(userId);
	}

	/**
	 * Sets the user name of this ma so theo doi.
	 *
	 * @param userName the user name of this ma so theo doi
	 */
	@Override
	public void setUserName(String userName) {
		_maSoTheoDoi.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this ma so theo doi.
	 *
	 * @param userUuid the user uuid of this ma so theo doi
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_maSoTheoDoi.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<MaSoTheoDoi>
		toCacheModel() {

		return _maSoTheoDoi.toCacheModel();
	}

	@Override
	public MaSoTheoDoi toEscapedModel() {
		return new MaSoTheoDoiWrapper(_maSoTheoDoi.toEscapedModel());
	}

	@Override
	public String toString() {
		return _maSoTheoDoi.toString();
	}

	@Override
	public MaSoTheoDoi toUnescapedModel() {
		return new MaSoTheoDoiWrapper(_maSoTheoDoi.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _maSoTheoDoi.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MaSoTheoDoiWrapper)) {
			return false;
		}

		MaSoTheoDoiWrapper maSoTheoDoiWrapper = (MaSoTheoDoiWrapper)obj;

		if (Objects.equals(_maSoTheoDoi, maSoTheoDoiWrapper._maSoTheoDoi)) {
			return true;
		}

		return false;
	}

	@Override
	public MaSoTheoDoi getWrappedModel() {
		return _maSoTheoDoi;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _maSoTheoDoi.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _maSoTheoDoi.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_maSoTheoDoi.resetOriginalValues();
	}

	private final MaSoTheoDoi _maSoTheoDoi;

}