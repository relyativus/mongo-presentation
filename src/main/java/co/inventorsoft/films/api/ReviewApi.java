/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.inventorsoft.films.api;

import co.inventorsoft.films.model.film.Review;
import co.inventorsoft.films.service.ReviewService;
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
@RequestMapping("/reviews")
public class ReviewApi {

    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> create(@RequestBody Review review) {
        final Review createdReview = reviewService.create(review);

        return ResponseEntity.created(URI.create(format("/reviews/%s", createdReview.getId().toHexString())))
                .body(createdReview);
    }
}
