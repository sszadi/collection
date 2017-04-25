package com.io2.validator;

import com.io2.annotation.PasswordMatches;
import com.io2.model.UserDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Niki on 2017-04-07.
 */

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {
    @Override
    public void initialize(PasswordMatches passwordMatches) {

    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext context) {
        UserDTO user = (UserDTO) object;
        return user.getPassword().equals(user.getMatchingPassword());
    }
}
