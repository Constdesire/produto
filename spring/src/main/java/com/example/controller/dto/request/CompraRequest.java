package com.example.controller.dto.request;
import java.util.List;

public record CompraRequest(
        String clienteId,
        List<String> produtosIds
) {

}