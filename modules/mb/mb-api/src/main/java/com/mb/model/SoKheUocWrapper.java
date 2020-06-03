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

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link SoKheUoc}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SoKheUoc
 * @generated
 */
@ProviderType
public class SoKheUocWrapper implements SoKheUoc, ModelWrapper<SoKheUoc> {

	public SoKheUocWrapper(SoKheUoc soKheUoc) {
		_soKheUoc = soKheUoc;
	}

	@Override
	public Class<?> getModelClass() {
		return SoKheUoc.class;
	}

	@Override
	public String getModelClassName() {
		return SoKheUoc.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("soKheUocId", getSoKheUocId());
		attributes.put("cauTruc", getCauTruc());
		attributes.put("so", getSo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long soKheUocId = (Long)attributes.get("soKheUocId");

		if (soKheUocId != null) {
			setSoKheUocId(soKheUocId);
		}

		String cauTruc = (String)attributes.get("cauTruc");

		if (cauTruc != null) {
			setCauTruc(cauTruc);
		}

		Integer so = (Integer)attributes.get("so");

		if (so != null) {
			setSo(so);
		}
	}

	@Override
	public Object clone() {
		return new SoKheUocWrapper((SoKheUoc)_soKheUoc.clone());
	}

	@Override
	public int compareTo(SoKheUoc soKheUoc) {
		return _soKheUoc.compareTo(soKheUoc);
	}

	/**
	 * Returns the cau truc of this so khe uoc.
	 *
	 * @return the cau truc of this so khe uoc
	 */
	@Override
	public String getCauTruc() {
		return _soKheUoc.getCauTruc();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _soKheUoc.getExpandoBridge();
	}

	/**
	 * Returns the primary key of this so khe uoc.
	 *
	 * @return the primary key of this so khe uoc
	 */
	@Override
	public long getPrimaryKey() {
		return _soKheUoc.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _soKheUoc.getPrimaryKeyObj();
	}

	/**
	 * Returns the so of this so khe uoc.
	 *
	 * @return the so of this so khe uoc
	 */
	@Override
	public int getSo() {
		return _soKheUoc.getSo();
	}

	@Override
	public String getSoKheUocDayDu() {
		return _soKheUoc.getSoKheUocDayDu();
	}

	/**
	 * Returns the so khe uoc ID of this so khe uoc.
	 *
	 * @return the so khe uoc ID of this so khe uoc
	 */
	@Override
	public long getSoKheUocId() {
		return _soKheUoc.getSoKheUocId();
	}

	@Override
	public int hashCode() {
		return _soKheUoc.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _soKheUoc.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _soKheUoc.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _soKheUoc.isNew();
	}

	@Override
	public void persist() {
		_soKheUoc.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_soKheUoc.setCachedModel(cachedModel);
	}

	/**
	 * Sets the cau truc of this so khe uoc.
	 *
	 * @param cauTruc the cau truc of this so khe uoc
	 */
	@Override
	public void setCauTruc(String cauTruc) {
		_soKheUoc.setCauTruc(cauTruc);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_soKheUoc.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_soKheUoc.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_soKheUoc.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_soKheUoc.setNew(n);
	}

	/**
	 * Sets the primary key of this so khe uoc.
	 *
	 * @param primaryKey the primary key of this so khe uoc
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_soKheUoc.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_soKheUoc.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the so of this so khe uoc.
	 *
	 * @param so the so of this so khe uoc
	 */
	@Override
	public void setSo(int so) {
		_soKheUoc.setSo(so);
	}

	/**
	 * Sets the so khe uoc ID of this so khe uoc.
	 *
	 * @param soKheUocId the so khe uoc ID of this so khe uoc
	 */
	@Override
	public void setSoKheUocId(long soKheUocId) {
		_soKheUoc.setSoKheUocId(soKheUocId);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<SoKheUoc> toCacheModel() {
		return _soKheUoc.toCacheModel();
	}

	@Override
	public SoKheUoc toEscapedModel() {
		return new SoKheUocWrapper(_soKheUoc.toEscapedModel());
	}

	@Override
	public String toString() {
		return _soKheUoc.toString();
	}

	@Override
	public SoKheUoc toUnescapedModel() {
		return new SoKheUocWrapper(_soKheUoc.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _soKheUoc.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SoKheUocWrapper)) {
			return false;
		}

		SoKheUocWrapper soKheUocWrapper = (SoKheUocWrapper)obj;

		if (Objects.equals(_soKheUoc, soKheUocWrapper._soKheUoc)) {
			return true;
		}

		return false;
	}

	@Override
	public SoKheUoc getWrappedModel() {
		return _soKheUoc;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _soKheUoc.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _soKheUoc.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_soKheUoc.resetOriginalValues();
	}

	private final SoKheUoc _soKheUoc;

}