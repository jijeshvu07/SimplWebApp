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



import com.company.product.domain.SkillFactor;
import com.company.product.service.SkillFactorService;

public class SkillFactorValidator extends Validator {

	@Autowired
	private SkillFactorService skillFactorService;
	
	public boolean supports(Class<?> cls) {
		return SkillFactor.class.equals(cls);
	}
	public void validate(Object target, Errors errors) {
	SkillFactor skillFactor= (SkillFactor) target;
		if (skillFactorService.checkExists(skillFactor.getFactorName())) {
			
			errors.rejectValue("factorName", "skillFactor.factorName.exists");

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
