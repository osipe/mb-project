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
 * This class is a wrapper for {@link CauHinhThuTienTet}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CauHinhThuTienTet
 * @generated
 */
@ProviderType
public class CauHinhThuTienTetWrapper
	implements CauHinhThuTienTet, ModelWrapper<CauHinhThuTienTet> {

	public CauHinhThuTienTetWrapper(CauHinhThuTienTet cauHinhThuTienTet) {
		_cauHinhThuTienTet = cauHinhThuTienTet;
	}

	@Override
	public Class<?> getModelClass() {
		return CauHinhThuTienTet.class;
	}

	@Override
	public String getModelClassName() {
		return CauHinhThuTienTet.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("cauHinhThuTienTetId", getCauHinhThuTienTetId());
		attributes.put("nam", getNam());
		attributes.put("ngayBatDau", getNgayBatDau());
		attributes.put("ngayKetThuc", getNgayKetThuc());
		attributes.put("soNgay", getSoNgay());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long cauHinhThuTienTetId = (Long)attributes.get("cauHinhThuTienTetId");

		if (cauHinhThuTienTetId != null) {
			setCauHinhThuTienTetId(cauHinhThuTienTetId);
		}

		Integer nam = (Integer)attributes.get("nam");

		if (nam != null) {
			setNam(nam);
		}

		Date ngayBatDau = (Date)attributes.get("ngayBatDau");

		if (ngayBatDau != null) {
			setNgayBatDau(ngayBatDau);
		}

		Date ngayKetThuc = (Date)attributes.get("ngayKetThuc");

		if (ngayKetThuc != null) {
			setNgayKetThuc(ngayKetThuc);
		}

		Integer soNgay = (Integer)attributes.get("soNgay");

		if (soNgay != null) {
			setSoNgay(soNgay);
		}
	}

	@Override
	public Object clone() {
		return new CauHinhThuTienTetWrapper(
			(CauHinhThuTienTet)_cauHinhThuTienTet.clone());
	}

	@Override
	public int compareTo(CauHinhThuTienTet cauHinhThuTienTet) {
		return _cauHinhThuTienTet.compareTo(cauHinhThuTienTet);
	}

	/**
	 * Returns the cau hinh thu tien tet ID of this cau hinh thu tien tet.
	 *
	 * @return the cau hinh thu tien tet ID of this cau hinh thu tien tet
	 */
	@Override
	public long getCauHinhThuTienTetId() {
		return _cauHinhThuTienTet.getCauHinhThuTienTetId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _cauHinhThuTienTet.getExpandoBridge();
	}

	/**
	 * Returns the nam of this cau hinh thu tien tet.
	 *
	 * @return the nam of this cau hinh thu tien tet
	 */
	@Override
	public int getNam() {
		return _cauHinhThuTienTet.getNam();
	}

	/**
	 * Returns the ngay bat dau of this cau hinh thu tien tet.
	 *
	 * @return the ngay bat dau of this cau hinh thu tien tet
	 */
	@Override
	public Date getNgayBatDau() {
		return _cauHinhThuTienTet.getNgayBatDau();
	}

	/**
	 * Returns the ngay ket thuc of this cau hinh thu tien tet.
	 *
	 * @return the ngay ket thuc of this cau hinh thu tien tet
	 */
	@Override
	public Date getNgayKetThuc() {
		return _cauHinhThuTienTet.getNgayKetThuc();
	}

	/**
	 * Returns the primary key of this cau hinh thu tien tet.
	 *
	 * @return the primary key of this cau hinh thu tien tet
	 */
	@Override
	public long getPrimaryKey() {
		return _cauHinhThuTienTet.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _cauHinhThuTienTet.getPrimaryKeyObj();
	}

	/**
	 * Returns the so ngay of this cau hinh thu tien tet.
	 *
	 * @return the so ngay of this cau hinh thu tien tet
	 */
	@Override
	public int getSoNgay() {
		return _cauHinhThuTienTet.getSoNgay();
	}

	@Override
	public int hashCode() {
		return _cauHinhThuTienTet.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _cauHinhThuTienTet.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _cauHinhThuTienTet.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _cauHinhThuTienTet.isNew();
	}

	@Override
	public void persist() {
		_cauHinhThuTienTet.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_cauHinhThuTienTet.setCachedModel(cachedModel);
	}

	/**
	 * Sets the cau hinh thu tien tet ID of this cau hinh thu tien tet.
	 *
	 * @param cauHinhThuTienTetId the cau hinh thu tien tet ID of this cau hinh thu tien tet
	 */
	@Override
	public void setCauHinhThuTienTetId(long cauHinhThuTienTetId) {
		_cauHinhThuTienTet.setCauHinhThuTienTetId(cauHinhThuTienTetId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_cauHinhThuTienTet.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_cauHinhThuTienTet.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_cauHinhThuTienTet.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the nam of this cau hinh thu tien tet.
	 *
	 * @param nam the nam of this cau hinh thu tien tet
	 */
	@Override
	public void setNam(int nam) {
		_cauHinhThuTienTet.setNam(nam);
	}

	@Override
	public void setNew(boolean n) {
		_cauHinhThuTienTet.setNew(n);
	}

	/**
	 * Sets the ngay bat dau of this cau hinh thu tien tet.
	 *
	 * @param ngayBatDau the ngay bat dau of this cau hinh thu tien tet
	 */
	@Override
	public void setNgayBatDau(Date ngayBatDau) {
		_cauHinhThuTienTet.setNgayBatDau(ngayBatDau);
	}

	/**
	 * Sets the ngay ket thuc of this cau hinh thu tien tet.
	 *
	 * @param ngayKetThuc the ngay ket thuc of this cau hinh thu tien tet
	 */
	@Override
	public void setNgayKetThuc(Date ngayKetThuc) {
		_cauHinhThuTienTet.setNgayKetThuc(ngayKetThuc);
	}

	/**
	 * Sets the primary key of this cau hinh thu tien tet.
	 *
	 * @param primaryKey the primary key of this cau hinh thu tien tet
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_cauHinhThuTienTet.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_cauHinhThuTienTet.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the so ngay of this cau hinh thu tien tet.
	 *
	 * @param soNgay the so ngay of this cau hinh thu tien tet
	 */
	@Override
	public void setSoNgay(int soNgay) {
		_cauHinhThuTienTet.setSoNgay(soNgay);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<CauHinhThuTienTet>
		toCacheModel() {

		return _cauHinhThuTienTet.toCacheModel();
	}

	@Override
	public CauHinhThuTienTet toEscapedModel() {
		return new CauHinhThuTienTetWrapper(
			_cauHinhThuTienTet.toEscapedModel());
	}

	@Override
	public String toString() {
		return _cauHinhThuTienTet.toString();
	}

	@Override
	public CauHinhThuTienTet toUnescapedModel() {
		return new CauHinhThuTienTetWrapper(
			_cauHinhThuTienTet.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _cauHinhThuTienTet.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CauHinhThuTienTetWrapper)) {
			return false;
		}

		CauHinhThuTienTetWrapper cauHinhThuTienTetWrapper =
			(CauHinhThuTienTetWrapper)obj;

		if (Objects.equals(
				_cauHinhThuTienTet,
				cauHinhThuTienTetWrapper._cauHinhThuTienTet)) {

			return true;
		}

		return false;
	}

	@Override
	public CauHinhThuTienTet getWrappedModel() {
		return _cauHinhThuTienTet;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _cauHinhThuTienTet.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _cauHinhThuTienTet.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_cauHinhThuTienTet.resetOriginalValues();
	}

	private final CauHinhThuTienTet _cauHinhThuTienTet;

}