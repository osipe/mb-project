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

import com.mb.model.Phieu;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Phieu in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class PhieuCacheModel implements CacheModel<Phieu>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PhieuCacheModel)) {
			return false;
		}

		PhieuCacheModel phieuCacheModel = (PhieuCacheModel)obj;

		if (phieuId == phieuCacheModel.phieuId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, phieuId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{phieuId=");
		sb.append(phieuId);
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
		sb.append(", hoTenCTV=");
		sb.append(hoTenCTV);
		sb.append(", soHopDong=");
		sb.append(soHopDong);
		sb.append(", ngayChungTu=");
		sb.append(ngayChungTu);
		sb.append(", diaChi=");
		sb.append(diaChi);
		sb.append(", soPhieu=");
		sb.append(soPhieu);
		sb.append(", ngayGhiSo=");
		sb.append(ngayGhiSo);
		sb.append(", maMSThuChi=");
		sb.append(maMSThuChi);
		sb.append(", soTien=");
		sb.append(soTien);
		sb.append(", chungTuKemTheo=");
		sb.append(chungTuKemTheo);
		sb.append(", loai=");
		sb.append(loai);
		sb.append(", hoatDong=");
		sb.append(hoatDong);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Phieu toEntityModel() {
		PhieuImpl phieuImpl = new PhieuImpl();

		phieuImpl.setPhieuId(phieuId);
		phieuImpl.setCompanyId(companyId);
		phieuImpl.setGroupId(groupId);
		phieuImpl.setUserId(userId);

		if (userName == null) {
			phieuImpl.setUserName("");
		}
		else {
			phieuImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			phieuImpl.setCreateDate(null);
		}
		else {
			phieuImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			phieuImpl.setModifiedDate(null);
		}
		else {
			phieuImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (maCTV == null) {
			phieuImpl.setMaCTV("");
		}
		else {
			phieuImpl.setMaCTV(maCTV);
		}

		if (hoTenCTV == null) {
			phieuImpl.setHoTenCTV("");
		}
		else {
			phieuImpl.setHoTenCTV(hoTenCTV);
		}

		if (soHopDong == null) {
			phieuImpl.setSoHopDong("");
		}
		else {
			phieuImpl.setSoHopDong(soHopDong);
		}

		if (ngayChungTu == Long.MIN_VALUE) {
			phieuImpl.setNgayChungTu(null);
		}
		else {
			phieuImpl.setNgayChungTu(new Date(ngayChungTu));
		}

		if (diaChi == null) {
			phieuImpl.setDiaChi("");
		}
		else {
			phieuImpl.setDiaChi(diaChi);
		}

		if (soPhieu == null) {
			phieuImpl.setSoPhieu("");
		}
		else {
			phieuImpl.setSoPhieu(soPhieu);
		}

		if (ngayGhiSo == Long.MIN_VALUE) {
			phieuImpl.setNgayGhiSo(null);
		}
		else {
			phieuImpl.setNgayGhiSo(new Date(ngayGhiSo));
		}

		if (maMSThuChi == null) {
			phieuImpl.setMaMSThuChi("");
		}
		else {
			phieuImpl.setMaMSThuChi(maMSThuChi);
		}

		phieuImpl.setSoTien(soTien);

		if (chungTuKemTheo == null) {
			phieuImpl.setChungTuKemTheo("");
		}
		else {
			phieuImpl.setChungTuKemTheo(chungTuKemTheo);
		}

		phieuImpl.setLoai(loai);
		phieuImpl.setHoatDong(hoatDong);

		phieuImpl.resetOriginalValues();

		return phieuImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		phieuId = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		maCTV = objectInput.readUTF();
		hoTenCTV = objectInput.readUTF();
		soHopDong = objectInput.readUTF();
		ngayChungTu = objectInput.readLong();
		diaChi = objectInput.readUTF();
		soPhieu = objectInput.readUTF();
		ngayGhiSo = objectInput.readLong();
		maMSThuChi = objectInput.readUTF();

		soTien = objectInput.readDouble();
		chungTuKemTheo = objectInput.readUTF();

		loai = objectInput.readInt();

		hoatDong = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(phieuId);

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

		if (hoTenCTV == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(hoTenCTV);
		}

		if (soHopDong == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(soHopDong);
		}

		objectOutput.writeLong(ngayChungTu);

		if (diaChi == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(diaChi);
		}

		if (soPhieu == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(soPhieu);
		}

		objectOutput.writeLong(ngayGhiSo);

		if (maMSThuChi == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(maMSThuChi);
		}

		objectOutput.writeDouble(soTien);

		if (chungTuKemTheo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(chungTuKemTheo);
		}

		objectOutput.writeInt(loai);

		objectOutput.writeBoolean(hoatDong);
	}

	public long phieuId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String maCTV;
	public String hoTenCTV;
	public String soHopDong;
	public long ngayChungTu;
	public String diaChi;
	public String soPhieu;
	public long ngayGhiSo;
	public String maMSThuChi;
	public double soTien;
	public String chungTuKemTheo;
	public int loai;
	public boolean hoatDong;

}