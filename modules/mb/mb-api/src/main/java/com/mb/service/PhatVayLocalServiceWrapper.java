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
 * Provides a wrapper for {@link PhatVayLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PhatVayLocalService
 * @generated
 */
@ProviderType
public class PhatVayLocalServiceWrapper
	implements PhatVayLocalService, ServiceWrapper<PhatVayLocalService> {

	public PhatVayLocalServiceWrapper(PhatVayLocalService phatVayLocalService) {
		_phatVayLocalService = phatVayLocalService;
	}

	@Override
	public com.mb.model.PhatVay addOrUpdatePhatVay(
			com.mb.model.PhatVay phatVay,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.NoSuchUserException,
			   com.liferay.portal.kernel.exception.SystemException,
			   com.mb.exception.TrungSoKUException {

		return _phatVayLocalService.addOrUpdatePhatVay(phatVay, serviceContext);
	}

	@Override
	public void addOrUpdateThongTinLienQuan(
			com.mb.model.PhatVay phatVay,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.NoSuchUserException,
			   com.liferay.portal.kernel.exception.SystemException {

		_phatVayLocalService.addOrUpdateThongTinLienQuan(
			phatVay, serviceContext);
	}

	/**
	 * Adds the phat vay to the database. Also notifies the appropriate model listeners.
	 *
	 * @param phatVay the phat vay
	 * @return the phat vay that was added
	 */
	@Override
	public com.mb.model.PhatVay addPhatVay(com.mb.model.PhatVay phatVay) {
		return _phatVayLocalService.addPhatVay(phatVay);
	}

	@Override
	public com.mb.model.PhatVay addPhatVay(
			com.mb.model.PhatVay phatVay,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.NoSuchUserException,
			   com.liferay.portal.kernel.exception.SystemException,
			   com.mb.exception.TrungSoKUException {

		return _phatVayLocalService.addPhatVay(phatVay, serviceContext);
	}

	@Override
	public int countBase(
			String soKU, String maCTV, String maKhachHang,
			java.util.Date createDateTu, java.util.Date createDateDen,
			java.util.Date ngayBatDauTu, java.util.Date ngayBatDauDen,
			java.util.Date ngayTatToanTu, java.util.Date ngayTatToanDen,
			String trangThai)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _phatVayLocalService.countBase(
			soKU, maCTV, maKhachHang, createDateTu, createDateDen, ngayBatDauTu,
			ngayBatDauDen, ngayTatToanTu, ngayTatToanDen, trangThai);
	}

	@Override
	public int countCTV_NgayThuTien(
		long chiNhanhId, String maCTV, java.util.Date ngayThuTien) {

		return _phatVayLocalService.countCTV_NgayThuTien(
			chiNhanhId, maCTV, ngayThuTien);
	}

	/**
	 * Creates a new phat vay with the primary key. Does not add the phat vay to the database.
	 *
	 * @param phatVayId the primary key for the new phat vay
	 * @return the new phat vay
	 */
	@Override
	public com.mb.model.PhatVay createPhatVay(long phatVayId) {
		return _phatVayLocalService.createPhatVay(phatVayId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phatVayLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the phat vay with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param phatVayId the primary key of the phat vay
	 * @return the phat vay that was removed
	 * @throws PortalException if a phat vay with the primary key could not be found
	 */
	@Override
	public com.mb.model.PhatVay deletePhatVay(long phatVayId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phatVayLocalService.deletePhatVay(phatVayId);
	}

	/**
	 * Deletes the phat vay from the database. Also notifies the appropriate model listeners.
	 *
	 * @param phatVay the phat vay
	 * @return the phat vay that was removed
	 */
	@Override
	public com.mb.model.PhatVay deletePhatVay(com.mb.model.PhatVay phatVay) {
		return _phatVayLocalService.deletePhatVay(phatVay);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _phatVayLocalService.dynamicQuery();
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

		return _phatVayLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.PhatVayModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _phatVayLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.PhatVayModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _phatVayLocalService.dynamicQuery(
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

		return _phatVayLocalService.dynamicQueryCount(dynamicQuery);
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

		return _phatVayLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.mb.model.PhatVay fetchBySoKU(String soKU) {
		return _phatVayLocalService.fetchBySoKU(soKU);
	}

	@Override
	public com.mb.model.PhatVay fetchPhatVay(long phatVayId) {
		return _phatVayLocalService.fetchPhatVay(phatVayId);
	}

	@Override
	public java.util.List<com.mb.model.PhatVay> findBase(
		String soKU, String maCTV, String maKhachHang,
		java.util.Date createDateTu, java.util.Date createDateDen,
		java.util.Date ngayBatDauTu, java.util.Date ngayBatDauDen,
		java.util.Date ngayTatToanTu, java.util.Date ngayTatToanDen,
		String trangThai, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc) {

		return _phatVayLocalService.findBase(
			soKU, maCTV, maKhachHang, createDateTu, createDateDen, ngayBatDauTu,
			ngayBatDauDen, ngayTatToanTu, ngayTatToanDen, trangThai, start, end,
			obc);
	}

	@Override
	public java.util.List<com.mb.model.PhatVay> findByMaCTV(String maCTV)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _phatVayLocalService.findByMaCTV(maCTV);
	}

	@Override
	public java.util.List<com.mb.model.PhatVay> findCTV_NgayThuTien(
		long chiNhanhId, String maCTV, java.util.Date ngayThuTien) {

		return _phatVayLocalService.findCTV_NgayThuTien(
			chiNhanhId, maCTV, ngayThuTien);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _phatVayLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _phatVayLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _phatVayLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phatVayLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns a range of all the phat vaies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.PhatVayModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of phat vaies
	 * @param end the upper bound of the range of phat vaies (not inclusive)
	 * @return the range of phat vaies
	 */
	@Override
	public java.util.List<com.mb.model.PhatVay> getPhatVaies(
		int start, int end) {

		return _phatVayLocalService.getPhatVaies(start, end);
	}

	/**
	 * Returns the number of phat vaies.
	 *
	 * @return the number of phat vaies
	 */
	@Override
	public int getPhatVaiesCount() {
		return _phatVayLocalService.getPhatVaiesCount();
	}

	/**
	 * Returns the phat vay with the primary key.
	 *
	 * @param phatVayId the primary key of the phat vay
	 * @return the phat vay
	 * @throws PortalException if a phat vay with the primary key could not be found
	 */
	@Override
	public com.mb.model.PhatVay getPhatVay(long phatVayId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _phatVayLocalService.getPhatVay(phatVayId);
	}

	@Override
	public java.util.List<com.mb.model.PhatVay> getPhatVayDeThuTienTruoc(
		String maCTV, java.util.Date ngayThuTienTu) {

		return _phatVayLocalService.getPhatVayDeThuTienTruoc(
			maCTV, ngayThuTienTu);
	}

	@Override
	public java.util.List<com.mb.model.PhatVay> getPhatVayInIds(String ids)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _phatVayLocalService.getPhatVayInIds(ids);
	}

	@Override
	public java.util.List<com.mb.model.PhatVay> getPhatVaySaoKe(
			long chiNhanhId, String maCTV, int loaiPhatVay,
			java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _phatVayLocalService.getPhatVaySaoKe(
			chiNhanhId, maCTV, loaiPhatVay, createDate);
	}

	@Override
	public void updateChiNhanh(String maCTV, long chiNhanhId)
		throws com.liferay.portal.kernel.exception.SystemException {

		_phatVayLocalService.updateChiNhanh(maCTV, chiNhanhId);
	}

	/**
	 * Updates the phat vay in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param phatVay the phat vay
	 * @return the phat vay that was updated
	 */
	@Override
	public com.mb.model.PhatVay updatePhatVay(com.mb.model.PhatVay phatVay) {
		return _phatVayLocalService.updatePhatVay(phatVay);
	}

	@Override
	public com.mb.model.PhatVay updatePhatVay(
			com.mb.model.PhatVay phatVay,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.NoSuchUserException,
			   com.liferay.portal.kernel.exception.SystemException,
			   com.mb.exception.TrungSoKUException {

		return _phatVayLocalService.updatePhatVay(phatVay, serviceContext);
	}

	@Override
	public void xoaToanBoThongTinPhatVay(long phatVayId)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		_phatVayLocalService.xoaToanBoThongTinPhatVay(phatVayId);
	}

	@Override
	public PhatVayLocalService getWrappedService() {
		return _phatVayLocalService;
	}

	@Override
	public void setWrappedService(PhatVayLocalService phatVayLocalService) {
		_phatVayLocalService = phatVayLocalService;
	}

	private PhatVayLocalService _phatVayLocalService;

}