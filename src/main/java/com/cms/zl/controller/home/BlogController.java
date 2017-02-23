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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
        Page<Article> articlePage = articleService.get(0, 5);
        mav.addObject("articles", articlePage.getContent());
        mav.addObject("kind", "index");
        return mav;
    }

    @RequestMapping(value = "/coding", method = RequestMethod.GET)
    public ModelAndView coding() {
        ModelAndView mav = new ModelAndView("/home/blog/index");
        Page<Article> articlePage = articleService.getByKind(0, 5, "coding");
        mav.addObject("articles", articlePage.getContent());
        mav.addObject("kind", "coding");
        return mav;
    }

    @RequestMapping(value = "/reading", method = RequestMethod.GET)
    public ModelAndView reading() {
        ModelAndView mav = new ModelAndView("/home/blog/index");
        Page<Article> articlePage = articleService.getByKind(0, 5, "reading");
        mav.addObject("articles", articlePage.getContent());
        mav.addObject("kind", "reading");
        return mav;
    }

    @RequestMapping(value = "/recording", method = RequestMethod.GET)
    public ModelAndView recording() {
        ModelAndView mav = new ModelAndView("/home/blog/index");
        Page<Article> articlePage = articleService.getByKind(0, 5, "recording");
        mav.addObject("articles", articlePage.getContent());
        mav.addObject("kind", "recording");
        return mav;
    }

    @ResponseBody
    @RequestMapping(value = "/load_more", method = RequestMethod.GET)
    public List<Article> loadMore(@RequestParam(value = "page") Integer page, @RequestParam(value = "kind") String kind) {
        Page<Article> articles;
        if(kind.equals("index")) {
            articles = articleService.get(page, 5);
        }
        else {
            articles = articleService.getByKind(page, 5, kind);
        }
        List<Article> resultList = new ArrayList<>();
        for (Article article: articles) {
            resultList.add(article);
        }
        return resultList;
    }

}
