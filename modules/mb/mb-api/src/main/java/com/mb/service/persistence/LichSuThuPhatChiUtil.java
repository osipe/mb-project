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

import com.mb.model.LichSuThuPhatChi;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the lich su thu phat chi service. This utility wraps <code>com.mb.service.persistence.impl.LichSuThuPhatChiPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LichSuThuPhatChiPersistence
 * @generated
 */
@ProviderType
public class LichSuThuPhatChiUtil {

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
	public static void clearCache(LichSuThuPhatChi lichSuThuPhatChi) {
		getPersistence().clearCache(lichSuThuPhatChi);
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
	public static Map<Serializable, LichSuThuPhatChi> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LichSuThuPhatChi> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LichSuThuPhatChi> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LichSuThuPhatChi> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LichSuThuPhatChi> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LichSuThuPhatChi update(LichSuThuPhatChi lichSuThuPhatChi) {
		return getPersistence().update(lichSuThuPhatChi);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LichSuThuPhatChi update(
		LichSuThuPhatChi lichSuThuPhatChi, ServiceContext serviceContext) {

		return getPersistence().update(lichSuThuPhatChi, serviceContext);
	}

	/**
	 * Returns all the lich su thu phat chis where maCTV = &#63;.
	 *
	 * @param maCTV the ma ctv
	 * @return the matching lich su thu phat chis
	 */
	public static List<LichSuThuPhatChi> findByMaCTV(String maCTV) {
		return getPersistence().findByMaCTV(maCTV);
	}

	/**
	 * Returns a range of all the lich su thu phat chis where maCTV = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LichSuThuPhatChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param maCTV the ma ctv
	 * @param start the lower bound of the range of lich su thu phat chis
	 * @param end the upper bound of the range of lich su thu phat chis (not inclusive)
	 * @return the range of matching lich su thu phat chis
	 */
	public static List<LichSuThuPhatChi> findByMaCTV(
		String maCTV, int start, int end) {

		return getPersistence().findByMaCTV(maCTV, start, end);
	}

	/**
	 * Returns an ordered range of all the lich su thu phat chis where maCTV = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LichSuThuPhatChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param maCTV the ma ctv
	 * @param start the lower bound of the range of lich su thu phat chis
	 * @param end the upper bound of the range of lich su thu phat chis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lich su thu phat chis
	 */
	public static List<LichSuThuPhatChi> findByMaCTV(
		String maCTV, int start, int end,
		OrderByComparator<LichSuThuPhatChi> orderByComparator) {

		return getPersistence().findByMaCTV(
			maCTV, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the lich su thu phat chis where maCTV = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LichSuThuPhatChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param maCTV the ma ctv
	 * @param start the lower bound of the range of lich su thu phat chis
	 * @param end the upper bound of the range of lich su thu phat chis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching lich su thu phat chis
	 */
	public static List<LichSuThuPhatChi> findByMaCTV(
		String maCTV, int start, int end,
		OrderByComparator<LichSuThuPhatChi> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByMaCTV(
			maCTV, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first lich su thu phat chi in the ordered set where maCTV = &#63;.
	 *
	 * @param maCTV the ma ctv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lich su thu phat chi
	 * @throws NoSuchLichSuThuPhatChiException if a matching lich su thu phat chi could not be found
	 */
	public static LichSuThuPhatChi findByMaCTV_First(
			String maCTV, OrderByComparator<LichSuThuPhatChi> orderByComparator)
		throws com.mb.exception.NoSuchLichSuThuPhatChiException {

		return getPersistence().findByMaCTV_First(maCTV, orderByComparator);
	}

	/**
	 * Returns the first lich su thu phat chi in the ordered set where maCTV = &#63;.
	 *
	 * @param maCTV the ma ctv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lich su thu phat chi, or <code>null</code> if a matching lich su thu phat chi could not be found
	 */
	public static LichSuThuPhatChi fetchByMaCTV_First(
		String maCTV, OrderByComparator<LichSuThuPhatChi> orderByComparator) {

		return getPersistence().fetchByMaCTV_First(maCTV, orderByComparator);
	}

	/**
	 * Returns the last lich su thu phat chi in the ordered set where maCTV = &#63;.
	 *
	 * @param maCTV the ma ctv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lich su thu phat chi
	 * @throws NoSuchLichSuThuPhatChiException if a matching lich su thu phat chi could not be found
	 */
	public static LichSuThuPhatChi findByMaCTV_Last(
			String maCTV, OrderByComparator<LichSuThuPhatChi> orderByComparator)
		throws com.mb.exception.NoSuchLichSuThuPhatChiException {

		return getPersistence().findByMaCTV_Last(maCTV, orderByComparator);
	}

	/**
	 * Returns the last lich su thu phat chi in the ordered set where maCTV = &#63;.
	 *
	 * @param maCTV the ma ctv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lich su thu phat chi, or <code>null</code> if a matching lich su thu phat chi could not be found
	 */
	public static LichSuThuPhatChi fetchByMaCTV_Last(
		String maCTV, OrderByComparator<LichSuThuPhatChi> orderByComparator) {

		return getPersistence().fetchByMaCTV_Last(maCTV, orderByComparator);
	}

	/**
	 * Returns the lich su thu phat chis before and after the current lich su thu phat chi in the ordered set where maCTV = &#63;.
	 *
	 * @param lichSuThuPhatChiId the primary key of the current lich su thu phat chi
	 * @param maCTV the ma ctv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lich su thu phat chi
	 * @throws NoSuchLichSuThuPhatChiException if a lich su thu phat chi with the primary key could not be found
	 */
	public static LichSuThuPhatChi[] findByMaCTV_PrevAndNext(
			long lichSuThuPhatChiId, String maCTV,
			OrderByComparator<LichSuThuPhatChi> orderByComparator)
		throws com.mb.exception.NoSuchLichSuThuPhatChiException {

		return getPersistence().findByMaCTV_PrevAndNext(
			lichSuThuPhatChiId, maCTV, orderByComparator);
	}

	/**
	 * Removes all the lich su thu phat chis where maCTV = &#63; from the database.
	 *
	 * @param maCTV the ma ctv
	 */
	public static void removeByMaCTV(String maCTV) {
		getPersistence().removeByMaCTV(maCTV);
	}

	/**
	 * Returns the number of lich su thu phat chis where maCTV = &#63;.
	 *
	 * @param maCTV the ma ctv
	 * @return the number of matching lich su thu phat chis
	 */
	public static int countByMaCTV(String maCTV) {
		return getPersistence().countByMaCTV(maCTV);
	}

	/**
	 * Returns all the lich su thu phat chis where phatVayId = &#63;.
	 *
	 * @param phatVayId the phat vay ID
	 * @return the matching lich su thu phat chis
	 */
	public static List<LichSuThuPhatChi> findByPhatVayId(long phatVayId) {
		return getPersistence().findByPhatVayId(phatVayId);
	}

	/**
	 * Returns a range of all the lich su thu phat chis where phatVayId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LichSuThuPhatChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phatVayId the phat vay ID
	 * @param start the lower bound of the range of lich su thu phat chis
	 * @param end the upper bound of the range of lich su thu phat chis (not inclusive)
	 * @return the range of matching lich su thu phat chis
	 */
	public static List<LichSuThuPhatChi> findByPhatVayId(
		long phatVayId, int start, int end) {

		return getPersistence().findByPhatVayId(phatVayId, start, end);
	}

	/**
	 * Returns an ordered range of all the lich su thu phat chis where phatVayId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LichSuThuPhatChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phatVayId the phat vay ID
	 * @param start the lower bound of the range of lich su thu phat chis
	 * @param end the upper bound of the range of lich su thu phat chis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lich su thu phat chis
	 */
	public static List<LichSuThuPhatChi> findByPhatVayId(
		long phatVayId, int start, int end,
		OrderByComparator<LichSuThuPhatChi> orderByComparator) {

		return getPersistence().findByPhatVayId(
			phatVayId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the lich su thu phat chis where phatVayId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LichSuThuPhatChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phatVayId the phat vay ID
	 * @param start the lower bound of the range of lich su thu phat chis
	 * @param end the upper bound of the range of lich su thu phat chis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching lich su thu phat chis
	 */
	public static List<LichSuThuPhatChi> findByPhatVayId(
		long phatVayId, int start, int end,
		OrderByComparator<LichSuThuPhatChi> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByPhatVayId(
			phatVayId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first lich su thu phat chi in the ordered set where phatVayId = &#63;.
	 *
	 * @param phatVayId the phat vay ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lich su thu phat chi
	 * @throws NoSuchLichSuThuPhatChiException if a matching lich su thu phat chi could not be found
	 */
	public static LichSuThuPhatChi findByPhatVayId_First(
			long phatVayId,
			OrderByComparator<LichSuThuPhatChi> orderByComparator)
		throws com.mb.exception.NoSuchLichSuThuPhatChiException {

		return getPersistence().findByPhatVayId_First(
			phatVayId, orderByComparator);
	}

	/**
	 * Returns the first lich su thu phat chi in the ordered set where phatVayId = &#63;.
	 *
	 * @param phatVayId the phat vay ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lich su thu phat chi, or <code>null</code> if a matching lich su thu phat chi could not be found
	 */
	public static LichSuThuPhatChi fetchByPhatVayId_First(
		long phatVayId, OrderByComparator<LichSuThuPhatChi> orderByComparator) {

		return getPersistence().fetchByPhatVayId_First(
			phatVayId, orderByComparator);
	}

	/**
	 * Returns the last lich su thu phat chi in the ordered set where phatVayId = &#63;.
	 *
	 * @param phatVayId the phat vay ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lich su thu phat chi
	 * @throws NoSuchLichSuThuPhatChiException if a matching lich su thu phat chi could not be found
	 */
	public static LichSuThuPhatChi findByPhatVayId_Last(
			long phatVayId,
			OrderByComparator<LichSuThuPhatChi> orderByComparator)
		throws com.mb.exception.NoSuchLichSuThuPhatChiException {

		return getPersistence().findByPhatVayId_Last(
			phatVayId, orderByComparator);
	}

	/**
	 * Returns the last lich su thu phat chi in the ordered set where phatVayId = &#63;.
	 *
	 * @param phatVayId the phat vay ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lich su thu phat chi, or <code>null</code> if a matching lich su thu phat chi could not be found
	 */
	public static LichSuThuPhatChi fetchByPhatVayId_Last(
		long phatVayId, OrderByComparator<LichSuThuPhatChi> orderByComparator) {

		return getPersistence().fetchByPhatVayId_Last(
			phatVayId, orderByComparator);
	}

	/**
	 * Returns the lich su thu phat chis before and after the current lich su thu phat chi in the ordered set where phatVayId = &#63;.
	 *
	 * @param lichSuThuPhatChiId the primary key of the current lich su thu phat chi
	 * @param phatVayId the phat vay ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lich su thu phat chi
	 * @throws NoSuchLichSuThuPhatChiException if a lich su thu phat chi with the primary key could not be found
	 */
	public static LichSuThuPhatChi[] findByPhatVayId_PrevAndNext(
			long lichSuThuPhatChiId, long phatVayId,
			OrderByComparator<LichSuThuPhatChi> orderByComparator)
		throws com.mb.exception.NoSuchLichSuThuPhatChiException {

		return getPersistence().findByPhatVayId_PrevAndNext(
			lichSuThuPhatChiId, phatVayId, orderByComparator);
	}

	/**
	 * Removes all the lich su thu phat chis where phatVayId = &#63; from the database.
	 *
	 * @param phatVayId the phat vay ID
	 */
	public static void removeByPhatVayId(long phatVayId) {
		getPersistence().removeByPhatVayId(phatVayId);
	}

	/**
	 * Returns the number of lich su thu phat chis where phatVayId = &#63;.
	 *
	 * @param phatVayId the phat vay ID
	 * @return the number of matching lich su thu phat chis
	 */
	public static int countByPhatVayId(long phatVayId) {
		return getPersistence().countByPhatVayId(phatVayId);
	}

	/**
	 * Returns all the lich su thu phat chis where phatVayId = &#63; and loai = &#63;.
	 *
	 * @param phatVayId the phat vay ID
	 * @param loai the loai
	 * @return the matching lich su thu phat chis
	 */
	public static List<LichSuThuPhatChi> findByPhatVayId_Loai(
		long phatVayId, int loai) {

		return getPersistence().findByPhatVayId_Loai(phatVayId, loai);
	}

	/**
	 * Returns a range of all the lich su thu phat chis where phatVayId = &#63; and loai = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LichSuThuPhatChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phatVayId the phat vay ID
	 * @param loai the loai
	 * @param start the lower bound of the range of lich su thu phat chis
	 * @param end the upper bound of the range of lich su thu phat chis (not inclusive)
	 * @return the range of matching lich su thu phat chis
	 */
	public static List<LichSuThuPhatChi> findByPhatVayId_Loai(
		long phatVayId, int loai, int start, int end) {

		return getPersistence().findByPhatVayId_Loai(
			phatVayId, loai, start, end);
	}

	/**
	 * Returns an ordered range of all the lich su thu phat chis where phatVayId = &#63; and loai = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LichSuThuPhatChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phatVayId the phat vay ID
	 * @param loai the loai
	 * @param start the lower bound of the range of lich su thu phat chis
	 * @param end the upper bound of the range of lich su thu phat chis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lich su thu phat chis
	 */
	public static List<LichSuThuPhatChi> findByPhatVayId_Loai(
		long phatVayId, int loai, int start, int end,
		OrderByComparator<LichSuThuPhatChi> orderByComparator) {

		return getPersistence().findByPhatVayId_Loai(
			phatVayId, loai, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the lich su thu phat chis where phatVayId = &#63; and loai = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LichSuThuPhatChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phatVayId the phat vay ID
	 * @param loai the loai
	 * @param start the lower bound of the range of lich su thu phat chis
	 * @param end the upper bound of the range of lich su thu phat chis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching lich su thu phat chis
	 */
	public static List<LichSuThuPhatChi> findByPhatVayId_Loai(
		long phatVayId, int loai, int start, int end,
		OrderByComparator<LichSuThuPhatChi> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByPhatVayId_Loai(
			phatVayId, loai, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first lich su thu phat chi in the ordered set where phatVayId = &#63; and loai = &#63;.
	 *
	 * @param phatVayId the phat vay ID
	 * @param loai the loai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lich su thu phat chi
	 * @throws NoSuchLichSuThuPhatChiException if a matching lich su thu phat chi could not be found
	 */
	public static LichSuThuPhatChi findByPhatVayId_Loai_First(
			long phatVayId, int loai,
			OrderByComparator<LichSuThuPhatChi> orderByComparator)
		throws com.mb.exception.NoSuchLichSuThuPhatChiException {

		return getPersistence().findByPhatVayId_Loai_First(
			phatVayId, loai, orderByComparator);
	}

	/**
	 * Returns the first lich su thu phat chi in the ordered set where phatVayId = &#63; and loai = &#63;.
	 *
	 * @param phatVayId the phat vay ID
	 * @param loai the loai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lich su thu phat chi, or <code>null</code> if a matching lich su thu phat chi could not be found
	 */
	public static LichSuThuPhatChi fetchByPhatVayId_Loai_First(
		long phatVayId, int loai,
		OrderByComparator<LichSuThuPhatChi> orderByComparator) {

		return getPersistence().fetchByPhatVayId_Loai_First(
			phatVayId, loai, orderByComparator);
	}

	/**
	 * Returns the last lich su thu phat chi in the ordered set where phatVayId = &#63; and loai = &#63;.
	 *
	 * @param phatVayId the phat vay ID
	 * @param loai the loai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lich su thu phat chi
	 * @throws NoSuchLichSuThuPhatChiException if a matching lich su thu phat chi could not be found
	 */
	public static LichSuThuPhatChi findByPhatVayId_Loai_Last(
			long phatVayId, int loai,
			OrderByComparator<LichSuThuPhatChi> orderByComparator)
		throws com.mb.exception.NoSuchLichSuThuPhatChiException {

		return getPersistence().findByPhatVayId_Loai_Last(
			phatVayId, loai, orderByComparator);
	}

	/**
	 * Returns the last lich su thu phat chi in the ordered set where phatVayId = &#63; and loai = &#63;.
	 *
	 * @param phatVayId the phat vay ID
	 * @param loai the loai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lich su thu phat chi, or <code>null</code> if a matching lich su thu phat chi could not be found
	 */
	public static LichSuThuPhatChi fetchByPhatVayId_Loai_Last(
		long phatVayId, int loai,
		OrderByComparator<LichSuThuPhatChi> orderByComparator) {

		return getPersistence().fetchByPhatVayId_Loai_Last(
			phatVayId, loai, orderByComparator);
	}

	/**
	 * Returns the lich su thu phat chis before and after the current lich su thu phat chi in the ordered set where phatVayId = &#63; and loai = &#63;.
	 *
	 * @param lichSuThuPhatChiId the primary key of the current lich su thu phat chi
	 * @param phatVayId the phat vay ID
	 * @param loai the loai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lich su thu phat chi
	 * @throws NoSuchLichSuThuPhatChiException if a lich su thu phat chi with the primary key could not be found
	 */
	public static LichSuThuPhatChi[] findByPhatVayId_Loai_PrevAndNext(
			long lichSuThuPhatChiId, long phatVayId, int loai,
			OrderByComparator<LichSuThuPhatChi> orderByComparator)
		throws com.mb.exception.NoSuchLichSuThuPhatChiException {

		return getPersistence().findByPhatVayId_Loai_PrevAndNext(
			lichSuThuPhatChiId, phatVayId, loai, orderByComparator);
	}

	/**
	 * Removes all the lich su thu phat chis where phatVayId = &#63; and loai = &#63; from the database.
	 *
	 * @param phatVayId the phat vay ID
	 * @param loai the loai
	 */
	public static void removeByPhatVayId_Loai(long phatVayId, int loai) {
		getPersistence().removeByPhatVayId_Loai(phatVayId, loai);
	}

	/**
	 * Returns the number of lich su thu phat chis where phatVayId = &#63; and loai = &#63;.
	 *
	 * @param phatVayId the phat vay ID
	 * @param loai the loai
	 * @return the number of matching lich su thu phat chis
	 */
	public static int countByPhatVayId_Loai(long phatVayId, int loai) {
		return getPersistence().countByPhatVayId_Loai(phatVayId, loai);
	}

	/**
	 * Caches the lich su thu phat chi in the entity cache if it is enabled.
	 *
	 * @param lichSuThuPhatChi the lich su thu phat chi
	 */
	public static void cacheResult(LichSuThuPhatChi lichSuThuPhatChi) {
		getPersistence().cacheResult(lichSuThuPhatChi);
	}

	/**
	 * Caches the lich su thu phat chis in the entity cache if it is enabled.
	 *
	 * @param lichSuThuPhatChis the lich su thu phat chis
	 */
	public static void cacheResult(List<LichSuThuPhatChi> lichSuThuPhatChis) {
		getPersistence().cacheResult(lichSuThuPhatChis);
	}

	/**
	 * Creates a new lich su thu phat chi with the primary key. Does not add the lich su thu phat chi to the database.
	 *
	 * @param lichSuThuPhatChiId the primary key for the new lich su thu phat chi
	 * @return the new lich su thu phat chi
	 */
	public static LichSuThuPhatChi create(long lichSuThuPhatChiId) {
		return getPersistence().create(lichSuThuPhatChiId);
	}

	/**
	 * Removes the lich su thu phat chi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lichSuThuPhatChiId the primary key of the lich su thu phat chi
	 * @return the lich su thu phat chi that was removed
	 * @throws NoSuchLichSuThuPhatChiException if a lich su thu phat chi with the primary key could not be found
	 */
	public static LichSuThuPhatChi remove(long lichSuThuPhatChiId)
		throws com.mb.exception.NoSuchLichSuThuPhatChiException {

		return getPersistence().remove(lichSuThuPhatChiId);
	}

	public static LichSuThuPhatChi updateImpl(
		LichSuThuPhatChi lichSuThuPhatChi) {

		return getPersistence().updateImpl(lichSuThuPhatChi);
	}

	/**
	 * Returns the lich su thu phat chi with the primary key or throws a <code>NoSuchLichSuThuPhatChiException</code> if it could not be found.
	 *
	 * @param lichSuThuPhatChiId the primary key of the lich su thu phat chi
	 * @return the lich su thu phat chi
	 * @throws NoSuchLichSuThuPhatChiException if a lich su thu phat chi with the primary key could not be found
	 */
	public static LichSuThuPhatChi findByPrimaryKey(long lichSuThuPhatChiId)
		throws com.mb.exception.NoSuchLichSuThuPhatChiException {

		return getPersistence().findByPrimaryKey(lichSuThuPhatChiId);
	}

	/**
	 * Returns the lich su thu phat chi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lichSuThuPhatChiId the primary key of the lich su thu phat chi
	 * @return the lich su thu phat chi, or <code>null</code> if a lich su thu phat chi with the primary key could not be found
	 */
	public static LichSuThuPhatChi fetchByPrimaryKey(long lichSuThuPhatChiId) {
		return getPersistence().fetchByPrimaryKey(lichSuThuPhatChiId);
	}

	/**
	 * Returns all the lich su thu phat chis.
	 *
	 * @return the lich su thu phat chis
	 */
	public static List<LichSuThuPhatChi> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the lich su thu phat chis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LichSuThuPhatChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lich su thu phat chis
	 * @param end the upper bound of the range of lich su thu phat chis (not inclusive)
	 * @return the range of lich su thu phat chis
	 */
	public static List<LichSuThuPhatChi> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the lich su thu phat chis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LichSuThuPhatChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lich su thu phat chis
	 * @param end the upper bound of the range of lich su thu phat chis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lich su thu phat chis
	 */
	public static List<LichSuThuPhatChi> findAll(
		int start, int end,
		OrderByComparator<LichSuThuPhatChi> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the lich su thu phat chis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LichSuThuPhatChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lich su thu phat chis
	 * @param end the upper bound of the range of lich su thu phat chis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of lich su thu phat chis
	 */
	public static List<LichSuThuPhatChi> findAll(
		int start, int end,
		OrderByComparator<LichSuThuPhatChi> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the lich su thu phat chis from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of lich su thu phat chis.
	 *
	 * @return the number of lich su thu phat chis
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LichSuThuPhatChiPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<LichSuThuPhatChiPersistence, LichSuThuPhatChiPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			LichSuThuPhatChiPersistence.class);

		ServiceTracker<LichSuThuPhatChiPersistence, LichSuThuPhatChiPersistence>
			serviceTracker =
				new ServiceTracker
					<LichSuThuPhatChiPersistence, LichSuThuPhatChiPersistence>(
						bundle.getBundleContext(),
						LichSuThuPhatChiPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}