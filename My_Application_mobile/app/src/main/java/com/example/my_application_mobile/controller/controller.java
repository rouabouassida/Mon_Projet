package com.example.my_application_mobile.controller;

import com.example.my_application_mobile.modele.personne;
public class controller {
    private com.example.my_application_mobile.modele.personne personne;
    private static controller instance = null;
    public static controller getInstance() {
        if (controller.instance == null) {
            controller.instance = new controller();
        }
        return controller.instance;
    }
    private controller() {
        super();
    }
    public void create_personne(int poids, float taille) {
        personne = new personne(poids, taille);
    }
    public String getResultat(){
        return personne.getResultat();}
}
