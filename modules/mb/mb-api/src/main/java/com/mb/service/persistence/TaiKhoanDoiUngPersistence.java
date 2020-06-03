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

import com.mb.exception.NoSuchTaiKhoanDoiUngException;
import com.mb.model.TaiKhoanDoiUng;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the tai khoan doi ung service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaiKhoanDoiUngUtil
 * @generated
 */
@ProviderType
public interface TaiKhoanDoiUngPersistence
	extends BasePersistence<TaiKhoanDoiUng> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TaiKhoanDoiUngUtil} to access the tai khoan doi ung persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, TaiKhoanDoiUng> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns the tai khoan doi ung where soHieu = &#63; or throws a <code>NoSuchTaiKhoanDoiUngException</code> if it could not be found.
	 *
	 * @param soHieu the so hieu
	 * @return the matching tai khoan doi ung
	 * @throws NoSuchTaiKhoanDoiUngException if a matching tai khoan doi ung could not be found
	 */
	public TaiKhoanDoiUng findBySoHieu(String soHieu)
		throws NoSuchTaiKhoanDoiUngException;

	/**
	 * Returns the tai khoan doi ung where soHieu = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param soHieu the so hieu
	 * @return the matching tai khoan doi ung, or <code>null</code> if a matching tai khoan doi ung could not be found
	 */
	public TaiKhoanDoiUng fetchBySoHieu(String soHieu);

	/**
	 * Returns the tai khoan doi ung where soHieu = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param soHieu the so hieu
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching tai khoan doi ung, or <code>null</code> if a matching tai khoan doi ung could not be found
	 */
	public TaiKhoanDoiUng fetchBySoHieu(
		String soHieu, boolean retrieveFromCache);

	/**
	 * Removes the tai khoan doi ung where soHieu = &#63; from the database.
	 *
	 * @param soHieu the so hieu
	 * @return the tai khoan doi ung that was removed
	 */
	public TaiKhoanDoiUng removeBySoHieu(String soHieu)
		throws NoSuchTaiKhoanDoiUngException;

	/**
	 * Returns the number of tai khoan doi ungs where soHieu = &#63;.
	 *
	 * @param soHieu the so hieu
	 * @return the number of matching tai khoan doi ungs
	 */
	public int countBySoHieu(String soHieu);

	/**
	 * Returns all the tai khoan doi ungs where hoatDong = &#63;.
	 *
	 * @param hoatDong the hoat dong
	 * @return the matching tai khoan doi ungs
	 */
	public java.util.List<TaiKhoanDoiUng> findByHoatDong(Boolean hoatDong);

	/**
	 * Returns a range of all the tai khoan doi ungs where hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaiKhoanDoiUngModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of tai khoan doi ungs
	 * @param end the upper bound of the range of tai khoan doi ungs (not inclusive)
	 * @return the range of matching tai khoan doi ungs
	 */
	public java.util.List<TaiKhoanDoiUng> findByHoatDong(
		Boolean hoatDong, int start, int end);

	/**
	 * Returns an ordered range of all the tai khoan doi ungs where hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaiKhoanDoiUngModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of tai khoan doi ungs
	 * @param end the upper bound of the range of tai khoan doi ungs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tai khoan doi ungs
	 */
	public java.util.List<TaiKhoanDoiUng> findByHoatDong(
		Boolean hoatDong, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaiKhoanDoiUng>
			orderByComparator);

	/**
	 * Returns an ordered range of all the tai khoan doi ungs where hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaiKhoanDoiUngModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of tai khoan doi ungs
	 * @param end the upper bound of the range of tai khoan doi ungs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching tai khoan doi ungs
	 */
	public java.util.List<TaiKhoanDoiUng> findByHoatDong(
		Boolean hoatDong, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaiKhoanDoiUng>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first tai khoan doi ung in the ordered set where hoatDong = &#63;.
	 *
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tai khoan doi ung
	 * @throws NoSuchTaiKhoanDoiUngException if a matching tai khoan doi ung could not be found
	 */
	public TaiKhoanDoiUng findByHoatDong_First(
			Boolean hoatDong,
			com.liferay.portal.kernel.util.OrderByComparator<TaiKhoanDoiUng>
				orderByComparator)
		throws NoSuchTaiKhoanDoiUngException;

	/**
	 * Returns the first tai khoan doi ung in the ordered set where hoatDong = &#63;.
	 *
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tai khoan doi ung, or <code>null</code> if a matching tai khoan doi ung could not be found
	 */
	public TaiKhoanDoiUng fetchByHoatDong_First(
		Boolean hoatDong,
		com.liferay.portal.kernel.util.OrderByComparator<TaiKhoanDoiUng>
			orderByComparator);

	/**
	 * Returns the last tai khoan doi ung in the ordered set where hoatDong = &#63;.
	 *
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tai khoan doi ung
	 * @throws NoSuchTaiKhoanDoiUngException if a matching tai khoan doi ung could not be found
	 */
	public TaiKhoanDoiUng findByHoatDong_Last(
			Boolean hoatDong,
			com.liferay.portal.kernel.util.OrderByComparator<TaiKhoanDoiUng>
				orderByComparator)
		throws NoSuchTaiKhoanDoiUngException;

	/**
	 * Returns the last tai khoan doi ung in the ordered set where hoatDong = &#63;.
	 *
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tai khoan doi ung, or <code>null</code> if a matching tai khoan doi ung could not be found
	 */
	public TaiKhoanDoiUng fetchByHoatDong_Last(
		Boolean hoatDong,
		com.liferay.portal.kernel.util.OrderByComparator<TaiKhoanDoiUng>
			orderByComparator);

	/**
	 * Returns the tai khoan doi ungs before and after the current tai khoan doi ung in the ordered set where hoatDong = &#63;.
	 *
	 * @param taiKhoanDoiUngId the primary key of the current tai khoan doi ung
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tai khoan doi ung
	 * @throws NoSuchTaiKhoanDoiUngException if a tai khoan doi ung with the primary key could not be found
	 */
	public TaiKhoanDoiUng[] findByHoatDong_PrevAndNext(
			long taiKhoanDoiUngId, Boolean hoatDong,
			com.liferay.portal.kernel.util.OrderByComparator<TaiKhoanDoiUng>
				orderByComparator)
		throws NoSuchTaiKhoanDoiUngException;

	/**
	 * Removes all the tai khoan doi ungs where hoatDong = &#63; from the database.
	 *
	 * @param hoatDong the hoat dong
	 */
	public void removeByHoatDong(Boolean hoatDong);

	/**
	 * Returns the number of tai khoan doi ungs where hoatDong = &#63;.
	 *
	 * @param hoatDong the hoat dong
	 * @return the number of matching tai khoan doi ungs
	 */
	public int countByHoatDong(Boolean hoatDong);

	/**
	 * Returns all the tai khoan doi ungs where taiKhoanDoiUngChaId = &#63; and hoatDong = &#63;.
	 *
	 * @param taiKhoanDoiUngChaId the tai khoan doi ung cha ID
	 * @param hoatDong the hoat dong
	 * @return the matching tai khoan doi ungs
	 */
	public java.util.List<TaiKhoanDoiUng> findByTaiKhoanDoiUngChaId_HoatDong(
		long taiKhoanDoiUngChaId, Boolean hoatDong);

	/**
	 * Returns a range of all the tai khoan doi ungs where taiKhoanDoiUngChaId = &#63; and hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaiKhoanDoiUngModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param taiKhoanDoiUngChaId the tai khoan doi ung cha ID
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of tai khoan doi ungs
	 * @param end the upper bound of the range of tai khoan doi ungs (not inclusive)
	 * @return the range of matching tai khoan doi ungs
	 */
	public java.util.List<TaiKhoanDoiUng> findByTaiKhoanDoiUngChaId_HoatDong(
		long taiKhoanDoiUngChaId, Boolean hoatDong, int start, int end);

	/**
	 * Returns an ordered range of all the tai khoan doi ungs where taiKhoanDoiUngChaId = &#63; and hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaiKhoanDoiUngModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param taiKhoanDoiUngChaId the tai khoan doi ung cha ID
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of tai khoan doi ungs
	 * @param end the upper bound of the range of tai khoan doi ungs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tai khoan doi ungs
	 */
	public java.util.List<TaiKhoanDoiUng> findByTaiKhoanDoiUngChaId_HoatDong(
		long taiKhoanDoiUngChaId, Boolean hoatDong, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaiKhoanDoiUng>
			orderByComparator);

	/**
	 * Returns an ordered range of all the tai khoan doi ungs where taiKhoanDoiUngChaId = &#63; and hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaiKhoanDoiUngModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param taiKhoanDoiUngChaId the tai khoan doi ung cha ID
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of tai khoan doi ungs
	 * @param end the upper bound of the range of tai khoan doi ungs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching tai khoan doi ungs
	 */
	public java.util.List<TaiKhoanDoiUng> findByTaiKhoanDoiUngChaId_HoatDong(
		long taiKhoanDoiUngChaId, Boolean hoatDong, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaiKhoanDoiUng>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first tai khoan doi ung in the ordered set where taiKhoanDoiUngChaId = &#63; and hoatDong = &#63;.
	 *
	 * @param taiKhoanDoiUngChaId the tai khoan doi ung cha ID
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tai khoan doi ung
	 * @throws NoSuchTaiKhoanDoiUngException if a matching tai khoan doi ung could not be found
	 */
	public TaiKhoanDoiUng findByTaiKhoanDoiUngChaId_HoatDong_First(
			long taiKhoanDoiUngChaId, Boolean hoatDong,
			com.liferay.portal.kernel.util.OrderByComparator<TaiKhoanDoiUng>
				orderByComparator)
		throws NoSuchTaiKhoanDoiUngException;

	/**
	 * Returns the first tai khoan doi ung in the ordered set where taiKhoanDoiUngChaId = &#63; and hoatDong = &#63;.
	 *
	 * @param taiKhoanDoiUngChaId the tai khoan doi ung cha ID
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tai khoan doi ung, or <code>null</code> if a matching tai khoan doi ung could not be found
	 */
	public TaiKhoanDoiUng fetchByTaiKhoanDoiUngChaId_HoatDong_First(
		long taiKhoanDoiUngChaId, Boolean hoatDong,
		com.liferay.portal.kernel.util.OrderByComparator<TaiKhoanDoiUng>
			orderByComparator);

	/**
	 * Returns the last tai khoan doi ung in the ordered set where taiKhoanDoiUngChaId = &#63; and hoatDong = &#63;.
	 *
	 * @param taiKhoanDoiUngChaId the tai khoan doi ung cha ID
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tai khoan doi ung
	 * @throws NoSuchTaiKhoanDoiUngException if a matching tai khoan doi ung could not be found
	 */
	public TaiKhoanDoiUng findByTaiKhoanDoiUngChaId_HoatDong_Last(
			long taiKhoanDoiUngChaId, Boolean hoatDong,
			com.liferay.portal.kernel.util.OrderByComparator<TaiKhoanDoiUng>
				orderByComparator)
		throws NoSuchTaiKhoanDoiUngException;

	/**
	 * Returns the last tai khoan doi ung in the ordered set where taiKhoanDoiUngChaId = &#63; and hoatDong = &#63;.
	 *
	 * @param taiKhoanDoiUngChaId the tai khoan doi ung cha ID
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tai khoan doi ung, or <code>null</code> if a matching tai khoan doi ung could not be found
	 */
	public TaiKhoanDoiUng fetchByTaiKhoanDoiUngChaId_HoatDong_Last(
		long taiKhoanDoiUngChaId, Boolean hoatDong,
		com.liferay.portal.kernel.util.OrderByComparator<TaiKhoanDoiUng>
			orderByComparator);

	/**
	 * Returns the tai khoan doi ungs before and after the current tai khoan doi ung in the ordered set where taiKhoanDoiUngChaId = &#63; and hoatDong = &#63;.
	 *
	 * @param taiKhoanDoiUngId the primary key of the current tai khoan doi ung
	 * @param taiKhoanDoiUngChaId the tai khoan doi ung cha ID
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tai khoan doi ung
	 * @throws NoSuchTaiKhoanDoiUngException if a tai khoan doi ung with the primary key could not be found
	 */
	public TaiKhoanDoiUng[] findByTaiKhoanDoiUngChaId_HoatDong_PrevAndNext(
			long taiKhoanDoiUngId, long taiKhoanDoiUngChaId, Boolean hoatDong,
			com.liferay.portal.kernel.util.OrderByComparator<TaiKhoanDoiUng>
				orderByComparator)
		throws NoSuchTaiKhoanDoiUngException;

	/**
	 * Removes all the tai khoan doi ungs where taiKhoanDoiUngChaId = &#63; and hoatDong = &#63; from the database.
	 *
	 * @param taiKhoanDoiUngChaId the tai khoan doi ung cha ID
	 * @param hoatDong the hoat dong
	 */
	public void removeByTaiKhoanDoiUngChaId_HoatDong(
		long taiKhoanDoiUngChaId, Boolean hoatDong);

	/**
	 * Returns the number of tai khoan doi ungs where taiKhoanDoiUngChaId = &#63; and hoatDong = &#63;.
	 *
	 * @param taiKhoanDoiUngChaId the tai khoan doi ung cha ID
	 * @param hoatDong the hoat dong
	 * @return the number of matching tai khoan doi ungs
	 */
	public int countByTaiKhoanDoiUngChaId_HoatDong(
		long taiKhoanDoiUngChaId, Boolean hoatDong);

	/**
	 * Caches the tai khoan doi ung in the entity cache if it is enabled.
	 *
	 * @param taiKhoanDoiUng the tai khoan doi ung
	 */
	public void cacheResult(TaiKhoanDoiUng taiKhoanDoiUng);

	/**
	 * Caches the tai khoan doi ungs in the entity cache if it is enabled.
	 *
	 * @param taiKhoanDoiUngs the tai khoan doi ungs
	 */
	public void cacheResult(java.util.List<TaiKhoanDoiUng> taiKhoanDoiUngs);

	/**
	 * Creates a new tai khoan doi ung with the primary key. Does not add the tai khoan doi ung to the database.
	 *
	 * @param taiKhoanDoiUngId the primary key for the new tai khoan doi ung
	 * @return the new tai khoan doi ung
	 */
	public TaiKhoanDoiUng create(long taiKhoanDoiUngId);

	/**
	 * Removes the tai khoan doi ung with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taiKhoanDoiUngId the primary key of the tai khoan doi ung
	 * @return the tai khoan doi ung that was removed
	 * @throws NoSuchTaiKhoanDoiUngException if a tai khoan doi ung with the primary key could not be found
	 */
	public TaiKhoanDoiUng remove(long taiKhoanDoiUngId)
		throws NoSuchTaiKhoanDoiUngException;

	public TaiKhoanDoiUng updateImpl(TaiKhoanDoiUng taiKhoanDoiUng);

	/**
	 * Returns the tai khoan doi ung with the primary key or throws a <code>NoSuchTaiKhoanDoiUngException</code> if it could not be found.
	 *
	 * @param taiKhoanDoiUngId the primary key of the tai khoan doi ung
	 * @return the tai khoan doi ung
	 * @throws NoSuchTaiKhoanDoiUngException if a tai khoan doi ung with the primary key could not be found
	 */
	public TaiKhoanDoiUng findByPrimaryKey(long taiKhoanDoiUngId)
		throws NoSuchTaiKhoanDoiUngException;

	/**
	 * Returns the tai khoan doi ung with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param taiKhoanDoiUngId the primary key of the tai khoan doi ung
	 * @return the tai khoan doi ung, or <code>null</code> if a tai khoan doi ung with the primary key could not be found
	 */
	public TaiKhoanDoiUng fetchByPrimaryKey(long taiKhoanDoiUngId);

	/**
	 * Returns all the tai khoan doi ungs.
	 *
	 * @return the tai khoan doi ungs
	 */
	public java.util.List<TaiKhoanDoiUng> findAll();

	/**
	 * Returns a range of all the tai khoan doi ungs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaiKhoanDoiUngModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tai khoan doi ungs
	 * @param end the upper bound of the range of tai khoan doi ungs (not inclusive)
	 * @return the range of tai khoan doi ungs
	 */
	public java.util.List<TaiKhoanDoiUng> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the tai khoan doi ungs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaiKhoanDoiUngModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tai khoan doi ungs
	 * @param end the upper bound of the range of tai khoan doi ungs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tai khoan doi ungs
	 */
	public java.util.List<TaiKhoanDoiUng> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaiKhoanDoiUng>
			orderByComparator);

	/**
	 * Returns an ordered range of all the tai khoan doi ungs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TaiKhoanDoiUngModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tai khoan doi ungs
	 * @param end the upper bound of the range of tai khoan doi ungs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of tai khoan doi ungs
	 */
	public java.util.List<TaiKhoanDoiUng> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaiKhoanDoiUng>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the tai khoan doi ungs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of tai khoan doi ungs.
	 *
	 * @return the number of tai khoan doi ungs
	 */
	public int countAll();

}