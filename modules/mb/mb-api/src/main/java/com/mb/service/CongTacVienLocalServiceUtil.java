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
 * Provides the local service utility for CongTacVien. This utility wraps
 * <code>com.mb.service.impl.CongTacVienLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CongTacVienLocalService
 * @generated
 */
@ProviderType
public class CongTacVienLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mb.service.impl.CongTacVienLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the cong tac vien to the database. Also notifies the appropriate model listeners.
	 *
	 * @param congTacVien the cong tac vien
	 * @return the cong tac vien that was added
	 */
	public static com.mb.model.CongTacVien addCongTacVien(
		com.mb.model.CongTacVien congTacVien) {

		return getService().addCongTacVien(congTacVien);
	}

	public static com.mb.model.CongTacVien addCongTacVien(
			com.mb.model.CongTacVien congTacVien,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException,
			   com.mb.exception.TrungMaException,
			   com.mb.exception.TrungSoCMNDException {

		return getService().addCongTacVien(congTacVien, serviceContext);
	}

	public static com.mb.model.CongTacVien addOrUpdateCongTacVien(
			com.mb.model.CongTacVien congTacVien,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException,
			   com.mb.exception.TrungMaException,
			   com.mb.exception.TrungSoCMNDException {

		return getService().addOrUpdateCongTacVien(congTacVien, serviceContext);
	}

	public static int countBase(
			String ma, String hoTen, String soCMND, String diaChi, int hoatDong)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().countBase(ma, hoTen, soCMND, diaChi, hoatDong);
	}

	/**
	 * Creates a new cong tac vien with the primary key. Does not add the cong tac vien to the database.
	 *
	 * @param congTacVienId the primary key for the new cong tac vien
	 * @return the new cong tac vien
	 */
	public static com.mb.model.CongTacVien createCongTacVien(
		long congTacVienId) {

		return getService().createCongTacVien(congTacVienId);
	}

	/**
	 * Deletes the cong tac vien from the database. Also notifies the appropriate model listeners.
	 *
	 * @param congTacVien the cong tac vien
	 * @return the cong tac vien that was removed
	 */
	public static com.mb.model.CongTacVien deleteCongTacVien(
		com.mb.model.CongTacVien congTacVien) {

		return getService().deleteCongTacVien(congTacVien);
	}

	/**
	 * Deletes the cong tac vien with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param congTacVienId the primary key of the cong tac vien
	 * @return the cong tac vien that was removed
	 * @throws PortalException if a cong tac vien with the primary key could not be found
	 */
	public static com.mb.model.CongTacVien deleteCongTacVien(long congTacVienId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteCongTacVien(congTacVienId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.CongTacVienModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.CongTacVienModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.mb.model.CongTacVien fetchByMa(String ma)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().fetchByMa(ma);
	}

	public static com.mb.model.CongTacVien fetchBySoCMND(String soCMND)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().fetchBySoCMND(soCMND);
	}

	public static com.mb.model.CongTacVien fetchCongTacVien(
		long congTacVienId) {

		return getService().fetchCongTacVien(congTacVienId);
	}

	public static java.util.List<com.mb.model.CongTacVien> findBase(
			String ma, String hoTen, String soCMND, String diaChi, int hoatDong,
			int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().findBase(
			ma, hoTen, soCMND, diaChi, hoatDong, start, end, obc);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the cong tac vien with the primary key.
	 *
	 * @param congTacVienId the primary key of the cong tac vien
	 * @return the cong tac vien
	 * @throws PortalException if a cong tac vien with the primary key could not be found
	 */
	public static com.mb.model.CongTacVien getCongTacVien(long congTacVienId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCongTacVien(congTacVienId);
	}

	/**
	 * Returns a range of all the cong tac viens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.CongTacVienModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cong tac viens
	 * @param end the upper bound of the range of cong tac viens (not inclusive)
	 * @return the range of cong tac viens
	 */
	public static java.util.List<com.mb.model.CongTacVien> getCongTacViens(
		int start, int end) {

		return getService().getCongTacViens(start, end);
	}

	/**
	 * Returns the number of cong tac viens.
	 *
	 * @return the number of cong tac viens
	 */
	public static int getCongTacViensCount() {
		return getService().getCongTacViensCount();
	}

	public static java.util.List<com.mb.model.CongTacVien> getCTVPhatVayNgay(
			java.util.Date ngayTaoTu, java.util.Date ngayTaoDen)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getCTVPhatVayNgay(ngayTaoTu, ngayTaoDen);
	}

	public static java.util.List<com.mb.model.CongTacVien> getCTVSaoKe(
			String maCTV, java.util.Date ngayTaoTu)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getCTVSaoKe(maCTV, ngayTaoTu);
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
	 * Updates the cong tac vien in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param congTacVien the cong tac vien
	 * @return the cong tac vien that was updated
	 */
	public static com.mb.model.CongTacVien updateCongTacVien(
		com.mb.model.CongTacVien congTacVien) {

		return getService().updateCongTacVien(congTacVien);
	}

	public static com.mb.model.CongTacVien updateCongTacVien(
			com.mb.model.CongTacVien congTacVien,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException,
			   com.mb.exception.TrungMaException,
			   com.mb.exception.TrungSoCMNDException {

		return getService().updateCongTacVien(congTacVien, serviceContext);
	}

	public static CongTacVienLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CongTacVienLocalService, CongTacVienLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CongTacVienLocalService.class);

		ServiceTracker<CongTacVienLocalService, CongTacVienLocalService>
			serviceTracker =
				new ServiceTracker
					<CongTacVienLocalService, CongTacVienLocalService>(
						bundle.getBundleContext(),
						CongTacVienLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}