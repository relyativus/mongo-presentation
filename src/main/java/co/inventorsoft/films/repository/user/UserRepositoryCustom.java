/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.inventorsoft.films.repository.user;

import co.inventorsoft.films.model.film.Film;
import org.bson.types.ObjectId;

/**
 * @author anatolii vakaliuk
 */
public interface UserRepositoryCustom {

    void addLastSeenFilm(final ObjectId userId, final Film film);
}
