package com.example.repository.mongo;

import com.example.repository.orm.VendaOrmMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VendaMongoRepository extends MongoRepository<VendaOrmMongo, String> {

}