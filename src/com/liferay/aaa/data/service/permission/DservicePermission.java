package com.liferay.aaa.data.service.permission;

import com.liferay.aaa.data.model.Dservice;
import com.liferay.aaa.data.service.DserviceLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class DservicePermission {
		
	public static void check(PermissionChecker permissionChecker,long dserviceId, String actionId) throws PortalException,SystemException {

        if (!contains(permissionChecker, dserviceId, actionId)) {
            throw new PrincipalException();
        }
    }
	
	public static boolean contains(PermissionChecker permissionChecker,long dserviceId, String actionId) throws PortalException,SystemException {

        Dservice dservice = DserviceLocalServiceUtil.getDservice(dserviceId);

        return permissionChecker.hasPermission(dservice.getGroupId(),Dservice.class.getName(), dservice.getDserviceId(),actionId);
}

}
