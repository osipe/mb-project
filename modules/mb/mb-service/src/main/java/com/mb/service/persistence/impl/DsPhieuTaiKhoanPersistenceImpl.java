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

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.mb.exception.NoSuchDsPhieuTaiKhoanException;
import com.mb.model.DsPhieuTaiKhoan;
import com.mb.model.impl.DsPhieuTaiKhoanImpl;
import com.mb.model.impl.DsPhieuTaiKhoanModelImpl;
import com.mb.service.persistence.DsPhieuTaiKhoanPersistence;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the ds phieu tai khoan service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class DsPhieuTaiKhoanPersistenceImpl
	extends BasePersistenceImpl<DsPhieuTaiKhoan>
	implements DsPhieuTaiKhoanPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DsPhieuTaiKhoanUtil</code> to access the ds phieu tai khoan persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DsPhieuTaiKhoanImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByTaiKhoanDoiUngId_HoatDong;
	private FinderPath
		_finderPathWithoutPaginationFindByTaiKhoanDoiUngId_HoatDong;
	private FinderPath _finderPathCountByTaiKhoanDoiUngId_HoatDong;

	/**
	 * Returns all the ds phieu tai khoans where taiKhoanDoiUngId = &#63; and hoatDong = &#63;.
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param hoatDong the hoat dong
	 * @return the matching ds phieu tai khoans
	 */
	@Override
	public List<DsPhieuTaiKhoan> findByTaiKhoanDoiUngId_HoatDong(
		long taiKhoanDoiUngId, Boolean hoatDong) {

		return findByTaiKhoanDoiUngId_HoatDong(
			taiKhoanDoiUngId, hoatDong, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the ds phieu tai khoans where taiKhoanDoiUngId = &#63; and hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DsPhieuTaiKhoanModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of ds phieu tai khoans
	 * @param end the upper bound of the range of ds phieu tai khoans (not inclusive)
	 * @return the range of matching ds phieu tai khoans
	 */
	@Override
	public List<DsPhieuTaiKhoan> findByTaiKhoanDoiUngId_HoatDong(
		long taiKhoanDoiUngId, Boolean hoatDong, int start, int end) {

		return findByTaiKhoanDoiUngId_HoatDong(
			taiKhoanDoiUngId, hoatDong, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ds phieu tai khoans where taiKhoanDoiUngId = &#63; and hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DsPhieuTaiKhoanModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of ds phieu tai khoans
	 * @param end the upper bound of the range of ds phieu tai khoans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ds phieu tai khoans
	 */
	@Override
	public List<DsPhieuTaiKhoan> findByTaiKhoanDoiUngId_HoatDong(
		long taiKhoanDoiUngId, Boolean hoatDong, int start, int end,
		OrderByComparator<DsPhieuTaiKhoan> orderByComparator) {

		return findByTaiKhoanDoiUngId_HoatDong(
			taiKhoanDoiUngId, hoatDong, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ds phieu tai khoans where taiKhoanDoiUngId = &#63; and hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DsPhieuTaiKhoanModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of ds phieu tai khoans
	 * @param end the upper bound of the range of ds phieu tai khoans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching ds phieu tai khoans
	 */
	@Override
	public List<DsPhieuTaiKhoan> findByTaiKhoanDoiUngId_HoatDong(
		long taiKhoanDoiUngId, Boolean hoatDong, int start, int end,
		OrderByComparator<DsPhieuTaiKhoan> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath =
				_finderPathWithoutPaginationFindByTaiKhoanDoiUngId_HoatDong;
			finderArgs = new Object[] {taiKhoanDoiUngId, hoatDong};
		}
		else {
			finderPath =
				_finderPathWithPaginationFindByTaiKhoanDoiUngId_HoatDong;
			finderArgs = new Object[] {
				taiKhoanDoiUngId, hoatDong, start, end, orderByComparator
			};
		}

		List<DsPhieuTaiKhoan> list = null;

		if (retrieveFromCache) {
			list = (List<DsPhieuTaiKhoan>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DsPhieuTaiKhoan dsPhieuTaiKhoan : list) {
					if ((taiKhoanDoiUngId !=
							dsPhieuTaiKhoan.getTaiKhoanDoiUngId()) ||
						!Objects.equals(
							hoatDong, dsPhieuTaiKhoan.getHoatDong())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_DSPHIEUTAIKHOAN_WHERE);

			query.append(
				_FINDER_COLUMN_TAIKHOANDOIUNGID_HOATDONG_TAIKHOANDOIUNGID_2);

			query.append(_FINDER_COLUMN_TAIKHOANDOIUNGID_HOATDONG_HOATDONG_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(DsPhieuTaiKhoanModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(taiKhoanDoiUngId);

				qPos.add(hoatDong.booleanValue());

				if (!pagination) {
					list = (List<DsPhieuTaiKhoan>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DsPhieuTaiKhoan>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first ds phieu tai khoan in the ordered set where taiKhoanDoiUngId = &#63; and hoatDong = &#63;.
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ds phieu tai khoan
	 * @throws NoSuchDsPhieuTaiKhoanException if a matching ds phieu tai khoan could not be found
	 */
	@Override
	public DsPhieuTaiKhoan findByTaiKhoanDoiUngId_HoatDong_First(
			long taiKhoanDoiUngId, Boolean hoatDong,
			OrderByComparator<DsPhieuTaiKhoan> orderByComparator)
		throws NoSuchDsPhieuTaiKhoanException {

		DsPhieuTaiKhoan dsPhieuTaiKhoan =
			fetchByTaiKhoanDoiUngId_HoatDong_First(
				taiKhoanDoiUngId, hoatDong, orderByComparator);

		if (dsPhieuTaiKhoan != null) {
			return dsPhieuTaiKhoan;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("taiKhoanDoiUngId=");
		msg.append(taiKhoanDoiUngId);

		msg.append(", hoatDong=");
		msg.append(hoatDong);

		msg.append("}");

		throw new NoSuchDsPhieuTaiKhoanException(msg.toString());
	}

	/**
	 * Returns the first ds phieu tai khoan in the ordered set where taiKhoanDoiUngId = &#63; and hoatDong = &#63;.
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ds phieu tai khoan, or <code>null</code> if a matching ds phieu tai khoan could not be found
	 */
	@Override
	public DsPhieuTaiKhoan fetchByTaiKhoanDoiUngId_HoatDong_First(
		long taiKhoanDoiUngId, Boolean hoatDong,
		OrderByComparator<DsPhieuTaiKhoan> orderByComparator) {

		List<DsPhieuTaiKhoan> list = findByTaiKhoanDoiUngId_HoatDong(
			taiKhoanDoiUngId, hoatDong, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ds phieu tai khoan in the ordered set where taiKhoanDoiUngId = &#63; and hoatDong = &#63;.
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ds phieu tai khoan
	 * @throws NoSuchDsPhieuTaiKhoanException if a matching ds phieu tai khoan could not be found
	 */
	@Override
	public DsPhieuTaiKhoan findByTaiKhoanDoiUngId_HoatDong_Last(
			long taiKhoanDoiUngId, Boolean hoatDong,
			OrderByComparator<DsPhieuTaiKhoan> orderByComparator)
		throws NoSuchDsPhieuTaiKhoanException {

		DsPhieuTaiKhoan dsPhieuTaiKhoan = fetchByTaiKhoanDoiUngId_HoatDong_Last(
			taiKhoanDoiUngId, hoatDong, orderByComparator);

		if (dsPhieuTaiKhoan != null) {
			return dsPhieuTaiKhoan;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("taiKhoanDoiUngId=");
		msg.append(taiKhoanDoiUngId);

		msg.append(", hoatDong=");
		msg.append(hoatDong);

		msg.append("}");

		throw new NoSuchDsPhieuTaiKhoanException(msg.toString());
	}

	/**
	 * Returns the last ds phieu tai khoan in the ordered set where taiKhoanDoiUngId = &#63; and hoatDong = &#63;.
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ds phieu tai khoan, or <code>null</code> if a matching ds phieu tai khoan could not be found
	 */
	@Override
	public DsPhieuTaiKhoan fetchByTaiKhoanDoiUngId_HoatDong_Last(
		long taiKhoanDoiUngId, Boolean hoatDong,
		OrderByComparator<DsPhieuTaiKhoan> orderByComparator) {

		int count = countByTaiKhoanDoiUngId_HoatDong(
			taiKhoanDoiUngId, hoatDong);

		if (count == 0) {
			return null;
		}

		List<DsPhieuTaiKhoan> list = findByTaiKhoanDoiUngId_HoatDong(
			taiKhoanDoiUngId, hoatDong, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ds phieu tai khoans before and after the current ds phieu tai khoan in the ordered set where taiKhoanDoiUngId = &#63; and hoatDong = &#63;.
	 *
	 * @param dsPhieuTaiKhoanId the primary key of the current ds phieu tai khoan
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ds phieu tai khoan
	 * @throws NoSuchDsPhieuTaiKhoanException if a ds phieu tai khoan with the primary key could not be found
	 */
	@Override
	public DsPhieuTaiKhoan[] findByTaiKhoanDoiUngId_HoatDong_PrevAndNext(
			long dsPhieuTaiKhoanId, long taiKhoanDoiUngId, Boolean hoatDong,
			OrderByComparator<DsPhieuTaiKhoan> orderByComparator)
		throws NoSuchDsPhieuTaiKhoanException {

		DsPhieuTaiKhoan dsPhieuTaiKhoan = findByPrimaryKey(dsPhieuTaiKhoanId);

		Session session = null;

		try {
			session = openSession();

			DsPhieuTaiKhoan[] array = new DsPhieuTaiKhoanImpl[3];

			array[0] = getByTaiKhoanDoiUngId_HoatDong_PrevAndNext(
				session, dsPhieuTaiKhoan, taiKhoanDoiUngId, hoatDong,
				orderByComparator, true);

			array[1] = dsPhieuTaiKhoan;

			array[2] = getByTaiKhoanDoiUngId_HoatDong_PrevAndNext(
				session, dsPhieuTaiKhoan, taiKhoanDoiUngId, hoatDong,
				orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DsPhieuTaiKhoan getByTaiKhoanDoiUngId_HoatDong_PrevAndNext(
		Session session, DsPhieuTaiKhoan dsPhieuTaiKhoan, long taiKhoanDoiUngId,
		Boolean hoatDong, OrderByComparator<DsPhieuTaiKhoan> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_DSPHIEUTAIKHOAN_WHERE);

		query.append(
			_FINDER_COLUMN_TAIKHOANDOIUNGID_HOATDONG_TAIKHOANDOIUNGID_2);

		query.append(_FINDER_COLUMN_TAIKHOANDOIUNGID_HOATDONG_HOATDONG_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(DsPhieuTaiKhoanModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(taiKhoanDoiUngId);

		qPos.add(hoatDong.booleanValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dsPhieuTaiKhoan)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<DsPhieuTaiKhoan> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ds phieu tai khoans where taiKhoanDoiUngId = &#63; and hoatDong = &#63; from the database.
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param hoatDong the hoat dong
	 */
	@Override
	public void removeByTaiKhoanDoiUngId_HoatDong(
		long taiKhoanDoiUngId, Boolean hoatDong) {

		for (DsPhieuTaiKhoan dsPhieuTaiKhoan :
				findByTaiKhoanDoiUngId_HoatDong(
					taiKhoanDoiUngId, hoatDong, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(dsPhieuTaiKhoan);
		}
	}

	/**
	 * Returns the number of ds phieu tai khoans where taiKhoanDoiUngId = &#63; and hoatDong = &#63;.
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param hoatDong the hoat dong
	 * @return the number of matching ds phieu tai khoans
	 */
	@Override
	public int countByTaiKhoanDoiUngId_HoatDong(
		long taiKhoanDoiUngId, Boolean hoatDong) {

		FinderPath finderPath = _finderPathCountByTaiKhoanDoiUngId_HoatDong;

		Object[] finderArgs = new Object[] {taiKhoanDoiUngId, hoatDong};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DSPHIEUTAIKHOAN_WHERE);

			query.append(
				_FINDER_COLUMN_TAIKHOANDOIUNGID_HOATDONG_TAIKHOANDOIUNGID_2);

			query.append(_FINDER_COLUMN_TAIKHOANDOIUNGID_HOATDONG_HOATDONG_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(taiKhoanDoiUngId);

				qPos.add(hoatDong.booleanValue());

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_TAIKHOANDOIUNGID_HOATDONG_TAIKHOANDOIUNGID_2 =
			"dsPhieuTaiKhoan.taiKhoanDoiUngId = ? AND ";

	private static final String
		_FINDER_COLUMN_TAIKHOANDOIUNGID_HOATDONG_HOATDONG_2 =
			"dsPhieuTaiKhoan.hoatDong = ?";

	private FinderPath _finderPathWithPaginationFindByPhieuId_HoatDong;
	private FinderPath _finderPathWithoutPaginationFindByPhieuId_HoatDong;
	private FinderPath _finderPathCountByPhieuId_HoatDong;

	/**
	 * Returns all the ds phieu tai khoans where phieuId = &#63; and hoatDong = &#63;.
	 *
	 * @param phieuId the phieu ID
	 * @param hoatDong the hoat dong
	 * @return the matching ds phieu tai khoans
	 */
	@Override
	public List<DsPhieuTaiKhoan> findByPhieuId_HoatDong(
		long phieuId, Boolean hoatDong) {

		return findByPhieuId_HoatDong(
			phieuId, hoatDong, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ds phieu tai khoans where phieuId = &#63; and hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DsPhieuTaiKhoanModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phieuId the phieu ID
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of ds phieu tai khoans
	 * @param end the upper bound of the range of ds phieu tai khoans (not inclusive)
	 * @return the range of matching ds phieu tai khoans
	 */
	@Override
	public List<DsPhieuTaiKhoan> findByPhieuId_HoatDong(
		long phieuId, Boolean hoatDong, int start, int end) {

		return findByPhieuId_HoatDong(phieuId, hoatDong, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ds phieu tai khoans where phieuId = &#63; and hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DsPhieuTaiKhoanModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phieuId the phieu ID
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of ds phieu tai khoans
	 * @param end the upper bound of the range of ds phieu tai khoans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ds phieu tai khoans
	 */
	@Override
	public List<DsPhieuTaiKhoan> findByPhieuId_HoatDong(
		long phieuId, Boolean hoatDong, int start, int end,
		OrderByComparator<DsPhieuTaiKhoan> orderByComparator) {

		return findByPhieuId_HoatDong(
			phieuId, hoatDong, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ds phieu tai khoans where phieuId = &#63; and hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DsPhieuTaiKhoanModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phieuId the phieu ID
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of ds phieu tai khoans
	 * @param end the upper bound of the range of ds phieu tai khoans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching ds phieu tai khoans
	 */
	@Override
	public List<DsPhieuTaiKhoan> findByPhieuId_HoatDong(
		long phieuId, Boolean hoatDong, int start, int end,
		OrderByComparator<DsPhieuTaiKhoan> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByPhieuId_HoatDong;
			finderArgs = new Object[] {phieuId, hoatDong};
		}
		else {
			finderPath = _finderPathWithPaginationFindByPhieuId_HoatDong;
			finderArgs = new Object[] {
				phieuId, hoatDong, start, end, orderByComparator
			};
		}

		List<DsPhieuTaiKhoan> list = null;

		if (retrieveFromCache) {
			list = (List<DsPhieuTaiKhoan>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DsPhieuTaiKhoan dsPhieuTaiKhoan : list) {
					if ((phieuId != dsPhieuTaiKhoan.getPhieuId()) ||
						!Objects.equals(
							hoatDong, dsPhieuTaiKhoan.getHoatDong())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_DSPHIEUTAIKHOAN_WHERE);

			query.append(_FINDER_COLUMN_PHIEUID_HOATDONG_PHIEUID_2);

			query.append(_FINDER_COLUMN_PHIEUID_HOATDONG_HOATDONG_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(DsPhieuTaiKhoanModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(phieuId);

				qPos.add(hoatDong.booleanValue());

				if (!pagination) {
					list = (List<DsPhieuTaiKhoan>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DsPhieuTaiKhoan>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first ds phieu tai khoan in the ordered set where phieuId = &#63; and hoatDong = &#63;.
	 *
	 * @param phieuId the phieu ID
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ds phieu tai khoan
	 * @throws NoSuchDsPhieuTaiKhoanException if a matching ds phieu tai khoan could not be found
	 */
	@Override
	public DsPhieuTaiKhoan findByPhieuId_HoatDong_First(
			long phieuId, Boolean hoatDong,
			OrderByComparator<DsPhieuTaiKhoan> orderByComparator)
		throws NoSuchDsPhieuTaiKhoanException {

		DsPhieuTaiKhoan dsPhieuTaiKhoan = fetchByPhieuId_HoatDong_First(
			phieuId, hoatDong, orderByComparator);

		if (dsPhieuTaiKhoan != null) {
			return dsPhieuTaiKhoan;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("phieuId=");
		msg.append(phieuId);

		msg.append(", hoatDong=");
		msg.append(hoatDong);

		msg.append("}");

		throw new NoSuchDsPhieuTaiKhoanException(msg.toString());
	}

	/**
	 * Returns the first ds phieu tai khoan in the ordered set where phieuId = &#63; and hoatDong = &#63;.
	 *
	 * @param phieuId the phieu ID
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ds phieu tai khoan, or <code>null</code> if a matching ds phieu tai khoan could not be found
	 */
	@Override
	public DsPhieuTaiKhoan fetchByPhieuId_HoatDong_First(
		long phieuId, Boolean hoatDong,
		OrderByComparator<DsPhieuTaiKhoan> orderByComparator) {

		List<DsPhieuTaiKhoan> list = findByPhieuId_HoatDong(
			phieuId, hoatDong, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ds phieu tai khoan in the ordered set where phieuId = &#63; and hoatDong = &#63;.
	 *
	 * @param phieuId the phieu ID
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ds phieu tai khoan
	 * @throws NoSuchDsPhieuTaiKhoanException if a matching ds phieu tai khoan could not be found
	 */
	@Override
	public DsPhieuTaiKhoan findByPhieuId_HoatDong_Last(
			long phieuId, Boolean hoatDong,
			OrderByComparator<DsPhieuTaiKhoan> orderByComparator)
		throws NoSuchDsPhieuTaiKhoanException {

		DsPhieuTaiKhoan dsPhieuTaiKhoan = fetchByPhieuId_HoatDong_Last(
			phieuId, hoatDong, orderByComparator);

		if (dsPhieuTaiKhoan != null) {
			return dsPhieuTaiKhoan;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("phieuId=");
		msg.append(phieuId);

		msg.append(", hoatDong=");
		msg.append(hoatDong);

		msg.append("}");

		throw new NoSuchDsPhieuTaiKhoanException(msg.toString());
	}

	/**
	 * Returns the last ds phieu tai khoan in the ordered set where phieuId = &#63; and hoatDong = &#63;.
	 *
	 * @param phieuId the phieu ID
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ds phieu tai khoan, or <code>null</code> if a matching ds phieu tai khoan could not be found
	 */
	@Override
	public DsPhieuTaiKhoan fetchByPhieuId_HoatDong_Last(
		long phieuId, Boolean hoatDong,
		OrderByComparator<DsPhieuTaiKhoan> orderByComparator) {

		int count = countByPhieuId_HoatDong(phieuId, hoatDong);

		if (count == 0) {
			return null;
		}

		List<DsPhieuTaiKhoan> list = findByPhieuId_HoatDong(
			phieuId, hoatDong, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ds phieu tai khoans before and after the current ds phieu tai khoan in the ordered set where phieuId = &#63; and hoatDong = &#63;.
	 *
	 * @param dsPhieuTaiKhoanId the primary key of the current ds phieu tai khoan
	 * @param phieuId the phieu ID
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ds phieu tai khoan
	 * @throws NoSuchDsPhieuTaiKhoanException if a ds phieu tai khoan with the primary key could not be found
	 */
	@Override
	public DsPhieuTaiKhoan[] findByPhieuId_HoatDong_PrevAndNext(
			long dsPhieuTaiKhoanId, long phieuId, Boolean hoatDong,
			OrderByComparator<DsPhieuTaiKhoan> orderByComparator)
		throws NoSuchDsPhieuTaiKhoanException {

		DsPhieuTaiKhoan dsPhieuTaiKhoan = findByPrimaryKey(dsPhieuTaiKhoanId);

		Session session = null;

		try {
			session = openSession();

			DsPhieuTaiKhoan[] array = new DsPhieuTaiKhoanImpl[3];

			array[0] = getByPhieuId_HoatDong_PrevAndNext(
				session, dsPhieuTaiKhoan, phieuId, hoatDong, orderByComparator,
				true);

			array[1] = dsPhieuTaiKhoan;

			array[2] = getByPhieuId_HoatDong_PrevAndNext(
				session, dsPhieuTaiKhoan, phieuId, hoatDong, orderByComparator,
				false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DsPhieuTaiKhoan getByPhieuId_HoatDong_PrevAndNext(
		Session session, DsPhieuTaiKhoan dsPhieuTaiKhoan, long phieuId,
		Boolean hoatDong, OrderByComparator<DsPhieuTaiKhoan> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_DSPHIEUTAIKHOAN_WHERE);

		query.append(_FINDER_COLUMN_PHIEUID_HOATDONG_PHIEUID_2);

		query.append(_FINDER_COLUMN_PHIEUID_HOATDONG_HOATDONG_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(DsPhieuTaiKhoanModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(phieuId);

		qPos.add(hoatDong.booleanValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dsPhieuTaiKhoan)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<DsPhieuTaiKhoan> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ds phieu tai khoans where phieuId = &#63; and hoatDong = &#63; from the database.
	 *
	 * @param phieuId the phieu ID
	 * @param hoatDong the hoat dong
	 */
	@Override
	public void removeByPhieuId_HoatDong(long phieuId, Boolean hoatDong) {
		for (DsPhieuTaiKhoan dsPhieuTaiKhoan :
				findByPhieuId_HoatDong(
					phieuId, hoatDong, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(dsPhieuTaiKhoan);
		}
	}

	/**
	 * Returns the number of ds phieu tai khoans where phieuId = &#63; and hoatDong = &#63;.
	 *
	 * @param phieuId the phieu ID
	 * @param hoatDong the hoat dong
	 * @return the number of matching ds phieu tai khoans
	 */
	@Override
	public int countByPhieuId_HoatDong(long phieuId, Boolean hoatDong) {
		FinderPath finderPath = _finderPathCountByPhieuId_HoatDong;

		Object[] finderArgs = new Object[] {phieuId, hoatDong};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DSPHIEUTAIKHOAN_WHERE);

			query.append(_FINDER_COLUMN_PHIEUID_HOATDONG_PHIEUID_2);

			query.append(_FINDER_COLUMN_PHIEUID_HOATDONG_HOATDONG_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(phieuId);

				qPos.add(hoatDong.booleanValue());

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PHIEUID_HOATDONG_PHIEUID_2 =
		"dsPhieuTaiKhoan.phieuId = ? AND ";

	private static final String _FINDER_COLUMN_PHIEUID_HOATDONG_HOATDONG_2 =
		"dsPhieuTaiKhoan.hoatDong = ?";

	private FinderPath _finderPathWithPaginationFindByPhieuId;
	private FinderPath _finderPathWithoutPaginationFindByPhieuId;
	private FinderPath _finderPathCountByPhieuId;

	/**
	 * Returns all the ds phieu tai khoans where phieuId = &#63;.
	 *
	 * @param phieuId the phieu ID
	 * @return the matching ds phieu tai khoans
	 */
	@Override
	public List<DsPhieuTaiKhoan> findByPhieuId(long phieuId) {
		return findByPhieuId(
			phieuId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ds phieu tai khoans where phieuId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DsPhieuTaiKhoanModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phieuId the phieu ID
	 * @param start the lower bound of the range of ds phieu tai khoans
	 * @param end the upper bound of the range of ds phieu tai khoans (not inclusive)
	 * @return the range of matching ds phieu tai khoans
	 */
	@Override
	public List<DsPhieuTaiKhoan> findByPhieuId(
		long phieuId, int start, int end) {

		return findByPhieuId(phieuId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ds phieu tai khoans where phieuId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DsPhieuTaiKhoanModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phieuId the phieu ID
	 * @param start the lower bound of the range of ds phieu tai khoans
	 * @param end the upper bound of the range of ds phieu tai khoans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ds phieu tai khoans
	 */
	@Override
	public List<DsPhieuTaiKhoan> findByPhieuId(
		long phieuId, int start, int end,
		OrderByComparator<DsPhieuTaiKhoan> orderByComparator) {

		return findByPhieuId(phieuId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ds phieu tai khoans where phieuId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DsPhieuTaiKhoanModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phieuId the phieu ID
	 * @param start the lower bound of the range of ds phieu tai khoans
	 * @param end the upper bound of the range of ds phieu tai khoans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching ds phieu tai khoans
	 */
	@Override
	public List<DsPhieuTaiKhoan> findByPhieuId(
		long phieuId, int start, int end,
		OrderByComparator<DsPhieuTaiKhoan> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByPhieuId;
			finderArgs = new Object[] {phieuId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByPhieuId;
			finderArgs = new Object[] {phieuId, start, end, orderByComparator};
		}

		List<DsPhieuTaiKhoan> list = null;

		if (retrieveFromCache) {
			list = (List<DsPhieuTaiKhoan>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DsPhieuTaiKhoan dsPhieuTaiKhoan : list) {
					if ((phieuId != dsPhieuTaiKhoan.getPhieuId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_DSPHIEUTAIKHOAN_WHERE);

			query.append(_FINDER_COLUMN_PHIEUID_PHIEUID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(DsPhieuTaiKhoanModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(phieuId);

				if (!pagination) {
					list = (List<DsPhieuTaiKhoan>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DsPhieuTaiKhoan>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first ds phieu tai khoan in the ordered set where phieuId = &#63;.
	 *
	 * @param phieuId the phieu ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ds phieu tai khoan
	 * @throws NoSuchDsPhieuTaiKhoanException if a matching ds phieu tai khoan could not be found
	 */
	@Override
	public DsPhieuTaiKhoan findByPhieuId_First(
			long phieuId, OrderByComparator<DsPhieuTaiKhoan> orderByComparator)
		throws NoSuchDsPhieuTaiKhoanException {

		DsPhieuTaiKhoan dsPhieuTaiKhoan = fetchByPhieuId_First(
			phieuId, orderByComparator);

		if (dsPhieuTaiKhoan != null) {
			return dsPhieuTaiKhoan;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("phieuId=");
		msg.append(phieuId);

		msg.append("}");

		throw new NoSuchDsPhieuTaiKhoanException(msg.toString());
	}

	/**
	 * Returns the first ds phieu tai khoan in the ordered set where phieuId = &#63;.
	 *
	 * @param phieuId the phieu ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ds phieu tai khoan, or <code>null</code> if a matching ds phieu tai khoan could not be found
	 */
	@Override
	public DsPhieuTaiKhoan fetchByPhieuId_First(
		long phieuId, OrderByComparator<DsPhieuTaiKhoan> orderByComparator) {

		List<DsPhieuTaiKhoan> list = findByPhieuId(
			phieuId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ds phieu tai khoan in the ordered set where phieuId = &#63;.
	 *
	 * @param phieuId the phieu ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ds phieu tai khoan
	 * @throws NoSuchDsPhieuTaiKhoanException if a matching ds phieu tai khoan could not be found
	 */
	@Override
	public DsPhieuTaiKhoan findByPhieuId_Last(
			long phieuId, OrderByComparator<DsPhieuTaiKhoan> orderByComparator)
		throws NoSuchDsPhieuTaiKhoanException {

		DsPhieuTaiKhoan dsPhieuTaiKhoan = fetchByPhieuId_Last(
			phieuId, orderByComparator);

		if (dsPhieuTaiKhoan != null) {
			return dsPhieuTaiKhoan;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("phieuId=");
		msg.append(phieuId);

		msg.append("}");

		throw new NoSuchDsPhieuTaiKhoanException(msg.toString());
	}

	/**
	 * Returns the last ds phieu tai khoan in the ordered set where phieuId = &#63;.
	 *
	 * @param phieuId the phieu ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ds phieu tai khoan, or <code>null</code> if a matching ds phieu tai khoan could not be found
	 */
	@Override
	public DsPhieuTaiKhoan fetchByPhieuId_Last(
		long phieuId, OrderByComparator<DsPhieuTaiKhoan> orderByComparator) {

		int count = countByPhieuId(phieuId);

		if (count == 0) {
			return null;
		}

		List<DsPhieuTaiKhoan> list = findByPhieuId(
			phieuId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ds phieu tai khoans before and after the current ds phieu tai khoan in the ordered set where phieuId = &#63;.
	 *
	 * @param dsPhieuTaiKhoanId the primary key of the current ds phieu tai khoan
	 * @param phieuId the phieu ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ds phieu tai khoan
	 * @throws NoSuchDsPhieuTaiKhoanException if a ds phieu tai khoan with the primary key could not be found
	 */
	@Override
	public DsPhieuTaiKhoan[] findByPhieuId_PrevAndNext(
			long dsPhieuTaiKhoanId, long phieuId,
			OrderByComparator<DsPhieuTaiKhoan> orderByComparator)
		throws NoSuchDsPhieuTaiKhoanException {

		DsPhieuTaiKhoan dsPhieuTaiKhoan = findByPrimaryKey(dsPhieuTaiKhoanId);

		Session session = null;

		try {
			session = openSession();

			DsPhieuTaiKhoan[] array = new DsPhieuTaiKhoanImpl[3];

			array[0] = getByPhieuId_PrevAndNext(
				session, dsPhieuTaiKhoan, phieuId, orderByComparator, true);

			array[1] = dsPhieuTaiKhoan;

			array[2] = getByPhieuId_PrevAndNext(
				session, dsPhieuTaiKhoan, phieuId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DsPhieuTaiKhoan getByPhieuId_PrevAndNext(
		Session session, DsPhieuTaiKhoan dsPhieuTaiKhoan, long phieuId,
		OrderByComparator<DsPhieuTaiKhoan> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DSPHIEUTAIKHOAN_WHERE);

		query.append(_FINDER_COLUMN_PHIEUID_PHIEUID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(DsPhieuTaiKhoanModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(phieuId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						dsPhieuTaiKhoan)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<DsPhieuTaiKhoan> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ds phieu tai khoans where phieuId = &#63; from the database.
	 *
	 * @param phieuId the phieu ID
	 */
	@Override
	public void removeByPhieuId(long phieuId) {
		for (DsPhieuTaiKhoan dsPhieuTaiKhoan :
				findByPhieuId(
					phieuId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dsPhieuTaiKhoan);
		}
	}

	/**
	 * Returns the number of ds phieu tai khoans where phieuId = &#63;.
	 *
	 * @param phieuId the phieu ID
	 * @return the number of matching ds phieu tai khoans
	 */
	@Override
	public int countByPhieuId(long phieuId) {
		FinderPath finderPath = _finderPathCountByPhieuId;

		Object[] finderArgs = new Object[] {phieuId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DSPHIEUTAIKHOAN_WHERE);

			query.append(_FINDER_COLUMN_PHIEUID_PHIEUID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(phieuId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PHIEUID_PHIEUID_2 =
		"dsPhieuTaiKhoan.phieuId = ?";

	public DsPhieuTaiKhoanPersistenceImpl() {
		setModelClass(DsPhieuTaiKhoan.class);
	}

	/**
	 * Caches the ds phieu tai khoan in the entity cache if it is enabled.
	 *
	 * @param dsPhieuTaiKhoan the ds phieu tai khoan
	 */
	@Override
	public void cacheResult(DsPhieuTaiKhoan dsPhieuTaiKhoan) {
		entityCache.putResult(
			DsPhieuTaiKhoanModelImpl.ENTITY_CACHE_ENABLED,
			DsPhieuTaiKhoanImpl.class, dsPhieuTaiKhoan.getPrimaryKey(),
			dsPhieuTaiKhoan);

		dsPhieuTaiKhoan.resetOriginalValues();
	}

	/**
	 * Caches the ds phieu tai khoans in the entity cache if it is enabled.
	 *
	 * @param dsPhieuTaiKhoans the ds phieu tai khoans
	 */
	@Override
	public void cacheResult(List<DsPhieuTaiKhoan> dsPhieuTaiKhoans) {
		for (DsPhieuTaiKhoan dsPhieuTaiKhoan : dsPhieuTaiKhoans) {
			if (entityCache.getResult(
					DsPhieuTaiKhoanModelImpl.ENTITY_CACHE_ENABLED,
					DsPhieuTaiKhoanImpl.class,
					dsPhieuTaiKhoan.getPrimaryKey()) == null) {

				cacheResult(dsPhieuTaiKhoan);
			}
			else {
				dsPhieuTaiKhoan.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ds phieu tai khoans.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DsPhieuTaiKhoanImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ds phieu tai khoan.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DsPhieuTaiKhoan dsPhieuTaiKhoan) {
		entityCache.removeResult(
			DsPhieuTaiKhoanModelImpl.ENTITY_CACHE_ENABLED,
			DsPhieuTaiKhoanImpl.class, dsPhieuTaiKhoan.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<DsPhieuTaiKhoan> dsPhieuTaiKhoans) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DsPhieuTaiKhoan dsPhieuTaiKhoan : dsPhieuTaiKhoans) {
			entityCache.removeResult(
				DsPhieuTaiKhoanModelImpl.ENTITY_CACHE_ENABLED,
				DsPhieuTaiKhoanImpl.class, dsPhieuTaiKhoan.getPrimaryKey());
		}
	}

	/**
	 * Creates a new ds phieu tai khoan with the primary key. Does not add the ds phieu tai khoan to the database.
	 *
	 * @param dsPhieuTaiKhoanId the primary key for the new ds phieu tai khoan
	 * @return the new ds phieu tai khoan
	 */
	@Override
	public DsPhieuTaiKhoan create(long dsPhieuTaiKhoanId) {
		DsPhieuTaiKhoan dsPhieuTaiKhoan = new DsPhieuTaiKhoanImpl();

		dsPhieuTaiKhoan.setNew(true);
		dsPhieuTaiKhoan.setPrimaryKey(dsPhieuTaiKhoanId);

		dsPhieuTaiKhoan.setCompanyId(companyProvider.getCompanyId());

		return dsPhieuTaiKhoan;
	}

	/**
	 * Removes the ds phieu tai khoan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dsPhieuTaiKhoanId the primary key of the ds phieu tai khoan
	 * @return the ds phieu tai khoan that was removed
	 * @throws NoSuchDsPhieuTaiKhoanException if a ds phieu tai khoan with the primary key could not be found
	 */
	@Override
	public DsPhieuTaiKhoan remove(long dsPhieuTaiKhoanId)
		throws NoSuchDsPhieuTaiKhoanException {

		return remove((Serializable)dsPhieuTaiKhoanId);
	}

	/**
	 * Removes the ds phieu tai khoan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ds phieu tai khoan
	 * @return the ds phieu tai khoan that was removed
	 * @throws NoSuchDsPhieuTaiKhoanException if a ds phieu tai khoan with the primary key could not be found
	 */
	@Override
	public DsPhieuTaiKhoan remove(Serializable primaryKey)
		throws NoSuchDsPhieuTaiKhoanException {

		Session session = null;

		try {
			session = openSession();

			DsPhieuTaiKhoan dsPhieuTaiKhoan = (DsPhieuTaiKhoan)session.get(
				DsPhieuTaiKhoanImpl.class, primaryKey);

			if (dsPhieuTaiKhoan == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDsPhieuTaiKhoanException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dsPhieuTaiKhoan);
		}
		catch (NoSuchDsPhieuTaiKhoanException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected DsPhieuTaiKhoan removeImpl(DsPhieuTaiKhoan dsPhieuTaiKhoan) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dsPhieuTaiKhoan)) {
				dsPhieuTaiKhoan = (DsPhieuTaiKhoan)session.get(
					DsPhieuTaiKhoanImpl.class,
					dsPhieuTaiKhoan.getPrimaryKeyObj());
			}

			if (dsPhieuTaiKhoan != null) {
				session.delete(dsPhieuTaiKhoan);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (dsPhieuTaiKhoan != null) {
			clearCache(dsPhieuTaiKhoan);
		}

		return dsPhieuTaiKhoan;
	}

	@Override
	public DsPhieuTaiKhoan updateImpl(DsPhieuTaiKhoan dsPhieuTaiKhoan) {
		boolean isNew = dsPhieuTaiKhoan.isNew();

		if (!(dsPhieuTaiKhoan instanceof DsPhieuTaiKhoanModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(dsPhieuTaiKhoan.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					dsPhieuTaiKhoan);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in dsPhieuTaiKhoan proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DsPhieuTaiKhoan implementation " +
					dsPhieuTaiKhoan.getClass());
		}

		DsPhieuTaiKhoanModelImpl dsPhieuTaiKhoanModelImpl =
			(DsPhieuTaiKhoanModelImpl)dsPhieuTaiKhoan;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (dsPhieuTaiKhoan.getCreateDate() == null)) {
			if (serviceContext == null) {
				dsPhieuTaiKhoan.setCreateDate(now);
			}
			else {
				dsPhieuTaiKhoan.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!dsPhieuTaiKhoanModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				dsPhieuTaiKhoan.setModifiedDate(now);
			}
			else {
				dsPhieuTaiKhoan.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (dsPhieuTaiKhoan.isNew()) {
				session.save(dsPhieuTaiKhoan);

				dsPhieuTaiKhoan.setNew(false);
			}
			else {
				dsPhieuTaiKhoan = (DsPhieuTaiKhoan)session.merge(
					dsPhieuTaiKhoan);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!DsPhieuTaiKhoanModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				dsPhieuTaiKhoanModelImpl.getTaiKhoanDoiUngId(),
				dsPhieuTaiKhoanModelImpl.getHoatDong()
			};

			finderCache.removeResult(
				_finderPathCountByTaiKhoanDoiUngId_HoatDong, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByTaiKhoanDoiUngId_HoatDong,
				args);

			args = new Object[] {
				dsPhieuTaiKhoanModelImpl.getPhieuId(),
				dsPhieuTaiKhoanModelImpl.getHoatDong()
			};

			finderCache.removeResult(_finderPathCountByPhieuId_HoatDong, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByPhieuId_HoatDong, args);

			args = new Object[] {dsPhieuTaiKhoanModelImpl.getPhieuId()};

			finderCache.removeResult(_finderPathCountByPhieuId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByPhieuId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((dsPhieuTaiKhoanModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByTaiKhoanDoiUngId_HoatDong.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					dsPhieuTaiKhoanModelImpl.getOriginalTaiKhoanDoiUngId(),
					dsPhieuTaiKhoanModelImpl.getOriginalHoatDong()
				};

				finderCache.removeResult(
					_finderPathCountByTaiKhoanDoiUngId_HoatDong, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTaiKhoanDoiUngId_HoatDong,
					args);

				args = new Object[] {
					dsPhieuTaiKhoanModelImpl.getTaiKhoanDoiUngId(),
					dsPhieuTaiKhoanModelImpl.getHoatDong()
				};

				finderCache.removeResult(
					_finderPathCountByTaiKhoanDoiUngId_HoatDong, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTaiKhoanDoiUngId_HoatDong,
					args);
			}

			if ((dsPhieuTaiKhoanModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByPhieuId_HoatDong.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					dsPhieuTaiKhoanModelImpl.getOriginalPhieuId(),
					dsPhieuTaiKhoanModelImpl.getOriginalHoatDong()
				};

				finderCache.removeResult(
					_finderPathCountByPhieuId_HoatDong, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByPhieuId_HoatDong, args);

				args = new Object[] {
					dsPhieuTaiKhoanModelImpl.getPhieuId(),
					dsPhieuTaiKhoanModelImpl.getHoatDong()
				};

				finderCache.removeResult(
					_finderPathCountByPhieuId_HoatDong, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByPhieuId_HoatDong, args);
			}

			if ((dsPhieuTaiKhoanModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByPhieuId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					dsPhieuTaiKhoanModelImpl.getOriginalPhieuId()
				};

				finderCache.removeResult(_finderPathCountByPhieuId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByPhieuId, args);

				args = new Object[] {dsPhieuTaiKhoanModelImpl.getPhieuId()};

				finderCache.removeResult(_finderPathCountByPhieuId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByPhieuId, args);
			}
		}

		entityCache.putResult(
			DsPhieuTaiKhoanModelImpl.ENTITY_CACHE_ENABLED,
			DsPhieuTaiKhoanImpl.class, dsPhieuTaiKhoan.getPrimaryKey(),
			dsPhieuTaiKhoan, false);

		dsPhieuTaiKhoan.resetOriginalValues();

		return dsPhieuTaiKhoan;
	}

	/**
	 * Returns the ds phieu tai khoan with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ds phieu tai khoan
	 * @return the ds phieu tai khoan
	 * @throws NoSuchDsPhieuTaiKhoanException if a ds phieu tai khoan with the primary key could not be found
	 */
	@Override
	public DsPhieuTaiKhoan findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDsPhieuTaiKhoanException {

		DsPhieuTaiKhoan dsPhieuTaiKhoan = fetchByPrimaryKey(primaryKey);

		if (dsPhieuTaiKhoan == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDsPhieuTaiKhoanException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dsPhieuTaiKhoan;
	}

	/**
	 * Returns the ds phieu tai khoan with the primary key or throws a <code>NoSuchDsPhieuTaiKhoanException</code> if it could not be found.
	 *
	 * @param dsPhieuTaiKhoanId the primary key of the ds phieu tai khoan
	 * @return the ds phieu tai khoan
	 * @throws NoSuchDsPhieuTaiKhoanException if a ds phieu tai khoan with the primary key could not be found
	 */
	@Override
	public DsPhieuTaiKhoan findByPrimaryKey(long dsPhieuTaiKhoanId)
		throws NoSuchDsPhieuTaiKhoanException {

		return findByPrimaryKey((Serializable)dsPhieuTaiKhoanId);
	}

	/**
	 * Returns the ds phieu tai khoan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ds phieu tai khoan
	 * @return the ds phieu tai khoan, or <code>null</code> if a ds phieu tai khoan with the primary key could not be found
	 */
	@Override
	public DsPhieuTaiKhoan fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			DsPhieuTaiKhoanModelImpl.ENTITY_CACHE_ENABLED,
			DsPhieuTaiKhoanImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		DsPhieuTaiKhoan dsPhieuTaiKhoan = (DsPhieuTaiKhoan)serializable;

		if (dsPhieuTaiKhoan == null) {
			Session session = null;

			try {
				session = openSession();

				dsPhieuTaiKhoan = (DsPhieuTaiKhoan)session.get(
					DsPhieuTaiKhoanImpl.class, primaryKey);

				if (dsPhieuTaiKhoan != null) {
					cacheResult(dsPhieuTaiKhoan);
				}
				else {
					entityCache.putResult(
						DsPhieuTaiKhoanModelImpl.ENTITY_CACHE_ENABLED,
						DsPhieuTaiKhoanImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					DsPhieuTaiKhoanModelImpl.ENTITY_CACHE_ENABLED,
					DsPhieuTaiKhoanImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return dsPhieuTaiKhoan;
	}

	/**
	 * Returns the ds phieu tai khoan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dsPhieuTaiKhoanId the primary key of the ds phieu tai khoan
	 * @return the ds phieu tai khoan, or <code>null</code> if a ds phieu tai khoan with the primary key could not be found
	 */
	@Override
	public DsPhieuTaiKhoan fetchByPrimaryKey(long dsPhieuTaiKhoanId) {
		return fetchByPrimaryKey((Serializable)dsPhieuTaiKhoanId);
	}

	@Override
	public Map<Serializable, DsPhieuTaiKhoan> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, DsPhieuTaiKhoan> map =
			new HashMap<Serializable, DsPhieuTaiKhoan>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			DsPhieuTaiKhoan dsPhieuTaiKhoan = fetchByPrimaryKey(primaryKey);

			if (dsPhieuTaiKhoan != null) {
				map.put(primaryKey, dsPhieuTaiKhoan);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				DsPhieuTaiKhoanModelImpl.ENTITY_CACHE_ENABLED,
				DsPhieuTaiKhoanImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (DsPhieuTaiKhoan)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_DSPHIEUTAIKHOAN_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (DsPhieuTaiKhoan dsPhieuTaiKhoan :
					(List<DsPhieuTaiKhoan>)q.list()) {

				map.put(dsPhieuTaiKhoan.getPrimaryKeyObj(), dsPhieuTaiKhoan);

				cacheResult(dsPhieuTaiKhoan);

				uncachedPrimaryKeys.remove(dsPhieuTaiKhoan.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					DsPhieuTaiKhoanModelImpl.ENTITY_CACHE_ENABLED,
					DsPhieuTaiKhoanImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the ds phieu tai khoans.
	 *
	 * @return the ds phieu tai khoans
	 */
	@Override
	public List<DsPhieuTaiKhoan> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ds phieu tai khoans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DsPhieuTaiKhoanModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ds phieu tai khoans
	 * @param end the upper bound of the range of ds phieu tai khoans (not inclusive)
	 * @return the range of ds phieu tai khoans
	 */
	@Override
	public List<DsPhieuTaiKhoan> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ds phieu tai khoans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DsPhieuTaiKhoanModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ds phieu tai khoans
	 * @param end the upper bound of the range of ds phieu tai khoans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ds phieu tai khoans
	 */
	@Override
	public List<DsPhieuTaiKhoan> findAll(
		int start, int end,
		OrderByComparator<DsPhieuTaiKhoan> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ds phieu tai khoans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DsPhieuTaiKhoanModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ds phieu tai khoans
	 * @param end the upper bound of the range of ds phieu tai khoans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of ds phieu tai khoans
	 */
	@Override
	public List<DsPhieuTaiKhoan> findAll(
		int start, int end,
		OrderByComparator<DsPhieuTaiKhoan> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindAll;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<DsPhieuTaiKhoan> list = null;

		if (retrieveFromCache) {
			list = (List<DsPhieuTaiKhoan>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_DSPHIEUTAIKHOAN);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DSPHIEUTAIKHOAN;

				if (pagination) {
					sql = sql.concat(DsPhieuTaiKhoanModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DsPhieuTaiKhoan>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DsPhieuTaiKhoan>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the ds phieu tai khoans from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DsPhieuTaiKhoan dsPhieuTaiKhoan : findAll()) {
			remove(dsPhieuTaiKhoan);
		}
	}

	/**
	 * Returns the number of ds phieu tai khoans.
	 *
	 * @return the number of ds phieu tai khoans
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DSPHIEUTAIKHOAN);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DsPhieuTaiKhoanModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the ds phieu tai khoan persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			DsPhieuTaiKhoanModelImpl.ENTITY_CACHE_ENABLED,
			DsPhieuTaiKhoanModelImpl.FINDER_CACHE_ENABLED,
			DsPhieuTaiKhoanImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			DsPhieuTaiKhoanModelImpl.ENTITY_CACHE_ENABLED,
			DsPhieuTaiKhoanModelImpl.FINDER_CACHE_ENABLED,
			DsPhieuTaiKhoanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			DsPhieuTaiKhoanModelImpl.ENTITY_CACHE_ENABLED,
			DsPhieuTaiKhoanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByTaiKhoanDoiUngId_HoatDong =
			new FinderPath(
				DsPhieuTaiKhoanModelImpl.ENTITY_CACHE_ENABLED,
				DsPhieuTaiKhoanModelImpl.FINDER_CACHE_ENABLED,
				DsPhieuTaiKhoanImpl.class,
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByTaiKhoanDoiUngId_HoatDong",
				new String[] {
					Long.class.getName(), Boolean.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				});

		_finderPathWithoutPaginationFindByTaiKhoanDoiUngId_HoatDong =
			new FinderPath(
				DsPhieuTaiKhoanModelImpl.ENTITY_CACHE_ENABLED,
				DsPhieuTaiKhoanModelImpl.FINDER_CACHE_ENABLED,
				DsPhieuTaiKhoanImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByTaiKhoanDoiUngId_HoatDong",
				new String[] {Long.class.getName(), Boolean.class.getName()},
				DsPhieuTaiKhoanModelImpl.TAIKHOANDOIUNGID_COLUMN_BITMASK |
				DsPhieuTaiKhoanModelImpl.HOATDONG_COLUMN_BITMASK);

		_finderPathCountByTaiKhoanDoiUngId_HoatDong = new FinderPath(
			DsPhieuTaiKhoanModelImpl.ENTITY_CACHE_ENABLED,
			DsPhieuTaiKhoanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTaiKhoanDoiUngId_HoatDong",
			new String[] {Long.class.getName(), Boolean.class.getName()});

		_finderPathWithPaginationFindByPhieuId_HoatDong = new FinderPath(
			DsPhieuTaiKhoanModelImpl.ENTITY_CACHE_ENABLED,
			DsPhieuTaiKhoanModelImpl.FINDER_CACHE_ENABLED,
			DsPhieuTaiKhoanImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPhieuId_HoatDong",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByPhieuId_HoatDong = new FinderPath(
			DsPhieuTaiKhoanModelImpl.ENTITY_CACHE_ENABLED,
			DsPhieuTaiKhoanModelImpl.FINDER_CACHE_ENABLED,
			DsPhieuTaiKhoanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPhieuId_HoatDong",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			DsPhieuTaiKhoanModelImpl.PHIEUID_COLUMN_BITMASK |
			DsPhieuTaiKhoanModelImpl.HOATDONG_COLUMN_BITMASK);

		_finderPathCountByPhieuId_HoatDong = new FinderPath(
			DsPhieuTaiKhoanModelImpl.ENTITY_CACHE_ENABLED,
			DsPhieuTaiKhoanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPhieuId_HoatDong",
			new String[] {Long.class.getName(), Boolean.class.getName()});

		_finderPathWithPaginationFindByPhieuId = new FinderPath(
			DsPhieuTaiKhoanModelImpl.ENTITY_CACHE_ENABLED,
			DsPhieuTaiKhoanModelImpl.FINDER_CACHE_ENABLED,
			DsPhieuTaiKhoanImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPhieuId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByPhieuId = new FinderPath(
			DsPhieuTaiKhoanModelImpl.ENTITY_CACHE_ENABLED,
			DsPhieuTaiKhoanModelImpl.FINDER_CACHE_ENABLED,
			DsPhieuTaiKhoanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPhieuId",
			new String[] {Long.class.getName()},
			DsPhieuTaiKhoanModelImpl.PHIEUID_COLUMN_BITMASK);

		_finderPathCountByPhieuId = new FinderPath(
			DsPhieuTaiKhoanModelImpl.ENTITY_CACHE_ENABLED,
			DsPhieuTaiKhoanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPhieuId",
			new String[] {Long.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(DsPhieuTaiKhoanImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_DSPHIEUTAIKHOAN =
		"SELECT dsPhieuTaiKhoan FROM DsPhieuTaiKhoan dsPhieuTaiKhoan";

	private static final String _SQL_SELECT_DSPHIEUTAIKHOAN_WHERE_PKS_IN =
		"SELECT dsPhieuTaiKhoan FROM DsPhieuTaiKhoan dsPhieuTaiKhoan WHERE dsPhieuTaiKhoanId IN (";

	private static final String _SQL_SELECT_DSPHIEUTAIKHOAN_WHERE =
		"SELECT dsPhieuTaiKhoan FROM DsPhieuTaiKhoan dsPhieuTaiKhoan WHERE ";

	private static final String _SQL_COUNT_DSPHIEUTAIKHOAN =
		"SELECT COUNT(dsPhieuTaiKhoan) FROM DsPhieuTaiKhoan dsPhieuTaiKhoan";

	private static final String _SQL_COUNT_DSPHIEUTAIKHOAN_WHERE =
		"SELECT COUNT(dsPhieuTaiKhoan) FROM DsPhieuTaiKhoan dsPhieuTaiKhoan WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "dsPhieuTaiKhoan.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DsPhieuTaiKhoan exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DsPhieuTaiKhoan exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DsPhieuTaiKhoanPersistenceImpl.class);

}