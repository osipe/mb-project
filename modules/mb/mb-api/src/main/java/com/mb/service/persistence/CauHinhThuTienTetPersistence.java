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

package com.mb.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.mb.exception.NoSuchCauHinhThuTienTetException;
import com.mb.model.CauHinhThuTienTet;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the cau hinh thu tien tet service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CauHinhThuTienTetUtil
 * @generated
 */
@ProviderType
public interface CauHinhThuTienTetPersistence
	extends BasePersistence<CauHinhThuTienTet> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CauHinhThuTienTetUtil} to access the cau hinh thu tien tet persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, CauHinhThuTienTet> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns the cau hinh thu tien tet where nam = &#63; or throws a <code>NoSuchCauHinhThuTienTetException</code> if it could not be found.
	 *
	 * @param nam the nam
	 * @return the matching cau hinh thu tien tet
	 * @throws NoSuchCauHinhThuTienTetException if a matching cau hinh thu tien tet could not be found
	 */
	public CauHinhThuTienTet findByNam(int nam)
		throws NoSuchCauHinhThuTienTetException;

	/**
	 * Returns the cau hinh thu tien tet where nam = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nam the nam
	 * @return the matching cau hinh thu tien tet, or <code>null</code> if a matching cau hinh thu tien tet could not be found
	 */
	public CauHinhThuTienTet fetchByNam(int nam);

	/**
	 * Returns the cau hinh thu tien tet where nam = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nam the nam
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching cau hinh thu tien tet, or <code>null</code> if a matching cau hinh thu tien tet could not be found
	 */
	public CauHinhThuTienTet fetchByNam(int nam, boolean retrieveFromCache);

	/**
	 * Removes the cau hinh thu tien tet where nam = &#63; from the database.
	 *
	 * @param nam the nam
	 * @return the cau hinh thu tien tet that was removed
	 */
	public CauHinhThuTienTet removeByNam(int nam)
		throws NoSuchCauHinhThuTienTetException;

	/**
	 * Returns the number of cau hinh thu tien tets where nam = &#63;.
	 *
	 * @param nam the nam
	 * @return the number of matching cau hinh thu tien tets
	 */
	public int countByNam(int nam);

	/**
	 * Caches the cau hinh thu tien tet in the entity cache if it is enabled.
	 *
	 * @param cauHinhThuTienTet the cau hinh thu tien tet
	 */
	public void cacheResult(CauHinhThuTienTet cauHinhThuTienTet);

	/**
	 * Caches the cau hinh thu tien tets in the entity cache if it is enabled.
	 *
	 * @param cauHinhThuTienTets the cau hinh thu tien tets
	 */
	public void cacheResult(
		java.util.List<CauHinhThuTienTet> cauHinhThuTienTets);

	/**
	 * Creates a new cau hinh thu tien tet with the primary key. Does not add the cau hinh thu tien tet to the database.
	 *
	 * @param cauHinhThuTienTetId the primary key for the new cau hinh thu tien tet
	 * @return the new cau hinh thu tien tet
	 */
	public CauHinhThuTienTet create(long cauHinhThuTienTetId);

	/**
	 * Removes the cau hinh thu tien tet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cauHinhThuTienTetId the primary key of the cau hinh thu tien tet
	 * @return the cau hinh thu tien tet that was removed
	 * @throws NoSuchCauHinhThuTienTetException if a cau hinh thu tien tet with the primary key could not be found
	 */
	public CauHinhThuTienTet remove(long cauHinhThuTienTetId)
		throws NoSuchCauHinhThuTienTetException;

	public CauHinhThuTienTet updateImpl(CauHinhThuTienTet cauHinhThuTienTet);

	/**
	 * Returns the cau hinh thu tien tet with the primary key or throws a <code>NoSuchCauHinhThuTienTetException</code> if it could not be found.
	 *
	 * @param cauHinhThuTienTetId the primary key of the cau hinh thu tien tet
	 * @return the cau hinh thu tien tet
	 * @throws NoSuchCauHinhThuTienTetException if a cau hinh thu tien tet with the primary key could not be found
	 */
	public CauHinhThuTienTet findByPrimaryKey(long cauHinhThuTienTetId)
		throws NoSuchCauHinhThuTienTetException;

	/**
	 * Returns the cau hinh thu tien tet with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cauHinhThuTienTetId the primary key of the cau hinh thu tien tet
	 * @return the cau hinh thu tien tet, or <code>null</code> if a cau hinh thu tien tet with the primary key could not be found
	 */
	public CauHinhThuTienTet fetchByPrimaryKey(long cauHinhThuTienTetId);

	/**
	 * Returns all the cau hinh thu tien tets.
	 *
	 * @return the cau hinh thu tien tets
	 */
	public java.util.List<CauHinhThuTienTet> findAll();

	/**
	 * Returns a range of all the cau hinh thu tien tets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CauHinhThuTienTetModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cau hinh thu tien tets
	 * @param end the upper bound of the range of cau hinh thu tien tets (not inclusive)
	 * @return the range of cau hinh thu tien tets
	 */
	public java.util.List<CauHinhThuTienTet> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the cau hinh thu tien tets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CauHinhThuTienTetModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cau hinh thu tien tets
	 * @param end the upper bound of the range of cau hinh thu tien tets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cau hinh thu tien tets
	 */
	public java.util.List<CauHinhThuTienTet> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CauHinhThuTienTet>
			orderByComparator);

	/**
	 * Returns an ordered range of all the cau hinh thu tien tets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CauHinhThuTienTetModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cau hinh thu tien tets
	 * @param end the upper bound of the range of cau hinh thu tien tets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of cau hinh thu tien tets
	 */
	public java.util.List<CauHinhThuTienTet> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CauHinhThuTienTet>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the cau hinh thu tien tets from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of cau hinh thu tien tets.
	 *
	 * @return the number of cau hinh thu tien tets
	 */
	public int countAll();

}