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

import com.mb.model.ChiNhanh;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ChiNhanh in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class ChiNhanhCacheModel
	implements CacheModel<ChiNhanh>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ChiNhanhCacheModel)) {
			return false;
		}

		ChiNhanhCacheModel chiNhanhCacheModel = (ChiNhanhCacheModel)obj;

		if (chiNhanhId == chiNhanhCacheModel.chiNhanhId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, chiNhanhId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{chiNhanhId=");
		sb.append(chiNhanhId);
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
		sb.append(", ten=");
		sb.append(ten);
		sb.append(", hoatDong=");
		sb.append(hoatDong);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ChiNhanh toEntityModel() {
		ChiNhanhImpl chiNhanhImpl = new ChiNhanhImpl();

		chiNhanhImpl.setChiNhanhId(chiNhanhId);
		chiNhanhImpl.setCompanyId(companyId);
		chiNhanhImpl.setGroupId(groupId);
		chiNhanhImpl.setUserId(userId);

		if (userName == null) {
			chiNhanhImpl.setUserName("");
		}
		else {
			chiNhanhImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			chiNhanhImpl.setCreateDate(null);
		}
		else {
			chiNhanhImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			chiNhanhImpl.setModifiedDate(null);
		}
		else {
			chiNhanhImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (ma == null) {
			chiNhanhImpl.setMa("");
		}
		else {
			chiNhanhImpl.setMa(ma);
		}

		if (ten == null) {
			chiNhanhImpl.setTen("");
		}
		else {
			chiNhanhImpl.setTen(ten);
		}

		chiNhanhImpl.setHoatDong(hoatDong);

		chiNhanhImpl.resetOriginalValues();

		return chiNhanhImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		chiNhanhId = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		ma = objectInput.readUTF();
		ten = objectInput.readUTF();

		hoatDong = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(chiNhanhId);

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

		if (ten == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ten);
		}

		objectOutput.writeBoolean(hoatDong);
	}

	public long chiNhanhId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String ma;
	public String ten;
	public boolean hoatDong;

}