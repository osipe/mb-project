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

import com.mb.exception.NoSuchTaiSanThueChapException;
import com.mb.model.TaiSanThueChap;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the tai san thue chap service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaiSanThueChapUtil
 * @generated
 */
@ProviderType
public interface TaiSanThueChapPersistence
	extends BasePersistence<TaiSanThueChap> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TaiSanThueChapUtil} to access the tai san thue chap persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, TaiSanThueChap> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the tai san thue chaps where phatVayId = &#63;.
	 *
	 * @param phatVayId the phat vay ID
	 * @return the matching tai san thue chaps
	 */
	public java.util.List<TaiSanThueChap> findByPhatVayId(long phatVayId);

	/**
	 * Returns a range of all the tai san thue chaps where phatVayId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaiSanThueChapModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phatVayId the phat vay ID
	 * @param start the lower bound of the range of tai san thue chaps
	 * @param end the upper bound of the range of tai san thue chaps (not inclusive)
	 * @return the range of matching tai san thue chaps
	 */
	public java.util.List<TaiSanThueChap> findByPhatVayId(
		long phatVayId, int start, int end);

	/**
	 * Returns an ordered range of all the tai san thue chaps where phatVayId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaiSanThueChapModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phatVayId the phat vay ID
	 * @param start the lower bound of the range of tai san thue chaps
	 * @param end the upper bound of the range of tai san thue chaps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tai san thue chaps
	 */
	public java.util.List<TaiSanThueChap> findByPhatVayId(
		long phatVayId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaiSanThueChap>
			orderByComparator);

	/**
	 * Returns an ordered range of all the tai san thue chaps where phatVayId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaiSanThueChapModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phatVayId the phat vay ID
	 * @param start the lower bound of the range of tai san thue chaps
	 * @param end the upper bound of the range of tai san thue chaps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching tai san thue chaps
	 */
	public java.util.List<TaiSanThueChap> findByPhatVayId(
		long phatVayId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaiSanThueChap>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first tai san thue chap in the ordered set where phatVayId = &#63;.
	 *
	 * @param phatVayId the phat vay ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tai san thue chap
	 * @throws NoSuchTaiSanThueChapException if a matching tai san thue chap could not be found
	 */
	public TaiSanThueChap findByPhatVayId_First(
			long phatVayId,
			com.liferay.portal.kernel.util.OrderByComparator<TaiSanThueChap>
				orderByComparator)
		throws NoSuchTaiSanThueChapException;

	/**
	 * Returns the first tai san thue chap in the ordered set where phatVayId = &#63;.
	 *
	 * @param phatVayId the phat vay ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tai san thue chap, or <code>null</code> if a matching tai san thue chap could not be found
	 */
	public TaiSanThueChap fetchByPhatVayId_First(
		long phatVayId,
		com.liferay.portal.kernel.util.OrderByComparator<TaiSanThueChap>
			orderByComparator);

	/**
	 * Returns the last tai san thue chap in the ordered set where phatVayId = &#63;.
	 *
	 * @param phatVayId the phat vay ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tai san thue chap
	 * @throws NoSuchTaiSanThueChapException if a matching tai san thue chap could not be found
	 */
	public TaiSanThueChap findByPhatVayId_Last(
			long phatVayId,
			com.liferay.portal.kernel.util.OrderByComparator<TaiSanThueChap>
				orderByComparator)
		throws NoSuchTaiSanThueChapException;

	/**
	 * Returns the last tai san thue chap in the ordered set where phatVayId = &#63;.
	 *
	 * @param phatVayId the phat vay ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tai san thue chap, or <code>null</code> if a matching tai san thue chap could not be found
	 */
	public TaiSanThueChap fetchByPhatVayId_Last(
		long phatVayId,
		com.liferay.portal.kernel.util.OrderByComparator<TaiSanThueChap>
			orderByComparator);

	/**
	 * Returns the tai san thue chaps before and after the current tai san thue chap in the ordered set where phatVayId = &#63;.
	 *
	 * @param taiSanThueChapId the primary key of the current tai san thue chap
	 * @param phatVayId the phat vay ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tai san thue chap
	 * @throws NoSuchTaiSanThueChapException if a tai san thue chap with the primary key could not be found
	 */
	public TaiSanThueChap[] findByPhatVayId_PrevAndNext(
			long taiSanThueChapId, long phatVayId,
			com.liferay.portal.kernel.util.OrderByComparator<TaiSanThueChap>
				orderByComparator)
		throws NoSuchTaiSanThueChapException;

	/**
	 * Removes all the tai san thue chaps where phatVayId = &#63; from the database.
	 *
	 * @param phatVayId the phat vay ID
	 */
	public void removeByPhatVayId(long phatVayId);

	/**
	 * Returns the number of tai san thue chaps where phatVayId = &#63;.
	 *
	 * @param phatVayId the phat vay ID
	 * @return the number of matching tai san thue chaps
	 */
	public int countByPhatVayId(long phatVayId);

	/**
	 * Caches the tai san thue chap in the entity cache if it is enabled.
	 *
	 * @param taiSanThueChap the tai san thue chap
	 */
	public void cacheResult(TaiSanThueChap taiSanThueChap);

	/**
	 * Caches the tai san thue chaps in the entity cache if it is enabled.
	 *
	 * @param taiSanThueChaps the tai san thue chaps
	 */
	public void cacheResult(java.util.List<TaiSanThueChap> taiSanThueChaps);

	/**
	 * Creates a new tai san thue chap with the primary key. Does not add the tai san thue chap to the database.
	 *
	 * @param taiSanThueChapId the primary key for the new tai san thue chap
	 * @return the new tai san thue chap
	 */
	public TaiSanThueChap create(long taiSanThueChapId);

	/**
	 * Removes the tai san thue chap with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taiSanThueChapId the primary key of the tai san thue chap
	 * @return the tai san thue chap that was removed
	 * @throws NoSuchTaiSanThueChapException if a tai san thue chap with the primary key could not be found
	 */
	public TaiSanThueChap remove(long taiSanThueChapId)
		throws NoSuchTaiSanThueChapException;

	public TaiSanThueChap updateImpl(TaiSanThueChap taiSanThueChap);

	/**
	 * Returns the tai san thue chap with the primary key or throws a <code>NoSuchTaiSanThueChapException</code> if it could not be found.
	 *
	 * @param taiSanThueChapId the primary key of the tai san thue chap
	 * @return the tai san thue chap
	 * @throws NoSuchTaiSanThueChapException if a tai san thue chap with the primary key could not be found
	 */
	public TaiSanThueChap findByPrimaryKey(long taiSanThueChapId)
		throws NoSuchTaiSanThueChapException;

	/**
	 * Returns the tai san thue chap with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param taiSanThueChapId the primary key of the tai san thue chap
	 * @return the tai san thue chap, or <code>null</code> if a tai san thue chap with the primary key could not be found
	 */
	public TaiSanThueChap fetchByPrimaryKey(long taiSanThueChapId);

	/**
	 * Returns all the tai san thue chaps.
	 *
	 * @return the tai san thue chaps
	 */
	public java.util.List<TaiSanThueChap> findAll();

	/**
	 * Returns a range of all the tai san thue chaps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaiSanThueChapModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tai san thue chaps
	 * @param end the upper bound of the range of tai san thue chaps (not inclusive)
	 * @return the range of tai san thue chaps
	 */
	public java.util.List<TaiSanThueChap> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the tai san thue chaps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaiSanThueChapModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tai san thue chaps
	 * @param end the upper bound of the range of tai san thue chaps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tai san thue chaps
	 */
	public java.util.List<TaiSanThueChap> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaiSanThueChap>
			orderByComparator);

	/**
	 * Returns an ordered range of all the tai san thue chaps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaiSanThueChapModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tai san thue chaps
	 * @param end the upper bound of the range of tai san thue chaps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of tai san thue chaps
	 */
	public java.util.List<TaiSanThueChap> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaiSanThueChap>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the tai san thue chaps from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of tai san thue chaps.
	 *
	 * @return the number of tai san thue chaps
	 */
	public int countAll();

}