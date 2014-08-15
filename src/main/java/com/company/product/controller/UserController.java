package com.company.product.controller;

import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.company.product.domain.Rating;
import com.company.product.domain.SkillFactor;
import com.company.product.domain.Technology;
import com.company.product.domain.User;
import com.company.product.domain.UserRating;
import com.company.product.service.DepartmentService;
import com.company.product.service.RatingService;
import com.company.product.service.SkillFactorService;
import com.company.product.service.TechnologyService;
import com.company.product.service.UserRatingService;
import com.company.product.service.UserService;
import com.google.gson.Gson;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private SkillFactorService skillFactorService;

	@Autowired
	private TechnologyService technologyService;

	@Autowired
	private RatingService ratingService;

	@Autowired
	private UserRatingService userRatingService;

	@Autowired
	private DepartmentService departmentService;

	@RequestMapping(value = "/SkillRate", method = RequestMethod.GET)
	public String userSkillRate(ModelMap model) {
		User loggedUser = userService.getLoggedUserAccount();
		model.addAttribute("message", "Rate the user Skills");

		model.addAttribute("ratingList", ratingList());

		List<Technology> technologies = technologyService
				.findTechnologyByDepartmentId(loggedUser.getDepartment()
						.getId());
		model.addAttribute("technologies", technologies);
		return "/SkillRate";

	}

	@RequestMapping(value = "saveUserRating")
	public @ResponseBody String saveUserRating(
			@RequestParam(value = "id") String x) {
		Gson gson = new Gson();
		String data = gson.toJson("Thank You!");
		Technology technology = null;
		SkillFactor skillFactor = null;
		Rating rating = null;
		JSONArray arrJsonPCData = new JSONArray(x);
		java.util.Date utilDate=new Date();
		java.sql.Date sqlDate=new java.sql.Date(utilDate.getTime());
		for (int i = 0; i < arrJsonPCData.length(); i++) {
			JSONObject json_data = arrJsonPCData.getJSONObject(i);
			int techID = Integer.parseInt(json_data.getString("tech"));
			String skill = json_data.getString("skill");
			int ratingId = Integer.parseInt(json_data.getString("rValue"));
			UserRating userRating = new UserRating();
			technology = technologyService.findTechologyById(techID);
			skillFactor = skillFactorService.findSkillFactorByName(skill);
			rating = ratingService.findRatingById(ratingId);

			User user = userService.getLoggedUserAccount();

			userRating.setTechnologyId(technology);
			userRating.setSkillFactorId(skillFactor);
			userRating.setRatingId(rating);
			userRating.setUserId(user);
			userRating.setAttendDate(sqlDate);

			userRatingService.saveUserRating(userRating);
		}

		return data;
	}

	
	public List<Technology> technologyList() {
		List<Technology> technologies = technologyService.findAllTechnology();
		return technologies;
	}

	@ModelAttribute("skillfactors")
	public List<SkillFactor> skillFactorList() {
		List<SkillFactor> skillFactor = skillFactorService.findAllSkilFactor();
		return skillFactor;
	}

	public List<Rating> ratingList() {
		List<Rating> rating = ratingService.findAllRating();
		return rating;
	}
}
