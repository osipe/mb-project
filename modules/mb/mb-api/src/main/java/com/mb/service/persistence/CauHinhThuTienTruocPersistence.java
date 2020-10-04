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

import com.mb.exception.NoSuchCauHinhThuTienTruocException;
import com.mb.model.CauHinhThuTienTruoc;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the cau hinh thu tien truoc service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CauHinhThuTienTruocUtil
 * @generated
 */
@ProviderType
public interface CauHinhThuTienTruocPersistence
	extends BasePersistence<CauHinhThuTienTruoc> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CauHinhThuTienTruocUtil} to access the cau hinh thu tien truoc persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, CauHinhThuTienTruoc> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns the cau hinh thu tien truoc where nam = &#63; or throws a <code>NoSuchCauHinhThuTienTruocException</code> if it could not be found.
	 *
	 * @param nam the nam
	 * @return the matching cau hinh thu tien truoc
	 * @throws NoSuchCauHinhThuTienTruocException if a matching cau hinh thu tien truoc could not be found
	 */
	public CauHinhThuTienTruoc findByNam(int nam)
		throws NoSuchCauHinhThuTienTruocException;

	/**
	 * Returns the cau hinh thu tien truoc where nam = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param nam the nam
	 * @return the matching cau hinh thu tien truoc, or <code>null</code> if a matching cau hinh thu tien truoc could not be found
	 */
	public CauHinhThuTienTruoc fetchByNam(int nam);

	/**
	 * Returns the cau hinh thu tien truoc where nam = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param nam the nam
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching cau hinh thu tien truoc, or <code>null</code> if a matching cau hinh thu tien truoc could not be found
	 */
	public CauHinhThuTienTruoc fetchByNam(int nam, boolean retrieveFromCache);

	/**
	 * Removes the cau hinh thu tien truoc where nam = &#63; from the database.
	 *
	 * @param nam the nam
	 * @return the cau hinh thu tien truoc that was removed
	 */
	public CauHinhThuTienTruoc removeByNam(int nam)
		throws NoSuchCauHinhThuTienTruocException;

	/**
	 * Returns the number of cau hinh thu tien truocs where nam = &#63;.
	 *
	 * @param nam the nam
	 * @return the number of matching cau hinh thu tien truocs
	 */
	public int countByNam(int nam);

	/**
	 * Caches the cau hinh thu tien truoc in the entity cache if it is enabled.
	 *
	 * @param cauHinhThuTienTruoc the cau hinh thu tien truoc
	 */
	public void cacheResult(CauHinhThuTienTruoc cauHinhThuTienTruoc);

	/**
	 * Caches the cau hinh thu tien truocs in the entity cache if it is enabled.
	 *
	 * @param cauHinhThuTienTruocs the cau hinh thu tien truocs
	 */
	public void cacheResult(
		java.util.List<CauHinhThuTienTruoc> cauHinhThuTienTruocs);

	/**
	 * Creates a new cau hinh thu tien truoc with the primary key. Does not add the cau hinh thu tien truoc to the database.
	 *
	 * @param cauHinhThuTienTruocId the primary key for the new cau hinh thu tien truoc
	 * @return the new cau hinh thu tien truoc
	 */
	public CauHinhThuTienTruoc create(long cauHinhThuTienTruocId);

	/**
	 * Removes the cau hinh thu tien truoc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cauHinhThuTienTruocId the primary key of the cau hinh thu tien truoc
	 * @return the cau hinh thu tien truoc that was removed
	 * @throws NoSuchCauHinhThuTienTruocException if a cau hinh thu tien truoc with the primary key could not be found
	 */
	public CauHinhThuTienTruoc remove(long cauHinhThuTienTruocId)
		throws NoSuchCauHinhThuTienTruocException;

	public CauHinhThuTienTruoc updateImpl(
		CauHinhThuTienTruoc cauHinhThuTienTruoc);

	/**
	 * Returns the cau hinh thu tien truoc with the primary key or throws a <code>NoSuchCauHinhThuTienTruocException</code> if it could not be found.
	 *
	 * @param cauHinhThuTienTruocId the primary key of the cau hinh thu tien truoc
	 * @return the cau hinh thu tien truoc
	 * @throws NoSuchCauHinhThuTienTruocException if a cau hinh thu tien truoc with the primary key could not be found
	 */
	public CauHinhThuTienTruoc findByPrimaryKey(long cauHinhThuTienTruocId)
		throws NoSuchCauHinhThuTienTruocException;

	/**
	 * Returns the cau hinh thu tien truoc with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cauHinhThuTienTruocId the primary key of the cau hinh thu tien truoc
	 * @return the cau hinh thu tien truoc, or <code>null</code> if a cau hinh thu tien truoc with the primary key could not be found
	 */
	public CauHinhThuTienTruoc fetchByPrimaryKey(long cauHinhThuTienTruocId);

	/**
	 * Returns all the cau hinh thu tien truocs.
	 *
	 * @return the cau hinh thu tien truocs
	 */
	public java.util.List<CauHinhThuTienTruoc> findAll();

	/**
	 * Returns a range of all the cau hinh thu tien truocs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CauHinhThuTienTruocModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cau hinh thu tien truocs
	 * @param end the upper bound of the range of cau hinh thu tien truocs (not inclusive)
	 * @return the range of cau hinh thu tien truocs
	 */
	public java.util.List<CauHinhThuTienTruoc> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the cau hinh thu tien truocs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CauHinhThuTienTruocModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cau hinh thu tien truocs
	 * @param end the upper bound of the range of cau hinh thu tien truocs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cau hinh thu tien truocs
	 */
	public java.util.List<CauHinhThuTienTruoc> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CauHinhThuTienTruoc>
			orderByComparator);

	/**
	 * Returns an ordered range of all the cau hinh thu tien truocs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CauHinhThuTienTruocModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cau hinh thu tien truocs
	 * @param end the upper bound of the range of cau hinh thu tien truocs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of cau hinh thu tien truocs
	 */
	public java.util.List<CauHinhThuTienTruoc> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CauHinhThuTienTruoc>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the cau hinh thu tien truocs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of cau hinh thu tien truocs.
	 *
	 * @return the number of cau hinh thu tien truocs
	 */
	public int countAll();

}