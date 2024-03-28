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
 * Provides a wrapper for {@link CongTacVienLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CongTacVienLocalService
 * @generated
 */
@ProviderType
public class CongTacVienLocalServiceWrapper
	implements CongTacVienLocalService,
			   ServiceWrapper<CongTacVienLocalService> {

	public CongTacVienLocalServiceWrapper(
		CongTacVienLocalService congTacVienLocalService) {

		_congTacVienLocalService = congTacVienLocalService;
	}

	/**
	 * Adds the cong tac vien to the database. Also notifies the appropriate model listeners.
	 *
	 * @param congTacVien the cong tac vien
	 * @return the cong tac vien that was added
	 */
	@Override
	public com.mb.model.CongTacVien addCongTacVien(
		com.mb.model.CongTacVien congTacVien) {

		return _congTacVienLocalService.addCongTacVien(congTacVien);
	}

	@Override
	public com.mb.model.CongTacVien addCongTacVien(
			com.mb.model.CongTacVien congTacVien,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException,
			   com.mb.exception.TrungMaException,
			   com.mb.exception.TrungSoCMNDException {

		return _congTacVienLocalService.addCongTacVien(
			congTacVien, serviceContext);
	}

	@Override
	public com.mb.model.CongTacVien addOrUpdateCongTacVien(
			com.mb.model.CongTacVien congTacVien,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException,
			   com.mb.exception.TrungMaException,
			   com.mb.exception.TrungSoCMNDException {

		return _congTacVienLocalService.addOrUpdateCongTacVien(
			congTacVien, serviceContext);
	}

	@Override
	public int countBase(
			String ma, String hoTen, String soCMND, String diaChi, int hoatDong)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _congTacVienLocalService.countBase(
			ma, hoTen, soCMND, diaChi, hoatDong);
	}

	@Override
	public int countCTVSaoKe(
			long chiNhanhId, String maCTV, java.util.Date ngayTaoTu)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _congTacVienLocalService.countCTVSaoKe(
			chiNhanhId, maCTV, ngayTaoTu);
	}

	/**
	 * Creates a new cong tac vien with the primary key. Does not add the cong tac vien to the database.
	 *
	 * @param congTacVienId the primary key for the new cong tac vien
	 * @return the new cong tac vien
	 */
	@Override
	public com.mb.model.CongTacVien createCongTacVien(long congTacVienId) {
		return _congTacVienLocalService.createCongTacVien(congTacVienId);
	}

	/**
	 * Deletes the cong tac vien from the database. Also notifies the appropriate model listeners.
	 *
	 * @param congTacVien the cong tac vien
	 * @return the cong tac vien that was removed
	 */
	@Override
	public com.mb.model.CongTacVien deleteCongTacVien(
		com.mb.model.CongTacVien congTacVien) {

		return _congTacVienLocalService.deleteCongTacVien(congTacVien);
	}

	/**
	 * Deletes the cong tac vien with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param congTacVienId the primary key of the cong tac vien
	 * @return the cong tac vien that was removed
	 * @throws PortalException if a cong tac vien with the primary key could not be found
	 */
	@Override
	public com.mb.model.CongTacVien deleteCongTacVien(long congTacVienId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _congTacVienLocalService.deleteCongTacVien(congTacVienId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _congTacVienLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _congTacVienLocalService.dynamicQuery();
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

		return _congTacVienLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.CongTacVienModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _congTacVienLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.CongTacVienModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _congTacVienLocalService.dynamicQuery(
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

		return _congTacVienLocalService.dynamicQueryCount(dynamicQuery);
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

		return _congTacVienLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mb.model.CongTacVien fetchByMa(String ma)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _congTacVienLocalService.fetchByMa(ma);
	}

	@Override
	public com.mb.model.CongTacVien fetchBySoCMND(String soCMND)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _congTacVienLocalService.fetchBySoCMND(soCMND);
	}

	@Override
	public com.mb.model.CongTacVien fetchCongTacVien(long congTacVienId) {
		return _congTacVienLocalService.fetchCongTacVien(congTacVienId);
	}

	@Override
	public java.util.List<com.mb.model.CongTacVien> findBase(
			String ma, String hoTen, String soCMND, String diaChi, int hoatDong,
			int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _congTacVienLocalService.findBase(
			ma, hoTen, soCMND, diaChi, hoatDong, start, end, obc);
	}

	@Override
	public java.util.List<com.mb.model.CongTacVien> findChiNhanh_Ma_HoatDong(
		long chiNhanhId, String ma, int hoatDong, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc) {

		return _congTacVienLocalService.findChiNhanh_Ma_HoatDong(
			chiNhanhId, ma, hoatDong, start, end, obc);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _congTacVienLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the cong tac vien with the primary key.
	 *
	 * @param congTacVienId the primary key of the cong tac vien
	 * @return the cong tac vien
	 * @throws PortalException if a cong tac vien with the primary key could not be found
	 */
	@Override
	public com.mb.model.CongTacVien getCongTacVien(long congTacVienId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _congTacVienLocalService.getCongTacVien(congTacVienId);
	}

	@Override
	public java.util.List<com.mb.model.CongTacVien>
			getCongTacVienChuaCoTaiKhoanDU()
		throws com.liferay.portal.kernel.exception.SystemException {

		return _congTacVienLocalService.getCongTacVienChuaCoTaiKhoanDU();
	}

	/**
	 * Returns a range of all the cong tac viens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.CongTacVienModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cong tac viens
	 * @param end the upper bound of the range of cong tac viens (not inclusive)
	 * @return the range of cong tac viens
	 */
	@Override
	public java.util.List<com.mb.model.CongTacVien> getCongTacViens(
		int start, int end) {

		return _congTacVienLocalService.getCongTacViens(start, end);
	}

	/**
	 * Returns the number of cong tac viens.
	 *
	 * @return the number of cong tac viens
	 */
	@Override
	public int getCongTacViensCount() {
		return _congTacVienLocalService.getCongTacViensCount();
	}

	@Override
	public java.util.List<com.mb.model.CongTacVien> getCTVPhatVayNgay(
			java.util.Date ngayTaoTu, java.util.Date ngayTaoDen)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _congTacVienLocalService.getCTVPhatVayNgay(
			ngayTaoTu, ngayTaoDen);
	}

	@Override
	public java.util.List<com.mb.model.CongTacVien> getCTVSaoKe(
			long chiNhanhId, String maCTV, java.util.Date ngayTaoTu)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _congTacVienLocalService.getCTVSaoKe(
			chiNhanhId, maCTV, ngayTaoTu);
	}

	@Override
	public java.util.List<com.mb.model.CongTacVien> getCTVSaoKePhanTrang(
			long chiNhanhId, String maCTV, java.util.Date ngayTaoTu, int start,
			int end)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _congTacVienLocalService.getCTVSaoKePhanTrang(
			chiNhanhId, maCTV, ngayTaoTu, start, end);
	}

	@Override
	public java.util.List<com.mb.model.CongTacVien> getCTVThuPhatChi(
			String maCTV, java.util.Date ngayTaoTu, java.util.Date ngayTaoDen)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _congTacVienLocalService.getCTVThuPhatChi(
			maCTV, ngayTaoTu, ngayTaoDen);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _congTacVienLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _congTacVienLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _congTacVienLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the cong tac vien in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param congTacVien the cong tac vien
	 * @return the cong tac vien that was updated
	 */
	@Override
	public com.mb.model.CongTacVien updateCongTacVien(
		com.mb.model.CongTacVien congTacVien) {

		return _congTacVienLocalService.updateCongTacVien(congTacVien);
	}

	@Override
	public com.mb.model.CongTacVien updateCongTacVien(
			com.mb.model.CongTacVien congTacVien,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException,
			   com.mb.exception.TrungMaException,
			   com.mb.exception.TrungSoCMNDException {

		return _congTacVienLocalService.updateCongTacVien(
			congTacVien, serviceContext);
	}

	@Override
	public CongTacVienLocalService getWrappedService() {
		return _congTacVienLocalService;
	}

	@Override
	public void setWrappedService(
		CongTacVienLocalService congTacVienLocalService) {

		_congTacVienLocalService = congTacVienLocalService;
	}

	private CongTacVienLocalService _congTacVienLocalService;

}