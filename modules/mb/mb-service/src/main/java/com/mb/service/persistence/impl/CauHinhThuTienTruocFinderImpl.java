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
import com.mb.model.CauHinhThuTienTruoc;
import com.mb.model.impl.CauHinhThuTienTruocImpl;
import com.mb.service.persistence.CauHinhThuTienTruocFinder;

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
@Component(service = CauHinhThuTienTruocFinder.class)
public class CauHinhThuTienTruocFinderImpl extends CauHinhThuTienTruocFinderBaseImpl
		implements CauHinhThuTienTruocFinder {
	@ServiceReference(type = CustomSQL.class)
	private CustomSQL _customSQL;

	public static final String FIND_BASE = CauHinhThuTienTruocFinder.class.getName() + ".findBase";
	public static final String COUNT_BASE = CauHinhThuTienTruocFinder.class.getName() + ".countBase";

	@SuppressWarnings("unchecked")
	public List<CauHinhThuTienTruoc> findBase(int nam, int hoatDong, int start, int end, OrderByComparator obc)
			throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = _customSQL.get(getClass(), FIND_BASE);
			if (hoatDong == 0) {
				sql = sql.replace("AND (hoatdong = ?)", "");
			}
			if (nam <= 0) {
				sql = sql.replace("AND (nam = ?)", "");
			}
			sql = _customSQL.replaceOrderBy(sql, obc);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("CauHinhThuTienTruoc", CauHinhThuTienTruocImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			if (hoatDong != 0) {
				qPos.add(hoatDong == 1 ? true : false);
			}
			if (nam > 0) {
				qPos.add(nam);
			}
			return (List<CauHinhThuTienTruoc>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			e.printStackTrace();
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public int countBase(int nam, int hoatDong) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = _customSQL.get(getClass(), COUNT_BASE);

			if (hoatDong == 0) {
				sql = sql.replace("AND (hoatdong = ?)", "");
			}
			if (nam <= 0) {
				sql = sql.replace("AND (nam = ?)", "");
			}
			sql = _customSQL.replaceAndOperator(sql, true);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("COUNT_VALUE", Type.LONG);
			QueryPos qPos = QueryPos.getInstance(q);
			if (hoatDong != 0) {
				qPos.add(hoatDong == 1 ? true : false);
			}
			if (nam > 0) {
				qPos.add(nam);
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