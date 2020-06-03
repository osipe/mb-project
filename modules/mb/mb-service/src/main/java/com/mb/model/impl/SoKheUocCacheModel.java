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

import com.mb.model.SoKheUoc;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing SoKheUoc in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class SoKheUocCacheModel
	implements CacheModel<SoKheUoc>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SoKheUocCacheModel)) {
			return false;
		}

		SoKheUocCacheModel soKheUocCacheModel = (SoKheUocCacheModel)obj;

		if (soKheUocId == soKheUocCacheModel.soKheUocId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, soKheUocId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{soKheUocId=");
		sb.append(soKheUocId);
		sb.append(", cauTruc=");
		sb.append(cauTruc);
		sb.append(", so=");
		sb.append(so);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SoKheUoc toEntityModel() {
		SoKheUocImpl soKheUocImpl = new SoKheUocImpl();

		soKheUocImpl.setSoKheUocId(soKheUocId);

		if (cauTruc == null) {
			soKheUocImpl.setCauTruc("");
		}
		else {
			soKheUocImpl.setCauTruc(cauTruc);
		}

		soKheUocImpl.setSo(so);

		soKheUocImpl.resetOriginalValues();

		return soKheUocImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		soKheUocId = objectInput.readLong();
		cauTruc = objectInput.readUTF();

		so = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(soKheUocId);

		if (cauTruc == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cauTruc);
		}

		objectOutput.writeInt(so);
	}

	public long soKheUocId;
	public String cauTruc;
	public int so;

}