package com.ponto.eletronico.repository;

import com.ponto.eletronico.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    boolean existsByEmail(String email);
}
