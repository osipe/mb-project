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

import com.mb.exception.NoSuchPhatVayException;
import com.mb.model.PhatVay;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the phat vay service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PhatVayUtil
 * @generated
 */
@ProviderType
public interface PhatVayPersistence extends BasePersistence<PhatVay> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PhatVayUtil} to access the phat vay persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, PhatVay> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the phat vaies where maCTV = &#63;.
	 *
	 * @param maCTV the ma ctv
	 * @return the matching phat vaies
	 */
	public java.util.List<PhatVay> findByMaCTV(String maCTV);

	/**
	 * Returns a range of all the phat vaies where maCTV = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PhatVayModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param maCTV the ma ctv
	 * @param start the lower bound of the range of phat vaies
	 * @param end the upper bound of the range of phat vaies (not inclusive)
	 * @return the range of matching phat vaies
	 */
	public java.util.List<PhatVay> findByMaCTV(
		String maCTV, int start, int end);

	/**
	 * Returns an ordered range of all the phat vaies where maCTV = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PhatVayModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param maCTV the ma ctv
	 * @param start the lower bound of the range of phat vaies
	 * @param end the upper bound of the range of phat vaies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching phat vaies
	 */
	public java.util.List<PhatVay> findByMaCTV(
		String maCTV, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PhatVay>
			orderByComparator);

	/**
	 * Returns an ordered range of all the phat vaies where maCTV = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PhatVayModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param maCTV the ma ctv
	 * @param start the lower bound of the range of phat vaies
	 * @param end the upper bound of the range of phat vaies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching phat vaies
	 */
	public java.util.List<PhatVay> findByMaCTV(
		String maCTV, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PhatVay>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first phat vay in the ordered set where maCTV = &#63;.
	 *
	 * @param maCTV the ma ctv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phat vay
	 * @throws NoSuchPhatVayException if a matching phat vay could not be found
	 */
	public PhatVay findByMaCTV_First(
			String maCTV,
			com.liferay.portal.kernel.util.OrderByComparator<PhatVay>
				orderByComparator)
		throws NoSuchPhatVayException;

	/**
	 * Returns the first phat vay in the ordered set where maCTV = &#63;.
	 *
	 * @param maCTV the ma ctv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phat vay, or <code>null</code> if a matching phat vay could not be found
	 */
	public PhatVay fetchByMaCTV_First(
		String maCTV,
		com.liferay.portal.kernel.util.OrderByComparator<PhatVay>
			orderByComparator);

	/**
	 * Returns the last phat vay in the ordered set where maCTV = &#63;.
	 *
	 * @param maCTV the ma ctv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phat vay
	 * @throws NoSuchPhatVayException if a matching phat vay could not be found
	 */
	public PhatVay findByMaCTV_Last(
			String maCTV,
			com.liferay.portal.kernel.util.OrderByComparator<PhatVay>
				orderByComparator)
		throws NoSuchPhatVayException;

	/**
	 * Returns the last phat vay in the ordered set where maCTV = &#63;.
	 *
	 * @param maCTV the ma ctv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phat vay, or <code>null</code> if a matching phat vay could not be found
	 */
	public PhatVay fetchByMaCTV_Last(
		String maCTV,
		com.liferay.portal.kernel.util.OrderByComparator<PhatVay>
			orderByComparator);

	/**
	 * Returns the phat vaies before and after the current phat vay in the ordered set where maCTV = &#63;.
	 *
	 * @param phatVayId the primary key of the current phat vay
	 * @param maCTV the ma ctv
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next phat vay
	 * @throws NoSuchPhatVayException if a phat vay with the primary key could not be found
	 */
	public PhatVay[] findByMaCTV_PrevAndNext(
			long phatVayId, String maCTV,
			com.liferay.portal.kernel.util.OrderByComparator<PhatVay>
				orderByComparator)
		throws NoSuchPhatVayException;

	/**
	 * Removes all the phat vaies where maCTV = &#63; from the database.
	 *
	 * @param maCTV the ma ctv
	 */
	public void removeByMaCTV(String maCTV);

	/**
	 * Returns the number of phat vaies where maCTV = &#63;.
	 *
	 * @param maCTV the ma ctv
	 * @return the number of matching phat vaies
	 */
	public int countByMaCTV(String maCTV);

	/**
	 * Returns the phat vay where soKU = &#63; or throws a <code>NoSuchPhatVayException</code> if it could not be found.
	 *
	 * @param soKU the so ku
	 * @return the matching phat vay
	 * @throws NoSuchPhatVayException if a matching phat vay could not be found
	 */
	public PhatVay findBySoKU(String soKU) throws NoSuchPhatVayException;

	/**
	 * Returns the phat vay where soKU = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param soKU the so ku
	 * @return the matching phat vay, or <code>null</code> if a matching phat vay could not be found
	 */
	public PhatVay fetchBySoKU(String soKU);

	/**
	 * Returns the phat vay where soKU = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param soKU the so ku
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching phat vay, or <code>null</code> if a matching phat vay could not be found
	 */
	public PhatVay fetchBySoKU(String soKU, boolean retrieveFromCache);

	/**
	 * Removes the phat vay where soKU = &#63; from the database.
	 *
	 * @param soKU the so ku
	 * @return the phat vay that was removed
	 */
	public PhatVay removeBySoKU(String soKU) throws NoSuchPhatVayException;

	/**
	 * Returns the number of phat vaies where soKU = &#63;.
	 *
	 * @param soKU the so ku
	 * @return the number of matching phat vaies
	 */
	public int countBySoKU(String soKU);

	/**
	 * Caches the phat vay in the entity cache if it is enabled.
	 *
	 * @param phatVay the phat vay
	 */
	public void cacheResult(PhatVay phatVay);

	/**
	 * Caches the phat vaies in the entity cache if it is enabled.
	 *
	 * @param phatVaies the phat vaies
	 */
	public void cacheResult(java.util.List<PhatVay> phatVaies);

	/**
	 * Creates a new phat vay with the primary key. Does not add the phat vay to the database.
	 *
	 * @param phatVayId the primary key for the new phat vay
	 * @return the new phat vay
	 */
	public PhatVay create(long phatVayId);

	/**
	 * Removes the phat vay with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param phatVayId the primary key of the phat vay
	 * @return the phat vay that was removed
	 * @throws NoSuchPhatVayException if a phat vay with the primary key could not be found
	 */
	public PhatVay remove(long phatVayId) throws NoSuchPhatVayException;

	public PhatVay updateImpl(PhatVay phatVay);

	/**
	 * Returns the phat vay with the primary key or throws a <code>NoSuchPhatVayException</code> if it could not be found.
	 *
	 * @param phatVayId the primary key of the phat vay
	 * @return the phat vay
	 * @throws NoSuchPhatVayException if a phat vay with the primary key could not be found
	 */
	public PhatVay findByPrimaryKey(long phatVayId)
		throws NoSuchPhatVayException;

	/**
	 * Returns the phat vay with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param phatVayId the primary key of the phat vay
	 * @return the phat vay, or <code>null</code> if a phat vay with the primary key could not be found
	 */
	public PhatVay fetchByPrimaryKey(long phatVayId);

	/**
	 * Returns all the phat vaies.
	 *
	 * @return the phat vaies
	 */
	public java.util.List<PhatVay> findAll();

	/**
	 * Returns a range of all the phat vaies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PhatVayModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of phat vaies
	 * @param end the upper bound of the range of phat vaies (not inclusive)
	 * @return the range of phat vaies
	 */
	public java.util.List<PhatVay> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the phat vaies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PhatVayModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of phat vaies
	 * @param end the upper bound of the range of phat vaies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of phat vaies
	 */
	public java.util.List<PhatVay> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PhatVay>
			orderByComparator);

	/**
	 * Returns an ordered range of all the phat vaies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PhatVayModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of phat vaies
	 * @param end the upper bound of the range of phat vaies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of phat vaies
	 */
	public java.util.List<PhatVay> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PhatVay>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the phat vaies from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of phat vaies.
	 *
	 * @return the number of phat vaies
	 */
	public int countAll();

}