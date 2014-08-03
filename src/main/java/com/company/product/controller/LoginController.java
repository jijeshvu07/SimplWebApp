package com.company.product.controller;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.company.product.validation.*;
import com.company.product.domain.Department;
import com.company.product.service.DepartmentService;
import com.company.product.service.UserService;
import com.google.gson.Gson;

@Controller
public class LoginController {

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private RegisrationValidator regisrationValidator;

	private boolean isRolePresent(Collection<GrantedAuthority> authorities,
			String role) {
		boolean isRolePresent = false;
		for (GrantedAuthority grantedAuthority : authorities) {
			isRolePresent = grantedAuthority.getAuthority().equals(role);
			if (isRolePresent)
				break;
		}
		return isRolePresent;
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		if (isRolePresent(SecurityContextHolder.getContext()
				.getAuthentication().getAuthorities(), "ROLE_NORMAL")) {
			model.addAttribute("isAdmin", false);
			model.addAttribute("message", "Welcome User");
			return "/landingPage";

		}

		else if (isRolePresent(SecurityContextHolder.getContext()
				.getAuthentication().getAuthorities(), "ROLE_ADMIN")) {
			model.addAttribute("isAdmin", true);
			model.addAttribute("message", "Welcome ADMIN");
			return "/landingPage";
		} else
			return "login";

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		model.addAttribute("isLogedIn", true);
		return "login";
	}

	@RequestMapping(value = "/view-register", method = RequestMethod.GET)
	public ModelAndView showRegister() {
		ModelAndView modelAndView = new ModelAndView("/register");
		modelAndView.addObject("user", new com.company.product.domain.User());

		return modelAndView;
	}

	@RequestMapping(value = "/do-register", method = RequestMethod.POST)
	public ModelAndView doregister(
			@Valid @ModelAttribute(value = "user") com.company.product.domain.User user,
			BindingResult result) {
		ModelAndView modelAndView = new ModelAndView("/login");
		
		regisrationValidator.validate(user, result);
		
		if(result.hasErrors()){
			return modelAndView=new ModelAndView("/register");
		}
		
		
		user.setAuthority("ROLE_NORMAL");

		userService.saveUser(user);
		modelAndView.addObject("message", "Account Created Now Login!");

		return modelAndView;
	}

	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {

		model.addAttribute("error", "true");
		return "login";

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {

		return "login";

	}

	@RequestMapping(value = "/checkusername")
	public @ResponseBody String checkUserName(@RequestParam("name") String name) {
		boolean result = userService.userAlreadyTakenValidation(name);
		String data = convertBooleanToString(result);
		Gson gson = new Gson();
		String json = gson.toJson(data);
		return json;

	}

	public String convertBooleanToString(boolean b) {
		String result = "";
		if (b == true) {
			result = "1";
		} else {
			result = "0";
		}
		return result;
	}

	@ModelAttribute("departments")
	public List<Department> departmentList() {
		List<Department> departments = departmentService.findAllDept();
		return departments;
	}

}