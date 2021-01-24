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
 * Provides a wrapper for {@link CauHinhThuTienTruocLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CauHinhThuTienTruocLocalService
 * @generated
 */
@ProviderType
public class CauHinhThuTienTruocLocalServiceWrapper
	implements CauHinhThuTienTruocLocalService,
			   ServiceWrapper<CauHinhThuTienTruocLocalService> {

	public CauHinhThuTienTruocLocalServiceWrapper(
		CauHinhThuTienTruocLocalService cauHinhThuTienTruocLocalService) {

		_cauHinhThuTienTruocLocalService = cauHinhThuTienTruocLocalService;
	}

	/**
	 * Adds the cau hinh thu tien truoc to the database. Also notifies the appropriate model listeners.
	 *
	 * @param cauHinhThuTienTruoc the cau hinh thu tien truoc
	 * @return the cau hinh thu tien truoc that was added
	 */
	@Override
	public com.mb.model.CauHinhThuTienTruoc addCauHinhThuTienTruoc(
		com.mb.model.CauHinhThuTienTruoc cauHinhThuTienTruoc) {

		return _cauHinhThuTienTruocLocalService.addCauHinhThuTienTruoc(
			cauHinhThuTienTruoc);
	}

	@Override
	public com.mb.model.CauHinhThuTienTruoc addCauHinhThuTienTruoc(
			com.mb.model.CauHinhThuTienTruoc cauHinhThuTienTruoc,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException,
			   com.mb.exception.TrungMaException,
			   com.mb.exception.TrungSoCMNDException {

		return _cauHinhThuTienTruocLocalService.addCauHinhThuTienTruoc(
			cauHinhThuTienTruoc, serviceContext);
	}

	@Override
	public com.mb.model.CauHinhThuTienTruoc addOrUpdate(
			com.mb.model.CauHinhThuTienTruoc cauHinhThuTienTruoc,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException,
			   com.mb.exception.TrungMaException,
			   com.mb.exception.TrungSoCMNDException {

		return _cauHinhThuTienTruocLocalService.addOrUpdate(
			cauHinhThuTienTruoc, serviceContext);
	}

	@Override
	public int countBase(int nam, int hoatDong)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _cauHinhThuTienTruocLocalService.countBase(nam, hoatDong);
	}

	/**
	 * Creates a new cau hinh thu tien truoc with the primary key. Does not add the cau hinh thu tien truoc to the database.
	 *
	 * @param cauHinhThuTienTruocId the primary key for the new cau hinh thu tien truoc
	 * @return the new cau hinh thu tien truoc
	 */
	@Override
	public com.mb.model.CauHinhThuTienTruoc createCauHinhThuTienTruoc(
		long cauHinhThuTienTruocId) {

		return _cauHinhThuTienTruocLocalService.createCauHinhThuTienTruoc(
			cauHinhThuTienTruocId);
	}

	/**
	 * Deletes the cau hinh thu tien truoc from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cauHinhThuTienTruoc the cau hinh thu tien truoc
	 * @return the cau hinh thu tien truoc that was removed
	 */
	@Override
	public com.mb.model.CauHinhThuTienTruoc deleteCauHinhThuTienTruoc(
		com.mb.model.CauHinhThuTienTruoc cauHinhThuTienTruoc) {

		return _cauHinhThuTienTruocLocalService.deleteCauHinhThuTienTruoc(
			cauHinhThuTienTruoc);
	}

	/**
	 * Deletes the cau hinh thu tien truoc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cauHinhThuTienTruocId the primary key of the cau hinh thu tien truoc
	 * @return the cau hinh thu tien truoc that was removed
	 * @throws PortalException if a cau hinh thu tien truoc with the primary key could not be found
	 */
	@Override
	public com.mb.model.CauHinhThuTienTruoc deleteCauHinhThuTienTruoc(
			long cauHinhThuTienTruocId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cauHinhThuTienTruocLocalService.deleteCauHinhThuTienTruoc(
			cauHinhThuTienTruocId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cauHinhThuTienTruocLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _cauHinhThuTienTruocLocalService.dynamicQuery();
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

		return _cauHinhThuTienTruocLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.CauHinhThuTienTruocModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _cauHinhThuTienTruocLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.CauHinhThuTienTruocModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _cauHinhThuTienTruocLocalService.dynamicQuery(
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

		return _cauHinhThuTienTruocLocalService.dynamicQueryCount(dynamicQuery);
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

		return _cauHinhThuTienTruocLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mb.model.CauHinhThuTienTruoc fetchByNam(int nam)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _cauHinhThuTienTruocLocalService.fetchByNam(nam);
	}

	@Override
	public com.mb.model.CauHinhThuTienTruoc fetchCauHinhThuTienTruoc(
		long cauHinhThuTienTruocId) {

		return _cauHinhThuTienTruocLocalService.fetchCauHinhThuTienTruoc(
			cauHinhThuTienTruocId);
	}

	@Override
	public java.util.List<com.mb.model.CauHinhThuTienTruoc> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {

		return _cauHinhThuTienTruocLocalService.findAll();
	}

	@Override
	public java.util.List<com.mb.model.CauHinhThuTienTruoc> findBase(
			int nam, int hoatDong, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _cauHinhThuTienTruocLocalService.findBase(
			nam, hoatDong, start, end, obc);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _cauHinhThuTienTruocLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the cau hinh thu tien truoc with the primary key.
	 *
	 * @param cauHinhThuTienTruocId the primary key of the cau hinh thu tien truoc
	 * @return the cau hinh thu tien truoc
	 * @throws PortalException if a cau hinh thu tien truoc with the primary key could not be found
	 */
	@Override
	public com.mb.model.CauHinhThuTienTruoc getCauHinhThuTienTruoc(
			long cauHinhThuTienTruocId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cauHinhThuTienTruocLocalService.getCauHinhThuTienTruoc(
			cauHinhThuTienTruocId);
	}

	/**
	 * Returns a range of all the cau hinh thu tien truocs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.CauHinhThuTienTruocModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cau hinh thu tien truocs
	 * @param end the upper bound of the range of cau hinh thu tien truocs (not inclusive)
	 * @return the range of cau hinh thu tien truocs
	 */
	@Override
	public java.util.List<com.mb.model.CauHinhThuTienTruoc>
		getCauHinhThuTienTruocs(int start, int end) {

		return _cauHinhThuTienTruocLocalService.getCauHinhThuTienTruocs(
			start, end);
	}

	/**
	 * Returns the number of cau hinh thu tien truocs.
	 *
	 * @return the number of cau hinh thu tien truocs
	 */
	@Override
	public int getCauHinhThuTienTruocsCount() {
		return _cauHinhThuTienTruocLocalService.getCauHinhThuTienTruocsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _cauHinhThuTienTruocLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _cauHinhThuTienTruocLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cauHinhThuTienTruocLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the cau hinh thu tien truoc in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param cauHinhThuTienTruoc the cau hinh thu tien truoc
	 * @return the cau hinh thu tien truoc that was updated
	 */
	@Override
	public com.mb.model.CauHinhThuTienTruoc updateCauHinhThuTienTruoc(
		com.mb.model.CauHinhThuTienTruoc cauHinhThuTienTruoc) {

		return _cauHinhThuTienTruocLocalService.updateCauHinhThuTienTruoc(
			cauHinhThuTienTruoc);
	}

	@Override
	public com.mb.model.CauHinhThuTienTruoc updateCauHinhThuTienTruoc(
			com.mb.model.CauHinhThuTienTruoc cauHinhThuTienTruoc,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException,
			   com.mb.exception.TrungMaException,
			   com.mb.exception.TrungSoCMNDException {

		return _cauHinhThuTienTruocLocalService.updateCauHinhThuTienTruoc(
			cauHinhThuTienTruoc, serviceContext);
	}

	@Override
	public CauHinhThuTienTruocLocalService getWrappedService() {
		return _cauHinhThuTienTruocLocalService;
	}

	@Override
	public void setWrappedService(
		CauHinhThuTienTruocLocalService cauHinhThuTienTruocLocalService) {

		_cauHinhThuTienTruocLocalService = cauHinhThuTienTruocLocalService;
	}

	private CauHinhThuTienTruocLocalService _cauHinhThuTienTruocLocalService;

}