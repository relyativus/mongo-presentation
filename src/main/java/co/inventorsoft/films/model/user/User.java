/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.inventorsoft.films.model.user;

import co.inventorsoft.films.model.Identity;
import co.inventorsoft.films.model.film.SimpleFilm;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * @author anatolii vakaliuk
 */
@Getter
@Setter
@Document(collection = "users")
public class User extends Identity {

    private String name;

    private String password;

    private List<SocialMedia> mediaLinks;

    private List<SimpleFilm> lastSeen;
}
