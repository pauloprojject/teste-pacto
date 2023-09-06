package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Conta;
import com.example.demo.repository.ContaRepository;

@Service
public class ContaService {
    @Autowired
    private ContaRepository contaRepository;

    public Conta save(Conta conta){
        return contaRepository.save(conta);
    }

    public Optional<Conta> read(long id){
        return contaRepository.findById(id);
    }
}
