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
import com.mb.model.ChiNhanh;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for ChiNhanh. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see ChiNhanhLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface ChiNhanhLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ChiNhanhLocalServiceUtil} to access the chi nhanh local service. Add custom service methods to <code>com.mb.service.impl.ChiNhanhLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	 * Adds the chi nhanh to the database. Also notifies the appropriate model listeners.
	 *
	 * @param chiNhanh the chi nhanh
	 * @return the chi nhanh that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public ChiNhanh addChiNhanh(ChiNhanh chiNhanh);

	public ChiNhanh addChiNhanh(
			ChiNhanh chiNhanh, ServiceContext serviceContext)
		throws PortalException, SystemException, TrungMaException,
			   TrungSoCMNDException;

	public ChiNhanh addOrUpdateChiNhanh(
			ChiNhanh chiNhanh, ServiceContext serviceContext)
		throws PortalException, SystemException, TrungMaException,
			   TrungSoCMNDException;

	public int countBase(String ma, String ten, int hoatDong)
		throws SystemException;

	/**
	 * Creates a new chi nhanh with the primary key. Does not add the chi nhanh to the database.
	 *
	 * @param chiNhanhId the primary key for the new chi nhanh
	 * @return the new chi nhanh
	 */
	@Transactional(enabled = false)
	public ChiNhanh createChiNhanh(long chiNhanhId);

	/**
	 * Deletes the chi nhanh from the database. Also notifies the appropriate model listeners.
	 *
	 * @param chiNhanh the chi nhanh
	 * @return the chi nhanh that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public ChiNhanh deleteChiNhanh(ChiNhanh chiNhanh);

	/**
	 * Deletes the chi nhanh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param chiNhanhId the primary key of the chi nhanh
	 * @return the chi nhanh that was removed
	 * @throws PortalException if a chi nhanh with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public ChiNhanh deleteChiNhanh(long chiNhanhId) throws PortalException;

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.ChiNhanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.ChiNhanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public ChiNhanh fetchByMa(String ma) throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ChiNhanh fetchChiNhanh(long chiNhanhId);

	public List<ChiNhanh> findBase(
			String ma, String ten, int hoatDong, int start, int end,
			OrderByComparator obc)
		throws SystemException;

	public List<ChiNhanh> findByHoatDong(boolean hoatDong)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns the chi nhanh with the primary key.
	 *
	 * @param chiNhanhId the primary key of the chi nhanh
	 * @return the chi nhanh
	 * @throws PortalException if a chi nhanh with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ChiNhanh getChiNhanh(long chiNhanhId) throws PortalException;

	/**
	 * Returns a range of all the chi nhanhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.ChiNhanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of chi nhanhs
	 * @param end the upper bound of the range of chi nhanhs (not inclusive)
	 * @return the range of chi nhanhs
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ChiNhanh> getChiNhanhs(int start, int end);

	/**
	 * Returns the number of chi nhanhs.
	 *
	 * @return the number of chi nhanhs
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getChiNhanhsCount();

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
	 * Updates the chi nhanh in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param chiNhanh the chi nhanh
	 * @return the chi nhanh that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public ChiNhanh updateChiNhanh(ChiNhanh chiNhanh);

	public ChiNhanh updateChiNhanh(
			ChiNhanh chiNhanh, ServiceContext serviceContext)
		throws PortalException, SystemException, TrungMaException,
			   TrungSoCMNDException;

}