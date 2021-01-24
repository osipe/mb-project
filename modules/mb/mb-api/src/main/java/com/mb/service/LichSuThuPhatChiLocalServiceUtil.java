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
 * Provides the local service utility for LichSuThuPhatChi. This utility wraps
 * <code>com.mb.service.impl.LichSuThuPhatChiLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see LichSuThuPhatChiLocalService
 * @generated
 */
@ProviderType
public class LichSuThuPhatChiLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.mb.service.impl.LichSuThuPhatChiLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the lich su thu phat chi to the database. Also notifies the appropriate model listeners.
	 *
	 * @param lichSuThuPhatChi the lich su thu phat chi
	 * @return the lich su thu phat chi that was added
	 */
	public static com.mb.model.LichSuThuPhatChi addLichSuThuPhatChi(
		com.mb.model.LichSuThuPhatChi lichSuThuPhatChi) {

		return getService().addLichSuThuPhatChi(lichSuThuPhatChi);
	}

	public static com.mb.model.LichSuThuPhatChi addLichSuThuPhatChi(
			com.mb.model.LichSuThuPhatChi lichSuThuPhatChi,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.NoSuchUserException,
			   com.liferay.portal.kernel.exception.SystemException {

		return getService().addLichSuThuPhatChi(
			lichSuThuPhatChi, serviceContext);
	}

	public static com.mb.model.LichSuThuPhatChi addOrUpdateLichSuThuPhatChi(
			com.mb.model.LichSuThuPhatChi lichSuThuPhatChi,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.NoSuchUserException,
			   com.liferay.portal.kernel.exception.SystemException {

		return getService().addOrUpdateLichSuThuPhatChi(
			lichSuThuPhatChi, serviceContext);
	}

	/**
	 * Creates a new lich su thu phat chi with the primary key. Does not add the lich su thu phat chi to the database.
	 *
	 * @param lichSuThuPhatChiId the primary key for the new lich su thu phat chi
	 * @return the new lich su thu phat chi
	 */
	public static com.mb.model.LichSuThuPhatChi createLichSuThuPhatChi(
		long lichSuThuPhatChiId) {

		return getService().createLichSuThuPhatChi(lichSuThuPhatChiId);
	}

	/**
	 * Deletes the lich su thu phat chi from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lichSuThuPhatChi the lich su thu phat chi
	 * @return the lich su thu phat chi that was removed
	 */
	public static com.mb.model.LichSuThuPhatChi deleteLichSuThuPhatChi(
		com.mb.model.LichSuThuPhatChi lichSuThuPhatChi) {

		return getService().deleteLichSuThuPhatChi(lichSuThuPhatChi);
	}

	/**
	 * Deletes the lich su thu phat chi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lichSuThuPhatChiId the primary key of the lich su thu phat chi
	 * @return the lich su thu phat chi that was removed
	 * @throws PortalException if a lich su thu phat chi with the primary key could not be found
	 */
	public static com.mb.model.LichSuThuPhatChi deleteLichSuThuPhatChi(
			long lichSuThuPhatChiId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteLichSuThuPhatChi(lichSuThuPhatChiId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.LichSuThuPhatChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.LichSuThuPhatChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.mb.model.LichSuThuPhatChi fetchLichSuThuPhatChi(
		long lichSuThuPhatChiId) {

		return getService().fetchLichSuThuPhatChi(lichSuThuPhatChiId);
	}

	public static java.util.List<com.mb.model.LichSuThuPhatChi>
			findByCTV_Loai_Createdate(
				String maCTV, int loai, java.util.Date ngayTaoTu,
				java.util.Date ngayTaoDen, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().findByCTV_Loai_Createdate(
			maCTV, loai, ngayTaoTu, ngayTaoDen, start, end, obc);
	}

	public static java.util.List<com.mb.model.LichSuThuPhatChi>
			findByCTV_Loai_Createdate_NgayXuLy(
				String maCTV, int loai, java.util.Date ngayTaoTu,
				java.util.Date ngayTaoDen, java.util.Date ngayXuLyTu,
				java.util.Date ngayXuLyDen, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().findByCTV_Loai_Createdate_NgayXuLy(
			maCTV, loai, ngayTaoTu, ngayTaoDen, ngayXuLyTu, ngayXuLyDen, start,
			end, obc);
	}

	public static java.util.List<com.mb.model.LichSuThuPhatChi>
			findByPhatVay_Createdate_Loai(
				long chiNhanhId, long phatVayId, java.util.Date ngayTaoTu,
				java.util.Date ngayTaoDen, String loai)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().findByPhatVay_Createdate_Loai(
			chiNhanhId, phatVayId, ngayTaoTu, ngayTaoDen, loai);
	}

	public static java.util.List<com.mb.model.LichSuThuPhatChi>
			findByPhatVayId_Loai(long phatVayId, int loai)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().findByPhatVayId_Loai(phatVayId, loai);
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
	 * Returns the lich su thu phat chi with the primary key.
	 *
	 * @param lichSuThuPhatChiId the primary key of the lich su thu phat chi
	 * @return the lich su thu phat chi
	 * @throws PortalException if a lich su thu phat chi with the primary key could not be found
	 */
	public static com.mb.model.LichSuThuPhatChi getLichSuThuPhatChi(
			long lichSuThuPhatChiId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getLichSuThuPhatChi(lichSuThuPhatChiId);
	}

	public static java.util.List<Object[]> getLichSuThuPhatChi_MaCTV_Createdate(
			String maCTV, java.util.Date createdate)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getLichSuThuPhatChi_MaCTV_Createdate(
			maCTV, createdate);
	}

	/**
	 * Returns a range of all the lich su thu phat chis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.LichSuThuPhatChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lich su thu phat chis
	 * @param end the upper bound of the range of lich su thu phat chis (not inclusive)
	 * @return the range of lich su thu phat chis
	 */
	public static java.util.List<com.mb.model.LichSuThuPhatChi>
		getLichSuThuPhatChis(int start, int end) {

		return getService().getLichSuThuPhatChis(start, end);
	}

	/**
	 * Returns the number of lich su thu phat chis.
	 *
	 * @return the number of lich su thu phat chis
	 */
	public static int getLichSuThuPhatChisCount() {
		return getService().getLichSuThuPhatChisCount();
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

	public static Double getSoTienVay_CTV_TAINGAY(
			long chiNhanhId, String maCTV, java.util.Date ngay)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getSoTienVay_CTV_TAINGAY(chiNhanhId, maCTV, ngay);
	}

	public static Object[] getSumPhatVay_CTV_TAINGAY(
			long chiNhanhId, String maCTV, java.util.Date ngay, int loaiPV)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getSumPhatVay_CTV_TAINGAY(
			chiNhanhId, maCTV, ngay, loaiPV);
	}

	public static Object[] getTongLichSuTraTien_CTV_TAINGAY(
			long chiNhanhId, String maCTV, java.util.Date ngay,
			java.util.Date ngayXuLy, int loaiPV)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getTongLichSuTraTien_CTV_TAINGAY(
			chiNhanhId, maCTV, ngay, ngayXuLy, loaiPV);
	}

	public static void removeByPhatVayId(long phatVayId)
		throws com.liferay.portal.kernel.exception.SystemException {

		getService().removeByPhatVayId(phatVayId);
	}

	public static void removeByPhatVayId_Loai(long phatVayId, int loai)
		throws com.liferay.portal.kernel.exception.SystemException {

		getService().removeByPhatVayId_Loai(phatVayId, loai);
	}

	/**
	 * Updates the lich su thu phat chi in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param lichSuThuPhatChi the lich su thu phat chi
	 * @return the lich su thu phat chi that was updated
	 */
	public static com.mb.model.LichSuThuPhatChi updateLichSuThuPhatChi(
		com.mb.model.LichSuThuPhatChi lichSuThuPhatChi) {

		return getService().updateLichSuThuPhatChi(lichSuThuPhatChi);
	}

	public static com.mb.model.LichSuThuPhatChi updateLichSuThuPhatChi(
			com.mb.model.LichSuThuPhatChi lichSuThuPhatChi,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().updateLichSuThuPhatChi(
			lichSuThuPhatChi, serviceContext);
	}

	public static LichSuThuPhatChiLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<LichSuThuPhatChiLocalService, LichSuThuPhatChiLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			LichSuThuPhatChiLocalService.class);

		ServiceTracker
			<LichSuThuPhatChiLocalService, LichSuThuPhatChiLocalService>
				serviceTracker =
					new ServiceTracker
						<LichSuThuPhatChiLocalService,
						 LichSuThuPhatChiLocalService>(
							 bundle.getBundleContext(),
							 LichSuThuPhatChiLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}