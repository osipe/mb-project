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
 * This class is used by SOAP remote services, specifically {@link com.mb.service.http.SoKheUocServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class SoKheUocSoap implements Serializable {

	public static SoKheUocSoap toSoapModel(SoKheUoc model) {
		SoKheUocSoap soapModel = new SoKheUocSoap();

		soapModel.setSoKheUocId(model.getSoKheUocId());
		soapModel.setCauTruc(model.getCauTruc());
		soapModel.setSo(model.getSo());

		return soapModel;
	}

	public static SoKheUocSoap[] toSoapModels(SoKheUoc[] models) {
		SoKheUocSoap[] soapModels = new SoKheUocSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SoKheUocSoap[][] toSoapModels(SoKheUoc[][] models) {
		SoKheUocSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SoKheUocSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SoKheUocSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SoKheUocSoap[] toSoapModels(List<SoKheUoc> models) {
		List<SoKheUocSoap> soapModels = new ArrayList<SoKheUocSoap>(
			models.size());

		for (SoKheUoc model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SoKheUocSoap[soapModels.size()]);
	}

	public SoKheUocSoap() {
	}

	public long getPrimaryKey() {
		return _soKheUocId;
	}

	public void setPrimaryKey(long pk) {
		setSoKheUocId(pk);
	}

	public long getSoKheUocId() {
		return _soKheUocId;
	}

	public void setSoKheUocId(long soKheUocId) {
		_soKheUocId = soKheUocId;
	}

	public String getCauTruc() {
		return _cauTruc;
	}

	public void setCauTruc(String cauTruc) {
		_cauTruc = cauTruc;
	}

	public int getSo() {
		return _so;
	}

	public void setSo(int so) {
		_so = so;
	}

	private long _soKheUocId;
	private String _cauTruc;
	private int _so;

}