package com.nology.synergyapi.model;

import jakarta.persistence.Id;

public class FXRate {

    @Id
    private String code;
  private Float fxrate;

    public FXRate(String code, Float fxrate) {
        this.code = code;
        this.fxrate = fxrate;
    }

    public FXRate() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Float getFxrate() {
        return fxrate;
    }

    public void setFxrate(Float fxrate) {
        this.fxrate = fxrate;
    }

    @Override
    public String toString() {
        return "FXRate{" +
                "code='" + code + '\'' +
                ", fxrate=" + fxrate +
                '}';
    }
}
