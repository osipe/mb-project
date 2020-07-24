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

import com.mb.model.LichSuTaiKhoanDauKy;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LichSuTaiKhoanDauKy in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class LichSuTaiKhoanDauKyCacheModel
	implements CacheModel<LichSuTaiKhoanDauKy>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LichSuTaiKhoanDauKyCacheModel)) {
			return false;
		}

		LichSuTaiKhoanDauKyCacheModel lichSuTaiKhoanDauKyCacheModel =
			(LichSuTaiKhoanDauKyCacheModel)obj;

		if (lichSuTaiKhoanDauKyId ==
				lichSuTaiKhoanDauKyCacheModel.lichSuTaiKhoanDauKyId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, lichSuTaiKhoanDauKyId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{lichSuTaiKhoanDauKyId=");
		sb.append(lichSuTaiKhoanDauKyId);
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
		sb.append(", taiKhoanDoiUngId=");
		sb.append(taiKhoanDoiUngId);
		sb.append(", thang=");
		sb.append(thang);
		sb.append(", nam=");
		sb.append(nam);
		sb.append(", soTienTon=");
		sb.append(soTienTon);
		sb.append(", soTienThu=");
		sb.append(soTienThu);
		sb.append(", soTienChi=");
		sb.append(soTienChi);
		sb.append(", hoatDong=");
		sb.append(hoatDong);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LichSuTaiKhoanDauKy toEntityModel() {
		LichSuTaiKhoanDauKyImpl lichSuTaiKhoanDauKyImpl =
			new LichSuTaiKhoanDauKyImpl();

		lichSuTaiKhoanDauKyImpl.setLichSuTaiKhoanDauKyId(lichSuTaiKhoanDauKyId);
		lichSuTaiKhoanDauKyImpl.setCompanyId(companyId);
		lichSuTaiKhoanDauKyImpl.setGroupId(groupId);
		lichSuTaiKhoanDauKyImpl.setUserId(userId);

		if (userName == null) {
			lichSuTaiKhoanDauKyImpl.setUserName("");
		}
		else {
			lichSuTaiKhoanDauKyImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			lichSuTaiKhoanDauKyImpl.setCreateDate(null);
		}
		else {
			lichSuTaiKhoanDauKyImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			lichSuTaiKhoanDauKyImpl.setModifiedDate(null);
		}
		else {
			lichSuTaiKhoanDauKyImpl.setModifiedDate(new Date(modifiedDate));
		}

		lichSuTaiKhoanDauKyImpl.setTaiKhoanDoiUngId(taiKhoanDoiUngId);
		lichSuTaiKhoanDauKyImpl.setThang(thang);
		lichSuTaiKhoanDauKyImpl.setNam(nam);
		lichSuTaiKhoanDauKyImpl.setSoTienTon(soTienTon);
		lichSuTaiKhoanDauKyImpl.setSoTienThu(soTienThu);
		lichSuTaiKhoanDauKyImpl.setSoTienChi(soTienChi);
		lichSuTaiKhoanDauKyImpl.setHoatDong(hoatDong);

		lichSuTaiKhoanDauKyImpl.resetOriginalValues();

		return lichSuTaiKhoanDauKyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		lichSuTaiKhoanDauKyId = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		taiKhoanDoiUngId = objectInput.readLong();

		thang = objectInput.readInt();

		nam = objectInput.readInt();

		soTienTon = objectInput.readDouble();

		soTienThu = objectInput.readDouble();

		soTienChi = objectInput.readDouble();

		hoatDong = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(lichSuTaiKhoanDauKyId);

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

		objectOutput.writeLong(taiKhoanDoiUngId);

		objectOutput.writeInt(thang);

		objectOutput.writeInt(nam);

		objectOutput.writeDouble(soTienTon);

		objectOutput.writeDouble(soTienThu);

		objectOutput.writeDouble(soTienChi);

		objectOutput.writeBoolean(hoatDong);
	}

	public long lichSuTaiKhoanDauKyId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long taiKhoanDoiUngId;
	public int thang;
	public int nam;
	public double soTienTon;
	public double soTienThu;
	public double soTienChi;
	public boolean hoatDong;

}