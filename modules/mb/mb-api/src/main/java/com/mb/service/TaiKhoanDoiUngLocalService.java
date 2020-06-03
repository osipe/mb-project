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

import com.mb.exception.TrungSoHieuException;
import com.mb.model.TaiKhoanDoiUng;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for TaiKhoanDoiUng. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see TaiKhoanDoiUngLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface TaiKhoanDoiUngLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TaiKhoanDoiUngLocalServiceUtil} to access the tai khoan doi ung local service. Add custom service methods to <code>com.mb.service.impl.TaiKhoanDoiUngLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public TaiKhoanDoiUng addOrUpdateCongTacVien(
			TaiKhoanDoiUng taiKhoanDoiUng, ServiceContext serviceContext)
		throws PortalException, SystemException, TrungSoHieuException;

	/**
	 * Adds the tai khoan doi ung to the database. Also notifies the appropriate model listeners.
	 *
	 * @param taiKhoanDoiUng the tai khoan doi ung
	 * @return the tai khoan doi ung that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public TaiKhoanDoiUng addTaiKhoanDoiUng(TaiKhoanDoiUng taiKhoanDoiUng);

	public TaiKhoanDoiUng addTaiKhoanDoiUng(
			TaiKhoanDoiUng taiKhoanDoiUng, ServiceContext serviceContext)
		throws PortalException, SystemException, TrungSoHieuException;

	public int countBase(
			long taiKhoanDoiUngChaId, String soHieu, String ten, int hoatDong)
		throws SystemException;

	/**
	 * Creates a new tai khoan doi ung with the primary key. Does not add the tai khoan doi ung to the database.
	 *
	 * @param taiKhoanDoiUngId the primary key for the new tai khoan doi ung
	 * @return the new tai khoan doi ung
	 */
	@Transactional(enabled = false)
	public TaiKhoanDoiUng createTaiKhoanDoiUng(long taiKhoanDoiUngId);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the tai khoan doi ung with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taiKhoanDoiUngId the primary key of the tai khoan doi ung
	 * @return the tai khoan doi ung that was removed
	 * @throws PortalException if a tai khoan doi ung with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public TaiKhoanDoiUng deleteTaiKhoanDoiUng(long taiKhoanDoiUngId)
		throws PortalException;

	/**
	 * Deletes the tai khoan doi ung from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taiKhoanDoiUng the tai khoan doi ung
	 * @return the tai khoan doi ung that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public TaiKhoanDoiUng deleteTaiKhoanDoiUng(TaiKhoanDoiUng taiKhoanDoiUng);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.TaiKhoanDoiUngModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.TaiKhoanDoiUngModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public TaiKhoanDoiUng fetchBySoHieu(String soHieu) throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TaiKhoanDoiUng fetchTaiKhoanDoiUng(long taiKhoanDoiUngId);

	public List<TaiKhoanDoiUng> findBase(
			long taiKhoanDoiUngChaId, String soHieu, String ten, int hoatDong,
			int start, int end, OrderByComparator obc)
		throws SystemException;

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
	 * Returns the tai khoan doi ung with the primary key.
	 *
	 * @param taiKhoanDoiUngId the primary key of the tai khoan doi ung
	 * @return the tai khoan doi ung
	 * @throws PortalException if a tai khoan doi ung with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TaiKhoanDoiUng getTaiKhoanDoiUng(long taiKhoanDoiUngId)
		throws PortalException;

	/**
	 * Returns a range of all the tai khoan doi ungs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.TaiKhoanDoiUngModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tai khoan doi ungs
	 * @param end the upper bound of the range of tai khoan doi ungs (not inclusive)
	 * @return the range of tai khoan doi ungs
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TaiKhoanDoiUng> getTaiKhoanDoiUngs(int start, int end);

	/**
	 * Returns the number of tai khoan doi ungs.
	 *
	 * @return the number of tai khoan doi ungs
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTaiKhoanDoiUngsCount();

	/**
	 * Updates the tai khoan doi ung in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param taiKhoanDoiUng the tai khoan doi ung
	 * @return the tai khoan doi ung that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public TaiKhoanDoiUng updateTaiKhoanDoiUng(TaiKhoanDoiUng taiKhoanDoiUng);

	public TaiKhoanDoiUng updateTaiKhoanDoiUng(
			TaiKhoanDoiUng taiKhoanDoiUng, ServiceContext serviceContext)
		throws PortalException, SystemException, TrungSoHieuException;

}