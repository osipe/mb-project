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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DsPhieuTaiKhoanLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DsPhieuTaiKhoanLocalService
 * @generated
 */
@ProviderType
public class DsPhieuTaiKhoanLocalServiceWrapper
	implements DsPhieuTaiKhoanLocalService,
			   ServiceWrapper<DsPhieuTaiKhoanLocalService> {

	public DsPhieuTaiKhoanLocalServiceWrapper(
		DsPhieuTaiKhoanLocalService dsPhieuTaiKhoanLocalService) {

		_dsPhieuTaiKhoanLocalService = dsPhieuTaiKhoanLocalService;
	}

	/**
	 * Adds the ds phieu tai khoan to the database. Also notifies the appropriate model listeners.
	 *
	 * @param dsPhieuTaiKhoan the ds phieu tai khoan
	 * @return the ds phieu tai khoan that was added
	 */
	@Override
	public com.mb.model.DsPhieuTaiKhoan addDsPhieuTaiKhoan(
		com.mb.model.DsPhieuTaiKhoan dsPhieuTaiKhoan) {

		return _dsPhieuTaiKhoanLocalService.addDsPhieuTaiKhoan(dsPhieuTaiKhoan);
	}

	@Override
	public com.mb.model.DsPhieuTaiKhoan addDsPhieuTaiKhoan(
			com.mb.model.DsPhieuTaiKhoan dsPhieuTaiKhoan,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.NoSuchUserException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _dsPhieuTaiKhoanLocalService.addDsPhieuTaiKhoan(
			dsPhieuTaiKhoan, serviceContext);
	}

	@Override
	public void addOrUpdateDsPhieuTaiKhoan(
			com.mb.model.Phieu phieu,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.NoSuchUserException,
			   com.liferay.portal.kernel.exception.SystemException {

		_dsPhieuTaiKhoanLocalService.addOrUpdateDsPhieuTaiKhoan(
			phieu, serviceContext);
	}

	/**
	 * Creates a new ds phieu tai khoan with the primary key. Does not add the ds phieu tai khoan to the database.
	 *
	 * @param dsPhieuTaiKhoanId the primary key for the new ds phieu tai khoan
	 * @return the new ds phieu tai khoan
	 */
	@Override
	public com.mb.model.DsPhieuTaiKhoan createDsPhieuTaiKhoan(
		long dsPhieuTaiKhoanId) {

		return _dsPhieuTaiKhoanLocalService.createDsPhieuTaiKhoan(
			dsPhieuTaiKhoanId);
	}

	/**
	 * Deletes the ds phieu tai khoan from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dsPhieuTaiKhoan the ds phieu tai khoan
	 * @return the ds phieu tai khoan that was removed
	 */
	@Override
	public com.mb.model.DsPhieuTaiKhoan deleteDsPhieuTaiKhoan(
		com.mb.model.DsPhieuTaiKhoan dsPhieuTaiKhoan) {

		return _dsPhieuTaiKhoanLocalService.deleteDsPhieuTaiKhoan(
			dsPhieuTaiKhoan);
	}

	/**
	 * Deletes the ds phieu tai khoan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dsPhieuTaiKhoanId the primary key of the ds phieu tai khoan
	 * @return the ds phieu tai khoan that was removed
	 * @throws PortalException if a ds phieu tai khoan with the primary key could not be found
	 */
	@Override
	public com.mb.model.DsPhieuTaiKhoan deleteDsPhieuTaiKhoan(
			long dsPhieuTaiKhoanId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dsPhieuTaiKhoanLocalService.deleteDsPhieuTaiKhoan(
			dsPhieuTaiKhoanId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dsPhieuTaiKhoanLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dsPhieuTaiKhoanLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _dsPhieuTaiKhoanLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.DsPhieuTaiKhoanModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _dsPhieuTaiKhoanLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.DsPhieuTaiKhoanModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _dsPhieuTaiKhoanLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _dsPhieuTaiKhoanLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _dsPhieuTaiKhoanLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mb.model.DsPhieuTaiKhoan fetchDsPhieuTaiKhoan(
		long dsPhieuTaiKhoanId) {

		return _dsPhieuTaiKhoanLocalService.fetchDsPhieuTaiKhoan(
			dsPhieuTaiKhoanId);
	}

	@Override
	public java.util.List<com.mb.model.DsPhieuTaiKhoan> findByPhieuId(
			long phieuId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _dsPhieuTaiKhoanLocalService.findByPhieuId(phieuId);
	}

	@Override
	public java.util.List<com.mb.model.DsPhieuTaiKhoan>
			findByTaiKhoanDoiUngId_HoatDong(
				long taiKhoanDoiUngId, boolean hoatDong)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _dsPhieuTaiKhoanLocalService.findByTaiKhoanDoiUngId_HoatDong(
			taiKhoanDoiUngId, hoatDong);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dsPhieuTaiKhoanLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the ds phieu tai khoan with the primary key.
	 *
	 * @param dsPhieuTaiKhoanId the primary key of the ds phieu tai khoan
	 * @return the ds phieu tai khoan
	 * @throws PortalException if a ds phieu tai khoan with the primary key could not be found
	 */
	@Override
	public com.mb.model.DsPhieuTaiKhoan getDsPhieuTaiKhoan(
			long dsPhieuTaiKhoanId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dsPhieuTaiKhoanLocalService.getDsPhieuTaiKhoan(
			dsPhieuTaiKhoanId);
	}

	/**
	 * Returns a range of all the ds phieu tai khoans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.DsPhieuTaiKhoanModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ds phieu tai khoans
	 * @param end the upper bound of the range of ds phieu tai khoans (not inclusive)
	 * @return the range of ds phieu tai khoans
	 */
	@Override
	public java.util.List<com.mb.model.DsPhieuTaiKhoan> getDsPhieuTaiKhoans(
		int start, int end) {

		return _dsPhieuTaiKhoanLocalService.getDsPhieuTaiKhoans(start, end);
	}

	/**
	 * Returns the number of ds phieu tai khoans.
	 *
	 * @return the number of ds phieu tai khoans
	 */
	@Override
	public int getDsPhieuTaiKhoansCount() {
		return _dsPhieuTaiKhoanLocalService.getDsPhieuTaiKhoansCount();
	}

	@Override
	public java.util.List<com.mb.model.DsPhieuTaiKhoan>
			getDSThuChiByTaiKhoanNgayChungTu(
				long taiKhoanDoiUngId, java.util.Date ngayChungTuTu,
				java.util.Date ngayChungTuDen, int hoatDong, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _dsPhieuTaiKhoanLocalService.getDSThuChiByTaiKhoanNgayChungTu(
			taiKhoanDoiUngId, ngayChungTuTu, ngayChungTuDen, hoatDong, start,
			end, obc);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dsPhieuTaiKhoanLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dsPhieuTaiKhoanLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dsPhieuTaiKhoanLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public void removeByPhieuId(long phieuId)
		throws com.liferay.portal.kernel.exception.SystemException {

		_dsPhieuTaiKhoanLocalService.removeByPhieuId(phieuId);
	}

	/**
	 * Updates the ds phieu tai khoan in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param dsPhieuTaiKhoan the ds phieu tai khoan
	 * @return the ds phieu tai khoan that was updated
	 */
	@Override
	public com.mb.model.DsPhieuTaiKhoan updateDsPhieuTaiKhoan(
		com.mb.model.DsPhieuTaiKhoan dsPhieuTaiKhoan) {

		return _dsPhieuTaiKhoanLocalService.updateDsPhieuTaiKhoan(
			dsPhieuTaiKhoan);
	}

	@Override
	public com.mb.model.DsPhieuTaiKhoan updateDsPhieuTaiKhoan(
			com.mb.model.DsPhieuTaiKhoan dsPhieuTaiKhoan,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _dsPhieuTaiKhoanLocalService.updateDsPhieuTaiKhoan(
			dsPhieuTaiKhoan, serviceContext);
	}

	@Override
	public DsPhieuTaiKhoanLocalService getWrappedService() {
		return _dsPhieuTaiKhoanLocalService;
	}

	@Override
	public void setWrappedService(
		DsPhieuTaiKhoanLocalService dsPhieuTaiKhoanLocalService) {

		_dsPhieuTaiKhoanLocalService = dsPhieuTaiKhoanLocalService;
	}

	private DsPhieuTaiKhoanLocalService _dsPhieuTaiKhoanLocalService;

}