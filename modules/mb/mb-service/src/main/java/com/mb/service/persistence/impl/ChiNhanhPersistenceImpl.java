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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.mb.exception.NoSuchChiNhanhException;
import com.mb.model.ChiNhanh;
import com.mb.model.impl.ChiNhanhImpl;
import com.mb.model.impl.ChiNhanhModelImpl;
import com.mb.service.persistence.ChiNhanhPersistence;

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
 * The persistence implementation for the chi nhanh service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class ChiNhanhPersistenceImpl
	extends BasePersistenceImpl<ChiNhanh> implements ChiNhanhPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ChiNhanhUtil</code> to access the chi nhanh persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ChiNhanhImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByMa;
	private FinderPath _finderPathCountByMa;

	/**
	 * Returns the chi nhanh where ma = &#63; or throws a <code>NoSuchChiNhanhException</code> if it could not be found.
	 *
	 * @param ma the ma
	 * @return the matching chi nhanh
	 * @throws NoSuchChiNhanhException if a matching chi nhanh could not be found
	 */
	@Override
	public ChiNhanh findByMa(String ma) throws NoSuchChiNhanhException {
		ChiNhanh chiNhanh = fetchByMa(ma);

		if (chiNhanh == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ma=");
			msg.append(ma);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchChiNhanhException(msg.toString());
		}

		return chiNhanh;
	}

	/**
	 * Returns the chi nhanh where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ma the ma
	 * @return the matching chi nhanh, or <code>null</code> if a matching chi nhanh could not be found
	 */
	@Override
	public ChiNhanh fetchByMa(String ma) {
		return fetchByMa(ma, true);
	}

	/**
	 * Returns the chi nhanh where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ma the ma
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching chi nhanh, or <code>null</code> if a matching chi nhanh could not be found
	 */
	@Override
	public ChiNhanh fetchByMa(String ma, boolean retrieveFromCache) {
		ma = Objects.toString(ma, "");

		Object[] finderArgs = new Object[] {ma};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByMa, finderArgs, this);
		}

		if (result instanceof ChiNhanh) {
			ChiNhanh chiNhanh = (ChiNhanh)result;

			if (!Objects.equals(ma, chiNhanh.getMa())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_CHINHANH_WHERE);

			boolean bindMa = false;

			if (ma.isEmpty()) {
				query.append(_FINDER_COLUMN_MA_MA_3);
			}
			else {
				bindMa = true;

				query.append(_FINDER_COLUMN_MA_MA_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindMa) {
					qPos.add(ma);
				}

				List<ChiNhanh> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByMa, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"ChiNhanhPersistenceImpl.fetchByMa(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ChiNhanh chiNhanh = list.get(0);

					result = chiNhanh;

					cacheResult(chiNhanh);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(_finderPathFetchByMa, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (ChiNhanh)result;
		}
	}

	/**
	 * Removes the chi nhanh where ma = &#63; from the database.
	 *
	 * @param ma the ma
	 * @return the chi nhanh that was removed
	 */
	@Override
	public ChiNhanh removeByMa(String ma) throws NoSuchChiNhanhException {
		ChiNhanh chiNhanh = findByMa(ma);

		return remove(chiNhanh);
	}

	/**
	 * Returns the number of chi nhanhs where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the number of matching chi nhanhs
	 */
	@Override
	public int countByMa(String ma) {
		ma = Objects.toString(ma, "");

		FinderPath finderPath = _finderPathCountByMa;

		Object[] finderArgs = new Object[] {ma};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CHINHANH_WHERE);

			boolean bindMa = false;

			if (ma.isEmpty()) {
				query.append(_FINDER_COLUMN_MA_MA_3);
			}
			else {
				bindMa = true;

				query.append(_FINDER_COLUMN_MA_MA_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindMa) {
					qPos.add(ma);
				}

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

	private static final String _FINDER_COLUMN_MA_MA_2 = "chiNhanh.ma = ?";

	private static final String _FINDER_COLUMN_MA_MA_3 =
		"(chiNhanh.ma IS NULL OR chiNhanh.ma = '')";

	private FinderPath _finderPathWithPaginationFindByHoatDong;
	private FinderPath _finderPathWithoutPaginationFindByHoatDong;
	private FinderPath _finderPathCountByHoatDong;

	/**
	 * Returns all the chi nhanhs where hoatDong = &#63;.
	 *
	 * @param hoatDong the hoat dong
	 * @return the matching chi nhanhs
	 */
	@Override
	public List<ChiNhanh> findByHoatDong(Boolean hoatDong) {
		return findByHoatDong(
			hoatDong, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the chi nhanhs where hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ChiNhanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of chi nhanhs
	 * @param end the upper bound of the range of chi nhanhs (not inclusive)
	 * @return the range of matching chi nhanhs
	 */
	@Override
	public List<ChiNhanh> findByHoatDong(Boolean hoatDong, int start, int end) {
		return findByHoatDong(hoatDong, start, end, null);
	}

	/**
	 * Returns an ordered range of all the chi nhanhs where hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ChiNhanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of chi nhanhs
	 * @param end the upper bound of the range of chi nhanhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching chi nhanhs
	 */
	@Override
	public List<ChiNhanh> findByHoatDong(
		Boolean hoatDong, int start, int end,
		OrderByComparator<ChiNhanh> orderByComparator) {

		return findByHoatDong(hoatDong, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the chi nhanhs where hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ChiNhanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of chi nhanhs
	 * @param end the upper bound of the range of chi nhanhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching chi nhanhs
	 */
	@Override
	public List<ChiNhanh> findByHoatDong(
		Boolean hoatDong, int start, int end,
		OrderByComparator<ChiNhanh> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByHoatDong;
			finderArgs = new Object[] {hoatDong};
		}
		else {
			finderPath = _finderPathWithPaginationFindByHoatDong;
			finderArgs = new Object[] {hoatDong, start, end, orderByComparator};
		}

		List<ChiNhanh> list = null;

		if (retrieveFromCache) {
			list = (List<ChiNhanh>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ChiNhanh chiNhanh : list) {
					if (!Objects.equals(hoatDong, chiNhanh.getHoatDong())) {
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

			query.append(_SQL_SELECT_CHINHANH_WHERE);

			query.append(_FINDER_COLUMN_HOATDONG_HOATDONG_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(ChiNhanhModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(hoatDong.booleanValue());

				if (!pagination) {
					list = (List<ChiNhanh>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ChiNhanh>)QueryUtil.list(
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
	 * Returns the first chi nhanh in the ordered set where hoatDong = &#63;.
	 *
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chi nhanh
	 * @throws NoSuchChiNhanhException if a matching chi nhanh could not be found
	 */
	@Override
	public ChiNhanh findByHoatDong_First(
			Boolean hoatDong, OrderByComparator<ChiNhanh> orderByComparator)
		throws NoSuchChiNhanhException {

		ChiNhanh chiNhanh = fetchByHoatDong_First(hoatDong, orderByComparator);

		if (chiNhanh != null) {
			return chiNhanh;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("hoatDong=");
		msg.append(hoatDong);

		msg.append("}");

		throw new NoSuchChiNhanhException(msg.toString());
	}

	/**
	 * Returns the first chi nhanh in the ordered set where hoatDong = &#63;.
	 *
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chi nhanh, or <code>null</code> if a matching chi nhanh could not be found
	 */
	@Override
	public ChiNhanh fetchByHoatDong_First(
		Boolean hoatDong, OrderByComparator<ChiNhanh> orderByComparator) {

		List<ChiNhanh> list = findByHoatDong(hoatDong, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last chi nhanh in the ordered set where hoatDong = &#63;.
	 *
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chi nhanh
	 * @throws NoSuchChiNhanhException if a matching chi nhanh could not be found
	 */
	@Override
	public ChiNhanh findByHoatDong_Last(
			Boolean hoatDong, OrderByComparator<ChiNhanh> orderByComparator)
		throws NoSuchChiNhanhException {

		ChiNhanh chiNhanh = fetchByHoatDong_Last(hoatDong, orderByComparator);

		if (chiNhanh != null) {
			return chiNhanh;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("hoatDong=");
		msg.append(hoatDong);

		msg.append("}");

		throw new NoSuchChiNhanhException(msg.toString());
	}

	/**
	 * Returns the last chi nhanh in the ordered set where hoatDong = &#63;.
	 *
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chi nhanh, or <code>null</code> if a matching chi nhanh could not be found
	 */
	@Override
	public ChiNhanh fetchByHoatDong_Last(
		Boolean hoatDong, OrderByComparator<ChiNhanh> orderByComparator) {

		int count = countByHoatDong(hoatDong);

		if (count == 0) {
			return null;
		}

		List<ChiNhanh> list = findByHoatDong(
			hoatDong, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the chi nhanhs before and after the current chi nhanh in the ordered set where hoatDong = &#63;.
	 *
	 * @param chiNhanhId the primary key of the current chi nhanh
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next chi nhanh
	 * @throws NoSuchChiNhanhException if a chi nhanh with the primary key could not be found
	 */
	@Override
	public ChiNhanh[] findByHoatDong_PrevAndNext(
			long chiNhanhId, Boolean hoatDong,
			OrderByComparator<ChiNhanh> orderByComparator)
		throws NoSuchChiNhanhException {

		ChiNhanh chiNhanh = findByPrimaryKey(chiNhanhId);

		Session session = null;

		try {
			session = openSession();

			ChiNhanh[] array = new ChiNhanhImpl[3];

			array[0] = getByHoatDong_PrevAndNext(
				session, chiNhanh, hoatDong, orderByComparator, true);

			array[1] = chiNhanh;

			array[2] = getByHoatDong_PrevAndNext(
				session, chiNhanh, hoatDong, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ChiNhanh getByHoatDong_PrevAndNext(
		Session session, ChiNhanh chiNhanh, Boolean hoatDong,
		OrderByComparator<ChiNhanh> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CHINHANH_WHERE);

		query.append(_FINDER_COLUMN_HOATDONG_HOATDONG_2);

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
			query.append(ChiNhanhModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(hoatDong.booleanValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(chiNhanh)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<ChiNhanh> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the chi nhanhs where hoatDong = &#63; from the database.
	 *
	 * @param hoatDong the hoat dong
	 */
	@Override
	public void removeByHoatDong(Boolean hoatDong) {
		for (ChiNhanh chiNhanh :
				findByHoatDong(
					hoatDong, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(chiNhanh);
		}
	}

	/**
	 * Returns the number of chi nhanhs where hoatDong = &#63;.
	 *
	 * @param hoatDong the hoat dong
	 * @return the number of matching chi nhanhs
	 */
	@Override
	public int countByHoatDong(Boolean hoatDong) {
		FinderPath finderPath = _finderPathCountByHoatDong;

		Object[] finderArgs = new Object[] {hoatDong};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CHINHANH_WHERE);

			query.append(_FINDER_COLUMN_HOATDONG_HOATDONG_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_HOATDONG_HOATDONG_2 =
		"chiNhanh.hoatDong = ?";

	public ChiNhanhPersistenceImpl() {
		setModelClass(ChiNhanh.class);
	}

	/**
	 * Caches the chi nhanh in the entity cache if it is enabled.
	 *
	 * @param chiNhanh the chi nhanh
	 */
	@Override
	public void cacheResult(ChiNhanh chiNhanh) {
		entityCache.putResult(
			ChiNhanhModelImpl.ENTITY_CACHE_ENABLED, ChiNhanhImpl.class,
			chiNhanh.getPrimaryKey(), chiNhanh);

		finderCache.putResult(
			_finderPathFetchByMa, new Object[] {chiNhanh.getMa()}, chiNhanh);

		chiNhanh.resetOriginalValues();
	}

	/**
	 * Caches the chi nhanhs in the entity cache if it is enabled.
	 *
	 * @param chiNhanhs the chi nhanhs
	 */
	@Override
	public void cacheResult(List<ChiNhanh> chiNhanhs) {
		for (ChiNhanh chiNhanh : chiNhanhs) {
			if (entityCache.getResult(
					ChiNhanhModelImpl.ENTITY_CACHE_ENABLED, ChiNhanhImpl.class,
					chiNhanh.getPrimaryKey()) == null) {

				cacheResult(chiNhanh);
			}
			else {
				chiNhanh.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all chi nhanhs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ChiNhanhImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the chi nhanh.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ChiNhanh chiNhanh) {
		entityCache.removeResult(
			ChiNhanhModelImpl.ENTITY_CACHE_ENABLED, ChiNhanhImpl.class,
			chiNhanh.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((ChiNhanhModelImpl)chiNhanh, true);
	}

	@Override
	public void clearCache(List<ChiNhanh> chiNhanhs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ChiNhanh chiNhanh : chiNhanhs) {
			entityCache.removeResult(
				ChiNhanhModelImpl.ENTITY_CACHE_ENABLED, ChiNhanhImpl.class,
				chiNhanh.getPrimaryKey());

			clearUniqueFindersCache((ChiNhanhModelImpl)chiNhanh, true);
		}
	}

	protected void cacheUniqueFindersCache(
		ChiNhanhModelImpl chiNhanhModelImpl) {

		Object[] args = new Object[] {chiNhanhModelImpl.getMa()};

		finderCache.putResult(
			_finderPathCountByMa, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByMa, args, chiNhanhModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		ChiNhanhModelImpl chiNhanhModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {chiNhanhModelImpl.getMa()};

			finderCache.removeResult(_finderPathCountByMa, args);
			finderCache.removeResult(_finderPathFetchByMa, args);
		}

		if ((chiNhanhModelImpl.getColumnBitmask() &
			 _finderPathFetchByMa.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {chiNhanhModelImpl.getOriginalMa()};

			finderCache.removeResult(_finderPathCountByMa, args);
			finderCache.removeResult(_finderPathFetchByMa, args);
		}
	}

	/**
	 * Creates a new chi nhanh with the primary key. Does not add the chi nhanh to the database.
	 *
	 * @param chiNhanhId the primary key for the new chi nhanh
	 * @return the new chi nhanh
	 */
	@Override
	public ChiNhanh create(long chiNhanhId) {
		ChiNhanh chiNhanh = new ChiNhanhImpl();

		chiNhanh.setNew(true);
		chiNhanh.setPrimaryKey(chiNhanhId);

		chiNhanh.setCompanyId(companyProvider.getCompanyId());

		return chiNhanh;
	}

	/**
	 * Removes the chi nhanh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param chiNhanhId the primary key of the chi nhanh
	 * @return the chi nhanh that was removed
	 * @throws NoSuchChiNhanhException if a chi nhanh with the primary key could not be found
	 */
	@Override
	public ChiNhanh remove(long chiNhanhId) throws NoSuchChiNhanhException {
		return remove((Serializable)chiNhanhId);
	}

	/**
	 * Removes the chi nhanh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the chi nhanh
	 * @return the chi nhanh that was removed
	 * @throws NoSuchChiNhanhException if a chi nhanh with the primary key could not be found
	 */
	@Override
	public ChiNhanh remove(Serializable primaryKey)
		throws NoSuchChiNhanhException {

		Session session = null;

		try {
			session = openSession();

			ChiNhanh chiNhanh = (ChiNhanh)session.get(
				ChiNhanhImpl.class, primaryKey);

			if (chiNhanh == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchChiNhanhException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(chiNhanh);
		}
		catch (NoSuchChiNhanhException nsee) {
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
	protected ChiNhanh removeImpl(ChiNhanh chiNhanh) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(chiNhanh)) {
				chiNhanh = (ChiNhanh)session.get(
					ChiNhanhImpl.class, chiNhanh.getPrimaryKeyObj());
			}

			if (chiNhanh != null) {
				session.delete(chiNhanh);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (chiNhanh != null) {
			clearCache(chiNhanh);
		}

		return chiNhanh;
	}

	@Override
	public ChiNhanh updateImpl(ChiNhanh chiNhanh) {
		boolean isNew = chiNhanh.isNew();

		if (!(chiNhanh instanceof ChiNhanhModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(chiNhanh.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(chiNhanh);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in chiNhanh proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ChiNhanh implementation " +
					chiNhanh.getClass());
		}

		ChiNhanhModelImpl chiNhanhModelImpl = (ChiNhanhModelImpl)chiNhanh;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (chiNhanh.getCreateDate() == null)) {
			if (serviceContext == null) {
				chiNhanh.setCreateDate(now);
			}
			else {
				chiNhanh.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!chiNhanhModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				chiNhanh.setModifiedDate(now);
			}
			else {
				chiNhanh.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (chiNhanh.isNew()) {
				session.save(chiNhanh);

				chiNhanh.setNew(false);
			}
			else {
				chiNhanh = (ChiNhanh)session.merge(chiNhanh);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!ChiNhanhModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {chiNhanhModelImpl.getHoatDong()};

			finderCache.removeResult(_finderPathCountByHoatDong, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByHoatDong, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((chiNhanhModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByHoatDong.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					chiNhanhModelImpl.getOriginalHoatDong()
				};

				finderCache.removeResult(_finderPathCountByHoatDong, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByHoatDong, args);

				args = new Object[] {chiNhanhModelImpl.getHoatDong()};

				finderCache.removeResult(_finderPathCountByHoatDong, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByHoatDong, args);
			}
		}

		entityCache.putResult(
			ChiNhanhModelImpl.ENTITY_CACHE_ENABLED, ChiNhanhImpl.class,
			chiNhanh.getPrimaryKey(), chiNhanh, false);

		clearUniqueFindersCache(chiNhanhModelImpl, false);
		cacheUniqueFindersCache(chiNhanhModelImpl);

		chiNhanh.resetOriginalValues();

		return chiNhanh;
	}

	/**
	 * Returns the chi nhanh with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the chi nhanh
	 * @return the chi nhanh
	 * @throws NoSuchChiNhanhException if a chi nhanh with the primary key could not be found
	 */
	@Override
	public ChiNhanh findByPrimaryKey(Serializable primaryKey)
		throws NoSuchChiNhanhException {

		ChiNhanh chiNhanh = fetchByPrimaryKey(primaryKey);

		if (chiNhanh == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchChiNhanhException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return chiNhanh;
	}

	/**
	 * Returns the chi nhanh with the primary key or throws a <code>NoSuchChiNhanhException</code> if it could not be found.
	 *
	 * @param chiNhanhId the primary key of the chi nhanh
	 * @return the chi nhanh
	 * @throws NoSuchChiNhanhException if a chi nhanh with the primary key could not be found
	 */
	@Override
	public ChiNhanh findByPrimaryKey(long chiNhanhId)
		throws NoSuchChiNhanhException {

		return findByPrimaryKey((Serializable)chiNhanhId);
	}

	/**
	 * Returns the chi nhanh with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the chi nhanh
	 * @return the chi nhanh, or <code>null</code> if a chi nhanh with the primary key could not be found
	 */
	@Override
	public ChiNhanh fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			ChiNhanhModelImpl.ENTITY_CACHE_ENABLED, ChiNhanhImpl.class,
			primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		ChiNhanh chiNhanh = (ChiNhanh)serializable;

		if (chiNhanh == null) {
			Session session = null;

			try {
				session = openSession();

				chiNhanh = (ChiNhanh)session.get(
					ChiNhanhImpl.class, primaryKey);

				if (chiNhanh != null) {
					cacheResult(chiNhanh);
				}
				else {
					entityCache.putResult(
						ChiNhanhModelImpl.ENTITY_CACHE_ENABLED,
						ChiNhanhImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					ChiNhanhModelImpl.ENTITY_CACHE_ENABLED, ChiNhanhImpl.class,
					primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return chiNhanh;
	}

	/**
	 * Returns the chi nhanh with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param chiNhanhId the primary key of the chi nhanh
	 * @return the chi nhanh, or <code>null</code> if a chi nhanh with the primary key could not be found
	 */
	@Override
	public ChiNhanh fetchByPrimaryKey(long chiNhanhId) {
		return fetchByPrimaryKey((Serializable)chiNhanhId);
	}

	@Override
	public Map<Serializable, ChiNhanh> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ChiNhanh> map = new HashMap<Serializable, ChiNhanh>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ChiNhanh chiNhanh = fetchByPrimaryKey(primaryKey);

			if (chiNhanh != null) {
				map.put(primaryKey, chiNhanh);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				ChiNhanhModelImpl.ENTITY_CACHE_ENABLED, ChiNhanhImpl.class,
				primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (ChiNhanh)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_CHINHANH_WHERE_PKS_IN);

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

			for (ChiNhanh chiNhanh : (List<ChiNhanh>)q.list()) {
				map.put(chiNhanh.getPrimaryKeyObj(), chiNhanh);

				cacheResult(chiNhanh);

				uncachedPrimaryKeys.remove(chiNhanh.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					ChiNhanhModelImpl.ENTITY_CACHE_ENABLED, ChiNhanhImpl.class,
					primaryKey, nullModel);
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
	 * Returns all the chi nhanhs.
	 *
	 * @return the chi nhanhs
	 */
	@Override
	public List<ChiNhanh> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the chi nhanhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ChiNhanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of chi nhanhs
	 * @param end the upper bound of the range of chi nhanhs (not inclusive)
	 * @return the range of chi nhanhs
	 */
	@Override
	public List<ChiNhanh> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the chi nhanhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ChiNhanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of chi nhanhs
	 * @param end the upper bound of the range of chi nhanhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of chi nhanhs
	 */
	@Override
	public List<ChiNhanh> findAll(
		int start, int end, OrderByComparator<ChiNhanh> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the chi nhanhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ChiNhanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of chi nhanhs
	 * @param end the upper bound of the range of chi nhanhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of chi nhanhs
	 */
	@Override
	public List<ChiNhanh> findAll(
		int start, int end, OrderByComparator<ChiNhanh> orderByComparator,
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

		List<ChiNhanh> list = null;

		if (retrieveFromCache) {
			list = (List<ChiNhanh>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CHINHANH);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CHINHANH;

				if (pagination) {
					sql = sql.concat(ChiNhanhModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ChiNhanh>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ChiNhanh>)QueryUtil.list(
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
	 * Removes all the chi nhanhs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ChiNhanh chiNhanh : findAll()) {
			remove(chiNhanh);
		}
	}

	/**
	 * Returns the number of chi nhanhs.
	 *
	 * @return the number of chi nhanhs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CHINHANH);

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
		return ChiNhanhModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the chi nhanh persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			ChiNhanhModelImpl.ENTITY_CACHE_ENABLED,
			ChiNhanhModelImpl.FINDER_CACHE_ENABLED, ChiNhanhImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			ChiNhanhModelImpl.ENTITY_CACHE_ENABLED,
			ChiNhanhModelImpl.FINDER_CACHE_ENABLED, ChiNhanhImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			ChiNhanhModelImpl.ENTITY_CACHE_ENABLED,
			ChiNhanhModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByMa = new FinderPath(
			ChiNhanhModelImpl.ENTITY_CACHE_ENABLED,
			ChiNhanhModelImpl.FINDER_CACHE_ENABLED, ChiNhanhImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByMa",
			new String[] {String.class.getName()},
			ChiNhanhModelImpl.MA_COLUMN_BITMASK);

		_finderPathCountByMa = new FinderPath(
			ChiNhanhModelImpl.ENTITY_CACHE_ENABLED,
			ChiNhanhModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMa",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByHoatDong = new FinderPath(
			ChiNhanhModelImpl.ENTITY_CACHE_ENABLED,
			ChiNhanhModelImpl.FINDER_CACHE_ENABLED, ChiNhanhImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByHoatDong",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByHoatDong = new FinderPath(
			ChiNhanhModelImpl.ENTITY_CACHE_ENABLED,
			ChiNhanhModelImpl.FINDER_CACHE_ENABLED, ChiNhanhImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByHoatDong",
			new String[] {Boolean.class.getName()},
			ChiNhanhModelImpl.HOATDONG_COLUMN_BITMASK);

		_finderPathCountByHoatDong = new FinderPath(
			ChiNhanhModelImpl.ENTITY_CACHE_ENABLED,
			ChiNhanhModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByHoatDong",
			new String[] {Boolean.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(ChiNhanhImpl.class.getName());
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

	private static final String _SQL_SELECT_CHINHANH =
		"SELECT chiNhanh FROM ChiNhanh chiNhanh";

	private static final String _SQL_SELECT_CHINHANH_WHERE_PKS_IN =
		"SELECT chiNhanh FROM ChiNhanh chiNhanh WHERE chiNhanhId IN (";

	private static final String _SQL_SELECT_CHINHANH_WHERE =
		"SELECT chiNhanh FROM ChiNhanh chiNhanh WHERE ";

	private static final String _SQL_COUNT_CHINHANH =
		"SELECT COUNT(chiNhanh) FROM ChiNhanh chiNhanh";

	private static final String _SQL_COUNT_CHINHANH_WHERE =
		"SELECT COUNT(chiNhanh) FROM ChiNhanh chiNhanh WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "chiNhanh.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ChiNhanh exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ChiNhanh exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ChiNhanhPersistenceImpl.class);

}