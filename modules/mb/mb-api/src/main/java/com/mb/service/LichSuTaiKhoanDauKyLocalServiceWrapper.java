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
 * Provides a wrapper for {@link LichSuTaiKhoanDauKyLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LichSuTaiKhoanDauKyLocalService
 * @generated
 */
@ProviderType
public class LichSuTaiKhoanDauKyLocalServiceWrapper
	implements LichSuTaiKhoanDauKyLocalService,
			   ServiceWrapper<LichSuTaiKhoanDauKyLocalService> {

	public LichSuTaiKhoanDauKyLocalServiceWrapper(
		LichSuTaiKhoanDauKyLocalService lichSuTaiKhoanDauKyLocalService) {

		_lichSuTaiKhoanDauKyLocalService = lichSuTaiKhoanDauKyLocalService;
	}

	/**
	 * Adds the lich su tai khoan dau ky to the database. Also notifies the appropriate model listeners.
	 *
	 * @param lichSuTaiKhoanDauKy the lich su tai khoan dau ky
	 * @return the lich su tai khoan dau ky that was added
	 */
	@Override
	public com.mb.model.LichSuTaiKhoanDauKy addLichSuTaiKhoanDauKy(
		com.mb.model.LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy) {

		return _lichSuTaiKhoanDauKyLocalService.addLichSuTaiKhoanDauKy(
			lichSuTaiKhoanDauKy);
	}

	@Override
	public com.mb.model.LichSuTaiKhoanDauKy addLichSuTaiKhoanDauKy(
			com.mb.model.LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException,
			   com.mb.exception.TrungDuLieuDauKyException {

		return _lichSuTaiKhoanDauKyLocalService.addLichSuTaiKhoanDauKy(
			lichSuTaiKhoanDauKy, serviceContext);
	}

	@Override
	public com.mb.model.LichSuTaiKhoanDauKy addOrUpdateLichSuTaiKhoanDauKy(
			com.mb.model.LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _lichSuTaiKhoanDauKyLocalService.addOrUpdateLichSuTaiKhoanDauKy(
			lichSuTaiKhoanDauKy, serviceContext);
	}

	@Override
	public int countBase(int nam, int thang, long taiKhoanDoiUngId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _lichSuTaiKhoanDauKyLocalService.countBase(
			nam, thang, taiKhoanDoiUngId);
	}

	/**
	 * Creates a new lich su tai khoan dau ky with the primary key. Does not add the lich su tai khoan dau ky to the database.
	 *
	 * @param lichSuTaiKhoanDauKyId the primary key for the new lich su tai khoan dau ky
	 * @return the new lich su tai khoan dau ky
	 */
	@Override
	public com.mb.model.LichSuTaiKhoanDauKy createLichSuTaiKhoanDauKy(
		long lichSuTaiKhoanDauKyId) {

		return _lichSuTaiKhoanDauKyLocalService.createLichSuTaiKhoanDauKy(
			lichSuTaiKhoanDauKyId);
	}

	/**
	 * Deletes the lich su tai khoan dau ky from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lichSuTaiKhoanDauKy the lich su tai khoan dau ky
	 * @return the lich su tai khoan dau ky that was removed
	 */
	@Override
	public com.mb.model.LichSuTaiKhoanDauKy deleteLichSuTaiKhoanDauKy(
		com.mb.model.LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy) {

		return _lichSuTaiKhoanDauKyLocalService.deleteLichSuTaiKhoanDauKy(
			lichSuTaiKhoanDauKy);
	}

	/**
	 * Deletes the lich su tai khoan dau ky with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lichSuTaiKhoanDauKyId the primary key of the lich su tai khoan dau ky
	 * @return the lich su tai khoan dau ky that was removed
	 * @throws PortalException if a lich su tai khoan dau ky with the primary key could not be found
	 */
	@Override
	public com.mb.model.LichSuTaiKhoanDauKy deleteLichSuTaiKhoanDauKy(
			long lichSuTaiKhoanDauKyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lichSuTaiKhoanDauKyLocalService.deleteLichSuTaiKhoanDauKy(
			lichSuTaiKhoanDauKyId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lichSuTaiKhoanDauKyLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _lichSuTaiKhoanDauKyLocalService.dynamicQuery();
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

		return _lichSuTaiKhoanDauKyLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.LichSuTaiKhoanDauKyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _lichSuTaiKhoanDauKyLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.LichSuTaiKhoanDauKyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _lichSuTaiKhoanDauKyLocalService.dynamicQuery(
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

		return _lichSuTaiKhoanDauKyLocalService.dynamicQueryCount(dynamicQuery);
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

		return _lichSuTaiKhoanDauKyLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mb.model.LichSuTaiKhoanDauKy fetchByTaiKhoanDoiUngId_Nam_Thang(
			long taiKhoanDoiUngId, int nam, int thang)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _lichSuTaiKhoanDauKyLocalService.
			fetchByTaiKhoanDoiUngId_Nam_Thang(taiKhoanDoiUngId, nam, thang);
	}

	@Override
	public com.mb.model.LichSuTaiKhoanDauKy fetchLichSuTaiKhoanDauKy(
		long lichSuTaiKhoanDauKyId) {

		return _lichSuTaiKhoanDauKyLocalService.fetchLichSuTaiKhoanDauKy(
			lichSuTaiKhoanDauKyId);
	}

	@Override
	public java.util.List<com.mb.model.LichSuTaiKhoanDauKy> findBase(
			int nam, int thang, long taiKhoanDoiUngId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _lichSuTaiKhoanDauKyLocalService.findBase(
			nam, thang, taiKhoanDoiUngId, start, end, obc);
	}

	@Override
	public java.util.List<com.mb.model.LichSuTaiKhoanDauKy>
			findByTaiKhoanDoiUngId(long taiKhoanDoiUngId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _lichSuTaiKhoanDauKyLocalService.findByTaiKhoanDoiUngId(
			taiKhoanDoiUngId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _lichSuTaiKhoanDauKyLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _lichSuTaiKhoanDauKyLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the lich su tai khoan dau kies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.LichSuTaiKhoanDauKyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lich su tai khoan dau kies
	 * @param end the upper bound of the range of lich su tai khoan dau kies (not inclusive)
	 * @return the range of lich su tai khoan dau kies
	 */
	@Override
	public java.util.List<com.mb.model.LichSuTaiKhoanDauKy>
		getLichSuTaiKhoanDauKies(int start, int end) {

		return _lichSuTaiKhoanDauKyLocalService.getLichSuTaiKhoanDauKies(
			start, end);
	}

	/**
	 * Returns the number of lich su tai khoan dau kies.
	 *
	 * @return the number of lich su tai khoan dau kies
	 */
	@Override
	public int getLichSuTaiKhoanDauKiesCount() {
		return _lichSuTaiKhoanDauKyLocalService.getLichSuTaiKhoanDauKiesCount();
	}

	/**
	 * Returns the lich su tai khoan dau ky with the primary key.
	 *
	 * @param lichSuTaiKhoanDauKyId the primary key of the lich su tai khoan dau ky
	 * @return the lich su tai khoan dau ky
	 * @throws PortalException if a lich su tai khoan dau ky with the primary key could not be found
	 */
	@Override
	public com.mb.model.LichSuTaiKhoanDauKy getLichSuTaiKhoanDauKy(
			long lichSuTaiKhoanDauKyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lichSuTaiKhoanDauKyLocalService.getLichSuTaiKhoanDauKy(
			lichSuTaiKhoanDauKyId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _lichSuTaiKhoanDauKyLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lichSuTaiKhoanDauKyLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the lich su tai khoan dau ky in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param lichSuTaiKhoanDauKy the lich su tai khoan dau ky
	 * @return the lich su tai khoan dau ky that was updated
	 */
	@Override
	public com.mb.model.LichSuTaiKhoanDauKy updateLichSuTaiKhoanDauKy(
		com.mb.model.LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy) {

		return _lichSuTaiKhoanDauKyLocalService.updateLichSuTaiKhoanDauKy(
			lichSuTaiKhoanDauKy);
	}

	@Override
	public com.mb.model.LichSuTaiKhoanDauKy updateLichSuTaiKhoanDauKy(
			com.mb.model.LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException,
			   com.mb.exception.TrungDuLieuDauKyException {

		return _lichSuTaiKhoanDauKyLocalService.updateLichSuTaiKhoanDauKy(
			lichSuTaiKhoanDauKy, serviceContext);
	}

	@Override
	public LichSuTaiKhoanDauKyLocalService getWrappedService() {
		return _lichSuTaiKhoanDauKyLocalService;
	}

	@Override
	public void setWrappedService(
		LichSuTaiKhoanDauKyLocalService lichSuTaiKhoanDauKyLocalService) {

		_lichSuTaiKhoanDauKyLocalService = lichSuTaiKhoanDauKyLocalService;
	}

	private LichSuTaiKhoanDauKyLocalService _lichSuTaiKhoanDauKyLocalService;

}