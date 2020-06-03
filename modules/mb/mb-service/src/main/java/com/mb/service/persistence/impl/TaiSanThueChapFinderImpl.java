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
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.spring.extender.service.ServiceReference;
import com.mb.model.TaiSanThueChap;
import com.mb.model.impl.TaiSanThueChapImpl;
import com.mb.service.persistence.TaiSanThueChapFinder;

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
@Component(service = TaiSanThueChapFinder.class)
public class TaiSanThueChapFinderImpl extends TaiSanThueChapFinderBaseImpl implements TaiSanThueChapFinder {
	@ServiceReference(type = CustomSQL.class)
	private CustomSQL _customSQL;

	public static final String FIND_BASE = TaiSanThueChapFinder.class.getName() + ".findBase";
	public static final String COUNT_BASE = TaiSanThueChapFinder.class.getName() + ".countBase";

	@SuppressWarnings("unchecked")
	public List<TaiSanThueChap> findBase(String soKU, String ten, String maKhachHang, long loaiTaiSanId,
			int start, int end, OrderByComparator obc) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = _customSQL.get(getClass(), FIND_BASE);
			if (Validator.isNull(soKU)) {
				sql = sql.replace("AND (soKU = ?)", "");
			}
			if (Validator.isNull(maKhachHang)) {
				sql = sql.replace("AND (maKhachHang = ?)", "");
			}
			if (loaiTaiSanId == 0) {
				sql = sql.replace("AND (loaiTaiSanId = ?)", "");
			}
			if (Validator.isNull(ten)) {
				sql = sql.replace("AND (lower(ten) like ?)", "");
			}
			sql = _customSQL.replaceOrderBy(sql, obc);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("TaiSanThueChap", TaiSanThueChapImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			if (Validator.isNotNull(soKU)) {
				qPos.add(soKU);
			}
			if (Validator.isNotNull(maKhachHang)) {
				qPos.add(maKhachHang);
			}
			if (loaiTaiSanId > 0) {
				qPos.add(loaiTaiSanId);
			}
			if (Validator.isNotNull(ten)) {
				qPos.add("%" + ten.toLowerCase() + "%");
			}
			return (List<TaiSanThueChap>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			e.printStackTrace();
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public int countBase(String soKU, String ten, String maKhachHang, long loaiTaiSanId)
			throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = _customSQL.get(getClass(), COUNT_BASE);
			if (Validator.isNull(soKU)) {
				sql = sql.replace("AND (soKU = ?)", "");
			}
			if (Validator.isNull(maKhachHang)) {
				sql = sql.replace("AND (maKhachHang = ?)", "");
			}
			if (loaiTaiSanId == 0) {
				sql = sql.replace("AND (loaiTaiSanId = ?)", "");
			}
			if (Validator.isNull(ten)) {
				sql = sql.replace("AND (lower(ten) like ?)", "");
			}
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("COUNT_VALUE", Type.LONG);
			QueryPos qPos = QueryPos.getInstance(q);
			if (Validator.isNotNull(soKU)) {
				qPos.add(soKU);
			}
			if (Validator.isNotNull(maKhachHang)) {
				qPos.add(maKhachHang);
			}
			if (loaiTaiSanId > 0) {
				qPos.add(loaiTaiSanId);
			}
			if (Validator.isNotNull(ten)) {
				qPos.add("%" + ten.toLowerCase() + "%");
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