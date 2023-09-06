package com.example.demo.model;

import java.sql.Timestamp;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class LimiteConta {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="conta_id")
    private Conta conta;
    private Double limite;
    private Timestamp data_limite;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    // public Long getConta_id() {
    //     return conta_id;
    // }
    // public void setConta_id(Long conta_id) {
    //     this.conta_id = conta_id;
    // }
    public Double getLimite() {
        return limite;
    }
    public void setLimite(Double limite) {
        this.limite = limite;
    }
    public Timestamp getData_limite() {
        return data_limite;
    }
    public void setData_limite(Timestamp data_limite) {
        this.data_limite = data_limite;
    }
    public LimiteConta(Conta conta, Double limite) {
        this.conta = conta;
        this.limite = limite;
        Date dataAtual = new Date();
        setData_limite(new java.sql.Timestamp(dataAtual.getTime()));
    }

    public LimiteConta(){
        
    }
    
}
