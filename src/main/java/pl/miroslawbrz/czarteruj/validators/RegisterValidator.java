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

        ValidationUtils.rejectIfEmpty(errors, "firstName", "Imię nie może być puste");
        ValidationUtils.rejectIfEmpty(errors, "lastName", "Nazwisko nie może być puste");
        ValidationUtils.rejectIfEmpty(errors, "email", "Email nie może być pusty");
        ValidationUtils.rejectIfEmpty(errors, "password", "hasło nie może być puste");

        if(user.getEmail()!=null){
            boolean isMatch = UserValidationUtils.checkStringFromInput(RegexForValidator.emailPattern, user.getEmail());
            if(!isMatch){
                errors.rejectValue("email", "nieprawidłowy adres email");
            }
        }
        if(user.getPassword()!=null){
            boolean isMatch = UserValidationUtils.checkStringFromInput(RegexForValidator.passwordPattern, user.getPassword());
            if(!isMatch){
                errors.rejectValue("password", "nieprawidłowe hasło");
            }
        }
    }
    public void validateEmailExist(User user, Errors errors){
        if(user!=null){
            errors.rejectValue("email", "Pod podanym adresem email jest już zarejestrowany użytkownik");
        }
    }
}
