package com.ponto.eletronico.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "empresa")

public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmpresa;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senhaHash;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dataCriacao = LocalDateTime.now();

    private LocalDateTime dataAtualizacao;

    @JsonManagedReference
    @OneToMany(mappedBy = "empresa")
    private List<Funcionario> funcionarios;

    public Empresa(){
    }

    @PreUpdate
    public void preUpdate(){
        this.dataAtualizacao = LocalDateTime.now();
    }

    // Getters e Setters

    public Long getIdEmpresa(){
        return idEmpresa;
    }
     public void setIdEmpresa(Long idEmpresa){
        this.idEmpresa = idEmpresa;

     }
     public String getNome(){
        return nome;
     }
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getEmail(){
        return  email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public String getSenhaHash(){
        return senhaHash;
    }
    public void setSenhaHash(String senhaHash){
        this.senhaHash = senhaHash;
    }

    public LocalDateTime getDataCriacao(){
        return dataCriacao;
    }
    public LocalDateTime getDataAtualizacao(){
        return dataAtualizacao;
    }

    public List<Funcionario> getFuncionarios(){
       return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
     this.funcionarios = funcionarios;
    }



}
