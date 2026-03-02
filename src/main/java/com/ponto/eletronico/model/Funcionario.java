package com.ponto.eletronico.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "funcionarios")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFuncionario;

    @ManyToOne (optional = false)
    @JoinColumn(name = "id_empresa", nullable = false)
    @JsonBackReference
    private Empresa empresa;

    @NotBlank(message = "Nome é obrigatório")
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String sobrenome;

    @NotBlank(message = ("Email é obrigatório"))
    @Email(message = "Email inválido")
    @Column(nullable = false)
    private String email;

    @NotBlank(message = "Senha é obrigatória")
    @Column(nullable = false)
    private String senhaHash;

    @Column(nullable = false)
    private Boolean isAdmin = false;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dataCriacao = LocalDateTime.now();

    private LocalDateTime dataAtualizacao;

    public Funcionario(){
    }

    @PreUpdate
    public void preUpdate(){
        this.dataAtualizacao = LocalDateTime.now();
    }

    // Getters e Setters

    public Long getIdFuncionario(){
        return idFuncionario;
    }

    public Empresa getEmpresa(){
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenhaHash() {
        return senhaHash;
    }

    public void setSenhaHash(String senhaHash) {
        this.senhaHash = senhaHash;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }
}
