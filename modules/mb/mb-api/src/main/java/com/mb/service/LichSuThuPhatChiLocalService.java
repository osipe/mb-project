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

import com.mb.model.LichSuThuPhatChi;
import com.mb.model.PhatVay;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

/**
 * Provides the local service interface for LichSuThuPhatChi. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see LichSuThuPhatChiLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface LichSuThuPhatChiLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LichSuThuPhatChiLocalServiceUtil} to access the lich su thu phat chi local service. Add custom service methods to <code>com.mb.service.impl.LichSuThuPhatChiLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	 * Adds the lich su thu phat chi to the database. Also notifies the appropriate model listeners.
	 *
	 * @param lichSuThuPhatChi the lich su thu phat chi
	 * @return the lich su thu phat chi that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public LichSuThuPhatChi addLichSuThuPhatChi(
		LichSuThuPhatChi lichSuThuPhatChi);

	public LichSuThuPhatChi addLichSuThuPhatChi(
			LichSuThuPhatChi lichSuThuPhatChi, ServiceContext serviceContext)
		throws NoSuchUserException, SystemException;

	public LichSuThuPhatChi addOrUpdateLichSuThuPhatChi(
			LichSuThuPhatChi lichSuThuPhatChi, ServiceContext serviceContext)
		throws NoSuchUserException, SystemException;

	/**
	 * Creates a new lich su thu phat chi with the primary key. Does not add the lich su thu phat chi to the database.
	 *
	 * @param lichSuThuPhatChiId the primary key for the new lich su thu phat chi
	 * @return the new lich su thu phat chi
	 */
	@Transactional(enabled = false)
	public LichSuThuPhatChi createLichSuThuPhatChi(long lichSuThuPhatChiId);

	public void deleteByCTV_Loai_Createdate_NgayXuLy(
			String maCTV, int loai, Date ngayTaoTu, Date ngayTaoDen,
			Date ngayXuLyTu, Date ngayXuLyDen)
		throws SystemException;

	/**
	 * Deletes the lich su thu phat chi from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lichSuThuPhatChi the lich su thu phat chi
	 * @return the lich su thu phat chi that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public LichSuThuPhatChi deleteLichSuThuPhatChi(
		LichSuThuPhatChi lichSuThuPhatChi);

	/**
	 * Deletes the lich su thu phat chi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lichSuThuPhatChiId the primary key of the lich su thu phat chi
	 * @return the lich su thu phat chi that was removed
	 * @throws PortalException if a lich su thu phat chi with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public LichSuThuPhatChi deleteLichSuThuPhatChi(long lichSuThuPhatChiId)
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.LichSuThuPhatChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.LichSuThuPhatChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public LichSuThuPhatChi fetchLichSuThuPhatChi(long lichSuThuPhatChiId);

	public List<LichSuThuPhatChi> findByCTV_Loai_Createdate(
			String maCTV, int loai, Date ngayTaoTu, Date ngayTaoDen, int start,
			int end, OrderByComparator obc)
		throws SystemException;

	public List<LichSuThuPhatChi> findByCTV_Loai_Createdate_NgayXuLy(
			String maCTV, int loai, Date ngayTaoTu, Date ngayTaoDen,
			Date ngayXuLyTu, Date ngayXuLyDen, int start, int end,
			OrderByComparator obc)
		throws SystemException;

	public List<LichSuThuPhatChi> findByPhatVay_Createdate_Loai(
			long chiNhanhId, long phatVayId, Date ngayTaoTu, Date ngayTaoDen,
			String loai)
		throws SystemException;

	public List<LichSuThuPhatChi> findByPhatVayId_Loai(long phatVayId, int loai)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the lich su thu phat chi with the primary key.
	 *
	 * @param lichSuThuPhatChiId the primary key of the lich su thu phat chi
	 * @return the lich su thu phat chi
	 * @throws PortalException if a lich su thu phat chi with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public LichSuThuPhatChi getLichSuThuPhatChi(long lichSuThuPhatChiId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Object[]> getLichSuThuPhatChi_MaCTV_Createdate(
			String maCTV, Date createdate)
		throws SystemException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<LichSuThuPhatChi> getLichSuThuPhatChis(int start, int end);

	/**
	 * Returns the number of lich su thu phat chis.
	 *
	 * @return the number of lich su thu phat chis
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getLichSuThuPhatChisCount();

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

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PhatVay> getPhatVayByCTV_Loai_Createdate_NgayXuLy(
			String maCTV, int loai, Date ngayTaoTu, Date ngayTaoDen,
			Date ngayXuLyTu, Date ngayXuLyDen, int start, int end)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Double getSoTienVay_CTV_TAINGAY(
			long chiNhanhId, String maCTV, Date ngay)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Object[] getSumPhatVay_CTV_TAINGAY(
			long chiNhanhId, String maCTV, Date ngay, int loaiPV)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Object[] getTongLichSuTraTien_CTV_TAINGAY(
			long chiNhanhId, String maCTV, Date ngay, Date ngayXuLy, int loaiPV)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Object[] getTongLichSuTraTien_PhayVayId_ChiNhanhId_Loai(
			long phatVayId, long chiNhanhId, int loai)
		throws SystemException;

	public void removeByPhatVayId(long phatVayId) throws SystemException;

	public void removeByPhatVayId_Loai(long phatVayId, int loai)
		throws SystemException;

	/**
	 * Updates the lich su thu phat chi in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param lichSuThuPhatChi the lich su thu phat chi
	 * @return the lich su thu phat chi that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public LichSuThuPhatChi updateLichSuThuPhatChi(
		LichSuThuPhatChi lichSuThuPhatChi);

	public LichSuThuPhatChi updateLichSuThuPhatChi(
			LichSuThuPhatChi lichSuThuPhatChi, ServiceContext serviceContext)
		throws SystemException;

}