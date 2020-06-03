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
 * The extended model interface for the LichSuThuPhatChi service. Represents a row in the &quot;mb_lichsuthuphatchi&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see LichSuThuPhatChiModel
 * @generated
 */
@ImplementationClassName("com.mb.model.impl.LichSuThuPhatChiImpl")
@ProviderType
public interface LichSuThuPhatChi
	extends LichSuThuPhatChiModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.mb.model.impl.LichSuThuPhatChiImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<LichSuThuPhatChi, Long>
		LICH_SU_THU_PHAT_CHI_ID_ACCESSOR =
			new Accessor<LichSuThuPhatChi, Long>() {

				@Override
				public Long get(LichSuThuPhatChi lichSuThuPhatChi) {
					return lichSuThuPhatChi.getLichSuThuPhatChiId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<LichSuThuPhatChi> getTypeClass() {
					return LichSuThuPhatChi.class;
				}

			};

}