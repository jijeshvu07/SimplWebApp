package com.company.product.validation;

import java.io.IOException;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.validation.Validator;

import org.springframework.validation.Errors;
import org.w3c.dom.ls.LSResourceResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;

import com.company.product.domain.Department;
import com.company.product.domain.Technology;

public class TechnologyValidator extends Validator {

    public boolean supports(Class<?> cls) {
        return Technology .class.equals(cls);
    }

    public void validate(Object target, Errors errors) {
      //  super.validate(target, errors);
        Technology tecObj= (Technology ) target;
        //here i am assuming Technology name is REQUIRED and   
        //NotEmpty.technology.name is in message.properties
     
        Department dept = tecObj.getDepartment();
        //as from from your are binding department ID
        if (dept==null || dept.getId() == 0  ) {
        	
           errors.rejectValue("department.id", "NotEmpty.technology.department");
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
		// TODO Auto-generated method stub
		
	}
}
