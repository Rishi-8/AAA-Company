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

package com.liferay.aaa.data.model.impl;

import com.liferay.aaa.data.model.Dservice;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Dservice in entity cache.
 *
 * @author Rishikesh Dubey
 * @see Dservice
 * @generated
 */
public class DserviceCacheModel implements CacheModel<Dservice>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", dserviceId=");
		sb.append(dserviceId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", serviceTitle=");
		sb.append(serviceTitle);
		sb.append(", serviceDescription=");
		sb.append(serviceDescription);
		sb.append(", serviceRate=");
		sb.append(serviceRate);
		sb.append(", serviceDuration=");
		sb.append(serviceDuration);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Dservice toEntityModel() {
		DserviceImpl dserviceImpl = new DserviceImpl();

		if (uuid == null) {
			dserviceImpl.setUuid(StringPool.BLANK);
		}
		else {
			dserviceImpl.setUuid(uuid);
		}

		dserviceImpl.setDserviceId(dserviceId);
		dserviceImpl.setGroupId(groupId);
		dserviceImpl.setCompanyId(companyId);
		dserviceImpl.setUserId(userId);

		if (userName == null) {
			dserviceImpl.setUserName(StringPool.BLANK);
		}
		else {
			dserviceImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			dserviceImpl.setCreateDate(null);
		}
		else {
			dserviceImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			dserviceImpl.setModifiedDate(null);
		}
		else {
			dserviceImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (serviceTitle == null) {
			dserviceImpl.setServiceTitle(StringPool.BLANK);
		}
		else {
			dserviceImpl.setServiceTitle(serviceTitle);
		}

		if (serviceDescription == null) {
			dserviceImpl.setServiceDescription(StringPool.BLANK);
		}
		else {
			dserviceImpl.setServiceDescription(serviceDescription);
		}

		if (serviceRate == null) {
			dserviceImpl.setServiceRate(StringPool.BLANK);
		}
		else {
			dserviceImpl.setServiceRate(serviceRate);
		}

		if (serviceDuration == null) {
			dserviceImpl.setServiceDuration(StringPool.BLANK);
		}
		else {
			dserviceImpl.setServiceDuration(serviceDuration);
		}

		dserviceImpl.resetOriginalValues();

		return dserviceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		dserviceId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		serviceTitle = objectInput.readUTF();
		serviceDescription = objectInput.readUTF();
		serviceRate = objectInput.readUTF();
		serviceDuration = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(dserviceId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (serviceTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(serviceTitle);
		}

		if (serviceDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(serviceDescription);
		}

		if (serviceRate == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(serviceRate);
		}

		if (serviceDuration == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(serviceDuration);
		}
	}

	public String uuid;
	public long dserviceId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String serviceTitle;
	public String serviceDescription;
	public String serviceRate;
	public String serviceDuration;
}