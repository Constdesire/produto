package com.example.repository.orm;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "produtos")
public record ProdutoOrmMongo(
        @Id
        String id,
        String nome,
        Double preco) {

}
