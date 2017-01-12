package com.cms.zl.controller.admin;

import com.cms.zl.Exception.ControllerParamException;
import com.cms.zl.entity.Profile;
import com.cms.zl.model.ProfileForm;
import com.cms.zl.service.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vincent on 2017/1/4.
 */
@PreAuthorize("hasRole('ROLE_ADMIN')")
@Controller
@RequestMapping("/admin/profile")
public class ProfileController {
    private final IProfileService profileService;

    @Autowired
    public ProfileController(IProfileService profileService) {
        this.profileService = profileService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView adminInfo() {
        ModelAndView mav = new ModelAndView("admin/infoSet");
        Profile profile = profileService.get(1);
        mav.addObject("profile", profile);
        List<String> labels = new ArrayList<>(4);
        String[] tempArr = profile.getLabel().split("&");
        for(int i = 0; i < 4; i++){
            labels.add(tempArr[i]);
        }
        mav.addObject("labels", labels);
        return mav;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView editProfile(@Valid ProfileForm profileForm, BindingResult bindingResult) throws ControllerParamException {
        if(bindingResult.hasErrors()) throw new ControllerParamException("ProfileForm params errors");
        ModelAndView mav = new ModelAndView("redirect:/admin/profile");
        System.out.println("label: "+profileForm.getLabel());
        profileService.update(new Profile(1, profileForm.getAvatar(), profileForm.getEducation(), profileForm.getEmail(),
                profileForm.getLabel(), profileForm.getNative_place(), profileForm.getStudies()));
        return mav;
    }
}
