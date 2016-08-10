package com.graywolf.creatives.integration;

import com.graywolf.creatives.CreativesApplication;
import com.graywolf.creatives.persistance.Country;
import com.graywolf.creatives.persistance.Creatives;
import com.graywolf.creatives.persistance.CreativesRepository;
import com.graywolf.creatives.persistance.OperationSystem;
import com.graywolf.creatives.services.CreativesService;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

//For tests should be used different Context Configuration and different database,
//but as it's not so impotent now I didn't create separate configuration class.
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CreativesApplication.class, loader = SpringBootContextLoader.class)
public class SearchCreativesSteps {

    @Autowired
    private CreativesRepository creativesRepository;

    @Autowired
    private CreativesService creativesService;

    private Creatives creatives;

    private List<Creatives> searchResult;

    @Before
    public void cleanDB() {
        creativesRepository.deleteAll();
    }

    @Given("^have creative with url \"([^\"]*)\" and description \"([^\"]*)\"$")
    public void given_with_params(String url, String description) throws Throwable {
        creatives = new Creatives(url, description);
    }

    @And("^creative has set of os:$")
    public void creatives_has_set_of_os(List<String> osNameList) throws Throwable {
        for (String osName : osNameList) {
            creatives.addToOsSet(OperationSystem.findByName(osName).getId());
        }
    }

    @And("^creative has set of countries:$")
    public void creatives_has_set_of_countries(List<String> countriesList) throws Throwable {
        for (String countryCode : countriesList) {
            creatives.addToCountriesSet(Country.findByCode(countryCode).getId());
        }
    }

    @And("^creative has set of excluded countries:$")
    public void creatives_has_set_of_excluded_countries(List<String> countriesList) throws Throwable {
        for (String countryCode : countriesList) {
            creatives.addToExcludedCountries(Country.findByCode(countryCode).getId());
        }
    }

    @And("^creative stored in database$")
    public void creative_stored_to_db() throws Throwable {
        creativesRepository.save(creatives);
    }

    @When("^Search for creative with os \"([^\"]*)\" and country \"([^\"]*)\" and limit (\\d+)$")
    public void search_for_creative(String os, String country, Integer limit) {
        searchResult = creativesService.findAllByOsAndCountry(country, os, limit);
    }

    @Then("(\\d+) creatives should be found")
    public void size_of_creatives_should_be_found(Integer size) {
        assertTrue(searchResult.size() == size);
    }

    @Then("Creative with url \"([^\"]*)\" should be found")
    public void creative_should_be_found(String url) {
        assertNotNull(
                searchResult.stream()
                        .filter(creative -> creative.getUrl().equals(url)).findFirst().orElse(null)
        );
    }
}
