package com.graywolf.creatives.persistance;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by graywolf on 8/1/16.
 */
public interface CreativesRepository extends MongoRepository<Creatives, String> {

}
