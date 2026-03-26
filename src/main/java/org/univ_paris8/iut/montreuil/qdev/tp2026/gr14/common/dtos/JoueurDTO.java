package org.univ_paris8.iut.montreuil.qdev.tp2026.gr14.common.dtos;

import org.univ_paris8.iut.montreuil.qdev.tp2026.gr14.common.enums.LangueEnum;

public class JoueurDTO {

    //Obligatoire
    private String nom;
    private String prenom;
    private String pseudo;

    //Facultatif
    private int anneeNaissance;
    private String[] centreInterets;

    //Langue
    private LangueEnum langue;


    public JoueurDTO(String nom, String prenom, String pseudo, int anneeNaissance, String[] centreInteret, LangueEnum langue) {
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.anneeNaissance = anneeNaissance;
        this.centreInterets = centreInteret;
        this.langue = langue;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getPseudo() {
        return pseudo;
    }

    public int getAnneeNaissance() {
        return anneeNaissance;
    }

    public String[] getCentreInterets() {
        return centreInterets;
    }

    public LangueEnum getLangue() {
        return langue;
    }

}