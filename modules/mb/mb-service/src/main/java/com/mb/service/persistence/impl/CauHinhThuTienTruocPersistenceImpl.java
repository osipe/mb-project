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

import com.mb.exception.NoSuchCauHinhThuTienTruocException;
import com.mb.model.CauHinhThuTienTruoc;
import com.mb.model.impl.CauHinhThuTienTruocImpl;
import com.mb.model.impl.CauHinhThuTienTruocModelImpl;
import com.mb.service.persistence.CauHinhThuTienTruocPersistence;

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
 * The persistence implementation for the cau hinh thu tien truoc service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class CauHinhThuTienTruocPersistenceImpl
	extends BasePersistenceImpl<CauHinhThuTienTruoc>
	implements CauHinhThuTienTruocPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CauHinhThuTienTruocUtil</code> to access the cau hinh thu tien truoc persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CauHinhThuTienTruocImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByNam;
	private FinderPath _finderPathCountByNam;

	/**
	 * Returns the cau hinh thu tien truoc where nam = &#63; or throws a <code>NoSuchCauHinhThuTienTruocException</code> if it could not be found.
	 *
	 * @param nam the nam
	 * @return the matching cau hinh thu tien truoc
	 * @throws NoSuchCauHinhThuTienTruocException if a matching cau hinh thu tien truoc could not be found
	 */
	@Override
	public CauHinhThuTienTruoc findByNam(int nam)
		throws NoSuchCauHinhThuTienTruocException {

		CauHinhThuTienTruoc cauHinhThuTienTruoc = fetchByNam(nam);

		if (cauHinhThuTienTruoc == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("nam=");
			msg.append(nam);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchCauHinhThuTienTruocException(msg.toString());
		}

		return cauHinhThuTienTruoc;
	}

	/**
	 * Returns the cau hinh thu tien truoc where nam = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nam the nam
	 * @return the matching cau hinh thu tien truoc, or <code>null</code> if a matching cau hinh thu tien truoc could not be found
	 */
	@Override
	public CauHinhThuTienTruoc fetchByNam(int nam) {
		return fetchByNam(nam, true);
	}

	/**
	 * Returns the cau hinh thu tien truoc where nam = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nam the nam
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching cau hinh thu tien truoc, or <code>null</code> if a matching cau hinh thu tien truoc could not be found
	 */
	@Override
	public CauHinhThuTienTruoc fetchByNam(int nam, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] {nam};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByNam, finderArgs, this);
		}

		if (result instanceof CauHinhThuTienTruoc) {
			CauHinhThuTienTruoc cauHinhThuTienTruoc =
				(CauHinhThuTienTruoc)result;

			if ((nam != cauHinhThuTienTruoc.getNam())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_CAUHINHTHUTIENTRUOC_WHERE);

			query.append(_FINDER_COLUMN_NAM_NAM_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(nam);

				List<CauHinhThuTienTruoc> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByNam, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"CauHinhThuTienTruocPersistenceImpl.fetchByNam(int, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					CauHinhThuTienTruoc cauHinhThuTienTruoc = list.get(0);

					result = cauHinhThuTienTruoc;

					cacheResult(cauHinhThuTienTruoc);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(_finderPathFetchByNam, finderArgs);

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
			return (CauHinhThuTienTruoc)result;
		}
	}

	/**
	 * Removes the cau hinh thu tien truoc where nam = &#63; from the database.
	 *
	 * @param nam the nam
	 * @return the cau hinh thu tien truoc that was removed
	 */
	@Override
	public CauHinhThuTienTruoc removeByNam(int nam)
		throws NoSuchCauHinhThuTienTruocException {

		CauHinhThuTienTruoc cauHinhThuTienTruoc = findByNam(nam);

		return remove(cauHinhThuTienTruoc);
	}

	/**
	 * Returns the number of cau hinh thu tien truocs where nam = &#63;.
	 *
	 * @param nam the nam
	 * @return the number of matching cau hinh thu tien truocs
	 */
	@Override
	public int countByNam(int nam) {
		FinderPath finderPath = _finderPathCountByNam;

		Object[] finderArgs = new Object[] {nam};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CAUHINHTHUTIENTRUOC_WHERE);

			query.append(_FINDER_COLUMN_NAM_NAM_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(nam);

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

	private static final String _FINDER_COLUMN_NAM_NAM_2 =
		"cauHinhThuTienTruoc.nam = ?";

	private FinderPath _finderPathWithPaginationFindByHoatDong;
	private FinderPath _finderPathWithoutPaginationFindByHoatDong;
	private FinderPath _finderPathCountByHoatDong;

	/**
	 * Returns all the cau hinh thu tien truocs where hoatDong = &#63;.
	 *
	 * @param hoatDong the hoat dong
	 * @return the matching cau hinh thu tien truocs
	 */
	@Override
	public List<CauHinhThuTienTruoc> findByHoatDong(Boolean hoatDong) {
		return findByHoatDong(
			hoatDong, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cau hinh thu tien truocs where hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CauHinhThuTienTruocModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of cau hinh thu tien truocs
	 * @param end the upper bound of the range of cau hinh thu tien truocs (not inclusive)
	 * @return the range of matching cau hinh thu tien truocs
	 */
	@Override
	public List<CauHinhThuTienTruoc> findByHoatDong(
		Boolean hoatDong, int start, int end) {

		return findByHoatDong(hoatDong, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cau hinh thu tien truocs where hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CauHinhThuTienTruocModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of cau hinh thu tien truocs
	 * @param end the upper bound of the range of cau hinh thu tien truocs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cau hinh thu tien truocs
	 */
	@Override
	public List<CauHinhThuTienTruoc> findByHoatDong(
		Boolean hoatDong, int start, int end,
		OrderByComparator<CauHinhThuTienTruoc> orderByComparator) {

		return findByHoatDong(hoatDong, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cau hinh thu tien truocs where hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CauHinhThuTienTruocModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of cau hinh thu tien truocs
	 * @param end the upper bound of the range of cau hinh thu tien truocs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching cau hinh thu tien truocs
	 */
	@Override
	public List<CauHinhThuTienTruoc> findByHoatDong(
		Boolean hoatDong, int start, int end,
		OrderByComparator<CauHinhThuTienTruoc> orderByComparator,
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

		List<CauHinhThuTienTruoc> list = null;

		if (retrieveFromCache) {
			list = (List<CauHinhThuTienTruoc>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CauHinhThuTienTruoc cauHinhThuTienTruoc : list) {
					if (!Objects.equals(
							hoatDong, cauHinhThuTienTruoc.getHoatDong())) {

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

			query.append(_SQL_SELECT_CAUHINHTHUTIENTRUOC_WHERE);

			query.append(_FINDER_COLUMN_HOATDONG_HOATDONG_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(CauHinhThuTienTruocModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(hoatDong.booleanValue());

				if (!pagination) {
					list = (List<CauHinhThuTienTruoc>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CauHinhThuTienTruoc>)QueryUtil.list(
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
	 * Returns the first cau hinh thu tien truoc in the ordered set where hoatDong = &#63;.
	 *
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cau hinh thu tien truoc
	 * @throws NoSuchCauHinhThuTienTruocException if a matching cau hinh thu tien truoc could not be found
	 */
	@Override
	public CauHinhThuTienTruoc findByHoatDong_First(
			Boolean hoatDong,
			OrderByComparator<CauHinhThuTienTruoc> orderByComparator)
		throws NoSuchCauHinhThuTienTruocException {

		CauHinhThuTienTruoc cauHinhThuTienTruoc = fetchByHoatDong_First(
			hoatDong, orderByComparator);

		if (cauHinhThuTienTruoc != null) {
			return cauHinhThuTienTruoc;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("hoatDong=");
		msg.append(hoatDong);

		msg.append("}");

		throw new NoSuchCauHinhThuTienTruocException(msg.toString());
	}

	/**
	 * Returns the first cau hinh thu tien truoc in the ordered set where hoatDong = &#63;.
	 *
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cau hinh thu tien truoc, or <code>null</code> if a matching cau hinh thu tien truoc could not be found
	 */
	@Override
	public CauHinhThuTienTruoc fetchByHoatDong_First(
		Boolean hoatDong,
		OrderByComparator<CauHinhThuTienTruoc> orderByComparator) {

		List<CauHinhThuTienTruoc> list = findByHoatDong(
			hoatDong, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cau hinh thu tien truoc in the ordered set where hoatDong = &#63;.
	 *
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cau hinh thu tien truoc
	 * @throws NoSuchCauHinhThuTienTruocException if a matching cau hinh thu tien truoc could not be found
	 */
	@Override
	public CauHinhThuTienTruoc findByHoatDong_Last(
			Boolean hoatDong,
			OrderByComparator<CauHinhThuTienTruoc> orderByComparator)
		throws NoSuchCauHinhThuTienTruocException {

		CauHinhThuTienTruoc cauHinhThuTienTruoc = fetchByHoatDong_Last(
			hoatDong, orderByComparator);

		if (cauHinhThuTienTruoc != null) {
			return cauHinhThuTienTruoc;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("hoatDong=");
		msg.append(hoatDong);

		msg.append("}");

		throw new NoSuchCauHinhThuTienTruocException(msg.toString());
	}

	/**
	 * Returns the last cau hinh thu tien truoc in the ordered set where hoatDong = &#63;.
	 *
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cau hinh thu tien truoc, or <code>null</code> if a matching cau hinh thu tien truoc could not be found
	 */
	@Override
	public CauHinhThuTienTruoc fetchByHoatDong_Last(
		Boolean hoatDong,
		OrderByComparator<CauHinhThuTienTruoc> orderByComparator) {

		int count = countByHoatDong(hoatDong);

		if (count == 0) {
			return null;
		}

		List<CauHinhThuTienTruoc> list = findByHoatDong(
			hoatDong, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cau hinh thu tien truocs before and after the current cau hinh thu tien truoc in the ordered set where hoatDong = &#63;.
	 *
	 * @param cauHinhThuTienTruocId the primary key of the current cau hinh thu tien truoc
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cau hinh thu tien truoc
	 * @throws NoSuchCauHinhThuTienTruocException if a cau hinh thu tien truoc with the primary key could not be found
	 */
	@Override
	public CauHinhThuTienTruoc[] findByHoatDong_PrevAndNext(
			long cauHinhThuTienTruocId, Boolean hoatDong,
			OrderByComparator<CauHinhThuTienTruoc> orderByComparator)
		throws NoSuchCauHinhThuTienTruocException {

		CauHinhThuTienTruoc cauHinhThuTienTruoc = findByPrimaryKey(
			cauHinhThuTienTruocId);

		Session session = null;

		try {
			session = openSession();

			CauHinhThuTienTruoc[] array = new CauHinhThuTienTruocImpl[3];

			array[0] = getByHoatDong_PrevAndNext(
				session, cauHinhThuTienTruoc, hoatDong, orderByComparator,
				true);

			array[1] = cauHinhThuTienTruoc;

			array[2] = getByHoatDong_PrevAndNext(
				session, cauHinhThuTienTruoc, hoatDong, orderByComparator,
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

	protected CauHinhThuTienTruoc getByHoatDong_PrevAndNext(
		Session session, CauHinhThuTienTruoc cauHinhThuTienTruoc,
		Boolean hoatDong,
		OrderByComparator<CauHinhThuTienTruoc> orderByComparator,
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

		query.append(_SQL_SELECT_CAUHINHTHUTIENTRUOC_WHERE);

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
			query.append(CauHinhThuTienTruocModelImpl.ORDER_BY_JPQL);
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
						cauHinhThuTienTruoc)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<CauHinhThuTienTruoc> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cau hinh thu tien truocs where hoatDong = &#63; from the database.
	 *
	 * @param hoatDong the hoat dong
	 */
	@Override
	public void removeByHoatDong(Boolean hoatDong) {
		for (CauHinhThuTienTruoc cauHinhThuTienTruoc :
				findByHoatDong(
					hoatDong, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(cauHinhThuTienTruoc);
		}
	}

	/**
	 * Returns the number of cau hinh thu tien truocs where hoatDong = &#63;.
	 *
	 * @param hoatDong the hoat dong
	 * @return the number of matching cau hinh thu tien truocs
	 */
	@Override
	public int countByHoatDong(Boolean hoatDong) {
		FinderPath finderPath = _finderPathCountByHoatDong;

		Object[] finderArgs = new Object[] {hoatDong};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CAUHINHTHUTIENTRUOC_WHERE);

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
		"cauHinhThuTienTruoc.hoatDong = ?";

	public CauHinhThuTienTruocPersistenceImpl() {
		setModelClass(CauHinhThuTienTruoc.class);
	}

	/**
	 * Caches the cau hinh thu tien truoc in the entity cache if it is enabled.
	 *
	 * @param cauHinhThuTienTruoc the cau hinh thu tien truoc
	 */
	@Override
	public void cacheResult(CauHinhThuTienTruoc cauHinhThuTienTruoc) {
		entityCache.putResult(
			CauHinhThuTienTruocModelImpl.ENTITY_CACHE_ENABLED,
			CauHinhThuTienTruocImpl.class, cauHinhThuTienTruoc.getPrimaryKey(),
			cauHinhThuTienTruoc);

		finderCache.putResult(
			_finderPathFetchByNam, new Object[] {cauHinhThuTienTruoc.getNam()},
			cauHinhThuTienTruoc);

		cauHinhThuTienTruoc.resetOriginalValues();
	}

	/**
	 * Caches the cau hinh thu tien truocs in the entity cache if it is enabled.
	 *
	 * @param cauHinhThuTienTruocs the cau hinh thu tien truocs
	 */
	@Override
	public void cacheResult(List<CauHinhThuTienTruoc> cauHinhThuTienTruocs) {
		for (CauHinhThuTienTruoc cauHinhThuTienTruoc : cauHinhThuTienTruocs) {
			if (entityCache.getResult(
					CauHinhThuTienTruocModelImpl.ENTITY_CACHE_ENABLED,
					CauHinhThuTienTruocImpl.class,
					cauHinhThuTienTruoc.getPrimaryKey()) == null) {

				cacheResult(cauHinhThuTienTruoc);
			}
			else {
				cauHinhThuTienTruoc.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cau hinh thu tien truocs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CauHinhThuTienTruocImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cau hinh thu tien truoc.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CauHinhThuTienTruoc cauHinhThuTienTruoc) {
		entityCache.removeResult(
			CauHinhThuTienTruocModelImpl.ENTITY_CACHE_ENABLED,
			CauHinhThuTienTruocImpl.class, cauHinhThuTienTruoc.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(CauHinhThuTienTruocModelImpl)cauHinhThuTienTruoc, true);
	}

	@Override
	public void clearCache(List<CauHinhThuTienTruoc> cauHinhThuTienTruocs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CauHinhThuTienTruoc cauHinhThuTienTruoc : cauHinhThuTienTruocs) {
			entityCache.removeResult(
				CauHinhThuTienTruocModelImpl.ENTITY_CACHE_ENABLED,
				CauHinhThuTienTruocImpl.class,
				cauHinhThuTienTruoc.getPrimaryKey());

			clearUniqueFindersCache(
				(CauHinhThuTienTruocModelImpl)cauHinhThuTienTruoc, true);
		}
	}

	protected void cacheUniqueFindersCache(
		CauHinhThuTienTruocModelImpl cauHinhThuTienTruocModelImpl) {

		Object[] args = new Object[] {cauHinhThuTienTruocModelImpl.getNam()};

		finderCache.putResult(
			_finderPathCountByNam, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByNam, args, cauHinhThuTienTruocModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		CauHinhThuTienTruocModelImpl cauHinhThuTienTruocModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				cauHinhThuTienTruocModelImpl.getNam()
			};

			finderCache.removeResult(_finderPathCountByNam, args);
			finderCache.removeResult(_finderPathFetchByNam, args);
		}

		if ((cauHinhThuTienTruocModelImpl.getColumnBitmask() &
			 _finderPathFetchByNam.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				cauHinhThuTienTruocModelImpl.getOriginalNam()
			};

			finderCache.removeResult(_finderPathCountByNam, args);
			finderCache.removeResult(_finderPathFetchByNam, args);
		}
	}

	/**
	 * Creates a new cau hinh thu tien truoc with the primary key. Does not add the cau hinh thu tien truoc to the database.
	 *
	 * @param cauHinhThuTienTruocId the primary key for the new cau hinh thu tien truoc
	 * @return the new cau hinh thu tien truoc
	 */
	@Override
	public CauHinhThuTienTruoc create(long cauHinhThuTienTruocId) {
		CauHinhThuTienTruoc cauHinhThuTienTruoc = new CauHinhThuTienTruocImpl();

		cauHinhThuTienTruoc.setNew(true);
		cauHinhThuTienTruoc.setPrimaryKey(cauHinhThuTienTruocId);

		cauHinhThuTienTruoc.setCompanyId(companyProvider.getCompanyId());

		return cauHinhThuTienTruoc;
	}

	/**
	 * Removes the cau hinh thu tien truoc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cauHinhThuTienTruocId the primary key of the cau hinh thu tien truoc
	 * @return the cau hinh thu tien truoc that was removed
	 * @throws NoSuchCauHinhThuTienTruocException if a cau hinh thu tien truoc with the primary key could not be found
	 */
	@Override
	public CauHinhThuTienTruoc remove(long cauHinhThuTienTruocId)
		throws NoSuchCauHinhThuTienTruocException {

		return remove((Serializable)cauHinhThuTienTruocId);
	}

	/**
	 * Removes the cau hinh thu tien truoc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cau hinh thu tien truoc
	 * @return the cau hinh thu tien truoc that was removed
	 * @throws NoSuchCauHinhThuTienTruocException if a cau hinh thu tien truoc with the primary key could not be found
	 */
	@Override
	public CauHinhThuTienTruoc remove(Serializable primaryKey)
		throws NoSuchCauHinhThuTienTruocException {

		Session session = null;

		try {
			session = openSession();

			CauHinhThuTienTruoc cauHinhThuTienTruoc =
				(CauHinhThuTienTruoc)session.get(
					CauHinhThuTienTruocImpl.class, primaryKey);

			if (cauHinhThuTienTruoc == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCauHinhThuTienTruocException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(cauHinhThuTienTruoc);
		}
		catch (NoSuchCauHinhThuTienTruocException nsee) {
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
	protected CauHinhThuTienTruoc removeImpl(
		CauHinhThuTienTruoc cauHinhThuTienTruoc) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(cauHinhThuTienTruoc)) {
				cauHinhThuTienTruoc = (CauHinhThuTienTruoc)session.get(
					CauHinhThuTienTruocImpl.class,
					cauHinhThuTienTruoc.getPrimaryKeyObj());
			}

			if (cauHinhThuTienTruoc != null) {
				session.delete(cauHinhThuTienTruoc);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (cauHinhThuTienTruoc != null) {
			clearCache(cauHinhThuTienTruoc);
		}

		return cauHinhThuTienTruoc;
	}

	@Override
	public CauHinhThuTienTruoc updateImpl(
		CauHinhThuTienTruoc cauHinhThuTienTruoc) {

		boolean isNew = cauHinhThuTienTruoc.isNew();

		if (!(cauHinhThuTienTruoc instanceof CauHinhThuTienTruocModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(cauHinhThuTienTruoc.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					cauHinhThuTienTruoc);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in cauHinhThuTienTruoc proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CauHinhThuTienTruoc implementation " +
					cauHinhThuTienTruoc.getClass());
		}

		CauHinhThuTienTruocModelImpl cauHinhThuTienTruocModelImpl =
			(CauHinhThuTienTruocModelImpl)cauHinhThuTienTruoc;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (cauHinhThuTienTruoc.getCreateDate() == null)) {
			if (serviceContext == null) {
				cauHinhThuTienTruoc.setCreateDate(now);
			}
			else {
				cauHinhThuTienTruoc.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!cauHinhThuTienTruocModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				cauHinhThuTienTruoc.setModifiedDate(now);
			}
			else {
				cauHinhThuTienTruoc.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (cauHinhThuTienTruoc.isNew()) {
				session.save(cauHinhThuTienTruoc);

				cauHinhThuTienTruoc.setNew(false);
			}
			else {
				cauHinhThuTienTruoc = (CauHinhThuTienTruoc)session.merge(
					cauHinhThuTienTruoc);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!CauHinhThuTienTruocModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				cauHinhThuTienTruocModelImpl.getHoatDong()
			};

			finderCache.removeResult(_finderPathCountByHoatDong, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByHoatDong, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((cauHinhThuTienTruocModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByHoatDong.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					cauHinhThuTienTruocModelImpl.getOriginalHoatDong()
				};

				finderCache.removeResult(_finderPathCountByHoatDong, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByHoatDong, args);

				args = new Object[] {
					cauHinhThuTienTruocModelImpl.getHoatDong()
				};

				finderCache.removeResult(_finderPathCountByHoatDong, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByHoatDong, args);
			}
		}

		entityCache.putResult(
			CauHinhThuTienTruocModelImpl.ENTITY_CACHE_ENABLED,
			CauHinhThuTienTruocImpl.class, cauHinhThuTienTruoc.getPrimaryKey(),
			cauHinhThuTienTruoc, false);

		clearUniqueFindersCache(cauHinhThuTienTruocModelImpl, false);
		cacheUniqueFindersCache(cauHinhThuTienTruocModelImpl);

		cauHinhThuTienTruoc.resetOriginalValues();

		return cauHinhThuTienTruoc;
	}

	/**
	 * Returns the cau hinh thu tien truoc with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cau hinh thu tien truoc
	 * @return the cau hinh thu tien truoc
	 * @throws NoSuchCauHinhThuTienTruocException if a cau hinh thu tien truoc with the primary key could not be found
	 */
	@Override
	public CauHinhThuTienTruoc findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCauHinhThuTienTruocException {

		CauHinhThuTienTruoc cauHinhThuTienTruoc = fetchByPrimaryKey(primaryKey);

		if (cauHinhThuTienTruoc == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCauHinhThuTienTruocException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return cauHinhThuTienTruoc;
	}

	/**
	 * Returns the cau hinh thu tien truoc with the primary key or throws a <code>NoSuchCauHinhThuTienTruocException</code> if it could not be found.
	 *
	 * @param cauHinhThuTienTruocId the primary key of the cau hinh thu tien truoc
	 * @return the cau hinh thu tien truoc
	 * @throws NoSuchCauHinhThuTienTruocException if a cau hinh thu tien truoc with the primary key could not be found
	 */
	@Override
	public CauHinhThuTienTruoc findByPrimaryKey(long cauHinhThuTienTruocId)
		throws NoSuchCauHinhThuTienTruocException {

		return findByPrimaryKey((Serializable)cauHinhThuTienTruocId);
	}

	/**
	 * Returns the cau hinh thu tien truoc with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cau hinh thu tien truoc
	 * @return the cau hinh thu tien truoc, or <code>null</code> if a cau hinh thu tien truoc with the primary key could not be found
	 */
	@Override
	public CauHinhThuTienTruoc fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			CauHinhThuTienTruocModelImpl.ENTITY_CACHE_ENABLED,
			CauHinhThuTienTruocImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		CauHinhThuTienTruoc cauHinhThuTienTruoc =
			(CauHinhThuTienTruoc)serializable;

		if (cauHinhThuTienTruoc == null) {
			Session session = null;

			try {
				session = openSession();

				cauHinhThuTienTruoc = (CauHinhThuTienTruoc)session.get(
					CauHinhThuTienTruocImpl.class, primaryKey);

				if (cauHinhThuTienTruoc != null) {
					cacheResult(cauHinhThuTienTruoc);
				}
				else {
					entityCache.putResult(
						CauHinhThuTienTruocModelImpl.ENTITY_CACHE_ENABLED,
						CauHinhThuTienTruocImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					CauHinhThuTienTruocModelImpl.ENTITY_CACHE_ENABLED,
					CauHinhThuTienTruocImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return cauHinhThuTienTruoc;
	}

	/**
	 * Returns the cau hinh thu tien truoc with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cauHinhThuTienTruocId the primary key of the cau hinh thu tien truoc
	 * @return the cau hinh thu tien truoc, or <code>null</code> if a cau hinh thu tien truoc with the primary key could not be found
	 */
	@Override
	public CauHinhThuTienTruoc fetchByPrimaryKey(long cauHinhThuTienTruocId) {
		return fetchByPrimaryKey((Serializable)cauHinhThuTienTruocId);
	}

	@Override
	public Map<Serializable, CauHinhThuTienTruoc> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, CauHinhThuTienTruoc> map =
			new HashMap<Serializable, CauHinhThuTienTruoc>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			CauHinhThuTienTruoc cauHinhThuTienTruoc = fetchByPrimaryKey(
				primaryKey);

			if (cauHinhThuTienTruoc != null) {
				map.put(primaryKey, cauHinhThuTienTruoc);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				CauHinhThuTienTruocModelImpl.ENTITY_CACHE_ENABLED,
				CauHinhThuTienTruocImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (CauHinhThuTienTruoc)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_CAUHINHTHUTIENTRUOC_WHERE_PKS_IN);

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

			for (CauHinhThuTienTruoc cauHinhThuTienTruoc :
					(List<CauHinhThuTienTruoc>)q.list()) {

				map.put(
					cauHinhThuTienTruoc.getPrimaryKeyObj(),
					cauHinhThuTienTruoc);

				cacheResult(cauHinhThuTienTruoc);

				uncachedPrimaryKeys.remove(
					cauHinhThuTienTruoc.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					CauHinhThuTienTruocModelImpl.ENTITY_CACHE_ENABLED,
					CauHinhThuTienTruocImpl.class, primaryKey, nullModel);
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
	 * Returns all the cau hinh thu tien truocs.
	 *
	 * @return the cau hinh thu tien truocs
	 */
	@Override
	public List<CauHinhThuTienTruoc> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cau hinh thu tien truocs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CauHinhThuTienTruocModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cau hinh thu tien truocs
	 * @param end the upper bound of the range of cau hinh thu tien truocs (not inclusive)
	 * @return the range of cau hinh thu tien truocs
	 */
	@Override
	public List<CauHinhThuTienTruoc> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the cau hinh thu tien truocs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CauHinhThuTienTruocModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cau hinh thu tien truocs
	 * @param end the upper bound of the range of cau hinh thu tien truocs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cau hinh thu tien truocs
	 */
	@Override
	public List<CauHinhThuTienTruoc> findAll(
		int start, int end,
		OrderByComparator<CauHinhThuTienTruoc> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cau hinh thu tien truocs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CauHinhThuTienTruocModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cau hinh thu tien truocs
	 * @param end the upper bound of the range of cau hinh thu tien truocs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of cau hinh thu tien truocs
	 */
	@Override
	public List<CauHinhThuTienTruoc> findAll(
		int start, int end,
		OrderByComparator<CauHinhThuTienTruoc> orderByComparator,
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

		List<CauHinhThuTienTruoc> list = null;

		if (retrieveFromCache) {
			list = (List<CauHinhThuTienTruoc>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CAUHINHTHUTIENTRUOC);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CAUHINHTHUTIENTRUOC;

				if (pagination) {
					sql = sql.concat(
						CauHinhThuTienTruocModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CauHinhThuTienTruoc>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CauHinhThuTienTruoc>)QueryUtil.list(
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
	 * Removes all the cau hinh thu tien truocs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CauHinhThuTienTruoc cauHinhThuTienTruoc : findAll()) {
			remove(cauHinhThuTienTruoc);
		}
	}

	/**
	 * Returns the number of cau hinh thu tien truocs.
	 *
	 * @return the number of cau hinh thu tien truocs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CAUHINHTHUTIENTRUOC);

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
		return CauHinhThuTienTruocModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the cau hinh thu tien truoc persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			CauHinhThuTienTruocModelImpl.ENTITY_CACHE_ENABLED,
			CauHinhThuTienTruocModelImpl.FINDER_CACHE_ENABLED,
			CauHinhThuTienTruocImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			CauHinhThuTienTruocModelImpl.ENTITY_CACHE_ENABLED,
			CauHinhThuTienTruocModelImpl.FINDER_CACHE_ENABLED,
			CauHinhThuTienTruocImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			CauHinhThuTienTruocModelImpl.ENTITY_CACHE_ENABLED,
			CauHinhThuTienTruocModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByNam = new FinderPath(
			CauHinhThuTienTruocModelImpl.ENTITY_CACHE_ENABLED,
			CauHinhThuTienTruocModelImpl.FINDER_CACHE_ENABLED,
			CauHinhThuTienTruocImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByNam", new String[] {Integer.class.getName()},
			CauHinhThuTienTruocModelImpl.NAM_COLUMN_BITMASK);

		_finderPathCountByNam = new FinderPath(
			CauHinhThuTienTruocModelImpl.ENTITY_CACHE_ENABLED,
			CauHinhThuTienTruocModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNam",
			new String[] {Integer.class.getName()});

		_finderPathWithPaginationFindByHoatDong = new FinderPath(
			CauHinhThuTienTruocModelImpl.ENTITY_CACHE_ENABLED,
			CauHinhThuTienTruocModelImpl.FINDER_CACHE_ENABLED,
			CauHinhThuTienTruocImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByHoatDong",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByHoatDong = new FinderPath(
			CauHinhThuTienTruocModelImpl.ENTITY_CACHE_ENABLED,
			CauHinhThuTienTruocModelImpl.FINDER_CACHE_ENABLED,
			CauHinhThuTienTruocImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByHoatDong",
			new String[] {Boolean.class.getName()},
			CauHinhThuTienTruocModelImpl.HOATDONG_COLUMN_BITMASK |
			CauHinhThuTienTruocModelImpl.NAM_COLUMN_BITMASK);

		_finderPathCountByHoatDong = new FinderPath(
			CauHinhThuTienTruocModelImpl.ENTITY_CACHE_ENABLED,
			CauHinhThuTienTruocModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByHoatDong",
			new String[] {Boolean.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(CauHinhThuTienTruocImpl.class.getName());
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

	private static final String _SQL_SELECT_CAUHINHTHUTIENTRUOC =
		"SELECT cauHinhThuTienTruoc FROM CauHinhThuTienTruoc cauHinhThuTienTruoc";

	private static final String _SQL_SELECT_CAUHINHTHUTIENTRUOC_WHERE_PKS_IN =
		"SELECT cauHinhThuTienTruoc FROM CauHinhThuTienTruoc cauHinhThuTienTruoc WHERE cauHinhThuTienTruocId IN (";

	private static final String _SQL_SELECT_CAUHINHTHUTIENTRUOC_WHERE =
		"SELECT cauHinhThuTienTruoc FROM CauHinhThuTienTruoc cauHinhThuTienTruoc WHERE ";

	private static final String _SQL_COUNT_CAUHINHTHUTIENTRUOC =
		"SELECT COUNT(cauHinhThuTienTruoc) FROM CauHinhThuTienTruoc cauHinhThuTienTruoc";

	private static final String _SQL_COUNT_CAUHINHTHUTIENTRUOC_WHERE =
		"SELECT COUNT(cauHinhThuTienTruoc) FROM CauHinhThuTienTruoc cauHinhThuTienTruoc WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "cauHinhThuTienTruoc.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CauHinhThuTienTruoc exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CauHinhThuTienTruoc exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CauHinhThuTienTruocPersistenceImpl.class);

}