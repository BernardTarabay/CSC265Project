package com.example.demo1;

public class Country {
    private String myWord;
    private String capital;
    private String flagImagePath;

    public Country(String myWord, String capital, String flagImagePath) {
        this.myWord = myWord;
        this.capital = capital;
        this.flagImagePath = flagImagePath;
    }

    public String getMyWord() {
        return myWord;
    }

    public String getCapital() {
        return capital;
    }

    public String getFlagImagePath() {
        return flagImagePath;
    }
}
