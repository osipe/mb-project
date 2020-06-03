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
 * Provides a wrapper for {@link QuanLyMaSoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see QuanLyMaSoLocalService
 * @generated
 */
@ProviderType
public class QuanLyMaSoLocalServiceWrapper
	implements QuanLyMaSoLocalService, ServiceWrapper<QuanLyMaSoLocalService> {

	public QuanLyMaSoLocalServiceWrapper(
		QuanLyMaSoLocalService quanLyMaSoLocalService) {

		_quanLyMaSoLocalService = quanLyMaSoLocalService;
	}

	/**
	 * Adds the quan ly ma so to the database. Also notifies the appropriate model listeners.
	 *
	 * @param quanLyMaSo the quan ly ma so
	 * @return the quan ly ma so that was added
	 */
	@Override
	public com.mb.model.QuanLyMaSo addQuanLyMaSo(
		com.mb.model.QuanLyMaSo quanLyMaSo) {

		return _quanLyMaSoLocalService.addQuanLyMaSo(quanLyMaSo);
	}

	@Override
	public com.mb.model.QuanLyMaSo addQuanLyMaSo(
			com.mb.model.QuanLyMaSo quanLyMaSo,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _quanLyMaSoLocalService.addQuanLyMaSo(
			quanLyMaSo, serviceContext);
	}

	/**
	 * Creates a new quan ly ma so with the primary key. Does not add the quan ly ma so to the database.
	 *
	 * @param quanLyMaSoId the primary key for the new quan ly ma so
	 * @return the new quan ly ma so
	 */
	@Override
	public com.mb.model.QuanLyMaSo createQuanLyMaSo(long quanLyMaSoId) {
		return _quanLyMaSoLocalService.createQuanLyMaSo(quanLyMaSoId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quanLyMaSoLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the quan ly ma so with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param quanLyMaSoId the primary key of the quan ly ma so
	 * @return the quan ly ma so that was removed
	 * @throws PortalException if a quan ly ma so with the primary key could not be found
	 */
	@Override
	public com.mb.model.QuanLyMaSo deleteQuanLyMaSo(long quanLyMaSoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quanLyMaSoLocalService.deleteQuanLyMaSo(quanLyMaSoId);
	}

	/**
	 * Deletes the quan ly ma so from the database. Also notifies the appropriate model listeners.
	 *
	 * @param quanLyMaSo the quan ly ma so
	 * @return the quan ly ma so that was removed
	 */
	@Override
	public com.mb.model.QuanLyMaSo deleteQuanLyMaSo(
		com.mb.model.QuanLyMaSo quanLyMaSo) {

		return _quanLyMaSoLocalService.deleteQuanLyMaSo(quanLyMaSo);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _quanLyMaSoLocalService.dynamicQuery();
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

		return _quanLyMaSoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.QuanLyMaSoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _quanLyMaSoLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.QuanLyMaSoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _quanLyMaSoLocalService.dynamicQuery(
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

		return _quanLyMaSoLocalService.dynamicQueryCount(dynamicQuery);
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

		return _quanLyMaSoLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mb.model.QuanLyMaSo fetchByKey(String key)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _quanLyMaSoLocalService.fetchByKey(key);
	}

	@Override
	public com.mb.model.QuanLyMaSo fetchQuanLyMaSo(long quanLyMaSoId) {
		return _quanLyMaSoLocalService.fetchQuanLyMaSo(quanLyMaSoId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _quanLyMaSoLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _quanLyMaSoLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _quanLyMaSoLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quanLyMaSoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the quan ly ma so with the primary key.
	 *
	 * @param quanLyMaSoId the primary key of the quan ly ma so
	 * @return the quan ly ma so
	 * @throws PortalException if a quan ly ma so with the primary key could not be found
	 */
	@Override
	public com.mb.model.QuanLyMaSo getQuanLyMaSo(long quanLyMaSoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quanLyMaSoLocalService.getQuanLyMaSo(quanLyMaSoId);
	}

	/**
	 * Returns a range of all the quan ly ma sos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.QuanLyMaSoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of quan ly ma sos
	 * @param end the upper bound of the range of quan ly ma sos (not inclusive)
	 * @return the range of quan ly ma sos
	 */
	@Override
	public java.util.List<com.mb.model.QuanLyMaSo> getQuanLyMaSos(
		int start, int end) {

		return _quanLyMaSoLocalService.getQuanLyMaSos(start, end);
	}

	/**
	 * Returns the number of quan ly ma sos.
	 *
	 * @return the number of quan ly ma sos
	 */
	@Override
	public int getQuanLyMaSosCount() {
		return _quanLyMaSoLocalService.getQuanLyMaSosCount();
	}

	@Override
	public com.mb.model.QuanLyMaSo tangQuanLyMaSo(
			String key,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _quanLyMaSoLocalService.tangQuanLyMaSo(key, serviceContext);
	}

	/**
	 * Updates the quan ly ma so in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param quanLyMaSo the quan ly ma so
	 * @return the quan ly ma so that was updated
	 */
	@Override
	public com.mb.model.QuanLyMaSo updateQuanLyMaSo(
		com.mb.model.QuanLyMaSo quanLyMaSo) {

		return _quanLyMaSoLocalService.updateQuanLyMaSo(quanLyMaSo);
	}

	@Override
	public com.mb.model.QuanLyMaSo updateQuanLyMaSo(
			com.mb.model.QuanLyMaSo quanLyMaSo,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _quanLyMaSoLocalService.updateQuanLyMaSo(
			quanLyMaSo, serviceContext);
	}

	@Override
	public QuanLyMaSoLocalService getWrappedService() {
		return _quanLyMaSoLocalService;
	}

	@Override
	public void setWrappedService(
		QuanLyMaSoLocalService quanLyMaSoLocalService) {

		_quanLyMaSoLocalService = quanLyMaSoLocalService;
	}

	private QuanLyMaSoLocalService _quanLyMaSoLocalService;

}