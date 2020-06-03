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

import com.mb.exception.NoSuchMaSoTheoDoiException;
import com.mb.model.MaSoTheoDoi;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the ma so theo doi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MaSoTheoDoiUtil
 * @generated
 */
@ProviderType
public interface MaSoTheoDoiPersistence extends BasePersistence<MaSoTheoDoi> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MaSoTheoDoiUtil} to access the ma so theo doi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, MaSoTheoDoi> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns the ma so theo doi where ma = &#63; or throws a <code>NoSuchMaSoTheoDoiException</code> if it could not be found.
	 *
	 * @param ma the ma
	 * @return the matching ma so theo doi
	 * @throws NoSuchMaSoTheoDoiException if a matching ma so theo doi could not be found
	 */
	public MaSoTheoDoi findByMa(String ma) throws NoSuchMaSoTheoDoiException;

	/**
	 * Returns the ma so theo doi where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ma the ma
	 * @return the matching ma so theo doi, or <code>null</code> if a matching ma so theo doi could not be found
	 */
	public MaSoTheoDoi fetchByMa(String ma);

	/**
	 * Returns the ma so theo doi where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ma the ma
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching ma so theo doi, or <code>null</code> if a matching ma so theo doi could not be found
	 */
	public MaSoTheoDoi fetchByMa(String ma, boolean retrieveFromCache);

	/**
	 * Removes the ma so theo doi where ma = &#63; from the database.
	 *
	 * @param ma the ma
	 * @return the ma so theo doi that was removed
	 */
	public MaSoTheoDoi removeByMa(String ma) throws NoSuchMaSoTheoDoiException;

	/**
	 * Returns the number of ma so theo dois where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the number of matching ma so theo dois
	 */
	public int countByMa(String ma);

	/**
	 * Caches the ma so theo doi in the entity cache if it is enabled.
	 *
	 * @param maSoTheoDoi the ma so theo doi
	 */
	public void cacheResult(MaSoTheoDoi maSoTheoDoi);

	/**
	 * Caches the ma so theo dois in the entity cache if it is enabled.
	 *
	 * @param maSoTheoDois the ma so theo dois
	 */
	public void cacheResult(java.util.List<MaSoTheoDoi> maSoTheoDois);

	/**
	 * Creates a new ma so theo doi with the primary key. Does not add the ma so theo doi to the database.
	 *
	 * @param maSoTheoDoiId the primary key for the new ma so theo doi
	 * @return the new ma so theo doi
	 */
	public MaSoTheoDoi create(long maSoTheoDoiId);

	/**
	 * Removes the ma so theo doi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param maSoTheoDoiId the primary key of the ma so theo doi
	 * @return the ma so theo doi that was removed
	 * @throws NoSuchMaSoTheoDoiException if a ma so theo doi with the primary key could not be found
	 */
	public MaSoTheoDoi remove(long maSoTheoDoiId)
		throws NoSuchMaSoTheoDoiException;

	public MaSoTheoDoi updateImpl(MaSoTheoDoi maSoTheoDoi);

	/**
	 * Returns the ma so theo doi with the primary key or throws a <code>NoSuchMaSoTheoDoiException</code> if it could not be found.
	 *
	 * @param maSoTheoDoiId the primary key of the ma so theo doi
	 * @return the ma so theo doi
	 * @throws NoSuchMaSoTheoDoiException if a ma so theo doi with the primary key could not be found
	 */
	public MaSoTheoDoi findByPrimaryKey(long maSoTheoDoiId)
		throws NoSuchMaSoTheoDoiException;

	/**
	 * Returns the ma so theo doi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param maSoTheoDoiId the primary key of the ma so theo doi
	 * @return the ma so theo doi, or <code>null</code> if a ma so theo doi with the primary key could not be found
	 */
	public MaSoTheoDoi fetchByPrimaryKey(long maSoTheoDoiId);

	/**
	 * Returns all the ma so theo dois.
	 *
	 * @return the ma so theo dois
	 */
	public java.util.List<MaSoTheoDoi> findAll();

	/**
	 * Returns a range of all the ma so theo dois.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MaSoTheoDoiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ma so theo dois
	 * @param end the upper bound of the range of ma so theo dois (not inclusive)
	 * @return the range of ma so theo dois
	 */
	public java.util.List<MaSoTheoDoi> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the ma so theo dois.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MaSoTheoDoiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ma so theo dois
	 * @param end the upper bound of the range of ma so theo dois (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ma so theo dois
	 */
	public java.util.List<MaSoTheoDoi> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MaSoTheoDoi>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ma so theo dois.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MaSoTheoDoiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ma so theo dois
	 * @param end the upper bound of the range of ma so theo dois (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of ma so theo dois
	 */
	public java.util.List<MaSoTheoDoi> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MaSoTheoDoi>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the ma so theo dois from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of ma so theo dois.
	 *
	 * @return the number of ma so theo dois
	 */
	public int countAll();

}