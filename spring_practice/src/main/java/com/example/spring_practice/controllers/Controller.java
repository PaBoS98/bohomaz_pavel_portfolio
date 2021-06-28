package com.example.spring_practice.controllers;

import com.example.spring_practice.dto.PersonFullDto;
import com.example.spring_practice.servicies.GlobalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    private GlobalService globalService;

    @Autowired
    public void setGlobalService(GlobalService globalService) {
        this.globalService = globalService;
    }

    @GetMapping
    public ResponseEntity<List<PersonFullDto>> get(){
        List<PersonFullDto> dto = globalService.get();
        return ResponseEntity.ok(dto);
    }

}
