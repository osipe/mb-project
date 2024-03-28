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
 * Provides the local service utility for SoKheUoc. This utility wraps
 * <code>com.mb.service.impl.SoKheUocLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SoKheUocLocalService
 * @generated
 */
@ProviderType
public class SoKheUocLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mb.service.impl.SoKheUocLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the so khe uoc to the database. Also notifies the appropriate model listeners.
	 *
	 * @param soKheUoc the so khe uoc
	 * @return the so khe uoc that was added
	 */
	public static com.mb.model.SoKheUoc addSoKheUoc(
		com.mb.model.SoKheUoc soKheUoc) {

		return getService().addSoKheUoc(soKheUoc);
	}

	public static com.mb.model.SoKheUoc addSoKheUoc(
			com.mb.model.SoKheUoc soKheUoc,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().addSoKheUoc(soKheUoc, serviceContext);
	}

	public static int countBase(String cauTruc)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().countBase(cauTruc);
	}

	/**
	 * Creates a new so khe uoc with the primary key. Does not add the so khe uoc to the database.
	 *
	 * @param soKheUocId the primary key for the new so khe uoc
	 * @return the new so khe uoc
	 */
	public static com.mb.model.SoKheUoc createSoKheUoc(long soKheUocId) {
		return getService().createSoKheUoc(soKheUocId);
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
	 * Deletes the so khe uoc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param soKheUocId the primary key of the so khe uoc
	 * @return the so khe uoc that was removed
	 * @throws PortalException if a so khe uoc with the primary key could not be found
	 */
	public static com.mb.model.SoKheUoc deleteSoKheUoc(long soKheUocId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteSoKheUoc(soKheUocId);
	}

	/**
	 * Deletes the so khe uoc from the database. Also notifies the appropriate model listeners.
	 *
	 * @param soKheUoc the so khe uoc
	 * @return the so khe uoc that was removed
	 */
	public static com.mb.model.SoKheUoc deleteSoKheUoc(
		com.mb.model.SoKheUoc soKheUoc) {

		return getService().deleteSoKheUoc(soKheUoc);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.SoKheUocModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.SoKheUocModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.mb.model.SoKheUoc fetchByCauTruc(String cauTruc)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return getService().fetchByCauTruc(cauTruc);
	}

	public static com.mb.model.SoKheUoc fetchSoKheUoc(long soKheUocId) {
		return getService().fetchSoKheUoc(soKheUocId);
	}

	public static java.util.List<com.mb.model.SoKheUoc> findBase(
			String cauTruc, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().findBase(cauTruc, start, end, obc);
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
	 * Returns the so khe uoc with the primary key.
	 *
	 * @param soKheUocId the primary key of the so khe uoc
	 * @return the so khe uoc
	 * @throws PortalException if a so khe uoc with the primary key could not be found
	 */
	public static com.mb.model.SoKheUoc getSoKheUoc(long soKheUocId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getSoKheUoc(soKheUocId);
	}

	/**
	 * Returns a range of all the so khe uocs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.SoKheUocModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of so khe uocs
	 * @param end the upper bound of the range of so khe uocs (not inclusive)
	 * @return the range of so khe uocs
	 */
	public static java.util.List<com.mb.model.SoKheUoc> getSoKheUocs(
		int start, int end) {

		return getService().getSoKheUocs(start, end);
	}

	/**
	 * Returns the number of so khe uocs.
	 *
	 * @return the number of so khe uocs
	 */
	public static int getSoKheUocsCount() {
		return getService().getSoKheUocsCount();
	}

	public static com.mb.model.SoKheUoc tangSoKheUoc(
			String cauTruc,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().tangSoKheUoc(cauTruc, serviceContext);
	}

	/**
	 * Updates the so khe uoc in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param soKheUoc the so khe uoc
	 * @return the so khe uoc that was updated
	 */
	public static com.mb.model.SoKheUoc updateSoKheUoc(
		com.mb.model.SoKheUoc soKheUoc) {

		return getService().updateSoKheUoc(soKheUoc);
	}

	public static com.mb.model.SoKheUoc updateSoKheUoc(
			com.mb.model.SoKheUoc soKheUoc,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().updateSoKheUoc(soKheUoc, serviceContext);
	}

	public static SoKheUocLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SoKheUocLocalService, SoKheUocLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SoKheUocLocalService.class);

		ServiceTracker<SoKheUocLocalService, SoKheUocLocalService>
			serviceTracker =
				new ServiceTracker<SoKheUocLocalService, SoKheUocLocalService>(
					bundle.getBundleContext(), SoKheUocLocalService.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}