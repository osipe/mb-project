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
 * Provides the local service utility for PhatVay. This utility wraps
 * <code>com.mb.service.impl.PhatVayLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see PhatVayLocalService
 * @generated
 */
@ProviderType
public class PhatVayLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mb.service.impl.PhatVayLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.mb.model.PhatVay addOrUpdatePhatVay(
			com.mb.model.PhatVay phatVay,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.NoSuchUserException,
			   com.liferay.portal.kernel.exception.SystemException,
			   com.mb.exception.TrungSoKUException {

		return getService().addOrUpdatePhatVay(phatVay, serviceContext);
	}

	public static void addOrUpdateThongTinLienQuan(
			com.mb.model.PhatVay phatVay,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.NoSuchUserException,
			   com.liferay.portal.kernel.exception.SystemException {

		getService().addOrUpdateThongTinLienQuan(phatVay, serviceContext);
	}

	/**
	 * Adds the phat vay to the database. Also notifies the appropriate model listeners.
	 *
	 * @param phatVay the phat vay
	 * @return the phat vay that was added
	 */
	public static com.mb.model.PhatVay addPhatVay(
		com.mb.model.PhatVay phatVay) {

		return getService().addPhatVay(phatVay);
	}

	public static com.mb.model.PhatVay addPhatVay(
			com.mb.model.PhatVay phatVay,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.NoSuchUserException,
			   com.liferay.portal.kernel.exception.SystemException,
			   com.mb.exception.TrungSoKUException {

		return getService().addPhatVay(phatVay, serviceContext);
	}

	public static int countBase(
			String soKU, String maCTV, String maKhachHang,
			java.util.Date createDateTu, java.util.Date createDateDen,
			java.util.Date ngayBatDauTu, java.util.Date ngayBatDauDen,
			java.util.Date ngayTatToanTu, java.util.Date ngayTatToanDen,
			String trangThai)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().countBase(
			soKU, maCTV, maKhachHang, createDateTu, createDateDen, ngayBatDauTu,
			ngayBatDauDen, ngayTatToanTu, ngayTatToanDen, trangThai);
	}

	public static int countCTV_NgayThuTien(
		long chiNhanhId, String maCTV, java.util.Date ngayThuTien) {

		return getService().countCTV_NgayThuTien(
			chiNhanhId, maCTV, ngayThuTien);
	}

	/**
	 * Creates a new phat vay with the primary key. Does not add the phat vay to the database.
	 *
	 * @param phatVayId the primary key for the new phat vay
	 * @return the new phat vay
	 */
	public static com.mb.model.PhatVay createPhatVay(long phatVayId) {
		return getService().createPhatVay(phatVayId);
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
	 * Deletes the phat vay with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param phatVayId the primary key of the phat vay
	 * @return the phat vay that was removed
	 * @throws PortalException if a phat vay with the primary key could not be found
	 */
	public static com.mb.model.PhatVay deletePhatVay(long phatVayId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePhatVay(phatVayId);
	}

	/**
	 * Deletes the phat vay from the database. Also notifies the appropriate model listeners.
	 *
	 * @param phatVay the phat vay
	 * @return the phat vay that was removed
	 */
	public static com.mb.model.PhatVay deletePhatVay(
		com.mb.model.PhatVay phatVay) {

		return getService().deletePhatVay(phatVay);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.PhatVayModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.PhatVayModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.mb.model.PhatVay fetchBySoKU(String soKU) {
		return getService().fetchBySoKU(soKU);
	}

	public static com.mb.model.PhatVay fetchPhatVay(long phatVayId) {
		return getService().fetchPhatVay(phatVayId);
	}

	public static java.util.List<com.mb.model.PhatVay> findBase(
		String soKU, String maCTV, String maKhachHang,
		java.util.Date createDateTu, java.util.Date createDateDen,
		java.util.Date ngayBatDauTu, java.util.Date ngayBatDauDen,
		java.util.Date ngayTatToanTu, java.util.Date ngayTatToanDen,
		String trangThai, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc) {

		return getService().findBase(
			soKU, maCTV, maKhachHang, createDateTu, createDateDen, ngayBatDauTu,
			ngayBatDauDen, ngayTatToanTu, ngayTatToanDen, trangThai, start, end,
			obc);
	}

	public static java.util.List<com.mb.model.PhatVay> findByMaCTV(String maCTV)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().findByMaCTV(maCTV);
	}

	public static java.util.List<com.mb.model.PhatVay> findCTV_NgayThuTien(
		long chiNhanhId, String maCTV, java.util.Date ngayThuTien) {

		return getService().findCTV_NgayThuTien(chiNhanhId, maCTV, ngayThuTien);
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
	 * Returns a range of all the phat vaies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.PhatVayModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of phat vaies
	 * @param end the upper bound of the range of phat vaies (not inclusive)
	 * @return the range of phat vaies
	 */
	public static java.util.List<com.mb.model.PhatVay> getPhatVaies(
		int start, int end) {

		return getService().getPhatVaies(start, end);
	}

	/**
	 * Returns the number of phat vaies.
	 *
	 * @return the number of phat vaies
	 */
	public static int getPhatVaiesCount() {
		return getService().getPhatVaiesCount();
	}

	/**
	 * Returns the phat vay with the primary key.
	 *
	 * @param phatVayId the primary key of the phat vay
	 * @return the phat vay
	 * @throws PortalException if a phat vay with the primary key could not be found
	 */
	public static com.mb.model.PhatVay getPhatVay(long phatVayId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPhatVay(phatVayId);
	}

	public static java.util.List<com.mb.model.PhatVay> getPhatVayDeThuTienTruoc(
		String maCTV, java.util.Date ngayThuTienTu) {

		return getService().getPhatVayDeThuTienTruoc(maCTV, ngayThuTienTu);
	}

	public static java.util.List<com.mb.model.PhatVay> getPhatVayInIds(
			String ids)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getPhatVayInIds(ids);
	}

	public static java.util.List<com.mb.model.PhatVay> getPhatVaySaoKe(
			long chiNhanhId, String maCTV, int loaiPhatVay,
			java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getPhatVaySaoKe(
			chiNhanhId, maCTV, loaiPhatVay, createDate);
	}

	public static void updateChiNhanh(String maCTV, long chiNhanhId)
		throws com.liferay.portal.kernel.exception.SystemException {

		getService().updateChiNhanh(maCTV, chiNhanhId);
	}

	/**
	 * Updates the phat vay in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param phatVay the phat vay
	 * @return the phat vay that was updated
	 */
	public static com.mb.model.PhatVay updatePhatVay(
		com.mb.model.PhatVay phatVay) {

		return getService().updatePhatVay(phatVay);
	}

	public static com.mb.model.PhatVay updatePhatVay(
			com.mb.model.PhatVay phatVay,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.NoSuchUserException,
			   com.liferay.portal.kernel.exception.SystemException,
			   com.mb.exception.TrungSoKUException {

		return getService().updatePhatVay(phatVay, serviceContext);
	}

	public static void xoaToanBoThongTinPhatVay(long phatVayId)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		getService().xoaToanBoThongTinPhatVay(phatVayId);
	}

	public static PhatVayLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PhatVayLocalService, PhatVayLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PhatVayLocalService.class);

		ServiceTracker<PhatVayLocalService, PhatVayLocalService>
			serviceTracker =
				new ServiceTracker<PhatVayLocalService, PhatVayLocalService>(
					bundle.getBundleContext(), PhatVayLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}