package com.ponto.eletronico.repository;

import com.ponto.eletronico.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    Boolean existsByCpf(String cpf);
}
