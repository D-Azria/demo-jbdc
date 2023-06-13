package fr.diginamic.jbdc.entites;

import java.util.ArrayList;

public class Fournisseur {

    int ID;
    String nom;

    public Fournisseur(int ID, String nom) {
        this.ID = ID;
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Fournisseur{" +
                "ID=" + ID +
                ", nom='" + nom + '\'' +
                '}';
    }
}
