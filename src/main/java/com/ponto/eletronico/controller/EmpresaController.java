package com.ponto.eletronico.controller;

import com.ponto.eletronico.service.EmpresaService;
import com.ponto.eletronico.model.Empresa;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    private final EmpresaService service;

    public EmpresaController(EmpresaService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Empresa> salvar(@RequestBody Empresa empresa){
        return ResponseEntity.ok(
                service.salvar(empresa)
        );
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
    public ResponseEntity<Empresa> atualizar(@PathVariable Long id, @RequestBody Empresa empresa){
        return ResponseEntity.ok(service.atualizar(id, empresa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
