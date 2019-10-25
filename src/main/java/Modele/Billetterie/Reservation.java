package Modele.Billetterie;

import java.util.ArrayList;
import java.util.Date;

import Modele.Statut;
import Modele.Theatre.Place;

/**
 * Représente la réservation de place(s)
 *
 * @see Modele.Theatre.Place
 * @see Modele.Utilisateur.Client
 * @see Modele.Utilisateur.Respo_Programmation
 */

public class Reservation
{
    /**
     * Représente le numéro de réservation
     */
    private String num_res;

    /**
     * Représente la date de réservation
     */
    private Date date;

    /**
     * Statut de la réservation
     */
    private Statut statut;

    /**
     * Représente la liste des places réservées
     */
    private ArrayList<Place> places;

    /**
     * Constructeur
     * @param num_res : numéro de réservation
     * @param date : date de réservation
     * @param places : liste des places réservées
     */
    public Reservation(String num_res, Date date, ArrayList<Place> places)
    {
        this.num_res = num_res;
        this.date = date;
        // Statut par défaut : Valide_e
        this.statut = Statut.Valide_e;
        this.places = places;
    }

    /**
     * Getter
     * @return num_res : numéro de réservation
     */
    public String getNum_res()
    {
        return num_res;
    }

    /**
     * Getter
     * @return date : date de réservation
     */
    public Date getDate()
    {
        return date;
    }

    /**
     * Getter
     * @return statut : statut de la réservation
     */
    public Statut getStatut()
    {
        return statut;
    }

    /**
     * Setter
     * @param statut : statut de la réservation
     */
    public void setStatut(Statut statut)
    {
        this.statut = statut;
    }

    /**
     * Getter
     * @return places : liste des places réservées
     */
    public ArrayList<Place> getPlaces()
    {
        return places;
    }
}
