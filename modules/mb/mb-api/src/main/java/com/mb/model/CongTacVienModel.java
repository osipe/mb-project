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

package com.mb.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the CongTacVien service. Represents a row in the &quot;dm_congtacvien&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.mb.model.impl.CongTacVienModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.mb.model.impl.CongTacVienImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CongTacVien
 * @generated
 */
@ProviderType
public interface CongTacVienModel
	extends BaseModel<CongTacVien>, GroupedModel, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a cong tac vien model instance should use the {@link CongTacVien} interface instead.
	 */

	/**
	 * Returns the primary key of this cong tac vien.
	 *
	 * @return the primary key of this cong tac vien
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this cong tac vien.
	 *
	 * @param primaryKey the primary key of this cong tac vien
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the cong tac vien ID of this cong tac vien.
	 *
	 * @return the cong tac vien ID of this cong tac vien
	 */
	public long getCongTacVienId();

	/**
	 * Sets the cong tac vien ID of this cong tac vien.
	 *
	 * @param congTacVienId the cong tac vien ID of this cong tac vien
	 */
	public void setCongTacVienId(long congTacVienId);

	/**
	 * Returns the company ID of this cong tac vien.
	 *
	 * @return the company ID of this cong tac vien
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this cong tac vien.
	 *
	 * @param companyId the company ID of this cong tac vien
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this cong tac vien.
	 *
	 * @return the group ID of this cong tac vien
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this cong tac vien.
	 *
	 * @param groupId the group ID of this cong tac vien
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the user ID of this cong tac vien.
	 *
	 * @return the user ID of this cong tac vien
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this cong tac vien.
	 *
	 * @param userId the user ID of this cong tac vien
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this cong tac vien.
	 *
	 * @return the user uuid of this cong tac vien
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this cong tac vien.
	 *
	 * @param userUuid the user uuid of this cong tac vien
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this cong tac vien.
	 *
	 * @return the user name of this cong tac vien
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this cong tac vien.
	 *
	 * @param userName the user name of this cong tac vien
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this cong tac vien.
	 *
	 * @return the create date of this cong tac vien
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this cong tac vien.
	 *
	 * @param createDate the create date of this cong tac vien
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this cong tac vien.
	 *
	 * @return the modified date of this cong tac vien
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this cong tac vien.
	 *
	 * @param modifiedDate the modified date of this cong tac vien
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the ma of this cong tac vien.
	 *
	 * @return the ma of this cong tac vien
	 */
	@AutoEscape
	public String getMa();

	/**
	 * Sets the ma of this cong tac vien.
	 *
	 * @param ma the ma of this cong tac vien
	 */
	public void setMa(String ma);

	/**
	 * Returns the ho ten of this cong tac vien.
	 *
	 * @return the ho ten of this cong tac vien
	 */
	@AutoEscape
	public String getHoTen();

	/**
	 * Sets the ho ten of this cong tac vien.
	 *
	 * @param hoTen the ho ten of this cong tac vien
	 */
	public void setHoTen(String hoTen);

	/**
	 * Returns the so cmnd of this cong tac vien.
	 *
	 * @return the so cmnd of this cong tac vien
	 */
	@AutoEscape
	public String getSoCMND();

	/**
	 * Sets the so cmnd of this cong tac vien.
	 *
	 * @param soCMND the so cmnd of this cong tac vien
	 */
	public void setSoCMND(String soCMND);

	/**
	 * Returns the du no toi da of this cong tac vien.
	 *
	 * @return the du no toi da of this cong tac vien
	 */
	public Double getDuNoToiDa();

	/**
	 * Sets the du no toi da of this cong tac vien.
	 *
	 * @param duNoToiDa the du no toi da of this cong tac vien
	 */
	public void setDuNoToiDa(Double duNoToiDa);

	/**
	 * Returns the du no toi da the chap of this cong tac vien.
	 *
	 * @return the du no toi da the chap of this cong tac vien
	 */
	public Double getDuNoToiDaTheChap();

	/**
	 * Sets the du no toi da the chap of this cong tac vien.
	 *
	 * @param duNoToiDaTheChap the du no toi da the chap of this cong tac vien
	 */
	public void setDuNoToiDaTheChap(Double duNoToiDaTheChap);

	/**
	 * Returns the dia chi of this cong tac vien.
	 *
	 * @return the dia chi of this cong tac vien
	 */
	@AutoEscape
	public String getDiaChi();

	/**
	 * Sets the dia chi of this cong tac vien.
	 *
	 * @param diaChi the dia chi of this cong tac vien
	 */
	public void setDiaChi(String diaChi);

	/**
	 * Returns the ghi chu of this cong tac vien.
	 *
	 * @return the ghi chu of this cong tac vien
	 */
	@AutoEscape
	public String getGhiChu();

	/**
	 * Sets the ghi chu of this cong tac vien.
	 *
	 * @param ghiChu the ghi chu of this cong tac vien
	 */
	public void setGhiChu(String ghiChu);

	/**
	 * Returns the hoat dong of this cong tac vien.
	 *
	 * @return the hoat dong of this cong tac vien
	 */
	public Boolean getHoatDong();

	/**
	 * Sets the hoat dong of this cong tac vien.
	 *
	 * @param hoatDong the hoat dong of this cong tac vien
	 */
	public void setHoatDong(Boolean hoatDong);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(CongTacVien congTacVien);

	@Override
	public int hashCode();

	@Override
	public CacheModel<CongTacVien> toCacheModel();

	@Override
	public CongTacVien toEscapedModel();

	@Override
	public CongTacVien toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();

}