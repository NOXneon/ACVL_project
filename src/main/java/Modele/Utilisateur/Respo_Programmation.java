package Modele.Utilisateur;

import Modele.ExceptionChevauchement;
import Modele.Theatre.Representation;
import Modele.Theatre.Salle;
import Modele.Theatre.Spectacle;
import Modele.Theatre.Theatre;

import java.util.ArrayList;

/**
 * Représente le responsable de l'application du théâtre
 */

public final class Respo_Programmation extends Responsable
{
    /**
     * Constructeur
     *
     * @param nom    : nom de l'Utilisateur
     * @param prenom : prénom de l'Utilisateur
     * @param login  : login de l'Utilisateur
     * @param mdp    : mot de passe de l'Utilisateur
     * @param mail   : adresse mail de l'Utilisateur
     * @param tel    : numéro de téléphone de l'Utilisateur
     */
    public Respo_Programmation(String nom, String prenom, String login, String mdp, String mail, String tel)
    {
        super(nom, prenom, login, mdp, mail, tel);
    }

    /**
     * Programme un spectacle dans la salle
     * @param nom : nom du spectacle
     * @param representations : représentations du spectacle
     */
    public void programmerSpectacle(String nom, ArrayList<Representation> representations) throws ExceptionChevauchement
    {
        Spectacle spectacle = new Spectacle(nom, representations);
        Theatre.getTHEATRE().ajouterSpectacle(spectacle);
    }

    /**
     * Déprogramme un spectacle de la salle
     * @param spectacle : spectacle à déprogrammer
     */
    public void deprogrammerSpectacle(Spectacle spectacle)
    {
        Theatre.getTHEATRE().supprimerSpectacle(spectacle);
    }
}
