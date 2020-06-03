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

import com.mb.model.LoaiTaiSan;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LoaiTaiSan in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class LoaiTaiSanCacheModel
	implements CacheModel<LoaiTaiSan>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LoaiTaiSanCacheModel)) {
			return false;
		}

		LoaiTaiSanCacheModel loaiTaiSanCacheModel = (LoaiTaiSanCacheModel)obj;

		if (loaiTaiSanId == loaiTaiSanCacheModel.loaiTaiSanId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, loaiTaiSanId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{loaiTaiSanId=");
		sb.append(loaiTaiSanId);
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
		sb.append(", ten=");
		sb.append(ten);
		sb.append(", ma=");
		sb.append(ma);
		sb.append(", ghiChu=");
		sb.append(ghiChu);
		sb.append(", hoatDong=");
		sb.append(hoatDong);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LoaiTaiSan toEntityModel() {
		LoaiTaiSanImpl loaiTaiSanImpl = new LoaiTaiSanImpl();

		loaiTaiSanImpl.setLoaiTaiSanId(loaiTaiSanId);
		loaiTaiSanImpl.setCompanyId(companyId);
		loaiTaiSanImpl.setGroupId(groupId);
		loaiTaiSanImpl.setUserId(userId);

		if (userName == null) {
			loaiTaiSanImpl.setUserName("");
		}
		else {
			loaiTaiSanImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			loaiTaiSanImpl.setCreateDate(null);
		}
		else {
			loaiTaiSanImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			loaiTaiSanImpl.setModifiedDate(null);
		}
		else {
			loaiTaiSanImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (ten == null) {
			loaiTaiSanImpl.setTen("");
		}
		else {
			loaiTaiSanImpl.setTen(ten);
		}

		if (ma == null) {
			loaiTaiSanImpl.setMa("");
		}
		else {
			loaiTaiSanImpl.setMa(ma);
		}

		if (ghiChu == null) {
			loaiTaiSanImpl.setGhiChu("");
		}
		else {
			loaiTaiSanImpl.setGhiChu(ghiChu);
		}

		loaiTaiSanImpl.setHoatDong(hoatDong);

		loaiTaiSanImpl.resetOriginalValues();

		return loaiTaiSanImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		loaiTaiSanId = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		ten = objectInput.readUTF();
		ma = objectInput.readUTF();
		ghiChu = objectInput.readUTF();

		hoatDong = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(loaiTaiSanId);

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

		if (ten == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ten);
		}

		if (ma == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ma);
		}

		if (ghiChu == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ghiChu);
		}

		objectOutput.writeBoolean(hoatDong);
	}

	public long loaiTaiSanId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String ten;
	public String ma;
	public String ghiChu;
	public boolean hoatDong;

}