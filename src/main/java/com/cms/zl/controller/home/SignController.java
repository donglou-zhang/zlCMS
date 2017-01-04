package com.cms.zl.controller.home;

import com.cms.zl.Exception.ControllerParamException;
import com.cms.zl.entity.User;
import com.cms.zl.model.UserSignupForm;
import com.cms.zl.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by Vincent on 2016/12/14.
 */

@Controller
public class SignController {

    private final IUserService userService;
    private final BCryptPasswordEncoder encoder;
    private final UserDetailsService userDetailsService;

    @Autowired
    public SignController(IUserService userService, UserDetailsService userDetailsService) {
        this.userService = userService;
        this.userDetailsService = userDetailsService;//spring-security
        this.encoder = new BCryptPasswordEncoder();
    }

    @RequestMapping(value="/signin", method = RequestMethod.GET)
    public ModelAndView signin() {
        ModelAndView mav = new ModelAndView("home/sign/login");
        return mav;
    }

    @RequestMapping(value="/signup", method = RequestMethod.GET)
    public ModelAndView signup() {
        ModelAndView mav = new ModelAndView("home/sign/register");
        return mav;
    }

    @RequestMapping(value="/signup", method = RequestMethod.POST)
    public ModelAndView signup(@Valid UserSignupForm user, BindingResult bindingResult, WebRequest webRequest) throws ControllerParamException{
        if(bindingResult.hasErrors()) throw new ControllerParamException("ControllerParamException: bindingResult.hasErrors");

        ModelAndView mav;
        try{
            User localUser = userService.create(user.getUsername(), encoder.encode(user.getPassword()));//已经将user信息写入数据库
            UserDetails userDetails = userDetailsService.loadUserByUsername(localUser.getUsername());
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            mav = new ModelAndView("redirect:/signin");
        }catch(Exception e){
            mav = new ModelAndView("home/sign/register");
            mav.addObject("message", "注册失败，该用户名已被注册");
        }
        return mav;
    }
}
