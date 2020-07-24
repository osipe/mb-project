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

import com.mb.model.MaSoThuChi;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MaSoThuChi in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class MaSoThuChiCacheModel
	implements CacheModel<MaSoThuChi>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MaSoThuChiCacheModel)) {
			return false;
		}

		MaSoThuChiCacheModel maSoThuChiCacheModel = (MaSoThuChiCacheModel)obj;

		if (maSoThuChiId == maSoThuChiCacheModel.maSoThuChiId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, maSoThuChiId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{maSoThuChiId=");
		sb.append(maSoThuChiId);
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
		sb.append(", dienGiai=");
		sb.append(dienGiai);
		sb.append(", loai=");
		sb.append(loai);
		sb.append(", hoatDong=");
		sb.append(hoatDong);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MaSoThuChi toEntityModel() {
		MaSoThuChiImpl maSoThuChiImpl = new MaSoThuChiImpl();

		maSoThuChiImpl.setMaSoThuChiId(maSoThuChiId);
		maSoThuChiImpl.setCompanyId(companyId);
		maSoThuChiImpl.setGroupId(groupId);
		maSoThuChiImpl.setUserId(userId);

		if (userName == null) {
			maSoThuChiImpl.setUserName("");
		}
		else {
			maSoThuChiImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			maSoThuChiImpl.setCreateDate(null);
		}
		else {
			maSoThuChiImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			maSoThuChiImpl.setModifiedDate(null);
		}
		else {
			maSoThuChiImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (ma == null) {
			maSoThuChiImpl.setMa("");
		}
		else {
			maSoThuChiImpl.setMa(ma);
		}

		if (dienGiai == null) {
			maSoThuChiImpl.setDienGiai("");
		}
		else {
			maSoThuChiImpl.setDienGiai(dienGiai);
		}

		maSoThuChiImpl.setLoai(loai);
		maSoThuChiImpl.setHoatDong(hoatDong);

		maSoThuChiImpl.resetOriginalValues();

		return maSoThuChiImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		maSoThuChiId = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		ma = objectInput.readUTF();
		dienGiai = objectInput.readUTF();

		loai = objectInput.readInt();

		hoatDong = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(maSoThuChiId);

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

		if (dienGiai == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dienGiai);
		}

		objectOutput.writeInt(loai);

		objectOutput.writeBoolean(hoatDong);
	}

	public long maSoThuChiId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String ma;
	public String dienGiai;
	public int loai;
	public boolean hoatDong;

}