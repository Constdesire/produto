package com.example.repository.adapter;

import com.example.entity.Venda;
import com.example.repository.mongo.VendaMongoRepository;
import com.example.repository.orm.VendaOrmMongo;
import com.example.repository.VendaRepository;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class VendaRepositoryAdapter implements VendaRepository {
    private final VendaMongoRepository mongoRepo;

    public VendaRepositoryAdapter(VendaMongoRepository mongoRepo) { this.mongoRepo = mongoRepo; }

    @Override
    public Venda salvar(Venda v) {
        var salvo = mongoRepo.save(new VendaOrmMongo(
                v.id(),
                v.clienteId(),
                v.produtos(),
                v.valorTotal()));

        return new Venda(
                salvo.id(),
                salvo.clienteId(),
                salvo.produtos(),
                salvo.valorTotal());
    }

    @Override
    public Optional<Venda> buscarPorId(String id) {
        return mongoRepo.findById(id).map(o -> new Venda(
                o.id(),
                o.clienteId(),
                o.produtos(),
                o.valorTotal()));
    }
}