package com.ponto.eletronico.controller;


import com.ponto.eletronico.DTO.FuncionarioRequestDTO;
import com.ponto.eletronico.DTO.FuncionarioResponseDTO;
import com.ponto.eletronico.model.Empresa;
import com.ponto.eletronico.model.Funcionario;
import com.ponto.eletronico.service.EmpresaService;
import com.ponto.eletronico.service.FuncionarioService;
import jakarta.validation.Valid;
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
    public ResponseEntity<List> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
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
