package com.nology.synergyapi.model;

import java.util.Arrays;
import java.util.HashMap;

public class FXCodesNames {
    private String result;
    private String documentation;
    private String terms_of_use;
    private String[][] supported_codes;

    public FXCodesNames(String result, String documentation, String terms_of_use, String[][] supported_codes) {
        this.result = result;
        this.documentation = documentation;
        this.terms_of_use = terms_of_use;
        this.supported_codes = supported_codes;
    }

    public FXCodesNames() {
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDocumentation() {
        return documentation;
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }

    public String getTerms_of_use() {
        return terms_of_use;
    }

    public void setTerms_of_use(String terms_of_use) {
        this.terms_of_use = terms_of_use;
    }

    public String[][] getSupported_codes() {
        return supported_codes;
    }

    public void setSupported_codes(String[][] supported_codes) {
        this.supported_codes = supported_codes;
    }

    @Override
    public String toString() {
        return "FXCodesNames{" +
                "result='" + result + '\'' +
                ", documentation='" + documentation + '\'' +
                ", terms_of_use='" + terms_of_use + '\'' +
                ", supported_codes=" + Arrays.toString(supported_codes) +
                '}';
    }


}
