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
 * Provides the local service utility for LaiSuat. This utility wraps
 * <code>com.mb.service.impl.LaiSuatLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see LaiSuatLocalService
 * @generated
 */
@ProviderType
public class LaiSuatLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mb.service.impl.LaiSuatLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the lai suat to the database. Also notifies the appropriate model listeners.
	 *
	 * @param laiSuat the lai suat
	 * @return the lai suat that was added
	 */
	public static com.mb.model.LaiSuat addLaiSuat(
		com.mb.model.LaiSuat laiSuat) {

		return getService().addLaiSuat(laiSuat);
	}

	public static com.mb.model.LaiSuat addLaiSuat(
			com.mb.model.LaiSuat LaiSuat,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException,
			   com.mb.exception.TrungLaiSuatException {

		return getService().addLaiSuat(LaiSuat, serviceContext);
	}

	public static com.mb.model.LaiSuat addOrUpdateLaiSuat(
			com.mb.model.LaiSuat LaiSuat,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException,
			   com.mb.exception.TrungMaException,
			   com.mb.exception.TrungSoCMNDException {

		return getService().addOrUpdateLaiSuat(LaiSuat, serviceContext);
	}

	public static int countBase(
			Double soTienVay, Double laiSuat, int thoiHan, int hoatDong)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().countBase(soTienVay, laiSuat, thoiHan, hoatDong);
	}

	/**
	 * Creates a new lai suat with the primary key. Does not add the lai suat to the database.
	 *
	 * @param laiSuatId the primary key for the new lai suat
	 * @return the new lai suat
	 */
	public static com.mb.model.LaiSuat createLaiSuat(long laiSuatId) {
		return getService().createLaiSuat(laiSuatId);
	}

	/**
	 * Deletes the lai suat from the database. Also notifies the appropriate model listeners.
	 *
	 * @param laiSuat the lai suat
	 * @return the lai suat that was removed
	 */
	public static com.mb.model.LaiSuat deleteLaiSuat(
		com.mb.model.LaiSuat laiSuat) {

		return getService().deleteLaiSuat(laiSuat);
	}

	/**
	 * Deletes the lai suat with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param laiSuatId the primary key of the lai suat
	 * @return the lai suat that was removed
	 * @throws PortalException if a lai suat with the primary key could not be found
	 */
	public static com.mb.model.LaiSuat deleteLaiSuat(long laiSuatId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteLaiSuat(laiSuatId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.LaiSuatModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.LaiSuatModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.mb.model.LaiSuat fetchBySoTienVay_ThoiHan(
			Double soTienVay, int thoiHan)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return getService().fetchBySoTienVay_ThoiHan(soTienVay, thoiHan);
	}

	public static com.mb.model.LaiSuat fetchLaiSuat(long laiSuatId) {
		return getService().fetchLaiSuat(laiSuatId);
	}

	public static java.util.List<com.mb.model.LaiSuat> findBase(
			Double soTienVay, Double laiSuat, int thoiHan, int hoatDong,
			int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().findBase(
			soTienVay, laiSuat, thoiHan, hoatDong, start, end, obc);
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
	 * Returns the lai suat with the primary key.
	 *
	 * @param laiSuatId the primary key of the lai suat
	 * @return the lai suat
	 * @throws PortalException if a lai suat with the primary key could not be found
	 */
	public static com.mb.model.LaiSuat getLaiSuat(long laiSuatId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getLaiSuat(laiSuatId);
	}

	/**
	 * Returns a range of all the lai suats.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.LaiSuatModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lai suats
	 * @param end the upper bound of the range of lai suats (not inclusive)
	 * @return the range of lai suats
	 */
	public static java.util.List<com.mb.model.LaiSuat> getLaiSuats(
		int start, int end) {

		return getService().getLaiSuats(start, end);
	}

	/**
	 * Returns the number of lai suats.
	 *
	 * @return the number of lai suats
	 */
	public static int getLaiSuatsCount() {
		return getService().getLaiSuatsCount();
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
	 * Updates the lai suat in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param laiSuat the lai suat
	 * @return the lai suat that was updated
	 */
	public static com.mb.model.LaiSuat updateLaiSuat(
		com.mb.model.LaiSuat laiSuat) {

		return getService().updateLaiSuat(laiSuat);
	}

	public static com.mb.model.LaiSuat updateLaiSuat(
			com.mb.model.LaiSuat LaiSuat,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException,
			   com.mb.exception.TrungLaiSuatException {

		return getService().updateLaiSuat(LaiSuat, serviceContext);
	}

	public static LaiSuatLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LaiSuatLocalService, LaiSuatLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LaiSuatLocalService.class);

		ServiceTracker<LaiSuatLocalService, LaiSuatLocalService>
			serviceTracker =
				new ServiceTracker<LaiSuatLocalService, LaiSuatLocalService>(
					bundle.getBundleContext(), LaiSuatLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}