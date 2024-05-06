package com.example.demo1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CountryData {
    private List<Country> countries;
    private Random random;

    public CountryData() {
        countries = new ArrayList<>();
        random = new Random();
        loadCountries();
    }

    private void loadCountries() {
           countries.add(new Country("United Arab Emirates", "Abu Dhabi", "flags/ae.png"));

    }

    public Country getRandomCountry() {
        return countries.get(random.nextInt(countries.size()));
    }
}

