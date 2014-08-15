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



import com.company.product.domain.Rating;
import com.company.product.service.RatingService;

public class RatingValidator extends Validator {

	@Autowired
	private RatingService ratingService;

	public boolean supports(Class<?> cls) {
		return Rating.class.equals(cls);
	}

	public void validate(Object target, Errors errors) {
		Rating rating= (Rating) target;
		if (ratingService.checkExists(rating.getName())) {

			errors.rejectValue("name", "rating.name.exists");

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
