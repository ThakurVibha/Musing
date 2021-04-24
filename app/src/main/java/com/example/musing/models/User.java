package com.example.musing.models;
//For sending multiple data to the Firebase Realtime database we have to create an Object class and send that whole object class to Firebase.
public class User {

    String name;

    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name) {
        this.name = name;
    }
}
