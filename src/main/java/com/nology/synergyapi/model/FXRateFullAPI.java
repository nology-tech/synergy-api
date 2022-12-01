package com.nology.synergyapi.model;

import java.util.HashMap;

public class FXRateFullAPI {
    private String result;
    private String documentation;
    private String terms_of_use;
    private String time_last_update_unix;
    private String time_last_update_utc;
    private String time_next_update_unix;
    private String time_next_update_utc;
    private String base_code;
    private HashMap conversion_rates;

    public FXRateFullAPI(String result, String documentation, String terms_of_use, String time_last_update_unix, String time_last_update_utc, String time_next_update_unix, String time_next_update_utc, String base_code, HashMap conversion_rates) {
        this.result = result;
        this.documentation = documentation;
        this.terms_of_use = terms_of_use;
        this.time_last_update_unix = time_last_update_unix;
        this.time_last_update_utc = time_last_update_utc;
        this.time_next_update_unix = time_next_update_unix;
        this.time_next_update_utc = time_next_update_utc;
        this.base_code = base_code;
        this.conversion_rates = conversion_rates;
    }

    public String getTime_next_update_utc() {
        return time_next_update_utc;
    }

    public void setTime_next_update_utc(String time_next_update_utc) {
        this.time_next_update_utc = time_next_update_utc;
    }

    public String getDocumentation() {
        return documentation;
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }

    public FXRateFullAPI() {
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getTerms_of_use() {
        return terms_of_use;
    }

    public void setTerms_of_use(String terms_of_use) {
        this.terms_of_use = terms_of_use;
    }

    public String getTime_last_update_unix() {
        return time_last_update_unix;
    }

    public void setTime_last_update_unix(String time_last_update_unix) {
        this.time_last_update_unix = time_last_update_unix;
    }

    public String getTime_last_update_utc() {
        return time_last_update_utc;
    }

    public void setTime_last_update_utc(String time_last_update_utc) {
        this.time_last_update_utc = time_last_update_utc;
    }

    public String getTime_next_update_unix() {
        return time_next_update_unix;
    }

    public void setTime_next_update_unix(String time_next_update_unix) {
        this.time_next_update_unix = time_next_update_unix;
    }

    public String getBase_code() {
        return base_code;
    }

    public void setBase_code(String base_code) {
        this.base_code = base_code;
    }

    public HashMap getConversion_rates() {
        return conversion_rates;
    }

    public void setConversion_rates(HashMap conversion_rates) {
        this.conversion_rates = conversion_rates;
    }
}
