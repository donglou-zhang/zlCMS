package com.cms.zl.controller.admin;

import com.cms.zl.Exception.ControllerParamException;
import com.cms.zl.model.FriendLinkForm;
import com.cms.zl.service.IFriendLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by Vincent on 2017/3/8.
 */
@Controller
@RequestMapping("/admin/f_link")
public class FriendLinkController {
    private final IFriendLinkService friendLinkService;

    @Autowired
    public FriendLinkController(IFriendLinkService friendLinkService) {
        this.friendLinkService = friendLinkService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView fLinkPage() {
        ModelAndView mav = new ModelAndView("admin/addFLink");
        return mav;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addFLink(@Valid FriendLinkForm fLinkForm, BindingResult result) throws ControllerParamException{
        if(result.hasErrors()) throw new ControllerParamException("友链参数错误");
        ModelAndView mav = new ModelAndView("redirect:/admin/f_link/list");
        friendLinkService.create(fLinkForm.getSname(), fLinkForm.getSite());
        return mav;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView fLinkListPage() {
        ModelAndView mav = new ModelAndView("admin/fLinkList");
        return mav;
    }
}
