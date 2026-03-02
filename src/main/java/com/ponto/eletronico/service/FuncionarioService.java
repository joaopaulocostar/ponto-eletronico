package com.ponto.eletronico.service;

import com.ponto.eletronico.exception.RegraDeNegocioException;
import com.ponto.eletronico.model.Funcionario;
import com.ponto.eletronico.model.Empresa;
import com.ponto.eletronico.repository.FuncionarioRepository;
import com.ponto.eletronico.repository.EmpresaRepository;
import com.ponto.eletronico.exception.RecursoNaoEncontradoException;
import com.ponto.eletronico.exception.EmailJaCadastradoException;
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
        Empresa empresa = empresaRepository.findById(idEmpresa).orElseThrow(() -> new RecursoNaoEncontradoException("Empresa não encontrada"));
        if (funcionarioRepository.existsByEmail(funcionario.getEmail())){
            throw new EmailJaCadastradoException("Email já cadastrado");
        }

        if (funcionario.getNome() == null || funcionario.getNome().isBlank()){
            throw new RegraDeNegocioException("Nome é obrigatório");
        }

        funcionario.setEmpresa(empresa);
        return funcionarioRepository.save(funcionario);
    }

    public List<Funcionario> listarTodos(){
        return funcionarioRepository.findAll();
    }

    public Funcionario buscarPorId(Long id){
        return funcionarioRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Funcionário não encontrado"));
    }
}
