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

package com.mb.service.persistence.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.spring.extender.service.ServiceReference;
import com.mb.model.DsPhieuTaiKhoan;
import com.mb.model.impl.DsPhieuTaiKhoanImpl;
import com.mb.service.persistence.DsPhieuTaiKhoanFinder;

/**
 * The persistence implementation for the cong tac vien service.
 *
 * <p>
 * Caching information and settings can be found in
 * <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DsPhieuTaiKhoanFinder.class)
public class DsPhieuTaiKhoanFinderImpl extends DsPhieuTaiKhoanFinderBaseImpl implements DsPhieuTaiKhoanFinder {
	@ServiceReference(type = CustomSQL.class)
	private CustomSQL _customSQL;

	public static final String GET_DSTHUCHI_BY_TAIKHOAN_NGAYCHUNGTU = DsPhieuTaiKhoanFinder.class.getName()
			+ ".getDSThuChiByTaiKhoanNgayChungTu";

	@SuppressWarnings("unchecked")
	public List<DsPhieuTaiKhoan> getDSThuChiByTaiKhoanNgayChungTu(long taiKhoanDoiUngId, Date ngayChungTuTu,
			Date ngayChungTuDen, int hoatDong, int start, int end, OrderByComparator obc) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = _customSQL.get(getClass(), GET_DSTHUCHI_BY_TAIKHOAN_NGAYCHUNGTU);
			if (hoatDong == 0) {
				sql = sql.replace("AND (hoatdong = ?)", "");
			}
			if (taiKhoanDoiUngId == 0) {
				sql = sql.replace("AND (taiKhoanDoiUngId IN (SELECT taiKhoanDoiUngId FROM dm_taikhoandoiung WHERE taiKhoanDoiUngChaId = ? OR taiKhoanDoiUngId = ?)","");
			}
			if (Validator.isNull(ngayChungTuTu)) {
				sql = sql.replace("AND (ngayChungTu >= ?)", "");
			}
			if (Validator.isNull(ngayChungTuDen)) {
				sql = sql.replace("AND (ngayChungTu <= ?)", "");
			}
			sql = _customSQL.replaceOrderBy(sql, obc);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("DsPhieuTaiKhoan", DsPhieuTaiKhoanImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			if (hoatDong != 0) {
				qPos.add(hoatDong == 1 ? true : false);
			}
			if (taiKhoanDoiUngId > 0) {
				qPos.add(taiKhoanDoiUngId);
				qPos.add(taiKhoanDoiUngId);
			}

			if (Validator.isNotNull(ngayChungTuTu)) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(ngayChungTuTu);
				qPos.add(CalendarUtil.getTimestamp(CalendarUtil.getGTDate(cal)));
			}
			if (Validator.isNotNull(ngayChungTuDen)) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(ngayChungTuDen);
				qPos.add(CalendarUtil.getTimestamp(CalendarUtil.getLTDate(cal)));
			}
			return (List<DsPhieuTaiKhoan>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			e.printStackTrace();
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

}