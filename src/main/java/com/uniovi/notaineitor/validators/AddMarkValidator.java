package com.uniovi.notaineitor.validators;
import com.uniovi.notaineitor.entities.Mark;
import com.uniovi.notaineitor.entities.User;
import com.uniovi.notaineitor.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.*;
@Component
public class AddMarkValidator implements Validator {
    @Autowired
    private UsersService usersService;
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }
    @Override
    public void validate(Object target, Errors errors) {
        Mark mark = (Mark) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user", "Error.empty");
        if (mark.getScore() < 0 || mark.getScore() > 10) {
            errors.rejectValue("score", "Error.mark.score.length");}
        char aux =  mark.getUser().getDni().charAt(mark.getUser().getDni().length()-1);
        if (mark.getDescription().length() <20) {
            errors.rejectValue("description", "Error.mark.description.length");}
        if (mark.getUser().getDni().length() != 9 || Character.isDigit(aux)) {
            errors.rejectValue("user", "Error.mark.dni.length");}
        if (usersService.getUserByDni(mark.getUser().getDni()) != null) {
            errors.rejectValue("user", "Error.signup.dni.duplicate");}

    }
}