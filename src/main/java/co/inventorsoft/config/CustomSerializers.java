/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.inventorsoft.config;

import org.bson.types.ObjectId;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author anatolii vakaliuk
 */
@Configuration
public class CustomSerializers extends WebMvcConfigurerAdapter {


    @Bean
    public Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder() {
        final Jackson2ObjectMapperBuilder mapperBuilder = new Jackson2ObjectMapperBuilder();
        mapperBuilder.deserializerByType(ObjectId.class, new ObjectIdDeserializer());
        mapperBuilder.serializerByType(ObjectId.class, new ObjectIdSerializer());
        return mapperBuilder;
    }
}
