/**
 * 
 */
package com.sy.oauth2.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhailiang
 *
 */
public interface RbacService {

    /**
     * 判断的是否拥有权限
     * @param permission
     * @return
     */
	boolean hasPermission(String permission);

}
