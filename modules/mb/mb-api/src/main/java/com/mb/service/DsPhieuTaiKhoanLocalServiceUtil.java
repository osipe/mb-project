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

package com.mb.service;

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for DsPhieuTaiKhoan. This utility wraps
 * <code>com.mb.service.impl.DsPhieuTaiKhoanLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see DsPhieuTaiKhoanLocalService
 * @generated
 */
@ProviderType
public class DsPhieuTaiKhoanLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mb.service.impl.DsPhieuTaiKhoanLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the ds phieu tai khoan to the database. Also notifies the appropriate model listeners.
	 *
	 * @param dsPhieuTaiKhoan the ds phieu tai khoan
	 * @return the ds phieu tai khoan that was added
	 */
	public static com.mb.model.DsPhieuTaiKhoan addDsPhieuTaiKhoan(
		com.mb.model.DsPhieuTaiKhoan dsPhieuTaiKhoan) {

		return getService().addDsPhieuTaiKhoan(dsPhieuTaiKhoan);
	}

	public static com.mb.model.DsPhieuTaiKhoan addDsPhieuTaiKhoan(
			com.mb.model.DsPhieuTaiKhoan dsPhieuTaiKhoan,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.NoSuchUserException,
			   com.liferay.portal.kernel.exception.SystemException {

		return getService().addDsPhieuTaiKhoan(dsPhieuTaiKhoan, serviceContext);
	}

	public static void addOrUpdateDsPhieuTaiKhoan(
			com.mb.model.Phieu phieu,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.NoSuchUserException,
			   com.liferay.portal.kernel.exception.SystemException {

		getService().addOrUpdateDsPhieuTaiKhoan(phieu, serviceContext);
	}

	/**
	 * Creates a new ds phieu tai khoan with the primary key. Does not add the ds phieu tai khoan to the database.
	 *
	 * @param dsPhieuTaiKhoanId the primary key for the new ds phieu tai khoan
	 * @return the new ds phieu tai khoan
	 */
	public static com.mb.model.DsPhieuTaiKhoan createDsPhieuTaiKhoan(
		long dsPhieuTaiKhoanId) {

		return getService().createDsPhieuTaiKhoan(dsPhieuTaiKhoanId);
	}

	/**
	 * Deletes the ds phieu tai khoan from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dsPhieuTaiKhoan the ds phieu tai khoan
	 * @return the ds phieu tai khoan that was removed
	 */
	public static com.mb.model.DsPhieuTaiKhoan deleteDsPhieuTaiKhoan(
		com.mb.model.DsPhieuTaiKhoan dsPhieuTaiKhoan) {

		return getService().deleteDsPhieuTaiKhoan(dsPhieuTaiKhoan);
	}

	/**
	 * Deletes the ds phieu tai khoan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dsPhieuTaiKhoanId the primary key of the ds phieu tai khoan
	 * @return the ds phieu tai khoan that was removed
	 * @throws PortalException if a ds phieu tai khoan with the primary key could not be found
	 */
	public static com.mb.model.DsPhieuTaiKhoan deleteDsPhieuTaiKhoan(
			long dsPhieuTaiKhoanId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteDsPhieuTaiKhoan(dsPhieuTaiKhoanId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.DsPhieuTaiKhoanModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.DsPhieuTaiKhoanModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.mb.model.DsPhieuTaiKhoan fetchDsPhieuTaiKhoan(
		long dsPhieuTaiKhoanId) {

		return getService().fetchDsPhieuTaiKhoan(dsPhieuTaiKhoanId);
	}

	public static java.util.List<com.mb.model.DsPhieuTaiKhoan> findByPhieuId(
			long phieuId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().findByPhieuId(phieuId);
	}

	public static java.util.List<com.mb.model.DsPhieuTaiKhoan>
			findByTaiKhoanDoiUngId_HoatDong(
				long taiKhoanDoiUngId, boolean hoatDong)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().findByTaiKhoanDoiUngId_HoatDong(
			taiKhoanDoiUngId, hoatDong);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the ds phieu tai khoan with the primary key.
	 *
	 * @param dsPhieuTaiKhoanId the primary key of the ds phieu tai khoan
	 * @return the ds phieu tai khoan
	 * @throws PortalException if a ds phieu tai khoan with the primary key could not be found
	 */
	public static com.mb.model.DsPhieuTaiKhoan getDsPhieuTaiKhoan(
			long dsPhieuTaiKhoanId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getDsPhieuTaiKhoan(dsPhieuTaiKhoanId);
	}

	/**
	 * Returns a range of all the ds phieu tai khoans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.DsPhieuTaiKhoanModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ds phieu tai khoans
	 * @param end the upper bound of the range of ds phieu tai khoans (not inclusive)
	 * @return the range of ds phieu tai khoans
	 */
	public static java.util.List<com.mb.model.DsPhieuTaiKhoan>
		getDsPhieuTaiKhoans(int start, int end) {

		return getService().getDsPhieuTaiKhoans(start, end);
	}

	/**
	 * Returns the number of ds phieu tai khoans.
	 *
	 * @return the number of ds phieu tai khoans
	 */
	public static int getDsPhieuTaiKhoansCount() {
		return getService().getDsPhieuTaiKhoansCount();
	}

	public static java.util.List<com.mb.model.DsPhieuTaiKhoan>
			getDSThuChiByTaiKhoanNgayChungTu(
				long taiKhoanDoiUngId, java.util.Date ngayChungTuTu,
				java.util.Date ngayChungTuDen, int hoatDong, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getDSThuChiByTaiKhoanNgayChungTu(
			taiKhoanDoiUngId, ngayChungTuTu, ngayChungTuDen, hoatDong, start,
			end, obc);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static void removeByPhieuId(long phieuId)
		throws com.liferay.portal.kernel.exception.SystemException {

		getService().removeByPhieuId(phieuId);
	}

	/**
	 * Updates the ds phieu tai khoan in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param dsPhieuTaiKhoan the ds phieu tai khoan
	 * @return the ds phieu tai khoan that was updated
	 */
	public static com.mb.model.DsPhieuTaiKhoan updateDsPhieuTaiKhoan(
		com.mb.model.DsPhieuTaiKhoan dsPhieuTaiKhoan) {

		return getService().updateDsPhieuTaiKhoan(dsPhieuTaiKhoan);
	}

	public static com.mb.model.DsPhieuTaiKhoan updateDsPhieuTaiKhoan(
			com.mb.model.DsPhieuTaiKhoan dsPhieuTaiKhoan,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().updateDsPhieuTaiKhoan(
			dsPhieuTaiKhoan, serviceContext);
	}

	public static DsPhieuTaiKhoanLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<DsPhieuTaiKhoanLocalService, DsPhieuTaiKhoanLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			DsPhieuTaiKhoanLocalService.class);

		ServiceTracker<DsPhieuTaiKhoanLocalService, DsPhieuTaiKhoanLocalService>
			serviceTracker =
				new ServiceTracker
					<DsPhieuTaiKhoanLocalService, DsPhieuTaiKhoanLocalService>(
						bundle.getBundleContext(),
						DsPhieuTaiKhoanLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}