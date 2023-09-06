package com.example.demo.model;

import java.util.Date;
import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Transacao {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private Long conta_id;
    private Long tipo_operacao_id;
    private Double valor;
    private Timestamp dataTransacao;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getConta_id() {
        return conta_id;
    }
    public void setConta_id(Long conta_id) {
        this.conta_id = conta_id;
    }
    public Long getTipo_operacao_id() {
        return tipo_operacao_id;
    }
    public void setTipo_operacao_id(Long tipo_operacao_id) {
        this.tipo_operacao_id = tipo_operacao_id;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    public Timestamp getDataTransacao() {
        return dataTransacao;
    }
    public void setDataTransacao(Timestamp dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    private void debitar(Double valor){
        setValor(getValor() - valor);
    }

    private void creditar(Double Valor){
        setValor(getValor() + valor);
    }

    public Transacao(Long conta_id, Long tipo_operacao_id, Double valor) {
        setConta_id(conta_id);
        setTipo_operacao_id(tipo_operacao_id);
        setValor(valor);
        Date dataAtual = new Date();
        setDataTransacao(new java.sql.Timestamp(dataAtual.getTime()));
    }
}
