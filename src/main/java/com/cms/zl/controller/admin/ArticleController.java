package com.cms.zl.controller.admin;

import com.cms.zl.Exception.ControllerParamException;
import com.cms.zl.entity.Article;
import com.cms.zl.model.ArticleForm;
import com.cms.zl.service.IArticleService;
import com.cms.zl.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;

/**
 * Created by Vincent on 2016/12/30.
 */
@PreAuthorize("hasRole('ROLE_ADMIN')")
@Controller
@RequestMapping("/admin/article")
public class ArticleController {
    private static final int articlePageSize = 5;

    private final IUserService userService;
    private final IArticleService articleService;

    @Autowired
    public ArticleController(IUserService userService, IArticleService articleService) {
        this.userService = userService;
        this.articleService = articleService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView articleList(@RequestParam(value = "page", defaultValue = "1")Integer page) {
        ModelAndView mav = new ModelAndView("admin/articleList");
        Page<Article> articlePage = articleService.get(page-1, articlePageSize);
        mav.addObject("articles", articlePage.getContent());

        int pageNumber = articlePage.getTotalPages();

        mav.addObject("currentPage", page.intValue());
        mav.addObject("maxPage", pageNumber);
        return mav;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView addArticle() {
        ModelAndView mav = new ModelAndView("admin/editArticle");
        return mav;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addArticle(@Valid ArticleForm articleForm, BindingResult result, Principal principal) throws ControllerParamException {
        if(result.hasErrors()) throw new ControllerParamException("编辑文章参数错误");
        Article article = articleService.create(articleForm.getTitle(), articleForm.getTopic(), articleForm.getKind(), articleForm.getContent());
        ModelAndView mav = new ModelAndView("redirect:/admin/article/list");
        return mav;
    }
}
