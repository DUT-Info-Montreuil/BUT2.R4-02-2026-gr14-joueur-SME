package org.univ_paris8.iut.montreuil.qdev.tp2026.gr14.common.dtos;

import org.univ_paris8.iut.montreuil.qdev.tp2026.gr14.common.enums.LangueEnum;

public class JoueurDTO {

    //Obligatoire
    private String nom;
    private String prenom;
    private String pseudo;

    //Facultatif
    private String anneeNaissance;
    private String centreInteret;

    //Langue
    private LangueEnum langue;


}
