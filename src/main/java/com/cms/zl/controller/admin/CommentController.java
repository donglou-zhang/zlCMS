package com.cms.zl.controller.admin;

import com.cms.zl.Exception.ControllerParamException;
import com.cms.zl.model.CommentForm;
import com.cms.zl.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;

/**
 * Created by lei_b on 2017/1/24.
 */
@Controller
@RequestMapping("/admin/comment")
public class CommentController {
    private final ICommentService commentService;

    @Autowired
    public CommentController(ICommentService commentService) {
        this.commentService = commentService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView commitComment(@RequestParam(value = "kind") String kind, @Valid CommentForm commentForm, BindingResult result, Principal principal) throws ControllerParamException {
        if(result.hasErrors()) throw new ControllerParamException("提交评论参数错误");
        String article_id = commentForm.getArticle_id();
        ModelAndView mav = new ModelAndView("redirect:/article?id=" + article_id + "&kind=" + kind);
        commentService.create(commentForm.getComment(), commentForm.getArticle_id(), commentForm.getUser_id());
        return mav;
    }
}
