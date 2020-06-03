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

import com.mb.exception.NoSuchQuanLyMaSoException;
import com.mb.model.QuanLyMaSo;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the quan ly ma so service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuanLyMaSoUtil
 * @generated
 */
@ProviderType
public interface QuanLyMaSoPersistence extends BasePersistence<QuanLyMaSo> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link QuanLyMaSoUtil} to access the quan ly ma so persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, QuanLyMaSo> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns the quan ly ma so where key = &#63; or throws a <code>NoSuchQuanLyMaSoException</code> if it could not be found.
	 *
	 * @param key the key
	 * @return the matching quan ly ma so
	 * @throws NoSuchQuanLyMaSoException if a matching quan ly ma so could not be found
	 */
	public QuanLyMaSo findByKey(String key) throws NoSuchQuanLyMaSoException;

	/**
	 * Returns the quan ly ma so where key = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param key the key
	 * @return the matching quan ly ma so, or <code>null</code> if a matching quan ly ma so could not be found
	 */
	public QuanLyMaSo fetchByKey(String key);

	/**
	 * Returns the quan ly ma so where key = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param key the key
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching quan ly ma so, or <code>null</code> if a matching quan ly ma so could not be found
	 */
	public QuanLyMaSo fetchByKey(String key, boolean retrieveFromCache);

	/**
	 * Removes the quan ly ma so where key = &#63; from the database.
	 *
	 * @param key the key
	 * @return the quan ly ma so that was removed
	 */
	public QuanLyMaSo removeByKey(String key) throws NoSuchQuanLyMaSoException;

	/**
	 * Returns the number of quan ly ma sos where key = &#63;.
	 *
	 * @param key the key
	 * @return the number of matching quan ly ma sos
	 */
	public int countByKey(String key);

	/**
	 * Caches the quan ly ma so in the entity cache if it is enabled.
	 *
	 * @param quanLyMaSo the quan ly ma so
	 */
	public void cacheResult(QuanLyMaSo quanLyMaSo);

	/**
	 * Caches the quan ly ma sos in the entity cache if it is enabled.
	 *
	 * @param quanLyMaSos the quan ly ma sos
	 */
	public void cacheResult(java.util.List<QuanLyMaSo> quanLyMaSos);

	/**
	 * Creates a new quan ly ma so with the primary key. Does not add the quan ly ma so to the database.
	 *
	 * @param quanLyMaSoId the primary key for the new quan ly ma so
	 * @return the new quan ly ma so
	 */
	public QuanLyMaSo create(long quanLyMaSoId);

	/**
	 * Removes the quan ly ma so with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param quanLyMaSoId the primary key of the quan ly ma so
	 * @return the quan ly ma so that was removed
	 * @throws NoSuchQuanLyMaSoException if a quan ly ma so with the primary key could not be found
	 */
	public QuanLyMaSo remove(long quanLyMaSoId)
		throws NoSuchQuanLyMaSoException;

	public QuanLyMaSo updateImpl(QuanLyMaSo quanLyMaSo);

	/**
	 * Returns the quan ly ma so with the primary key or throws a <code>NoSuchQuanLyMaSoException</code> if it could not be found.
	 *
	 * @param quanLyMaSoId the primary key of the quan ly ma so
	 * @return the quan ly ma so
	 * @throws NoSuchQuanLyMaSoException if a quan ly ma so with the primary key could not be found
	 */
	public QuanLyMaSo findByPrimaryKey(long quanLyMaSoId)
		throws NoSuchQuanLyMaSoException;

	/**
	 * Returns the quan ly ma so with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param quanLyMaSoId the primary key of the quan ly ma so
	 * @return the quan ly ma so, or <code>null</code> if a quan ly ma so with the primary key could not be found
	 */
	public QuanLyMaSo fetchByPrimaryKey(long quanLyMaSoId);

	/**
	 * Returns all the quan ly ma sos.
	 *
	 * @return the quan ly ma sos
	 */
	public java.util.List<QuanLyMaSo> findAll();

	/**
	 * Returns a range of all the quan ly ma sos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QuanLyMaSoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of quan ly ma sos
	 * @param end the upper bound of the range of quan ly ma sos (not inclusive)
	 * @return the range of quan ly ma sos
	 */
	public java.util.List<QuanLyMaSo> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the quan ly ma sos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QuanLyMaSoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of quan ly ma sos
	 * @param end the upper bound of the range of quan ly ma sos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of quan ly ma sos
	 */
	public java.util.List<QuanLyMaSo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QuanLyMaSo>
			orderByComparator);

	/**
	 * Returns an ordered range of all the quan ly ma sos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QuanLyMaSoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of quan ly ma sos
	 * @param end the upper bound of the range of quan ly ma sos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of quan ly ma sos
	 */
	public java.util.List<QuanLyMaSo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QuanLyMaSo>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the quan ly ma sos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of quan ly ma sos.
	 *
	 * @return the number of quan ly ma sos
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}