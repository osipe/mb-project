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

import com.mb.model.TaiSanThueChap;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TaiSanThueChap in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class TaiSanThueChapCacheModel
	implements CacheModel<TaiSanThueChap>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TaiSanThueChapCacheModel)) {
			return false;
		}

		TaiSanThueChapCacheModel taiSanThueChapCacheModel =
			(TaiSanThueChapCacheModel)obj;

		if (taiSanThueChapId == taiSanThueChapCacheModel.taiSanThueChapId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, taiSanThueChapId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{taiSanThueChapId=");
		sb.append(taiSanThueChapId);
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
		sb.append(", soKU=");
		sb.append(soKU);
		sb.append(", maKhachHang=");
		sb.append(maKhachHang);
		sb.append(", loaiTaiSanId=");
		sb.append(loaiTaiSanId);
		sb.append(", giaTriTaiSan=");
		sb.append(giaTriTaiSan);
		sb.append(", thongTinTaiSan=");
		sb.append(thongTinTaiSan);
		sb.append(", ten=");
		sb.append(ten);
		sb.append(", ghiChu=");
		sb.append(ghiChu);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TaiSanThueChap toEntityModel() {
		TaiSanThueChapImpl taiSanThueChapImpl = new TaiSanThueChapImpl();

		taiSanThueChapImpl.setTaiSanThueChapId(taiSanThueChapId);
		taiSanThueChapImpl.setCompanyId(companyId);
		taiSanThueChapImpl.setGroupId(groupId);
		taiSanThueChapImpl.setUserId(userId);

		if (userName == null) {
			taiSanThueChapImpl.setUserName("");
		}
		else {
			taiSanThueChapImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			taiSanThueChapImpl.setCreateDate(null);
		}
		else {
			taiSanThueChapImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			taiSanThueChapImpl.setModifiedDate(null);
		}
		else {
			taiSanThueChapImpl.setModifiedDate(new Date(modifiedDate));
		}

		taiSanThueChapImpl.setPhatVayId(phatVayId);

		if (soKU == null) {
			taiSanThueChapImpl.setSoKU("");
		}
		else {
			taiSanThueChapImpl.setSoKU(soKU);
		}

		if (maKhachHang == null) {
			taiSanThueChapImpl.setMaKhachHang("");
		}
		else {
			taiSanThueChapImpl.setMaKhachHang(maKhachHang);
		}

		taiSanThueChapImpl.setLoaiTaiSanId(loaiTaiSanId);
		taiSanThueChapImpl.setGiaTriTaiSan(giaTriTaiSan);

		if (thongTinTaiSan == null) {
			taiSanThueChapImpl.setThongTinTaiSan("");
		}
		else {
			taiSanThueChapImpl.setThongTinTaiSan(thongTinTaiSan);
		}

		if (ten == null) {
			taiSanThueChapImpl.setTen("");
		}
		else {
			taiSanThueChapImpl.setTen(ten);
		}

		if (ghiChu == null) {
			taiSanThueChapImpl.setGhiChu("");
		}
		else {
			taiSanThueChapImpl.setGhiChu(ghiChu);
		}

		taiSanThueChapImpl.resetOriginalValues();

		return taiSanThueChapImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		taiSanThueChapId = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		phatVayId = objectInput.readLong();
		soKU = objectInput.readUTF();
		maKhachHang = objectInput.readUTF();

		loaiTaiSanId = objectInput.readLong();

		giaTriTaiSan = objectInput.readDouble();
		thongTinTaiSan = objectInput.readUTF();
		ten = objectInput.readUTF();
		ghiChu = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(taiSanThueChapId);

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

		if (soKU == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(soKU);
		}

		if (maKhachHang == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(maKhachHang);
		}

		objectOutput.writeLong(loaiTaiSanId);

		objectOutput.writeDouble(giaTriTaiSan);

		if (thongTinTaiSan == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(thongTinTaiSan);
		}

		if (ten == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ten);
		}

		if (ghiChu == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ghiChu);
		}
	}

	public long taiSanThueChapId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long phatVayId;
	public String soKU;
	public String maKhachHang;
	public long loaiTaiSanId;
	public double giaTriTaiSan;
	public String thongTinTaiSan;
	public String ten;
	public String ghiChu;

}