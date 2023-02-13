package com.uniovi.notaineitor.services;

import com.uniovi.notaineitor.entities.Mark;
import com.uniovi.notaineitor.entities.Professor;
import com.uniovi.notaineitor.repositories.MarksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
@Service
public class ProfessorService {


   private List<Professor> professorsList = new LinkedList<>();
    @PostConstruct
    public void init() {
       professorsList.add(new Professor(1L, "234", "ivo","vego","aa"));
       professorsList.add(new Professor(2L, "234", "ger","goo","aaa"));
    }
    public List<Professor> getProfessors() {

        return professorsList;
    }
    public Professor getProfessor(Long id) {
        return professorsList.stream()
                .filter(professor -> professor.getId().equals(id)).findFirst().get();
    }
    public void addProfessor(Professor mark) {
        if (mark.getId() == null) {
            mark.setId(professorsList.get(professorsList.size() - 1).getId() + 1);
        }
       professorsList.add(mark);
    }
    public void deleteProfessor(Long id) {
        professorsList.removeIf(professor -> professor.getId().equals(id));
    }
}
