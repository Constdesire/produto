package com.example.entity;

import java.util.List;

public record Venda(
        String id,
        String clienteId,
        List<Produto> produtos,
        Double valorTotal
) {

}