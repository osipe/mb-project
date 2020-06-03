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
 * Provides a wrapper for {@link KhachHangLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see KhachHangLocalService
 * @generated
 */
@ProviderType
public class KhachHangLocalServiceWrapper
	implements KhachHangLocalService, ServiceWrapper<KhachHangLocalService> {

	public KhachHangLocalServiceWrapper(
		KhachHangLocalService khachHangLocalService) {

		_khachHangLocalService = khachHangLocalService;
	}

	/**
	 * Adds the khach hang to the database. Also notifies the appropriate model listeners.
	 *
	 * @param khachHang the khach hang
	 * @return the khach hang that was added
	 */
	@Override
	public com.mb.model.KhachHang addKhachHang(
		com.mb.model.KhachHang khachHang) {

		return _khachHangLocalService.addKhachHang(khachHang);
	}

	@Override
	public com.mb.model.KhachHang addKhachHang(
			com.mb.model.KhachHang KhachHang,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException,
			   com.mb.exception.TrungMaException,
			   com.mb.exception.TrungSoCMNDException {

		return _khachHangLocalService.addKhachHang(KhachHang, serviceContext);
	}

	@Override
	public com.mb.model.KhachHang addOrUpdateKhachHang(
			com.mb.model.KhachHang KhachHang,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException,
			   com.mb.exception.TrungMaException,
			   com.mb.exception.TrungSoCMNDException {

		return _khachHangLocalService.addOrUpdateKhachHang(
			KhachHang, serviceContext);
	}

	@Override
	public int countBase(
			String ma, String maCTV, String hoTen, String soCMND, String diaChi,
			int hoatDong)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _khachHangLocalService.countBase(
			ma, maCTV, hoTen, soCMND, diaChi, hoatDong);
	}

	/**
	 * Creates a new khach hang with the primary key. Does not add the khach hang to the database.
	 *
	 * @param khachHangId the primary key for the new khach hang
	 * @return the new khach hang
	 */
	@Override
	public com.mb.model.KhachHang createKhachHang(long khachHangId) {
		return _khachHangLocalService.createKhachHang(khachHangId);
	}

	/**
	 * Deletes the khach hang from the database. Also notifies the appropriate model listeners.
	 *
	 * @param khachHang the khach hang
	 * @return the khach hang that was removed
	 */
	@Override
	public com.mb.model.KhachHang deleteKhachHang(
		com.mb.model.KhachHang khachHang) {

		return _khachHangLocalService.deleteKhachHang(khachHang);
	}

	/**
	 * Deletes the khach hang with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param khachHangId the primary key of the khach hang
	 * @return the khach hang that was removed
	 * @throws PortalException if a khach hang with the primary key could not be found
	 */
	@Override
	public com.mb.model.KhachHang deleteKhachHang(long khachHangId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _khachHangLocalService.deleteKhachHang(khachHangId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _khachHangLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _khachHangLocalService.dynamicQuery();
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

		return _khachHangLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.KhachHangModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _khachHangLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.KhachHangModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _khachHangLocalService.dynamicQuery(
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

		return _khachHangLocalService.dynamicQueryCount(dynamicQuery);
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

		return _khachHangLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mb.model.KhachHang fetchByMa(String ma)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _khachHangLocalService.fetchByMa(ma);
	}

	@Override
	public com.mb.model.KhachHang fetchBySoCMND(String soCMND)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _khachHangLocalService.fetchBySoCMND(soCMND);
	}

	@Override
	public com.mb.model.KhachHang fetchKhachHang(long khachHangId) {
		return _khachHangLocalService.fetchKhachHang(khachHangId);
	}

	@Override
	public java.util.List<com.mb.model.KhachHang> findBase(
			String ma, String maCTV, String hoTen, String soCMND, String diaChi,
			int hoatDong, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _khachHangLocalService.findBase(
			ma, maCTV, hoTen, soCMND, diaChi, hoatDong, start, end, obc);
	}

	@Override
	public java.util.List<com.mb.model.KhachHang> findByMaCTV(String maCTV)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _khachHangLocalService.findByMaCTV(maCTV);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _khachHangLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _khachHangLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the khach hang with the primary key.
	 *
	 * @param khachHangId the primary key of the khach hang
	 * @return the khach hang
	 * @throws PortalException if a khach hang with the primary key could not be found
	 */
	@Override
	public com.mb.model.KhachHang getKhachHang(long khachHangId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _khachHangLocalService.getKhachHang(khachHangId);
	}

	/**
	 * Returns a range of all the khach hangs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.KhachHangModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of khach hangs
	 * @param end the upper bound of the range of khach hangs (not inclusive)
	 * @return the range of khach hangs
	 */
	@Override
	public java.util.List<com.mb.model.KhachHang> getKhachHangs(
		int start, int end) {

		return _khachHangLocalService.getKhachHangs(start, end);
	}

	/**
	 * Returns the number of khach hangs.
	 *
	 * @return the number of khach hangs
	 */
	@Override
	public int getKhachHangsCount() {
		return _khachHangLocalService.getKhachHangsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _khachHangLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _khachHangLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the khach hang in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param khachHang the khach hang
	 * @return the khach hang that was updated
	 */
	@Override
	public com.mb.model.KhachHang updateKhachHang(
		com.mb.model.KhachHang khachHang) {

		return _khachHangLocalService.updateKhachHang(khachHang);
	}

	@Override
	public com.mb.model.KhachHang updateKhachHang(
			com.mb.model.KhachHang KhachHang,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException,
			   com.mb.exception.TrungMaException,
			   com.mb.exception.TrungSoCMNDException {

		return _khachHangLocalService.updateKhachHang(
			KhachHang, serviceContext);
	}

	@Override
	public KhachHangLocalService getWrappedService() {
		return _khachHangLocalService;
	}

	@Override
	public void setWrappedService(KhachHangLocalService khachHangLocalService) {
		_khachHangLocalService = khachHangLocalService;
	}

	private KhachHangLocalService _khachHangLocalService;

}