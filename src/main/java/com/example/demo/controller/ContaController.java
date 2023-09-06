package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Conta;
import com.example.demo.service.ContaService;

@RestController
@RequestMapping("/conta")
public class ContaController {
    @Autowired
    private ContaService contaService;

    @PostMapping
    public Conta create(@RequestBody Conta conta){
        return contaService.save(conta);
    }

    @GetMapping("/{id}")
    public Conta read(@PathVariable Long id){
        return contaService.read(id).get();
    }
}
