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

import com.mb.exception.NoSuchSoKheUocException;
import com.mb.model.SoKheUoc;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the so khe uoc service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SoKheUocUtil
 * @generated
 */
@ProviderType
public interface SoKheUocPersistence extends BasePersistence<SoKheUoc> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SoKheUocUtil} to access the so khe uoc persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, SoKheUoc> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns the so khe uoc where cauTruc = &#63; or throws a <code>NoSuchSoKheUocException</code> if it could not be found.
	 *
	 * @param cauTruc the cau truc
	 * @return the matching so khe uoc
	 * @throws NoSuchSoKheUocException if a matching so khe uoc could not be found
	 */
	public SoKheUoc findByCauTruc(String cauTruc)
		throws NoSuchSoKheUocException;

	/**
	 * Returns the so khe uoc where cauTruc = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param cauTruc the cau truc
	 * @return the matching so khe uoc, or <code>null</code> if a matching so khe uoc could not be found
	 */
	public SoKheUoc fetchByCauTruc(String cauTruc);

	/**
	 * Returns the so khe uoc where cauTruc = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param cauTruc the cau truc
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching so khe uoc, or <code>null</code> if a matching so khe uoc could not be found
	 */
	public SoKheUoc fetchByCauTruc(String cauTruc, boolean retrieveFromCache);

	/**
	 * Removes the so khe uoc where cauTruc = &#63; from the database.
	 *
	 * @param cauTruc the cau truc
	 * @return the so khe uoc that was removed
	 */
	public SoKheUoc removeByCauTruc(String cauTruc)
		throws NoSuchSoKheUocException;

	/**
	 * Returns the number of so khe uocs where cauTruc = &#63;.
	 *
	 * @param cauTruc the cau truc
	 * @return the number of matching so khe uocs
	 */
	public int countByCauTruc(String cauTruc);

	/**
	 * Caches the so khe uoc in the entity cache if it is enabled.
	 *
	 * @param soKheUoc the so khe uoc
	 */
	public void cacheResult(SoKheUoc soKheUoc);

	/**
	 * Caches the so khe uocs in the entity cache if it is enabled.
	 *
	 * @param soKheUocs the so khe uocs
	 */
	public void cacheResult(java.util.List<SoKheUoc> soKheUocs);

	/**
	 * Creates a new so khe uoc with the primary key. Does not add the so khe uoc to the database.
	 *
	 * @param soKheUocId the primary key for the new so khe uoc
	 * @return the new so khe uoc
	 */
	public SoKheUoc create(long soKheUocId);

	/**
	 * Removes the so khe uoc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param soKheUocId the primary key of the so khe uoc
	 * @return the so khe uoc that was removed
	 * @throws NoSuchSoKheUocException if a so khe uoc with the primary key could not be found
	 */
	public SoKheUoc remove(long soKheUocId) throws NoSuchSoKheUocException;

	public SoKheUoc updateImpl(SoKheUoc soKheUoc);

	/**
	 * Returns the so khe uoc with the primary key or throws a <code>NoSuchSoKheUocException</code> if it could not be found.
	 *
	 * @param soKheUocId the primary key of the so khe uoc
	 * @return the so khe uoc
	 * @throws NoSuchSoKheUocException if a so khe uoc with the primary key could not be found
	 */
	public SoKheUoc findByPrimaryKey(long soKheUocId)
		throws NoSuchSoKheUocException;

	/**
	 * Returns the so khe uoc with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param soKheUocId the primary key of the so khe uoc
	 * @return the so khe uoc, or <code>null</code> if a so khe uoc with the primary key could not be found
	 */
	public SoKheUoc fetchByPrimaryKey(long soKheUocId);

	/**
	 * Returns all the so khe uocs.
	 *
	 * @return the so khe uocs
	 */
	public java.util.List<SoKheUoc> findAll();

	/**
	 * Returns a range of all the so khe uocs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SoKheUocModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of so khe uocs
	 * @param end the upper bound of the range of so khe uocs (not inclusive)
	 * @return the range of so khe uocs
	 */
	public java.util.List<SoKheUoc> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the so khe uocs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SoKheUocModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of so khe uocs
	 * @param end the upper bound of the range of so khe uocs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of so khe uocs
	 */
	public java.util.List<SoKheUoc> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SoKheUoc>
			orderByComparator);

	/**
	 * Returns an ordered range of all the so khe uocs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SoKheUocModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of so khe uocs
	 * @param end the upper bound of the range of so khe uocs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of so khe uocs
	 */
	public java.util.List<SoKheUoc> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SoKheUoc>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the so khe uocs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of so khe uocs.
	 *
	 * @return the number of so khe uocs
	 */
	public int countAll();

}