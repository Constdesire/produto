package com.example.repository.mongo;

import com.example.repository.orm.ProdutoOrmMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProdutoMongoRepository extends MongoRepository<ProdutoOrmMongo, String> {

}