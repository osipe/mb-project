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

import com.mb.exception.NoSuchDsPhieuTaiKhoanException;
import com.mb.model.DsPhieuTaiKhoan;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the ds phieu tai khoan service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DsPhieuTaiKhoanUtil
 * @generated
 */
@ProviderType
public interface DsPhieuTaiKhoanPersistence
	extends BasePersistence<DsPhieuTaiKhoan> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DsPhieuTaiKhoanUtil} to access the ds phieu tai khoan persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, DsPhieuTaiKhoan> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the ds phieu tai khoans where taiKhoanDoiUngId = &#63; and hoatDong = &#63;.
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param hoatDong the hoat dong
	 * @return the matching ds phieu tai khoans
	 */
	public java.util.List<DsPhieuTaiKhoan> findByTaiKhoanDoiUngId_HoatDong(
		long taiKhoanDoiUngId, Boolean hoatDong);

	/**
	 * Returns a range of all the ds phieu tai khoans where taiKhoanDoiUngId = &#63; and hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DsPhieuTaiKhoanModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of ds phieu tai khoans
	 * @param end the upper bound of the range of ds phieu tai khoans (not inclusive)
	 * @return the range of matching ds phieu tai khoans
	 */
	public java.util.List<DsPhieuTaiKhoan> findByTaiKhoanDoiUngId_HoatDong(
		long taiKhoanDoiUngId, Boolean hoatDong, int start, int end);

	/**
	 * Returns an ordered range of all the ds phieu tai khoans where taiKhoanDoiUngId = &#63; and hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DsPhieuTaiKhoanModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of ds phieu tai khoans
	 * @param end the upper bound of the range of ds phieu tai khoans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ds phieu tai khoans
	 */
	public java.util.List<DsPhieuTaiKhoan> findByTaiKhoanDoiUngId_HoatDong(
		long taiKhoanDoiUngId, Boolean hoatDong, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DsPhieuTaiKhoan>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ds phieu tai khoans where taiKhoanDoiUngId = &#63; and hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DsPhieuTaiKhoanModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of ds phieu tai khoans
	 * @param end the upper bound of the range of ds phieu tai khoans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching ds phieu tai khoans
	 */
	public java.util.List<DsPhieuTaiKhoan> findByTaiKhoanDoiUngId_HoatDong(
		long taiKhoanDoiUngId, Boolean hoatDong, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DsPhieuTaiKhoan>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first ds phieu tai khoan in the ordered set where taiKhoanDoiUngId = &#63; and hoatDong = &#63;.
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ds phieu tai khoan
	 * @throws NoSuchDsPhieuTaiKhoanException if a matching ds phieu tai khoan could not be found
	 */
	public DsPhieuTaiKhoan findByTaiKhoanDoiUngId_HoatDong_First(
			long taiKhoanDoiUngId, Boolean hoatDong,
			com.liferay.portal.kernel.util.OrderByComparator<DsPhieuTaiKhoan>
				orderByComparator)
		throws NoSuchDsPhieuTaiKhoanException;

	/**
	 * Returns the first ds phieu tai khoan in the ordered set where taiKhoanDoiUngId = &#63; and hoatDong = &#63;.
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ds phieu tai khoan, or <code>null</code> if a matching ds phieu tai khoan could not be found
	 */
	public DsPhieuTaiKhoan fetchByTaiKhoanDoiUngId_HoatDong_First(
		long taiKhoanDoiUngId, Boolean hoatDong,
		com.liferay.portal.kernel.util.OrderByComparator<DsPhieuTaiKhoan>
			orderByComparator);

	/**
	 * Returns the last ds phieu tai khoan in the ordered set where taiKhoanDoiUngId = &#63; and hoatDong = &#63;.
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ds phieu tai khoan
	 * @throws NoSuchDsPhieuTaiKhoanException if a matching ds phieu tai khoan could not be found
	 */
	public DsPhieuTaiKhoan findByTaiKhoanDoiUngId_HoatDong_Last(
			long taiKhoanDoiUngId, Boolean hoatDong,
			com.liferay.portal.kernel.util.OrderByComparator<DsPhieuTaiKhoan>
				orderByComparator)
		throws NoSuchDsPhieuTaiKhoanException;

	/**
	 * Returns the last ds phieu tai khoan in the ordered set where taiKhoanDoiUngId = &#63; and hoatDong = &#63;.
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ds phieu tai khoan, or <code>null</code> if a matching ds phieu tai khoan could not be found
	 */
	public DsPhieuTaiKhoan fetchByTaiKhoanDoiUngId_HoatDong_Last(
		long taiKhoanDoiUngId, Boolean hoatDong,
		com.liferay.portal.kernel.util.OrderByComparator<DsPhieuTaiKhoan>
			orderByComparator);

	/**
	 * Returns the ds phieu tai khoans before and after the current ds phieu tai khoan in the ordered set where taiKhoanDoiUngId = &#63; and hoatDong = &#63;.
	 *
	 * @param dsPhieuTaiKhoanId the primary key of the current ds phieu tai khoan
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ds phieu tai khoan
	 * @throws NoSuchDsPhieuTaiKhoanException if a ds phieu tai khoan with the primary key could not be found
	 */
	public DsPhieuTaiKhoan[] findByTaiKhoanDoiUngId_HoatDong_PrevAndNext(
			long dsPhieuTaiKhoanId, long taiKhoanDoiUngId, Boolean hoatDong,
			com.liferay.portal.kernel.util.OrderByComparator<DsPhieuTaiKhoan>
				orderByComparator)
		throws NoSuchDsPhieuTaiKhoanException;

	/**
	 * Removes all the ds phieu tai khoans where taiKhoanDoiUngId = &#63; and hoatDong = &#63; from the database.
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param hoatDong the hoat dong
	 */
	public void removeByTaiKhoanDoiUngId_HoatDong(
		long taiKhoanDoiUngId, Boolean hoatDong);

	/**
	 * Returns the number of ds phieu tai khoans where taiKhoanDoiUngId = &#63; and hoatDong = &#63;.
	 *
	 * @param taiKhoanDoiUngId the tai khoan doi ung ID
	 * @param hoatDong the hoat dong
	 * @return the number of matching ds phieu tai khoans
	 */
	public int countByTaiKhoanDoiUngId_HoatDong(
		long taiKhoanDoiUngId, Boolean hoatDong);

	/**
	 * Returns all the ds phieu tai khoans where phieuId = &#63; and hoatDong = &#63;.
	 *
	 * @param phieuId the phieu ID
	 * @param hoatDong the hoat dong
	 * @return the matching ds phieu tai khoans
	 */
	public java.util.List<DsPhieuTaiKhoan> findByPhieuId_HoatDong(
		long phieuId, Boolean hoatDong);

	/**
	 * Returns a range of all the ds phieu tai khoans where phieuId = &#63; and hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DsPhieuTaiKhoanModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phieuId the phieu ID
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of ds phieu tai khoans
	 * @param end the upper bound of the range of ds phieu tai khoans (not inclusive)
	 * @return the range of matching ds phieu tai khoans
	 */
	public java.util.List<DsPhieuTaiKhoan> findByPhieuId_HoatDong(
		long phieuId, Boolean hoatDong, int start, int end);

	/**
	 * Returns an ordered range of all the ds phieu tai khoans where phieuId = &#63; and hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DsPhieuTaiKhoanModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phieuId the phieu ID
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of ds phieu tai khoans
	 * @param end the upper bound of the range of ds phieu tai khoans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ds phieu tai khoans
	 */
	public java.util.List<DsPhieuTaiKhoan> findByPhieuId_HoatDong(
		long phieuId, Boolean hoatDong, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DsPhieuTaiKhoan>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ds phieu tai khoans where phieuId = &#63; and hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DsPhieuTaiKhoanModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phieuId the phieu ID
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of ds phieu tai khoans
	 * @param end the upper bound of the range of ds phieu tai khoans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching ds phieu tai khoans
	 */
	public java.util.List<DsPhieuTaiKhoan> findByPhieuId_HoatDong(
		long phieuId, Boolean hoatDong, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DsPhieuTaiKhoan>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first ds phieu tai khoan in the ordered set where phieuId = &#63; and hoatDong = &#63;.
	 *
	 * @param phieuId the phieu ID
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ds phieu tai khoan
	 * @throws NoSuchDsPhieuTaiKhoanException if a matching ds phieu tai khoan could not be found
	 */
	public DsPhieuTaiKhoan findByPhieuId_HoatDong_First(
			long phieuId, Boolean hoatDong,
			com.liferay.portal.kernel.util.OrderByComparator<DsPhieuTaiKhoan>
				orderByComparator)
		throws NoSuchDsPhieuTaiKhoanException;

	/**
	 * Returns the first ds phieu tai khoan in the ordered set where phieuId = &#63; and hoatDong = &#63;.
	 *
	 * @param phieuId the phieu ID
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ds phieu tai khoan, or <code>null</code> if a matching ds phieu tai khoan could not be found
	 */
	public DsPhieuTaiKhoan fetchByPhieuId_HoatDong_First(
		long phieuId, Boolean hoatDong,
		com.liferay.portal.kernel.util.OrderByComparator<DsPhieuTaiKhoan>
			orderByComparator);

	/**
	 * Returns the last ds phieu tai khoan in the ordered set where phieuId = &#63; and hoatDong = &#63;.
	 *
	 * @param phieuId the phieu ID
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ds phieu tai khoan
	 * @throws NoSuchDsPhieuTaiKhoanException if a matching ds phieu tai khoan could not be found
	 */
	public DsPhieuTaiKhoan findByPhieuId_HoatDong_Last(
			long phieuId, Boolean hoatDong,
			com.liferay.portal.kernel.util.OrderByComparator<DsPhieuTaiKhoan>
				orderByComparator)
		throws NoSuchDsPhieuTaiKhoanException;

	/**
	 * Returns the last ds phieu tai khoan in the ordered set where phieuId = &#63; and hoatDong = &#63;.
	 *
	 * @param phieuId the phieu ID
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ds phieu tai khoan, or <code>null</code> if a matching ds phieu tai khoan could not be found
	 */
	public DsPhieuTaiKhoan fetchByPhieuId_HoatDong_Last(
		long phieuId, Boolean hoatDong,
		com.liferay.portal.kernel.util.OrderByComparator<DsPhieuTaiKhoan>
			orderByComparator);

	/**
	 * Returns the ds phieu tai khoans before and after the current ds phieu tai khoan in the ordered set where phieuId = &#63; and hoatDong = &#63;.
	 *
	 * @param dsPhieuTaiKhoanId the primary key of the current ds phieu tai khoan
	 * @param phieuId the phieu ID
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ds phieu tai khoan
	 * @throws NoSuchDsPhieuTaiKhoanException if a ds phieu tai khoan with the primary key could not be found
	 */
	public DsPhieuTaiKhoan[] findByPhieuId_HoatDong_PrevAndNext(
			long dsPhieuTaiKhoanId, long phieuId, Boolean hoatDong,
			com.liferay.portal.kernel.util.OrderByComparator<DsPhieuTaiKhoan>
				orderByComparator)
		throws NoSuchDsPhieuTaiKhoanException;

	/**
	 * Removes all the ds phieu tai khoans where phieuId = &#63; and hoatDong = &#63; from the database.
	 *
	 * @param phieuId the phieu ID
	 * @param hoatDong the hoat dong
	 */
	public void removeByPhieuId_HoatDong(long phieuId, Boolean hoatDong);

	/**
	 * Returns the number of ds phieu tai khoans where phieuId = &#63; and hoatDong = &#63;.
	 *
	 * @param phieuId the phieu ID
	 * @param hoatDong the hoat dong
	 * @return the number of matching ds phieu tai khoans
	 */
	public int countByPhieuId_HoatDong(long phieuId, Boolean hoatDong);

	/**
	 * Returns all the ds phieu tai khoans where phieuId = &#63;.
	 *
	 * @param phieuId the phieu ID
	 * @return the matching ds phieu tai khoans
	 */
	public java.util.List<DsPhieuTaiKhoan> findByPhieuId(long phieuId);

	/**
	 * Returns a range of all the ds phieu tai khoans where phieuId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DsPhieuTaiKhoanModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phieuId the phieu ID
	 * @param start the lower bound of the range of ds phieu tai khoans
	 * @param end the upper bound of the range of ds phieu tai khoans (not inclusive)
	 * @return the range of matching ds phieu tai khoans
	 */
	public java.util.List<DsPhieuTaiKhoan> findByPhieuId(
		long phieuId, int start, int end);

	/**
	 * Returns an ordered range of all the ds phieu tai khoans where phieuId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DsPhieuTaiKhoanModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phieuId the phieu ID
	 * @param start the lower bound of the range of ds phieu tai khoans
	 * @param end the upper bound of the range of ds phieu tai khoans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ds phieu tai khoans
	 */
	public java.util.List<DsPhieuTaiKhoan> findByPhieuId(
		long phieuId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DsPhieuTaiKhoan>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ds phieu tai khoans where phieuId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DsPhieuTaiKhoanModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phieuId the phieu ID
	 * @param start the lower bound of the range of ds phieu tai khoans
	 * @param end the upper bound of the range of ds phieu tai khoans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching ds phieu tai khoans
	 */
	public java.util.List<DsPhieuTaiKhoan> findByPhieuId(
		long phieuId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DsPhieuTaiKhoan>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first ds phieu tai khoan in the ordered set where phieuId = &#63;.
	 *
	 * @param phieuId the phieu ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ds phieu tai khoan
	 * @throws NoSuchDsPhieuTaiKhoanException if a matching ds phieu tai khoan could not be found
	 */
	public DsPhieuTaiKhoan findByPhieuId_First(
			long phieuId,
			com.liferay.portal.kernel.util.OrderByComparator<DsPhieuTaiKhoan>
				orderByComparator)
		throws NoSuchDsPhieuTaiKhoanException;

	/**
	 * Returns the first ds phieu tai khoan in the ordered set where phieuId = &#63;.
	 *
	 * @param phieuId the phieu ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ds phieu tai khoan, or <code>null</code> if a matching ds phieu tai khoan could not be found
	 */
	public DsPhieuTaiKhoan fetchByPhieuId_First(
		long phieuId,
		com.liferay.portal.kernel.util.OrderByComparator<DsPhieuTaiKhoan>
			orderByComparator);

	/**
	 * Returns the last ds phieu tai khoan in the ordered set where phieuId = &#63;.
	 *
	 * @param phieuId the phieu ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ds phieu tai khoan
	 * @throws NoSuchDsPhieuTaiKhoanException if a matching ds phieu tai khoan could not be found
	 */
	public DsPhieuTaiKhoan findByPhieuId_Last(
			long phieuId,
			com.liferay.portal.kernel.util.OrderByComparator<DsPhieuTaiKhoan>
				orderByComparator)
		throws NoSuchDsPhieuTaiKhoanException;

	/**
	 * Returns the last ds phieu tai khoan in the ordered set where phieuId = &#63;.
	 *
	 * @param phieuId the phieu ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ds phieu tai khoan, or <code>null</code> if a matching ds phieu tai khoan could not be found
	 */
	public DsPhieuTaiKhoan fetchByPhieuId_Last(
		long phieuId,
		com.liferay.portal.kernel.util.OrderByComparator<DsPhieuTaiKhoan>
			orderByComparator);

	/**
	 * Returns the ds phieu tai khoans before and after the current ds phieu tai khoan in the ordered set where phieuId = &#63;.
	 *
	 * @param dsPhieuTaiKhoanId the primary key of the current ds phieu tai khoan
	 * @param phieuId the phieu ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ds phieu tai khoan
	 * @throws NoSuchDsPhieuTaiKhoanException if a ds phieu tai khoan with the primary key could not be found
	 */
	public DsPhieuTaiKhoan[] findByPhieuId_PrevAndNext(
			long dsPhieuTaiKhoanId, long phieuId,
			com.liferay.portal.kernel.util.OrderByComparator<DsPhieuTaiKhoan>
				orderByComparator)
		throws NoSuchDsPhieuTaiKhoanException;

	/**
	 * Removes all the ds phieu tai khoans where phieuId = &#63; from the database.
	 *
	 * @param phieuId the phieu ID
	 */
	public void removeByPhieuId(long phieuId);

	/**
	 * Returns the number of ds phieu tai khoans where phieuId = &#63;.
	 *
	 * @param phieuId the phieu ID
	 * @return the number of matching ds phieu tai khoans
	 */
	public int countByPhieuId(long phieuId);

	/**
	 * Caches the ds phieu tai khoan in the entity cache if it is enabled.
	 *
	 * @param dsPhieuTaiKhoan the ds phieu tai khoan
	 */
	public void cacheResult(DsPhieuTaiKhoan dsPhieuTaiKhoan);

	/**
	 * Caches the ds phieu tai khoans in the entity cache if it is enabled.
	 *
	 * @param dsPhieuTaiKhoans the ds phieu tai khoans
	 */
	public void cacheResult(java.util.List<DsPhieuTaiKhoan> dsPhieuTaiKhoans);

	/**
	 * Creates a new ds phieu tai khoan with the primary key. Does not add the ds phieu tai khoan to the database.
	 *
	 * @param dsPhieuTaiKhoanId the primary key for the new ds phieu tai khoan
	 * @return the new ds phieu tai khoan
	 */
	public DsPhieuTaiKhoan create(long dsPhieuTaiKhoanId);

	/**
	 * Removes the ds phieu tai khoan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dsPhieuTaiKhoanId the primary key of the ds phieu tai khoan
	 * @return the ds phieu tai khoan that was removed
	 * @throws NoSuchDsPhieuTaiKhoanException if a ds phieu tai khoan with the primary key could not be found
	 */
	public DsPhieuTaiKhoan remove(long dsPhieuTaiKhoanId)
		throws NoSuchDsPhieuTaiKhoanException;

	public DsPhieuTaiKhoan updateImpl(DsPhieuTaiKhoan dsPhieuTaiKhoan);

	/**
	 * Returns the ds phieu tai khoan with the primary key or throws a <code>NoSuchDsPhieuTaiKhoanException</code> if it could not be found.
	 *
	 * @param dsPhieuTaiKhoanId the primary key of the ds phieu tai khoan
	 * @return the ds phieu tai khoan
	 * @throws NoSuchDsPhieuTaiKhoanException if a ds phieu tai khoan with the primary key could not be found
	 */
	public DsPhieuTaiKhoan findByPrimaryKey(long dsPhieuTaiKhoanId)
		throws NoSuchDsPhieuTaiKhoanException;

	/**
	 * Returns the ds phieu tai khoan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dsPhieuTaiKhoanId the primary key of the ds phieu tai khoan
	 * @return the ds phieu tai khoan, or <code>null</code> if a ds phieu tai khoan with the primary key could not be found
	 */
	public DsPhieuTaiKhoan fetchByPrimaryKey(long dsPhieuTaiKhoanId);

	/**
	 * Returns all the ds phieu tai khoans.
	 *
	 * @return the ds phieu tai khoans
	 */
	public java.util.List<DsPhieuTaiKhoan> findAll();

	/**
	 * Returns a range of all the ds phieu tai khoans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DsPhieuTaiKhoanModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ds phieu tai khoans
	 * @param end the upper bound of the range of ds phieu tai khoans (not inclusive)
	 * @return the range of ds phieu tai khoans
	 */
	public java.util.List<DsPhieuTaiKhoan> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the ds phieu tai khoans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DsPhieuTaiKhoanModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ds phieu tai khoans
	 * @param end the upper bound of the range of ds phieu tai khoans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ds phieu tai khoans
	 */
	public java.util.List<DsPhieuTaiKhoan> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DsPhieuTaiKhoan>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ds phieu tai khoans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>DsPhieuTaiKhoanModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ds phieu tai khoans
	 * @param end the upper bound of the range of ds phieu tai khoans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of ds phieu tai khoans
	 */
	public java.util.List<DsPhieuTaiKhoan> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DsPhieuTaiKhoan>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the ds phieu tai khoans from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of ds phieu tai khoans.
	 *
	 * @return the number of ds phieu tai khoans
	 */
	public int countAll();

}