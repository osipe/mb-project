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

import com.mb.model.LichSuThuPhatChi;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LichSuThuPhatChi in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class LichSuThuPhatChiCacheModel
	implements CacheModel<LichSuThuPhatChi>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LichSuThuPhatChiCacheModel)) {
			return false;
		}

		LichSuThuPhatChiCacheModel lichSuThuPhatChiCacheModel =
			(LichSuThuPhatChiCacheModel)obj;

		if (lichSuThuPhatChiId ==
				lichSuThuPhatChiCacheModel.lichSuThuPhatChiId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, lichSuThuPhatChiId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{lichSuThuPhatChiId=");
		sb.append(lichSuThuPhatChiId);
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
		sb.append(", phatVayId=");
		sb.append(phatVayId);
		sb.append(", maCTV=");
		sb.append(maCTV);
		sb.append(", soTien=");
		sb.append(soTien);
		sb.append(", tongSoTienVonTra=");
		sb.append(tongSoTienVonTra);
		sb.append(", tongSoTienLaiTra=");
		sb.append(tongSoTienLaiTra);
		sb.append(", loai=");
		sb.append(loai);
		sb.append(", trangThaiPhatVayHienTai=");
		sb.append(trangThaiPhatVayHienTai);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LichSuThuPhatChi toEntityModel() {
		LichSuThuPhatChiImpl lichSuThuPhatChiImpl = new LichSuThuPhatChiImpl();

		lichSuThuPhatChiImpl.setLichSuThuPhatChiId(lichSuThuPhatChiId);
		lichSuThuPhatChiImpl.setCompanyId(companyId);
		lichSuThuPhatChiImpl.setGroupId(groupId);
		lichSuThuPhatChiImpl.setUserId(userId);

		if (userName == null) {
			lichSuThuPhatChiImpl.setUserName("");
		}
		else {
			lichSuThuPhatChiImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			lichSuThuPhatChiImpl.setCreateDate(null);
		}
		else {
			lichSuThuPhatChiImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			lichSuThuPhatChiImpl.setModifiedDate(null);
		}
		else {
			lichSuThuPhatChiImpl.setModifiedDate(new Date(modifiedDate));
		}

		lichSuThuPhatChiImpl.setPhatVayId(phatVayId);

		if (maCTV == null) {
			lichSuThuPhatChiImpl.setMaCTV("");
		}
		else {
			lichSuThuPhatChiImpl.setMaCTV(maCTV);
		}

		lichSuThuPhatChiImpl.setSoTien(soTien);
		lichSuThuPhatChiImpl.setTongSoTienVonTra(tongSoTienVonTra);
		lichSuThuPhatChiImpl.setTongSoTienLaiTra(tongSoTienLaiTra);
		lichSuThuPhatChiImpl.setLoai(loai);
		lichSuThuPhatChiImpl.setTrangThaiPhatVayHienTai(
			trangThaiPhatVayHienTai);

		lichSuThuPhatChiImpl.resetOriginalValues();

		return lichSuThuPhatChiImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		lichSuThuPhatChiId = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		phatVayId = objectInput.readLong();
		maCTV = objectInput.readUTF();

		soTien = objectInput.readDouble();

		tongSoTienVonTra = objectInput.readDouble();

		tongSoTienLaiTra = objectInput.readDouble();

		loai = objectInput.readInt();

		trangThaiPhatVayHienTai = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(lichSuThuPhatChiId);

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

		objectOutput.writeLong(phatVayId);

		if (maCTV == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(maCTV);
		}

		objectOutput.writeDouble(soTien);

		objectOutput.writeDouble(tongSoTienVonTra);

		objectOutput.writeDouble(tongSoTienLaiTra);

		objectOutput.writeInt(loai);

		objectOutput.writeInt(trangThaiPhatVayHienTai);
	}

	public long lichSuThuPhatChiId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long phatVayId;
	public String maCTV;
	public double soTien;
	public double tongSoTienVonTra;
	public double tongSoTienLaiTra;
	public int loai;
	public int trangThaiPhatVayHienTai;

}