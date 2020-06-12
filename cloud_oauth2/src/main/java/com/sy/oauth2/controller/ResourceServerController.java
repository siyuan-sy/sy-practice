package com.sy.oauth2.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author siyuan
 * @create 2020/6/11
 */
@RestController
@RequestMapping("/resource")
public class ResourceServerController {


    @GetMapping("/me")
    public Authentication me(Authentication authentication) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("principal = " + principal);
        return authentication;
    }

    @PreAuthorize("@ss.hasPermission('system:config:list')")
    @GetMapping("/test")
    public  Object test(){
        return "思源";
    }

    @GetMapping("/permission")
    @PreAuthorize("@ss.hasPermission('SystemContentDelete')")
    public  Object permission(){
        return "siyuan";
    }
}
