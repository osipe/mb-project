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

import com.mb.model.LoaiTaiSan;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the loai tai san service. This utility wraps <code>com.mb.service.persistence.impl.LoaiTaiSanPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LoaiTaiSanPersistence
 * @generated
 */
@ProviderType
public class LoaiTaiSanUtil {

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
	public static void clearCache(LoaiTaiSan loaiTaiSan) {
		getPersistence().clearCache(loaiTaiSan);
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
	public static Map<Serializable, LoaiTaiSan> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LoaiTaiSan> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LoaiTaiSan> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LoaiTaiSan> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LoaiTaiSan> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LoaiTaiSan update(LoaiTaiSan loaiTaiSan) {
		return getPersistence().update(loaiTaiSan);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LoaiTaiSan update(
		LoaiTaiSan loaiTaiSan, ServiceContext serviceContext) {

		return getPersistence().update(loaiTaiSan, serviceContext);
	}

	/**
	 * Returns the loai tai san where ma = &#63; or throws a <code>NoSuchLoaiTaiSanException</code> if it could not be found.
	 *
	 * @param ma the ma
	 * @return the matching loai tai san
	 * @throws NoSuchLoaiTaiSanException if a matching loai tai san could not be found
	 */
	public static LoaiTaiSan findByMa(String ma)
		throws com.mb.exception.NoSuchLoaiTaiSanException {

		return getPersistence().findByMa(ma);
	}

	/**
	 * Returns the loai tai san where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ma the ma
	 * @return the matching loai tai san, or <code>null</code> if a matching loai tai san could not be found
	 */
	public static LoaiTaiSan fetchByMa(String ma) {
		return getPersistence().fetchByMa(ma);
	}

	/**
	 * Returns the loai tai san where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ma the ma
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching loai tai san, or <code>null</code> if a matching loai tai san could not be found
	 */
	public static LoaiTaiSan fetchByMa(String ma, boolean retrieveFromCache) {
		return getPersistence().fetchByMa(ma, retrieveFromCache);
	}

	/**
	 * Removes the loai tai san where ma = &#63; from the database.
	 *
	 * @param ma the ma
	 * @return the loai tai san that was removed
	 */
	public static LoaiTaiSan removeByMa(String ma)
		throws com.mb.exception.NoSuchLoaiTaiSanException {

		return getPersistence().removeByMa(ma);
	}

	/**
	 * Returns the number of loai tai sans where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the number of matching loai tai sans
	 */
	public static int countByMa(String ma) {
		return getPersistence().countByMa(ma);
	}

	/**
	 * Caches the loai tai san in the entity cache if it is enabled.
	 *
	 * @param loaiTaiSan the loai tai san
	 */
	public static void cacheResult(LoaiTaiSan loaiTaiSan) {
		getPersistence().cacheResult(loaiTaiSan);
	}

	/**
	 * Caches the loai tai sans in the entity cache if it is enabled.
	 *
	 * @param loaiTaiSans the loai tai sans
	 */
	public static void cacheResult(List<LoaiTaiSan> loaiTaiSans) {
		getPersistence().cacheResult(loaiTaiSans);
	}

	/**
	 * Creates a new loai tai san with the primary key. Does not add the loai tai san to the database.
	 *
	 * @param loaiTaiSanId the primary key for the new loai tai san
	 * @return the new loai tai san
	 */
	public static LoaiTaiSan create(long loaiTaiSanId) {
		return getPersistence().create(loaiTaiSanId);
	}

	/**
	 * Removes the loai tai san with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param loaiTaiSanId the primary key of the loai tai san
	 * @return the loai tai san that was removed
	 * @throws NoSuchLoaiTaiSanException if a loai tai san with the primary key could not be found
	 */
	public static LoaiTaiSan remove(long loaiTaiSanId)
		throws com.mb.exception.NoSuchLoaiTaiSanException {

		return getPersistence().remove(loaiTaiSanId);
	}

	public static LoaiTaiSan updateImpl(LoaiTaiSan loaiTaiSan) {
		return getPersistence().updateImpl(loaiTaiSan);
	}

	/**
	 * Returns the loai tai san with the primary key or throws a <code>NoSuchLoaiTaiSanException</code> if it could not be found.
	 *
	 * @param loaiTaiSanId the primary key of the loai tai san
	 * @return the loai tai san
	 * @throws NoSuchLoaiTaiSanException if a loai tai san with the primary key could not be found
	 */
	public static LoaiTaiSan findByPrimaryKey(long loaiTaiSanId)
		throws com.mb.exception.NoSuchLoaiTaiSanException {

		return getPersistence().findByPrimaryKey(loaiTaiSanId);
	}

	/**
	 * Returns the loai tai san with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param loaiTaiSanId the primary key of the loai tai san
	 * @return the loai tai san, or <code>null</code> if a loai tai san with the primary key could not be found
	 */
	public static LoaiTaiSan fetchByPrimaryKey(long loaiTaiSanId) {
		return getPersistence().fetchByPrimaryKey(loaiTaiSanId);
	}

	/**
	 * Returns all the loai tai sans.
	 *
	 * @return the loai tai sans
	 */
	public static List<LoaiTaiSan> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the loai tai sans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LoaiTaiSanModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of loai tai sans
	 * @param end the upper bound of the range of loai tai sans (not inclusive)
	 * @return the range of loai tai sans
	 */
	public static List<LoaiTaiSan> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the loai tai sans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LoaiTaiSanModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of loai tai sans
	 * @param end the upper bound of the range of loai tai sans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of loai tai sans
	 */
	public static List<LoaiTaiSan> findAll(
		int start, int end, OrderByComparator<LoaiTaiSan> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the loai tai sans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LoaiTaiSanModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of loai tai sans
	 * @param end the upper bound of the range of loai tai sans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of loai tai sans
	 */
	public static List<LoaiTaiSan> findAll(
		int start, int end, OrderByComparator<LoaiTaiSan> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the loai tai sans from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of loai tai sans.
	 *
	 * @return the number of loai tai sans
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LoaiTaiSanPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LoaiTaiSanPersistence, LoaiTaiSanPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LoaiTaiSanPersistence.class);

		ServiceTracker<LoaiTaiSanPersistence, LoaiTaiSanPersistence>
			serviceTracker =
				new ServiceTracker
					<LoaiTaiSanPersistence, LoaiTaiSanPersistence>(
						bundle.getBundleContext(), LoaiTaiSanPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}