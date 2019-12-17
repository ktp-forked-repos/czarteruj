package pl.miroslawbrz.czarteruj.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import pl.miroslawbrz.czarteruj.constans.RegexForValidator;
import pl.miroslawbrz.czarteruj.model.User;

public class RegisterValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmpty(errors, "firstName", "error.userName.empty");
        ValidationUtils.rejectIfEmpty(errors, "lastName", "error.userLastName.empty");
        ValidationUtils.rejectIfEmpty(errors, "email", "error.userEmail.empty");
        ValidationUtils.rejectIfEmpty(errors, "password", "error.userPassword.empty");

        if(user.getEmail()!=null){
            boolean isMatch = UserValidationUtils.checkStringFromInput(RegexForValidator.emailPattern, user.getEmail());
            if(!isMatch){
                errors.rejectValue("email", "error.userEmailIsNotMatch");
            }
        }
        if(user.getPassword()!=null){
            boolean isMatch = UserValidationUtils.checkStringFromInput(RegexForValidator.passwordPattern, user.getPassword());
            if(!isMatch){
                errors.rejectValue("password", "error.userPasswordIsNotMatch");
            }
        }
    }
    public void validateEmailExist(User user, Errors errors){
        if(user!=null){
            errors.rejectValue("email", "error.userIsExist");
        }
    }
}
