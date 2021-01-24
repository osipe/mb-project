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

import com.mb.model.ChiNhanh;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the chi nhanh service. This utility wraps <code>com.mb.service.persistence.impl.ChiNhanhPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ChiNhanhPersistence
 * @generated
 */
@ProviderType
public class ChiNhanhUtil {

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
	public static void clearCache(ChiNhanh chiNhanh) {
		getPersistence().clearCache(chiNhanh);
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
	public static Map<Serializable, ChiNhanh> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ChiNhanh> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ChiNhanh> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ChiNhanh> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ChiNhanh> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ChiNhanh update(ChiNhanh chiNhanh) {
		return getPersistence().update(chiNhanh);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ChiNhanh update(
		ChiNhanh chiNhanh, ServiceContext serviceContext) {

		return getPersistence().update(chiNhanh, serviceContext);
	}

	/**
	 * Returns the chi nhanh where ma = &#63; or throws a <code>NoSuchChiNhanhException</code> if it could not be found.
	 *
	 * @param ma the ma
	 * @return the matching chi nhanh
	 * @throws NoSuchChiNhanhException if a matching chi nhanh could not be found
	 */
	public static ChiNhanh findByMa(String ma)
		throws com.mb.exception.NoSuchChiNhanhException {

		return getPersistence().findByMa(ma);
	}

	/**
	 * Returns the chi nhanh where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ma the ma
	 * @return the matching chi nhanh, or <code>null</code> if a matching chi nhanh could not be found
	 */
	public static ChiNhanh fetchByMa(String ma) {
		return getPersistence().fetchByMa(ma);
	}

	/**
	 * Returns the chi nhanh where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ma the ma
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching chi nhanh, or <code>null</code> if a matching chi nhanh could not be found
	 */
	public static ChiNhanh fetchByMa(String ma, boolean retrieveFromCache) {
		return getPersistence().fetchByMa(ma, retrieveFromCache);
	}

	/**
	 * Removes the chi nhanh where ma = &#63; from the database.
	 *
	 * @param ma the ma
	 * @return the chi nhanh that was removed
	 */
	public static ChiNhanh removeByMa(String ma)
		throws com.mb.exception.NoSuchChiNhanhException {

		return getPersistence().removeByMa(ma);
	}

	/**
	 * Returns the number of chi nhanhs where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the number of matching chi nhanhs
	 */
	public static int countByMa(String ma) {
		return getPersistence().countByMa(ma);
	}

	/**
	 * Returns all the chi nhanhs where hoatDong = &#63;.
	 *
	 * @param hoatDong the hoat dong
	 * @return the matching chi nhanhs
	 */
	public static List<ChiNhanh> findByHoatDong(Boolean hoatDong) {
		return getPersistence().findByHoatDong(hoatDong);
	}

	/**
	 * Returns a range of all the chi nhanhs where hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ChiNhanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of chi nhanhs
	 * @param end the upper bound of the range of chi nhanhs (not inclusive)
	 * @return the range of matching chi nhanhs
	 */
	public static List<ChiNhanh> findByHoatDong(
		Boolean hoatDong, int start, int end) {

		return getPersistence().findByHoatDong(hoatDong, start, end);
	}

	/**
	 * Returns an ordered range of all the chi nhanhs where hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ChiNhanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of chi nhanhs
	 * @param end the upper bound of the range of chi nhanhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching chi nhanhs
	 */
	public static List<ChiNhanh> findByHoatDong(
		Boolean hoatDong, int start, int end,
		OrderByComparator<ChiNhanh> orderByComparator) {

		return getPersistence().findByHoatDong(
			hoatDong, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the chi nhanhs where hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ChiNhanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of chi nhanhs
	 * @param end the upper bound of the range of chi nhanhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching chi nhanhs
	 */
	public static List<ChiNhanh> findByHoatDong(
		Boolean hoatDong, int start, int end,
		OrderByComparator<ChiNhanh> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByHoatDong(
			hoatDong, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first chi nhanh in the ordered set where hoatDong = &#63;.
	 *
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chi nhanh
	 * @throws NoSuchChiNhanhException if a matching chi nhanh could not be found
	 */
	public static ChiNhanh findByHoatDong_First(
			Boolean hoatDong, OrderByComparator<ChiNhanh> orderByComparator)
		throws com.mb.exception.NoSuchChiNhanhException {

		return getPersistence().findByHoatDong_First(
			hoatDong, orderByComparator);
	}

	/**
	 * Returns the first chi nhanh in the ordered set where hoatDong = &#63;.
	 *
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chi nhanh, or <code>null</code> if a matching chi nhanh could not be found
	 */
	public static ChiNhanh fetchByHoatDong_First(
		Boolean hoatDong, OrderByComparator<ChiNhanh> orderByComparator) {

		return getPersistence().fetchByHoatDong_First(
			hoatDong, orderByComparator);
	}

	/**
	 * Returns the last chi nhanh in the ordered set where hoatDong = &#63;.
	 *
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chi nhanh
	 * @throws NoSuchChiNhanhException if a matching chi nhanh could not be found
	 */
	public static ChiNhanh findByHoatDong_Last(
			Boolean hoatDong, OrderByComparator<ChiNhanh> orderByComparator)
		throws com.mb.exception.NoSuchChiNhanhException {

		return getPersistence().findByHoatDong_Last(
			hoatDong, orderByComparator);
	}

	/**
	 * Returns the last chi nhanh in the ordered set where hoatDong = &#63;.
	 *
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chi nhanh, or <code>null</code> if a matching chi nhanh could not be found
	 */
	public static ChiNhanh fetchByHoatDong_Last(
		Boolean hoatDong, OrderByComparator<ChiNhanh> orderByComparator) {

		return getPersistence().fetchByHoatDong_Last(
			hoatDong, orderByComparator);
	}

	/**
	 * Returns the chi nhanhs before and after the current chi nhanh in the ordered set where hoatDong = &#63;.
	 *
	 * @param chiNhanhId the primary key of the current chi nhanh
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next chi nhanh
	 * @throws NoSuchChiNhanhException if a chi nhanh with the primary key could not be found
	 */
	public static ChiNhanh[] findByHoatDong_PrevAndNext(
			long chiNhanhId, Boolean hoatDong,
			OrderByComparator<ChiNhanh> orderByComparator)
		throws com.mb.exception.NoSuchChiNhanhException {

		return getPersistence().findByHoatDong_PrevAndNext(
			chiNhanhId, hoatDong, orderByComparator);
	}

	/**
	 * Removes all the chi nhanhs where hoatDong = &#63; from the database.
	 *
	 * @param hoatDong the hoat dong
	 */
	public static void removeByHoatDong(Boolean hoatDong) {
		getPersistence().removeByHoatDong(hoatDong);
	}

	/**
	 * Returns the number of chi nhanhs where hoatDong = &#63;.
	 *
	 * @param hoatDong the hoat dong
	 * @return the number of matching chi nhanhs
	 */
	public static int countByHoatDong(Boolean hoatDong) {
		return getPersistence().countByHoatDong(hoatDong);
	}

	/**
	 * Caches the chi nhanh in the entity cache if it is enabled.
	 *
	 * @param chiNhanh the chi nhanh
	 */
	public static void cacheResult(ChiNhanh chiNhanh) {
		getPersistence().cacheResult(chiNhanh);
	}

	/**
	 * Caches the chi nhanhs in the entity cache if it is enabled.
	 *
	 * @param chiNhanhs the chi nhanhs
	 */
	public static void cacheResult(List<ChiNhanh> chiNhanhs) {
		getPersistence().cacheResult(chiNhanhs);
	}

	/**
	 * Creates a new chi nhanh with the primary key. Does not add the chi nhanh to the database.
	 *
	 * @param chiNhanhId the primary key for the new chi nhanh
	 * @return the new chi nhanh
	 */
	public static ChiNhanh create(long chiNhanhId) {
		return getPersistence().create(chiNhanhId);
	}

	/**
	 * Removes the chi nhanh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param chiNhanhId the primary key of the chi nhanh
	 * @return the chi nhanh that was removed
	 * @throws NoSuchChiNhanhException if a chi nhanh with the primary key could not be found
	 */
	public static ChiNhanh remove(long chiNhanhId)
		throws com.mb.exception.NoSuchChiNhanhException {

		return getPersistence().remove(chiNhanhId);
	}

	public static ChiNhanh updateImpl(ChiNhanh chiNhanh) {
		return getPersistence().updateImpl(chiNhanh);
	}

	/**
	 * Returns the chi nhanh with the primary key or throws a <code>NoSuchChiNhanhException</code> if it could not be found.
	 *
	 * @param chiNhanhId the primary key of the chi nhanh
	 * @return the chi nhanh
	 * @throws NoSuchChiNhanhException if a chi nhanh with the primary key could not be found
	 */
	public static ChiNhanh findByPrimaryKey(long chiNhanhId)
		throws com.mb.exception.NoSuchChiNhanhException {

		return getPersistence().findByPrimaryKey(chiNhanhId);
	}

	/**
	 * Returns the chi nhanh with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param chiNhanhId the primary key of the chi nhanh
	 * @return the chi nhanh, or <code>null</code> if a chi nhanh with the primary key could not be found
	 */
	public static ChiNhanh fetchByPrimaryKey(long chiNhanhId) {
		return getPersistence().fetchByPrimaryKey(chiNhanhId);
	}

	/**
	 * Returns all the chi nhanhs.
	 *
	 * @return the chi nhanhs
	 */
	public static List<ChiNhanh> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the chi nhanhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ChiNhanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of chi nhanhs
	 * @param end the upper bound of the range of chi nhanhs (not inclusive)
	 * @return the range of chi nhanhs
	 */
	public static List<ChiNhanh> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the chi nhanhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ChiNhanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of chi nhanhs
	 * @param end the upper bound of the range of chi nhanhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of chi nhanhs
	 */
	public static List<ChiNhanh> findAll(
		int start, int end, OrderByComparator<ChiNhanh> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the chi nhanhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ChiNhanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of chi nhanhs
	 * @param end the upper bound of the range of chi nhanhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of chi nhanhs
	 */
	public static List<ChiNhanh> findAll(
		int start, int end, OrderByComparator<ChiNhanh> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the chi nhanhs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of chi nhanhs.
	 *
	 * @return the number of chi nhanhs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ChiNhanhPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ChiNhanhPersistence, ChiNhanhPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ChiNhanhPersistence.class);

		ServiceTracker<ChiNhanhPersistence, ChiNhanhPersistence>
			serviceTracker =
				new ServiceTracker<ChiNhanhPersistence, ChiNhanhPersistence>(
					bundle.getBundleContext(), ChiNhanhPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}