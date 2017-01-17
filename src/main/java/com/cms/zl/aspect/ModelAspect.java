package com.cms.zl.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.Entity;

/**
 * Created by Vincent on 2016/12/29.
 */
@Aspect
@Component
public class ModelAspect {
    @AfterReturning(value = "execution(org.springframework.web.servlet.ModelAndView com.cms.zl.controller..*(..))", returning = "mav")
    public void before(ModelAndView mav) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails) {
            mav.addObject("username", ((UserDetails) principal).getUsername());
            mav.addObject("authority_num", ((UserDetails) principal).getAuthorities().size());
        }
    }
}
