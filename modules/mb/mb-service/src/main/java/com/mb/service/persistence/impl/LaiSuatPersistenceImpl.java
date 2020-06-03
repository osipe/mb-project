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

import com.mb.exception.NoSuchLaiSuatException;
import com.mb.model.LaiSuat;
import com.mb.model.impl.LaiSuatImpl;
import com.mb.model.impl.LaiSuatModelImpl;
import com.mb.service.persistence.LaiSuatPersistence;

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
 * The persistence implementation for the lai suat service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class LaiSuatPersistenceImpl
	extends BasePersistenceImpl<LaiSuat> implements LaiSuatPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LaiSuatUtil</code> to access the lai suat persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LaiSuatImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchBySoTienVay_ThoiHan;
	private FinderPath _finderPathCountBySoTienVay_ThoiHan;

	/**
	 * Returns the lai suat where soTienVay = &#63; and thoiHan = &#63; or throws a <code>NoSuchLaiSuatException</code> if it could not be found.
	 *
	 * @param soTienVay the so tien vay
	 * @param thoiHan the thoi han
	 * @return the matching lai suat
	 * @throws NoSuchLaiSuatException if a matching lai suat could not be found
	 */
	@Override
	public LaiSuat findBySoTienVay_ThoiHan(Double soTienVay, int thoiHan)
		throws NoSuchLaiSuatException {

		LaiSuat laiSuat = fetchBySoTienVay_ThoiHan(soTienVay, thoiHan);

		if (laiSuat == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("soTienVay=");
			msg.append(soTienVay);

			msg.append(", thoiHan=");
			msg.append(thoiHan);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchLaiSuatException(msg.toString());
		}

		return laiSuat;
	}

	/**
	 * Returns the lai suat where soTienVay = &#63; and thoiHan = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param soTienVay the so tien vay
	 * @param thoiHan the thoi han
	 * @return the matching lai suat, or <code>null</code> if a matching lai suat could not be found
	 */
	@Override
	public LaiSuat fetchBySoTienVay_ThoiHan(Double soTienVay, int thoiHan) {
		return fetchBySoTienVay_ThoiHan(soTienVay, thoiHan, true);
	}

	/**
	 * Returns the lai suat where soTienVay = &#63; and thoiHan = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param soTienVay the so tien vay
	 * @param thoiHan the thoi han
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching lai suat, or <code>null</code> if a matching lai suat could not be found
	 */
	@Override
	public LaiSuat fetchBySoTienVay_ThoiHan(
		Double soTienVay, int thoiHan, boolean retrieveFromCache) {

		Object[] finderArgs = new Object[] {soTienVay, thoiHan};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchBySoTienVay_ThoiHan, finderArgs, this);
		}

		if (result instanceof LaiSuat) {
			LaiSuat laiSuat = (LaiSuat)result;

			if (!Objects.equals(soTienVay, laiSuat.getSoTienVay()) ||
				(thoiHan != laiSuat.getThoiHan())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_LAISUAT_WHERE);

			query.append(_FINDER_COLUMN_SOTIENVAY_THOIHAN_SOTIENVAY_2);

			query.append(_FINDER_COLUMN_SOTIENVAY_THOIHAN_THOIHAN_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(soTienVay.doubleValue());

				qPos.add(thoiHan);

				List<LaiSuat> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchBySoTienVay_ThoiHan, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"LaiSuatPersistenceImpl.fetchBySoTienVay_ThoiHan(Double, int, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					LaiSuat laiSuat = list.get(0);

					result = laiSuat;

					cacheResult(laiSuat);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathFetchBySoTienVay_ThoiHan, finderArgs);

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
			return (LaiSuat)result;
		}
	}

	/**
	 * Removes the lai suat where soTienVay = &#63; and thoiHan = &#63; from the database.
	 *
	 * @param soTienVay the so tien vay
	 * @param thoiHan the thoi han
	 * @return the lai suat that was removed
	 */
	@Override
	public LaiSuat removeBySoTienVay_ThoiHan(Double soTienVay, int thoiHan)
		throws NoSuchLaiSuatException {

		LaiSuat laiSuat = findBySoTienVay_ThoiHan(soTienVay, thoiHan);

		return remove(laiSuat);
	}

	/**
	 * Returns the number of lai suats where soTienVay = &#63; and thoiHan = &#63;.
	 *
	 * @param soTienVay the so tien vay
	 * @param thoiHan the thoi han
	 * @return the number of matching lai suats
	 */
	@Override
	public int countBySoTienVay_ThoiHan(Double soTienVay, int thoiHan) {
		FinderPath finderPath = _finderPathCountBySoTienVay_ThoiHan;

		Object[] finderArgs = new Object[] {soTienVay, thoiHan};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LAISUAT_WHERE);

			query.append(_FINDER_COLUMN_SOTIENVAY_THOIHAN_SOTIENVAY_2);

			query.append(_FINDER_COLUMN_SOTIENVAY_THOIHAN_THOIHAN_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(soTienVay.doubleValue());

				qPos.add(thoiHan);

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

	private static final String _FINDER_COLUMN_SOTIENVAY_THOIHAN_SOTIENVAY_2 =
		"laiSuat.soTienVay = ? AND ";

	private static final String _FINDER_COLUMN_SOTIENVAY_THOIHAN_THOIHAN_2 =
		"laiSuat.thoiHan = ?";

	public LaiSuatPersistenceImpl() {
		setModelClass(LaiSuat.class);
	}

	/**
	 * Caches the lai suat in the entity cache if it is enabled.
	 *
	 * @param laiSuat the lai suat
	 */
	@Override
	public void cacheResult(LaiSuat laiSuat) {
		entityCache.putResult(
			LaiSuatModelImpl.ENTITY_CACHE_ENABLED, LaiSuatImpl.class,
			laiSuat.getPrimaryKey(), laiSuat);

		finderCache.putResult(
			_finderPathFetchBySoTienVay_ThoiHan,
			new Object[] {laiSuat.getSoTienVay(), laiSuat.getThoiHan()},
			laiSuat);

		laiSuat.resetOriginalValues();
	}

	/**
	 * Caches the lai suats in the entity cache if it is enabled.
	 *
	 * @param laiSuats the lai suats
	 */
	@Override
	public void cacheResult(List<LaiSuat> laiSuats) {
		for (LaiSuat laiSuat : laiSuats) {
			if (entityCache.getResult(
					LaiSuatModelImpl.ENTITY_CACHE_ENABLED, LaiSuatImpl.class,
					laiSuat.getPrimaryKey()) == null) {

				cacheResult(laiSuat);
			}
			else {
				laiSuat.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all lai suats.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LaiSuatImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the lai suat.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LaiSuat laiSuat) {
		entityCache.removeResult(
			LaiSuatModelImpl.ENTITY_CACHE_ENABLED, LaiSuatImpl.class,
			laiSuat.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((LaiSuatModelImpl)laiSuat, true);
	}

	@Override
	public void clearCache(List<LaiSuat> laiSuats) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LaiSuat laiSuat : laiSuats) {
			entityCache.removeResult(
				LaiSuatModelImpl.ENTITY_CACHE_ENABLED, LaiSuatImpl.class,
				laiSuat.getPrimaryKey());

			clearUniqueFindersCache((LaiSuatModelImpl)laiSuat, true);
		}
	}

	protected void cacheUniqueFindersCache(LaiSuatModelImpl laiSuatModelImpl) {
		Object[] args = new Object[] {
			laiSuatModelImpl.getSoTienVay(), laiSuatModelImpl.getThoiHan()
		};

		finderCache.putResult(
			_finderPathCountBySoTienVay_ThoiHan, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchBySoTienVay_ThoiHan, args, laiSuatModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		LaiSuatModelImpl laiSuatModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				laiSuatModelImpl.getSoTienVay(), laiSuatModelImpl.getThoiHan()
			};

			finderCache.removeResult(_finderPathCountBySoTienVay_ThoiHan, args);
			finderCache.removeResult(_finderPathFetchBySoTienVay_ThoiHan, args);
		}

		if ((laiSuatModelImpl.getColumnBitmask() &
			 _finderPathFetchBySoTienVay_ThoiHan.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				laiSuatModelImpl.getOriginalSoTienVay(),
				laiSuatModelImpl.getOriginalThoiHan()
			};

			finderCache.removeResult(_finderPathCountBySoTienVay_ThoiHan, args);
			finderCache.removeResult(_finderPathFetchBySoTienVay_ThoiHan, args);
		}
	}

	/**
	 * Creates a new lai suat with the primary key. Does not add the lai suat to the database.
	 *
	 * @param laiSuatId the primary key for the new lai suat
	 * @return the new lai suat
	 */
	@Override
	public LaiSuat create(long laiSuatId) {
		LaiSuat laiSuat = new LaiSuatImpl();

		laiSuat.setNew(true);
		laiSuat.setPrimaryKey(laiSuatId);

		laiSuat.setCompanyId(companyProvider.getCompanyId());

		return laiSuat;
	}

	/**
	 * Removes the lai suat with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param laiSuatId the primary key of the lai suat
	 * @return the lai suat that was removed
	 * @throws NoSuchLaiSuatException if a lai suat with the primary key could not be found
	 */
	@Override
	public LaiSuat remove(long laiSuatId) throws NoSuchLaiSuatException {
		return remove((Serializable)laiSuatId);
	}

	/**
	 * Removes the lai suat with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the lai suat
	 * @return the lai suat that was removed
	 * @throws NoSuchLaiSuatException if a lai suat with the primary key could not be found
	 */
	@Override
	public LaiSuat remove(Serializable primaryKey)
		throws NoSuchLaiSuatException {

		Session session = null;

		try {
			session = openSession();

			LaiSuat laiSuat = (LaiSuat)session.get(
				LaiSuatImpl.class, primaryKey);

			if (laiSuat == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLaiSuatException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(laiSuat);
		}
		catch (NoSuchLaiSuatException nsee) {
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
	protected LaiSuat removeImpl(LaiSuat laiSuat) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(laiSuat)) {
				laiSuat = (LaiSuat)session.get(
					LaiSuatImpl.class, laiSuat.getPrimaryKeyObj());
			}

			if (laiSuat != null) {
				session.delete(laiSuat);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (laiSuat != null) {
			clearCache(laiSuat);
		}

		return laiSuat;
	}

	@Override
	public LaiSuat updateImpl(LaiSuat laiSuat) {
		boolean isNew = laiSuat.isNew();

		if (!(laiSuat instanceof LaiSuatModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(laiSuat.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(laiSuat);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in laiSuat proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LaiSuat implementation " +
					laiSuat.getClass());
		}

		LaiSuatModelImpl laiSuatModelImpl = (LaiSuatModelImpl)laiSuat;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (laiSuat.getCreateDate() == null)) {
			if (serviceContext == null) {
				laiSuat.setCreateDate(now);
			}
			else {
				laiSuat.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!laiSuatModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				laiSuat.setModifiedDate(now);
			}
			else {
				laiSuat.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (laiSuat.isNew()) {
				session.save(laiSuat);

				laiSuat.setNew(false);
			}
			else {
				laiSuat = (LaiSuat)session.merge(laiSuat);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!LaiSuatModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			LaiSuatModelImpl.ENTITY_CACHE_ENABLED, LaiSuatImpl.class,
			laiSuat.getPrimaryKey(), laiSuat, false);

		clearUniqueFindersCache(laiSuatModelImpl, false);
		cacheUniqueFindersCache(laiSuatModelImpl);

		laiSuat.resetOriginalValues();

		return laiSuat;
	}

	/**
	 * Returns the lai suat with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the lai suat
	 * @return the lai suat
	 * @throws NoSuchLaiSuatException if a lai suat with the primary key could not be found
	 */
	@Override
	public LaiSuat findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLaiSuatException {

		LaiSuat laiSuat = fetchByPrimaryKey(primaryKey);

		if (laiSuat == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLaiSuatException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return laiSuat;
	}

	/**
	 * Returns the lai suat with the primary key or throws a <code>NoSuchLaiSuatException</code> if it could not be found.
	 *
	 * @param laiSuatId the primary key of the lai suat
	 * @return the lai suat
	 * @throws NoSuchLaiSuatException if a lai suat with the primary key could not be found
	 */
	@Override
	public LaiSuat findByPrimaryKey(long laiSuatId)
		throws NoSuchLaiSuatException {

		return findByPrimaryKey((Serializable)laiSuatId);
	}

	/**
	 * Returns the lai suat with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the lai suat
	 * @return the lai suat, or <code>null</code> if a lai suat with the primary key could not be found
	 */
	@Override
	public LaiSuat fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			LaiSuatModelImpl.ENTITY_CACHE_ENABLED, LaiSuatImpl.class,
			primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		LaiSuat laiSuat = (LaiSuat)serializable;

		if (laiSuat == null) {
			Session session = null;

			try {
				session = openSession();

				laiSuat = (LaiSuat)session.get(LaiSuatImpl.class, primaryKey);

				if (laiSuat != null) {
					cacheResult(laiSuat);
				}
				else {
					entityCache.putResult(
						LaiSuatModelImpl.ENTITY_CACHE_ENABLED,
						LaiSuatImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					LaiSuatModelImpl.ENTITY_CACHE_ENABLED, LaiSuatImpl.class,
					primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return laiSuat;
	}

	/**
	 * Returns the lai suat with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param laiSuatId the primary key of the lai suat
	 * @return the lai suat, or <code>null</code> if a lai suat with the primary key could not be found
	 */
	@Override
	public LaiSuat fetchByPrimaryKey(long laiSuatId) {
		return fetchByPrimaryKey((Serializable)laiSuatId);
	}

	@Override
	public Map<Serializable, LaiSuat> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, LaiSuat> map = new HashMap<Serializable, LaiSuat>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			LaiSuat laiSuat = fetchByPrimaryKey(primaryKey);

			if (laiSuat != null) {
				map.put(primaryKey, laiSuat);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				LaiSuatModelImpl.ENTITY_CACHE_ENABLED, LaiSuatImpl.class,
				primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (LaiSuat)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_LAISUAT_WHERE_PKS_IN);

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

			for (LaiSuat laiSuat : (List<LaiSuat>)q.list()) {
				map.put(laiSuat.getPrimaryKeyObj(), laiSuat);

				cacheResult(laiSuat);

				uncachedPrimaryKeys.remove(laiSuat.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					LaiSuatModelImpl.ENTITY_CACHE_ENABLED, LaiSuatImpl.class,
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
	 * Returns all the lai suats.
	 *
	 * @return the lai suats
	 */
	@Override
	public List<LaiSuat> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lai suats.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LaiSuatModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lai suats
	 * @param end the upper bound of the range of lai suats (not inclusive)
	 * @return the range of lai suats
	 */
	@Override
	public List<LaiSuat> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the lai suats.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LaiSuatModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lai suats
	 * @param end the upper bound of the range of lai suats (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lai suats
	 */
	@Override
	public List<LaiSuat> findAll(
		int start, int end, OrderByComparator<LaiSuat> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lai suats.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LaiSuatModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lai suats
	 * @param end the upper bound of the range of lai suats (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of lai suats
	 */
	@Override
	public List<LaiSuat> findAll(
		int start, int end, OrderByComparator<LaiSuat> orderByComparator,
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

		List<LaiSuat> list = null;

		if (retrieveFromCache) {
			list = (List<LaiSuat>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LAISUAT);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LAISUAT;

				if (pagination) {
					sql = sql.concat(LaiSuatModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LaiSuat>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<LaiSuat>)QueryUtil.list(
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
	 * Removes all the lai suats from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LaiSuat laiSuat : findAll()) {
			remove(laiSuat);
		}
	}

	/**
	 * Returns the number of lai suats.
	 *
	 * @return the number of lai suats
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LAISUAT);

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
		return LaiSuatModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the lai suat persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			LaiSuatModelImpl.ENTITY_CACHE_ENABLED,
			LaiSuatModelImpl.FINDER_CACHE_ENABLED, LaiSuatImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			LaiSuatModelImpl.ENTITY_CACHE_ENABLED,
			LaiSuatModelImpl.FINDER_CACHE_ENABLED, LaiSuatImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			LaiSuatModelImpl.ENTITY_CACHE_ENABLED,
			LaiSuatModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchBySoTienVay_ThoiHan = new FinderPath(
			LaiSuatModelImpl.ENTITY_CACHE_ENABLED,
			LaiSuatModelImpl.FINDER_CACHE_ENABLED, LaiSuatImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBySoTienVay_ThoiHan",
			new String[] {Double.class.getName(), Integer.class.getName()},
			LaiSuatModelImpl.SOTIENVAY_COLUMN_BITMASK |
			LaiSuatModelImpl.THOIHAN_COLUMN_BITMASK);

		_finderPathCountBySoTienVay_ThoiHan = new FinderPath(
			LaiSuatModelImpl.ENTITY_CACHE_ENABLED,
			LaiSuatModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySoTienVay_ThoiHan",
			new String[] {Double.class.getName(), Integer.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(LaiSuatImpl.class.getName());
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

	private static final String _SQL_SELECT_LAISUAT =
		"SELECT laiSuat FROM LaiSuat laiSuat";

	private static final String _SQL_SELECT_LAISUAT_WHERE_PKS_IN =
		"SELECT laiSuat FROM LaiSuat laiSuat WHERE laiSuatId IN (";

	private static final String _SQL_SELECT_LAISUAT_WHERE =
		"SELECT laiSuat FROM LaiSuat laiSuat WHERE ";

	private static final String _SQL_COUNT_LAISUAT =
		"SELECT COUNT(laiSuat) FROM LaiSuat laiSuat";

	private static final String _SQL_COUNT_LAISUAT_WHERE =
		"SELECT COUNT(laiSuat) FROM LaiSuat laiSuat WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "laiSuat.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No LaiSuat exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No LaiSuat exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LaiSuatPersistenceImpl.class);

}