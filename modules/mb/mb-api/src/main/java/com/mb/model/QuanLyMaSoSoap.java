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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.mb.service.http.QuanLyMaSoServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class QuanLyMaSoSoap implements Serializable {

	public static QuanLyMaSoSoap toSoapModel(QuanLyMaSo model) {
		QuanLyMaSoSoap soapModel = new QuanLyMaSoSoap();

		soapModel.setQuanLyMaSoId(model.getQuanLyMaSoId());
		soapModel.setKey(model.getKey());
		soapModel.setSo(model.getSo());

		return soapModel;
	}

	public static QuanLyMaSoSoap[] toSoapModels(QuanLyMaSo[] models) {
		QuanLyMaSoSoap[] soapModels = new QuanLyMaSoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static QuanLyMaSoSoap[][] toSoapModels(QuanLyMaSo[][] models) {
		QuanLyMaSoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new QuanLyMaSoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new QuanLyMaSoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static QuanLyMaSoSoap[] toSoapModels(List<QuanLyMaSo> models) {
		List<QuanLyMaSoSoap> soapModels = new ArrayList<QuanLyMaSoSoap>(
			models.size());

		for (QuanLyMaSo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new QuanLyMaSoSoap[soapModels.size()]);
	}

	public QuanLyMaSoSoap() {
	}

	public long getPrimaryKey() {
		return _quanLyMaSoId;
	}

	public void setPrimaryKey(long pk) {
		setQuanLyMaSoId(pk);
	}

	public long getQuanLyMaSoId() {
		return _quanLyMaSoId;
	}

	public void setQuanLyMaSoId(long quanLyMaSoId) {
		_quanLyMaSoId = quanLyMaSoId;
	}

	public String getKey() {
		return _key;
	}

	public void setKey(String key) {
		_key = key;
	}

	public int getSo() {
		return _so;
	}

	public void setSo(int so) {
		_so = so;
	}

	private long _quanLyMaSoId;
	private String _key;
	private int _so;

}