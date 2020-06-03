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
 * Provides a wrapper for {@link TaiSanThueChapLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TaiSanThueChapLocalService
 * @generated
 */
@ProviderType
public class TaiSanThueChapLocalServiceWrapper
	implements TaiSanThueChapLocalService,
			   ServiceWrapper<TaiSanThueChapLocalService> {

	public TaiSanThueChapLocalServiceWrapper(
		TaiSanThueChapLocalService taiSanThueChapLocalService) {

		_taiSanThueChapLocalService = taiSanThueChapLocalService;
	}

	@Override
	public void addOrTaiSanThueChap(
			com.mb.model.PhatVay phatVay,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.NoSuchUserException,
			   com.liferay.portal.kernel.exception.SystemException {

		_taiSanThueChapLocalService.addOrTaiSanThueChap(
			phatVay, serviceContext);
	}

	/**
	 * Adds the tai san thue chap to the database. Also notifies the appropriate model listeners.
	 *
	 * @param taiSanThueChap the tai san thue chap
	 * @return the tai san thue chap that was added
	 */
	@Override
	public com.mb.model.TaiSanThueChap addTaiSanThueChap(
		com.mb.model.TaiSanThueChap taiSanThueChap) {

		return _taiSanThueChapLocalService.addTaiSanThueChap(taiSanThueChap);
	}

	@Override
	public com.mb.model.TaiSanThueChap addTaiSanThueChap(
			com.mb.model.TaiSanThueChap taiSanThueChap,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.NoSuchUserException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _taiSanThueChapLocalService.addTaiSanThueChap(
			taiSanThueChap, serviceContext);
	}

	@Override
	public int countBase(
			String soKU, String ten, String maKhachHang, long loaiTaiSanId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _taiSanThueChapLocalService.countBase(
			soKU, ten, maKhachHang, loaiTaiSanId);
	}

	/**
	 * Creates a new tai san thue chap with the primary key. Does not add the tai san thue chap to the database.
	 *
	 * @param taiSanThueChapId the primary key for the new tai san thue chap
	 * @return the new tai san thue chap
	 */
	@Override
	public com.mb.model.TaiSanThueChap createTaiSanThueChap(
		long taiSanThueChapId) {

		return _taiSanThueChapLocalService.createTaiSanThueChap(
			taiSanThueChapId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taiSanThueChapLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the tai san thue chap with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taiSanThueChapId the primary key of the tai san thue chap
	 * @return the tai san thue chap that was removed
	 * @throws PortalException if a tai san thue chap with the primary key could not be found
	 */
	@Override
	public com.mb.model.TaiSanThueChap deleteTaiSanThueChap(
			long taiSanThueChapId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taiSanThueChapLocalService.deleteTaiSanThueChap(
			taiSanThueChapId);
	}

	/**
	 * Deletes the tai san thue chap from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taiSanThueChap the tai san thue chap
	 * @return the tai san thue chap that was removed
	 */
	@Override
	public com.mb.model.TaiSanThueChap deleteTaiSanThueChap(
		com.mb.model.TaiSanThueChap taiSanThueChap) {

		return _taiSanThueChapLocalService.deleteTaiSanThueChap(taiSanThueChap);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _taiSanThueChapLocalService.dynamicQuery();
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

		return _taiSanThueChapLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.TaiSanThueChapModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _taiSanThueChapLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.TaiSanThueChapModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _taiSanThueChapLocalService.dynamicQuery(
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

		return _taiSanThueChapLocalService.dynamicQueryCount(dynamicQuery);
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

		return _taiSanThueChapLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mb.model.TaiSanThueChap fetchTaiSanThueChap(
		long taiSanThueChapId) {

		return _taiSanThueChapLocalService.fetchTaiSanThueChap(
			taiSanThueChapId);
	}

	@Override
	public java.util.List<com.mb.model.TaiSanThueChap> findBase(
			String soKU, String ten, String maKhachHang, long loaiTaiSanId,
			int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _taiSanThueChapLocalService.findBase(
			soKU, ten, maKhachHang, loaiTaiSanId, start, end, obc);
	}

	@Override
	public java.util.List<com.mb.model.TaiSanThueChap> findByPhatVayId(
			long phatVayId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _taiSanThueChapLocalService.findByPhatVayId(phatVayId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _taiSanThueChapLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _taiSanThueChapLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _taiSanThueChapLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taiSanThueChapLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the tai san thue chap with the primary key.
	 *
	 * @param taiSanThueChapId the primary key of the tai san thue chap
	 * @return the tai san thue chap
	 * @throws PortalException if a tai san thue chap with the primary key could not be found
	 */
	@Override
	public com.mb.model.TaiSanThueChap getTaiSanThueChap(long taiSanThueChapId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taiSanThueChapLocalService.getTaiSanThueChap(taiSanThueChapId);
	}

	/**
	 * Returns a range of all the tai san thue chaps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.TaiSanThueChapModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tai san thue chaps
	 * @param end the upper bound of the range of tai san thue chaps (not inclusive)
	 * @return the range of tai san thue chaps
	 */
	@Override
	public java.util.List<com.mb.model.TaiSanThueChap> getTaiSanThueChaps(
		int start, int end) {

		return _taiSanThueChapLocalService.getTaiSanThueChaps(start, end);
	}

	/**
	 * Returns the number of tai san thue chaps.
	 *
	 * @return the number of tai san thue chaps
	 */
	@Override
	public int getTaiSanThueChapsCount() {
		return _taiSanThueChapLocalService.getTaiSanThueChapsCount();
	}

	@Override
	public void removeByPhatVayId(long phatVayId)
		throws com.liferay.portal.kernel.exception.SystemException {

		_taiSanThueChapLocalService.removeByPhatVayId(phatVayId);
	}

	/**
	 * Updates the tai san thue chap in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param taiSanThueChap the tai san thue chap
	 * @return the tai san thue chap that was updated
	 */
	@Override
	public com.mb.model.TaiSanThueChap updateTaiSanThueChap(
		com.mb.model.TaiSanThueChap taiSanThueChap) {

		return _taiSanThueChapLocalService.updateTaiSanThueChap(taiSanThueChap);
	}

	@Override
	public com.mb.model.TaiSanThueChap updateTaiSanThueChap(
			com.mb.model.TaiSanThueChap taiSanThueChap,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _taiSanThueChapLocalService.updateTaiSanThueChap(
			taiSanThueChap, serviceContext);
	}

	@Override
	public TaiSanThueChapLocalService getWrappedService() {
		return _taiSanThueChapLocalService;
	}

	@Override
	public void setWrappedService(
		TaiSanThueChapLocalService taiSanThueChapLocalService) {

		_taiSanThueChapLocalService = taiSanThueChapLocalService;
	}

	private TaiSanThueChapLocalService _taiSanThueChapLocalService;

}