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

import com.mb.model.TaiKhoanDoiUng;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TaiKhoanDoiUng in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class TaiKhoanDoiUngCacheModel
	implements CacheModel<TaiKhoanDoiUng>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TaiKhoanDoiUngCacheModel)) {
			return false;
		}

		TaiKhoanDoiUngCacheModel taiKhoanDoiUngCacheModel =
			(TaiKhoanDoiUngCacheModel)obj;

		if (taiKhoanDoiUngId == taiKhoanDoiUngCacheModel.taiKhoanDoiUngId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, taiKhoanDoiUngId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{taiKhoanDoiUngId=");
		sb.append(taiKhoanDoiUngId);
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
		sb.append(", taiKhoanDoiUngChaId=");
		sb.append(taiKhoanDoiUngChaId);
		sb.append(", soHieu=");
		sb.append(soHieu);
		sb.append(", ten=");
		sb.append(ten);
		sb.append(", hoatDong=");
		sb.append(hoatDong);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TaiKhoanDoiUng toEntityModel() {
		TaiKhoanDoiUngImpl taiKhoanDoiUngImpl = new TaiKhoanDoiUngImpl();

		taiKhoanDoiUngImpl.setTaiKhoanDoiUngId(taiKhoanDoiUngId);
		taiKhoanDoiUngImpl.setCompanyId(companyId);
		taiKhoanDoiUngImpl.setGroupId(groupId);
		taiKhoanDoiUngImpl.setUserId(userId);

		if (userName == null) {
			taiKhoanDoiUngImpl.setUserName("");
		}
		else {
			taiKhoanDoiUngImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			taiKhoanDoiUngImpl.setCreateDate(null);
		}
		else {
			taiKhoanDoiUngImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			taiKhoanDoiUngImpl.setModifiedDate(null);
		}
		else {
			taiKhoanDoiUngImpl.setModifiedDate(new Date(modifiedDate));
		}

		taiKhoanDoiUngImpl.setTaiKhoanDoiUngChaId(taiKhoanDoiUngChaId);

		if (soHieu == null) {
			taiKhoanDoiUngImpl.setSoHieu("");
		}
		else {
			taiKhoanDoiUngImpl.setSoHieu(soHieu);
		}

		if (ten == null) {
			taiKhoanDoiUngImpl.setTen("");
		}
		else {
			taiKhoanDoiUngImpl.setTen(ten);
		}

		taiKhoanDoiUngImpl.setHoatDong(hoatDong);

		taiKhoanDoiUngImpl.resetOriginalValues();

		return taiKhoanDoiUngImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		taiKhoanDoiUngId = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		taiKhoanDoiUngChaId = objectInput.readLong();
		soHieu = objectInput.readUTF();
		ten = objectInput.readUTF();

		hoatDong = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(taiKhoanDoiUngId);

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

		objectOutput.writeLong(taiKhoanDoiUngChaId);

		if (soHieu == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(soHieu);
		}

		if (ten == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ten);
		}

		objectOutput.writeBoolean(hoatDong);
	}

	public long taiKhoanDoiUngId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long taiKhoanDoiUngChaId;
	public String soHieu;
	public String ten;
	public boolean hoatDong;

}