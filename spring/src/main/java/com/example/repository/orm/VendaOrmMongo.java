package com.example.repository.orm;

import com.example.entity.Produto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "vendas")
public record VendaOrmMongo(
        @Id
        String id,
        String clienteId,
        List<Produto> produtos,
        Double valorTotal) {

}