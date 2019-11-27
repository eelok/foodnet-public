package de.htw.foodnet.service;

import de.htw.foodnet.database.Entity.User;
import de.htw.foodnet.database.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        RegisterForm form = (RegisterForm) o;
        if (form == null) {
            errors.reject("No user");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (form.getUsername().length() < 3 || form.getUsername().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username");
        }
        if (userRepository.findByUsername(form.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (form.getPassword().length() < 3 || form.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }
    }
}
