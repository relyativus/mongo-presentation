/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.inventorsoft.films.repository.review;

import co.inventorsoft.films.model.film.Review;
import co.inventorsoft.films.repository.RepositoryBase;

/**
 * @author anatolii vakaliuk
 */
public interface ReviewRepository extends RepositoryBase<Review>, ReviewRepositoryCustom {
}
