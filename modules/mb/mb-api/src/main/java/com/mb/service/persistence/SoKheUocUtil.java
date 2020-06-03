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

import com.mb.model.SoKheUoc;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the so khe uoc service. This utility wraps <code>com.mb.service.persistence.impl.SoKheUocPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SoKheUocPersistence
 * @generated
 */
@ProviderType
public class SoKheUocUtil {

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
	public static void clearCache(SoKheUoc soKheUoc) {
		getPersistence().clearCache(soKheUoc);
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
	public static Map<Serializable, SoKheUoc> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SoKheUoc> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SoKheUoc> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SoKheUoc> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SoKheUoc> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SoKheUoc update(SoKheUoc soKheUoc) {
		return getPersistence().update(soKheUoc);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SoKheUoc update(
		SoKheUoc soKheUoc, ServiceContext serviceContext) {

		return getPersistence().update(soKheUoc, serviceContext);
	}

	/**
	 * Returns the so khe uoc where cauTruc = &#63; or throws a <code>NoSuchSoKheUocException</code> if it could not be found.
	 *
	 * @param cauTruc the cau truc
	 * @return the matching so khe uoc
	 * @throws NoSuchSoKheUocException if a matching so khe uoc could not be found
	 */
	public static SoKheUoc findByCauTruc(String cauTruc)
		throws com.mb.exception.NoSuchSoKheUocException {

		return getPersistence().findByCauTruc(cauTruc);
	}

	/**
	 * Returns the so khe uoc where cauTruc = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param cauTruc the cau truc
	 * @return the matching so khe uoc, or <code>null</code> if a matching so khe uoc could not be found
	 */
	public static SoKheUoc fetchByCauTruc(String cauTruc) {
		return getPersistence().fetchByCauTruc(cauTruc);
	}

	/**
	 * Returns the so khe uoc where cauTruc = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param cauTruc the cau truc
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching so khe uoc, or <code>null</code> if a matching so khe uoc could not be found
	 */
	public static SoKheUoc fetchByCauTruc(
		String cauTruc, boolean retrieveFromCache) {

		return getPersistence().fetchByCauTruc(cauTruc, retrieveFromCache);
	}

	/**
	 * Removes the so khe uoc where cauTruc = &#63; from the database.
	 *
	 * @param cauTruc the cau truc
	 * @return the so khe uoc that was removed
	 */
	public static SoKheUoc removeByCauTruc(String cauTruc)
		throws com.mb.exception.NoSuchSoKheUocException {

		return getPersistence().removeByCauTruc(cauTruc);
	}

	/**
	 * Returns the number of so khe uocs where cauTruc = &#63;.
	 *
	 * @param cauTruc the cau truc
	 * @return the number of matching so khe uocs
	 */
	public static int countByCauTruc(String cauTruc) {
		return getPersistence().countByCauTruc(cauTruc);
	}

	/**
	 * Caches the so khe uoc in the entity cache if it is enabled.
	 *
	 * @param soKheUoc the so khe uoc
	 */
	public static void cacheResult(SoKheUoc soKheUoc) {
		getPersistence().cacheResult(soKheUoc);
	}

	/**
	 * Caches the so khe uocs in the entity cache if it is enabled.
	 *
	 * @param soKheUocs the so khe uocs
	 */
	public static void cacheResult(List<SoKheUoc> soKheUocs) {
		getPersistence().cacheResult(soKheUocs);
	}

	/**
	 * Creates a new so khe uoc with the primary key. Does not add the so khe uoc to the database.
	 *
	 * @param soKheUocId the primary key for the new so khe uoc
	 * @return the new so khe uoc
	 */
	public static SoKheUoc create(long soKheUocId) {
		return getPersistence().create(soKheUocId);
	}

	/**
	 * Removes the so khe uoc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param soKheUocId the primary key of the so khe uoc
	 * @return the so khe uoc that was removed
	 * @throws NoSuchSoKheUocException if a so khe uoc with the primary key could not be found
	 */
	public static SoKheUoc remove(long soKheUocId)
		throws com.mb.exception.NoSuchSoKheUocException {

		return getPersistence().remove(soKheUocId);
	}

	public static SoKheUoc updateImpl(SoKheUoc soKheUoc) {
		return getPersistence().updateImpl(soKheUoc);
	}

	/**
	 * Returns the so khe uoc with the primary key or throws a <code>NoSuchSoKheUocException</code> if it could not be found.
	 *
	 * @param soKheUocId the primary key of the so khe uoc
	 * @return the so khe uoc
	 * @throws NoSuchSoKheUocException if a so khe uoc with the primary key could not be found
	 */
	public static SoKheUoc findByPrimaryKey(long soKheUocId)
		throws com.mb.exception.NoSuchSoKheUocException {

		return getPersistence().findByPrimaryKey(soKheUocId);
	}

	/**
	 * Returns the so khe uoc with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param soKheUocId the primary key of the so khe uoc
	 * @return the so khe uoc, or <code>null</code> if a so khe uoc with the primary key could not be found
	 */
	public static SoKheUoc fetchByPrimaryKey(long soKheUocId) {
		return getPersistence().fetchByPrimaryKey(soKheUocId);
	}

	/**
	 * Returns all the so khe uocs.
	 *
	 * @return the so khe uocs
	 */
	public static List<SoKheUoc> findAll() {
		return getPersistence().findAll();
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
	public static List<SoKheUoc> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<SoKheUoc> findAll(
		int start, int end, OrderByComparator<SoKheUoc> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<SoKheUoc> findAll(
		int start, int end, OrderByComparator<SoKheUoc> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the so khe uocs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of so khe uocs.
	 *
	 * @return the number of so khe uocs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SoKheUocPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SoKheUocPersistence, SoKheUocPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SoKheUocPersistence.class);

		ServiceTracker<SoKheUocPersistence, SoKheUocPersistence>
			serviceTracker =
				new ServiceTracker<SoKheUocPersistence, SoKheUocPersistence>(
					bundle.getBundleContext(), SoKheUocPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}