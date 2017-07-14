/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.inventorsoft.films.model.film;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

/**
 * @author anatolii vakaliuk
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rating {

    private Double value;

    private Long lastReviewDateMillis;

    private Integer calculatedReviewCount;

    public static Rating createDefault() {
        final Rating rating = new Rating();
        rating.setValue(0.0);
        rating.setCalculatedReviewCount(1);
        rating.setLastReviewDateMillis(Instant.MIN.getEpochSecond());
        return rating;
    }
}
