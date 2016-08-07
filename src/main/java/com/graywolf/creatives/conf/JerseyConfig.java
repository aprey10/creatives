package com.graywolf.creatives.conf;

import com.graywolf.creatives.controllers.CreativesController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 * Created by graywolf on 8/7/16.
 */
@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(CreativesController.class);
    }
}
