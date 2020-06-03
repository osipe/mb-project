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

import com.mb.model.PhatVay;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PhatVay in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class PhatVayCacheModel implements CacheModel<PhatVay>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PhatVayCacheModel)) {
			return false;
		}

		PhatVayCacheModel phatVayCacheModel = (PhatVayCacheModel)obj;

		if (phatVayId == phatVayCacheModel.phatVayId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, phatVayId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(55);

		sb.append("{phatVayId=");
		sb.append(phatVayId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", ngayTao=");
		sb.append(ngayTao);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", maCTV=");
		sb.append(maCTV);
		sb.append(", maKhachHang=");
		sb.append(maKhachHang);
		sb.append(", soKU=");
		sb.append(soKU);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", ngayBatDau=");
		sb.append(ngayBatDau);
		sb.append(", ngayKetThuc=");
		sb.append(ngayKetThuc);
		sb.append(", loaiPhatVay=");
		sb.append(loaiPhatVay);
		sb.append(", soLanDaThu=");
		sb.append(soLanDaThu);
		sb.append(", ngayDaThuCuoi=");
		sb.append(ngayDaThuCuoi);
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
		sb.append(", soNgayThuTruoc=");
		sb.append(soNgayThuTruoc);
		sb.append(", ngayThuTruocTu=");
		sb.append(ngayThuTruocTu);
		sb.append(", ngayThuTruocDen=");
		sb.append(ngayThuTruocDen);
		sb.append(", ngayTatToan=");
		sb.append(ngayTatToan);
		sb.append(", trangThai=");
		sb.append(trangThai);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PhatVay toEntityModel() {
		PhatVayImpl phatVayImpl = new PhatVayImpl();

		phatVayImpl.setPhatVayId(phatVayId);
		phatVayImpl.setCompanyId(companyId);
		phatVayImpl.setGroupId(groupId);
		phatVayImpl.setUserId(userId);

		if (userName == null) {
			phatVayImpl.setUserName("");
		}
		else {
			phatVayImpl.setUserName(userName);
		}

		if (ngayTao == Long.MIN_VALUE) {
			phatVayImpl.setNgayTao(null);
		}
		else {
			phatVayImpl.setNgayTao(new Date(ngayTao));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			phatVayImpl.setModifiedDate(null);
		}
		else {
			phatVayImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (maCTV == null) {
			phatVayImpl.setMaCTV("");
		}
		else {
			phatVayImpl.setMaCTV(maCTV);
		}

		if (maKhachHang == null) {
			phatVayImpl.setMaKhachHang("");
		}
		else {
			phatVayImpl.setMaKhachHang(maKhachHang);
		}

		if (soKU == null) {
			phatVayImpl.setSoKU("");
		}
		else {
			phatVayImpl.setSoKU(soKU);
		}

		if (createDate == Long.MIN_VALUE) {
			phatVayImpl.setCreateDate(null);
		}
		else {
			phatVayImpl.setCreateDate(new Date(createDate));
		}

		if (ngayBatDau == Long.MIN_VALUE) {
			phatVayImpl.setNgayBatDau(null);
		}
		else {
			phatVayImpl.setNgayBatDau(new Date(ngayBatDau));
		}

		if (ngayKetThuc == Long.MIN_VALUE) {
			phatVayImpl.setNgayKetThuc(null);
		}
		else {
			phatVayImpl.setNgayKetThuc(new Date(ngayKetThuc));
		}

		phatVayImpl.setLoaiPhatVay(loaiPhatVay);
		phatVayImpl.setSoLanDaThu(soLanDaThu);

		if (ngayDaThuCuoi == Long.MIN_VALUE) {
			phatVayImpl.setNgayDaThuCuoi(null);
		}
		else {
			phatVayImpl.setNgayDaThuCuoi(new Date(ngayDaThuCuoi));
		}

		phatVayImpl.setSoTienVay(soTienVay);
		phatVayImpl.setThoiHan(thoiHan);
		phatVayImpl.setLaiSuatVay(laiSuatVay);
		phatVayImpl.setGocNgay(gocNgay);
		phatVayImpl.setLaiNgay(laiNgay);
		phatVayImpl.setGocNgayCuoi(gocNgayCuoi);
		phatVayImpl.setSoNgayThuTruoc(soNgayThuTruoc);

		if (ngayThuTruocTu == Long.MIN_VALUE) {
			phatVayImpl.setNgayThuTruocTu(null);
		}
		else {
			phatVayImpl.setNgayThuTruocTu(new Date(ngayThuTruocTu));
		}

		if (ngayThuTruocDen == Long.MIN_VALUE) {
			phatVayImpl.setNgayThuTruocDen(null);
		}
		else {
			phatVayImpl.setNgayThuTruocDen(new Date(ngayThuTruocDen));
		}

		if (ngayTatToan == Long.MIN_VALUE) {
			phatVayImpl.setNgayTatToan(null);
		}
		else {
			phatVayImpl.setNgayTatToan(new Date(ngayTatToan));
		}

		phatVayImpl.setTrangThai(trangThai);

		phatVayImpl.resetOriginalValues();

		return phatVayImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		phatVayId = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		ngayTao = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		maCTV = objectInput.readUTF();
		maKhachHang = objectInput.readUTF();
		soKU = objectInput.readUTF();
		createDate = objectInput.readLong();
		ngayBatDau = objectInput.readLong();
		ngayKetThuc = objectInput.readLong();

		loaiPhatVay = objectInput.readInt();

		soLanDaThu = objectInput.readInt();
		ngayDaThuCuoi = objectInput.readLong();

		soTienVay = objectInput.readDouble();

		thoiHan = objectInput.readInt();

		laiSuatVay = objectInput.readDouble();

		gocNgay = objectInput.readDouble();

		laiNgay = objectInput.readDouble();

		gocNgayCuoi = objectInput.readDouble();

		soNgayThuTruoc = objectInput.readInt();
		ngayThuTruocTu = objectInput.readLong();
		ngayThuTruocDen = objectInput.readLong();
		ngayTatToan = objectInput.readLong();

		trangThai = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(phatVayId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(ngayTao);
		objectOutput.writeLong(modifiedDate);

		if (maCTV == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(maCTV);
		}

		if (maKhachHang == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(maKhachHang);
		}

		if (soKU == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(soKU);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(ngayBatDau);
		objectOutput.writeLong(ngayKetThuc);

		objectOutput.writeInt(loaiPhatVay);

		objectOutput.writeInt(soLanDaThu);
		objectOutput.writeLong(ngayDaThuCuoi);

		objectOutput.writeDouble(soTienVay);

		objectOutput.writeInt(thoiHan);

		objectOutput.writeDouble(laiSuatVay);

		objectOutput.writeDouble(gocNgay);

		objectOutput.writeDouble(laiNgay);

		objectOutput.writeDouble(gocNgayCuoi);

		objectOutput.writeInt(soNgayThuTruoc);
		objectOutput.writeLong(ngayThuTruocTu);
		objectOutput.writeLong(ngayThuTruocDen);
		objectOutput.writeLong(ngayTatToan);

		objectOutput.writeInt(trangThai);
	}

	public long phatVayId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long ngayTao;
	public long modifiedDate;
	public String maCTV;
	public String maKhachHang;
	public String soKU;
	public long createDate;
	public long ngayBatDau;
	public long ngayKetThuc;
	public int loaiPhatVay;
	public int soLanDaThu;
	public long ngayDaThuCuoi;
	public double soTienVay;
	public int thoiHan;
	public double laiSuatVay;
	public double gocNgay;
	public double laiNgay;
	public double gocNgayCuoi;
	public int soNgayThuTruoc;
	public long ngayThuTruocTu;
	public long ngayThuTruocDen;
	public long ngayTatToan;
	public int trangThai;

}