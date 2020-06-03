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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.mb.service.http.CauHinhThuTienTetServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class CauHinhThuTienTetSoap implements Serializable {

	public static CauHinhThuTienTetSoap toSoapModel(CauHinhThuTienTet model) {
		CauHinhThuTienTetSoap soapModel = new CauHinhThuTienTetSoap();

		soapModel.setCauHinhThuTienTetId(model.getCauHinhThuTienTetId());
		soapModel.setNam(model.getNam());
		soapModel.setNgayBatDau(model.getNgayBatDau());
		soapModel.setNgayKetThuc(model.getNgayKetThuc());
		soapModel.setSoNgay(model.getSoNgay());

		return soapModel;
	}

	public static CauHinhThuTienTetSoap[] toSoapModels(
		CauHinhThuTienTet[] models) {

		CauHinhThuTienTetSoap[] soapModels =
			new CauHinhThuTienTetSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CauHinhThuTienTetSoap[][] toSoapModels(
		CauHinhThuTienTet[][] models) {

		CauHinhThuTienTetSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new CauHinhThuTienTetSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CauHinhThuTienTetSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CauHinhThuTienTetSoap[] toSoapModels(
		List<CauHinhThuTienTet> models) {

		List<CauHinhThuTienTetSoap> soapModels =
			new ArrayList<CauHinhThuTienTetSoap>(models.size());

		for (CauHinhThuTienTet model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CauHinhThuTienTetSoap[soapModels.size()]);
	}

	public CauHinhThuTienTetSoap() {
	}

	public long getPrimaryKey() {
		return _cauHinhThuTienTetId;
	}

	public void setPrimaryKey(long pk) {
		setCauHinhThuTienTetId(pk);
	}

	public long getCauHinhThuTienTetId() {
		return _cauHinhThuTienTetId;
	}

	public void setCauHinhThuTienTetId(long cauHinhThuTienTetId) {
		_cauHinhThuTienTetId = cauHinhThuTienTetId;
	}

	public int getNam() {
		return _nam;
	}

	public void setNam(int nam) {
		_nam = nam;
	}

	public Date getNgayBatDau() {
		return _ngayBatDau;
	}

	public void setNgayBatDau(Date ngayBatDau) {
		_ngayBatDau = ngayBatDau;
	}

	public Date getNgayKetThuc() {
		return _ngayKetThuc;
	}

	public void setNgayKetThuc(Date ngayKetThuc) {
		_ngayKetThuc = ngayKetThuc;
	}

	public int getSoNgay() {
		return _soNgay;
	}

	public void setSoNgay(int soNgay) {
		_soNgay = soNgay;
	}

	private long _cauHinhThuTienTetId;
	private int _nam;
	private Date _ngayBatDau;
	private Date _ngayKetThuc;
	private int _soNgay;

}