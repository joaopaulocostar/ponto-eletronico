package com.ponto.eletronico.controller;


import com.ponto.eletronico.model.Empresa;
import com.ponto.eletronico.model.Funcionario;
import com.ponto.eletronico.service.EmpresaService;
import com.ponto.eletronico.service.FuncionarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioService service;
    private final EmpresaService empresaService;

    public FuncionarioController(FuncionarioService service, EmpresaService empresaService){
        this.service = service;
        this.empresaService = empresaService;
    }

    @PostMapping
    public ResponseEntity<Funcionario> salvar(@RequestBody Funcionario funcionario){
        Empresa empresa = empresaService.buscarPorId(funcionario.getEmpresa().getId());
        funcionario.setEmpresa(empresa);

        return ResponseEntity.ok(service.salvar(funcionario));

    }

    @GetMapping
    public ResponseEntity<List> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizar(@PathVariable Long id, @RequestBody Funcionario funcionario){
        return ResponseEntity.ok(service.atualizar(id, funcionario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Funcionario> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
