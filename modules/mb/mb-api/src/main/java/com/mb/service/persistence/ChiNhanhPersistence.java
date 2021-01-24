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

import com.mb.exception.NoSuchChiNhanhException;
import com.mb.model.ChiNhanh;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the chi nhanh service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ChiNhanhUtil
 * @generated
 */
@ProviderType
public interface ChiNhanhPersistence extends BasePersistence<ChiNhanh> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ChiNhanhUtil} to access the chi nhanh persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, ChiNhanh> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns the chi nhanh where ma = &#63; or throws a <code>NoSuchChiNhanhException</code> if it could not be found.
	 *
	 * @param ma the ma
	 * @return the matching chi nhanh
	 * @throws NoSuchChiNhanhException if a matching chi nhanh could not be found
	 */
	public ChiNhanh findByMa(String ma) throws NoSuchChiNhanhException;

	/**
	 * Returns the chi nhanh where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ma the ma
	 * @return the matching chi nhanh, or <code>null</code> if a matching chi nhanh could not be found
	 */
	public ChiNhanh fetchByMa(String ma);

	/**
	 * Returns the chi nhanh where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ma the ma
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching chi nhanh, or <code>null</code> if a matching chi nhanh could not be found
	 */
	public ChiNhanh fetchByMa(String ma, boolean retrieveFromCache);

	/**
	 * Removes the chi nhanh where ma = &#63; from the database.
	 *
	 * @param ma the ma
	 * @return the chi nhanh that was removed
	 */
	public ChiNhanh removeByMa(String ma) throws NoSuchChiNhanhException;

	/**
	 * Returns the number of chi nhanhs where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the number of matching chi nhanhs
	 */
	public int countByMa(String ma);

	/**
	 * Returns all the chi nhanhs where hoatDong = &#63;.
	 *
	 * @param hoatDong the hoat dong
	 * @return the matching chi nhanhs
	 */
	public java.util.List<ChiNhanh> findByHoatDong(Boolean hoatDong);

	/**
	 * Returns a range of all the chi nhanhs where hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ChiNhanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of chi nhanhs
	 * @param end the upper bound of the range of chi nhanhs (not inclusive)
	 * @return the range of matching chi nhanhs
	 */
	public java.util.List<ChiNhanh> findByHoatDong(
		Boolean hoatDong, int start, int end);

	/**
	 * Returns an ordered range of all the chi nhanhs where hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ChiNhanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of chi nhanhs
	 * @param end the upper bound of the range of chi nhanhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching chi nhanhs
	 */
	public java.util.List<ChiNhanh> findByHoatDong(
		Boolean hoatDong, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChiNhanh>
			orderByComparator);

	/**
	 * Returns an ordered range of all the chi nhanhs where hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ChiNhanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of chi nhanhs
	 * @param end the upper bound of the range of chi nhanhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching chi nhanhs
	 */
	public java.util.List<ChiNhanh> findByHoatDong(
		Boolean hoatDong, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChiNhanh>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first chi nhanh in the ordered set where hoatDong = &#63;.
	 *
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chi nhanh
	 * @throws NoSuchChiNhanhException if a matching chi nhanh could not be found
	 */
	public ChiNhanh findByHoatDong_First(
			Boolean hoatDong,
			com.liferay.portal.kernel.util.OrderByComparator<ChiNhanh>
				orderByComparator)
		throws NoSuchChiNhanhException;

	/**
	 * Returns the first chi nhanh in the ordered set where hoatDong = &#63;.
	 *
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chi nhanh, or <code>null</code> if a matching chi nhanh could not be found
	 */
	public ChiNhanh fetchByHoatDong_First(
		Boolean hoatDong,
		com.liferay.portal.kernel.util.OrderByComparator<ChiNhanh>
			orderByComparator);

	/**
	 * Returns the last chi nhanh in the ordered set where hoatDong = &#63;.
	 *
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chi nhanh
	 * @throws NoSuchChiNhanhException if a matching chi nhanh could not be found
	 */
	public ChiNhanh findByHoatDong_Last(
			Boolean hoatDong,
			com.liferay.portal.kernel.util.OrderByComparator<ChiNhanh>
				orderByComparator)
		throws NoSuchChiNhanhException;

	/**
	 * Returns the last chi nhanh in the ordered set where hoatDong = &#63;.
	 *
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chi nhanh, or <code>null</code> if a matching chi nhanh could not be found
	 */
	public ChiNhanh fetchByHoatDong_Last(
		Boolean hoatDong,
		com.liferay.portal.kernel.util.OrderByComparator<ChiNhanh>
			orderByComparator);

	/**
	 * Returns the chi nhanhs before and after the current chi nhanh in the ordered set where hoatDong = &#63;.
	 *
	 * @param chiNhanhId the primary key of the current chi nhanh
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next chi nhanh
	 * @throws NoSuchChiNhanhException if a chi nhanh with the primary key could not be found
	 */
	public ChiNhanh[] findByHoatDong_PrevAndNext(
			long chiNhanhId, Boolean hoatDong,
			com.liferay.portal.kernel.util.OrderByComparator<ChiNhanh>
				orderByComparator)
		throws NoSuchChiNhanhException;

	/**
	 * Removes all the chi nhanhs where hoatDong = &#63; from the database.
	 *
	 * @param hoatDong the hoat dong
	 */
	public void removeByHoatDong(Boolean hoatDong);

	/**
	 * Returns the number of chi nhanhs where hoatDong = &#63;.
	 *
	 * @param hoatDong the hoat dong
	 * @return the number of matching chi nhanhs
	 */
	public int countByHoatDong(Boolean hoatDong);

	/**
	 * Caches the chi nhanh in the entity cache if it is enabled.
	 *
	 * @param chiNhanh the chi nhanh
	 */
	public void cacheResult(ChiNhanh chiNhanh);

	/**
	 * Caches the chi nhanhs in the entity cache if it is enabled.
	 *
	 * @param chiNhanhs the chi nhanhs
	 */
	public void cacheResult(java.util.List<ChiNhanh> chiNhanhs);

	/**
	 * Creates a new chi nhanh with the primary key. Does not add the chi nhanh to the database.
	 *
	 * @param chiNhanhId the primary key for the new chi nhanh
	 * @return the new chi nhanh
	 */
	public ChiNhanh create(long chiNhanhId);

	/**
	 * Removes the chi nhanh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param chiNhanhId the primary key of the chi nhanh
	 * @return the chi nhanh that was removed
	 * @throws NoSuchChiNhanhException if a chi nhanh with the primary key could not be found
	 */
	public ChiNhanh remove(long chiNhanhId) throws NoSuchChiNhanhException;

	public ChiNhanh updateImpl(ChiNhanh chiNhanh);

	/**
	 * Returns the chi nhanh with the primary key or throws a <code>NoSuchChiNhanhException</code> if it could not be found.
	 *
	 * @param chiNhanhId the primary key of the chi nhanh
	 * @return the chi nhanh
	 * @throws NoSuchChiNhanhException if a chi nhanh with the primary key could not be found
	 */
	public ChiNhanh findByPrimaryKey(long chiNhanhId)
		throws NoSuchChiNhanhException;

	/**
	 * Returns the chi nhanh with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param chiNhanhId the primary key of the chi nhanh
	 * @return the chi nhanh, or <code>null</code> if a chi nhanh with the primary key could not be found
	 */
	public ChiNhanh fetchByPrimaryKey(long chiNhanhId);

	/**
	 * Returns all the chi nhanhs.
	 *
	 * @return the chi nhanhs
	 */
	public java.util.List<ChiNhanh> findAll();

	/**
	 * Returns a range of all the chi nhanhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ChiNhanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of chi nhanhs
	 * @param end the upper bound of the range of chi nhanhs (not inclusive)
	 * @return the range of chi nhanhs
	 */
	public java.util.List<ChiNhanh> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the chi nhanhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ChiNhanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of chi nhanhs
	 * @param end the upper bound of the range of chi nhanhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of chi nhanhs
	 */
	public java.util.List<ChiNhanh> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChiNhanh>
			orderByComparator);

	/**
	 * Returns an ordered range of all the chi nhanhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ChiNhanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of chi nhanhs
	 * @param end the upper bound of the range of chi nhanhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of chi nhanhs
	 */
	public java.util.List<ChiNhanh> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChiNhanh>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the chi nhanhs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of chi nhanhs.
	 *
	 * @return the number of chi nhanhs
	 */
	public int countAll();

}