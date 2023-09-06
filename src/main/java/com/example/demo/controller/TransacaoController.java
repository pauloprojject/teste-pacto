package com.example.demo.controller;

import java.util.Objects;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Transacao;
import com.example.demo.service.LimiteContaService;
import com.example.demo.service.TransacaoService;
import static com.example.demo.util.TipoOperacaoEnum.obterPermitidos;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {
    
    @Autowired
    private TransacaoService transacaoService;

    @Autowired
    private LimiteContaService limiteContaService;

    @PostMapping
    public ResponseEntity create(@RequestBody Transacao transacao){

        if (verificarLimiteBoolean(transacao)) {
            Transacao savedTransacao = transacaoService.save(transacao);
            return new ResponseEntity(savedTransacao, HttpStatus.CREATED);
        }
        return new ResponseEntity("Transação não autorizada.", HttpStatus.BAD_REQUEST);
    }

    private boolean verificarLimiteBoolean(Transacao transacao) {
        return Objects.nonNull(obterPermitidos(transacao.getTipo_operacao_id())) 
            && limiteContaService.verificarLimite(transacao);
    }

    
}
