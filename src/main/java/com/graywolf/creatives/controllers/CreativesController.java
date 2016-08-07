package com.graywolf.creatives.controllers;

import com.graywolf.creatives.persistance.Creatives;
import com.graywolf.creatives.persistance.CreativesRepository;
import com.graywolf.creatives.services.CreativesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

/**
 * Created by graywolf on 8/7/16.
 */
@Component
@Path("/creatives")
public class CreativesController {

    @Autowired
    CreativesService creativesService;

    @GET
    @Produces("application/json")
    public List<Creatives> getCreatives() {

        return creativesService.findAllByOsAndCountry("1", "2", 5);
    }
}
