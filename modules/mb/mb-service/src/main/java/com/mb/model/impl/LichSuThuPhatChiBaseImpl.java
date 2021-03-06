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

import com.mb.model.LichSuThuPhatChi;
import com.mb.service.LichSuThuPhatChiLocalServiceUtil;

/**
 * The extended model base implementation for the LichSuThuPhatChi service. Represents a row in the &quot;mb_lichsuthuphatchi&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LichSuThuPhatChiImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LichSuThuPhatChiImpl
 * @see LichSuThuPhatChi
 * @generated
 */
@ProviderType
public abstract class LichSuThuPhatChiBaseImpl
	extends LichSuThuPhatChiModelImpl implements LichSuThuPhatChi {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a lich su thu phat chi model instance should use the <code>LichSuThuPhatChi</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			LichSuThuPhatChiLocalServiceUtil.addLichSuThuPhatChi(this);
		}
		else {
			LichSuThuPhatChiLocalServiceUtil.updateLichSuThuPhatChi(this);
		}
	}

}