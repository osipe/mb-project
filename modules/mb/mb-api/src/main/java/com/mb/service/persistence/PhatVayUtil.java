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

import com.mb.model.PhatVay;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the phat vay service. This utility wraps <code>com.mb.service.persistence.impl.PhatVayPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PhatVayPersistence
 * @generated
 */
@ProviderType
public class PhatVayUtil {

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
	public static void clearCache(PhatVay phatVay) {
		getPersistence().clearCache(phatVay);
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
	public static Map<Serializable, PhatVay> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PhatVay> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PhatVay> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PhatVay> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PhatVay> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PhatVay update(PhatVay phatVay) {
		return getPersistence().update(phatVay);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PhatVay update(
		PhatVay phatVay, ServiceContext serviceContext) {

		return getPersistence().update(phatVay, serviceContext);
	}

	/**
	 * Returns all the phat vaies where maCTV = &#63;.
	 *
	 * @param maCTV the ma ctv
	 * @return the matching phat vaies
	 */
	public static List<PhatVay> findByMaCTV(String maCTV) {
		return getPersistence().findByMaCTV(maCTV);
	}

	/**
	 * Returns a range of all the phat vaies where maCTV = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PhatVayModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param maCTV the ma ctv
	 * @param start the lower bound of the range of phat vaies
	 * @param end the upper bound of the range of phat vaies (not inclusive)
	 * @return the range of matching phat vaies
	 */
	public static List<PhatVay> findByMaCTV(String maCTV, int start, int end) {
		return getPersistence().findByMaCTV(maCTV, start, end);
	}

	/**
	 * Returns an ordered range of all the phat vaies where maCTV = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PhatVayModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param maCTV the ma ctv
	 * @param start the lower bound of the range of phat vaies
	 * @param end the upper bound of the range of phat vaies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching phat vaies
	 */
	public static List<PhatVay> findByMaCTV(
		String maCTV, int start, int end,
		OrderByComparator<PhatVay> orderByComparator) {

		return getPersistence().findByMaCTV(
			maCTV, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the phat vaies where maCTV = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PhatVayModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param maCTV the ma ctv
	 * @param start the lower bound of the range of phat vaies
	 * @param end the upper bound of the range of phat vaies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching phat vaies
	 */
	public static List<PhatVay> findByMaCTV(
		String maCTV, int start, int end,
		OrderByComparator<PhatVay> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByMaCTV(
			maCTV, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first phat vay in the ordered set where maCTV = &#63;.
	 *
	 * @param maCTV the ma ctv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phat vay
	 * @throws NoSuchPhatVayException if a matching phat vay could not be found
	 */
	public static PhatVay findByMaCTV_First(
			String maCTV, OrderByComparator<PhatVay> orderByComparator)
		throws com.mb.exception.NoSuchPhatVayException {

		return getPersistence().findByMaCTV_First(maCTV, orderByComparator);
	}

	/**
	 * Returns the first phat vay in the ordered set where maCTV = &#63;.
	 *
	 * @param maCTV the ma ctv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phat vay, or <code>null</code> if a matching phat vay could not be found
	 */
	public static PhatVay fetchByMaCTV_First(
		String maCTV, OrderByComparator<PhatVay> orderByComparator) {

		return getPersistence().fetchByMaCTV_First(maCTV, orderByComparator);
	}

	/**
	 * Returns the last phat vay in the ordered set where maCTV = &#63;.
	 *
	 * @param maCTV the ma ctv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phat vay
	 * @throws NoSuchPhatVayException if a matching phat vay could not be found
	 */
	public static PhatVay findByMaCTV_Last(
			String maCTV, OrderByComparator<PhatVay> orderByComparator)
		throws com.mb.exception.NoSuchPhatVayException {

		return getPersistence().findByMaCTV_Last(maCTV, orderByComparator);
	}

	/**
	 * Returns the last phat vay in the ordered set where maCTV = &#63;.
	 *
	 * @param maCTV the ma ctv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phat vay, or <code>null</code> if a matching phat vay could not be found
	 */
	public static PhatVay fetchByMaCTV_Last(
		String maCTV, OrderByComparator<PhatVay> orderByComparator) {

		return getPersistence().fetchByMaCTV_Last(maCTV, orderByComparator);
	}

	/**
	 * Returns the phat vaies before and after the current phat vay in the ordered set where maCTV = &#63;.
	 *
	 * @param phatVayId the primary key of the current phat vay
	 * @param maCTV the ma ctv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next phat vay
	 * @throws NoSuchPhatVayException if a phat vay with the primary key could not be found
	 */
	public static PhatVay[] findByMaCTV_PrevAndNext(
			long phatVayId, String maCTV,
			OrderByComparator<PhatVay> orderByComparator)
		throws com.mb.exception.NoSuchPhatVayException {

		return getPersistence().findByMaCTV_PrevAndNext(
			phatVayId, maCTV, orderByComparator);
	}

	/**
	 * Removes all the phat vaies where maCTV = &#63; from the database.
	 *
	 * @param maCTV the ma ctv
	 */
	public static void removeByMaCTV(String maCTV) {
		getPersistence().removeByMaCTV(maCTV);
	}

	/**
	 * Returns the number of phat vaies where maCTV = &#63;.
	 *
	 * @param maCTV the ma ctv
	 * @return the number of matching phat vaies
	 */
	public static int countByMaCTV(String maCTV) {
		return getPersistence().countByMaCTV(maCTV);
	}

	/**
	 * Returns the phat vay where soKU = &#63; or throws a <code>NoSuchPhatVayException</code> if it could not be found.
	 *
	 * @param soKU the so ku
	 * @return the matching phat vay
	 * @throws NoSuchPhatVayException if a matching phat vay could not be found
	 */
	public static PhatVay findBySoKU(String soKU)
		throws com.mb.exception.NoSuchPhatVayException {

		return getPersistence().findBySoKU(soKU);
	}

	/**
	 * Returns the phat vay where soKU = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param soKU the so ku
	 * @return the matching phat vay, or <code>null</code> if a matching phat vay could not be found
	 */
	public static PhatVay fetchBySoKU(String soKU) {
		return getPersistence().fetchBySoKU(soKU);
	}

	/**
	 * Returns the phat vay where soKU = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param soKU the so ku
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching phat vay, or <code>null</code> if a matching phat vay could not be found
	 */
	public static PhatVay fetchBySoKU(String soKU, boolean retrieveFromCache) {
		return getPersistence().fetchBySoKU(soKU, retrieveFromCache);
	}

	/**
	 * Removes the phat vay where soKU = &#63; from the database.
	 *
	 * @param soKU the so ku
	 * @return the phat vay that was removed
	 */
	public static PhatVay removeBySoKU(String soKU)
		throws com.mb.exception.NoSuchPhatVayException {

		return getPersistence().removeBySoKU(soKU);
	}

	/**
	 * Returns the number of phat vaies where soKU = &#63;.
	 *
	 * @param soKU the so ku
	 * @return the number of matching phat vaies
	 */
	public static int countBySoKU(String soKU) {
		return getPersistence().countBySoKU(soKU);
	}

	/**
	 * Caches the phat vay in the entity cache if it is enabled.
	 *
	 * @param phatVay the phat vay
	 */
	public static void cacheResult(PhatVay phatVay) {
		getPersistence().cacheResult(phatVay);
	}

	/**
	 * Caches the phat vaies in the entity cache if it is enabled.
	 *
	 * @param phatVaies the phat vaies
	 */
	public static void cacheResult(List<PhatVay> phatVaies) {
		getPersistence().cacheResult(phatVaies);
	}

	/**
	 * Creates a new phat vay with the primary key. Does not add the phat vay to the database.
	 *
	 * @param phatVayId the primary key for the new phat vay
	 * @return the new phat vay
	 */
	public static PhatVay create(long phatVayId) {
		return getPersistence().create(phatVayId);
	}

	/**
	 * Removes the phat vay with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param phatVayId the primary key of the phat vay
	 * @return the phat vay that was removed
	 * @throws NoSuchPhatVayException if a phat vay with the primary key could not be found
	 */
	public static PhatVay remove(long phatVayId)
		throws com.mb.exception.NoSuchPhatVayException {

		return getPersistence().remove(phatVayId);
	}

	public static PhatVay updateImpl(PhatVay phatVay) {
		return getPersistence().updateImpl(phatVay);
	}

	/**
	 * Returns the phat vay with the primary key or throws a <code>NoSuchPhatVayException</code> if it could not be found.
	 *
	 * @param phatVayId the primary key of the phat vay
	 * @return the phat vay
	 * @throws NoSuchPhatVayException if a phat vay with the primary key could not be found
	 */
	public static PhatVay findByPrimaryKey(long phatVayId)
		throws com.mb.exception.NoSuchPhatVayException {

		return getPersistence().findByPrimaryKey(phatVayId);
	}

	/**
	 * Returns the phat vay with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param phatVayId the primary key of the phat vay
	 * @return the phat vay, or <code>null</code> if a phat vay with the primary key could not be found
	 */
	public static PhatVay fetchByPrimaryKey(long phatVayId) {
		return getPersistence().fetchByPrimaryKey(phatVayId);
	}

	/**
	 * Returns all the phat vaies.
	 *
	 * @return the phat vaies
	 */
	public static List<PhatVay> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the phat vaies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PhatVayModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of phat vaies
	 * @param end the upper bound of the range of phat vaies (not inclusive)
	 * @return the range of phat vaies
	 */
	public static List<PhatVay> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the phat vaies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PhatVayModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of phat vaies
	 * @param end the upper bound of the range of phat vaies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of phat vaies
	 */
	public static List<PhatVay> findAll(
		int start, int end, OrderByComparator<PhatVay> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the phat vaies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PhatVayModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of phat vaies
	 * @param end the upper bound of the range of phat vaies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of phat vaies
	 */
	public static List<PhatVay> findAll(
		int start, int end, OrderByComparator<PhatVay> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the phat vaies from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of phat vaies.
	 *
	 * @return the number of phat vaies
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PhatVayPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PhatVayPersistence, PhatVayPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PhatVayPersistence.class);

		ServiceTracker<PhatVayPersistence, PhatVayPersistence> serviceTracker =
			new ServiceTracker<PhatVayPersistence, PhatVayPersistence>(
				bundle.getBundleContext(), PhatVayPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}