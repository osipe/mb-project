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

import com.mb.exception.NoSuchLaiSuatException;
import com.mb.model.LaiSuat;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the lai suat service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LaiSuatUtil
 * @generated
 */
@ProviderType
public interface LaiSuatPersistence extends BasePersistence<LaiSuat> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LaiSuatUtil} to access the lai suat persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, LaiSuat> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns the lai suat where soTienVay = &#63; and thoiHan = &#63; or throws a <code>NoSuchLaiSuatException</code> if it could not be found.
	 *
	 * @param soTienVay the so tien vay
	 * @param thoiHan the thoi han
	 * @return the matching lai suat
	 * @throws NoSuchLaiSuatException if a matching lai suat could not be found
	 */
	public LaiSuat findBySoTienVay_ThoiHan(Double soTienVay, int thoiHan)
		throws NoSuchLaiSuatException;

	/**
	 * Returns the lai suat where soTienVay = &#63; and thoiHan = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param soTienVay the so tien vay
	 * @param thoiHan the thoi han
	 * @return the matching lai suat, or <code>null</code> if a matching lai suat could not be found
	 */
	public LaiSuat fetchBySoTienVay_ThoiHan(Double soTienVay, int thoiHan);

	/**
	 * Returns the lai suat where soTienVay = &#63; and thoiHan = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param soTienVay the so tien vay
	 * @param thoiHan the thoi han
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching lai suat, or <code>null</code> if a matching lai suat could not be found
	 */
	public LaiSuat fetchBySoTienVay_ThoiHan(
		Double soTienVay, int thoiHan, boolean retrieveFromCache);

	/**
	 * Removes the lai suat where soTienVay = &#63; and thoiHan = &#63; from the database.
	 *
	 * @param soTienVay the so tien vay
	 * @param thoiHan the thoi han
	 * @return the lai suat that was removed
	 */
	public LaiSuat removeBySoTienVay_ThoiHan(Double soTienVay, int thoiHan)
		throws NoSuchLaiSuatException;

	/**
	 * Returns the number of lai suats where soTienVay = &#63; and thoiHan = &#63;.
	 *
	 * @param soTienVay the so tien vay
	 * @param thoiHan the thoi han
	 * @return the number of matching lai suats
	 */
	public int countBySoTienVay_ThoiHan(Double soTienVay, int thoiHan);

	/**
	 * Caches the lai suat in the entity cache if it is enabled.
	 *
	 * @param laiSuat the lai suat
	 */
	public void cacheResult(LaiSuat laiSuat);

	/**
	 * Caches the lai suats in the entity cache if it is enabled.
	 *
	 * @param laiSuats the lai suats
	 */
	public void cacheResult(java.util.List<LaiSuat> laiSuats);

	/**
	 * Creates a new lai suat with the primary key. Does not add the lai suat to the database.
	 *
	 * @param laiSuatId the primary key for the new lai suat
	 * @return the new lai suat
	 */
	public LaiSuat create(long laiSuatId);

	/**
	 * Removes the lai suat with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param laiSuatId the primary key of the lai suat
	 * @return the lai suat that was removed
	 * @throws NoSuchLaiSuatException if a lai suat with the primary key could not be found
	 */
	public LaiSuat remove(long laiSuatId) throws NoSuchLaiSuatException;

	public LaiSuat updateImpl(LaiSuat laiSuat);

	/**
	 * Returns the lai suat with the primary key or throws a <code>NoSuchLaiSuatException</code> if it could not be found.
	 *
	 * @param laiSuatId the primary key of the lai suat
	 * @return the lai suat
	 * @throws NoSuchLaiSuatException if a lai suat with the primary key could not be found
	 */
	public LaiSuat findByPrimaryKey(long laiSuatId)
		throws NoSuchLaiSuatException;

	/**
	 * Returns the lai suat with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param laiSuatId the primary key of the lai suat
	 * @return the lai suat, or <code>null</code> if a lai suat with the primary key could not be found
	 */
	public LaiSuat fetchByPrimaryKey(long laiSuatId);

	/**
	 * Returns all the lai suats.
	 *
	 * @return the lai suats
	 */
	public java.util.List<LaiSuat> findAll();

	/**
	 * Returns a range of all the lai suats.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LaiSuatModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lai suats
	 * @param end the upper bound of the range of lai suats (not inclusive)
	 * @return the range of lai suats
	 */
	public java.util.List<LaiSuat> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the lai suats.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LaiSuatModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lai suats
	 * @param end the upper bound of the range of lai suats (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lai suats
	 */
	public java.util.List<LaiSuat> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LaiSuat>
			orderByComparator);

	/**
	 * Returns an ordered range of all the lai suats.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LaiSuatModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lai suats
	 * @param end the upper bound of the range of lai suats (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of lai suats
	 */
	public java.util.List<LaiSuat> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LaiSuat>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the lai suats from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of lai suats.
	 *
	 * @return the number of lai suats
	 */
	public int countAll();

}