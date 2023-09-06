package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.TipoOperacao;
import com.example.demo.repository.TipoOperacaoRepository;

@Service
public class TipoOperacaoService {
    
    @Autowired
    private TipoOperacaoRepository tipoOperacaoRepository;

    public List<TipoOperacao> save(List<TipoOperacao> tipoOperacao){
        return tipoOperacaoRepository.saveAll(tipoOperacao);
    }
}
