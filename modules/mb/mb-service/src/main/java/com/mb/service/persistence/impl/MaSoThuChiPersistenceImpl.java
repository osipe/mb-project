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

import com.mb.exception.NoSuchMaSoThuChiException;
import com.mb.model.MaSoThuChi;
import com.mb.model.impl.MaSoThuChiImpl;
import com.mb.model.impl.MaSoThuChiModelImpl;
import com.mb.service.persistence.MaSoThuChiPersistence;

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
 * The persistence implementation for the ma so thu chi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class MaSoThuChiPersistenceImpl
	extends BasePersistenceImpl<MaSoThuChi> implements MaSoThuChiPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>MaSoThuChiUtil</code> to access the ma so thu chi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		MaSoThuChiImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByMa_Loai_HoatDong;
	private FinderPath _finderPathCountByMa_Loai_HoatDong;

	/**
	 * Returns the ma so thu chi where ma = &#63; and loai = &#63; and hoatDong = &#63; or throws a <code>NoSuchMaSoThuChiException</code> if it could not be found.
	 *
	 * @param ma the ma
	 * @param loai the loai
	 * @param hoatDong the hoat dong
	 * @return the matching ma so thu chi
	 * @throws NoSuchMaSoThuChiException if a matching ma so thu chi could not be found
	 */
	@Override
	public MaSoThuChi findByMa_Loai_HoatDong(
			String ma, int loai, Boolean hoatDong)
		throws NoSuchMaSoThuChiException {

		MaSoThuChi maSoThuChi = fetchByMa_Loai_HoatDong(ma, loai, hoatDong);

		if (maSoThuChi == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ma=");
			msg.append(ma);

			msg.append(", loai=");
			msg.append(loai);

			msg.append(", hoatDong=");
			msg.append(hoatDong);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchMaSoThuChiException(msg.toString());
		}

		return maSoThuChi;
	}

	/**
	 * Returns the ma so thu chi where ma = &#63; and loai = &#63; and hoatDong = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ma the ma
	 * @param loai the loai
	 * @param hoatDong the hoat dong
	 * @return the matching ma so thu chi, or <code>null</code> if a matching ma so thu chi could not be found
	 */
	@Override
	public MaSoThuChi fetchByMa_Loai_HoatDong(
		String ma, int loai, Boolean hoatDong) {

		return fetchByMa_Loai_HoatDong(ma, loai, hoatDong, true);
	}

	/**
	 * Returns the ma so thu chi where ma = &#63; and loai = &#63; and hoatDong = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ma the ma
	 * @param loai the loai
	 * @param hoatDong the hoat dong
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching ma so thu chi, or <code>null</code> if a matching ma so thu chi could not be found
	 */
	@Override
	public MaSoThuChi fetchByMa_Loai_HoatDong(
		String ma, int loai, Boolean hoatDong, boolean retrieveFromCache) {

		ma = Objects.toString(ma, "");

		Object[] finderArgs = new Object[] {ma, loai, hoatDong};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByMa_Loai_HoatDong, finderArgs, this);
		}

		if (result instanceof MaSoThuChi) {
			MaSoThuChi maSoThuChi = (MaSoThuChi)result;

			if (!Objects.equals(ma, maSoThuChi.getMa()) ||
				(loai != maSoThuChi.getLoai()) ||
				!Objects.equals(hoatDong, maSoThuChi.getHoatDong())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_MASOTHUCHI_WHERE);

			boolean bindMa = false;

			if (ma.isEmpty()) {
				query.append(_FINDER_COLUMN_MA_LOAI_HOATDONG_MA_3);
			}
			else {
				bindMa = true;

				query.append(_FINDER_COLUMN_MA_LOAI_HOATDONG_MA_2);
			}

			query.append(_FINDER_COLUMN_MA_LOAI_HOATDONG_LOAI_2);

			query.append(_FINDER_COLUMN_MA_LOAI_HOATDONG_HOATDONG_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindMa) {
					qPos.add(ma);
				}

				qPos.add(loai);

				qPos.add(hoatDong.booleanValue());

				List<MaSoThuChi> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByMa_Loai_HoatDong, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"MaSoThuChiPersistenceImpl.fetchByMa_Loai_HoatDong(String, int, Boolean, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					MaSoThuChi maSoThuChi = list.get(0);

					result = maSoThuChi;

					cacheResult(maSoThuChi);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathFetchByMa_Loai_HoatDong, finderArgs);

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
			return (MaSoThuChi)result;
		}
	}

	/**
	 * Removes the ma so thu chi where ma = &#63; and loai = &#63; and hoatDong = &#63; from the database.
	 *
	 * @param ma the ma
	 * @param loai the loai
	 * @param hoatDong the hoat dong
	 * @return the ma so thu chi that was removed
	 */
	@Override
	public MaSoThuChi removeByMa_Loai_HoatDong(
			String ma, int loai, Boolean hoatDong)
		throws NoSuchMaSoThuChiException {

		MaSoThuChi maSoThuChi = findByMa_Loai_HoatDong(ma, loai, hoatDong);

		return remove(maSoThuChi);
	}

	/**
	 * Returns the number of ma so thu chis where ma = &#63; and loai = &#63; and hoatDong = &#63;.
	 *
	 * @param ma the ma
	 * @param loai the loai
	 * @param hoatDong the hoat dong
	 * @return the number of matching ma so thu chis
	 */
	@Override
	public int countByMa_Loai_HoatDong(String ma, int loai, Boolean hoatDong) {
		ma = Objects.toString(ma, "");

		FinderPath finderPath = _finderPathCountByMa_Loai_HoatDong;

		Object[] finderArgs = new Object[] {ma, loai, hoatDong};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_MASOTHUCHI_WHERE);

			boolean bindMa = false;

			if (ma.isEmpty()) {
				query.append(_FINDER_COLUMN_MA_LOAI_HOATDONG_MA_3);
			}
			else {
				bindMa = true;

				query.append(_FINDER_COLUMN_MA_LOAI_HOATDONG_MA_2);
			}

			query.append(_FINDER_COLUMN_MA_LOAI_HOATDONG_LOAI_2);

			query.append(_FINDER_COLUMN_MA_LOAI_HOATDONG_HOATDONG_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindMa) {
					qPos.add(ma);
				}

				qPos.add(loai);

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

	private static final String _FINDER_COLUMN_MA_LOAI_HOATDONG_MA_2 =
		"maSoThuChi.ma = ? AND ";

	private static final String _FINDER_COLUMN_MA_LOAI_HOATDONG_MA_3 =
		"(maSoThuChi.ma IS NULL OR maSoThuChi.ma = '') AND ";

	private static final String _FINDER_COLUMN_MA_LOAI_HOATDONG_LOAI_2 =
		"maSoThuChi.loai = ? AND ";

	private static final String _FINDER_COLUMN_MA_LOAI_HOATDONG_HOATDONG_2 =
		"maSoThuChi.hoatDong = ?";

	private FinderPath _finderPathWithPaginationFindByLoai_HoatDong;
	private FinderPath _finderPathWithoutPaginationFindByLoai_HoatDong;
	private FinderPath _finderPathCountByLoai_HoatDong;

	/**
	 * Returns all the ma so thu chis where loai = &#63; and hoatDong = &#63;.
	 *
	 * @param loai the loai
	 * @param hoatDong the hoat dong
	 * @return the matching ma so thu chis
	 */
	@Override
	public List<MaSoThuChi> findByLoai_HoatDong(int loai, Boolean hoatDong) {
		return findByLoai_HoatDong(
			loai, hoatDong, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ma so thu chis where loai = &#63; and hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MaSoThuChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param loai the loai
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of ma so thu chis
	 * @param end the upper bound of the range of ma so thu chis (not inclusive)
	 * @return the range of matching ma so thu chis
	 */
	@Override
	public List<MaSoThuChi> findByLoai_HoatDong(
		int loai, Boolean hoatDong, int start, int end) {

		return findByLoai_HoatDong(loai, hoatDong, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ma so thu chis where loai = &#63; and hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MaSoThuChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param loai the loai
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of ma so thu chis
	 * @param end the upper bound of the range of ma so thu chis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ma so thu chis
	 */
	@Override
	public List<MaSoThuChi> findByLoai_HoatDong(
		int loai, Boolean hoatDong, int start, int end,
		OrderByComparator<MaSoThuChi> orderByComparator) {

		return findByLoai_HoatDong(
			loai, hoatDong, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ma so thu chis where loai = &#63; and hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MaSoThuChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param loai the loai
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of ma so thu chis
	 * @param end the upper bound of the range of ma so thu chis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching ma so thu chis
	 */
	@Override
	public List<MaSoThuChi> findByLoai_HoatDong(
		int loai, Boolean hoatDong, int start, int end,
		OrderByComparator<MaSoThuChi> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByLoai_HoatDong;
			finderArgs = new Object[] {loai, hoatDong};
		}
		else {
			finderPath = _finderPathWithPaginationFindByLoai_HoatDong;
			finderArgs = new Object[] {
				loai, hoatDong, start, end, orderByComparator
			};
		}

		List<MaSoThuChi> list = null;

		if (retrieveFromCache) {
			list = (List<MaSoThuChi>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MaSoThuChi maSoThuChi : list) {
					if ((loai != maSoThuChi.getLoai()) ||
						!Objects.equals(hoatDong, maSoThuChi.getHoatDong())) {

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

			query.append(_SQL_SELECT_MASOTHUCHI_WHERE);

			query.append(_FINDER_COLUMN_LOAI_HOATDONG_LOAI_2);

			query.append(_FINDER_COLUMN_LOAI_HOATDONG_HOATDONG_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(MaSoThuChiModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(loai);

				qPos.add(hoatDong.booleanValue());

				if (!pagination) {
					list = (List<MaSoThuChi>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<MaSoThuChi>)QueryUtil.list(
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
	 * Returns the first ma so thu chi in the ordered set where loai = &#63; and hoatDong = &#63;.
	 *
	 * @param loai the loai
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ma so thu chi
	 * @throws NoSuchMaSoThuChiException if a matching ma so thu chi could not be found
	 */
	@Override
	public MaSoThuChi findByLoai_HoatDong_First(
			int loai, Boolean hoatDong,
			OrderByComparator<MaSoThuChi> orderByComparator)
		throws NoSuchMaSoThuChiException {

		MaSoThuChi maSoThuChi = fetchByLoai_HoatDong_First(
			loai, hoatDong, orderByComparator);

		if (maSoThuChi != null) {
			return maSoThuChi;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("loai=");
		msg.append(loai);

		msg.append(", hoatDong=");
		msg.append(hoatDong);

		msg.append("}");

		throw new NoSuchMaSoThuChiException(msg.toString());
	}

	/**
	 * Returns the first ma so thu chi in the ordered set where loai = &#63; and hoatDong = &#63;.
	 *
	 * @param loai the loai
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ma so thu chi, or <code>null</code> if a matching ma so thu chi could not be found
	 */
	@Override
	public MaSoThuChi fetchByLoai_HoatDong_First(
		int loai, Boolean hoatDong,
		OrderByComparator<MaSoThuChi> orderByComparator) {

		List<MaSoThuChi> list = findByLoai_HoatDong(
			loai, hoatDong, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ma so thu chi in the ordered set where loai = &#63; and hoatDong = &#63;.
	 *
	 * @param loai the loai
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ma so thu chi
	 * @throws NoSuchMaSoThuChiException if a matching ma so thu chi could not be found
	 */
	@Override
	public MaSoThuChi findByLoai_HoatDong_Last(
			int loai, Boolean hoatDong,
			OrderByComparator<MaSoThuChi> orderByComparator)
		throws NoSuchMaSoThuChiException {

		MaSoThuChi maSoThuChi = fetchByLoai_HoatDong_Last(
			loai, hoatDong, orderByComparator);

		if (maSoThuChi != null) {
			return maSoThuChi;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("loai=");
		msg.append(loai);

		msg.append(", hoatDong=");
		msg.append(hoatDong);

		msg.append("}");

		throw new NoSuchMaSoThuChiException(msg.toString());
	}

	/**
	 * Returns the last ma so thu chi in the ordered set where loai = &#63; and hoatDong = &#63;.
	 *
	 * @param loai the loai
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ma so thu chi, or <code>null</code> if a matching ma so thu chi could not be found
	 */
	@Override
	public MaSoThuChi fetchByLoai_HoatDong_Last(
		int loai, Boolean hoatDong,
		OrderByComparator<MaSoThuChi> orderByComparator) {

		int count = countByLoai_HoatDong(loai, hoatDong);

		if (count == 0) {
			return null;
		}

		List<MaSoThuChi> list = findByLoai_HoatDong(
			loai, hoatDong, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ma so thu chis before and after the current ma so thu chi in the ordered set where loai = &#63; and hoatDong = &#63;.
	 *
	 * @param maSoThuChiId the primary key of the current ma so thu chi
	 * @param loai the loai
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ma so thu chi
	 * @throws NoSuchMaSoThuChiException if a ma so thu chi with the primary key could not be found
	 */
	@Override
	public MaSoThuChi[] findByLoai_HoatDong_PrevAndNext(
			long maSoThuChiId, int loai, Boolean hoatDong,
			OrderByComparator<MaSoThuChi> orderByComparator)
		throws NoSuchMaSoThuChiException {

		MaSoThuChi maSoThuChi = findByPrimaryKey(maSoThuChiId);

		Session session = null;

		try {
			session = openSession();

			MaSoThuChi[] array = new MaSoThuChiImpl[3];

			array[0] = getByLoai_HoatDong_PrevAndNext(
				session, maSoThuChi, loai, hoatDong, orderByComparator, true);

			array[1] = maSoThuChi;

			array[2] = getByLoai_HoatDong_PrevAndNext(
				session, maSoThuChi, loai, hoatDong, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MaSoThuChi getByLoai_HoatDong_PrevAndNext(
		Session session, MaSoThuChi maSoThuChi, int loai, Boolean hoatDong,
		OrderByComparator<MaSoThuChi> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_MASOTHUCHI_WHERE);

		query.append(_FINDER_COLUMN_LOAI_HOATDONG_LOAI_2);

		query.append(_FINDER_COLUMN_LOAI_HOATDONG_HOATDONG_2);

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
			query.append(MaSoThuChiModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(loai);

		qPos.add(hoatDong.booleanValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(maSoThuChi)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<MaSoThuChi> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ma so thu chis where loai = &#63; and hoatDong = &#63; from the database.
	 *
	 * @param loai the loai
	 * @param hoatDong the hoat dong
	 */
	@Override
	public void removeByLoai_HoatDong(int loai, Boolean hoatDong) {
		for (MaSoThuChi maSoThuChi :
				findByLoai_HoatDong(
					loai, hoatDong, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(maSoThuChi);
		}
	}

	/**
	 * Returns the number of ma so thu chis where loai = &#63; and hoatDong = &#63;.
	 *
	 * @param loai the loai
	 * @param hoatDong the hoat dong
	 * @return the number of matching ma so thu chis
	 */
	@Override
	public int countByLoai_HoatDong(int loai, Boolean hoatDong) {
		FinderPath finderPath = _finderPathCountByLoai_HoatDong;

		Object[] finderArgs = new Object[] {loai, hoatDong};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MASOTHUCHI_WHERE);

			query.append(_FINDER_COLUMN_LOAI_HOATDONG_LOAI_2);

			query.append(_FINDER_COLUMN_LOAI_HOATDONG_HOATDONG_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(loai);

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

	private static final String _FINDER_COLUMN_LOAI_HOATDONG_LOAI_2 =
		"maSoThuChi.loai = ? AND ";

	private static final String _FINDER_COLUMN_LOAI_HOATDONG_HOATDONG_2 =
		"maSoThuChi.hoatDong = ?";

	public MaSoThuChiPersistenceImpl() {
		setModelClass(MaSoThuChi.class);
	}

	/**
	 * Caches the ma so thu chi in the entity cache if it is enabled.
	 *
	 * @param maSoThuChi the ma so thu chi
	 */
	@Override
	public void cacheResult(MaSoThuChi maSoThuChi) {
		entityCache.putResult(
			MaSoThuChiModelImpl.ENTITY_CACHE_ENABLED, MaSoThuChiImpl.class,
			maSoThuChi.getPrimaryKey(), maSoThuChi);

		finderCache.putResult(
			_finderPathFetchByMa_Loai_HoatDong,
			new Object[] {
				maSoThuChi.getMa(), maSoThuChi.getLoai(),
				maSoThuChi.getHoatDong()
			},
			maSoThuChi);

		maSoThuChi.resetOriginalValues();
	}

	/**
	 * Caches the ma so thu chis in the entity cache if it is enabled.
	 *
	 * @param maSoThuChis the ma so thu chis
	 */
	@Override
	public void cacheResult(List<MaSoThuChi> maSoThuChis) {
		for (MaSoThuChi maSoThuChi : maSoThuChis) {
			if (entityCache.getResult(
					MaSoThuChiModelImpl.ENTITY_CACHE_ENABLED,
					MaSoThuChiImpl.class, maSoThuChi.getPrimaryKey()) == null) {

				cacheResult(maSoThuChi);
			}
			else {
				maSoThuChi.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ma so thu chis.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MaSoThuChiImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ma so thu chi.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MaSoThuChi maSoThuChi) {
		entityCache.removeResult(
			MaSoThuChiModelImpl.ENTITY_CACHE_ENABLED, MaSoThuChiImpl.class,
			maSoThuChi.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((MaSoThuChiModelImpl)maSoThuChi, true);
	}

	@Override
	public void clearCache(List<MaSoThuChi> maSoThuChis) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MaSoThuChi maSoThuChi : maSoThuChis) {
			entityCache.removeResult(
				MaSoThuChiModelImpl.ENTITY_CACHE_ENABLED, MaSoThuChiImpl.class,
				maSoThuChi.getPrimaryKey());

			clearUniqueFindersCache((MaSoThuChiModelImpl)maSoThuChi, true);
		}
	}

	protected void cacheUniqueFindersCache(
		MaSoThuChiModelImpl maSoThuChiModelImpl) {

		Object[] args = new Object[] {
			maSoThuChiModelImpl.getMa(), maSoThuChiModelImpl.getLoai(),
			maSoThuChiModelImpl.getHoatDong()
		};

		finderCache.putResult(
			_finderPathCountByMa_Loai_HoatDong, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByMa_Loai_HoatDong, args, maSoThuChiModelImpl,
			false);
	}

	protected void clearUniqueFindersCache(
		MaSoThuChiModelImpl maSoThuChiModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				maSoThuChiModelImpl.getMa(), maSoThuChiModelImpl.getLoai(),
				maSoThuChiModelImpl.getHoatDong()
			};

			finderCache.removeResult(_finderPathCountByMa_Loai_HoatDong, args);
			finderCache.removeResult(_finderPathFetchByMa_Loai_HoatDong, args);
		}

		if ((maSoThuChiModelImpl.getColumnBitmask() &
			 _finderPathFetchByMa_Loai_HoatDong.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				maSoThuChiModelImpl.getOriginalMa(),
				maSoThuChiModelImpl.getOriginalLoai(),
				maSoThuChiModelImpl.getOriginalHoatDong()
			};

			finderCache.removeResult(_finderPathCountByMa_Loai_HoatDong, args);
			finderCache.removeResult(_finderPathFetchByMa_Loai_HoatDong, args);
		}
	}

	/**
	 * Creates a new ma so thu chi with the primary key. Does not add the ma so thu chi to the database.
	 *
	 * @param maSoThuChiId the primary key for the new ma so thu chi
	 * @return the new ma so thu chi
	 */
	@Override
	public MaSoThuChi create(long maSoThuChiId) {
		MaSoThuChi maSoThuChi = new MaSoThuChiImpl();

		maSoThuChi.setNew(true);
		maSoThuChi.setPrimaryKey(maSoThuChiId);

		maSoThuChi.setCompanyId(companyProvider.getCompanyId());

		return maSoThuChi;
	}

	/**
	 * Removes the ma so thu chi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param maSoThuChiId the primary key of the ma so thu chi
	 * @return the ma so thu chi that was removed
	 * @throws NoSuchMaSoThuChiException if a ma so thu chi with the primary key could not be found
	 */
	@Override
	public MaSoThuChi remove(long maSoThuChiId)
		throws NoSuchMaSoThuChiException {

		return remove((Serializable)maSoThuChiId);
	}

	/**
	 * Removes the ma so thu chi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ma so thu chi
	 * @return the ma so thu chi that was removed
	 * @throws NoSuchMaSoThuChiException if a ma so thu chi with the primary key could not be found
	 */
	@Override
	public MaSoThuChi remove(Serializable primaryKey)
		throws NoSuchMaSoThuChiException {

		Session session = null;

		try {
			session = openSession();

			MaSoThuChi maSoThuChi = (MaSoThuChi)session.get(
				MaSoThuChiImpl.class, primaryKey);

			if (maSoThuChi == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMaSoThuChiException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(maSoThuChi);
		}
		catch (NoSuchMaSoThuChiException nsee) {
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
	protected MaSoThuChi removeImpl(MaSoThuChi maSoThuChi) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(maSoThuChi)) {
				maSoThuChi = (MaSoThuChi)session.get(
					MaSoThuChiImpl.class, maSoThuChi.getPrimaryKeyObj());
			}

			if (maSoThuChi != null) {
				session.delete(maSoThuChi);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (maSoThuChi != null) {
			clearCache(maSoThuChi);
		}

		return maSoThuChi;
	}

	@Override
	public MaSoThuChi updateImpl(MaSoThuChi maSoThuChi) {
		boolean isNew = maSoThuChi.isNew();

		if (!(maSoThuChi instanceof MaSoThuChiModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(maSoThuChi.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(maSoThuChi);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in maSoThuChi proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom MaSoThuChi implementation " +
					maSoThuChi.getClass());
		}

		MaSoThuChiModelImpl maSoThuChiModelImpl =
			(MaSoThuChiModelImpl)maSoThuChi;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (maSoThuChi.getCreateDate() == null)) {
			if (serviceContext == null) {
				maSoThuChi.setCreateDate(now);
			}
			else {
				maSoThuChi.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!maSoThuChiModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				maSoThuChi.setModifiedDate(now);
			}
			else {
				maSoThuChi.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (maSoThuChi.isNew()) {
				session.save(maSoThuChi);

				maSoThuChi.setNew(false);
			}
			else {
				maSoThuChi = (MaSoThuChi)session.merge(maSoThuChi);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!MaSoThuChiModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				maSoThuChiModelImpl.getLoai(), maSoThuChiModelImpl.getHoatDong()
			};

			finderCache.removeResult(_finderPathCountByLoai_HoatDong, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByLoai_HoatDong, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((maSoThuChiModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByLoai_HoatDong.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					maSoThuChiModelImpl.getOriginalLoai(),
					maSoThuChiModelImpl.getOriginalHoatDong()
				};

				finderCache.removeResult(_finderPathCountByLoai_HoatDong, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByLoai_HoatDong, args);

				args = new Object[] {
					maSoThuChiModelImpl.getLoai(),
					maSoThuChiModelImpl.getHoatDong()
				};

				finderCache.removeResult(_finderPathCountByLoai_HoatDong, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByLoai_HoatDong, args);
			}
		}

		entityCache.putResult(
			MaSoThuChiModelImpl.ENTITY_CACHE_ENABLED, MaSoThuChiImpl.class,
			maSoThuChi.getPrimaryKey(), maSoThuChi, false);

		clearUniqueFindersCache(maSoThuChiModelImpl, false);
		cacheUniqueFindersCache(maSoThuChiModelImpl);

		maSoThuChi.resetOriginalValues();

		return maSoThuChi;
	}

	/**
	 * Returns the ma so thu chi with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ma so thu chi
	 * @return the ma so thu chi
	 * @throws NoSuchMaSoThuChiException if a ma so thu chi with the primary key could not be found
	 */
	@Override
	public MaSoThuChi findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMaSoThuChiException {

		MaSoThuChi maSoThuChi = fetchByPrimaryKey(primaryKey);

		if (maSoThuChi == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMaSoThuChiException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return maSoThuChi;
	}

	/**
	 * Returns the ma so thu chi with the primary key or throws a <code>NoSuchMaSoThuChiException</code> if it could not be found.
	 *
	 * @param maSoThuChiId the primary key of the ma so thu chi
	 * @return the ma so thu chi
	 * @throws NoSuchMaSoThuChiException if a ma so thu chi with the primary key could not be found
	 */
	@Override
	public MaSoThuChi findByPrimaryKey(long maSoThuChiId)
		throws NoSuchMaSoThuChiException {

		return findByPrimaryKey((Serializable)maSoThuChiId);
	}

	/**
	 * Returns the ma so thu chi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ma so thu chi
	 * @return the ma so thu chi, or <code>null</code> if a ma so thu chi with the primary key could not be found
	 */
	@Override
	public MaSoThuChi fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			MaSoThuChiModelImpl.ENTITY_CACHE_ENABLED, MaSoThuChiImpl.class,
			primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		MaSoThuChi maSoThuChi = (MaSoThuChi)serializable;

		if (maSoThuChi == null) {
			Session session = null;

			try {
				session = openSession();

				maSoThuChi = (MaSoThuChi)session.get(
					MaSoThuChiImpl.class, primaryKey);

				if (maSoThuChi != null) {
					cacheResult(maSoThuChi);
				}
				else {
					entityCache.putResult(
						MaSoThuChiModelImpl.ENTITY_CACHE_ENABLED,
						MaSoThuChiImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					MaSoThuChiModelImpl.ENTITY_CACHE_ENABLED,
					MaSoThuChiImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return maSoThuChi;
	}

	/**
	 * Returns the ma so thu chi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param maSoThuChiId the primary key of the ma so thu chi
	 * @return the ma so thu chi, or <code>null</code> if a ma so thu chi with the primary key could not be found
	 */
	@Override
	public MaSoThuChi fetchByPrimaryKey(long maSoThuChiId) {
		return fetchByPrimaryKey((Serializable)maSoThuChiId);
	}

	@Override
	public Map<Serializable, MaSoThuChi> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, MaSoThuChi> map =
			new HashMap<Serializable, MaSoThuChi>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			MaSoThuChi maSoThuChi = fetchByPrimaryKey(primaryKey);

			if (maSoThuChi != null) {
				map.put(primaryKey, maSoThuChi);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				MaSoThuChiModelImpl.ENTITY_CACHE_ENABLED, MaSoThuChiImpl.class,
				primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (MaSoThuChi)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_MASOTHUCHI_WHERE_PKS_IN);

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

			for (MaSoThuChi maSoThuChi : (List<MaSoThuChi>)q.list()) {
				map.put(maSoThuChi.getPrimaryKeyObj(), maSoThuChi);

				cacheResult(maSoThuChi);

				uncachedPrimaryKeys.remove(maSoThuChi.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					MaSoThuChiModelImpl.ENTITY_CACHE_ENABLED,
					MaSoThuChiImpl.class, primaryKey, nullModel);
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
	 * Returns all the ma so thu chis.
	 *
	 * @return the ma so thu chis
	 */
	@Override
	public List<MaSoThuChi> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ma so thu chis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MaSoThuChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ma so thu chis
	 * @param end the upper bound of the range of ma so thu chis (not inclusive)
	 * @return the range of ma so thu chis
	 */
	@Override
	public List<MaSoThuChi> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ma so thu chis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MaSoThuChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ma so thu chis
	 * @param end the upper bound of the range of ma so thu chis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ma so thu chis
	 */
	@Override
	public List<MaSoThuChi> findAll(
		int start, int end, OrderByComparator<MaSoThuChi> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ma so thu chis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MaSoThuChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ma so thu chis
	 * @param end the upper bound of the range of ma so thu chis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of ma so thu chis
	 */
	@Override
	public List<MaSoThuChi> findAll(
		int start, int end, OrderByComparator<MaSoThuChi> orderByComparator,
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

		List<MaSoThuChi> list = null;

		if (retrieveFromCache) {
			list = (List<MaSoThuChi>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_MASOTHUCHI);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MASOTHUCHI;

				if (pagination) {
					sql = sql.concat(MaSoThuChiModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<MaSoThuChi>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<MaSoThuChi>)QueryUtil.list(
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
	 * Removes all the ma so thu chis from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (MaSoThuChi maSoThuChi : findAll()) {
			remove(maSoThuChi);
		}
	}

	/**
	 * Returns the number of ma so thu chis.
	 *
	 * @return the number of ma so thu chis
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_MASOTHUCHI);

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
		return MaSoThuChiModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the ma so thu chi persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			MaSoThuChiModelImpl.ENTITY_CACHE_ENABLED,
			MaSoThuChiModelImpl.FINDER_CACHE_ENABLED, MaSoThuChiImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			MaSoThuChiModelImpl.ENTITY_CACHE_ENABLED,
			MaSoThuChiModelImpl.FINDER_CACHE_ENABLED, MaSoThuChiImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			MaSoThuChiModelImpl.ENTITY_CACHE_ENABLED,
			MaSoThuChiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByMa_Loai_HoatDong = new FinderPath(
			MaSoThuChiModelImpl.ENTITY_CACHE_ENABLED,
			MaSoThuChiModelImpl.FINDER_CACHE_ENABLED, MaSoThuChiImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByMa_Loai_HoatDong",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Boolean.class.getName()
			},
			MaSoThuChiModelImpl.MA_COLUMN_BITMASK |
			MaSoThuChiModelImpl.LOAI_COLUMN_BITMASK |
			MaSoThuChiModelImpl.HOATDONG_COLUMN_BITMASK);

		_finderPathCountByMa_Loai_HoatDong = new FinderPath(
			MaSoThuChiModelImpl.ENTITY_CACHE_ENABLED,
			MaSoThuChiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByMa_Loai_HoatDong",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Boolean.class.getName()
			});

		_finderPathWithPaginationFindByLoai_HoatDong = new FinderPath(
			MaSoThuChiModelImpl.ENTITY_CACHE_ENABLED,
			MaSoThuChiModelImpl.FINDER_CACHE_ENABLED, MaSoThuChiImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLoai_HoatDong",
			new String[] {
				Integer.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByLoai_HoatDong = new FinderPath(
			MaSoThuChiModelImpl.ENTITY_CACHE_ENABLED,
			MaSoThuChiModelImpl.FINDER_CACHE_ENABLED, MaSoThuChiImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLoai_HoatDong",
			new String[] {Integer.class.getName(), Boolean.class.getName()},
			MaSoThuChiModelImpl.LOAI_COLUMN_BITMASK |
			MaSoThuChiModelImpl.HOATDONG_COLUMN_BITMASK);

		_finderPathCountByLoai_HoatDong = new FinderPath(
			MaSoThuChiModelImpl.ENTITY_CACHE_ENABLED,
			MaSoThuChiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLoai_HoatDong",
			new String[] {Integer.class.getName(), Boolean.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(MaSoThuChiImpl.class.getName());
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

	private static final String _SQL_SELECT_MASOTHUCHI =
		"SELECT maSoThuChi FROM MaSoThuChi maSoThuChi";

	private static final String _SQL_SELECT_MASOTHUCHI_WHERE_PKS_IN =
		"SELECT maSoThuChi FROM MaSoThuChi maSoThuChi WHERE maSoThuChiId IN (";

	private static final String _SQL_SELECT_MASOTHUCHI_WHERE =
		"SELECT maSoThuChi FROM MaSoThuChi maSoThuChi WHERE ";

	private static final String _SQL_COUNT_MASOTHUCHI =
		"SELECT COUNT(maSoThuChi) FROM MaSoThuChi maSoThuChi";

	private static final String _SQL_COUNT_MASOTHUCHI_WHERE =
		"SELECT COUNT(maSoThuChi) FROM MaSoThuChi maSoThuChi WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "maSoThuChi.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No MaSoThuChi exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No MaSoThuChi exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		MaSoThuChiPersistenceImpl.class);

}