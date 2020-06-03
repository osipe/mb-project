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
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.mb.exception.NoSuchSoKheUocException;
import com.mb.model.SoKheUoc;
import com.mb.model.impl.SoKheUocImpl;
import com.mb.model.impl.SoKheUocModelImpl;
import com.mb.service.persistence.SoKheUocPersistence;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the so khe uoc service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class SoKheUocPersistenceImpl
	extends BasePersistenceImpl<SoKheUoc> implements SoKheUocPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SoKheUocUtil</code> to access the so khe uoc persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SoKheUocImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByCauTruc;
	private FinderPath _finderPathCountByCauTruc;

	/**
	 * Returns the so khe uoc where cauTruc = &#63; or throws a <code>NoSuchSoKheUocException</code> if it could not be found.
	 *
	 * @param cauTruc the cau truc
	 * @return the matching so khe uoc
	 * @throws NoSuchSoKheUocException if a matching so khe uoc could not be found
	 */
	@Override
	public SoKheUoc findByCauTruc(String cauTruc)
		throws NoSuchSoKheUocException {

		SoKheUoc soKheUoc = fetchByCauTruc(cauTruc);

		if (soKheUoc == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("cauTruc=");
			msg.append(cauTruc);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchSoKheUocException(msg.toString());
		}

		return soKheUoc;
	}

	/**
	 * Returns the so khe uoc where cauTruc = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param cauTruc the cau truc
	 * @return the matching so khe uoc, or <code>null</code> if a matching so khe uoc could not be found
	 */
	@Override
	public SoKheUoc fetchByCauTruc(String cauTruc) {
		return fetchByCauTruc(cauTruc, true);
	}

	/**
	 * Returns the so khe uoc where cauTruc = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param cauTruc the cau truc
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching so khe uoc, or <code>null</code> if a matching so khe uoc could not be found
	 */
	@Override
	public SoKheUoc fetchByCauTruc(String cauTruc, boolean retrieveFromCache) {
		cauTruc = Objects.toString(cauTruc, "");

		Object[] finderArgs = new Object[] {cauTruc};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByCauTruc, finderArgs, this);
		}

		if (result instanceof SoKheUoc) {
			SoKheUoc soKheUoc = (SoKheUoc)result;

			if (!Objects.equals(cauTruc, soKheUoc.getCauTruc())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_SOKHEUOC_WHERE);

			boolean bindCauTruc = false;

			if (cauTruc.isEmpty()) {
				query.append(_FINDER_COLUMN_CAUTRUC_CAUTRUC_3);
			}
			else {
				bindCauTruc = true;

				query.append(_FINDER_COLUMN_CAUTRUC_CAUTRUC_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCauTruc) {
					qPos.add(cauTruc);
				}

				List<SoKheUoc> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByCauTruc, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"SoKheUocPersistenceImpl.fetchByCauTruc(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					SoKheUoc soKheUoc = list.get(0);

					result = soKheUoc;

					cacheResult(soKheUoc);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(_finderPathFetchByCauTruc, finderArgs);

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
			return (SoKheUoc)result;
		}
	}

	/**
	 * Removes the so khe uoc where cauTruc = &#63; from the database.
	 *
	 * @param cauTruc the cau truc
	 * @return the so khe uoc that was removed
	 */
	@Override
	public SoKheUoc removeByCauTruc(String cauTruc)
		throws NoSuchSoKheUocException {

		SoKheUoc soKheUoc = findByCauTruc(cauTruc);

		return remove(soKheUoc);
	}

	/**
	 * Returns the number of so khe uocs where cauTruc = &#63;.
	 *
	 * @param cauTruc the cau truc
	 * @return the number of matching so khe uocs
	 */
	@Override
	public int countByCauTruc(String cauTruc) {
		cauTruc = Objects.toString(cauTruc, "");

		FinderPath finderPath = _finderPathCountByCauTruc;

		Object[] finderArgs = new Object[] {cauTruc};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SOKHEUOC_WHERE);

			boolean bindCauTruc = false;

			if (cauTruc.isEmpty()) {
				query.append(_FINDER_COLUMN_CAUTRUC_CAUTRUC_3);
			}
			else {
				bindCauTruc = true;

				query.append(_FINDER_COLUMN_CAUTRUC_CAUTRUC_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCauTruc) {
					qPos.add(cauTruc);
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

	private static final String _FINDER_COLUMN_CAUTRUC_CAUTRUC_2 =
		"soKheUoc.cauTruc = ?";

	private static final String _FINDER_COLUMN_CAUTRUC_CAUTRUC_3 =
		"(soKheUoc.cauTruc IS NULL OR soKheUoc.cauTruc = '')";

	public SoKheUocPersistenceImpl() {
		setModelClass(SoKheUoc.class);
	}

	/**
	 * Caches the so khe uoc in the entity cache if it is enabled.
	 *
	 * @param soKheUoc the so khe uoc
	 */
	@Override
	public void cacheResult(SoKheUoc soKheUoc) {
		entityCache.putResult(
			SoKheUocModelImpl.ENTITY_CACHE_ENABLED, SoKheUocImpl.class,
			soKheUoc.getPrimaryKey(), soKheUoc);

		finderCache.putResult(
			_finderPathFetchByCauTruc, new Object[] {soKheUoc.getCauTruc()},
			soKheUoc);

		soKheUoc.resetOriginalValues();
	}

	/**
	 * Caches the so khe uocs in the entity cache if it is enabled.
	 *
	 * @param soKheUocs the so khe uocs
	 */
	@Override
	public void cacheResult(List<SoKheUoc> soKheUocs) {
		for (SoKheUoc soKheUoc : soKheUocs) {
			if (entityCache.getResult(
					SoKheUocModelImpl.ENTITY_CACHE_ENABLED, SoKheUocImpl.class,
					soKheUoc.getPrimaryKey()) == null) {

				cacheResult(soKheUoc);
			}
			else {
				soKheUoc.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all so khe uocs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SoKheUocImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the so khe uoc.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SoKheUoc soKheUoc) {
		entityCache.removeResult(
			SoKheUocModelImpl.ENTITY_CACHE_ENABLED, SoKheUocImpl.class,
			soKheUoc.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((SoKheUocModelImpl)soKheUoc, true);
	}

	@Override
	public void clearCache(List<SoKheUoc> soKheUocs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SoKheUoc soKheUoc : soKheUocs) {
			entityCache.removeResult(
				SoKheUocModelImpl.ENTITY_CACHE_ENABLED, SoKheUocImpl.class,
				soKheUoc.getPrimaryKey());

			clearUniqueFindersCache((SoKheUocModelImpl)soKheUoc, true);
		}
	}

	protected void cacheUniqueFindersCache(
		SoKheUocModelImpl soKheUocModelImpl) {

		Object[] args = new Object[] {soKheUocModelImpl.getCauTruc()};

		finderCache.putResult(
			_finderPathCountByCauTruc, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByCauTruc, args, soKheUocModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		SoKheUocModelImpl soKheUocModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {soKheUocModelImpl.getCauTruc()};

			finderCache.removeResult(_finderPathCountByCauTruc, args);
			finderCache.removeResult(_finderPathFetchByCauTruc, args);
		}

		if ((soKheUocModelImpl.getColumnBitmask() &
			 _finderPathFetchByCauTruc.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				soKheUocModelImpl.getOriginalCauTruc()
			};

			finderCache.removeResult(_finderPathCountByCauTruc, args);
			finderCache.removeResult(_finderPathFetchByCauTruc, args);
		}
	}

	/**
	 * Creates a new so khe uoc with the primary key. Does not add the so khe uoc to the database.
	 *
	 * @param soKheUocId the primary key for the new so khe uoc
	 * @return the new so khe uoc
	 */
	@Override
	public SoKheUoc create(long soKheUocId) {
		SoKheUoc soKheUoc = new SoKheUocImpl();

		soKheUoc.setNew(true);
		soKheUoc.setPrimaryKey(soKheUocId);

		return soKheUoc;
	}

	/**
	 * Removes the so khe uoc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param soKheUocId the primary key of the so khe uoc
	 * @return the so khe uoc that was removed
	 * @throws NoSuchSoKheUocException if a so khe uoc with the primary key could not be found
	 */
	@Override
	public SoKheUoc remove(long soKheUocId) throws NoSuchSoKheUocException {
		return remove((Serializable)soKheUocId);
	}

	/**
	 * Removes the so khe uoc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the so khe uoc
	 * @return the so khe uoc that was removed
	 * @throws NoSuchSoKheUocException if a so khe uoc with the primary key could not be found
	 */
	@Override
	public SoKheUoc remove(Serializable primaryKey)
		throws NoSuchSoKheUocException {

		Session session = null;

		try {
			session = openSession();

			SoKheUoc soKheUoc = (SoKheUoc)session.get(
				SoKheUocImpl.class, primaryKey);

			if (soKheUoc == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSoKheUocException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(soKheUoc);
		}
		catch (NoSuchSoKheUocException nsee) {
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
	protected SoKheUoc removeImpl(SoKheUoc soKheUoc) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(soKheUoc)) {
				soKheUoc = (SoKheUoc)session.get(
					SoKheUocImpl.class, soKheUoc.getPrimaryKeyObj());
			}

			if (soKheUoc != null) {
				session.delete(soKheUoc);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (soKheUoc != null) {
			clearCache(soKheUoc);
		}

		return soKheUoc;
	}

	@Override
	public SoKheUoc updateImpl(SoKheUoc soKheUoc) {
		boolean isNew = soKheUoc.isNew();

		if (!(soKheUoc instanceof SoKheUocModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(soKheUoc.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(soKheUoc);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in soKheUoc proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SoKheUoc implementation " +
					soKheUoc.getClass());
		}

		SoKheUocModelImpl soKheUocModelImpl = (SoKheUocModelImpl)soKheUoc;

		Session session = null;

		try {
			session = openSession();

			if (soKheUoc.isNew()) {
				session.save(soKheUoc);

				soKheUoc.setNew(false);
			}
			else {
				soKheUoc = (SoKheUoc)session.merge(soKheUoc);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!SoKheUocModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			SoKheUocModelImpl.ENTITY_CACHE_ENABLED, SoKheUocImpl.class,
			soKheUoc.getPrimaryKey(), soKheUoc, false);

		clearUniqueFindersCache(soKheUocModelImpl, false);
		cacheUniqueFindersCache(soKheUocModelImpl);

		soKheUoc.resetOriginalValues();

		return soKheUoc;
	}

	/**
	 * Returns the so khe uoc with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the so khe uoc
	 * @return the so khe uoc
	 * @throws NoSuchSoKheUocException if a so khe uoc with the primary key could not be found
	 */
	@Override
	public SoKheUoc findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSoKheUocException {

		SoKheUoc soKheUoc = fetchByPrimaryKey(primaryKey);

		if (soKheUoc == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSoKheUocException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return soKheUoc;
	}

	/**
	 * Returns the so khe uoc with the primary key or throws a <code>NoSuchSoKheUocException</code> if it could not be found.
	 *
	 * @param soKheUocId the primary key of the so khe uoc
	 * @return the so khe uoc
	 * @throws NoSuchSoKheUocException if a so khe uoc with the primary key could not be found
	 */
	@Override
	public SoKheUoc findByPrimaryKey(long soKheUocId)
		throws NoSuchSoKheUocException {

		return findByPrimaryKey((Serializable)soKheUocId);
	}

	/**
	 * Returns the so khe uoc with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the so khe uoc
	 * @return the so khe uoc, or <code>null</code> if a so khe uoc with the primary key could not be found
	 */
	@Override
	public SoKheUoc fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			SoKheUocModelImpl.ENTITY_CACHE_ENABLED, SoKheUocImpl.class,
			primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		SoKheUoc soKheUoc = (SoKheUoc)serializable;

		if (soKheUoc == null) {
			Session session = null;

			try {
				session = openSession();

				soKheUoc = (SoKheUoc)session.get(
					SoKheUocImpl.class, primaryKey);

				if (soKheUoc != null) {
					cacheResult(soKheUoc);
				}
				else {
					entityCache.putResult(
						SoKheUocModelImpl.ENTITY_CACHE_ENABLED,
						SoKheUocImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					SoKheUocModelImpl.ENTITY_CACHE_ENABLED, SoKheUocImpl.class,
					primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return soKheUoc;
	}

	/**
	 * Returns the so khe uoc with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param soKheUocId the primary key of the so khe uoc
	 * @return the so khe uoc, or <code>null</code> if a so khe uoc with the primary key could not be found
	 */
	@Override
	public SoKheUoc fetchByPrimaryKey(long soKheUocId) {
		return fetchByPrimaryKey((Serializable)soKheUocId);
	}

	@Override
	public Map<Serializable, SoKheUoc> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, SoKheUoc> map = new HashMap<Serializable, SoKheUoc>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			SoKheUoc soKheUoc = fetchByPrimaryKey(primaryKey);

			if (soKheUoc != null) {
				map.put(primaryKey, soKheUoc);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				SoKheUocModelImpl.ENTITY_CACHE_ENABLED, SoKheUocImpl.class,
				primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (SoKheUoc)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_SOKHEUOC_WHERE_PKS_IN);

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

			for (SoKheUoc soKheUoc : (List<SoKheUoc>)q.list()) {
				map.put(soKheUoc.getPrimaryKeyObj(), soKheUoc);

				cacheResult(soKheUoc);

				uncachedPrimaryKeys.remove(soKheUoc.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					SoKheUocModelImpl.ENTITY_CACHE_ENABLED, SoKheUocImpl.class,
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
	 * Returns all the so khe uocs.
	 *
	 * @return the so khe uocs
	 */
	@Override
	public List<SoKheUoc> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the so khe uocs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SoKheUocModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of so khe uocs
	 * @param end the upper bound of the range of so khe uocs (not inclusive)
	 * @return the range of so khe uocs
	 */
	@Override
	public List<SoKheUoc> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the so khe uocs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SoKheUocModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of so khe uocs
	 * @param end the upper bound of the range of so khe uocs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of so khe uocs
	 */
	@Override
	public List<SoKheUoc> findAll(
		int start, int end, OrderByComparator<SoKheUoc> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the so khe uocs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SoKheUocModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of so khe uocs
	 * @param end the upper bound of the range of so khe uocs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of so khe uocs
	 */
	@Override
	public List<SoKheUoc> findAll(
		int start, int end, OrderByComparator<SoKheUoc> orderByComparator,
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

		List<SoKheUoc> list = null;

		if (retrieveFromCache) {
			list = (List<SoKheUoc>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_SOKHEUOC);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SOKHEUOC;

				if (pagination) {
					sql = sql.concat(SoKheUocModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SoKheUoc>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SoKheUoc>)QueryUtil.list(
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
	 * Removes all the so khe uocs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SoKheUoc soKheUoc : findAll()) {
			remove(soKheUoc);
		}
	}

	/**
	 * Returns the number of so khe uocs.
	 *
	 * @return the number of so khe uocs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SOKHEUOC);

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
		return SoKheUocModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the so khe uoc persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			SoKheUocModelImpl.ENTITY_CACHE_ENABLED,
			SoKheUocModelImpl.FINDER_CACHE_ENABLED, SoKheUocImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			SoKheUocModelImpl.ENTITY_CACHE_ENABLED,
			SoKheUocModelImpl.FINDER_CACHE_ENABLED, SoKheUocImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			SoKheUocModelImpl.ENTITY_CACHE_ENABLED,
			SoKheUocModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByCauTruc = new FinderPath(
			SoKheUocModelImpl.ENTITY_CACHE_ENABLED,
			SoKheUocModelImpl.FINDER_CACHE_ENABLED, SoKheUocImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCauTruc",
			new String[] {String.class.getName()},
			SoKheUocModelImpl.CAUTRUC_COLUMN_BITMASK);

		_finderPathCountByCauTruc = new FinderPath(
			SoKheUocModelImpl.ENTITY_CACHE_ENABLED,
			SoKheUocModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCauTruc",
			new String[] {String.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(SoKheUocImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_SOKHEUOC =
		"SELECT soKheUoc FROM SoKheUoc soKheUoc";

	private static final String _SQL_SELECT_SOKHEUOC_WHERE_PKS_IN =
		"SELECT soKheUoc FROM SoKheUoc soKheUoc WHERE soKheUocId IN (";

	private static final String _SQL_SELECT_SOKHEUOC_WHERE =
		"SELECT soKheUoc FROM SoKheUoc soKheUoc WHERE ";

	private static final String _SQL_COUNT_SOKHEUOC =
		"SELECT COUNT(soKheUoc) FROM SoKheUoc soKheUoc";

	private static final String _SQL_COUNT_SOKHEUOC_WHERE =
		"SELECT COUNT(soKheUoc) FROM SoKheUoc soKheUoc WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "soKheUoc.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SoKheUoc exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No SoKheUoc exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SoKheUocPersistenceImpl.class);

}