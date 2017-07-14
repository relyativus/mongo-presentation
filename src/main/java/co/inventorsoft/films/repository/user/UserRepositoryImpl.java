/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.inventorsoft.films.repository.user;

import co.inventorsoft.films.model.film.Film;
import co.inventorsoft.films.model.film.SimpleFilm;
import co.inventorsoft.films.model.user.User;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.Fields;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * @author anatolii vakaliuk
 */
@AllArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom  {

    private MongoOperations mongoOperations;

    @Override
    public void addLastSeenFilm(ObjectId userId, Film film) {
        Update update = new Update();
        final Update.PushOperatorBuilder push = update.push("lastSeen");
        push.each(new SimpleFilm(film));
        push.sort(Sort.Direction.DESC);
        push.slice(5);

        mongoOperations.findAndModify(new Query(where(Fields.UNDERSCORE_ID).is(userId)), update, User.class);
    }
}
