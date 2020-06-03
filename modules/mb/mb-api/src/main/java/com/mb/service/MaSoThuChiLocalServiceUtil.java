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
 * Provides the local service utility for MaSoThuChi. This utility wraps
 * <code>com.mb.service.impl.MaSoThuChiLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see MaSoThuChiLocalService
 * @generated
 */
@ProviderType
public class MaSoThuChiLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mb.service.impl.MaSoThuChiLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the ma so thu chi to the database. Also notifies the appropriate model listeners.
	 *
	 * @param maSoThuChi the ma so thu chi
	 * @return the ma so thu chi that was added
	 */
	public static com.mb.model.MaSoThuChi addMaSoThuChi(
		com.mb.model.MaSoThuChi maSoThuChi) {

		return getService().addMaSoThuChi(maSoThuChi);
	}

	public static com.mb.model.MaSoThuChi addMaSoThuChi(
			com.mb.model.MaSoThuChi maSoThuChi,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException,
			   com.mb.exception.TrungMaException {

		return getService().addMaSoThuChi(maSoThuChi, serviceContext);
	}

	public static com.mb.model.MaSoThuChi addOrUpdateMaSoThuChi(
			com.mb.model.MaSoThuChi maSoThuChi,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException,
			   com.mb.exception.TrungMaException {

		return getService().addOrUpdateMaSoThuChi(maSoThuChi, serviceContext);
	}

	public static int countBase(
			String ma, String dienGiai, int loai, int hoatDong)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().countBase(ma, dienGiai, loai, hoatDong);
	}

	/**
	 * Creates a new ma so thu chi with the primary key. Does not add the ma so thu chi to the database.
	 *
	 * @param maSoThuChiId the primary key for the new ma so thu chi
	 * @return the new ma so thu chi
	 */
	public static com.mb.model.MaSoThuChi createMaSoThuChi(long maSoThuChiId) {
		return getService().createMaSoThuChi(maSoThuChiId);
	}

	/**
	 * Deletes the ma so thu chi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param maSoThuChiId the primary key of the ma so thu chi
	 * @return the ma so thu chi that was removed
	 * @throws PortalException if a ma so thu chi with the primary key could not be found
	 */
	public static com.mb.model.MaSoThuChi deleteMaSoThuChi(long maSoThuChiId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteMaSoThuChi(maSoThuChiId);
	}

	/**
	 * Deletes the ma so thu chi from the database. Also notifies the appropriate model listeners.
	 *
	 * @param maSoThuChi the ma so thu chi
	 * @return the ma so thu chi that was removed
	 */
	public static com.mb.model.MaSoThuChi deleteMaSoThuChi(
		com.mb.model.MaSoThuChi maSoThuChi) {

		return getService().deleteMaSoThuChi(maSoThuChi);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.MaSoThuChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.MaSoThuChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.mb.model.MaSoThuChi fetchByMa_Loai_HoatDong(
			String ma, int loai, boolean hoatDong)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().fetchByMa_Loai_HoatDong(ma, loai, hoatDong);
	}

	public static com.mb.model.MaSoThuChi fetchMaSoThuChi(long maSoThuChiId) {
		return getService().fetchMaSoThuChi(maSoThuChiId);
	}

	public static java.util.List<com.mb.model.MaSoThuChi> findBase(
			String ma, String dienGiai, int loai, int hoatDong, int start,
			int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().findBase(
			ma, dienGiai, loai, hoatDong, start, end, obc);
	}

	public static java.util.List<com.mb.model.MaSoThuChi> findByLoai_HoatDong(
			int loai, boolean hoatDong)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().findByLoai_HoatDong(loai, hoatDong);
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
	 * Returns the ma so thu chi with the primary key.
	 *
	 * @param maSoThuChiId the primary key of the ma so thu chi
	 * @return the ma so thu chi
	 * @throws PortalException if a ma so thu chi with the primary key could not be found
	 */
	public static com.mb.model.MaSoThuChi getMaSoThuChi(long maSoThuChiId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getMaSoThuChi(maSoThuChiId);
	}

	/**
	 * Returns a range of all the ma so thu chis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.MaSoThuChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ma so thu chis
	 * @param end the upper bound of the range of ma so thu chis (not inclusive)
	 * @return the range of ma so thu chis
	 */
	public static java.util.List<com.mb.model.MaSoThuChi> getMaSoThuChis(
		int start, int end) {

		return getService().getMaSoThuChis(start, end);
	}

	/**
	 * Returns the number of ma so thu chis.
	 *
	 * @return the number of ma so thu chis
	 */
	public static int getMaSoThuChisCount() {
		return getService().getMaSoThuChisCount();
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
	 * Updates the ma so thu chi in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param maSoThuChi the ma so thu chi
	 * @return the ma so thu chi that was updated
	 */
	public static com.mb.model.MaSoThuChi updateMaSoThuChi(
		com.mb.model.MaSoThuChi maSoThuChi) {

		return getService().updateMaSoThuChi(maSoThuChi);
	}

	public static com.mb.model.MaSoThuChi updateMaSoThuChi(
			com.mb.model.MaSoThuChi maSoThuChi,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException,
			   com.mb.exception.TrungMaException {

		return getService().updateMaSoThuChi(maSoThuChi, serviceContext);
	}

	public static MaSoThuChiLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<MaSoThuChiLocalService, MaSoThuChiLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(MaSoThuChiLocalService.class);

		ServiceTracker<MaSoThuChiLocalService, MaSoThuChiLocalService>
			serviceTracker =
				new ServiceTracker
					<MaSoThuChiLocalService, MaSoThuChiLocalService>(
						bundle.getBundleContext(), MaSoThuChiLocalService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}