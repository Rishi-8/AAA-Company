package com.liferay.aaa.data;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.aaa.data.model.Dservice;
import com.liferay.aaa.data.service.DserviceLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ServiceDetailPortlet
 */
public class ServiceDetailPortlet extends MVCPortlet {
	
	public void addDservice(ActionRequest request, ActionResponse response) throws PortalException, SystemException, IOException{
		changeDservice(request);
		sendRedirect(request, response);
	}
	
	public void deleteDservice(ActionRequest request, ActionResponse response) throws PortalException, SystemException, IOException{
		long dserviceId = ParamUtil.getLong(request, "dserviceId");
		DserviceLocalServiceUtil.deleteDservice(dserviceId);
		sendRedirect(request, response);
	}
	
	public void updateDservice(ActionRequest request, ActionResponse response) throws PortalException, SystemException, IOException{
		changeDservice(request);
		sendRedirect(request, response);
	}
 
	private Dservice changeDservice(ActionRequest request) throws PortalException, SystemException{
		
		long dserviceId = ParamUtil.getLong(request, "dserviceId");
		String serviceTitle = ParamUtil.getString(request, "serviceTitle");
		String serviceDescription = ParamUtil.getString(request, "serviceDescription");
		String serviceRate = ParamUtil.getString(request, "serviceRate");
		String serviceDuration = ParamUtil.getString(request, "serviceDuration");
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Dservice.class.getName(), request);
		
		Dservice dservice = null;
		
		if(dserviceId<=0){
			dservice = DserviceLocalServiceUtil.addDservice(serviceContext.getUserId(), serviceContext.getScopeGroupId(), serviceTitle, serviceDescription, serviceRate, serviceDuration, serviceContext);
			System.out.println("Service Added");
		}
		else{
			System.out.println("Service Updated");
			dservice = DserviceLocalServiceUtil.getDservice(dserviceId);
			dservice = DserviceLocalServiceUtil.updateDservice(dserviceId, serviceTitle, serviceDescription, serviceRate, serviceDuration, serviceContext);
		}
		
		return dservice;
		
	}

}
