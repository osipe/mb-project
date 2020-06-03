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
 * Provides a wrapper for {@link MaSoThuChiLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see MaSoThuChiLocalService
 * @generated
 */
@ProviderType
public class MaSoThuChiLocalServiceWrapper
	implements MaSoThuChiLocalService, ServiceWrapper<MaSoThuChiLocalService> {

	public MaSoThuChiLocalServiceWrapper(
		MaSoThuChiLocalService maSoThuChiLocalService) {

		_maSoThuChiLocalService = maSoThuChiLocalService;
	}

	/**
	 * Adds the ma so thu chi to the database. Also notifies the appropriate model listeners.
	 *
	 * @param maSoThuChi the ma so thu chi
	 * @return the ma so thu chi that was added
	 */
	@Override
	public com.mb.model.MaSoThuChi addMaSoThuChi(
		com.mb.model.MaSoThuChi maSoThuChi) {

		return _maSoThuChiLocalService.addMaSoThuChi(maSoThuChi);
	}

	@Override
	public com.mb.model.MaSoThuChi addMaSoThuChi(
			com.mb.model.MaSoThuChi maSoThuChi,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException,
			   com.mb.exception.TrungMaException {

		return _maSoThuChiLocalService.addMaSoThuChi(
			maSoThuChi, serviceContext);
	}

	@Override
	public com.mb.model.MaSoThuChi addOrUpdateMaSoThuChi(
			com.mb.model.MaSoThuChi maSoThuChi,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException,
			   com.mb.exception.TrungMaException {

		return _maSoThuChiLocalService.addOrUpdateMaSoThuChi(
			maSoThuChi, serviceContext);
	}

	@Override
	public int countBase(String ma, String dienGiai, int loai, int hoatDong)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _maSoThuChiLocalService.countBase(ma, dienGiai, loai, hoatDong);
	}

	/**
	 * Creates a new ma so thu chi with the primary key. Does not add the ma so thu chi to the database.
	 *
	 * @param maSoThuChiId the primary key for the new ma so thu chi
	 * @return the new ma so thu chi
	 */
	@Override
	public com.mb.model.MaSoThuChi createMaSoThuChi(long maSoThuChiId) {
		return _maSoThuChiLocalService.createMaSoThuChi(maSoThuChiId);
	}

	/**
	 * Deletes the ma so thu chi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param maSoThuChiId the primary key of the ma so thu chi
	 * @return the ma so thu chi that was removed
	 * @throws PortalException if a ma so thu chi with the primary key could not be found
	 */
	@Override
	public com.mb.model.MaSoThuChi deleteMaSoThuChi(long maSoThuChiId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _maSoThuChiLocalService.deleteMaSoThuChi(maSoThuChiId);
	}

	/**
	 * Deletes the ma so thu chi from the database. Also notifies the appropriate model listeners.
	 *
	 * @param maSoThuChi the ma so thu chi
	 * @return the ma so thu chi that was removed
	 */
	@Override
	public com.mb.model.MaSoThuChi deleteMaSoThuChi(
		com.mb.model.MaSoThuChi maSoThuChi) {

		return _maSoThuChiLocalService.deleteMaSoThuChi(maSoThuChi);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _maSoThuChiLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _maSoThuChiLocalService.dynamicQuery();
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

		return _maSoThuChiLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.MaSoThuChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _maSoThuChiLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.MaSoThuChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _maSoThuChiLocalService.dynamicQuery(
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

		return _maSoThuChiLocalService.dynamicQueryCount(dynamicQuery);
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

		return _maSoThuChiLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mb.model.MaSoThuChi fetchByMa_Loai_HoatDong(
			String ma, int loai, boolean hoatDong)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _maSoThuChiLocalService.fetchByMa_Loai_HoatDong(
			ma, loai, hoatDong);
	}

	@Override
	public com.mb.model.MaSoThuChi fetchMaSoThuChi(long maSoThuChiId) {
		return _maSoThuChiLocalService.fetchMaSoThuChi(maSoThuChiId);
	}

	@Override
	public java.util.List<com.mb.model.MaSoThuChi> findBase(
			String ma, String dienGiai, int loai, int hoatDong, int start,
			int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _maSoThuChiLocalService.findBase(
			ma, dienGiai, loai, hoatDong, start, end, obc);
	}

	@Override
	public java.util.List<com.mb.model.MaSoThuChi> findByLoai_HoatDong(
			int loai, boolean hoatDong)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _maSoThuChiLocalService.findByLoai_HoatDong(loai, hoatDong);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _maSoThuChiLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _maSoThuChiLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the ma so thu chi with the primary key.
	 *
	 * @param maSoThuChiId the primary key of the ma so thu chi
	 * @return the ma so thu chi
	 * @throws PortalException if a ma so thu chi with the primary key could not be found
	 */
	@Override
	public com.mb.model.MaSoThuChi getMaSoThuChi(long maSoThuChiId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _maSoThuChiLocalService.getMaSoThuChi(maSoThuChiId);
	}

	/**
	 * Returns a range of all the ma so thu chis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.MaSoThuChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ma so thu chis
	 * @param end the upper bound of the range of ma so thu chis (not inclusive)
	 * @return the range of ma so thu chis
	 */
	@Override
	public java.util.List<com.mb.model.MaSoThuChi> getMaSoThuChis(
		int start, int end) {

		return _maSoThuChiLocalService.getMaSoThuChis(start, end);
	}

	/**
	 * Returns the number of ma so thu chis.
	 *
	 * @return the number of ma so thu chis
	 */
	@Override
	public int getMaSoThuChisCount() {
		return _maSoThuChiLocalService.getMaSoThuChisCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _maSoThuChiLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _maSoThuChiLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the ma so thu chi in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param maSoThuChi the ma so thu chi
	 * @return the ma so thu chi that was updated
	 */
	@Override
	public com.mb.model.MaSoThuChi updateMaSoThuChi(
		com.mb.model.MaSoThuChi maSoThuChi) {

		return _maSoThuChiLocalService.updateMaSoThuChi(maSoThuChi);
	}

	@Override
	public com.mb.model.MaSoThuChi updateMaSoThuChi(
			com.mb.model.MaSoThuChi maSoThuChi,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException,
			   com.mb.exception.TrungMaException {

		return _maSoThuChiLocalService.updateMaSoThuChi(
			maSoThuChi, serviceContext);
	}

	@Override
	public MaSoThuChiLocalService getWrappedService() {
		return _maSoThuChiLocalService;
	}

	@Override
	public void setWrappedService(
		MaSoThuChiLocalService maSoThuChiLocalService) {

		_maSoThuChiLocalService = maSoThuChiLocalService;
	}

	private MaSoThuChiLocalService _maSoThuChiLocalService;

}