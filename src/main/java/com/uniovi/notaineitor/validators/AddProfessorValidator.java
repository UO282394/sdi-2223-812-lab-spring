package com.uniovi.notaineitor.validators;
import com.uniovi.notaineitor.entities.Mark;
import com.uniovi.notaineitor.entities.Professor;
import com.uniovi.notaineitor.entities.User;
import com.uniovi.notaineitor.services.ProfessorService;
import com.uniovi.notaineitor.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.*;
@Component
public class AddProfessorValidator implements Validator {
    @Autowired
    private UsersService usersService;
    @Autowired
    private ProfessorService proService;
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }
    @Override
    public void validate(Object target, Errors errors) {
     Professor pro = (Professor) target;

        char aux =  pro.getDni().charAt(pro.getDni().length()-1);
        if (pro.getDni().length() != 9 || Character.isDigit(aux)) {
            errors.rejectValue("dni", "Error.professor.dni.length");}
        if (usersService.getUserByDni(pro.getDni()) != null) {
            errors.rejectValue("dni", "Error.signup.dni.duplicate");}
        boolean f = false;
        for (int i = 0; i < proService.getProfessors().size(); i++) {
            if(proService.getProfessors().get(i).getDni().equals(pro.getDni())){
                f = true;
            }
        }
        if (f) {
            errors.rejectValue("dni", "Error.signup.dni.duplicate");}

    }
}