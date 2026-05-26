package com.ponto.eletronico.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class EmpresaRequestDTO {

    @NotBlank
    private String nome;

    @NotBlank
    @Size(min = 14,  max = 14 )
    private String cnpj;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }
}
