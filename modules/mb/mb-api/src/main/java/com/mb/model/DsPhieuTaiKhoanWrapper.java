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
 * This class is a wrapper for {@link DsPhieuTaiKhoan}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DsPhieuTaiKhoan
 * @generated
 */
@ProviderType
public class DsPhieuTaiKhoanWrapper
	implements DsPhieuTaiKhoan, ModelWrapper<DsPhieuTaiKhoan> {

	public DsPhieuTaiKhoanWrapper(DsPhieuTaiKhoan dsPhieuTaiKhoan) {
		_dsPhieuTaiKhoan = dsPhieuTaiKhoan;
	}

	@Override
	public Class<?> getModelClass() {
		return DsPhieuTaiKhoan.class;
	}

	@Override
	public String getModelClassName() {
		return DsPhieuTaiKhoan.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dsPhieuTaiKhoanId", getDsPhieuTaiKhoanId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("phieuId", getPhieuId());
		attributes.put("ngayChungTu", getNgayChungTu());
		attributes.put("taiKhoanDoiUngId", getTaiKhoanDoiUngId());
		attributes.put("maTheoDoi", getMaTheoDoi());
		attributes.put("dienGiaiTheoDoi", getDienGiaiTheoDoi());
		attributes.put("soTien", getSoTien());
		attributes.put("tenCTV", getTenCTV());
		attributes.put("hoatDong", getHoatDong());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dsPhieuTaiKhoanId = (Long)attributes.get("dsPhieuTaiKhoanId");

		if (dsPhieuTaiKhoanId != null) {
			setDsPhieuTaiKhoanId(dsPhieuTaiKhoanId);
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

		Long phieuId = (Long)attributes.get("phieuId");

		if (phieuId != null) {
			setPhieuId(phieuId);
		}

		Date ngayChungTu = (Date)attributes.get("ngayChungTu");

		if (ngayChungTu != null) {
			setNgayChungTu(ngayChungTu);
		}

		Long taiKhoanDoiUngId = (Long)attributes.get("taiKhoanDoiUngId");

		if (taiKhoanDoiUngId != null) {
			setTaiKhoanDoiUngId(taiKhoanDoiUngId);
		}

		String maTheoDoi = (String)attributes.get("maTheoDoi");

		if (maTheoDoi != null) {
			setMaTheoDoi(maTheoDoi);
		}

		String dienGiaiTheoDoi = (String)attributes.get("dienGiaiTheoDoi");

		if (dienGiaiTheoDoi != null) {
			setDienGiaiTheoDoi(dienGiaiTheoDoi);
		}

		Double soTien = (Double)attributes.get("soTien");

		if (soTien != null) {
			setSoTien(soTien);
		}

		String tenCTV = (String)attributes.get("tenCTV");

		if (tenCTV != null) {
			setTenCTV(tenCTV);
		}

		Boolean hoatDong = (Boolean)attributes.get("hoatDong");

		if (hoatDong != null) {
			setHoatDong(hoatDong);
		}
	}

	@Override
	public Object clone() {
		return new DsPhieuTaiKhoanWrapper(
			(DsPhieuTaiKhoan)_dsPhieuTaiKhoan.clone());
	}

	@Override
	public int compareTo(DsPhieuTaiKhoan dsPhieuTaiKhoan) {
		return _dsPhieuTaiKhoan.compareTo(dsPhieuTaiKhoan);
	}

	/**
	 * Returns the company ID of this ds phieu tai khoan.
	 *
	 * @return the company ID of this ds phieu tai khoan
	 */
	@Override
	public long getCompanyId() {
		return _dsPhieuTaiKhoan.getCompanyId();
	}

	/**
	 * Returns the create date of this ds phieu tai khoan.
	 *
	 * @return the create date of this ds phieu tai khoan
	 */
	@Override
	public Date getCreateDate() {
		return _dsPhieuTaiKhoan.getCreateDate();
	}

	/**
	 * Returns the dien giai theo doi of this ds phieu tai khoan.
	 *
	 * @return the dien giai theo doi of this ds phieu tai khoan
	 */
	@Override
	public String getDienGiaiTheoDoi() {
		return _dsPhieuTaiKhoan.getDienGiaiTheoDoi();
	}

	/**
	 * Returns the ds phieu tai khoan ID of this ds phieu tai khoan.
	 *
	 * @return the ds phieu tai khoan ID of this ds phieu tai khoan
	 */
	@Override
	public long getDsPhieuTaiKhoanId() {
		return _dsPhieuTaiKhoan.getDsPhieuTaiKhoanId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _dsPhieuTaiKhoan.getExpandoBridge();
	}

	/**
	 * Returns the group ID of this ds phieu tai khoan.
	 *
	 * @return the group ID of this ds phieu tai khoan
	 */
	@Override
	public long getGroupId() {
		return _dsPhieuTaiKhoan.getGroupId();
	}

	/**
	 * Returns the hoat dong of this ds phieu tai khoan.
	 *
	 * @return the hoat dong of this ds phieu tai khoan
	 */
	@Override
	public Boolean getHoatDong() {
		return _dsPhieuTaiKhoan.getHoatDong();
	}

	/**
	 * Returns the ma theo doi of this ds phieu tai khoan.
	 *
	 * @return the ma theo doi of this ds phieu tai khoan
	 */
	@Override
	public String getMaTheoDoi() {
		return _dsPhieuTaiKhoan.getMaTheoDoi();
	}

	/**
	 * Returns the modified date of this ds phieu tai khoan.
	 *
	 * @return the modified date of this ds phieu tai khoan
	 */
	@Override
	public Date getModifiedDate() {
		return _dsPhieuTaiKhoan.getModifiedDate();
	}

	/**
	 * Returns the ngay chung tu of this ds phieu tai khoan.
	 *
	 * @return the ngay chung tu of this ds phieu tai khoan
	 */
	@Override
	public Date getNgayChungTu() {
		return _dsPhieuTaiKhoan.getNgayChungTu();
	}

	@Override
	public Phieu getPhieu() {
		return _dsPhieuTaiKhoan.getPhieu();
	}

	/**
	 * Returns the phieu ID of this ds phieu tai khoan.
	 *
	 * @return the phieu ID of this ds phieu tai khoan
	 */
	@Override
	public long getPhieuId() {
		return _dsPhieuTaiKhoan.getPhieuId();
	}

	/**
	 * Returns the primary key of this ds phieu tai khoan.
	 *
	 * @return the primary key of this ds phieu tai khoan
	 */
	@Override
	public long getPrimaryKey() {
		return _dsPhieuTaiKhoan.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dsPhieuTaiKhoan.getPrimaryKeyObj();
	}

	/**
	 * Returns the so tien of this ds phieu tai khoan.
	 *
	 * @return the so tien of this ds phieu tai khoan
	 */
	@Override
	public Double getSoTien() {
		return _dsPhieuTaiKhoan.getSoTien();
	}

	@Override
	public TaiKhoanDoiUng getTaiKhoanDoiUng() {
		return _dsPhieuTaiKhoan.getTaiKhoanDoiUng();
	}

	/**
	 * Returns the tai khoan doi ung ID of this ds phieu tai khoan.
	 *
	 * @return the tai khoan doi ung ID of this ds phieu tai khoan
	 */
	@Override
	public long getTaiKhoanDoiUngId() {
		return _dsPhieuTaiKhoan.getTaiKhoanDoiUngId();
	}

	/**
	 * Returns the ten ctv of this ds phieu tai khoan.
	 *
	 * @return the ten ctv of this ds phieu tai khoan
	 */
	@Override
	public String getTenCTV() {
		return _dsPhieuTaiKhoan.getTenCTV();
	}

	/**
	 * Returns the user ID of this ds phieu tai khoan.
	 *
	 * @return the user ID of this ds phieu tai khoan
	 */
	@Override
	public long getUserId() {
		return _dsPhieuTaiKhoan.getUserId();
	}

	/**
	 * Returns the user name of this ds phieu tai khoan.
	 *
	 * @return the user name of this ds phieu tai khoan
	 */
	@Override
	public String getUserName() {
		return _dsPhieuTaiKhoan.getUserName();
	}

	/**
	 * Returns the user uuid of this ds phieu tai khoan.
	 *
	 * @return the user uuid of this ds phieu tai khoan
	 */
	@Override
	public String getUserUuid() {
		return _dsPhieuTaiKhoan.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _dsPhieuTaiKhoan.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _dsPhieuTaiKhoan.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _dsPhieuTaiKhoan.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _dsPhieuTaiKhoan.isNew();
	}

	@Override
	public void persist() {
		_dsPhieuTaiKhoan.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_dsPhieuTaiKhoan.setCachedModel(cachedModel);
	}

	/**
	 * Sets the company ID of this ds phieu tai khoan.
	 *
	 * @param companyId the company ID of this ds phieu tai khoan
	 */
	@Override
	public void setCompanyId(long companyId) {
		_dsPhieuTaiKhoan.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this ds phieu tai khoan.
	 *
	 * @param createDate the create date of this ds phieu tai khoan
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_dsPhieuTaiKhoan.setCreateDate(createDate);
	}

	/**
	 * Sets the dien giai theo doi of this ds phieu tai khoan.
	 *
	 * @param dienGiaiTheoDoi the dien giai theo doi of this ds phieu tai khoan
	 */
	@Override
	public void setDienGiaiTheoDoi(String dienGiaiTheoDoi) {
		_dsPhieuTaiKhoan.setDienGiaiTheoDoi(dienGiaiTheoDoi);
	}

	/**
	 * Sets the ds phieu tai khoan ID of this ds phieu tai khoan.
	 *
	 * @param dsPhieuTaiKhoanId the ds phieu tai khoan ID of this ds phieu tai khoan
	 */
	@Override
	public void setDsPhieuTaiKhoanId(long dsPhieuTaiKhoanId) {
		_dsPhieuTaiKhoan.setDsPhieuTaiKhoanId(dsPhieuTaiKhoanId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_dsPhieuTaiKhoan.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_dsPhieuTaiKhoan.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_dsPhieuTaiKhoan.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the group ID of this ds phieu tai khoan.
	 *
	 * @param groupId the group ID of this ds phieu tai khoan
	 */
	@Override
	public void setGroupId(long groupId) {
		_dsPhieuTaiKhoan.setGroupId(groupId);
	}

	/**
	 * Sets the hoat dong of this ds phieu tai khoan.
	 *
	 * @param hoatDong the hoat dong of this ds phieu tai khoan
	 */
	@Override
	public void setHoatDong(Boolean hoatDong) {
		_dsPhieuTaiKhoan.setHoatDong(hoatDong);
	}

	/**
	 * Sets the ma theo doi of this ds phieu tai khoan.
	 *
	 * @param maTheoDoi the ma theo doi of this ds phieu tai khoan
	 */
	@Override
	public void setMaTheoDoi(String maTheoDoi) {
		_dsPhieuTaiKhoan.setMaTheoDoi(maTheoDoi);
	}

	/**
	 * Sets the modified date of this ds phieu tai khoan.
	 *
	 * @param modifiedDate the modified date of this ds phieu tai khoan
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_dsPhieuTaiKhoan.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_dsPhieuTaiKhoan.setNew(n);
	}

	/**
	 * Sets the ngay chung tu of this ds phieu tai khoan.
	 *
	 * @param ngayChungTu the ngay chung tu of this ds phieu tai khoan
	 */
	@Override
	public void setNgayChungTu(Date ngayChungTu) {
		_dsPhieuTaiKhoan.setNgayChungTu(ngayChungTu);
	}

	/**
	 * Sets the phieu ID of this ds phieu tai khoan.
	 *
	 * @param phieuId the phieu ID of this ds phieu tai khoan
	 */
	@Override
	public void setPhieuId(long phieuId) {
		_dsPhieuTaiKhoan.setPhieuId(phieuId);
	}

	/**
	 * Sets the primary key of this ds phieu tai khoan.
	 *
	 * @param primaryKey the primary key of this ds phieu tai khoan
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_dsPhieuTaiKhoan.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_dsPhieuTaiKhoan.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the so tien of this ds phieu tai khoan.
	 *
	 * @param soTien the so tien of this ds phieu tai khoan
	 */
	@Override
	public void setSoTien(Double soTien) {
		_dsPhieuTaiKhoan.setSoTien(soTien);
	}

	/**
	 * Sets the tai khoan doi ung ID of this ds phieu tai khoan.
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID of this ds phieu tai khoan
	 */
	@Override
	public void setTaiKhoanDoiUngId(long taiKhoanDoiUngId) {
		_dsPhieuTaiKhoan.setTaiKhoanDoiUngId(taiKhoanDoiUngId);
	}

	/**
	 * Sets the ten ctv of this ds phieu tai khoan.
	 *
	 * @param tenCTV the ten ctv of this ds phieu tai khoan
	 */
	@Override
	public void setTenCTV(String tenCTV) {
		_dsPhieuTaiKhoan.setTenCTV(tenCTV);
	}

	/**
	 * Sets the user ID of this ds phieu tai khoan.
	 *
	 * @param userId the user ID of this ds phieu tai khoan
	 */
	@Override
	public void setUserId(long userId) {
		_dsPhieuTaiKhoan.setUserId(userId);
	}

	/**
	 * Sets the user name of this ds phieu tai khoan.
	 *
	 * @param userName the user name of this ds phieu tai khoan
	 */
	@Override
	public void setUserName(String userName) {
		_dsPhieuTaiKhoan.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this ds phieu tai khoan.
	 *
	 * @param userUuid the user uuid of this ds phieu tai khoan
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_dsPhieuTaiKhoan.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<DsPhieuTaiKhoan>
		toCacheModel() {

		return _dsPhieuTaiKhoan.toCacheModel();
	}

	@Override
	public DsPhieuTaiKhoan toEscapedModel() {
		return new DsPhieuTaiKhoanWrapper(_dsPhieuTaiKhoan.toEscapedModel());
	}

	@Override
	public String toString() {
		return _dsPhieuTaiKhoan.toString();
	}

	@Override
	public DsPhieuTaiKhoan toUnescapedModel() {
		return new DsPhieuTaiKhoanWrapper(_dsPhieuTaiKhoan.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _dsPhieuTaiKhoan.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DsPhieuTaiKhoanWrapper)) {
			return false;
		}

		DsPhieuTaiKhoanWrapper dsPhieuTaiKhoanWrapper =
			(DsPhieuTaiKhoanWrapper)obj;

		if (Objects.equals(
				_dsPhieuTaiKhoan, dsPhieuTaiKhoanWrapper._dsPhieuTaiKhoan)) {

			return true;
		}

		return false;
	}

	@Override
	public DsPhieuTaiKhoan getWrappedModel() {
		return _dsPhieuTaiKhoan;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _dsPhieuTaiKhoan.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _dsPhieuTaiKhoan.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_dsPhieuTaiKhoan.resetOriginalValues();
	}

	private final DsPhieuTaiKhoan _dsPhieuTaiKhoan;

}