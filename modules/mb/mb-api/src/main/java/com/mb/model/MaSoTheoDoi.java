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
 * The extended model interface for the MaSoTheoDoi service. Represents a row in the &quot;dm_masotheodoi&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see MaSoTheoDoiModel
 * @generated
 */
@ImplementationClassName("com.mb.model.impl.MaSoTheoDoiImpl")
@ProviderType
public interface MaSoTheoDoi extends MaSoTheoDoiModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.mb.model.impl.MaSoTheoDoiImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<MaSoTheoDoi, Long> MA_SO_THEO_DOI_ID_ACCESSOR =
		new Accessor<MaSoTheoDoi, Long>() {

			@Override
			public Long get(MaSoTheoDoi maSoTheoDoi) {
				return maSoTheoDoi.getMaSoTheoDoiId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<MaSoTheoDoi> getTypeClass() {
				return MaSoTheoDoi.class;
			}

		};

}