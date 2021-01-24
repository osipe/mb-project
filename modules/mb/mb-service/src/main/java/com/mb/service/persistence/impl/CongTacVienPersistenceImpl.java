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

import com.mb.exception.NoSuchCongTacVienException;
import com.mb.model.CongTacVien;
import com.mb.model.impl.CongTacVienImpl;
import com.mb.model.impl.CongTacVienModelImpl;
import com.mb.service.persistence.CongTacVienPersistence;

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
 * The persistence implementation for the cong tac vien service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class CongTacVienPersistenceImpl
	extends BasePersistenceImpl<CongTacVien> implements CongTacVienPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CongTacVienUtil</code> to access the cong tac vien persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CongTacVienImpl.class.getName();

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
	 * Returns the cong tac vien where ma = &#63; or throws a <code>NoSuchCongTacVienException</code> if it could not be found.
	 *
	 * @param ma the ma
	 * @return the matching cong tac vien
	 * @throws NoSuchCongTacVienException if a matching cong tac vien could not be found
	 */
	@Override
	public CongTacVien findByMa(String ma) throws NoSuchCongTacVienException {
		CongTacVien congTacVien = fetchByMa(ma);

		if (congTacVien == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ma=");
			msg.append(ma);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchCongTacVienException(msg.toString());
		}

		return congTacVien;
	}

	/**
	 * Returns the cong tac vien where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ma the ma
	 * @return the matching cong tac vien, or <code>null</code> if a matching cong tac vien could not be found
	 */
	@Override
	public CongTacVien fetchByMa(String ma) {
		return fetchByMa(ma, true);
	}

	/**
	 * Returns the cong tac vien where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ma the ma
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching cong tac vien, or <code>null</code> if a matching cong tac vien could not be found
	 */
	@Override
	public CongTacVien fetchByMa(String ma, boolean retrieveFromCache) {
		ma = Objects.toString(ma, "");

		Object[] finderArgs = new Object[] {ma};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByMa, finderArgs, this);
		}

		if (result instanceof CongTacVien) {
			CongTacVien congTacVien = (CongTacVien)result;

			if (!Objects.equals(ma, congTacVien.getMa())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_CONGTACVIEN_WHERE);

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

				List<CongTacVien> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByMa, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"CongTacVienPersistenceImpl.fetchByMa(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					CongTacVien congTacVien = list.get(0);

					result = congTacVien;

					cacheResult(congTacVien);
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
			return (CongTacVien)result;
		}
	}

	/**
	 * Removes the cong tac vien where ma = &#63; from the database.
	 *
	 * @param ma the ma
	 * @return the cong tac vien that was removed
	 */
	@Override
	public CongTacVien removeByMa(String ma) throws NoSuchCongTacVienException {
		CongTacVien congTacVien = findByMa(ma);

		return remove(congTacVien);
	}

	/**
	 * Returns the number of cong tac viens where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the number of matching cong tac viens
	 */
	@Override
	public int countByMa(String ma) {
		ma = Objects.toString(ma, "");

		FinderPath finderPath = _finderPathCountByMa;

		Object[] finderArgs = new Object[] {ma};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONGTACVIEN_WHERE);

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

	private static final String _FINDER_COLUMN_MA_MA_2 = "congTacVien.ma = ?";

	private static final String _FINDER_COLUMN_MA_MA_3 =
		"(congTacVien.ma IS NULL OR congTacVien.ma = '')";

	private FinderPath _finderPathFetchBySoCMND;
	private FinderPath _finderPathCountBySoCMND;

	/**
	 * Returns the cong tac vien where soCMND = &#63; or throws a <code>NoSuchCongTacVienException</code> if it could not be found.
	 *
	 * @param soCMND the so cmnd
	 * @return the matching cong tac vien
	 * @throws NoSuchCongTacVienException if a matching cong tac vien could not be found
	 */
	@Override
	public CongTacVien findBySoCMND(String soCMND)
		throws NoSuchCongTacVienException {

		CongTacVien congTacVien = fetchBySoCMND(soCMND);

		if (congTacVien == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("soCMND=");
			msg.append(soCMND);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchCongTacVienException(msg.toString());
		}

		return congTacVien;
	}

	/**
	 * Returns the cong tac vien where soCMND = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param soCMND the so cmnd
	 * @return the matching cong tac vien, or <code>null</code> if a matching cong tac vien could not be found
	 */
	@Override
	public CongTacVien fetchBySoCMND(String soCMND) {
		return fetchBySoCMND(soCMND, true);
	}

	/**
	 * Returns the cong tac vien where soCMND = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param soCMND the so cmnd
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching cong tac vien, or <code>null</code> if a matching cong tac vien could not be found
	 */
	@Override
	public CongTacVien fetchBySoCMND(String soCMND, boolean retrieveFromCache) {
		soCMND = Objects.toString(soCMND, "");

		Object[] finderArgs = new Object[] {soCMND};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchBySoCMND, finderArgs, this);
		}

		if (result instanceof CongTacVien) {
			CongTacVien congTacVien = (CongTacVien)result;

			if (!Objects.equals(soCMND, congTacVien.getSoCMND())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_CONGTACVIEN_WHERE);

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

				List<CongTacVien> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchBySoCMND, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"CongTacVienPersistenceImpl.fetchBySoCMND(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					CongTacVien congTacVien = list.get(0);

					result = congTacVien;

					cacheResult(congTacVien);
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
			return (CongTacVien)result;
		}
	}

	/**
	 * Removes the cong tac vien where soCMND = &#63; from the database.
	 *
	 * @param soCMND the so cmnd
	 * @return the cong tac vien that was removed
	 */
	@Override
	public CongTacVien removeBySoCMND(String soCMND)
		throws NoSuchCongTacVienException {

		CongTacVien congTacVien = findBySoCMND(soCMND);

		return remove(congTacVien);
	}

	/**
	 * Returns the number of cong tac viens where soCMND = &#63;.
	 *
	 * @param soCMND the so cmnd
	 * @return the number of matching cong tac viens
	 */
	@Override
	public int countBySoCMND(String soCMND) {
		soCMND = Objects.toString(soCMND, "");

		FinderPath finderPath = _finderPathCountBySoCMND;

		Object[] finderArgs = new Object[] {soCMND};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONGTACVIEN_WHERE);

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
		"congTacVien.soCMND = ?";

	private static final String _FINDER_COLUMN_SOCMND_SOCMND_3 =
		"(congTacVien.soCMND IS NULL OR congTacVien.soCMND = '')";

	private FinderPath _finderPathWithPaginationFindByChiNhanh_HoatDong;
	private FinderPath _finderPathWithoutPaginationFindByChiNhanh_HoatDong;
	private FinderPath _finderPathCountByChiNhanh_HoatDong;

	/**
	 * Returns all the cong tac viens where chiNhanhId = &#63; and hoatDong = &#63;.
	 *
	 * @param chiNhanhId the chi nhanh ID
	 * @param hoatDong the hoat dong
	 * @return the matching cong tac viens
	 */
	@Override
	public List<CongTacVien> findByChiNhanh_HoatDong(
		long chiNhanhId, Boolean hoatDong) {

		return findByChiNhanh_HoatDong(
			chiNhanhId, hoatDong, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cong tac viens where chiNhanhId = &#63; and hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CongTacVienModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param chiNhanhId the chi nhanh ID
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of cong tac viens
	 * @param end the upper bound of the range of cong tac viens (not inclusive)
	 * @return the range of matching cong tac viens
	 */
	@Override
	public List<CongTacVien> findByChiNhanh_HoatDong(
		long chiNhanhId, Boolean hoatDong, int start, int end) {

		return findByChiNhanh_HoatDong(chiNhanhId, hoatDong, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cong tac viens where chiNhanhId = &#63; and hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CongTacVienModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param chiNhanhId the chi nhanh ID
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of cong tac viens
	 * @param end the upper bound of the range of cong tac viens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cong tac viens
	 */
	@Override
	public List<CongTacVien> findByChiNhanh_HoatDong(
		long chiNhanhId, Boolean hoatDong, int start, int end,
		OrderByComparator<CongTacVien> orderByComparator) {

		return findByChiNhanh_HoatDong(
			chiNhanhId, hoatDong, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cong tac viens where chiNhanhId = &#63; and hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CongTacVienModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param chiNhanhId the chi nhanh ID
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of cong tac viens
	 * @param end the upper bound of the range of cong tac viens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching cong tac viens
	 */
	@Override
	public List<CongTacVien> findByChiNhanh_HoatDong(
		long chiNhanhId, Boolean hoatDong, int start, int end,
		OrderByComparator<CongTacVien> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByChiNhanh_HoatDong;
			finderArgs = new Object[] {chiNhanhId, hoatDong};
		}
		else {
			finderPath = _finderPathWithPaginationFindByChiNhanh_HoatDong;
			finderArgs = new Object[] {
				chiNhanhId, hoatDong, start, end, orderByComparator
			};
		}

		List<CongTacVien> list = null;

		if (retrieveFromCache) {
			list = (List<CongTacVien>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CongTacVien congTacVien : list) {
					if ((chiNhanhId != congTacVien.getChiNhanhId()) ||
						!Objects.equals(hoatDong, congTacVien.getHoatDong())) {

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

			query.append(_SQL_SELECT_CONGTACVIEN_WHERE);

			query.append(_FINDER_COLUMN_CHINHANH_HOATDONG_CHINHANHID_2);

			query.append(_FINDER_COLUMN_CHINHANH_HOATDONG_HOATDONG_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(CongTacVienModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(chiNhanhId);

				qPos.add(hoatDong.booleanValue());

				if (!pagination) {
					list = (List<CongTacVien>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CongTacVien>)QueryUtil.list(
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
	 * Returns the first cong tac vien in the ordered set where chiNhanhId = &#63; and hoatDong = &#63;.
	 *
	 * @param chiNhanhId the chi nhanh ID
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cong tac vien
	 * @throws NoSuchCongTacVienException if a matching cong tac vien could not be found
	 */
	@Override
	public CongTacVien findByChiNhanh_HoatDong_First(
			long chiNhanhId, Boolean hoatDong,
			OrderByComparator<CongTacVien> orderByComparator)
		throws NoSuchCongTacVienException {

		CongTacVien congTacVien = fetchByChiNhanh_HoatDong_First(
			chiNhanhId, hoatDong, orderByComparator);

		if (congTacVien != null) {
			return congTacVien;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("chiNhanhId=");
		msg.append(chiNhanhId);

		msg.append(", hoatDong=");
		msg.append(hoatDong);

		msg.append("}");

		throw new NoSuchCongTacVienException(msg.toString());
	}

	/**
	 * Returns the first cong tac vien in the ordered set where chiNhanhId = &#63; and hoatDong = &#63;.
	 *
	 * @param chiNhanhId the chi nhanh ID
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cong tac vien, or <code>null</code> if a matching cong tac vien could not be found
	 */
	@Override
	public CongTacVien fetchByChiNhanh_HoatDong_First(
		long chiNhanhId, Boolean hoatDong,
		OrderByComparator<CongTacVien> orderByComparator) {

		List<CongTacVien> list = findByChiNhanh_HoatDong(
			chiNhanhId, hoatDong, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cong tac vien in the ordered set where chiNhanhId = &#63; and hoatDong = &#63;.
	 *
	 * @param chiNhanhId the chi nhanh ID
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cong tac vien
	 * @throws NoSuchCongTacVienException if a matching cong tac vien could not be found
	 */
	@Override
	public CongTacVien findByChiNhanh_HoatDong_Last(
			long chiNhanhId, Boolean hoatDong,
			OrderByComparator<CongTacVien> orderByComparator)
		throws NoSuchCongTacVienException {

		CongTacVien congTacVien = fetchByChiNhanh_HoatDong_Last(
			chiNhanhId, hoatDong, orderByComparator);

		if (congTacVien != null) {
			return congTacVien;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("chiNhanhId=");
		msg.append(chiNhanhId);

		msg.append(", hoatDong=");
		msg.append(hoatDong);

		msg.append("}");

		throw new NoSuchCongTacVienException(msg.toString());
	}

	/**
	 * Returns the last cong tac vien in the ordered set where chiNhanhId = &#63; and hoatDong = &#63;.
	 *
	 * @param chiNhanhId the chi nhanh ID
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cong tac vien, or <code>null</code> if a matching cong tac vien could not be found
	 */
	@Override
	public CongTacVien fetchByChiNhanh_HoatDong_Last(
		long chiNhanhId, Boolean hoatDong,
		OrderByComparator<CongTacVien> orderByComparator) {

		int count = countByChiNhanh_HoatDong(chiNhanhId, hoatDong);

		if (count == 0) {
			return null;
		}

		List<CongTacVien> list = findByChiNhanh_HoatDong(
			chiNhanhId, hoatDong, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cong tac viens before and after the current cong tac vien in the ordered set where chiNhanhId = &#63; and hoatDong = &#63;.
	 *
	 * @param congTacVienId the primary key of the current cong tac vien
	 * @param chiNhanhId the chi nhanh ID
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cong tac vien
	 * @throws NoSuchCongTacVienException if a cong tac vien with the primary key could not be found
	 */
	@Override
	public CongTacVien[] findByChiNhanh_HoatDong_PrevAndNext(
			long congTacVienId, long chiNhanhId, Boolean hoatDong,
			OrderByComparator<CongTacVien> orderByComparator)
		throws NoSuchCongTacVienException {

		CongTacVien congTacVien = findByPrimaryKey(congTacVienId);

		Session session = null;

		try {
			session = openSession();

			CongTacVien[] array = new CongTacVienImpl[3];

			array[0] = getByChiNhanh_HoatDong_PrevAndNext(
				session, congTacVien, chiNhanhId, hoatDong, orderByComparator,
				true);

			array[1] = congTacVien;

			array[2] = getByChiNhanh_HoatDong_PrevAndNext(
				session, congTacVien, chiNhanhId, hoatDong, orderByComparator,
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

	protected CongTacVien getByChiNhanh_HoatDong_PrevAndNext(
		Session session, CongTacVien congTacVien, long chiNhanhId,
		Boolean hoatDong, OrderByComparator<CongTacVien> orderByComparator,
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

		query.append(_SQL_SELECT_CONGTACVIEN_WHERE);

		query.append(_FINDER_COLUMN_CHINHANH_HOATDONG_CHINHANHID_2);

		query.append(_FINDER_COLUMN_CHINHANH_HOATDONG_HOATDONG_2);

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
			query.append(CongTacVienModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(chiNhanhId);

		qPos.add(hoatDong.booleanValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(congTacVien)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<CongTacVien> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cong tac viens where chiNhanhId = &#63; and hoatDong = &#63; from the database.
	 *
	 * @param chiNhanhId the chi nhanh ID
	 * @param hoatDong the hoat dong
	 */
	@Override
	public void removeByChiNhanh_HoatDong(long chiNhanhId, Boolean hoatDong) {
		for (CongTacVien congTacVien :
				findByChiNhanh_HoatDong(
					chiNhanhId, hoatDong, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(congTacVien);
		}
	}

	/**
	 * Returns the number of cong tac viens where chiNhanhId = &#63; and hoatDong = &#63;.
	 *
	 * @param chiNhanhId the chi nhanh ID
	 * @param hoatDong the hoat dong
	 * @return the number of matching cong tac viens
	 */
	@Override
	public int countByChiNhanh_HoatDong(long chiNhanhId, Boolean hoatDong) {
		FinderPath finderPath = _finderPathCountByChiNhanh_HoatDong;

		Object[] finderArgs = new Object[] {chiNhanhId, hoatDong};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONGTACVIEN_WHERE);

			query.append(_FINDER_COLUMN_CHINHANH_HOATDONG_CHINHANHID_2);

			query.append(_FINDER_COLUMN_CHINHANH_HOATDONG_HOATDONG_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(chiNhanhId);

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

	private static final String _FINDER_COLUMN_CHINHANH_HOATDONG_CHINHANHID_2 =
		"congTacVien.chiNhanhId = ? AND ";

	private static final String _FINDER_COLUMN_CHINHANH_HOATDONG_HOATDONG_2 =
		"congTacVien.hoatDong = ?";

	private FinderPath _finderPathWithPaginationFindByChiNhanh;
	private FinderPath _finderPathWithoutPaginationFindByChiNhanh;
	private FinderPath _finderPathCountByChiNhanh;

	/**
	 * Returns all the cong tac viens where chiNhanhId = &#63;.
	 *
	 * @param chiNhanhId the chi nhanh ID
	 * @return the matching cong tac viens
	 */
	@Override
	public List<CongTacVien> findByChiNhanh(long chiNhanhId) {
		return findByChiNhanh(
			chiNhanhId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cong tac viens where chiNhanhId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CongTacVienModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param chiNhanhId the chi nhanh ID
	 * @param start the lower bound of the range of cong tac viens
	 * @param end the upper bound of the range of cong tac viens (not inclusive)
	 * @return the range of matching cong tac viens
	 */
	@Override
	public List<CongTacVien> findByChiNhanh(
		long chiNhanhId, int start, int end) {

		return findByChiNhanh(chiNhanhId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cong tac viens where chiNhanhId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CongTacVienModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param chiNhanhId the chi nhanh ID
	 * @param start the lower bound of the range of cong tac viens
	 * @param end the upper bound of the range of cong tac viens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cong tac viens
	 */
	@Override
	public List<CongTacVien> findByChiNhanh(
		long chiNhanhId, int start, int end,
		OrderByComparator<CongTacVien> orderByComparator) {

		return findByChiNhanh(chiNhanhId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cong tac viens where chiNhanhId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CongTacVienModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param chiNhanhId the chi nhanh ID
	 * @param start the lower bound of the range of cong tac viens
	 * @param end the upper bound of the range of cong tac viens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching cong tac viens
	 */
	@Override
	public List<CongTacVien> findByChiNhanh(
		long chiNhanhId, int start, int end,
		OrderByComparator<CongTacVien> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByChiNhanh;
			finderArgs = new Object[] {chiNhanhId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByChiNhanh;
			finderArgs = new Object[] {
				chiNhanhId, start, end, orderByComparator
			};
		}

		List<CongTacVien> list = null;

		if (retrieveFromCache) {
			list = (List<CongTacVien>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CongTacVien congTacVien : list) {
					if ((chiNhanhId != congTacVien.getChiNhanhId())) {
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

			query.append(_SQL_SELECT_CONGTACVIEN_WHERE);

			query.append(_FINDER_COLUMN_CHINHANH_CHINHANHID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(CongTacVienModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(chiNhanhId);

				if (!pagination) {
					list = (List<CongTacVien>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CongTacVien>)QueryUtil.list(
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
	 * Returns the first cong tac vien in the ordered set where chiNhanhId = &#63;.
	 *
	 * @param chiNhanhId the chi nhanh ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cong tac vien
	 * @throws NoSuchCongTacVienException if a matching cong tac vien could not be found
	 */
	@Override
	public CongTacVien findByChiNhanh_First(
			long chiNhanhId, OrderByComparator<CongTacVien> orderByComparator)
		throws NoSuchCongTacVienException {

		CongTacVien congTacVien = fetchByChiNhanh_First(
			chiNhanhId, orderByComparator);

		if (congTacVien != null) {
			return congTacVien;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("chiNhanhId=");
		msg.append(chiNhanhId);

		msg.append("}");

		throw new NoSuchCongTacVienException(msg.toString());
	}

	/**
	 * Returns the first cong tac vien in the ordered set where chiNhanhId = &#63;.
	 *
	 * @param chiNhanhId the chi nhanh ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cong tac vien, or <code>null</code> if a matching cong tac vien could not be found
	 */
	@Override
	public CongTacVien fetchByChiNhanh_First(
		long chiNhanhId, OrderByComparator<CongTacVien> orderByComparator) {

		List<CongTacVien> list = findByChiNhanh(
			chiNhanhId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cong tac vien in the ordered set where chiNhanhId = &#63;.
	 *
	 * @param chiNhanhId the chi nhanh ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cong tac vien
	 * @throws NoSuchCongTacVienException if a matching cong tac vien could not be found
	 */
	@Override
	public CongTacVien findByChiNhanh_Last(
			long chiNhanhId, OrderByComparator<CongTacVien> orderByComparator)
		throws NoSuchCongTacVienException {

		CongTacVien congTacVien = fetchByChiNhanh_Last(
			chiNhanhId, orderByComparator);

		if (congTacVien != null) {
			return congTacVien;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("chiNhanhId=");
		msg.append(chiNhanhId);

		msg.append("}");

		throw new NoSuchCongTacVienException(msg.toString());
	}

	/**
	 * Returns the last cong tac vien in the ordered set where chiNhanhId = &#63;.
	 *
	 * @param chiNhanhId the chi nhanh ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cong tac vien, or <code>null</code> if a matching cong tac vien could not be found
	 */
	@Override
	public CongTacVien fetchByChiNhanh_Last(
		long chiNhanhId, OrderByComparator<CongTacVien> orderByComparator) {

		int count = countByChiNhanh(chiNhanhId);

		if (count == 0) {
			return null;
		}

		List<CongTacVien> list = findByChiNhanh(
			chiNhanhId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cong tac viens before and after the current cong tac vien in the ordered set where chiNhanhId = &#63;.
	 *
	 * @param congTacVienId the primary key of the current cong tac vien
	 * @param chiNhanhId the chi nhanh ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cong tac vien
	 * @throws NoSuchCongTacVienException if a cong tac vien with the primary key could not be found
	 */
	@Override
	public CongTacVien[] findByChiNhanh_PrevAndNext(
			long congTacVienId, long chiNhanhId,
			OrderByComparator<CongTacVien> orderByComparator)
		throws NoSuchCongTacVienException {

		CongTacVien congTacVien = findByPrimaryKey(congTacVienId);

		Session session = null;

		try {
			session = openSession();

			CongTacVien[] array = new CongTacVienImpl[3];

			array[0] = getByChiNhanh_PrevAndNext(
				session, congTacVien, chiNhanhId, orderByComparator, true);

			array[1] = congTacVien;

			array[2] = getByChiNhanh_PrevAndNext(
				session, congTacVien, chiNhanhId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CongTacVien getByChiNhanh_PrevAndNext(
		Session session, CongTacVien congTacVien, long chiNhanhId,
		OrderByComparator<CongTacVien> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONGTACVIEN_WHERE);

		query.append(_FINDER_COLUMN_CHINHANH_CHINHANHID_2);

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
			query.append(CongTacVienModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(chiNhanhId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(congTacVien)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<CongTacVien> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cong tac viens where chiNhanhId = &#63; from the database.
	 *
	 * @param chiNhanhId the chi nhanh ID
	 */
	@Override
	public void removeByChiNhanh(long chiNhanhId) {
		for (CongTacVien congTacVien :
				findByChiNhanh(
					chiNhanhId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(congTacVien);
		}
	}

	/**
	 * Returns the number of cong tac viens where chiNhanhId = &#63;.
	 *
	 * @param chiNhanhId the chi nhanh ID
	 * @return the number of matching cong tac viens
	 */
	@Override
	public int countByChiNhanh(long chiNhanhId) {
		FinderPath finderPath = _finderPathCountByChiNhanh;

		Object[] finderArgs = new Object[] {chiNhanhId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONGTACVIEN_WHERE);

			query.append(_FINDER_COLUMN_CHINHANH_CHINHANHID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(chiNhanhId);

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

	private static final String _FINDER_COLUMN_CHINHANH_CHINHANHID_2 =
		"congTacVien.chiNhanhId = ?";

	public CongTacVienPersistenceImpl() {
		setModelClass(CongTacVien.class);
	}

	/**
	 * Caches the cong tac vien in the entity cache if it is enabled.
	 *
	 * @param congTacVien the cong tac vien
	 */
	@Override
	public void cacheResult(CongTacVien congTacVien) {
		entityCache.putResult(
			CongTacVienModelImpl.ENTITY_CACHE_ENABLED, CongTacVienImpl.class,
			congTacVien.getPrimaryKey(), congTacVien);

		finderCache.putResult(
			_finderPathFetchByMa, new Object[] {congTacVien.getMa()},
			congTacVien);

		finderCache.putResult(
			_finderPathFetchBySoCMND, new Object[] {congTacVien.getSoCMND()},
			congTacVien);

		congTacVien.resetOriginalValues();
	}

	/**
	 * Caches the cong tac viens in the entity cache if it is enabled.
	 *
	 * @param congTacViens the cong tac viens
	 */
	@Override
	public void cacheResult(List<CongTacVien> congTacViens) {
		for (CongTacVien congTacVien : congTacViens) {
			if (entityCache.getResult(
					CongTacVienModelImpl.ENTITY_CACHE_ENABLED,
					CongTacVienImpl.class, congTacVien.getPrimaryKey()) ==
						null) {

				cacheResult(congTacVien);
			}
			else {
				congTacVien.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cong tac viens.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CongTacVienImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cong tac vien.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CongTacVien congTacVien) {
		entityCache.removeResult(
			CongTacVienModelImpl.ENTITY_CACHE_ENABLED, CongTacVienImpl.class,
			congTacVien.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((CongTacVienModelImpl)congTacVien, true);
	}

	@Override
	public void clearCache(List<CongTacVien> congTacViens) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CongTacVien congTacVien : congTacViens) {
			entityCache.removeResult(
				CongTacVienModelImpl.ENTITY_CACHE_ENABLED,
				CongTacVienImpl.class, congTacVien.getPrimaryKey());

			clearUniqueFindersCache((CongTacVienModelImpl)congTacVien, true);
		}
	}

	protected void cacheUniqueFindersCache(
		CongTacVienModelImpl congTacVienModelImpl) {

		Object[] args = new Object[] {congTacVienModelImpl.getMa()};

		finderCache.putResult(
			_finderPathCountByMa, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByMa, args, congTacVienModelImpl, false);

		args = new Object[] {congTacVienModelImpl.getSoCMND()};

		finderCache.putResult(
			_finderPathCountBySoCMND, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchBySoCMND, args, congTacVienModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		CongTacVienModelImpl congTacVienModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {congTacVienModelImpl.getMa()};

			finderCache.removeResult(_finderPathCountByMa, args);
			finderCache.removeResult(_finderPathFetchByMa, args);
		}

		if ((congTacVienModelImpl.getColumnBitmask() &
			 _finderPathFetchByMa.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {congTacVienModelImpl.getOriginalMa()};

			finderCache.removeResult(_finderPathCountByMa, args);
			finderCache.removeResult(_finderPathFetchByMa, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {congTacVienModelImpl.getSoCMND()};

			finderCache.removeResult(_finderPathCountBySoCMND, args);
			finderCache.removeResult(_finderPathFetchBySoCMND, args);
		}

		if ((congTacVienModelImpl.getColumnBitmask() &
			 _finderPathFetchBySoCMND.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				congTacVienModelImpl.getOriginalSoCMND()
			};

			finderCache.removeResult(_finderPathCountBySoCMND, args);
			finderCache.removeResult(_finderPathFetchBySoCMND, args);
		}
	}

	/**
	 * Creates a new cong tac vien with the primary key. Does not add the cong tac vien to the database.
	 *
	 * @param congTacVienId the primary key for the new cong tac vien
	 * @return the new cong tac vien
	 */
	@Override
	public CongTacVien create(long congTacVienId) {
		CongTacVien congTacVien = new CongTacVienImpl();

		congTacVien.setNew(true);
		congTacVien.setPrimaryKey(congTacVienId);

		congTacVien.setCompanyId(companyProvider.getCompanyId());

		return congTacVien;
	}

	/**
	 * Removes the cong tac vien with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param congTacVienId the primary key of the cong tac vien
	 * @return the cong tac vien that was removed
	 * @throws NoSuchCongTacVienException if a cong tac vien with the primary key could not be found
	 */
	@Override
	public CongTacVien remove(long congTacVienId)
		throws NoSuchCongTacVienException {

		return remove((Serializable)congTacVienId);
	}

	/**
	 * Removes the cong tac vien with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cong tac vien
	 * @return the cong tac vien that was removed
	 * @throws NoSuchCongTacVienException if a cong tac vien with the primary key could not be found
	 */
	@Override
	public CongTacVien remove(Serializable primaryKey)
		throws NoSuchCongTacVienException {

		Session session = null;

		try {
			session = openSession();

			CongTacVien congTacVien = (CongTacVien)session.get(
				CongTacVienImpl.class, primaryKey);

			if (congTacVien == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCongTacVienException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(congTacVien);
		}
		catch (NoSuchCongTacVienException nsee) {
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
	protected CongTacVien removeImpl(CongTacVien congTacVien) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(congTacVien)) {
				congTacVien = (CongTacVien)session.get(
					CongTacVienImpl.class, congTacVien.getPrimaryKeyObj());
			}

			if (congTacVien != null) {
				session.delete(congTacVien);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (congTacVien != null) {
			clearCache(congTacVien);
		}

		return congTacVien;
	}

	@Override
	public CongTacVien updateImpl(CongTacVien congTacVien) {
		boolean isNew = congTacVien.isNew();

		if (!(congTacVien instanceof CongTacVienModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(congTacVien.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(congTacVien);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in congTacVien proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CongTacVien implementation " +
					congTacVien.getClass());
		}

		CongTacVienModelImpl congTacVienModelImpl =
			(CongTacVienModelImpl)congTacVien;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (congTacVien.getCreateDate() == null)) {
			if (serviceContext == null) {
				congTacVien.setCreateDate(now);
			}
			else {
				congTacVien.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!congTacVienModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				congTacVien.setModifiedDate(now);
			}
			else {
				congTacVien.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (congTacVien.isNew()) {
				session.save(congTacVien);

				congTacVien.setNew(false);
			}
			else {
				congTacVien = (CongTacVien)session.merge(congTacVien);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!CongTacVienModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				congTacVienModelImpl.getChiNhanhId(),
				congTacVienModelImpl.getHoatDong()
			};

			finderCache.removeResult(_finderPathCountByChiNhanh_HoatDong, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByChiNhanh_HoatDong, args);

			args = new Object[] {congTacVienModelImpl.getChiNhanhId()};

			finderCache.removeResult(_finderPathCountByChiNhanh, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByChiNhanh, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((congTacVienModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByChiNhanh_HoatDong.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					congTacVienModelImpl.getOriginalChiNhanhId(),
					congTacVienModelImpl.getOriginalHoatDong()
				};

				finderCache.removeResult(
					_finderPathCountByChiNhanh_HoatDong, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByChiNhanh_HoatDong, args);

				args = new Object[] {
					congTacVienModelImpl.getChiNhanhId(),
					congTacVienModelImpl.getHoatDong()
				};

				finderCache.removeResult(
					_finderPathCountByChiNhanh_HoatDong, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByChiNhanh_HoatDong, args);
			}

			if ((congTacVienModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByChiNhanh.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					congTacVienModelImpl.getOriginalChiNhanhId()
				};

				finderCache.removeResult(_finderPathCountByChiNhanh, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByChiNhanh, args);

				args = new Object[] {congTacVienModelImpl.getChiNhanhId()};

				finderCache.removeResult(_finderPathCountByChiNhanh, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByChiNhanh, args);
			}
		}

		entityCache.putResult(
			CongTacVienModelImpl.ENTITY_CACHE_ENABLED, CongTacVienImpl.class,
			congTacVien.getPrimaryKey(), congTacVien, false);

		clearUniqueFindersCache(congTacVienModelImpl, false);
		cacheUniqueFindersCache(congTacVienModelImpl);

		congTacVien.resetOriginalValues();

		return congTacVien;
	}

	/**
	 * Returns the cong tac vien with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cong tac vien
	 * @return the cong tac vien
	 * @throws NoSuchCongTacVienException if a cong tac vien with the primary key could not be found
	 */
	@Override
	public CongTacVien findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCongTacVienException {

		CongTacVien congTacVien = fetchByPrimaryKey(primaryKey);

		if (congTacVien == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCongTacVienException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return congTacVien;
	}

	/**
	 * Returns the cong tac vien with the primary key or throws a <code>NoSuchCongTacVienException</code> if it could not be found.
	 *
	 * @param congTacVienId the primary key of the cong tac vien
	 * @return the cong tac vien
	 * @throws NoSuchCongTacVienException if a cong tac vien with the primary key could not be found
	 */
	@Override
	public CongTacVien findByPrimaryKey(long congTacVienId)
		throws NoSuchCongTacVienException {

		return findByPrimaryKey((Serializable)congTacVienId);
	}

	/**
	 * Returns the cong tac vien with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cong tac vien
	 * @return the cong tac vien, or <code>null</code> if a cong tac vien with the primary key could not be found
	 */
	@Override
	public CongTacVien fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			CongTacVienModelImpl.ENTITY_CACHE_ENABLED, CongTacVienImpl.class,
			primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		CongTacVien congTacVien = (CongTacVien)serializable;

		if (congTacVien == null) {
			Session session = null;

			try {
				session = openSession();

				congTacVien = (CongTacVien)session.get(
					CongTacVienImpl.class, primaryKey);

				if (congTacVien != null) {
					cacheResult(congTacVien);
				}
				else {
					entityCache.putResult(
						CongTacVienModelImpl.ENTITY_CACHE_ENABLED,
						CongTacVienImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					CongTacVienModelImpl.ENTITY_CACHE_ENABLED,
					CongTacVienImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return congTacVien;
	}

	/**
	 * Returns the cong tac vien with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param congTacVienId the primary key of the cong tac vien
	 * @return the cong tac vien, or <code>null</code> if a cong tac vien with the primary key could not be found
	 */
	@Override
	public CongTacVien fetchByPrimaryKey(long congTacVienId) {
		return fetchByPrimaryKey((Serializable)congTacVienId);
	}

	@Override
	public Map<Serializable, CongTacVien> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, CongTacVien> map =
			new HashMap<Serializable, CongTacVien>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			CongTacVien congTacVien = fetchByPrimaryKey(primaryKey);

			if (congTacVien != null) {
				map.put(primaryKey, congTacVien);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				CongTacVienModelImpl.ENTITY_CACHE_ENABLED,
				CongTacVienImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (CongTacVien)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_CONGTACVIEN_WHERE_PKS_IN);

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

			for (CongTacVien congTacVien : (List<CongTacVien>)q.list()) {
				map.put(congTacVien.getPrimaryKeyObj(), congTacVien);

				cacheResult(congTacVien);

				uncachedPrimaryKeys.remove(congTacVien.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					CongTacVienModelImpl.ENTITY_CACHE_ENABLED,
					CongTacVienImpl.class, primaryKey, nullModel);
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
	 * Returns all the cong tac viens.
	 *
	 * @return the cong tac viens
	 */
	@Override
	public List<CongTacVien> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cong tac viens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CongTacVienModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cong tac viens
	 * @param end the upper bound of the range of cong tac viens (not inclusive)
	 * @return the range of cong tac viens
	 */
	@Override
	public List<CongTacVien> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the cong tac viens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CongTacVienModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cong tac viens
	 * @param end the upper bound of the range of cong tac viens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cong tac viens
	 */
	@Override
	public List<CongTacVien> findAll(
		int start, int end, OrderByComparator<CongTacVien> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cong tac viens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CongTacVienModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cong tac viens
	 * @param end the upper bound of the range of cong tac viens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of cong tac viens
	 */
	@Override
	public List<CongTacVien> findAll(
		int start, int end, OrderByComparator<CongTacVien> orderByComparator,
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

		List<CongTacVien> list = null;

		if (retrieveFromCache) {
			list = (List<CongTacVien>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CONGTACVIEN);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CONGTACVIEN;

				if (pagination) {
					sql = sql.concat(CongTacVienModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CongTacVien>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CongTacVien>)QueryUtil.list(
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
	 * Removes all the cong tac viens from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CongTacVien congTacVien : findAll()) {
			remove(congTacVien);
		}
	}

	/**
	 * Returns the number of cong tac viens.
	 *
	 * @return the number of cong tac viens
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CONGTACVIEN);

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
		return CongTacVienModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the cong tac vien persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			CongTacVienModelImpl.ENTITY_CACHE_ENABLED,
			CongTacVienModelImpl.FINDER_CACHE_ENABLED, CongTacVienImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			CongTacVienModelImpl.ENTITY_CACHE_ENABLED,
			CongTacVienModelImpl.FINDER_CACHE_ENABLED, CongTacVienImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			CongTacVienModelImpl.ENTITY_CACHE_ENABLED,
			CongTacVienModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByMa = new FinderPath(
			CongTacVienModelImpl.ENTITY_CACHE_ENABLED,
			CongTacVienModelImpl.FINDER_CACHE_ENABLED, CongTacVienImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByMa",
			new String[] {String.class.getName()},
			CongTacVienModelImpl.MA_COLUMN_BITMASK);

		_finderPathCountByMa = new FinderPath(
			CongTacVienModelImpl.ENTITY_CACHE_ENABLED,
			CongTacVienModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMa",
			new String[] {String.class.getName()});

		_finderPathFetchBySoCMND = new FinderPath(
			CongTacVienModelImpl.ENTITY_CACHE_ENABLED,
			CongTacVienModelImpl.FINDER_CACHE_ENABLED, CongTacVienImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBySoCMND",
			new String[] {String.class.getName()},
			CongTacVienModelImpl.SOCMND_COLUMN_BITMASK);

		_finderPathCountBySoCMND = new FinderPath(
			CongTacVienModelImpl.ENTITY_CACHE_ENABLED,
			CongTacVienModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySoCMND",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByChiNhanh_HoatDong = new FinderPath(
			CongTacVienModelImpl.ENTITY_CACHE_ENABLED,
			CongTacVienModelImpl.FINDER_CACHE_ENABLED, CongTacVienImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByChiNhanh_HoatDong",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByChiNhanh_HoatDong = new FinderPath(
			CongTacVienModelImpl.ENTITY_CACHE_ENABLED,
			CongTacVienModelImpl.FINDER_CACHE_ENABLED, CongTacVienImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByChiNhanh_HoatDong",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			CongTacVienModelImpl.CHINHANHID_COLUMN_BITMASK |
			CongTacVienModelImpl.HOATDONG_COLUMN_BITMASK |
			CongTacVienModelImpl.MA_COLUMN_BITMASK);

		_finderPathCountByChiNhanh_HoatDong = new FinderPath(
			CongTacVienModelImpl.ENTITY_CACHE_ENABLED,
			CongTacVienModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByChiNhanh_HoatDong",
			new String[] {Long.class.getName(), Boolean.class.getName()});

		_finderPathWithPaginationFindByChiNhanh = new FinderPath(
			CongTacVienModelImpl.ENTITY_CACHE_ENABLED,
			CongTacVienModelImpl.FINDER_CACHE_ENABLED, CongTacVienImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByChiNhanh",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByChiNhanh = new FinderPath(
			CongTacVienModelImpl.ENTITY_CACHE_ENABLED,
			CongTacVienModelImpl.FINDER_CACHE_ENABLED, CongTacVienImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByChiNhanh",
			new String[] {Long.class.getName()},
			CongTacVienModelImpl.CHINHANHID_COLUMN_BITMASK |
			CongTacVienModelImpl.MA_COLUMN_BITMASK);

		_finderPathCountByChiNhanh = new FinderPath(
			CongTacVienModelImpl.ENTITY_CACHE_ENABLED,
			CongTacVienModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByChiNhanh",
			new String[] {Long.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(CongTacVienImpl.class.getName());
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

	private static final String _SQL_SELECT_CONGTACVIEN =
		"SELECT congTacVien FROM CongTacVien congTacVien";

	private static final String _SQL_SELECT_CONGTACVIEN_WHERE_PKS_IN =
		"SELECT congTacVien FROM CongTacVien congTacVien WHERE congTacVienId IN (";

	private static final String _SQL_SELECT_CONGTACVIEN_WHERE =
		"SELECT congTacVien FROM CongTacVien congTacVien WHERE ";

	private static final String _SQL_COUNT_CONGTACVIEN =
		"SELECT COUNT(congTacVien) FROM CongTacVien congTacVien";

	private static final String _SQL_COUNT_CONGTACVIEN_WHERE =
		"SELECT COUNT(congTacVien) FROM CongTacVien congTacVien WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "congTacVien.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CongTacVien exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CongTacVien exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CongTacVienPersistenceImpl.class);

}