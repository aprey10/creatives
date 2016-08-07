package com.graywolf.creatives.persistance;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by graywolf on 7/30/16.
 */
@Data
@Document(collection = "creatives")
public class Creatives {

    @Id
    private String id;
    private String description;
    private String url;

    @Indexed
    private Set<Integer> osList;

    @Indexed
    private Set<Integer> countriesList;

    @Indexed
    private Set<Integer> excludedCountries;

    public Creatives(){

    }

    public Creatives(String description, String url, Set<Integer> osList, Set<Integer> countriesList,
                     Set<Integer> excludedCountriesList){
        this.description = description;
        this.url = url;
        this.osList = new HashSet<>(osList);
        this.countriesList = new HashSet<>(countriesList);
        this.excludedCountries = new HashSet<>(excludedCountriesList);
    }

    @Override
    public String toString(){
        return String.format(
                "Creatives [id=%s, url='%s', description='%s']",
                id, url, description);
    }

}
