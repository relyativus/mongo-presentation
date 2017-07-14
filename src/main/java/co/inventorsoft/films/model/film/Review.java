/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.inventorsoft.films.model.film;

import co.inventorsoft.films.model.Identity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author anatolii vakaliuk
 */
@Getter
@Setter
@Document(collection = "reviews")
public class Review extends Identity {

    private String summary;

    private String text;

    private Long rating;

    private SimpleFilm film;

    private SimpleUser user;

    private Long reviewCreatedEpochSeconds;

    @Data
    public static class SimpleUser {

        private ObjectId id;

        private String name;
    }
}
