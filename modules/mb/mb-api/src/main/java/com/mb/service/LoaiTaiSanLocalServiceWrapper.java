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
 * Provides a wrapper for {@link LoaiTaiSanLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LoaiTaiSanLocalService
 * @generated
 */
@ProviderType
public class LoaiTaiSanLocalServiceWrapper
	implements LoaiTaiSanLocalService, ServiceWrapper<LoaiTaiSanLocalService> {

	public LoaiTaiSanLocalServiceWrapper(
		LoaiTaiSanLocalService loaiTaiSanLocalService) {

		_loaiTaiSanLocalService = loaiTaiSanLocalService;
	}

	/**
	 * Adds the loai tai san to the database. Also notifies the appropriate model listeners.
	 *
	 * @param loaiTaiSan the loai tai san
	 * @return the loai tai san that was added
	 */
	@Override
	public com.mb.model.LoaiTaiSan addLoaiTaiSan(
		com.mb.model.LoaiTaiSan loaiTaiSan) {

		return _loaiTaiSanLocalService.addLoaiTaiSan(loaiTaiSan);
	}

	@Override
	public com.mb.model.LoaiTaiSan addLoaiTaiSan(
			com.mb.model.LoaiTaiSan LoaiTaiSan,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException,
			   com.mb.exception.TrungMaException,
			   com.mb.exception.TrungSoCMNDException {

		return _loaiTaiSanLocalService.addLoaiTaiSan(
			LoaiTaiSan, serviceContext);
	}

	@Override
	public com.mb.model.LoaiTaiSan addOrUpdateLoaiTaiSan(
			com.mb.model.LoaiTaiSan LoaiTaiSan,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException,
			   com.mb.exception.TrungMaException,
			   com.mb.exception.TrungSoCMNDException {

		return _loaiTaiSanLocalService.addOrUpdateLoaiTaiSan(
			LoaiTaiSan, serviceContext);
	}

	@Override
	public int countBase(String ma, String ten, String ghiChu, int hoatDong)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _loaiTaiSanLocalService.countBase(ma, ten, ghiChu, hoatDong);
	}

	/**
	 * Creates a new loai tai san with the primary key. Does not add the loai tai san to the database.
	 *
	 * @param loaiTaiSanId the primary key for the new loai tai san
	 * @return the new loai tai san
	 */
	@Override
	public com.mb.model.LoaiTaiSan createLoaiTaiSan(long loaiTaiSanId) {
		return _loaiTaiSanLocalService.createLoaiTaiSan(loaiTaiSanId);
	}

	/**
	 * Deletes the loai tai san from the database. Also notifies the appropriate model listeners.
	 *
	 * @param loaiTaiSan the loai tai san
	 * @return the loai tai san that was removed
	 */
	@Override
	public com.mb.model.LoaiTaiSan deleteLoaiTaiSan(
		com.mb.model.LoaiTaiSan loaiTaiSan) {

		return _loaiTaiSanLocalService.deleteLoaiTaiSan(loaiTaiSan);
	}

	/**
	 * Deletes the loai tai san with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param loaiTaiSanId the primary key of the loai tai san
	 * @return the loai tai san that was removed
	 * @throws PortalException if a loai tai san with the primary key could not be found
	 */
	@Override
	public com.mb.model.LoaiTaiSan deleteLoaiTaiSan(long loaiTaiSanId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _loaiTaiSanLocalService.deleteLoaiTaiSan(loaiTaiSanId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _loaiTaiSanLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _loaiTaiSanLocalService.dynamicQuery();
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

		return _loaiTaiSanLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _loaiTaiSanLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _loaiTaiSanLocalService.dynamicQuery(
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

		return _loaiTaiSanLocalService.dynamicQueryCount(dynamicQuery);
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

		return _loaiTaiSanLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mb.model.LoaiTaiSan fetchByMa(String ma)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _loaiTaiSanLocalService.fetchByMa(ma);
	}

	@Override
	public com.mb.model.LoaiTaiSan fetchLoaiTaiSan(long loaiTaiSanId) {
		return _loaiTaiSanLocalService.fetchLoaiTaiSan(loaiTaiSanId);
	}

	@Override
	public java.util.List<com.mb.model.LoaiTaiSan> findBase(
			String ma, String ten, String ghiChu, int hoatDong, int start,
			int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _loaiTaiSanLocalService.findBase(
			ma, ten, ghiChu, hoatDong, start, end, obc);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _loaiTaiSanLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _loaiTaiSanLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the loai tai san with the primary key.
	 *
	 * @param loaiTaiSanId the primary key of the loai tai san
	 * @return the loai tai san
	 * @throws PortalException if a loai tai san with the primary key could not be found
	 */
	@Override
	public com.mb.model.LoaiTaiSan getLoaiTaiSan(long loaiTaiSanId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _loaiTaiSanLocalService.getLoaiTaiSan(loaiTaiSanId);
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
	@Override
	public java.util.List<com.mb.model.LoaiTaiSan> getLoaiTaiSans(
		int start, int end) {

		return _loaiTaiSanLocalService.getLoaiTaiSans(start, end);
	}

	/**
	 * Returns the number of loai tai sans.
	 *
	 * @return the number of loai tai sans
	 */
	@Override
	public int getLoaiTaiSansCount() {
		return _loaiTaiSanLocalService.getLoaiTaiSansCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _loaiTaiSanLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _loaiTaiSanLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the loai tai san in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param loaiTaiSan the loai tai san
	 * @return the loai tai san that was updated
	 */
	@Override
	public com.mb.model.LoaiTaiSan updateLoaiTaiSan(
		com.mb.model.LoaiTaiSan loaiTaiSan) {

		return _loaiTaiSanLocalService.updateLoaiTaiSan(loaiTaiSan);
	}

	@Override
	public com.mb.model.LoaiTaiSan updateLoaiTaiSan(
			com.mb.model.LoaiTaiSan LoaiTaiSan,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException,
			   com.mb.exception.TrungMaException,
			   com.mb.exception.TrungSoCMNDException {

		return _loaiTaiSanLocalService.updateLoaiTaiSan(
			LoaiTaiSan, serviceContext);
	}

	@Override
	public LoaiTaiSanLocalService getWrappedService() {
		return _loaiTaiSanLocalService;
	}

	@Override
	public void setWrappedService(
		LoaiTaiSanLocalService loaiTaiSanLocalService) {

		_loaiTaiSanLocalService = loaiTaiSanLocalService;
	}

	private LoaiTaiSanLocalService _loaiTaiSanLocalService;

}