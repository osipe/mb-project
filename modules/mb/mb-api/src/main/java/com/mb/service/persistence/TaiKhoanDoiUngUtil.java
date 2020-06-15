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

import com.mb.model.TaiKhoanDoiUng;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the tai khoan doi ung service. This utility wraps <code>com.mb.service.persistence.impl.TaiKhoanDoiUngPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaiKhoanDoiUngPersistence
 * @generated
 */
@ProviderType
public class TaiKhoanDoiUngUtil {

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
	public static void clearCache(TaiKhoanDoiUng taiKhoanDoiUng) {
		getPersistence().clearCache(taiKhoanDoiUng);
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
	public static Map<Serializable, TaiKhoanDoiUng> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TaiKhoanDoiUng> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TaiKhoanDoiUng> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TaiKhoanDoiUng> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TaiKhoanDoiUng> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TaiKhoanDoiUng update(TaiKhoanDoiUng taiKhoanDoiUng) {
		return getPersistence().update(taiKhoanDoiUng);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TaiKhoanDoiUng update(
		TaiKhoanDoiUng taiKhoanDoiUng, ServiceContext serviceContext) {

		return getPersistence().update(taiKhoanDoiUng, serviceContext);
	}

	/**
	 * Returns the tai khoan doi ung where soHieu = &#63; or throws a <code>NoSuchTaiKhoanDoiUngException</code> if it could not be found.
	 *
	 * @param soHieu the so hieu
	 * @return the matching tai khoan doi ung
	 * @throws NoSuchTaiKhoanDoiUngException if a matching tai khoan doi ung could not be found
	 */
	public static TaiKhoanDoiUng findBySoHieu(String soHieu)
		throws com.mb.exception.NoSuchTaiKhoanDoiUngException {

		return getPersistence().findBySoHieu(soHieu);
	}

	/**
	 * Returns the tai khoan doi ung where soHieu = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param soHieu the so hieu
	 * @return the matching tai khoan doi ung, or <code>null</code> if a matching tai khoan doi ung could not be found
	 */
	public static TaiKhoanDoiUng fetchBySoHieu(String soHieu) {
		return getPersistence().fetchBySoHieu(soHieu);
	}

	/**
	 * Returns the tai khoan doi ung where soHieu = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param soHieu the so hieu
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching tai khoan doi ung, or <code>null</code> if a matching tai khoan doi ung could not be found
	 */
	public static TaiKhoanDoiUng fetchBySoHieu(
		String soHieu, boolean retrieveFromCache) {

		return getPersistence().fetchBySoHieu(soHieu, retrieveFromCache);
	}

	/**
	 * Removes the tai khoan doi ung where soHieu = &#63; from the database.
	 *
	 * @param soHieu the so hieu
	 * @return the tai khoan doi ung that was removed
	 */
	public static TaiKhoanDoiUng removeBySoHieu(String soHieu)
		throws com.mb.exception.NoSuchTaiKhoanDoiUngException {

		return getPersistence().removeBySoHieu(soHieu);
	}

	/**
	 * Returns the number of tai khoan doi ungs where soHieu = &#63;.
	 *
	 * @param soHieu the so hieu
	 * @return the number of matching tai khoan doi ungs
	 */
	public static int countBySoHieu(String soHieu) {
		return getPersistence().countBySoHieu(soHieu);
	}

	/**
	 * Returns all the tai khoan doi ungs where hoatDong = &#63;.
	 *
	 * @param hoatDong the hoat dong
	 * @return the matching tai khoan doi ungs
	 */
	public static List<TaiKhoanDoiUng> findByHoatDong(Boolean hoatDong) {
		return getPersistence().findByHoatDong(hoatDong);
	}

	/**
	 * Returns a range of all the tai khoan doi ungs where hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaiKhoanDoiUngModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of tai khoan doi ungs
	 * @param end the upper bound of the range of tai khoan doi ungs (not inclusive)
	 * @return the range of matching tai khoan doi ungs
	 */
	public static List<TaiKhoanDoiUng> findByHoatDong(
		Boolean hoatDong, int start, int end) {

		return getPersistence().findByHoatDong(hoatDong, start, end);
	}

	/**
	 * Returns an ordered range of all the tai khoan doi ungs where hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaiKhoanDoiUngModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of tai khoan doi ungs
	 * @param end the upper bound of the range of tai khoan doi ungs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tai khoan doi ungs
	 */
	public static List<TaiKhoanDoiUng> findByHoatDong(
		Boolean hoatDong, int start, int end,
		OrderByComparator<TaiKhoanDoiUng> orderByComparator) {

		return getPersistence().findByHoatDong(
			hoatDong, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the tai khoan doi ungs where hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaiKhoanDoiUngModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of tai khoan doi ungs
	 * @param end the upper bound of the range of tai khoan doi ungs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching tai khoan doi ungs
	 */
	public static List<TaiKhoanDoiUng> findByHoatDong(
		Boolean hoatDong, int start, int end,
		OrderByComparator<TaiKhoanDoiUng> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByHoatDong(
			hoatDong, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first tai khoan doi ung in the ordered set where hoatDong = &#63;.
	 *
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tai khoan doi ung
	 * @throws NoSuchTaiKhoanDoiUngException if a matching tai khoan doi ung could not be found
	 */
	public static TaiKhoanDoiUng findByHoatDong_First(
			Boolean hoatDong,
			OrderByComparator<TaiKhoanDoiUng> orderByComparator)
		throws com.mb.exception.NoSuchTaiKhoanDoiUngException {

		return getPersistence().findByHoatDong_First(
			hoatDong, orderByComparator);
	}

	/**
	 * Returns the first tai khoan doi ung in the ordered set where hoatDong = &#63;.
	 *
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tai khoan doi ung, or <code>null</code> if a matching tai khoan doi ung could not be found
	 */
	public static TaiKhoanDoiUng fetchByHoatDong_First(
		Boolean hoatDong, OrderByComparator<TaiKhoanDoiUng> orderByComparator) {

		return getPersistence().fetchByHoatDong_First(
			hoatDong, orderByComparator);
	}

	/**
	 * Returns the last tai khoan doi ung in the ordered set where hoatDong = &#63;.
	 *
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tai khoan doi ung
	 * @throws NoSuchTaiKhoanDoiUngException if a matching tai khoan doi ung could not be found
	 */
	public static TaiKhoanDoiUng findByHoatDong_Last(
			Boolean hoatDong,
			OrderByComparator<TaiKhoanDoiUng> orderByComparator)
		throws com.mb.exception.NoSuchTaiKhoanDoiUngException {

		return getPersistence().findByHoatDong_Last(
			hoatDong, orderByComparator);
	}

	/**
	 * Returns the last tai khoan doi ung in the ordered set where hoatDong = &#63;.
	 *
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tai khoan doi ung, or <code>null</code> if a matching tai khoan doi ung could not be found
	 */
	public static TaiKhoanDoiUng fetchByHoatDong_Last(
		Boolean hoatDong, OrderByComparator<TaiKhoanDoiUng> orderByComparator) {

		return getPersistence().fetchByHoatDong_Last(
			hoatDong, orderByComparator);
	}

	/**
	 * Returns the tai khoan doi ungs before and after the current tai khoan doi ung in the ordered set where hoatDong = &#63;.
	 *
	 * @param taiKhoanDoiUngId the primary key of the current tai khoan doi ung
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tai khoan doi ung
	 * @throws NoSuchTaiKhoanDoiUngException if a tai khoan doi ung with the primary key could not be found
	 */
	public static TaiKhoanDoiUng[] findByHoatDong_PrevAndNext(
			long taiKhoanDoiUngId, Boolean hoatDong,
			OrderByComparator<TaiKhoanDoiUng> orderByComparator)
		throws com.mb.exception.NoSuchTaiKhoanDoiUngException {

		return getPersistence().findByHoatDong_PrevAndNext(
			taiKhoanDoiUngId, hoatDong, orderByComparator);
	}

	/**
	 * Removes all the tai khoan doi ungs where hoatDong = &#63; from the database.
	 *
	 * @param hoatDong the hoat dong
	 */
	public static void removeByHoatDong(Boolean hoatDong) {
		getPersistence().removeByHoatDong(hoatDong);
	}

	/**
	 * Returns the number of tai khoan doi ungs where hoatDong = &#63;.
	 *
	 * @param hoatDong the hoat dong
	 * @return the number of matching tai khoan doi ungs
	 */
	public static int countByHoatDong(Boolean hoatDong) {
		return getPersistence().countByHoatDong(hoatDong);
	}

	/**
	 * Returns all the tai khoan doi ungs where loaiTaiKhoan = &#63; and hoatDong = &#63;.
	 *
	 * @param loaiTaiKhoan the loai tai khoan
	 * @param hoatDong the hoat dong
	 * @return the matching tai khoan doi ungs
	 */
	public static List<TaiKhoanDoiUng> findByLoaiTaiKhoan_HoatDong(
		int loaiTaiKhoan, Boolean hoatDong) {

		return getPersistence().findByLoaiTaiKhoan_HoatDong(
			loaiTaiKhoan, hoatDong);
	}

	/**
	 * Returns a range of all the tai khoan doi ungs where loaiTaiKhoan = &#63; and hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaiKhoanDoiUngModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param loaiTaiKhoan the loai tai khoan
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of tai khoan doi ungs
	 * @param end the upper bound of the range of tai khoan doi ungs (not inclusive)
	 * @return the range of matching tai khoan doi ungs
	 */
	public static List<TaiKhoanDoiUng> findByLoaiTaiKhoan_HoatDong(
		int loaiTaiKhoan, Boolean hoatDong, int start, int end) {

		return getPersistence().findByLoaiTaiKhoan_HoatDong(
			loaiTaiKhoan, hoatDong, start, end);
	}

	/**
	 * Returns an ordered range of all the tai khoan doi ungs where loaiTaiKhoan = &#63; and hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaiKhoanDoiUngModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param loaiTaiKhoan the loai tai khoan
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of tai khoan doi ungs
	 * @param end the upper bound of the range of tai khoan doi ungs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tai khoan doi ungs
	 */
	public static List<TaiKhoanDoiUng> findByLoaiTaiKhoan_HoatDong(
		int loaiTaiKhoan, Boolean hoatDong, int start, int end,
		OrderByComparator<TaiKhoanDoiUng> orderByComparator) {

		return getPersistence().findByLoaiTaiKhoan_HoatDong(
			loaiTaiKhoan, hoatDong, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the tai khoan doi ungs where loaiTaiKhoan = &#63; and hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaiKhoanDoiUngModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param loaiTaiKhoan the loai tai khoan
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of tai khoan doi ungs
	 * @param end the upper bound of the range of tai khoan doi ungs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching tai khoan doi ungs
	 */
	public static List<TaiKhoanDoiUng> findByLoaiTaiKhoan_HoatDong(
		int loaiTaiKhoan, Boolean hoatDong, int start, int end,
		OrderByComparator<TaiKhoanDoiUng> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByLoaiTaiKhoan_HoatDong(
			loaiTaiKhoan, hoatDong, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	 * Returns the first tai khoan doi ung in the ordered set where loaiTaiKhoan = &#63; and hoatDong = &#63;.
	 *
	 * @param loaiTaiKhoan the loai tai khoan
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tai khoan doi ung
	 * @throws NoSuchTaiKhoanDoiUngException if a matching tai khoan doi ung could not be found
	 */
	public static TaiKhoanDoiUng findByLoaiTaiKhoan_HoatDong_First(
			int loaiTaiKhoan, Boolean hoatDong,
			OrderByComparator<TaiKhoanDoiUng> orderByComparator)
		throws com.mb.exception.NoSuchTaiKhoanDoiUngException {

		return getPersistence().findByLoaiTaiKhoan_HoatDong_First(
			loaiTaiKhoan, hoatDong, orderByComparator);
	}

	/**
	 * Returns the first tai khoan doi ung in the ordered set where loaiTaiKhoan = &#63; and hoatDong = &#63;.
	 *
	 * @param loaiTaiKhoan the loai tai khoan
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tai khoan doi ung, or <code>null</code> if a matching tai khoan doi ung could not be found
	 */
	public static TaiKhoanDoiUng fetchByLoaiTaiKhoan_HoatDong_First(
		int loaiTaiKhoan, Boolean hoatDong,
		OrderByComparator<TaiKhoanDoiUng> orderByComparator) {

		return getPersistence().fetchByLoaiTaiKhoan_HoatDong_First(
			loaiTaiKhoan, hoatDong, orderByComparator);
	}

	/**
	 * Returns the last tai khoan doi ung in the ordered set where loaiTaiKhoan = &#63; and hoatDong = &#63;.
	 *
	 * @param loaiTaiKhoan the loai tai khoan
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tai khoan doi ung
	 * @throws NoSuchTaiKhoanDoiUngException if a matching tai khoan doi ung could not be found
	 */
	public static TaiKhoanDoiUng findByLoaiTaiKhoan_HoatDong_Last(
			int loaiTaiKhoan, Boolean hoatDong,
			OrderByComparator<TaiKhoanDoiUng> orderByComparator)
		throws com.mb.exception.NoSuchTaiKhoanDoiUngException {

		return getPersistence().findByLoaiTaiKhoan_HoatDong_Last(
			loaiTaiKhoan, hoatDong, orderByComparator);
	}

	/**
	 * Returns the last tai khoan doi ung in the ordered set where loaiTaiKhoan = &#63; and hoatDong = &#63;.
	 *
	 * @param loaiTaiKhoan the loai tai khoan
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tai khoan doi ung, or <code>null</code> if a matching tai khoan doi ung could not be found
	 */
	public static TaiKhoanDoiUng fetchByLoaiTaiKhoan_HoatDong_Last(
		int loaiTaiKhoan, Boolean hoatDong,
		OrderByComparator<TaiKhoanDoiUng> orderByComparator) {

		return getPersistence().fetchByLoaiTaiKhoan_HoatDong_Last(
			loaiTaiKhoan, hoatDong, orderByComparator);
	}

	/**
	 * Returns the tai khoan doi ungs before and after the current tai khoan doi ung in the ordered set where loaiTaiKhoan = &#63; and hoatDong = &#63;.
	 *
	 * @param taiKhoanDoiUngId the primary key of the current tai khoan doi ung
	 * @param loaiTaiKhoan the loai tai khoan
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tai khoan doi ung
	 * @throws NoSuchTaiKhoanDoiUngException if a tai khoan doi ung with the primary key could not be found
	 */
	public static TaiKhoanDoiUng[] findByLoaiTaiKhoan_HoatDong_PrevAndNext(
			long taiKhoanDoiUngId, int loaiTaiKhoan, Boolean hoatDong,
			OrderByComparator<TaiKhoanDoiUng> orderByComparator)
		throws com.mb.exception.NoSuchTaiKhoanDoiUngException {

		return getPersistence().findByLoaiTaiKhoan_HoatDong_PrevAndNext(
			taiKhoanDoiUngId, loaiTaiKhoan, hoatDong, orderByComparator);
	}

	/**
	 * Removes all the tai khoan doi ungs where loaiTaiKhoan = &#63; and hoatDong = &#63; from the database.
	 *
	 * @param loaiTaiKhoan the loai tai khoan
	 * @param hoatDong the hoat dong
	 */
	public static void removeByLoaiTaiKhoan_HoatDong(
		int loaiTaiKhoan, Boolean hoatDong) {

		getPersistence().removeByLoaiTaiKhoan_HoatDong(loaiTaiKhoan, hoatDong);
	}

	/**
	 * Returns the number of tai khoan doi ungs where loaiTaiKhoan = &#63; and hoatDong = &#63;.
	 *
	 * @param loaiTaiKhoan the loai tai khoan
	 * @param hoatDong the hoat dong
	 * @return the number of matching tai khoan doi ungs
	 */
	public static int countByLoaiTaiKhoan_HoatDong(
		int loaiTaiKhoan, Boolean hoatDong) {

		return getPersistence().countByLoaiTaiKhoan_HoatDong(
			loaiTaiKhoan, hoatDong);
	}

	/**
	 * Returns all the tai khoan doi ungs where taiKhoanDoiUngChaId = &#63; and hoatDong = &#63;.
	 *
	 * @param taiKhoanDoiUngChaId the tai khoan doi ung cha ID
	 * @param hoatDong the hoat dong
	 * @return the matching tai khoan doi ungs
	 */
	public static List<TaiKhoanDoiUng> findByTaiKhoanDoiUngChaId_HoatDong(
		long taiKhoanDoiUngChaId, Boolean hoatDong) {

		return getPersistence().findByTaiKhoanDoiUngChaId_HoatDong(
			taiKhoanDoiUngChaId, hoatDong);
	}

	/**
	 * Returns a range of all the tai khoan doi ungs where taiKhoanDoiUngChaId = &#63; and hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaiKhoanDoiUngModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param taiKhoanDoiUngChaId the tai khoan doi ung cha ID
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of tai khoan doi ungs
	 * @param end the upper bound of the range of tai khoan doi ungs (not inclusive)
	 * @return the range of matching tai khoan doi ungs
	 */
	public static List<TaiKhoanDoiUng> findByTaiKhoanDoiUngChaId_HoatDong(
		long taiKhoanDoiUngChaId, Boolean hoatDong, int start, int end) {

		return getPersistence().findByTaiKhoanDoiUngChaId_HoatDong(
			taiKhoanDoiUngChaId, hoatDong, start, end);
	}

	/**
	 * Returns an ordered range of all the tai khoan doi ungs where taiKhoanDoiUngChaId = &#63; and hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaiKhoanDoiUngModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param taiKhoanDoiUngChaId the tai khoan doi ung cha ID
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of tai khoan doi ungs
	 * @param end the upper bound of the range of tai khoan doi ungs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tai khoan doi ungs
	 */
	public static List<TaiKhoanDoiUng> findByTaiKhoanDoiUngChaId_HoatDong(
		long taiKhoanDoiUngChaId, Boolean hoatDong, int start, int end,
		OrderByComparator<TaiKhoanDoiUng> orderByComparator) {

		return getPersistence().findByTaiKhoanDoiUngChaId_HoatDong(
			taiKhoanDoiUngChaId, hoatDong, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the tai khoan doi ungs where taiKhoanDoiUngChaId = &#63; and hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaiKhoanDoiUngModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param taiKhoanDoiUngChaId the tai khoan doi ung cha ID
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of tai khoan doi ungs
	 * @param end the upper bound of the range of tai khoan doi ungs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching tai khoan doi ungs
	 */
	public static List<TaiKhoanDoiUng> findByTaiKhoanDoiUngChaId_HoatDong(
		long taiKhoanDoiUngChaId, Boolean hoatDong, int start, int end,
		OrderByComparator<TaiKhoanDoiUng> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByTaiKhoanDoiUngChaId_HoatDong(
			taiKhoanDoiUngChaId, hoatDong, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	 * Returns the first tai khoan doi ung in the ordered set where taiKhoanDoiUngChaId = &#63; and hoatDong = &#63;.
	 *
	 * @param taiKhoanDoiUngChaId the tai khoan doi ung cha ID
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tai khoan doi ung
	 * @throws NoSuchTaiKhoanDoiUngException if a matching tai khoan doi ung could not be found
	 */
	public static TaiKhoanDoiUng findByTaiKhoanDoiUngChaId_HoatDong_First(
			long taiKhoanDoiUngChaId, Boolean hoatDong,
			OrderByComparator<TaiKhoanDoiUng> orderByComparator)
		throws com.mb.exception.NoSuchTaiKhoanDoiUngException {

		return getPersistence().findByTaiKhoanDoiUngChaId_HoatDong_First(
			taiKhoanDoiUngChaId, hoatDong, orderByComparator);
	}

	/**
	 * Returns the first tai khoan doi ung in the ordered set where taiKhoanDoiUngChaId = &#63; and hoatDong = &#63;.
	 *
	 * @param taiKhoanDoiUngChaId the tai khoan doi ung cha ID
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tai khoan doi ung, or <code>null</code> if a matching tai khoan doi ung could not be found
	 */
	public static TaiKhoanDoiUng fetchByTaiKhoanDoiUngChaId_HoatDong_First(
		long taiKhoanDoiUngChaId, Boolean hoatDong,
		OrderByComparator<TaiKhoanDoiUng> orderByComparator) {

		return getPersistence().fetchByTaiKhoanDoiUngChaId_HoatDong_First(
			taiKhoanDoiUngChaId, hoatDong, orderByComparator);
	}

	/**
	 * Returns the last tai khoan doi ung in the ordered set where taiKhoanDoiUngChaId = &#63; and hoatDong = &#63;.
	 *
	 * @param taiKhoanDoiUngChaId the tai khoan doi ung cha ID
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tai khoan doi ung
	 * @throws NoSuchTaiKhoanDoiUngException if a matching tai khoan doi ung could not be found
	 */
	public static TaiKhoanDoiUng findByTaiKhoanDoiUngChaId_HoatDong_Last(
			long taiKhoanDoiUngChaId, Boolean hoatDong,
			OrderByComparator<TaiKhoanDoiUng> orderByComparator)
		throws com.mb.exception.NoSuchTaiKhoanDoiUngException {

		return getPersistence().findByTaiKhoanDoiUngChaId_HoatDong_Last(
			taiKhoanDoiUngChaId, hoatDong, orderByComparator);
	}

	/**
	 * Returns the last tai khoan doi ung in the ordered set where taiKhoanDoiUngChaId = &#63; and hoatDong = &#63;.
	 *
	 * @param taiKhoanDoiUngChaId the tai khoan doi ung cha ID
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tai khoan doi ung, or <code>null</code> if a matching tai khoan doi ung could not be found
	 */
	public static TaiKhoanDoiUng fetchByTaiKhoanDoiUngChaId_HoatDong_Last(
		long taiKhoanDoiUngChaId, Boolean hoatDong,
		OrderByComparator<TaiKhoanDoiUng> orderByComparator) {

		return getPersistence().fetchByTaiKhoanDoiUngChaId_HoatDong_Last(
			taiKhoanDoiUngChaId, hoatDong, orderByComparator);
	}

	/**
	 * Returns the tai khoan doi ungs before and after the current tai khoan doi ung in the ordered set where taiKhoanDoiUngChaId = &#63; and hoatDong = &#63;.
	 *
	 * @param taiKhoanDoiUngId the primary key of the current tai khoan doi ung
	 * @param taiKhoanDoiUngChaId the tai khoan doi ung cha ID
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tai khoan doi ung
	 * @throws NoSuchTaiKhoanDoiUngException if a tai khoan doi ung with the primary key could not be found
	 */
	public static TaiKhoanDoiUng[]
			findByTaiKhoanDoiUngChaId_HoatDong_PrevAndNext(
				long taiKhoanDoiUngId, long taiKhoanDoiUngChaId,
				Boolean hoatDong,
				OrderByComparator<TaiKhoanDoiUng> orderByComparator)
		throws com.mb.exception.NoSuchTaiKhoanDoiUngException {

		return getPersistence().findByTaiKhoanDoiUngChaId_HoatDong_PrevAndNext(
			taiKhoanDoiUngId, taiKhoanDoiUngChaId, hoatDong, orderByComparator);
	}

	/**
	 * Removes all the tai khoan doi ungs where taiKhoanDoiUngChaId = &#63; and hoatDong = &#63; from the database.
	 *
	 * @param taiKhoanDoiUngChaId the tai khoan doi ung cha ID
	 * @param hoatDong the hoat dong
	 */
	public static void removeByTaiKhoanDoiUngChaId_HoatDong(
		long taiKhoanDoiUngChaId, Boolean hoatDong) {

		getPersistence().removeByTaiKhoanDoiUngChaId_HoatDong(
			taiKhoanDoiUngChaId, hoatDong);
	}

	/**
	 * Returns the number of tai khoan doi ungs where taiKhoanDoiUngChaId = &#63; and hoatDong = &#63;.
	 *
	 * @param taiKhoanDoiUngChaId the tai khoan doi ung cha ID
	 * @param hoatDong the hoat dong
	 * @return the number of matching tai khoan doi ungs
	 */
	public static int countByTaiKhoanDoiUngChaId_HoatDong(
		long taiKhoanDoiUngChaId, Boolean hoatDong) {

		return getPersistence().countByTaiKhoanDoiUngChaId_HoatDong(
			taiKhoanDoiUngChaId, hoatDong);
	}

	/**
	 * Caches the tai khoan doi ung in the entity cache if it is enabled.
	 *
	 * @param taiKhoanDoiUng the tai khoan doi ung
	 */
	public static void cacheResult(TaiKhoanDoiUng taiKhoanDoiUng) {
		getPersistence().cacheResult(taiKhoanDoiUng);
	}

	/**
	 * Caches the tai khoan doi ungs in the entity cache if it is enabled.
	 *
	 * @param taiKhoanDoiUngs the tai khoan doi ungs
	 */
	public static void cacheResult(List<TaiKhoanDoiUng> taiKhoanDoiUngs) {
		getPersistence().cacheResult(taiKhoanDoiUngs);
	}

	/**
	 * Creates a new tai khoan doi ung with the primary key. Does not add the tai khoan doi ung to the database.
	 *
	 * @param taiKhoanDoiUngId the primary key for the new tai khoan doi ung
	 * @return the new tai khoan doi ung
	 */
	public static TaiKhoanDoiUng create(long taiKhoanDoiUngId) {
		return getPersistence().create(taiKhoanDoiUngId);
	}

	/**
	 * Removes the tai khoan doi ung with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taiKhoanDoiUngId the primary key of the tai khoan doi ung
	 * @return the tai khoan doi ung that was removed
	 * @throws NoSuchTaiKhoanDoiUngException if a tai khoan doi ung with the primary key could not be found
	 */
	public static TaiKhoanDoiUng remove(long taiKhoanDoiUngId)
		throws com.mb.exception.NoSuchTaiKhoanDoiUngException {

		return getPersistence().remove(taiKhoanDoiUngId);
	}

	public static TaiKhoanDoiUng updateImpl(TaiKhoanDoiUng taiKhoanDoiUng) {
		return getPersistence().updateImpl(taiKhoanDoiUng);
	}

	/**
	 * Returns the tai khoan doi ung with the primary key or throws a <code>NoSuchTaiKhoanDoiUngException</code> if it could not be found.
	 *
	 * @param taiKhoanDoiUngId the primary key of the tai khoan doi ung
	 * @return the tai khoan doi ung
	 * @throws NoSuchTaiKhoanDoiUngException if a tai khoan doi ung with the primary key could not be found
	 */
	public static TaiKhoanDoiUng findByPrimaryKey(long taiKhoanDoiUngId)
		throws com.mb.exception.NoSuchTaiKhoanDoiUngException {

		return getPersistence().findByPrimaryKey(taiKhoanDoiUngId);
	}

	/**
	 * Returns the tai khoan doi ung with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param taiKhoanDoiUngId the primary key of the tai khoan doi ung
	 * @return the tai khoan doi ung, or <code>null</code> if a tai khoan doi ung with the primary key could not be found
	 */
	public static TaiKhoanDoiUng fetchByPrimaryKey(long taiKhoanDoiUngId) {
		return getPersistence().fetchByPrimaryKey(taiKhoanDoiUngId);
	}

	/**
	 * Returns all the tai khoan doi ungs.
	 *
	 * @return the tai khoan doi ungs
	 */
	public static List<TaiKhoanDoiUng> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the tai khoan doi ungs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaiKhoanDoiUngModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tai khoan doi ungs
	 * @param end the upper bound of the range of tai khoan doi ungs (not inclusive)
	 * @return the range of tai khoan doi ungs
	 */
	public static List<TaiKhoanDoiUng> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the tai khoan doi ungs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaiKhoanDoiUngModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tai khoan doi ungs
	 * @param end the upper bound of the range of tai khoan doi ungs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tai khoan doi ungs
	 */
	public static List<TaiKhoanDoiUng> findAll(
		int start, int end,
		OrderByComparator<TaiKhoanDoiUng> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the tai khoan doi ungs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaiKhoanDoiUngModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tai khoan doi ungs
	 * @param end the upper bound of the range of tai khoan doi ungs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of tai khoan doi ungs
	 */
	public static List<TaiKhoanDoiUng> findAll(
		int start, int end, OrderByComparator<TaiKhoanDoiUng> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the tai khoan doi ungs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of tai khoan doi ungs.
	 *
	 * @return the number of tai khoan doi ungs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TaiKhoanDoiUngPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<TaiKhoanDoiUngPersistence, TaiKhoanDoiUngPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			TaiKhoanDoiUngPersistence.class);

		ServiceTracker<TaiKhoanDoiUngPersistence, TaiKhoanDoiUngPersistence>
			serviceTracker =
				new ServiceTracker
					<TaiKhoanDoiUngPersistence, TaiKhoanDoiUngPersistence>(
						bundle.getBundleContext(),
						TaiKhoanDoiUngPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}