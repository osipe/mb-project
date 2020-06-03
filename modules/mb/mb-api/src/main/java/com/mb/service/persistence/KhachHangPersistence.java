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

import com.mb.exception.NoSuchKhachHangException;
import com.mb.model.KhachHang;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the khach hang service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KhachHangUtil
 * @generated
 */
@ProviderType
public interface KhachHangPersistence extends BasePersistence<KhachHang> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link KhachHangUtil} to access the khach hang persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, KhachHang> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns the khach hang where ma = &#63; or throws a <code>NoSuchKhachHangException</code> if it could not be found.
	 *
	 * @param ma the ma
	 * @return the matching khach hang
	 * @throws NoSuchKhachHangException if a matching khach hang could not be found
	 */
	public KhachHang findByMa(String ma) throws NoSuchKhachHangException;

	/**
	 * Returns the khach hang where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ma the ma
	 * @return the matching khach hang, or <code>null</code> if a matching khach hang could not be found
	 */
	public KhachHang fetchByMa(String ma);

	/**
	 * Returns the khach hang where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ma the ma
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching khach hang, or <code>null</code> if a matching khach hang could not be found
	 */
	public KhachHang fetchByMa(String ma, boolean retrieveFromCache);

	/**
	 * Removes the khach hang where ma = &#63; from the database.
	 *
	 * @param ma the ma
	 * @return the khach hang that was removed
	 */
	public KhachHang removeByMa(String ma) throws NoSuchKhachHangException;

	/**
	 * Returns the number of khach hangs where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the number of matching khach hangs
	 */
	public int countByMa(String ma);

	/**
	 * Returns all the khach hangs where maCTV = &#63;.
	 *
	 * @param maCTV the ma ctv
	 * @return the matching khach hangs
	 */
	public java.util.List<KhachHang> findByMaCTV(String maCTV);

	/**
	 * Returns a range of all the khach hangs where maCTV = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>KhachHangModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param maCTV the ma ctv
	 * @param start the lower bound of the range of khach hangs
	 * @param end the upper bound of the range of khach hangs (not inclusive)
	 * @return the range of matching khach hangs
	 */
	public java.util.List<KhachHang> findByMaCTV(
		String maCTV, int start, int end);

	/**
	 * Returns an ordered range of all the khach hangs where maCTV = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>KhachHangModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param maCTV the ma ctv
	 * @param start the lower bound of the range of khach hangs
	 * @param end the upper bound of the range of khach hangs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching khach hangs
	 */
	public java.util.List<KhachHang> findByMaCTV(
		String maCTV, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<KhachHang>
			orderByComparator);

	/**
	 * Returns an ordered range of all the khach hangs where maCTV = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>KhachHangModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param maCTV the ma ctv
	 * @param start the lower bound of the range of khach hangs
	 * @param end the upper bound of the range of khach hangs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching khach hangs
	 */
	public java.util.List<KhachHang> findByMaCTV(
		String maCTV, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<KhachHang>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first khach hang in the ordered set where maCTV = &#63;.
	 *
	 * @param maCTV the ma ctv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching khach hang
	 * @throws NoSuchKhachHangException if a matching khach hang could not be found
	 */
	public KhachHang findByMaCTV_First(
			String maCTV,
			com.liferay.portal.kernel.util.OrderByComparator<KhachHang>
				orderByComparator)
		throws NoSuchKhachHangException;

	/**
	 * Returns the first khach hang in the ordered set where maCTV = &#63;.
	 *
	 * @param maCTV the ma ctv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching khach hang, or <code>null</code> if a matching khach hang could not be found
	 */
	public KhachHang fetchByMaCTV_First(
		String maCTV,
		com.liferay.portal.kernel.util.OrderByComparator<KhachHang>
			orderByComparator);

	/**
	 * Returns the last khach hang in the ordered set where maCTV = &#63;.
	 *
	 * @param maCTV the ma ctv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching khach hang
	 * @throws NoSuchKhachHangException if a matching khach hang could not be found
	 */
	public KhachHang findByMaCTV_Last(
			String maCTV,
			com.liferay.portal.kernel.util.OrderByComparator<KhachHang>
				orderByComparator)
		throws NoSuchKhachHangException;

	/**
	 * Returns the last khach hang in the ordered set where maCTV = &#63;.
	 *
	 * @param maCTV the ma ctv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching khach hang, or <code>null</code> if a matching khach hang could not be found
	 */
	public KhachHang fetchByMaCTV_Last(
		String maCTV,
		com.liferay.portal.kernel.util.OrderByComparator<KhachHang>
			orderByComparator);

	/**
	 * Returns the khach hangs before and after the current khach hang in the ordered set where maCTV = &#63;.
	 *
	 * @param khachHangId the primary key of the current khach hang
	 * @param maCTV the ma ctv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next khach hang
	 * @throws NoSuchKhachHangException if a khach hang with the primary key could not be found
	 */
	public KhachHang[] findByMaCTV_PrevAndNext(
			long khachHangId, String maCTV,
			com.liferay.portal.kernel.util.OrderByComparator<KhachHang>
				orderByComparator)
		throws NoSuchKhachHangException;

	/**
	 * Removes all the khach hangs where maCTV = &#63; from the database.
	 *
	 * @param maCTV the ma ctv
	 */
	public void removeByMaCTV(String maCTV);

	/**
	 * Returns the number of khach hangs where maCTV = &#63;.
	 *
	 * @param maCTV the ma ctv
	 * @return the number of matching khach hangs
	 */
	public int countByMaCTV(String maCTV);

	/**
	 * Returns the khach hang where soCMND = &#63; or throws a <code>NoSuchKhachHangException</code> if it could not be found.
	 *
	 * @param soCMND the so cmnd
	 * @return the matching khach hang
	 * @throws NoSuchKhachHangException if a matching khach hang could not be found
	 */
	public KhachHang findBySoCMND(String soCMND)
		throws NoSuchKhachHangException;

	/**
	 * Returns the khach hang where soCMND = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param soCMND the so cmnd
	 * @return the matching khach hang, or <code>null</code> if a matching khach hang could not be found
	 */
	public KhachHang fetchBySoCMND(String soCMND);

	/**
	 * Returns the khach hang where soCMND = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param soCMND the so cmnd
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching khach hang, or <code>null</code> if a matching khach hang could not be found
	 */
	public KhachHang fetchBySoCMND(String soCMND, boolean retrieveFromCache);

	/**
	 * Removes the khach hang where soCMND = &#63; from the database.
	 *
	 * @param soCMND the so cmnd
	 * @return the khach hang that was removed
	 */
	public KhachHang removeBySoCMND(String soCMND)
		throws NoSuchKhachHangException;

	/**
	 * Returns the number of khach hangs where soCMND = &#63;.
	 *
	 * @param soCMND the so cmnd
	 * @return the number of matching khach hangs
	 */
	public int countBySoCMND(String soCMND);

	/**
	 * Caches the khach hang in the entity cache if it is enabled.
	 *
	 * @param khachHang the khach hang
	 */
	public void cacheResult(KhachHang khachHang);

	/**
	 * Caches the khach hangs in the entity cache if it is enabled.
	 *
	 * @param khachHangs the khach hangs
	 */
	public void cacheResult(java.util.List<KhachHang> khachHangs);

	/**
	 * Creates a new khach hang with the primary key. Does not add the khach hang to the database.
	 *
	 * @param khachHangId the primary key for the new khach hang
	 * @return the new khach hang
	 */
	public KhachHang create(long khachHangId);

	/**
	 * Removes the khach hang with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param khachHangId the primary key of the khach hang
	 * @return the khach hang that was removed
	 * @throws NoSuchKhachHangException if a khach hang with the primary key could not be found
	 */
	public KhachHang remove(long khachHangId) throws NoSuchKhachHangException;

	public KhachHang updateImpl(KhachHang khachHang);

	/**
	 * Returns the khach hang with the primary key or throws a <code>NoSuchKhachHangException</code> if it could not be found.
	 *
	 * @param khachHangId the primary key of the khach hang
	 * @return the khach hang
	 * @throws NoSuchKhachHangException if a khach hang with the primary key could not be found
	 */
	public KhachHang findByPrimaryKey(long khachHangId)
		throws NoSuchKhachHangException;

	/**
	 * Returns the khach hang with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param khachHangId the primary key of the khach hang
	 * @return the khach hang, or <code>null</code> if a khach hang with the primary key could not be found
	 */
	public KhachHang fetchByPrimaryKey(long khachHangId);

	/**
	 * Returns all the khach hangs.
	 *
	 * @return the khach hangs
	 */
	public java.util.List<KhachHang> findAll();

	/**
	 * Returns a range of all the khach hangs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>KhachHangModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of khach hangs
	 * @param end the upper bound of the range of khach hangs (not inclusive)
	 * @return the range of khach hangs
	 */
	public java.util.List<KhachHang> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the khach hangs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>KhachHangModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of khach hangs
	 * @param end the upper bound of the range of khach hangs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of khach hangs
	 */
	public java.util.List<KhachHang> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<KhachHang>
			orderByComparator);

	/**
	 * Returns an ordered range of all the khach hangs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>KhachHangModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of khach hangs
	 * @param end the upper bound of the range of khach hangs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of khach hangs
	 */
	public java.util.List<KhachHang> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<KhachHang>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the khach hangs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of khach hangs.
	 *
	 * @return the number of khach hangs
	 */
	public int countAll();

}