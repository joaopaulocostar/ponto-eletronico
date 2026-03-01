package com.ponto.eletronico.controller;

import com.ponto.eletronico.model.Funcionario;
import com.ponto.eletronico.service.FuncionarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping("/{idEmpresa}")
    public Funcionario criarFuncionario(@RequestBody Funcionario funcionario, @PathVariable Long idEmpresa){
        return funcionarioService.salvar(funcionario, idEmpresa);
    }

    @GetMapping
    public List<Funcionario> ListarFuncionarios(){
        return funcionarioService.ListarTodos();
    }

    @GetMapping("/{id}")
    public Funcionario buscarFuncionario(@PathVariable Long id) {
        return funcionarioService.buscarPorid(id);
    }
}
