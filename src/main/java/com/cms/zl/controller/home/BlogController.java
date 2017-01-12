package com.cms.zl.controller.home;

import com.cms.zl.entity.Profile;
import com.cms.zl.service.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Vincent on 2016/12/25.
 */
@Controller
@RequestMapping("/blog")
public class BlogController {
    private final IProfileService profileService;

    @Autowired
    public BlogController(IProfileService profileService) {
        this.profileService = profileService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView blog() {
        ModelAndView mav = new ModelAndView("redirect:/blog/index");
        return mav;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("/home/blog/index");
        Profile profile = profileService.get(1);
        mav.addObject("profile", profile);
        return mav;
    }
}
