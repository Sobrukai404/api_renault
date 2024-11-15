package com.api.renault.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
public class GraphPizzaValueModel {
    @EmbeddedId
    @JsonProperty("title_value")
    private String titleValue;

    @JsonProperty("value")
    private double value;



//Get & Set


    public String getTitleValue() {
        return titleValue;
    }

    public void setTitleValue(String titleValue) {
        this.titleValue = titleValue;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
