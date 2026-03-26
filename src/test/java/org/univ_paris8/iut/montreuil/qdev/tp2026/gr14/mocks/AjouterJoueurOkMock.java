// AjouterJoueurOkMock.java
package org.univ_paris8.iut.montreuil.qdev.tp2026.gr14.mocks;

import org.univ_paris8.iut.montreuil.qdev.tp2026.gr14.Interfaces.IserviceJoueur;
import org.univ_paris8.iut.montreuil.qdev.tp2026.gr14.common.dtos.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2026.gr14.common.enums.LangueEnum;
import org.univ_paris8.iut.montreuil.qdev.tp2026.gr14.utils.exceptions.DonneeInvalideException;
import java.util.ArrayList;

public class AjouterJoueurOkMock implements IserviceJoueur {

    @Override
    public JoueurDTO ajouterJoueur(String nom, String prenom, String pseudo, LangueEnum langue, String[] centreInterets, int anneeNaissance) throws DonneeInvalideException {
        return new JoueurDTO(nom, prenom, pseudo, anneeNaissance, centreInterets, langue);
    }

    @Override
    public ArrayList<JoueurDTO> listerJoueurs() {
        ArrayList<JoueurDTO> liste = new ArrayList<>();
        liste.add(new JoueurDTO("Dupont", "Alice", "alice42", 1995, new String[]{"sport", "musique"}, LangueEnum.FR));
        liste.add(new JoueurDTO("Martin", "Bob", "bob99", 1990, new String[]{"cinema"}, LangueEnum.EN));
        return liste;
    }
}