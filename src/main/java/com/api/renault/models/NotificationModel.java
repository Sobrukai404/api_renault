package com.api.renault.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
public class NotificationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id_notification")
    private Integer idNotification;
    @JsonProperty("title_notification")
    private String titleNotification;
    @JsonProperty("description_notification")
    private String descriptionNotification;
    @JsonProperty("id_risk")
    @ManyToOne
    private RiskModel riskModel;


    // Getters e Setters
    public Integer getIdNotification() {
        return idNotification;
    }

    public void setIdNotification(Integer idNotification) {
        this.idNotification = idNotification;
    }

    public String getTitleNotification() {
        return titleNotification;
    }

    public void setTitleNotification(String titleNotification) {
        this.titleNotification = titleNotification;
    }

    public String getDescriptionNotification() {
        return descriptionNotification;
    }

    public void setDescriptionNotification(String descriptionNotification) {
        this.descriptionNotification = descriptionNotification;
    }

    public RiskModel getRiskModel() {
        return riskModel;
    }

    public void setRiskModel(RiskModel riskModel) {
        this.riskModel = riskModel;
    }
}