/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.inventorsoft.films.service;

import co.inventorsoft.films.model.film.Actor;
import co.inventorsoft.films.model.film.Genre;
import co.inventorsoft.films.repository.ActorRepository;
import co.inventorsoft.films.repository.GenreRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author anatolii vakaliuk
 */
@Slf4j
@AllArgsConstructor
@Component
public class DbInitializer {

    private ActorRepository actorRepository;

    private GenreRepository genreRepository;

    @EventListener(ContextRefreshedEvent.class)
    public void initDb() {
        if (actorRepository.count() == 0) {
            final List<Actor> actors = Arrays.asList(
                    new Actor("John Travolta", 63),
                    new Actor("Tim Roth", 56),
                    new Actor("Brad Pitt", 53),
                    new Actor("Natalie Portman", 36)
            );

            actorRepository.insert(actors);
            log.info("Actors initialized {}", actors);
        }

        if (genreRepository.count() == 0) {
            final List<Genre> genres = Arrays.asList(
                    new Genre("Criminal", "Based on gangsters stories"),
                    new Genre("Fantasy", "Has elements of miracle"),
                    new Genre("Phsycological horror", "Usually has a complex screen")
            );
            genreRepository.insert(genres);
            log.info("Genres initialized {}", genres);
        }
    }
}
