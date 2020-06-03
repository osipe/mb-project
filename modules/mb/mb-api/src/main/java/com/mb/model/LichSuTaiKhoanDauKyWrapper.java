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
 * This class is a wrapper for {@link LichSuTaiKhoanDauKy}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LichSuTaiKhoanDauKy
 * @generated
 */
@ProviderType
public class LichSuTaiKhoanDauKyWrapper
	implements LichSuTaiKhoanDauKy, ModelWrapper<LichSuTaiKhoanDauKy> {

	public LichSuTaiKhoanDauKyWrapper(LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy) {
		_lichSuTaiKhoanDauKy = lichSuTaiKhoanDauKy;
	}

	@Override
	public Class<?> getModelClass() {
		return LichSuTaiKhoanDauKy.class;
	}

	@Override
	public String getModelClassName() {
		return LichSuTaiKhoanDauKy.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("lichSuTaiKhoanDauKyId", getLichSuTaiKhoanDauKyId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("taiKhoanDoiUngId", getTaiKhoanDoiUngId());
		attributes.put("thang", getThang());
		attributes.put("nam", getNam());
		attributes.put("soTienTon", getSoTienTon());
		attributes.put("hoatDong", getHoatDong());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long lichSuTaiKhoanDauKyId = (Long)attributes.get(
			"lichSuTaiKhoanDauKyId");

		if (lichSuTaiKhoanDauKyId != null) {
			setLichSuTaiKhoanDauKyId(lichSuTaiKhoanDauKyId);
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

		Long taiKhoanDoiUngId = (Long)attributes.get("taiKhoanDoiUngId");

		if (taiKhoanDoiUngId != null) {
			setTaiKhoanDoiUngId(taiKhoanDoiUngId);
		}

		Integer thang = (Integer)attributes.get("thang");

		if (thang != null) {
			setThang(thang);
		}

		Integer nam = (Integer)attributes.get("nam");

		if (nam != null) {
			setNam(nam);
		}

		Double soTienTon = (Double)attributes.get("soTienTon");

		if (soTienTon != null) {
			setSoTienTon(soTienTon);
		}

		Boolean hoatDong = (Boolean)attributes.get("hoatDong");

		if (hoatDong != null) {
			setHoatDong(hoatDong);
		}
	}

	@Override
	public Object clone() {
		return new LichSuTaiKhoanDauKyWrapper(
			(LichSuTaiKhoanDauKy)_lichSuTaiKhoanDauKy.clone());
	}

	@Override
	public int compareTo(LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy) {
		return _lichSuTaiKhoanDauKy.compareTo(lichSuTaiKhoanDauKy);
	}

	/**
	 * Returns the company ID of this lich su tai khoan dau ky.
	 *
	 * @return the company ID of this lich su tai khoan dau ky
	 */
	@Override
	public long getCompanyId() {
		return _lichSuTaiKhoanDauKy.getCompanyId();
	}

	/**
	 * Returns the create date of this lich su tai khoan dau ky.
	 *
	 * @return the create date of this lich su tai khoan dau ky
	 */
	@Override
	public Date getCreateDate() {
		return _lichSuTaiKhoanDauKy.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _lichSuTaiKhoanDauKy.getExpandoBridge();
	}

	/**
	 * Returns the group ID of this lich su tai khoan dau ky.
	 *
	 * @return the group ID of this lich su tai khoan dau ky
	 */
	@Override
	public long getGroupId() {
		return _lichSuTaiKhoanDauKy.getGroupId();
	}

	/**
	 * Returns the hoat dong of this lich su tai khoan dau ky.
	 *
	 * @return the hoat dong of this lich su tai khoan dau ky
	 */
	@Override
	public Boolean getHoatDong() {
		return _lichSuTaiKhoanDauKy.getHoatDong();
	}

	/**
	 * Returns the lich su tai khoan dau ky ID of this lich su tai khoan dau ky.
	 *
	 * @return the lich su tai khoan dau ky ID of this lich su tai khoan dau ky
	 */
	@Override
	public long getLichSuTaiKhoanDauKyId() {
		return _lichSuTaiKhoanDauKy.getLichSuTaiKhoanDauKyId();
	}

	/**
	 * Returns the modified date of this lich su tai khoan dau ky.
	 *
	 * @return the modified date of this lich su tai khoan dau ky
	 */
	@Override
	public Date getModifiedDate() {
		return _lichSuTaiKhoanDauKy.getModifiedDate();
	}

	/**
	 * Returns the nam of this lich su tai khoan dau ky.
	 *
	 * @return the nam of this lich su tai khoan dau ky
	 */
	@Override
	public int getNam() {
		return _lichSuTaiKhoanDauKy.getNam();
	}

	/**
	 * Returns the primary key of this lich su tai khoan dau ky.
	 *
	 * @return the primary key of this lich su tai khoan dau ky
	 */
	@Override
	public long getPrimaryKey() {
		return _lichSuTaiKhoanDauKy.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _lichSuTaiKhoanDauKy.getPrimaryKeyObj();
	}

	/**
	 * Returns the so tien ton of this lich su tai khoan dau ky.
	 *
	 * @return the so tien ton of this lich su tai khoan dau ky
	 */
	@Override
	public Double getSoTienTon() {
		return _lichSuTaiKhoanDauKy.getSoTienTon();
	}

	/**
	 * Returns the tai khoan doi ung ID of this lich su tai khoan dau ky.
	 *
	 * @return the tai khoan doi ung ID of this lich su tai khoan dau ky
	 */
	@Override
	public long getTaiKhoanDoiUngId() {
		return _lichSuTaiKhoanDauKy.getTaiKhoanDoiUngId();
	}

	/**
	 * Returns the thang of this lich su tai khoan dau ky.
	 *
	 * @return the thang of this lich su tai khoan dau ky
	 */
	@Override
	public int getThang() {
		return _lichSuTaiKhoanDauKy.getThang();
	}

	/**
	 * Returns the user ID of this lich su tai khoan dau ky.
	 *
	 * @return the user ID of this lich su tai khoan dau ky
	 */
	@Override
	public long getUserId() {
		return _lichSuTaiKhoanDauKy.getUserId();
	}

	/**
	 * Returns the user name of this lich su tai khoan dau ky.
	 *
	 * @return the user name of this lich su tai khoan dau ky
	 */
	@Override
	public String getUserName() {
		return _lichSuTaiKhoanDauKy.getUserName();
	}

	/**
	 * Returns the user uuid of this lich su tai khoan dau ky.
	 *
	 * @return the user uuid of this lich su tai khoan dau ky
	 */
	@Override
	public String getUserUuid() {
		return _lichSuTaiKhoanDauKy.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _lichSuTaiKhoanDauKy.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _lichSuTaiKhoanDauKy.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _lichSuTaiKhoanDauKy.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _lichSuTaiKhoanDauKy.isNew();
	}

	@Override
	public void persist() {
		_lichSuTaiKhoanDauKy.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_lichSuTaiKhoanDauKy.setCachedModel(cachedModel);
	}

	/**
	 * Sets the company ID of this lich su tai khoan dau ky.
	 *
	 * @param companyId the company ID of this lich su tai khoan dau ky
	 */
	@Override
	public void setCompanyId(long companyId) {
		_lichSuTaiKhoanDauKy.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this lich su tai khoan dau ky.
	 *
	 * @param createDate the create date of this lich su tai khoan dau ky
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_lichSuTaiKhoanDauKy.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_lichSuTaiKhoanDauKy.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_lichSuTaiKhoanDauKy.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_lichSuTaiKhoanDauKy.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the group ID of this lich su tai khoan dau ky.
	 *
	 * @param groupId the group ID of this lich su tai khoan dau ky
	 */
	@Override
	public void setGroupId(long groupId) {
		_lichSuTaiKhoanDauKy.setGroupId(groupId);
	}

	/**
	 * Sets the hoat dong of this lich su tai khoan dau ky.
	 *
	 * @param hoatDong the hoat dong of this lich su tai khoan dau ky
	 */
	@Override
	public void setHoatDong(Boolean hoatDong) {
		_lichSuTaiKhoanDauKy.setHoatDong(hoatDong);
	}

	/**
	 * Sets the lich su tai khoan dau ky ID of this lich su tai khoan dau ky.
	 *
	 * @param lichSuTaiKhoanDauKyId the lich su tai khoan dau ky ID of this lich su tai khoan dau ky
	 */
	@Override
	public void setLichSuTaiKhoanDauKyId(long lichSuTaiKhoanDauKyId) {
		_lichSuTaiKhoanDauKy.setLichSuTaiKhoanDauKyId(lichSuTaiKhoanDauKyId);
	}

	/**
	 * Sets the modified date of this lich su tai khoan dau ky.
	 *
	 * @param modifiedDate the modified date of this lich su tai khoan dau ky
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_lichSuTaiKhoanDauKy.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the nam of this lich su tai khoan dau ky.
	 *
	 * @param nam the nam of this lich su tai khoan dau ky
	 */
	@Override
	public void setNam(int nam) {
		_lichSuTaiKhoanDauKy.setNam(nam);
	}

	@Override
	public void setNew(boolean n) {
		_lichSuTaiKhoanDauKy.setNew(n);
	}

	/**
	 * Sets the primary key of this lich su tai khoan dau ky.
	 *
	 * @param primaryKey the primary key of this lich su tai khoan dau ky
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_lichSuTaiKhoanDauKy.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_lichSuTaiKhoanDauKy.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the so tien ton of this lich su tai khoan dau ky.
	 *
	 * @param soTienTon the so tien ton of this lich su tai khoan dau ky
	 */
	@Override
	public void setSoTienTon(Double soTienTon) {
		_lichSuTaiKhoanDauKy.setSoTienTon(soTienTon);
	}

	/**
	 * Sets the tai khoan doi ung ID of this lich su tai khoan dau ky.
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID of this lich su tai khoan dau ky
	 */
	@Override
	public void setTaiKhoanDoiUngId(long taiKhoanDoiUngId) {
		_lichSuTaiKhoanDauKy.setTaiKhoanDoiUngId(taiKhoanDoiUngId);
	}

	/**
	 * Sets the thang of this lich su tai khoan dau ky.
	 *
	 * @param thang the thang of this lich su tai khoan dau ky
	 */
	@Override
	public void setThang(int thang) {
		_lichSuTaiKhoanDauKy.setThang(thang);
	}

	/**
	 * Sets the user ID of this lich su tai khoan dau ky.
	 *
	 * @param userId the user ID of this lich su tai khoan dau ky
	 */
	@Override
	public void setUserId(long userId) {
		_lichSuTaiKhoanDauKy.setUserId(userId);
	}

	/**
	 * Sets the user name of this lich su tai khoan dau ky.
	 *
	 * @param userName the user name of this lich su tai khoan dau ky
	 */
	@Override
	public void setUserName(String userName) {
		_lichSuTaiKhoanDauKy.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this lich su tai khoan dau ky.
	 *
	 * @param userUuid the user uuid of this lich su tai khoan dau ky
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_lichSuTaiKhoanDauKy.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<LichSuTaiKhoanDauKy>
		toCacheModel() {

		return _lichSuTaiKhoanDauKy.toCacheModel();
	}

	@Override
	public LichSuTaiKhoanDauKy toEscapedModel() {
		return new LichSuTaiKhoanDauKyWrapper(
			_lichSuTaiKhoanDauKy.toEscapedModel());
	}

	@Override
	public String toString() {
		return _lichSuTaiKhoanDauKy.toString();
	}

	@Override
	public LichSuTaiKhoanDauKy toUnescapedModel() {
		return new LichSuTaiKhoanDauKyWrapper(
			_lichSuTaiKhoanDauKy.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _lichSuTaiKhoanDauKy.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LichSuTaiKhoanDauKyWrapper)) {
			return false;
		}

		LichSuTaiKhoanDauKyWrapper lichSuTaiKhoanDauKyWrapper =
			(LichSuTaiKhoanDauKyWrapper)obj;

		if (Objects.equals(
				_lichSuTaiKhoanDauKy,
				lichSuTaiKhoanDauKyWrapper._lichSuTaiKhoanDauKy)) {

			return true;
		}

		return false;
	}

	@Override
	public LichSuTaiKhoanDauKy getWrappedModel() {
		return _lichSuTaiKhoanDauKy;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _lichSuTaiKhoanDauKy.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _lichSuTaiKhoanDauKy.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_lichSuTaiKhoanDauKy.resetOriginalValues();
	}

	private final LichSuTaiKhoanDauKy _lichSuTaiKhoanDauKy;

}