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
 * Provides a wrapper for {@link SoKheUocLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SoKheUocLocalService
 * @generated
 */
@ProviderType
public class SoKheUocLocalServiceWrapper
	implements SoKheUocLocalService, ServiceWrapper<SoKheUocLocalService> {

	public SoKheUocLocalServiceWrapper(
		SoKheUocLocalService soKheUocLocalService) {

		_soKheUocLocalService = soKheUocLocalService;
	}

	/**
	 * Adds the so khe uoc to the database. Also notifies the appropriate model listeners.
	 *
	 * @param soKheUoc the so khe uoc
	 * @return the so khe uoc that was added
	 */
	@Override
	public com.mb.model.SoKheUoc addSoKheUoc(com.mb.model.SoKheUoc soKheUoc) {
		return _soKheUocLocalService.addSoKheUoc(soKheUoc);
	}

	@Override
	public com.mb.model.SoKheUoc addSoKheUoc(
			com.mb.model.SoKheUoc soKheUoc,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _soKheUocLocalService.addSoKheUoc(soKheUoc, serviceContext);
	}

	@Override
	public int countBase(String cauTruc)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _soKheUocLocalService.countBase(cauTruc);
	}

	/**
	 * Creates a new so khe uoc with the primary key. Does not add the so khe uoc to the database.
	 *
	 * @param soKheUocId the primary key for the new so khe uoc
	 * @return the new so khe uoc
	 */
	@Override
	public com.mb.model.SoKheUoc createSoKheUoc(long soKheUocId) {
		return _soKheUocLocalService.createSoKheUoc(soKheUocId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _soKheUocLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the so khe uoc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param soKheUocId the primary key of the so khe uoc
	 * @return the so khe uoc that was removed
	 * @throws PortalException if a so khe uoc with the primary key could not be found
	 */
	@Override
	public com.mb.model.SoKheUoc deleteSoKheUoc(long soKheUocId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _soKheUocLocalService.deleteSoKheUoc(soKheUocId);
	}

	/**
	 * Deletes the so khe uoc from the database. Also notifies the appropriate model listeners.
	 *
	 * @param soKheUoc the so khe uoc
	 * @return the so khe uoc that was removed
	 */
	@Override
	public com.mb.model.SoKheUoc deleteSoKheUoc(
		com.mb.model.SoKheUoc soKheUoc) {

		return _soKheUocLocalService.deleteSoKheUoc(soKheUoc);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _soKheUocLocalService.dynamicQuery();
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

		return _soKheUocLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.SoKheUocModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _soKheUocLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.SoKheUocModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _soKheUocLocalService.dynamicQuery(
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

		return _soKheUocLocalService.dynamicQueryCount(dynamicQuery);
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

		return _soKheUocLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mb.model.SoKheUoc fetchByCauTruc(String cauTruc)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _soKheUocLocalService.fetchByCauTruc(cauTruc);
	}

	@Override
	public com.mb.model.SoKheUoc fetchSoKheUoc(long soKheUocId) {
		return _soKheUocLocalService.fetchSoKheUoc(soKheUocId);
	}

	@Override
	public java.util.List<com.mb.model.SoKheUoc> findBase(
			String cauTruc, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _soKheUocLocalService.findBase(cauTruc, start, end, obc);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _soKheUocLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _soKheUocLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _soKheUocLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _soKheUocLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the so khe uoc with the primary key.
	 *
	 * @param soKheUocId the primary key of the so khe uoc
	 * @return the so khe uoc
	 * @throws PortalException if a so khe uoc with the primary key could not be found
	 */
	@Override
	public com.mb.model.SoKheUoc getSoKheUoc(long soKheUocId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _soKheUocLocalService.getSoKheUoc(soKheUocId);
	}

	/**
	 * Returns a range of all the so khe uocs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.SoKheUocModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of so khe uocs
	 * @param end the upper bound of the range of so khe uocs (not inclusive)
	 * @return the range of so khe uocs
	 */
	@Override
	public java.util.List<com.mb.model.SoKheUoc> getSoKheUocs(
		int start, int end) {

		return _soKheUocLocalService.getSoKheUocs(start, end);
	}

	/**
	 * Returns the number of so khe uocs.
	 *
	 * @return the number of so khe uocs
	 */
	@Override
	public int getSoKheUocsCount() {
		return _soKheUocLocalService.getSoKheUocsCount();
	}

	@Override
	public com.mb.model.SoKheUoc tangSoKheUoc(
			String cauTruc,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _soKheUocLocalService.tangSoKheUoc(cauTruc, serviceContext);
	}

	/**
	 * Updates the so khe uoc in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param soKheUoc the so khe uoc
	 * @return the so khe uoc that was updated
	 */
	@Override
	public com.mb.model.SoKheUoc updateSoKheUoc(
		com.mb.model.SoKheUoc soKheUoc) {

		return _soKheUocLocalService.updateSoKheUoc(soKheUoc);
	}

	@Override
	public com.mb.model.SoKheUoc updateSoKheUoc(
			com.mb.model.SoKheUoc soKheUoc,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _soKheUocLocalService.updateSoKheUoc(soKheUoc, serviceContext);
	}

	@Override
	public SoKheUocLocalService getWrappedService() {
		return _soKheUocLocalService;
	}

	@Override
	public void setWrappedService(SoKheUocLocalService soKheUocLocalService) {
		_soKheUocLocalService = soKheUocLocalService;
	}

	private SoKheUocLocalService _soKheUocLocalService;

}