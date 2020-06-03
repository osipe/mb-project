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

import com.mb.model.MaSoThuChi;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the ma so thu chi service. This utility wraps <code>com.mb.service.persistence.impl.MaSoThuChiPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MaSoThuChiPersistence
 * @generated
 */
@ProviderType
public class MaSoThuChiUtil {

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
	public static void clearCache(MaSoThuChi maSoThuChi) {
		getPersistence().clearCache(maSoThuChi);
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
	public static Map<Serializable, MaSoThuChi> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<MaSoThuChi> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MaSoThuChi> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MaSoThuChi> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MaSoThuChi> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MaSoThuChi update(MaSoThuChi maSoThuChi) {
		return getPersistence().update(maSoThuChi);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MaSoThuChi update(
		MaSoThuChi maSoThuChi, ServiceContext serviceContext) {

		return getPersistence().update(maSoThuChi, serviceContext);
	}

	/**
	 * Returns the ma so thu chi where ma = &#63; and loai = &#63; and hoatDong = &#63; or throws a <code>NoSuchMaSoThuChiException</code> if it could not be found.
	 *
	 * @param ma the ma
	 * @param loai the loai
	 * @param hoatDong the hoat dong
	 * @return the matching ma so thu chi
	 * @throws NoSuchMaSoThuChiException if a matching ma so thu chi could not be found
	 */
	public static MaSoThuChi findByMa_Loai_HoatDong(
			String ma, int loai, Boolean hoatDong)
		throws com.mb.exception.NoSuchMaSoThuChiException {

		return getPersistence().findByMa_Loai_HoatDong(ma, loai, hoatDong);
	}

	/**
	 * Returns the ma so thu chi where ma = &#63; and loai = &#63; and hoatDong = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ma the ma
	 * @param loai the loai
	 * @param hoatDong the hoat dong
	 * @return the matching ma so thu chi, or <code>null</code> if a matching ma so thu chi could not be found
	 */
	public static MaSoThuChi fetchByMa_Loai_HoatDong(
		String ma, int loai, Boolean hoatDong) {

		return getPersistence().fetchByMa_Loai_HoatDong(ma, loai, hoatDong);
	}

	/**
	 * Returns the ma so thu chi where ma = &#63; and loai = &#63; and hoatDong = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ma the ma
	 * @param loai the loai
	 * @param hoatDong the hoat dong
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching ma so thu chi, or <code>null</code> if a matching ma so thu chi could not be found
	 */
	public static MaSoThuChi fetchByMa_Loai_HoatDong(
		String ma, int loai, Boolean hoatDong, boolean retrieveFromCache) {

		return getPersistence().fetchByMa_Loai_HoatDong(
			ma, loai, hoatDong, retrieveFromCache);
	}

	/**
	 * Removes the ma so thu chi where ma = &#63; and loai = &#63; and hoatDong = &#63; from the database.
	 *
	 * @param ma the ma
	 * @param loai the loai
	 * @param hoatDong the hoat dong
	 * @return the ma so thu chi that was removed
	 */
	public static MaSoThuChi removeByMa_Loai_HoatDong(
			String ma, int loai, Boolean hoatDong)
		throws com.mb.exception.NoSuchMaSoThuChiException {

		return getPersistence().removeByMa_Loai_HoatDong(ma, loai, hoatDong);
	}

	/**
	 * Returns the number of ma so thu chis where ma = &#63; and loai = &#63; and hoatDong = &#63;.
	 *
	 * @param ma the ma
	 * @param loai the loai
	 * @param hoatDong the hoat dong
	 * @return the number of matching ma so thu chis
	 */
	public static int countByMa_Loai_HoatDong(
		String ma, int loai, Boolean hoatDong) {

		return getPersistence().countByMa_Loai_HoatDong(ma, loai, hoatDong);
	}

	/**
	 * Returns all the ma so thu chis where loai = &#63; and hoatDong = &#63;.
	 *
	 * @param loai the loai
	 * @param hoatDong the hoat dong
	 * @return the matching ma so thu chis
	 */
	public static List<MaSoThuChi> findByLoai_HoatDong(
		int loai, Boolean hoatDong) {

		return getPersistence().findByLoai_HoatDong(loai, hoatDong);
	}

	/**
	 * Returns a range of all the ma so thu chis where loai = &#63; and hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MaSoThuChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param loai the loai
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of ma so thu chis
	 * @param end the upper bound of the range of ma so thu chis (not inclusive)
	 * @return the range of matching ma so thu chis
	 */
	public static List<MaSoThuChi> findByLoai_HoatDong(
		int loai, Boolean hoatDong, int start, int end) {

		return getPersistence().findByLoai_HoatDong(loai, hoatDong, start, end);
	}

	/**
	 * Returns an ordered range of all the ma so thu chis where loai = &#63; and hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MaSoThuChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param loai the loai
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of ma so thu chis
	 * @param end the upper bound of the range of ma so thu chis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ma so thu chis
	 */
	public static List<MaSoThuChi> findByLoai_HoatDong(
		int loai, Boolean hoatDong, int start, int end,
		OrderByComparator<MaSoThuChi> orderByComparator) {

		return getPersistence().findByLoai_HoatDong(
			loai, hoatDong, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ma so thu chis where loai = &#63; and hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MaSoThuChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param loai the loai
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of ma so thu chis
	 * @param end the upper bound of the range of ma so thu chis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching ma so thu chis
	 */
	public static List<MaSoThuChi> findByLoai_HoatDong(
		int loai, Boolean hoatDong, int start, int end,
		OrderByComparator<MaSoThuChi> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByLoai_HoatDong(
			loai, hoatDong, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first ma so thu chi in the ordered set where loai = &#63; and hoatDong = &#63;.
	 *
	 * @param loai the loai
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ma so thu chi
	 * @throws NoSuchMaSoThuChiException if a matching ma so thu chi could not be found
	 */
	public static MaSoThuChi findByLoai_HoatDong_First(
			int loai, Boolean hoatDong,
			OrderByComparator<MaSoThuChi> orderByComparator)
		throws com.mb.exception.NoSuchMaSoThuChiException {

		return getPersistence().findByLoai_HoatDong_First(
			loai, hoatDong, orderByComparator);
	}

	/**
	 * Returns the first ma so thu chi in the ordered set where loai = &#63; and hoatDong = &#63;.
	 *
	 * @param loai the loai
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ma so thu chi, or <code>null</code> if a matching ma so thu chi could not be found
	 */
	public static MaSoThuChi fetchByLoai_HoatDong_First(
		int loai, Boolean hoatDong,
		OrderByComparator<MaSoThuChi> orderByComparator) {

		return getPersistence().fetchByLoai_HoatDong_First(
			loai, hoatDong, orderByComparator);
	}

	/**
	 * Returns the last ma so thu chi in the ordered set where loai = &#63; and hoatDong = &#63;.
	 *
	 * @param loai the loai
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ma so thu chi
	 * @throws NoSuchMaSoThuChiException if a matching ma so thu chi could not be found
	 */
	public static MaSoThuChi findByLoai_HoatDong_Last(
			int loai, Boolean hoatDong,
			OrderByComparator<MaSoThuChi> orderByComparator)
		throws com.mb.exception.NoSuchMaSoThuChiException {

		return getPersistence().findByLoai_HoatDong_Last(
			loai, hoatDong, orderByComparator);
	}

	/**
	 * Returns the last ma so thu chi in the ordered set where loai = &#63; and hoatDong = &#63;.
	 *
	 * @param loai the loai
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ma so thu chi, or <code>null</code> if a matching ma so thu chi could not be found
	 */
	public static MaSoThuChi fetchByLoai_HoatDong_Last(
		int loai, Boolean hoatDong,
		OrderByComparator<MaSoThuChi> orderByComparator) {

		return getPersistence().fetchByLoai_HoatDong_Last(
			loai, hoatDong, orderByComparator);
	}

	/**
	 * Returns the ma so thu chis before and after the current ma so thu chi in the ordered set where loai = &#63; and hoatDong = &#63;.
	 *
	 * @param maSoThuChiId the primary key of the current ma so thu chi
	 * @param loai the loai
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ma so thu chi
	 * @throws NoSuchMaSoThuChiException if a ma so thu chi with the primary key could not be found
	 */
	public static MaSoThuChi[] findByLoai_HoatDong_PrevAndNext(
			long maSoThuChiId, int loai, Boolean hoatDong,
			OrderByComparator<MaSoThuChi> orderByComparator)
		throws com.mb.exception.NoSuchMaSoThuChiException {

		return getPersistence().findByLoai_HoatDong_PrevAndNext(
			maSoThuChiId, loai, hoatDong, orderByComparator);
	}

	/**
	 * Removes all the ma so thu chis where loai = &#63; and hoatDong = &#63; from the database.
	 *
	 * @param loai the loai
	 * @param hoatDong the hoat dong
	 */
	public static void removeByLoai_HoatDong(int loai, Boolean hoatDong) {
		getPersistence().removeByLoai_HoatDong(loai, hoatDong);
	}

	/**
	 * Returns the number of ma so thu chis where loai = &#63; and hoatDong = &#63;.
	 *
	 * @param loai the loai
	 * @param hoatDong the hoat dong
	 * @return the number of matching ma so thu chis
	 */
	public static int countByLoai_HoatDong(int loai, Boolean hoatDong) {
		return getPersistence().countByLoai_HoatDong(loai, hoatDong);
	}

	/**
	 * Caches the ma so thu chi in the entity cache if it is enabled.
	 *
	 * @param maSoThuChi the ma so thu chi
	 */
	public static void cacheResult(MaSoThuChi maSoThuChi) {
		getPersistence().cacheResult(maSoThuChi);
	}

	/**
	 * Caches the ma so thu chis in the entity cache if it is enabled.
	 *
	 * @param maSoThuChis the ma so thu chis
	 */
	public static void cacheResult(List<MaSoThuChi> maSoThuChis) {
		getPersistence().cacheResult(maSoThuChis);
	}

	/**
	 * Creates a new ma so thu chi with the primary key. Does not add the ma so thu chi to the database.
	 *
	 * @param maSoThuChiId the primary key for the new ma so thu chi
	 * @return the new ma so thu chi
	 */
	public static MaSoThuChi create(long maSoThuChiId) {
		return getPersistence().create(maSoThuChiId);
	}

	/**
	 * Removes the ma so thu chi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param maSoThuChiId the primary key of the ma so thu chi
	 * @return the ma so thu chi that was removed
	 * @throws NoSuchMaSoThuChiException if a ma so thu chi with the primary key could not be found
	 */
	public static MaSoThuChi remove(long maSoThuChiId)
		throws com.mb.exception.NoSuchMaSoThuChiException {

		return getPersistence().remove(maSoThuChiId);
	}

	public static MaSoThuChi updateImpl(MaSoThuChi maSoThuChi) {
		return getPersistence().updateImpl(maSoThuChi);
	}

	/**
	 * Returns the ma so thu chi with the primary key or throws a <code>NoSuchMaSoThuChiException</code> if it could not be found.
	 *
	 * @param maSoThuChiId the primary key of the ma so thu chi
	 * @return the ma so thu chi
	 * @throws NoSuchMaSoThuChiException if a ma so thu chi with the primary key could not be found
	 */
	public static MaSoThuChi findByPrimaryKey(long maSoThuChiId)
		throws com.mb.exception.NoSuchMaSoThuChiException {

		return getPersistence().findByPrimaryKey(maSoThuChiId);
	}

	/**
	 * Returns the ma so thu chi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param maSoThuChiId the primary key of the ma so thu chi
	 * @return the ma so thu chi, or <code>null</code> if a ma so thu chi with the primary key could not be found
	 */
	public static MaSoThuChi fetchByPrimaryKey(long maSoThuChiId) {
		return getPersistence().fetchByPrimaryKey(maSoThuChiId);
	}

	/**
	 * Returns all the ma so thu chis.
	 *
	 * @return the ma so thu chis
	 */
	public static List<MaSoThuChi> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the ma so thu chis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MaSoThuChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ma so thu chis
	 * @param end the upper bound of the range of ma so thu chis (not inclusive)
	 * @return the range of ma so thu chis
	 */
	public static List<MaSoThuChi> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the ma so thu chis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MaSoThuChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ma so thu chis
	 * @param end the upper bound of the range of ma so thu chis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ma so thu chis
	 */
	public static List<MaSoThuChi> findAll(
		int start, int end, OrderByComparator<MaSoThuChi> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ma so thu chis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MaSoThuChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ma so thu chis
	 * @param end the upper bound of the range of ma so thu chis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of ma so thu chis
	 */
	public static List<MaSoThuChi> findAll(
		int start, int end, OrderByComparator<MaSoThuChi> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the ma so thu chis from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of ma so thu chis.
	 *
	 * @return the number of ma so thu chis
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MaSoThuChiPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<MaSoThuChiPersistence, MaSoThuChiPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(MaSoThuChiPersistence.class);

		ServiceTracker<MaSoThuChiPersistence, MaSoThuChiPersistence>
			serviceTracker =
				new ServiceTracker
					<MaSoThuChiPersistence, MaSoThuChiPersistence>(
						bundle.getBundleContext(), MaSoThuChiPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}