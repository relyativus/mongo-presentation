/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.inventorsoft.films.api;

import co.inventorsoft.films.model.film.Film;
import co.inventorsoft.films.service.FilmService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

import static java.lang.String.format;

/**
 * @author anatolii vakaliuk
 */
@AllArgsConstructor
@RestController
@RequestMapping("/films")
public class FilmApi {

    private FilmService filmService;

    @PostMapping
    public ResponseEntity<Film> createFilm(@RequestBody Film film) {
        final Film createdFilm = filmService.create(film);

        return ResponseEntity.created(URI.create(format("/films/%s", createdFilm.getId().toHexString())))
                .body(createdFilm);
    }
}
