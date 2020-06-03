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

import com.mb.model.KhachHang;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing KhachHang in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class KhachHangCacheModel
	implements CacheModel<KhachHang>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof KhachHangCacheModel)) {
			return false;
		}

		KhachHangCacheModel khachHangCacheModel = (KhachHangCacheModel)obj;

		if (khachHangId == khachHangCacheModel.khachHangId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, khachHangId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{khachHangId=");
		sb.append(khachHangId);
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
		sb.append(", maCTV=");
		sb.append(maCTV);
		sb.append(", ma=");
		sb.append(ma);
		sb.append(", hoTen=");
		sb.append(hoTen);
		sb.append(", soCMND=");
		sb.append(soCMND);
		sb.append(", diaChi=");
		sb.append(diaChi);
		sb.append(", hoatDong=");
		sb.append(hoatDong);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public KhachHang toEntityModel() {
		KhachHangImpl khachHangImpl = new KhachHangImpl();

		khachHangImpl.setKhachHangId(khachHangId);
		khachHangImpl.setCompanyId(companyId);
		khachHangImpl.setGroupId(groupId);
		khachHangImpl.setUserId(userId);

		if (userName == null) {
			khachHangImpl.setUserName("");
		}
		else {
			khachHangImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			khachHangImpl.setCreateDate(null);
		}
		else {
			khachHangImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			khachHangImpl.setModifiedDate(null);
		}
		else {
			khachHangImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (maCTV == null) {
			khachHangImpl.setMaCTV("");
		}
		else {
			khachHangImpl.setMaCTV(maCTV);
		}

		if (ma == null) {
			khachHangImpl.setMa("");
		}
		else {
			khachHangImpl.setMa(ma);
		}

		if (hoTen == null) {
			khachHangImpl.setHoTen("");
		}
		else {
			khachHangImpl.setHoTen(hoTen);
		}

		if (soCMND == null) {
			khachHangImpl.setSoCMND("");
		}
		else {
			khachHangImpl.setSoCMND(soCMND);
		}

		if (diaChi == null) {
			khachHangImpl.setDiaChi("");
		}
		else {
			khachHangImpl.setDiaChi(diaChi);
		}

		khachHangImpl.setHoatDong(hoatDong);

		khachHangImpl.resetOriginalValues();

		return khachHangImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		khachHangId = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		maCTV = objectInput.readUTF();
		ma = objectInput.readUTF();
		hoTen = objectInput.readUTF();
		soCMND = objectInput.readUTF();
		diaChi = objectInput.readUTF();

		hoatDong = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(khachHangId);

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

		if (maCTV == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(maCTV);
		}

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

		if (diaChi == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(diaChi);
		}

		objectOutput.writeBoolean(hoatDong);
	}

	public long khachHangId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String maCTV;
	public String ma;
	public String hoTen;
	public String soCMND;
	public String diaChi;
	public boolean hoatDong;

}