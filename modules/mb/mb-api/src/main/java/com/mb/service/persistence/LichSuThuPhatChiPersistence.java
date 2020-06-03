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

import com.mb.exception.NoSuchLichSuThuPhatChiException;
import com.mb.model.LichSuThuPhatChi;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the lich su thu phat chi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LichSuThuPhatChiUtil
 * @generated
 */
@ProviderType
public interface LichSuThuPhatChiPersistence
	extends BasePersistence<LichSuThuPhatChi> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LichSuThuPhatChiUtil} to access the lich su thu phat chi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, LichSuThuPhatChi> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the lich su thu phat chis where maCTV = &#63;.
	 *
	 * @param maCTV the ma ctv
	 * @return the matching lich su thu phat chis
	 */
	public java.util.List<LichSuThuPhatChi> findByMaCTV(String maCTV);

	/**
	 * Returns a range of all the lich su thu phat chis where maCTV = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LichSuThuPhatChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param maCTV the ma ctv
	 * @param start the lower bound of the range of lich su thu phat chis
	 * @param end the upper bound of the range of lich su thu phat chis (not inclusive)
	 * @return the range of matching lich su thu phat chis
	 */
	public java.util.List<LichSuThuPhatChi> findByMaCTV(
		String maCTV, int start, int end);

	/**
	 * Returns an ordered range of all the lich su thu phat chis where maCTV = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LichSuThuPhatChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param maCTV the ma ctv
	 * @param start the lower bound of the range of lich su thu phat chis
	 * @param end the upper bound of the range of lich su thu phat chis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lich su thu phat chis
	 */
	public java.util.List<LichSuThuPhatChi> findByMaCTV(
		String maCTV, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LichSuThuPhatChi>
			orderByComparator);

	/**
	 * Returns an ordered range of all the lich su thu phat chis where maCTV = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LichSuThuPhatChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param maCTV the ma ctv
	 * @param start the lower bound of the range of lich su thu phat chis
	 * @param end the upper bound of the range of lich su thu phat chis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching lich su thu phat chis
	 */
	public java.util.List<LichSuThuPhatChi> findByMaCTV(
		String maCTV, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LichSuThuPhatChi>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first lich su thu phat chi in the ordered set where maCTV = &#63;.
	 *
	 * @param maCTV the ma ctv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lich su thu phat chi
	 * @throws NoSuchLichSuThuPhatChiException if a matching lich su thu phat chi could not be found
	 */
	public LichSuThuPhatChi findByMaCTV_First(
			String maCTV,
			com.liferay.portal.kernel.util.OrderByComparator<LichSuThuPhatChi>
				orderByComparator)
		throws NoSuchLichSuThuPhatChiException;

	/**
	 * Returns the first lich su thu phat chi in the ordered set where maCTV = &#63;.
	 *
	 * @param maCTV the ma ctv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lich su thu phat chi, or <code>null</code> if a matching lich su thu phat chi could not be found
	 */
	public LichSuThuPhatChi fetchByMaCTV_First(
		String maCTV,
		com.liferay.portal.kernel.util.OrderByComparator<LichSuThuPhatChi>
			orderByComparator);

	/**
	 * Returns the last lich su thu phat chi in the ordered set where maCTV = &#63;.
	 *
	 * @param maCTV the ma ctv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lich su thu phat chi
	 * @throws NoSuchLichSuThuPhatChiException if a matching lich su thu phat chi could not be found
	 */
	public LichSuThuPhatChi findByMaCTV_Last(
			String maCTV,
			com.liferay.portal.kernel.util.OrderByComparator<LichSuThuPhatChi>
				orderByComparator)
		throws NoSuchLichSuThuPhatChiException;

	/**
	 * Returns the last lich su thu phat chi in the ordered set where maCTV = &#63;.
	 *
	 * @param maCTV the ma ctv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lich su thu phat chi, or <code>null</code> if a matching lich su thu phat chi could not be found
	 */
	public LichSuThuPhatChi fetchByMaCTV_Last(
		String maCTV,
		com.liferay.portal.kernel.util.OrderByComparator<LichSuThuPhatChi>
			orderByComparator);

	/**
	 * Returns the lich su thu phat chis before and after the current lich su thu phat chi in the ordered set where maCTV = &#63;.
	 *
	 * @param lichSuThuPhatChiId the primary key of the current lich su thu phat chi
	 * @param maCTV the ma ctv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lich su thu phat chi
	 * @throws NoSuchLichSuThuPhatChiException if a lich su thu phat chi with the primary key could not be found
	 */
	public LichSuThuPhatChi[] findByMaCTV_PrevAndNext(
			long lichSuThuPhatChiId, String maCTV,
			com.liferay.portal.kernel.util.OrderByComparator<LichSuThuPhatChi>
				orderByComparator)
		throws NoSuchLichSuThuPhatChiException;

	/**
	 * Removes all the lich su thu phat chis where maCTV = &#63; from the database.
	 *
	 * @param maCTV the ma ctv
	 */
	public void removeByMaCTV(String maCTV);

	/**
	 * Returns the number of lich su thu phat chis where maCTV = &#63;.
	 *
	 * @param maCTV the ma ctv
	 * @return the number of matching lich su thu phat chis
	 */
	public int countByMaCTV(String maCTV);

	/**
	 * Returns all the lich su thu phat chis where phatVayId = &#63;.
	 *
	 * @param phatVayId the phat vay ID
	 * @return the matching lich su thu phat chis
	 */
	public java.util.List<LichSuThuPhatChi> findByPhatVayId(long phatVayId);

	/**
	 * Returns a range of all the lich su thu phat chis where phatVayId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LichSuThuPhatChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phatVayId the phat vay ID
	 * @param start the lower bound of the range of lich su thu phat chis
	 * @param end the upper bound of the range of lich su thu phat chis (not inclusive)
	 * @return the range of matching lich su thu phat chis
	 */
	public java.util.List<LichSuThuPhatChi> findByPhatVayId(
		long phatVayId, int start, int end);

	/**
	 * Returns an ordered range of all the lich su thu phat chis where phatVayId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LichSuThuPhatChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phatVayId the phat vay ID
	 * @param start the lower bound of the range of lich su thu phat chis
	 * @param end the upper bound of the range of lich su thu phat chis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lich su thu phat chis
	 */
	public java.util.List<LichSuThuPhatChi> findByPhatVayId(
		long phatVayId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LichSuThuPhatChi>
			orderByComparator);

	/**
	 * Returns an ordered range of all the lich su thu phat chis where phatVayId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LichSuThuPhatChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phatVayId the phat vay ID
	 * @param start the lower bound of the range of lich su thu phat chis
	 * @param end the upper bound of the range of lich su thu phat chis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching lich su thu phat chis
	 */
	public java.util.List<LichSuThuPhatChi> findByPhatVayId(
		long phatVayId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LichSuThuPhatChi>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first lich su thu phat chi in the ordered set where phatVayId = &#63;.
	 *
	 * @param phatVayId the phat vay ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lich su thu phat chi
	 * @throws NoSuchLichSuThuPhatChiException if a matching lich su thu phat chi could not be found
	 */
	public LichSuThuPhatChi findByPhatVayId_First(
			long phatVayId,
			com.liferay.portal.kernel.util.OrderByComparator<LichSuThuPhatChi>
				orderByComparator)
		throws NoSuchLichSuThuPhatChiException;

	/**
	 * Returns the first lich su thu phat chi in the ordered set where phatVayId = &#63;.
	 *
	 * @param phatVayId the phat vay ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lich su thu phat chi, or <code>null</code> if a matching lich su thu phat chi could not be found
	 */
	public LichSuThuPhatChi fetchByPhatVayId_First(
		long phatVayId,
		com.liferay.portal.kernel.util.OrderByComparator<LichSuThuPhatChi>
			orderByComparator);

	/**
	 * Returns the last lich su thu phat chi in the ordered set where phatVayId = &#63;.
	 *
	 * @param phatVayId the phat vay ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lich su thu phat chi
	 * @throws NoSuchLichSuThuPhatChiException if a matching lich su thu phat chi could not be found
	 */
	public LichSuThuPhatChi findByPhatVayId_Last(
			long phatVayId,
			com.liferay.portal.kernel.util.OrderByComparator<LichSuThuPhatChi>
				orderByComparator)
		throws NoSuchLichSuThuPhatChiException;

	/**
	 * Returns the last lich su thu phat chi in the ordered set where phatVayId = &#63;.
	 *
	 * @param phatVayId the phat vay ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lich su thu phat chi, or <code>null</code> if a matching lich su thu phat chi could not be found
	 */
	public LichSuThuPhatChi fetchByPhatVayId_Last(
		long phatVayId,
		com.liferay.portal.kernel.util.OrderByComparator<LichSuThuPhatChi>
			orderByComparator);

	/**
	 * Returns the lich su thu phat chis before and after the current lich su thu phat chi in the ordered set where phatVayId = &#63;.
	 *
	 * @param lichSuThuPhatChiId the primary key of the current lich su thu phat chi
	 * @param phatVayId the phat vay ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lich su thu phat chi
	 * @throws NoSuchLichSuThuPhatChiException if a lich su thu phat chi with the primary key could not be found
	 */
	public LichSuThuPhatChi[] findByPhatVayId_PrevAndNext(
			long lichSuThuPhatChiId, long phatVayId,
			com.liferay.portal.kernel.util.OrderByComparator<LichSuThuPhatChi>
				orderByComparator)
		throws NoSuchLichSuThuPhatChiException;

	/**
	 * Removes all the lich su thu phat chis where phatVayId = &#63; from the database.
	 *
	 * @param phatVayId the phat vay ID
	 */
	public void removeByPhatVayId(long phatVayId);

	/**
	 * Returns the number of lich su thu phat chis where phatVayId = &#63;.
	 *
	 * @param phatVayId the phat vay ID
	 * @return the number of matching lich su thu phat chis
	 */
	public int countByPhatVayId(long phatVayId);

	/**
	 * Returns all the lich su thu phat chis where phatVayId = &#63; and loai = &#63;.
	 *
	 * @param phatVayId the phat vay ID
	 * @param loai the loai
	 * @return the matching lich su thu phat chis
	 */
	public java.util.List<LichSuThuPhatChi> findByPhatVayId_Loai(
		long phatVayId, int loai);

	/**
	 * Returns a range of all the lich su thu phat chis where phatVayId = &#63; and loai = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LichSuThuPhatChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phatVayId the phat vay ID
	 * @param loai the loai
	 * @param start the lower bound of the range of lich su thu phat chis
	 * @param end the upper bound of the range of lich su thu phat chis (not inclusive)
	 * @return the range of matching lich su thu phat chis
	 */
	public java.util.List<LichSuThuPhatChi> findByPhatVayId_Loai(
		long phatVayId, int loai, int start, int end);

	/**
	 * Returns an ordered range of all the lich su thu phat chis where phatVayId = &#63; and loai = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LichSuThuPhatChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phatVayId the phat vay ID
	 * @param loai the loai
	 * @param start the lower bound of the range of lich su thu phat chis
	 * @param end the upper bound of the range of lich su thu phat chis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lich su thu phat chis
	 */
	public java.util.List<LichSuThuPhatChi> findByPhatVayId_Loai(
		long phatVayId, int loai, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LichSuThuPhatChi>
			orderByComparator);

	/**
	 * Returns an ordered range of all the lich su thu phat chis where phatVayId = &#63; and loai = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LichSuThuPhatChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param phatVayId the phat vay ID
	 * @param loai the loai
	 * @param start the lower bound of the range of lich su thu phat chis
	 * @param end the upper bound of the range of lich su thu phat chis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching lich su thu phat chis
	 */
	public java.util.List<LichSuThuPhatChi> findByPhatVayId_Loai(
		long phatVayId, int loai, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LichSuThuPhatChi>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first lich su thu phat chi in the ordered set where phatVayId = &#63; and loai = &#63;.
	 *
	 * @param phatVayId the phat vay ID
	 * @param loai the loai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lich su thu phat chi
	 * @throws NoSuchLichSuThuPhatChiException if a matching lich su thu phat chi could not be found
	 */
	public LichSuThuPhatChi findByPhatVayId_Loai_First(
			long phatVayId, int loai,
			com.liferay.portal.kernel.util.OrderByComparator<LichSuThuPhatChi>
				orderByComparator)
		throws NoSuchLichSuThuPhatChiException;

	/**
	 * Returns the first lich su thu phat chi in the ordered set where phatVayId = &#63; and loai = &#63;.
	 *
	 * @param phatVayId the phat vay ID
	 * @param loai the loai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lich su thu phat chi, or <code>null</code> if a matching lich su thu phat chi could not be found
	 */
	public LichSuThuPhatChi fetchByPhatVayId_Loai_First(
		long phatVayId, int loai,
		com.liferay.portal.kernel.util.OrderByComparator<LichSuThuPhatChi>
			orderByComparator);

	/**
	 * Returns the last lich su thu phat chi in the ordered set where phatVayId = &#63; and loai = &#63;.
	 *
	 * @param phatVayId the phat vay ID
	 * @param loai the loai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lich su thu phat chi
	 * @throws NoSuchLichSuThuPhatChiException if a matching lich su thu phat chi could not be found
	 */
	public LichSuThuPhatChi findByPhatVayId_Loai_Last(
			long phatVayId, int loai,
			com.liferay.portal.kernel.util.OrderByComparator<LichSuThuPhatChi>
				orderByComparator)
		throws NoSuchLichSuThuPhatChiException;

	/**
	 * Returns the last lich su thu phat chi in the ordered set where phatVayId = &#63; and loai = &#63;.
	 *
	 * @param phatVayId the phat vay ID
	 * @param loai the loai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lich su thu phat chi, or <code>null</code> if a matching lich su thu phat chi could not be found
	 */
	public LichSuThuPhatChi fetchByPhatVayId_Loai_Last(
		long phatVayId, int loai,
		com.liferay.portal.kernel.util.OrderByComparator<LichSuThuPhatChi>
			orderByComparator);

	/**
	 * Returns the lich su thu phat chis before and after the current lich su thu phat chi in the ordered set where phatVayId = &#63; and loai = &#63;.
	 *
	 * @param lichSuThuPhatChiId the primary key of the current lich su thu phat chi
	 * @param phatVayId the phat vay ID
	 * @param loai the loai
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lich su thu phat chi
	 * @throws NoSuchLichSuThuPhatChiException if a lich su thu phat chi with the primary key could not be found
	 */
	public LichSuThuPhatChi[] findByPhatVayId_Loai_PrevAndNext(
			long lichSuThuPhatChiId, long phatVayId, int loai,
			com.liferay.portal.kernel.util.OrderByComparator<LichSuThuPhatChi>
				orderByComparator)
		throws NoSuchLichSuThuPhatChiException;

	/**
	 * Removes all the lich su thu phat chis where phatVayId = &#63; and loai = &#63; from the database.
	 *
	 * @param phatVayId the phat vay ID
	 * @param loai the loai
	 */
	public void removeByPhatVayId_Loai(long phatVayId, int loai);

	/**
	 * Returns the number of lich su thu phat chis where phatVayId = &#63; and loai = &#63;.
	 *
	 * @param phatVayId the phat vay ID
	 * @param loai the loai
	 * @return the number of matching lich su thu phat chis
	 */
	public int countByPhatVayId_Loai(long phatVayId, int loai);

	/**
	 * Caches the lich su thu phat chi in the entity cache if it is enabled.
	 *
	 * @param lichSuThuPhatChi the lich su thu phat chi
	 */
	public void cacheResult(LichSuThuPhatChi lichSuThuPhatChi);

	/**
	 * Caches the lich su thu phat chis in the entity cache if it is enabled.
	 *
	 * @param lichSuThuPhatChis the lich su thu phat chis
	 */
	public void cacheResult(java.util.List<LichSuThuPhatChi> lichSuThuPhatChis);

	/**
	 * Creates a new lich su thu phat chi with the primary key. Does not add the lich su thu phat chi to the database.
	 *
	 * @param lichSuThuPhatChiId the primary key for the new lich su thu phat chi
	 * @return the new lich su thu phat chi
	 */
	public LichSuThuPhatChi create(long lichSuThuPhatChiId);

	/**
	 * Removes the lich su thu phat chi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lichSuThuPhatChiId the primary key of the lich su thu phat chi
	 * @return the lich su thu phat chi that was removed
	 * @throws NoSuchLichSuThuPhatChiException if a lich su thu phat chi with the primary key could not be found
	 */
	public LichSuThuPhatChi remove(long lichSuThuPhatChiId)
		throws NoSuchLichSuThuPhatChiException;

	public LichSuThuPhatChi updateImpl(LichSuThuPhatChi lichSuThuPhatChi);

	/**
	 * Returns the lich su thu phat chi with the primary key or throws a <code>NoSuchLichSuThuPhatChiException</code> if it could not be found.
	 *
	 * @param lichSuThuPhatChiId the primary key of the lich su thu phat chi
	 * @return the lich su thu phat chi
	 * @throws NoSuchLichSuThuPhatChiException if a lich su thu phat chi with the primary key could not be found
	 */
	public LichSuThuPhatChi findByPrimaryKey(long lichSuThuPhatChiId)
		throws NoSuchLichSuThuPhatChiException;

	/**
	 * Returns the lich su thu phat chi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lichSuThuPhatChiId the primary key of the lich su thu phat chi
	 * @return the lich su thu phat chi, or <code>null</code> if a lich su thu phat chi with the primary key could not be found
	 */
	public LichSuThuPhatChi fetchByPrimaryKey(long lichSuThuPhatChiId);

	/**
	 * Returns all the lich su thu phat chis.
	 *
	 * @return the lich su thu phat chis
	 */
	public java.util.List<LichSuThuPhatChi> findAll();

	/**
	 * Returns a range of all the lich su thu phat chis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LichSuThuPhatChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lich su thu phat chis
	 * @param end the upper bound of the range of lich su thu phat chis (not inclusive)
	 * @return the range of lich su thu phat chis
	 */
	public java.util.List<LichSuThuPhatChi> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the lich su thu phat chis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LichSuThuPhatChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lich su thu phat chis
	 * @param end the upper bound of the range of lich su thu phat chis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lich su thu phat chis
	 */
	public java.util.List<LichSuThuPhatChi> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LichSuThuPhatChi>
			orderByComparator);

	/**
	 * Returns an ordered range of all the lich su thu phat chis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LichSuThuPhatChiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lich su thu phat chis
	 * @param end the upper bound of the range of lich su thu phat chis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of lich su thu phat chis
	 */
	public java.util.List<LichSuThuPhatChi> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LichSuThuPhatChi>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the lich su thu phat chis from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of lich su thu phat chis.
	 *
	 * @return the number of lich su thu phat chis
	 */
	public int countAll();

}