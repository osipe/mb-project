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

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.mb.exception.TrungDuLieuDauKyException;
import com.mb.model.LichSuTaiKhoanDauKy;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for LichSuTaiKhoanDauKy. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see LichSuTaiKhoanDauKyLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface LichSuTaiKhoanDauKyLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LichSuTaiKhoanDauKyLocalServiceUtil} to access the lich su tai khoan dau ky local service. Add custom service methods to <code>com.mb.service.impl.LichSuTaiKhoanDauKyLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	 * Adds the lich su tai khoan dau ky to the database. Also notifies the appropriate model listeners.
	 *
	 * @param lichSuTaiKhoanDauKy the lich su tai khoan dau ky
	 * @return the lich su tai khoan dau ky that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public LichSuTaiKhoanDauKy addLichSuTaiKhoanDauKy(
		LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy);

	public LichSuTaiKhoanDauKy addLichSuTaiKhoanDauKy(
			LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy,
			ServiceContext serviceContext)
		throws PortalException, SystemException, TrungDuLieuDauKyException;

	public LichSuTaiKhoanDauKy addOrUpdateLichSuTaiKhoanDauKy(
			LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy,
			ServiceContext serviceContext)
		throws PortalException, SystemException;

	public int countBase(int nam, int thang, long taiKhoanDoiUngId)
		throws SystemException;

	/**
	 * Creates a new lich su tai khoan dau ky with the primary key. Does not add the lich su tai khoan dau ky to the database.
	 *
	 * @param lichSuTaiKhoanDauKyId the primary key for the new lich su tai khoan dau ky
	 * @return the new lich su tai khoan dau ky
	 */
	@Transactional(enabled = false)
	public LichSuTaiKhoanDauKy createLichSuTaiKhoanDauKy(
		long lichSuTaiKhoanDauKyId);

	/**
	 * Deletes the lich su tai khoan dau ky from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lichSuTaiKhoanDauKy the lich su tai khoan dau ky
	 * @return the lich su tai khoan dau ky that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public LichSuTaiKhoanDauKy deleteLichSuTaiKhoanDauKy(
		LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy);

	/**
	 * Deletes the lich su tai khoan dau ky with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lichSuTaiKhoanDauKyId the primary key of the lich su tai khoan dau ky
	 * @return the lich su tai khoan dau ky that was removed
	 * @throws PortalException if a lich su tai khoan dau ky with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public LichSuTaiKhoanDauKy deleteLichSuTaiKhoanDauKy(
			long lichSuTaiKhoanDauKyId)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.LichSuTaiKhoanDauKyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.LichSuTaiKhoanDauKyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public LichSuTaiKhoanDauKy fetchByTaiKhoanDoiUngId_Nam_Thang(
			long taiKhoanDoiUngId, int nam, int thang)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public LichSuTaiKhoanDauKy fetchLichSuTaiKhoanDauKy(
		long lichSuTaiKhoanDauKyId);

	public List<LichSuTaiKhoanDauKy> findBase(
			int nam, int thang, long taiKhoanDoiUngId, int start, int end,
			OrderByComparator obc)
		throws SystemException;

	public List<LichSuTaiKhoanDauKy> findByNam_Thang(int nam, int thang)
		throws SystemException;

	public List<LichSuTaiKhoanDauKy> findByTaiKhoanDoiUngId(
			long taiKhoanDoiUngId)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns a range of all the lich su tai khoan dau kies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.LichSuTaiKhoanDauKyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lich su tai khoan dau kies
	 * @param end the upper bound of the range of lich su tai khoan dau kies (not inclusive)
	 * @return the range of lich su tai khoan dau kies
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<LichSuTaiKhoanDauKy> getLichSuTaiKhoanDauKies(
		int start, int end);

	/**
	 * Returns the number of lich su tai khoan dau kies.
	 *
	 * @return the number of lich su tai khoan dau kies
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getLichSuTaiKhoanDauKiesCount();

	/**
	 * Returns the lich su tai khoan dau ky with the primary key.
	 *
	 * @param lichSuTaiKhoanDauKyId the primary key of the lich su tai khoan dau ky
	 * @return the lich su tai khoan dau ky
	 * @throws PortalException if a lich su tai khoan dau ky with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public LichSuTaiKhoanDauKy getLichSuTaiKhoanDauKy(
			long lichSuTaiKhoanDauKyId)
		throws PortalException;

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	public LichSuTaiKhoanDauKy sumByNamThang(
			long taiKhoanDoiUngChaId, int loaiTaiKhoan, int nam, int thang)
		throws SystemException;

	/**
	 * Updates the lich su tai khoan dau ky in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param lichSuTaiKhoanDauKy the lich su tai khoan dau ky
	 * @return the lich su tai khoan dau ky that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public LichSuTaiKhoanDauKy updateLichSuTaiKhoanDauKy(
		LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy);

	public LichSuTaiKhoanDauKy updateLichSuTaiKhoanDauKy(
			LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy,
			ServiceContext serviceContext)
		throws PortalException, SystemException, TrungDuLieuDauKyException;

}