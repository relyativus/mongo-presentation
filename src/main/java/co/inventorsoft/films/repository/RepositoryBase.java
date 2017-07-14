/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.inventorsoft.films.repository;

import co.inventorsoft.films.model.Identity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * @author anatolii vakaliuk
 */
public interface RepositoryBase<T extends Identity> extends MongoRepository<T, ObjectId> {

    Optional<T> findById(final ObjectId id);
}
