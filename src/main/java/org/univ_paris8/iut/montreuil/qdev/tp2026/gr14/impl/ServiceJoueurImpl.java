package org.univ_paris8.iut.montreuil.qdev.tp2026.gr14.impl;

import org.univ_paris8.iut.montreuil.qdev.tp2026.gr14.Interfaces.IserviceJoueur;
import org.univ_paris8.iut.montreuil.qdev.tp2026.gr14.common.dtos.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2026.gr14.common.enums.LangueEnum;
import org.univ_paris8.iut.montreuil.qdev.tp2026.gr14.utils.exceptions.*;

import java.util.ArrayList;

public class ServiceJoueurImpl implements IserviceJoueur {

    private ArrayList<JoueurDTO> joueurs = new ArrayList<>();

    @Override
    public JoueurDTO ajouterJoueur(String nom, String prenom, String pseudo,
                                   LangueEnum langue, String[] centreInterets,
                                   int anneeNaissance) throws DonneeInvalideException {

        if (nom == null || nom.isBlank())
            throw new NomInvalideException();

        if (prenom == null || prenom.isBlank())
            throw new PrenomInvalideException();

        if (pseudo == null || pseudo.isBlank())
            throw new PseudoInvalideException();

        if (langue == null)
            throw new LangueInvalideException();

        //Si le pseudo commence par un chiffre
        if (Character.isDigit(pseudo.charAt(0)))
            throw new PseudoInvalideException();

        for (JoueurDTO j : joueurs) {
            if (j.getPseudo().equals(pseudo))
                throw new JoueurExistantException();
        }


        // Si la saisie finit par "," le split produira un dernier élément vide
        if (centreInterets != null && centreInterets.length > 0) {
            String dernier = centreInterets[centreInterets.length - 1];
            if (dernier == null || dernier.isBlank())
                throw new DonneeInvalideException();
        }

        // Création et ajout
        JoueurDTO joueur = new JoueurDTO(nom, prenom, pseudo, anneeNaissance, centreInterets, langue);
        joueurs.add(joueur);
        return joueur;
    }

    @Override
    public ArrayList<JoueurDTO> listerJoueurs() {
        return joueurs;
    }


}