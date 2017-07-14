/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.inventorsoft.films.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

/**
 * @author anatolii vakaliuk
 */
@Getter
@Setter
public abstract class Identity {

    private ObjectId id;
}
