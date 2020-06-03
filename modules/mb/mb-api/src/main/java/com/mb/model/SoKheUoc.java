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
 * The extended model interface for the SoKheUoc service. Represents a row in the &quot;dm_sokheuoc&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see SoKheUocModel
 * @generated
 */
@ImplementationClassName("com.mb.model.impl.SoKheUocImpl")
@ProviderType
public interface SoKheUoc extends PersistedModel, SoKheUocModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.mb.model.impl.SoKheUocImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<SoKheUoc, Long> SO_KHE_UOC_ID_ACCESSOR =
		new Accessor<SoKheUoc, Long>() {

			@Override
			public Long get(SoKheUoc soKheUoc) {
				return soKheUoc.getSoKheUocId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<SoKheUoc> getTypeClass() {
				return SoKheUoc.class;
			}

		};

	public String getSoKheUocDayDu();

}