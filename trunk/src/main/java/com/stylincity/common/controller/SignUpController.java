package com.stylincity.common.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stylincity.login.bean.UserAccount;
import com.stylincity.login.bean.UserProfile;
import com.stylincity.login.bean.enums.UserAccountStatus;
import com.stylincity.login.service.LoginService;

@Controller
public class SignUpController {
	
	@Autowired LoginService loginService;
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Your new online shopping destination.");
		return "signinform";
	}
	
	@ModelAttribute("userAccount")
	public UserAccount getUserAccount() {
		return new UserAccount();
	}
	
	@ModelAttribute("userProfile")
	public UserProfile getUserProfile() {
		return new UserProfile();
	}
	
    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public String validateSignInForm(@ModelAttribute("userAccount") @Valid UserAccount userAccount, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "signinform";
        }

        String loginStatus = loginService.login(userAccount);
		if (loginStatus.equals(UserAccountStatus.NEW_USER_CREATED)) {
			model.addAttribute("user", userAccount);
			return "userstats";
		} else if (loginStatus.equals(UserAccountStatus.LOGIN_SUCCESS))
			return "userProfile"; 
		else
			return "signinform"; //to change
    }

    @RequestMapping(value = "/saveuserstats", method = RequestMethod.POST)
    public String saveUserStats(@ModelAttribute("userProfile") @Valid UserProfile userProfile, BindingResult result, ModelMap model) {
        model.addAttribute("userprofile", userProfile);
        return "uploadphotos";
    }

    @RequestMapping(value = "/uploaduserphotos", method = RequestMethod.POST)
    public String uploadUserPhotos(@ModelAttribute("userProfile") @Valid UserProfile userProfile, BindingResult result, ModelMap model) {
        model.addAttribute("userprofile", userProfile);
        return "uploadphotos";
    }
}
