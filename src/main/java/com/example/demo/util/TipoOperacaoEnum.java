package com.example.demo.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoOperacaoEnum {
    COMPRA_A_VISTA(1L),
    SAQUE(3L),
    PAGAMENTO(4L);

    private final Long id;

    public static TipoOperacaoEnum obterPermitidos(Long id){
        for(TipoOperacaoEnum tipoOperacao : TipoOperacaoEnum.values()){
            if(tipoOperacao.getId().equals(id)){
                return tipoOperacao;
            }
        }
        return null;
    }
}
