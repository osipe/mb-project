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

package com.mb.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.NoSuchUserException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.mb.model.PhatVay;
import com.mb.model.TaiSanThueChap;
import com.mb.service.TaiSanThueChapLocalServiceUtil;
import com.mb.service.base.TaiSanThueChapLocalServiceBaseImpl;

/**
 * The implementation of the tai san thue chap local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.mb.service.TaiSanThueChapLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaiSanThueChapLocalServiceBaseImpl
 */
public class TaiSanThueChapLocalServiceImpl extends TaiSanThueChapLocalServiceBaseImpl {

	public void addOrTaiSanThueChap(PhatVay phatVay, ServiceContext serviceContext)
			throws SystemException, NoSuchUserException {
		if (phatVay.getPhatVayId() > 0 && phatVay.getTaiSanThueChapJSONArray() != null && phatVay.getTaiSanThueChapJSONArray().length() > 0) {
			removeByPhatVayId(phatVay.getPhatVayId());
			for (int i =0 ;i < phatVay.getTaiSanThueChapJSONArray().length();i++) {
				JSONObject item = phatVay.getTaiSanThueChapJSONArray().getJSONObject(i);
				TaiSanThueChap taiSanThueChap = TaiSanThueChapLocalServiceUtil.createTaiSanThueChap(0L);
				taiSanThueChap.setPhatVayId(phatVay.getPhatVayId());
				taiSanThueChap.setSoKU(phatVay.getSoKU());
				taiSanThueChap.setMaKhachHang(phatVay.getMaKhachHang());
				taiSanThueChap.setLoaiTaiSanId(item.getLong("loaiTaiSan"));
				String giaTriTaiSanStr = item.getString("giaTriTaiSan");
				if(Validator.isNotNull(giaTriTaiSanStr)) {
					taiSanThueChap.setGiaTriTaiSan(GetterUtil.getDouble(giaTriTaiSanStr.replaceAll(",", "")));
				}
				taiSanThueChap.setThongTinTaiSan(item.getString("thongTinTaiSan"));
				taiSanThueChap.setTen(item.getString("tenTaiSan"));
				taiSanThueChap.setGhiChu(item.getString("ghiChu"));
				addTaiSanThueChap(taiSanThueChap, serviceContext);
			}
		} else if (phatVay.getPhatVayId() > 0) {
			removeByPhatVayId(phatVay.getPhatVayId());
		}

	}

	public TaiSanThueChap addTaiSanThueChap(TaiSanThueChap taiSanThueChap, ServiceContext serviceContext)
			throws SystemException, NoSuchUserException {
		Date now = new Date();
		User user = userPersistence.findByPrimaryKey(serviceContext.getUserId());
		long taiSanThueChapId = counterLocalService.increment(TaiSanThueChap.class.getName());
		taiSanThueChap.setTaiSanThueChapId(taiSanThueChapId);
		taiSanThueChap.setGroupId(serviceContext.getScopeGroupId());
		taiSanThueChap.setCompanyId(user.getCompanyId());
		taiSanThueChap.setUserId(user.getUserId());
		taiSanThueChap.setUserName(user.getFullName());
		taiSanThueChap.setCreateDate(serviceContext.getCreateDate(now));
		taiSanThueChap.setModifiedDate(serviceContext.getModifiedDate(now));
		taiSanThueChap.setExpandoBridgeAttributes(serviceContext);
		addTaiSanThueChap(taiSanThueChap);
		return taiSanThueChap;
	}

	public TaiSanThueChap updateTaiSanThueChap(TaiSanThueChap taiSanThueChap, ServiceContext serviceContext)
			throws SystemException {
		taiSanThueChap.setExpandoBridgeAttributes(serviceContext);
		updateTaiSanThueChap(taiSanThueChap);
		return taiSanThueChap;
	}

	public List<TaiSanThueChap> findByPhatVayId(long phatVayId) throws SystemException {
		return taiSanThueChapPersistence.findByPhatVayId(phatVayId);
	}

	public void removeByPhatVayId(long phatVayId) throws SystemException {
		taiSanThueChapPersistence.removeByPhatVayId(phatVayId);
	}

	public List<TaiSanThueChap> findBase( String soKU, String ten, String maKhachHang, long loaiTaiSanId,String thongTinTaiSan,
			int start, int end, OrderByComparator obc) throws SystemException {
		return taiSanThueChapFinder.findBase( soKU, ten, maKhachHang, loaiTaiSanId,thongTinTaiSan, start, end, obc);
	}

	public int countBase( String soKU, String ten, String maKhachHang, long loaiTaiSanId,String thongTinTaiSan)
			throws SystemException {
		return taiSanThueChapFinder.countBase( soKU, ten, maKhachHang, loaiTaiSanId,thongTinTaiSan );
	}

}