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
 * Provides a wrapper for {@link LaiSuatLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LaiSuatLocalService
 * @generated
 */
@ProviderType
public class LaiSuatLocalServiceWrapper
	implements LaiSuatLocalService, ServiceWrapper<LaiSuatLocalService> {

	public LaiSuatLocalServiceWrapper(LaiSuatLocalService laiSuatLocalService) {
		_laiSuatLocalService = laiSuatLocalService;
	}

	/**
	 * Adds the lai suat to the database. Also notifies the appropriate model listeners.
	 *
	 * @param laiSuat the lai suat
	 * @return the lai suat that was added
	 */
	@Override
	public com.mb.model.LaiSuat addLaiSuat(com.mb.model.LaiSuat laiSuat) {
		return _laiSuatLocalService.addLaiSuat(laiSuat);
	}

	@Override
	public com.mb.model.LaiSuat addLaiSuat(
			com.mb.model.LaiSuat LaiSuat,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException,
			   com.mb.exception.TrungLaiSuatException {

		return _laiSuatLocalService.addLaiSuat(LaiSuat, serviceContext);
	}

	@Override
	public com.mb.model.LaiSuat addOrUpdateLaiSuat(
			com.mb.model.LaiSuat LaiSuat,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException,
			   com.mb.exception.TrungMaException,
			   com.mb.exception.TrungSoCMNDException {

		return _laiSuatLocalService.addOrUpdateLaiSuat(LaiSuat, serviceContext);
	}

	@Override
	public int countBase(
			Double soTienVay, Double laiSuat, int thoiHan, int hoatDong)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _laiSuatLocalService.countBase(
			soTienVay, laiSuat, thoiHan, hoatDong);
	}

	/**
	 * Creates a new lai suat with the primary key. Does not add the lai suat to the database.
	 *
	 * @param laiSuatId the primary key for the new lai suat
	 * @return the new lai suat
	 */
	@Override
	public com.mb.model.LaiSuat createLaiSuat(long laiSuatId) {
		return _laiSuatLocalService.createLaiSuat(laiSuatId);
	}

	/**
	 * Deletes the lai suat from the database. Also notifies the appropriate model listeners.
	 *
	 * @param laiSuat the lai suat
	 * @return the lai suat that was removed
	 */
	@Override
	public com.mb.model.LaiSuat deleteLaiSuat(com.mb.model.LaiSuat laiSuat) {
		return _laiSuatLocalService.deleteLaiSuat(laiSuat);
	}

	/**
	 * Deletes the lai suat with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param laiSuatId the primary key of the lai suat
	 * @return the lai suat that was removed
	 * @throws PortalException if a lai suat with the primary key could not be found
	 */
	@Override
	public com.mb.model.LaiSuat deleteLaiSuat(long laiSuatId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _laiSuatLocalService.deleteLaiSuat(laiSuatId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _laiSuatLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _laiSuatLocalService.dynamicQuery();
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

		return _laiSuatLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.LaiSuatModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _laiSuatLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.LaiSuatModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _laiSuatLocalService.dynamicQuery(
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

		return _laiSuatLocalService.dynamicQueryCount(dynamicQuery);
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

		return _laiSuatLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.mb.model.LaiSuat fetchBySoTienVay_ThoiHan(
			Double soTienVay, int thoiHan)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _laiSuatLocalService.fetchBySoTienVay_ThoiHan(
			soTienVay, thoiHan);
	}

	@Override
	public com.mb.model.LaiSuat fetchLaiSuat(long laiSuatId) {
		return _laiSuatLocalService.fetchLaiSuat(laiSuatId);
	}

	@Override
	public java.util.List<com.mb.model.LaiSuat> findBase(
			Double soTienVay, Double laiSuat, int thoiHan, int hoatDong,
			int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _laiSuatLocalService.findBase(
			soTienVay, laiSuat, thoiHan, hoatDong, start, end, obc);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _laiSuatLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _laiSuatLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the lai suat with the primary key.
	 *
	 * @param laiSuatId the primary key of the lai suat
	 * @return the lai suat
	 * @throws PortalException if a lai suat with the primary key could not be found
	 */
	@Override
	public com.mb.model.LaiSuat getLaiSuat(long laiSuatId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _laiSuatLocalService.getLaiSuat(laiSuatId);
	}

	/**
	 * Returns a range of all the lai suats.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.LaiSuatModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lai suats
	 * @param end the upper bound of the range of lai suats (not inclusive)
	 * @return the range of lai suats
	 */
	@Override
	public java.util.List<com.mb.model.LaiSuat> getLaiSuats(
		int start, int end) {

		return _laiSuatLocalService.getLaiSuats(start, end);
	}

	/**
	 * Returns the number of lai suats.
	 *
	 * @return the number of lai suats
	 */
	@Override
	public int getLaiSuatsCount() {
		return _laiSuatLocalService.getLaiSuatsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _laiSuatLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _laiSuatLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the lai suat in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param laiSuat the lai suat
	 * @return the lai suat that was updated
	 */
	@Override
	public com.mb.model.LaiSuat updateLaiSuat(com.mb.model.LaiSuat laiSuat) {
		return _laiSuatLocalService.updateLaiSuat(laiSuat);
	}

	@Override
	public com.mb.model.LaiSuat updateLaiSuat(
			com.mb.model.LaiSuat LaiSuat,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException,
			   com.mb.exception.TrungLaiSuatException {

		return _laiSuatLocalService.updateLaiSuat(LaiSuat, serviceContext);
	}

	@Override
	public LaiSuatLocalService getWrappedService() {
		return _laiSuatLocalService;
	}

	@Override
	public void setWrappedService(LaiSuatLocalService laiSuatLocalService) {
		_laiSuatLocalService = laiSuatLocalService;
	}

	private LaiSuatLocalService _laiSuatLocalService;

}