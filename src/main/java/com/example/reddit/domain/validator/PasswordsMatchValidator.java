package com.example.reddit.domain.validator;

import com.example.reddit.domain.MyUser;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordsMatchValidator implements ConstraintValidator<PasswordsMatch, MyUser> {

    @Override
    public void initialize(PasswordsMatch passwordsMatch){
    }

    public boolean isValid(MyUser user, ConstraintValidatorContext context) {
        return user.getPassword().equals(user.getConfirmPassword());
    }

}