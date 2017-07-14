/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.inventorsoft.films.service;

import co.inventorsoft.films.model.Identity;
import co.inventorsoft.films.repository.RepositoryBase;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

/**
 * @author anatolii vakaliuk
 */
public class DefaultCrudSupport<T extends Identity> implements CrudSupport<T> {

    @Autowired
    private RepositoryBase<T> repository;

    @Override
    public T create(T entity) {
        return repository.insert(entity);
    }

    @Override
    public T update(T entity) {
        return repository.save(entity);
    }

    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public Optional<T> findById(ObjectId id) {
        return repository.findById(id);
    }
}
