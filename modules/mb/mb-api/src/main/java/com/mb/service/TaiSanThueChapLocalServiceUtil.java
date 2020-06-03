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
 * Provides the local service utility for TaiSanThueChap. This utility wraps
 * <code>com.mb.service.impl.TaiSanThueChapLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TaiSanThueChapLocalService
 * @generated
 */
@ProviderType
public class TaiSanThueChapLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mb.service.impl.TaiSanThueChapLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static void addOrTaiSanThueChap(
			com.mb.model.PhatVay phatVay,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.NoSuchUserException,
			   com.liferay.portal.kernel.exception.SystemException {

		getService().addOrTaiSanThueChap(phatVay, serviceContext);
	}

	/**
	 * Adds the tai san thue chap to the database. Also notifies the appropriate model listeners.
	 *
	 * @param taiSanThueChap the tai san thue chap
	 * @return the tai san thue chap that was added
	 */
	public static com.mb.model.TaiSanThueChap addTaiSanThueChap(
		com.mb.model.TaiSanThueChap taiSanThueChap) {

		return getService().addTaiSanThueChap(taiSanThueChap);
	}

	public static com.mb.model.TaiSanThueChap addTaiSanThueChap(
			com.mb.model.TaiSanThueChap taiSanThueChap,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.NoSuchUserException,
			   com.liferay.portal.kernel.exception.SystemException {

		return getService().addTaiSanThueChap(taiSanThueChap, serviceContext);
	}

	public static int countBase(
			String soKU, String ten, String maKhachHang, long loaiTaiSanId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().countBase(soKU, ten, maKhachHang, loaiTaiSanId);
	}

	/**
	 * Creates a new tai san thue chap with the primary key. Does not add the tai san thue chap to the database.
	 *
	 * @param taiSanThueChapId the primary key for the new tai san thue chap
	 * @return the new tai san thue chap
	 */
	public static com.mb.model.TaiSanThueChap createTaiSanThueChap(
		long taiSanThueChapId) {

		return getService().createTaiSanThueChap(taiSanThueChapId);
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

	/**
	 * Deletes the tai san thue chap with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taiSanThueChapId the primary key of the tai san thue chap
	 * @return the tai san thue chap that was removed
	 * @throws PortalException if a tai san thue chap with the primary key could not be found
	 */
	public static com.mb.model.TaiSanThueChap deleteTaiSanThueChap(
			long taiSanThueChapId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteTaiSanThueChap(taiSanThueChapId);
	}

	/**
	 * Deletes the tai san thue chap from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taiSanThueChap the tai san thue chap
	 * @return the tai san thue chap that was removed
	 */
	public static com.mb.model.TaiSanThueChap deleteTaiSanThueChap(
		com.mb.model.TaiSanThueChap taiSanThueChap) {

		return getService().deleteTaiSanThueChap(taiSanThueChap);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.TaiSanThueChapModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.TaiSanThueChapModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.mb.model.TaiSanThueChap fetchTaiSanThueChap(
		long taiSanThueChapId) {

		return getService().fetchTaiSanThueChap(taiSanThueChapId);
	}

	public static java.util.List<com.mb.model.TaiSanThueChap> findBase(
			String soKU, String ten, String maKhachHang, long loaiTaiSanId,
			int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().findBase(
			soKU, ten, maKhachHang, loaiTaiSanId, start, end, obc);
	}

	public static java.util.List<com.mb.model.TaiSanThueChap> findByPhatVayId(
			long phatVayId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().findByPhatVayId(phatVayId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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

	/**
	 * Returns the tai san thue chap with the primary key.
	 *
	 * @param taiSanThueChapId the primary key of the tai san thue chap
	 * @return the tai san thue chap
	 * @throws PortalException if a tai san thue chap with the primary key could not be found
	 */
	public static com.mb.model.TaiSanThueChap getTaiSanThueChap(
			long taiSanThueChapId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getTaiSanThueChap(taiSanThueChapId);
	}

	/**
	 * Returns a range of all the tai san thue chaps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.TaiSanThueChapModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tai san thue chaps
	 * @param end the upper bound of the range of tai san thue chaps (not inclusive)
	 * @return the range of tai san thue chaps
	 */
	public static java.util.List<com.mb.model.TaiSanThueChap>
		getTaiSanThueChaps(int start, int end) {

		return getService().getTaiSanThueChaps(start, end);
	}

	/**
	 * Returns the number of tai san thue chaps.
	 *
	 * @return the number of tai san thue chaps
	 */
	public static int getTaiSanThueChapsCount() {
		return getService().getTaiSanThueChapsCount();
	}

	public static void removeByPhatVayId(long phatVayId)
		throws com.liferay.portal.kernel.exception.SystemException {

		getService().removeByPhatVayId(phatVayId);
	}

	/**
	 * Updates the tai san thue chap in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param taiSanThueChap the tai san thue chap
	 * @return the tai san thue chap that was updated
	 */
	public static com.mb.model.TaiSanThueChap updateTaiSanThueChap(
		com.mb.model.TaiSanThueChap taiSanThueChap) {

		return getService().updateTaiSanThueChap(taiSanThueChap);
	}

	public static com.mb.model.TaiSanThueChap updateTaiSanThueChap(
			com.mb.model.TaiSanThueChap taiSanThueChap,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().updateTaiSanThueChap(
			taiSanThueChap, serviceContext);
	}

	public static TaiSanThueChapLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<TaiSanThueChapLocalService, TaiSanThueChapLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			TaiSanThueChapLocalService.class);

		ServiceTracker<TaiSanThueChapLocalService, TaiSanThueChapLocalService>
			serviceTracker =
				new ServiceTracker
					<TaiSanThueChapLocalService, TaiSanThueChapLocalService>(
						bundle.getBundleContext(),
						TaiSanThueChapLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}