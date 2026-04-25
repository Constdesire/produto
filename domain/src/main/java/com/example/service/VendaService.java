package com.example.service;

import com.example.entity.Produto;
import com.example.entity.Venda;
import com.example.entity.dto.CompraRequest;
import com.example.integration.ClienteIntegration;
import com.example.repository.ProdutoRepository;
import com.example.repository.VendaRepository;
import java.util.List;
import java.util.UUID;

public class VendaService {
    private final VendaRepository vendaRepository;
    private final ProdutoRepository produtoRepository;
    private final ClienteIntegration clienteIntegration;


    public VendaService(VendaRepository vendaRepository, ProdutoRepository produtoRepository, ClienteIntegration clienteIntegration) {
        this.vendaRepository = vendaRepository;
        this.produtoRepository = produtoRepository;
        this.clienteIntegration = clienteIntegration;
    }

    public List<Venda> listarTodas() {
        return vendaRepository.findAll();
    }

    public Venda realizarCompra(String clienteId, List<String> produtosIds) {
        if (!clienteIntegration.clienteExiste(clienteId)) {
            throw new RuntimeException("Cliente não encontrado na base de clientes!");
        }

        List<Produto> produtos = produtosIds.stream()
                .map(id -> produtoRepository.buscarPorId(id).orElseThrow(() -> new RuntimeException("Produto ID " + id + " não encontrado")))
                .toList();

        Double total = produtos.stream().mapToDouble(Produto::preco).sum();

        Venda venda = new Venda(
                UUID.randomUUID().toString(),
                clienteId,
                produtos,
                total);

        return vendaRepository.salvar(venda);
    }

    public Venda consultarVenda(String id) {
        return vendaRepository.buscarPorId(id).orElseThrow(() -> new RuntimeException("Venda não encontrada"));
    }

    public Venda atualizarVenda(String id, CompraRequest request) {
        Venda vendaExistente = vendaRepository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Venda não encontrada"));

        if (!clienteIntegration.clienteExiste(request.clienteId())) {
            throw new RuntimeException("Cliente não encontrado!");
        }

        List<Produto> novosProdutos = request.produtosIds().stream()
                .map(pId -> produtoRepository.buscarPorId(pId)
                        .orElseThrow(() -> new RuntimeException("Produto " + pId + " não encontrado")))
                .toList();

        Double novoTotal = novosProdutos.stream().mapToDouble(Produto::preco).sum();

        Venda vendaAtualizada = new Venda(
                id,
                request.clienteId(),
                novosProdutos,
                novoTotal);

        return vendaRepository.atualizar(vendaAtualizada);
    }

    public void deletarVenda(String id) {
        if (!vendaRepository.buscarPorId(id).isPresent()) {
            throw new RuntimeException("Venda não encontrada para exclusão");
        }
        vendaRepository.deletar(id);
    }
}