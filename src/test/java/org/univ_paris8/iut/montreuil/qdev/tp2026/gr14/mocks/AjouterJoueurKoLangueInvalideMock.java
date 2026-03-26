// AjouterJoueurKoLangueInvalideMock.java
package org.univ_paris8.iut.montreuil.qdev.tp2026.gr14.mocks;

import org.univ_paris8.iut.montreuil.qdev.tp2026.gr14.Interfaces.IserviceJoueur;
import org.univ_paris8.iut.montreuil.qdev.tp2026.gr14.common.dtos.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2026.gr14.common.enums.LangueEnum;
import org.univ_paris8.iut.montreuil.qdev.tp2026.gr14.utils.exceptions.DonneeInvalideException;
import org.univ_paris8.iut.montreuil.qdev.tp2026.gr14.utils.exceptions.LangueInvalideException;
import java.util.ArrayList;

public class AjouterJoueurKoLangueInvalideMock implements IserviceJoueur {

    @Override
    public JoueurDTO ajouterJoueur(String nom, String prenom, String pseudo, LangueEnum langue, String[] centreInterets, int anneeNaissance) throws DonneeInvalideException {
        throw new LangueInvalideException();
    }

    @Override
    public ArrayList<JoueurDTO> listerJoueurs() {
        return null;
    }
}