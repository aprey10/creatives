package com.graywolf.creatives;

import com.graywolf.creatives.persistance.Country;
import com.graywolf.creatives.persistance.Creatives;
import com.graywolf.creatives.persistance.CreativesRepository;
import com.graywolf.creatives.persistance.OperationSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by graywolf on 8/7/16.
 */
@Component
public class BootstrapData {

    @Autowired
    private CreativesRepository creativesRepository;

    private static final String DESCRIPTION = "description";

    public void createDropData(int size) throws MalformedURLException {
        creativesRepository.deleteAll();
        generateCreatives(size);
    }

    private void generateCreatives(int size) throws MalformedURLException {
        for (int i = 0; i < size; i++) {
            Creatives creatives = buildCreatives(
                    generateRandomUrl(),
                    DESCRIPTION,
                    buildRandomSet(getRandomInt(1, 5), 1, OperationSystem.values().length),
                    buildRandomSet(getRandomInt(1, 7), 1, Country.values().length),
                    buildRandomSet(getRandomInt(1, 7), 1, Country.values().length)

            );
            creativesRepository.save(creatives);
        }
    }

    private String generateRandomUrl() throws MalformedURLException {
        return new URL("http", "google.com", "test" + getRandomInt(1, 100)).toString();
    }

    private Set<Integer> buildRandomSet(int size, int min, int max) {
        Set<Integer> randomSet = new HashSet<>();
        for (int i = 0; i < size; i++) {
            randomSet.add(getRandomInt(min, max));
        }

        return randomSet;
    }

    private int getRandomInt(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    private Creatives buildCreatives(String url, String description, Set<Integer> osList, Set<Integer> countriesList,
                                     Set<Integer> exludedCountriesList) {
        return new Creatives(url, description, osList, countriesList, exludedCountriesList);
    }
}
