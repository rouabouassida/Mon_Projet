package com.example.my_application_mobile.modele;

public class utilisateur {
    private String userNom;
    private String password;
    public utilisateur (String userNom,String password){
        this.userNom=userNom;
        this.password=password;
    }

    public String getUserNom() {
        return userNom;
    }

    public String getPassword() {
        return password;
    }
}
