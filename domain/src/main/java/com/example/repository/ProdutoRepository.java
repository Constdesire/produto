package com.example.repository;

import com.example.entity.Produto;
import java.util.List;
import java.util.Optional;

public interface ProdutoRepository {
    Produto salvar(Produto produto);
    List<Produto> buscarTodos();
    Optional<Produto> buscarPorId(String id);
    void deletar(String id);
}