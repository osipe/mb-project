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
 * This class is a wrapper for {@link CauHinhThuTienTruoc}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CauHinhThuTienTruoc
 * @generated
 */
@ProviderType
public class CauHinhThuTienTruocWrapper
	implements CauHinhThuTienTruoc, ModelWrapper<CauHinhThuTienTruoc> {

	public CauHinhThuTienTruocWrapper(CauHinhThuTienTruoc cauHinhThuTienTruoc) {
		_cauHinhThuTienTruoc = cauHinhThuTienTruoc;
	}

	@Override
	public Class<?> getModelClass() {
		return CauHinhThuTienTruoc.class;
	}

	@Override
	public String getModelClassName() {
		return CauHinhThuTienTruoc.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("cauHinhThuTienTruocId", getCauHinhThuTienTruocId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("nam", getNam());
		attributes.put("ngayTu", getNgayTu());
		attributes.put("ngayDen", getNgayDen());
		attributes.put("hoatDong", getHoatDong());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long cauHinhThuTienTruocId = (Long)attributes.get(
			"cauHinhThuTienTruocId");

		if (cauHinhThuTienTruocId != null) {
			setCauHinhThuTienTruocId(cauHinhThuTienTruocId);
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

		Integer nam = (Integer)attributes.get("nam");

		if (nam != null) {
			setNam(nam);
		}

		Date ngayTu = (Date)attributes.get("ngayTu");

		if (ngayTu != null) {
			setNgayTu(ngayTu);
		}

		Date ngayDen = (Date)attributes.get("ngayDen");

		if (ngayDen != null) {
			setNgayDen(ngayDen);
		}

		Boolean hoatDong = (Boolean)attributes.get("hoatDong");

		if (hoatDong != null) {
			setHoatDong(hoatDong);
		}
	}

	@Override
	public Object clone() {
		return new CauHinhThuTienTruocWrapper(
			(CauHinhThuTienTruoc)_cauHinhThuTienTruoc.clone());
	}

	@Override
	public int compareTo(CauHinhThuTienTruoc cauHinhThuTienTruoc) {
		return _cauHinhThuTienTruoc.compareTo(cauHinhThuTienTruoc);
	}

	/**
	 * Returns the cau hinh thu tien truoc ID of this cau hinh thu tien truoc.
	 *
	 * @return the cau hinh thu tien truoc ID of this cau hinh thu tien truoc
	 */
	@Override
	public long getCauHinhThuTienTruocId() {
		return _cauHinhThuTienTruoc.getCauHinhThuTienTruocId();
	}

	/**
	 * Returns the company ID of this cau hinh thu tien truoc.
	 *
	 * @return the company ID of this cau hinh thu tien truoc
	 */
	@Override
	public long getCompanyId() {
		return _cauHinhThuTienTruoc.getCompanyId();
	}

	/**
	 * Returns the create date of this cau hinh thu tien truoc.
	 *
	 * @return the create date of this cau hinh thu tien truoc
	 */
	@Override
	public Date getCreateDate() {
		return _cauHinhThuTienTruoc.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _cauHinhThuTienTruoc.getExpandoBridge();
	}

	/**
	 * Returns the group ID of this cau hinh thu tien truoc.
	 *
	 * @return the group ID of this cau hinh thu tien truoc
	 */
	@Override
	public long getGroupId() {
		return _cauHinhThuTienTruoc.getGroupId();
	}

	/**
	 * Returns the hoat dong of this cau hinh thu tien truoc.
	 *
	 * @return the hoat dong of this cau hinh thu tien truoc
	 */
	@Override
	public Boolean getHoatDong() {
		return _cauHinhThuTienTruoc.getHoatDong();
	}

	/**
	 * Returns the modified date of this cau hinh thu tien truoc.
	 *
	 * @return the modified date of this cau hinh thu tien truoc
	 */
	@Override
	public Date getModifiedDate() {
		return _cauHinhThuTienTruoc.getModifiedDate();
	}

	/**
	 * Returns the nam of this cau hinh thu tien truoc.
	 *
	 * @return the nam of this cau hinh thu tien truoc
	 */
	@Override
	public int getNam() {
		return _cauHinhThuTienTruoc.getNam();
	}

	/**
	 * Returns the ngay den of this cau hinh thu tien truoc.
	 *
	 * @return the ngay den of this cau hinh thu tien truoc
	 */
	@Override
	public Date getNgayDen() {
		return _cauHinhThuTienTruoc.getNgayDen();
	}

	/**
	 * Returns the ngay tu of this cau hinh thu tien truoc.
	 *
	 * @return the ngay tu of this cau hinh thu tien truoc
	 */
	@Override
	public Date getNgayTu() {
		return _cauHinhThuTienTruoc.getNgayTu();
	}

	/**
	 * Returns the primary key of this cau hinh thu tien truoc.
	 *
	 * @return the primary key of this cau hinh thu tien truoc
	 */
	@Override
	public long getPrimaryKey() {
		return _cauHinhThuTienTruoc.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _cauHinhThuTienTruoc.getPrimaryKeyObj();
	}

	/**
	 * Returns the user ID of this cau hinh thu tien truoc.
	 *
	 * @return the user ID of this cau hinh thu tien truoc
	 */
	@Override
	public long getUserId() {
		return _cauHinhThuTienTruoc.getUserId();
	}

	/**
	 * Returns the user name of this cau hinh thu tien truoc.
	 *
	 * @return the user name of this cau hinh thu tien truoc
	 */
	@Override
	public String getUserName() {
		return _cauHinhThuTienTruoc.getUserName();
	}

	/**
	 * Returns the user uuid of this cau hinh thu tien truoc.
	 *
	 * @return the user uuid of this cau hinh thu tien truoc
	 */
	@Override
	public String getUserUuid() {
		return _cauHinhThuTienTruoc.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _cauHinhThuTienTruoc.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _cauHinhThuTienTruoc.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _cauHinhThuTienTruoc.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _cauHinhThuTienTruoc.isNew();
	}

	@Override
	public void persist() {
		_cauHinhThuTienTruoc.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_cauHinhThuTienTruoc.setCachedModel(cachedModel);
	}

	/**
	 * Sets the cau hinh thu tien truoc ID of this cau hinh thu tien truoc.
	 *
	 * @param cauHinhThuTienTruocId the cau hinh thu tien truoc ID of this cau hinh thu tien truoc
	 */
	@Override
	public void setCauHinhThuTienTruocId(long cauHinhThuTienTruocId) {
		_cauHinhThuTienTruoc.setCauHinhThuTienTruocId(cauHinhThuTienTruocId);
	}

	/**
	 * Sets the company ID of this cau hinh thu tien truoc.
	 *
	 * @param companyId the company ID of this cau hinh thu tien truoc
	 */
	@Override
	public void setCompanyId(long companyId) {
		_cauHinhThuTienTruoc.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this cau hinh thu tien truoc.
	 *
	 * @param createDate the create date of this cau hinh thu tien truoc
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_cauHinhThuTienTruoc.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_cauHinhThuTienTruoc.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_cauHinhThuTienTruoc.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_cauHinhThuTienTruoc.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the group ID of this cau hinh thu tien truoc.
	 *
	 * @param groupId the group ID of this cau hinh thu tien truoc
	 */
	@Override
	public void setGroupId(long groupId) {
		_cauHinhThuTienTruoc.setGroupId(groupId);
	}

	/**
	 * Sets the hoat dong of this cau hinh thu tien truoc.
	 *
	 * @param hoatDong the hoat dong of this cau hinh thu tien truoc
	 */
	@Override
	public void setHoatDong(Boolean hoatDong) {
		_cauHinhThuTienTruoc.setHoatDong(hoatDong);
	}

	/**
	 * Sets the modified date of this cau hinh thu tien truoc.
	 *
	 * @param modifiedDate the modified date of this cau hinh thu tien truoc
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_cauHinhThuTienTruoc.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the nam of this cau hinh thu tien truoc.
	 *
	 * @param nam the nam of this cau hinh thu tien truoc
	 */
	@Override
	public void setNam(int nam) {
		_cauHinhThuTienTruoc.setNam(nam);
	}

	@Override
	public void setNew(boolean n) {
		_cauHinhThuTienTruoc.setNew(n);
	}

	/**
	 * Sets the ngay den of this cau hinh thu tien truoc.
	 *
	 * @param ngayDen the ngay den of this cau hinh thu tien truoc
	 */
	@Override
	public void setNgayDen(Date ngayDen) {
		_cauHinhThuTienTruoc.setNgayDen(ngayDen);
	}

	/**
	 * Sets the ngay tu of this cau hinh thu tien truoc.
	 *
	 * @param ngayTu the ngay tu of this cau hinh thu tien truoc
	 */
	@Override
	public void setNgayTu(Date ngayTu) {
		_cauHinhThuTienTruoc.setNgayTu(ngayTu);
	}

	/**
	 * Sets the primary key of this cau hinh thu tien truoc.
	 *
	 * @param primaryKey the primary key of this cau hinh thu tien truoc
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_cauHinhThuTienTruoc.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_cauHinhThuTienTruoc.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the user ID of this cau hinh thu tien truoc.
	 *
	 * @param userId the user ID of this cau hinh thu tien truoc
	 */
	@Override
	public void setUserId(long userId) {
		_cauHinhThuTienTruoc.setUserId(userId);
	}

	/**
	 * Sets the user name of this cau hinh thu tien truoc.
	 *
	 * @param userName the user name of this cau hinh thu tien truoc
	 */
	@Override
	public void setUserName(String userName) {
		_cauHinhThuTienTruoc.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this cau hinh thu tien truoc.
	 *
	 * @param userUuid the user uuid of this cau hinh thu tien truoc
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_cauHinhThuTienTruoc.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<CauHinhThuTienTruoc>
		toCacheModel() {

		return _cauHinhThuTienTruoc.toCacheModel();
	}

	@Override
	public CauHinhThuTienTruoc toEscapedModel() {
		return new CauHinhThuTienTruocWrapper(
			_cauHinhThuTienTruoc.toEscapedModel());
	}

	@Override
	public String toString() {
		return _cauHinhThuTienTruoc.toString();
	}

	@Override
	public CauHinhThuTienTruoc toUnescapedModel() {
		return new CauHinhThuTienTruocWrapper(
			_cauHinhThuTienTruoc.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _cauHinhThuTienTruoc.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CauHinhThuTienTruocWrapper)) {
			return false;
		}

		CauHinhThuTienTruocWrapper cauHinhThuTienTruocWrapper =
			(CauHinhThuTienTruocWrapper)obj;

		if (Objects.equals(
				_cauHinhThuTienTruoc,
				cauHinhThuTienTruocWrapper._cauHinhThuTienTruoc)) {

			return true;
		}

		return false;
	}

	@Override
	public CauHinhThuTienTruoc getWrappedModel() {
		return _cauHinhThuTienTruoc;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _cauHinhThuTienTruoc.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _cauHinhThuTienTruoc.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_cauHinhThuTienTruoc.resetOriginalValues();
	}

	private final CauHinhThuTienTruoc _cauHinhThuTienTruoc;

}