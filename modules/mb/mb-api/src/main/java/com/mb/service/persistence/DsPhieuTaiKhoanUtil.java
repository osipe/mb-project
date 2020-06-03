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

import com.mb.model.DsPhieuTaiKhoan;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the ds phieu tai khoan service. This utility wraps <code>com.mb.service.persistence.impl.DsPhieuTaiKhoanPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DsPhieuTaiKhoanPersistence
 * @generated
 */
@ProviderType
public class DsPhieuTaiKhoanUtil {

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
	public static void clearCache(DsPhieuTaiKhoan dsPhieuTaiKhoan) {
		getPersistence().clearCache(dsPhieuTaiKhoan);
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
	public static Map<Serializable, DsPhieuTaiKhoan> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DsPhieuTaiKhoan> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DsPhieuTaiKhoan> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DsPhieuTaiKhoan> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DsPhieuTaiKhoan> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DsPhieuTaiKhoan update(DsPhieuTaiKhoan dsPhieuTaiKhoan) {
		return getPersistence().update(dsPhieuTaiKhoan);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DsPhieuTaiKhoan update(
		DsPhieuTaiKhoan dsPhieuTaiKhoan, ServiceContext serviceContext) {

		return getPersistence().update(dsPhieuTaiKhoan, serviceContext);
	}

	/**
	 * Returns all the ds phieu tai khoans where taiKhoanDoiUngId = &#63; and hoatDong = &#63;.
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param hoatDong the hoat dong
	 * @return the matching ds phieu tai khoans
	 */
	public static List<DsPhieuTaiKhoan> findByTaiKhoanDoiUngId_HoatDong(
		long taiKhoanDoiUngId, Boolean hoatDong) {

		return getPersistence().findByTaiKhoanDoiUngId_HoatDong(
			taiKhoanDoiUngId, hoatDong);
	}

	/**
	 * Returns a range of all the ds phieu tai khoans where taiKhoanDoiUngId = &#63; and hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DsPhieuTaiKhoanModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of ds phieu tai khoans
	 * @param end the upper bound of the range of ds phieu tai khoans (not inclusive)
	 * @return the range of matching ds phieu tai khoans
	 */
	public static List<DsPhieuTaiKhoan> findByTaiKhoanDoiUngId_HoatDong(
		long taiKhoanDoiUngId, Boolean hoatDong, int start, int end) {

		return getPersistence().findByTaiKhoanDoiUngId_HoatDong(
			taiKhoanDoiUngId, hoatDong, start, end);
	}

	/**
	 * Returns an ordered range of all the ds phieu tai khoans where taiKhoanDoiUngId = &#63; and hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DsPhieuTaiKhoanModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of ds phieu tai khoans
	 * @param end the upper bound of the range of ds phieu tai khoans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ds phieu tai khoans
	 */
	public static List<DsPhieuTaiKhoan> findByTaiKhoanDoiUngId_HoatDong(
		long taiKhoanDoiUngId, Boolean hoatDong, int start, int end,
		OrderByComparator<DsPhieuTaiKhoan> orderByComparator) {

		return getPersistence().findByTaiKhoanDoiUngId_HoatDong(
			taiKhoanDoiUngId, hoatDong, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ds phieu tai khoans where taiKhoanDoiUngId = &#63; and hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DsPhieuTaiKhoanModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of ds phieu tai khoans
	 * @param end the upper bound of the range of ds phieu tai khoans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching ds phieu tai khoans
	 */
	public static List<DsPhieuTaiKhoan> findByTaiKhoanDoiUngId_HoatDong(
		long taiKhoanDoiUngId, Boolean hoatDong, int start, int end,
		OrderByComparator<DsPhieuTaiKhoan> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByTaiKhoanDoiUngId_HoatDong(
			taiKhoanDoiUngId, hoatDong, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	 * Returns the first ds phieu tai khoan in the ordered set where taiKhoanDoiUngId = &#63; and hoatDong = &#63;.
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ds phieu tai khoan
	 * @throws NoSuchDsPhieuTaiKhoanException if a matching ds phieu tai khoan could not be found
	 */
	public static DsPhieuTaiKhoan findByTaiKhoanDoiUngId_HoatDong_First(
			long taiKhoanDoiUngId, Boolean hoatDong,
			OrderByComparator<DsPhieuTaiKhoan> orderByComparator)
		throws com.mb.exception.NoSuchDsPhieuTaiKhoanException {

		return getPersistence().findByTaiKhoanDoiUngId_HoatDong_First(
			taiKhoanDoiUngId, hoatDong, orderByComparator);
	}

	/**
	 * Returns the first ds phieu tai khoan in the ordered set where taiKhoanDoiUngId = &#63; and hoatDong = &#63;.
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ds phieu tai khoan, or <code>null</code> if a matching ds phieu tai khoan could not be found
	 */
	public static DsPhieuTaiKhoan fetchByTaiKhoanDoiUngId_HoatDong_First(
		long taiKhoanDoiUngId, Boolean hoatDong,
		OrderByComparator<DsPhieuTaiKhoan> orderByComparator) {

		return getPersistence().fetchByTaiKhoanDoiUngId_HoatDong_First(
			taiKhoanDoiUngId, hoatDong, orderByComparator);
	}

	/**
	 * Returns the last ds phieu tai khoan in the ordered set where taiKhoanDoiUngId = &#63; and hoatDong = &#63;.
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ds phieu tai khoan
	 * @throws NoSuchDsPhieuTaiKhoanException if a matching ds phieu tai khoan could not be found
	 */
	public static DsPhieuTaiKhoan findByTaiKhoanDoiUngId_HoatDong_Last(
			long taiKhoanDoiUngId, Boolean hoatDong,
			OrderByComparator<DsPhieuTaiKhoan> orderByComparator)
		throws com.mb.exception.NoSuchDsPhieuTaiKhoanException {

		return getPersistence().findByTaiKhoanDoiUngId_HoatDong_Last(
			taiKhoanDoiUngId, hoatDong, orderByComparator);
	}

	/**
	 * Returns the last ds phieu tai khoan in the ordered set where taiKhoanDoiUngId = &#63; and hoatDong = &#63;.
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ds phieu tai khoan, or <code>null</code> if a matching ds phieu tai khoan could not be found
	 */
	public static DsPhieuTaiKhoan fetchByTaiKhoanDoiUngId_HoatDong_Last(
		long taiKhoanDoiUngId, Boolean hoatDong,
		OrderByComparator<DsPhieuTaiKhoan> orderByComparator) {

		return getPersistence().fetchByTaiKhoanDoiUngId_HoatDong_Last(
			taiKhoanDoiUngId, hoatDong, orderByComparator);
	}

	/**
	 * Returns the ds phieu tai khoans before and after the current ds phieu tai khoan in the ordered set where taiKhoanDoiUngId = &#63; and hoatDong = &#63;.
	 *
	 * @param dsPhieuTaiKhoanId the primary key of the current ds phieu tai khoan
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ds phieu tai khoan
	 * @throws NoSuchDsPhieuTaiKhoanException if a ds phieu tai khoan with the primary key could not be found
	 */
	public static DsPhieuTaiKhoan[] findByTaiKhoanDoiUngId_HoatDong_PrevAndNext(
			long dsPhieuTaiKhoanId, long taiKhoanDoiUngId, Boolean hoatDong,
			OrderByComparator<DsPhieuTaiKhoan> orderByComparator)
		throws com.mb.exception.NoSuchDsPhieuTaiKhoanException {

		return getPersistence().findByTaiKhoanDoiUngId_HoatDong_PrevAndNext(
			dsPhieuTaiKhoanId, taiKhoanDoiUngId, hoatDong, orderByComparator);
	}

	/**
	 * Removes all the ds phieu tai khoans where taiKhoanDoiUngId = &#63; and hoatDong = &#63; from the database.
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param hoatDong the hoat dong
	 */
	public static void removeByTaiKhoanDoiUngId_HoatDong(
		long taiKhoanDoiUngId, Boolean hoatDong) {

		getPersistence().removeByTaiKhoanDoiUngId_HoatDong(
			taiKhoanDoiUngId, hoatDong);
	}

	/**
	 * Returns the number of ds phieu tai khoans where taiKhoanDoiUngId = &#63; and hoatDong = &#63;.
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param hoatDong the hoat dong
	 * @return the number of matching ds phieu tai khoans
	 */
	public static int countByTaiKhoanDoiUngId_HoatDong(
		long taiKhoanDoiUngId, Boolean hoatDong) {

		return getPersistence().countByTaiKhoanDoiUngId_HoatDong(
			taiKhoanDoiUngId, hoatDong);
	}

	/**
	 * Returns all the ds phieu tai khoans where phieuId = &#63; and hoatDong = &#63;.
	 *
	 * @param phieuId the phieu ID
	 * @param hoatDong the hoat dong
	 * @return the matching ds phieu tai khoans
	 */
	public static List<DsPhieuTaiKhoan> findByPhieuId_HoatDong(
		long phieuId, Boolean hoatDong) {

		return getPersistence().findByPhieuId_HoatDong(phieuId, hoatDong);
	}

	/**
	 * Returns a range of all the ds phieu tai khoans where phieuId = &#63; and hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DsPhieuTaiKhoanModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phieuId the phieu ID
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of ds phieu tai khoans
	 * @param end the upper bound of the range of ds phieu tai khoans (not inclusive)
	 * @return the range of matching ds phieu tai khoans
	 */
	public static List<DsPhieuTaiKhoan> findByPhieuId_HoatDong(
		long phieuId, Boolean hoatDong, int start, int end) {

		return getPersistence().findByPhieuId_HoatDong(
			phieuId, hoatDong, start, end);
	}

	/**
	 * Returns an ordered range of all the ds phieu tai khoans where phieuId = &#63; and hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DsPhieuTaiKhoanModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phieuId the phieu ID
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of ds phieu tai khoans
	 * @param end the upper bound of the range of ds phieu tai khoans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ds phieu tai khoans
	 */
	public static List<DsPhieuTaiKhoan> findByPhieuId_HoatDong(
		long phieuId, Boolean hoatDong, int start, int end,
		OrderByComparator<DsPhieuTaiKhoan> orderByComparator) {

		return getPersistence().findByPhieuId_HoatDong(
			phieuId, hoatDong, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ds phieu tai khoans where phieuId = &#63; and hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DsPhieuTaiKhoanModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phieuId the phieu ID
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of ds phieu tai khoans
	 * @param end the upper bound of the range of ds phieu tai khoans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching ds phieu tai khoans
	 */
	public static List<DsPhieuTaiKhoan> findByPhieuId_HoatDong(
		long phieuId, Boolean hoatDong, int start, int end,
		OrderByComparator<DsPhieuTaiKhoan> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByPhieuId_HoatDong(
			phieuId, hoatDong, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	 * Returns the first ds phieu tai khoan in the ordered set where phieuId = &#63; and hoatDong = &#63;.
	 *
	 * @param phieuId the phieu ID
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ds phieu tai khoan
	 * @throws NoSuchDsPhieuTaiKhoanException if a matching ds phieu tai khoan could not be found
	 */
	public static DsPhieuTaiKhoan findByPhieuId_HoatDong_First(
			long phieuId, Boolean hoatDong,
			OrderByComparator<DsPhieuTaiKhoan> orderByComparator)
		throws com.mb.exception.NoSuchDsPhieuTaiKhoanException {

		return getPersistence().findByPhieuId_HoatDong_First(
			phieuId, hoatDong, orderByComparator);
	}

	/**
	 * Returns the first ds phieu tai khoan in the ordered set where phieuId = &#63; and hoatDong = &#63;.
	 *
	 * @param phieuId the phieu ID
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ds phieu tai khoan, or <code>null</code> if a matching ds phieu tai khoan could not be found
	 */
	public static DsPhieuTaiKhoan fetchByPhieuId_HoatDong_First(
		long phieuId, Boolean hoatDong,
		OrderByComparator<DsPhieuTaiKhoan> orderByComparator) {

		return getPersistence().fetchByPhieuId_HoatDong_First(
			phieuId, hoatDong, orderByComparator);
	}

	/**
	 * Returns the last ds phieu tai khoan in the ordered set where phieuId = &#63; and hoatDong = &#63;.
	 *
	 * @param phieuId the phieu ID
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ds phieu tai khoan
	 * @throws NoSuchDsPhieuTaiKhoanException if a matching ds phieu tai khoan could not be found
	 */
	public static DsPhieuTaiKhoan findByPhieuId_HoatDong_Last(
			long phieuId, Boolean hoatDong,
			OrderByComparator<DsPhieuTaiKhoan> orderByComparator)
		throws com.mb.exception.NoSuchDsPhieuTaiKhoanException {

		return getPersistence().findByPhieuId_HoatDong_Last(
			phieuId, hoatDong, orderByComparator);
	}

	/**
	 * Returns the last ds phieu tai khoan in the ordered set where phieuId = &#63; and hoatDong = &#63;.
	 *
	 * @param phieuId the phieu ID
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ds phieu tai khoan, or <code>null</code> if a matching ds phieu tai khoan could not be found
	 */
	public static DsPhieuTaiKhoan fetchByPhieuId_HoatDong_Last(
		long phieuId, Boolean hoatDong,
		OrderByComparator<DsPhieuTaiKhoan> orderByComparator) {

		return getPersistence().fetchByPhieuId_HoatDong_Last(
			phieuId, hoatDong, orderByComparator);
	}

	/**
	 * Returns the ds phieu tai khoans before and after the current ds phieu tai khoan in the ordered set where phieuId = &#63; and hoatDong = &#63;.
	 *
	 * @param dsPhieuTaiKhoanId the primary key of the current ds phieu tai khoan
	 * @param phieuId the phieu ID
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ds phieu tai khoan
	 * @throws NoSuchDsPhieuTaiKhoanException if a ds phieu tai khoan with the primary key could not be found
	 */
	public static DsPhieuTaiKhoan[] findByPhieuId_HoatDong_PrevAndNext(
			long dsPhieuTaiKhoanId, long phieuId, Boolean hoatDong,
			OrderByComparator<DsPhieuTaiKhoan> orderByComparator)
		throws com.mb.exception.NoSuchDsPhieuTaiKhoanException {

		return getPersistence().findByPhieuId_HoatDong_PrevAndNext(
			dsPhieuTaiKhoanId, phieuId, hoatDong, orderByComparator);
	}

	/**
	 * Removes all the ds phieu tai khoans where phieuId = &#63; and hoatDong = &#63; from the database.
	 *
	 * @param phieuId the phieu ID
	 * @param hoatDong the hoat dong
	 */
	public static void removeByPhieuId_HoatDong(
		long phieuId, Boolean hoatDong) {

		getPersistence().removeByPhieuId_HoatDong(phieuId, hoatDong);
	}

	/**
	 * Returns the number of ds phieu tai khoans where phieuId = &#63; and hoatDong = &#63;.
	 *
	 * @param phieuId the phieu ID
	 * @param hoatDong the hoat dong
	 * @return the number of matching ds phieu tai khoans
	 */
	public static int countByPhieuId_HoatDong(long phieuId, Boolean hoatDong) {
		return getPersistence().countByPhieuId_HoatDong(phieuId, hoatDong);
	}

	/**
	 * Returns all the ds phieu tai khoans where phieuId = &#63;.
	 *
	 * @param phieuId the phieu ID
	 * @return the matching ds phieu tai khoans
	 */
	public static List<DsPhieuTaiKhoan> findByPhieuId(long phieuId) {
		return getPersistence().findByPhieuId(phieuId);
	}

	/**
	 * Returns a range of all the ds phieu tai khoans where phieuId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DsPhieuTaiKhoanModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phieuId the phieu ID
	 * @param start the lower bound of the range of ds phieu tai khoans
	 * @param end the upper bound of the range of ds phieu tai khoans (not inclusive)
	 * @return the range of matching ds phieu tai khoans
	 */
	public static List<DsPhieuTaiKhoan> findByPhieuId(
		long phieuId, int start, int end) {

		return getPersistence().findByPhieuId(phieuId, start, end);
	}

	/**
	 * Returns an ordered range of all the ds phieu tai khoans where phieuId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DsPhieuTaiKhoanModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phieuId the phieu ID
	 * @param start the lower bound of the range of ds phieu tai khoans
	 * @param end the upper bound of the range of ds phieu tai khoans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ds phieu tai khoans
	 */
	public static List<DsPhieuTaiKhoan> findByPhieuId(
		long phieuId, int start, int end,
		OrderByComparator<DsPhieuTaiKhoan> orderByComparator) {

		return getPersistence().findByPhieuId(
			phieuId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ds phieu tai khoans where phieuId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DsPhieuTaiKhoanModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phieuId the phieu ID
	 * @param start the lower bound of the range of ds phieu tai khoans
	 * @param end the upper bound of the range of ds phieu tai khoans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching ds phieu tai khoans
	 */
	public static List<DsPhieuTaiKhoan> findByPhieuId(
		long phieuId, int start, int end,
		OrderByComparator<DsPhieuTaiKhoan> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByPhieuId(
			phieuId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first ds phieu tai khoan in the ordered set where phieuId = &#63;.
	 *
	 * @param phieuId the phieu ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ds phieu tai khoan
	 * @throws NoSuchDsPhieuTaiKhoanException if a matching ds phieu tai khoan could not be found
	 */
	public static DsPhieuTaiKhoan findByPhieuId_First(
			long phieuId, OrderByComparator<DsPhieuTaiKhoan> orderByComparator)
		throws com.mb.exception.NoSuchDsPhieuTaiKhoanException {

		return getPersistence().findByPhieuId_First(phieuId, orderByComparator);
	}

	/**
	 * Returns the first ds phieu tai khoan in the ordered set where phieuId = &#63;.
	 *
	 * @param phieuId the phieu ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ds phieu tai khoan, or <code>null</code> if a matching ds phieu tai khoan could not be found
	 */
	public static DsPhieuTaiKhoan fetchByPhieuId_First(
		long phieuId, OrderByComparator<DsPhieuTaiKhoan> orderByComparator) {

		return getPersistence().fetchByPhieuId_First(
			phieuId, orderByComparator);
	}

	/**
	 * Returns the last ds phieu tai khoan in the ordered set where phieuId = &#63;.
	 *
	 * @param phieuId the phieu ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ds phieu tai khoan
	 * @throws NoSuchDsPhieuTaiKhoanException if a matching ds phieu tai khoan could not be found
	 */
	public static DsPhieuTaiKhoan findByPhieuId_Last(
			long phieuId, OrderByComparator<DsPhieuTaiKhoan> orderByComparator)
		throws com.mb.exception.NoSuchDsPhieuTaiKhoanException {

		return getPersistence().findByPhieuId_Last(phieuId, orderByComparator);
	}

	/**
	 * Returns the last ds phieu tai khoan in the ordered set where phieuId = &#63;.
	 *
	 * @param phieuId the phieu ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ds phieu tai khoan, or <code>null</code> if a matching ds phieu tai khoan could not be found
	 */
	public static DsPhieuTaiKhoan fetchByPhieuId_Last(
		long phieuId, OrderByComparator<DsPhieuTaiKhoan> orderByComparator) {

		return getPersistence().fetchByPhieuId_Last(phieuId, orderByComparator);
	}

	/**
	 * Returns the ds phieu tai khoans before and after the current ds phieu tai khoan in the ordered set where phieuId = &#63;.
	 *
	 * @param dsPhieuTaiKhoanId the primary key of the current ds phieu tai khoan
	 * @param phieuId the phieu ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ds phieu tai khoan
	 * @throws NoSuchDsPhieuTaiKhoanException if a ds phieu tai khoan with the primary key could not be found
	 */
	public static DsPhieuTaiKhoan[] findByPhieuId_PrevAndNext(
			long dsPhieuTaiKhoanId, long phieuId,
			OrderByComparator<DsPhieuTaiKhoan> orderByComparator)
		throws com.mb.exception.NoSuchDsPhieuTaiKhoanException {

		return getPersistence().findByPhieuId_PrevAndNext(
			dsPhieuTaiKhoanId, phieuId, orderByComparator);
	}

	/**
	 * Removes all the ds phieu tai khoans where phieuId = &#63; from the database.
	 *
	 * @param phieuId the phieu ID
	 */
	public static void removeByPhieuId(long phieuId) {
		getPersistence().removeByPhieuId(phieuId);
	}

	/**
	 * Returns the number of ds phieu tai khoans where phieuId = &#63;.
	 *
	 * @param phieuId the phieu ID
	 * @return the number of matching ds phieu tai khoans
	 */
	public static int countByPhieuId(long phieuId) {
		return getPersistence().countByPhieuId(phieuId);
	}

	/**
	 * Caches the ds phieu tai khoan in the entity cache if it is enabled.
	 *
	 * @param dsPhieuTaiKhoan the ds phieu tai khoan
	 */
	public static void cacheResult(DsPhieuTaiKhoan dsPhieuTaiKhoan) {
		getPersistence().cacheResult(dsPhieuTaiKhoan);
	}

	/**
	 * Caches the ds phieu tai khoans in the entity cache if it is enabled.
	 *
	 * @param dsPhieuTaiKhoans the ds phieu tai khoans
	 */
	public static void cacheResult(List<DsPhieuTaiKhoan> dsPhieuTaiKhoans) {
		getPersistence().cacheResult(dsPhieuTaiKhoans);
	}

	/**
	 * Creates a new ds phieu tai khoan with the primary key. Does not add the ds phieu tai khoan to the database.
	 *
	 * @param dsPhieuTaiKhoanId the primary key for the new ds phieu tai khoan
	 * @return the new ds phieu tai khoan
	 */
	public static DsPhieuTaiKhoan create(long dsPhieuTaiKhoanId) {
		return getPersistence().create(dsPhieuTaiKhoanId);
	}

	/**
	 * Removes the ds phieu tai khoan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dsPhieuTaiKhoanId the primary key of the ds phieu tai khoan
	 * @return the ds phieu tai khoan that was removed
	 * @throws NoSuchDsPhieuTaiKhoanException if a ds phieu tai khoan with the primary key could not be found
	 */
	public static DsPhieuTaiKhoan remove(long dsPhieuTaiKhoanId)
		throws com.mb.exception.NoSuchDsPhieuTaiKhoanException {

		return getPersistence().remove(dsPhieuTaiKhoanId);
	}

	public static DsPhieuTaiKhoan updateImpl(DsPhieuTaiKhoan dsPhieuTaiKhoan) {
		return getPersistence().updateImpl(dsPhieuTaiKhoan);
	}

	/**
	 * Returns the ds phieu tai khoan with the primary key or throws a <code>NoSuchDsPhieuTaiKhoanException</code> if it could not be found.
	 *
	 * @param dsPhieuTaiKhoanId the primary key of the ds phieu tai khoan
	 * @return the ds phieu tai khoan
	 * @throws NoSuchDsPhieuTaiKhoanException if a ds phieu tai khoan with the primary key could not be found
	 */
	public static DsPhieuTaiKhoan findByPrimaryKey(long dsPhieuTaiKhoanId)
		throws com.mb.exception.NoSuchDsPhieuTaiKhoanException {

		return getPersistence().findByPrimaryKey(dsPhieuTaiKhoanId);
	}

	/**
	 * Returns the ds phieu tai khoan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dsPhieuTaiKhoanId the primary key of the ds phieu tai khoan
	 * @return the ds phieu tai khoan, or <code>null</code> if a ds phieu tai khoan with the primary key could not be found
	 */
	public static DsPhieuTaiKhoan fetchByPrimaryKey(long dsPhieuTaiKhoanId) {
		return getPersistence().fetchByPrimaryKey(dsPhieuTaiKhoanId);
	}

	/**
	 * Returns all the ds phieu tai khoans.
	 *
	 * @return the ds phieu tai khoans
	 */
	public static List<DsPhieuTaiKhoan> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the ds phieu tai khoans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DsPhieuTaiKhoanModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ds phieu tai khoans
	 * @param end the upper bound of the range of ds phieu tai khoans (not inclusive)
	 * @return the range of ds phieu tai khoans
	 */
	public static List<DsPhieuTaiKhoan> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the ds phieu tai khoans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DsPhieuTaiKhoanModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ds phieu tai khoans
	 * @param end the upper bound of the range of ds phieu tai khoans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ds phieu tai khoans
	 */
	public static List<DsPhieuTaiKhoan> findAll(
		int start, int end,
		OrderByComparator<DsPhieuTaiKhoan> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ds phieu tai khoans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DsPhieuTaiKhoanModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ds phieu tai khoans
	 * @param end the upper bound of the range of ds phieu tai khoans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of ds phieu tai khoans
	 */
	public static List<DsPhieuTaiKhoan> findAll(
		int start, int end,
		OrderByComparator<DsPhieuTaiKhoan> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the ds phieu tai khoans from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of ds phieu tai khoans.
	 *
	 * @return the number of ds phieu tai khoans
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DsPhieuTaiKhoanPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<DsPhieuTaiKhoanPersistence, DsPhieuTaiKhoanPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			DsPhieuTaiKhoanPersistence.class);

		ServiceTracker<DsPhieuTaiKhoanPersistence, DsPhieuTaiKhoanPersistence>
			serviceTracker =
				new ServiceTracker
					<DsPhieuTaiKhoanPersistence, DsPhieuTaiKhoanPersistence>(
						bundle.getBundleContext(),
						DsPhieuTaiKhoanPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}