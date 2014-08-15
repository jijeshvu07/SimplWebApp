package com.company.product.validation;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.w3c.dom.ls.LSResourceResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;

import com.company.product.domain.Department;
import com.company.product.domain.User;
import com.company.product.service.UserService;

public class RegisrationValidator extends Validator {
	private Pattern pattern;  
	 private Matcher matcher;  
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"  
			   + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";  
	@Autowired
	UserService userService;

	public boolean supports(Class<?> cls) {
		return User.class.equals(cls);
	}

	public void validate(Object target, Errors errors) {

		User user = (User) target;

		Department dept = user.getDepartment();
		// as from from your are binding department ID
		if (dept == null || dept.getId() == 0) {

			errors.rejectValue("department.id", "NotEmpty.user.department");
		}
		if (userService.userAlreadyTakenValidation(user.getName())) {

			errors.rejectValue("name", "user.name.exists");

		}
		// email validation in spring  
		  if (!(user.getEmail() != null && user.getEmail().isEmpty())) {  
		   pattern = Pattern.compile(EMAIL_PATTERN);  
		   matcher = pattern.matcher(user.getEmail());  
		   if (!matcher.matches()) {  
		    errors.rejectValue("email", "email.incorrect",  
		      "Incorrect email!");  
		   }  
		  } 

	}

	@Override
	public ErrorHandler getErrorHandler() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LSResourceResolver getResourceResolver() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setErrorHandler(ErrorHandler errorHandler) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setResourceResolver(LSResourceResolver resourceResolver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void validate(Source source, Result result) throws SAXException,
			IOException {

	}

}
