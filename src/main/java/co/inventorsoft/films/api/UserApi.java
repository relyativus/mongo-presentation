/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.inventorsoft.films.api;

import co.inventorsoft.films.model.user.User;
import co.inventorsoft.films.service.UserService;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

import static java.lang.String.format;

/**
 * @author anatolii vakaliuk
 */
@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserApi {

    private UserService userService;

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        final User createdUser = userService.create(user);
        return ResponseEntity.created(URI.create(format("/users/%s", user.getId().toHexString()))).body(createdUser);
    }

    @PostMapping("/{userId}/films/lastSeen")
    public ResponseEntity seeFilm(@PathVariable("userId") String userIdHex,
                                  @RequestParam("filmId") String filmIdHex) {
        final ObjectId filmId = new ObjectId(filmIdHex);
        final ObjectId userId = new ObjectId(userIdHex);
        userService.addSeenFilm(userId, filmId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
