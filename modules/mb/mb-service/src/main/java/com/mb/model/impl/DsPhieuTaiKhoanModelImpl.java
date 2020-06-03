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

package com.mb.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import com.mb.model.DsPhieuTaiKhoan;
import com.mb.model.DsPhieuTaiKhoanModel;
import com.mb.model.DsPhieuTaiKhoanSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the DsPhieuTaiKhoan service. Represents a row in the &quot;ketoan_dsphieutaikhoan&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>DsPhieuTaiKhoanModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DsPhieuTaiKhoanImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DsPhieuTaiKhoanImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class DsPhieuTaiKhoanModelImpl
	extends BaseModelImpl<DsPhieuTaiKhoan> implements DsPhieuTaiKhoanModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a ds phieu tai khoan model instance should use the <code>DsPhieuTaiKhoan</code> interface instead.
	 */
	public static final String TABLE_NAME = "ketoan_dsphieutaikhoan";

	public static final Object[][] TABLE_COLUMNS = {
		{"dsPhieuTaiKhoanId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"phieuId", Types.BIGINT},
		{"ngayChungTu", Types.TIMESTAMP}, {"taiKhoanDoiUngId", Types.BIGINT},
		{"maTheoDoi", Types.VARCHAR}, {"dienGiaiTheoDoi", Types.VARCHAR},
		{"soTien", Types.DOUBLE}, {"hoatDong", Types.BOOLEAN}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("dsPhieuTaiKhoanId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("phieuId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("ngayChungTu", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("taiKhoanDoiUngId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("maTheoDoi", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("dienGiaiTheoDoi", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("soTien", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("hoatDong", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE =
		"create table ketoan_dsphieutaikhoan (dsPhieuTaiKhoanId LONG not null primary key,companyId LONG,groupId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,phieuId LONG,ngayChungTu DATE null,taiKhoanDoiUngId LONG,maTheoDoi VARCHAR(75) null,dienGiaiTheoDoi VARCHAR(75) null,soTien DOUBLE,hoatDong BOOLEAN)";

	public static final String TABLE_SQL_DROP =
		"drop table ketoan_dsphieutaikhoan";

	public static final String ORDER_BY_JPQL =
		" ORDER BY dsPhieuTaiKhoan.dsPhieuTaiKhoanId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY ketoan_dsphieutaikhoan.dsPhieuTaiKhoanId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		com.mb.service.util.ServiceProps.get(
			"value.object.entity.cache.enabled.com.mb.model.DsPhieuTaiKhoan"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		com.mb.service.util.ServiceProps.get(
			"value.object.finder.cache.enabled.com.mb.model.DsPhieuTaiKhoan"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		com.mb.service.util.ServiceProps.get(
			"value.object.column.bitmask.enabled.com.mb.model.DsPhieuTaiKhoan"),
		true);

	public static final long HOATDONG_COLUMN_BITMASK = 1L;

	public static final long PHIEUID_COLUMN_BITMASK = 2L;

	public static final long TAIKHOANDOIUNGID_COLUMN_BITMASK = 4L;

	public static final long DSPHIEUTAIKHOANID_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static DsPhieuTaiKhoan toModel(DsPhieuTaiKhoanSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		DsPhieuTaiKhoan model = new DsPhieuTaiKhoanImpl();

		model.setDsPhieuTaiKhoanId(soapModel.getDsPhieuTaiKhoanId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setGroupId(soapModel.getGroupId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setPhieuId(soapModel.getPhieuId());
		model.setNgayChungTu(soapModel.getNgayChungTu());
		model.setTaiKhoanDoiUngId(soapModel.getTaiKhoanDoiUngId());
		model.setMaTheoDoi(soapModel.getMaTheoDoi());
		model.setDienGiaiTheoDoi(soapModel.getDienGiaiTheoDoi());
		model.setSoTien(soapModel.getSoTien());
		model.setHoatDong(soapModel.getHoatDong());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<DsPhieuTaiKhoan> toModels(
		DsPhieuTaiKhoanSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<DsPhieuTaiKhoan> models = new ArrayList<DsPhieuTaiKhoan>(
			soapModels.length);

		for (DsPhieuTaiKhoanSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.mb.service.util.ServiceProps.get(
			"lock.expiration.time.com.mb.model.DsPhieuTaiKhoan"));

	public DsPhieuTaiKhoanModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _dsPhieuTaiKhoanId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDsPhieuTaiKhoanId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dsPhieuTaiKhoanId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return DsPhieuTaiKhoan.class;
	}

	@Override
	public String getModelClassName() {
		return DsPhieuTaiKhoan.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<DsPhieuTaiKhoan, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<DsPhieuTaiKhoan, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DsPhieuTaiKhoan, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((DsPhieuTaiKhoan)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<DsPhieuTaiKhoan, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<DsPhieuTaiKhoan, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(DsPhieuTaiKhoan)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<DsPhieuTaiKhoan, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<DsPhieuTaiKhoan, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<DsPhieuTaiKhoan, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<DsPhieuTaiKhoan, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<DsPhieuTaiKhoan, Object>>
			attributeGetterFunctions =
				new LinkedHashMap<String, Function<DsPhieuTaiKhoan, Object>>();
		Map<String, BiConsumer<DsPhieuTaiKhoan, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<DsPhieuTaiKhoan, ?>>();

		attributeGetterFunctions.put(
			"dsPhieuTaiKhoanId",
			new Function<DsPhieuTaiKhoan, Object>() {

				@Override
				public Object apply(DsPhieuTaiKhoan dsPhieuTaiKhoan) {
					return dsPhieuTaiKhoan.getDsPhieuTaiKhoanId();
				}

			});
		attributeSetterBiConsumers.put(
			"dsPhieuTaiKhoanId",
			new BiConsumer<DsPhieuTaiKhoan, Object>() {

				@Override
				public void accept(
					DsPhieuTaiKhoan dsPhieuTaiKhoan, Object dsPhieuTaiKhoanId) {

					dsPhieuTaiKhoan.setDsPhieuTaiKhoanId(
						(Long)dsPhieuTaiKhoanId);
				}

			});
		attributeGetterFunctions.put(
			"companyId",
			new Function<DsPhieuTaiKhoan, Object>() {

				@Override
				public Object apply(DsPhieuTaiKhoan dsPhieuTaiKhoan) {
					return dsPhieuTaiKhoan.getCompanyId();
				}

			});
		attributeSetterBiConsumers.put(
			"companyId",
			new BiConsumer<DsPhieuTaiKhoan, Object>() {

				@Override
				public void accept(
					DsPhieuTaiKhoan dsPhieuTaiKhoan, Object companyId) {

					dsPhieuTaiKhoan.setCompanyId((Long)companyId);
				}

			});
		attributeGetterFunctions.put(
			"groupId",
			new Function<DsPhieuTaiKhoan, Object>() {

				@Override
				public Object apply(DsPhieuTaiKhoan dsPhieuTaiKhoan) {
					return dsPhieuTaiKhoan.getGroupId();
				}

			});
		attributeSetterBiConsumers.put(
			"groupId",
			new BiConsumer<DsPhieuTaiKhoan, Object>() {

				@Override
				public void accept(
					DsPhieuTaiKhoan dsPhieuTaiKhoan, Object groupId) {

					dsPhieuTaiKhoan.setGroupId((Long)groupId);
				}

			});
		attributeGetterFunctions.put(
			"userId",
			new Function<DsPhieuTaiKhoan, Object>() {

				@Override
				public Object apply(DsPhieuTaiKhoan dsPhieuTaiKhoan) {
					return dsPhieuTaiKhoan.getUserId();
				}

			});
		attributeSetterBiConsumers.put(
			"userId",
			new BiConsumer<DsPhieuTaiKhoan, Object>() {

				@Override
				public void accept(
					DsPhieuTaiKhoan dsPhieuTaiKhoan, Object userId) {

					dsPhieuTaiKhoan.setUserId((Long)userId);
				}

			});
		attributeGetterFunctions.put(
			"userName",
			new Function<DsPhieuTaiKhoan, Object>() {

				@Override
				public Object apply(DsPhieuTaiKhoan dsPhieuTaiKhoan) {
					return dsPhieuTaiKhoan.getUserName();
				}

			});
		attributeSetterBiConsumers.put(
			"userName",
			new BiConsumer<DsPhieuTaiKhoan, Object>() {

				@Override
				public void accept(
					DsPhieuTaiKhoan dsPhieuTaiKhoan, Object userName) {

					dsPhieuTaiKhoan.setUserName((String)userName);
				}

			});
		attributeGetterFunctions.put(
			"createDate",
			new Function<DsPhieuTaiKhoan, Object>() {

				@Override
				public Object apply(DsPhieuTaiKhoan dsPhieuTaiKhoan) {
					return dsPhieuTaiKhoan.getCreateDate();
				}

			});
		attributeSetterBiConsumers.put(
			"createDate",
			new BiConsumer<DsPhieuTaiKhoan, Object>() {

				@Override
				public void accept(
					DsPhieuTaiKhoan dsPhieuTaiKhoan, Object createDate) {

					dsPhieuTaiKhoan.setCreateDate((Date)createDate);
				}

			});
		attributeGetterFunctions.put(
			"modifiedDate",
			new Function<DsPhieuTaiKhoan, Object>() {

				@Override
				public Object apply(DsPhieuTaiKhoan dsPhieuTaiKhoan) {
					return dsPhieuTaiKhoan.getModifiedDate();
				}

			});
		attributeSetterBiConsumers.put(
			"modifiedDate",
			new BiConsumer<DsPhieuTaiKhoan, Object>() {

				@Override
				public void accept(
					DsPhieuTaiKhoan dsPhieuTaiKhoan, Object modifiedDate) {

					dsPhieuTaiKhoan.setModifiedDate((Date)modifiedDate);
				}

			});
		attributeGetterFunctions.put(
			"phieuId",
			new Function<DsPhieuTaiKhoan, Object>() {

				@Override
				public Object apply(DsPhieuTaiKhoan dsPhieuTaiKhoan) {
					return dsPhieuTaiKhoan.getPhieuId();
				}

			});
		attributeSetterBiConsumers.put(
			"phieuId",
			new BiConsumer<DsPhieuTaiKhoan, Object>() {

				@Override
				public void accept(
					DsPhieuTaiKhoan dsPhieuTaiKhoan, Object phieuId) {

					dsPhieuTaiKhoan.setPhieuId((Long)phieuId);
				}

			});
		attributeGetterFunctions.put(
			"ngayChungTu",
			new Function<DsPhieuTaiKhoan, Object>() {

				@Override
				public Object apply(DsPhieuTaiKhoan dsPhieuTaiKhoan) {
					return dsPhieuTaiKhoan.getNgayChungTu();
				}

			});
		attributeSetterBiConsumers.put(
			"ngayChungTu",
			new BiConsumer<DsPhieuTaiKhoan, Object>() {

				@Override
				public void accept(
					DsPhieuTaiKhoan dsPhieuTaiKhoan, Object ngayChungTu) {

					dsPhieuTaiKhoan.setNgayChungTu((Date)ngayChungTu);
				}

			});
		attributeGetterFunctions.put(
			"taiKhoanDoiUngId",
			new Function<DsPhieuTaiKhoan, Object>() {

				@Override
				public Object apply(DsPhieuTaiKhoan dsPhieuTaiKhoan) {
					return dsPhieuTaiKhoan.getTaiKhoanDoiUngId();
				}

			});
		attributeSetterBiConsumers.put(
			"taiKhoanDoiUngId",
			new BiConsumer<DsPhieuTaiKhoan, Object>() {

				@Override
				public void accept(
					DsPhieuTaiKhoan dsPhieuTaiKhoan, Object taiKhoanDoiUngId) {

					dsPhieuTaiKhoan.setTaiKhoanDoiUngId((Long)taiKhoanDoiUngId);
				}

			});
		attributeGetterFunctions.put(
			"maTheoDoi",
			new Function<DsPhieuTaiKhoan, Object>() {

				@Override
				public Object apply(DsPhieuTaiKhoan dsPhieuTaiKhoan) {
					return dsPhieuTaiKhoan.getMaTheoDoi();
				}

			});
		attributeSetterBiConsumers.put(
			"maTheoDoi",
			new BiConsumer<DsPhieuTaiKhoan, Object>() {

				@Override
				public void accept(
					DsPhieuTaiKhoan dsPhieuTaiKhoan, Object maTheoDoi) {

					dsPhieuTaiKhoan.setMaTheoDoi((String)maTheoDoi);
				}

			});
		attributeGetterFunctions.put(
			"dienGiaiTheoDoi",
			new Function<DsPhieuTaiKhoan, Object>() {

				@Override
				public Object apply(DsPhieuTaiKhoan dsPhieuTaiKhoan) {
					return dsPhieuTaiKhoan.getDienGiaiTheoDoi();
				}

			});
		attributeSetterBiConsumers.put(
			"dienGiaiTheoDoi",
			new BiConsumer<DsPhieuTaiKhoan, Object>() {

				@Override
				public void accept(
					DsPhieuTaiKhoan dsPhieuTaiKhoan, Object dienGiaiTheoDoi) {

					dsPhieuTaiKhoan.setDienGiaiTheoDoi((String)dienGiaiTheoDoi);
				}

			});
		attributeGetterFunctions.put(
			"soTien",
			new Function<DsPhieuTaiKhoan, Object>() {

				@Override
				public Object apply(DsPhieuTaiKhoan dsPhieuTaiKhoan) {
					return dsPhieuTaiKhoan.getSoTien();
				}

			});
		attributeSetterBiConsumers.put(
			"soTien",
			new BiConsumer<DsPhieuTaiKhoan, Object>() {

				@Override
				public void accept(
					DsPhieuTaiKhoan dsPhieuTaiKhoan, Object soTien) {

					dsPhieuTaiKhoan.setSoTien((Double)soTien);
				}

			});
		attributeGetterFunctions.put(
			"hoatDong",
			new Function<DsPhieuTaiKhoan, Object>() {

				@Override
				public Object apply(DsPhieuTaiKhoan dsPhieuTaiKhoan) {
					return dsPhieuTaiKhoan.getHoatDong();
				}

			});
		attributeSetterBiConsumers.put(
			"hoatDong",
			new BiConsumer<DsPhieuTaiKhoan, Object>() {

				@Override
				public void accept(
					DsPhieuTaiKhoan dsPhieuTaiKhoan, Object hoatDong) {

					dsPhieuTaiKhoan.setHoatDong((Boolean)hoatDong);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getDsPhieuTaiKhoanId() {
		return _dsPhieuTaiKhoanId;
	}

	@Override
	public void setDsPhieuTaiKhoanId(long dsPhieuTaiKhoanId) {
		_columnBitmask = -1L;

		_dsPhieuTaiKhoanId = dsPhieuTaiKhoanId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public long getPhieuId() {
		return _phieuId;
	}

	@Override
	public void setPhieuId(long phieuId) {
		_columnBitmask |= PHIEUID_COLUMN_BITMASK;

		if (!_setOriginalPhieuId) {
			_setOriginalPhieuId = true;

			_originalPhieuId = _phieuId;
		}

		_phieuId = phieuId;
	}

	public long getOriginalPhieuId() {
		return _originalPhieuId;
	}

	@JSON
	@Override
	public Date getNgayChungTu() {
		return _ngayChungTu;
	}

	@Override
	public void setNgayChungTu(Date ngayChungTu) {
		_ngayChungTu = ngayChungTu;
	}

	@JSON
	@Override
	public long getTaiKhoanDoiUngId() {
		return _taiKhoanDoiUngId;
	}

	@Override
	public void setTaiKhoanDoiUngId(long taiKhoanDoiUngId) {
		_columnBitmask |= TAIKHOANDOIUNGID_COLUMN_BITMASK;

		if (!_setOriginalTaiKhoanDoiUngId) {
			_setOriginalTaiKhoanDoiUngId = true;

			_originalTaiKhoanDoiUngId = _taiKhoanDoiUngId;
		}

		_taiKhoanDoiUngId = taiKhoanDoiUngId;
	}

	public long getOriginalTaiKhoanDoiUngId() {
		return _originalTaiKhoanDoiUngId;
	}

	@JSON
	@Override
	public String getMaTheoDoi() {
		if (_maTheoDoi == null) {
			return "";
		}
		else {
			return _maTheoDoi;
		}
	}

	@Override
	public void setMaTheoDoi(String maTheoDoi) {
		_maTheoDoi = maTheoDoi;
	}

	@JSON
	@Override
	public String getDienGiaiTheoDoi() {
		if (_dienGiaiTheoDoi == null) {
			return "";
		}
		else {
			return _dienGiaiTheoDoi;
		}
	}

	@Override
	public void setDienGiaiTheoDoi(String dienGiaiTheoDoi) {
		_dienGiaiTheoDoi = dienGiaiTheoDoi;
	}

	@JSON
	@Override
	public Double getSoTien() {
		return _soTien;
	}

	@Override
	public void setSoTien(Double soTien) {
		_soTien = soTien;
	}

	@JSON
	@Override
	public Boolean getHoatDong() {
		return _hoatDong;
	}

	@Override
	public void setHoatDong(Boolean hoatDong) {
		_columnBitmask |= HOATDONG_COLUMN_BITMASK;

		if (!_setOriginalHoatDong) {
			_setOriginalHoatDong = true;

			_originalHoatDong = _hoatDong;
		}

		_hoatDong = hoatDong;
	}

	public Boolean getOriginalHoatDong() {
		return _originalHoatDong;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), DsPhieuTaiKhoan.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public DsPhieuTaiKhoan toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (DsPhieuTaiKhoan)ProxyUtil.newProxyInstance(
				_classLoader, _escapedModelInterfaces,
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		DsPhieuTaiKhoanImpl dsPhieuTaiKhoanImpl = new DsPhieuTaiKhoanImpl();

		dsPhieuTaiKhoanImpl.setDsPhieuTaiKhoanId(getDsPhieuTaiKhoanId());
		dsPhieuTaiKhoanImpl.setCompanyId(getCompanyId());
		dsPhieuTaiKhoanImpl.setGroupId(getGroupId());
		dsPhieuTaiKhoanImpl.setUserId(getUserId());
		dsPhieuTaiKhoanImpl.setUserName(getUserName());
		dsPhieuTaiKhoanImpl.setCreateDate(getCreateDate());
		dsPhieuTaiKhoanImpl.setModifiedDate(getModifiedDate());
		dsPhieuTaiKhoanImpl.setPhieuId(getPhieuId());
		dsPhieuTaiKhoanImpl.setNgayChungTu(getNgayChungTu());
		dsPhieuTaiKhoanImpl.setTaiKhoanDoiUngId(getTaiKhoanDoiUngId());
		dsPhieuTaiKhoanImpl.setMaTheoDoi(getMaTheoDoi());
		dsPhieuTaiKhoanImpl.setDienGiaiTheoDoi(getDienGiaiTheoDoi());
		dsPhieuTaiKhoanImpl.setSoTien(getSoTien());
		dsPhieuTaiKhoanImpl.setHoatDong(getHoatDong());

		dsPhieuTaiKhoanImpl.resetOriginalValues();

		return dsPhieuTaiKhoanImpl;
	}

	@Override
	public int compareTo(DsPhieuTaiKhoan dsPhieuTaiKhoan) {
		int value = 0;

		if (getDsPhieuTaiKhoanId() < dsPhieuTaiKhoan.getDsPhieuTaiKhoanId()) {
			value = -1;
		}
		else if (getDsPhieuTaiKhoanId() >
					dsPhieuTaiKhoan.getDsPhieuTaiKhoanId()) {

			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DsPhieuTaiKhoan)) {
			return false;
		}

		DsPhieuTaiKhoan dsPhieuTaiKhoan = (DsPhieuTaiKhoan)obj;

		long primaryKey = dsPhieuTaiKhoan.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		DsPhieuTaiKhoanModelImpl dsPhieuTaiKhoanModelImpl = this;

		dsPhieuTaiKhoanModelImpl._setModifiedDate = false;

		dsPhieuTaiKhoanModelImpl._originalPhieuId =
			dsPhieuTaiKhoanModelImpl._phieuId;

		dsPhieuTaiKhoanModelImpl._setOriginalPhieuId = false;

		dsPhieuTaiKhoanModelImpl._originalTaiKhoanDoiUngId =
			dsPhieuTaiKhoanModelImpl._taiKhoanDoiUngId;

		dsPhieuTaiKhoanModelImpl._setOriginalTaiKhoanDoiUngId = false;

		dsPhieuTaiKhoanModelImpl._originalHoatDong =
			dsPhieuTaiKhoanModelImpl._hoatDong;

		dsPhieuTaiKhoanModelImpl._setOriginalHoatDong = false;

		dsPhieuTaiKhoanModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<DsPhieuTaiKhoan> toCacheModel() {
		DsPhieuTaiKhoanCacheModel dsPhieuTaiKhoanCacheModel =
			new DsPhieuTaiKhoanCacheModel();

		dsPhieuTaiKhoanCacheModel.dsPhieuTaiKhoanId = getDsPhieuTaiKhoanId();

		dsPhieuTaiKhoanCacheModel.companyId = getCompanyId();

		dsPhieuTaiKhoanCacheModel.groupId = getGroupId();

		dsPhieuTaiKhoanCacheModel.userId = getUserId();

		dsPhieuTaiKhoanCacheModel.userName = getUserName();

		String userName = dsPhieuTaiKhoanCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			dsPhieuTaiKhoanCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			dsPhieuTaiKhoanCacheModel.createDate = createDate.getTime();
		}
		else {
			dsPhieuTaiKhoanCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			dsPhieuTaiKhoanCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			dsPhieuTaiKhoanCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		dsPhieuTaiKhoanCacheModel.phieuId = getPhieuId();

		Date ngayChungTu = getNgayChungTu();

		if (ngayChungTu != null) {
			dsPhieuTaiKhoanCacheModel.ngayChungTu = ngayChungTu.getTime();
		}
		else {
			dsPhieuTaiKhoanCacheModel.ngayChungTu = Long.MIN_VALUE;
		}

		dsPhieuTaiKhoanCacheModel.taiKhoanDoiUngId = getTaiKhoanDoiUngId();

		dsPhieuTaiKhoanCacheModel.maTheoDoi = getMaTheoDoi();

		String maTheoDoi = dsPhieuTaiKhoanCacheModel.maTheoDoi;

		if ((maTheoDoi != null) && (maTheoDoi.length() == 0)) {
			dsPhieuTaiKhoanCacheModel.maTheoDoi = null;
		}

		dsPhieuTaiKhoanCacheModel.dienGiaiTheoDoi = getDienGiaiTheoDoi();

		String dienGiaiTheoDoi = dsPhieuTaiKhoanCacheModel.dienGiaiTheoDoi;

		if ((dienGiaiTheoDoi != null) && (dienGiaiTheoDoi.length() == 0)) {
			dsPhieuTaiKhoanCacheModel.dienGiaiTheoDoi = null;
		}

		dsPhieuTaiKhoanCacheModel.soTien = getSoTien();

		dsPhieuTaiKhoanCacheModel.hoatDong = getHoatDong();

		return dsPhieuTaiKhoanCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<DsPhieuTaiKhoan, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<DsPhieuTaiKhoan, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DsPhieuTaiKhoan, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((DsPhieuTaiKhoan)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<DsPhieuTaiKhoan, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<DsPhieuTaiKhoan, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DsPhieuTaiKhoan, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((DsPhieuTaiKhoan)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader =
		DsPhieuTaiKhoan.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
		DsPhieuTaiKhoan.class, ModelWrapper.class
	};

	private long _dsPhieuTaiKhoanId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _phieuId;
	private long _originalPhieuId;
	private boolean _setOriginalPhieuId;
	private Date _ngayChungTu;
	private long _taiKhoanDoiUngId;
	private long _originalTaiKhoanDoiUngId;
	private boolean _setOriginalTaiKhoanDoiUngId;
	private String _maTheoDoi;
	private String _dienGiaiTheoDoi;
	private Double _soTien;
	private Boolean _hoatDong;
	private Boolean _originalHoatDong;
	private boolean _setOriginalHoatDong;
	private long _columnBitmask;
	private DsPhieuTaiKhoan _escapedModel;

}