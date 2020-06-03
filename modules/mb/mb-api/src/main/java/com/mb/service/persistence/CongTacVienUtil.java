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

import com.mb.model.CongTacVien;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the cong tac vien service. This utility wraps <code>com.mb.service.persistence.impl.CongTacVienPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CongTacVienPersistence
 * @generated
 */
@ProviderType
public class CongTacVienUtil {

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
	public static void clearCache(CongTacVien congTacVien) {
		getPersistence().clearCache(congTacVien);
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
	public static Map<Serializable, CongTacVien> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CongTacVien> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CongTacVien> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CongTacVien> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CongTacVien> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CongTacVien update(CongTacVien congTacVien) {
		return getPersistence().update(congTacVien);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CongTacVien update(
		CongTacVien congTacVien, ServiceContext serviceContext) {

		return getPersistence().update(congTacVien, serviceContext);
	}

	/**
	 * Returns the cong tac vien where ma = &#63; or throws a <code>NoSuchCongTacVienException</code> if it could not be found.
	 *
	 * @param ma the ma
	 * @return the matching cong tac vien
	 * @throws NoSuchCongTacVienException if a matching cong tac vien could not be found
	 */
	public static CongTacVien findByMa(String ma)
		throws com.mb.exception.NoSuchCongTacVienException {

		return getPersistence().findByMa(ma);
	}

	/**
	 * Returns the cong tac vien where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ma the ma
	 * @return the matching cong tac vien, or <code>null</code> if a matching cong tac vien could not be found
	 */
	public static CongTacVien fetchByMa(String ma) {
		return getPersistence().fetchByMa(ma);
	}

	/**
	 * Returns the cong tac vien where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ma the ma
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching cong tac vien, or <code>null</code> if a matching cong tac vien could not be found
	 */
	public static CongTacVien fetchByMa(String ma, boolean retrieveFromCache) {
		return getPersistence().fetchByMa(ma, retrieveFromCache);
	}

	/**
	 * Removes the cong tac vien where ma = &#63; from the database.
	 *
	 * @param ma the ma
	 * @return the cong tac vien that was removed
	 */
	public static CongTacVien removeByMa(String ma)
		throws com.mb.exception.NoSuchCongTacVienException {

		return getPersistence().removeByMa(ma);
	}

	/**
	 * Returns the number of cong tac viens where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the number of matching cong tac viens
	 */
	public static int countByMa(String ma) {
		return getPersistence().countByMa(ma);
	}

	/**
	 * Returns the cong tac vien where soCMND = &#63; or throws a <code>NoSuchCongTacVienException</code> if it could not be found.
	 *
	 * @param soCMND the so cmnd
	 * @return the matching cong tac vien
	 * @throws NoSuchCongTacVienException if a matching cong tac vien could not be found
	 */
	public static CongTacVien findBySoCMND(String soCMND)
		throws com.mb.exception.NoSuchCongTacVienException {

		return getPersistence().findBySoCMND(soCMND);
	}

	/**
	 * Returns the cong tac vien where soCMND = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param soCMND the so cmnd
	 * @return the matching cong tac vien, or <code>null</code> if a matching cong tac vien could not be found
	 */
	public static CongTacVien fetchBySoCMND(String soCMND) {
		return getPersistence().fetchBySoCMND(soCMND);
	}

	/**
	 * Returns the cong tac vien where soCMND = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param soCMND the so cmnd
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching cong tac vien, or <code>null</code> if a matching cong tac vien could not be found
	 */
	public static CongTacVien fetchBySoCMND(
		String soCMND, boolean retrieveFromCache) {

		return getPersistence().fetchBySoCMND(soCMND, retrieveFromCache);
	}

	/**
	 * Removes the cong tac vien where soCMND = &#63; from the database.
	 *
	 * @param soCMND the so cmnd
	 * @return the cong tac vien that was removed
	 */
	public static CongTacVien removeBySoCMND(String soCMND)
		throws com.mb.exception.NoSuchCongTacVienException {

		return getPersistence().removeBySoCMND(soCMND);
	}

	/**
	 * Returns the number of cong tac viens where soCMND = &#63;.
	 *
	 * @param soCMND the so cmnd
	 * @return the number of matching cong tac viens
	 */
	public static int countBySoCMND(String soCMND) {
		return getPersistence().countBySoCMND(soCMND);
	}

	/**
	 * Caches the cong tac vien in the entity cache if it is enabled.
	 *
	 * @param congTacVien the cong tac vien
	 */
	public static void cacheResult(CongTacVien congTacVien) {
		getPersistence().cacheResult(congTacVien);
	}

	/**
	 * Caches the cong tac viens in the entity cache if it is enabled.
	 *
	 * @param congTacViens the cong tac viens
	 */
	public static void cacheResult(List<CongTacVien> congTacViens) {
		getPersistence().cacheResult(congTacViens);
	}

	/**
	 * Creates a new cong tac vien with the primary key. Does not add the cong tac vien to the database.
	 *
	 * @param congTacVienId the primary key for the new cong tac vien
	 * @return the new cong tac vien
	 */
	public static CongTacVien create(long congTacVienId) {
		return getPersistence().create(congTacVienId);
	}

	/**
	 * Removes the cong tac vien with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param congTacVienId the primary key of the cong tac vien
	 * @return the cong tac vien that was removed
	 * @throws NoSuchCongTacVienException if a cong tac vien with the primary key could not be found
	 */
	public static CongTacVien remove(long congTacVienId)
		throws com.mb.exception.NoSuchCongTacVienException {

		return getPersistence().remove(congTacVienId);
	}

	public static CongTacVien updateImpl(CongTacVien congTacVien) {
		return getPersistence().updateImpl(congTacVien);
	}

	/**
	 * Returns the cong tac vien with the primary key or throws a <code>NoSuchCongTacVienException</code> if it could not be found.
	 *
	 * @param congTacVienId the primary key of the cong tac vien
	 * @return the cong tac vien
	 * @throws NoSuchCongTacVienException if a cong tac vien with the primary key could not be found
	 */
	public static CongTacVien findByPrimaryKey(long congTacVienId)
		throws com.mb.exception.NoSuchCongTacVienException {

		return getPersistence().findByPrimaryKey(congTacVienId);
	}

	/**
	 * Returns the cong tac vien with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param congTacVienId the primary key of the cong tac vien
	 * @return the cong tac vien, or <code>null</code> if a cong tac vien with the primary key could not be found
	 */
	public static CongTacVien fetchByPrimaryKey(long congTacVienId) {
		return getPersistence().fetchByPrimaryKey(congTacVienId);
	}

	/**
	 * Returns all the cong tac viens.
	 *
	 * @return the cong tac viens
	 */
	public static List<CongTacVien> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the cong tac viens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CongTacVienModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cong tac viens
	 * @param end the upper bound of the range of cong tac viens (not inclusive)
	 * @return the range of cong tac viens
	 */
	public static List<CongTacVien> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the cong tac viens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CongTacVienModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cong tac viens
	 * @param end the upper bound of the range of cong tac viens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cong tac viens
	 */
	public static List<CongTacVien> findAll(
		int start, int end, OrderByComparator<CongTacVien> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cong tac viens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CongTacVienModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cong tac viens
	 * @param end the upper bound of the range of cong tac viens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of cong tac viens
	 */
	public static List<CongTacVien> findAll(
		int start, int end, OrderByComparator<CongTacVien> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the cong tac viens from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of cong tac viens.
	 *
	 * @return the number of cong tac viens
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CongTacVienPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CongTacVienPersistence, CongTacVienPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CongTacVienPersistence.class);

		ServiceTracker<CongTacVienPersistence, CongTacVienPersistence>
			serviceTracker =
				new ServiceTracker
					<CongTacVienPersistence, CongTacVienPersistence>(
						bundle.getBundleContext(), CongTacVienPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}