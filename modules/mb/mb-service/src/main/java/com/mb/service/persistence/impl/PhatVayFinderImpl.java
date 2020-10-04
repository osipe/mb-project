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
import com.mb.model.PhatVay;
import com.mb.model.impl.PhatVayImpl;
import com.mb.service.persistence.PhatVayFinder;

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
@Component(service = PhatVayFinder.class)
public class PhatVayFinderImpl extends PhatVayFinderBaseImpl implements PhatVayFinder {
	@ServiceReference(type = CustomSQL.class)
	private CustomSQL _customSQL;

	public static final String FIND_BASE = PhatVayFinder.class.getName() + ".findBase";
	public static final String COUNT_BASE = PhatVayFinder.class.getName() + ".countBase";
	public static final String FINDCTV_NGAYTHUTIEN = PhatVayFinder.class.getName() + ".findCTV_NgayThuTien";
	public static final String GET_PHAT_VAY_DE_THU_TIEN_TRUOC = PhatVayFinder.class.getName()
			+ ".getPhatVayDeThuTienTruoc";
	public static final String GET_PHATVAY_BY_NGAYTHUTRUOC_LAST = PhatVayFinder.class.getName()
			+ ".getPhatVayByNgayThuTruocLast";
	public static final String GET_PHATVAY_SAOKE = PhatVayFinder.class.getName() + ".getPhatVaySaoKe";
	public static final String GET_PHATVAY_INIDS = PhatVayFinder.class.getName() + ".getPhatVayInIds";
	@SuppressWarnings("unchecked")
	public List<PhatVay> getPhatVayInIds(String ids) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = _customSQL.get(getClass(), GET_PHATVAY_INIDS);
			if (Validator.isNull(ids)) {
				sql = sql.replace("AND phatVayId IN ?", "");
			}
			sql = _customSQL.replaceOrderBy(sql, null);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PhatVay", PhatVayImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			if (Validator.isNotNull(ids)) {
				qPos.add("( " + ids + " ) ");
			}
			return (List<PhatVay>) QueryUtil.list(q, getDialect(), -1, -1);
		} catch (Exception e) {
			e.printStackTrace();
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	@SuppressWarnings("unchecked")
	public List<PhatVay> getPhatVaySaoKe(String maCTV,int loaiPhatVay, Date createDate) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = _customSQL.get(getClass(), GET_PHATVAY_SAOKE);
			if (Validator.isNull(maCTV)) {
				sql = sql.replace("and mactv = ?", "");
			}
			if (loaiPhatVay == 0) {
				sql = sql.replace("and loaiphatvay = ?", "");
			}
			if (createDate == null) {
				sql = sql.replace("and ngayketthuc >= ?", "");
				sql = sql.replace("and createdate <= ?", "");
				sql = sql.replace("and createdate <= ?", "");
			}
			sql = _customSQL.replaceOrderBy(sql, null);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PhatVay", PhatVayImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			if (Validator.isNotNull(maCTV)) {
				qPos.add(maCTV);
			}
			if (loaiPhatVay > 0) {
				qPos.add(loaiPhatVay);
			}
			if (createDate != null) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(createDate);
				qPos.add(CalendarUtil.getTimestamp(CalendarUtil.getGTDate(cal)));
				qPos.add(CalendarUtil.getTimestamp(CalendarUtil.getLTDate(cal)));
				qPos.add(CalendarUtil.getTimestamp(CalendarUtil.getLTDate(cal)));
			}
			return (List<PhatVay>) QueryUtil.list(q, getDialect(), -1, -1);
		} catch (Exception e) {
			e.printStackTrace();
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public PhatVay getPhatVayByNgayThuTruocLast() throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = _customSQL.get(getClass(), GET_PHATVAY_BY_NGAYTHUTRUOC_LAST);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PhatVay", PhatVayImpl.class);
			@SuppressWarnings("unchecked")
			Iterator<PhatVay> iter = q.list().iterator();
			if (iter.hasNext()) {
				PhatVay value = iter.next();
				if (value != null) {
					return value;
				}
			}
			return null;
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	@SuppressWarnings("unchecked")
	public List<PhatVay> getPhatVayDeThuTienTruoc(String maCTV, Date ngayThuTienTu) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = _customSQL.get(getClass(), GET_PHAT_VAY_DE_THU_TIEN_TRUOC);
			if (Validator.isNull(maCTV)) {
				sql = sql.replace("AND (maCTV = ?)", "");
			}
			if (Validator.isNull(ngayThuTienTu)) {
				sql = sql.replace("AND (ngayBatDau <= ?)", "");
				sql = sql.replace("AND (ngayDaThuCuoi < ? OR ngayDaThuCuoi IS NULL)", "");
			}
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PhatVay", PhatVayImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			if (Validator.isNotNull(maCTV)) {
				qPos.add(maCTV);
			}
			if (Validator.isNotNull(ngayThuTienTu)) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(ngayThuTienTu);
				qPos.add(CalendarUtil.getTimestamp(CalendarUtil.getGTDate(cal)));
				qPos.add(CalendarUtil.getTimestamp(CalendarUtil.getLTDate(cal)));
				qPos.add(CalendarUtil.getTimestamp(CalendarUtil.getGTDate(cal)));
			}
			return (List<PhatVay>) QueryUtil.list(q, getDialect(), -1, -1);
		} catch (Exception e) {
			e.printStackTrace();
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	@SuppressWarnings("unchecked")
	public List<PhatVay> findCTV_NgayThuTien(String maCTV, Date ngayThuTien) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = _customSQL.get(getClass(), FINDCTV_NGAYTHUTIEN);
			if (Validator.isNull(maCTV)) {
				sql = sql.replace("AND (maCTV = ?)", "");
			}
			if (Validator.isNull(ngayThuTien)) {
				sql = sql.replace("AND (ngayBatDau <= ?)", "");
				sql = sql.replace("AND (ngayDaThuCuoi < ? OR ngayDaThuCuoi IS NULL)", "");
			}
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PhatVay", PhatVayImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			if (Validator.isNotNull(maCTV)) {
				qPos.add(maCTV);
			}
			if (Validator.isNotNull(ngayThuTien)) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(ngayThuTien);
				qPos.add(CalendarUtil.getTimestamp(CalendarUtil.getGTDate(cal)));
				qPos.add(CalendarUtil.getTimestamp(CalendarUtil.getGTDate(cal)));
			}
			return (List<PhatVay>) QueryUtil.list(q, getDialect(), -1, -1);
		} catch (Exception e) {
			e.printStackTrace();
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	@SuppressWarnings("unchecked")
	public List<PhatVay> findBase(String soKU, String maCTV, String maKhachHang, Date createDateTu, Date createDateDen,
			Date ngayBatDauTu, Date ngayBatDauDen, Date ngayTatToanTu, Date ngayTatToanDen, String trangThai, int start,
			int end, OrderByComparator obc) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = _customSQL.get(getClass(), FIND_BASE);
			if (Validator.isNull(soKU)) {
				sql = sql.replace("AND (lower(soKU) like ?)", "");
			}
			if (Validator.isNull(maCTV)) {
				sql = sql.replace("AND (maCTV = ?)", "");
			}
			if (Validator.isNull(maKhachHang)) {
				sql = sql.replace("AND (maKhachHang = ?)", "");
			}
			if (Validator.isNull(createDateTu)) {
				sql = sql.replace("AND (createDate >= ?)", "");
			}
			if (Validator.isNull(createDateDen)) {
				sql = sql.replace("AND (createDate <= ?)", "");
			}
			if (Validator.isNull(ngayBatDauTu)) {
				sql = sql.replace("AND (ngayBatDau >= ?)", "");
			}
			if (Validator.isNull(ngayBatDauDen)) {
				sql = sql.replace("AND (ngayBatDau <= ?)", "");
			}
			if (Validator.isNull(ngayTatToanTu)) {
				sql = sql.replace("AND (ngayTatToan >= ?)", "");
			}
			if (Validator.isNull(ngayTatToanDen)) {
				sql = sql.replace("AND (ngayTatToan <= ?)", "");
			}
			if (Validator.isNull(trangThai) || (Validator.isNotNull(trangThai) && trangThai.equals("0"))) {
				sql = sql.replace("AND $QUERY_TRANGTHAI$", "");
			} else {
				String queryTrangThai = "trangThai in (" + trangThai + ")";
				sql = sql.replace("$QUERY_TRANGTHAI$", queryTrangThai);
			}
			sql = _customSQL.replaceOrderBy(sql, obc);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PhatVay", PhatVayImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			if (Validator.isNotNull(soKU)) {
				qPos.add("%" + soKU.toLowerCase() + "%");
			}
			if (Validator.isNotNull(maCTV)) {
				qPos.add(maCTV);
			}
			if (Validator.isNotNull(maKhachHang)) {
				qPos.add(maKhachHang);
			}
			if (Validator.isNotNull(createDateTu)) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(createDateTu);
				qPos.add(CalendarUtil.getTimestamp(CalendarUtil.getGTDate(cal)));
			}
			if (Validator.isNotNull(createDateDen)) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(createDateDen);
				qPos.add(CalendarUtil.getTimestamp(CalendarUtil.getLTDate(cal)));
			}
			if (Validator.isNotNull(ngayBatDauTu)) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(ngayBatDauTu);
				qPos.add(CalendarUtil.getTimestamp(CalendarUtil.getGTDate(cal)));
			}
			if (Validator.isNotNull(ngayBatDauDen)) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(ngayBatDauDen);
				qPos.add(CalendarUtil.getTimestamp(CalendarUtil.getLTDate(cal)));
			}
			if (Validator.isNotNull(ngayTatToanTu)) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(ngayTatToanTu);
				qPos.add(CalendarUtil.getTimestamp(CalendarUtil.getGTDate(cal)));
			}
			if (Validator.isNotNull(ngayTatToanDen)) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(ngayTatToanDen);
				qPos.add(CalendarUtil.getTimestamp(CalendarUtil.getLTDate(cal)));
			}
			return (List<PhatVay>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			e.printStackTrace();
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public int countBase(String soKU, String maCTV, String maKhachHang, Date createDateTu, Date createDateDen,
			Date ngayBatDauTu, Date ngayBatDauDen, Date ngayTatToanTu, Date ngayTatToanDen, String trangThai)
			throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = _customSQL.get(getClass(), COUNT_BASE);
			if (Validator.isNull(soKU)) {
				sql = sql.replace("AND (lower(soKU) like ?)", "");
			}
			if (Validator.isNull(maCTV)) {
				sql = sql.replace("AND (maCTV = ?)", "");
			}
			if (Validator.isNull(maKhachHang)) {
				sql = sql.replace("AND (maKhachHang = ?)", "");
			}
			if (Validator.isNull(createDateTu)) {
				sql = sql.replace("AND (createDate >= ?)", "");
			}
			if (Validator.isNull(createDateDen)) {
				sql = sql.replace("AND (createDate <= ?)", "");
			}
			if (Validator.isNull(ngayBatDauTu)) {
				sql = sql.replace("AND (ngayBatDau >= ?)", "");
			}
			if (Validator.isNull(ngayBatDauDen)) {
				sql = sql.replace("AND (ngayBatDau <= ?)", "");
			}
			if (Validator.isNull(ngayTatToanTu)) {
				sql = sql.replace("AND (ngayTatToan >= ?)", "");
			}
			if (Validator.isNull(ngayTatToanDen)) {
				sql = sql.replace("AND (ngayTatToan <= ?)", "");
			}
			if (Validator.isNull(trangThai) || (Validator.isNotNull(trangThai) && trangThai.equals("0"))) {
				sql = sql.replace("AND $QUERY_TRANGTHAI$", "");
			} else {
				String queryTrangThai = "trangThai in (" + trangThai + ")";
				sql = sql.replace("$QUERY_TRANGTHAI$", queryTrangThai);
			}
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("COUNT_VALUE", Type.LONG);
			QueryPos qPos = QueryPos.getInstance(q);
			if (Validator.isNotNull(soKU)) {
				qPos.add("%" + soKU.toLowerCase() + "%");
			}
			if (Validator.isNotNull(maCTV)) {
				qPos.add(maCTV);
			}
			if (Validator.isNotNull(maKhachHang)) {
				qPos.add(maKhachHang);
			}
			if (Validator.isNotNull(createDateTu)) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(createDateTu);
				qPos.add(CalendarUtil.getTimestamp(CalendarUtil.getGTDate(cal)));
			}
			if (Validator.isNotNull(createDateDen)) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(createDateDen);
				qPos.add(CalendarUtil.getTimestamp(CalendarUtil.getLTDate(cal)));
			}
			if (Validator.isNotNull(ngayBatDauTu)) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(ngayBatDauTu);
				qPos.add(CalendarUtil.getTimestamp(CalendarUtil.getGTDate(cal)));
			}
			if (Validator.isNotNull(ngayBatDauDen)) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(ngayBatDauDen);
				qPos.add(CalendarUtil.getTimestamp(CalendarUtil.getLTDate(cal)));
			}
			if (Validator.isNotNull(ngayTatToanTu)) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(ngayTatToanTu);
				qPos.add(CalendarUtil.getTimestamp(CalendarUtil.getGTDate(cal)));
			}
			if (Validator.isNotNull(ngayTatToanDen)) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(ngayTatToanDen);
				qPos.add(CalendarUtil.getTimestamp(CalendarUtil.getLTDate(cal)));
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