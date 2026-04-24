package com.example.integration;

import org.springframework.stereotype.Component;

@Component
public class ClienteIntegrationAdapter implements ClienteIntegration {
    private final ClienteFeignClient feignClient;

    public ClienteIntegrationAdapter(ClienteFeignClient feignClient) {
        this.feignClient = feignClient;
    }

    @Override
    public boolean clienteExiste(String clienteId) {
        try {
            feignClient.buscarClientePorId(clienteId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}