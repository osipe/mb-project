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

import com.mb.exception.TrungMaException;
import com.mb.exception.TrungSoCMNDException;
import com.mb.model.CongTacVien;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

/**
 * Provides the local service interface for CongTacVien. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see CongTacVienLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface CongTacVienLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CongTacVienLocalServiceUtil} to access the cong tac vien local service. Add custom service methods to <code>com.mb.service.impl.CongTacVienLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	 * Adds the cong tac vien to the database. Also notifies the appropriate model listeners.
	 *
	 * @param congTacVien the cong tac vien
	 * @return the cong tac vien that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public CongTacVien addCongTacVien(CongTacVien congTacVien);

	public CongTacVien addCongTacVien(
			CongTacVien congTacVien, ServiceContext serviceContext)
		throws PortalException, SystemException, TrungMaException,
			   TrungSoCMNDException;

	public CongTacVien addOrUpdateCongTacVien(
			CongTacVien congTacVien, ServiceContext serviceContext)
		throws PortalException, SystemException, TrungMaException,
			   TrungSoCMNDException;

	public int countBase(
			String ma, String hoTen, String soCMND, String diaChi, int hoatDong)
		throws SystemException;

	public int countCTVSaoKe(long chiNhanhId, String maCTV, Date ngayTaoTu)
		throws SystemException;

	/**
	 * Creates a new cong tac vien with the primary key. Does not add the cong tac vien to the database.
	 *
	 * @param congTacVienId the primary key for the new cong tac vien
	 * @return the new cong tac vien
	 */
	@Transactional(enabled = false)
	public CongTacVien createCongTacVien(long congTacVienId);

	/**
	 * Deletes the cong tac vien from the database. Also notifies the appropriate model listeners.
	 *
	 * @param congTacVien the cong tac vien
	 * @return the cong tac vien that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public CongTacVien deleteCongTacVien(CongTacVien congTacVien);

	/**
	 * Deletes the cong tac vien with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param congTacVienId the primary key of the cong tac vien
	 * @return the cong tac vien that was removed
	 * @throws PortalException if a cong tac vien with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public CongTacVien deleteCongTacVien(long congTacVienId)
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.CongTacVienModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.CongTacVienModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public CongTacVien fetchByMa(String ma) throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CongTacVien fetchBySoCMND(String soCMND) throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CongTacVien fetchCongTacVien(long congTacVienId);

	public List<CongTacVien> findBase(
			String ma, String hoTen, String soCMND, String diaChi, int hoatDong,
			int start, int end, OrderByComparator obc)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns the cong tac vien with the primary key.
	 *
	 * @param congTacVienId the primary key of the cong tac vien
	 * @return the cong tac vien
	 * @throws PortalException if a cong tac vien with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CongTacVien getCongTacVien(long congTacVienId)
		throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CongTacVien> getCongTacViens(int start, int end);

	/**
	 * Returns the number of cong tac viens.
	 *
	 * @return the number of cong tac viens
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCongTacViensCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CongTacVien> getCTVPhatVayNgay(Date ngayTaoTu, Date ngayTaoDen)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CongTacVien> getCTVSaoKe(
			long chiNhanhId, String maCTV, Date ngayTaoTu)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CongTacVien> getCTVSaoKePhanTrang(
			long chiNhanhId, String maCTV, Date ngayTaoTu, int start, int end)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CongTacVien> getCTVThuPhatChi(
			String maCTV, Date ngayTaoTu, Date ngayTaoDen)
		throws SystemException;

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
	 * Updates the cong tac vien in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param congTacVien the cong tac vien
	 * @return the cong tac vien that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public CongTacVien updateCongTacVien(CongTacVien congTacVien);

	public CongTacVien updateCongTacVien(
			CongTacVien congTacVien, ServiceContext serviceContext)
		throws PortalException, SystemException, TrungMaException,
			   TrungSoCMNDException;

}