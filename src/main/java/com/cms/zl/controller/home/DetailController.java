package com.cms.zl.controller.home;

import com.cms.zl.entity.Article;
import com.cms.zl.entity.Profile;
import com.cms.zl.entity.User;
import com.cms.zl.service.IArticleService;
import com.cms.zl.service.ICommentService;
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

import java.sql.Timestamp;

/**
 * Created by Vincent on 2017/1/16.
 */
@Controller
@RequestMapping("/article")
public class DetailController {
    private final IArticleService articleService;
    private final IProfileService profileService;
    private final IUserService userService;
    private final ICommentService commentService;

    @Autowired
    public DetailController(IArticleService articleService, IProfileService profileService, IUserService userService, ICommentService commentService) {
        this.articleService = articleService;
        this.profileService = profileService;
        this.userService = userService;
        this.commentService = commentService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView viewFullText(@RequestParam(value = "id") String id, @RequestParam(value = "kind") String kind) {
        ModelAndView mav = new ModelAndView("/home/blog/detail");

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails) {
            User user = userService.getByUsername(((UserDetails) principal).getUsername());
            mav.addObject("user_id", user.getId());
        }

        Article article = articleService.get(id);
        mav.addObject("article", article);
        mav.addObject("comments", commentService.getByArticle(id));

        Article preArticle, nextArticle;
        if(kind.equals("index")) {
            preArticle = articleService.getPreArticle(article.getUpdateTime());
            nextArticle = articleService.getNextArticle(article.getUpdateTime());
        }
        else {
            preArticle = articleService.getPreArticleByKind(article.getKind(), article.getUpdateTime());
            nextArticle = articleService.getNextArticleByKind(article.getKind(), article.getUpdateTime());
        }
        mav.addObject("preArticle", preArticle);
        mav.addObject("nextArticle", nextArticle);
        mav.addObject("kind", kind);

        return mav;
    }
}
