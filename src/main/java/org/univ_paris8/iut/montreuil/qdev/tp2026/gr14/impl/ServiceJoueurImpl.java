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
            throw new NomInvalideException("Le nom ne peut pas être vide");

        if (prenom == null || prenom.isBlank())
            throw new PrenomInvalideException("Le prénom ne peut pas être vide");

        if (pseudo == null || pseudo.isBlank())
            throw new PseudoInvalideException("Le pseudo ne peut pas être vide");

        if (langue == null)
            throw new LangueInvalideException("La langue ne peut pas être nulle");

        //Si le pseudo commence par un chiffre
        if (Character.isDigit(pseudo.charAt(0)))
            throw new PseudoInvalideException("Le pseudo ne doit pas commencer par un chiffre");

        for (JoueurDTO j : joueurs) {
            if (j.getPseudo().equals(pseudo))
                throw new JoueurExistantException("Le pseudo '" + pseudo + "' est déjà utilisé");
        }


        // Si la saisie finit par "," le split produira un dernier élément vide
        if (centreInterets != null && centreInterets.length > 0) {
            String dernier = centreInterets[centreInterets.length - 1];
            if (dernier == null || dernier.isBlank())
                throw new DonneeInvalideException("Les centres d'intérêt ne doivent pas finir par une virgule");
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