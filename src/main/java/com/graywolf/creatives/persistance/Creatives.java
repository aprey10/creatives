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
    private Set<String> osList;

    @Indexed
    private Set<String> countriesList;

    @Indexed
    private Set<String> excludedCountries;

    public Creatives(String description, String url){
        this.description = description;
        this.url = url;
    }

    @Override
    public String toString(){
        return String.format(
                "Creatives [id=%s, url='%s', description='%s']",
                id, url, description);
    }

}
