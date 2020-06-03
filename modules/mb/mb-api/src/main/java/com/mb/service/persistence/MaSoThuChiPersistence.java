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

import com.mb.exception.NoSuchMaSoThuChiException;
import com.mb.model.MaSoThuChi;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the ma so thu chi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MaSoThuChiUtil
 * @generated
 */
@ProviderType
public interface MaSoThuChiPersistence extends BasePersistence<MaSoThuChi> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MaSoThuChiUtil} to access the ma so thu chi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, MaSoThuChi> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns the ma so thu chi where ma = &#63; and loai = &#63; and hoatDong = &#63; or throws a <code>NoSuchMaSoThuChiException</code> if it could not be found.
	 *
	 * @param ma the ma
	 * @param loai the loai
	 * @param hoatDong the hoat dong
	 * @return the matching ma so thu chi
	 * @throws NoSuchMaSoThuChiException if a matching ma so thu chi could not be found
	 */
	public MaSoThuChi findByMa_Loai_HoatDong(
			String ma, int loai, Boolean hoatDong)
		throws NoSuchMaSoThuChiException;

	/**
	 * Returns the ma so thu chi where ma = &#63; and loai = &#63; and hoatDong = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ma the ma
	 * @param loai the loai
	 * @param hoatDong the hoat dong
	 * @return the matching ma so thu chi, or <code>null</code> if a matching ma so thu chi could not be found
	 */
	public MaSoThuChi fetchByMa_Loai_HoatDong(
		String ma, int loai, Boolean hoatDong);

	/**
	 * Returns the ma so thu chi where ma = &#63; and loai = &#63; and hoatDong = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ma the ma
	 * @param loai the loai
	 * @param hoatDong the hoat dong
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching ma so thu chi, or <code>null</code> if a matching ma so thu chi could not be found
	 */
	public MaSoThuChi fetchByMa_Loai_HoatDong(
		String ma, int loai, Boolean hoatDong, boolean retrieveFromCache);

	/**
	 * Removes the ma so thu chi where ma = &#63; and loai = &#63; and hoatDong = &#63; from the database.
	 *
	 * @param ma the ma
	 * @param loai the loai
	 * @param hoatDong the hoat dong
	 * @return the ma so thu chi that was removed
	 */
	public MaSoThuChi removeByMa_Loai_HoatDong(
			String ma, int loai, Boolean hoatDong)
		throws NoSuchMaSoThuChiException;

	/**
	 * Returns the number of ma so thu chis where ma = &#63; and loai = &#63; and hoatDong = &#63;.
	 *
	 * @param ma the ma
	 * @param loai the loai
	 * @param hoatDong the hoat dong
	 * @return the number of matching ma so thu chis
	 */
	public int countByMa_Loai_HoatDong(String ma, int loai, Boolean hoatDong);

	/**
	 * Returns all the ma so thu chis where loai = &#63; and hoatDong = &#63;.
	 *
	 * @param loai the loai
	 * @param hoatDong the hoat dong
	 * @return the matching ma so thu chis
	 */
	public java.util.List<MaSoThuChi> findByLoai_HoatDong(
		int loai, Boolean hoatDong);

	/**
	 * Returns a range of all the ma so thu chis where loai = &#63; and hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MaSoThuChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param loai the loai
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of ma so thu chis
	 * @param end the upper bound of the range of ma so thu chis (not inclusive)
	 * @return the range of matching ma so thu chis
	 */
	public java.util.List<MaSoThuChi> findByLoai_HoatDong(
		int loai, Boolean hoatDong, int start, int end);

	/**
	 * Returns an ordered range of all the ma so thu chis where loai = &#63; and hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MaSoThuChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param loai the loai
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of ma so thu chis
	 * @param end the upper bound of the range of ma so thu chis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ma so thu chis
	 */
	public java.util.List<MaSoThuChi> findByLoai_HoatDong(
		int loai, Boolean hoatDong, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MaSoThuChi>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ma so thu chis where loai = &#63; and hoatDong = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MaSoThuChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param loai the loai
	 * @param hoatDong the hoat dong
	 * @param start the lower bound of the range of ma so thu chis
	 * @param end the upper bound of the range of ma so thu chis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching ma so thu chis
	 */
	public java.util.List<MaSoThuChi> findByLoai_HoatDong(
		int loai, Boolean hoatDong, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MaSoThuChi>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first ma so thu chi in the ordered set where loai = &#63; and hoatDong = &#63;.
	 *
	 * @param loai the loai
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ma so thu chi
	 * @throws NoSuchMaSoThuChiException if a matching ma so thu chi could not be found
	 */
	public MaSoThuChi findByLoai_HoatDong_First(
			int loai, Boolean hoatDong,
			com.liferay.portal.kernel.util.OrderByComparator<MaSoThuChi>
				orderByComparator)
		throws NoSuchMaSoThuChiException;

	/**
	 * Returns the first ma so thu chi in the ordered set where loai = &#63; and hoatDong = &#63;.
	 *
	 * @param loai the loai
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ma so thu chi, or <code>null</code> if a matching ma so thu chi could not be found
	 */
	public MaSoThuChi fetchByLoai_HoatDong_First(
		int loai, Boolean hoatDong,
		com.liferay.portal.kernel.util.OrderByComparator<MaSoThuChi>
			orderByComparator);

	/**
	 * Returns the last ma so thu chi in the ordered set where loai = &#63; and hoatDong = &#63;.
	 *
	 * @param loai the loai
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ma so thu chi
	 * @throws NoSuchMaSoThuChiException if a matching ma so thu chi could not be found
	 */
	public MaSoThuChi findByLoai_HoatDong_Last(
			int loai, Boolean hoatDong,
			com.liferay.portal.kernel.util.OrderByComparator<MaSoThuChi>
				orderByComparator)
		throws NoSuchMaSoThuChiException;

	/**
	 * Returns the last ma so thu chi in the ordered set where loai = &#63; and hoatDong = &#63;.
	 *
	 * @param loai the loai
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ma so thu chi, or <code>null</code> if a matching ma so thu chi could not be found
	 */
	public MaSoThuChi fetchByLoai_HoatDong_Last(
		int loai, Boolean hoatDong,
		com.liferay.portal.kernel.util.OrderByComparator<MaSoThuChi>
			orderByComparator);

	/**
	 * Returns the ma so thu chis before and after the current ma so thu chi in the ordered set where loai = &#63; and hoatDong = &#63;.
	 *
	 * @param maSoThuChiId the primary key of the current ma so thu chi
	 * @param loai the loai
	 * @param hoatDong the hoat dong
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ma so thu chi
	 * @throws NoSuchMaSoThuChiException if a ma so thu chi with the primary key could not be found
	 */
	public MaSoThuChi[] findByLoai_HoatDong_PrevAndNext(
			long maSoThuChiId, int loai, Boolean hoatDong,
			com.liferay.portal.kernel.util.OrderByComparator<MaSoThuChi>
				orderByComparator)
		throws NoSuchMaSoThuChiException;

	/**
	 * Removes all the ma so thu chis where loai = &#63; and hoatDong = &#63; from the database.
	 *
	 * @param loai the loai
	 * @param hoatDong the hoat dong
	 */
	public void removeByLoai_HoatDong(int loai, Boolean hoatDong);

	/**
	 * Returns the number of ma so thu chis where loai = &#63; and hoatDong = &#63;.
	 *
	 * @param loai the loai
	 * @param hoatDong the hoat dong
	 * @return the number of matching ma so thu chis
	 */
	public int countByLoai_HoatDong(int loai, Boolean hoatDong);

	/**
	 * Caches the ma so thu chi in the entity cache if it is enabled.
	 *
	 * @param maSoThuChi the ma so thu chi
	 */
	public void cacheResult(MaSoThuChi maSoThuChi);

	/**
	 * Caches the ma so thu chis in the entity cache if it is enabled.
	 *
	 * @param maSoThuChis the ma so thu chis
	 */
	public void cacheResult(java.util.List<MaSoThuChi> maSoThuChis);

	/**
	 * Creates a new ma so thu chi with the primary key. Does not add the ma so thu chi to the database.
	 *
	 * @param maSoThuChiId the primary key for the new ma so thu chi
	 * @return the new ma so thu chi
	 */
	public MaSoThuChi create(long maSoThuChiId);

	/**
	 * Removes the ma so thu chi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param maSoThuChiId the primary key of the ma so thu chi
	 * @return the ma so thu chi that was removed
	 * @throws NoSuchMaSoThuChiException if a ma so thu chi with the primary key could not be found
	 */
	public MaSoThuChi remove(long maSoThuChiId)
		throws NoSuchMaSoThuChiException;

	public MaSoThuChi updateImpl(MaSoThuChi maSoThuChi);

	/**
	 * Returns the ma so thu chi with the primary key or throws a <code>NoSuchMaSoThuChiException</code> if it could not be found.
	 *
	 * @param maSoThuChiId the primary key of the ma so thu chi
	 * @return the ma so thu chi
	 * @throws NoSuchMaSoThuChiException if a ma so thu chi with the primary key could not be found
	 */
	public MaSoThuChi findByPrimaryKey(long maSoThuChiId)
		throws NoSuchMaSoThuChiException;

	/**
	 * Returns the ma so thu chi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param maSoThuChiId the primary key of the ma so thu chi
	 * @return the ma so thu chi, or <code>null</code> if a ma so thu chi with the primary key could not be found
	 */
	public MaSoThuChi fetchByPrimaryKey(long maSoThuChiId);

	/**
	 * Returns all the ma so thu chis.
	 *
	 * @return the ma so thu chis
	 */
	public java.util.List<MaSoThuChi> findAll();

	/**
	 * Returns a range of all the ma so thu chis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MaSoThuChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ma so thu chis
	 * @param end the upper bound of the range of ma so thu chis (not inclusive)
	 * @return the range of ma so thu chis
	 */
	public java.util.List<MaSoThuChi> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the ma so thu chis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MaSoThuChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ma so thu chis
	 * @param end the upper bound of the range of ma so thu chis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ma so thu chis
	 */
	public java.util.List<MaSoThuChi> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MaSoThuChi>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ma so thu chis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MaSoThuChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ma so thu chis
	 * @param end the upper bound of the range of ma so thu chis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of ma so thu chis
	 */
	public java.util.List<MaSoThuChi> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MaSoThuChi>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the ma so thu chis from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of ma so thu chis.
	 *
	 * @return the number of ma so thu chis
	 */
	public int countAll();

}