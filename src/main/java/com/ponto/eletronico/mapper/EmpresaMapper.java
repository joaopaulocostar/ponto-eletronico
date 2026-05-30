package com.ponto.eletronico.mapper;

import com.ponto.eletronico.DTO.EmpresaRequestDTO;
import com.ponto.eletronico.DTO.EmpresaResponseDTO;
import com.ponto.eletronico.model.Empresa;
import org.springframework.stereotype.Component;

@Component
public class EmpresaMapper {
    public EmpresaResponseDTO toResponseDTO(Empresa empresa){
        EmpresaResponseDTO response = new EmpresaResponseDTO();

        response.setCnpj(empresa.getCnpj());
        response.setId(empresa.getId());
        response.setNome(empresa.getNome());

        return response;

    }

    public Empresa toEntity(EmpresaRequestDTO dto){
        Empresa empresa = new Empresa();
        empresa.setNome(dto.getNome());
        empresa.setCnpj(dto.getCnpj());

        return empresa;
    }
}
