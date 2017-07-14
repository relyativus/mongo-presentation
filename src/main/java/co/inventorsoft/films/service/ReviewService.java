/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.inventorsoft.films.service;

import co.inventorsoft.films.model.film.Film;
import co.inventorsoft.films.model.film.Rating;
import co.inventorsoft.films.model.film.Review;
import co.inventorsoft.films.repository.review.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

/**
 * @author anatolii vakaliuk
 */
@AllArgsConstructor
@Service
public class ReviewService extends DefaultCrudSupport<Review> implements CrudSupport<Review> {

    private FilmService filmService;

    private ReviewRepository reviewRepository;

    @Override
    public Review create(Review entity) {
        entity.setReviewCreatedEpochSeconds(Instant.now().getEpochSecond());
        final Review createdReview = super.create(entity);
        updateFilmRating(createdReview);
        return createdReview;
    }

    private void updateFilmRating(Review entity) {
        final Film film = filmService.findById(entity.getFilm().getId())
                .orElseThrow(() -> new IllegalStateException("Could not find film"));
        final Double newRating = reviewRepository.recalculateRating(film.getId());
        film.setAvgRating(newRating);
        filmService.update(film);
    }
}
