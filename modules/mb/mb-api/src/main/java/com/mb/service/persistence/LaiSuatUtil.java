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

import com.mb.model.LaiSuat;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the lai suat service. This utility wraps <code>com.mb.service.persistence.impl.LaiSuatPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LaiSuatPersistence
 * @generated
 */
@ProviderType
public class LaiSuatUtil {

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
	public static void clearCache(LaiSuat laiSuat) {
		getPersistence().clearCache(laiSuat);
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
	public static Map<Serializable, LaiSuat> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LaiSuat> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LaiSuat> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LaiSuat> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LaiSuat> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LaiSuat update(LaiSuat laiSuat) {
		return getPersistence().update(laiSuat);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LaiSuat update(
		LaiSuat laiSuat, ServiceContext serviceContext) {

		return getPersistence().update(laiSuat, serviceContext);
	}

	/**
	 * Returns the lai suat where soTienVay = &#63; and thoiHan = &#63; or throws a <code>NoSuchLaiSuatException</code> if it could not be found.
	 *
	 * @param soTienVay the so tien vay
	 * @param thoiHan the thoi han
	 * @return the matching lai suat
	 * @throws NoSuchLaiSuatException if a matching lai suat could not be found
	 */
	public static LaiSuat findBySoTienVay_ThoiHan(Double soTienVay, int thoiHan)
		throws com.mb.exception.NoSuchLaiSuatException {

		return getPersistence().findBySoTienVay_ThoiHan(soTienVay, thoiHan);
	}

	/**
	 * Returns the lai suat where soTienVay = &#63; and thoiHan = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param soTienVay the so tien vay
	 * @param thoiHan the thoi han
	 * @return the matching lai suat, or <code>null</code> if a matching lai suat could not be found
	 */
	public static LaiSuat fetchBySoTienVay_ThoiHan(
		Double soTienVay, int thoiHan) {

		return getPersistence().fetchBySoTienVay_ThoiHan(soTienVay, thoiHan);
	}

	/**
	 * Returns the lai suat where soTienVay = &#63; and thoiHan = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param soTienVay the so tien vay
	 * @param thoiHan the thoi han
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching lai suat, or <code>null</code> if a matching lai suat could not be found
	 */
	public static LaiSuat fetchBySoTienVay_ThoiHan(
		Double soTienVay, int thoiHan, boolean retrieveFromCache) {

		return getPersistence().fetchBySoTienVay_ThoiHan(
			soTienVay, thoiHan, retrieveFromCache);
	}

	/**
	 * Removes the lai suat where soTienVay = &#63; and thoiHan = &#63; from the database.
	 *
	 * @param soTienVay the so tien vay
	 * @param thoiHan the thoi han
	 * @return the lai suat that was removed
	 */
	public static LaiSuat removeBySoTienVay_ThoiHan(
			Double soTienVay, int thoiHan)
		throws com.mb.exception.NoSuchLaiSuatException {

		return getPersistence().removeBySoTienVay_ThoiHan(soTienVay, thoiHan);
	}

	/**
	 * Returns the number of lai suats where soTienVay = &#63; and thoiHan = &#63;.
	 *
	 * @param soTienVay the so tien vay
	 * @param thoiHan the thoi han
	 * @return the number of matching lai suats
	 */
	public static int countBySoTienVay_ThoiHan(Double soTienVay, int thoiHan) {
		return getPersistence().countBySoTienVay_ThoiHan(soTienVay, thoiHan);
	}

	/**
	 * Caches the lai suat in the entity cache if it is enabled.
	 *
	 * @param laiSuat the lai suat
	 */
	public static void cacheResult(LaiSuat laiSuat) {
		getPersistence().cacheResult(laiSuat);
	}

	/**
	 * Caches the lai suats in the entity cache if it is enabled.
	 *
	 * @param laiSuats the lai suats
	 */
	public static void cacheResult(List<LaiSuat> laiSuats) {
		getPersistence().cacheResult(laiSuats);
	}

	/**
	 * Creates a new lai suat with the primary key. Does not add the lai suat to the database.
	 *
	 * @param laiSuatId the primary key for the new lai suat
	 * @return the new lai suat
	 */
	public static LaiSuat create(long laiSuatId) {
		return getPersistence().create(laiSuatId);
	}

	/**
	 * Removes the lai suat with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param laiSuatId the primary key of the lai suat
	 * @return the lai suat that was removed
	 * @throws NoSuchLaiSuatException if a lai suat with the primary key could not be found
	 */
	public static LaiSuat remove(long laiSuatId)
		throws com.mb.exception.NoSuchLaiSuatException {

		return getPersistence().remove(laiSuatId);
	}

	public static LaiSuat updateImpl(LaiSuat laiSuat) {
		return getPersistence().updateImpl(laiSuat);
	}

	/**
	 * Returns the lai suat with the primary key or throws a <code>NoSuchLaiSuatException</code> if it could not be found.
	 *
	 * @param laiSuatId the primary key of the lai suat
	 * @return the lai suat
	 * @throws NoSuchLaiSuatException if a lai suat with the primary key could not be found
	 */
	public static LaiSuat findByPrimaryKey(long laiSuatId)
		throws com.mb.exception.NoSuchLaiSuatException {

		return getPersistence().findByPrimaryKey(laiSuatId);
	}

	/**
	 * Returns the lai suat with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param laiSuatId the primary key of the lai suat
	 * @return the lai suat, or <code>null</code> if a lai suat with the primary key could not be found
	 */
	public static LaiSuat fetchByPrimaryKey(long laiSuatId) {
		return getPersistence().fetchByPrimaryKey(laiSuatId);
	}

	/**
	 * Returns all the lai suats.
	 *
	 * @return the lai suats
	 */
	public static List<LaiSuat> findAll() {
		return getPersistence().findAll();
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
	public static List<LaiSuat> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<LaiSuat> findAll(
		int start, int end, OrderByComparator<LaiSuat> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<LaiSuat> findAll(
		int start, int end, OrderByComparator<LaiSuat> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the lai suats from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of lai suats.
	 *
	 * @return the number of lai suats
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LaiSuatPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LaiSuatPersistence, LaiSuatPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LaiSuatPersistence.class);

		ServiceTracker<LaiSuatPersistence, LaiSuatPersistence> serviceTracker =
			new ServiceTracker<LaiSuatPersistence, LaiSuatPersistence>(
				bundle.getBundleContext(), LaiSuatPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}