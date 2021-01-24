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
 * Provides a wrapper for {@link ChiNhanhLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ChiNhanhLocalService
 * @generated
 */
@ProviderType
public class ChiNhanhLocalServiceWrapper
	implements ChiNhanhLocalService, ServiceWrapper<ChiNhanhLocalService> {

	public ChiNhanhLocalServiceWrapper(
		ChiNhanhLocalService chiNhanhLocalService) {

		_chiNhanhLocalService = chiNhanhLocalService;
	}

	/**
	 * Adds the chi nhanh to the database. Also notifies the appropriate model listeners.
	 *
	 * @param chiNhanh the chi nhanh
	 * @return the chi nhanh that was added
	 */
	@Override
	public com.mb.model.ChiNhanh addChiNhanh(com.mb.model.ChiNhanh chiNhanh) {
		return _chiNhanhLocalService.addChiNhanh(chiNhanh);
	}

	@Override
	public com.mb.model.ChiNhanh addChiNhanh(
			com.mb.model.ChiNhanh chiNhanh,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException,
			   com.mb.exception.TrungMaException,
			   com.mb.exception.TrungSoCMNDException {

		return _chiNhanhLocalService.addChiNhanh(chiNhanh, serviceContext);
	}

	@Override
	public com.mb.model.ChiNhanh addOrUpdateChiNhanh(
			com.mb.model.ChiNhanh chiNhanh,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException,
			   com.mb.exception.TrungMaException,
			   com.mb.exception.TrungSoCMNDException {

		return _chiNhanhLocalService.addOrUpdateChiNhanh(
			chiNhanh, serviceContext);
	}

	@Override
	public int countBase(String ma, String ten, int hoatDong)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _chiNhanhLocalService.countBase(ma, ten, hoatDong);
	}

	/**
	 * Creates a new chi nhanh with the primary key. Does not add the chi nhanh to the database.
	 *
	 * @param chiNhanhId the primary key for the new chi nhanh
	 * @return the new chi nhanh
	 */
	@Override
	public com.mb.model.ChiNhanh createChiNhanh(long chiNhanhId) {
		return _chiNhanhLocalService.createChiNhanh(chiNhanhId);
	}

	/**
	 * Deletes the chi nhanh from the database. Also notifies the appropriate model listeners.
	 *
	 * @param chiNhanh the chi nhanh
	 * @return the chi nhanh that was removed
	 */
	@Override
	public com.mb.model.ChiNhanh deleteChiNhanh(
		com.mb.model.ChiNhanh chiNhanh) {

		return _chiNhanhLocalService.deleteChiNhanh(chiNhanh);
	}

	/**
	 * Deletes the chi nhanh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param chiNhanhId the primary key of the chi nhanh
	 * @return the chi nhanh that was removed
	 * @throws PortalException if a chi nhanh with the primary key could not be found
	 */
	@Override
	public com.mb.model.ChiNhanh deleteChiNhanh(long chiNhanhId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _chiNhanhLocalService.deleteChiNhanh(chiNhanhId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _chiNhanhLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _chiNhanhLocalService.dynamicQuery();
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

		return _chiNhanhLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.ChiNhanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _chiNhanhLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.ChiNhanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _chiNhanhLocalService.dynamicQuery(
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

		return _chiNhanhLocalService.dynamicQueryCount(dynamicQuery);
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

		return _chiNhanhLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mb.model.ChiNhanh fetchByMa(String ma)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _chiNhanhLocalService.fetchByMa(ma);
	}

	@Override
	public com.mb.model.ChiNhanh fetchChiNhanh(long chiNhanhId) {
		return _chiNhanhLocalService.fetchChiNhanh(chiNhanhId);
	}

	@Override
	public java.util.List<com.mb.model.ChiNhanh> findBase(
			String ma, String ten, int hoatDong, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _chiNhanhLocalService.findBase(
			ma, ten, hoatDong, start, end, obc);
	}

	@Override
	public java.util.List<com.mb.model.ChiNhanh> findByHoatDong(
			boolean hoatDong)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _chiNhanhLocalService.findByHoatDong(hoatDong);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _chiNhanhLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the chi nhanh with the primary key.
	 *
	 * @param chiNhanhId the primary key of the chi nhanh
	 * @return the chi nhanh
	 * @throws PortalException if a chi nhanh with the primary key could not be found
	 */
	@Override
	public com.mb.model.ChiNhanh getChiNhanh(long chiNhanhId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _chiNhanhLocalService.getChiNhanh(chiNhanhId);
	}

	/**
	 * Returns a range of all the chi nhanhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.ChiNhanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of chi nhanhs
	 * @param end the upper bound of the range of chi nhanhs (not inclusive)
	 * @return the range of chi nhanhs
	 */
	@Override
	public java.util.List<com.mb.model.ChiNhanh> getChiNhanhs(
		int start, int end) {

		return _chiNhanhLocalService.getChiNhanhs(start, end);
	}

	/**
	 * Returns the number of chi nhanhs.
	 *
	 * @return the number of chi nhanhs
	 */
	@Override
	public int getChiNhanhsCount() {
		return _chiNhanhLocalService.getChiNhanhsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _chiNhanhLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _chiNhanhLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _chiNhanhLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the chi nhanh in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param chiNhanh the chi nhanh
	 * @return the chi nhanh that was updated
	 */
	@Override
	public com.mb.model.ChiNhanh updateChiNhanh(
		com.mb.model.ChiNhanh chiNhanh) {

		return _chiNhanhLocalService.updateChiNhanh(chiNhanh);
	}

	@Override
	public com.mb.model.ChiNhanh updateChiNhanh(
			com.mb.model.ChiNhanh chiNhanh,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException,
			   com.mb.exception.TrungMaException,
			   com.mb.exception.TrungSoCMNDException {

		return _chiNhanhLocalService.updateChiNhanh(chiNhanh, serviceContext);
	}

	@Override
	public ChiNhanhLocalService getWrappedService() {
		return _chiNhanhLocalService;
	}

	@Override
	public void setWrappedService(ChiNhanhLocalService chiNhanhLocalService) {
		_chiNhanhLocalService = chiNhanhLocalService;
	}

	private ChiNhanhLocalService _chiNhanhLocalService;

}