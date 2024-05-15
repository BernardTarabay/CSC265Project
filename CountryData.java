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
        countries.add(new Country("Moldova", "Chisinau", "mo.png"));
        countries.add(new Country("United States", "Washington, D.C.", "us.png"));
        countries.add(new Country("Canada", "Ottawa", "ca.png"));
        countries.add(new Country("Brazil", "Brasilia", "br.png"));
        countries.add(new Country("Argentina", "Buenos Aires", "ar.png"));
        countries.add(new Country("United Kingdom", "London", "un.png"));
        countries.add(new Country("France", "Paris", "fr.png"));
        countries.add(new Country("Germany", "Berlin", "ge.png"));
        countries.add(new Country("Italy", "Rome", "it.png"));
        countries.add(new Country("Spain", "Madrid", "sp.png"));
        countries.add(new Country("Russia", "Moscow", "ru.png"));
        countries.add(new Country("China", "Beijing", "ch.png"));
        countries.add(new Country("Japan", "Tokyo", "jp.png"));
        countries.add(new Country("South Korea", "Seoul", "so.png"));
        countries.add(new Country("India", "New Delhi", "in.png"));
        countries.add(new Country("Australia", "Canberra", "au.png"));
        countries.add(new Country("New Zealand", "Wellington", "ne.png"));
        countries.add(new Country("South Africa", "Pretoria", "so.png"));
        countries.add(new Country("Egypt", "Cairo", "eg.png"));
        countries.add(new Country("Nigeria", "Abuja", "ni.png"));
        countries.add(new Country("Mexico", "Mexico City", "me.png"));
        countries.add(new Country("Colombia", "Bogota", "co.png"));
        countries.add(new Country("Chile", "Santiago", "ch.png"));
        countries.add(new Country("Peru", "Lima", "pe.png"));
        countries.add(new Country("Venezuela", "Caracas", "ve.png"));
        countries.add(new Country("Saudi Arabia", "Riyadh", "sa.png"));
        countries.add(new Country("Turkey", "Ankara", "tu.png"));
        countries.add(new Country("Iran", "Tehran", "ir.png"));
        countries.add(new Country("Pakistan", "Islamabad", "pa.png"));
        countries.add(new Country("Indonesia", "Jakarta", "in.png"));
        countries.add(new Country("Thailand", "Bangkok", "th.png"));
        countries.add(new Country("Vietnam", "Hanoi", "vi.png"));
        countries.add(new Country("Malaysia", "Kuala Lumpur", "ma.png"));
        countries.add(new Country("Singapore", "Singapore", "si.png"));
        countries.add(new Country("Bangladesh", "Dhaka", "ba.png"));
        countries.add(new Country("Ukraine", "Kyiv", "ua.png"));
        countries.add(new Country("Poland", "Warsaw", "po.png"));
        countries.add(new Country("Belgium", "Brussels", "be.png"));
        countries.add(new Country("Sweden", "Stockholm", "sw.png"));
        countries.add(new Country("Norway", "Oslo", "no.png"));
        countries.add(new Country("Denmark", "Copenhagen", "de.png"));
        countries.add(new Country("Finland", "Helsinki", "fi.png"));
        countries.add(new Country("Switzerland", "Bern", "ch.png"));
        countries.add(new Country("Austria", "Vienna", "au.png"));
        countries.add(new Country("Greece", "Athens", "gr.png"));
        countries.add(new Country("Portugal", "Lisbon", "po.png"));
    }

    public Country getRandomCountry() {
        if (countries.isEmpty()) {
            System.out.println("No countries loaded.");
            return null;
        }
        return countries.get(random.nextInt(countries.size()));
    }
}
