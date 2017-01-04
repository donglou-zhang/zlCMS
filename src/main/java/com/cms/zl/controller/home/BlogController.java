package com.cms.zl.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Vincent on 2016/12/25.
 */
@Controller
@RequestMapping("/blog")
public class BlogController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView blog() {
        ModelAndView mav = new ModelAndView("redirect:/blog/index");
        return mav;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("/home/blog/index");
        return mav;
    }
}
