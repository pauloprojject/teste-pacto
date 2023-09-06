package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.LimiteConta;

@Repository
public interface LimiteContaRepository extends JpaRepository<LimiteConta, Long>{

    LimiteConta findByConta_id(Long conta_id);
}
