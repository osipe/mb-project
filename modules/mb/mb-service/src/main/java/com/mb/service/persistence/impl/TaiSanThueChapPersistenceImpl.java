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

import com.mb.exception.NoSuchTaiSanThueChapException;
import com.mb.model.TaiSanThueChap;
import com.mb.model.impl.TaiSanThueChapImpl;
import com.mb.model.impl.TaiSanThueChapModelImpl;
import com.mb.service.persistence.TaiSanThueChapPersistence;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the tai san thue chap service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class TaiSanThueChapPersistenceImpl
	extends BasePersistenceImpl<TaiSanThueChap>
	implements TaiSanThueChapPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TaiSanThueChapUtil</code> to access the tai san thue chap persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TaiSanThueChapImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByPhatVayId;
	private FinderPath _finderPathWithoutPaginationFindByPhatVayId;
	private FinderPath _finderPathCountByPhatVayId;

	/**
	 * Returns all the tai san thue chaps where phatVayId = &#63;.
	 *
	 * @param phatVayId the phat vay ID
	 * @return the matching tai san thue chaps
	 */
	@Override
	public List<TaiSanThueChap> findByPhatVayId(long phatVayId) {
		return findByPhatVayId(
			phatVayId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tai san thue chaps where phatVayId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaiSanThueChapModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phatVayId the phat vay ID
	 * @param start the lower bound of the range of tai san thue chaps
	 * @param end the upper bound of the range of tai san thue chaps (not inclusive)
	 * @return the range of matching tai san thue chaps
	 */
	@Override
	public List<TaiSanThueChap> findByPhatVayId(
		long phatVayId, int start, int end) {

		return findByPhatVayId(phatVayId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tai san thue chaps where phatVayId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaiSanThueChapModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phatVayId the phat vay ID
	 * @param start the lower bound of the range of tai san thue chaps
	 * @param end the upper bound of the range of tai san thue chaps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tai san thue chaps
	 */
	@Override
	public List<TaiSanThueChap> findByPhatVayId(
		long phatVayId, int start, int end,
		OrderByComparator<TaiSanThueChap> orderByComparator) {

		return findByPhatVayId(phatVayId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tai san thue chaps where phatVayId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaiSanThueChapModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phatVayId the phat vay ID
	 * @param start the lower bound of the range of tai san thue chaps
	 * @param end the upper bound of the range of tai san thue chaps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching tai san thue chaps
	 */
	@Override
	public List<TaiSanThueChap> findByPhatVayId(
		long phatVayId, int start, int end,
		OrderByComparator<TaiSanThueChap> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByPhatVayId;
			finderArgs = new Object[] {phatVayId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByPhatVayId;
			finderArgs = new Object[] {
				phatVayId, start, end, orderByComparator
			};
		}

		List<TaiSanThueChap> list = null;

		if (retrieveFromCache) {
			list = (List<TaiSanThueChap>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TaiSanThueChap taiSanThueChap : list) {
					if ((phatVayId != taiSanThueChap.getPhatVayId())) {
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

			query.append(_SQL_SELECT_TAISANTHUECHAP_WHERE);

			query.append(_FINDER_COLUMN_PHATVAYID_PHATVAYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(TaiSanThueChapModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(phatVayId);

				if (!pagination) {
					list = (List<TaiSanThueChap>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TaiSanThueChap>)QueryUtil.list(
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
	 * Returns the first tai san thue chap in the ordered set where phatVayId = &#63;.
	 *
	 * @param phatVayId the phat vay ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tai san thue chap
	 * @throws NoSuchTaiSanThueChapException if a matching tai san thue chap could not be found
	 */
	@Override
	public TaiSanThueChap findByPhatVayId_First(
			long phatVayId, OrderByComparator<TaiSanThueChap> orderByComparator)
		throws NoSuchTaiSanThueChapException {

		TaiSanThueChap taiSanThueChap = fetchByPhatVayId_First(
			phatVayId, orderByComparator);

		if (taiSanThueChap != null) {
			return taiSanThueChap;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("phatVayId=");
		msg.append(phatVayId);

		msg.append("}");

		throw new NoSuchTaiSanThueChapException(msg.toString());
	}

	/**
	 * Returns the first tai san thue chap in the ordered set where phatVayId = &#63;.
	 *
	 * @param phatVayId the phat vay ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tai san thue chap, or <code>null</code> if a matching tai san thue chap could not be found
	 */
	@Override
	public TaiSanThueChap fetchByPhatVayId_First(
		long phatVayId, OrderByComparator<TaiSanThueChap> orderByComparator) {

		List<TaiSanThueChap> list = findByPhatVayId(
			phatVayId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tai san thue chap in the ordered set where phatVayId = &#63;.
	 *
	 * @param phatVayId the phat vay ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tai san thue chap
	 * @throws NoSuchTaiSanThueChapException if a matching tai san thue chap could not be found
	 */
	@Override
	public TaiSanThueChap findByPhatVayId_Last(
			long phatVayId, OrderByComparator<TaiSanThueChap> orderByComparator)
		throws NoSuchTaiSanThueChapException {

		TaiSanThueChap taiSanThueChap = fetchByPhatVayId_Last(
			phatVayId, orderByComparator);

		if (taiSanThueChap != null) {
			return taiSanThueChap;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("phatVayId=");
		msg.append(phatVayId);

		msg.append("}");

		throw new NoSuchTaiSanThueChapException(msg.toString());
	}

	/**
	 * Returns the last tai san thue chap in the ordered set where phatVayId = &#63;.
	 *
	 * @param phatVayId the phat vay ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tai san thue chap, or <code>null</code> if a matching tai san thue chap could not be found
	 */
	@Override
	public TaiSanThueChap fetchByPhatVayId_Last(
		long phatVayId, OrderByComparator<TaiSanThueChap> orderByComparator) {

		int count = countByPhatVayId(phatVayId);

		if (count == 0) {
			return null;
		}

		List<TaiSanThueChap> list = findByPhatVayId(
			phatVayId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tai san thue chaps before and after the current tai san thue chap in the ordered set where phatVayId = &#63;.
	 *
	 * @param taiSanThueChapId the primary key of the current tai san thue chap
	 * @param phatVayId the phat vay ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tai san thue chap
	 * @throws NoSuchTaiSanThueChapException if a tai san thue chap with the primary key could not be found
	 */
	@Override
	public TaiSanThueChap[] findByPhatVayId_PrevAndNext(
			long taiSanThueChapId, long phatVayId,
			OrderByComparator<TaiSanThueChap> orderByComparator)
		throws NoSuchTaiSanThueChapException {

		TaiSanThueChap taiSanThueChap = findByPrimaryKey(taiSanThueChapId);

		Session session = null;

		try {
			session = openSession();

			TaiSanThueChap[] array = new TaiSanThueChapImpl[3];

			array[0] = getByPhatVayId_PrevAndNext(
				session, taiSanThueChap, phatVayId, orderByComparator, true);

			array[1] = taiSanThueChap;

			array[2] = getByPhatVayId_PrevAndNext(
				session, taiSanThueChap, phatVayId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TaiSanThueChap getByPhatVayId_PrevAndNext(
		Session session, TaiSanThueChap taiSanThueChap, long phatVayId,
		OrderByComparator<TaiSanThueChap> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TAISANTHUECHAP_WHERE);

		query.append(_FINDER_COLUMN_PHATVAYID_PHATVAYID_2);

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
			query.append(TaiSanThueChapModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(phatVayId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						taiSanThueChap)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<TaiSanThueChap> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tai san thue chaps where phatVayId = &#63; from the database.
	 *
	 * @param phatVayId the phat vay ID
	 */
	@Override
	public void removeByPhatVayId(long phatVayId) {
		for (TaiSanThueChap taiSanThueChap :
				findByPhatVayId(
					phatVayId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(taiSanThueChap);
		}
	}

	/**
	 * Returns the number of tai san thue chaps where phatVayId = &#63;.
	 *
	 * @param phatVayId the phat vay ID
	 * @return the number of matching tai san thue chaps
	 */
	@Override
	public int countByPhatVayId(long phatVayId) {
		FinderPath finderPath = _finderPathCountByPhatVayId;

		Object[] finderArgs = new Object[] {phatVayId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TAISANTHUECHAP_WHERE);

			query.append(_FINDER_COLUMN_PHATVAYID_PHATVAYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(phatVayId);

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

	private static final String _FINDER_COLUMN_PHATVAYID_PHATVAYID_2 =
		"taiSanThueChap.phatVayId = ?";

	public TaiSanThueChapPersistenceImpl() {
		setModelClass(TaiSanThueChap.class);
	}

	/**
	 * Caches the tai san thue chap in the entity cache if it is enabled.
	 *
	 * @param taiSanThueChap the tai san thue chap
	 */
	@Override
	public void cacheResult(TaiSanThueChap taiSanThueChap) {
		entityCache.putResult(
			TaiSanThueChapModelImpl.ENTITY_CACHE_ENABLED,
			TaiSanThueChapImpl.class, taiSanThueChap.getPrimaryKey(),
			taiSanThueChap);

		taiSanThueChap.resetOriginalValues();
	}

	/**
	 * Caches the tai san thue chaps in the entity cache if it is enabled.
	 *
	 * @param taiSanThueChaps the tai san thue chaps
	 */
	@Override
	public void cacheResult(List<TaiSanThueChap> taiSanThueChaps) {
		for (TaiSanThueChap taiSanThueChap : taiSanThueChaps) {
			if (entityCache.getResult(
					TaiSanThueChapModelImpl.ENTITY_CACHE_ENABLED,
					TaiSanThueChapImpl.class, taiSanThueChap.getPrimaryKey()) ==
						null) {

				cacheResult(taiSanThueChap);
			}
			else {
				taiSanThueChap.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tai san thue chaps.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TaiSanThueChapImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tai san thue chap.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TaiSanThueChap taiSanThueChap) {
		entityCache.removeResult(
			TaiSanThueChapModelImpl.ENTITY_CACHE_ENABLED,
			TaiSanThueChapImpl.class, taiSanThueChap.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TaiSanThueChap> taiSanThueChaps) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TaiSanThueChap taiSanThueChap : taiSanThueChaps) {
			entityCache.removeResult(
				TaiSanThueChapModelImpl.ENTITY_CACHE_ENABLED,
				TaiSanThueChapImpl.class, taiSanThueChap.getPrimaryKey());
		}
	}

	/**
	 * Creates a new tai san thue chap with the primary key. Does not add the tai san thue chap to the database.
	 *
	 * @param taiSanThueChapId the primary key for the new tai san thue chap
	 * @return the new tai san thue chap
	 */
	@Override
	public TaiSanThueChap create(long taiSanThueChapId) {
		TaiSanThueChap taiSanThueChap = new TaiSanThueChapImpl();

		taiSanThueChap.setNew(true);
		taiSanThueChap.setPrimaryKey(taiSanThueChapId);

		taiSanThueChap.setCompanyId(companyProvider.getCompanyId());

		return taiSanThueChap;
	}

	/**
	 * Removes the tai san thue chap with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taiSanThueChapId the primary key of the tai san thue chap
	 * @return the tai san thue chap that was removed
	 * @throws NoSuchTaiSanThueChapException if a tai san thue chap with the primary key could not be found
	 */
	@Override
	public TaiSanThueChap remove(long taiSanThueChapId)
		throws NoSuchTaiSanThueChapException {

		return remove((Serializable)taiSanThueChapId);
	}

	/**
	 * Removes the tai san thue chap with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tai san thue chap
	 * @return the tai san thue chap that was removed
	 * @throws NoSuchTaiSanThueChapException if a tai san thue chap with the primary key could not be found
	 */
	@Override
	public TaiSanThueChap remove(Serializable primaryKey)
		throws NoSuchTaiSanThueChapException {

		Session session = null;

		try {
			session = openSession();

			TaiSanThueChap taiSanThueChap = (TaiSanThueChap)session.get(
				TaiSanThueChapImpl.class, primaryKey);

			if (taiSanThueChap == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTaiSanThueChapException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(taiSanThueChap);
		}
		catch (NoSuchTaiSanThueChapException nsee) {
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
	protected TaiSanThueChap removeImpl(TaiSanThueChap taiSanThueChap) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(taiSanThueChap)) {
				taiSanThueChap = (TaiSanThueChap)session.get(
					TaiSanThueChapImpl.class,
					taiSanThueChap.getPrimaryKeyObj());
			}

			if (taiSanThueChap != null) {
				session.delete(taiSanThueChap);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (taiSanThueChap != null) {
			clearCache(taiSanThueChap);
		}

		return taiSanThueChap;
	}

	@Override
	public TaiSanThueChap updateImpl(TaiSanThueChap taiSanThueChap) {
		boolean isNew = taiSanThueChap.isNew();

		if (!(taiSanThueChap instanceof TaiSanThueChapModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(taiSanThueChap.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					taiSanThueChap);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in taiSanThueChap proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TaiSanThueChap implementation " +
					taiSanThueChap.getClass());
		}

		TaiSanThueChapModelImpl taiSanThueChapModelImpl =
			(TaiSanThueChapModelImpl)taiSanThueChap;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (taiSanThueChap.getCreateDate() == null)) {
			if (serviceContext == null) {
				taiSanThueChap.setCreateDate(now);
			}
			else {
				taiSanThueChap.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!taiSanThueChapModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				taiSanThueChap.setModifiedDate(now);
			}
			else {
				taiSanThueChap.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (taiSanThueChap.isNew()) {
				session.save(taiSanThueChap);

				taiSanThueChap.setNew(false);
			}
			else {
				taiSanThueChap = (TaiSanThueChap)session.merge(taiSanThueChap);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!TaiSanThueChapModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				taiSanThueChapModelImpl.getPhatVayId()
			};

			finderCache.removeResult(_finderPathCountByPhatVayId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByPhatVayId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((taiSanThueChapModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByPhatVayId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					taiSanThueChapModelImpl.getOriginalPhatVayId()
				};

				finderCache.removeResult(_finderPathCountByPhatVayId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByPhatVayId, args);

				args = new Object[] {taiSanThueChapModelImpl.getPhatVayId()};

				finderCache.removeResult(_finderPathCountByPhatVayId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByPhatVayId, args);
			}
		}

		entityCache.putResult(
			TaiSanThueChapModelImpl.ENTITY_CACHE_ENABLED,
			TaiSanThueChapImpl.class, taiSanThueChap.getPrimaryKey(),
			taiSanThueChap, false);

		taiSanThueChap.resetOriginalValues();

		return taiSanThueChap;
	}

	/**
	 * Returns the tai san thue chap with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tai san thue chap
	 * @return the tai san thue chap
	 * @throws NoSuchTaiSanThueChapException if a tai san thue chap with the primary key could not be found
	 */
	@Override
	public TaiSanThueChap findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTaiSanThueChapException {

		TaiSanThueChap taiSanThueChap = fetchByPrimaryKey(primaryKey);

		if (taiSanThueChap == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTaiSanThueChapException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return taiSanThueChap;
	}

	/**
	 * Returns the tai san thue chap with the primary key or throws a <code>NoSuchTaiSanThueChapException</code> if it could not be found.
	 *
	 * @param taiSanThueChapId the primary key of the tai san thue chap
	 * @return the tai san thue chap
	 * @throws NoSuchTaiSanThueChapException if a tai san thue chap with the primary key could not be found
	 */
	@Override
	public TaiSanThueChap findByPrimaryKey(long taiSanThueChapId)
		throws NoSuchTaiSanThueChapException {

		return findByPrimaryKey((Serializable)taiSanThueChapId);
	}

	/**
	 * Returns the tai san thue chap with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tai san thue chap
	 * @return the tai san thue chap, or <code>null</code> if a tai san thue chap with the primary key could not be found
	 */
	@Override
	public TaiSanThueChap fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			TaiSanThueChapModelImpl.ENTITY_CACHE_ENABLED,
			TaiSanThueChapImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		TaiSanThueChap taiSanThueChap = (TaiSanThueChap)serializable;

		if (taiSanThueChap == null) {
			Session session = null;

			try {
				session = openSession();

				taiSanThueChap = (TaiSanThueChap)session.get(
					TaiSanThueChapImpl.class, primaryKey);

				if (taiSanThueChap != null) {
					cacheResult(taiSanThueChap);
				}
				else {
					entityCache.putResult(
						TaiSanThueChapModelImpl.ENTITY_CACHE_ENABLED,
						TaiSanThueChapImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					TaiSanThueChapModelImpl.ENTITY_CACHE_ENABLED,
					TaiSanThueChapImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return taiSanThueChap;
	}

	/**
	 * Returns the tai san thue chap with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param taiSanThueChapId the primary key of the tai san thue chap
	 * @return the tai san thue chap, or <code>null</code> if a tai san thue chap with the primary key could not be found
	 */
	@Override
	public TaiSanThueChap fetchByPrimaryKey(long taiSanThueChapId) {
		return fetchByPrimaryKey((Serializable)taiSanThueChapId);
	}

	@Override
	public Map<Serializable, TaiSanThueChap> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, TaiSanThueChap> map =
			new HashMap<Serializable, TaiSanThueChap>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			TaiSanThueChap taiSanThueChap = fetchByPrimaryKey(primaryKey);

			if (taiSanThueChap != null) {
				map.put(primaryKey, taiSanThueChap);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				TaiSanThueChapModelImpl.ENTITY_CACHE_ENABLED,
				TaiSanThueChapImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (TaiSanThueChap)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_TAISANTHUECHAP_WHERE_PKS_IN);

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

			for (TaiSanThueChap taiSanThueChap :
					(List<TaiSanThueChap>)q.list()) {

				map.put(taiSanThueChap.getPrimaryKeyObj(), taiSanThueChap);

				cacheResult(taiSanThueChap);

				uncachedPrimaryKeys.remove(taiSanThueChap.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					TaiSanThueChapModelImpl.ENTITY_CACHE_ENABLED,
					TaiSanThueChapImpl.class, primaryKey, nullModel);
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
	 * Returns all the tai san thue chaps.
	 *
	 * @return the tai san thue chaps
	 */
	@Override
	public List<TaiSanThueChap> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tai san thue chaps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaiSanThueChapModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tai san thue chaps
	 * @param end the upper bound of the range of tai san thue chaps (not inclusive)
	 * @return the range of tai san thue chaps
	 */
	@Override
	public List<TaiSanThueChap> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the tai san thue chaps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaiSanThueChapModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tai san thue chaps
	 * @param end the upper bound of the range of tai san thue chaps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tai san thue chaps
	 */
	@Override
	public List<TaiSanThueChap> findAll(
		int start, int end,
		OrderByComparator<TaiSanThueChap> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tai san thue chaps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaiSanThueChapModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tai san thue chaps
	 * @param end the upper bound of the range of tai san thue chaps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of tai san thue chaps
	 */
	@Override
	public List<TaiSanThueChap> findAll(
		int start, int end, OrderByComparator<TaiSanThueChap> orderByComparator,
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

		List<TaiSanThueChap> list = null;

		if (retrieveFromCache) {
			list = (List<TaiSanThueChap>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TAISANTHUECHAP);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TAISANTHUECHAP;

				if (pagination) {
					sql = sql.concat(TaiSanThueChapModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TaiSanThueChap>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TaiSanThueChap>)QueryUtil.list(
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
	 * Removes all the tai san thue chaps from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TaiSanThueChap taiSanThueChap : findAll()) {
			remove(taiSanThueChap);
		}
	}

	/**
	 * Returns the number of tai san thue chaps.
	 *
	 * @return the number of tai san thue chaps
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TAISANTHUECHAP);

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
		return TaiSanThueChapModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the tai san thue chap persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			TaiSanThueChapModelImpl.ENTITY_CACHE_ENABLED,
			TaiSanThueChapModelImpl.FINDER_CACHE_ENABLED,
			TaiSanThueChapImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			TaiSanThueChapModelImpl.ENTITY_CACHE_ENABLED,
			TaiSanThueChapModelImpl.FINDER_CACHE_ENABLED,
			TaiSanThueChapImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);

		_finderPathCountAll = new FinderPath(
			TaiSanThueChapModelImpl.ENTITY_CACHE_ENABLED,
			TaiSanThueChapModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByPhatVayId = new FinderPath(
			TaiSanThueChapModelImpl.ENTITY_CACHE_ENABLED,
			TaiSanThueChapModelImpl.FINDER_CACHE_ENABLED,
			TaiSanThueChapImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPhatVayId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByPhatVayId = new FinderPath(
			TaiSanThueChapModelImpl.ENTITY_CACHE_ENABLED,
			TaiSanThueChapModelImpl.FINDER_CACHE_ENABLED,
			TaiSanThueChapImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByPhatVayId", new String[] {Long.class.getName()},
			TaiSanThueChapModelImpl.PHATVAYID_COLUMN_BITMASK);

		_finderPathCountByPhatVayId = new FinderPath(
			TaiSanThueChapModelImpl.ENTITY_CACHE_ENABLED,
			TaiSanThueChapModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPhatVayId",
			new String[] {Long.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(TaiSanThueChapImpl.class.getName());
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

	private static final String _SQL_SELECT_TAISANTHUECHAP =
		"SELECT taiSanThueChap FROM TaiSanThueChap taiSanThueChap";

	private static final String _SQL_SELECT_TAISANTHUECHAP_WHERE_PKS_IN =
		"SELECT taiSanThueChap FROM TaiSanThueChap taiSanThueChap WHERE taiSanThueChapId IN (";

	private static final String _SQL_SELECT_TAISANTHUECHAP_WHERE =
		"SELECT taiSanThueChap FROM TaiSanThueChap taiSanThueChap WHERE ";

	private static final String _SQL_COUNT_TAISANTHUECHAP =
		"SELECT COUNT(taiSanThueChap) FROM TaiSanThueChap taiSanThueChap";

	private static final String _SQL_COUNT_TAISANTHUECHAP_WHERE =
		"SELECT COUNT(taiSanThueChap) FROM TaiSanThueChap taiSanThueChap WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "taiSanThueChap.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TaiSanThueChap exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TaiSanThueChap exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TaiSanThueChapPersistenceImpl.class);

}