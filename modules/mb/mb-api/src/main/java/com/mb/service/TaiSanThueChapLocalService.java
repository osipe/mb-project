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

import com.mb.model.PhatVay;
import com.mb.model.TaiSanThueChap;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for TaiSanThueChap. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see TaiSanThueChapLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface TaiSanThueChapLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TaiSanThueChapLocalServiceUtil} to access the tai san thue chap local service. Add custom service methods to <code>com.mb.service.impl.TaiSanThueChapLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public void addOrTaiSanThueChap(
			PhatVay phatVay, ServiceContext serviceContext)
		throws NoSuchUserException, SystemException;

	/**
	 * Adds the tai san thue chap to the database. Also notifies the appropriate model listeners.
	 *
	 * @param taiSanThueChap the tai san thue chap
	 * @return the tai san thue chap that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public TaiSanThueChap addTaiSanThueChap(TaiSanThueChap taiSanThueChap);

	public TaiSanThueChap addTaiSanThueChap(
			TaiSanThueChap taiSanThueChap, ServiceContext serviceContext)
		throws NoSuchUserException, SystemException;

	public int countBase(
			String soKU, String ten, String maKhachHang, long loaiTaiSanId)
		throws SystemException;

	/**
	 * Creates a new tai san thue chap with the primary key. Does not add the tai san thue chap to the database.
	 *
	 * @param taiSanThueChapId the primary key for the new tai san thue chap
	 * @return the new tai san thue chap
	 */
	@Transactional(enabled = false)
	public TaiSanThueChap createTaiSanThueChap(long taiSanThueChapId);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the tai san thue chap with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taiSanThueChapId the primary key of the tai san thue chap
	 * @return the tai san thue chap that was removed
	 * @throws PortalException if a tai san thue chap with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public TaiSanThueChap deleteTaiSanThueChap(long taiSanThueChapId)
		throws PortalException;

	/**
	 * Deletes the tai san thue chap from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taiSanThueChap the tai san thue chap
	 * @return the tai san thue chap that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public TaiSanThueChap deleteTaiSanThueChap(TaiSanThueChap taiSanThueChap);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.TaiSanThueChapModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.TaiSanThueChapModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public TaiSanThueChap fetchTaiSanThueChap(long taiSanThueChapId);

	public List<TaiSanThueChap> findBase(
			String soKU, String ten, String maKhachHang, long loaiTaiSanId,
			int start, int end, OrderByComparator obc)
		throws SystemException;

	public List<TaiSanThueChap> findByPhatVayId(long phatVayId)
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
	 * Returns the tai san thue chap with the primary key.
	 *
	 * @param taiSanThueChapId the primary key of the tai san thue chap
	 * @return the tai san thue chap
	 * @throws PortalException if a tai san thue chap with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TaiSanThueChap getTaiSanThueChap(long taiSanThueChapId)
		throws PortalException;

	/**
	 * Returns a range of all the tai san thue chaps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.TaiSanThueChapModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tai san thue chaps
	 * @param end the upper bound of the range of tai san thue chaps (not inclusive)
	 * @return the range of tai san thue chaps
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TaiSanThueChap> getTaiSanThueChaps(int start, int end);

	/**
	 * Returns the number of tai san thue chaps.
	 *
	 * @return the number of tai san thue chaps
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTaiSanThueChapsCount();

	public void removeByPhatVayId(long phatVayId) throws SystemException;

	/**
	 * Updates the tai san thue chap in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param taiSanThueChap the tai san thue chap
	 * @return the tai san thue chap that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public TaiSanThueChap updateTaiSanThueChap(TaiSanThueChap taiSanThueChap);

	public TaiSanThueChap updateTaiSanThueChap(
			TaiSanThueChap taiSanThueChap, ServiceContext serviceContext)
		throws SystemException;

}