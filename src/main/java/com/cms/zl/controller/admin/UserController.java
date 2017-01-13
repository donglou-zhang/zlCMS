package com.cms.zl.controller.admin;

import com.cms.zl.entity.Article;
import com.cms.zl.entity.User;
import com.cms.zl.repository.IArticleRepository;
import com.cms.zl.repository.IUserRepository;
import com.cms.zl.service.IUserService;
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

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1")Integer page) {
        ModelAndView mav = new ModelAndView("admin/userList");
//        Sort sort = new Sort(Sort.Direction.DESC, "create_time");
//        Pageable pageable = new PageRequest(page, pageSize, sort);

        Page<User> userPage = userService.get(page-1, pageSize);
        mav.addObject("users", userPage.getContent());

        int pageNumber = userPage.getTotalPages();

        mav.addObject("currentPage", page.intValue());
        mav.addObject("maxPage", pageNumber);
        return mav;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView addUser() {
        ModelAndView mav = new ModelAndView("admin/addUser");
        return mav;
    }
}
