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

import com.mb.model.CauHinhThuTienTet;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the cau hinh thu tien tet service. This utility wraps <code>com.mb.service.persistence.impl.CauHinhThuTienTetPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CauHinhThuTienTetPersistence
 * @generated
 */
@ProviderType
public class CauHinhThuTienTetUtil {

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
	public static void clearCache(CauHinhThuTienTet cauHinhThuTienTet) {
		getPersistence().clearCache(cauHinhThuTienTet);
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
	public static Map<Serializable, CauHinhThuTienTet> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CauHinhThuTienTet> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CauHinhThuTienTet> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CauHinhThuTienTet> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CauHinhThuTienTet> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CauHinhThuTienTet update(
		CauHinhThuTienTet cauHinhThuTienTet) {

		return getPersistence().update(cauHinhThuTienTet);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CauHinhThuTienTet update(
		CauHinhThuTienTet cauHinhThuTienTet, ServiceContext serviceContext) {

		return getPersistence().update(cauHinhThuTienTet, serviceContext);
	}

	/**
	 * Returns the cau hinh thu tien tet where nam = &#63; or throws a <code>NoSuchCauHinhThuTienTetException</code> if it could not be found.
	 *
	 * @param nam the nam
	 * @return the matching cau hinh thu tien tet
	 * @throws NoSuchCauHinhThuTienTetException if a matching cau hinh thu tien tet could not be found
	 */
	public static CauHinhThuTienTet findByNam(int nam)
		throws com.mb.exception.NoSuchCauHinhThuTienTetException {

		return getPersistence().findByNam(nam);
	}

	/**
	 * Returns the cau hinh thu tien tet where nam = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nam the nam
	 * @return the matching cau hinh thu tien tet, or <code>null</code> if a matching cau hinh thu tien tet could not be found
	 */
	public static CauHinhThuTienTet fetchByNam(int nam) {
		return getPersistence().fetchByNam(nam);
	}

	/**
	 * Returns the cau hinh thu tien tet where nam = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nam the nam
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching cau hinh thu tien tet, or <code>null</code> if a matching cau hinh thu tien tet could not be found
	 */
	public static CauHinhThuTienTet fetchByNam(
		int nam, boolean retrieveFromCache) {

		return getPersistence().fetchByNam(nam, retrieveFromCache);
	}

	/**
	 * Removes the cau hinh thu tien tet where nam = &#63; from the database.
	 *
	 * @param nam the nam
	 * @return the cau hinh thu tien tet that was removed
	 */
	public static CauHinhThuTienTet removeByNam(int nam)
		throws com.mb.exception.NoSuchCauHinhThuTienTetException {

		return getPersistence().removeByNam(nam);
	}

	/**
	 * Returns the number of cau hinh thu tien tets where nam = &#63;.
	 *
	 * @param nam the nam
	 * @return the number of matching cau hinh thu tien tets
	 */
	public static int countByNam(int nam) {
		return getPersistence().countByNam(nam);
	}

	/**
	 * Caches the cau hinh thu tien tet in the entity cache if it is enabled.
	 *
	 * @param cauHinhThuTienTet the cau hinh thu tien tet
	 */
	public static void cacheResult(CauHinhThuTienTet cauHinhThuTienTet) {
		getPersistence().cacheResult(cauHinhThuTienTet);
	}

	/**
	 * Caches the cau hinh thu tien tets in the entity cache if it is enabled.
	 *
	 * @param cauHinhThuTienTets the cau hinh thu tien tets
	 */
	public static void cacheResult(List<CauHinhThuTienTet> cauHinhThuTienTets) {
		getPersistence().cacheResult(cauHinhThuTienTets);
	}

	/**
	 * Creates a new cau hinh thu tien tet with the primary key. Does not add the cau hinh thu tien tet to the database.
	 *
	 * @param cauHinhThuTienTetId the primary key for the new cau hinh thu tien tet
	 * @return the new cau hinh thu tien tet
	 */
	public static CauHinhThuTienTet create(long cauHinhThuTienTetId) {
		return getPersistence().create(cauHinhThuTienTetId);
	}

	/**
	 * Removes the cau hinh thu tien tet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cauHinhThuTienTetId the primary key of the cau hinh thu tien tet
	 * @return the cau hinh thu tien tet that was removed
	 * @throws NoSuchCauHinhThuTienTetException if a cau hinh thu tien tet with the primary key could not be found
	 */
	public static CauHinhThuTienTet remove(long cauHinhThuTienTetId)
		throws com.mb.exception.NoSuchCauHinhThuTienTetException {

		return getPersistence().remove(cauHinhThuTienTetId);
	}

	public static CauHinhThuTienTet updateImpl(
		CauHinhThuTienTet cauHinhThuTienTet) {

		return getPersistence().updateImpl(cauHinhThuTienTet);
	}

	/**
	 * Returns the cau hinh thu tien tet with the primary key or throws a <code>NoSuchCauHinhThuTienTetException</code> if it could not be found.
	 *
	 * @param cauHinhThuTienTetId the primary key of the cau hinh thu tien tet
	 * @return the cau hinh thu tien tet
	 * @throws NoSuchCauHinhThuTienTetException if a cau hinh thu tien tet with the primary key could not be found
	 */
	public static CauHinhThuTienTet findByPrimaryKey(long cauHinhThuTienTetId)
		throws com.mb.exception.NoSuchCauHinhThuTienTetException {

		return getPersistence().findByPrimaryKey(cauHinhThuTienTetId);
	}

	/**
	 * Returns the cau hinh thu tien tet with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cauHinhThuTienTetId the primary key of the cau hinh thu tien tet
	 * @return the cau hinh thu tien tet, or <code>null</code> if a cau hinh thu tien tet with the primary key could not be found
	 */
	public static CauHinhThuTienTet fetchByPrimaryKey(
		long cauHinhThuTienTetId) {

		return getPersistence().fetchByPrimaryKey(cauHinhThuTienTetId);
	}

	/**
	 * Returns all the cau hinh thu tien tets.
	 *
	 * @return the cau hinh thu tien tets
	 */
	public static List<CauHinhThuTienTet> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the cau hinh thu tien tets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CauHinhThuTienTetModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cau hinh thu tien tets
	 * @param end the upper bound of the range of cau hinh thu tien tets (not inclusive)
	 * @return the range of cau hinh thu tien tets
	 */
	public static List<CauHinhThuTienTet> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the cau hinh thu tien tets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CauHinhThuTienTetModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cau hinh thu tien tets
	 * @param end the upper bound of the range of cau hinh thu tien tets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cau hinh thu tien tets
	 */
	public static List<CauHinhThuTienTet> findAll(
		int start, int end,
		OrderByComparator<CauHinhThuTienTet> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cau hinh thu tien tets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CauHinhThuTienTetModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cau hinh thu tien tets
	 * @param end the upper bound of the range of cau hinh thu tien tets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of cau hinh thu tien tets
	 */
	public static List<CauHinhThuTienTet> findAll(
		int start, int end,
		OrderByComparator<CauHinhThuTienTet> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the cau hinh thu tien tets from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of cau hinh thu tien tets.
	 *
	 * @return the number of cau hinh thu tien tets
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CauHinhThuTienTetPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CauHinhThuTienTetPersistence, CauHinhThuTienTetPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			CauHinhThuTienTetPersistence.class);

		ServiceTracker
			<CauHinhThuTienTetPersistence, CauHinhThuTienTetPersistence>
				serviceTracker =
					new ServiceTracker
						<CauHinhThuTienTetPersistence,
						 CauHinhThuTienTetPersistence>(
							 bundle.getBundleContext(),
							 CauHinhThuTienTetPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}