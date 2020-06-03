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

package com.mb.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.mb.model.QuanLyMaSo;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the quan ly ma so service. This utility wraps <code>com.mb.service.persistence.impl.QuanLyMaSoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuanLyMaSoPersistence
 * @generated
 */
@ProviderType
public class QuanLyMaSoUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(QuanLyMaSo quanLyMaSo) {
		getPersistence().clearCache(quanLyMaSo);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, QuanLyMaSo> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<QuanLyMaSo> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<QuanLyMaSo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<QuanLyMaSo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<QuanLyMaSo> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static QuanLyMaSo update(QuanLyMaSo quanLyMaSo) {
		return getPersistence().update(quanLyMaSo);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static QuanLyMaSo update(
		QuanLyMaSo quanLyMaSo, ServiceContext serviceContext) {

		return getPersistence().update(quanLyMaSo, serviceContext);
	}

	/**
	 * Returns the quan ly ma so where key = &#63; or throws a <code>NoSuchQuanLyMaSoException</code> if it could not be found.
	 *
	 * @param key the key
	 * @return the matching quan ly ma so
	 * @throws NoSuchQuanLyMaSoException if a matching quan ly ma so could not be found
	 */
	public static QuanLyMaSo findByKey(String key)
		throws com.mb.exception.NoSuchQuanLyMaSoException {

		return getPersistence().findByKey(key);
	}

	/**
	 * Returns the quan ly ma so where key = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param key the key
	 * @return the matching quan ly ma so, or <code>null</code> if a matching quan ly ma so could not be found
	 */
	public static QuanLyMaSo fetchByKey(String key) {
		return getPersistence().fetchByKey(key);
	}

	/**
	 * Returns the quan ly ma so where key = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param key the key
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching quan ly ma so, or <code>null</code> if a matching quan ly ma so could not be found
	 */
	public static QuanLyMaSo fetchByKey(String key, boolean retrieveFromCache) {
		return getPersistence().fetchByKey(key, retrieveFromCache);
	}

	/**
	 * Removes the quan ly ma so where key = &#63; from the database.
	 *
	 * @param key the key
	 * @return the quan ly ma so that was removed
	 */
	public static QuanLyMaSo removeByKey(String key)
		throws com.mb.exception.NoSuchQuanLyMaSoException {

		return getPersistence().removeByKey(key);
	}

	/**
	 * Returns the number of quan ly ma sos where key = &#63;.
	 *
	 * @param key the key
	 * @return the number of matching quan ly ma sos
	 */
	public static int countByKey(String key) {
		return getPersistence().countByKey(key);
	}

	/**
	 * Caches the quan ly ma so in the entity cache if it is enabled.
	 *
	 * @param quanLyMaSo the quan ly ma so
	 */
	public static void cacheResult(QuanLyMaSo quanLyMaSo) {
		getPersistence().cacheResult(quanLyMaSo);
	}

	/**
	 * Caches the quan ly ma sos in the entity cache if it is enabled.
	 *
	 * @param quanLyMaSos the quan ly ma sos
	 */
	public static void cacheResult(List<QuanLyMaSo> quanLyMaSos) {
		getPersistence().cacheResult(quanLyMaSos);
	}

	/**
	 * Creates a new quan ly ma so with the primary key. Does not add the quan ly ma so to the database.
	 *
	 * @param quanLyMaSoId the primary key for the new quan ly ma so
	 * @return the new quan ly ma so
	 */
	public static QuanLyMaSo create(long quanLyMaSoId) {
		return getPersistence().create(quanLyMaSoId);
	}

	/**
	 * Removes the quan ly ma so with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param quanLyMaSoId the primary key of the quan ly ma so
	 * @return the quan ly ma so that was removed
	 * @throws NoSuchQuanLyMaSoException if a quan ly ma so with the primary key could not be found
	 */
	public static QuanLyMaSo remove(long quanLyMaSoId)
		throws com.mb.exception.NoSuchQuanLyMaSoException {

		return getPersistence().remove(quanLyMaSoId);
	}

	public static QuanLyMaSo updateImpl(QuanLyMaSo quanLyMaSo) {
		return getPersistence().updateImpl(quanLyMaSo);
	}

	/**
	 * Returns the quan ly ma so with the primary key or throws a <code>NoSuchQuanLyMaSoException</code> if it could not be found.
	 *
	 * @param quanLyMaSoId the primary key of the quan ly ma so
	 * @return the quan ly ma so
	 * @throws NoSuchQuanLyMaSoException if a quan ly ma so with the primary key could not be found
	 */
	public static QuanLyMaSo findByPrimaryKey(long quanLyMaSoId)
		throws com.mb.exception.NoSuchQuanLyMaSoException {

		return getPersistence().findByPrimaryKey(quanLyMaSoId);
	}

	/**
	 * Returns the quan ly ma so with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param quanLyMaSoId the primary key of the quan ly ma so
	 * @return the quan ly ma so, or <code>null</code> if a quan ly ma so with the primary key could not be found
	 */
	public static QuanLyMaSo fetchByPrimaryKey(long quanLyMaSoId) {
		return getPersistence().fetchByPrimaryKey(quanLyMaSoId);
	}

	/**
	 * Returns all the quan ly ma sos.
	 *
	 * @return the quan ly ma sos
	 */
	public static List<QuanLyMaSo> findAll() {
		return getPersistence().findAll();
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
	public static List<QuanLyMaSo> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<QuanLyMaSo> findAll(
		int start, int end, OrderByComparator<QuanLyMaSo> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<QuanLyMaSo> findAll(
		int start, int end, OrderByComparator<QuanLyMaSo> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the quan ly ma sos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of quan ly ma sos.
	 *
	 * @return the number of quan ly ma sos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static QuanLyMaSoPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<QuanLyMaSoPersistence, QuanLyMaSoPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(QuanLyMaSoPersistence.class);

		ServiceTracker<QuanLyMaSoPersistence, QuanLyMaSoPersistence>
			serviceTracker =
				new ServiceTracker
					<QuanLyMaSoPersistence, QuanLyMaSoPersistence>(
						bundle.getBundleContext(), QuanLyMaSoPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}