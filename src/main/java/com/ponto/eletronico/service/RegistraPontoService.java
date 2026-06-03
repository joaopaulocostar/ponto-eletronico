package com.ponto.eletronico.service;

import com.ponto.eletronico.model.RegistraPonto;
import com.ponto.eletronico.repository.RegistraPontoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RegistraPontoService {

    private final RegistraPontoRepository repository;
    public RegistraPontoService(RegistraPontoRepository repository){
        this.repository = repository;
    }

    public RegistraPonto salvar(RegistraPonto registro){
        registro.setDataHora(LocalDateTime.now());
        return repository.save(registro);
    }

    public List<RegistraPonto> listar(){
        return repository.findAll();
    }

    public RegistraPonto buscarPorId(Long id){
        return repository.findById(id).orElseThrow(()-> new RuntimeException("Registro não encontrado"));
    }

    public void deletar(Long id){
        buscarPorId(id);
        repository.deleteById(id);
    }
}
