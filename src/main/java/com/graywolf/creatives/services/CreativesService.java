package com.graywolf.creatives.services;

import com.graywolf.creatives.persistance.Country;
import com.graywolf.creatives.persistance.Creatives;
import com.graywolf.creatives.persistance.CreativesRepository;
import com.graywolf.creatives.persistance.OperationSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by graywolf on 8/7/16.
 */
@Service
public class CreativesService {

    @Autowired
    private CreativesRepository repository;

    @Autowired
    private MongoTemplate mongoTemplate;


    public List<Creatives> findAllByOsAndCountry(String countryCode, String osName, int limit) {
        OperationSystem os = OperationSystem.findByName(osName);
        Country country = Country.findByCode(countryCode);
        if((os == null) || (country == null)){
            throw new IllegalArgumentException("Can't find Country or OS");
        }

        return mongoTemplate.find(buildQuery(os.getId(), country.getId(), limit), Creatives.class);
    }

    private Query buildQuery(int os, int country, int limit){
        Query query = new Query();
        query.addCriteria(Criteria.where("osList").is(os));
        query.addCriteria(Criteria.where("countriesList").is(country));
        query.addCriteria(Criteria.where("excludedCountries").ne(country));
        query.limit(limit);

        return query;
    }
}
