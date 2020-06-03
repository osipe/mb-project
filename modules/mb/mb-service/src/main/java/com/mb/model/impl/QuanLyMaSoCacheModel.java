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

import com.mb.model.QuanLyMaSo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing QuanLyMaSo in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class QuanLyMaSoCacheModel
	implements CacheModel<QuanLyMaSo>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof QuanLyMaSoCacheModel)) {
			return false;
		}

		QuanLyMaSoCacheModel quanLyMaSoCacheModel = (QuanLyMaSoCacheModel)obj;

		if (quanLyMaSoId == quanLyMaSoCacheModel.quanLyMaSoId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, quanLyMaSoId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{quanLyMaSoId=");
		sb.append(quanLyMaSoId);
		sb.append(", key=");
		sb.append(key);
		sb.append(", so=");
		sb.append(so);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public QuanLyMaSo toEntityModel() {
		QuanLyMaSoImpl quanLyMaSoImpl = new QuanLyMaSoImpl();

		quanLyMaSoImpl.setQuanLyMaSoId(quanLyMaSoId);

		if (key == null) {
			quanLyMaSoImpl.setKey("");
		}
		else {
			quanLyMaSoImpl.setKey(key);
		}

		quanLyMaSoImpl.setSo(so);

		quanLyMaSoImpl.resetOriginalValues();

		return quanLyMaSoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		quanLyMaSoId = objectInput.readLong();
		key = objectInput.readUTF();

		so = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(quanLyMaSoId);

		if (key == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(key);
		}

		objectOutput.writeInt(so);
	}

	public long quanLyMaSoId;
	public String key;
	public int so;

}