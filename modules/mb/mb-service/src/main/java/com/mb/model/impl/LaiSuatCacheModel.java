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

import com.mb.model.LaiSuat;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LaiSuat in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class LaiSuatCacheModel implements CacheModel<LaiSuat>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LaiSuatCacheModel)) {
			return false;
		}

		LaiSuatCacheModel laiSuatCacheModel = (LaiSuatCacheModel)obj;

		if (laiSuatId == laiSuatCacheModel.laiSuatId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, laiSuatId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{laiSuatId=");
		sb.append(laiSuatId);
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
		sb.append(", soTienVay=");
		sb.append(soTienVay);
		sb.append(", thoiHan=");
		sb.append(thoiHan);
		sb.append(", laiSuatVay=");
		sb.append(laiSuatVay);
		sb.append(", gocNgay=");
		sb.append(gocNgay);
		sb.append(", laiNgay=");
		sb.append(laiNgay);
		sb.append(", gocNgayCuoi=");
		sb.append(gocNgayCuoi);
		sb.append(", hoatDong=");
		sb.append(hoatDong);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LaiSuat toEntityModel() {
		LaiSuatImpl laiSuatImpl = new LaiSuatImpl();

		laiSuatImpl.setLaiSuatId(laiSuatId);
		laiSuatImpl.setCompanyId(companyId);
		laiSuatImpl.setGroupId(groupId);
		laiSuatImpl.setUserId(userId);

		if (userName == null) {
			laiSuatImpl.setUserName("");
		}
		else {
			laiSuatImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			laiSuatImpl.setCreateDate(null);
		}
		else {
			laiSuatImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			laiSuatImpl.setModifiedDate(null);
		}
		else {
			laiSuatImpl.setModifiedDate(new Date(modifiedDate));
		}

		laiSuatImpl.setSoTienVay(soTienVay);
		laiSuatImpl.setThoiHan(thoiHan);
		laiSuatImpl.setLaiSuatVay(laiSuatVay);
		laiSuatImpl.setGocNgay(gocNgay);
		laiSuatImpl.setLaiNgay(laiNgay);
		laiSuatImpl.setGocNgayCuoi(gocNgayCuoi);
		laiSuatImpl.setHoatDong(hoatDong);

		laiSuatImpl.resetOriginalValues();

		return laiSuatImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		laiSuatId = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		soTienVay = objectInput.readDouble();

		thoiHan = objectInput.readInt();

		laiSuatVay = objectInput.readDouble();

		gocNgay = objectInput.readDouble();

		laiNgay = objectInput.readDouble();

		gocNgayCuoi = objectInput.readDouble();

		hoatDong = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(laiSuatId);

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

		objectOutput.writeDouble(soTienVay);

		objectOutput.writeInt(thoiHan);

		objectOutput.writeDouble(laiSuatVay);

		objectOutput.writeDouble(gocNgay);

		objectOutput.writeDouble(laiNgay);

		objectOutput.writeDouble(gocNgayCuoi);

		objectOutput.writeBoolean(hoatDong);
	}

	public long laiSuatId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public double soTienVay;
	public int thoiHan;
	public double laiSuatVay;
	public double gocNgay;
	public double laiNgay;
	public double gocNgayCuoi;
	public boolean hoatDong;

}