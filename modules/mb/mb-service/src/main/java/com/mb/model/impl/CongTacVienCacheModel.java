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

package com.mb.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import com.mb.model.CongTacVien;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CongTacVien in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class CongTacVienCacheModel
	implements CacheModel<CongTacVien>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CongTacVienCacheModel)) {
			return false;
		}

		CongTacVienCacheModel congTacVienCacheModel =
			(CongTacVienCacheModel)obj;

		if (congTacVienId == congTacVienCacheModel.congTacVienId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, congTacVienId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{congTacVienId=");
		sb.append(congTacVienId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", ma=");
		sb.append(ma);
		sb.append(", hoTen=");
		sb.append(hoTen);
		sb.append(", soCMND=");
		sb.append(soCMND);
		sb.append(", duNoToiDa=");
		sb.append(duNoToiDa);
		sb.append(", duNoToiDaTheChap=");
		sb.append(duNoToiDaTheChap);
		sb.append(", diaChi=");
		sb.append(diaChi);
		sb.append(", ghiChu=");
		sb.append(ghiChu);
		sb.append(", hoatDong=");
		sb.append(hoatDong);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CongTacVien toEntityModel() {
		CongTacVienImpl congTacVienImpl = new CongTacVienImpl();

		congTacVienImpl.setCongTacVienId(congTacVienId);
		congTacVienImpl.setCompanyId(companyId);
		congTacVienImpl.setGroupId(groupId);
		congTacVienImpl.setUserId(userId);

		if (userName == null) {
			congTacVienImpl.setUserName("");
		}
		else {
			congTacVienImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			congTacVienImpl.setCreateDate(null);
		}
		else {
			congTacVienImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			congTacVienImpl.setModifiedDate(null);
		}
		else {
			congTacVienImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (ma == null) {
			congTacVienImpl.setMa("");
		}
		else {
			congTacVienImpl.setMa(ma);
		}

		if (hoTen == null) {
			congTacVienImpl.setHoTen("");
		}
		else {
			congTacVienImpl.setHoTen(hoTen);
		}

		if (soCMND == null) {
			congTacVienImpl.setSoCMND("");
		}
		else {
			congTacVienImpl.setSoCMND(soCMND);
		}

		congTacVienImpl.setDuNoToiDa(duNoToiDa);
		congTacVienImpl.setDuNoToiDaTheChap(duNoToiDaTheChap);

		if (diaChi == null) {
			congTacVienImpl.setDiaChi("");
		}
		else {
			congTacVienImpl.setDiaChi(diaChi);
		}

		if (ghiChu == null) {
			congTacVienImpl.setGhiChu("");
		}
		else {
			congTacVienImpl.setGhiChu(ghiChu);
		}

		congTacVienImpl.setHoatDong(hoatDong);

		congTacVienImpl.resetOriginalValues();

		return congTacVienImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		congTacVienId = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		ma = objectInput.readUTF();
		hoTen = objectInput.readUTF();
		soCMND = objectInput.readUTF();

		duNoToiDa = objectInput.readDouble();

		duNoToiDaTheChap = objectInput.readDouble();
		diaChi = objectInput.readUTF();
		ghiChu = objectInput.readUTF();

		hoatDong = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(congTacVienId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (ma == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ma);
		}

		if (hoTen == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(hoTen);
		}

		if (soCMND == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(soCMND);
		}

		objectOutput.writeDouble(duNoToiDa);

		objectOutput.writeDouble(duNoToiDaTheChap);

		if (diaChi == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(diaChi);
		}

		if (ghiChu == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ghiChu);
		}

		objectOutput.writeBoolean(hoatDong);
	}

	public long congTacVienId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String ma;
	public String hoTen;
	public String soCMND;
	public double duNoToiDa;
	public double duNoToiDaTheChap;
	public String diaChi;
	public String ghiChu;
	public boolean hoatDong;

}