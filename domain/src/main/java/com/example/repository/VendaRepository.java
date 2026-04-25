package com.example.repository;

import com.example.entity.Venda;

import java.util.List;
import java.util.Optional;

public interface VendaRepository {
    Venda salvar(Venda venda);
    Optional<Venda> buscarPorId(String id);
    List<Venda> findAll();
    void deletar(String id);
    Venda atualizar(Venda venda);
}