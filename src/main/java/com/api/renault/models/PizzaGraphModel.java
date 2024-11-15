package com.api.renault.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcType;

import java.util.List;

@Entity
public class PizzaGraphModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id_graph")
    private Integer idGraph;

    @JsonProperty("title_graph")
    private String titleGraph;

    @JsonProperty("values")
    private List<GraphPizzaValueModel> values;

    public Integer getIdGraph() {
        return idGraph;
    }

    public void setIdGraph(Integer idGraph) {
        this.idGraph = idGraph;
    }

    public String getTitleGraph() {
        return titleGraph;
    }

    public void setTitleGraph(String titleGraph) {
        this.titleGraph = titleGraph;
    }

    public List<GraphPizzaValueModel> getValues() {
        return values;
    }

    public void setValues(List<GraphPizzaValueModel> values) {
        this.values = values;
    }
}