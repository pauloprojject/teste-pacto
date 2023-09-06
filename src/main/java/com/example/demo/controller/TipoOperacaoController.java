package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.TipoOperacao;
import com.example.demo.service.TipoOperacaoService;

@RestController
@RequestMapping("/tipoOperacao")
public class TipoOperacaoController {

    @Autowired
    private TipoOperacaoService tipoOperacaoService;

    @PostMapping
    public List<TipoOperacao> create(@RequestBody List<TipoOperacao> tipoOperacao){
        return tipoOperacaoService.save(tipoOperacao);
    }
}
