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
import java.util.Iterator;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.spring.extender.service.ServiceReference;
import com.mb.model.CongTacVien;
import com.mb.model.impl.CongTacVienImpl;
import com.mb.service.persistence.CongTacVienFinder;

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
@Component(service = CongTacVienFinder.class)
public class CongTacVienFinderImpl extends CongTacVienFinderBaseImpl implements CongTacVienFinder {
	@ServiceReference(type = CustomSQL.class)
	private CustomSQL _customSQL;

	public static final String FIND_BASE = CongTacVienFinder.class.getName() + ".findBase";
	public static final String COUNT_BASE = CongTacVienFinder.class.getName() + ".countBase";
	public static final String GET_CTV_SAOKE = CongTacVienFinder.class.getName() + ".getCTVSaoKe";
	public static final String GET_CTV_PHATVAYNGAY = CongTacVienFinder.class.getName() + ".getCTVPhatVayNgay";
	public static final String GET_CTV_THUPHATCHI = CongTacVienFinder.class.getName() + ".getCTVThuPhatChi";
	
	
	@SuppressWarnings("unchecked")
	public List<CongTacVien> getCTVThuPhatChi(String maCTV,Date ngayTaoTu,Date ngayTaoDen) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = _customSQL.get(getClass(), GET_CTV_THUPHATCHI);
			if (Validator.isNull(maCTV)) {
				sql = sql.replace("AND (maCTV = ?)","");
			}
			if (ngayTaoDen == null) {
				sql = sql.replace("AND (createDate <= ?)","");
			}
			if (ngayTaoTu == null) {
				sql = sql.replace("AND (createDate >= ?)","");
			}
			sql = _customSQL.replaceOrderBy(sql, null);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("CongTacVien", CongTacVienImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			if (Validator.isNotNull(maCTV)) {
				qPos.add(maCTV);
			}
			if (ngayTaoDen != null) {
				Calendar calDen = Calendar.getInstance();
				calDen.setTime(ngayTaoDen);
				qPos.add(CalendarUtil.getTimestamp(CalendarUtil.getLTDate(calDen)));
			}
			if (ngayTaoTu != null) {
				Calendar calTu = Calendar.getInstance();
				calTu.setTime(ngayTaoTu);
				qPos.add(CalendarUtil.getTimestamp(CalendarUtil.getGTDate(calTu)));
			}
			return (List<CongTacVien>) QueryUtil.list(q, getDialect(), -1, -1);
		} catch (Exception e) {
			e.printStackTrace();
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<CongTacVien> getCTVPhatVayNgay(Date ngayTaoTu,Date ngayTaoDen) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = _customSQL.get(getClass(), GET_CTV_PHATVAYNGAY);
			if (ngayTaoTu == null || ngayTaoDen == null) {
				sql = sql.replace("AND [QUERY_PHAVAYNGAY]","");
			}else {
				sql = sql.replace("AND [QUERY_PHAVAYNGAY]","AND ma IN (SELECT mactv FROM mb_phatvay  WHERE createdate >= ? and createdate <= ?)");
			}
			sql = _customSQL.replaceOrderBy(sql, null);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("CongTacVien", CongTacVienImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			if (ngayTaoTu != null && ngayTaoDen != null) {
				Calendar calTu = Calendar.getInstance();
				calTu.setTime(ngayTaoTu);
				qPos.add(CalendarUtil.getTimestamp(CalendarUtil.getGTDate(calTu)));
				Calendar calDen = Calendar.getInstance();
				calDen.setTime(ngayTaoDen);
				qPos.add(CalendarUtil.getTimestamp(CalendarUtil.getLTDate(calDen)));
			}
			return (List<CongTacVien>) QueryUtil.list(q, getDialect(), -1, -1);
		} catch (Exception e) {
			e.printStackTrace();
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<CongTacVien> getCTVSaoKe(String maCTV,Date createDate) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = _customSQL.get(getClass(), GET_CTV_SAOKE);
			if (Validator.isNull(maCTV)) {
				sql = sql.replace("and mactv = ?", "");
			}
			if(createDate == null) {
				sql = sql.replace("and ngayketthuc >= ?", "");
				sql = sql.replace("and createdate <= ?", "");
				sql = sql.replace("and createdate <= ?", "");
			}
			sql = _customSQL.replaceOrderBy(sql, null);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("CongTacVien", CongTacVienImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			if (Validator.isNotNull(maCTV)) {
				qPos.add(maCTV);
			}
			if(createDate != null) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(createDate);
				qPos.add(CalendarUtil.getTimestamp(CalendarUtil.getGTDate(cal)));
				qPos.add(CalendarUtil.getTimestamp(CalendarUtil.getLTDate(cal)));
				qPos.add(CalendarUtil.getTimestamp(CalendarUtil.getLTDate(cal)));
			}else {
			}
			return (List<CongTacVien>) QueryUtil.list(q, getDialect(), -1, -1);
		} catch (Exception e) {
			e.printStackTrace();
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	@SuppressWarnings("unchecked")
	public List<CongTacVien> findBase(String ma, String hoTen, String soCMND, String diaChi, int hoatDong, int start,
			int end, OrderByComparator obc) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = _customSQL.get(getClass(), FIND_BASE);
			if (hoatDong == 0) {
				sql = sql.replace("AND (hoatdong = ?)", "");
			}
			if (Validator.isNull(ma)) {
				sql = sql.replace("AND (ma = ?)", "");
			}
			if (Validator.isNull(soCMND)) {
				sql = sql.replace("AND (soCMND = ?)", "");
			}
			if (Validator.isNull(hoTen)) {
				sql = sql.replace("AND (LOWER(hoTen) LIKE ?)", "");
			}
			if (Validator.isNull(diaChi)) {
				sql = sql.replace("AND (LOWER(diaChi) LIKE ?)", "");
			}
			sql = _customSQL.replaceOrderBy(sql, obc);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("CongTacVien", CongTacVienImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			if (hoatDong != 0) {
				qPos.add(hoatDong == 1 ? true : false);
			}
			if (Validator.isNotNull(ma)) {
				qPos.add(ma);
			}
			if (Validator.isNotNull(soCMND)) {
				qPos.add(soCMND);
			}
			if (Validator.isNotNull(hoTen)) {
				qPos.add("%" + hoTen.toLowerCase() + "%");
			}
			if (Validator.isNotNull(diaChi)) {
				qPos.add("%" + diaChi.toLowerCase() + "%");
			}
			return (List<CongTacVien>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			e.printStackTrace();
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public int countBase(String ma, String hoTen, String soCMND, String diaChi, int hoatDong) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = _customSQL.get(getClass(), COUNT_BASE);

			if (hoatDong == 0) {
				sql = sql.replace("AND (hoatdong = ?)", "");
			}
			if (Validator.isNull(ma)) {
				sql = sql.replace("AND (ma = ?)", "");
			}
			if (Validator.isNull(soCMND)) {
				sql = sql.replace("AND (soCMND = ?)", "");
			}
			if (Validator.isNull(hoTen)) {
				sql = sql.replace("AND (LOWER(hoTen) LIKE ?)", "");
			}
			if (Validator.isNull(diaChi)) {
				sql = sql.replace("AND (LOWER(diaChi) LIKE ?)", "");
			}
			sql = _customSQL.replaceAndOperator(sql, true);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("COUNT_VALUE", Type.LONG);
			QueryPos qPos = QueryPos.getInstance(q);
			if (hoatDong != 0) {
				qPos.add(hoatDong == 1 ? true : false);
			}
			if (Validator.isNotNull(ma)) {
				qPos.add(ma);
			}
			if (Validator.isNotNull(soCMND)) {
				qPos.add(soCMND);
			}
			if (Validator.isNotNull(hoTen)) {
				qPos.add("%" + hoTen.toLowerCase() + "%");
			}
			if (Validator.isNotNull(diaChi)) {
				qPos.add("%" + diaChi.toLowerCase() + "%");
			}

			@SuppressWarnings("unchecked")
			Iterator<Long> iter = q.list().iterator();
			if (iter.hasNext()) {
				Long value = iter.next();
				if (Validator.isNotNull(value)) {
					return value.intValue();
				}
			}
			return 0;
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

}