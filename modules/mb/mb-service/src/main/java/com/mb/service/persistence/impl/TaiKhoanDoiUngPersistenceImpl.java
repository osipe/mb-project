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

import com.mb.exception.NoSuchTaiKhoanDoiUngException;
import com.mb.model.TaiKhoanDoiUng;
import com.mb.model.impl.TaiKhoanDoiUngImpl;
import com.mb.model.impl.TaiKhoanDoiUngModelImpl;
import com.mb.service.persistence.TaiKhoanDoiUngPersistence;

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
 * The persistence implementation for the tai khoan doi ung service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class TaiKhoanDoiUngPersistenceImpl
	extends BasePersistenceImpl<TaiKhoanDoiUng>
	implements TaiKhoanDoiUngPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TaiKhoanDoiUngUtil</code> to access the tai khoan doi ung persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TaiKhoanDoiUngImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchBySoHieu;
	private FinderPath _finderPathCountBySoHieu;

	/**
	 * Returns the tai khoan doi ung where soHieu = &#63; or throws a <code>NoSuchTaiKhoanDoiUngException</code> if it could not be found.
	 *
	 * @param soHieu the so hieu
	 * @return the matching tai khoan doi ung
	 * @throws NoSuchTaiKhoanDoiUngException if a matching tai khoan doi ung could not be found
	 */
	@Override
	public TaiKhoanDoiUng findBySoHieu(String soHieu)
		throws NoSuchTaiKhoanDoiUngException {

		TaiKhoanDoiUng taiKhoanDoiUng = fetchBySoHieu(soHieu);

		if (taiKhoanDoiUng == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("soHieu=");
			msg.append(soHieu);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchTaiKhoanDoiUngException(msg.toString());
		}

		return taiKhoanDoiUng;
	}

	/**
	 * Returns the tai khoan doi ung where soHieu = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param soHieu the so hieu
	 * @return the matching tai khoan doi ung, or <code>null</code> if a matching tai khoan doi ung could not be found
	 */
	@Override
	public TaiKhoanDoiUng fetchBySoHieu(String soHieu) {
		return fetchBySoHieu(soHieu, true);
	}

	/**
	 * Returns the tai khoan doi ung where soHieu = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param soHieu the so hieu
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching tai khoan doi ung, or <code>null</code> if a matching tai khoan doi ung could not be found
	 */
	@Override
	public TaiKhoanDoiUng fetchBySoHieu(
		String soHieu, boolean retrieveFromCache) {

		soHieu = Objects.toString(soHieu, "");

		Object[] finderArgs = new Object[] {soHieu};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchBySoHieu, finderArgs, this);
		}

		if (result instanceof TaiKhoanDoiUng) {
			TaiKhoanDoiUng taiKhoanDoiUng = (TaiKhoanDoiUng)result;

			if (!Objects.equals(soHieu, taiKhoanDoiUng.getSoHieu())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_TAIKHOANDOIUNG_WHERE);

			boolean bindSoHieu = false;

			if (soHieu.isEmpty()) {
				query.append(_FINDER_COLUMN_SOHIEU_SOHIEU_3);
			}
			else {
				bindSoHieu = true;

				query.append(_FINDER_COLUMN_SOHIEU_SOHIEU_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindSoHieu) {
					qPos.add(soHieu);
				}

				List<TaiKhoanDoiUng> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchBySoHieu, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"TaiKhoanDoiUngPersistenceImpl.fetchBySoHieu(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					TaiKhoanDoiUng taiKhoanDoiUng = list.get(0);

					result = taiKhoanDoiUng;

					cacheResult(taiKhoanDoiUng);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(_finderPathFetchBySoHieu, finderArgs);

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
			return (TaiKhoanDoiUng)result;
		}
	}

	/**
	 * Removes the tai khoan doi ung where soHieu = &#63; from the database.
	 *
	 * @param soHieu the so hieu
	 * @return the tai khoan doi ung that was removed
	 */
	@Override
	public TaiKhoanDoiUng removeBySoHieu(String soHieu)
		throws NoSuchTaiKhoanDoiUngException {

		TaiKhoanDoiUng taiKhoanDoiUng = findBySoHieu(soHieu);

		return remove(taiKhoanDoiUng);
	}

	/**
	 * Returns the number of tai khoan doi ungs where soHieu = &#63;.
	 *
	 * @param soHieu the so hieu
	 * @return the number of matching tai khoan doi ungs
	 */
	@Override
	public int countBySoHieu(String soHieu) {
		soHieu = Objects.toString(soHieu, "");

		FinderPath finderPath = _finderPathCountBySoHieu;

		Object[] finderArgs = new Object[] {soHieu};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TAIKHOANDOIUNG_WHERE);

			boolean bindSoHieu = false;

			if (soHieu.isEmpty()) {
				query.append(_FINDER_COLUMN_SOHIEU_SOHIEU_3);
			}
			else {
				bindSoHieu = true;

				query.append(_FINDER_COLUMN_SOHIEU_SOHIEU_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindSoHieu) {
					qPos.add(soHieu);
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

	private static final String _FINDER_COLUMN_SOHIEU_SOHIEU_2 =
		"taiKhoanDoiUng.soHieu = ?";

	private static final String _FINDER_COLUMN_SOHIEU_SOHIEU_3 =
		"(taiKhoanDoiUng.soHieu IS NULL OR taiKhoanDoiUng.soHieu = '')";

	private FinderPath _finderPathWithPaginationFindByHoatDong;
	private FinderPath _finderPathWithoutPaginationFindByHoatDong;
	private FinderPath _finderPathCountByHoatDong;

	/**
	 * Returns all the tai khoan doi ungs where hoatDong = &#63;.
	 *
	 * @param hoatDong the hoat dong
	 * @return the matching tai khoan doi ungs
	 */
	@Override
	public List<TaiKhoanDoiUng> findByHoatDong(Boolean hoatDong) {
		return findByHoatDong(
			hoatDong, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tai khoan doi ungs where hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaiKhoanDoiUngModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of tai khoan doi ungs
	 * @param end the upper bound of the range of tai khoan doi ungs (not inclusive)
	 * @return the range of matching tai khoan doi ungs
	 */
	@Override
	public List<TaiKhoanDoiUng> findByHoatDong(
		Boolean hoatDong, int start, int end) {

		return findByHoatDong(hoatDong, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tai khoan doi ungs where hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaiKhoanDoiUngModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of tai khoan doi ungs
	 * @param end the upper bound of the range of tai khoan doi ungs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tai khoan doi ungs
	 */
	@Override
	public List<TaiKhoanDoiUng> findByHoatDong(
		Boolean hoatDong, int start, int end,
		OrderByComparator<TaiKhoanDoiUng> orderByComparator) {

		return findByHoatDong(hoatDong, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tai khoan doi ungs where hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaiKhoanDoiUngModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of tai khoan doi ungs
	 * @param end the upper bound of the range of tai khoan doi ungs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching tai khoan doi ungs
	 */
	@Override
	public List<TaiKhoanDoiUng> findByHoatDong(
		Boolean hoatDong, int start, int end,
		OrderByComparator<TaiKhoanDoiUng> orderByComparator,
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

		List<TaiKhoanDoiUng> list = null;

		if (retrieveFromCache) {
			list = (List<TaiKhoanDoiUng>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TaiKhoanDoiUng taiKhoanDoiUng : list) {
					if (!Objects.equals(
							hoatDong, taiKhoanDoiUng.getHoatDong())) {

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

			query.append(_SQL_SELECT_TAIKHOANDOIUNG_WHERE);

			query.append(_FINDER_COLUMN_HOATDONG_HOATDONG_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(TaiKhoanDoiUngModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(hoatDong.booleanValue());

				if (!pagination) {
					list = (List<TaiKhoanDoiUng>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TaiKhoanDoiUng>)QueryUtil.list(
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
	 * Returns the first tai khoan doi ung in the ordered set where hoatDong = &#63;.
	 *
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tai khoan doi ung
	 * @throws NoSuchTaiKhoanDoiUngException if a matching tai khoan doi ung could not be found
	 */
	@Override
	public TaiKhoanDoiUng findByHoatDong_First(
			Boolean hoatDong,
			OrderByComparator<TaiKhoanDoiUng> orderByComparator)
		throws NoSuchTaiKhoanDoiUngException {

		TaiKhoanDoiUng taiKhoanDoiUng = fetchByHoatDong_First(
			hoatDong, orderByComparator);

		if (taiKhoanDoiUng != null) {
			return taiKhoanDoiUng;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("hoatDong=");
		msg.append(hoatDong);

		msg.append("}");

		throw new NoSuchTaiKhoanDoiUngException(msg.toString());
	}

	/**
	 * Returns the first tai khoan doi ung in the ordered set where hoatDong = &#63;.
	 *
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tai khoan doi ung, or <code>null</code> if a matching tai khoan doi ung could not be found
	 */
	@Override
	public TaiKhoanDoiUng fetchByHoatDong_First(
		Boolean hoatDong, OrderByComparator<TaiKhoanDoiUng> orderByComparator) {

		List<TaiKhoanDoiUng> list = findByHoatDong(
			hoatDong, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tai khoan doi ung in the ordered set where hoatDong = &#63;.
	 *
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tai khoan doi ung
	 * @throws NoSuchTaiKhoanDoiUngException if a matching tai khoan doi ung could not be found
	 */
	@Override
	public TaiKhoanDoiUng findByHoatDong_Last(
			Boolean hoatDong,
			OrderByComparator<TaiKhoanDoiUng> orderByComparator)
		throws NoSuchTaiKhoanDoiUngException {

		TaiKhoanDoiUng taiKhoanDoiUng = fetchByHoatDong_Last(
			hoatDong, orderByComparator);

		if (taiKhoanDoiUng != null) {
			return taiKhoanDoiUng;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("hoatDong=");
		msg.append(hoatDong);

		msg.append("}");

		throw new NoSuchTaiKhoanDoiUngException(msg.toString());
	}

	/**
	 * Returns the last tai khoan doi ung in the ordered set where hoatDong = &#63;.
	 *
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tai khoan doi ung, or <code>null</code> if a matching tai khoan doi ung could not be found
	 */
	@Override
	public TaiKhoanDoiUng fetchByHoatDong_Last(
		Boolean hoatDong, OrderByComparator<TaiKhoanDoiUng> orderByComparator) {

		int count = countByHoatDong(hoatDong);

		if (count == 0) {
			return null;
		}

		List<TaiKhoanDoiUng> list = findByHoatDong(
			hoatDong, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tai khoan doi ungs before and after the current tai khoan doi ung in the ordered set where hoatDong = &#63;.
	 *
	 * @param taiKhoanDoiUngId the primary key of the current tai khoan doi ung
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tai khoan doi ung
	 * @throws NoSuchTaiKhoanDoiUngException if a tai khoan doi ung with the primary key could not be found
	 */
	@Override
	public TaiKhoanDoiUng[] findByHoatDong_PrevAndNext(
			long taiKhoanDoiUngId, Boolean hoatDong,
			OrderByComparator<TaiKhoanDoiUng> orderByComparator)
		throws NoSuchTaiKhoanDoiUngException {

		TaiKhoanDoiUng taiKhoanDoiUng = findByPrimaryKey(taiKhoanDoiUngId);

		Session session = null;

		try {
			session = openSession();

			TaiKhoanDoiUng[] array = new TaiKhoanDoiUngImpl[3];

			array[0] = getByHoatDong_PrevAndNext(
				session, taiKhoanDoiUng, hoatDong, orderByComparator, true);

			array[1] = taiKhoanDoiUng;

			array[2] = getByHoatDong_PrevAndNext(
				session, taiKhoanDoiUng, hoatDong, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TaiKhoanDoiUng getByHoatDong_PrevAndNext(
		Session session, TaiKhoanDoiUng taiKhoanDoiUng, Boolean hoatDong,
		OrderByComparator<TaiKhoanDoiUng> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TAIKHOANDOIUNG_WHERE);

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
			query.append(TaiKhoanDoiUngModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(hoatDong.booleanValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						taiKhoanDoiUng)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<TaiKhoanDoiUng> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tai khoan doi ungs where hoatDong = &#63; from the database.
	 *
	 * @param hoatDong the hoat dong
	 */
	@Override
	public void removeByHoatDong(Boolean hoatDong) {
		for (TaiKhoanDoiUng taiKhoanDoiUng :
				findByHoatDong(
					hoatDong, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(taiKhoanDoiUng);
		}
	}

	/**
	 * Returns the number of tai khoan doi ungs where hoatDong = &#63;.
	 *
	 * @param hoatDong the hoat dong
	 * @return the number of matching tai khoan doi ungs
	 */
	@Override
	public int countByHoatDong(Boolean hoatDong) {
		FinderPath finderPath = _finderPathCountByHoatDong;

		Object[] finderArgs = new Object[] {hoatDong};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TAIKHOANDOIUNG_WHERE);

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
		"taiKhoanDoiUng.hoatDong = ?";

	private FinderPath _finderPathWithPaginationFindByLoaiTaiKhoan_HoatDong;
	private FinderPath _finderPathWithoutPaginationFindByLoaiTaiKhoan_HoatDong;
	private FinderPath _finderPathCountByLoaiTaiKhoan_HoatDong;

	/**
	 * Returns all the tai khoan doi ungs where loaiTaiKhoan = &#63; and hoatDong = &#63;.
	 *
	 * @param loaiTaiKhoan the loai tai khoan
	 * @param hoatDong the hoat dong
	 * @return the matching tai khoan doi ungs
	 */
	@Override
	public List<TaiKhoanDoiUng> findByLoaiTaiKhoan_HoatDong(
		int loaiTaiKhoan, Boolean hoatDong) {

		return findByLoaiTaiKhoan_HoatDong(
			loaiTaiKhoan, hoatDong, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tai khoan doi ungs where loaiTaiKhoan = &#63; and hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaiKhoanDoiUngModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param loaiTaiKhoan the loai tai khoan
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of tai khoan doi ungs
	 * @param end the upper bound of the range of tai khoan doi ungs (not inclusive)
	 * @return the range of matching tai khoan doi ungs
	 */
	@Override
	public List<TaiKhoanDoiUng> findByLoaiTaiKhoan_HoatDong(
		int loaiTaiKhoan, Boolean hoatDong, int start, int end) {

		return findByLoaiTaiKhoan_HoatDong(
			loaiTaiKhoan, hoatDong, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tai khoan doi ungs where loaiTaiKhoan = &#63; and hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaiKhoanDoiUngModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param loaiTaiKhoan the loai tai khoan
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of tai khoan doi ungs
	 * @param end the upper bound of the range of tai khoan doi ungs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tai khoan doi ungs
	 */
	@Override
	public List<TaiKhoanDoiUng> findByLoaiTaiKhoan_HoatDong(
		int loaiTaiKhoan, Boolean hoatDong, int start, int end,
		OrderByComparator<TaiKhoanDoiUng> orderByComparator) {

		return findByLoaiTaiKhoan_HoatDong(
			loaiTaiKhoan, hoatDong, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tai khoan doi ungs where loaiTaiKhoan = &#63; and hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaiKhoanDoiUngModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param loaiTaiKhoan the loai tai khoan
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of tai khoan doi ungs
	 * @param end the upper bound of the range of tai khoan doi ungs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching tai khoan doi ungs
	 */
	@Override
	public List<TaiKhoanDoiUng> findByLoaiTaiKhoan_HoatDong(
		int loaiTaiKhoan, Boolean hoatDong, int start, int end,
		OrderByComparator<TaiKhoanDoiUng> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath =
				_finderPathWithoutPaginationFindByLoaiTaiKhoan_HoatDong;
			finderArgs = new Object[] {loaiTaiKhoan, hoatDong};
		}
		else {
			finderPath = _finderPathWithPaginationFindByLoaiTaiKhoan_HoatDong;
			finderArgs = new Object[] {
				loaiTaiKhoan, hoatDong, start, end, orderByComparator
			};
		}

		List<TaiKhoanDoiUng> list = null;

		if (retrieveFromCache) {
			list = (List<TaiKhoanDoiUng>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TaiKhoanDoiUng taiKhoanDoiUng : list) {
					if ((loaiTaiKhoan != taiKhoanDoiUng.getLoaiTaiKhoan()) ||
						!Objects.equals(
							hoatDong, taiKhoanDoiUng.getHoatDong())) {

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

			query.append(_SQL_SELECT_TAIKHOANDOIUNG_WHERE);

			query.append(_FINDER_COLUMN_LOAITAIKHOAN_HOATDONG_LOAITAIKHOAN_2);

			query.append(_FINDER_COLUMN_LOAITAIKHOAN_HOATDONG_HOATDONG_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(TaiKhoanDoiUngModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(loaiTaiKhoan);

				qPos.add(hoatDong.booleanValue());

				if (!pagination) {
					list = (List<TaiKhoanDoiUng>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TaiKhoanDoiUng>)QueryUtil.list(
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
	 * Returns the first tai khoan doi ung in the ordered set where loaiTaiKhoan = &#63; and hoatDong = &#63;.
	 *
	 * @param loaiTaiKhoan the loai tai khoan
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tai khoan doi ung
	 * @throws NoSuchTaiKhoanDoiUngException if a matching tai khoan doi ung could not be found
	 */
	@Override
	public TaiKhoanDoiUng findByLoaiTaiKhoan_HoatDong_First(
			int loaiTaiKhoan, Boolean hoatDong,
			OrderByComparator<TaiKhoanDoiUng> orderByComparator)
		throws NoSuchTaiKhoanDoiUngException {

		TaiKhoanDoiUng taiKhoanDoiUng = fetchByLoaiTaiKhoan_HoatDong_First(
			loaiTaiKhoan, hoatDong, orderByComparator);

		if (taiKhoanDoiUng != null) {
			return taiKhoanDoiUng;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("loaiTaiKhoan=");
		msg.append(loaiTaiKhoan);

		msg.append(", hoatDong=");
		msg.append(hoatDong);

		msg.append("}");

		throw new NoSuchTaiKhoanDoiUngException(msg.toString());
	}

	/**
	 * Returns the first tai khoan doi ung in the ordered set where loaiTaiKhoan = &#63; and hoatDong = &#63;.
	 *
	 * @param loaiTaiKhoan the loai tai khoan
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tai khoan doi ung, or <code>null</code> if a matching tai khoan doi ung could not be found
	 */
	@Override
	public TaiKhoanDoiUng fetchByLoaiTaiKhoan_HoatDong_First(
		int loaiTaiKhoan, Boolean hoatDong,
		OrderByComparator<TaiKhoanDoiUng> orderByComparator) {

		List<TaiKhoanDoiUng> list = findByLoaiTaiKhoan_HoatDong(
			loaiTaiKhoan, hoatDong, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tai khoan doi ung in the ordered set where loaiTaiKhoan = &#63; and hoatDong = &#63;.
	 *
	 * @param loaiTaiKhoan the loai tai khoan
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tai khoan doi ung
	 * @throws NoSuchTaiKhoanDoiUngException if a matching tai khoan doi ung could not be found
	 */
	@Override
	public TaiKhoanDoiUng findByLoaiTaiKhoan_HoatDong_Last(
			int loaiTaiKhoan, Boolean hoatDong,
			OrderByComparator<TaiKhoanDoiUng> orderByComparator)
		throws NoSuchTaiKhoanDoiUngException {

		TaiKhoanDoiUng taiKhoanDoiUng = fetchByLoaiTaiKhoan_HoatDong_Last(
			loaiTaiKhoan, hoatDong, orderByComparator);

		if (taiKhoanDoiUng != null) {
			return taiKhoanDoiUng;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("loaiTaiKhoan=");
		msg.append(loaiTaiKhoan);

		msg.append(", hoatDong=");
		msg.append(hoatDong);

		msg.append("}");

		throw new NoSuchTaiKhoanDoiUngException(msg.toString());
	}

	/**
	 * Returns the last tai khoan doi ung in the ordered set where loaiTaiKhoan = &#63; and hoatDong = &#63;.
	 *
	 * @param loaiTaiKhoan the loai tai khoan
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tai khoan doi ung, or <code>null</code> if a matching tai khoan doi ung could not be found
	 */
	@Override
	public TaiKhoanDoiUng fetchByLoaiTaiKhoan_HoatDong_Last(
		int loaiTaiKhoan, Boolean hoatDong,
		OrderByComparator<TaiKhoanDoiUng> orderByComparator) {

		int count = countByLoaiTaiKhoan_HoatDong(loaiTaiKhoan, hoatDong);

		if (count == 0) {
			return null;
		}

		List<TaiKhoanDoiUng> list = findByLoaiTaiKhoan_HoatDong(
			loaiTaiKhoan, hoatDong, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tai khoan doi ungs before and after the current tai khoan doi ung in the ordered set where loaiTaiKhoan = &#63; and hoatDong = &#63;.
	 *
	 * @param taiKhoanDoiUngId the primary key of the current tai khoan doi ung
	 * @param loaiTaiKhoan the loai tai khoan
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tai khoan doi ung
	 * @throws NoSuchTaiKhoanDoiUngException if a tai khoan doi ung with the primary key could not be found
	 */
	@Override
	public TaiKhoanDoiUng[] findByLoaiTaiKhoan_HoatDong_PrevAndNext(
			long taiKhoanDoiUngId, int loaiTaiKhoan, Boolean hoatDong,
			OrderByComparator<TaiKhoanDoiUng> orderByComparator)
		throws NoSuchTaiKhoanDoiUngException {

		TaiKhoanDoiUng taiKhoanDoiUng = findByPrimaryKey(taiKhoanDoiUngId);

		Session session = null;

		try {
			session = openSession();

			TaiKhoanDoiUng[] array = new TaiKhoanDoiUngImpl[3];

			array[0] = getByLoaiTaiKhoan_HoatDong_PrevAndNext(
				session, taiKhoanDoiUng, loaiTaiKhoan, hoatDong,
				orderByComparator, true);

			array[1] = taiKhoanDoiUng;

			array[2] = getByLoaiTaiKhoan_HoatDong_PrevAndNext(
				session, taiKhoanDoiUng, loaiTaiKhoan, hoatDong,
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

	protected TaiKhoanDoiUng getByLoaiTaiKhoan_HoatDong_PrevAndNext(
		Session session, TaiKhoanDoiUng taiKhoanDoiUng, int loaiTaiKhoan,
		Boolean hoatDong, OrderByComparator<TaiKhoanDoiUng> orderByComparator,
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

		query.append(_SQL_SELECT_TAIKHOANDOIUNG_WHERE);

		query.append(_FINDER_COLUMN_LOAITAIKHOAN_HOATDONG_LOAITAIKHOAN_2);

		query.append(_FINDER_COLUMN_LOAITAIKHOAN_HOATDONG_HOATDONG_2);

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
			query.append(TaiKhoanDoiUngModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(loaiTaiKhoan);

		qPos.add(hoatDong.booleanValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						taiKhoanDoiUng)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<TaiKhoanDoiUng> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tai khoan doi ungs where loaiTaiKhoan = &#63; and hoatDong = &#63; from the database.
	 *
	 * @param loaiTaiKhoan the loai tai khoan
	 * @param hoatDong the hoat dong
	 */
	@Override
	public void removeByLoaiTaiKhoan_HoatDong(
		int loaiTaiKhoan, Boolean hoatDong) {

		for (TaiKhoanDoiUng taiKhoanDoiUng :
				findByLoaiTaiKhoan_HoatDong(
					loaiTaiKhoan, hoatDong, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(taiKhoanDoiUng);
		}
	}

	/**
	 * Returns the number of tai khoan doi ungs where loaiTaiKhoan = &#63; and hoatDong = &#63;.
	 *
	 * @param loaiTaiKhoan the loai tai khoan
	 * @param hoatDong the hoat dong
	 * @return the number of matching tai khoan doi ungs
	 */
	@Override
	public int countByLoaiTaiKhoan_HoatDong(
		int loaiTaiKhoan, Boolean hoatDong) {

		FinderPath finderPath = _finderPathCountByLoaiTaiKhoan_HoatDong;

		Object[] finderArgs = new Object[] {loaiTaiKhoan, hoatDong};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TAIKHOANDOIUNG_WHERE);

			query.append(_FINDER_COLUMN_LOAITAIKHOAN_HOATDONG_LOAITAIKHOAN_2);

			query.append(_FINDER_COLUMN_LOAITAIKHOAN_HOATDONG_HOATDONG_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(loaiTaiKhoan);

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
		_FINDER_COLUMN_LOAITAIKHOAN_HOATDONG_LOAITAIKHOAN_2 =
			"taiKhoanDoiUng.loaiTaiKhoan = ? AND ";

	private static final String
		_FINDER_COLUMN_LOAITAIKHOAN_HOATDONG_HOATDONG_2 =
			"taiKhoanDoiUng.hoatDong = ?";

	private FinderPath
		_finderPathWithPaginationFindByTaiKhoanDoiUngChaId_HoatDong;
	private FinderPath
		_finderPathWithoutPaginationFindByTaiKhoanDoiUngChaId_HoatDong;
	private FinderPath _finderPathCountByTaiKhoanDoiUngChaId_HoatDong;

	/**
	 * Returns all the tai khoan doi ungs where taiKhoanDoiUngChaId = &#63; and hoatDong = &#63;.
	 *
	 * @param taiKhoanDoiUngChaId the tai khoan doi ung cha ID
	 * @param hoatDong the hoat dong
	 * @return the matching tai khoan doi ungs
	 */
	@Override
	public List<TaiKhoanDoiUng> findByTaiKhoanDoiUngChaId_HoatDong(
		long taiKhoanDoiUngChaId, Boolean hoatDong) {

		return findByTaiKhoanDoiUngChaId_HoatDong(
			taiKhoanDoiUngChaId, hoatDong, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the tai khoan doi ungs where taiKhoanDoiUngChaId = &#63; and hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaiKhoanDoiUngModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param taiKhoanDoiUngChaId the tai khoan doi ung cha ID
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of tai khoan doi ungs
	 * @param end the upper bound of the range of tai khoan doi ungs (not inclusive)
	 * @return the range of matching tai khoan doi ungs
	 */
	@Override
	public List<TaiKhoanDoiUng> findByTaiKhoanDoiUngChaId_HoatDong(
		long taiKhoanDoiUngChaId, Boolean hoatDong, int start, int end) {

		return findByTaiKhoanDoiUngChaId_HoatDong(
			taiKhoanDoiUngChaId, hoatDong, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tai khoan doi ungs where taiKhoanDoiUngChaId = &#63; and hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaiKhoanDoiUngModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param taiKhoanDoiUngChaId the tai khoan doi ung cha ID
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of tai khoan doi ungs
	 * @param end the upper bound of the range of tai khoan doi ungs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tai khoan doi ungs
	 */
	@Override
	public List<TaiKhoanDoiUng> findByTaiKhoanDoiUngChaId_HoatDong(
		long taiKhoanDoiUngChaId, Boolean hoatDong, int start, int end,
		OrderByComparator<TaiKhoanDoiUng> orderByComparator) {

		return findByTaiKhoanDoiUngChaId_HoatDong(
			taiKhoanDoiUngChaId, hoatDong, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tai khoan doi ungs where taiKhoanDoiUngChaId = &#63; and hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaiKhoanDoiUngModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param taiKhoanDoiUngChaId the tai khoan doi ung cha ID
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of tai khoan doi ungs
	 * @param end the upper bound of the range of tai khoan doi ungs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching tai khoan doi ungs
	 */
	@Override
	public List<TaiKhoanDoiUng> findByTaiKhoanDoiUngChaId_HoatDong(
		long taiKhoanDoiUngChaId, Boolean hoatDong, int start, int end,
		OrderByComparator<TaiKhoanDoiUng> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath =
				_finderPathWithoutPaginationFindByTaiKhoanDoiUngChaId_HoatDong;
			finderArgs = new Object[] {taiKhoanDoiUngChaId, hoatDong};
		}
		else {
			finderPath =
				_finderPathWithPaginationFindByTaiKhoanDoiUngChaId_HoatDong;
			finderArgs = new Object[] {
				taiKhoanDoiUngChaId, hoatDong, start, end, orderByComparator
			};
		}

		List<TaiKhoanDoiUng> list = null;

		if (retrieveFromCache) {
			list = (List<TaiKhoanDoiUng>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TaiKhoanDoiUng taiKhoanDoiUng : list) {
					if ((taiKhoanDoiUngChaId !=
							taiKhoanDoiUng.getTaiKhoanDoiUngChaId()) ||
						!Objects.equals(
							hoatDong, taiKhoanDoiUng.getHoatDong())) {

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

			query.append(_SQL_SELECT_TAIKHOANDOIUNG_WHERE);

			query.append(
				_FINDER_COLUMN_TAIKHOANDOIUNGCHAID_HOATDONG_TAIKHOANDOIUNGCHAID_2);

			query.append(
				_FINDER_COLUMN_TAIKHOANDOIUNGCHAID_HOATDONG_HOATDONG_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(TaiKhoanDoiUngModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(taiKhoanDoiUngChaId);

				qPos.add(hoatDong.booleanValue());

				if (!pagination) {
					list = (List<TaiKhoanDoiUng>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TaiKhoanDoiUng>)QueryUtil.list(
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
	 * Returns the first tai khoan doi ung in the ordered set where taiKhoanDoiUngChaId = &#63; and hoatDong = &#63;.
	 *
	 * @param taiKhoanDoiUngChaId the tai khoan doi ung cha ID
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tai khoan doi ung
	 * @throws NoSuchTaiKhoanDoiUngException if a matching tai khoan doi ung could not be found
	 */
	@Override
	public TaiKhoanDoiUng findByTaiKhoanDoiUngChaId_HoatDong_First(
			long taiKhoanDoiUngChaId, Boolean hoatDong,
			OrderByComparator<TaiKhoanDoiUng> orderByComparator)
		throws NoSuchTaiKhoanDoiUngException {

		TaiKhoanDoiUng taiKhoanDoiUng =
			fetchByTaiKhoanDoiUngChaId_HoatDong_First(
				taiKhoanDoiUngChaId, hoatDong, orderByComparator);

		if (taiKhoanDoiUng != null) {
			return taiKhoanDoiUng;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("taiKhoanDoiUngChaId=");
		msg.append(taiKhoanDoiUngChaId);

		msg.append(", hoatDong=");
		msg.append(hoatDong);

		msg.append("}");

		throw new NoSuchTaiKhoanDoiUngException(msg.toString());
	}

	/**
	 * Returns the first tai khoan doi ung in the ordered set where taiKhoanDoiUngChaId = &#63; and hoatDong = &#63;.
	 *
	 * @param taiKhoanDoiUngChaId the tai khoan doi ung cha ID
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tai khoan doi ung, or <code>null</code> if a matching tai khoan doi ung could not be found
	 */
	@Override
	public TaiKhoanDoiUng fetchByTaiKhoanDoiUngChaId_HoatDong_First(
		long taiKhoanDoiUngChaId, Boolean hoatDong,
		OrderByComparator<TaiKhoanDoiUng> orderByComparator) {

		List<TaiKhoanDoiUng> list = findByTaiKhoanDoiUngChaId_HoatDong(
			taiKhoanDoiUngChaId, hoatDong, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tai khoan doi ung in the ordered set where taiKhoanDoiUngChaId = &#63; and hoatDong = &#63;.
	 *
	 * @param taiKhoanDoiUngChaId the tai khoan doi ung cha ID
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tai khoan doi ung
	 * @throws NoSuchTaiKhoanDoiUngException if a matching tai khoan doi ung could not be found
	 */
	@Override
	public TaiKhoanDoiUng findByTaiKhoanDoiUngChaId_HoatDong_Last(
			long taiKhoanDoiUngChaId, Boolean hoatDong,
			OrderByComparator<TaiKhoanDoiUng> orderByComparator)
		throws NoSuchTaiKhoanDoiUngException {

		TaiKhoanDoiUng taiKhoanDoiUng =
			fetchByTaiKhoanDoiUngChaId_HoatDong_Last(
				taiKhoanDoiUngChaId, hoatDong, orderByComparator);

		if (taiKhoanDoiUng != null) {
			return taiKhoanDoiUng;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("taiKhoanDoiUngChaId=");
		msg.append(taiKhoanDoiUngChaId);

		msg.append(", hoatDong=");
		msg.append(hoatDong);

		msg.append("}");

		throw new NoSuchTaiKhoanDoiUngException(msg.toString());
	}

	/**
	 * Returns the last tai khoan doi ung in the ordered set where taiKhoanDoiUngChaId = &#63; and hoatDong = &#63;.
	 *
	 * @param taiKhoanDoiUngChaId the tai khoan doi ung cha ID
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tai khoan doi ung, or <code>null</code> if a matching tai khoan doi ung could not be found
	 */
	@Override
	public TaiKhoanDoiUng fetchByTaiKhoanDoiUngChaId_HoatDong_Last(
		long taiKhoanDoiUngChaId, Boolean hoatDong,
		OrderByComparator<TaiKhoanDoiUng> orderByComparator) {

		int count = countByTaiKhoanDoiUngChaId_HoatDong(
			taiKhoanDoiUngChaId, hoatDong);

		if (count == 0) {
			return null;
		}

		List<TaiKhoanDoiUng> list = findByTaiKhoanDoiUngChaId_HoatDong(
			taiKhoanDoiUngChaId, hoatDong, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tai khoan doi ungs before and after the current tai khoan doi ung in the ordered set where taiKhoanDoiUngChaId = &#63; and hoatDong = &#63;.
	 *
	 * @param taiKhoanDoiUngId the primary key of the current tai khoan doi ung
	 * @param taiKhoanDoiUngChaId the tai khoan doi ung cha ID
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tai khoan doi ung
	 * @throws NoSuchTaiKhoanDoiUngException if a tai khoan doi ung with the primary key could not be found
	 */
	@Override
	public TaiKhoanDoiUng[] findByTaiKhoanDoiUngChaId_HoatDong_PrevAndNext(
			long taiKhoanDoiUngId, long taiKhoanDoiUngChaId, Boolean hoatDong,
			OrderByComparator<TaiKhoanDoiUng> orderByComparator)
		throws NoSuchTaiKhoanDoiUngException {

		TaiKhoanDoiUng taiKhoanDoiUng = findByPrimaryKey(taiKhoanDoiUngId);

		Session session = null;

		try {
			session = openSession();

			TaiKhoanDoiUng[] array = new TaiKhoanDoiUngImpl[3];

			array[0] = getByTaiKhoanDoiUngChaId_HoatDong_PrevAndNext(
				session, taiKhoanDoiUng, taiKhoanDoiUngChaId, hoatDong,
				orderByComparator, true);

			array[1] = taiKhoanDoiUng;

			array[2] = getByTaiKhoanDoiUngChaId_HoatDong_PrevAndNext(
				session, taiKhoanDoiUng, taiKhoanDoiUngChaId, hoatDong,
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

	protected TaiKhoanDoiUng getByTaiKhoanDoiUngChaId_HoatDong_PrevAndNext(
		Session session, TaiKhoanDoiUng taiKhoanDoiUng,
		long taiKhoanDoiUngChaId, Boolean hoatDong,
		OrderByComparator<TaiKhoanDoiUng> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_TAIKHOANDOIUNG_WHERE);

		query.append(
			_FINDER_COLUMN_TAIKHOANDOIUNGCHAID_HOATDONG_TAIKHOANDOIUNGCHAID_2);

		query.append(_FINDER_COLUMN_TAIKHOANDOIUNGCHAID_HOATDONG_HOATDONG_2);

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
			query.append(TaiKhoanDoiUngModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(taiKhoanDoiUngChaId);

		qPos.add(hoatDong.booleanValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						taiKhoanDoiUng)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<TaiKhoanDoiUng> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tai khoan doi ungs where taiKhoanDoiUngChaId = &#63; and hoatDong = &#63; from the database.
	 *
	 * @param taiKhoanDoiUngChaId the tai khoan doi ung cha ID
	 * @param hoatDong the hoat dong
	 */
	@Override
	public void removeByTaiKhoanDoiUngChaId_HoatDong(
		long taiKhoanDoiUngChaId, Boolean hoatDong) {

		for (TaiKhoanDoiUng taiKhoanDoiUng :
				findByTaiKhoanDoiUngChaId_HoatDong(
					taiKhoanDoiUngChaId, hoatDong, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(taiKhoanDoiUng);
		}
	}

	/**
	 * Returns the number of tai khoan doi ungs where taiKhoanDoiUngChaId = &#63; and hoatDong = &#63;.
	 *
	 * @param taiKhoanDoiUngChaId the tai khoan doi ung cha ID
	 * @param hoatDong the hoat dong
	 * @return the number of matching tai khoan doi ungs
	 */
	@Override
	public int countByTaiKhoanDoiUngChaId_HoatDong(
		long taiKhoanDoiUngChaId, Boolean hoatDong) {

		FinderPath finderPath = _finderPathCountByTaiKhoanDoiUngChaId_HoatDong;

		Object[] finderArgs = new Object[] {taiKhoanDoiUngChaId, hoatDong};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TAIKHOANDOIUNG_WHERE);

			query.append(
				_FINDER_COLUMN_TAIKHOANDOIUNGCHAID_HOATDONG_TAIKHOANDOIUNGCHAID_2);

			query.append(
				_FINDER_COLUMN_TAIKHOANDOIUNGCHAID_HOATDONG_HOATDONG_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(taiKhoanDoiUngChaId);

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
		_FINDER_COLUMN_TAIKHOANDOIUNGCHAID_HOATDONG_TAIKHOANDOIUNGCHAID_2 =
			"taiKhoanDoiUng.taiKhoanDoiUngChaId = ? AND ";

	private static final String
		_FINDER_COLUMN_TAIKHOANDOIUNGCHAID_HOATDONG_HOATDONG_2 =
			"taiKhoanDoiUng.hoatDong = ?";

	public TaiKhoanDoiUngPersistenceImpl() {
		setModelClass(TaiKhoanDoiUng.class);
	}

	/**
	 * Caches the tai khoan doi ung in the entity cache if it is enabled.
	 *
	 * @param taiKhoanDoiUng the tai khoan doi ung
	 */
	@Override
	public void cacheResult(TaiKhoanDoiUng taiKhoanDoiUng) {
		entityCache.putResult(
			TaiKhoanDoiUngModelImpl.ENTITY_CACHE_ENABLED,
			TaiKhoanDoiUngImpl.class, taiKhoanDoiUng.getPrimaryKey(),
			taiKhoanDoiUng);

		finderCache.putResult(
			_finderPathFetchBySoHieu, new Object[] {taiKhoanDoiUng.getSoHieu()},
			taiKhoanDoiUng);

		taiKhoanDoiUng.resetOriginalValues();
	}

	/**
	 * Caches the tai khoan doi ungs in the entity cache if it is enabled.
	 *
	 * @param taiKhoanDoiUngs the tai khoan doi ungs
	 */
	@Override
	public void cacheResult(List<TaiKhoanDoiUng> taiKhoanDoiUngs) {
		for (TaiKhoanDoiUng taiKhoanDoiUng : taiKhoanDoiUngs) {
			if (entityCache.getResult(
					TaiKhoanDoiUngModelImpl.ENTITY_CACHE_ENABLED,
					TaiKhoanDoiUngImpl.class, taiKhoanDoiUng.getPrimaryKey()) ==
						null) {

				cacheResult(taiKhoanDoiUng);
			}
			else {
				taiKhoanDoiUng.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tai khoan doi ungs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TaiKhoanDoiUngImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tai khoan doi ung.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TaiKhoanDoiUng taiKhoanDoiUng) {
		entityCache.removeResult(
			TaiKhoanDoiUngModelImpl.ENTITY_CACHE_ENABLED,
			TaiKhoanDoiUngImpl.class, taiKhoanDoiUng.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((TaiKhoanDoiUngModelImpl)taiKhoanDoiUng, true);
	}

	@Override
	public void clearCache(List<TaiKhoanDoiUng> taiKhoanDoiUngs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TaiKhoanDoiUng taiKhoanDoiUng : taiKhoanDoiUngs) {
			entityCache.removeResult(
				TaiKhoanDoiUngModelImpl.ENTITY_CACHE_ENABLED,
				TaiKhoanDoiUngImpl.class, taiKhoanDoiUng.getPrimaryKey());

			clearUniqueFindersCache(
				(TaiKhoanDoiUngModelImpl)taiKhoanDoiUng, true);
		}
	}

	protected void cacheUniqueFindersCache(
		TaiKhoanDoiUngModelImpl taiKhoanDoiUngModelImpl) {

		Object[] args = new Object[] {taiKhoanDoiUngModelImpl.getSoHieu()};

		finderCache.putResult(
			_finderPathCountBySoHieu, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchBySoHieu, args, taiKhoanDoiUngModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		TaiKhoanDoiUngModelImpl taiKhoanDoiUngModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {taiKhoanDoiUngModelImpl.getSoHieu()};

			finderCache.removeResult(_finderPathCountBySoHieu, args);
			finderCache.removeResult(_finderPathFetchBySoHieu, args);
		}

		if ((taiKhoanDoiUngModelImpl.getColumnBitmask() &
			 _finderPathFetchBySoHieu.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				taiKhoanDoiUngModelImpl.getOriginalSoHieu()
			};

			finderCache.removeResult(_finderPathCountBySoHieu, args);
			finderCache.removeResult(_finderPathFetchBySoHieu, args);
		}
	}

	/**
	 * Creates a new tai khoan doi ung with the primary key. Does not add the tai khoan doi ung to the database.
	 *
	 * @param taiKhoanDoiUngId the primary key for the new tai khoan doi ung
	 * @return the new tai khoan doi ung
	 */
	@Override
	public TaiKhoanDoiUng create(long taiKhoanDoiUngId) {
		TaiKhoanDoiUng taiKhoanDoiUng = new TaiKhoanDoiUngImpl();

		taiKhoanDoiUng.setNew(true);
		taiKhoanDoiUng.setPrimaryKey(taiKhoanDoiUngId);

		taiKhoanDoiUng.setCompanyId(companyProvider.getCompanyId());

		return taiKhoanDoiUng;
	}

	/**
	 * Removes the tai khoan doi ung with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taiKhoanDoiUngId the primary key of the tai khoan doi ung
	 * @return the tai khoan doi ung that was removed
	 * @throws NoSuchTaiKhoanDoiUngException if a tai khoan doi ung with the primary key could not be found
	 */
	@Override
	public TaiKhoanDoiUng remove(long taiKhoanDoiUngId)
		throws NoSuchTaiKhoanDoiUngException {

		return remove((Serializable)taiKhoanDoiUngId);
	}

	/**
	 * Removes the tai khoan doi ung with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tai khoan doi ung
	 * @return the tai khoan doi ung that was removed
	 * @throws NoSuchTaiKhoanDoiUngException if a tai khoan doi ung with the primary key could not be found
	 */
	@Override
	public TaiKhoanDoiUng remove(Serializable primaryKey)
		throws NoSuchTaiKhoanDoiUngException {

		Session session = null;

		try {
			session = openSession();

			TaiKhoanDoiUng taiKhoanDoiUng = (TaiKhoanDoiUng)session.get(
				TaiKhoanDoiUngImpl.class, primaryKey);

			if (taiKhoanDoiUng == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTaiKhoanDoiUngException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(taiKhoanDoiUng);
		}
		catch (NoSuchTaiKhoanDoiUngException nsee) {
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
	protected TaiKhoanDoiUng removeImpl(TaiKhoanDoiUng taiKhoanDoiUng) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(taiKhoanDoiUng)) {
				taiKhoanDoiUng = (TaiKhoanDoiUng)session.get(
					TaiKhoanDoiUngImpl.class,
					taiKhoanDoiUng.getPrimaryKeyObj());
			}

			if (taiKhoanDoiUng != null) {
				session.delete(taiKhoanDoiUng);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (taiKhoanDoiUng != null) {
			clearCache(taiKhoanDoiUng);
		}

		return taiKhoanDoiUng;
	}

	@Override
	public TaiKhoanDoiUng updateImpl(TaiKhoanDoiUng taiKhoanDoiUng) {
		boolean isNew = taiKhoanDoiUng.isNew();

		if (!(taiKhoanDoiUng instanceof TaiKhoanDoiUngModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(taiKhoanDoiUng.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					taiKhoanDoiUng);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in taiKhoanDoiUng proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TaiKhoanDoiUng implementation " +
					taiKhoanDoiUng.getClass());
		}

		TaiKhoanDoiUngModelImpl taiKhoanDoiUngModelImpl =
			(TaiKhoanDoiUngModelImpl)taiKhoanDoiUng;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (taiKhoanDoiUng.getCreateDate() == null)) {
			if (serviceContext == null) {
				taiKhoanDoiUng.setCreateDate(now);
			}
			else {
				taiKhoanDoiUng.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!taiKhoanDoiUngModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				taiKhoanDoiUng.setModifiedDate(now);
			}
			else {
				taiKhoanDoiUng.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (taiKhoanDoiUng.isNew()) {
				session.save(taiKhoanDoiUng);

				taiKhoanDoiUng.setNew(false);
			}
			else {
				taiKhoanDoiUng = (TaiKhoanDoiUng)session.merge(taiKhoanDoiUng);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!TaiKhoanDoiUngModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				taiKhoanDoiUngModelImpl.getHoatDong()
			};

			finderCache.removeResult(_finderPathCountByHoatDong, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByHoatDong, args);

			args = new Object[] {
				taiKhoanDoiUngModelImpl.getLoaiTaiKhoan(),
				taiKhoanDoiUngModelImpl.getHoatDong()
			};

			finderCache.removeResult(
				_finderPathCountByLoaiTaiKhoan_HoatDong, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByLoaiTaiKhoan_HoatDong, args);

			args = new Object[] {
				taiKhoanDoiUngModelImpl.getTaiKhoanDoiUngChaId(),
				taiKhoanDoiUngModelImpl.getHoatDong()
			};

			finderCache.removeResult(
				_finderPathCountByTaiKhoanDoiUngChaId_HoatDong, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByTaiKhoanDoiUngChaId_HoatDong,
				args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((taiKhoanDoiUngModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByHoatDong.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					taiKhoanDoiUngModelImpl.getOriginalHoatDong()
				};

				finderCache.removeResult(_finderPathCountByHoatDong, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByHoatDong, args);

				args = new Object[] {taiKhoanDoiUngModelImpl.getHoatDong()};

				finderCache.removeResult(_finderPathCountByHoatDong, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByHoatDong, args);
			}

			if ((taiKhoanDoiUngModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByLoaiTaiKhoan_HoatDong.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					taiKhoanDoiUngModelImpl.getOriginalLoaiTaiKhoan(),
					taiKhoanDoiUngModelImpl.getOriginalHoatDong()
				};

				finderCache.removeResult(
					_finderPathCountByLoaiTaiKhoan_HoatDong, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByLoaiTaiKhoan_HoatDong,
					args);

				args = new Object[] {
					taiKhoanDoiUngModelImpl.getLoaiTaiKhoan(),
					taiKhoanDoiUngModelImpl.getHoatDong()
				};

				finderCache.removeResult(
					_finderPathCountByLoaiTaiKhoan_HoatDong, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByLoaiTaiKhoan_HoatDong,
					args);
			}

			if ((taiKhoanDoiUngModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByTaiKhoanDoiUngChaId_HoatDong.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					taiKhoanDoiUngModelImpl.getOriginalTaiKhoanDoiUngChaId(),
					taiKhoanDoiUngModelImpl.getOriginalHoatDong()
				};

				finderCache.removeResult(
					_finderPathCountByTaiKhoanDoiUngChaId_HoatDong, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTaiKhoanDoiUngChaId_HoatDong,
					args);

				args = new Object[] {
					taiKhoanDoiUngModelImpl.getTaiKhoanDoiUngChaId(),
					taiKhoanDoiUngModelImpl.getHoatDong()
				};

				finderCache.removeResult(
					_finderPathCountByTaiKhoanDoiUngChaId_HoatDong, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTaiKhoanDoiUngChaId_HoatDong,
					args);
			}
		}

		entityCache.putResult(
			TaiKhoanDoiUngModelImpl.ENTITY_CACHE_ENABLED,
			TaiKhoanDoiUngImpl.class, taiKhoanDoiUng.getPrimaryKey(),
			taiKhoanDoiUng, false);

		clearUniqueFindersCache(taiKhoanDoiUngModelImpl, false);
		cacheUniqueFindersCache(taiKhoanDoiUngModelImpl);

		taiKhoanDoiUng.resetOriginalValues();

		return taiKhoanDoiUng;
	}

	/**
	 * Returns the tai khoan doi ung with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tai khoan doi ung
	 * @return the tai khoan doi ung
	 * @throws NoSuchTaiKhoanDoiUngException if a tai khoan doi ung with the primary key could not be found
	 */
	@Override
	public TaiKhoanDoiUng findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTaiKhoanDoiUngException {

		TaiKhoanDoiUng taiKhoanDoiUng = fetchByPrimaryKey(primaryKey);

		if (taiKhoanDoiUng == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTaiKhoanDoiUngException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return taiKhoanDoiUng;
	}

	/**
	 * Returns the tai khoan doi ung with the primary key or throws a <code>NoSuchTaiKhoanDoiUngException</code> if it could not be found.
	 *
	 * @param taiKhoanDoiUngId the primary key of the tai khoan doi ung
	 * @return the tai khoan doi ung
	 * @throws NoSuchTaiKhoanDoiUngException if a tai khoan doi ung with the primary key could not be found
	 */
	@Override
	public TaiKhoanDoiUng findByPrimaryKey(long taiKhoanDoiUngId)
		throws NoSuchTaiKhoanDoiUngException {

		return findByPrimaryKey((Serializable)taiKhoanDoiUngId);
	}

	/**
	 * Returns the tai khoan doi ung with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tai khoan doi ung
	 * @return the tai khoan doi ung, or <code>null</code> if a tai khoan doi ung with the primary key could not be found
	 */
	@Override
	public TaiKhoanDoiUng fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			TaiKhoanDoiUngModelImpl.ENTITY_CACHE_ENABLED,
			TaiKhoanDoiUngImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		TaiKhoanDoiUng taiKhoanDoiUng = (TaiKhoanDoiUng)serializable;

		if (taiKhoanDoiUng == null) {
			Session session = null;

			try {
				session = openSession();

				taiKhoanDoiUng = (TaiKhoanDoiUng)session.get(
					TaiKhoanDoiUngImpl.class, primaryKey);

				if (taiKhoanDoiUng != null) {
					cacheResult(taiKhoanDoiUng);
				}
				else {
					entityCache.putResult(
						TaiKhoanDoiUngModelImpl.ENTITY_CACHE_ENABLED,
						TaiKhoanDoiUngImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					TaiKhoanDoiUngModelImpl.ENTITY_CACHE_ENABLED,
					TaiKhoanDoiUngImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return taiKhoanDoiUng;
	}

	/**
	 * Returns the tai khoan doi ung with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param taiKhoanDoiUngId the primary key of the tai khoan doi ung
	 * @return the tai khoan doi ung, or <code>null</code> if a tai khoan doi ung with the primary key could not be found
	 */
	@Override
	public TaiKhoanDoiUng fetchByPrimaryKey(long taiKhoanDoiUngId) {
		return fetchByPrimaryKey((Serializable)taiKhoanDoiUngId);
	}

	@Override
	public Map<Serializable, TaiKhoanDoiUng> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, TaiKhoanDoiUng> map =
			new HashMap<Serializable, TaiKhoanDoiUng>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			TaiKhoanDoiUng taiKhoanDoiUng = fetchByPrimaryKey(primaryKey);

			if (taiKhoanDoiUng != null) {
				map.put(primaryKey, taiKhoanDoiUng);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				TaiKhoanDoiUngModelImpl.ENTITY_CACHE_ENABLED,
				TaiKhoanDoiUngImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (TaiKhoanDoiUng)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_TAIKHOANDOIUNG_WHERE_PKS_IN);

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

			for (TaiKhoanDoiUng taiKhoanDoiUng :
					(List<TaiKhoanDoiUng>)q.list()) {

				map.put(taiKhoanDoiUng.getPrimaryKeyObj(), taiKhoanDoiUng);

				cacheResult(taiKhoanDoiUng);

				uncachedPrimaryKeys.remove(taiKhoanDoiUng.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					TaiKhoanDoiUngModelImpl.ENTITY_CACHE_ENABLED,
					TaiKhoanDoiUngImpl.class, primaryKey, nullModel);
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
	 * Returns all the tai khoan doi ungs.
	 *
	 * @return the tai khoan doi ungs
	 */
	@Override
	public List<TaiKhoanDoiUng> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tai khoan doi ungs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaiKhoanDoiUngModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tai khoan doi ungs
	 * @param end the upper bound of the range of tai khoan doi ungs (not inclusive)
	 * @return the range of tai khoan doi ungs
	 */
	@Override
	public List<TaiKhoanDoiUng> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the tai khoan doi ungs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaiKhoanDoiUngModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tai khoan doi ungs
	 * @param end the upper bound of the range of tai khoan doi ungs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tai khoan doi ungs
	 */
	@Override
	public List<TaiKhoanDoiUng> findAll(
		int start, int end,
		OrderByComparator<TaiKhoanDoiUng> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tai khoan doi ungs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaiKhoanDoiUngModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tai khoan doi ungs
	 * @param end the upper bound of the range of tai khoan doi ungs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of tai khoan doi ungs
	 */
	@Override
	public List<TaiKhoanDoiUng> findAll(
		int start, int end, OrderByComparator<TaiKhoanDoiUng> orderByComparator,
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

		List<TaiKhoanDoiUng> list = null;

		if (retrieveFromCache) {
			list = (List<TaiKhoanDoiUng>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TAIKHOANDOIUNG);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TAIKHOANDOIUNG;

				if (pagination) {
					sql = sql.concat(TaiKhoanDoiUngModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TaiKhoanDoiUng>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TaiKhoanDoiUng>)QueryUtil.list(
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
	 * Removes all the tai khoan doi ungs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TaiKhoanDoiUng taiKhoanDoiUng : findAll()) {
			remove(taiKhoanDoiUng);
		}
	}

	/**
	 * Returns the number of tai khoan doi ungs.
	 *
	 * @return the number of tai khoan doi ungs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TAIKHOANDOIUNG);

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
		return TaiKhoanDoiUngModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the tai khoan doi ung persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			TaiKhoanDoiUngModelImpl.ENTITY_CACHE_ENABLED,
			TaiKhoanDoiUngModelImpl.FINDER_CACHE_ENABLED,
			TaiKhoanDoiUngImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			TaiKhoanDoiUngModelImpl.ENTITY_CACHE_ENABLED,
			TaiKhoanDoiUngModelImpl.FINDER_CACHE_ENABLED,
			TaiKhoanDoiUngImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);

		_finderPathCountAll = new FinderPath(
			TaiKhoanDoiUngModelImpl.ENTITY_CACHE_ENABLED,
			TaiKhoanDoiUngModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchBySoHieu = new FinderPath(
			TaiKhoanDoiUngModelImpl.ENTITY_CACHE_ENABLED,
			TaiKhoanDoiUngModelImpl.FINDER_CACHE_ENABLED,
			TaiKhoanDoiUngImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchBySoHieu",
			new String[] {String.class.getName()},
			TaiKhoanDoiUngModelImpl.SOHIEU_COLUMN_BITMASK);

		_finderPathCountBySoHieu = new FinderPath(
			TaiKhoanDoiUngModelImpl.ENTITY_CACHE_ENABLED,
			TaiKhoanDoiUngModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySoHieu",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByHoatDong = new FinderPath(
			TaiKhoanDoiUngModelImpl.ENTITY_CACHE_ENABLED,
			TaiKhoanDoiUngModelImpl.FINDER_CACHE_ENABLED,
			TaiKhoanDoiUngImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByHoatDong",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByHoatDong = new FinderPath(
			TaiKhoanDoiUngModelImpl.ENTITY_CACHE_ENABLED,
			TaiKhoanDoiUngModelImpl.FINDER_CACHE_ENABLED,
			TaiKhoanDoiUngImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByHoatDong", new String[] {Boolean.class.getName()},
			TaiKhoanDoiUngModelImpl.HOATDONG_COLUMN_BITMASK |
			TaiKhoanDoiUngModelImpl.SOHIEU_COLUMN_BITMASK);

		_finderPathCountByHoatDong = new FinderPath(
			TaiKhoanDoiUngModelImpl.ENTITY_CACHE_ENABLED,
			TaiKhoanDoiUngModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByHoatDong",
			new String[] {Boolean.class.getName()});

		_finderPathWithPaginationFindByLoaiTaiKhoan_HoatDong = new FinderPath(
			TaiKhoanDoiUngModelImpl.ENTITY_CACHE_ENABLED,
			TaiKhoanDoiUngModelImpl.FINDER_CACHE_ENABLED,
			TaiKhoanDoiUngImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByLoaiTaiKhoan_HoatDong",
			new String[] {
				Integer.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByLoaiTaiKhoan_HoatDong =
			new FinderPath(
				TaiKhoanDoiUngModelImpl.ENTITY_CACHE_ENABLED,
				TaiKhoanDoiUngModelImpl.FINDER_CACHE_ENABLED,
				TaiKhoanDoiUngImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByLoaiTaiKhoan_HoatDong",
				new String[] {Integer.class.getName(), Boolean.class.getName()},
				TaiKhoanDoiUngModelImpl.LOAITAIKHOAN_COLUMN_BITMASK |
				TaiKhoanDoiUngModelImpl.HOATDONG_COLUMN_BITMASK |
				TaiKhoanDoiUngModelImpl.SOHIEU_COLUMN_BITMASK);

		_finderPathCountByLoaiTaiKhoan_HoatDong = new FinderPath(
			TaiKhoanDoiUngModelImpl.ENTITY_CACHE_ENABLED,
			TaiKhoanDoiUngModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByLoaiTaiKhoan_HoatDong",
			new String[] {Integer.class.getName(), Boolean.class.getName()});

		_finderPathWithPaginationFindByTaiKhoanDoiUngChaId_HoatDong =
			new FinderPath(
				TaiKhoanDoiUngModelImpl.ENTITY_CACHE_ENABLED,
				TaiKhoanDoiUngModelImpl.FINDER_CACHE_ENABLED,
				TaiKhoanDoiUngImpl.class,
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByTaiKhoanDoiUngChaId_HoatDong",
				new String[] {
					Long.class.getName(), Boolean.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				});

		_finderPathWithoutPaginationFindByTaiKhoanDoiUngChaId_HoatDong =
			new FinderPath(
				TaiKhoanDoiUngModelImpl.ENTITY_CACHE_ENABLED,
				TaiKhoanDoiUngModelImpl.FINDER_CACHE_ENABLED,
				TaiKhoanDoiUngImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByTaiKhoanDoiUngChaId_HoatDong",
				new String[] {Long.class.getName(), Boolean.class.getName()},
				TaiKhoanDoiUngModelImpl.TAIKHOANDOIUNGCHAID_COLUMN_BITMASK |
				TaiKhoanDoiUngModelImpl.HOATDONG_COLUMN_BITMASK |
				TaiKhoanDoiUngModelImpl.SOHIEU_COLUMN_BITMASK);

		_finderPathCountByTaiKhoanDoiUngChaId_HoatDong = new FinderPath(
			TaiKhoanDoiUngModelImpl.ENTITY_CACHE_ENABLED,
			TaiKhoanDoiUngModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTaiKhoanDoiUngChaId_HoatDong",
			new String[] {Long.class.getName(), Boolean.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(TaiKhoanDoiUngImpl.class.getName());
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

	private static final String _SQL_SELECT_TAIKHOANDOIUNG =
		"SELECT taiKhoanDoiUng FROM TaiKhoanDoiUng taiKhoanDoiUng";

	private static final String _SQL_SELECT_TAIKHOANDOIUNG_WHERE_PKS_IN =
		"SELECT taiKhoanDoiUng FROM TaiKhoanDoiUng taiKhoanDoiUng WHERE taiKhoanDoiUngId IN (";

	private static final String _SQL_SELECT_TAIKHOANDOIUNG_WHERE =
		"SELECT taiKhoanDoiUng FROM TaiKhoanDoiUng taiKhoanDoiUng WHERE ";

	private static final String _SQL_COUNT_TAIKHOANDOIUNG =
		"SELECT COUNT(taiKhoanDoiUng) FROM TaiKhoanDoiUng taiKhoanDoiUng";

	private static final String _SQL_COUNT_TAIKHOANDOIUNG_WHERE =
		"SELECT COUNT(taiKhoanDoiUng) FROM TaiKhoanDoiUng taiKhoanDoiUng WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "taiKhoanDoiUng.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TaiKhoanDoiUng exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TaiKhoanDoiUng exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TaiKhoanDoiUngPersistenceImpl.class);

}