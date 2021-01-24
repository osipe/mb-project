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

import com.mb.exception.NoSuchCongTacVienException;
import com.mb.model.CongTacVien;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the cong tac vien service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CongTacVienUtil
 * @generated
 */
@ProviderType
public interface CongTacVienPersistence extends BasePersistence<CongTacVien> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CongTacVienUtil} to access the cong tac vien persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, CongTacVien> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns the cong tac vien where ma = &#63; or throws a <code>NoSuchCongTacVienException</code> if it could not be found.
	 *
	 * @param ma the ma
	 * @return the matching cong tac vien
	 * @throws NoSuchCongTacVienException if a matching cong tac vien could not be found
	 */
	public CongTacVien findByMa(String ma) throws NoSuchCongTacVienException;

	/**
	 * Returns the cong tac vien where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ma the ma
	 * @return the matching cong tac vien, or <code>null</code> if a matching cong tac vien could not be found
	 */
	public CongTacVien fetchByMa(String ma);

	/**
	 * Returns the cong tac vien where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ma the ma
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching cong tac vien, or <code>null</code> if a matching cong tac vien could not be found
	 */
	public CongTacVien fetchByMa(String ma, boolean retrieveFromCache);

	/**
	 * Removes the cong tac vien where ma = &#63; from the database.
	 *
	 * @param ma the ma
	 * @return the cong tac vien that was removed
	 */
	public CongTacVien removeByMa(String ma) throws NoSuchCongTacVienException;

	/**
	 * Returns the number of cong tac viens where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the number of matching cong tac viens
	 */
	public int countByMa(String ma);

	/**
	 * Returns the cong tac vien where soCMND = &#63; or throws a <code>NoSuchCongTacVienException</code> if it could not be found.
	 *
	 * @param soCMND the so cmnd
	 * @return the matching cong tac vien
	 * @throws NoSuchCongTacVienException if a matching cong tac vien could not be found
	 */
	public CongTacVien findBySoCMND(String soCMND)
		throws NoSuchCongTacVienException;

	/**
	 * Returns the cong tac vien where soCMND = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param soCMND the so cmnd
	 * @return the matching cong tac vien, or <code>null</code> if a matching cong tac vien could not be found
	 */
	public CongTacVien fetchBySoCMND(String soCMND);

	/**
	 * Returns the cong tac vien where soCMND = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param soCMND the so cmnd
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching cong tac vien, or <code>null</code> if a matching cong tac vien could not be found
	 */
	public CongTacVien fetchBySoCMND(String soCMND, boolean retrieveFromCache);

	/**
	 * Removes the cong tac vien where soCMND = &#63; from the database.
	 *
	 * @param soCMND the so cmnd
	 * @return the cong tac vien that was removed
	 */
	public CongTacVien removeBySoCMND(String soCMND)
		throws NoSuchCongTacVienException;

	/**
	 * Returns the number of cong tac viens where soCMND = &#63;.
	 *
	 * @param soCMND the so cmnd
	 * @return the number of matching cong tac viens
	 */
	public int countBySoCMND(String soCMND);

	/**
	 * Returns all the cong tac viens where chiNhanhId = &#63; and hoatDong = &#63;.
	 *
	 * @param chiNhanhId the chi nhanh ID
	 * @param hoatDong the hoat dong
	 * @return the matching cong tac viens
	 */
	public java.util.List<CongTacVien> findByChiNhanh_HoatDong(
		long chiNhanhId, Boolean hoatDong);

	/**
	 * Returns a range of all the cong tac viens where chiNhanhId = &#63; and hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CongTacVienModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param chiNhanhId the chi nhanh ID
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of cong tac viens
	 * @param end the upper bound of the range of cong tac viens (not inclusive)
	 * @return the range of matching cong tac viens
	 */
	public java.util.List<CongTacVien> findByChiNhanh_HoatDong(
		long chiNhanhId, Boolean hoatDong, int start, int end);

	/**
	 * Returns an ordered range of all the cong tac viens where chiNhanhId = &#63; and hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CongTacVienModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param chiNhanhId the chi nhanh ID
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of cong tac viens
	 * @param end the upper bound of the range of cong tac viens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cong tac viens
	 */
	public java.util.List<CongTacVien> findByChiNhanh_HoatDong(
		long chiNhanhId, Boolean hoatDong, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CongTacVien>
			orderByComparator);

	/**
	 * Returns an ordered range of all the cong tac viens where chiNhanhId = &#63; and hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CongTacVienModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param chiNhanhId the chi nhanh ID
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of cong tac viens
	 * @param end the upper bound of the range of cong tac viens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching cong tac viens
	 */
	public java.util.List<CongTacVien> findByChiNhanh_HoatDong(
		long chiNhanhId, Boolean hoatDong, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CongTacVien>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first cong tac vien in the ordered set where chiNhanhId = &#63; and hoatDong = &#63;.
	 *
	 * @param chiNhanhId the chi nhanh ID
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cong tac vien
	 * @throws NoSuchCongTacVienException if a matching cong tac vien could not be found
	 */
	public CongTacVien findByChiNhanh_HoatDong_First(
			long chiNhanhId, Boolean hoatDong,
			com.liferay.portal.kernel.util.OrderByComparator<CongTacVien>
				orderByComparator)
		throws NoSuchCongTacVienException;

	/**
	 * Returns the first cong tac vien in the ordered set where chiNhanhId = &#63; and hoatDong = &#63;.
	 *
	 * @param chiNhanhId the chi nhanh ID
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cong tac vien, or <code>null</code> if a matching cong tac vien could not be found
	 */
	public CongTacVien fetchByChiNhanh_HoatDong_First(
		long chiNhanhId, Boolean hoatDong,
		com.liferay.portal.kernel.util.OrderByComparator<CongTacVien>
			orderByComparator);

	/**
	 * Returns the last cong tac vien in the ordered set where chiNhanhId = &#63; and hoatDong = &#63;.
	 *
	 * @param chiNhanhId the chi nhanh ID
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cong tac vien
	 * @throws NoSuchCongTacVienException if a matching cong tac vien could not be found
	 */
	public CongTacVien findByChiNhanh_HoatDong_Last(
			long chiNhanhId, Boolean hoatDong,
			com.liferay.portal.kernel.util.OrderByComparator<CongTacVien>
				orderByComparator)
		throws NoSuchCongTacVienException;

	/**
	 * Returns the last cong tac vien in the ordered set where chiNhanhId = &#63; and hoatDong = &#63;.
	 *
	 * @param chiNhanhId the chi nhanh ID
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cong tac vien, or <code>null</code> if a matching cong tac vien could not be found
	 */
	public CongTacVien fetchByChiNhanh_HoatDong_Last(
		long chiNhanhId, Boolean hoatDong,
		com.liferay.portal.kernel.util.OrderByComparator<CongTacVien>
			orderByComparator);

	/**
	 * Returns the cong tac viens before and after the current cong tac vien in the ordered set where chiNhanhId = &#63; and hoatDong = &#63;.
	 *
	 * @param congTacVienId the primary key of the current cong tac vien
	 * @param chiNhanhId the chi nhanh ID
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cong tac vien
	 * @throws NoSuchCongTacVienException if a cong tac vien with the primary key could not be found
	 */
	public CongTacVien[] findByChiNhanh_HoatDong_PrevAndNext(
			long congTacVienId, long chiNhanhId, Boolean hoatDong,
			com.liferay.portal.kernel.util.OrderByComparator<CongTacVien>
				orderByComparator)
		throws NoSuchCongTacVienException;

	/**
	 * Removes all the cong tac viens where chiNhanhId = &#63; and hoatDong = &#63; from the database.
	 *
	 * @param chiNhanhId the chi nhanh ID
	 * @param hoatDong the hoat dong
	 */
	public void removeByChiNhanh_HoatDong(long chiNhanhId, Boolean hoatDong);

	/**
	 * Returns the number of cong tac viens where chiNhanhId = &#63; and hoatDong = &#63;.
	 *
	 * @param chiNhanhId the chi nhanh ID
	 * @param hoatDong the hoat dong
	 * @return the number of matching cong tac viens
	 */
	public int countByChiNhanh_HoatDong(long chiNhanhId, Boolean hoatDong);

	/**
	 * Returns all the cong tac viens where chiNhanhId = &#63;.
	 *
	 * @param chiNhanhId the chi nhanh ID
	 * @return the matching cong tac viens
	 */
	public java.util.List<CongTacVien> findByChiNhanh(long chiNhanhId);

	/**
	 * Returns a range of all the cong tac viens where chiNhanhId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CongTacVienModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param chiNhanhId the chi nhanh ID
	 * @param start the lower bound of the range of cong tac viens
	 * @param end the upper bound of the range of cong tac viens (not inclusive)
	 * @return the range of matching cong tac viens
	 */
	public java.util.List<CongTacVien> findByChiNhanh(
		long chiNhanhId, int start, int end);

	/**
	 * Returns an ordered range of all the cong tac viens where chiNhanhId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CongTacVienModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param chiNhanhId the chi nhanh ID
	 * @param start the lower bound of the range of cong tac viens
	 * @param end the upper bound of the range of cong tac viens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cong tac viens
	 */
	public java.util.List<CongTacVien> findByChiNhanh(
		long chiNhanhId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CongTacVien>
			orderByComparator);

	/**
	 * Returns an ordered range of all the cong tac viens where chiNhanhId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CongTacVienModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param chiNhanhId the chi nhanh ID
	 * @param start the lower bound of the range of cong tac viens
	 * @param end the upper bound of the range of cong tac viens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching cong tac viens
	 */
	public java.util.List<CongTacVien> findByChiNhanh(
		long chiNhanhId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CongTacVien>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first cong tac vien in the ordered set where chiNhanhId = &#63;.
	 *
	 * @param chiNhanhId the chi nhanh ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cong tac vien
	 * @throws NoSuchCongTacVienException if a matching cong tac vien could not be found
	 */
	public CongTacVien findByChiNhanh_First(
			long chiNhanhId,
			com.liferay.portal.kernel.util.OrderByComparator<CongTacVien>
				orderByComparator)
		throws NoSuchCongTacVienException;

	/**
	 * Returns the first cong tac vien in the ordered set where chiNhanhId = &#63;.
	 *
	 * @param chiNhanhId the chi nhanh ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cong tac vien, or <code>null</code> if a matching cong tac vien could not be found
	 */
	public CongTacVien fetchByChiNhanh_First(
		long chiNhanhId,
		com.liferay.portal.kernel.util.OrderByComparator<CongTacVien>
			orderByComparator);

	/**
	 * Returns the last cong tac vien in the ordered set where chiNhanhId = &#63;.
	 *
	 * @param chiNhanhId the chi nhanh ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cong tac vien
	 * @throws NoSuchCongTacVienException if a matching cong tac vien could not be found
	 */
	public CongTacVien findByChiNhanh_Last(
			long chiNhanhId,
			com.liferay.portal.kernel.util.OrderByComparator<CongTacVien>
				orderByComparator)
		throws NoSuchCongTacVienException;

	/**
	 * Returns the last cong tac vien in the ordered set where chiNhanhId = &#63;.
	 *
	 * @param chiNhanhId the chi nhanh ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cong tac vien, or <code>null</code> if a matching cong tac vien could not be found
	 */
	public CongTacVien fetchByChiNhanh_Last(
		long chiNhanhId,
		com.liferay.portal.kernel.util.OrderByComparator<CongTacVien>
			orderByComparator);

	/**
	 * Returns the cong tac viens before and after the current cong tac vien in the ordered set where chiNhanhId = &#63;.
	 *
	 * @param congTacVienId the primary key of the current cong tac vien
	 * @param chiNhanhId the chi nhanh ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cong tac vien
	 * @throws NoSuchCongTacVienException if a cong tac vien with the primary key could not be found
	 */
	public CongTacVien[] findByChiNhanh_PrevAndNext(
			long congTacVienId, long chiNhanhId,
			com.liferay.portal.kernel.util.OrderByComparator<CongTacVien>
				orderByComparator)
		throws NoSuchCongTacVienException;

	/**
	 * Removes all the cong tac viens where chiNhanhId = &#63; from the database.
	 *
	 * @param chiNhanhId the chi nhanh ID
	 */
	public void removeByChiNhanh(long chiNhanhId);

	/**
	 * Returns the number of cong tac viens where chiNhanhId = &#63;.
	 *
	 * @param chiNhanhId the chi nhanh ID
	 * @return the number of matching cong tac viens
	 */
	public int countByChiNhanh(long chiNhanhId);

	/**
	 * Caches the cong tac vien in the entity cache if it is enabled.
	 *
	 * @param congTacVien the cong tac vien
	 */
	public void cacheResult(CongTacVien congTacVien);

	/**
	 * Caches the cong tac viens in the entity cache if it is enabled.
	 *
	 * @param congTacViens the cong tac viens
	 */
	public void cacheResult(java.util.List<CongTacVien> congTacViens);

	/**
	 * Creates a new cong tac vien with the primary key. Does not add the cong tac vien to the database.
	 *
	 * @param congTacVienId the primary key for the new cong tac vien
	 * @return the new cong tac vien
	 */
	public CongTacVien create(long congTacVienId);

	/**
	 * Removes the cong tac vien with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param congTacVienId the primary key of the cong tac vien
	 * @return the cong tac vien that was removed
	 * @throws NoSuchCongTacVienException if a cong tac vien with the primary key could not be found
	 */
	public CongTacVien remove(long congTacVienId)
		throws NoSuchCongTacVienException;

	public CongTacVien updateImpl(CongTacVien congTacVien);

	/**
	 * Returns the cong tac vien with the primary key or throws a <code>NoSuchCongTacVienException</code> if it could not be found.
	 *
	 * @param congTacVienId the primary key of the cong tac vien
	 * @return the cong tac vien
	 * @throws NoSuchCongTacVienException if a cong tac vien with the primary key could not be found
	 */
	public CongTacVien findByPrimaryKey(long congTacVienId)
		throws NoSuchCongTacVienException;

	/**
	 * Returns the cong tac vien with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param congTacVienId the primary key of the cong tac vien
	 * @return the cong tac vien, or <code>null</code> if a cong tac vien with the primary key could not be found
	 */
	public CongTacVien fetchByPrimaryKey(long congTacVienId);

	/**
	 * Returns all the cong tac viens.
	 *
	 * @return the cong tac viens
	 */
	public java.util.List<CongTacVien> findAll();

	/**
	 * Returns a range of all the cong tac viens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CongTacVienModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cong tac viens
	 * @param end the upper bound of the range of cong tac viens (not inclusive)
	 * @return the range of cong tac viens
	 */
	public java.util.List<CongTacVien> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the cong tac viens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CongTacVienModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cong tac viens
	 * @param end the upper bound of the range of cong tac viens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cong tac viens
	 */
	public java.util.List<CongTacVien> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CongTacVien>
			orderByComparator);

	/**
	 * Returns an ordered range of all the cong tac viens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CongTacVienModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cong tac viens
	 * @param end the upper bound of the range of cong tac viens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of cong tac viens
	 */
	public java.util.List<CongTacVien> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CongTacVien>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the cong tac viens from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of cong tac viens.
	 *
	 * @return the number of cong tac viens
	 */
	public int countAll();

}