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
 * Provides a wrapper for {@link LichSuThuPhatChiLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LichSuThuPhatChiLocalService
 * @generated
 */
@ProviderType
public class LichSuThuPhatChiLocalServiceWrapper
	implements LichSuThuPhatChiLocalService,
			   ServiceWrapper<LichSuThuPhatChiLocalService> {

	public LichSuThuPhatChiLocalServiceWrapper(
		LichSuThuPhatChiLocalService lichSuThuPhatChiLocalService) {

		_lichSuThuPhatChiLocalService = lichSuThuPhatChiLocalService;
	}

	/**
	 * Adds the lich su thu phat chi to the database. Also notifies the appropriate model listeners.
	 *
	 * @param lichSuThuPhatChi the lich su thu phat chi
	 * @return the lich su thu phat chi that was added
	 */
	@Override
	public com.mb.model.LichSuThuPhatChi addLichSuThuPhatChi(
		com.mb.model.LichSuThuPhatChi lichSuThuPhatChi) {

		return _lichSuThuPhatChiLocalService.addLichSuThuPhatChi(
			lichSuThuPhatChi);
	}

	@Override
	public com.mb.model.LichSuThuPhatChi addLichSuThuPhatChi(
			com.mb.model.LichSuThuPhatChi lichSuThuPhatChi,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.NoSuchUserException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _lichSuThuPhatChiLocalService.addLichSuThuPhatChi(
			lichSuThuPhatChi, serviceContext);
	}

	@Override
	public com.mb.model.LichSuThuPhatChi addOrUpdateLichSuThuPhatChi(
			com.mb.model.LichSuThuPhatChi lichSuThuPhatChi,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.NoSuchUserException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _lichSuThuPhatChiLocalService.addOrUpdateLichSuThuPhatChi(
			lichSuThuPhatChi, serviceContext);
	}

	/**
	 * Creates a new lich su thu phat chi with the primary key. Does not add the lich su thu phat chi to the database.
	 *
	 * @param lichSuThuPhatChiId the primary key for the new lich su thu phat chi
	 * @return the new lich su thu phat chi
	 */
	@Override
	public com.mb.model.LichSuThuPhatChi createLichSuThuPhatChi(
		long lichSuThuPhatChiId) {

		return _lichSuThuPhatChiLocalService.createLichSuThuPhatChi(
			lichSuThuPhatChiId);
	}

	/**
	 * Deletes the lich su thu phat chi from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lichSuThuPhatChi the lich su thu phat chi
	 * @return the lich su thu phat chi that was removed
	 */
	@Override
	public com.mb.model.LichSuThuPhatChi deleteLichSuThuPhatChi(
		com.mb.model.LichSuThuPhatChi lichSuThuPhatChi) {

		return _lichSuThuPhatChiLocalService.deleteLichSuThuPhatChi(
			lichSuThuPhatChi);
	}

	/**
	 * Deletes the lich su thu phat chi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lichSuThuPhatChiId the primary key of the lich su thu phat chi
	 * @return the lich su thu phat chi that was removed
	 * @throws PortalException if a lich su thu phat chi with the primary key could not be found
	 */
	@Override
	public com.mb.model.LichSuThuPhatChi deleteLichSuThuPhatChi(
			long lichSuThuPhatChiId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lichSuThuPhatChiLocalService.deleteLichSuThuPhatChi(
			lichSuThuPhatChiId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lichSuThuPhatChiLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _lichSuThuPhatChiLocalService.dynamicQuery();
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

		return _lichSuThuPhatChiLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.LichSuThuPhatChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _lichSuThuPhatChiLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.LichSuThuPhatChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _lichSuThuPhatChiLocalService.dynamicQuery(
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

		return _lichSuThuPhatChiLocalService.dynamicQueryCount(dynamicQuery);
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

		return _lichSuThuPhatChiLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.mb.model.LichSuThuPhatChi fetchLichSuThuPhatChi(
		long lichSuThuPhatChiId) {

		return _lichSuThuPhatChiLocalService.fetchLichSuThuPhatChi(
			lichSuThuPhatChiId);
	}

	@Override
	public java.util.List<com.mb.model.LichSuThuPhatChi>
			findByCTV_Loai_Createdate(
				String maCTV, int loai, java.util.Date ngayTaoTu,
				java.util.Date ngayTaoDen, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _lichSuThuPhatChiLocalService.findByCTV_Loai_Createdate(
			maCTV, loai, ngayTaoTu, ngayTaoDen, start, end, obc);
	}

	@Override
	public java.util.List<com.mb.model.LichSuThuPhatChi>
			findByCTV_Loai_Createdate_NgayXuLy(
				String maCTV, int loai, java.util.Date ngayTaoTu,
				java.util.Date ngayTaoDen, java.util.Date ngayXuLyTu,
				java.util.Date ngayXuLyDen, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _lichSuThuPhatChiLocalService.findByCTV_Loai_Createdate_NgayXuLy(
			maCTV, loai, ngayTaoTu, ngayTaoDen, ngayXuLyTu, ngayXuLyDen, start,
			end, obc);
	}

	@Override
	public java.util.List<com.mb.model.LichSuThuPhatChi>
			findByPhatVay_Createdate_Loai(
				long chiNhanhId, long phatVayId, java.util.Date ngayTaoTu,
				java.util.Date ngayTaoDen, String loai)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _lichSuThuPhatChiLocalService.findByPhatVay_Createdate_Loai(
			chiNhanhId, phatVayId, ngayTaoTu, ngayTaoDen, loai);
	}

	@Override
	public java.util.List<com.mb.model.LichSuThuPhatChi> findByPhatVayId_Loai(
			long phatVayId, int loai)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _lichSuThuPhatChiLocalService.findByPhatVayId_Loai(
			phatVayId, loai);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _lichSuThuPhatChiLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _lichSuThuPhatChiLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the lich su thu phat chi with the primary key.
	 *
	 * @param lichSuThuPhatChiId the primary key of the lich su thu phat chi
	 * @return the lich su thu phat chi
	 * @throws PortalException if a lich su thu phat chi with the primary key could not be found
	 */
	@Override
	public com.mb.model.LichSuThuPhatChi getLichSuThuPhatChi(
			long lichSuThuPhatChiId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lichSuThuPhatChiLocalService.getLichSuThuPhatChi(
			lichSuThuPhatChiId);
	}

	@Override
	public java.util.List<Object[]> getLichSuThuPhatChi_MaCTV_Createdate(
			String maCTV, java.util.Date createdate)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _lichSuThuPhatChiLocalService.
			getLichSuThuPhatChi_MaCTV_Createdate(maCTV, createdate);
	}

	/**
	 * Returns a range of all the lich su thu phat chis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.LichSuThuPhatChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lich su thu phat chis
	 * @param end the upper bound of the range of lich su thu phat chis (not inclusive)
	 * @return the range of lich su thu phat chis
	 */
	@Override
	public java.util.List<com.mb.model.LichSuThuPhatChi> getLichSuThuPhatChis(
		int start, int end) {

		return _lichSuThuPhatChiLocalService.getLichSuThuPhatChis(start, end);
	}

	/**
	 * Returns the number of lich su thu phat chis.
	 *
	 * @return the number of lich su thu phat chis
	 */
	@Override
	public int getLichSuThuPhatChisCount() {
		return _lichSuThuPhatChiLocalService.getLichSuThuPhatChisCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _lichSuThuPhatChiLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lichSuThuPhatChiLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public Double getSoTienVay_CTV_TAINGAY(
			long chiNhanhId, String maCTV, java.util.Date ngay)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _lichSuThuPhatChiLocalService.getSoTienVay_CTV_TAINGAY(
			chiNhanhId, maCTV, ngay);
	}

	@Override
	public Object[] getSumPhatVay_CTV_TAINGAY(
			long chiNhanhId, String maCTV, java.util.Date ngay, int loaiPV)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _lichSuThuPhatChiLocalService.getSumPhatVay_CTV_TAINGAY(
			chiNhanhId, maCTV, ngay, loaiPV);
	}

	@Override
	public Object[] getTongLichSuTraTien_CTV_TAINGAY(
			long chiNhanhId, String maCTV, java.util.Date ngay,
			java.util.Date ngayXuLy, int loaiPV)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _lichSuThuPhatChiLocalService.getTongLichSuTraTien_CTV_TAINGAY(
			chiNhanhId, maCTV, ngay, ngayXuLy, loaiPV);
	}

	@Override
	public void removeByPhatVayId(long phatVayId)
		throws com.liferay.portal.kernel.exception.SystemException {

		_lichSuThuPhatChiLocalService.removeByPhatVayId(phatVayId);
	}

	@Override
	public void removeByPhatVayId_Loai(long phatVayId, int loai)
		throws com.liferay.portal.kernel.exception.SystemException {

		_lichSuThuPhatChiLocalService.removeByPhatVayId_Loai(phatVayId, loai);
	}

	/**
	 * Updates the lich su thu phat chi in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param lichSuThuPhatChi the lich su thu phat chi
	 * @return the lich su thu phat chi that was updated
	 */
	@Override
	public com.mb.model.LichSuThuPhatChi updateLichSuThuPhatChi(
		com.mb.model.LichSuThuPhatChi lichSuThuPhatChi) {

		return _lichSuThuPhatChiLocalService.updateLichSuThuPhatChi(
			lichSuThuPhatChi);
	}

	@Override
	public com.mb.model.LichSuThuPhatChi updateLichSuThuPhatChi(
			com.mb.model.LichSuThuPhatChi lichSuThuPhatChi,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _lichSuThuPhatChiLocalService.updateLichSuThuPhatChi(
			lichSuThuPhatChi, serviceContext);
	}

	@Override
	public LichSuThuPhatChiLocalService getWrappedService() {
		return _lichSuThuPhatChiLocalService;
	}

	@Override
	public void setWrappedService(
		LichSuThuPhatChiLocalService lichSuThuPhatChiLocalService) {

		_lichSuThuPhatChiLocalService = lichSuThuPhatChiLocalService;
	}

	private LichSuThuPhatChiLocalService _lichSuThuPhatChiLocalService;

}