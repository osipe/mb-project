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

package com.mb.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Phieu service. Represents a row in the &quot;ketoan_phieu&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see PhieuModel
 * @generated
 */
@ImplementationClassName("com.mb.model.impl.PhieuImpl")
@ProviderType
public interface Phieu extends PersistedModel, PhieuModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.mb.model.impl.PhieuImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Phieu, Long> PHIEU_ID_ACCESSOR =
		new Accessor<Phieu, Long>() {

			@Override
			public Long get(Phieu phieu) {
				return phieu.getPhieuId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Phieu> getTypeClass() {
				return Phieu.class;
			}

		};

	public MaSoThuChi getMaSoThuChi();

	public CongTacVien getCtv();

	public com.liferay.portal.kernel.json.JSONArray
		getDsPhieuTaiKhoanJSONArray();

	public void setDsPhieuTaiKhoanJSONArray(
		com.liferay.portal.kernel.json.JSONArray dsPhieuTaiKhoanJSONArray);

}