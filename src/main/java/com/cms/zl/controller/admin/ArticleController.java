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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

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
    public ModelAndView editArticle(@RequestParam(value = "id", required = false)String id) {
        ModelAndView mav = new ModelAndView("admin/editArticle");
        if(id != null && id.length() != 0) {
            Article article = articleService.get(id);
            mav.addObject("article", article);
        }
        return mav;
    }

    @RequestMapping(value = "/saveEdit", method = RequestMethod.POST)
    public ModelAndView saveEdit(@RequestParam(value = "id")String id, @Valid ArticleForm articleForm, BindingResult bindingResult) throws ControllerParamException{
        if(bindingResult.hasErrors()) throw new ControllerParamException("编辑文章参数错误");
        ModelAndView mav = new ModelAndView("redirect:/admin/article/list");
        Article article = articleService.get(id);
        article.setTitle(articleForm.getTitle());
        article.setKind(articleForm.getKind());
        article.setTopic(articleForm.getTopic());
        article.setContent(articleForm.getContent());
        articleService.update(article);
        return mav;
    }

    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Map deleteArticle(@RequestParam(value = "id")String id) {
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("status", "success");
        articleService.delete(id);
        return resultMap;
    }

    /**
     * 添加新文章
     * @param articleForm
     * @param result
     * @param principal
     * @return
     * @throws ControllerParamException
     */
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addArticle(@Valid ArticleForm articleForm, BindingResult result, Principal principal) throws ControllerParamException {
        if(result.hasErrors()) throw new ControllerParamException("编辑文章参数错误");
        articleService.create(articleForm.getTitle(), articleForm.getTopic(), articleForm.getKind(), articleForm.getContent());
        ModelAndView mav = new ModelAndView("redirect:/admin/article/list");
        return mav;
    }
}
