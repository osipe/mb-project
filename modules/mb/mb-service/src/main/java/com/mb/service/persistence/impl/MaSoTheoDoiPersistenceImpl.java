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

import com.mb.exception.NoSuchMaSoTheoDoiException;
import com.mb.model.MaSoTheoDoi;
import com.mb.model.impl.MaSoTheoDoiImpl;
import com.mb.model.impl.MaSoTheoDoiModelImpl;
import com.mb.service.persistence.MaSoTheoDoiPersistence;

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
 * The persistence implementation for the ma so theo doi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class MaSoTheoDoiPersistenceImpl
	extends BasePersistenceImpl<MaSoTheoDoi> implements MaSoTheoDoiPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>MaSoTheoDoiUtil</code> to access the ma so theo doi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		MaSoTheoDoiImpl.class.getName();

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
	 * Returns the ma so theo doi where ma = &#63; or throws a <code>NoSuchMaSoTheoDoiException</code> if it could not be found.
	 *
	 * @param ma the ma
	 * @return the matching ma so theo doi
	 * @throws NoSuchMaSoTheoDoiException if a matching ma so theo doi could not be found
	 */
	@Override
	public MaSoTheoDoi findByMa(String ma) throws NoSuchMaSoTheoDoiException {
		MaSoTheoDoi maSoTheoDoi = fetchByMa(ma);

		if (maSoTheoDoi == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ma=");
			msg.append(ma);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchMaSoTheoDoiException(msg.toString());
		}

		return maSoTheoDoi;
	}

	/**
	 * Returns the ma so theo doi where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ma the ma
	 * @return the matching ma so theo doi, or <code>null</code> if a matching ma so theo doi could not be found
	 */
	@Override
	public MaSoTheoDoi fetchByMa(String ma) {
		return fetchByMa(ma, true);
	}

	/**
	 * Returns the ma so theo doi where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ma the ma
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching ma so theo doi, or <code>null</code> if a matching ma so theo doi could not be found
	 */
	@Override
	public MaSoTheoDoi fetchByMa(String ma, boolean retrieveFromCache) {
		ma = Objects.toString(ma, "");

		Object[] finderArgs = new Object[] {ma};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByMa, finderArgs, this);
		}

		if (result instanceof MaSoTheoDoi) {
			MaSoTheoDoi maSoTheoDoi = (MaSoTheoDoi)result;

			if (!Objects.equals(ma, maSoTheoDoi.getMa())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_MASOTHEODOI_WHERE);

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

				List<MaSoTheoDoi> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByMa, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"MaSoTheoDoiPersistenceImpl.fetchByMa(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					MaSoTheoDoi maSoTheoDoi = list.get(0);

					result = maSoTheoDoi;

					cacheResult(maSoTheoDoi);
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
			return (MaSoTheoDoi)result;
		}
	}

	/**
	 * Removes the ma so theo doi where ma = &#63; from the database.
	 *
	 * @param ma the ma
	 * @return the ma so theo doi that was removed
	 */
	@Override
	public MaSoTheoDoi removeByMa(String ma) throws NoSuchMaSoTheoDoiException {
		MaSoTheoDoi maSoTheoDoi = findByMa(ma);

		return remove(maSoTheoDoi);
	}

	/**
	 * Returns the number of ma so theo dois where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the number of matching ma so theo dois
	 */
	@Override
	public int countByMa(String ma) {
		ma = Objects.toString(ma, "");

		FinderPath finderPath = _finderPathCountByMa;

		Object[] finderArgs = new Object[] {ma};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MASOTHEODOI_WHERE);

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

	private static final String _FINDER_COLUMN_MA_MA_2 = "maSoTheoDoi.ma = ?";

	private static final String _FINDER_COLUMN_MA_MA_3 =
		"(maSoTheoDoi.ma IS NULL OR maSoTheoDoi.ma = '')";

	public MaSoTheoDoiPersistenceImpl() {
		setModelClass(MaSoTheoDoi.class);
	}

	/**
	 * Caches the ma so theo doi in the entity cache if it is enabled.
	 *
	 * @param maSoTheoDoi the ma so theo doi
	 */
	@Override
	public void cacheResult(MaSoTheoDoi maSoTheoDoi) {
		entityCache.putResult(
			MaSoTheoDoiModelImpl.ENTITY_CACHE_ENABLED, MaSoTheoDoiImpl.class,
			maSoTheoDoi.getPrimaryKey(), maSoTheoDoi);

		finderCache.putResult(
			_finderPathFetchByMa, new Object[] {maSoTheoDoi.getMa()},
			maSoTheoDoi);

		maSoTheoDoi.resetOriginalValues();
	}

	/**
	 * Caches the ma so theo dois in the entity cache if it is enabled.
	 *
	 * @param maSoTheoDois the ma so theo dois
	 */
	@Override
	public void cacheResult(List<MaSoTheoDoi> maSoTheoDois) {
		for (MaSoTheoDoi maSoTheoDoi : maSoTheoDois) {
			if (entityCache.getResult(
					MaSoTheoDoiModelImpl.ENTITY_CACHE_ENABLED,
					MaSoTheoDoiImpl.class, maSoTheoDoi.getPrimaryKey()) ==
						null) {

				cacheResult(maSoTheoDoi);
			}
			else {
				maSoTheoDoi.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ma so theo dois.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MaSoTheoDoiImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ma so theo doi.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MaSoTheoDoi maSoTheoDoi) {
		entityCache.removeResult(
			MaSoTheoDoiModelImpl.ENTITY_CACHE_ENABLED, MaSoTheoDoiImpl.class,
			maSoTheoDoi.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((MaSoTheoDoiModelImpl)maSoTheoDoi, true);
	}

	@Override
	public void clearCache(List<MaSoTheoDoi> maSoTheoDois) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MaSoTheoDoi maSoTheoDoi : maSoTheoDois) {
			entityCache.removeResult(
				MaSoTheoDoiModelImpl.ENTITY_CACHE_ENABLED,
				MaSoTheoDoiImpl.class, maSoTheoDoi.getPrimaryKey());

			clearUniqueFindersCache((MaSoTheoDoiModelImpl)maSoTheoDoi, true);
		}
	}

	protected void cacheUniqueFindersCache(
		MaSoTheoDoiModelImpl maSoTheoDoiModelImpl) {

		Object[] args = new Object[] {maSoTheoDoiModelImpl.getMa()};

		finderCache.putResult(
			_finderPathCountByMa, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByMa, args, maSoTheoDoiModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		MaSoTheoDoiModelImpl maSoTheoDoiModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {maSoTheoDoiModelImpl.getMa()};

			finderCache.removeResult(_finderPathCountByMa, args);
			finderCache.removeResult(_finderPathFetchByMa, args);
		}

		if ((maSoTheoDoiModelImpl.getColumnBitmask() &
			 _finderPathFetchByMa.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {maSoTheoDoiModelImpl.getOriginalMa()};

			finderCache.removeResult(_finderPathCountByMa, args);
			finderCache.removeResult(_finderPathFetchByMa, args);
		}
	}

	/**
	 * Creates a new ma so theo doi with the primary key. Does not add the ma so theo doi to the database.
	 *
	 * @param maSoTheoDoiId the primary key for the new ma so theo doi
	 * @return the new ma so theo doi
	 */
	@Override
	public MaSoTheoDoi create(long maSoTheoDoiId) {
		MaSoTheoDoi maSoTheoDoi = new MaSoTheoDoiImpl();

		maSoTheoDoi.setNew(true);
		maSoTheoDoi.setPrimaryKey(maSoTheoDoiId);

		maSoTheoDoi.setCompanyId(companyProvider.getCompanyId());

		return maSoTheoDoi;
	}

	/**
	 * Removes the ma so theo doi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param maSoTheoDoiId the primary key of the ma so theo doi
	 * @return the ma so theo doi that was removed
	 * @throws NoSuchMaSoTheoDoiException if a ma so theo doi with the primary key could not be found
	 */
	@Override
	public MaSoTheoDoi remove(long maSoTheoDoiId)
		throws NoSuchMaSoTheoDoiException {

		return remove((Serializable)maSoTheoDoiId);
	}

	/**
	 * Removes the ma so theo doi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ma so theo doi
	 * @return the ma so theo doi that was removed
	 * @throws NoSuchMaSoTheoDoiException if a ma so theo doi with the primary key could not be found
	 */
	@Override
	public MaSoTheoDoi remove(Serializable primaryKey)
		throws NoSuchMaSoTheoDoiException {

		Session session = null;

		try {
			session = openSession();

			MaSoTheoDoi maSoTheoDoi = (MaSoTheoDoi)session.get(
				MaSoTheoDoiImpl.class, primaryKey);

			if (maSoTheoDoi == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMaSoTheoDoiException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(maSoTheoDoi);
		}
		catch (NoSuchMaSoTheoDoiException nsee) {
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
	protected MaSoTheoDoi removeImpl(MaSoTheoDoi maSoTheoDoi) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(maSoTheoDoi)) {
				maSoTheoDoi = (MaSoTheoDoi)session.get(
					MaSoTheoDoiImpl.class, maSoTheoDoi.getPrimaryKeyObj());
			}

			if (maSoTheoDoi != null) {
				session.delete(maSoTheoDoi);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (maSoTheoDoi != null) {
			clearCache(maSoTheoDoi);
		}

		return maSoTheoDoi;
	}

	@Override
	public MaSoTheoDoi updateImpl(MaSoTheoDoi maSoTheoDoi) {
		boolean isNew = maSoTheoDoi.isNew();

		if (!(maSoTheoDoi instanceof MaSoTheoDoiModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(maSoTheoDoi.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(maSoTheoDoi);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in maSoTheoDoi proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom MaSoTheoDoi implementation " +
					maSoTheoDoi.getClass());
		}

		MaSoTheoDoiModelImpl maSoTheoDoiModelImpl =
			(MaSoTheoDoiModelImpl)maSoTheoDoi;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (maSoTheoDoi.getCreateDate() == null)) {
			if (serviceContext == null) {
				maSoTheoDoi.setCreateDate(now);
			}
			else {
				maSoTheoDoi.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!maSoTheoDoiModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				maSoTheoDoi.setModifiedDate(now);
			}
			else {
				maSoTheoDoi.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (maSoTheoDoi.isNew()) {
				session.save(maSoTheoDoi);

				maSoTheoDoi.setNew(false);
			}
			else {
				maSoTheoDoi = (MaSoTheoDoi)session.merge(maSoTheoDoi);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!MaSoTheoDoiModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			MaSoTheoDoiModelImpl.ENTITY_CACHE_ENABLED, MaSoTheoDoiImpl.class,
			maSoTheoDoi.getPrimaryKey(), maSoTheoDoi, false);

		clearUniqueFindersCache(maSoTheoDoiModelImpl, false);
		cacheUniqueFindersCache(maSoTheoDoiModelImpl);

		maSoTheoDoi.resetOriginalValues();

		return maSoTheoDoi;
	}

	/**
	 * Returns the ma so theo doi with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ma so theo doi
	 * @return the ma so theo doi
	 * @throws NoSuchMaSoTheoDoiException if a ma so theo doi with the primary key could not be found
	 */
	@Override
	public MaSoTheoDoi findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMaSoTheoDoiException {

		MaSoTheoDoi maSoTheoDoi = fetchByPrimaryKey(primaryKey);

		if (maSoTheoDoi == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMaSoTheoDoiException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return maSoTheoDoi;
	}

	/**
	 * Returns the ma so theo doi with the primary key or throws a <code>NoSuchMaSoTheoDoiException</code> if it could not be found.
	 *
	 * @param maSoTheoDoiId the primary key of the ma so theo doi
	 * @return the ma so theo doi
	 * @throws NoSuchMaSoTheoDoiException if a ma so theo doi with the primary key could not be found
	 */
	@Override
	public MaSoTheoDoi findByPrimaryKey(long maSoTheoDoiId)
		throws NoSuchMaSoTheoDoiException {

		return findByPrimaryKey((Serializable)maSoTheoDoiId);
	}

	/**
	 * Returns the ma so theo doi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ma so theo doi
	 * @return the ma so theo doi, or <code>null</code> if a ma so theo doi with the primary key could not be found
	 */
	@Override
	public MaSoTheoDoi fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			MaSoTheoDoiModelImpl.ENTITY_CACHE_ENABLED, MaSoTheoDoiImpl.class,
			primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		MaSoTheoDoi maSoTheoDoi = (MaSoTheoDoi)serializable;

		if (maSoTheoDoi == null) {
			Session session = null;

			try {
				session = openSession();

				maSoTheoDoi = (MaSoTheoDoi)session.get(
					MaSoTheoDoiImpl.class, primaryKey);

				if (maSoTheoDoi != null) {
					cacheResult(maSoTheoDoi);
				}
				else {
					entityCache.putResult(
						MaSoTheoDoiModelImpl.ENTITY_CACHE_ENABLED,
						MaSoTheoDoiImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					MaSoTheoDoiModelImpl.ENTITY_CACHE_ENABLED,
					MaSoTheoDoiImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return maSoTheoDoi;
	}

	/**
	 * Returns the ma so theo doi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param maSoTheoDoiId the primary key of the ma so theo doi
	 * @return the ma so theo doi, or <code>null</code> if a ma so theo doi with the primary key could not be found
	 */
	@Override
	public MaSoTheoDoi fetchByPrimaryKey(long maSoTheoDoiId) {
		return fetchByPrimaryKey((Serializable)maSoTheoDoiId);
	}

	@Override
	public Map<Serializable, MaSoTheoDoi> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, MaSoTheoDoi> map =
			new HashMap<Serializable, MaSoTheoDoi>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			MaSoTheoDoi maSoTheoDoi = fetchByPrimaryKey(primaryKey);

			if (maSoTheoDoi != null) {
				map.put(primaryKey, maSoTheoDoi);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				MaSoTheoDoiModelImpl.ENTITY_CACHE_ENABLED,
				MaSoTheoDoiImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (MaSoTheoDoi)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_MASOTHEODOI_WHERE_PKS_IN);

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

			for (MaSoTheoDoi maSoTheoDoi : (List<MaSoTheoDoi>)q.list()) {
				map.put(maSoTheoDoi.getPrimaryKeyObj(), maSoTheoDoi);

				cacheResult(maSoTheoDoi);

				uncachedPrimaryKeys.remove(maSoTheoDoi.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					MaSoTheoDoiModelImpl.ENTITY_CACHE_ENABLED,
					MaSoTheoDoiImpl.class, primaryKey, nullModel);
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
	 * Returns all the ma so theo dois.
	 *
	 * @return the ma so theo dois
	 */
	@Override
	public List<MaSoTheoDoi> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ma so theo dois.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MaSoTheoDoiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ma so theo dois
	 * @param end the upper bound of the range of ma so theo dois (not inclusive)
	 * @return the range of ma so theo dois
	 */
	@Override
	public List<MaSoTheoDoi> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ma so theo dois.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MaSoTheoDoiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ma so theo dois
	 * @param end the upper bound of the range of ma so theo dois (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ma so theo dois
	 */
	@Override
	public List<MaSoTheoDoi> findAll(
		int start, int end, OrderByComparator<MaSoTheoDoi> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ma so theo dois.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MaSoTheoDoiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ma so theo dois
	 * @param end the upper bound of the range of ma so theo dois (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of ma so theo dois
	 */
	@Override
	public List<MaSoTheoDoi> findAll(
		int start, int end, OrderByComparator<MaSoTheoDoi> orderByComparator,
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

		List<MaSoTheoDoi> list = null;

		if (retrieveFromCache) {
			list = (List<MaSoTheoDoi>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_MASOTHEODOI);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MASOTHEODOI;

				if (pagination) {
					sql = sql.concat(MaSoTheoDoiModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<MaSoTheoDoi>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<MaSoTheoDoi>)QueryUtil.list(
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
	 * Removes all the ma so theo dois from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (MaSoTheoDoi maSoTheoDoi : findAll()) {
			remove(maSoTheoDoi);
		}
	}

	/**
	 * Returns the number of ma so theo dois.
	 *
	 * @return the number of ma so theo dois
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_MASOTHEODOI);

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
		return MaSoTheoDoiModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the ma so theo doi persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			MaSoTheoDoiModelImpl.ENTITY_CACHE_ENABLED,
			MaSoTheoDoiModelImpl.FINDER_CACHE_ENABLED, MaSoTheoDoiImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			MaSoTheoDoiModelImpl.ENTITY_CACHE_ENABLED,
			MaSoTheoDoiModelImpl.FINDER_CACHE_ENABLED, MaSoTheoDoiImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			MaSoTheoDoiModelImpl.ENTITY_CACHE_ENABLED,
			MaSoTheoDoiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByMa = new FinderPath(
			MaSoTheoDoiModelImpl.ENTITY_CACHE_ENABLED,
			MaSoTheoDoiModelImpl.FINDER_CACHE_ENABLED, MaSoTheoDoiImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByMa",
			new String[] {String.class.getName()},
			MaSoTheoDoiModelImpl.MA_COLUMN_BITMASK);

		_finderPathCountByMa = new FinderPath(
			MaSoTheoDoiModelImpl.ENTITY_CACHE_ENABLED,
			MaSoTheoDoiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMa",
			new String[] {String.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(MaSoTheoDoiImpl.class.getName());
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

	private static final String _SQL_SELECT_MASOTHEODOI =
		"SELECT maSoTheoDoi FROM MaSoTheoDoi maSoTheoDoi";

	private static final String _SQL_SELECT_MASOTHEODOI_WHERE_PKS_IN =
		"SELECT maSoTheoDoi FROM MaSoTheoDoi maSoTheoDoi WHERE maSoTheoDoiId IN (";

	private static final String _SQL_SELECT_MASOTHEODOI_WHERE =
		"SELECT maSoTheoDoi FROM MaSoTheoDoi maSoTheoDoi WHERE ";

	private static final String _SQL_COUNT_MASOTHEODOI =
		"SELECT COUNT(maSoTheoDoi) FROM MaSoTheoDoi maSoTheoDoi";

	private static final String _SQL_COUNT_MASOTHEODOI_WHERE =
		"SELECT COUNT(maSoTheoDoi) FROM MaSoTheoDoi maSoTheoDoi WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "maSoTheoDoi.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No MaSoTheoDoi exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No MaSoTheoDoi exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		MaSoTheoDoiPersistenceImpl.class);

}