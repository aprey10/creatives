package com.graywolf.creatives.integration;

import com.graywolf.creatives.CreativesApplication;
import com.graywolf.creatives.persistance.Creatives;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by graywolf on 8/8/16.
 */
@RunWith(Cucumber.class)
@CucumberOptions(format="html:output",features="src/test/resources")
public class IntegrationTests {
}
