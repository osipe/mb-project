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

import com.mb.model.TaiSanThueChap;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the tai san thue chap service. This utility wraps <code>com.mb.service.persistence.impl.TaiSanThueChapPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaiSanThueChapPersistence
 * @generated
 */
@ProviderType
public class TaiSanThueChapUtil {

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
	public static void clearCache(TaiSanThueChap taiSanThueChap) {
		getPersistence().clearCache(taiSanThueChap);
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
	public static Map<Serializable, TaiSanThueChap> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TaiSanThueChap> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TaiSanThueChap> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TaiSanThueChap> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TaiSanThueChap> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TaiSanThueChap update(TaiSanThueChap taiSanThueChap) {
		return getPersistence().update(taiSanThueChap);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TaiSanThueChap update(
		TaiSanThueChap taiSanThueChap, ServiceContext serviceContext) {

		return getPersistence().update(taiSanThueChap, serviceContext);
	}

	/**
	 * Returns all the tai san thue chaps where phatVayId = &#63;.
	 *
	 * @param phatVayId the phat vay ID
	 * @return the matching tai san thue chaps
	 */
	public static List<TaiSanThueChap> findByPhatVayId(long phatVayId) {
		return getPersistence().findByPhatVayId(phatVayId);
	}

	/**
	 * Returns a range of all the tai san thue chaps where phatVayId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaiSanThueChapModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phatVayId the phat vay ID
	 * @param start the lower bound of the range of tai san thue chaps
	 * @param end the upper bound of the range of tai san thue chaps (not inclusive)
	 * @return the range of matching tai san thue chaps
	 */
	public static List<TaiSanThueChap> findByPhatVayId(
		long phatVayId, int start, int end) {

		return getPersistence().findByPhatVayId(phatVayId, start, end);
	}

	/**
	 * Returns an ordered range of all the tai san thue chaps where phatVayId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaiSanThueChapModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phatVayId the phat vay ID
	 * @param start the lower bound of the range of tai san thue chaps
	 * @param end the upper bound of the range of tai san thue chaps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tai san thue chaps
	 */
	public static List<TaiSanThueChap> findByPhatVayId(
		long phatVayId, int start, int end,
		OrderByComparator<TaiSanThueChap> orderByComparator) {

		return getPersistence().findByPhatVayId(
			phatVayId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the tai san thue chaps where phatVayId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaiSanThueChapModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phatVayId the phat vay ID
	 * @param start the lower bound of the range of tai san thue chaps
	 * @param end the upper bound of the range of tai san thue chaps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching tai san thue chaps
	 */
	public static List<TaiSanThueChap> findByPhatVayId(
		long phatVayId, int start, int end,
		OrderByComparator<TaiSanThueChap> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByPhatVayId(
			phatVayId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first tai san thue chap in the ordered set where phatVayId = &#63;.
	 *
	 * @param phatVayId the phat vay ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tai san thue chap
	 * @throws NoSuchTaiSanThueChapException if a matching tai san thue chap could not be found
	 */
	public static TaiSanThueChap findByPhatVayId_First(
			long phatVayId, OrderByComparator<TaiSanThueChap> orderByComparator)
		throws com.mb.exception.NoSuchTaiSanThueChapException {

		return getPersistence().findByPhatVayId_First(
			phatVayId, orderByComparator);
	}

	/**
	 * Returns the first tai san thue chap in the ordered set where phatVayId = &#63;.
	 *
	 * @param phatVayId the phat vay ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tai san thue chap, or <code>null</code> if a matching tai san thue chap could not be found
	 */
	public static TaiSanThueChap fetchByPhatVayId_First(
		long phatVayId, OrderByComparator<TaiSanThueChap> orderByComparator) {

		return getPersistence().fetchByPhatVayId_First(
			phatVayId, orderByComparator);
	}

	/**
	 * Returns the last tai san thue chap in the ordered set where phatVayId = &#63;.
	 *
	 * @param phatVayId the phat vay ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tai san thue chap
	 * @throws NoSuchTaiSanThueChapException if a matching tai san thue chap could not be found
	 */
	public static TaiSanThueChap findByPhatVayId_Last(
			long phatVayId, OrderByComparator<TaiSanThueChap> orderByComparator)
		throws com.mb.exception.NoSuchTaiSanThueChapException {

		return getPersistence().findByPhatVayId_Last(
			phatVayId, orderByComparator);
	}

	/**
	 * Returns the last tai san thue chap in the ordered set where phatVayId = &#63;.
	 *
	 * @param phatVayId the phat vay ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tai san thue chap, or <code>null</code> if a matching tai san thue chap could not be found
	 */
	public static TaiSanThueChap fetchByPhatVayId_Last(
		long phatVayId, OrderByComparator<TaiSanThueChap> orderByComparator) {

		return getPersistence().fetchByPhatVayId_Last(
			phatVayId, orderByComparator);
	}

	/**
	 * Returns the tai san thue chaps before and after the current tai san thue chap in the ordered set where phatVayId = &#63;.
	 *
	 * @param taiSanThueChapId the primary key of the current tai san thue chap
	 * @param phatVayId the phat vay ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tai san thue chap
	 * @throws NoSuchTaiSanThueChapException if a tai san thue chap with the primary key could not be found
	 */
	public static TaiSanThueChap[] findByPhatVayId_PrevAndNext(
			long taiSanThueChapId, long phatVayId,
			OrderByComparator<TaiSanThueChap> orderByComparator)
		throws com.mb.exception.NoSuchTaiSanThueChapException {

		return getPersistence().findByPhatVayId_PrevAndNext(
			taiSanThueChapId, phatVayId, orderByComparator);
	}

	/**
	 * Removes all the tai san thue chaps where phatVayId = &#63; from the database.
	 *
	 * @param phatVayId the phat vay ID
	 */
	public static void removeByPhatVayId(long phatVayId) {
		getPersistence().removeByPhatVayId(phatVayId);
	}

	/**
	 * Returns the number of tai san thue chaps where phatVayId = &#63;.
	 *
	 * @param phatVayId the phat vay ID
	 * @return the number of matching tai san thue chaps
	 */
	public static int countByPhatVayId(long phatVayId) {
		return getPersistence().countByPhatVayId(phatVayId);
	}

	/**
	 * Caches the tai san thue chap in the entity cache if it is enabled.
	 *
	 * @param taiSanThueChap the tai san thue chap
	 */
	public static void cacheResult(TaiSanThueChap taiSanThueChap) {
		getPersistence().cacheResult(taiSanThueChap);
	}

	/**
	 * Caches the tai san thue chaps in the entity cache if it is enabled.
	 *
	 * @param taiSanThueChaps the tai san thue chaps
	 */
	public static void cacheResult(List<TaiSanThueChap> taiSanThueChaps) {
		getPersistence().cacheResult(taiSanThueChaps);
	}

	/**
	 * Creates a new tai san thue chap with the primary key. Does not add the tai san thue chap to the database.
	 *
	 * @param taiSanThueChapId the primary key for the new tai san thue chap
	 * @return the new tai san thue chap
	 */
	public static TaiSanThueChap create(long taiSanThueChapId) {
		return getPersistence().create(taiSanThueChapId);
	}

	/**
	 * Removes the tai san thue chap with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taiSanThueChapId the primary key of the tai san thue chap
	 * @return the tai san thue chap that was removed
	 * @throws NoSuchTaiSanThueChapException if a tai san thue chap with the primary key could not be found
	 */
	public static TaiSanThueChap remove(long taiSanThueChapId)
		throws com.mb.exception.NoSuchTaiSanThueChapException {

		return getPersistence().remove(taiSanThueChapId);
	}

	public static TaiSanThueChap updateImpl(TaiSanThueChap taiSanThueChap) {
		return getPersistence().updateImpl(taiSanThueChap);
	}

	/**
	 * Returns the tai san thue chap with the primary key or throws a <code>NoSuchTaiSanThueChapException</code> if it could not be found.
	 *
	 * @param taiSanThueChapId the primary key of the tai san thue chap
	 * @return the tai san thue chap
	 * @throws NoSuchTaiSanThueChapException if a tai san thue chap with the primary key could not be found
	 */
	public static TaiSanThueChap findByPrimaryKey(long taiSanThueChapId)
		throws com.mb.exception.NoSuchTaiSanThueChapException {

		return getPersistence().findByPrimaryKey(taiSanThueChapId);
	}

	/**
	 * Returns the tai san thue chap with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param taiSanThueChapId the primary key of the tai san thue chap
	 * @return the tai san thue chap, or <code>null</code> if a tai san thue chap with the primary key could not be found
	 */
	public static TaiSanThueChap fetchByPrimaryKey(long taiSanThueChapId) {
		return getPersistence().fetchByPrimaryKey(taiSanThueChapId);
	}

	/**
	 * Returns all the tai san thue chaps.
	 *
	 * @return the tai san thue chaps
	 */
	public static List<TaiSanThueChap> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the tai san thue chaps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaiSanThueChapModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tai san thue chaps
	 * @param end the upper bound of the range of tai san thue chaps (not inclusive)
	 * @return the range of tai san thue chaps
	 */
	public static List<TaiSanThueChap> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the tai san thue chaps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaiSanThueChapModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tai san thue chaps
	 * @param end the upper bound of the range of tai san thue chaps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tai san thue chaps
	 */
	public static List<TaiSanThueChap> findAll(
		int start, int end,
		OrderByComparator<TaiSanThueChap> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the tai san thue chaps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaiSanThueChapModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tai san thue chaps
	 * @param end the upper bound of the range of tai san thue chaps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of tai san thue chaps
	 */
	public static List<TaiSanThueChap> findAll(
		int start, int end, OrderByComparator<TaiSanThueChap> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the tai san thue chaps from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of tai san thue chaps.
	 *
	 * @return the number of tai san thue chaps
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TaiSanThueChapPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<TaiSanThueChapPersistence, TaiSanThueChapPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			TaiSanThueChapPersistence.class);

		ServiceTracker<TaiSanThueChapPersistence, TaiSanThueChapPersistence>
			serviceTracker =
				new ServiceTracker
					<TaiSanThueChapPersistence, TaiSanThueChapPersistence>(
						bundle.getBundleContext(),
						TaiSanThueChapPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}