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

import com.mb.exception.NoSuchLoaiTaiSanException;
import com.mb.model.LoaiTaiSan;
import com.mb.model.impl.LoaiTaiSanImpl;
import com.mb.model.impl.LoaiTaiSanModelImpl;
import com.mb.service.persistence.LoaiTaiSanPersistence;

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
 * The persistence implementation for the loai tai san service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class LoaiTaiSanPersistenceImpl
	extends BasePersistenceImpl<LoaiTaiSan> implements LoaiTaiSanPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LoaiTaiSanUtil</code> to access the loai tai san persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LoaiTaiSanImpl.class.getName();

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
	 * Returns the loai tai san where ma = &#63; or throws a <code>NoSuchLoaiTaiSanException</code> if it could not be found.
	 *
	 * @param ma the ma
	 * @return the matching loai tai san
	 * @throws NoSuchLoaiTaiSanException if a matching loai tai san could not be found
	 */
	@Override
	public LoaiTaiSan findByMa(String ma) throws NoSuchLoaiTaiSanException {
		LoaiTaiSan loaiTaiSan = fetchByMa(ma);

		if (loaiTaiSan == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ma=");
			msg.append(ma);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchLoaiTaiSanException(msg.toString());
		}

		return loaiTaiSan;
	}

	/**
	 * Returns the loai tai san where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ma the ma
	 * @return the matching loai tai san, or <code>null</code> if a matching loai tai san could not be found
	 */
	@Override
	public LoaiTaiSan fetchByMa(String ma) {
		return fetchByMa(ma, true);
	}

	/**
	 * Returns the loai tai san where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ma the ma
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching loai tai san, or <code>null</code> if a matching loai tai san could not be found
	 */
	@Override
	public LoaiTaiSan fetchByMa(String ma, boolean retrieveFromCache) {
		ma = Objects.toString(ma, "");

		Object[] finderArgs = new Object[] {ma};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByMa, finderArgs, this);
		}

		if (result instanceof LoaiTaiSan) {
			LoaiTaiSan loaiTaiSan = (LoaiTaiSan)result;

			if (!Objects.equals(ma, loaiTaiSan.getMa())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_LOAITAISAN_WHERE);

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

				List<LoaiTaiSan> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByMa, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"LoaiTaiSanPersistenceImpl.fetchByMa(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					LoaiTaiSan loaiTaiSan = list.get(0);

					result = loaiTaiSan;

					cacheResult(loaiTaiSan);
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
			return (LoaiTaiSan)result;
		}
	}

	/**
	 * Removes the loai tai san where ma = &#63; from the database.
	 *
	 * @param ma the ma
	 * @return the loai tai san that was removed
	 */
	@Override
	public LoaiTaiSan removeByMa(String ma) throws NoSuchLoaiTaiSanException {
		LoaiTaiSan loaiTaiSan = findByMa(ma);

		return remove(loaiTaiSan);
	}

	/**
	 * Returns the number of loai tai sans where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the number of matching loai tai sans
	 */
	@Override
	public int countByMa(String ma) {
		ma = Objects.toString(ma, "");

		FinderPath finderPath = _finderPathCountByMa;

		Object[] finderArgs = new Object[] {ma};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LOAITAISAN_WHERE);

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

	private static final String _FINDER_COLUMN_MA_MA_2 = "loaiTaiSan.ma = ?";

	private static final String _FINDER_COLUMN_MA_MA_3 =
		"(loaiTaiSan.ma IS NULL OR loaiTaiSan.ma = '')";

	public LoaiTaiSanPersistenceImpl() {
		setModelClass(LoaiTaiSan.class);
	}

	/**
	 * Caches the loai tai san in the entity cache if it is enabled.
	 *
	 * @param loaiTaiSan the loai tai san
	 */
	@Override
	public void cacheResult(LoaiTaiSan loaiTaiSan) {
		entityCache.putResult(
			LoaiTaiSanModelImpl.ENTITY_CACHE_ENABLED, LoaiTaiSanImpl.class,
			loaiTaiSan.getPrimaryKey(), loaiTaiSan);

		finderCache.putResult(
			_finderPathFetchByMa, new Object[] {loaiTaiSan.getMa()},
			loaiTaiSan);

		loaiTaiSan.resetOriginalValues();
	}

	/**
	 * Caches the loai tai sans in the entity cache if it is enabled.
	 *
	 * @param loaiTaiSans the loai tai sans
	 */
	@Override
	public void cacheResult(List<LoaiTaiSan> loaiTaiSans) {
		for (LoaiTaiSan loaiTaiSan : loaiTaiSans) {
			if (entityCache.getResult(
					LoaiTaiSanModelImpl.ENTITY_CACHE_ENABLED,
					LoaiTaiSanImpl.class, loaiTaiSan.getPrimaryKey()) == null) {

				cacheResult(loaiTaiSan);
			}
			else {
				loaiTaiSan.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all loai tai sans.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LoaiTaiSanImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the loai tai san.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LoaiTaiSan loaiTaiSan) {
		entityCache.removeResult(
			LoaiTaiSanModelImpl.ENTITY_CACHE_ENABLED, LoaiTaiSanImpl.class,
			loaiTaiSan.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((LoaiTaiSanModelImpl)loaiTaiSan, true);
	}

	@Override
	public void clearCache(List<LoaiTaiSan> loaiTaiSans) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LoaiTaiSan loaiTaiSan : loaiTaiSans) {
			entityCache.removeResult(
				LoaiTaiSanModelImpl.ENTITY_CACHE_ENABLED, LoaiTaiSanImpl.class,
				loaiTaiSan.getPrimaryKey());

			clearUniqueFindersCache((LoaiTaiSanModelImpl)loaiTaiSan, true);
		}
	}

	protected void cacheUniqueFindersCache(
		LoaiTaiSanModelImpl loaiTaiSanModelImpl) {

		Object[] args = new Object[] {loaiTaiSanModelImpl.getMa()};

		finderCache.putResult(
			_finderPathCountByMa, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByMa, args, loaiTaiSanModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		LoaiTaiSanModelImpl loaiTaiSanModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {loaiTaiSanModelImpl.getMa()};

			finderCache.removeResult(_finderPathCountByMa, args);
			finderCache.removeResult(_finderPathFetchByMa, args);
		}

		if ((loaiTaiSanModelImpl.getColumnBitmask() &
			 _finderPathFetchByMa.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {loaiTaiSanModelImpl.getOriginalMa()};

			finderCache.removeResult(_finderPathCountByMa, args);
			finderCache.removeResult(_finderPathFetchByMa, args);
		}
	}

	/**
	 * Creates a new loai tai san with the primary key. Does not add the loai tai san to the database.
	 *
	 * @param loaiTaiSanId the primary key for the new loai tai san
	 * @return the new loai tai san
	 */
	@Override
	public LoaiTaiSan create(long loaiTaiSanId) {
		LoaiTaiSan loaiTaiSan = new LoaiTaiSanImpl();

		loaiTaiSan.setNew(true);
		loaiTaiSan.setPrimaryKey(loaiTaiSanId);

		loaiTaiSan.setCompanyId(companyProvider.getCompanyId());

		return loaiTaiSan;
	}

	/**
	 * Removes the loai tai san with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param loaiTaiSanId the primary key of the loai tai san
	 * @return the loai tai san that was removed
	 * @throws NoSuchLoaiTaiSanException if a loai tai san with the primary key could not be found
	 */
	@Override
	public LoaiTaiSan remove(long loaiTaiSanId)
		throws NoSuchLoaiTaiSanException {

		return remove((Serializable)loaiTaiSanId);
	}

	/**
	 * Removes the loai tai san with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the loai tai san
	 * @return the loai tai san that was removed
	 * @throws NoSuchLoaiTaiSanException if a loai tai san with the primary key could not be found
	 */
	@Override
	public LoaiTaiSan remove(Serializable primaryKey)
		throws NoSuchLoaiTaiSanException {

		Session session = null;

		try {
			session = openSession();

			LoaiTaiSan loaiTaiSan = (LoaiTaiSan)session.get(
				LoaiTaiSanImpl.class, primaryKey);

			if (loaiTaiSan == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLoaiTaiSanException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(loaiTaiSan);
		}
		catch (NoSuchLoaiTaiSanException nsee) {
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
	protected LoaiTaiSan removeImpl(LoaiTaiSan loaiTaiSan) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(loaiTaiSan)) {
				loaiTaiSan = (LoaiTaiSan)session.get(
					LoaiTaiSanImpl.class, loaiTaiSan.getPrimaryKeyObj());
			}

			if (loaiTaiSan != null) {
				session.delete(loaiTaiSan);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (loaiTaiSan != null) {
			clearCache(loaiTaiSan);
		}

		return loaiTaiSan;
	}

	@Override
	public LoaiTaiSan updateImpl(LoaiTaiSan loaiTaiSan) {
		boolean isNew = loaiTaiSan.isNew();

		if (!(loaiTaiSan instanceof LoaiTaiSanModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(loaiTaiSan.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(loaiTaiSan);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in loaiTaiSan proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LoaiTaiSan implementation " +
					loaiTaiSan.getClass());
		}

		LoaiTaiSanModelImpl loaiTaiSanModelImpl =
			(LoaiTaiSanModelImpl)loaiTaiSan;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (loaiTaiSan.getCreateDate() == null)) {
			if (serviceContext == null) {
				loaiTaiSan.setCreateDate(now);
			}
			else {
				loaiTaiSan.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!loaiTaiSanModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				loaiTaiSan.setModifiedDate(now);
			}
			else {
				loaiTaiSan.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (loaiTaiSan.isNew()) {
				session.save(loaiTaiSan);

				loaiTaiSan.setNew(false);
			}
			else {
				loaiTaiSan = (LoaiTaiSan)session.merge(loaiTaiSan);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!LoaiTaiSanModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			LoaiTaiSanModelImpl.ENTITY_CACHE_ENABLED, LoaiTaiSanImpl.class,
			loaiTaiSan.getPrimaryKey(), loaiTaiSan, false);

		clearUniqueFindersCache(loaiTaiSanModelImpl, false);
		cacheUniqueFindersCache(loaiTaiSanModelImpl);

		loaiTaiSan.resetOriginalValues();

		return loaiTaiSan;
	}

	/**
	 * Returns the loai tai san with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the loai tai san
	 * @return the loai tai san
	 * @throws NoSuchLoaiTaiSanException if a loai tai san with the primary key could not be found
	 */
	@Override
	public LoaiTaiSan findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLoaiTaiSanException {

		LoaiTaiSan loaiTaiSan = fetchByPrimaryKey(primaryKey);

		if (loaiTaiSan == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLoaiTaiSanException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return loaiTaiSan;
	}

	/**
	 * Returns the loai tai san with the primary key or throws a <code>NoSuchLoaiTaiSanException</code> if it could not be found.
	 *
	 * @param loaiTaiSanId the primary key of the loai tai san
	 * @return the loai tai san
	 * @throws NoSuchLoaiTaiSanException if a loai tai san with the primary key could not be found
	 */
	@Override
	public LoaiTaiSan findByPrimaryKey(long loaiTaiSanId)
		throws NoSuchLoaiTaiSanException {

		return findByPrimaryKey((Serializable)loaiTaiSanId);
	}

	/**
	 * Returns the loai tai san with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the loai tai san
	 * @return the loai tai san, or <code>null</code> if a loai tai san with the primary key could not be found
	 */
	@Override
	public LoaiTaiSan fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			LoaiTaiSanModelImpl.ENTITY_CACHE_ENABLED, LoaiTaiSanImpl.class,
			primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		LoaiTaiSan loaiTaiSan = (LoaiTaiSan)serializable;

		if (loaiTaiSan == null) {
			Session session = null;

			try {
				session = openSession();

				loaiTaiSan = (LoaiTaiSan)session.get(
					LoaiTaiSanImpl.class, primaryKey);

				if (loaiTaiSan != null) {
					cacheResult(loaiTaiSan);
				}
				else {
					entityCache.putResult(
						LoaiTaiSanModelImpl.ENTITY_CACHE_ENABLED,
						LoaiTaiSanImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					LoaiTaiSanModelImpl.ENTITY_CACHE_ENABLED,
					LoaiTaiSanImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return loaiTaiSan;
	}

	/**
	 * Returns the loai tai san with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param loaiTaiSanId the primary key of the loai tai san
	 * @return the loai tai san, or <code>null</code> if a loai tai san with the primary key could not be found
	 */
	@Override
	public LoaiTaiSan fetchByPrimaryKey(long loaiTaiSanId) {
		return fetchByPrimaryKey((Serializable)loaiTaiSanId);
	}

	@Override
	public Map<Serializable, LoaiTaiSan> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, LoaiTaiSan> map =
			new HashMap<Serializable, LoaiTaiSan>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			LoaiTaiSan loaiTaiSan = fetchByPrimaryKey(primaryKey);

			if (loaiTaiSan != null) {
				map.put(primaryKey, loaiTaiSan);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				LoaiTaiSanModelImpl.ENTITY_CACHE_ENABLED, LoaiTaiSanImpl.class,
				primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (LoaiTaiSan)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_LOAITAISAN_WHERE_PKS_IN);

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

			for (LoaiTaiSan loaiTaiSan : (List<LoaiTaiSan>)q.list()) {
				map.put(loaiTaiSan.getPrimaryKeyObj(), loaiTaiSan);

				cacheResult(loaiTaiSan);

				uncachedPrimaryKeys.remove(loaiTaiSan.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					LoaiTaiSanModelImpl.ENTITY_CACHE_ENABLED,
					LoaiTaiSanImpl.class, primaryKey, nullModel);
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
	 * Returns all the loai tai sans.
	 *
	 * @return the loai tai sans
	 */
	@Override
	public List<LoaiTaiSan> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the loai tai sans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LoaiTaiSanModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of loai tai sans
	 * @param end the upper bound of the range of loai tai sans (not inclusive)
	 * @return the range of loai tai sans
	 */
	@Override
	public List<LoaiTaiSan> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the loai tai sans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LoaiTaiSanModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of loai tai sans
	 * @param end the upper bound of the range of loai tai sans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of loai tai sans
	 */
	@Override
	public List<LoaiTaiSan> findAll(
		int start, int end, OrderByComparator<LoaiTaiSan> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the loai tai sans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LoaiTaiSanModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of loai tai sans
	 * @param end the upper bound of the range of loai tai sans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of loai tai sans
	 */
	@Override
	public List<LoaiTaiSan> findAll(
		int start, int end, OrderByComparator<LoaiTaiSan> orderByComparator,
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

		List<LoaiTaiSan> list = null;

		if (retrieveFromCache) {
			list = (List<LoaiTaiSan>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LOAITAISAN);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LOAITAISAN;

				if (pagination) {
					sql = sql.concat(LoaiTaiSanModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LoaiTaiSan>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<LoaiTaiSan>)QueryUtil.list(
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
	 * Removes all the loai tai sans from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LoaiTaiSan loaiTaiSan : findAll()) {
			remove(loaiTaiSan);
		}
	}

	/**
	 * Returns the number of loai tai sans.
	 *
	 * @return the number of loai tai sans
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LOAITAISAN);

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
		return LoaiTaiSanModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the loai tai san persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			LoaiTaiSanModelImpl.ENTITY_CACHE_ENABLED,
			LoaiTaiSanModelImpl.FINDER_CACHE_ENABLED, LoaiTaiSanImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			LoaiTaiSanModelImpl.ENTITY_CACHE_ENABLED,
			LoaiTaiSanModelImpl.FINDER_CACHE_ENABLED, LoaiTaiSanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			LoaiTaiSanModelImpl.ENTITY_CACHE_ENABLED,
			LoaiTaiSanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByMa = new FinderPath(
			LoaiTaiSanModelImpl.ENTITY_CACHE_ENABLED,
			LoaiTaiSanModelImpl.FINDER_CACHE_ENABLED, LoaiTaiSanImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByMa",
			new String[] {String.class.getName()},
			LoaiTaiSanModelImpl.MA_COLUMN_BITMASK);

		_finderPathCountByMa = new FinderPath(
			LoaiTaiSanModelImpl.ENTITY_CACHE_ENABLED,
			LoaiTaiSanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMa",
			new String[] {String.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(LoaiTaiSanImpl.class.getName());
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

	private static final String _SQL_SELECT_LOAITAISAN =
		"SELECT loaiTaiSan FROM LoaiTaiSan loaiTaiSan";

	private static final String _SQL_SELECT_LOAITAISAN_WHERE_PKS_IN =
		"SELECT loaiTaiSan FROM LoaiTaiSan loaiTaiSan WHERE loaiTaiSanId IN (";

	private static final String _SQL_SELECT_LOAITAISAN_WHERE =
		"SELECT loaiTaiSan FROM LoaiTaiSan loaiTaiSan WHERE ";

	private static final String _SQL_COUNT_LOAITAISAN =
		"SELECT COUNT(loaiTaiSan) FROM LoaiTaiSan loaiTaiSan";

	private static final String _SQL_COUNT_LOAITAISAN_WHERE =
		"SELECT COUNT(loaiTaiSan) FROM LoaiTaiSan loaiTaiSan WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "loaiTaiSan.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No LoaiTaiSan exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No LoaiTaiSan exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LoaiTaiSanPersistenceImpl.class);

}