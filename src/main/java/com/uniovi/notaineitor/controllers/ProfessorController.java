package com.uniovi.notaineitor.controllers;

import com.uniovi.notaineitor.entities.Mark;
import com.uniovi.notaineitor.entities.Professor;
import com.uniovi.notaineitor.services.MarksService;
import com.uniovi.notaineitor.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfessorController {
@Autowired //Inyectar el servicio
private ProfessorService professorService;
    @RequestMapping("/professor/list")
    public String getList() {

        return professorService.getProfessors().toString();
    }
    @RequestMapping(value = "/professor/add", method = RequestMethod.POST)
    public String setMark(@ModelAttribute Professor professor) {
       professorService.addProfessor(professor);
        return "OK";
    }


    @RequestMapping("/professor/details/{id}")
    public String getDetail( @PathVariable Long id) {
        return professorService.getProfessor(id).toString();
    }
    @RequestMapping("/professor/delete/{id}")
    public String deleteMark(@PathVariable Long id) {
        professorService.deleteProfessor(id);
        return "Ok";
    }
    @RequestMapping(value = "/professor/add")
    public String getProfessor() {
        return "OK";
    }

}
