/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.inventorsoft.films.service;

import co.inventorsoft.films.model.Identity;
import org.bson.types.ObjectId;

import java.util.Optional;

/**
 * @author anatolii vakaliuk
 */
public interface CrudSupport<T extends Identity> {

    T create(final T entity);

    T update(final T entity);

    T save(final T entity);

    Optional<T> findById(final ObjectId id);

}
