package com.example.entity.dto;
import java.util.List;

public record CompraRequest(
        String clienteId,
        List<String> produtosIds
) {

}