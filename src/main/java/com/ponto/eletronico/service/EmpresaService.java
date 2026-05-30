package com.ponto.eletronico.service;

import com.ponto.eletronico.exceptions.CpfJaCadastradoException;
import com.ponto.eletronico.exceptions.EmpresaNaoEncontradaException;
import com.ponto.eletronico.repository.EmpresaRepository;
import com.ponto.eletronico.model.Empresa;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmpresaService {

    private  final EmpresaRepository repository;

    public EmpresaService(EmpresaRepository repository){
        this.repository = repository;
    }

    public Empresa salvar(Empresa empresa){
        if(repository.existsByCnpj(empresa.getCnpj())){
            throw new CpfJaCadastradoException(empresa.getCnpj());
        }

        return repository.save(empresa);
    }

    public List<Empresa> Listar(){
        return repository.findAll();
    }

    public Empresa buscarPorId(Long id){
        return repository.findById(id).orElseThrow(()-> new EmpresaNaoEncontradaException(id));
    };

    public Empresa atualizar(Long id, Empresa empresaAtualizada ){
        Empresa empresa = buscarPorId(id);
        empresa.setNome(empresaAtualizada.getNome());
        empresa.setCnpj(empresaAtualizada.getCnpj());

        return repository.save(empresa);
    }

    public void deletar(Long id){
        Empresa empresa = buscarPorId(id);
        repository.delete(empresa);
    }
}
