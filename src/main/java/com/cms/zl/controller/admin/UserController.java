package com.cms.zl.controller.admin;

import com.cms.zl.entity.Article;
import com.cms.zl.repository.IArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Vincent on 2016/12/30.
 */
@PreAuthorize("hasRole('ROLE_ADMIN')")
@Controller
@RequestMapping("/admin/user")
public class UserController {
    private static final int pageSize = 5;

    private final IArticleRepository articleRepository;

    @Autowired
    public UserController(IArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "0")Integer page) {
        ModelAndView mav = new ModelAndView("admin/userList");
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        Pageable pageable = new PageRequest(page, pageSize, sort);

        Page<Article> articlePage = articleRepository.findAll(pageable);
        mav.addObject("articles", articlePage);
        return mav;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView addUser() {
        ModelAndView mav = new ModelAndView("admin/addUser");
        return mav;
    }
}
