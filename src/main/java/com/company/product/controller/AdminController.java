package com.company.product.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.company.product.validation.*;
import com.company.product.domain.Department;
import com.company.product.domain.Rating;
import com.company.product.domain.SkillFactor;
import com.company.product.domain.Technology;
import com.company.product.domain.UserRating;
import com.company.product.service.DepartmentService;
import com.company.product.service.RatingService;
import com.company.product.service.SkillFactorService;
import com.company.product.service.TechnologyService;
import com.company.product.service.UserRatingService;
import com.company.product.service.UserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class AdminController {

	@Autowired
	private TechnologyService technologyService;

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private SkillFactorService skillFactorService;

	@Autowired
	private RatingService ratingService;

	@Autowired
	private UserService userService;

	@Autowired
	private UserRatingService userRatingService;
	
	
	@Autowired
	TechnologyValidator techValid;

	@RequestMapping(value = "/user-rating", method = RequestMethod.GET)
	public ModelAndView showUserRating() {
		ModelAndView modelAndView = new ModelAndView(
				"/secure/admin/user-rating");

		return modelAndView;
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ModelAndView showUsers(
			@ModelAttribute com.company.product.domain.User user) {

		ModelAndView modelAndView = new ModelAndView("/secure/admin/admin");

		List<com.company.product.domain.User> users = userService.getAllUsers();
		modelAndView.addObject("users", users);
		modelAndView.addObject("isAdmin", false);

		return modelAndView;

	}

	@RequestMapping(value = "/technologies", method = RequestMethod.GET)
	public ModelAndView viewTechnologyList() {
		ModelAndView modelAndView = new ModelAndView("/secure/admin/technology");

		modelAndView.addObject("technology", new Technology());

		return modelAndView;
	}

	@RequestMapping(value = "/departments", method = RequestMethod.GET)
	public ModelAndView viewDepartmentList() {
		ModelAndView modelAndView = new ModelAndView("/secure/admin/department");
		modelAndView.addObject("department", new Department());
		return modelAndView;
	}

	@RequestMapping(value = "/skill-factors", method = RequestMethod.GET)
	public ModelAndView viewSkillFactorList() {
		ModelAndView modelAndView = new ModelAndView(
				"/secure/admin/skill-factor");
		modelAndView.addObject("skillfactor", new SkillFactor());
		return modelAndView;
	}

	@RequestMapping(value = "/rating", method = RequestMethod.GET)
	public ModelAndView viewRating() {
		ModelAndView modelAndView = new ModelAndView("/secure/admin/rating");
		modelAndView.addObject("rating", new Rating());
		return modelAndView;
	}

	@RequestMapping(value = "/add-rating")
	public String addRating(@ModelAttribute(value = "rating")@Valid Rating rating,BindingResult result) {
		if(result.hasErrors()){
			return "/secure/admin/rating";
		}
		java.util.Date utilDate = new java.util.Date();
		Date sqlDate = new Date(utilDate.getTime());
		rating.setCreatedDate(sqlDate);
		ratingService.saveRating(rating);
		return "redirect:/rating";
	}

	@RequestMapping(value = "/add-technology")
	public String addTechnology(
			@ModelAttribute(value = "technology")@Valid Technology technology,
			BindingResult result) {
		 //call validator
	    techValid.validate(technology, result);
		if(result.hasErrors()){
			return "/secure/admin/technology";
		}
		java.util.Date utilDate = new java.util.Date();
		Date sqlDate = new Date(utilDate.getTime());
		technology.setCreatedDate(sqlDate);

		technologyService.saveTechnology(technology);
		return "redirect:/technologies";
	}

	@RequestMapping(value = "/add-department")
	public String addDepartment(
			@ModelAttribute(value = "department")@Valid  Department department,
			BindingResult result) {
		if(result.hasErrors()){
			return "/secure/admin/department";
		}
		java.util.Date utilDate = new java.util.Date();
		Date sqlDate = new Date(utilDate.getTime());
		department.setCreatedDate(sqlDate);
		departmentService.saveDept(department);
		
		return "redirect:/departments";

	}
	@RequestMapping(value = "/updatedepartment")
	public @ResponseBody String updateDepartment(@RequestParam("id") String id){
		Department department=departmentService.findDeptById(Integer.parseInt(id));
		String content=String.valueOf(department.getId())+"/"+department.getName();
		Gson gson = new Gson();
		String json = gson.toJson(content);
		return json;
	}
	

	@RequestMapping(value = "/add-skillfactor")
	public String addSkillFactor(
			@ModelAttribute(value = "skillfactor")@Valid SkillFactor skillFactor,BindingResult result) {
		if(result.hasErrors()){
			return "/secure/admin/skill-factor";
		}
		java.util.Date utilDate = new java.util.Date();
		Date sqlDate = new Date(utilDate.getTime());
		skillFactor.setCreatedDate(sqlDate);
		skillFactorService.saveSkillFactor(skillFactor);
		return "redirect:/skill-factors";
	}

	@RequestMapping(value = "/delete-technology/{id}")
	public String deleteTechnology(@PathVariable int id) {
		ModelAndView modelAndView = new ModelAndView("/secure/admin/technology");

		modelAndView.addObject("technology", new Technology());
		technologyService.deleteTechnology(id);
		return "redirect:/technologies";
	}

	@RequestMapping(value = "/delete-department/{id}")
	public String deleteDepartment(@PathVariable int id) {
		ModelAndView modelAndView = new ModelAndView("/secure/admin/department");
		modelAndView.addObject("department", new Department());
		departmentService.deleteDept(id);
		return "redirect:/departments";
	}

	@RequestMapping(value = "/delete-skillfactor/{id}")
	public String deleteSkillfactor(@PathVariable int id) {
		skillFactorService.deleteSkillFactor(id);
		return "redirect:/skill-factors";
	}

	@RequestMapping(value = "/delete-rating/{id}")
	public String deleteRating(@PathVariable int id) {
		ratingService.deleteRating(id);
		return "redirect:/rating";
	}

	@RequestMapping(value = "/springPaginationDataTables", method = RequestMethod.GET)
	public @ResponseBody String springPaginationDataTables() throws IOException {
		List<UserRating> userRatings = userRatingService.findAllUserRating();
		UserRatingJsonObject ratingJsonObject = new UserRatingJsonObject();
		ratingJsonObject.setiTotalDisplayRecords(userRatings.size());

		ratingJsonObject.setiTotalRecords(userRatings.size());
		ratingJsonObject.setAaData(userRatings);

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json2 = gson.toJson(ratingJsonObject);

		return json2;

	}
	
	
	
	
	
	
	
	
	

	@ModelAttribute("technologies")
	public List<Technology> technologyList() {
		List<Technology> technologies = technologyService.findAllTechnology();
		return technologies;
	}

	@ModelAttribute("departments")
	public List<Department> departmentList() {
		List<Department> departments = departmentService.findAllDept();
		return departments;
	}

	@ModelAttribute("ratings")
	public List<Rating> ratingList() {
		List<Rating> ratings = ratingService.findAllRating();
		return ratings;

	}

	@ModelAttribute("skillfactors")
	public List<SkillFactor> skillFactorList() {
		List<SkillFactor> skillFactors = skillFactorService.findAllSkilFactor();
		return skillFactors;
	}

	@ModelAttribute("userRatings")
	public List<UserRating> userRatingList() {
		List<UserRating> userRatings = userRatingService.findAllUserRating();
		return userRatings;
	}

}
