package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Conta;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface ContaRepository extends JpaRepository<Conta,Long>{
    
}
