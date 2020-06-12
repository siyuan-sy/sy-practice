/**
 *
 */
package com.sy.oauth2.service.impl;

import com.sy.oauth2.service.RbacService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.CollectionUtils;
import org.springframework.util.PatternMatchUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

/**
 * @author zhailiang
 *
 */
@Component("ss")
public class RbacServiceImpl implements RbacService {
    /** 所有权限标识 */
    private static final String ALL_PERMISSION = "*:*:*";
    /**
     * 判断是否匹配
     */
    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    private boolean hasPermissions(Collection<? extends GrantedAuthority> authorities, String permission) {
        return authorities.stream().map(GrantedAuthority::getAuthority).filter(StringUtils::hasText)
                .anyMatch(x -> ALL_PERMISSION.contains(x) || PatternMatchUtils.simpleMatch(permission, x));
    }

    @Override
    public boolean hasPermission(String permission) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        System.out.println("principal = " + principal);
        Collection<? extends GrantedAuthority> authorities =
                authentication.getAuthorities();
        if (!CollectionUtils.isEmpty(authorities)) {
            return this.hasPermissions(authorities, permission);
        }
        // 这里的Admin是用户实体类，不是管理员的意思
		/*if (principal instanceof Admin) {
			//如果用户名是admin，就永远返回true
			if (StringUtils.equals(((Admin) principal).getUsername(), "admin")) {
				hasPermission = true;
			} else {
				// 读取用户所拥有权限的所有URL
				Set<String> urls = ((Admin) principal).getUrls();
				//循环所有的url,进行授权
				for (String url : urls) {
				    //如果url匹配,进行授权
					if (antPathMatcher.match(url, request.getRequestURI())) {
						hasPermission = true;
						break;
					}
				}
			}
		}*/

        return false;
    }

}
