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

import com.mb.model.KhachHang;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the khach hang service. This utility wraps <code>com.mb.service.persistence.impl.KhachHangPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KhachHangPersistence
 * @generated
 */
@ProviderType
public class KhachHangUtil {

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
	public static void clearCache(KhachHang khachHang) {
		getPersistence().clearCache(khachHang);
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
	public static Map<Serializable, KhachHang> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<KhachHang> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<KhachHang> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<KhachHang> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<KhachHang> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static KhachHang update(KhachHang khachHang) {
		return getPersistence().update(khachHang);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static KhachHang update(
		KhachHang khachHang, ServiceContext serviceContext) {

		return getPersistence().update(khachHang, serviceContext);
	}

	/**
	 * Returns the khach hang where ma = &#63; or throws a <code>NoSuchKhachHangException</code> if it could not be found.
	 *
	 * @param ma the ma
	 * @return the matching khach hang
	 * @throws NoSuchKhachHangException if a matching khach hang could not be found
	 */
	public static KhachHang findByMa(String ma)
		throws com.mb.exception.NoSuchKhachHangException {

		return getPersistence().findByMa(ma);
	}

	/**
	 * Returns the khach hang where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ma the ma
	 * @return the matching khach hang, or <code>null</code> if a matching khach hang could not be found
	 */
	public static KhachHang fetchByMa(String ma) {
		return getPersistence().fetchByMa(ma);
	}

	/**
	 * Returns the khach hang where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ma the ma
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching khach hang, or <code>null</code> if a matching khach hang could not be found
	 */
	public static KhachHang fetchByMa(String ma, boolean retrieveFromCache) {
		return getPersistence().fetchByMa(ma, retrieveFromCache);
	}

	/**
	 * Removes the khach hang where ma = &#63; from the database.
	 *
	 * @param ma the ma
	 * @return the khach hang that was removed
	 */
	public static KhachHang removeByMa(String ma)
		throws com.mb.exception.NoSuchKhachHangException {

		return getPersistence().removeByMa(ma);
	}

	/**
	 * Returns the number of khach hangs where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the number of matching khach hangs
	 */
	public static int countByMa(String ma) {
		return getPersistence().countByMa(ma);
	}

	/**
	 * Returns all the khach hangs where maCTV = &#63;.
	 *
	 * @param maCTV the ma ctv
	 * @return the matching khach hangs
	 */
	public static List<KhachHang> findByMaCTV(String maCTV) {
		return getPersistence().findByMaCTV(maCTV);
	}

	/**
	 * Returns a range of all the khach hangs where maCTV = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>KhachHangModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param maCTV the ma ctv
	 * @param start the lower bound of the range of khach hangs
	 * @param end the upper bound of the range of khach hangs (not inclusive)
	 * @return the range of matching khach hangs
	 */
	public static List<KhachHang> findByMaCTV(
		String maCTV, int start, int end) {

		return getPersistence().findByMaCTV(maCTV, start, end);
	}

	/**
	 * Returns an ordered range of all the khach hangs where maCTV = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>KhachHangModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param maCTV the ma ctv
	 * @param start the lower bound of the range of khach hangs
	 * @param end the upper bound of the range of khach hangs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching khach hangs
	 */
	public static List<KhachHang> findByMaCTV(
		String maCTV, int start, int end,
		OrderByComparator<KhachHang> orderByComparator) {

		return getPersistence().findByMaCTV(
			maCTV, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the khach hangs where maCTV = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>KhachHangModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param maCTV the ma ctv
	 * @param start the lower bound of the range of khach hangs
	 * @param end the upper bound of the range of khach hangs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching khach hangs
	 */
	public static List<KhachHang> findByMaCTV(
		String maCTV, int start, int end,
		OrderByComparator<KhachHang> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByMaCTV(
			maCTV, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first khach hang in the ordered set where maCTV = &#63;.
	 *
	 * @param maCTV the ma ctv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching khach hang
	 * @throws NoSuchKhachHangException if a matching khach hang could not be found
	 */
	public static KhachHang findByMaCTV_First(
			String maCTV, OrderByComparator<KhachHang> orderByComparator)
		throws com.mb.exception.NoSuchKhachHangException {

		return getPersistence().findByMaCTV_First(maCTV, orderByComparator);
	}

	/**
	 * Returns the first khach hang in the ordered set where maCTV = &#63;.
	 *
	 * @param maCTV the ma ctv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching khach hang, or <code>null</code> if a matching khach hang could not be found
	 */
	public static KhachHang fetchByMaCTV_First(
		String maCTV, OrderByComparator<KhachHang> orderByComparator) {

		return getPersistence().fetchByMaCTV_First(maCTV, orderByComparator);
	}

	/**
	 * Returns the last khach hang in the ordered set where maCTV = &#63;.
	 *
	 * @param maCTV the ma ctv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching khach hang
	 * @throws NoSuchKhachHangException if a matching khach hang could not be found
	 */
	public static KhachHang findByMaCTV_Last(
			String maCTV, OrderByComparator<KhachHang> orderByComparator)
		throws com.mb.exception.NoSuchKhachHangException {

		return getPersistence().findByMaCTV_Last(maCTV, orderByComparator);
	}

	/**
	 * Returns the last khach hang in the ordered set where maCTV = &#63;.
	 *
	 * @param maCTV the ma ctv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching khach hang, or <code>null</code> if a matching khach hang could not be found
	 */
	public static KhachHang fetchByMaCTV_Last(
		String maCTV, OrderByComparator<KhachHang> orderByComparator) {

		return getPersistence().fetchByMaCTV_Last(maCTV, orderByComparator);
	}

	/**
	 * Returns the khach hangs before and after the current khach hang in the ordered set where maCTV = &#63;.
	 *
	 * @param khachHangId the primary key of the current khach hang
	 * @param maCTV the ma ctv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next khach hang
	 * @throws NoSuchKhachHangException if a khach hang with the primary key could not be found
	 */
	public static KhachHang[] findByMaCTV_PrevAndNext(
			long khachHangId, String maCTV,
			OrderByComparator<KhachHang> orderByComparator)
		throws com.mb.exception.NoSuchKhachHangException {

		return getPersistence().findByMaCTV_PrevAndNext(
			khachHangId, maCTV, orderByComparator);
	}

	/**
	 * Removes all the khach hangs where maCTV = &#63; from the database.
	 *
	 * @param maCTV the ma ctv
	 */
	public static void removeByMaCTV(String maCTV) {
		getPersistence().removeByMaCTV(maCTV);
	}

	/**
	 * Returns the number of khach hangs where maCTV = &#63;.
	 *
	 * @param maCTV the ma ctv
	 * @return the number of matching khach hangs
	 */
	public static int countByMaCTV(String maCTV) {
		return getPersistence().countByMaCTV(maCTV);
	}

	/**
	 * Returns the khach hang where soCMND = &#63; or throws a <code>NoSuchKhachHangException</code> if it could not be found.
	 *
	 * @param soCMND the so cmnd
	 * @return the matching khach hang
	 * @throws NoSuchKhachHangException if a matching khach hang could not be found
	 */
	public static KhachHang findBySoCMND(String soCMND)
		throws com.mb.exception.NoSuchKhachHangException {

		return getPersistence().findBySoCMND(soCMND);
	}

	/**
	 * Returns the khach hang where soCMND = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param soCMND the so cmnd
	 * @return the matching khach hang, or <code>null</code> if a matching khach hang could not be found
	 */
	public static KhachHang fetchBySoCMND(String soCMND) {
		return getPersistence().fetchBySoCMND(soCMND);
	}

	/**
	 * Returns the khach hang where soCMND = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param soCMND the so cmnd
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching khach hang, or <code>null</code> if a matching khach hang could not be found
	 */
	public static KhachHang fetchBySoCMND(
		String soCMND, boolean retrieveFromCache) {

		return getPersistence().fetchBySoCMND(soCMND, retrieveFromCache);
	}

	/**
	 * Removes the khach hang where soCMND = &#63; from the database.
	 *
	 * @param soCMND the so cmnd
	 * @return the khach hang that was removed
	 */
	public static KhachHang removeBySoCMND(String soCMND)
		throws com.mb.exception.NoSuchKhachHangException {

		return getPersistence().removeBySoCMND(soCMND);
	}

	/**
	 * Returns the number of khach hangs where soCMND = &#63;.
	 *
	 * @param soCMND the so cmnd
	 * @return the number of matching khach hangs
	 */
	public static int countBySoCMND(String soCMND) {
		return getPersistence().countBySoCMND(soCMND);
	}

	/**
	 * Caches the khach hang in the entity cache if it is enabled.
	 *
	 * @param khachHang the khach hang
	 */
	public static void cacheResult(KhachHang khachHang) {
		getPersistence().cacheResult(khachHang);
	}

	/**
	 * Caches the khach hangs in the entity cache if it is enabled.
	 *
	 * @param khachHangs the khach hangs
	 */
	public static void cacheResult(List<KhachHang> khachHangs) {
		getPersistence().cacheResult(khachHangs);
	}

	/**
	 * Creates a new khach hang with the primary key. Does not add the khach hang to the database.
	 *
	 * @param khachHangId the primary key for the new khach hang
	 * @return the new khach hang
	 */
	public static KhachHang create(long khachHangId) {
		return getPersistence().create(khachHangId);
	}

	/**
	 * Removes the khach hang with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param khachHangId the primary key of the khach hang
	 * @return the khach hang that was removed
	 * @throws NoSuchKhachHangException if a khach hang with the primary key could not be found
	 */
	public static KhachHang remove(long khachHangId)
		throws com.mb.exception.NoSuchKhachHangException {

		return getPersistence().remove(khachHangId);
	}

	public static KhachHang updateImpl(KhachHang khachHang) {
		return getPersistence().updateImpl(khachHang);
	}

	/**
	 * Returns the khach hang with the primary key or throws a <code>NoSuchKhachHangException</code> if it could not be found.
	 *
	 * @param khachHangId the primary key of the khach hang
	 * @return the khach hang
	 * @throws NoSuchKhachHangException if a khach hang with the primary key could not be found
	 */
	public static KhachHang findByPrimaryKey(long khachHangId)
		throws com.mb.exception.NoSuchKhachHangException {

		return getPersistence().findByPrimaryKey(khachHangId);
	}

	/**
	 * Returns the khach hang with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param khachHangId the primary key of the khach hang
	 * @return the khach hang, or <code>null</code> if a khach hang with the primary key could not be found
	 */
	public static KhachHang fetchByPrimaryKey(long khachHangId) {
		return getPersistence().fetchByPrimaryKey(khachHangId);
	}

	/**
	 * Returns all the khach hangs.
	 *
	 * @return the khach hangs
	 */
	public static List<KhachHang> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the khach hangs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>KhachHangModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of khach hangs
	 * @param end the upper bound of the range of khach hangs (not inclusive)
	 * @return the range of khach hangs
	 */
	public static List<KhachHang> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the khach hangs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>KhachHangModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of khach hangs
	 * @param end the upper bound of the range of khach hangs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of khach hangs
	 */
	public static List<KhachHang> findAll(
		int start, int end, OrderByComparator<KhachHang> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the khach hangs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>KhachHangModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of khach hangs
	 * @param end the upper bound of the range of khach hangs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of khach hangs
	 */
	public static List<KhachHang> findAll(
		int start, int end, OrderByComparator<KhachHang> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the khach hangs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of khach hangs.
	 *
	 * @return the number of khach hangs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static KhachHangPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<KhachHangPersistence, KhachHangPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(KhachHangPersistence.class);

		ServiceTracker<KhachHangPersistence, KhachHangPersistence>
			serviceTracker =
				new ServiceTracker<KhachHangPersistence, KhachHangPersistence>(
					bundle.getBundleContext(), KhachHangPersistence.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}