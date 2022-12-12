package com.nology.synergyapi.model;

public class CurrencyRate {
    private String code;
    private String img;
    private String countryName;
    private String name;
    private String symbol;
    private Double rate;

    public CurrencyRate(String code, String img, String countryName, String name, String symbol, Double rate) {
        this.code = code;
        this.img = img;
        this.countryName = countryName;
        this.name = name;
        this.symbol = symbol;
        this.rate = rate;
    }

    public CurrencyRate() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "CurrencyRate{" +
                "code='" + code + '\'' +
                ", img='" + img + '\'' +
                ", countryName='" + countryName + '\'' +
                ", name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                ", rate=" + rate +
                '}';
    }
}


