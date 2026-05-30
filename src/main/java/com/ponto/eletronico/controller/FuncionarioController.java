package com.ponto.eletronico.controller;


import com.ponto.eletronico.DTO.FuncionarioRequestDTO;
import com.ponto.eletronico.DTO.FuncionarioResponseDTO;
import com.ponto.eletronico.mapper.FuncionarioMapper;
import com.ponto.eletronico.model.Empresa;
import com.ponto.eletronico.model.Funcionario;
import com.ponto.eletronico.service.EmpresaService;
import com.ponto.eletronico.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioService service;
    private final EmpresaService empresaService;
    private final FuncionarioMapper mapper;

    public FuncionarioController(FuncionarioService service, EmpresaService empresaService, FuncionarioMapper mapper){
        this.service = service;
        this.empresaService = empresaService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<FuncionarioResponseDTO> salvar(@RequestBody @Valid FuncionarioRequestDTO dto){
        Empresa empresa = empresaService.buscarPorId(dto.getEmpresaId());
        Funcionario funcionario = mapper.toEntity(dto, empresa);

        Funcionario funcionarioSalvo = service.salvar(funcionario);

        return ResponseEntity.ok(mapper.toResponseDTO(funcionarioSalvo));

    }

    @GetMapping
    public ResponseEntity<List<FuncionarioResponseDTO>> listar(){
        List<Funcionario> funcionarios = service.listar();
        List<FuncionarioResponseDTO> response = new ArrayList<>();
        for(Funcionario funcionario: funcionarios){
           response.add(mapper.toResponseDTO(funcionario));
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioResponseDTO> buscarPorId(@PathVariable Long id){
        Funcionario funcionario = service.buscarPorId(id);
        return ResponseEntity.ok(mapper.toResponseDTO(funcionario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioResponseDTO> atualizar(@PathVariable Long id, @RequestBody @Valid FuncionarioRequestDTO dto){
        Empresa empresa = empresaService.buscarPorId(id);
        Funcionario funcionario = mapper.toEntity(dto, empresa);
        Funcionario funcionarioAtualizado = service.atualizar(id, funcionario);

        return ResponseEntity.ok(mapper.toResponseDTO(funcionarioAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Funcionario> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
