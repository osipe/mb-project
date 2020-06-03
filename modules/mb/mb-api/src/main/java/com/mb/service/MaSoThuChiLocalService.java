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
import com.mb.model.MaSoThuChi;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for MaSoThuChi. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see MaSoThuChiLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface MaSoThuChiLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MaSoThuChiLocalServiceUtil} to access the ma so thu chi local service. Add custom service methods to <code>com.mb.service.impl.MaSoThuChiLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	 * Adds the ma so thu chi to the database. Also notifies the appropriate model listeners.
	 *
	 * @param maSoThuChi the ma so thu chi
	 * @return the ma so thu chi that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public MaSoThuChi addMaSoThuChi(MaSoThuChi maSoThuChi);

	public MaSoThuChi addMaSoThuChi(
			MaSoThuChi maSoThuChi, ServiceContext serviceContext)
		throws PortalException, SystemException, TrungMaException;

	public MaSoThuChi addOrUpdateMaSoThuChi(
			MaSoThuChi maSoThuChi, ServiceContext serviceContext)
		throws PortalException, SystemException, TrungMaException;

	public int countBase(String ma, String dienGiai, int loai, int hoatDong)
		throws SystemException;

	/**
	 * Creates a new ma so thu chi with the primary key. Does not add the ma so thu chi to the database.
	 *
	 * @param maSoThuChiId the primary key for the new ma so thu chi
	 * @return the new ma so thu chi
	 */
	@Transactional(enabled = false)
	public MaSoThuChi createMaSoThuChi(long maSoThuChiId);

	/**
	 * Deletes the ma so thu chi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param maSoThuChiId the primary key of the ma so thu chi
	 * @return the ma so thu chi that was removed
	 * @throws PortalException if a ma so thu chi with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public MaSoThuChi deleteMaSoThuChi(long maSoThuChiId)
		throws PortalException;

	/**
	 * Deletes the ma so thu chi from the database. Also notifies the appropriate model listeners.
	 *
	 * @param maSoThuChi the ma so thu chi
	 * @return the ma so thu chi that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public MaSoThuChi deleteMaSoThuChi(MaSoThuChi maSoThuChi);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.MaSoThuChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.MaSoThuChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public MaSoThuChi fetchByMa_Loai_HoatDong(
			String ma, int loai, boolean hoatDong)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MaSoThuChi fetchMaSoThuChi(long maSoThuChiId);

	public List<MaSoThuChi> findBase(
			String ma, String dienGiai, int loai, int hoatDong, int start,
			int end, OrderByComparator obc)
		throws SystemException;

	public List<MaSoThuChi> findByLoai_HoatDong(int loai, boolean hoatDong)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the ma so thu chi with the primary key.
	 *
	 * @param maSoThuChiId the primary key of the ma so thu chi
	 * @return the ma so thu chi
	 * @throws PortalException if a ma so thu chi with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MaSoThuChi getMaSoThuChi(long maSoThuChiId) throws PortalException;

	/**
	 * Returns a range of all the ma so thu chis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.mb.model.impl.MaSoThuChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ma so thu chis
	 * @param end the upper bound of the range of ma so thu chis (not inclusive)
	 * @return the range of ma so thu chis
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MaSoThuChi> getMaSoThuChis(int start, int end);

	/**
	 * Returns the number of ma so thu chis.
	 *
	 * @return the number of ma so thu chis
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getMaSoThuChisCount();

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
	 * Updates the ma so thu chi in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param maSoThuChi the ma so thu chi
	 * @return the ma so thu chi that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public MaSoThuChi updateMaSoThuChi(MaSoThuChi maSoThuChi);

	public MaSoThuChi updateMaSoThuChi(
			MaSoThuChi maSoThuChi, ServiceContext serviceContext)
		throws PortalException, SystemException, TrungMaException;

}