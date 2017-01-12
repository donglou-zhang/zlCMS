package com.cms.zl.controller.admin;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Vincent on 2016/12/29.
 */
@PreAuthorize("hasRole('ROLE_ADMIN')")
@Controller
@RequestMapping("/admin")
public class ConsoleController {
    @RequestMapping(value="/index", method = RequestMethod.GET)
    public ModelAndView dashboard() {
        ModelAndView mav = new ModelAndView("admin/index");
        return mav;
    }
}
