package com.ponto.eletronico.service;


import com.ponto.eletronico.model.Funcionario;
import com.ponto.eletronico.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

    private final FuncionarioRepository repository;

    public FuncionarioService(FuncionarioRepository repository){
        this.repository = repository;
    }

    public Funcionario salvar(Funcionario funcionario){
        if(repository.existsByCpf(funcionario.getCpf())){
            throw new RuntimeException("CPF já cadastrado");
        }
        return repository.save(funcionario);
    }
}
