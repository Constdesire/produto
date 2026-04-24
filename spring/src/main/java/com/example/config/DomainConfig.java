package com.example.config;

import com.example.integration.ClienteIntegration;
import com.example.repository.ProdutoRepository;
import com.example.repository.VendaRepository;
import com.example.service.ProdutoService;
import com.example.service.VendaService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfig {
    @Bean
    public ProdutoService produtoService(ProdutoRepository repository) {
        return new ProdutoService(repository);
    }

    @Bean
    public VendaService vendaService(
            VendaRepository vendaRepo,
            ProdutoRepository prodRepo,
            ClienteIntegration clienteInt) {

        return new VendaService(vendaRepo, prodRepo, clienteInt);
    }
}