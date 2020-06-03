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

import com.mb.model.Phieu;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the phieu service. This utility wraps <code>com.mb.service.persistence.impl.PhieuPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PhieuPersistence
 * @generated
 */
@ProviderType
public class PhieuUtil {

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
	public static void clearCache(Phieu phieu) {
		getPersistence().clearCache(phieu);
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
	public static Map<Serializable, Phieu> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Phieu> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Phieu> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Phieu> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Phieu> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Phieu update(Phieu phieu) {
		return getPersistence().update(phieu);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Phieu update(Phieu phieu, ServiceContext serviceContext) {
		return getPersistence().update(phieu, serviceContext);
	}

	/**
	 * Caches the phieu in the entity cache if it is enabled.
	 *
	 * @param phieu the phieu
	 */
	public static void cacheResult(Phieu phieu) {
		getPersistence().cacheResult(phieu);
	}

	/**
	 * Caches the phieus in the entity cache if it is enabled.
	 *
	 * @param phieus the phieus
	 */
	public static void cacheResult(List<Phieu> phieus) {
		getPersistence().cacheResult(phieus);
	}

	/**
	 * Creates a new phieu with the primary key. Does not add the phieu to the database.
	 *
	 * @param phieuId the primary key for the new phieu
	 * @return the new phieu
	 */
	public static Phieu create(long phieuId) {
		return getPersistence().create(phieuId);
	}

	/**
	 * Removes the phieu with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param phieuId the primary key of the phieu
	 * @return the phieu that was removed
	 * @throws NoSuchPhieuException if a phieu with the primary key could not be found
	 */
	public static Phieu remove(long phieuId)
		throws com.mb.exception.NoSuchPhieuException {

		return getPersistence().remove(phieuId);
	}

	public static Phieu updateImpl(Phieu phieu) {
		return getPersistence().updateImpl(phieu);
	}

	/**
	 * Returns the phieu with the primary key or throws a <code>NoSuchPhieuException</code> if it could not be found.
	 *
	 * @param phieuId the primary key of the phieu
	 * @return the phieu
	 * @throws NoSuchPhieuException if a phieu with the primary key could not be found
	 */
	public static Phieu findByPrimaryKey(long phieuId)
		throws com.mb.exception.NoSuchPhieuException {

		return getPersistence().findByPrimaryKey(phieuId);
	}

	/**
	 * Returns the phieu with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param phieuId the primary key of the phieu
	 * @return the phieu, or <code>null</code> if a phieu with the primary key could not be found
	 */
	public static Phieu fetchByPrimaryKey(long phieuId) {
		return getPersistence().fetchByPrimaryKey(phieuId);
	}

	/**
	 * Returns all the phieus.
	 *
	 * @return the phieus
	 */
	public static List<Phieu> findAll() {
		return getPersistence().findAll();
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
	public static List<Phieu> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<Phieu> findAll(
		int start, int end, OrderByComparator<Phieu> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<Phieu> findAll(
		int start, int end, OrderByComparator<Phieu> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the phieus from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of phieus.
	 *
	 * @return the number of phieus
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PhieuPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PhieuPersistence, PhieuPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PhieuPersistence.class);

		ServiceTracker<PhieuPersistence, PhieuPersistence> serviceTracker =
			new ServiceTracker<PhieuPersistence, PhieuPersistence>(
				bundle.getBundleContext(), PhieuPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}