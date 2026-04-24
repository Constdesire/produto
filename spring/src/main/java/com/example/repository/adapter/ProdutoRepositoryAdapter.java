package com.example.repository.adapter;

import com.example.entity.Produto;
import com.example.repository.mongo.ProdutoMongoRepository;
import com.example.repository.orm.ProdutoOrmMongo;
import com.example.repository.ProdutoRepository;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class ProdutoRepositoryAdapter implements ProdutoRepository {
    private final ProdutoMongoRepository mongoRepo;

    public ProdutoRepositoryAdapter(ProdutoMongoRepository mongoRepo) {
        this.mongoRepo = mongoRepo;
    }

    @Override
    public Produto salvar(Produto p) {
        var salvo = mongoRepo.save(new ProdutoOrmMongo(
                p.id(),
                p.nome(),
                p.preco()));

        return new Produto(
                salvo.id(),
                salvo.nome(),
                salvo.preco());
    }

    @Override
    public List<Produto> buscarTodos() {
        return mongoRepo.findAll().stream().map(o -> new Produto(
                o.id(),
                o.nome(),
                o.preco()))
                .toList();
    }

    @Override
    public Optional<Produto> buscarPorId(String id) {
        return mongoRepo.findById(id).map(o -> new Produto(
                o.id(),
                o.nome(),
                o.preco()));
    }

    @Override
    public void deletar(String id) {
        mongoRepo.deleteById(id);
    }
}