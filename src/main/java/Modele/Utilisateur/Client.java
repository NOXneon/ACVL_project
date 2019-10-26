package Modele.Utilisateur;

import Modele.Billetterie.Achat;
import Modele.Billetterie.Reservation;

import java.util.ArrayList;

/**
 * Représente le client chez le théâtre
 */

public final class Client extends Utilisateur
{
    /**
     * Représente la liste de réservations effectuées
     */
    private ArrayList<Reservation> reservations;

    /**
     * Représente la liste d'achats effectués
     */
    private ArrayList<Achat> achats;

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
    public Client(String nom, String prenom, String login, String mdp, String mail, String tel)
    {
        super(nom, prenom, login, mdp, mail, tel);
        this.reservations = new ArrayList<Reservation>();
        this.achats = new ArrayList<Achat>();
    }

    /**
     * Getter
     * @return reservations : liste des réservations effectuées
     */
    public ArrayList<Reservation> getReservations()
    {
        return reservations;
    }

    /**
     * Getter
     * @return achats : représente la liste des achats effectués
     */
    public ArrayList<Achat> getAchats()
    {
        return achats;
    }
}
