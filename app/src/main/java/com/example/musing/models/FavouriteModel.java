package com.example.musing.models;

public class FavouriteModel {

String sessionName;
String sessionIcon;

    public FavouriteModel(String sessionName, String sessionIcon) {
        this.sessionName = sessionName;
        this.sessionIcon = sessionIcon;
    }

    public FavouriteModel() {
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public String getSessionIcon() {
        return sessionIcon;
    }

    public void setSessionIcon(String sessionIcon) {
        this.sessionIcon = sessionIcon;
    }
}
