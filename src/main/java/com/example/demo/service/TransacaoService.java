package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Transacao;
import com.example.demo.repository.TransacaoRepository;

@Service
public class TransacaoService {
    
    @Autowired
    private TransacaoRepository transacaoRepository;

    public Transacao save(Transacao transacao){
        return transacaoRepository.save(transacao);
    }
}
