package org.univ_paris8.iut.montreuil.qdev.tp2026.gr14.Interfaces;

import org.univ_paris8.iut.montreuil.qdev.tp2026.gr14.common.dtos.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2026.gr14.common.enums.LangueEnum;
import org.univ_paris8.iut.montreuil.qdev.tp2026.gr14.utils.exceptions.DonneeInvalideException;



import java.util.ArrayList;

public interface IserviceJoueur {
    public JoueurDTO ajouterJoueur(String nom, String prenom, String pseudo, LangueEnum langue, String[] centreInterets, int anneeNaissance) throws DonneeInvalideException;

    public ArrayList<JoueurDTO> listerJoueurs();
}