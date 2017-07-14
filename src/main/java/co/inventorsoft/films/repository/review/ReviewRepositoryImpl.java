/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.inventorsoft.films.repository.review;

import co.inventorsoft.films.model.film.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;

import java.util.Optional;

import static java.util.Objects.nonNull;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;
import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * @author anatolii vakaliuk
 */
@AllArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {

    private MongoOperations mongoOperations;

    @Override
    public Double recalculateRating(final ObjectId filmId) {
        final Aggregation aggregation = newAggregation(
                match(where("film._id").is(filmId)),
                project("rating"),
                group().avg("rating").as("rangeRating"),
                project("rangeRating")
        );
        final AggregationResults<NewRating> aggregationResults = mongoOperations.aggregate(aggregation, Review.class, NewRating.class);
        final NewRating newRating = Optional.ofNullable(aggregationResults.getUniqueMappedResult()).filter(NewRating::nonEmpty)
                .orElseGet(NewRating::createDefault);
        return newRating.getRangeRating();
    }

    @Getter
    @Setter
    private static class NewRating {

        private Double rangeRating = 0.0;

        public boolean nonEmpty() {
            return nonNull(rangeRating);
        }


        public static NewRating createDefault() {
            final NewRating newRating = new NewRating();
            newRating.setRangeRating(0.0);
            return newRating;
        }
    }
}
