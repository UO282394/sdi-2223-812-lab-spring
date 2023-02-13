package com.uniovi.notaineitor.controllers;

import com.uniovi.notaineitor.entities.Mark;
import com.uniovi.notaineitor.entities.Professor;
import com.uniovi.notaineitor.services.MarksService;
import com.uniovi.notaineitor.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProfessorController {
@Autowired //Inyectar el servicio
private ProfessorService professorService;
    @RequestMapping("/professor/list")
    public String getList(Model model) {

        model.addAttribute("professorList", professorService.getProfessors());
        return "professor/list";

    }
    @RequestMapping(value = "/professor/add", method = RequestMethod.POST)
    public String setProfessor(@ModelAttribute Professor professor) {
       professorService.addProfessor(professor);
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
    public String getProfessor() {
        return "professor/add";
    }

}
