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

import com.mb.exception.NoSuchLoaiTaiSanException;
import com.mb.model.LoaiTaiSan;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the loai tai san service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LoaiTaiSanUtil
 * @generated
 */
@ProviderType
public interface LoaiTaiSanPersistence extends BasePersistence<LoaiTaiSan> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LoaiTaiSanUtil} to access the loai tai san persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, LoaiTaiSan> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns the loai tai san where ma = &#63; or throws a <code>NoSuchLoaiTaiSanException</code> if it could not be found.
	 *
	 * @param ma the ma
	 * @return the matching loai tai san
	 * @throws NoSuchLoaiTaiSanException if a matching loai tai san could not be found
	 */
	public LoaiTaiSan findByMa(String ma) throws NoSuchLoaiTaiSanException;

	/**
	 * Returns the loai tai san where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ma the ma
	 * @return the matching loai tai san, or <code>null</code> if a matching loai tai san could not be found
	 */
	public LoaiTaiSan fetchByMa(String ma);

	/**
	 * Returns the loai tai san where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ma the ma
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching loai tai san, or <code>null</code> if a matching loai tai san could not be found
	 */
	public LoaiTaiSan fetchByMa(String ma, boolean retrieveFromCache);

	/**
	 * Removes the loai tai san where ma = &#63; from the database.
	 *
	 * @param ma the ma
	 * @return the loai tai san that was removed
	 */
	public LoaiTaiSan removeByMa(String ma) throws NoSuchLoaiTaiSanException;

	/**
	 * Returns the number of loai tai sans where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the number of matching loai tai sans
	 */
	public int countByMa(String ma);

	/**
	 * Caches the loai tai san in the entity cache if it is enabled.
	 *
	 * @param loaiTaiSan the loai tai san
	 */
	public void cacheResult(LoaiTaiSan loaiTaiSan);

	/**
	 * Caches the loai tai sans in the entity cache if it is enabled.
	 *
	 * @param loaiTaiSans the loai tai sans
	 */
	public void cacheResult(java.util.List<LoaiTaiSan> loaiTaiSans);

	/**
	 * Creates a new loai tai san with the primary key. Does not add the loai tai san to the database.
	 *
	 * @param loaiTaiSanId the primary key for the new loai tai san
	 * @return the new loai tai san
	 */
	public LoaiTaiSan create(long loaiTaiSanId);

	/**
	 * Removes the loai tai san with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param loaiTaiSanId the primary key of the loai tai san
	 * @return the loai tai san that was removed
	 * @throws NoSuchLoaiTaiSanException if a loai tai san with the primary key could not be found
	 */
	public LoaiTaiSan remove(long loaiTaiSanId)
		throws NoSuchLoaiTaiSanException;

	public LoaiTaiSan updateImpl(LoaiTaiSan loaiTaiSan);

	/**
	 * Returns the loai tai san with the primary key or throws a <code>NoSuchLoaiTaiSanException</code> if it could not be found.
	 *
	 * @param loaiTaiSanId the primary key of the loai tai san
	 * @return the loai tai san
	 * @throws NoSuchLoaiTaiSanException if a loai tai san with the primary key could not be found
	 */
	public LoaiTaiSan findByPrimaryKey(long loaiTaiSanId)
		throws NoSuchLoaiTaiSanException;

	/**
	 * Returns the loai tai san with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param loaiTaiSanId the primary key of the loai tai san
	 * @return the loai tai san, or <code>null</code> if a loai tai san with the primary key could not be found
	 */
	public LoaiTaiSan fetchByPrimaryKey(long loaiTaiSanId);

	/**
	 * Returns all the loai tai sans.
	 *
	 * @return the loai tai sans
	 */
	public java.util.List<LoaiTaiSan> findAll();

	/**
	 * Returns a range of all the loai tai sans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LoaiTaiSanModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of loai tai sans
	 * @param end the upper bound of the range of loai tai sans (not inclusive)
	 * @return the range of loai tai sans
	 */
	public java.util.List<LoaiTaiSan> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the loai tai sans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LoaiTaiSanModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of loai tai sans
	 * @param end the upper bound of the range of loai tai sans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of loai tai sans
	 */
	public java.util.List<LoaiTaiSan> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LoaiTaiSan>
			orderByComparator);

	/**
	 * Returns an ordered range of all the loai tai sans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LoaiTaiSanModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of loai tai sans
	 * @param end the upper bound of the range of loai tai sans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of loai tai sans
	 */
	public java.util.List<LoaiTaiSan> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LoaiTaiSan>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the loai tai sans from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of loai tai sans.
	 *
	 * @return the number of loai tai sans
	 */
	public int countAll();

}