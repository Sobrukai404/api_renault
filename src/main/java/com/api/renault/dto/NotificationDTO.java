package com.api.renault.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NotificationDTO {

    @JsonProperty("id_notification")
    private Integer idNotification;

    @JsonProperty("title_notification")
    private String titleNotification;

    @JsonProperty("description_notification")
    private String descriptionNotification;

    @JsonProperty("id_risk")
    private Integer idRisk;

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

    public Integer getIdRisk() {
        return idRisk;
    }

    public void setIdRisk(Integer idRisk) {
        this.idRisk = idRisk;
    }
}
