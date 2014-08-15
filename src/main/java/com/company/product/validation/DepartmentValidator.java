package com.company.product.validation;

import java.io.IOException;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.w3c.dom.ls.LSResourceResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;

import com.company.product.domain.Department;

import com.company.product.service.DepartmentService;

public class DepartmentValidator extends Validator {

	@Autowired
	DepartmentService departmentService;

	public boolean supports(Class<?> cls) {
		return Department.class.equals(cls);
	}
	public void validate(Object target, Errors errors) {
		Department department = (Department) target;
		if (departmentService.checkExists(department.getName())) {
			
			errors.rejectValue("name", "department.name.exists");

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
	public void setErrorHandler(ErrorHandler arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setResourceResolver(LSResourceResolver arg0) {
		// TODO Auto-generated method stub

	}

	
	@Override
	public void validate(Source source, Result result) throws SAXException,
			IOException {
		// TODO Auto-generated method stub

	}

}
