package com.cms.zl.controller.home;

import com.cms.zl.entity.Article;
import com.cms.zl.entity.Profile;
import com.cms.zl.service.IArticleService;
import com.cms.zl.service.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vincent on 2016/12/25.
 */
@Controller
@RequestMapping("/blog")
public class BlogController {
    private final IProfileService profileService;
    private final IArticleService articleService;

    @Autowired
    public BlogController(IProfileService profileService, IArticleService articleService) {
        this.profileService = profileService;
        this.articleService = articleService;
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
        if (profile == null) profile = new Profile();
        mav.addObject("profile", profile);

        String[] labelList = new String[4];
        labelList = profile.getLabel().split("&");
        mav.addObject("labels", labelList);

        Page<Article> articlePage = articleService.get(0, 5);
        System.out.println(articlePage.getNumber());
        mav.addObject("articles", articlePage.getContent());

        return mav;
    }
}
