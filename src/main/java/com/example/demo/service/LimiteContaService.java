package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.LimiteContaRepository;
import com.example.demo.util.TipoOperacaoEnum;
import com.example.demo.model.LimiteConta;
import com.example.demo.model.Transacao;
import static com.example.demo.util.TipoOperacaoEnum.obterPermitidos;
import static com.example.demo.util.TipoOperacaoEnum.SAQUE;
import static com.example.demo.util.TipoOperacaoEnum.COMPRA_A_VISTA;
import static com.example.demo.util.TipoOperacaoEnum.PAGAMENTO;

@Service
public class LimiteContaService {
    
    @Autowired
    private LimiteContaRepository limiteContaRepository;

    public boolean verificarLimite(Transacao transacao){
        LimiteConta limite = limiteContaRepository.findByConta_id(transacao.getConta_id());
        TipoOperacaoEnum tipoOperacao = obterPermitidos(transacao.getTipo_operacao_id());
        if(SAQUE.equals(tipoOperacao) || COMPRA_A_VISTA.equals(tipoOperacao)){
            if(transacao.getValor() > limite.getLimite()){
                return false;
            }
            limite.setLimite(limite.getLimite() - transacao.getValor());
        } else if(PAGAMENTO.equals(tipoOperacao)){
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
