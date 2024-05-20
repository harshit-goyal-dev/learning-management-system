package com.harshit.learningmanagementsystem.controller;

import com.harshit.learningmanagementsystem.services.EasterEggService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ExamController.APPLICATION_ENDPOINT)
public class EasterEggController {
    protected static final String APPLICATION_ENDPOINT = "/learning-navigator/api/v1";

    @Autowired
    private EasterEggService easterEggService;
    @GetMapping("/hidden-feature/{number}")
    public ResponseEntity<String> getRandomFact(@PathVariable int number){
        return ResponseEntity.ok().body(easterEggService.getRandomFact(number));
    }
}
