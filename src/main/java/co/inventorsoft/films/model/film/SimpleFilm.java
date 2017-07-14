/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.inventorsoft.films.model.film;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;

/**
 * @author anatolii vakaliuk
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SimpleFilm {

    private ObjectId id;

    private String name;

    public SimpleFilm(Film film) {
        this.id = film.getId();
        this.name = film.getName();
    }
}
