/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.inventorsoft.films.model.film;

import co.inventorsoft.films.model.Identity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author anatolii vakaliuk
 */
@Getter
@Setter
@Document(collection = "genres")
@ToString
public class Genre extends Identity {

    private String name;

    private String description;

    @PersistenceConstructor
    public Genre(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
