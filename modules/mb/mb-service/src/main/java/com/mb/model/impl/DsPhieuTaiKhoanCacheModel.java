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

import com.mb.model.DsPhieuTaiKhoan;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DsPhieuTaiKhoan in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class DsPhieuTaiKhoanCacheModel
	implements CacheModel<DsPhieuTaiKhoan>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DsPhieuTaiKhoanCacheModel)) {
			return false;
		}

		DsPhieuTaiKhoanCacheModel dsPhieuTaiKhoanCacheModel =
			(DsPhieuTaiKhoanCacheModel)obj;

		if (dsPhieuTaiKhoanId == dsPhieuTaiKhoanCacheModel.dsPhieuTaiKhoanId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, dsPhieuTaiKhoanId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{dsPhieuTaiKhoanId=");
		sb.append(dsPhieuTaiKhoanId);
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
		sb.append(", phieuId=");
		sb.append(phieuId);
		sb.append(", ngayChungTu=");
		sb.append(ngayChungTu);
		sb.append(", taiKhoanDoiUngId=");
		sb.append(taiKhoanDoiUngId);
		sb.append(", maTheoDoi=");
		sb.append(maTheoDoi);
		sb.append(", dienGiaiTheoDoi=");
		sb.append(dienGiaiTheoDoi);
		sb.append(", soTien=");
		sb.append(soTien);
		sb.append(", tenCTV=");
		sb.append(tenCTV);
		sb.append(", hoatDong=");
		sb.append(hoatDong);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DsPhieuTaiKhoan toEntityModel() {
		DsPhieuTaiKhoanImpl dsPhieuTaiKhoanImpl = new DsPhieuTaiKhoanImpl();

		dsPhieuTaiKhoanImpl.setDsPhieuTaiKhoanId(dsPhieuTaiKhoanId);
		dsPhieuTaiKhoanImpl.setCompanyId(companyId);
		dsPhieuTaiKhoanImpl.setGroupId(groupId);
		dsPhieuTaiKhoanImpl.setUserId(userId);

		if (userName == null) {
			dsPhieuTaiKhoanImpl.setUserName("");
		}
		else {
			dsPhieuTaiKhoanImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			dsPhieuTaiKhoanImpl.setCreateDate(null);
		}
		else {
			dsPhieuTaiKhoanImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			dsPhieuTaiKhoanImpl.setModifiedDate(null);
		}
		else {
			dsPhieuTaiKhoanImpl.setModifiedDate(new Date(modifiedDate));
		}

		dsPhieuTaiKhoanImpl.setPhieuId(phieuId);

		if (ngayChungTu == Long.MIN_VALUE) {
			dsPhieuTaiKhoanImpl.setNgayChungTu(null);
		}
		else {
			dsPhieuTaiKhoanImpl.setNgayChungTu(new Date(ngayChungTu));
		}

		dsPhieuTaiKhoanImpl.setTaiKhoanDoiUngId(taiKhoanDoiUngId);

		if (maTheoDoi == null) {
			dsPhieuTaiKhoanImpl.setMaTheoDoi("");
		}
		else {
			dsPhieuTaiKhoanImpl.setMaTheoDoi(maTheoDoi);
		}

		if (dienGiaiTheoDoi == null) {
			dsPhieuTaiKhoanImpl.setDienGiaiTheoDoi("");
		}
		else {
			dsPhieuTaiKhoanImpl.setDienGiaiTheoDoi(dienGiaiTheoDoi);
		}

		dsPhieuTaiKhoanImpl.setSoTien(soTien);

		if (tenCTV == null) {
			dsPhieuTaiKhoanImpl.setTenCTV("");
		}
		else {
			dsPhieuTaiKhoanImpl.setTenCTV(tenCTV);
		}

		dsPhieuTaiKhoanImpl.setHoatDong(hoatDong);

		dsPhieuTaiKhoanImpl.resetOriginalValues();

		return dsPhieuTaiKhoanImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		dsPhieuTaiKhoanId = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		phieuId = objectInput.readLong();
		ngayChungTu = objectInput.readLong();

		taiKhoanDoiUngId = objectInput.readLong();
		maTheoDoi = objectInput.readUTF();
		dienGiaiTheoDoi = objectInput.readUTF();

		soTien = objectInput.readDouble();
		tenCTV = objectInput.readUTF();

		hoatDong = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(dsPhieuTaiKhoanId);

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

		objectOutput.writeLong(phieuId);
		objectOutput.writeLong(ngayChungTu);

		objectOutput.writeLong(taiKhoanDoiUngId);

		if (maTheoDoi == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(maTheoDoi);
		}

		if (dienGiaiTheoDoi == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dienGiaiTheoDoi);
		}

		objectOutput.writeDouble(soTien);

		if (tenCTV == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tenCTV);
		}

		objectOutput.writeBoolean(hoatDong);
	}

	public long dsPhieuTaiKhoanId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long phieuId;
	public long ngayChungTu;
	public long taiKhoanDoiUngId;
	public String maTheoDoi;
	public String dienGiaiTheoDoi;
	public double soTien;
	public String tenCTV;
	public boolean hoatDong;

}