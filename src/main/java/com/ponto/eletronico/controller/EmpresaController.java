package com.ponto.eletronico.controller;

import com.ponto.eletronico.DTO.EmpresaRequestDTO;
import com.ponto.eletronico.DTO.EmpresaResponseDTO;
import com.ponto.eletronico.service.EmpresaService;
import com.ponto.eletronico.model.Empresa;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    private final EmpresaService service;

    public EmpresaController(EmpresaService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<EmpresaResponseDTO> salvar(@RequestBody @Valid EmpresaRequestDTO dto){

        Empresa empresa = new Empresa();
        empresa.setNome(dto.getNome());
        empresa.setCnpj(dto.getCnpj());

        Empresa empresaSalva = service.salvar(empresa);
        EmpresaResponseDTO response = new EmpresaResponseDTO();

        response.setId(empresaSalva.getId());
        response.setCnpj(empresaSalva.getCnpj());
        response.setNome(empresaSalva.getNome());

        return ResponseEntity.ok(response);
    }
    @GetMapping
    public ResponseEntity<List<Empresa>> listar(){
        return ResponseEntity.ok(
            service.Listar()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empresa> atualizar(@PathVariable Long id, @RequestBody @Valid Empresa empresa){
        return ResponseEntity.ok(service.atualizar(id, empresa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
