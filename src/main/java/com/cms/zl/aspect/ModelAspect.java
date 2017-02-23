package com.cms.zl.aspect;

import com.cms.zl.entity.Profile;
import com.cms.zl.service.IProfileService;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final IProfileService profileService;

    @Autowired
    public ModelAspect(IProfileService profileService) {
        this.profileService = profileService;
    }

    @AfterReturning(value = "execution(org.springframework.web.servlet.ModelAndView com.cms.zl.controller..*(..))", returning = "mav")
    public void before(ModelAndView mav) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails) {
            mav.addObject("username", ((UserDetails) principal).getUsername());
            mav.addObject("authority_num", ((UserDetails) principal).getAuthorities().size());
        }
    }

    /**
     * 首先加载博客页面标签、个人资料等信息
     * @param mav
     */
    @AfterReturning(value = "execution(org.springframework.web.servlet.ModelAndView com.cms.zl.controller.home..*(..))", returning = "mav")
    public void loadPrimaryInfo(ModelAndView mav) {
        Profile profile = profileService.get(1);
        if (profile == null) profile = new Profile();
        mav.addObject("profile", profile);

        String[] labelList = new String[4];
        labelList = profile.getLabel().split("&");
        mav.addObject("labels", labelList);
    }
}
