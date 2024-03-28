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
import com.liferay.portal.kernel.exception.NoSuchUserException;
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

import com.mb.exception.TrungSoKUException;
import com.mb.model.PhatVay;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

/**
 * Provides the local service interface for PhatVay. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see PhatVayLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface PhatVayLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PhatVayLocalServiceUtil} to access the phat vay local service. Add custom service methods to <code>com.mb.service.impl.PhatVayLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public PhatVay addOrUpdatePhatVay(
			PhatVay phatVay, ServiceContext serviceContext)
		throws NoSuchUserException, SystemException, TrungSoKUException;

	public void addOrUpdateThongTinLienQuan(
			PhatVay phatVay, ServiceContext serviceContext)
		throws NoSuchUserException, SystemException;

	/**
	 * Adds the phat vay to the database. Also notifies the appropriate model listeners.
	 *
	 * @param phatVay the phat vay
	 * @return the phat vay that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public PhatVay addPhatVay(PhatVay phatVay);

	public PhatVay addPhatVay(PhatVay phatVay, ServiceContext serviceContext)
		throws NoSuchUserException, SystemException, TrungSoKUException;

	public int countBase(
			String soKU, String maCTV, String maKhachHang, Date createDateTu,
			Date createDateDen, Date ngayBatDauTu, Date ngayBatDauDen,
			Date ngayTatToanTu, Date ngayTatToanDen, String trangThai)
		throws SystemException;

	public int countCTV_NgayThuTien(
		long chiNhanhId, String maCTV, Date ngayThuTien);

	/**
	 * Creates a new phat vay with the primary key. Does not add the phat vay to the database.
	 *
	 * @param phatVayId the primary key for the new phat vay
	 * @return the new phat vay
	 */
	@Transactional(enabled = false)
	public PhatVay createPhatVay(long phatVayId);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the phat vay with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param phatVayId the primary key of the phat vay
	 * @return the phat vay that was removed
	 * @throws PortalException if a phat vay with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public PhatVay deletePhatVay(long phatVayId) throws PortalException;

	/**
	 * Deletes the phat vay from the database. Also notifies the appropriate model listeners.
	 *
	 * @param phatVay the phat vay
	 * @return the phat vay that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public PhatVay deletePhatVay(PhatVay phatVay);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.PhatVayModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.PhatVayModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public PhatVay fetchBySoKU(String soKU);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PhatVay fetchPhatVay(long phatVayId);

	public List<PhatVay> findBase(
		String soKU, String maCTV, String maKhachHang, Date createDateTu,
		Date createDateDen, Date ngayBatDauTu, Date ngayBatDauDen,
		Date ngayTatToanTu, Date ngayTatToanDen, String trangThai, int start,
		int end, OrderByComparator obc);

	public List<PhatVay> findByMaCTV(String maCTV) throws SystemException;

	public List<PhatVay> findCTV_NgayThuTien(
		long chiNhanhId, String maCTV, Date ngayThuTien);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PhatVay> getPhatVaies(int start, int end);

	/**
	 * Returns the number of phat vaies.
	 *
	 * @return the number of phat vaies
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getPhatVaiesCount();

	/**
	 * Returns the phat vay with the primary key.
	 *
	 * @param phatVayId the primary key of the phat vay
	 * @return the phat vay
	 * @throws PortalException if a phat vay with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PhatVay getPhatVay(long phatVayId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PhatVay> getPhatVayDeThuTienTruoc(
		String maCTV, Date ngayThuTienTu);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PhatVay> getPhatVayInIds(String ids) throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PhatVay> getPhatVaySaoKe(
			long chiNhanhId, String maCTV, int loaiPhatVay, Date createDate)
		throws SystemException;

	public void updateChiNhanh(String maCTV, long chiNhanhId)
		throws SystemException;

	/**
	 * Updates the phat vay in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param phatVay the phat vay
	 * @return the phat vay that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public PhatVay updatePhatVay(PhatVay phatVay);

	public PhatVay updatePhatVay(PhatVay phatVay, ServiceContext serviceContext)
		throws NoSuchUserException, SystemException, TrungSoKUException;

	public void xoaToanBoThongTinPhatVay(long phatVayId)
		throws PortalException, SystemException;

}