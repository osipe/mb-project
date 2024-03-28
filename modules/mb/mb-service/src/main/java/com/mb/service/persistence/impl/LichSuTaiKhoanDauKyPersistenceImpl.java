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

import com.mb.exception.NoSuchLichSuTaiKhoanDauKyException;
import com.mb.model.LichSuTaiKhoanDauKy;
import com.mb.model.impl.LichSuTaiKhoanDauKyImpl;
import com.mb.model.impl.LichSuTaiKhoanDauKyModelImpl;
import com.mb.service.persistence.LichSuTaiKhoanDauKyPersistence;

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
 * The persistence implementation for the lich su tai khoan dau ky service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class LichSuTaiKhoanDauKyPersistenceImpl
	extends BasePersistenceImpl<LichSuTaiKhoanDauKy>
	implements LichSuTaiKhoanDauKyPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LichSuTaiKhoanDauKyUtil</code> to access the lich su tai khoan dau ky persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LichSuTaiKhoanDauKyImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByTaiKhoanDoiUngId_Nam_Thang;
	private FinderPath _finderPathCountByTaiKhoanDoiUngId_Nam_Thang;

	/**
	 * Returns the lich su tai khoan dau ky where taiKhoanDoiUngId = &#63; and nam = &#63; and thang = &#63; or throws a <code>NoSuchLichSuTaiKhoanDauKyException</code> if it could not be found.
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param nam the nam
	 * @param thang the thang
	 * @return the matching lich su tai khoan dau ky
	 * @throws NoSuchLichSuTaiKhoanDauKyException if a matching lich su tai khoan dau ky could not be found
	 */
	@Override
	public LichSuTaiKhoanDauKy findByTaiKhoanDoiUngId_Nam_Thang(
			long taiKhoanDoiUngId, int nam, int thang)
		throws NoSuchLichSuTaiKhoanDauKyException {

		LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy =
			fetchByTaiKhoanDoiUngId_Nam_Thang(taiKhoanDoiUngId, nam, thang);

		if (lichSuTaiKhoanDauKy == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("taiKhoanDoiUngId=");
			msg.append(taiKhoanDoiUngId);

			msg.append(", nam=");
			msg.append(nam);

			msg.append(", thang=");
			msg.append(thang);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchLichSuTaiKhoanDauKyException(msg.toString());
		}

		return lichSuTaiKhoanDauKy;
	}

	/**
	 * Returns the lich su tai khoan dau ky where taiKhoanDoiUngId = &#63; and nam = &#63; and thang = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param nam the nam
	 * @param thang the thang
	 * @return the matching lich su tai khoan dau ky, or <code>null</code> if a matching lich su tai khoan dau ky could not be found
	 */
	@Override
	public LichSuTaiKhoanDauKy fetchByTaiKhoanDoiUngId_Nam_Thang(
		long taiKhoanDoiUngId, int nam, int thang) {

		return fetchByTaiKhoanDoiUngId_Nam_Thang(
			taiKhoanDoiUngId, nam, thang, true);
	}

	/**
	 * Returns the lich su tai khoan dau ky where taiKhoanDoiUngId = &#63; and nam = &#63; and thang = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param nam the nam
	 * @param thang the thang
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching lich su tai khoan dau ky, or <code>null</code> if a matching lich su tai khoan dau ky could not be found
	 */
	@Override
	public LichSuTaiKhoanDauKy fetchByTaiKhoanDoiUngId_Nam_Thang(
		long taiKhoanDoiUngId, int nam, int thang, boolean retrieveFromCache) {

		Object[] finderArgs = new Object[] {taiKhoanDoiUngId, nam, thang};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByTaiKhoanDoiUngId_Nam_Thang, finderArgs, this);
		}

		if (result instanceof LichSuTaiKhoanDauKy) {
			LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy =
				(LichSuTaiKhoanDauKy)result;

			if ((taiKhoanDoiUngId !=
					lichSuTaiKhoanDauKy.getTaiKhoanDoiUngId()) ||
				(nam != lichSuTaiKhoanDauKy.getNam()) ||
				(thang != lichSuTaiKhoanDauKy.getThang())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_LICHSUTAIKHOANDAUKY_WHERE);

			query.append(
				_FINDER_COLUMN_TAIKHOANDOIUNGID_NAM_THANG_TAIKHOANDOIUNGID_2);

			query.append(_FINDER_COLUMN_TAIKHOANDOIUNGID_NAM_THANG_NAM_2);

			query.append(_FINDER_COLUMN_TAIKHOANDOIUNGID_NAM_THANG_THANG_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(taiKhoanDoiUngId);

				qPos.add(nam);

				qPos.add(thang);

				List<LichSuTaiKhoanDauKy> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByTaiKhoanDoiUngId_Nam_Thang,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"LichSuTaiKhoanDauKyPersistenceImpl.fetchByTaiKhoanDoiUngId_Nam_Thang(long, int, int, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy = list.get(0);

					result = lichSuTaiKhoanDauKy;

					cacheResult(lichSuTaiKhoanDauKy);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathFetchByTaiKhoanDoiUngId_Nam_Thang, finderArgs);

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
			return (LichSuTaiKhoanDauKy)result;
		}
	}

	/**
	 * Removes the lich su tai khoan dau ky where taiKhoanDoiUngId = &#63; and nam = &#63; and thang = &#63; from the database.
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param nam the nam
	 * @param thang the thang
	 * @return the lich su tai khoan dau ky that was removed
	 */
	@Override
	public LichSuTaiKhoanDauKy removeByTaiKhoanDoiUngId_Nam_Thang(
			long taiKhoanDoiUngId, int nam, int thang)
		throws NoSuchLichSuTaiKhoanDauKyException {

		LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy =
			findByTaiKhoanDoiUngId_Nam_Thang(taiKhoanDoiUngId, nam, thang);

		return remove(lichSuTaiKhoanDauKy);
	}

	/**
	 * Returns the number of lich su tai khoan dau kies where taiKhoanDoiUngId = &#63; and nam = &#63; and thang = &#63;.
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param nam the nam
	 * @param thang the thang
	 * @return the number of matching lich su tai khoan dau kies
	 */
	@Override
	public int countByTaiKhoanDoiUngId_Nam_Thang(
		long taiKhoanDoiUngId, int nam, int thang) {

		FinderPath finderPath = _finderPathCountByTaiKhoanDoiUngId_Nam_Thang;

		Object[] finderArgs = new Object[] {taiKhoanDoiUngId, nam, thang};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_LICHSUTAIKHOANDAUKY_WHERE);

			query.append(
				_FINDER_COLUMN_TAIKHOANDOIUNGID_NAM_THANG_TAIKHOANDOIUNGID_2);

			query.append(_FINDER_COLUMN_TAIKHOANDOIUNGID_NAM_THANG_NAM_2);

			query.append(_FINDER_COLUMN_TAIKHOANDOIUNGID_NAM_THANG_THANG_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(taiKhoanDoiUngId);

				qPos.add(nam);

				qPos.add(thang);

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
		_FINDER_COLUMN_TAIKHOANDOIUNGID_NAM_THANG_TAIKHOANDOIUNGID_2 =
			"lichSuTaiKhoanDauKy.taiKhoanDoiUngId = ? AND ";

	private static final String
		_FINDER_COLUMN_TAIKHOANDOIUNGID_NAM_THANG_NAM_2 =
			"lichSuTaiKhoanDauKy.nam = ? AND ";

	private static final String
		_FINDER_COLUMN_TAIKHOANDOIUNGID_NAM_THANG_THANG_2 =
			"lichSuTaiKhoanDauKy.thang = ?";

	private FinderPath _finderPathWithPaginationFindByNam_Thang;
	private FinderPath _finderPathWithoutPaginationFindByNam_Thang;
	private FinderPath _finderPathCountByNam_Thang;

	/**
	 * Returns all the lich su tai khoan dau kies where nam = &#63; and thang = &#63;.
	 *
	 * @param nam the nam
	 * @param thang the thang
	 * @return the matching lich su tai khoan dau kies
	 */
	@Override
	public List<LichSuTaiKhoanDauKy> findByNam_Thang(int nam, int thang) {
		return findByNam_Thang(
			nam, thang, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lich su tai khoan dau kies where nam = &#63; and thang = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LichSuTaiKhoanDauKyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nam the nam
	 * @param thang the thang
	 * @param start the lower bound of the range of lich su tai khoan dau kies
	 * @param end the upper bound of the range of lich su tai khoan dau kies (not inclusive)
	 * @return the range of matching lich su tai khoan dau kies
	 */
	@Override
	public List<LichSuTaiKhoanDauKy> findByNam_Thang(
		int nam, int thang, int start, int end) {

		return findByNam_Thang(nam, thang, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lich su tai khoan dau kies where nam = &#63; and thang = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LichSuTaiKhoanDauKyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nam the nam
	 * @param thang the thang
	 * @param start the lower bound of the range of lich su tai khoan dau kies
	 * @param end the upper bound of the range of lich su tai khoan dau kies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lich su tai khoan dau kies
	 */
	@Override
	public List<LichSuTaiKhoanDauKy> findByNam_Thang(
		int nam, int thang, int start, int end,
		OrderByComparator<LichSuTaiKhoanDauKy> orderByComparator) {

		return findByNam_Thang(nam, thang, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lich su tai khoan dau kies where nam = &#63; and thang = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LichSuTaiKhoanDauKyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nam the nam
	 * @param thang the thang
	 * @param start the lower bound of the range of lich su tai khoan dau kies
	 * @param end the upper bound of the range of lich su tai khoan dau kies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching lich su tai khoan dau kies
	 */
	@Override
	public List<LichSuTaiKhoanDauKy> findByNam_Thang(
		int nam, int thang, int start, int end,
		OrderByComparator<LichSuTaiKhoanDauKy> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByNam_Thang;
			finderArgs = new Object[] {nam, thang};
		}
		else {
			finderPath = _finderPathWithPaginationFindByNam_Thang;
			finderArgs = new Object[] {
				nam, thang, start, end, orderByComparator
			};
		}

		List<LichSuTaiKhoanDauKy> list = null;

		if (retrieveFromCache) {
			list = (List<LichSuTaiKhoanDauKy>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy : list) {
					if ((nam != lichSuTaiKhoanDauKy.getNam()) ||
						(thang != lichSuTaiKhoanDauKy.getThang())) {

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

			query.append(_SQL_SELECT_LICHSUTAIKHOANDAUKY_WHERE);

			query.append(_FINDER_COLUMN_NAM_THANG_NAM_2);

			query.append(_FINDER_COLUMN_NAM_THANG_THANG_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(LichSuTaiKhoanDauKyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(nam);

				qPos.add(thang);

				if (!pagination) {
					list = (List<LichSuTaiKhoanDauKy>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<LichSuTaiKhoanDauKy>)QueryUtil.list(
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
	 * Returns the first lich su tai khoan dau ky in the ordered set where nam = &#63; and thang = &#63;.
	 *
	 * @param nam the nam
	 * @param thang the thang
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lich su tai khoan dau ky
	 * @throws NoSuchLichSuTaiKhoanDauKyException if a matching lich su tai khoan dau ky could not be found
	 */
	@Override
	public LichSuTaiKhoanDauKy findByNam_Thang_First(
			int nam, int thang,
			OrderByComparator<LichSuTaiKhoanDauKy> orderByComparator)
		throws NoSuchLichSuTaiKhoanDauKyException {

		LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy = fetchByNam_Thang_First(
			nam, thang, orderByComparator);

		if (lichSuTaiKhoanDauKy != null) {
			return lichSuTaiKhoanDauKy;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nam=");
		msg.append(nam);

		msg.append(", thang=");
		msg.append(thang);

		msg.append("}");

		throw new NoSuchLichSuTaiKhoanDauKyException(msg.toString());
	}

	/**
	 * Returns the first lich su tai khoan dau ky in the ordered set where nam = &#63; and thang = &#63;.
	 *
	 * @param nam the nam
	 * @param thang the thang
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lich su tai khoan dau ky, or <code>null</code> if a matching lich su tai khoan dau ky could not be found
	 */
	@Override
	public LichSuTaiKhoanDauKy fetchByNam_Thang_First(
		int nam, int thang,
		OrderByComparator<LichSuTaiKhoanDauKy> orderByComparator) {

		List<LichSuTaiKhoanDauKy> list = findByNam_Thang(
			nam, thang, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lich su tai khoan dau ky in the ordered set where nam = &#63; and thang = &#63;.
	 *
	 * @param nam the nam
	 * @param thang the thang
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lich su tai khoan dau ky
	 * @throws NoSuchLichSuTaiKhoanDauKyException if a matching lich su tai khoan dau ky could not be found
	 */
	@Override
	public LichSuTaiKhoanDauKy findByNam_Thang_Last(
			int nam, int thang,
			OrderByComparator<LichSuTaiKhoanDauKy> orderByComparator)
		throws NoSuchLichSuTaiKhoanDauKyException {

		LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy = fetchByNam_Thang_Last(
			nam, thang, orderByComparator);

		if (lichSuTaiKhoanDauKy != null) {
			return lichSuTaiKhoanDauKy;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nam=");
		msg.append(nam);

		msg.append(", thang=");
		msg.append(thang);

		msg.append("}");

		throw new NoSuchLichSuTaiKhoanDauKyException(msg.toString());
	}

	/**
	 * Returns the last lich su tai khoan dau ky in the ordered set where nam = &#63; and thang = &#63;.
	 *
	 * @param nam the nam
	 * @param thang the thang
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lich su tai khoan dau ky, or <code>null</code> if a matching lich su tai khoan dau ky could not be found
	 */
	@Override
	public LichSuTaiKhoanDauKy fetchByNam_Thang_Last(
		int nam, int thang,
		OrderByComparator<LichSuTaiKhoanDauKy> orderByComparator) {

		int count = countByNam_Thang(nam, thang);

		if (count == 0) {
			return null;
		}

		List<LichSuTaiKhoanDauKy> list = findByNam_Thang(
			nam, thang, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lich su tai khoan dau kies before and after the current lich su tai khoan dau ky in the ordered set where nam = &#63; and thang = &#63;.
	 *
	 * @param lichSuTaiKhoanDauKyId the primary key of the current lich su tai khoan dau ky
	 * @param nam the nam
	 * @param thang the thang
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lich su tai khoan dau ky
	 * @throws NoSuchLichSuTaiKhoanDauKyException if a lich su tai khoan dau ky with the primary key could not be found
	 */
	@Override
	public LichSuTaiKhoanDauKy[] findByNam_Thang_PrevAndNext(
			long lichSuTaiKhoanDauKyId, int nam, int thang,
			OrderByComparator<LichSuTaiKhoanDauKy> orderByComparator)
		throws NoSuchLichSuTaiKhoanDauKyException {

		LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy = findByPrimaryKey(
			lichSuTaiKhoanDauKyId);

		Session session = null;

		try {
			session = openSession();

			LichSuTaiKhoanDauKy[] array = new LichSuTaiKhoanDauKyImpl[3];

			array[0] = getByNam_Thang_PrevAndNext(
				session, lichSuTaiKhoanDauKy, nam, thang, orderByComparator,
				true);

			array[1] = lichSuTaiKhoanDauKy;

			array[2] = getByNam_Thang_PrevAndNext(
				session, lichSuTaiKhoanDauKy, nam, thang, orderByComparator,
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

	protected LichSuTaiKhoanDauKy getByNam_Thang_PrevAndNext(
		Session session, LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy, int nam,
		int thang, OrderByComparator<LichSuTaiKhoanDauKy> orderByComparator,
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

		query.append(_SQL_SELECT_LICHSUTAIKHOANDAUKY_WHERE);

		query.append(_FINDER_COLUMN_NAM_THANG_NAM_2);

		query.append(_FINDER_COLUMN_NAM_THANG_THANG_2);

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
			query.append(LichSuTaiKhoanDauKyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(nam);

		qPos.add(thang);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						lichSuTaiKhoanDauKy)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LichSuTaiKhoanDauKy> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lich su tai khoan dau kies where nam = &#63; and thang = &#63; from the database.
	 *
	 * @param nam the nam
	 * @param thang the thang
	 */
	@Override
	public void removeByNam_Thang(int nam, int thang) {
		for (LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy :
				findByNam_Thang(
					nam, thang, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(lichSuTaiKhoanDauKy);
		}
	}

	/**
	 * Returns the number of lich su tai khoan dau kies where nam = &#63; and thang = &#63;.
	 *
	 * @param nam the nam
	 * @param thang the thang
	 * @return the number of matching lich su tai khoan dau kies
	 */
	@Override
	public int countByNam_Thang(int nam, int thang) {
		FinderPath finderPath = _finderPathCountByNam_Thang;

		Object[] finderArgs = new Object[] {nam, thang};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LICHSUTAIKHOANDAUKY_WHERE);

			query.append(_FINDER_COLUMN_NAM_THANG_NAM_2);

			query.append(_FINDER_COLUMN_NAM_THANG_THANG_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(nam);

				qPos.add(thang);

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

	private static final String _FINDER_COLUMN_NAM_THANG_NAM_2 =
		"lichSuTaiKhoanDauKy.nam = ? AND ";

	private static final String _FINDER_COLUMN_NAM_THANG_THANG_2 =
		"lichSuTaiKhoanDauKy.thang = ?";

	private FinderPath _finderPathWithPaginationFindByTaiKhoanDoiUngId;
	private FinderPath _finderPathWithoutPaginationFindByTaiKhoanDoiUngId;
	private FinderPath _finderPathCountByTaiKhoanDoiUngId;

	/**
	 * Returns all the lich su tai khoan dau kies where taiKhoanDoiUngId = &#63;.
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @return the matching lich su tai khoan dau kies
	 */
	@Override
	public List<LichSuTaiKhoanDauKy> findByTaiKhoanDoiUngId(
		long taiKhoanDoiUngId) {

		return findByTaiKhoanDoiUngId(
			taiKhoanDoiUngId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lich su tai khoan dau kies where taiKhoanDoiUngId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LichSuTaiKhoanDauKyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param start the lower bound of the range of lich su tai khoan dau kies
	 * @param end the upper bound of the range of lich su tai khoan dau kies (not inclusive)
	 * @return the range of matching lich su tai khoan dau kies
	 */
	@Override
	public List<LichSuTaiKhoanDauKy> findByTaiKhoanDoiUngId(
		long taiKhoanDoiUngId, int start, int end) {

		return findByTaiKhoanDoiUngId(taiKhoanDoiUngId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lich su tai khoan dau kies where taiKhoanDoiUngId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LichSuTaiKhoanDauKyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param start the lower bound of the range of lich su tai khoan dau kies
	 * @param end the upper bound of the range of lich su tai khoan dau kies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lich su tai khoan dau kies
	 */
	@Override
	public List<LichSuTaiKhoanDauKy> findByTaiKhoanDoiUngId(
		long taiKhoanDoiUngId, int start, int end,
		OrderByComparator<LichSuTaiKhoanDauKy> orderByComparator) {

		return findByTaiKhoanDoiUngId(
			taiKhoanDoiUngId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lich su tai khoan dau kies where taiKhoanDoiUngId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LichSuTaiKhoanDauKyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param start the lower bound of the range of lich su tai khoan dau kies
	 * @param end the upper bound of the range of lich su tai khoan dau kies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching lich su tai khoan dau kies
	 */
	@Override
	public List<LichSuTaiKhoanDauKy> findByTaiKhoanDoiUngId(
		long taiKhoanDoiUngId, int start, int end,
		OrderByComparator<LichSuTaiKhoanDauKy> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByTaiKhoanDoiUngId;
			finderArgs = new Object[] {taiKhoanDoiUngId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByTaiKhoanDoiUngId;
			finderArgs = new Object[] {
				taiKhoanDoiUngId, start, end, orderByComparator
			};
		}

		List<LichSuTaiKhoanDauKy> list = null;

		if (retrieveFromCache) {
			list = (List<LichSuTaiKhoanDauKy>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy : list) {
					if ((taiKhoanDoiUngId !=
							lichSuTaiKhoanDauKy.getTaiKhoanDoiUngId())) {

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

			query.append(_SQL_SELECT_LICHSUTAIKHOANDAUKY_WHERE);

			query.append(_FINDER_COLUMN_TAIKHOANDOIUNGID_TAIKHOANDOIUNGID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(LichSuTaiKhoanDauKyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(taiKhoanDoiUngId);

				if (!pagination) {
					list = (List<LichSuTaiKhoanDauKy>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<LichSuTaiKhoanDauKy>)QueryUtil.list(
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
	 * Returns the first lich su tai khoan dau ky in the ordered set where taiKhoanDoiUngId = &#63;.
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lich su tai khoan dau ky
	 * @throws NoSuchLichSuTaiKhoanDauKyException if a matching lich su tai khoan dau ky could not be found
	 */
	@Override
	public LichSuTaiKhoanDauKy findByTaiKhoanDoiUngId_First(
			long taiKhoanDoiUngId,
			OrderByComparator<LichSuTaiKhoanDauKy> orderByComparator)
		throws NoSuchLichSuTaiKhoanDauKyException {

		LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy = fetchByTaiKhoanDoiUngId_First(
			taiKhoanDoiUngId, orderByComparator);

		if (lichSuTaiKhoanDauKy != null) {
			return lichSuTaiKhoanDauKy;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("taiKhoanDoiUngId=");
		msg.append(taiKhoanDoiUngId);

		msg.append("}");

		throw new NoSuchLichSuTaiKhoanDauKyException(msg.toString());
	}

	/**
	 * Returns the first lich su tai khoan dau ky in the ordered set where taiKhoanDoiUngId = &#63;.
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lich su tai khoan dau ky, or <code>null</code> if a matching lich su tai khoan dau ky could not be found
	 */
	@Override
	public LichSuTaiKhoanDauKy fetchByTaiKhoanDoiUngId_First(
		long taiKhoanDoiUngId,
		OrderByComparator<LichSuTaiKhoanDauKy> orderByComparator) {

		List<LichSuTaiKhoanDauKy> list = findByTaiKhoanDoiUngId(
			taiKhoanDoiUngId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lich su tai khoan dau ky in the ordered set where taiKhoanDoiUngId = &#63;.
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lich su tai khoan dau ky
	 * @throws NoSuchLichSuTaiKhoanDauKyException if a matching lich su tai khoan dau ky could not be found
	 */
	@Override
	public LichSuTaiKhoanDauKy findByTaiKhoanDoiUngId_Last(
			long taiKhoanDoiUngId,
			OrderByComparator<LichSuTaiKhoanDauKy> orderByComparator)
		throws NoSuchLichSuTaiKhoanDauKyException {

		LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy = fetchByTaiKhoanDoiUngId_Last(
			taiKhoanDoiUngId, orderByComparator);

		if (lichSuTaiKhoanDauKy != null) {
			return lichSuTaiKhoanDauKy;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("taiKhoanDoiUngId=");
		msg.append(taiKhoanDoiUngId);

		msg.append("}");

		throw new NoSuchLichSuTaiKhoanDauKyException(msg.toString());
	}

	/**
	 * Returns the last lich su tai khoan dau ky in the ordered set where taiKhoanDoiUngId = &#63;.
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lich su tai khoan dau ky, or <code>null</code> if a matching lich su tai khoan dau ky could not be found
	 */
	@Override
	public LichSuTaiKhoanDauKy fetchByTaiKhoanDoiUngId_Last(
		long taiKhoanDoiUngId,
		OrderByComparator<LichSuTaiKhoanDauKy> orderByComparator) {

		int count = countByTaiKhoanDoiUngId(taiKhoanDoiUngId);

		if (count == 0) {
			return null;
		}

		List<LichSuTaiKhoanDauKy> list = findByTaiKhoanDoiUngId(
			taiKhoanDoiUngId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lich su tai khoan dau kies before and after the current lich su tai khoan dau ky in the ordered set where taiKhoanDoiUngId = &#63;.
	 *
	 * @param lichSuTaiKhoanDauKyId the primary key of the current lich su tai khoan dau ky
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lich su tai khoan dau ky
	 * @throws NoSuchLichSuTaiKhoanDauKyException if a lich su tai khoan dau ky with the primary key could not be found
	 */
	@Override
	public LichSuTaiKhoanDauKy[] findByTaiKhoanDoiUngId_PrevAndNext(
			long lichSuTaiKhoanDauKyId, long taiKhoanDoiUngId,
			OrderByComparator<LichSuTaiKhoanDauKy> orderByComparator)
		throws NoSuchLichSuTaiKhoanDauKyException {

		LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy = findByPrimaryKey(
			lichSuTaiKhoanDauKyId);

		Session session = null;

		try {
			session = openSession();

			LichSuTaiKhoanDauKy[] array = new LichSuTaiKhoanDauKyImpl[3];

			array[0] = getByTaiKhoanDoiUngId_PrevAndNext(
				session, lichSuTaiKhoanDauKy, taiKhoanDoiUngId,
				orderByComparator, true);

			array[1] = lichSuTaiKhoanDauKy;

			array[2] = getByTaiKhoanDoiUngId_PrevAndNext(
				session, lichSuTaiKhoanDauKy, taiKhoanDoiUngId,
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

	protected LichSuTaiKhoanDauKy getByTaiKhoanDoiUngId_PrevAndNext(
		Session session, LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy,
		long taiKhoanDoiUngId,
		OrderByComparator<LichSuTaiKhoanDauKy> orderByComparator,
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

		query.append(_SQL_SELECT_LICHSUTAIKHOANDAUKY_WHERE);

		query.append(_FINDER_COLUMN_TAIKHOANDOIUNGID_TAIKHOANDOIUNGID_2);

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
			query.append(LichSuTaiKhoanDauKyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(taiKhoanDoiUngId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						lichSuTaiKhoanDauKy)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LichSuTaiKhoanDauKy> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lich su tai khoan dau kies where taiKhoanDoiUngId = &#63; from the database.
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 */
	@Override
	public void removeByTaiKhoanDoiUngId(long taiKhoanDoiUngId) {
		for (LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy :
				findByTaiKhoanDoiUngId(
					taiKhoanDoiUngId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(lichSuTaiKhoanDauKy);
		}
	}

	/**
	 * Returns the number of lich su tai khoan dau kies where taiKhoanDoiUngId = &#63;.
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @return the number of matching lich su tai khoan dau kies
	 */
	@Override
	public int countByTaiKhoanDoiUngId(long taiKhoanDoiUngId) {
		FinderPath finderPath = _finderPathCountByTaiKhoanDoiUngId;

		Object[] finderArgs = new Object[] {taiKhoanDoiUngId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LICHSUTAIKHOANDAUKY_WHERE);

			query.append(_FINDER_COLUMN_TAIKHOANDOIUNGID_TAIKHOANDOIUNGID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(taiKhoanDoiUngId);

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
		_FINDER_COLUMN_TAIKHOANDOIUNGID_TAIKHOANDOIUNGID_2 =
			"lichSuTaiKhoanDauKy.taiKhoanDoiUngId = ?";

	public LichSuTaiKhoanDauKyPersistenceImpl() {
		setModelClass(LichSuTaiKhoanDauKy.class);
	}

	/**
	 * Caches the lich su tai khoan dau ky in the entity cache if it is enabled.
	 *
	 * @param lichSuTaiKhoanDauKy the lich su tai khoan dau ky
	 */
	@Override
	public void cacheResult(LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy) {
		entityCache.putResult(
			LichSuTaiKhoanDauKyModelImpl.ENTITY_CACHE_ENABLED,
			LichSuTaiKhoanDauKyImpl.class, lichSuTaiKhoanDauKy.getPrimaryKey(),
			lichSuTaiKhoanDauKy);

		finderCache.putResult(
			_finderPathFetchByTaiKhoanDoiUngId_Nam_Thang,
			new Object[] {
				lichSuTaiKhoanDauKy.getTaiKhoanDoiUngId(),
				lichSuTaiKhoanDauKy.getNam(), lichSuTaiKhoanDauKy.getThang()
			},
			lichSuTaiKhoanDauKy);

		lichSuTaiKhoanDauKy.resetOriginalValues();
	}

	/**
	 * Caches the lich su tai khoan dau kies in the entity cache if it is enabled.
	 *
	 * @param lichSuTaiKhoanDauKies the lich su tai khoan dau kies
	 */
	@Override
	public void cacheResult(List<LichSuTaiKhoanDauKy> lichSuTaiKhoanDauKies) {
		for (LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy : lichSuTaiKhoanDauKies) {
			if (entityCache.getResult(
					LichSuTaiKhoanDauKyModelImpl.ENTITY_CACHE_ENABLED,
					LichSuTaiKhoanDauKyImpl.class,
					lichSuTaiKhoanDauKy.getPrimaryKey()) == null) {

				cacheResult(lichSuTaiKhoanDauKy);
			}
			else {
				lichSuTaiKhoanDauKy.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all lich su tai khoan dau kies.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LichSuTaiKhoanDauKyImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the lich su tai khoan dau ky.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy) {
		entityCache.removeResult(
			LichSuTaiKhoanDauKyModelImpl.ENTITY_CACHE_ENABLED,
			LichSuTaiKhoanDauKyImpl.class, lichSuTaiKhoanDauKy.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(LichSuTaiKhoanDauKyModelImpl)lichSuTaiKhoanDauKy, true);
	}

	@Override
	public void clearCache(List<LichSuTaiKhoanDauKy> lichSuTaiKhoanDauKies) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy : lichSuTaiKhoanDauKies) {
			entityCache.removeResult(
				LichSuTaiKhoanDauKyModelImpl.ENTITY_CACHE_ENABLED,
				LichSuTaiKhoanDauKyImpl.class,
				lichSuTaiKhoanDauKy.getPrimaryKey());

			clearUniqueFindersCache(
				(LichSuTaiKhoanDauKyModelImpl)lichSuTaiKhoanDauKy, true);
		}
	}

	protected void cacheUniqueFindersCache(
		LichSuTaiKhoanDauKyModelImpl lichSuTaiKhoanDauKyModelImpl) {

		Object[] args = new Object[] {
			lichSuTaiKhoanDauKyModelImpl.getTaiKhoanDoiUngId(),
			lichSuTaiKhoanDauKyModelImpl.getNam(),
			lichSuTaiKhoanDauKyModelImpl.getThang()
		};

		finderCache.putResult(
			_finderPathCountByTaiKhoanDoiUngId_Nam_Thang, args, Long.valueOf(1),
			false);
		finderCache.putResult(
			_finderPathFetchByTaiKhoanDoiUngId_Nam_Thang, args,
			lichSuTaiKhoanDauKyModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		LichSuTaiKhoanDauKyModelImpl lichSuTaiKhoanDauKyModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				lichSuTaiKhoanDauKyModelImpl.getTaiKhoanDoiUngId(),
				lichSuTaiKhoanDauKyModelImpl.getNam(),
				lichSuTaiKhoanDauKyModelImpl.getThang()
			};

			finderCache.removeResult(
				_finderPathCountByTaiKhoanDoiUngId_Nam_Thang, args);
			finderCache.removeResult(
				_finderPathFetchByTaiKhoanDoiUngId_Nam_Thang, args);
		}

		if ((lichSuTaiKhoanDauKyModelImpl.getColumnBitmask() &
			 _finderPathFetchByTaiKhoanDoiUngId_Nam_Thang.getColumnBitmask()) !=
				 0) {

			Object[] args = new Object[] {
				lichSuTaiKhoanDauKyModelImpl.getOriginalTaiKhoanDoiUngId(),
				lichSuTaiKhoanDauKyModelImpl.getOriginalNam(),
				lichSuTaiKhoanDauKyModelImpl.getOriginalThang()
			};

			finderCache.removeResult(
				_finderPathCountByTaiKhoanDoiUngId_Nam_Thang, args);
			finderCache.removeResult(
				_finderPathFetchByTaiKhoanDoiUngId_Nam_Thang, args);
		}
	}

	/**
	 * Creates a new lich su tai khoan dau ky with the primary key. Does not add the lich su tai khoan dau ky to the database.
	 *
	 * @param lichSuTaiKhoanDauKyId the primary key for the new lich su tai khoan dau ky
	 * @return the new lich su tai khoan dau ky
	 */
	@Override
	public LichSuTaiKhoanDauKy create(long lichSuTaiKhoanDauKyId) {
		LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy = new LichSuTaiKhoanDauKyImpl();

		lichSuTaiKhoanDauKy.setNew(true);
		lichSuTaiKhoanDauKy.setPrimaryKey(lichSuTaiKhoanDauKyId);

		lichSuTaiKhoanDauKy.setCompanyId(companyProvider.getCompanyId());

		return lichSuTaiKhoanDauKy;
	}

	/**
	 * Removes the lich su tai khoan dau ky with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lichSuTaiKhoanDauKyId the primary key of the lich su tai khoan dau ky
	 * @return the lich su tai khoan dau ky that was removed
	 * @throws NoSuchLichSuTaiKhoanDauKyException if a lich su tai khoan dau ky with the primary key could not be found
	 */
	@Override
	public LichSuTaiKhoanDauKy remove(long lichSuTaiKhoanDauKyId)
		throws NoSuchLichSuTaiKhoanDauKyException {

		return remove((Serializable)lichSuTaiKhoanDauKyId);
	}

	/**
	 * Removes the lich su tai khoan dau ky with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the lich su tai khoan dau ky
	 * @return the lich su tai khoan dau ky that was removed
	 * @throws NoSuchLichSuTaiKhoanDauKyException if a lich su tai khoan dau ky with the primary key could not be found
	 */
	@Override
	public LichSuTaiKhoanDauKy remove(Serializable primaryKey)
		throws NoSuchLichSuTaiKhoanDauKyException {

		Session session = null;

		try {
			session = openSession();

			LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy =
				(LichSuTaiKhoanDauKy)session.get(
					LichSuTaiKhoanDauKyImpl.class, primaryKey);

			if (lichSuTaiKhoanDauKy == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLichSuTaiKhoanDauKyException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(lichSuTaiKhoanDauKy);
		}
		catch (NoSuchLichSuTaiKhoanDauKyException nsee) {
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
	protected LichSuTaiKhoanDauKy removeImpl(
		LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(lichSuTaiKhoanDauKy)) {
				lichSuTaiKhoanDauKy = (LichSuTaiKhoanDauKy)session.get(
					LichSuTaiKhoanDauKyImpl.class,
					lichSuTaiKhoanDauKy.getPrimaryKeyObj());
			}

			if (lichSuTaiKhoanDauKy != null) {
				session.delete(lichSuTaiKhoanDauKy);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (lichSuTaiKhoanDauKy != null) {
			clearCache(lichSuTaiKhoanDauKy);
		}

		return lichSuTaiKhoanDauKy;
	}

	@Override
	public LichSuTaiKhoanDauKy updateImpl(
		LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy) {

		boolean isNew = lichSuTaiKhoanDauKy.isNew();

		if (!(lichSuTaiKhoanDauKy instanceof LichSuTaiKhoanDauKyModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(lichSuTaiKhoanDauKy.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					lichSuTaiKhoanDauKy);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in lichSuTaiKhoanDauKy proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LichSuTaiKhoanDauKy implementation " +
					lichSuTaiKhoanDauKy.getClass());
		}

		LichSuTaiKhoanDauKyModelImpl lichSuTaiKhoanDauKyModelImpl =
			(LichSuTaiKhoanDauKyModelImpl)lichSuTaiKhoanDauKy;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (lichSuTaiKhoanDauKy.getCreateDate() == null)) {
			if (serviceContext == null) {
				lichSuTaiKhoanDauKy.setCreateDate(now);
			}
			else {
				lichSuTaiKhoanDauKy.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!lichSuTaiKhoanDauKyModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				lichSuTaiKhoanDauKy.setModifiedDate(now);
			}
			else {
				lichSuTaiKhoanDauKy.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (lichSuTaiKhoanDauKy.isNew()) {
				session.save(lichSuTaiKhoanDauKy);

				lichSuTaiKhoanDauKy.setNew(false);
			}
			else {
				lichSuTaiKhoanDauKy = (LichSuTaiKhoanDauKy)session.merge(
					lichSuTaiKhoanDauKy);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!LichSuTaiKhoanDauKyModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				lichSuTaiKhoanDauKyModelImpl.getNam(),
				lichSuTaiKhoanDauKyModelImpl.getThang()
			};

			finderCache.removeResult(_finderPathCountByNam_Thang, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByNam_Thang, args);

			args = new Object[] {
				lichSuTaiKhoanDauKyModelImpl.getTaiKhoanDoiUngId()
			};

			finderCache.removeResult(_finderPathCountByTaiKhoanDoiUngId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByTaiKhoanDoiUngId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((lichSuTaiKhoanDauKyModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByNam_Thang.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					lichSuTaiKhoanDauKyModelImpl.getOriginalNam(),
					lichSuTaiKhoanDauKyModelImpl.getOriginalThang()
				};

				finderCache.removeResult(_finderPathCountByNam_Thang, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByNam_Thang, args);

				args = new Object[] {
					lichSuTaiKhoanDauKyModelImpl.getNam(),
					lichSuTaiKhoanDauKyModelImpl.getThang()
				};

				finderCache.removeResult(_finderPathCountByNam_Thang, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByNam_Thang, args);
			}

			if ((lichSuTaiKhoanDauKyModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByTaiKhoanDoiUngId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					lichSuTaiKhoanDauKyModelImpl.getOriginalTaiKhoanDoiUngId()
				};

				finderCache.removeResult(
					_finderPathCountByTaiKhoanDoiUngId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTaiKhoanDoiUngId, args);

				args = new Object[] {
					lichSuTaiKhoanDauKyModelImpl.getTaiKhoanDoiUngId()
				};

				finderCache.removeResult(
					_finderPathCountByTaiKhoanDoiUngId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTaiKhoanDoiUngId, args);
			}
		}

		entityCache.putResult(
			LichSuTaiKhoanDauKyModelImpl.ENTITY_CACHE_ENABLED,
			LichSuTaiKhoanDauKyImpl.class, lichSuTaiKhoanDauKy.getPrimaryKey(),
			lichSuTaiKhoanDauKy, false);

		clearUniqueFindersCache(lichSuTaiKhoanDauKyModelImpl, false);
		cacheUniqueFindersCache(lichSuTaiKhoanDauKyModelImpl);

		lichSuTaiKhoanDauKy.resetOriginalValues();

		return lichSuTaiKhoanDauKy;
	}

	/**
	 * Returns the lich su tai khoan dau ky with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the lich su tai khoan dau ky
	 * @return the lich su tai khoan dau ky
	 * @throws NoSuchLichSuTaiKhoanDauKyException if a lich su tai khoan dau ky with the primary key could not be found
	 */
	@Override
	public LichSuTaiKhoanDauKy findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLichSuTaiKhoanDauKyException {

		LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy = fetchByPrimaryKey(primaryKey);

		if (lichSuTaiKhoanDauKy == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLichSuTaiKhoanDauKyException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return lichSuTaiKhoanDauKy;
	}

	/**
	 * Returns the lich su tai khoan dau ky with the primary key or throws a <code>NoSuchLichSuTaiKhoanDauKyException</code> if it could not be found.
	 *
	 * @param lichSuTaiKhoanDauKyId the primary key of the lich su tai khoan dau ky
	 * @return the lich su tai khoan dau ky
	 * @throws NoSuchLichSuTaiKhoanDauKyException if a lich su tai khoan dau ky with the primary key could not be found
	 */
	@Override
	public LichSuTaiKhoanDauKy findByPrimaryKey(long lichSuTaiKhoanDauKyId)
		throws NoSuchLichSuTaiKhoanDauKyException {

		return findByPrimaryKey((Serializable)lichSuTaiKhoanDauKyId);
	}

	/**
	 * Returns the lich su tai khoan dau ky with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the lich su tai khoan dau ky
	 * @return the lich su tai khoan dau ky, or <code>null</code> if a lich su tai khoan dau ky with the primary key could not be found
	 */
	@Override
	public LichSuTaiKhoanDauKy fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			LichSuTaiKhoanDauKyModelImpl.ENTITY_CACHE_ENABLED,
			LichSuTaiKhoanDauKyImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy =
			(LichSuTaiKhoanDauKy)serializable;

		if (lichSuTaiKhoanDauKy == null) {
			Session session = null;

			try {
				session = openSession();

				lichSuTaiKhoanDauKy = (LichSuTaiKhoanDauKy)session.get(
					LichSuTaiKhoanDauKyImpl.class, primaryKey);

				if (lichSuTaiKhoanDauKy != null) {
					cacheResult(lichSuTaiKhoanDauKy);
				}
				else {
					entityCache.putResult(
						LichSuTaiKhoanDauKyModelImpl.ENTITY_CACHE_ENABLED,
						LichSuTaiKhoanDauKyImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					LichSuTaiKhoanDauKyModelImpl.ENTITY_CACHE_ENABLED,
					LichSuTaiKhoanDauKyImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return lichSuTaiKhoanDauKy;
	}

	/**
	 * Returns the lich su tai khoan dau ky with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lichSuTaiKhoanDauKyId the primary key of the lich su tai khoan dau ky
	 * @return the lich su tai khoan dau ky, or <code>null</code> if a lich su tai khoan dau ky with the primary key could not be found
	 */
	@Override
	public LichSuTaiKhoanDauKy fetchByPrimaryKey(long lichSuTaiKhoanDauKyId) {
		return fetchByPrimaryKey((Serializable)lichSuTaiKhoanDauKyId);
	}

	@Override
	public Map<Serializable, LichSuTaiKhoanDauKy> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, LichSuTaiKhoanDauKy> map =
			new HashMap<Serializable, LichSuTaiKhoanDauKy>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy = fetchByPrimaryKey(
				primaryKey);

			if (lichSuTaiKhoanDauKy != null) {
				map.put(primaryKey, lichSuTaiKhoanDauKy);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				LichSuTaiKhoanDauKyModelImpl.ENTITY_CACHE_ENABLED,
				LichSuTaiKhoanDauKyImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (LichSuTaiKhoanDauKy)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_LICHSUTAIKHOANDAUKY_WHERE_PKS_IN);

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

			for (LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy :
					(List<LichSuTaiKhoanDauKy>)q.list()) {

				map.put(
					lichSuTaiKhoanDauKy.getPrimaryKeyObj(),
					lichSuTaiKhoanDauKy);

				cacheResult(lichSuTaiKhoanDauKy);

				uncachedPrimaryKeys.remove(
					lichSuTaiKhoanDauKy.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					LichSuTaiKhoanDauKyModelImpl.ENTITY_CACHE_ENABLED,
					LichSuTaiKhoanDauKyImpl.class, primaryKey, nullModel);
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
	 * Returns all the lich su tai khoan dau kies.
	 *
	 * @return the lich su tai khoan dau kies
	 */
	@Override
	public List<LichSuTaiKhoanDauKy> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lich su tai khoan dau kies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LichSuTaiKhoanDauKyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lich su tai khoan dau kies
	 * @param end the upper bound of the range of lich su tai khoan dau kies (not inclusive)
	 * @return the range of lich su tai khoan dau kies
	 */
	@Override
	public List<LichSuTaiKhoanDauKy> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the lich su tai khoan dau kies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LichSuTaiKhoanDauKyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lich su tai khoan dau kies
	 * @param end the upper bound of the range of lich su tai khoan dau kies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lich su tai khoan dau kies
	 */
	@Override
	public List<LichSuTaiKhoanDauKy> findAll(
		int start, int end,
		OrderByComparator<LichSuTaiKhoanDauKy> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lich su tai khoan dau kies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LichSuTaiKhoanDauKyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lich su tai khoan dau kies
	 * @param end the upper bound of the range of lich su tai khoan dau kies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of lich su tai khoan dau kies
	 */
	@Override
	public List<LichSuTaiKhoanDauKy> findAll(
		int start, int end,
		OrderByComparator<LichSuTaiKhoanDauKy> orderByComparator,
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

		List<LichSuTaiKhoanDauKy> list = null;

		if (retrieveFromCache) {
			list = (List<LichSuTaiKhoanDauKy>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LICHSUTAIKHOANDAUKY);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LICHSUTAIKHOANDAUKY;

				if (pagination) {
					sql = sql.concat(
						LichSuTaiKhoanDauKyModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LichSuTaiKhoanDauKy>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<LichSuTaiKhoanDauKy>)QueryUtil.list(
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
	 * Removes all the lich su tai khoan dau kies from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy : findAll()) {
			remove(lichSuTaiKhoanDauKy);
		}
	}

	/**
	 * Returns the number of lich su tai khoan dau kies.
	 *
	 * @return the number of lich su tai khoan dau kies
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LICHSUTAIKHOANDAUKY);

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
		return LichSuTaiKhoanDauKyModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the lich su tai khoan dau ky persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			LichSuTaiKhoanDauKyModelImpl.ENTITY_CACHE_ENABLED,
			LichSuTaiKhoanDauKyModelImpl.FINDER_CACHE_ENABLED,
			LichSuTaiKhoanDauKyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			LichSuTaiKhoanDauKyModelImpl.ENTITY_CACHE_ENABLED,
			LichSuTaiKhoanDauKyModelImpl.FINDER_CACHE_ENABLED,
			LichSuTaiKhoanDauKyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			LichSuTaiKhoanDauKyModelImpl.ENTITY_CACHE_ENABLED,
			LichSuTaiKhoanDauKyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByTaiKhoanDoiUngId_Nam_Thang = new FinderPath(
			LichSuTaiKhoanDauKyModelImpl.ENTITY_CACHE_ENABLED,
			LichSuTaiKhoanDauKyModelImpl.FINDER_CACHE_ENABLED,
			LichSuTaiKhoanDauKyImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByTaiKhoanDoiUngId_Nam_Thang",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName()
			},
			LichSuTaiKhoanDauKyModelImpl.TAIKHOANDOIUNGID_COLUMN_BITMASK |
			LichSuTaiKhoanDauKyModelImpl.NAM_COLUMN_BITMASK |
			LichSuTaiKhoanDauKyModelImpl.THANG_COLUMN_BITMASK);

		_finderPathCountByTaiKhoanDoiUngId_Nam_Thang = new FinderPath(
			LichSuTaiKhoanDauKyModelImpl.ENTITY_CACHE_ENABLED,
			LichSuTaiKhoanDauKyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTaiKhoanDoiUngId_Nam_Thang",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName()
			});

		_finderPathWithPaginationFindByNam_Thang = new FinderPath(
			LichSuTaiKhoanDauKyModelImpl.ENTITY_CACHE_ENABLED,
			LichSuTaiKhoanDauKyModelImpl.FINDER_CACHE_ENABLED,
			LichSuTaiKhoanDauKyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNam_Thang",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByNam_Thang = new FinderPath(
			LichSuTaiKhoanDauKyModelImpl.ENTITY_CACHE_ENABLED,
			LichSuTaiKhoanDauKyModelImpl.FINDER_CACHE_ENABLED,
			LichSuTaiKhoanDauKyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByNam_Thang",
			new String[] {Integer.class.getName(), Integer.class.getName()},
			LichSuTaiKhoanDauKyModelImpl.NAM_COLUMN_BITMASK |
			LichSuTaiKhoanDauKyModelImpl.THANG_COLUMN_BITMASK);

		_finderPathCountByNam_Thang = new FinderPath(
			LichSuTaiKhoanDauKyModelImpl.ENTITY_CACHE_ENABLED,
			LichSuTaiKhoanDauKyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNam_Thang",
			new String[] {Integer.class.getName(), Integer.class.getName()});

		_finderPathWithPaginationFindByTaiKhoanDoiUngId = new FinderPath(
			LichSuTaiKhoanDauKyModelImpl.ENTITY_CACHE_ENABLED,
			LichSuTaiKhoanDauKyModelImpl.FINDER_CACHE_ENABLED,
			LichSuTaiKhoanDauKyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTaiKhoanDoiUngId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByTaiKhoanDoiUngId = new FinderPath(
			LichSuTaiKhoanDauKyModelImpl.ENTITY_CACHE_ENABLED,
			LichSuTaiKhoanDauKyModelImpl.FINDER_CACHE_ENABLED,
			LichSuTaiKhoanDauKyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTaiKhoanDoiUngId",
			new String[] {Long.class.getName()},
			LichSuTaiKhoanDauKyModelImpl.TAIKHOANDOIUNGID_COLUMN_BITMASK);

		_finderPathCountByTaiKhoanDoiUngId = new FinderPath(
			LichSuTaiKhoanDauKyModelImpl.ENTITY_CACHE_ENABLED,
			LichSuTaiKhoanDauKyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTaiKhoanDoiUngId", new String[] {Long.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(LichSuTaiKhoanDauKyImpl.class.getName());
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

	private static final String _SQL_SELECT_LICHSUTAIKHOANDAUKY =
		"SELECT lichSuTaiKhoanDauKy FROM LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy";

	private static final String _SQL_SELECT_LICHSUTAIKHOANDAUKY_WHERE_PKS_IN =
		"SELECT lichSuTaiKhoanDauKy FROM LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy WHERE lichSuTaiKhoanDauKyId IN (";

	private static final String _SQL_SELECT_LICHSUTAIKHOANDAUKY_WHERE =
		"SELECT lichSuTaiKhoanDauKy FROM LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy WHERE ";

	private static final String _SQL_COUNT_LICHSUTAIKHOANDAUKY =
		"SELECT COUNT(lichSuTaiKhoanDauKy) FROM LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy";

	private static final String _SQL_COUNT_LICHSUTAIKHOANDAUKY_WHERE =
		"SELECT COUNT(lichSuTaiKhoanDauKy) FROM LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "lichSuTaiKhoanDauKy.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No LichSuTaiKhoanDauKy exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No LichSuTaiKhoanDauKy exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LichSuTaiKhoanDauKyPersistenceImpl.class);

}