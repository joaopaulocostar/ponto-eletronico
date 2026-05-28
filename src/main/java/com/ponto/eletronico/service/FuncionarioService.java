package com.ponto.eletronico.service;


import com.ponto.eletronico.model.Funcionario;
import com.ponto.eletronico.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Funcionario> listar(){
        return repository.findAll();
    }

    public Funcionario buscarPorId(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));
    }
    public Funcionario atualizar(Long id, Funcionario funcionarioAtualizado){
        Funcionario funcionario = buscarPorId(id);
        funcionario.setNome(funcionarioAtualizado.getNome());
        funcionario.setCargo(funcionarioAtualizado.getCargo());

        return repository.save(funcionario);
    }

    public void deletar(Long id){
        Funcionario funcionario = buscarPorId(id);
        repository.delete(funcionario);
    }
}
