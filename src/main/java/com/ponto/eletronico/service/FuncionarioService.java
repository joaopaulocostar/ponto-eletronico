package com.ponto.eletronico.service;

import com.ponto.eletronico.model.Funcionario;
import com.ponto.eletronico.model.Empresa;
import com.ponto.eletronico.repository.FuncionarioRepository;
import com.ponto.eletronico.repository.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final EmpresaRepository empresaRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository, EmpresaRepository empresaRepository){
        this.funcionarioRepository = funcionarioRepository;
        this.empresaRepository = empresaRepository;
    }

    public Funcionario salvar(Funcionario funcionario, Long idEmpresa){
        Empresa empresa = empresaRepository.findById(idEmpresa).orElseThrow(() -> new RuntimeException("Empresa não encontrada"));
        funcionario.setEmpresa(empresa);
        return funcionarioRepository.save(funcionario);
    }

    public List<Funcionario> ListarTodos(){
        return funcionarioRepository.findAll();
    }

    public Funcionario buscarPorid(Long id){
        return funcionarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));
    }
}
