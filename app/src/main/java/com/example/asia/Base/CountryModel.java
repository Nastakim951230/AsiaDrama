package com.example.asia.Base;

public class CountryModel {

    private String NameCountry;

    public CountryModel(String NameCountry)
    {
        this.NameCountry = NameCountry;
    }
    public void setCountries(String NameCountry)
    {
        this.NameCountry = NameCountry;
    }
    public String getCountries()
    {
        return  NameCountry;
    }
}
