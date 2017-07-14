/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.inventorsoft.films.repository;

import co.inventorsoft.films.model.film.Film;
import co.inventorsoft.films.repository.RepositoryBase;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author anatolii vakaliuk
 */
public interface FilmRepository extends RepositoryBase<Film> {
}
