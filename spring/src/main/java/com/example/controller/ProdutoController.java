package com.example.controller;

import com.example.controller.dto.request.ProdutoRequest;
import com.example.entity.Produto;
import com.example.service.ProdutoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoService service;

    public ProdutoController(ProdutoService service) { this.service = service; }

    @PostMapping
    public Produto criar(@RequestBody ProdutoRequest request) {
        return service.salvar(new Produto(
                UUID.randomUUID().toString(),
                request.nome(),
                request.preco()));
    }

    @GetMapping
    public List<Produto> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Produto buscar(@PathVariable String id) {
        return service.buscar(id);
    }

    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable String id, @RequestBody ProdutoRequest request) {
        return service.salvar(new Produto(id, request.nome(), request.preco()));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String id) { service.excluir(id); }
}
