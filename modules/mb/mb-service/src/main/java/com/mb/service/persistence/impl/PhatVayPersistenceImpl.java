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

import com.mb.exception.NoSuchPhatVayException;
import com.mb.model.PhatVay;
import com.mb.model.impl.PhatVayImpl;
import com.mb.model.impl.PhatVayModelImpl;
import com.mb.service.persistence.PhatVayPersistence;

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
 * The persistence implementation for the phat vay service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class PhatVayPersistenceImpl
	extends BasePersistenceImpl<PhatVay> implements PhatVayPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PhatVayUtil</code> to access the phat vay persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PhatVayImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByMaCTV;
	private FinderPath _finderPathWithoutPaginationFindByMaCTV;
	private FinderPath _finderPathCountByMaCTV;

	/**
	 * Returns all the phat vaies where maCTV = &#63;.
	 *
	 * @param maCTV the ma ctv
	 * @return the matching phat vaies
	 */
	@Override
	public List<PhatVay> findByMaCTV(String maCTV) {
		return findByMaCTV(maCTV, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the phat vaies where maCTV = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PhatVayModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param maCTV the ma ctv
	 * @param start the lower bound of the range of phat vaies
	 * @param end the upper bound of the range of phat vaies (not inclusive)
	 * @return the range of matching phat vaies
	 */
	@Override
	public List<PhatVay> findByMaCTV(String maCTV, int start, int end) {
		return findByMaCTV(maCTV, start, end, null);
	}

	/**
	 * Returns an ordered range of all the phat vaies where maCTV = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PhatVayModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param maCTV the ma ctv
	 * @param start the lower bound of the range of phat vaies
	 * @param end the upper bound of the range of phat vaies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching phat vaies
	 */
	@Override
	public List<PhatVay> findByMaCTV(
		String maCTV, int start, int end,
		OrderByComparator<PhatVay> orderByComparator) {

		return findByMaCTV(maCTV, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the phat vaies where maCTV = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PhatVayModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param maCTV the ma ctv
	 * @param start the lower bound of the range of phat vaies
	 * @param end the upper bound of the range of phat vaies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching phat vaies
	 */
	@Override
	public List<PhatVay> findByMaCTV(
		String maCTV, int start, int end,
		OrderByComparator<PhatVay> orderByComparator,
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

		List<PhatVay> list = null;

		if (retrieveFromCache) {
			list = (List<PhatVay>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PhatVay phatVay : list) {
					if (!maCTV.equals(phatVay.getMaCTV())) {
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

			query.append(_SQL_SELECT_PHATVAY_WHERE);

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
				query.append(PhatVayModelImpl.ORDER_BY_JPQL);
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
					list = (List<PhatVay>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PhatVay>)QueryUtil.list(
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
	 * Returns the first phat vay in the ordered set where maCTV = &#63;.
	 *
	 * @param maCTV the ma ctv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phat vay
	 * @throws NoSuchPhatVayException if a matching phat vay could not be found
	 */
	@Override
	public PhatVay findByMaCTV_First(
			String maCTV, OrderByComparator<PhatVay> orderByComparator)
		throws NoSuchPhatVayException {

		PhatVay phatVay = fetchByMaCTV_First(maCTV, orderByComparator);

		if (phatVay != null) {
			return phatVay;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("maCTV=");
		msg.append(maCTV);

		msg.append("}");

		throw new NoSuchPhatVayException(msg.toString());
	}

	/**
	 * Returns the first phat vay in the ordered set where maCTV = &#63;.
	 *
	 * @param maCTV the ma ctv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phat vay, or <code>null</code> if a matching phat vay could not be found
	 */
	@Override
	public PhatVay fetchByMaCTV_First(
		String maCTV, OrderByComparator<PhatVay> orderByComparator) {

		List<PhatVay> list = findByMaCTV(maCTV, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last phat vay in the ordered set where maCTV = &#63;.
	 *
	 * @param maCTV the ma ctv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phat vay
	 * @throws NoSuchPhatVayException if a matching phat vay could not be found
	 */
	@Override
	public PhatVay findByMaCTV_Last(
			String maCTV, OrderByComparator<PhatVay> orderByComparator)
		throws NoSuchPhatVayException {

		PhatVay phatVay = fetchByMaCTV_Last(maCTV, orderByComparator);

		if (phatVay != null) {
			return phatVay;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("maCTV=");
		msg.append(maCTV);

		msg.append("}");

		throw new NoSuchPhatVayException(msg.toString());
	}

	/**
	 * Returns the last phat vay in the ordered set where maCTV = &#63;.
	 *
	 * @param maCTV the ma ctv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phat vay, or <code>null</code> if a matching phat vay could not be found
	 */
	@Override
	public PhatVay fetchByMaCTV_Last(
		String maCTV, OrderByComparator<PhatVay> orderByComparator) {

		int count = countByMaCTV(maCTV);

		if (count == 0) {
			return null;
		}

		List<PhatVay> list = findByMaCTV(
			maCTV, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the phat vaies before and after the current phat vay in the ordered set where maCTV = &#63;.
	 *
	 * @param phatVayId the primary key of the current phat vay
	 * @param maCTV the ma ctv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next phat vay
	 * @throws NoSuchPhatVayException if a phat vay with the primary key could not be found
	 */
	@Override
	public PhatVay[] findByMaCTV_PrevAndNext(
			long phatVayId, String maCTV,
			OrderByComparator<PhatVay> orderByComparator)
		throws NoSuchPhatVayException {

		maCTV = Objects.toString(maCTV, "");

		PhatVay phatVay = findByPrimaryKey(phatVayId);

		Session session = null;

		try {
			session = openSession();

			PhatVay[] array = new PhatVayImpl[3];

			array[0] = getByMaCTV_PrevAndNext(
				session, phatVay, maCTV, orderByComparator, true);

			array[1] = phatVay;

			array[2] = getByMaCTV_PrevAndNext(
				session, phatVay, maCTV, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PhatVay getByMaCTV_PrevAndNext(
		Session session, PhatVay phatVay, String maCTV,
		OrderByComparator<PhatVay> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PHATVAY_WHERE);

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
			query.append(PhatVayModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(phatVay)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<PhatVay> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the phat vaies where maCTV = &#63; from the database.
	 *
	 * @param maCTV the ma ctv
	 */
	@Override
	public void removeByMaCTV(String maCTV) {
		for (PhatVay phatVay :
				findByMaCTV(
					maCTV, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(phatVay);
		}
	}

	/**
	 * Returns the number of phat vaies where maCTV = &#63;.
	 *
	 * @param maCTV the ma ctv
	 * @return the number of matching phat vaies
	 */
	@Override
	public int countByMaCTV(String maCTV) {
		maCTV = Objects.toString(maCTV, "");

		FinderPath finderPath = _finderPathCountByMaCTV;

		Object[] finderArgs = new Object[] {maCTV};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PHATVAY_WHERE);

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
		"phatVay.maCTV = ?";

	private static final String _FINDER_COLUMN_MACTV_MACTV_3 =
		"(phatVay.maCTV IS NULL OR phatVay.maCTV = '')";

	private FinderPath _finderPathFetchBySoKU;
	private FinderPath _finderPathCountBySoKU;

	/**
	 * Returns the phat vay where soKU = &#63; or throws a <code>NoSuchPhatVayException</code> if it could not be found.
	 *
	 * @param soKU the so ku
	 * @return the matching phat vay
	 * @throws NoSuchPhatVayException if a matching phat vay could not be found
	 */
	@Override
	public PhatVay findBySoKU(String soKU) throws NoSuchPhatVayException {
		PhatVay phatVay = fetchBySoKU(soKU);

		if (phatVay == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("soKU=");
			msg.append(soKU);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchPhatVayException(msg.toString());
		}

		return phatVay;
	}

	/**
	 * Returns the phat vay where soKU = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param soKU the so ku
	 * @return the matching phat vay, or <code>null</code> if a matching phat vay could not be found
	 */
	@Override
	public PhatVay fetchBySoKU(String soKU) {
		return fetchBySoKU(soKU, true);
	}

	/**
	 * Returns the phat vay where soKU = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param soKU the so ku
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching phat vay, or <code>null</code> if a matching phat vay could not be found
	 */
	@Override
	public PhatVay fetchBySoKU(String soKU, boolean retrieveFromCache) {
		soKU = Objects.toString(soKU, "");

		Object[] finderArgs = new Object[] {soKU};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchBySoKU, finderArgs, this);
		}

		if (result instanceof PhatVay) {
			PhatVay phatVay = (PhatVay)result;

			if (!Objects.equals(soKU, phatVay.getSoKU())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_PHATVAY_WHERE);

			boolean bindSoKU = false;

			if (soKU.isEmpty()) {
				query.append(_FINDER_COLUMN_SOKU_SOKU_3);
			}
			else {
				bindSoKU = true;

				query.append(_FINDER_COLUMN_SOKU_SOKU_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindSoKU) {
					qPos.add(soKU);
				}

				List<PhatVay> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchBySoKU, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"PhatVayPersistenceImpl.fetchBySoKU(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					PhatVay phatVay = list.get(0);

					result = phatVay;

					cacheResult(phatVay);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(_finderPathFetchBySoKU, finderArgs);

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
			return (PhatVay)result;
		}
	}

	/**
	 * Removes the phat vay where soKU = &#63; from the database.
	 *
	 * @param soKU the so ku
	 * @return the phat vay that was removed
	 */
	@Override
	public PhatVay removeBySoKU(String soKU) throws NoSuchPhatVayException {
		PhatVay phatVay = findBySoKU(soKU);

		return remove(phatVay);
	}

	/**
	 * Returns the number of phat vaies where soKU = &#63;.
	 *
	 * @param soKU the so ku
	 * @return the number of matching phat vaies
	 */
	@Override
	public int countBySoKU(String soKU) {
		soKU = Objects.toString(soKU, "");

		FinderPath finderPath = _finderPathCountBySoKU;

		Object[] finderArgs = new Object[] {soKU};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PHATVAY_WHERE);

			boolean bindSoKU = false;

			if (soKU.isEmpty()) {
				query.append(_FINDER_COLUMN_SOKU_SOKU_3);
			}
			else {
				bindSoKU = true;

				query.append(_FINDER_COLUMN_SOKU_SOKU_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindSoKU) {
					qPos.add(soKU);
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

	private static final String _FINDER_COLUMN_SOKU_SOKU_2 = "phatVay.soKU = ?";

	private static final String _FINDER_COLUMN_SOKU_SOKU_3 =
		"(phatVay.soKU IS NULL OR phatVay.soKU = '')";

	public PhatVayPersistenceImpl() {
		setModelClass(PhatVay.class);
	}

	/**
	 * Caches the phat vay in the entity cache if it is enabled.
	 *
	 * @param phatVay the phat vay
	 */
	@Override
	public void cacheResult(PhatVay phatVay) {
		entityCache.putResult(
			PhatVayModelImpl.ENTITY_CACHE_ENABLED, PhatVayImpl.class,
			phatVay.getPrimaryKey(), phatVay);

		finderCache.putResult(
			_finderPathFetchBySoKU, new Object[] {phatVay.getSoKU()}, phatVay);

		phatVay.resetOriginalValues();
	}

	/**
	 * Caches the phat vaies in the entity cache if it is enabled.
	 *
	 * @param phatVaies the phat vaies
	 */
	@Override
	public void cacheResult(List<PhatVay> phatVaies) {
		for (PhatVay phatVay : phatVaies) {
			if (entityCache.getResult(
					PhatVayModelImpl.ENTITY_CACHE_ENABLED, PhatVayImpl.class,
					phatVay.getPrimaryKey()) == null) {

				cacheResult(phatVay);
			}
			else {
				phatVay.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all phat vaies.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PhatVayImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the phat vay.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PhatVay phatVay) {
		entityCache.removeResult(
			PhatVayModelImpl.ENTITY_CACHE_ENABLED, PhatVayImpl.class,
			phatVay.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((PhatVayModelImpl)phatVay, true);
	}

	@Override
	public void clearCache(List<PhatVay> phatVaies) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PhatVay phatVay : phatVaies) {
			entityCache.removeResult(
				PhatVayModelImpl.ENTITY_CACHE_ENABLED, PhatVayImpl.class,
				phatVay.getPrimaryKey());

			clearUniqueFindersCache((PhatVayModelImpl)phatVay, true);
		}
	}

	protected void cacheUniqueFindersCache(PhatVayModelImpl phatVayModelImpl) {
		Object[] args = new Object[] {phatVayModelImpl.getSoKU()};

		finderCache.putResult(
			_finderPathCountBySoKU, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchBySoKU, args, phatVayModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		PhatVayModelImpl phatVayModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {phatVayModelImpl.getSoKU()};

			finderCache.removeResult(_finderPathCountBySoKU, args);
			finderCache.removeResult(_finderPathFetchBySoKU, args);
		}

		if ((phatVayModelImpl.getColumnBitmask() &
			 _finderPathFetchBySoKU.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {phatVayModelImpl.getOriginalSoKU()};

			finderCache.removeResult(_finderPathCountBySoKU, args);
			finderCache.removeResult(_finderPathFetchBySoKU, args);
		}
	}

	/**
	 * Creates a new phat vay with the primary key. Does not add the phat vay to the database.
	 *
	 * @param phatVayId the primary key for the new phat vay
	 * @return the new phat vay
	 */
	@Override
	public PhatVay create(long phatVayId) {
		PhatVay phatVay = new PhatVayImpl();

		phatVay.setNew(true);
		phatVay.setPrimaryKey(phatVayId);

		phatVay.setCompanyId(companyProvider.getCompanyId());

		return phatVay;
	}

	/**
	 * Removes the phat vay with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param phatVayId the primary key of the phat vay
	 * @return the phat vay that was removed
	 * @throws NoSuchPhatVayException if a phat vay with the primary key could not be found
	 */
	@Override
	public PhatVay remove(long phatVayId) throws NoSuchPhatVayException {
		return remove((Serializable)phatVayId);
	}

	/**
	 * Removes the phat vay with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the phat vay
	 * @return the phat vay that was removed
	 * @throws NoSuchPhatVayException if a phat vay with the primary key could not be found
	 */
	@Override
	public PhatVay remove(Serializable primaryKey)
		throws NoSuchPhatVayException {

		Session session = null;

		try {
			session = openSession();

			PhatVay phatVay = (PhatVay)session.get(
				PhatVayImpl.class, primaryKey);

			if (phatVay == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPhatVayException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(phatVay);
		}
		catch (NoSuchPhatVayException nsee) {
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
	protected PhatVay removeImpl(PhatVay phatVay) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(phatVay)) {
				phatVay = (PhatVay)session.get(
					PhatVayImpl.class, phatVay.getPrimaryKeyObj());
			}

			if (phatVay != null) {
				session.delete(phatVay);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (phatVay != null) {
			clearCache(phatVay);
		}

		return phatVay;
	}

	@Override
	public PhatVay updateImpl(PhatVay phatVay) {
		boolean isNew = phatVay.isNew();

		if (!(phatVay instanceof PhatVayModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(phatVay.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(phatVay);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in phatVay proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PhatVay implementation " +
					phatVay.getClass());
		}

		PhatVayModelImpl phatVayModelImpl = (PhatVayModelImpl)phatVay;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (phatVay.getCreateDate() == null)) {
			if (serviceContext == null) {
				phatVay.setCreateDate(now);
			}
			else {
				phatVay.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!phatVayModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				phatVay.setModifiedDate(now);
			}
			else {
				phatVay.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (phatVay.isNew()) {
				session.save(phatVay);

				phatVay.setNew(false);
			}
			else {
				phatVay = (PhatVay)session.merge(phatVay);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!PhatVayModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {phatVayModelImpl.getMaCTV()};

			finderCache.removeResult(_finderPathCountByMaCTV, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByMaCTV, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((phatVayModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByMaCTV.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					phatVayModelImpl.getOriginalMaCTV()
				};

				finderCache.removeResult(_finderPathCountByMaCTV, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByMaCTV, args);

				args = new Object[] {phatVayModelImpl.getMaCTV()};

				finderCache.removeResult(_finderPathCountByMaCTV, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByMaCTV, args);
			}
		}

		entityCache.putResult(
			PhatVayModelImpl.ENTITY_CACHE_ENABLED, PhatVayImpl.class,
			phatVay.getPrimaryKey(), phatVay, false);

		clearUniqueFindersCache(phatVayModelImpl, false);
		cacheUniqueFindersCache(phatVayModelImpl);

		phatVay.resetOriginalValues();

		return phatVay;
	}

	/**
	 * Returns the phat vay with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the phat vay
	 * @return the phat vay
	 * @throws NoSuchPhatVayException if a phat vay with the primary key could not be found
	 */
	@Override
	public PhatVay findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPhatVayException {

		PhatVay phatVay = fetchByPrimaryKey(primaryKey);

		if (phatVay == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPhatVayException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return phatVay;
	}

	/**
	 * Returns the phat vay with the primary key or throws a <code>NoSuchPhatVayException</code> if it could not be found.
	 *
	 * @param phatVayId the primary key of the phat vay
	 * @return the phat vay
	 * @throws NoSuchPhatVayException if a phat vay with the primary key could not be found
	 */
	@Override
	public PhatVay findByPrimaryKey(long phatVayId)
		throws NoSuchPhatVayException {

		return findByPrimaryKey((Serializable)phatVayId);
	}

	/**
	 * Returns the phat vay with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the phat vay
	 * @return the phat vay, or <code>null</code> if a phat vay with the primary key could not be found
	 */
	@Override
	public PhatVay fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			PhatVayModelImpl.ENTITY_CACHE_ENABLED, PhatVayImpl.class,
			primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		PhatVay phatVay = (PhatVay)serializable;

		if (phatVay == null) {
			Session session = null;

			try {
				session = openSession();

				phatVay = (PhatVay)session.get(PhatVayImpl.class, primaryKey);

				if (phatVay != null) {
					cacheResult(phatVay);
				}
				else {
					entityCache.putResult(
						PhatVayModelImpl.ENTITY_CACHE_ENABLED,
						PhatVayImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					PhatVayModelImpl.ENTITY_CACHE_ENABLED, PhatVayImpl.class,
					primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return phatVay;
	}

	/**
	 * Returns the phat vay with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param phatVayId the primary key of the phat vay
	 * @return the phat vay, or <code>null</code> if a phat vay with the primary key could not be found
	 */
	@Override
	public PhatVay fetchByPrimaryKey(long phatVayId) {
		return fetchByPrimaryKey((Serializable)phatVayId);
	}

	@Override
	public Map<Serializable, PhatVay> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, PhatVay> map = new HashMap<Serializable, PhatVay>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			PhatVay phatVay = fetchByPrimaryKey(primaryKey);

			if (phatVay != null) {
				map.put(primaryKey, phatVay);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				PhatVayModelImpl.ENTITY_CACHE_ENABLED, PhatVayImpl.class,
				primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (PhatVay)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_PHATVAY_WHERE_PKS_IN);

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

			for (PhatVay phatVay : (List<PhatVay>)q.list()) {
				map.put(phatVay.getPrimaryKeyObj(), phatVay);

				cacheResult(phatVay);

				uncachedPrimaryKeys.remove(phatVay.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					PhatVayModelImpl.ENTITY_CACHE_ENABLED, PhatVayImpl.class,
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
	 * Returns all the phat vaies.
	 *
	 * @return the phat vaies
	 */
	@Override
	public List<PhatVay> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the phat vaies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PhatVayModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of phat vaies
	 * @param end the upper bound of the range of phat vaies (not inclusive)
	 * @return the range of phat vaies
	 */
	@Override
	public List<PhatVay> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the phat vaies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PhatVayModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of phat vaies
	 * @param end the upper bound of the range of phat vaies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of phat vaies
	 */
	@Override
	public List<PhatVay> findAll(
		int start, int end, OrderByComparator<PhatVay> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the phat vaies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PhatVayModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of phat vaies
	 * @param end the upper bound of the range of phat vaies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of phat vaies
	 */
	@Override
	public List<PhatVay> findAll(
		int start, int end, OrderByComparator<PhatVay> orderByComparator,
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

		List<PhatVay> list = null;

		if (retrieveFromCache) {
			list = (List<PhatVay>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PHATVAY);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PHATVAY;

				if (pagination) {
					sql = sql.concat(PhatVayModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PhatVay>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PhatVay>)QueryUtil.list(
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
	 * Removes all the phat vaies from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PhatVay phatVay : findAll()) {
			remove(phatVay);
		}
	}

	/**
	 * Returns the number of phat vaies.
	 *
	 * @return the number of phat vaies
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PHATVAY);

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
		return PhatVayModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the phat vay persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			PhatVayModelImpl.ENTITY_CACHE_ENABLED,
			PhatVayModelImpl.FINDER_CACHE_ENABLED, PhatVayImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			PhatVayModelImpl.ENTITY_CACHE_ENABLED,
			PhatVayModelImpl.FINDER_CACHE_ENABLED, PhatVayImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			PhatVayModelImpl.ENTITY_CACHE_ENABLED,
			PhatVayModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByMaCTV = new FinderPath(
			PhatVayModelImpl.ENTITY_CACHE_ENABLED,
			PhatVayModelImpl.FINDER_CACHE_ENABLED, PhatVayImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMaCTV",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByMaCTV = new FinderPath(
			PhatVayModelImpl.ENTITY_CACHE_ENABLED,
			PhatVayModelImpl.FINDER_CACHE_ENABLED, PhatVayImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMaCTV",
			new String[] {String.class.getName()},
			PhatVayModelImpl.MACTV_COLUMN_BITMASK);

		_finderPathCountByMaCTV = new FinderPath(
			PhatVayModelImpl.ENTITY_CACHE_ENABLED,
			PhatVayModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMaCTV",
			new String[] {String.class.getName()});

		_finderPathFetchBySoKU = new FinderPath(
			PhatVayModelImpl.ENTITY_CACHE_ENABLED,
			PhatVayModelImpl.FINDER_CACHE_ENABLED, PhatVayImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBySoKU",
			new String[] {String.class.getName()},
			PhatVayModelImpl.SOKU_COLUMN_BITMASK);

		_finderPathCountBySoKU = new FinderPath(
			PhatVayModelImpl.ENTITY_CACHE_ENABLED,
			PhatVayModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySoKU",
			new String[] {String.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(PhatVayImpl.class.getName());
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

	private static final String _SQL_SELECT_PHATVAY =
		"SELECT phatVay FROM PhatVay phatVay";

	private static final String _SQL_SELECT_PHATVAY_WHERE_PKS_IN =
		"SELECT phatVay FROM PhatVay phatVay WHERE phatVayId IN (";

	private static final String _SQL_SELECT_PHATVAY_WHERE =
		"SELECT phatVay FROM PhatVay phatVay WHERE ";

	private static final String _SQL_COUNT_PHATVAY =
		"SELECT COUNT(phatVay) FROM PhatVay phatVay";

	private static final String _SQL_COUNT_PHATVAY_WHERE =
		"SELECT COUNT(phatVay) FROM PhatVay phatVay WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "phatVay.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PhatVay exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PhatVay exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PhatVayPersistenceImpl.class);

}