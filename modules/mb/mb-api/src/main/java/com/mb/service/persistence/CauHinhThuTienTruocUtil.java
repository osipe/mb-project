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

import com.mb.model.CauHinhThuTienTruoc;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the cau hinh thu tien truoc service. This utility wraps <code>com.mb.service.persistence.impl.CauHinhThuTienTruocPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CauHinhThuTienTruocPersistence
 * @generated
 */
@ProviderType
public class CauHinhThuTienTruocUtil {

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
	public static void clearCache(CauHinhThuTienTruoc cauHinhThuTienTruoc) {
		getPersistence().clearCache(cauHinhThuTienTruoc);
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
	public static Map<Serializable, CauHinhThuTienTruoc> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CauHinhThuTienTruoc> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CauHinhThuTienTruoc> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CauHinhThuTienTruoc> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CauHinhThuTienTruoc> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CauHinhThuTienTruoc update(
		CauHinhThuTienTruoc cauHinhThuTienTruoc) {

		return getPersistence().update(cauHinhThuTienTruoc);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CauHinhThuTienTruoc update(
		CauHinhThuTienTruoc cauHinhThuTienTruoc,
		ServiceContext serviceContext) {

		return getPersistence().update(cauHinhThuTienTruoc, serviceContext);
	}

	/**
	 * Returns the cau hinh thu tien truoc where nam = &#63; or throws a <code>NoSuchCauHinhThuTienTruocException</code> if it could not be found.
	 *
	 * @param nam the nam
	 * @return the matching cau hinh thu tien truoc
	 * @throws NoSuchCauHinhThuTienTruocException if a matching cau hinh thu tien truoc could not be found
	 */
	public static CauHinhThuTienTruoc findByNam(int nam)
		throws com.mb.exception.NoSuchCauHinhThuTienTruocException {

		return getPersistence().findByNam(nam);
	}

	/**
	 * Returns the cau hinh thu tien truoc where nam = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nam the nam
	 * @return the matching cau hinh thu tien truoc, or <code>null</code> if a matching cau hinh thu tien truoc could not be found
	 */
	public static CauHinhThuTienTruoc fetchByNam(int nam) {
		return getPersistence().fetchByNam(nam);
	}

	/**
	 * Returns the cau hinh thu tien truoc where nam = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nam the nam
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching cau hinh thu tien truoc, or <code>null</code> if a matching cau hinh thu tien truoc could not be found
	 */
	public static CauHinhThuTienTruoc fetchByNam(
		int nam, boolean retrieveFromCache) {

		return getPersistence().fetchByNam(nam, retrieveFromCache);
	}

	/**
	 * Removes the cau hinh thu tien truoc where nam = &#63; from the database.
	 *
	 * @param nam the nam
	 * @return the cau hinh thu tien truoc that was removed
	 */
	public static CauHinhThuTienTruoc removeByNam(int nam)
		throws com.mb.exception.NoSuchCauHinhThuTienTruocException {

		return getPersistence().removeByNam(nam);
	}

	/**
	 * Returns the number of cau hinh thu tien truocs where nam = &#63;.
	 *
	 * @param nam the nam
	 * @return the number of matching cau hinh thu tien truocs
	 */
	public static int countByNam(int nam) {
		return getPersistence().countByNam(nam);
	}

	/**
	 * Caches the cau hinh thu tien truoc in the entity cache if it is enabled.
	 *
	 * @param cauHinhThuTienTruoc the cau hinh thu tien truoc
	 */
	public static void cacheResult(CauHinhThuTienTruoc cauHinhThuTienTruoc) {
		getPersistence().cacheResult(cauHinhThuTienTruoc);
	}

	/**
	 * Caches the cau hinh thu tien truocs in the entity cache if it is enabled.
	 *
	 * @param cauHinhThuTienTruocs the cau hinh thu tien truocs
	 */
	public static void cacheResult(
		List<CauHinhThuTienTruoc> cauHinhThuTienTruocs) {

		getPersistence().cacheResult(cauHinhThuTienTruocs);
	}

	/**
	 * Creates a new cau hinh thu tien truoc with the primary key. Does not add the cau hinh thu tien truoc to the database.
	 *
	 * @param cauHinhThuTienTruocId the primary key for the new cau hinh thu tien truoc
	 * @return the new cau hinh thu tien truoc
	 */
	public static CauHinhThuTienTruoc create(long cauHinhThuTienTruocId) {
		return getPersistence().create(cauHinhThuTienTruocId);
	}

	/**
	 * Removes the cau hinh thu tien truoc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cauHinhThuTienTruocId the primary key of the cau hinh thu tien truoc
	 * @return the cau hinh thu tien truoc that was removed
	 * @throws NoSuchCauHinhThuTienTruocException if a cau hinh thu tien truoc with the primary key could not be found
	 */
	public static CauHinhThuTienTruoc remove(long cauHinhThuTienTruocId)
		throws com.mb.exception.NoSuchCauHinhThuTienTruocException {

		return getPersistence().remove(cauHinhThuTienTruocId);
	}

	public static CauHinhThuTienTruoc updateImpl(
		CauHinhThuTienTruoc cauHinhThuTienTruoc) {

		return getPersistence().updateImpl(cauHinhThuTienTruoc);
	}

	/**
	 * Returns the cau hinh thu tien truoc with the primary key or throws a <code>NoSuchCauHinhThuTienTruocException</code> if it could not be found.
	 *
	 * @param cauHinhThuTienTruocId the primary key of the cau hinh thu tien truoc
	 * @return the cau hinh thu tien truoc
	 * @throws NoSuchCauHinhThuTienTruocException if a cau hinh thu tien truoc with the primary key could not be found
	 */
	public static CauHinhThuTienTruoc findByPrimaryKey(
			long cauHinhThuTienTruocId)
		throws com.mb.exception.NoSuchCauHinhThuTienTruocException {

		return getPersistence().findByPrimaryKey(cauHinhThuTienTruocId);
	}

	/**
	 * Returns the cau hinh thu tien truoc with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cauHinhThuTienTruocId the primary key of the cau hinh thu tien truoc
	 * @return the cau hinh thu tien truoc, or <code>null</code> if a cau hinh thu tien truoc with the primary key could not be found
	 */
	public static CauHinhThuTienTruoc fetchByPrimaryKey(
		long cauHinhThuTienTruocId) {

		return getPersistence().fetchByPrimaryKey(cauHinhThuTienTruocId);
	}

	/**
	 * Returns all the cau hinh thu tien truocs.
	 *
	 * @return the cau hinh thu tien truocs
	 */
	public static List<CauHinhThuTienTruoc> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the cau hinh thu tien truocs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CauHinhThuTienTruocModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cau hinh thu tien truocs
	 * @param end the upper bound of the range of cau hinh thu tien truocs (not inclusive)
	 * @return the range of cau hinh thu tien truocs
	 */
	public static List<CauHinhThuTienTruoc> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the cau hinh thu tien truocs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CauHinhThuTienTruocModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cau hinh thu tien truocs
	 * @param end the upper bound of the range of cau hinh thu tien truocs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cau hinh thu tien truocs
	 */
	public static List<CauHinhThuTienTruoc> findAll(
		int start, int end,
		OrderByComparator<CauHinhThuTienTruoc> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cau hinh thu tien truocs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CauHinhThuTienTruocModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cau hinh thu tien truocs
	 * @param end the upper bound of the range of cau hinh thu tien truocs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of cau hinh thu tien truocs
	 */
	public static List<CauHinhThuTienTruoc> findAll(
		int start, int end,
		OrderByComparator<CauHinhThuTienTruoc> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the cau hinh thu tien truocs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of cau hinh thu tien truocs.
	 *
	 * @return the number of cau hinh thu tien truocs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CauHinhThuTienTruocPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CauHinhThuTienTruocPersistence, CauHinhThuTienTruocPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			CauHinhThuTienTruocPersistence.class);

		ServiceTracker
			<CauHinhThuTienTruocPersistence, CauHinhThuTienTruocPersistence>
				serviceTracker =
					new ServiceTracker
						<CauHinhThuTienTruocPersistence,
						 CauHinhThuTienTruocPersistence>(
							 bundle.getBundleContext(),
							 CauHinhThuTienTruocPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}