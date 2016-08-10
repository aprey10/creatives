package com.graywolf.creatives.controllers;

import com.graywolf.creatives.BootstrapData;
import com.graywolf.creatives.persistance.Creatives;
import com.graywolf.creatives.persistance.CreativesRepository;
import com.graywolf.creatives.services.CreativesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import java.net.MalformedURLException;
import java.util.List;

/**
 * Created by graywolf on 8/7/16.
 */
@Component
@Path("/creatives")
public class CreativesController {

    private final int CREATIVES_SIZE = 20000;

    @Autowired
    private CreativesService creativesService;

    @Autowired
    private BootstrapData bootstrapData;

    @GET
    @Produces("application/json")
    public List<Creatives> getCreatives(@QueryParam("os") String os, @QueryParam("country") String country) {

        return creativesService.findAllByOsAndCountry(country, os, 5);
    }

    //Endpoint to bootstrap db with random generated data for load testing
    @GET
    @Path("bootstrap")
    public String bootsrapDropWithTestData() throws MalformedURLException {
        bootstrapData.createDropData(CREATIVES_SIZE);
        return "Test data created";
    }
}
