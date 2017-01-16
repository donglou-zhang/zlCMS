package com.cms.zl.controller.home;

import com.cms.zl.entity.Profile;
import com.cms.zl.service.IArticleService;
import com.cms.zl.service.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Vincent on 2017/1/16.
 */
@Controller
@RequestMapping("/article")
public class DetailController {
    private final IArticleService articleService;
    private final IProfileService profileService;

    @Autowired
    public DetailController(IArticleService articleService, IProfileService profileService) {
        this.articleService = articleService;
        this.profileService = profileService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView viewFullText(@RequestParam(value = "id") String id) {
        ModelAndView mav = new ModelAndView("/home/blog/detail");
        Profile profile = profileService.get(1);
        if (profile == null) profile = new Profile();

        String[] labelList = new String[4];
        labelList = profile.getLabel().split("&");
        mav.addObject("labels", labelList);
        return mav;
    }
}
