package com.thomas.login.validator;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.thomas.login.models.User;

@Component
public class UserValidator implements Validator {
    
    // 1 
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }
    
    // 2
    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        
        if (!user.getPasswordConfirmation().equals(user.getPassword())) {
            // 3 Sets the code "Match" for the method passwordConfirmation
            errors.rejectValue("passwordConfirmation", "Match");
        }         
    }
}