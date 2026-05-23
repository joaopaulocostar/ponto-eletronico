package com.ponto.eletronico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ponto.eletronico.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    boolean existsByCnpj(String cnpj);
}
