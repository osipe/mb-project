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

import com.mb.model.CauHinhThuTienTruoc;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CauHinhThuTienTruoc in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class CauHinhThuTienTruocCacheModel
	implements CacheModel<CauHinhThuTienTruoc>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CauHinhThuTienTruocCacheModel)) {
			return false;
		}

		CauHinhThuTienTruocCacheModel cauHinhThuTienTruocCacheModel =
			(CauHinhThuTienTruocCacheModel)obj;

		if (cauHinhThuTienTruocId ==
				cauHinhThuTienTruocCacheModel.cauHinhThuTienTruocId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, cauHinhThuTienTruocId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{cauHinhThuTienTruocId=");
		sb.append(cauHinhThuTienTruocId);
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
		sb.append(", nam=");
		sb.append(nam);
		sb.append(", ngayTu=");
		sb.append(ngayTu);
		sb.append(", ngayDen=");
		sb.append(ngayDen);
		sb.append(", hoatDong=");
		sb.append(hoatDong);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CauHinhThuTienTruoc toEntityModel() {
		CauHinhThuTienTruocImpl cauHinhThuTienTruocImpl =
			new CauHinhThuTienTruocImpl();

		cauHinhThuTienTruocImpl.setCauHinhThuTienTruocId(cauHinhThuTienTruocId);
		cauHinhThuTienTruocImpl.setCompanyId(companyId);
		cauHinhThuTienTruocImpl.setGroupId(groupId);
		cauHinhThuTienTruocImpl.setUserId(userId);

		if (userName == null) {
			cauHinhThuTienTruocImpl.setUserName("");
		}
		else {
			cauHinhThuTienTruocImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			cauHinhThuTienTruocImpl.setCreateDate(null);
		}
		else {
			cauHinhThuTienTruocImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			cauHinhThuTienTruocImpl.setModifiedDate(null);
		}
		else {
			cauHinhThuTienTruocImpl.setModifiedDate(new Date(modifiedDate));
		}

		cauHinhThuTienTruocImpl.setNam(nam);

		if (ngayTu == Long.MIN_VALUE) {
			cauHinhThuTienTruocImpl.setNgayTu(null);
		}
		else {
			cauHinhThuTienTruocImpl.setNgayTu(new Date(ngayTu));
		}

		if (ngayDen == Long.MIN_VALUE) {
			cauHinhThuTienTruocImpl.setNgayDen(null);
		}
		else {
			cauHinhThuTienTruocImpl.setNgayDen(new Date(ngayDen));
		}

		cauHinhThuTienTruocImpl.setHoatDong(hoatDong);

		cauHinhThuTienTruocImpl.resetOriginalValues();

		return cauHinhThuTienTruocImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		cauHinhThuTienTruocId = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		nam = objectInput.readInt();
		ngayTu = objectInput.readLong();
		ngayDen = objectInput.readLong();

		hoatDong = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(cauHinhThuTienTruocId);

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

		objectOutput.writeInt(nam);
		objectOutput.writeLong(ngayTu);
		objectOutput.writeLong(ngayDen);

		objectOutput.writeBoolean(hoatDong);
	}

	public long cauHinhThuTienTruocId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int nam;
	public long ngayTu;
	public long ngayDen;
	public boolean hoatDong;

}