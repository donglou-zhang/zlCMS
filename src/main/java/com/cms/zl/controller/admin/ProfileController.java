package com.cms.zl.controller.admin;

import com.cms.zl.model.ProfileForm;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by Vincent on 2017/1/4.
 */
@Controller
@RequestMapping("/admin/profile")
public class ProfileController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView adminInfo() {
        ModelAndView mav = new ModelAndView("admin/infoSet");
        return mav;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView editProfile(@Valid ProfileForm profileForm, BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView("redirect:/admin/index");

        return mav;
    }
}
