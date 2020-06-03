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

import com.mb.exception.NoSuchKhachHangException;
import com.mb.model.KhachHang;
import com.mb.model.impl.KhachHangImpl;
import com.mb.model.impl.KhachHangModelImpl;
import com.mb.service.persistence.KhachHangPersistence;

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
 * The persistence implementation for the khach hang service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class KhachHangPersistenceImpl
	extends BasePersistenceImpl<KhachHang> implements KhachHangPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>KhachHangUtil</code> to access the khach hang persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		KhachHangImpl.class.getName();

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
	 * Returns the khach hang where ma = &#63; or throws a <code>NoSuchKhachHangException</code> if it could not be found.
	 *
	 * @param ma the ma
	 * @return the matching khach hang
	 * @throws NoSuchKhachHangException if a matching khach hang could not be found
	 */
	@Override
	public KhachHang findByMa(String ma) throws NoSuchKhachHangException {
		KhachHang khachHang = fetchByMa(ma);

		if (khachHang == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ma=");
			msg.append(ma);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchKhachHangException(msg.toString());
		}

		return khachHang;
	}

	/**
	 * Returns the khach hang where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ma the ma
	 * @return the matching khach hang, or <code>null</code> if a matching khach hang could not be found
	 */
	@Override
	public KhachHang fetchByMa(String ma) {
		return fetchByMa(ma, true);
	}

	/**
	 * Returns the khach hang where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ma the ma
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching khach hang, or <code>null</code> if a matching khach hang could not be found
	 */
	@Override
	public KhachHang fetchByMa(String ma, boolean retrieveFromCache) {
		ma = Objects.toString(ma, "");

		Object[] finderArgs = new Object[] {ma};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByMa, finderArgs, this);
		}

		if (result instanceof KhachHang) {
			KhachHang khachHang = (KhachHang)result;

			if (!Objects.equals(ma, khachHang.getMa())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_KHACHHANG_WHERE);

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

				List<KhachHang> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByMa, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"KhachHangPersistenceImpl.fetchByMa(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					KhachHang khachHang = list.get(0);

					result = khachHang;

					cacheResult(khachHang);
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
			return (KhachHang)result;
		}
	}

	/**
	 * Removes the khach hang where ma = &#63; from the database.
	 *
	 * @param ma the ma
	 * @return the khach hang that was removed
	 */
	@Override
	public KhachHang removeByMa(String ma) throws NoSuchKhachHangException {
		KhachHang khachHang = findByMa(ma);

		return remove(khachHang);
	}

	/**
	 * Returns the number of khach hangs where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the number of matching khach hangs
	 */
	@Override
	public int countByMa(String ma) {
		ma = Objects.toString(ma, "");

		FinderPath finderPath = _finderPathCountByMa;

		Object[] finderArgs = new Object[] {ma};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_KHACHHANG_WHERE);

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

	private static final String _FINDER_COLUMN_MA_MA_2 = "khachHang.ma = ?";

	private static final String _FINDER_COLUMN_MA_MA_3 =
		"(khachHang.ma IS NULL OR khachHang.ma = '')";

	private FinderPath _finderPathWithPaginationFindByMaCTV;
	private FinderPath _finderPathWithoutPaginationFindByMaCTV;
	private FinderPath _finderPathCountByMaCTV;

	/**
	 * Returns all the khach hangs where maCTV = &#63;.
	 *
	 * @param maCTV the ma ctv
	 * @return the matching khach hangs
	 */
	@Override
	public List<KhachHang> findByMaCTV(String maCTV) {
		return findByMaCTV(maCTV, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the khach hangs where maCTV = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>KhachHangModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param maCTV the ma ctv
	 * @param start the lower bound of the range of khach hangs
	 * @param end the upper bound of the range of khach hangs (not inclusive)
	 * @return the range of matching khach hangs
	 */
	@Override
	public List<KhachHang> findByMaCTV(String maCTV, int start, int end) {
		return findByMaCTV(maCTV, start, end, null);
	}

	/**
	 * Returns an ordered range of all the khach hangs where maCTV = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>KhachHangModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param maCTV the ma ctv
	 * @param start the lower bound of the range of khach hangs
	 * @param end the upper bound of the range of khach hangs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching khach hangs
	 */
	@Override
	public List<KhachHang> findByMaCTV(
		String maCTV, int start, int end,
		OrderByComparator<KhachHang> orderByComparator) {

		return findByMaCTV(maCTV, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the khach hangs where maCTV = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>KhachHangModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param maCTV the ma ctv
	 * @param start the lower bound of the range of khach hangs
	 * @param end the upper bound of the range of khach hangs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching khach hangs
	 */
	@Override
	public List<KhachHang> findByMaCTV(
		String maCTV, int start, int end,
		OrderByComparator<KhachHang> orderByComparator,
		boolean retrieveFromCache) {

		maCTV = Objects.toString(maCTV, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByMaCTV;
			finderArgs = new Object[] {maCTV};
		}
		else {
			finderPath = _finderPathWithPaginationFindByMaCTV;
			finderArgs = new Object[] {maCTV, start, end, orderByComparator};
		}

		List<KhachHang> list = null;

		if (retrieveFromCache) {
			list = (List<KhachHang>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (KhachHang khachHang : list) {
					if (!maCTV.equals(khachHang.getMaCTV())) {
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

			query.append(_SQL_SELECT_KHACHHANG_WHERE);

			boolean bindMaCTV = false;

			if (maCTV.isEmpty()) {
				query.append(_FINDER_COLUMN_MACTV_MACTV_3);
			}
			else {
				bindMaCTV = true;

				query.append(_FINDER_COLUMN_MACTV_MACTV_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(KhachHangModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindMaCTV) {
					qPos.add(maCTV);
				}

				if (!pagination) {
					list = (List<KhachHang>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<KhachHang>)QueryUtil.list(
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
	 * Returns the first khach hang in the ordered set where maCTV = &#63;.
	 *
	 * @param maCTV the ma ctv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching khach hang
	 * @throws NoSuchKhachHangException if a matching khach hang could not be found
	 */
	@Override
	public KhachHang findByMaCTV_First(
			String maCTV, OrderByComparator<KhachHang> orderByComparator)
		throws NoSuchKhachHangException {

		KhachHang khachHang = fetchByMaCTV_First(maCTV, orderByComparator);

		if (khachHang != null) {
			return khachHang;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("maCTV=");
		msg.append(maCTV);

		msg.append("}");

		throw new NoSuchKhachHangException(msg.toString());
	}

	/**
	 * Returns the first khach hang in the ordered set where maCTV = &#63;.
	 *
	 * @param maCTV the ma ctv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching khach hang, or <code>null</code> if a matching khach hang could not be found
	 */
	@Override
	public KhachHang fetchByMaCTV_First(
		String maCTV, OrderByComparator<KhachHang> orderByComparator) {

		List<KhachHang> list = findByMaCTV(maCTV, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last khach hang in the ordered set where maCTV = &#63;.
	 *
	 * @param maCTV the ma ctv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching khach hang
	 * @throws NoSuchKhachHangException if a matching khach hang could not be found
	 */
	@Override
	public KhachHang findByMaCTV_Last(
			String maCTV, OrderByComparator<KhachHang> orderByComparator)
		throws NoSuchKhachHangException {

		KhachHang khachHang = fetchByMaCTV_Last(maCTV, orderByComparator);

		if (khachHang != null) {
			return khachHang;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("maCTV=");
		msg.append(maCTV);

		msg.append("}");

		throw new NoSuchKhachHangException(msg.toString());
	}

	/**
	 * Returns the last khach hang in the ordered set where maCTV = &#63;.
	 *
	 * @param maCTV the ma ctv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching khach hang, or <code>null</code> if a matching khach hang could not be found
	 */
	@Override
	public KhachHang fetchByMaCTV_Last(
		String maCTV, OrderByComparator<KhachHang> orderByComparator) {

		int count = countByMaCTV(maCTV);

		if (count == 0) {
			return null;
		}

		List<KhachHang> list = findByMaCTV(
			maCTV, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the khach hangs before and after the current khach hang in the ordered set where maCTV = &#63;.
	 *
	 * @param khachHangId the primary key of the current khach hang
	 * @param maCTV the ma ctv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next khach hang
	 * @throws NoSuchKhachHangException if a khach hang with the primary key could not be found
	 */
	@Override
	public KhachHang[] findByMaCTV_PrevAndNext(
			long khachHangId, String maCTV,
			OrderByComparator<KhachHang> orderByComparator)
		throws NoSuchKhachHangException {

		maCTV = Objects.toString(maCTV, "");

		KhachHang khachHang = findByPrimaryKey(khachHangId);

		Session session = null;

		try {
			session = openSession();

			KhachHang[] array = new KhachHangImpl[3];

			array[0] = getByMaCTV_PrevAndNext(
				session, khachHang, maCTV, orderByComparator, true);

			array[1] = khachHang;

			array[2] = getByMaCTV_PrevAndNext(
				session, khachHang, maCTV, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected KhachHang getByMaCTV_PrevAndNext(
		Session session, KhachHang khachHang, String maCTV,
		OrderByComparator<KhachHang> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_KHACHHANG_WHERE);

		boolean bindMaCTV = false;

		if (maCTV.isEmpty()) {
			query.append(_FINDER_COLUMN_MACTV_MACTV_3);
		}
		else {
			bindMaCTV = true;

			query.append(_FINDER_COLUMN_MACTV_MACTV_2);
		}

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
			query.append(KhachHangModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindMaCTV) {
			qPos.add(maCTV);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(khachHang)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<KhachHang> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the khach hangs where maCTV = &#63; from the database.
	 *
	 * @param maCTV the ma ctv
	 */
	@Override
	public void removeByMaCTV(String maCTV) {
		for (KhachHang khachHang :
				findByMaCTV(
					maCTV, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(khachHang);
		}
	}

	/**
	 * Returns the number of khach hangs where maCTV = &#63;.
	 *
	 * @param maCTV the ma ctv
	 * @return the number of matching khach hangs
	 */
	@Override
	public int countByMaCTV(String maCTV) {
		maCTV = Objects.toString(maCTV, "");

		FinderPath finderPath = _finderPathCountByMaCTV;

		Object[] finderArgs = new Object[] {maCTV};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_KHACHHANG_WHERE);

			boolean bindMaCTV = false;

			if (maCTV.isEmpty()) {
				query.append(_FINDER_COLUMN_MACTV_MACTV_3);
			}
			else {
				bindMaCTV = true;

				query.append(_FINDER_COLUMN_MACTV_MACTV_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindMaCTV) {
					qPos.add(maCTV);
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

	private static final String _FINDER_COLUMN_MACTV_MACTV_2 =
		"khachHang.maCTV = ?";

	private static final String _FINDER_COLUMN_MACTV_MACTV_3 =
		"(khachHang.maCTV IS NULL OR khachHang.maCTV = '')";

	private FinderPath _finderPathFetchBySoCMND;
	private FinderPath _finderPathCountBySoCMND;

	/**
	 * Returns the khach hang where soCMND = &#63; or throws a <code>NoSuchKhachHangException</code> if it could not be found.
	 *
	 * @param soCMND the so cmnd
	 * @return the matching khach hang
	 * @throws NoSuchKhachHangException if a matching khach hang could not be found
	 */
	@Override
	public KhachHang findBySoCMND(String soCMND)
		throws NoSuchKhachHangException {

		KhachHang khachHang = fetchBySoCMND(soCMND);

		if (khachHang == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("soCMND=");
			msg.append(soCMND);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchKhachHangException(msg.toString());
		}

		return khachHang;
	}

	/**
	 * Returns the khach hang where soCMND = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param soCMND the so cmnd
	 * @return the matching khach hang, or <code>null</code> if a matching khach hang could not be found
	 */
	@Override
	public KhachHang fetchBySoCMND(String soCMND) {
		return fetchBySoCMND(soCMND, true);
	}

	/**
	 * Returns the khach hang where soCMND = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param soCMND the so cmnd
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching khach hang, or <code>null</code> if a matching khach hang could not be found
	 */
	@Override
	public KhachHang fetchBySoCMND(String soCMND, boolean retrieveFromCache) {
		soCMND = Objects.toString(soCMND, "");

		Object[] finderArgs = new Object[] {soCMND};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchBySoCMND, finderArgs, this);
		}

		if (result instanceof KhachHang) {
			KhachHang khachHang = (KhachHang)result;

			if (!Objects.equals(soCMND, khachHang.getSoCMND())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_KHACHHANG_WHERE);

			boolean bindSoCMND = false;

			if (soCMND.isEmpty()) {
				query.append(_FINDER_COLUMN_SOCMND_SOCMND_3);
			}
			else {
				bindSoCMND = true;

				query.append(_FINDER_COLUMN_SOCMND_SOCMND_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindSoCMND) {
					qPos.add(soCMND);
				}

				List<KhachHang> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchBySoCMND, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"KhachHangPersistenceImpl.fetchBySoCMND(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					KhachHang khachHang = list.get(0);

					result = khachHang;

					cacheResult(khachHang);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(_finderPathFetchBySoCMND, finderArgs);

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
			return (KhachHang)result;
		}
	}

	/**
	 * Removes the khach hang where soCMND = &#63; from the database.
	 *
	 * @param soCMND the so cmnd
	 * @return the khach hang that was removed
	 */
	@Override
	public KhachHang removeBySoCMND(String soCMND)
		throws NoSuchKhachHangException {

		KhachHang khachHang = findBySoCMND(soCMND);

		return remove(khachHang);
	}

	/**
	 * Returns the number of khach hangs where soCMND = &#63;.
	 *
	 * @param soCMND the so cmnd
	 * @return the number of matching khach hangs
	 */
	@Override
	public int countBySoCMND(String soCMND) {
		soCMND = Objects.toString(soCMND, "");

		FinderPath finderPath = _finderPathCountBySoCMND;

		Object[] finderArgs = new Object[] {soCMND};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_KHACHHANG_WHERE);

			boolean bindSoCMND = false;

			if (soCMND.isEmpty()) {
				query.append(_FINDER_COLUMN_SOCMND_SOCMND_3);
			}
			else {
				bindSoCMND = true;

				query.append(_FINDER_COLUMN_SOCMND_SOCMND_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindSoCMND) {
					qPos.add(soCMND);
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

	private static final String _FINDER_COLUMN_SOCMND_SOCMND_2 =
		"khachHang.soCMND = ?";

	private static final String _FINDER_COLUMN_SOCMND_SOCMND_3 =
		"(khachHang.soCMND IS NULL OR khachHang.soCMND = '')";

	public KhachHangPersistenceImpl() {
		setModelClass(KhachHang.class);
	}

	/**
	 * Caches the khach hang in the entity cache if it is enabled.
	 *
	 * @param khachHang the khach hang
	 */
	@Override
	public void cacheResult(KhachHang khachHang) {
		entityCache.putResult(
			KhachHangModelImpl.ENTITY_CACHE_ENABLED, KhachHangImpl.class,
			khachHang.getPrimaryKey(), khachHang);

		finderCache.putResult(
			_finderPathFetchByMa, new Object[] {khachHang.getMa()}, khachHang);

		finderCache.putResult(
			_finderPathFetchBySoCMND, new Object[] {khachHang.getSoCMND()},
			khachHang);

		khachHang.resetOriginalValues();
	}

	/**
	 * Caches the khach hangs in the entity cache if it is enabled.
	 *
	 * @param khachHangs the khach hangs
	 */
	@Override
	public void cacheResult(List<KhachHang> khachHangs) {
		for (KhachHang khachHang : khachHangs) {
			if (entityCache.getResult(
					KhachHangModelImpl.ENTITY_CACHE_ENABLED,
					KhachHangImpl.class, khachHang.getPrimaryKey()) == null) {

				cacheResult(khachHang);
			}
			else {
				khachHang.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all khach hangs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(KhachHangImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the khach hang.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(KhachHang khachHang) {
		entityCache.removeResult(
			KhachHangModelImpl.ENTITY_CACHE_ENABLED, KhachHangImpl.class,
			khachHang.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((KhachHangModelImpl)khachHang, true);
	}

	@Override
	public void clearCache(List<KhachHang> khachHangs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (KhachHang khachHang : khachHangs) {
			entityCache.removeResult(
				KhachHangModelImpl.ENTITY_CACHE_ENABLED, KhachHangImpl.class,
				khachHang.getPrimaryKey());

			clearUniqueFindersCache((KhachHangModelImpl)khachHang, true);
		}
	}

	protected void cacheUniqueFindersCache(
		KhachHangModelImpl khachHangModelImpl) {

		Object[] args = new Object[] {khachHangModelImpl.getMa()};

		finderCache.putResult(
			_finderPathCountByMa, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByMa, args, khachHangModelImpl, false);

		args = new Object[] {khachHangModelImpl.getSoCMND()};

		finderCache.putResult(
			_finderPathCountBySoCMND, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchBySoCMND, args, khachHangModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		KhachHangModelImpl khachHangModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {khachHangModelImpl.getMa()};

			finderCache.removeResult(_finderPathCountByMa, args);
			finderCache.removeResult(_finderPathFetchByMa, args);
		}

		if ((khachHangModelImpl.getColumnBitmask() &
			 _finderPathFetchByMa.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {khachHangModelImpl.getOriginalMa()};

			finderCache.removeResult(_finderPathCountByMa, args);
			finderCache.removeResult(_finderPathFetchByMa, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {khachHangModelImpl.getSoCMND()};

			finderCache.removeResult(_finderPathCountBySoCMND, args);
			finderCache.removeResult(_finderPathFetchBySoCMND, args);
		}

		if ((khachHangModelImpl.getColumnBitmask() &
			 _finderPathFetchBySoCMND.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				khachHangModelImpl.getOriginalSoCMND()
			};

			finderCache.removeResult(_finderPathCountBySoCMND, args);
			finderCache.removeResult(_finderPathFetchBySoCMND, args);
		}
	}

	/**
	 * Creates a new khach hang with the primary key. Does not add the khach hang to the database.
	 *
	 * @param khachHangId the primary key for the new khach hang
	 * @return the new khach hang
	 */
	@Override
	public KhachHang create(long khachHangId) {
		KhachHang khachHang = new KhachHangImpl();

		khachHang.setNew(true);
		khachHang.setPrimaryKey(khachHangId);

		khachHang.setCompanyId(companyProvider.getCompanyId());

		return khachHang;
	}

	/**
	 * Removes the khach hang with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param khachHangId the primary key of the khach hang
	 * @return the khach hang that was removed
	 * @throws NoSuchKhachHangException if a khach hang with the primary key could not be found
	 */
	@Override
	public KhachHang remove(long khachHangId) throws NoSuchKhachHangException {
		return remove((Serializable)khachHangId);
	}

	/**
	 * Removes the khach hang with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the khach hang
	 * @return the khach hang that was removed
	 * @throws NoSuchKhachHangException if a khach hang with the primary key could not be found
	 */
	@Override
	public KhachHang remove(Serializable primaryKey)
		throws NoSuchKhachHangException {

		Session session = null;

		try {
			session = openSession();

			KhachHang khachHang = (KhachHang)session.get(
				KhachHangImpl.class, primaryKey);

			if (khachHang == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchKhachHangException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(khachHang);
		}
		catch (NoSuchKhachHangException nsee) {
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
	protected KhachHang removeImpl(KhachHang khachHang) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(khachHang)) {
				khachHang = (KhachHang)session.get(
					KhachHangImpl.class, khachHang.getPrimaryKeyObj());
			}

			if (khachHang != null) {
				session.delete(khachHang);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (khachHang != null) {
			clearCache(khachHang);
		}

		return khachHang;
	}

	@Override
	public KhachHang updateImpl(KhachHang khachHang) {
		boolean isNew = khachHang.isNew();

		if (!(khachHang instanceof KhachHangModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(khachHang.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(khachHang);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in khachHang proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom KhachHang implementation " +
					khachHang.getClass());
		}

		KhachHangModelImpl khachHangModelImpl = (KhachHangModelImpl)khachHang;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (khachHang.getCreateDate() == null)) {
			if (serviceContext == null) {
				khachHang.setCreateDate(now);
			}
			else {
				khachHang.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!khachHangModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				khachHang.setModifiedDate(now);
			}
			else {
				khachHang.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (khachHang.isNew()) {
				session.save(khachHang);

				khachHang.setNew(false);
			}
			else {
				khachHang = (KhachHang)session.merge(khachHang);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!KhachHangModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {khachHangModelImpl.getMaCTV()};

			finderCache.removeResult(_finderPathCountByMaCTV, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByMaCTV, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((khachHangModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByMaCTV.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					khachHangModelImpl.getOriginalMaCTV()
				};

				finderCache.removeResult(_finderPathCountByMaCTV, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByMaCTV, args);

				args = new Object[] {khachHangModelImpl.getMaCTV()};

				finderCache.removeResult(_finderPathCountByMaCTV, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByMaCTV, args);
			}
		}

		entityCache.putResult(
			KhachHangModelImpl.ENTITY_CACHE_ENABLED, KhachHangImpl.class,
			khachHang.getPrimaryKey(), khachHang, false);

		clearUniqueFindersCache(khachHangModelImpl, false);
		cacheUniqueFindersCache(khachHangModelImpl);

		khachHang.resetOriginalValues();

		return khachHang;
	}

	/**
	 * Returns the khach hang with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the khach hang
	 * @return the khach hang
	 * @throws NoSuchKhachHangException if a khach hang with the primary key could not be found
	 */
	@Override
	public KhachHang findByPrimaryKey(Serializable primaryKey)
		throws NoSuchKhachHangException {

		KhachHang khachHang = fetchByPrimaryKey(primaryKey);

		if (khachHang == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchKhachHangException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return khachHang;
	}

	/**
	 * Returns the khach hang with the primary key or throws a <code>NoSuchKhachHangException</code> if it could not be found.
	 *
	 * @param khachHangId the primary key of the khach hang
	 * @return the khach hang
	 * @throws NoSuchKhachHangException if a khach hang with the primary key could not be found
	 */
	@Override
	public KhachHang findByPrimaryKey(long khachHangId)
		throws NoSuchKhachHangException {

		return findByPrimaryKey((Serializable)khachHangId);
	}

	/**
	 * Returns the khach hang with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the khach hang
	 * @return the khach hang, or <code>null</code> if a khach hang with the primary key could not be found
	 */
	@Override
	public KhachHang fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			KhachHangModelImpl.ENTITY_CACHE_ENABLED, KhachHangImpl.class,
			primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		KhachHang khachHang = (KhachHang)serializable;

		if (khachHang == null) {
			Session session = null;

			try {
				session = openSession();

				khachHang = (KhachHang)session.get(
					KhachHangImpl.class, primaryKey);

				if (khachHang != null) {
					cacheResult(khachHang);
				}
				else {
					entityCache.putResult(
						KhachHangModelImpl.ENTITY_CACHE_ENABLED,
						KhachHangImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					KhachHangModelImpl.ENTITY_CACHE_ENABLED,
					KhachHangImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return khachHang;
	}

	/**
	 * Returns the khach hang with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param khachHangId the primary key of the khach hang
	 * @return the khach hang, or <code>null</code> if a khach hang with the primary key could not be found
	 */
	@Override
	public KhachHang fetchByPrimaryKey(long khachHangId) {
		return fetchByPrimaryKey((Serializable)khachHangId);
	}

	@Override
	public Map<Serializable, KhachHang> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, KhachHang> map =
			new HashMap<Serializable, KhachHang>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			KhachHang khachHang = fetchByPrimaryKey(primaryKey);

			if (khachHang != null) {
				map.put(primaryKey, khachHang);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				KhachHangModelImpl.ENTITY_CACHE_ENABLED, KhachHangImpl.class,
				primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (KhachHang)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_KHACHHANG_WHERE_PKS_IN);

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

			for (KhachHang khachHang : (List<KhachHang>)q.list()) {
				map.put(khachHang.getPrimaryKeyObj(), khachHang);

				cacheResult(khachHang);

				uncachedPrimaryKeys.remove(khachHang.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					KhachHangModelImpl.ENTITY_CACHE_ENABLED,
					KhachHangImpl.class, primaryKey, nullModel);
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
	 * Returns all the khach hangs.
	 *
	 * @return the khach hangs
	 */
	@Override
	public List<KhachHang> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the khach hangs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>KhachHangModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of khach hangs
	 * @param end the upper bound of the range of khach hangs (not inclusive)
	 * @return the range of khach hangs
	 */
	@Override
	public List<KhachHang> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the khach hangs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>KhachHangModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of khach hangs
	 * @param end the upper bound of the range of khach hangs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of khach hangs
	 */
	@Override
	public List<KhachHang> findAll(
		int start, int end, OrderByComparator<KhachHang> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the khach hangs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>KhachHangModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of khach hangs
	 * @param end the upper bound of the range of khach hangs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of khach hangs
	 */
	@Override
	public List<KhachHang> findAll(
		int start, int end, OrderByComparator<KhachHang> orderByComparator,
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

		List<KhachHang> list = null;

		if (retrieveFromCache) {
			list = (List<KhachHang>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_KHACHHANG);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_KHACHHANG;

				if (pagination) {
					sql = sql.concat(KhachHangModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<KhachHang>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<KhachHang>)QueryUtil.list(
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
	 * Removes all the khach hangs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (KhachHang khachHang : findAll()) {
			remove(khachHang);
		}
	}

	/**
	 * Returns the number of khach hangs.
	 *
	 * @return the number of khach hangs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_KHACHHANG);

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
		return KhachHangModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the khach hang persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			KhachHangModelImpl.ENTITY_CACHE_ENABLED,
			KhachHangModelImpl.FINDER_CACHE_ENABLED, KhachHangImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			KhachHangModelImpl.ENTITY_CACHE_ENABLED,
			KhachHangModelImpl.FINDER_CACHE_ENABLED, KhachHangImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			KhachHangModelImpl.ENTITY_CACHE_ENABLED,
			KhachHangModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByMa = new FinderPath(
			KhachHangModelImpl.ENTITY_CACHE_ENABLED,
			KhachHangModelImpl.FINDER_CACHE_ENABLED, KhachHangImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByMa",
			new String[] {String.class.getName()},
			KhachHangModelImpl.MA_COLUMN_BITMASK);

		_finderPathCountByMa = new FinderPath(
			KhachHangModelImpl.ENTITY_CACHE_ENABLED,
			KhachHangModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMa",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByMaCTV = new FinderPath(
			KhachHangModelImpl.ENTITY_CACHE_ENABLED,
			KhachHangModelImpl.FINDER_CACHE_ENABLED, KhachHangImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMaCTV",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByMaCTV = new FinderPath(
			KhachHangModelImpl.ENTITY_CACHE_ENABLED,
			KhachHangModelImpl.FINDER_CACHE_ENABLED, KhachHangImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMaCTV",
			new String[] {String.class.getName()},
			KhachHangModelImpl.MACTV_COLUMN_BITMASK);

		_finderPathCountByMaCTV = new FinderPath(
			KhachHangModelImpl.ENTITY_CACHE_ENABLED,
			KhachHangModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMaCTV",
			new String[] {String.class.getName()});

		_finderPathFetchBySoCMND = new FinderPath(
			KhachHangModelImpl.ENTITY_CACHE_ENABLED,
			KhachHangModelImpl.FINDER_CACHE_ENABLED, KhachHangImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBySoCMND",
			new String[] {String.class.getName()},
			KhachHangModelImpl.SOCMND_COLUMN_BITMASK);

		_finderPathCountBySoCMND = new FinderPath(
			KhachHangModelImpl.ENTITY_CACHE_ENABLED,
			KhachHangModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySoCMND",
			new String[] {String.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(KhachHangImpl.class.getName());
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

	private static final String _SQL_SELECT_KHACHHANG =
		"SELECT khachHang FROM KhachHang khachHang";

	private static final String _SQL_SELECT_KHACHHANG_WHERE_PKS_IN =
		"SELECT khachHang FROM KhachHang khachHang WHERE khachHangId IN (";

	private static final String _SQL_SELECT_KHACHHANG_WHERE =
		"SELECT khachHang FROM KhachHang khachHang WHERE ";

	private static final String _SQL_COUNT_KHACHHANG =
		"SELECT COUNT(khachHang) FROM KhachHang khachHang";

	private static final String _SQL_COUNT_KHACHHANG_WHERE =
		"SELECT COUNT(khachHang) FROM KhachHang khachHang WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "khachHang.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No KhachHang exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No KhachHang exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		KhachHangPersistenceImpl.class);

}