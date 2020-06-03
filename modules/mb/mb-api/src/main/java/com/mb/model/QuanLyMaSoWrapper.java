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
 * This class is a wrapper for {@link QuanLyMaSo}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuanLyMaSo
 * @generated
 */
@ProviderType
public class QuanLyMaSoWrapper implements QuanLyMaSo, ModelWrapper<QuanLyMaSo> {

	public QuanLyMaSoWrapper(QuanLyMaSo quanLyMaSo) {
		_quanLyMaSo = quanLyMaSo;
	}

	@Override
	public Class<?> getModelClass() {
		return QuanLyMaSo.class;
	}

	@Override
	public String getModelClassName() {
		return QuanLyMaSo.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("quanLyMaSoId", getQuanLyMaSoId());
		attributes.put("key", getKey());
		attributes.put("so", getSo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long quanLyMaSoId = (Long)attributes.get("quanLyMaSoId");

		if (quanLyMaSoId != null) {
			setQuanLyMaSoId(quanLyMaSoId);
		}

		String key = (String)attributes.get("key");

		if (key != null) {
			setKey(key);
		}

		Integer so = (Integer)attributes.get("so");

		if (so != null) {
			setSo(so);
		}
	}

	@Override
	public Object clone() {
		return new QuanLyMaSoWrapper((QuanLyMaSo)_quanLyMaSo.clone());
	}

	@Override
	public int compareTo(QuanLyMaSo quanLyMaSo) {
		return _quanLyMaSo.compareTo(quanLyMaSo);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _quanLyMaSo.getExpandoBridge();
	}

	/**
	 * Returns the key of this quan ly ma so.
	 *
	 * @return the key of this quan ly ma so
	 */
	@Override
	public String getKey() {
		return _quanLyMaSo.getKey();
	}

	/**
	 * Returns the primary key of this quan ly ma so.
	 *
	 * @return the primary key of this quan ly ma so
	 */
	@Override
	public long getPrimaryKey() {
		return _quanLyMaSo.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _quanLyMaSo.getPrimaryKeyObj();
	}

	/**
	 * Returns the quan ly ma so ID of this quan ly ma so.
	 *
	 * @return the quan ly ma so ID of this quan ly ma so
	 */
	@Override
	public long getQuanLyMaSoId() {
		return _quanLyMaSo.getQuanLyMaSoId();
	}

	/**
	 * Returns the so of this quan ly ma so.
	 *
	 * @return the so of this quan ly ma so
	 */
	@Override
	public int getSo() {
		return _quanLyMaSo.getSo();
	}

	@Override
	public int hashCode() {
		return _quanLyMaSo.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _quanLyMaSo.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _quanLyMaSo.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _quanLyMaSo.isNew();
	}

	@Override
	public void persist() {
		_quanLyMaSo.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_quanLyMaSo.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_quanLyMaSo.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_quanLyMaSo.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_quanLyMaSo.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the key of this quan ly ma so.
	 *
	 * @param key the key of this quan ly ma so
	 */
	@Override
	public void setKey(String key) {
		_quanLyMaSo.setKey(key);
	}

	@Override
	public void setNew(boolean n) {
		_quanLyMaSo.setNew(n);
	}

	/**
	 * Sets the primary key of this quan ly ma so.
	 *
	 * @param primaryKey the primary key of this quan ly ma so
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_quanLyMaSo.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_quanLyMaSo.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the quan ly ma so ID of this quan ly ma so.
	 *
	 * @param quanLyMaSoId the quan ly ma so ID of this quan ly ma so
	 */
	@Override
	public void setQuanLyMaSoId(long quanLyMaSoId) {
		_quanLyMaSo.setQuanLyMaSoId(quanLyMaSoId);
	}

	/**
	 * Sets the so of this quan ly ma so.
	 *
	 * @param so the so of this quan ly ma so
	 */
	@Override
	public void setSo(int so) {
		_quanLyMaSo.setSo(so);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<QuanLyMaSo>
		toCacheModel() {

		return _quanLyMaSo.toCacheModel();
	}

	@Override
	public QuanLyMaSo toEscapedModel() {
		return new QuanLyMaSoWrapper(_quanLyMaSo.toEscapedModel());
	}

	@Override
	public String toString() {
		return _quanLyMaSo.toString();
	}

	@Override
	public QuanLyMaSo toUnescapedModel() {
		return new QuanLyMaSoWrapper(_quanLyMaSo.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _quanLyMaSo.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof QuanLyMaSoWrapper)) {
			return false;
		}

		QuanLyMaSoWrapper quanLyMaSoWrapper = (QuanLyMaSoWrapper)obj;

		if (Objects.equals(_quanLyMaSo, quanLyMaSoWrapper._quanLyMaSo)) {
			return true;
		}

		return false;
	}

	@Override
	public QuanLyMaSo getWrappedModel() {
		return _quanLyMaSo;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _quanLyMaSo.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _quanLyMaSo.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_quanLyMaSo.resetOriginalValues();
	}

	private final QuanLyMaSo _quanLyMaSo;

}