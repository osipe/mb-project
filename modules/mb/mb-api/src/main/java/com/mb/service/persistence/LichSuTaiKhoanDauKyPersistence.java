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

import com.mb.exception.NoSuchLichSuTaiKhoanDauKyException;
import com.mb.model.LichSuTaiKhoanDauKy;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the lich su tai khoan dau ky service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LichSuTaiKhoanDauKyUtil
 * @generated
 */
@ProviderType
public interface LichSuTaiKhoanDauKyPersistence
	extends BasePersistence<LichSuTaiKhoanDauKy> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LichSuTaiKhoanDauKyUtil} to access the lich su tai khoan dau ky persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, LichSuTaiKhoanDauKy> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns the lich su tai khoan dau ky where taiKhoanDoiUngId = &#63; and nam = &#63; and thang = &#63; or throws a <code>NoSuchLichSuTaiKhoanDauKyException</code> if it could not be found.
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param nam the nam
	 * @param thang the thang
	 * @return the matching lich su tai khoan dau ky
	 * @throws NoSuchLichSuTaiKhoanDauKyException if a matching lich su tai khoan dau ky could not be found
	 */
	public LichSuTaiKhoanDauKy findByTaiKhoanDoiUngId_Nam_Thang(
			long taiKhoanDoiUngId, int nam, int thang)
		throws NoSuchLichSuTaiKhoanDauKyException;

	/**
	 * Returns the lich su tai khoan dau ky where taiKhoanDoiUngId = &#63; and nam = &#63; and thang = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param nam the nam
	 * @param thang the thang
	 * @return the matching lich su tai khoan dau ky, or <code>null</code> if a matching lich su tai khoan dau ky could not be found
	 */
	public LichSuTaiKhoanDauKy fetchByTaiKhoanDoiUngId_Nam_Thang(
		long taiKhoanDoiUngId, int nam, int thang);

	/**
	 * Returns the lich su tai khoan dau ky where taiKhoanDoiUngId = &#63; and nam = &#63; and thang = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param nam the nam
	 * @param thang the thang
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching lich su tai khoan dau ky, or <code>null</code> if a matching lich su tai khoan dau ky could not be found
	 */
	public LichSuTaiKhoanDauKy fetchByTaiKhoanDoiUngId_Nam_Thang(
		long taiKhoanDoiUngId, int nam, int thang, boolean retrieveFromCache);

	/**
	 * Removes the lich su tai khoan dau ky where taiKhoanDoiUngId = &#63; and nam = &#63; and thang = &#63; from the database.
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param nam the nam
	 * @param thang the thang
	 * @return the lich su tai khoan dau ky that was removed
	 */
	public LichSuTaiKhoanDauKy removeByTaiKhoanDoiUngId_Nam_Thang(
			long taiKhoanDoiUngId, int nam, int thang)
		throws NoSuchLichSuTaiKhoanDauKyException;

	/**
	 * Returns the number of lich su tai khoan dau kies where taiKhoanDoiUngId = &#63; and nam = &#63; and thang = &#63;.
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param nam the nam
	 * @param thang the thang
	 * @return the number of matching lich su tai khoan dau kies
	 */
	public int countByTaiKhoanDoiUngId_Nam_Thang(
		long taiKhoanDoiUngId, int nam, int thang);

	/**
	 * Returns all the lich su tai khoan dau kies where nam = &#63; and thang = &#63;.
	 *
	 * @param nam the nam
	 * @param thang the thang
	 * @return the matching lich su tai khoan dau kies
	 */
	public java.util.List<LichSuTaiKhoanDauKy> findByNam_Thang(
		int nam, int thang);

	/**
	 * Returns a range of all the lich su tai khoan dau kies where nam = &#63; and thang = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LichSuTaiKhoanDauKyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nam the nam
	 * @param thang the thang
	 * @param start the lower bound of the range of lich su tai khoan dau kies
	 * @param end the upper bound of the range of lich su tai khoan dau kies (not inclusive)
	 * @return the range of matching lich su tai khoan dau kies
	 */
	public java.util.List<LichSuTaiKhoanDauKy> findByNam_Thang(
		int nam, int thang, int start, int end);

	/**
	 * Returns an ordered range of all the lich su tai khoan dau kies where nam = &#63; and thang = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LichSuTaiKhoanDauKyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nam the nam
	 * @param thang the thang
	 * @param start the lower bound of the range of lich su tai khoan dau kies
	 * @param end the upper bound of the range of lich su tai khoan dau kies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lich su tai khoan dau kies
	 */
	public java.util.List<LichSuTaiKhoanDauKy> findByNam_Thang(
		int nam, int thang, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LichSuTaiKhoanDauKy>
			orderByComparator);

	/**
	 * Returns an ordered range of all the lich su tai khoan dau kies where nam = &#63; and thang = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LichSuTaiKhoanDauKyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nam the nam
	 * @param thang the thang
	 * @param start the lower bound of the range of lich su tai khoan dau kies
	 * @param end the upper bound of the range of lich su tai khoan dau kies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching lich su tai khoan dau kies
	 */
	public java.util.List<LichSuTaiKhoanDauKy> findByNam_Thang(
		int nam, int thang, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LichSuTaiKhoanDauKy>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first lich su tai khoan dau ky in the ordered set where nam = &#63; and thang = &#63;.
	 *
	 * @param nam the nam
	 * @param thang the thang
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lich su tai khoan dau ky
	 * @throws NoSuchLichSuTaiKhoanDauKyException if a matching lich su tai khoan dau ky could not be found
	 */
	public LichSuTaiKhoanDauKy findByNam_Thang_First(
			int nam, int thang,
			com.liferay.portal.kernel.util.OrderByComparator
				<LichSuTaiKhoanDauKy> orderByComparator)
		throws NoSuchLichSuTaiKhoanDauKyException;

	/**
	 * Returns the first lich su tai khoan dau ky in the ordered set where nam = &#63; and thang = &#63;.
	 *
	 * @param nam the nam
	 * @param thang the thang
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lich su tai khoan dau ky, or <code>null</code> if a matching lich su tai khoan dau ky could not be found
	 */
	public LichSuTaiKhoanDauKy fetchByNam_Thang_First(
		int nam, int thang,
		com.liferay.portal.kernel.util.OrderByComparator<LichSuTaiKhoanDauKy>
			orderByComparator);

	/**
	 * Returns the last lich su tai khoan dau ky in the ordered set where nam = &#63; and thang = &#63;.
	 *
	 * @param nam the nam
	 * @param thang the thang
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lich su tai khoan dau ky
	 * @throws NoSuchLichSuTaiKhoanDauKyException if a matching lich su tai khoan dau ky could not be found
	 */
	public LichSuTaiKhoanDauKy findByNam_Thang_Last(
			int nam, int thang,
			com.liferay.portal.kernel.util.OrderByComparator
				<LichSuTaiKhoanDauKy> orderByComparator)
		throws NoSuchLichSuTaiKhoanDauKyException;

	/**
	 * Returns the last lich su tai khoan dau ky in the ordered set where nam = &#63; and thang = &#63;.
	 *
	 * @param nam the nam
	 * @param thang the thang
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lich su tai khoan dau ky, or <code>null</code> if a matching lich su tai khoan dau ky could not be found
	 */
	public LichSuTaiKhoanDauKy fetchByNam_Thang_Last(
		int nam, int thang,
		com.liferay.portal.kernel.util.OrderByComparator<LichSuTaiKhoanDauKy>
			orderByComparator);

	/**
	 * Returns the lich su tai khoan dau kies before and after the current lich su tai khoan dau ky in the ordered set where nam = &#63; and thang = &#63;.
	 *
	 * @param lichSuTaiKhoanDauKyId the primary key of the current lich su tai khoan dau ky
	 * @param nam the nam
	 * @param thang the thang
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lich su tai khoan dau ky
	 * @throws NoSuchLichSuTaiKhoanDauKyException if a lich su tai khoan dau ky with the primary key could not be found
	 */
	public LichSuTaiKhoanDauKy[] findByNam_Thang_PrevAndNext(
			long lichSuTaiKhoanDauKyId, int nam, int thang,
			com.liferay.portal.kernel.util.OrderByComparator
				<LichSuTaiKhoanDauKy> orderByComparator)
		throws NoSuchLichSuTaiKhoanDauKyException;

	/**
	 * Removes all the lich su tai khoan dau kies where nam = &#63; and thang = &#63; from the database.
	 *
	 * @param nam the nam
	 * @param thang the thang
	 */
	public void removeByNam_Thang(int nam, int thang);

	/**
	 * Returns the number of lich su tai khoan dau kies where nam = &#63; and thang = &#63;.
	 *
	 * @param nam the nam
	 * @param thang the thang
	 * @return the number of matching lich su tai khoan dau kies
	 */
	public int countByNam_Thang(int nam, int thang);

	/**
	 * Returns all the lich su tai khoan dau kies where taiKhoanDoiUngId = &#63;.
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @return the matching lich su tai khoan dau kies
	 */
	public java.util.List<LichSuTaiKhoanDauKy> findByTaiKhoanDoiUngId(
		long taiKhoanDoiUngId);

	/**
	 * Returns a range of all the lich su tai khoan dau kies where taiKhoanDoiUngId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LichSuTaiKhoanDauKyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param start the lower bound of the range of lich su tai khoan dau kies
	 * @param end the upper bound of the range of lich su tai khoan dau kies (not inclusive)
	 * @return the range of matching lich su tai khoan dau kies
	 */
	public java.util.List<LichSuTaiKhoanDauKy> findByTaiKhoanDoiUngId(
		long taiKhoanDoiUngId, int start, int end);

	/**
	 * Returns an ordered range of all the lich su tai khoan dau kies where taiKhoanDoiUngId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LichSuTaiKhoanDauKyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param start the lower bound of the range of lich su tai khoan dau kies
	 * @param end the upper bound of the range of lich su tai khoan dau kies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lich su tai khoan dau kies
	 */
	public java.util.List<LichSuTaiKhoanDauKy> findByTaiKhoanDoiUngId(
		long taiKhoanDoiUngId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LichSuTaiKhoanDauKy>
			orderByComparator);

	/**
	 * Returns an ordered range of all the lich su tai khoan dau kies where taiKhoanDoiUngId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LichSuTaiKhoanDauKyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param start the lower bound of the range of lich su tai khoan dau kies
	 * @param end the upper bound of the range of lich su tai khoan dau kies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching lich su tai khoan dau kies
	 */
	public java.util.List<LichSuTaiKhoanDauKy> findByTaiKhoanDoiUngId(
		long taiKhoanDoiUngId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LichSuTaiKhoanDauKy>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first lich su tai khoan dau ky in the ordered set where taiKhoanDoiUngId = &#63;.
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lich su tai khoan dau ky
	 * @throws NoSuchLichSuTaiKhoanDauKyException if a matching lich su tai khoan dau ky could not be found
	 */
	public LichSuTaiKhoanDauKy findByTaiKhoanDoiUngId_First(
			long taiKhoanDoiUngId,
			com.liferay.portal.kernel.util.OrderByComparator
				<LichSuTaiKhoanDauKy> orderByComparator)
		throws NoSuchLichSuTaiKhoanDauKyException;

	/**
	 * Returns the first lich su tai khoan dau ky in the ordered set where taiKhoanDoiUngId = &#63;.
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lich su tai khoan dau ky, or <code>null</code> if a matching lich su tai khoan dau ky could not be found
	 */
	public LichSuTaiKhoanDauKy fetchByTaiKhoanDoiUngId_First(
		long taiKhoanDoiUngId,
		com.liferay.portal.kernel.util.OrderByComparator<LichSuTaiKhoanDauKy>
			orderByComparator);

	/**
	 * Returns the last lich su tai khoan dau ky in the ordered set where taiKhoanDoiUngId = &#63;.
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lich su tai khoan dau ky
	 * @throws NoSuchLichSuTaiKhoanDauKyException if a matching lich su tai khoan dau ky could not be found
	 */
	public LichSuTaiKhoanDauKy findByTaiKhoanDoiUngId_Last(
			long taiKhoanDoiUngId,
			com.liferay.portal.kernel.util.OrderByComparator
				<LichSuTaiKhoanDauKy> orderByComparator)
		throws NoSuchLichSuTaiKhoanDauKyException;

	/**
	 * Returns the last lich su tai khoan dau ky in the ordered set where taiKhoanDoiUngId = &#63;.
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lich su tai khoan dau ky, or <code>null</code> if a matching lich su tai khoan dau ky could not be found
	 */
	public LichSuTaiKhoanDauKy fetchByTaiKhoanDoiUngId_Last(
		long taiKhoanDoiUngId,
		com.liferay.portal.kernel.util.OrderByComparator<LichSuTaiKhoanDauKy>
			orderByComparator);

	/**
	 * Returns the lich su tai khoan dau kies before and after the current lich su tai khoan dau ky in the ordered set where taiKhoanDoiUngId = &#63;.
	 *
	 * @param lichSuTaiKhoanDauKyId the primary key of the current lich su tai khoan dau ky
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lich su tai khoan dau ky
	 * @throws NoSuchLichSuTaiKhoanDauKyException if a lich su tai khoan dau ky with the primary key could not be found
	 */
	public LichSuTaiKhoanDauKy[] findByTaiKhoanDoiUngId_PrevAndNext(
			long lichSuTaiKhoanDauKyId, long taiKhoanDoiUngId,
			com.liferay.portal.kernel.util.OrderByComparator
				<LichSuTaiKhoanDauKy> orderByComparator)
		throws NoSuchLichSuTaiKhoanDauKyException;

	/**
	 * Removes all the lich su tai khoan dau kies where taiKhoanDoiUngId = &#63; from the database.
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 */
	public void removeByTaiKhoanDoiUngId(long taiKhoanDoiUngId);

	/**
	 * Returns the number of lich su tai khoan dau kies where taiKhoanDoiUngId = &#63;.
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @return the number of matching lich su tai khoan dau kies
	 */
	public int countByTaiKhoanDoiUngId(long taiKhoanDoiUngId);

	/**
	 * Caches the lich su tai khoan dau ky in the entity cache if it is enabled.
	 *
	 * @param lichSuTaiKhoanDauKy the lich su tai khoan dau ky
	 */
	public void cacheResult(LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy);

	/**
	 * Caches the lich su tai khoan dau kies in the entity cache if it is enabled.
	 *
	 * @param lichSuTaiKhoanDauKies the lich su tai khoan dau kies
	 */
	public void cacheResult(
		java.util.List<LichSuTaiKhoanDauKy> lichSuTaiKhoanDauKies);

	/**
	 * Creates a new lich su tai khoan dau ky with the primary key. Does not add the lich su tai khoan dau ky to the database.
	 *
	 * @param lichSuTaiKhoanDauKyId the primary key for the new lich su tai khoan dau ky
	 * @return the new lich su tai khoan dau ky
	 */
	public LichSuTaiKhoanDauKy create(long lichSuTaiKhoanDauKyId);

	/**
	 * Removes the lich su tai khoan dau ky with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lichSuTaiKhoanDauKyId the primary key of the lich su tai khoan dau ky
	 * @return the lich su tai khoan dau ky that was removed
	 * @throws NoSuchLichSuTaiKhoanDauKyException if a lich su tai khoan dau ky with the primary key could not be found
	 */
	public LichSuTaiKhoanDauKy remove(long lichSuTaiKhoanDauKyId)
		throws NoSuchLichSuTaiKhoanDauKyException;

	public LichSuTaiKhoanDauKy updateImpl(
		LichSuTaiKhoanDauKy lichSuTaiKhoanDauKy);

	/**
	 * Returns the lich su tai khoan dau ky with the primary key or throws a <code>NoSuchLichSuTaiKhoanDauKyException</code> if it could not be found.
	 *
	 * @param lichSuTaiKhoanDauKyId the primary key of the lich su tai khoan dau ky
	 * @return the lich su tai khoan dau ky
	 * @throws NoSuchLichSuTaiKhoanDauKyException if a lich su tai khoan dau ky with the primary key could not be found
	 */
	public LichSuTaiKhoanDauKy findByPrimaryKey(long lichSuTaiKhoanDauKyId)
		throws NoSuchLichSuTaiKhoanDauKyException;

	/**
	 * Returns the lich su tai khoan dau ky with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lichSuTaiKhoanDauKyId the primary key of the lich su tai khoan dau ky
	 * @return the lich su tai khoan dau ky, or <code>null</code> if a lich su tai khoan dau ky with the primary key could not be found
	 */
	public LichSuTaiKhoanDauKy fetchByPrimaryKey(long lichSuTaiKhoanDauKyId);

	/**
	 * Returns all the lich su tai khoan dau kies.
	 *
	 * @return the lich su tai khoan dau kies
	 */
	public java.util.List<LichSuTaiKhoanDauKy> findAll();

	/**
	 * Returns a range of all the lich su tai khoan dau kies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LichSuTaiKhoanDauKyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lich su tai khoan dau kies
	 * @param end the upper bound of the range of lich su tai khoan dau kies (not inclusive)
	 * @return the range of lich su tai khoan dau kies
	 */
	public java.util.List<LichSuTaiKhoanDauKy> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the lich su tai khoan dau kies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LichSuTaiKhoanDauKyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lich su tai khoan dau kies
	 * @param end the upper bound of the range of lich su tai khoan dau kies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lich su tai khoan dau kies
	 */
	public java.util.List<LichSuTaiKhoanDauKy> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LichSuTaiKhoanDauKy>
			orderByComparator);

	/**
	 * Returns an ordered range of all the lich su tai khoan dau kies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LichSuTaiKhoanDauKyModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lich su tai khoan dau kies
	 * @param end the upper bound of the range of lich su tai khoan dau kies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of lich su tai khoan dau kies
	 */
	public java.util.List<LichSuTaiKhoanDauKy> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LichSuTaiKhoanDauKy>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the lich su tai khoan dau kies from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of lich su tai khoan dau kies.
	 *
	 * @return the number of lich su tai khoan dau kies
	 */
	public int countAll();

}