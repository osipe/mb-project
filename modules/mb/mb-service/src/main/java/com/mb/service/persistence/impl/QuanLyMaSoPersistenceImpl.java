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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.mb.exception.NoSuchQuanLyMaSoException;
import com.mb.model.QuanLyMaSo;
import com.mb.model.impl.QuanLyMaSoImpl;
import com.mb.model.impl.QuanLyMaSoModelImpl;
import com.mb.service.persistence.QuanLyMaSoPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;
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
 * The persistence implementation for the quan ly ma so service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class QuanLyMaSoPersistenceImpl
	extends BasePersistenceImpl<QuanLyMaSo> implements QuanLyMaSoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>QuanLyMaSoUtil</code> to access the quan ly ma so persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		QuanLyMaSoImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByKey;
	private FinderPath _finderPathCountByKey;

	/**
	 * Returns the quan ly ma so where key = &#63; or throws a <code>NoSuchQuanLyMaSoException</code> if it could not be found.
	 *
	 * @param key the key
	 * @return the matching quan ly ma so
	 * @throws NoSuchQuanLyMaSoException if a matching quan ly ma so could not be found
	 */
	@Override
	public QuanLyMaSo findByKey(String key) throws NoSuchQuanLyMaSoException {
		QuanLyMaSo quanLyMaSo = fetchByKey(key);

		if (quanLyMaSo == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("key=");
			msg.append(key);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchQuanLyMaSoException(msg.toString());
		}

		return quanLyMaSo;
	}

	/**
	 * Returns the quan ly ma so where key = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param key the key
	 * @return the matching quan ly ma so, or <code>null</code> if a matching quan ly ma so could not be found
	 */
	@Override
	public QuanLyMaSo fetchByKey(String key) {
		return fetchByKey(key, true);
	}

	/**
	 * Returns the quan ly ma so where key = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param key the key
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching quan ly ma so, or <code>null</code> if a matching quan ly ma so could not be found
	 */
	@Override
	public QuanLyMaSo fetchByKey(String key, boolean retrieveFromCache) {
		key = Objects.toString(key, "");

		Object[] finderArgs = new Object[] {key};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByKey, finderArgs, this);
		}

		if (result instanceof QuanLyMaSo) {
			QuanLyMaSo quanLyMaSo = (QuanLyMaSo)result;

			if (!Objects.equals(key, quanLyMaSo.getKey())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_QUANLYMASO_WHERE);

			boolean bindKey = false;

			if (key.isEmpty()) {
				query.append(_FINDER_COLUMN_KEY_KEY_3);
			}
			else {
				bindKey = true;

				query.append(_FINDER_COLUMN_KEY_KEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindKey) {
					qPos.add(key);
				}

				List<QuanLyMaSo> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByKey, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"QuanLyMaSoPersistenceImpl.fetchByKey(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					QuanLyMaSo quanLyMaSo = list.get(0);

					result = quanLyMaSo;

					cacheResult(quanLyMaSo);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(_finderPathFetchByKey, finderArgs);

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
			return (QuanLyMaSo)result;
		}
	}

	/**
	 * Removes the quan ly ma so where key = &#63; from the database.
	 *
	 * @param key the key
	 * @return the quan ly ma so that was removed
	 */
	@Override
	public QuanLyMaSo removeByKey(String key) throws NoSuchQuanLyMaSoException {
		QuanLyMaSo quanLyMaSo = findByKey(key);

		return remove(quanLyMaSo);
	}

	/**
	 * Returns the number of quan ly ma sos where key = &#63;.
	 *
	 * @param key the key
	 * @return the number of matching quan ly ma sos
	 */
	@Override
	public int countByKey(String key) {
		key = Objects.toString(key, "");

		FinderPath finderPath = _finderPathCountByKey;

		Object[] finderArgs = new Object[] {key};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_QUANLYMASO_WHERE);

			boolean bindKey = false;

			if (key.isEmpty()) {
				query.append(_FINDER_COLUMN_KEY_KEY_3);
			}
			else {
				bindKey = true;

				query.append(_FINDER_COLUMN_KEY_KEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindKey) {
					qPos.add(key);
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

	private static final String _FINDER_COLUMN_KEY_KEY_2 = "quanLyMaSo.key = ?";

	private static final String _FINDER_COLUMN_KEY_KEY_3 =
		"(quanLyMaSo.key IS NULL OR quanLyMaSo.key = '')";

	public QuanLyMaSoPersistenceImpl() {
		setModelClass(QuanLyMaSo.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("key", "key_");

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
				"_dbColumnNames");

			field.setAccessible(true);

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the quan ly ma so in the entity cache if it is enabled.
	 *
	 * @param quanLyMaSo the quan ly ma so
	 */
	@Override
	public void cacheResult(QuanLyMaSo quanLyMaSo) {
		entityCache.putResult(
			QuanLyMaSoModelImpl.ENTITY_CACHE_ENABLED, QuanLyMaSoImpl.class,
			quanLyMaSo.getPrimaryKey(), quanLyMaSo);

		finderCache.putResult(
			_finderPathFetchByKey, new Object[] {quanLyMaSo.getKey()},
			quanLyMaSo);

		quanLyMaSo.resetOriginalValues();
	}

	/**
	 * Caches the quan ly ma sos in the entity cache if it is enabled.
	 *
	 * @param quanLyMaSos the quan ly ma sos
	 */
	@Override
	public void cacheResult(List<QuanLyMaSo> quanLyMaSos) {
		for (QuanLyMaSo quanLyMaSo : quanLyMaSos) {
			if (entityCache.getResult(
					QuanLyMaSoModelImpl.ENTITY_CACHE_ENABLED,
					QuanLyMaSoImpl.class, quanLyMaSo.getPrimaryKey()) == null) {

				cacheResult(quanLyMaSo);
			}
			else {
				quanLyMaSo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all quan ly ma sos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(QuanLyMaSoImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the quan ly ma so.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(QuanLyMaSo quanLyMaSo) {
		entityCache.removeResult(
			QuanLyMaSoModelImpl.ENTITY_CACHE_ENABLED, QuanLyMaSoImpl.class,
			quanLyMaSo.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((QuanLyMaSoModelImpl)quanLyMaSo, true);
	}

	@Override
	public void clearCache(List<QuanLyMaSo> quanLyMaSos) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (QuanLyMaSo quanLyMaSo : quanLyMaSos) {
			entityCache.removeResult(
				QuanLyMaSoModelImpl.ENTITY_CACHE_ENABLED, QuanLyMaSoImpl.class,
				quanLyMaSo.getPrimaryKey());

			clearUniqueFindersCache((QuanLyMaSoModelImpl)quanLyMaSo, true);
		}
	}

	protected void cacheUniqueFindersCache(
		QuanLyMaSoModelImpl quanLyMaSoModelImpl) {

		Object[] args = new Object[] {quanLyMaSoModelImpl.getKey()};

		finderCache.putResult(
			_finderPathCountByKey, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByKey, args, quanLyMaSoModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		QuanLyMaSoModelImpl quanLyMaSoModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {quanLyMaSoModelImpl.getKey()};

			finderCache.removeResult(_finderPathCountByKey, args);
			finderCache.removeResult(_finderPathFetchByKey, args);
		}

		if ((quanLyMaSoModelImpl.getColumnBitmask() &
			 _finderPathFetchByKey.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {quanLyMaSoModelImpl.getOriginalKey()};

			finderCache.removeResult(_finderPathCountByKey, args);
			finderCache.removeResult(_finderPathFetchByKey, args);
		}
	}

	/**
	 * Creates a new quan ly ma so with the primary key. Does not add the quan ly ma so to the database.
	 *
	 * @param quanLyMaSoId the primary key for the new quan ly ma so
	 * @return the new quan ly ma so
	 */
	@Override
	public QuanLyMaSo create(long quanLyMaSoId) {
		QuanLyMaSo quanLyMaSo = new QuanLyMaSoImpl();

		quanLyMaSo.setNew(true);
		quanLyMaSo.setPrimaryKey(quanLyMaSoId);

		return quanLyMaSo;
	}

	/**
	 * Removes the quan ly ma so with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param quanLyMaSoId the primary key of the quan ly ma so
	 * @return the quan ly ma so that was removed
	 * @throws NoSuchQuanLyMaSoException if a quan ly ma so with the primary key could not be found
	 */
	@Override
	public QuanLyMaSo remove(long quanLyMaSoId)
		throws NoSuchQuanLyMaSoException {

		return remove((Serializable)quanLyMaSoId);
	}

	/**
	 * Removes the quan ly ma so with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the quan ly ma so
	 * @return the quan ly ma so that was removed
	 * @throws NoSuchQuanLyMaSoException if a quan ly ma so with the primary key could not be found
	 */
	@Override
	public QuanLyMaSo remove(Serializable primaryKey)
		throws NoSuchQuanLyMaSoException {

		Session session = null;

		try {
			session = openSession();

			QuanLyMaSo quanLyMaSo = (QuanLyMaSo)session.get(
				QuanLyMaSoImpl.class, primaryKey);

			if (quanLyMaSo == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchQuanLyMaSoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(quanLyMaSo);
		}
		catch (NoSuchQuanLyMaSoException nsee) {
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
	protected QuanLyMaSo removeImpl(QuanLyMaSo quanLyMaSo) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(quanLyMaSo)) {
				quanLyMaSo = (QuanLyMaSo)session.get(
					QuanLyMaSoImpl.class, quanLyMaSo.getPrimaryKeyObj());
			}

			if (quanLyMaSo != null) {
				session.delete(quanLyMaSo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (quanLyMaSo != null) {
			clearCache(quanLyMaSo);
		}

		return quanLyMaSo;
	}

	@Override
	public QuanLyMaSo updateImpl(QuanLyMaSo quanLyMaSo) {
		boolean isNew = quanLyMaSo.isNew();

		if (!(quanLyMaSo instanceof QuanLyMaSoModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(quanLyMaSo.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(quanLyMaSo);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in quanLyMaSo proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom QuanLyMaSo implementation " +
					quanLyMaSo.getClass());
		}

		QuanLyMaSoModelImpl quanLyMaSoModelImpl =
			(QuanLyMaSoModelImpl)quanLyMaSo;

		Session session = null;

		try {
			session = openSession();

			if (quanLyMaSo.isNew()) {
				session.save(quanLyMaSo);

				quanLyMaSo.setNew(false);
			}
			else {
				quanLyMaSo = (QuanLyMaSo)session.merge(quanLyMaSo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!QuanLyMaSoModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			QuanLyMaSoModelImpl.ENTITY_CACHE_ENABLED, QuanLyMaSoImpl.class,
			quanLyMaSo.getPrimaryKey(), quanLyMaSo, false);

		clearUniqueFindersCache(quanLyMaSoModelImpl, false);
		cacheUniqueFindersCache(quanLyMaSoModelImpl);

		quanLyMaSo.resetOriginalValues();

		return quanLyMaSo;
	}

	/**
	 * Returns the quan ly ma so with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the quan ly ma so
	 * @return the quan ly ma so
	 * @throws NoSuchQuanLyMaSoException if a quan ly ma so with the primary key could not be found
	 */
	@Override
	public QuanLyMaSo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchQuanLyMaSoException {

		QuanLyMaSo quanLyMaSo = fetchByPrimaryKey(primaryKey);

		if (quanLyMaSo == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchQuanLyMaSoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return quanLyMaSo;
	}

	/**
	 * Returns the quan ly ma so with the primary key or throws a <code>NoSuchQuanLyMaSoException</code> if it could not be found.
	 *
	 * @param quanLyMaSoId the primary key of the quan ly ma so
	 * @return the quan ly ma so
	 * @throws NoSuchQuanLyMaSoException if a quan ly ma so with the primary key could not be found
	 */
	@Override
	public QuanLyMaSo findByPrimaryKey(long quanLyMaSoId)
		throws NoSuchQuanLyMaSoException {

		return findByPrimaryKey((Serializable)quanLyMaSoId);
	}

	/**
	 * Returns the quan ly ma so with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the quan ly ma so
	 * @return the quan ly ma so, or <code>null</code> if a quan ly ma so with the primary key could not be found
	 */
	@Override
	public QuanLyMaSo fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			QuanLyMaSoModelImpl.ENTITY_CACHE_ENABLED, QuanLyMaSoImpl.class,
			primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		QuanLyMaSo quanLyMaSo = (QuanLyMaSo)serializable;

		if (quanLyMaSo == null) {
			Session session = null;

			try {
				session = openSession();

				quanLyMaSo = (QuanLyMaSo)session.get(
					QuanLyMaSoImpl.class, primaryKey);

				if (quanLyMaSo != null) {
					cacheResult(quanLyMaSo);
				}
				else {
					entityCache.putResult(
						QuanLyMaSoModelImpl.ENTITY_CACHE_ENABLED,
						QuanLyMaSoImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					QuanLyMaSoModelImpl.ENTITY_CACHE_ENABLED,
					QuanLyMaSoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return quanLyMaSo;
	}

	/**
	 * Returns the quan ly ma so with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param quanLyMaSoId the primary key of the quan ly ma so
	 * @return the quan ly ma so, or <code>null</code> if a quan ly ma so with the primary key could not be found
	 */
	@Override
	public QuanLyMaSo fetchByPrimaryKey(long quanLyMaSoId) {
		return fetchByPrimaryKey((Serializable)quanLyMaSoId);
	}

	@Override
	public Map<Serializable, QuanLyMaSo> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, QuanLyMaSo> map =
			new HashMap<Serializable, QuanLyMaSo>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			QuanLyMaSo quanLyMaSo = fetchByPrimaryKey(primaryKey);

			if (quanLyMaSo != null) {
				map.put(primaryKey, quanLyMaSo);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				QuanLyMaSoModelImpl.ENTITY_CACHE_ENABLED, QuanLyMaSoImpl.class,
				primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (QuanLyMaSo)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_QUANLYMASO_WHERE_PKS_IN);

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

			for (QuanLyMaSo quanLyMaSo : (List<QuanLyMaSo>)q.list()) {
				map.put(quanLyMaSo.getPrimaryKeyObj(), quanLyMaSo);

				cacheResult(quanLyMaSo);

				uncachedPrimaryKeys.remove(quanLyMaSo.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					QuanLyMaSoModelImpl.ENTITY_CACHE_ENABLED,
					QuanLyMaSoImpl.class, primaryKey, nullModel);
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
	 * Returns all the quan ly ma sos.
	 *
	 * @return the quan ly ma sos
	 */
	@Override
	public List<QuanLyMaSo> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the quan ly ma sos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QuanLyMaSoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of quan ly ma sos
	 * @param end the upper bound of the range of quan ly ma sos (not inclusive)
	 * @return the range of quan ly ma sos
	 */
	@Override
	public List<QuanLyMaSo> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the quan ly ma sos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QuanLyMaSoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of quan ly ma sos
	 * @param end the upper bound of the range of quan ly ma sos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of quan ly ma sos
	 */
	@Override
	public List<QuanLyMaSo> findAll(
		int start, int end, OrderByComparator<QuanLyMaSo> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the quan ly ma sos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QuanLyMaSoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of quan ly ma sos
	 * @param end the upper bound of the range of quan ly ma sos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of quan ly ma sos
	 */
	@Override
	public List<QuanLyMaSo> findAll(
		int start, int end, OrderByComparator<QuanLyMaSo> orderByComparator,
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

		List<QuanLyMaSo> list = null;

		if (retrieveFromCache) {
			list = (List<QuanLyMaSo>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_QUANLYMASO);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_QUANLYMASO;

				if (pagination) {
					sql = sql.concat(QuanLyMaSoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<QuanLyMaSo>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<QuanLyMaSo>)QueryUtil.list(
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
	 * Removes all the quan ly ma sos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (QuanLyMaSo quanLyMaSo : findAll()) {
			remove(quanLyMaSo);
		}
	}

	/**
	 * Returns the number of quan ly ma sos.
	 *
	 * @return the number of quan ly ma sos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_QUANLYMASO);

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
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return QuanLyMaSoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the quan ly ma so persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			QuanLyMaSoModelImpl.ENTITY_CACHE_ENABLED,
			QuanLyMaSoModelImpl.FINDER_CACHE_ENABLED, QuanLyMaSoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			QuanLyMaSoModelImpl.ENTITY_CACHE_ENABLED,
			QuanLyMaSoModelImpl.FINDER_CACHE_ENABLED, QuanLyMaSoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			QuanLyMaSoModelImpl.ENTITY_CACHE_ENABLED,
			QuanLyMaSoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByKey = new FinderPath(
			QuanLyMaSoModelImpl.ENTITY_CACHE_ENABLED,
			QuanLyMaSoModelImpl.FINDER_CACHE_ENABLED, QuanLyMaSoImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByKey",
			new String[] {String.class.getName()},
			QuanLyMaSoModelImpl.KEY_COLUMN_BITMASK);

		_finderPathCountByKey = new FinderPath(
			QuanLyMaSoModelImpl.ENTITY_CACHE_ENABLED,
			QuanLyMaSoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByKey",
			new String[] {String.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(QuanLyMaSoImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_QUANLYMASO =
		"SELECT quanLyMaSo FROM QuanLyMaSo quanLyMaSo";

	private static final String _SQL_SELECT_QUANLYMASO_WHERE_PKS_IN =
		"SELECT quanLyMaSo FROM QuanLyMaSo quanLyMaSo WHERE quanLyMaSoId IN (";

	private static final String _SQL_SELECT_QUANLYMASO_WHERE =
		"SELECT quanLyMaSo FROM QuanLyMaSo quanLyMaSo WHERE ";

	private static final String _SQL_COUNT_QUANLYMASO =
		"SELECT COUNT(quanLyMaSo) FROM QuanLyMaSo quanLyMaSo";

	private static final String _SQL_COUNT_QUANLYMASO_WHERE =
		"SELECT COUNT(quanLyMaSo) FROM QuanLyMaSo quanLyMaSo WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "quanLyMaSo.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No QuanLyMaSo exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No QuanLyMaSo exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		QuanLyMaSoPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"key"});

}