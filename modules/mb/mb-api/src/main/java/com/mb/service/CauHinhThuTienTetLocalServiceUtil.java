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
 * Provides the local service utility for CauHinhThuTienTet. This utility wraps
 * <code>com.mb.service.impl.CauHinhThuTienTetLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CauHinhThuTienTetLocalService
 * @generated
 */
@ProviderType
public class CauHinhThuTienTetLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mb.service.impl.CauHinhThuTienTetLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the cau hinh thu tien tet to the database. Also notifies the appropriate model listeners.
	 *
	 * @param cauHinhThuTienTet the cau hinh thu tien tet
	 * @return the cau hinh thu tien tet that was added
	 */
	public static com.mb.model.CauHinhThuTienTet addCauHinhThuTienTet(
		com.mb.model.CauHinhThuTienTet cauHinhThuTienTet) {

		return getService().addCauHinhThuTienTet(cauHinhThuTienTet);
	}

	/**
	 * Creates a new cau hinh thu tien tet with the primary key. Does not add the cau hinh thu tien tet to the database.
	 *
	 * @param cauHinhThuTienTetId the primary key for the new cau hinh thu tien tet
	 * @return the new cau hinh thu tien tet
	 */
	public static com.mb.model.CauHinhThuTienTet createCauHinhThuTienTet(
		long cauHinhThuTienTetId) {

		return getService().createCauHinhThuTienTet(cauHinhThuTienTetId);
	}

	/**
	 * Deletes the cau hinh thu tien tet from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cauHinhThuTienTet the cau hinh thu tien tet
	 * @return the cau hinh thu tien tet that was removed
	 */
	public static com.mb.model.CauHinhThuTienTet deleteCauHinhThuTienTet(
		com.mb.model.CauHinhThuTienTet cauHinhThuTienTet) {

		return getService().deleteCauHinhThuTienTet(cauHinhThuTienTet);
	}

	/**
	 * Deletes the cau hinh thu tien tet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cauHinhThuTienTetId the primary key of the cau hinh thu tien tet
	 * @return the cau hinh thu tien tet that was removed
	 * @throws PortalException if a cau hinh thu tien tet with the primary key could not be found
	 */
	public static com.mb.model.CauHinhThuTienTet deleteCauHinhThuTienTet(
			long cauHinhThuTienTetId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteCauHinhThuTienTet(cauHinhThuTienTetId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.CauHinhThuTienTetModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.CauHinhThuTienTetModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.mb.model.CauHinhThuTienTet fetchCauHinhThuTienTet(
		long cauHinhThuTienTetId) {

		return getService().fetchCauHinhThuTienTet(cauHinhThuTienTetId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the cau hinh thu tien tet with the primary key.
	 *
	 * @param cauHinhThuTienTetId the primary key of the cau hinh thu tien tet
	 * @return the cau hinh thu tien tet
	 * @throws PortalException if a cau hinh thu tien tet with the primary key could not be found
	 */
	public static com.mb.model.CauHinhThuTienTet getCauHinhThuTienTet(
			long cauHinhThuTienTetId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCauHinhThuTienTet(cauHinhThuTienTetId);
	}

	/**
	 * Returns a range of all the cau hinh thu tien tets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.CauHinhThuTienTetModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cau hinh thu tien tets
	 * @param end the upper bound of the range of cau hinh thu tien tets (not inclusive)
	 * @return the range of cau hinh thu tien tets
	 */
	public static java.util.List<com.mb.model.CauHinhThuTienTet>
		getCauHinhThuTienTets(int start, int end) {

		return getService().getCauHinhThuTienTets(start, end);
	}

	/**
	 * Returns the number of cau hinh thu tien tets.
	 *
	 * @return the number of cau hinh thu tien tets
	 */
	public static int getCauHinhThuTienTetsCount() {
		return getService().getCauHinhThuTienTetsCount();
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
	 * Updates the cau hinh thu tien tet in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param cauHinhThuTienTet the cau hinh thu tien tet
	 * @return the cau hinh thu tien tet that was updated
	 */
	public static com.mb.model.CauHinhThuTienTet updateCauHinhThuTienTet(
		com.mb.model.CauHinhThuTienTet cauHinhThuTienTet) {

		return getService().updateCauHinhThuTienTet(cauHinhThuTienTet);
	}

	public static CauHinhThuTienTetLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CauHinhThuTienTetLocalService, CauHinhThuTienTetLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			CauHinhThuTienTetLocalService.class);

		ServiceTracker
			<CauHinhThuTienTetLocalService, CauHinhThuTienTetLocalService>
				serviceTracker =
					new ServiceTracker
						<CauHinhThuTienTetLocalService,
						 CauHinhThuTienTetLocalService>(
							 bundle.getBundleContext(),
							 CauHinhThuTienTetLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}