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

import com.mb.exception.NoSuchLichSuThuPhatChiException;
import com.mb.model.LichSuThuPhatChi;
import com.mb.model.impl.LichSuThuPhatChiImpl;
import com.mb.model.impl.LichSuThuPhatChiModelImpl;
import com.mb.service.persistence.LichSuThuPhatChiPersistence;

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
 * The persistence implementation for the lich su thu phat chi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class LichSuThuPhatChiPersistenceImpl
	extends BasePersistenceImpl<LichSuThuPhatChi>
	implements LichSuThuPhatChiPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LichSuThuPhatChiUtil</code> to access the lich su thu phat chi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LichSuThuPhatChiImpl.class.getName();

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
	 * Returns all the lich su thu phat chis where maCTV = &#63;.
	 *
	 * @param maCTV the ma ctv
	 * @return the matching lich su thu phat chis
	 */
	@Override
	public List<LichSuThuPhatChi> findByMaCTV(String maCTV) {
		return findByMaCTV(maCTV, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lich su thu phat chis where maCTV = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LichSuThuPhatChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param maCTV the ma ctv
	 * @param start the lower bound of the range of lich su thu phat chis
	 * @param end the upper bound of the range of lich su thu phat chis (not inclusive)
	 * @return the range of matching lich su thu phat chis
	 */
	@Override
	public List<LichSuThuPhatChi> findByMaCTV(
		String maCTV, int start, int end) {

		return findByMaCTV(maCTV, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lich su thu phat chis where maCTV = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LichSuThuPhatChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param maCTV the ma ctv
	 * @param start the lower bound of the range of lich su thu phat chis
	 * @param end the upper bound of the range of lich su thu phat chis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lich su thu phat chis
	 */
	@Override
	public List<LichSuThuPhatChi> findByMaCTV(
		String maCTV, int start, int end,
		OrderByComparator<LichSuThuPhatChi> orderByComparator) {

		return findByMaCTV(maCTV, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lich su thu phat chis where maCTV = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LichSuThuPhatChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param maCTV the ma ctv
	 * @param start the lower bound of the range of lich su thu phat chis
	 * @param end the upper bound of the range of lich su thu phat chis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching lich su thu phat chis
	 */
	@Override
	public List<LichSuThuPhatChi> findByMaCTV(
		String maCTV, int start, int end,
		OrderByComparator<LichSuThuPhatChi> orderByComparator,
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

		List<LichSuThuPhatChi> list = null;

		if (retrieveFromCache) {
			list = (List<LichSuThuPhatChi>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LichSuThuPhatChi lichSuThuPhatChi : list) {
					if (!maCTV.equals(lichSuThuPhatChi.getMaCTV())) {
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

			query.append(_SQL_SELECT_LICHSUTHUPHATCHI_WHERE);

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
				query.append(LichSuThuPhatChiModelImpl.ORDER_BY_JPQL);
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
					list = (List<LichSuThuPhatChi>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<LichSuThuPhatChi>)QueryUtil.list(
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
	 * Returns the first lich su thu phat chi in the ordered set where maCTV = &#63;.
	 *
	 * @param maCTV the ma ctv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lich su thu phat chi
	 * @throws NoSuchLichSuThuPhatChiException if a matching lich su thu phat chi could not be found
	 */
	@Override
	public LichSuThuPhatChi findByMaCTV_First(
			String maCTV, OrderByComparator<LichSuThuPhatChi> orderByComparator)
		throws NoSuchLichSuThuPhatChiException {

		LichSuThuPhatChi lichSuThuPhatChi = fetchByMaCTV_First(
			maCTV, orderByComparator);

		if (lichSuThuPhatChi != null) {
			return lichSuThuPhatChi;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("maCTV=");
		msg.append(maCTV);

		msg.append("}");

		throw new NoSuchLichSuThuPhatChiException(msg.toString());
	}

	/**
	 * Returns the first lich su thu phat chi in the ordered set where maCTV = &#63;.
	 *
	 * @param maCTV the ma ctv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lich su thu phat chi, or <code>null</code> if a matching lich su thu phat chi could not be found
	 */
	@Override
	public LichSuThuPhatChi fetchByMaCTV_First(
		String maCTV, OrderByComparator<LichSuThuPhatChi> orderByComparator) {

		List<LichSuThuPhatChi> list = findByMaCTV(
			maCTV, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lich su thu phat chi in the ordered set where maCTV = &#63;.
	 *
	 * @param maCTV the ma ctv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lich su thu phat chi
	 * @throws NoSuchLichSuThuPhatChiException if a matching lich su thu phat chi could not be found
	 */
	@Override
	public LichSuThuPhatChi findByMaCTV_Last(
			String maCTV, OrderByComparator<LichSuThuPhatChi> orderByComparator)
		throws NoSuchLichSuThuPhatChiException {

		LichSuThuPhatChi lichSuThuPhatChi = fetchByMaCTV_Last(
			maCTV, orderByComparator);

		if (lichSuThuPhatChi != null) {
			return lichSuThuPhatChi;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("maCTV=");
		msg.append(maCTV);

		msg.append("}");

		throw new NoSuchLichSuThuPhatChiException(msg.toString());
	}

	/**
	 * Returns the last lich su thu phat chi in the ordered set where maCTV = &#63;.
	 *
	 * @param maCTV the ma ctv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lich su thu phat chi, or <code>null</code> if a matching lich su thu phat chi could not be found
	 */
	@Override
	public LichSuThuPhatChi fetchByMaCTV_Last(
		String maCTV, OrderByComparator<LichSuThuPhatChi> orderByComparator) {

		int count = countByMaCTV(maCTV);

		if (count == 0) {
			return null;
		}

		List<LichSuThuPhatChi> list = findByMaCTV(
			maCTV, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lich su thu phat chis before and after the current lich su thu phat chi in the ordered set where maCTV = &#63;.
	 *
	 * @param lichSuThuPhatChiId the primary key of the current lich su thu phat chi
	 * @param maCTV the ma ctv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lich su thu phat chi
	 * @throws NoSuchLichSuThuPhatChiException if a lich su thu phat chi with the primary key could not be found
	 */
	@Override
	public LichSuThuPhatChi[] findByMaCTV_PrevAndNext(
			long lichSuThuPhatChiId, String maCTV,
			OrderByComparator<LichSuThuPhatChi> orderByComparator)
		throws NoSuchLichSuThuPhatChiException {

		maCTV = Objects.toString(maCTV, "");

		LichSuThuPhatChi lichSuThuPhatChi = findByPrimaryKey(
			lichSuThuPhatChiId);

		Session session = null;

		try {
			session = openSession();

			LichSuThuPhatChi[] array = new LichSuThuPhatChiImpl[3];

			array[0] = getByMaCTV_PrevAndNext(
				session, lichSuThuPhatChi, maCTV, orderByComparator, true);

			array[1] = lichSuThuPhatChi;

			array[2] = getByMaCTV_PrevAndNext(
				session, lichSuThuPhatChi, maCTV, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LichSuThuPhatChi getByMaCTV_PrevAndNext(
		Session session, LichSuThuPhatChi lichSuThuPhatChi, String maCTV,
		OrderByComparator<LichSuThuPhatChi> orderByComparator,
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

		query.append(_SQL_SELECT_LICHSUTHUPHATCHI_WHERE);

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
			query.append(LichSuThuPhatChiModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						lichSuThuPhatChi)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LichSuThuPhatChi> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lich su thu phat chis where maCTV = &#63; from the database.
	 *
	 * @param maCTV the ma ctv
	 */
	@Override
	public void removeByMaCTV(String maCTV) {
		for (LichSuThuPhatChi lichSuThuPhatChi :
				findByMaCTV(
					maCTV, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(lichSuThuPhatChi);
		}
	}

	/**
	 * Returns the number of lich su thu phat chis where maCTV = &#63;.
	 *
	 * @param maCTV the ma ctv
	 * @return the number of matching lich su thu phat chis
	 */
	@Override
	public int countByMaCTV(String maCTV) {
		maCTV = Objects.toString(maCTV, "");

		FinderPath finderPath = _finderPathCountByMaCTV;

		Object[] finderArgs = new Object[] {maCTV};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LICHSUTHUPHATCHI_WHERE);

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
		"lichSuThuPhatChi.maCTV = ?";

	private static final String _FINDER_COLUMN_MACTV_MACTV_3 =
		"(lichSuThuPhatChi.maCTV IS NULL OR lichSuThuPhatChi.maCTV = '')";

	private FinderPath _finderPathWithPaginationFindByPhatVayId;
	private FinderPath _finderPathWithoutPaginationFindByPhatVayId;
	private FinderPath _finderPathCountByPhatVayId;

	/**
	 * Returns all the lich su thu phat chis where phatVayId = &#63;.
	 *
	 * @param phatVayId the phat vay ID
	 * @return the matching lich su thu phat chis
	 */
	@Override
	public List<LichSuThuPhatChi> findByPhatVayId(long phatVayId) {
		return findByPhatVayId(
			phatVayId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lich su thu phat chis where phatVayId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LichSuThuPhatChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phatVayId the phat vay ID
	 * @param start the lower bound of the range of lich su thu phat chis
	 * @param end the upper bound of the range of lich su thu phat chis (not inclusive)
	 * @return the range of matching lich su thu phat chis
	 */
	@Override
	public List<LichSuThuPhatChi> findByPhatVayId(
		long phatVayId, int start, int end) {

		return findByPhatVayId(phatVayId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lich su thu phat chis where phatVayId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LichSuThuPhatChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phatVayId the phat vay ID
	 * @param start the lower bound of the range of lich su thu phat chis
	 * @param end the upper bound of the range of lich su thu phat chis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lich su thu phat chis
	 */
	@Override
	public List<LichSuThuPhatChi> findByPhatVayId(
		long phatVayId, int start, int end,
		OrderByComparator<LichSuThuPhatChi> orderByComparator) {

		return findByPhatVayId(phatVayId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lich su thu phat chis where phatVayId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LichSuThuPhatChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phatVayId the phat vay ID
	 * @param start the lower bound of the range of lich su thu phat chis
	 * @param end the upper bound of the range of lich su thu phat chis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching lich su thu phat chis
	 */
	@Override
	public List<LichSuThuPhatChi> findByPhatVayId(
		long phatVayId, int start, int end,
		OrderByComparator<LichSuThuPhatChi> orderByComparator,
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

		List<LichSuThuPhatChi> list = null;

		if (retrieveFromCache) {
			list = (List<LichSuThuPhatChi>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LichSuThuPhatChi lichSuThuPhatChi : list) {
					if ((phatVayId != lichSuThuPhatChi.getPhatVayId())) {
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

			query.append(_SQL_SELECT_LICHSUTHUPHATCHI_WHERE);

			query.append(_FINDER_COLUMN_PHATVAYID_PHATVAYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(LichSuThuPhatChiModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(phatVayId);

				if (!pagination) {
					list = (List<LichSuThuPhatChi>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<LichSuThuPhatChi>)QueryUtil.list(
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
	 * Returns the first lich su thu phat chi in the ordered set where phatVayId = &#63;.
	 *
	 * @param phatVayId the phat vay ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lich su thu phat chi
	 * @throws NoSuchLichSuThuPhatChiException if a matching lich su thu phat chi could not be found
	 */
	@Override
	public LichSuThuPhatChi findByPhatVayId_First(
			long phatVayId,
			OrderByComparator<LichSuThuPhatChi> orderByComparator)
		throws NoSuchLichSuThuPhatChiException {

		LichSuThuPhatChi lichSuThuPhatChi = fetchByPhatVayId_First(
			phatVayId, orderByComparator);

		if (lichSuThuPhatChi != null) {
			return lichSuThuPhatChi;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("phatVayId=");
		msg.append(phatVayId);

		msg.append("}");

		throw new NoSuchLichSuThuPhatChiException(msg.toString());
	}

	/**
	 * Returns the first lich su thu phat chi in the ordered set where phatVayId = &#63;.
	 *
	 * @param phatVayId the phat vay ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lich su thu phat chi, or <code>null</code> if a matching lich su thu phat chi could not be found
	 */
	@Override
	public LichSuThuPhatChi fetchByPhatVayId_First(
		long phatVayId, OrderByComparator<LichSuThuPhatChi> orderByComparator) {

		List<LichSuThuPhatChi> list = findByPhatVayId(
			phatVayId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lich su thu phat chi in the ordered set where phatVayId = &#63;.
	 *
	 * @param phatVayId the phat vay ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lich su thu phat chi
	 * @throws NoSuchLichSuThuPhatChiException if a matching lich su thu phat chi could not be found
	 */
	@Override
	public LichSuThuPhatChi findByPhatVayId_Last(
			long phatVayId,
			OrderByComparator<LichSuThuPhatChi> orderByComparator)
		throws NoSuchLichSuThuPhatChiException {

		LichSuThuPhatChi lichSuThuPhatChi = fetchByPhatVayId_Last(
			phatVayId, orderByComparator);

		if (lichSuThuPhatChi != null) {
			return lichSuThuPhatChi;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("phatVayId=");
		msg.append(phatVayId);

		msg.append("}");

		throw new NoSuchLichSuThuPhatChiException(msg.toString());
	}

	/**
	 * Returns the last lich su thu phat chi in the ordered set where phatVayId = &#63;.
	 *
	 * @param phatVayId the phat vay ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lich su thu phat chi, or <code>null</code> if a matching lich su thu phat chi could not be found
	 */
	@Override
	public LichSuThuPhatChi fetchByPhatVayId_Last(
		long phatVayId, OrderByComparator<LichSuThuPhatChi> orderByComparator) {

		int count = countByPhatVayId(phatVayId);

		if (count == 0) {
			return null;
		}

		List<LichSuThuPhatChi> list = findByPhatVayId(
			phatVayId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lich su thu phat chis before and after the current lich su thu phat chi in the ordered set where phatVayId = &#63;.
	 *
	 * @param lichSuThuPhatChiId the primary key of the current lich su thu phat chi
	 * @param phatVayId the phat vay ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lich su thu phat chi
	 * @throws NoSuchLichSuThuPhatChiException if a lich su thu phat chi with the primary key could not be found
	 */
	@Override
	public LichSuThuPhatChi[] findByPhatVayId_PrevAndNext(
			long lichSuThuPhatChiId, long phatVayId,
			OrderByComparator<LichSuThuPhatChi> orderByComparator)
		throws NoSuchLichSuThuPhatChiException {

		LichSuThuPhatChi lichSuThuPhatChi = findByPrimaryKey(
			lichSuThuPhatChiId);

		Session session = null;

		try {
			session = openSession();

			LichSuThuPhatChi[] array = new LichSuThuPhatChiImpl[3];

			array[0] = getByPhatVayId_PrevAndNext(
				session, lichSuThuPhatChi, phatVayId, orderByComparator, true);

			array[1] = lichSuThuPhatChi;

			array[2] = getByPhatVayId_PrevAndNext(
				session, lichSuThuPhatChi, phatVayId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LichSuThuPhatChi getByPhatVayId_PrevAndNext(
		Session session, LichSuThuPhatChi lichSuThuPhatChi, long phatVayId,
		OrderByComparator<LichSuThuPhatChi> orderByComparator,
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

		query.append(_SQL_SELECT_LICHSUTHUPHATCHI_WHERE);

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
			query.append(LichSuThuPhatChiModelImpl.ORDER_BY_JPQL);
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
						lichSuThuPhatChi)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LichSuThuPhatChi> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lich su thu phat chis where phatVayId = &#63; from the database.
	 *
	 * @param phatVayId the phat vay ID
	 */
	@Override
	public void removeByPhatVayId(long phatVayId) {
		for (LichSuThuPhatChi lichSuThuPhatChi :
				findByPhatVayId(
					phatVayId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(lichSuThuPhatChi);
		}
	}

	/**
	 * Returns the number of lich su thu phat chis where phatVayId = &#63;.
	 *
	 * @param phatVayId the phat vay ID
	 * @return the number of matching lich su thu phat chis
	 */
	@Override
	public int countByPhatVayId(long phatVayId) {
		FinderPath finderPath = _finderPathCountByPhatVayId;

		Object[] finderArgs = new Object[] {phatVayId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LICHSUTHUPHATCHI_WHERE);

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
		"lichSuThuPhatChi.phatVayId = ?";

	private FinderPath _finderPathWithPaginationFindByPhatVayId_Loai;
	private FinderPath _finderPathWithoutPaginationFindByPhatVayId_Loai;
	private FinderPath _finderPathCountByPhatVayId_Loai;

	/**
	 * Returns all the lich su thu phat chis where phatVayId = &#63; and loai = &#63;.
	 *
	 * @param phatVayId the phat vay ID
	 * @param loai the loai
	 * @return the matching lich su thu phat chis
	 */
	@Override
	public List<LichSuThuPhatChi> findByPhatVayId_Loai(
		long phatVayId, int loai) {

		return findByPhatVayId_Loai(
			phatVayId, loai, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lich su thu phat chis where phatVayId = &#63; and loai = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LichSuThuPhatChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phatVayId the phat vay ID
	 * @param loai the loai
	 * @param start the lower bound of the range of lich su thu phat chis
	 * @param end the upper bound of the range of lich su thu phat chis (not inclusive)
	 * @return the range of matching lich su thu phat chis
	 */
	@Override
	public List<LichSuThuPhatChi> findByPhatVayId_Loai(
		long phatVayId, int loai, int start, int end) {

		return findByPhatVayId_Loai(phatVayId, loai, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lich su thu phat chis where phatVayId = &#63; and loai = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LichSuThuPhatChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phatVayId the phat vay ID
	 * @param loai the loai
	 * @param start the lower bound of the range of lich su thu phat chis
	 * @param end the upper bound of the range of lich su thu phat chis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lich su thu phat chis
	 */
	@Override
	public List<LichSuThuPhatChi> findByPhatVayId_Loai(
		long phatVayId, int loai, int start, int end,
		OrderByComparator<LichSuThuPhatChi> orderByComparator) {

		return findByPhatVayId_Loai(
			phatVayId, loai, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lich su thu phat chis where phatVayId = &#63; and loai = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LichSuThuPhatChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phatVayId the phat vay ID
	 * @param loai the loai
	 * @param start the lower bound of the range of lich su thu phat chis
	 * @param end the upper bound of the range of lich su thu phat chis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching lich su thu phat chis
	 */
	@Override
	public List<LichSuThuPhatChi> findByPhatVayId_Loai(
		long phatVayId, int loai, int start, int end,
		OrderByComparator<LichSuThuPhatChi> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByPhatVayId_Loai;
			finderArgs = new Object[] {phatVayId, loai};
		}
		else {
			finderPath = _finderPathWithPaginationFindByPhatVayId_Loai;
			finderArgs = new Object[] {
				phatVayId, loai, start, end, orderByComparator
			};
		}

		List<LichSuThuPhatChi> list = null;

		if (retrieveFromCache) {
			list = (List<LichSuThuPhatChi>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LichSuThuPhatChi lichSuThuPhatChi : list) {
					if ((phatVayId != lichSuThuPhatChi.getPhatVayId()) ||
						(loai != lichSuThuPhatChi.getLoai())) {

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

			query.append(_SQL_SELECT_LICHSUTHUPHATCHI_WHERE);

			query.append(_FINDER_COLUMN_PHATVAYID_LOAI_PHATVAYID_2);

			query.append(_FINDER_COLUMN_PHATVAYID_LOAI_LOAI_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(LichSuThuPhatChiModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(phatVayId);

				qPos.add(loai);

				if (!pagination) {
					list = (List<LichSuThuPhatChi>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<LichSuThuPhatChi>)QueryUtil.list(
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
	 * Returns the first lich su thu phat chi in the ordered set where phatVayId = &#63; and loai = &#63;.
	 *
	 * @param phatVayId the phat vay ID
	 * @param loai the loai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lich su thu phat chi
	 * @throws NoSuchLichSuThuPhatChiException if a matching lich su thu phat chi could not be found
	 */
	@Override
	public LichSuThuPhatChi findByPhatVayId_Loai_First(
			long phatVayId, int loai,
			OrderByComparator<LichSuThuPhatChi> orderByComparator)
		throws NoSuchLichSuThuPhatChiException {

		LichSuThuPhatChi lichSuThuPhatChi = fetchByPhatVayId_Loai_First(
			phatVayId, loai, orderByComparator);

		if (lichSuThuPhatChi != null) {
			return lichSuThuPhatChi;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("phatVayId=");
		msg.append(phatVayId);

		msg.append(", loai=");
		msg.append(loai);

		msg.append("}");

		throw new NoSuchLichSuThuPhatChiException(msg.toString());
	}

	/**
	 * Returns the first lich su thu phat chi in the ordered set where phatVayId = &#63; and loai = &#63;.
	 *
	 * @param phatVayId the phat vay ID
	 * @param loai the loai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lich su thu phat chi, or <code>null</code> if a matching lich su thu phat chi could not be found
	 */
	@Override
	public LichSuThuPhatChi fetchByPhatVayId_Loai_First(
		long phatVayId, int loai,
		OrderByComparator<LichSuThuPhatChi> orderByComparator) {

		List<LichSuThuPhatChi> list = findByPhatVayId_Loai(
			phatVayId, loai, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lich su thu phat chi in the ordered set where phatVayId = &#63; and loai = &#63;.
	 *
	 * @param phatVayId the phat vay ID
	 * @param loai the loai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lich su thu phat chi
	 * @throws NoSuchLichSuThuPhatChiException if a matching lich su thu phat chi could not be found
	 */
	@Override
	public LichSuThuPhatChi findByPhatVayId_Loai_Last(
			long phatVayId, int loai,
			OrderByComparator<LichSuThuPhatChi> orderByComparator)
		throws NoSuchLichSuThuPhatChiException {

		LichSuThuPhatChi lichSuThuPhatChi = fetchByPhatVayId_Loai_Last(
			phatVayId, loai, orderByComparator);

		if (lichSuThuPhatChi != null) {
			return lichSuThuPhatChi;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("phatVayId=");
		msg.append(phatVayId);

		msg.append(", loai=");
		msg.append(loai);

		msg.append("}");

		throw new NoSuchLichSuThuPhatChiException(msg.toString());
	}

	/**
	 * Returns the last lich su thu phat chi in the ordered set where phatVayId = &#63; and loai = &#63;.
	 *
	 * @param phatVayId the phat vay ID
	 * @param loai the loai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lich su thu phat chi, or <code>null</code> if a matching lich su thu phat chi could not be found
	 */
	@Override
	public LichSuThuPhatChi fetchByPhatVayId_Loai_Last(
		long phatVayId, int loai,
		OrderByComparator<LichSuThuPhatChi> orderByComparator) {

		int count = countByPhatVayId_Loai(phatVayId, loai);

		if (count == 0) {
			return null;
		}

		List<LichSuThuPhatChi> list = findByPhatVayId_Loai(
			phatVayId, loai, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lich su thu phat chis before and after the current lich su thu phat chi in the ordered set where phatVayId = &#63; and loai = &#63;.
	 *
	 * @param lichSuThuPhatChiId the primary key of the current lich su thu phat chi
	 * @param phatVayId the phat vay ID
	 * @param loai the loai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lich su thu phat chi
	 * @throws NoSuchLichSuThuPhatChiException if a lich su thu phat chi with the primary key could not be found
	 */
	@Override
	public LichSuThuPhatChi[] findByPhatVayId_Loai_PrevAndNext(
			long lichSuThuPhatChiId, long phatVayId, int loai,
			OrderByComparator<LichSuThuPhatChi> orderByComparator)
		throws NoSuchLichSuThuPhatChiException {

		LichSuThuPhatChi lichSuThuPhatChi = findByPrimaryKey(
			lichSuThuPhatChiId);

		Session session = null;

		try {
			session = openSession();

			LichSuThuPhatChi[] array = new LichSuThuPhatChiImpl[3];

			array[0] = getByPhatVayId_Loai_PrevAndNext(
				session, lichSuThuPhatChi, phatVayId, loai, orderByComparator,
				true);

			array[1] = lichSuThuPhatChi;

			array[2] = getByPhatVayId_Loai_PrevAndNext(
				session, lichSuThuPhatChi, phatVayId, loai, orderByComparator,
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

	protected LichSuThuPhatChi getByPhatVayId_Loai_PrevAndNext(
		Session session, LichSuThuPhatChi lichSuThuPhatChi, long phatVayId,
		int loai, OrderByComparator<LichSuThuPhatChi> orderByComparator,
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

		query.append(_SQL_SELECT_LICHSUTHUPHATCHI_WHERE);

		query.append(_FINDER_COLUMN_PHATVAYID_LOAI_PHATVAYID_2);

		query.append(_FINDER_COLUMN_PHATVAYID_LOAI_LOAI_2);

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
			query.append(LichSuThuPhatChiModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(phatVayId);

		qPos.add(loai);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						lichSuThuPhatChi)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LichSuThuPhatChi> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lich su thu phat chis where phatVayId = &#63; and loai = &#63; from the database.
	 *
	 * @param phatVayId the phat vay ID
	 * @param loai the loai
	 */
	@Override
	public void removeByPhatVayId_Loai(long phatVayId, int loai) {
		for (LichSuThuPhatChi lichSuThuPhatChi :
				findByPhatVayId_Loai(
					phatVayId, loai, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(lichSuThuPhatChi);
		}
	}

	/**
	 * Returns the number of lich su thu phat chis where phatVayId = &#63; and loai = &#63;.
	 *
	 * @param phatVayId the phat vay ID
	 * @param loai the loai
	 * @return the number of matching lich su thu phat chis
	 */
	@Override
	public int countByPhatVayId_Loai(long phatVayId, int loai) {
		FinderPath finderPath = _finderPathCountByPhatVayId_Loai;

		Object[] finderArgs = new Object[] {phatVayId, loai};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LICHSUTHUPHATCHI_WHERE);

			query.append(_FINDER_COLUMN_PHATVAYID_LOAI_PHATVAYID_2);

			query.append(_FINDER_COLUMN_PHATVAYID_LOAI_LOAI_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(phatVayId);

				qPos.add(loai);

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

	private static final String _FINDER_COLUMN_PHATVAYID_LOAI_PHATVAYID_2 =
		"lichSuThuPhatChi.phatVayId = ? AND ";

	private static final String _FINDER_COLUMN_PHATVAYID_LOAI_LOAI_2 =
		"lichSuThuPhatChi.loai = ?";

	public LichSuThuPhatChiPersistenceImpl() {
		setModelClass(LichSuThuPhatChi.class);
	}

	/**
	 * Caches the lich su thu phat chi in the entity cache if it is enabled.
	 *
	 * @param lichSuThuPhatChi the lich su thu phat chi
	 */
	@Override
	public void cacheResult(LichSuThuPhatChi lichSuThuPhatChi) {
		entityCache.putResult(
			LichSuThuPhatChiModelImpl.ENTITY_CACHE_ENABLED,
			LichSuThuPhatChiImpl.class, lichSuThuPhatChi.getPrimaryKey(),
			lichSuThuPhatChi);

		lichSuThuPhatChi.resetOriginalValues();
	}

	/**
	 * Caches the lich su thu phat chis in the entity cache if it is enabled.
	 *
	 * @param lichSuThuPhatChis the lich su thu phat chis
	 */
	@Override
	public void cacheResult(List<LichSuThuPhatChi> lichSuThuPhatChis) {
		for (LichSuThuPhatChi lichSuThuPhatChi : lichSuThuPhatChis) {
			if (entityCache.getResult(
					LichSuThuPhatChiModelImpl.ENTITY_CACHE_ENABLED,
					LichSuThuPhatChiImpl.class,
					lichSuThuPhatChi.getPrimaryKey()) == null) {

				cacheResult(lichSuThuPhatChi);
			}
			else {
				lichSuThuPhatChi.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all lich su thu phat chis.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LichSuThuPhatChiImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the lich su thu phat chi.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LichSuThuPhatChi lichSuThuPhatChi) {
		entityCache.removeResult(
			LichSuThuPhatChiModelImpl.ENTITY_CACHE_ENABLED,
			LichSuThuPhatChiImpl.class, lichSuThuPhatChi.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LichSuThuPhatChi> lichSuThuPhatChis) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LichSuThuPhatChi lichSuThuPhatChi : lichSuThuPhatChis) {
			entityCache.removeResult(
				LichSuThuPhatChiModelImpl.ENTITY_CACHE_ENABLED,
				LichSuThuPhatChiImpl.class, lichSuThuPhatChi.getPrimaryKey());
		}
	}

	/**
	 * Creates a new lich su thu phat chi with the primary key. Does not add the lich su thu phat chi to the database.
	 *
	 * @param lichSuThuPhatChiId the primary key for the new lich su thu phat chi
	 * @return the new lich su thu phat chi
	 */
	@Override
	public LichSuThuPhatChi create(long lichSuThuPhatChiId) {
		LichSuThuPhatChi lichSuThuPhatChi = new LichSuThuPhatChiImpl();

		lichSuThuPhatChi.setNew(true);
		lichSuThuPhatChi.setPrimaryKey(lichSuThuPhatChiId);

		lichSuThuPhatChi.setCompanyId(companyProvider.getCompanyId());

		return lichSuThuPhatChi;
	}

	/**
	 * Removes the lich su thu phat chi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lichSuThuPhatChiId the primary key of the lich su thu phat chi
	 * @return the lich su thu phat chi that was removed
	 * @throws NoSuchLichSuThuPhatChiException if a lich su thu phat chi with the primary key could not be found
	 */
	@Override
	public LichSuThuPhatChi remove(long lichSuThuPhatChiId)
		throws NoSuchLichSuThuPhatChiException {

		return remove((Serializable)lichSuThuPhatChiId);
	}

	/**
	 * Removes the lich su thu phat chi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the lich su thu phat chi
	 * @return the lich su thu phat chi that was removed
	 * @throws NoSuchLichSuThuPhatChiException if a lich su thu phat chi with the primary key could not be found
	 */
	@Override
	public LichSuThuPhatChi remove(Serializable primaryKey)
		throws NoSuchLichSuThuPhatChiException {

		Session session = null;

		try {
			session = openSession();

			LichSuThuPhatChi lichSuThuPhatChi = (LichSuThuPhatChi)session.get(
				LichSuThuPhatChiImpl.class, primaryKey);

			if (lichSuThuPhatChi == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLichSuThuPhatChiException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(lichSuThuPhatChi);
		}
		catch (NoSuchLichSuThuPhatChiException nsee) {
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
	protected LichSuThuPhatChi removeImpl(LichSuThuPhatChi lichSuThuPhatChi) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(lichSuThuPhatChi)) {
				lichSuThuPhatChi = (LichSuThuPhatChi)session.get(
					LichSuThuPhatChiImpl.class,
					lichSuThuPhatChi.getPrimaryKeyObj());
			}

			if (lichSuThuPhatChi != null) {
				session.delete(lichSuThuPhatChi);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (lichSuThuPhatChi != null) {
			clearCache(lichSuThuPhatChi);
		}

		return lichSuThuPhatChi;
	}

	@Override
	public LichSuThuPhatChi updateImpl(LichSuThuPhatChi lichSuThuPhatChi) {
		boolean isNew = lichSuThuPhatChi.isNew();

		if (!(lichSuThuPhatChi instanceof LichSuThuPhatChiModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(lichSuThuPhatChi.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					lichSuThuPhatChi);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in lichSuThuPhatChi proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LichSuThuPhatChi implementation " +
					lichSuThuPhatChi.getClass());
		}

		LichSuThuPhatChiModelImpl lichSuThuPhatChiModelImpl =
			(LichSuThuPhatChiModelImpl)lichSuThuPhatChi;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (lichSuThuPhatChi.getCreateDate() == null)) {
			if (serviceContext == null) {
				lichSuThuPhatChi.setCreateDate(now);
			}
			else {
				lichSuThuPhatChi.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!lichSuThuPhatChiModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				lichSuThuPhatChi.setModifiedDate(now);
			}
			else {
				lichSuThuPhatChi.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (lichSuThuPhatChi.isNew()) {
				session.save(lichSuThuPhatChi);

				lichSuThuPhatChi.setNew(false);
			}
			else {
				lichSuThuPhatChi = (LichSuThuPhatChi)session.merge(
					lichSuThuPhatChi);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!LichSuThuPhatChiModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {lichSuThuPhatChiModelImpl.getMaCTV()};

			finderCache.removeResult(_finderPathCountByMaCTV, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByMaCTV, args);

			args = new Object[] {lichSuThuPhatChiModelImpl.getPhatVayId()};

			finderCache.removeResult(_finderPathCountByPhatVayId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByPhatVayId, args);

			args = new Object[] {
				lichSuThuPhatChiModelImpl.getPhatVayId(),
				lichSuThuPhatChiModelImpl.getLoai()
			};

			finderCache.removeResult(_finderPathCountByPhatVayId_Loai, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByPhatVayId_Loai, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((lichSuThuPhatChiModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByMaCTV.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					lichSuThuPhatChiModelImpl.getOriginalMaCTV()
				};

				finderCache.removeResult(_finderPathCountByMaCTV, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByMaCTV, args);

				args = new Object[] {lichSuThuPhatChiModelImpl.getMaCTV()};

				finderCache.removeResult(_finderPathCountByMaCTV, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByMaCTV, args);
			}

			if ((lichSuThuPhatChiModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByPhatVayId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					lichSuThuPhatChiModelImpl.getOriginalPhatVayId()
				};

				finderCache.removeResult(_finderPathCountByPhatVayId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByPhatVayId, args);

				args = new Object[] {lichSuThuPhatChiModelImpl.getPhatVayId()};

				finderCache.removeResult(_finderPathCountByPhatVayId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByPhatVayId, args);
			}

			if ((lichSuThuPhatChiModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByPhatVayId_Loai.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					lichSuThuPhatChiModelImpl.getOriginalPhatVayId(),
					lichSuThuPhatChiModelImpl.getOriginalLoai()
				};

				finderCache.removeResult(
					_finderPathCountByPhatVayId_Loai, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByPhatVayId_Loai, args);

				args = new Object[] {
					lichSuThuPhatChiModelImpl.getPhatVayId(),
					lichSuThuPhatChiModelImpl.getLoai()
				};

				finderCache.removeResult(
					_finderPathCountByPhatVayId_Loai, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByPhatVayId_Loai, args);
			}
		}

		entityCache.putResult(
			LichSuThuPhatChiModelImpl.ENTITY_CACHE_ENABLED,
			LichSuThuPhatChiImpl.class, lichSuThuPhatChi.getPrimaryKey(),
			lichSuThuPhatChi, false);

		lichSuThuPhatChi.resetOriginalValues();

		return lichSuThuPhatChi;
	}

	/**
	 * Returns the lich su thu phat chi with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the lich su thu phat chi
	 * @return the lich su thu phat chi
	 * @throws NoSuchLichSuThuPhatChiException if a lich su thu phat chi with the primary key could not be found
	 */
	@Override
	public LichSuThuPhatChi findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLichSuThuPhatChiException {

		LichSuThuPhatChi lichSuThuPhatChi = fetchByPrimaryKey(primaryKey);

		if (lichSuThuPhatChi == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLichSuThuPhatChiException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return lichSuThuPhatChi;
	}

	/**
	 * Returns the lich su thu phat chi with the primary key or throws a <code>NoSuchLichSuThuPhatChiException</code> if it could not be found.
	 *
	 * @param lichSuThuPhatChiId the primary key of the lich su thu phat chi
	 * @return the lich su thu phat chi
	 * @throws NoSuchLichSuThuPhatChiException if a lich su thu phat chi with the primary key could not be found
	 */
	@Override
	public LichSuThuPhatChi findByPrimaryKey(long lichSuThuPhatChiId)
		throws NoSuchLichSuThuPhatChiException {

		return findByPrimaryKey((Serializable)lichSuThuPhatChiId);
	}

	/**
	 * Returns the lich su thu phat chi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the lich su thu phat chi
	 * @return the lich su thu phat chi, or <code>null</code> if a lich su thu phat chi with the primary key could not be found
	 */
	@Override
	public LichSuThuPhatChi fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			LichSuThuPhatChiModelImpl.ENTITY_CACHE_ENABLED,
			LichSuThuPhatChiImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		LichSuThuPhatChi lichSuThuPhatChi = (LichSuThuPhatChi)serializable;

		if (lichSuThuPhatChi == null) {
			Session session = null;

			try {
				session = openSession();

				lichSuThuPhatChi = (LichSuThuPhatChi)session.get(
					LichSuThuPhatChiImpl.class, primaryKey);

				if (lichSuThuPhatChi != null) {
					cacheResult(lichSuThuPhatChi);
				}
				else {
					entityCache.putResult(
						LichSuThuPhatChiModelImpl.ENTITY_CACHE_ENABLED,
						LichSuThuPhatChiImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					LichSuThuPhatChiModelImpl.ENTITY_CACHE_ENABLED,
					LichSuThuPhatChiImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return lichSuThuPhatChi;
	}

	/**
	 * Returns the lich su thu phat chi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lichSuThuPhatChiId the primary key of the lich su thu phat chi
	 * @return the lich su thu phat chi, or <code>null</code> if a lich su thu phat chi with the primary key could not be found
	 */
	@Override
	public LichSuThuPhatChi fetchByPrimaryKey(long lichSuThuPhatChiId) {
		return fetchByPrimaryKey((Serializable)lichSuThuPhatChiId);
	}

	@Override
	public Map<Serializable, LichSuThuPhatChi> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, LichSuThuPhatChi> map =
			new HashMap<Serializable, LichSuThuPhatChi>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			LichSuThuPhatChi lichSuThuPhatChi = fetchByPrimaryKey(primaryKey);

			if (lichSuThuPhatChi != null) {
				map.put(primaryKey, lichSuThuPhatChi);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				LichSuThuPhatChiModelImpl.ENTITY_CACHE_ENABLED,
				LichSuThuPhatChiImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (LichSuThuPhatChi)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_LICHSUTHUPHATCHI_WHERE_PKS_IN);

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

			for (LichSuThuPhatChi lichSuThuPhatChi :
					(List<LichSuThuPhatChi>)q.list()) {

				map.put(lichSuThuPhatChi.getPrimaryKeyObj(), lichSuThuPhatChi);

				cacheResult(lichSuThuPhatChi);

				uncachedPrimaryKeys.remove(lichSuThuPhatChi.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					LichSuThuPhatChiModelImpl.ENTITY_CACHE_ENABLED,
					LichSuThuPhatChiImpl.class, primaryKey, nullModel);
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
	 * Returns all the lich su thu phat chis.
	 *
	 * @return the lich su thu phat chis
	 */
	@Override
	public List<LichSuThuPhatChi> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lich su thu phat chis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LichSuThuPhatChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lich su thu phat chis
	 * @param end the upper bound of the range of lich su thu phat chis (not inclusive)
	 * @return the range of lich su thu phat chis
	 */
	@Override
	public List<LichSuThuPhatChi> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the lich su thu phat chis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LichSuThuPhatChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lich su thu phat chis
	 * @param end the upper bound of the range of lich su thu phat chis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lich su thu phat chis
	 */
	@Override
	public List<LichSuThuPhatChi> findAll(
		int start, int end,
		OrderByComparator<LichSuThuPhatChi> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lich su thu phat chis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LichSuThuPhatChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lich su thu phat chis
	 * @param end the upper bound of the range of lich su thu phat chis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of lich su thu phat chis
	 */
	@Override
	public List<LichSuThuPhatChi> findAll(
		int start, int end,
		OrderByComparator<LichSuThuPhatChi> orderByComparator,
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

		List<LichSuThuPhatChi> list = null;

		if (retrieveFromCache) {
			list = (List<LichSuThuPhatChi>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LICHSUTHUPHATCHI);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LICHSUTHUPHATCHI;

				if (pagination) {
					sql = sql.concat(LichSuThuPhatChiModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LichSuThuPhatChi>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<LichSuThuPhatChi>)QueryUtil.list(
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
	 * Removes all the lich su thu phat chis from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LichSuThuPhatChi lichSuThuPhatChi : findAll()) {
			remove(lichSuThuPhatChi);
		}
	}

	/**
	 * Returns the number of lich su thu phat chis.
	 *
	 * @return the number of lich su thu phat chis
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LICHSUTHUPHATCHI);

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
		return LichSuThuPhatChiModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the lich su thu phat chi persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			LichSuThuPhatChiModelImpl.ENTITY_CACHE_ENABLED,
			LichSuThuPhatChiModelImpl.FINDER_CACHE_ENABLED,
			LichSuThuPhatChiImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			LichSuThuPhatChiModelImpl.ENTITY_CACHE_ENABLED,
			LichSuThuPhatChiModelImpl.FINDER_CACHE_ENABLED,
			LichSuThuPhatChiImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			LichSuThuPhatChiModelImpl.ENTITY_CACHE_ENABLED,
			LichSuThuPhatChiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByMaCTV = new FinderPath(
			LichSuThuPhatChiModelImpl.ENTITY_CACHE_ENABLED,
			LichSuThuPhatChiModelImpl.FINDER_CACHE_ENABLED,
			LichSuThuPhatChiImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByMaCTV",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByMaCTV = new FinderPath(
			LichSuThuPhatChiModelImpl.ENTITY_CACHE_ENABLED,
			LichSuThuPhatChiModelImpl.FINDER_CACHE_ENABLED,
			LichSuThuPhatChiImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMaCTV",
			new String[] {String.class.getName()},
			LichSuThuPhatChiModelImpl.MACTV_COLUMN_BITMASK);

		_finderPathCountByMaCTV = new FinderPath(
			LichSuThuPhatChiModelImpl.ENTITY_CACHE_ENABLED,
			LichSuThuPhatChiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMaCTV",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByPhatVayId = new FinderPath(
			LichSuThuPhatChiModelImpl.ENTITY_CACHE_ENABLED,
			LichSuThuPhatChiModelImpl.FINDER_CACHE_ENABLED,
			LichSuThuPhatChiImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPhatVayId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByPhatVayId = new FinderPath(
			LichSuThuPhatChiModelImpl.ENTITY_CACHE_ENABLED,
			LichSuThuPhatChiModelImpl.FINDER_CACHE_ENABLED,
			LichSuThuPhatChiImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPhatVayId",
			new String[] {Long.class.getName()},
			LichSuThuPhatChiModelImpl.PHATVAYID_COLUMN_BITMASK);

		_finderPathCountByPhatVayId = new FinderPath(
			LichSuThuPhatChiModelImpl.ENTITY_CACHE_ENABLED,
			LichSuThuPhatChiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPhatVayId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByPhatVayId_Loai = new FinderPath(
			LichSuThuPhatChiModelImpl.ENTITY_CACHE_ENABLED,
			LichSuThuPhatChiModelImpl.FINDER_CACHE_ENABLED,
			LichSuThuPhatChiImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPhatVayId_Loai",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByPhatVayId_Loai = new FinderPath(
			LichSuThuPhatChiModelImpl.ENTITY_CACHE_ENABLED,
			LichSuThuPhatChiModelImpl.FINDER_CACHE_ENABLED,
			LichSuThuPhatChiImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPhatVayId_Loai",
			new String[] {Long.class.getName(), Integer.class.getName()},
			LichSuThuPhatChiModelImpl.PHATVAYID_COLUMN_BITMASK |
			LichSuThuPhatChiModelImpl.LOAI_COLUMN_BITMASK);

		_finderPathCountByPhatVayId_Loai = new FinderPath(
			LichSuThuPhatChiModelImpl.ENTITY_CACHE_ENABLED,
			LichSuThuPhatChiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPhatVayId_Loai",
			new String[] {Long.class.getName(), Integer.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(LichSuThuPhatChiImpl.class.getName());
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

	private static final String _SQL_SELECT_LICHSUTHUPHATCHI =
		"SELECT lichSuThuPhatChi FROM LichSuThuPhatChi lichSuThuPhatChi";

	private static final String _SQL_SELECT_LICHSUTHUPHATCHI_WHERE_PKS_IN =
		"SELECT lichSuThuPhatChi FROM LichSuThuPhatChi lichSuThuPhatChi WHERE lichSuThuPhatChiId IN (";

	private static final String _SQL_SELECT_LICHSUTHUPHATCHI_WHERE =
		"SELECT lichSuThuPhatChi FROM LichSuThuPhatChi lichSuThuPhatChi WHERE ";

	private static final String _SQL_COUNT_LICHSUTHUPHATCHI =
		"SELECT COUNT(lichSuThuPhatChi) FROM LichSuThuPhatChi lichSuThuPhatChi";

	private static final String _SQL_COUNT_LICHSUTHUPHATCHI_WHERE =
		"SELECT COUNT(lichSuThuPhatChi) FROM LichSuThuPhatChi lichSuThuPhatChi WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "lichSuThuPhatChi.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No LichSuThuPhatChi exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No LichSuThuPhatChi exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LichSuThuPhatChiPersistenceImpl.class);

}