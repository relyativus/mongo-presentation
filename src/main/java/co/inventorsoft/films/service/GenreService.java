/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.inventorsoft.films.service;

import co.inventorsoft.films.model.film.Genre;
import org.springframework.stereotype.Service;

/**
 * @author anatolii vakaliuk
 */
@Service
public class GenreService extends DefaultCrudSupport<Genre> implements CrudSupport<Genre> {
}
