package com.ponto.eletronico.controller;

import com.ponto.eletronico.DTO.EmpresaRequestDTO;
import com.ponto.eletronico.DTO.EmpresaResponseDTO;
import com.ponto.eletronico.mapper.EmpresaMapper;
import com.ponto.eletronico.service.EmpresaService;
import com.ponto.eletronico.model.Empresa;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    private final EmpresaService service;
    private final EmpresaMapper mapper;

    public EmpresaController(EmpresaService service, EmpresaMapper mapper){
        this.service = service; this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<EmpresaResponseDTO> salvar(@RequestBody @Valid EmpresaRequestDTO dto){

        Empresa empresa = mapper.toEntity(dto);
        Empresa empresaSalva = service.salvar(empresa);

        return ResponseEntity.ok(mapper.toResponseDTO(empresaSalva));
    }
    @GetMapping
    public ResponseEntity<List<EmpresaResponseDTO>> listar(){
        List<Empresa> empresas = service.Listar();
        List<EmpresaResponseDTO> response = new ArrayList<>();

        for(Empresa empresa: empresas){
            response.add(mapper.toResponseDTO(empresa));
        }

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpresaResponseDTO> buscarPorId(@PathVariable Long id){
        Empresa empresa = service.buscarPorId(id);
        return ResponseEntity.ok(mapper.toResponseDTO(empresa));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpresaResponseDTO> atualizar(@PathVariable Long id, @RequestBody @Valid EmpresaRequestDTO dto){
        Empresa empresa = mapper.toEntity(dto);
        Empresa empresaAtualizada = service.atualizar(id, empresa);

        return ResponseEntity.ok(mapper.toResponseDTO(empresaAtualizada));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
