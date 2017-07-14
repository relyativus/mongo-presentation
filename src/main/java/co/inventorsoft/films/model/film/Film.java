/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.inventorsoft.films.model.film;

import co.inventorsoft.films.model.Identity;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

/**
 * @author anatolii vakaliuk
 */
@Getter
@Setter
@Document(collection = "films")
public class Film extends Identity {

    @TextIndexed
    private String name;

    private String description;

    private int year;

    private Set<SimpleGenre> genres;

    private Double avgRating;

    private Set<SimpleActor> actors;

    @Getter
    @Setter
    public static class SimpleActor {

        private ObjectId id;

        private String name;

    }

    @Getter
    @Setter
    public static class SimpleGenre {

        private ObjectId id;

        private String name;
    }

}
