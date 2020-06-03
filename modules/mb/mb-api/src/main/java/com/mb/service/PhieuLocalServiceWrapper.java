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
 * Provides a wrapper for {@link PhieuLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PhieuLocalService
 * @generated
 */
@ProviderType
public class PhieuLocalServiceWrapper
	implements PhieuLocalService, ServiceWrapper<PhieuLocalService> {

	public PhieuLocalServiceWrapper(PhieuLocalService phieuLocalService) {
		_phieuLocalService = phieuLocalService;
	}

	@Override
	public com.mb.model.Phieu addOrUpdatePhieu(
			com.mb.model.Phieu phieu,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.NoSuchUserException,
			   com.liferay.portal.kernel.exception.SystemException,
			   com.mb.exception.TrungSoKUException {

		return _phieuLocalService.addOrUpdatePhieu(phieu, serviceContext);
	}

	/**
	 * Adds the phieu to the database. Also notifies the appropriate model listeners.
	 *
	 * @param phieu the phieu
	 * @return the phieu that was added
	 */
	@Override
	public com.mb.model.Phieu addPhieu(com.mb.model.Phieu phieu) {
		return _phieuLocalService.addPhieu(phieu);
	}

	@Override
	public com.mb.model.Phieu addPhieu(
			com.mb.model.Phieu phieu,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.NoSuchUserException,
			   com.liferay.portal.kernel.exception.SystemException,
			   com.mb.exception.TrungSoKUException {

		return _phieuLocalService.addPhieu(phieu, serviceContext);
	}

	@Override
	public int countBase(
			String maCTV, String maMSThuChi, String soPhieu,
			java.util.Date ngayChungTuTu, java.util.Date ngayChungTuDen,
			int loai, int hoatDong)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _phieuLocalService.countBase(
			maCTV, maMSThuChi, soPhieu, ngayChungTuTu, ngayChungTuDen, loai,
			hoatDong);
	}

	/**
	 * Creates a new phieu with the primary key. Does not add the phieu to the database.
	 *
	 * @param phieuId the primary key for the new phieu
	 * @return the new phieu
	 */
	@Override
	public com.mb.model.Phieu createPhieu(long phieuId) {
		return _phieuLocalService.createPhieu(phieuId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phieuLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the phieu with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param phieuId the primary key of the phieu
	 * @return the phieu that was removed
	 * @throws PortalException if a phieu with the primary key could not be found
	 */
	@Override
	public com.mb.model.Phieu deletePhieu(long phieuId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phieuLocalService.deletePhieu(phieuId);
	}

	/**
	 * Deletes the phieu from the database. Also notifies the appropriate model listeners.
	 *
	 * @param phieu the phieu
	 * @return the phieu that was removed
	 */
	@Override
	public com.mb.model.Phieu deletePhieu(com.mb.model.Phieu phieu) {
		return _phieuLocalService.deletePhieu(phieu);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _phieuLocalService.dynamicQuery();
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

		return _phieuLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.PhieuModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _phieuLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.PhieuModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _phieuLocalService.dynamicQuery(
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

		return _phieuLocalService.dynamicQueryCount(dynamicQuery);
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

		return _phieuLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.mb.model.Phieu fetchPhieu(long phieuId) {
		return _phieuLocalService.fetchPhieu(phieuId);
	}

	@Override
	public java.util.List<com.mb.model.Phieu> findBase(
			String maCTV, String maMSThuChi, String soPhieu,
			java.util.Date ngayChungTuTu, java.util.Date ngayChungTuDen,
			int loai, int hoatDong, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _phieuLocalService.findBase(
			maCTV, maMSThuChi, soPhieu, ngayChungTuTu, ngayChungTuDen, loai,
			hoatDong, start, end, obc);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _phieuLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _phieuLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _phieuLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phieuLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the phieu with the primary key.
	 *
	 * @param phieuId the primary key of the phieu
	 * @return the phieu
	 * @throws PortalException if a phieu with the primary key could not be found
	 */
	@Override
	public com.mb.model.Phieu getPhieu(long phieuId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phieuLocalService.getPhieu(phieuId);
	}

	/**
	 * Returns a range of all the phieus.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.PhieuModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of phieus
	 * @param end the upper bound of the range of phieus (not inclusive)
	 * @return the range of phieus
	 */
	@Override
	public java.util.List<com.mb.model.Phieu> getPhieus(int start, int end) {
		return _phieuLocalService.getPhieus(start, end);
	}

	/**
	 * Returns the number of phieus.
	 *
	 * @return the number of phieus
	 */
	@Override
	public int getPhieusCount() {
		return _phieuLocalService.getPhieusCount();
	}

	/**
	 * Updates the phieu in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param phieu the phieu
	 * @return the phieu that was updated
	 */
	@Override
	public com.mb.model.Phieu updatePhieu(com.mb.model.Phieu phieu) {
		return _phieuLocalService.updatePhieu(phieu);
	}

	@Override
	public com.mb.model.Phieu updatePhieu(
			com.mb.model.Phieu phieu,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.NoSuchUserException,
			   com.liferay.portal.kernel.exception.SystemException,
			   com.mb.exception.TrungSoKUException {

		return _phieuLocalService.updatePhieu(phieu, serviceContext);
	}

	@Override
	public PhieuLocalService getWrappedService() {
		return _phieuLocalService;
	}

	@Override
	public void setWrappedService(PhieuLocalService phieuLocalService) {
		_phieuLocalService = phieuLocalService;
	}

	private PhieuLocalService _phieuLocalService;

}