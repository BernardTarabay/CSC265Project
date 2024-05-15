package com.example.demo1;

public class Country {
    private String name;
    private String capital;
    private String flagImagePath;

    public Country(String name, String capital, String flagImagePath) {
        this.name = name;
        this.capital = capital;
        this.flagImagePath = flagImagePath;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public String getFlagImagePath() {
        return flagImagePath;
    }
}
