package com.uniovi.notaineitor.controllers;

import com.uniovi.notaineitor.entities.Mark;
import com.uniovi.notaineitor.entities.Professor;
import com.uniovi.notaineitor.services.MarksService;
import com.uniovi.notaineitor.services.ProfessorService;
import com.uniovi.notaineitor.validators.AddMarkValidator;
import com.uniovi.notaineitor.validators.AddProfessorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProfessorController {
    @Autowired
    private AddProfessorValidator addProfessorValidator;
@Autowired //Inyectar el servicio
private ProfessorService professorService;
    @RequestMapping("/professor/list")
    public String getList(Model model) {

        model.addAttribute("professorList", professorService.getProfessors());
        return "professor/list";

    }
    @RequestMapping(value = "/professor/add", method = RequestMethod.POST)
    public String setProfessor(@Validated Professor professor, BindingResult result) {
        addProfessorValidator.validate(professor,result);
        if(result.hasErrors()){
            return "professor/add";
        }
       professorService.addProfessor(professor);
        return "redirect:/professor/list";
    }
    @RequestMapping("/professor/edit")
    public String edit(Model model) {


        return "professor/list";

    }
    @RequestMapping(value = "/professor/edit", method = RequestMethod.POST)
    public String edit(@Validated Professor professor, BindingResult result) {

        return "redirect:/professor/list";
    }


    @RequestMapping("/professor/details/{id}")
    public String getDetail(Model model, @PathVariable Long id) {
        model.addAttribute("professor", professorService.getProfessor(id));
        return "professor/details";
    }
    @RequestMapping("/professor/delete/{id}")
    public String deleteProfessor(@PathVariable Long id) {
        professorService.deleteProfessor(id);
        return "redirect:/professor/list";
    }
    @RequestMapping(value = "/professor/add")
    public String getProfessor(Model model) {
        model.addAttribute("professor",new Professor());
        return "professor/add";
    }

}
