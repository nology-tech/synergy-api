package com.nology.synergyapi.model;


import jakarta.persistence.Id;

public class Currency {
    @Id
    private String code;
    private String flag;
    private String countryName;
    private String currency;
    private String symbol;

    public Currency(String code, String flag, String countryName, String currency, String symbol) {
        this.code = code;
        this.flag = flag;
        this.countryName = countryName;
        this.currency = currency;
        this.symbol = symbol;
    }

    public String getCode() {
        return code;
    }

    public String getFlag() {
        return flag;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getCurrency() {
        return currency;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "code='" + code + '\'' +
                ", flag='" + flag + '\'' +
                ", countryName='" + countryName + '\'' +
                ", currency='" + currency + '\'' +
                ", symbol='" + symbol + '\'' +
                '}';
    }
}
