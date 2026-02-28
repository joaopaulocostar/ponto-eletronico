package com.ponto.eletronico.controller;

import com.ponto.eletronico.model.Empresa;
import com.ponto.eletronico.service.EmpresaService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @PostMapping
    public Empresa criarEmpresa(@RequestBody Empresa empresa) {
        return empresaService.salvar(empresa);
    }

    @GetMapping
    public List<Empresa> ListarEmpresas(){
        return empresaService.ListarTodas();
    }

    @GetMapping("/{id}")
    public Empresa buscarEmpresa(@PathVariable Long id) {
        return empresaService.buscarPorId(id);
    }
}
