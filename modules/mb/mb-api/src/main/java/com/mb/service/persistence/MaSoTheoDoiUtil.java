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

import com.mb.model.MaSoTheoDoi;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the ma so theo doi service. This utility wraps <code>com.mb.service.persistence.impl.MaSoTheoDoiPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MaSoTheoDoiPersistence
 * @generated
 */
@ProviderType
public class MaSoTheoDoiUtil {

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
	public static void clearCache(MaSoTheoDoi maSoTheoDoi) {
		getPersistence().clearCache(maSoTheoDoi);
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
	public static Map<Serializable, MaSoTheoDoi> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<MaSoTheoDoi> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MaSoTheoDoi> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MaSoTheoDoi> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MaSoTheoDoi> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MaSoTheoDoi update(MaSoTheoDoi maSoTheoDoi) {
		return getPersistence().update(maSoTheoDoi);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MaSoTheoDoi update(
		MaSoTheoDoi maSoTheoDoi, ServiceContext serviceContext) {

		return getPersistence().update(maSoTheoDoi, serviceContext);
	}

	/**
	 * Returns the ma so theo doi where ma = &#63; or throws a <code>NoSuchMaSoTheoDoiException</code> if it could not be found.
	 *
	 * @param ma the ma
	 * @return the matching ma so theo doi
	 * @throws NoSuchMaSoTheoDoiException if a matching ma so theo doi could not be found
	 */
	public static MaSoTheoDoi findByMa(String ma)
		throws com.mb.exception.NoSuchMaSoTheoDoiException {

		return getPersistence().findByMa(ma);
	}

	/**
	 * Returns the ma so theo doi where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ma the ma
	 * @return the matching ma so theo doi, or <code>null</code> if a matching ma so theo doi could not be found
	 */
	public static MaSoTheoDoi fetchByMa(String ma) {
		return getPersistence().fetchByMa(ma);
	}

	/**
	 * Returns the ma so theo doi where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ma the ma
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching ma so theo doi, or <code>null</code> if a matching ma so theo doi could not be found
	 */
	public static MaSoTheoDoi fetchByMa(String ma, boolean retrieveFromCache) {
		return getPersistence().fetchByMa(ma, retrieveFromCache);
	}

	/**
	 * Removes the ma so theo doi where ma = &#63; from the database.
	 *
	 * @param ma the ma
	 * @return the ma so theo doi that was removed
	 */
	public static MaSoTheoDoi removeByMa(String ma)
		throws com.mb.exception.NoSuchMaSoTheoDoiException {

		return getPersistence().removeByMa(ma);
	}

	/**
	 * Returns the number of ma so theo dois where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the number of matching ma so theo dois
	 */
	public static int countByMa(String ma) {
		return getPersistence().countByMa(ma);
	}

	/**
	 * Caches the ma so theo doi in the entity cache if it is enabled.
	 *
	 * @param maSoTheoDoi the ma so theo doi
	 */
	public static void cacheResult(MaSoTheoDoi maSoTheoDoi) {
		getPersistence().cacheResult(maSoTheoDoi);
	}

	/**
	 * Caches the ma so theo dois in the entity cache if it is enabled.
	 *
	 * @param maSoTheoDois the ma so theo dois
	 */
	public static void cacheResult(List<MaSoTheoDoi> maSoTheoDois) {
		getPersistence().cacheResult(maSoTheoDois);
	}

	/**
	 * Creates a new ma so theo doi with the primary key. Does not add the ma so theo doi to the database.
	 *
	 * @param maSoTheoDoiId the primary key for the new ma so theo doi
	 * @return the new ma so theo doi
	 */
	public static MaSoTheoDoi create(long maSoTheoDoiId) {
		return getPersistence().create(maSoTheoDoiId);
	}

	/**
	 * Removes the ma so theo doi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param maSoTheoDoiId the primary key of the ma so theo doi
	 * @return the ma so theo doi that was removed
	 * @throws NoSuchMaSoTheoDoiException if a ma so theo doi with the primary key could not be found
	 */
	public static MaSoTheoDoi remove(long maSoTheoDoiId)
		throws com.mb.exception.NoSuchMaSoTheoDoiException {

		return getPersistence().remove(maSoTheoDoiId);
	}

	public static MaSoTheoDoi updateImpl(MaSoTheoDoi maSoTheoDoi) {
		return getPersistence().updateImpl(maSoTheoDoi);
	}

	/**
	 * Returns the ma so theo doi with the primary key or throws a <code>NoSuchMaSoTheoDoiException</code> if it could not be found.
	 *
	 * @param maSoTheoDoiId the primary key of the ma so theo doi
	 * @return the ma so theo doi
	 * @throws NoSuchMaSoTheoDoiException if a ma so theo doi with the primary key could not be found
	 */
	public static MaSoTheoDoi findByPrimaryKey(long maSoTheoDoiId)
		throws com.mb.exception.NoSuchMaSoTheoDoiException {

		return getPersistence().findByPrimaryKey(maSoTheoDoiId);
	}

	/**
	 * Returns the ma so theo doi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param maSoTheoDoiId the primary key of the ma so theo doi
	 * @return the ma so theo doi, or <code>null</code> if a ma so theo doi with the primary key could not be found
	 */
	public static MaSoTheoDoi fetchByPrimaryKey(long maSoTheoDoiId) {
		return getPersistence().fetchByPrimaryKey(maSoTheoDoiId);
	}

	/**
	 * Returns all the ma so theo dois.
	 *
	 * @return the ma so theo dois
	 */
	public static List<MaSoTheoDoi> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the ma so theo dois.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MaSoTheoDoiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ma so theo dois
	 * @param end the upper bound of the range of ma so theo dois (not inclusive)
	 * @return the range of ma so theo dois
	 */
	public static List<MaSoTheoDoi> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the ma so theo dois.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MaSoTheoDoiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ma so theo dois
	 * @param end the upper bound of the range of ma so theo dois (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ma so theo dois
	 */
	public static List<MaSoTheoDoi> findAll(
		int start, int end, OrderByComparator<MaSoTheoDoi> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ma so theo dois.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MaSoTheoDoiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ma so theo dois
	 * @param end the upper bound of the range of ma so theo dois (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of ma so theo dois
	 */
	public static List<MaSoTheoDoi> findAll(
		int start, int end, OrderByComparator<MaSoTheoDoi> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the ma so theo dois from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of ma so theo dois.
	 *
	 * @return the number of ma so theo dois
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MaSoTheoDoiPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<MaSoTheoDoiPersistence, MaSoTheoDoiPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(MaSoTheoDoiPersistence.class);

		ServiceTracker<MaSoTheoDoiPersistence, MaSoTheoDoiPersistence>
			serviceTracker =
				new ServiceTracker
					<MaSoTheoDoiPersistence, MaSoTheoDoiPersistence>(
						bundle.getBundleContext(), MaSoTheoDoiPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}