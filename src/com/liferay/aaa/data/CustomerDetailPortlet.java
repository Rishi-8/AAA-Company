package com.liferay.aaa.data;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.aaa.data.model.Customer;
import com.liferay.aaa.data.service.CustomerLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class CustomerDetailPortlet
 */
public class CustomerDetailPortlet extends MVCPortlet {
	
	public void addCustomer(ActionRequest request, ActionResponse response) throws PortalException, SystemException, IOException{
		
		changeCustomer(request);
		
		sendRedirect(request, response);
		
	}
	
	public void deleteCustomer(ActionRequest request, ActionResponse response) throws PortalException, SystemException, IOException{
		long customerId = ParamUtil.getLong(request, "customerId");
		CustomerLocalServiceUtil.deleteCustomer(customerId);
		sendRedirect(request, response);
	}
	
	public void updateCustomer(ActionRequest request, ActionResponse response) throws PortalException, SystemException, IOException{
		changeCustomer(request);
		sendRedirect(request, response);
	}
	
	private Customer changeCustomer(ActionRequest request) throws PortalException, SystemException{
		
		long customerId = ParamUtil.getLong(request, "customerId");
		long dserviceId = ParamUtil.getLong(request, "dserviceId");
		String customerName = ParamUtil.getString(request, "customerName");
		String customerEmail = ParamUtil.getString(request, "customerEmail");
		String customerAddress = ParamUtil.getString(request, "customerAddress");
		long customerNIC = ParamUtil.getLong(request, "customerNIC");
		long customerContact = ParamUtil.getLong(request, "customerContact");
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Customer.class.getName(), request);
		
		Customer customer = null;
		
		if(customerId<=0){
			System.out.println("Customer Added");
			customer = CustomerLocalServiceUtil.addCustomer(serviceContext.getUserId(), serviceContext.getScopeGroupId(), customerName, customerEmail, customerAddress, customerNIC, customerContact, dserviceId, serviceContext);
		}
		
		else {
			System.out.println("Customer Updated");
			customer = CustomerLocalServiceUtil.getCustomer(customerId);
			
			customer = CustomerLocalServiceUtil.updateCustomer(customerId, customerName, customerEmail, customerAddress, customerNIC, customerContact, dserviceId, serviceContext);
		}
		
		
		return customer;
	}
 

}
