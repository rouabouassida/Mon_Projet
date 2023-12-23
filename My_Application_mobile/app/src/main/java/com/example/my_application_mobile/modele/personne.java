package com.example.my_application_mobile.modele;
public class personne {
    private int poids;
    private float taille;
    private String resultat;
    public personne(int poids, float taille) {
        this.poids=poids;
        this.taille=taille;
        calculer();
    }
    public int getPoids() {
        return poids;
    }
    public void setPoids(int poids) {
        this.poids = poids;
    }
    public float getTaille() {
        return taille;
    }
    public void setTaille(float taille) {
        this.taille = taille;
    }
    public String getResultat() {
        return resultat;
    }
    public void setResultat(String resultat) {
        this.resultat = resultat;
    }
    private void calculer() {
        float imc= poids / (taille * taille) ;
        if (imc < 18.5) {
            System.out.println("Vous êtes en insuffisance pondérale.");
        } else if (imc >= 18.5 && imc < 25) {
            System.out.println("Vous avez un poids normal.");
        } else if (imc >= 25 && imc < 30) {
            System.out.println("Vous êtes en surpoids.");
        } else {
            System.out.println("Vous êtes en situation d'obésité.");
        }
    }

}
