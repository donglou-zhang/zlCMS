package com.cms.zl.controller.home;

import com.cms.zl.entity.Article;
import com.cms.zl.entity.Profile;
import com.cms.zl.entity.User;
import com.cms.zl.service.IArticleService;
import com.cms.zl.service.IProfileService;
import com.cms.zl.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
    private final IUserService userService;

    @Autowired
    public DetailController(IArticleService articleService, IProfileService profileService, IUserService userService) {
        this.articleService = articleService;
        this.profileService = profileService;
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView viewFullText(@RequestParam(value = "id") String id) {
        ModelAndView mav = new ModelAndView("/home/blog/detail");

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails) {
            User user = userService.getByUsername(((UserDetails) principal).getUsername());
            mav.addObject("user_id", user.getId());
        }

        Profile profile = profileService.get(1);
        if (profile == null) profile = new Profile();

        String[] labelList = new String[4];
        labelList = profile.getLabel().split("&");
        mav.addObject("labels", labelList);

        Article article = articleService.get(id);
        mav.addObject("article", article);

        return mav;
    }
}
