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
import com.mb.model.LichSuThuPhatChi;
import com.mb.model.impl.LichSuThuPhatChiImpl;
import com.mb.service.persistence.LichSuThuPhatChiFinder;

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
@Component(service = LichSuThuPhatChiFinder.class)
public class LichSuThuPhatChiFinderImpl extends LichSuThuPhatChiFinderBaseImpl implements LichSuThuPhatChiFinder {
	@ServiceReference(type = CustomSQL.class)
	private CustomSQL _customSQL;

	public static final String FIND_BY_CTV_LOAI_CREATEDATE = LichSuThuPhatChiFinder.class.getName()
			+ ".findByCTV_Loai_Createdate";
	public static final String FIND_BY_PHATVAY_CREATEDATE_LOAI = LichSuThuPhatChiFinder.class.getName()
			+ ".findByPhatVay_Createdate_Loai";

	@SuppressWarnings("unchecked")
	public List<LichSuThuPhatChi> findByPhatVay_Createdate_Loai(long phatVayId, Date ngayTaoTu, Date ngayTaoDen,
			String loai) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = _customSQL.get(getClass(), FIND_BY_PHATVAY_CREATEDATE_LOAI);
			if (phatVayId == 0) {
				sql = sql.replace("AND (phatVayId = ?)", "");
			}
			if (ngayTaoDen == null) {
				sql = sql.replace("AND (createDate <= ?)", "");
			}
			if (ngayTaoTu == null) {
				sql = sql.replace("AND (createDate >= ?)", "");
			}
			if (Validator.isNull(loai)) {
				sql = sql.replace("AND [$QUERY_LOAI$]", "");
			} else {
				sql = sql.replace("AND [$QUERY_LOAI$]", "AND loai IN (" + loai + ")");
			}
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("LichSuThuPhatChi", LichSuThuPhatChiImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			if (phatVayId > 0) {
				qPos.add(phatVayId);
			}
			if (Validator.isNotNull(ngayTaoDen)) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(ngayTaoDen);
				qPos.add(CalendarUtil.getTimestamp(CalendarUtil.getLTDate(cal)));
			}
			if (Validator.isNotNull(ngayTaoTu)) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(ngayTaoTu);
				qPos.add(CalendarUtil.getTimestamp(CalendarUtil.getGTDate(cal)));
			}
			return (List<LichSuThuPhatChi>) QueryUtil.list(q, getDialect(), -1, -1);
		} catch (Exception e) {
			e.printStackTrace();
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	@SuppressWarnings("unchecked")
	public List<LichSuThuPhatChi> findByCTV_Loai_Createdate(String maCTV, int loai, Date ngayTaoTu, Date ngayTaoDen,
			int start, int end, OrderByComparator obc) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = _customSQL.get(getClass(), FIND_BY_CTV_LOAI_CREATEDATE);
			if (Validator.isNull(maCTV)) {
				sql = sql.replace("AND (maCTV = ?)", "");
			}
			if (loai == 0) {
				sql = sql.replace("AND (loai = ?)", "");
			}
			if (ngayTaoTu == null) {
				sql = sql.replace("AND (createDate <= ?)", "");
			}
			if (ngayTaoDen == null) {
				sql = sql.replace("AND (createDate >= ?)", "");
			}
			sql = _customSQL.replaceOrderBy(sql, obc);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("LichSuThuPhatChi", LichSuThuPhatChiImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			if (Validator.isNotNull(maCTV)) {
				qPos.add(maCTV);
			}
			if (loai > 0) {
				qPos.add(loai);
			}
			if (Validator.isNotNull(ngayTaoDen)) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(ngayTaoDen);
				qPos.add(CalendarUtil.getTimestamp(CalendarUtil.getLTDate(cal)));
			}
			if (Validator.isNotNull(ngayTaoTu)) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(ngayTaoTu);
				qPos.add(CalendarUtil.getTimestamp(CalendarUtil.getGTDate(cal)));
			}
			return (List<LichSuThuPhatChi>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			e.printStackTrace();
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

}