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
 * Provides the local service utility for MaSoTheoDoi. This utility wraps
 * <code>com.mb.service.impl.MaSoTheoDoiLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see MaSoTheoDoiLocalService
 * @generated
 */
@ProviderType
public class MaSoTheoDoiLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mb.service.impl.MaSoTheoDoiLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the ma so theo doi to the database. Also notifies the appropriate model listeners.
	 *
	 * @param maSoTheoDoi the ma so theo doi
	 * @return the ma so theo doi that was added
	 */
	public static com.mb.model.MaSoTheoDoi addMaSoTheoDoi(
		com.mb.model.MaSoTheoDoi maSoTheoDoi) {

		return getService().addMaSoTheoDoi(maSoTheoDoi);
	}

	public static com.mb.model.MaSoTheoDoi addMaSoTheoDoi(
			com.mb.model.MaSoTheoDoi maSoTheoDoi,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return getService().addMaSoTheoDoi(maSoTheoDoi, serviceContext);
	}

	public static com.mb.model.MaSoTheoDoi addOrUpdateMaSoThuChi(
			com.mb.model.MaSoTheoDoi maSoTheoDoi,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException,
			   com.mb.exception.TrungMaException {

		return getService().addOrUpdateMaSoThuChi(maSoTheoDoi, serviceContext);
	}

	public static int countBase(String ma, String dienGiai, int hoatDong)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().countBase(ma, dienGiai, hoatDong);
	}

	/**
	 * Creates a new ma so theo doi with the primary key. Does not add the ma so theo doi to the database.
	 *
	 * @param maSoTheoDoiId the primary key for the new ma so theo doi
	 * @return the new ma so theo doi
	 */
	public static com.mb.model.MaSoTheoDoi createMaSoTheoDoi(
		long maSoTheoDoiId) {

		return getService().createMaSoTheoDoi(maSoTheoDoiId);
	}

	/**
	 * Deletes the ma so theo doi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param maSoTheoDoiId the primary key of the ma so theo doi
	 * @return the ma so theo doi that was removed
	 * @throws PortalException if a ma so theo doi with the primary key could not be found
	 */
	public static com.mb.model.MaSoTheoDoi deleteMaSoTheoDoi(long maSoTheoDoiId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteMaSoTheoDoi(maSoTheoDoiId);
	}

	/**
	 * Deletes the ma so theo doi from the database. Also notifies the appropriate model listeners.
	 *
	 * @param maSoTheoDoi the ma so theo doi
	 * @return the ma so theo doi that was removed
	 */
	public static com.mb.model.MaSoTheoDoi deleteMaSoTheoDoi(
		com.mb.model.MaSoTheoDoi maSoTheoDoi) {

		return getService().deleteMaSoTheoDoi(maSoTheoDoi);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.MaSoTheoDoiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.MaSoTheoDoiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.mb.model.MaSoTheoDoi fetchByMa(String ma)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().fetchByMa(ma);
	}

	public static com.mb.model.MaSoTheoDoi fetchMaSoTheoDoi(
		long maSoTheoDoiId) {

		return getService().fetchMaSoTheoDoi(maSoTheoDoiId);
	}

	public static java.util.List<com.mb.model.MaSoTheoDoi> findBase(
			String ma, String dienGiai, int hoatDong, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().findBase(ma, dienGiai, hoatDong, start, end, obc);
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
	 * Returns the ma so theo doi with the primary key.
	 *
	 * @param maSoTheoDoiId the primary key of the ma so theo doi
	 * @return the ma so theo doi
	 * @throws PortalException if a ma so theo doi with the primary key could not be found
	 */
	public static com.mb.model.MaSoTheoDoi getMaSoTheoDoi(long maSoTheoDoiId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getMaSoTheoDoi(maSoTheoDoiId);
	}

	/**
	 * Returns a range of all the ma so theo dois.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.MaSoTheoDoiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ma so theo dois
	 * @param end the upper bound of the range of ma so theo dois (not inclusive)
	 * @return the range of ma so theo dois
	 */
	public static java.util.List<com.mb.model.MaSoTheoDoi> getMaSoTheoDois(
		int start, int end) {

		return getService().getMaSoTheoDois(start, end);
	}

	/**
	 * Returns the number of ma so theo dois.
	 *
	 * @return the number of ma so theo dois
	 */
	public static int getMaSoTheoDoisCount() {
		return getService().getMaSoTheoDoisCount();
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
	 * Updates the ma so theo doi in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param maSoTheoDoi the ma so theo doi
	 * @return the ma so theo doi that was updated
	 */
	public static com.mb.model.MaSoTheoDoi updateMaSoTheoDoi(
		com.mb.model.MaSoTheoDoi maSoTheoDoi) {

		return getService().updateMaSoTheoDoi(maSoTheoDoi);
	}

	public static com.mb.model.MaSoTheoDoi updateMaSoTheoDoi(
			com.mb.model.MaSoTheoDoi maSoTheoDoi,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return getService().updateMaSoTheoDoi(maSoTheoDoi, serviceContext);
	}

	public static MaSoTheoDoiLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<MaSoTheoDoiLocalService, MaSoTheoDoiLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(MaSoTheoDoiLocalService.class);

		ServiceTracker<MaSoTheoDoiLocalService, MaSoTheoDoiLocalService>
			serviceTracker =
				new ServiceTracker
					<MaSoTheoDoiLocalService, MaSoTheoDoiLocalService>(
						bundle.getBundleContext(),
						MaSoTheoDoiLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}