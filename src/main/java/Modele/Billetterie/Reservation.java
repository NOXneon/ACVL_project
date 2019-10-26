package Modele.Billetterie;

import java.util.ArrayList;
import java.util.Date;

import Modele.Statut;
import Modele.Theatre.Place;
import Modele.Theatre.Representation;

/**
 * Représente la réservation de place(s)
 *
 * @see Modele.Theatre.Place
 * @see Modele.Utilisateur.Client
 * @see Modele.Utilisateur.Respo_Programmation
 */

public final class Reservation
{
    /**
     * Représente le compteur pour la création du num_res
     */
    private int cpt=1;
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
     * Représente la représentation à assister
     */
    private Representation representation;

    /**
     * Constructeur
     * @param date : date de réservation
     * @param places : liste des places réservées
     * @param representation : représentation à assister
     */
    public Reservation(Date date, ArrayList<Place> places, Representation representation)
    {
        this.num_res = "Res n°"+cpt; cpt++;
        this.date = date;
        // Statut par défaut : Valide_e
        this.statut = Statut.Valide_e;
        this.places = places;
        this.representation = representation;
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

    /**
     * Getter
     * @return representation : la représentation à assister
     */
    public Representation getRepresentation()
    {
        return representation;
    }
}
