package com.uniovi.notaineitor.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class MarksController {
    @RequestMapping("/mark/list")
    public String getList() {
        return "Getting List";
    }
    @RequestMapping(value = "/mark/add", method = RequestMethod.POST)
    public String setMark(@ModelAttribute com.uniovi.notaineitor.entities.Mark mark) {
        return "added: " + mark.getDescription()
                + " with score : " + mark.getScore()
                + " id: " + mark.getId();
    }
    @RequestMapping("/mark/details/{id}")
    public String getDetail(@RequestParam Long id) {
        return "Getting Details>=" + id;
    }
}
