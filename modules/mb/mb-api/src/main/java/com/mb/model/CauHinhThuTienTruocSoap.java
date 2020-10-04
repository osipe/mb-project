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
 * This class is used by SOAP remote services, specifically {@link com.mb.service.http.CauHinhThuTienTruocServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class CauHinhThuTienTruocSoap implements Serializable {

	public static CauHinhThuTienTruocSoap toSoapModel(
		CauHinhThuTienTruoc model) {

		CauHinhThuTienTruocSoap soapModel = new CauHinhThuTienTruocSoap();

		soapModel.setCauHinhThuTienTruocId(model.getCauHinhThuTienTruocId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setNam(model.getNam());
		soapModel.setNgayTu(model.getNgayTu());
		soapModel.setNgayDen(model.getNgayDen());
		soapModel.setHoatDong(model.getHoatDong());

		return soapModel;
	}

	public static CauHinhThuTienTruocSoap[] toSoapModels(
		CauHinhThuTienTruoc[] models) {

		CauHinhThuTienTruocSoap[] soapModels =
			new CauHinhThuTienTruocSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CauHinhThuTienTruocSoap[][] toSoapModels(
		CauHinhThuTienTruoc[][] models) {

		CauHinhThuTienTruocSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new CauHinhThuTienTruocSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CauHinhThuTienTruocSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CauHinhThuTienTruocSoap[] toSoapModels(
		List<CauHinhThuTienTruoc> models) {

		List<CauHinhThuTienTruocSoap> soapModels =
			new ArrayList<CauHinhThuTienTruocSoap>(models.size());

		for (CauHinhThuTienTruoc model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new CauHinhThuTienTruocSoap[soapModels.size()]);
	}

	public CauHinhThuTienTruocSoap() {
	}

	public long getPrimaryKey() {
		return _cauHinhThuTienTruocId;
	}

	public void setPrimaryKey(long pk) {
		setCauHinhThuTienTruocId(pk);
	}

	public long getCauHinhThuTienTruocId() {
		return _cauHinhThuTienTruocId;
	}

	public void setCauHinhThuTienTruocId(long cauHinhThuTienTruocId) {
		_cauHinhThuTienTruocId = cauHinhThuTienTruocId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public int getNam() {
		return _nam;
	}

	public void setNam(int nam) {
		_nam = nam;
	}

	public Date getNgayTu() {
		return _ngayTu;
	}

	public void setNgayTu(Date ngayTu) {
		_ngayTu = ngayTu;
	}

	public Date getNgayDen() {
		return _ngayDen;
	}

	public void setNgayDen(Date ngayDen) {
		_ngayDen = ngayDen;
	}

	public Boolean getHoatDong() {
		return _hoatDong;
	}

	public void setHoatDong(Boolean hoatDong) {
		_hoatDong = hoatDong;
	}

	private long _cauHinhThuTienTruocId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _nam;
	private Date _ngayTu;
	private Date _ngayDen;
	private Boolean _hoatDong;

}