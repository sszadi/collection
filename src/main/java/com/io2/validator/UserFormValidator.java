package com.io2.validator;

import com.io2.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Niki on 2017-05-11.
 */

@Component
public class UserFormValidator implements Validator {

    @Autowired
    EmailValidator emailValidator;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "message.email");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "message.username");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "message.password");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "message.confirmPassword");
    }
}
