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

import com.mb.exception.NoSuchPhieuException;
import com.mb.model.Phieu;
import com.mb.model.impl.PhieuImpl;
import com.mb.model.impl.PhieuModelImpl;
import com.mb.service.persistence.PhieuPersistence;

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
 * The persistence implementation for the phieu service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class PhieuPersistenceImpl
	extends BasePersistenceImpl<Phieu> implements PhieuPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PhieuUtil</code> to access the phieu persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PhieuImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public PhieuPersistenceImpl() {
		setModelClass(Phieu.class);
	}

	/**
	 * Caches the phieu in the entity cache if it is enabled.
	 *
	 * @param phieu the phieu
	 */
	@Override
	public void cacheResult(Phieu phieu) {
		entityCache.putResult(
			PhieuModelImpl.ENTITY_CACHE_ENABLED, PhieuImpl.class,
			phieu.getPrimaryKey(), phieu);

		phieu.resetOriginalValues();
	}

	/**
	 * Caches the phieus in the entity cache if it is enabled.
	 *
	 * @param phieus the phieus
	 */
	@Override
	public void cacheResult(List<Phieu> phieus) {
		for (Phieu phieu : phieus) {
			if (entityCache.getResult(
					PhieuModelImpl.ENTITY_CACHE_ENABLED, PhieuImpl.class,
					phieu.getPrimaryKey()) == null) {

				cacheResult(phieu);
			}
			else {
				phieu.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all phieus.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PhieuImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the phieu.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Phieu phieu) {
		entityCache.removeResult(
			PhieuModelImpl.ENTITY_CACHE_ENABLED, PhieuImpl.class,
			phieu.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Phieu> phieus) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Phieu phieu : phieus) {
			entityCache.removeResult(
				PhieuModelImpl.ENTITY_CACHE_ENABLED, PhieuImpl.class,
				phieu.getPrimaryKey());
		}
	}

	/**
	 * Creates a new phieu with the primary key. Does not add the phieu to the database.
	 *
	 * @param phieuId the primary key for the new phieu
	 * @return the new phieu
	 */
	@Override
	public Phieu create(long phieuId) {
		Phieu phieu = new PhieuImpl();

		phieu.setNew(true);
		phieu.setPrimaryKey(phieuId);

		phieu.setCompanyId(companyProvider.getCompanyId());

		return phieu;
	}

	/**
	 * Removes the phieu with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param phieuId the primary key of the phieu
	 * @return the phieu that was removed
	 * @throws NoSuchPhieuException if a phieu with the primary key could not be found
	 */
	@Override
	public Phieu remove(long phieuId) throws NoSuchPhieuException {
		return remove((Serializable)phieuId);
	}

	/**
	 * Removes the phieu with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the phieu
	 * @return the phieu that was removed
	 * @throws NoSuchPhieuException if a phieu with the primary key could not be found
	 */
	@Override
	public Phieu remove(Serializable primaryKey) throws NoSuchPhieuException {
		Session session = null;

		try {
			session = openSession();

			Phieu phieu = (Phieu)session.get(PhieuImpl.class, primaryKey);

			if (phieu == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPhieuException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(phieu);
		}
		catch (NoSuchPhieuException nsee) {
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
	protected Phieu removeImpl(Phieu phieu) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(phieu)) {
				phieu = (Phieu)session.get(
					PhieuImpl.class, phieu.getPrimaryKeyObj());
			}

			if (phieu != null) {
				session.delete(phieu);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (phieu != null) {
			clearCache(phieu);
		}

		return phieu;
	}

	@Override
	public Phieu updateImpl(Phieu phieu) {
		boolean isNew = phieu.isNew();

		if (!(phieu instanceof PhieuModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(phieu.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(phieu);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in phieu proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Phieu implementation " +
					phieu.getClass());
		}

		PhieuModelImpl phieuModelImpl = (PhieuModelImpl)phieu;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (phieu.getCreateDate() == null)) {
			if (serviceContext == null) {
				phieu.setCreateDate(now);
			}
			else {
				phieu.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!phieuModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				phieu.setModifiedDate(now);
			}
			else {
				phieu.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (phieu.isNew()) {
				session.save(phieu);

				phieu.setNew(false);
			}
			else {
				phieu = (Phieu)session.merge(phieu);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			PhieuModelImpl.ENTITY_CACHE_ENABLED, PhieuImpl.class,
			phieu.getPrimaryKey(), phieu, false);

		phieu.resetOriginalValues();

		return phieu;
	}

	/**
	 * Returns the phieu with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the phieu
	 * @return the phieu
	 * @throws NoSuchPhieuException if a phieu with the primary key could not be found
	 */
	@Override
	public Phieu findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPhieuException {

		Phieu phieu = fetchByPrimaryKey(primaryKey);

		if (phieu == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPhieuException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return phieu;
	}

	/**
	 * Returns the phieu with the primary key or throws a <code>NoSuchPhieuException</code> if it could not be found.
	 *
	 * @param phieuId the primary key of the phieu
	 * @return the phieu
	 * @throws NoSuchPhieuException if a phieu with the primary key could not be found
	 */
	@Override
	public Phieu findByPrimaryKey(long phieuId) throws NoSuchPhieuException {
		return findByPrimaryKey((Serializable)phieuId);
	}

	/**
	 * Returns the phieu with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the phieu
	 * @return the phieu, or <code>null</code> if a phieu with the primary key could not be found
	 */
	@Override
	public Phieu fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			PhieuModelImpl.ENTITY_CACHE_ENABLED, PhieuImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Phieu phieu = (Phieu)serializable;

		if (phieu == null) {
			Session session = null;

			try {
				session = openSession();

				phieu = (Phieu)session.get(PhieuImpl.class, primaryKey);

				if (phieu != null) {
					cacheResult(phieu);
				}
				else {
					entityCache.putResult(
						PhieuModelImpl.ENTITY_CACHE_ENABLED, PhieuImpl.class,
						primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					PhieuModelImpl.ENTITY_CACHE_ENABLED, PhieuImpl.class,
					primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return phieu;
	}

	/**
	 * Returns the phieu with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param phieuId the primary key of the phieu
	 * @return the phieu, or <code>null</code> if a phieu with the primary key could not be found
	 */
	@Override
	public Phieu fetchByPrimaryKey(long phieuId) {
		return fetchByPrimaryKey((Serializable)phieuId);
	}

	@Override
	public Map<Serializable, Phieu> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Phieu> map = new HashMap<Serializable, Phieu>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Phieu phieu = fetchByPrimaryKey(primaryKey);

			if (phieu != null) {
				map.put(primaryKey, phieu);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				PhieuModelImpl.ENTITY_CACHE_ENABLED, PhieuImpl.class,
				primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Phieu)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_PHIEU_WHERE_PKS_IN);

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

			for (Phieu phieu : (List<Phieu>)q.list()) {
				map.put(phieu.getPrimaryKeyObj(), phieu);

				cacheResult(phieu);

				uncachedPrimaryKeys.remove(phieu.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					PhieuModelImpl.ENTITY_CACHE_ENABLED, PhieuImpl.class,
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
	 * Returns all the phieus.
	 *
	 * @return the phieus
	 */
	@Override
	public List<Phieu> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the phieus.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PhieuModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of phieus
	 * @param end the upper bound of the range of phieus (not inclusive)
	 * @return the range of phieus
	 */
	@Override
	public List<Phieu> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the phieus.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PhieuModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of phieus
	 * @param end the upper bound of the range of phieus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of phieus
	 */
	@Override
	public List<Phieu> findAll(
		int start, int end, OrderByComparator<Phieu> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the phieus.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PhieuModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of phieus
	 * @param end the upper bound of the range of phieus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of phieus
	 */
	@Override
	public List<Phieu> findAll(
		int start, int end, OrderByComparator<Phieu> orderByComparator,
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

		List<Phieu> list = null;

		if (retrieveFromCache) {
			list = (List<Phieu>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PHIEU);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PHIEU;

				if (pagination) {
					sql = sql.concat(PhieuModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Phieu>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Phieu>)QueryUtil.list(
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
	 * Removes all the phieus from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Phieu phieu : findAll()) {
			remove(phieu);
		}
	}

	/**
	 * Returns the number of phieus.
	 *
	 * @return the number of phieus
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PHIEU);

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
		return PhieuModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the phieu persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			PhieuModelImpl.ENTITY_CACHE_ENABLED,
			PhieuModelImpl.FINDER_CACHE_ENABLED, PhieuImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			PhieuModelImpl.ENTITY_CACHE_ENABLED,
			PhieuModelImpl.FINDER_CACHE_ENABLED, PhieuImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			PhieuModelImpl.ENTITY_CACHE_ENABLED,
			PhieuModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	public void destroy() {
		entityCache.removeCache(PhieuImpl.class.getName());
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

	private static final String _SQL_SELECT_PHIEU =
		"SELECT phieu FROM Phieu phieu";

	private static final String _SQL_SELECT_PHIEU_WHERE_PKS_IN =
		"SELECT phieu FROM Phieu phieu WHERE phieuId IN (";

	private static final String _SQL_COUNT_PHIEU =
		"SELECT COUNT(phieu) FROM Phieu phieu";

	private static final String _ORDER_BY_ENTITY_ALIAS = "phieu.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Phieu exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		PhieuPersistenceImpl.class);

}