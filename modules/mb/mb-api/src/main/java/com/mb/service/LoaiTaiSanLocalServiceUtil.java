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
 * Provides the local service utility for LoaiTaiSan. This utility wraps
 * <code>com.mb.service.impl.LoaiTaiSanLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see LoaiTaiSanLocalService
 * @generated
 */
@ProviderType
public class LoaiTaiSanLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mb.service.impl.LoaiTaiSanLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the loai tai san to the database. Also notifies the appropriate model listeners.
	 *
	 * @param loaiTaiSan the loai tai san
	 * @return the loai tai san that was added
	 */
	public static com.mb.model.LoaiTaiSan addLoaiTaiSan(
		com.mb.model.LoaiTaiSan loaiTaiSan) {

		return getService().addLoaiTaiSan(loaiTaiSan);
	}

	public static com.mb.model.LoaiTaiSan addLoaiTaiSan(
			com.mb.model.LoaiTaiSan LoaiTaiSan,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException,
			   com.mb.exception.TrungMaException,
			   com.mb.exception.TrungSoCMNDException {

		return getService().addLoaiTaiSan(LoaiTaiSan, serviceContext);
	}

	public static com.mb.model.LoaiTaiSan addOrUpdateLoaiTaiSan(
			com.mb.model.LoaiTaiSan LoaiTaiSan,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException,
			   com.mb.exception.TrungMaException,
			   com.mb.exception.TrungSoCMNDException {

		return getService().addOrUpdateLoaiTaiSan(LoaiTaiSan, serviceContext);
	}

	public static int countBase(
			String ma, String ten, String ghiChu, int hoatDong)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().countBase(ma, ten, ghiChu, hoatDong);
	}

	/**
	 * Creates a new loai tai san with the primary key. Does not add the loai tai san to the database.
	 *
	 * @param loaiTaiSanId the primary key for the new loai tai san
	 * @return the new loai tai san
	 */
	public static com.mb.model.LoaiTaiSan createLoaiTaiSan(long loaiTaiSanId) {
		return getService().createLoaiTaiSan(loaiTaiSanId);
	}

	/**
	 * Deletes the loai tai san from the database. Also notifies the appropriate model listeners.
	 *
	 * @param loaiTaiSan the loai tai san
	 * @return the loai tai san that was removed
	 */
	public static com.mb.model.LoaiTaiSan deleteLoaiTaiSan(
		com.mb.model.LoaiTaiSan loaiTaiSan) {

		return getService().deleteLoaiTaiSan(loaiTaiSan);
	}

	/**
	 * Deletes the loai tai san with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param loaiTaiSanId the primary key of the loai tai san
	 * @return the loai tai san that was removed
	 * @throws PortalException if a loai tai san with the primary key could not be found
	 */
	public static com.mb.model.LoaiTaiSan deleteLoaiTaiSan(long loaiTaiSanId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteLoaiTaiSan(loaiTaiSanId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.LoaiTaiSanModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.LoaiTaiSanModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.mb.model.LoaiTaiSan fetchByMa(String ma)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().fetchByMa(ma);
	}

	public static com.mb.model.LoaiTaiSan fetchLoaiTaiSan(long loaiTaiSanId) {
		return getService().fetchLoaiTaiSan(loaiTaiSanId);
	}

	public static java.util.List<com.mb.model.LoaiTaiSan> findBase(
			String ma, String ten, String ghiChu, int hoatDong, int start,
			int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().findBase(
			ma, ten, ghiChu, hoatDong, start, end, obc);
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
	 * Returns the loai tai san with the primary key.
	 *
	 * @param loaiTaiSanId the primary key of the loai tai san
	 * @return the loai tai san
	 * @throws PortalException if a loai tai san with the primary key could not be found
	 */
	public static com.mb.model.LoaiTaiSan getLoaiTaiSan(long loaiTaiSanId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getLoaiTaiSan(loaiTaiSanId);
	}

	/**
	 * Returns a range of all the loai tai sans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.LoaiTaiSanModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of loai tai sans
	 * @param end the upper bound of the range of loai tai sans (not inclusive)
	 * @return the range of loai tai sans
	 */
	public static java.util.List<com.mb.model.LoaiTaiSan> getLoaiTaiSans(
		int start, int end) {

		return getService().getLoaiTaiSans(start, end);
	}

	/**
	 * Returns the number of loai tai sans.
	 *
	 * @return the number of loai tai sans
	 */
	public static int getLoaiTaiSansCount() {
		return getService().getLoaiTaiSansCount();
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
	 * Updates the loai tai san in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param loaiTaiSan the loai tai san
	 * @return the loai tai san that was updated
	 */
	public static com.mb.model.LoaiTaiSan updateLoaiTaiSan(
		com.mb.model.LoaiTaiSan loaiTaiSan) {

		return getService().updateLoaiTaiSan(loaiTaiSan);
	}

	public static com.mb.model.LoaiTaiSan updateLoaiTaiSan(
			com.mb.model.LoaiTaiSan LoaiTaiSan,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException,
			   com.mb.exception.TrungMaException,
			   com.mb.exception.TrungSoCMNDException {

		return getService().updateLoaiTaiSan(LoaiTaiSan, serviceContext);
	}

	public static LoaiTaiSanLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<LoaiTaiSanLocalService, LoaiTaiSanLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LoaiTaiSanLocalService.class);

		ServiceTracker<LoaiTaiSanLocalService, LoaiTaiSanLocalService>
			serviceTracker =
				new ServiceTracker
					<LoaiTaiSanLocalService, LoaiTaiSanLocalService>(
						bundle.getBundleContext(), LoaiTaiSanLocalService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}