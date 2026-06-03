package com.ponto.eletronico.controller;


import com.ponto.eletronico.DTO.RegistroPontoRequestDTO;
import com.ponto.eletronico.DTO.RegistroPontoResponseDTO;
import com.ponto.eletronico.mapper.RegistroPontoMapper;
import com.ponto.eletronico.model.Funcionario;
import com.ponto.eletronico.model.RegistraPonto;
import com.ponto.eletronico.service.FuncionarioService;
import com.ponto.eletronico.service.RegistraPontoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registros-ponto")
public class RegistraPontoController {

    private final RegistraPontoService service;
    private final FuncionarioService funcionarioService;
    private final RegistroPontoMapper mapper;

    public RegistraPontoController(RegistraPontoService service, FuncionarioService funcionarioService, RegistroPontoMapper mapper){
        this.service = service;
        this.funcionarioService = funcionarioService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<RegistroPontoResponseDTO> salvar(@RequestBody @Valid RegistroPontoRequestDTO dto){
        Funcionario funcionario = funcionarioService.buscarPorId(dto.getFuncionarioId());
        RegistraPonto registro = mapper.toEntity(dto.getTipo(), funcionario);
        RegistraPonto registroSalvo = service.salvar(registro);
        return ResponseEntity.ok(mapper.toResponseDTO(registroSalvo));
    }

    @GetMapping
    public ResponseEntity<List<RegistroPontoResponseDTO>> listar(){
        List<RegistroPontoResponseDTO> response = service.listar().stream().map(mapper::toResponseDTO).toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistroPontoResponseDTO> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(mapper.toResponseDTO(service.buscarPorId(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
