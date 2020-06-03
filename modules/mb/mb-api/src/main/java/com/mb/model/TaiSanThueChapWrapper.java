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
 * This class is a wrapper for {@link TaiSanThueChap}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaiSanThueChap
 * @generated
 */
@ProviderType
public class TaiSanThueChapWrapper
	implements TaiSanThueChap, ModelWrapper<TaiSanThueChap> {

	public TaiSanThueChapWrapper(TaiSanThueChap taiSanThueChap) {
		_taiSanThueChap = taiSanThueChap;
	}

	@Override
	public Class<?> getModelClass() {
		return TaiSanThueChap.class;
	}

	@Override
	public String getModelClassName() {
		return TaiSanThueChap.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("taiSanThueChapId", getTaiSanThueChapId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("phatVayId", getPhatVayId());
		attributes.put("soKU", getSoKU());
		attributes.put("maKhachHang", getMaKhachHang());
		attributes.put("loaiTaiSanId", getLoaiTaiSanId());
		attributes.put("giaTriTaiSan", getGiaTriTaiSan());
		attributes.put("thongTinTaiSan", getThongTinTaiSan());
		attributes.put("ten", getTen());
		attributes.put("ghiChu", getGhiChu());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long taiSanThueChapId = (Long)attributes.get("taiSanThueChapId");

		if (taiSanThueChapId != null) {
			setTaiSanThueChapId(taiSanThueChapId);
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

		Long phatVayId = (Long)attributes.get("phatVayId");

		if (phatVayId != null) {
			setPhatVayId(phatVayId);
		}

		String soKU = (String)attributes.get("soKU");

		if (soKU != null) {
			setSoKU(soKU);
		}

		String maKhachHang = (String)attributes.get("maKhachHang");

		if (maKhachHang != null) {
			setMaKhachHang(maKhachHang);
		}

		Long loaiTaiSanId = (Long)attributes.get("loaiTaiSanId");

		if (loaiTaiSanId != null) {
			setLoaiTaiSanId(loaiTaiSanId);
		}

		Double giaTriTaiSan = (Double)attributes.get("giaTriTaiSan");

		if (giaTriTaiSan != null) {
			setGiaTriTaiSan(giaTriTaiSan);
		}

		String thongTinTaiSan = (String)attributes.get("thongTinTaiSan");

		if (thongTinTaiSan != null) {
			setThongTinTaiSan(thongTinTaiSan);
		}

		String ten = (String)attributes.get("ten");

		if (ten != null) {
			setTen(ten);
		}

		String ghiChu = (String)attributes.get("ghiChu");

		if (ghiChu != null) {
			setGhiChu(ghiChu);
		}
	}

	@Override
	public Object clone() {
		return new TaiSanThueChapWrapper(
			(TaiSanThueChap)_taiSanThueChap.clone());
	}

	@Override
	public int compareTo(TaiSanThueChap taiSanThueChap) {
		return _taiSanThueChap.compareTo(taiSanThueChap);
	}

	/**
	 * Returns the company ID of this tai san thue chap.
	 *
	 * @return the company ID of this tai san thue chap
	 */
	@Override
	public long getCompanyId() {
		return _taiSanThueChap.getCompanyId();
	}

	/**
	 * Returns the create date of this tai san thue chap.
	 *
	 * @return the create date of this tai san thue chap
	 */
	@Override
	public Date getCreateDate() {
		return _taiSanThueChap.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _taiSanThueChap.getExpandoBridge();
	}

	/**
	 * Returns the ghi chu of this tai san thue chap.
	 *
	 * @return the ghi chu of this tai san thue chap
	 */
	@Override
	public String getGhiChu() {
		return _taiSanThueChap.getGhiChu();
	}

	/**
	 * Returns the gia tri tai san of this tai san thue chap.
	 *
	 * @return the gia tri tai san of this tai san thue chap
	 */
	@Override
	public Double getGiaTriTaiSan() {
		return _taiSanThueChap.getGiaTriTaiSan();
	}

	/**
	 * Returns the group ID of this tai san thue chap.
	 *
	 * @return the group ID of this tai san thue chap
	 */
	@Override
	public long getGroupId() {
		return _taiSanThueChap.getGroupId();
	}

	@Override
	public KhachHang getKhachHang() {
		return _taiSanThueChap.getKhachHang();
	}

	/**
	 * Returns the loai tai san ID of this tai san thue chap.
	 *
	 * @return the loai tai san ID of this tai san thue chap
	 */
	@Override
	public long getLoaiTaiSanId() {
		return _taiSanThueChap.getLoaiTaiSanId();
	}

	/**
	 * Returns the ma khach hang of this tai san thue chap.
	 *
	 * @return the ma khach hang of this tai san thue chap
	 */
	@Override
	public String getMaKhachHang() {
		return _taiSanThueChap.getMaKhachHang();
	}

	/**
	 * Returns the modified date of this tai san thue chap.
	 *
	 * @return the modified date of this tai san thue chap
	 */
	@Override
	public Date getModifiedDate() {
		return _taiSanThueChap.getModifiedDate();
	}

	@Override
	public PhatVay getPhatVay() {
		return _taiSanThueChap.getPhatVay();
	}

	/**
	 * Returns the phat vay ID of this tai san thue chap.
	 *
	 * @return the phat vay ID of this tai san thue chap
	 */
	@Override
	public long getPhatVayId() {
		return _taiSanThueChap.getPhatVayId();
	}

	/**
	 * Returns the primary key of this tai san thue chap.
	 *
	 * @return the primary key of this tai san thue chap
	 */
	@Override
	public long getPrimaryKey() {
		return _taiSanThueChap.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _taiSanThueChap.getPrimaryKeyObj();
	}

	/**
	 * Returns the so ku of this tai san thue chap.
	 *
	 * @return the so ku of this tai san thue chap
	 */
	@Override
	public String getSoKU() {
		return _taiSanThueChap.getSoKU();
	}

	/**
	 * Returns the tai san thue chap ID of this tai san thue chap.
	 *
	 * @return the tai san thue chap ID of this tai san thue chap
	 */
	@Override
	public long getTaiSanThueChapId() {
		return _taiSanThueChap.getTaiSanThueChapId();
	}

	/**
	 * Returns the ten of this tai san thue chap.
	 *
	 * @return the ten of this tai san thue chap
	 */
	@Override
	public String getTen() {
		return _taiSanThueChap.getTen();
	}

	/**
	 * Returns the thong tin tai san of this tai san thue chap.
	 *
	 * @return the thong tin tai san of this tai san thue chap
	 */
	@Override
	public String getThongTinTaiSan() {
		return _taiSanThueChap.getThongTinTaiSan();
	}

	/**
	 * Returns the user ID of this tai san thue chap.
	 *
	 * @return the user ID of this tai san thue chap
	 */
	@Override
	public long getUserId() {
		return _taiSanThueChap.getUserId();
	}

	/**
	 * Returns the user name of this tai san thue chap.
	 *
	 * @return the user name of this tai san thue chap
	 */
	@Override
	public String getUserName() {
		return _taiSanThueChap.getUserName();
	}

	/**
	 * Returns the user uuid of this tai san thue chap.
	 *
	 * @return the user uuid of this tai san thue chap
	 */
	@Override
	public String getUserUuid() {
		return _taiSanThueChap.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _taiSanThueChap.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _taiSanThueChap.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _taiSanThueChap.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _taiSanThueChap.isNew();
	}

	@Override
	public void persist() {
		_taiSanThueChap.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_taiSanThueChap.setCachedModel(cachedModel);
	}

	/**
	 * Sets the company ID of this tai san thue chap.
	 *
	 * @param companyId the company ID of this tai san thue chap
	 */
	@Override
	public void setCompanyId(long companyId) {
		_taiSanThueChap.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this tai san thue chap.
	 *
	 * @param createDate the create date of this tai san thue chap
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_taiSanThueChap.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_taiSanThueChap.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_taiSanThueChap.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_taiSanThueChap.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the ghi chu of this tai san thue chap.
	 *
	 * @param ghiChu the ghi chu of this tai san thue chap
	 */
	@Override
	public void setGhiChu(String ghiChu) {
		_taiSanThueChap.setGhiChu(ghiChu);
	}

	/**
	 * Sets the gia tri tai san of this tai san thue chap.
	 *
	 * @param giaTriTaiSan the gia tri tai san of this tai san thue chap
	 */
	@Override
	public void setGiaTriTaiSan(Double giaTriTaiSan) {
		_taiSanThueChap.setGiaTriTaiSan(giaTriTaiSan);
	}

	/**
	 * Sets the group ID of this tai san thue chap.
	 *
	 * @param groupId the group ID of this tai san thue chap
	 */
	@Override
	public void setGroupId(long groupId) {
		_taiSanThueChap.setGroupId(groupId);
	}

	/**
	 * Sets the loai tai san ID of this tai san thue chap.
	 *
	 * @param loaiTaiSanId the loai tai san ID of this tai san thue chap
	 */
	@Override
	public void setLoaiTaiSanId(long loaiTaiSanId) {
		_taiSanThueChap.setLoaiTaiSanId(loaiTaiSanId);
	}

	/**
	 * Sets the ma khach hang of this tai san thue chap.
	 *
	 * @param maKhachHang the ma khach hang of this tai san thue chap
	 */
	@Override
	public void setMaKhachHang(String maKhachHang) {
		_taiSanThueChap.setMaKhachHang(maKhachHang);
	}

	/**
	 * Sets the modified date of this tai san thue chap.
	 *
	 * @param modifiedDate the modified date of this tai san thue chap
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_taiSanThueChap.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_taiSanThueChap.setNew(n);
	}

	/**
	 * Sets the phat vay ID of this tai san thue chap.
	 *
	 * @param phatVayId the phat vay ID of this tai san thue chap
	 */
	@Override
	public void setPhatVayId(long phatVayId) {
		_taiSanThueChap.setPhatVayId(phatVayId);
	}

	/**
	 * Sets the primary key of this tai san thue chap.
	 *
	 * @param primaryKey the primary key of this tai san thue chap
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_taiSanThueChap.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_taiSanThueChap.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the so ku of this tai san thue chap.
	 *
	 * @param soKU the so ku of this tai san thue chap
	 */
	@Override
	public void setSoKU(String soKU) {
		_taiSanThueChap.setSoKU(soKU);
	}

	/**
	 * Sets the tai san thue chap ID of this tai san thue chap.
	 *
	 * @param taiSanThueChapId the tai san thue chap ID of this tai san thue chap
	 */
	@Override
	public void setTaiSanThueChapId(long taiSanThueChapId) {
		_taiSanThueChap.setTaiSanThueChapId(taiSanThueChapId);
	}

	/**
	 * Sets the ten of this tai san thue chap.
	 *
	 * @param ten the ten of this tai san thue chap
	 */
	@Override
	public void setTen(String ten) {
		_taiSanThueChap.setTen(ten);
	}

	/**
	 * Sets the thong tin tai san of this tai san thue chap.
	 *
	 * @param thongTinTaiSan the thong tin tai san of this tai san thue chap
	 */
	@Override
	public void setThongTinTaiSan(String thongTinTaiSan) {
		_taiSanThueChap.setThongTinTaiSan(thongTinTaiSan);
	}

	/**
	 * Sets the user ID of this tai san thue chap.
	 *
	 * @param userId the user ID of this tai san thue chap
	 */
	@Override
	public void setUserId(long userId) {
		_taiSanThueChap.setUserId(userId);
	}

	/**
	 * Sets the user name of this tai san thue chap.
	 *
	 * @param userName the user name of this tai san thue chap
	 */
	@Override
	public void setUserName(String userName) {
		_taiSanThueChap.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this tai san thue chap.
	 *
	 * @param userUuid the user uuid of this tai san thue chap
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_taiSanThueChap.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<TaiSanThueChap>
		toCacheModel() {

		return _taiSanThueChap.toCacheModel();
	}

	@Override
	public TaiSanThueChap toEscapedModel() {
		return new TaiSanThueChapWrapper(_taiSanThueChap.toEscapedModel());
	}

	@Override
	public String toString() {
		return _taiSanThueChap.toString();
	}

	@Override
	public TaiSanThueChap toUnescapedModel() {
		return new TaiSanThueChapWrapper(_taiSanThueChap.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _taiSanThueChap.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TaiSanThueChapWrapper)) {
			return false;
		}

		TaiSanThueChapWrapper taiSanThueChapWrapper =
			(TaiSanThueChapWrapper)obj;

		if (Objects.equals(
				_taiSanThueChap, taiSanThueChapWrapper._taiSanThueChap)) {

			return true;
		}

		return false;
	}

	@Override
	public TaiSanThueChap getWrappedModel() {
		return _taiSanThueChap;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _taiSanThueChap.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _taiSanThueChap.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_taiSanThueChap.resetOriginalValues();
	}

	private final TaiSanThueChap _taiSanThueChap;

}