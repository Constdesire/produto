package com.example.controller;

import com.example.controller.dto.request.CompraRequest;
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
}