/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.inventorsoft.films.service;

import co.inventorsoft.films.model.film.Film;
import co.inventorsoft.films.model.user.User;
import co.inventorsoft.films.repository.user.UserRepository;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

/**
 * @author anatolii vakaliuk
 */
@AllArgsConstructor
@Service
public class UserService extends DefaultCrudSupport<User> implements CrudSupport<User> {

    private UserRepository userRepository;

    private FilmService filmService;


//    public void addSeenFilm(final ObjectId userId, final ObjectId filmId) {
//        final User user = findById(userId).orElseThrow(() -> new IllegalStateException("Could not find user"));
//        user.getLastSeen().add(filmId);
//        update(user);
//    }

    public void addSeenFilm(final ObjectId userId, final ObjectId filmId) {
        final Film film = filmService.findById(filmId).orElseThrow(() -> new IllegalStateException("Could not find the film"));
        userRepository.addLastSeenFilm(userId, film);
    }
}
