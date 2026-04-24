package com.example.repository;

import com.example.entity.Venda;
import java.util.Optional;

public interface VendaRepository {
    Venda salvar(Venda venda);
    Optional<Venda> buscarPorId(String id);
}