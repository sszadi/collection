package com.io2.validator;

import com.io2.model.Sneaker;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Niki on 2017-05-11.
 */
@Component
public class SneakersValidation implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Sneaker.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Sneaker sneaker = (Sneaker) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "brand", "message.model");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "size", "message.size");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "message.price");

        if (sneaker.getPrice() <= 0.0) {
            errors.rejectValue("error", "message.validPrice");
        }

        if (sneaker.getSize() <= 0.0) {
            errors.rejectValue("error", "message.validSize");
        }
    }
}

