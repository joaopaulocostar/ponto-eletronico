package com.ponto.eletronico.mapper;

import org.springframework.stereotype.Component;
import com.ponto.eletronico.model.Funcionario;
import com.ponto.eletronico.model.Empresa;
import com.ponto.eletronico.model.RegistraPonto;
import com.ponto.eletronico.DTO.RegistroPontoResponseDTO;

@Component
public class RegistroPontoMapper {
    public RegistraPonto toEntity(String tipo, Funcionario funcionario){

        RegistraPonto registro = new RegistraPonto();

        registro.setTipo(tipo);
        registro.setFuncionario(funcionario);

        return registro;
    }

    public RegistroPontoResponseDTO toResponseDTO(RegistraPonto registro){
        RegistroPontoResponseDTO response = new RegistroPontoResponseDTO();

        response.setId(registro.getId());
        response.setTipo(registro.getTipo());
        response.setDataHora(registro.getDataHora());
        response.setFuncionario(registro.getFuncionario().getNome());

        return response;
    }
}

