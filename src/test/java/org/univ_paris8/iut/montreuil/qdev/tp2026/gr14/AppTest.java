package org.univ_paris8.iut.montreuil.qdev.tp2026.gr14;

import org.junit.jupiter.api.Test;
import org.univ_paris8.iut.montreuil.qdev.tp2026.gr14.Interfaces.IserviceJoueur;
import org.univ_paris8.iut.montreuil.qdev.tp2026.gr14.common.dtos.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2026.gr14.common.enums.LangueEnum;
import org.univ_paris8.iut.montreuil.qdev.tp2026.gr14.utils.exceptions.DonneeInvalideException;
import org.univ_paris8.iut.montreuil.qdev.tp2026.gr14.mocks.*;
import org.univ_paris8.iut.montreuil.qdev.tp2026.gr14.utils.exceptions.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Unit test for simple App.
 */
public class AppTest {


    String[] centreInterets = {"foot", "dodo"};
    String[] centreInteretsInvalide = {"cinéma,"};


    @Test
    public void TestNomInvalide() {
        IserviceJoueur serviceJoueur = new AjouterJoueurKoNomInvalideMock();

        assertThrows(NomInvalideException.class, () -> {
            serviceJoueur.ajouterJoueur("", "eee", "abc", LangueEnum.FR, centreInterets, 2000);
        });
    }

    @Test
    public void TestPrenomInvalide() {
        IserviceJoueur serviceJoueur = new AjouterJoueurKoPrenomInvalideMock();

        assertThrows(PrenomInvalideException.class, () -> {
            serviceJoueur.ajouterJoueur("aaa", "5g", "ooo", LangueEnum.EN, centreInterets, 2000);
        });
    }

    @Test
    public void TestPseudoInvalide() {
        IserviceJoueur serviceJoueur = new AjouterJoueurKoPseudoInvalideMock();

        assertThrows(PseudoInvalideException.class, () -> {
            serviceJoueur.ajouterJoueur("bbb", "cr7", "ooo", LangueEnum.IT, centreInterets, 2000);
        });
    }

    @Test
    public void TestLangueInvalide() {
        IserviceJoueur serviceJoueur = new AjouterJoueurKoLangueInvalideMock();

        assertThrows(LangueInvalideException.class, () -> {
            serviceJoueur.ajouterJoueur("c1a", "gg", "uu9", LangueEnum.FR, centreInterets, 2000);
        });
    }

    @Test
    public void TestJoueurExistant() {
        IserviceJoueur serviceJoueur = new AjouterJoueurKoJoueurExistantMock();

        assertThrows(JoueurExistantException.class, () -> {
            serviceJoueur.ajouterJoueur("bbb", "cr7", "ooo", LangueEnum.IT, centreInterets, 2000);
        });
    }

    @Test
    public void TestAjouterJoueurOk() throws DonneeInvalideException {
        IserviceJoueur serviceJoueur = new AjouterJoueurOkMock();

        JoueurDTO joueur = serviceJoueur.ajouterJoueur("Dupont", "Alice", "alice42", LangueEnum.FR, centreInterets, 1995);

        assertNotNull(joueur);
        assertEquals("Dupont", joueur.getNom());
        assertEquals("Alice", joueur.getPrenom());
        assertEquals("alice42", joueur.getPseudo());
        assertEquals(LangueEnum.FR, joueur.getLangue());
        assertEquals(1995, joueur.getAnneeNaissance());
    }

    @Test
    public void TestListerJoueursRetourneListeNonVide() {
        IserviceJoueur serviceJoueur = new ListerJoueursOkMock();

        ArrayList<JoueurDTO> liste = serviceJoueur.listerJoueurs();

        assertNotNull(liste);
        assertFalse(liste.isEmpty());
    }

    @Test
    public void TestCentreInteretInvalide() {
        IserviceJoueur serviceJoueur = new AjouterJoueurKoCentreInteretInvalideMock();

        assertThrows(CentreInteretInvalideException.class, () -> {
            serviceJoueur.ajouterJoueur("aaa", "gg", "ooo", LangueEnum.FR, centreInteretsInvalide, 2000);
        });
    }
}