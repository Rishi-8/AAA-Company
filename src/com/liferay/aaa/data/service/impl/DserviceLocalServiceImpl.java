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

package com.liferay.aaa.data.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.aaa.data.model.Dservice;
import com.liferay.aaa.data.service.base.DserviceLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the dservice local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.aaa.data.service.DserviceLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Rishikesh Dubey
 * @see com.liferay.aaa.data.service.base.DserviceLocalServiceBaseImpl
 * @see com.liferay.aaa.data.service.DserviceLocalServiceUtil
 */
public class DserviceLocalServiceImpl extends DserviceLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.aaa.data.service.DserviceLocalServiceUtil} to access the dservice local service.
	 */
	public List<Dservice> getDservicesByGroupId(long groupId) throws SystemException{
		return dservicePersistence.findByGroupId(groupId);
	}
	
	public List<Dservice> getDservicesByGroupId(long groupId, int start, int end) throws SystemException{
		return dservicePersistence.findByGroupId(groupId, start, end);
	}
	
	public int getDservicesCountByGroupId(long groupId) throws SystemException{
		return dservicePersistence.countByGroupId(groupId);
	}
	
	public Dservice addDservice(long userId, long groupId, String serviceTitle, String serviceDescription, String serviceRate, String serviceDuration, ServiceContext serviceContext ) throws PortalException, SystemException{
		User user = userPersistence.findByPrimaryKey(userId);
		
		Date now = new Date();
		
		long dserviceId = counterLocalService.increment(Dservice.class.getName());
		
		Dservice dservice = dservicePersistence.create(dserviceId);
		
		dservice.setGroupId(groupId);
		dservice.setServiceTitle(serviceTitle);
		dservice.setServiceDescription(serviceDescription);
		dservice.setServiceRate(serviceRate);
		dservice.setServiceDuration(serviceDuration);
		dservice.setUserId(user.getUserId());
		dservice.setUserName(user.getFullName());
		dservice.setCompanyId(user.getCompanyId());
		dservice.setCreateDate(serviceContext.getCreateDate(now));
		dservice.setModifiedDate(serviceContext.getModifiedDate(now));
		
		super.addDservice(dservice);
		resourceLocalService.addResources(user.getCompanyId(), groupId, userId, Dservice.class.getName(), dserviceId, false, true, true);
		return dservice;	
	}
	
	public Dservice deleteDservice(Dservice dservice) throws SystemException{
		return dservicePersistence.remove(dservice);
	}
	
	public Dservice deleteDservice(long dserviceId) throws SystemException, PortalException{
		ServiceContext serviceContext = new ServiceContext();
		Dservice dservice = dservicePersistence.fetchByPrimaryKey(dserviceId);
		resourceLocalService.deleteResource(serviceContext.getCompanyId(), Dservice.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, dserviceId);
		return deleteDservice(dservice);
	}
	
	public Dservice updateDservice(long dserviceId, String serviceTitle, String serviceDescription, String serviceRate, String serviceDuration, ServiceContext serviceContext) throws PortalException, SystemException{
		Date now = new Date();
		
		long userId = serviceContext.getUserId();
		User user = userPersistence.fetchByPrimaryKey(userId);
		
		long groupId = serviceContext.getScopeGroupId();
		Dservice dservice = dservicePersistence.findByPrimaryKey(dserviceId);
		
		dservice.setServiceTitle(serviceTitle);
		dservice.setServiceDescription(serviceDescription);
		dservice.setServiceRate(serviceRate);
		dservice.setServiceDuration(serviceDuration);
		dservice.setModifiedDate(serviceContext.getModifiedDate(now));
		
		super.updateDservice(dservice);
		resourceLocalService.updateResources(user.getCompanyId(), groupId, Dservice.class.getName(), dserviceId, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}