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
 * Provides a wrapper for {@link TaiKhoanDoiUngLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TaiKhoanDoiUngLocalService
 * @generated
 */
@ProviderType
public class TaiKhoanDoiUngLocalServiceWrapper
	implements TaiKhoanDoiUngLocalService,
			   ServiceWrapper<TaiKhoanDoiUngLocalService> {

	public TaiKhoanDoiUngLocalServiceWrapper(
		TaiKhoanDoiUngLocalService taiKhoanDoiUngLocalService) {

		_taiKhoanDoiUngLocalService = taiKhoanDoiUngLocalService;
	}

	@Override
	public com.mb.model.TaiKhoanDoiUng addOrUpdateCongTacVien(
			com.mb.model.TaiKhoanDoiUng taiKhoanDoiUng,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException,
			   com.mb.exception.TrungSoHieuException {

		return _taiKhoanDoiUngLocalService.addOrUpdateCongTacVien(
			taiKhoanDoiUng, serviceContext);
	}

	/**
	 * Adds the tai khoan doi ung to the database. Also notifies the appropriate model listeners.
	 *
	 * @param taiKhoanDoiUng the tai khoan doi ung
	 * @return the tai khoan doi ung that was added
	 */
	@Override
	public com.mb.model.TaiKhoanDoiUng addTaiKhoanDoiUng(
		com.mb.model.TaiKhoanDoiUng taiKhoanDoiUng) {

		return _taiKhoanDoiUngLocalService.addTaiKhoanDoiUng(taiKhoanDoiUng);
	}

	@Override
	public com.mb.model.TaiKhoanDoiUng addTaiKhoanDoiUng(
			com.mb.model.TaiKhoanDoiUng taiKhoanDoiUng,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException,
			   com.mb.exception.TrungSoHieuException {

		return _taiKhoanDoiUngLocalService.addTaiKhoanDoiUng(
			taiKhoanDoiUng, serviceContext);
	}

	@Override
	public int countBase(
			long taiKhoanDoiUngChaId, String soHieu, String ten, int hoatDong)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _taiKhoanDoiUngLocalService.countBase(
			taiKhoanDoiUngChaId, soHieu, ten, hoatDong);
	}

	/**
	 * Creates a new tai khoan doi ung with the primary key. Does not add the tai khoan doi ung to the database.
	 *
	 * @param taiKhoanDoiUngId the primary key for the new tai khoan doi ung
	 * @return the new tai khoan doi ung
	 */
	@Override
	public com.mb.model.TaiKhoanDoiUng createTaiKhoanDoiUng(
		long taiKhoanDoiUngId) {

		return _taiKhoanDoiUngLocalService.createTaiKhoanDoiUng(
			taiKhoanDoiUngId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taiKhoanDoiUngLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the tai khoan doi ung with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taiKhoanDoiUngId the primary key of the tai khoan doi ung
	 * @return the tai khoan doi ung that was removed
	 * @throws PortalException if a tai khoan doi ung with the primary key could not be found
	 */
	@Override
	public com.mb.model.TaiKhoanDoiUng deleteTaiKhoanDoiUng(
			long taiKhoanDoiUngId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taiKhoanDoiUngLocalService.deleteTaiKhoanDoiUng(
			taiKhoanDoiUngId);
	}

	/**
	 * Deletes the tai khoan doi ung from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taiKhoanDoiUng the tai khoan doi ung
	 * @return the tai khoan doi ung that was removed
	 */
	@Override
	public com.mb.model.TaiKhoanDoiUng deleteTaiKhoanDoiUng(
		com.mb.model.TaiKhoanDoiUng taiKhoanDoiUng) {

		return _taiKhoanDoiUngLocalService.deleteTaiKhoanDoiUng(taiKhoanDoiUng);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _taiKhoanDoiUngLocalService.dynamicQuery();
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

		return _taiKhoanDoiUngLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.TaiKhoanDoiUngModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _taiKhoanDoiUngLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.TaiKhoanDoiUngModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _taiKhoanDoiUngLocalService.dynamicQuery(
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

		return _taiKhoanDoiUngLocalService.dynamicQueryCount(dynamicQuery);
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

		return _taiKhoanDoiUngLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mb.model.TaiKhoanDoiUng fetchBySoHieu(String soHieu)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _taiKhoanDoiUngLocalService.fetchBySoHieu(soHieu);
	}

	@Override
	public com.mb.model.TaiKhoanDoiUng fetchTaiKhoanDoiUng(
		long taiKhoanDoiUngId) {

		return _taiKhoanDoiUngLocalService.fetchTaiKhoanDoiUng(
			taiKhoanDoiUngId);
	}

	@Override
	public java.util.List<com.mb.model.TaiKhoanDoiUng> findBase(
			long taiKhoanDoiUngChaId, String soHieu, String ten, int hoatDong,
			int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _taiKhoanDoiUngLocalService.findBase(
			taiKhoanDoiUngChaId, soHieu, ten, hoatDong, start, end, obc);
	}

	@Override
	public java.util.List<com.mb.model.TaiKhoanDoiUng>
			findByLoaiTaiKhoan_HoatDong(int loaiTaiKhoan, boolean hoatDong)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _taiKhoanDoiUngLocalService.findByLoaiTaiKhoan_HoatDong(
			loaiTaiKhoan, hoatDong);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _taiKhoanDoiUngLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _taiKhoanDoiUngLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _taiKhoanDoiUngLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taiKhoanDoiUngLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the tai khoan doi ung with the primary key.
	 *
	 * @param taiKhoanDoiUngId the primary key of the tai khoan doi ung
	 * @return the tai khoan doi ung
	 * @throws PortalException if a tai khoan doi ung with the primary key could not be found
	 */
	@Override
	public com.mb.model.TaiKhoanDoiUng getTaiKhoanDoiUng(long taiKhoanDoiUngId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taiKhoanDoiUngLocalService.getTaiKhoanDoiUng(taiKhoanDoiUngId);
	}

	/**
	 * Returns a range of all the tai khoan doi ungs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.TaiKhoanDoiUngModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tai khoan doi ungs
	 * @param end the upper bound of the range of tai khoan doi ungs (not inclusive)
	 * @return the range of tai khoan doi ungs
	 */
	@Override
	public java.util.List<com.mb.model.TaiKhoanDoiUng> getTaiKhoanDoiUngs(
		int start, int end) {

		return _taiKhoanDoiUngLocalService.getTaiKhoanDoiUngs(start, end);
	}

	/**
	 * Returns the number of tai khoan doi ungs.
	 *
	 * @return the number of tai khoan doi ungs
	 */
	@Override
	public int getTaiKhoanDoiUngsCount() {
		return _taiKhoanDoiUngLocalService.getTaiKhoanDoiUngsCount();
	}

	/**
	 * Updates the tai khoan doi ung in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param taiKhoanDoiUng the tai khoan doi ung
	 * @return the tai khoan doi ung that was updated
	 */
	@Override
	public com.mb.model.TaiKhoanDoiUng updateTaiKhoanDoiUng(
		com.mb.model.TaiKhoanDoiUng taiKhoanDoiUng) {

		return _taiKhoanDoiUngLocalService.updateTaiKhoanDoiUng(taiKhoanDoiUng);
	}

	@Override
	public com.mb.model.TaiKhoanDoiUng updateTaiKhoanDoiUng(
			com.mb.model.TaiKhoanDoiUng taiKhoanDoiUng,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException,
			   com.mb.exception.TrungSoHieuException {

		return _taiKhoanDoiUngLocalService.updateTaiKhoanDoiUng(
			taiKhoanDoiUng, serviceContext);
	}

	@Override
	public TaiKhoanDoiUngLocalService getWrappedService() {
		return _taiKhoanDoiUngLocalService;
	}

	@Override
	public void setWrappedService(
		TaiKhoanDoiUngLocalService taiKhoanDoiUngLocalService) {

		_taiKhoanDoiUngLocalService = taiKhoanDoiUngLocalService;
	}

	private TaiKhoanDoiUngLocalService _taiKhoanDoiUngLocalService;

}