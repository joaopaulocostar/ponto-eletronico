package com.ponto.eletronico.mapper;


import com.ponto.eletronico.DTO.FuncionarioResponseDTO;
import com.ponto.eletronico.model.Funcionario;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class FuncionarioMapper {
    public FuncionarioResponseDTO toResponseDTO(Funcionario funcionario){
        FuncionarioResponseDTO response = new FuncionarioResponseDTO();

        response.setId(funcionario.getId());
        response.setNome(funcionario.getNome());
        response.setCpf(funcionario.getCpf());
        response.setCargo(funcionario.getCargo());
        response.setEmpresa(funcionario.getEmpresa().getNome());

        return response;
    }
}
