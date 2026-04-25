package com.example.controller;

import com.example.entity.dto.CompraRequest;
import com.example.entity.Venda;
import com.example.service.VendaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vendas")
public class VendaController {
    private final VendaService service;

    public VendaController(VendaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Venda> listarTodas() {
        return service.listarTodas();
    }

    @PostMapping
    public Venda realizarCompra(@RequestBody CompraRequest request) {
        return service.realizarCompra(
                request.clienteId(),
                request.produtosIds());
    }

    @GetMapping("/{id}")
    public Venda consultarVenda(@PathVariable String id) {
        return service.consultarVenda(id);
    }

    @PutMapping("/{id}")
    public Venda atualizarVenda(@PathVariable String id, @RequestBody CompraRequest request) {
        return service.atualizarVenda(id, request);
    }

    @DeleteMapping("/{id}")
    public void deletarVenda(@PathVariable String id) {
        service.deletarVenda(id);
    }
}
