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

import com.mb.exception.NoSuchPhieuException;
import com.mb.model.Phieu;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the phieu service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PhieuUtil
 * @generated
 */
@ProviderType
public interface PhieuPersistence extends BasePersistence<Phieu> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PhieuUtil} to access the phieu persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, Phieu> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Caches the phieu in the entity cache if it is enabled.
	 *
	 * @param phieu the phieu
	 */
	public void cacheResult(Phieu phieu);

	/**
	 * Caches the phieus in the entity cache if it is enabled.
	 *
	 * @param phieus the phieus
	 */
	public void cacheResult(java.util.List<Phieu> phieus);

	/**
	 * Creates a new phieu with the primary key. Does not add the phieu to the database.
	 *
	 * @param phieuId the primary key for the new phieu
	 * @return the new phieu
	 */
	public Phieu create(long phieuId);

	/**
	 * Removes the phieu with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param phieuId the primary key of the phieu
	 * @return the phieu that was removed
	 * @throws NoSuchPhieuException if a phieu with the primary key could not be found
	 */
	public Phieu remove(long phieuId) throws NoSuchPhieuException;

	public Phieu updateImpl(Phieu phieu);

	/**
	 * Returns the phieu with the primary key or throws a <code>NoSuchPhieuException</code> if it could not be found.
	 *
	 * @param phieuId the primary key of the phieu
	 * @return the phieu
	 * @throws NoSuchPhieuException if a phieu with the primary key could not be found
	 */
	public Phieu findByPrimaryKey(long phieuId) throws NoSuchPhieuException;

	/**
	 * Returns the phieu with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param phieuId the primary key of the phieu
	 * @return the phieu, or <code>null</code> if a phieu with the primary key could not be found
	 */
	public Phieu fetchByPrimaryKey(long phieuId);

	/**
	 * Returns all the phieus.
	 *
	 * @return the phieus
	 */
	public java.util.List<Phieu> findAll();

	/**
	 * Returns a range of all the phieus.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PhieuModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of phieus
	 * @param end the upper bound of the range of phieus (not inclusive)
	 * @return the range of phieus
	 */
	public java.util.List<Phieu> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the phieus.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PhieuModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of phieus
	 * @param end the upper bound of the range of phieus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of phieus
	 */
	public java.util.List<Phieu> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Phieu>
			orderByComparator);

	/**
	 * Returns an ordered range of all the phieus.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PhieuModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of phieus
	 * @param end the upper bound of the range of phieus (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of phieus
	 */
	public java.util.List<Phieu> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Phieu>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the phieus from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of phieus.
	 *
	 * @return the number of phieus
	 */
	public int countAll();

}