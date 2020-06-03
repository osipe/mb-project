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
 * This class is a wrapper for {@link MaSoThuChi}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MaSoThuChi
 * @generated
 */
@ProviderType
public class MaSoThuChiWrapper implements MaSoThuChi, ModelWrapper<MaSoThuChi> {

	public MaSoThuChiWrapper(MaSoThuChi maSoThuChi) {
		_maSoThuChi = maSoThuChi;
	}

	@Override
	public Class<?> getModelClass() {
		return MaSoThuChi.class;
	}

	@Override
	public String getModelClassName() {
		return MaSoThuChi.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("maSoThuChiId", getMaSoThuChiId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("ma", getMa());
		attributes.put("dienGiai", getDienGiai());
		attributes.put("dienGiaiTheoDoi", getDienGiaiTheoDoi());
		attributes.put("loai", getLoai());
		attributes.put("hoatDong", getHoatDong());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long maSoThuChiId = (Long)attributes.get("maSoThuChiId");

		if (maSoThuChiId != null) {
			setMaSoThuChiId(maSoThuChiId);
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

		String dienGiaiTheoDoi = (String)attributes.get("dienGiaiTheoDoi");

		if (dienGiaiTheoDoi != null) {
			setDienGiaiTheoDoi(dienGiaiTheoDoi);
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
		return new MaSoThuChiWrapper((MaSoThuChi)_maSoThuChi.clone());
	}

	@Override
	public int compareTo(MaSoThuChi maSoThuChi) {
		return _maSoThuChi.compareTo(maSoThuChi);
	}

	/**
	 * Returns the company ID of this ma so thu chi.
	 *
	 * @return the company ID of this ma so thu chi
	 */
	@Override
	public long getCompanyId() {
		return _maSoThuChi.getCompanyId();
	}

	/**
	 * Returns the create date of this ma so thu chi.
	 *
	 * @return the create date of this ma so thu chi
	 */
	@Override
	public Date getCreateDate() {
		return _maSoThuChi.getCreateDate();
	}

	/**
	 * Returns the dien giai of this ma so thu chi.
	 *
	 * @return the dien giai of this ma so thu chi
	 */
	@Override
	public String getDienGiai() {
		return _maSoThuChi.getDienGiai();
	}

	/**
	 * Returns the dien giai theo doi of this ma so thu chi.
	 *
	 * @return the dien giai theo doi of this ma so thu chi
	 */
	@Override
	public String getDienGiaiTheoDoi() {
		return _maSoThuChi.getDienGiaiTheoDoi();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _maSoThuChi.getExpandoBridge();
	}

	/**
	 * Returns the group ID of this ma so thu chi.
	 *
	 * @return the group ID of this ma so thu chi
	 */
	@Override
	public long getGroupId() {
		return _maSoThuChi.getGroupId();
	}

	/**
	 * Returns the hoat dong of this ma so thu chi.
	 *
	 * @return the hoat dong of this ma so thu chi
	 */
	@Override
	public Boolean getHoatDong() {
		return _maSoThuChi.getHoatDong();
	}

	/**
	 * Returns the loai of this ma so thu chi.
	 *
	 * @return the loai of this ma so thu chi
	 */
	@Override
	public int getLoai() {
		return _maSoThuChi.getLoai();
	}

	/**
	 * Returns the ma of this ma so thu chi.
	 *
	 * @return the ma of this ma so thu chi
	 */
	@Override
	public String getMa() {
		return _maSoThuChi.getMa();
	}

	/**
	 * Returns the ma so thu chi ID of this ma so thu chi.
	 *
	 * @return the ma so thu chi ID of this ma so thu chi
	 */
	@Override
	public long getMaSoThuChiId() {
		return _maSoThuChi.getMaSoThuChiId();
	}

	/**
	 * Returns the modified date of this ma so thu chi.
	 *
	 * @return the modified date of this ma so thu chi
	 */
	@Override
	public Date getModifiedDate() {
		return _maSoThuChi.getModifiedDate();
	}

	/**
	 * Returns the primary key of this ma so thu chi.
	 *
	 * @return the primary key of this ma so thu chi
	 */
	@Override
	public long getPrimaryKey() {
		return _maSoThuChi.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _maSoThuChi.getPrimaryKeyObj();
	}

	/**
	 * Returns the user ID of this ma so thu chi.
	 *
	 * @return the user ID of this ma so thu chi
	 */
	@Override
	public long getUserId() {
		return _maSoThuChi.getUserId();
	}

	/**
	 * Returns the user name of this ma so thu chi.
	 *
	 * @return the user name of this ma so thu chi
	 */
	@Override
	public String getUserName() {
		return _maSoThuChi.getUserName();
	}

	/**
	 * Returns the user uuid of this ma so thu chi.
	 *
	 * @return the user uuid of this ma so thu chi
	 */
	@Override
	public String getUserUuid() {
		return _maSoThuChi.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _maSoThuChi.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _maSoThuChi.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _maSoThuChi.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _maSoThuChi.isNew();
	}

	@Override
	public void persist() {
		_maSoThuChi.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_maSoThuChi.setCachedModel(cachedModel);
	}

	/**
	 * Sets the company ID of this ma so thu chi.
	 *
	 * @param companyId the company ID of this ma so thu chi
	 */
	@Override
	public void setCompanyId(long companyId) {
		_maSoThuChi.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this ma so thu chi.
	 *
	 * @param createDate the create date of this ma so thu chi
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_maSoThuChi.setCreateDate(createDate);
	}

	/**
	 * Sets the dien giai of this ma so thu chi.
	 *
	 * @param dienGiai the dien giai of this ma so thu chi
	 */
	@Override
	public void setDienGiai(String dienGiai) {
		_maSoThuChi.setDienGiai(dienGiai);
	}

	/**
	 * Sets the dien giai theo doi of this ma so thu chi.
	 *
	 * @param dienGiaiTheoDoi the dien giai theo doi of this ma so thu chi
	 */
	@Override
	public void setDienGiaiTheoDoi(String dienGiaiTheoDoi) {
		_maSoThuChi.setDienGiaiTheoDoi(dienGiaiTheoDoi);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_maSoThuChi.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_maSoThuChi.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_maSoThuChi.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the group ID of this ma so thu chi.
	 *
	 * @param groupId the group ID of this ma so thu chi
	 */
	@Override
	public void setGroupId(long groupId) {
		_maSoThuChi.setGroupId(groupId);
	}

	/**
	 * Sets the hoat dong of this ma so thu chi.
	 *
	 * @param hoatDong the hoat dong of this ma so thu chi
	 */
	@Override
	public void setHoatDong(Boolean hoatDong) {
		_maSoThuChi.setHoatDong(hoatDong);
	}

	/**
	 * Sets the loai of this ma so thu chi.
	 *
	 * @param loai the loai of this ma so thu chi
	 */
	@Override
	public void setLoai(int loai) {
		_maSoThuChi.setLoai(loai);
	}

	/**
	 * Sets the ma of this ma so thu chi.
	 *
	 * @param ma the ma of this ma so thu chi
	 */
	@Override
	public void setMa(String ma) {
		_maSoThuChi.setMa(ma);
	}

	/**
	 * Sets the ma so thu chi ID of this ma so thu chi.
	 *
	 * @param maSoThuChiId the ma so thu chi ID of this ma so thu chi
	 */
	@Override
	public void setMaSoThuChiId(long maSoThuChiId) {
		_maSoThuChi.setMaSoThuChiId(maSoThuChiId);
	}

	/**
	 * Sets the modified date of this ma so thu chi.
	 *
	 * @param modifiedDate the modified date of this ma so thu chi
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_maSoThuChi.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_maSoThuChi.setNew(n);
	}

	/**
	 * Sets the primary key of this ma so thu chi.
	 *
	 * @param primaryKey the primary key of this ma so thu chi
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_maSoThuChi.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_maSoThuChi.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the user ID of this ma so thu chi.
	 *
	 * @param userId the user ID of this ma so thu chi
	 */
	@Override
	public void setUserId(long userId) {
		_maSoThuChi.setUserId(userId);
	}

	/**
	 * Sets the user name of this ma so thu chi.
	 *
	 * @param userName the user name of this ma so thu chi
	 */
	@Override
	public void setUserName(String userName) {
		_maSoThuChi.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this ma so thu chi.
	 *
	 * @param userUuid the user uuid of this ma so thu chi
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_maSoThuChi.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<MaSoThuChi>
		toCacheModel() {

		return _maSoThuChi.toCacheModel();
	}

	@Override
	public MaSoThuChi toEscapedModel() {
		return new MaSoThuChiWrapper(_maSoThuChi.toEscapedModel());
	}

	@Override
	public String toString() {
		return _maSoThuChi.toString();
	}

	@Override
	public MaSoThuChi toUnescapedModel() {
		return new MaSoThuChiWrapper(_maSoThuChi.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _maSoThuChi.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MaSoThuChiWrapper)) {
			return false;
		}

		MaSoThuChiWrapper maSoThuChiWrapper = (MaSoThuChiWrapper)obj;

		if (Objects.equals(_maSoThuChi, maSoThuChiWrapper._maSoThuChi)) {
			return true;
		}

		return false;
	}

	@Override
	public MaSoThuChi getWrappedModel() {
		return _maSoThuChi;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _maSoThuChi.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _maSoThuChi.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_maSoThuChi.resetOriginalValues();
	}

	private final MaSoThuChi _maSoThuChi;

}