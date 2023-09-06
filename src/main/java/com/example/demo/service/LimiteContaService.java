package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.LimiteContaRepository;
import com.example.demo.model.LimiteConta;
import com.example.demo.model.Transacao;

@Service
public class LimiteContaService {
    
    @Autowired
    private LimiteContaRepository limiteContaRepository;

    public boolean verificarLimite(Transacao transacao){
        LimiteConta limite = limiteContaRepository.findByConta_id(transacao.getConta_id());

        if(transacao.getTipo_operacao_id() == 3 || transacao.getTipo_operacao_id() == 1){
            if(transacao.getValor() > limite.getLimite()){
                return false;
            }
            limite.setLimite(limite.getLimite() - transacao.getValor());
        } else if(transacao.getTipo_operacao_id() == 4){
            limite.setLimite(limite.getLimite() + transacao.getValor());
        }
            limite.setData_limite(transacao.getDataTransacao());

            limiteContaRepository.save(limite);
        return true;
    }

    public LimiteConta save(LimiteConta limiteConta) {
        return limiteContaRepository.save(limiteConta);
    }
}
