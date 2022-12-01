package com.nology.synergyapi.model;


import jakarta.persistence.Id;

public class Currency {
    @Id
    private String code;
    private String flag;
    private String countryName;
    private String currency;
    private String symbol;

    public Currency() {
        super();
    }

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

    public void setCode(String code) {
        this.code = code;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
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
