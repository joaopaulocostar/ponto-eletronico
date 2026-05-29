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
        Funcionario funcionario = new Funcionario();

        funcionario.setNome(dto.getNome());
        funcionario.setCpf(dto.getCpf());
        funcionario.setCargo(dto.getCargo());
        funcionario.setEmpresa(empresa);

        Funcionario funcionarioSalvo = service.salvar(funcionario);

        FuncionarioResponseDTO response = new FuncionarioResponseDTO();

        response.setId(funcionarioSalvo.getId());
        response.setNome(funcionarioSalvo.getNome());
        response.setCpf(funcionarioSalvo.getCpf());
        response.setCargo(funcionarioSalvo.getCargo());
        response.setEmpresa(funcionarioSalvo.getEmpresa().getNome());

        return ResponseEntity.ok(response);

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
    public ResponseEntity<Funcionario> atualizar(@PathVariable Long id, @RequestBody @Valid Funcionario funcionario){
        return ResponseEntity.ok(service.atualizar(id, funcionario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Funcionario> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
