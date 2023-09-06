package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Transacao;
import com.example.demo.service.LimiteContaService;
import com.example.demo.service.TransacaoService;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {
    
    @Autowired
    private TransacaoService transacaoService;

    @Autowired
    private LimiteContaService limiteContaService;

    @PostMapping
    public Transacao create(@RequestBody Transacao transacao){

        if((transacao.getTipo_operacao_id() == 3 || transacao.getTipo_operacao_id() == 4) 
        && limiteContaService.verificarLimite(transacao)){
            return transacaoService.save(transacao);
        }
        return null;
    }
}
