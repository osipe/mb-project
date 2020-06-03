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
 * The extended model interface for the TaiSanThueChap service. Represents a row in the &quot;mb_taisaithuechap&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see TaiSanThueChapModel
 * @generated
 */
@ImplementationClassName("com.mb.model.impl.TaiSanThueChapImpl")
@ProviderType
public interface TaiSanThueChap extends PersistedModel, TaiSanThueChapModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.mb.model.impl.TaiSanThueChapImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<TaiSanThueChap, Long>
		TAI_SAN_THUE_CHAP_ID_ACCESSOR = new Accessor<TaiSanThueChap, Long>() {

			@Override
			public Long get(TaiSanThueChap taiSanThueChap) {
				return taiSanThueChap.getTaiSanThueChapId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<TaiSanThueChap> getTypeClass() {
				return TaiSanThueChap.class;
			}

		};

	public KhachHang getKhachHang();

	public PhatVay getPhatVay();

}