package com.example.service;
import com.example.entity.Produto;
import com.example.repository.ProdutoRepository;

import java.util.List;

public class ProdutoService {
    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public Produto salvar(Produto produto) {
        return repository.salvar(produto);
    }

    public List<Produto> listar() {
        return repository.buscarTodos();
    }

    public Produto buscar(String id) {
        return repository.buscarPorId(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public void excluir(String id) {
        repository.deletar(id);
    }
}