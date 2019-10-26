package Modele.Billetterie;

import java.util.ArrayList;
import java.util.Date;

import Modele.Statut;
import Modele.Theatre.Place;
import Modele.Theatre.Representation;

/**
 * Représente le dossier d'achat de place(s)
 *
 * @see Reservation
 * @see Modele.Theatre.Place
 * @see Ticket
 */

public final class Achat
{
    /**
     * Représente le numéro d'achat
     */
    private String num_achat;

    /**
     * Représente la date d'achat
     */
    private Date date;

    /**
     * Représente le statut de l'achat
     */
    private Statut statut;

    /**
     * Représente l'éventuelle réservation effectuée en préalable
     */
    private Reservation reservation;

    /**
     * Représente la liste des places achetées
     */
    private ArrayList<Place> places;

    /**
     * Représente la représentation à assister
     */
    private Representation representation;

    /**
     * Constructeur
     * @param num_achat : numéro d'achat
     * @param date : date d'achat
     * @param reservation : éventuelle réservation effectuée au préalable
     * @param places : liste des places achetées
     */
    public Achat(String num_achat, Date date, Reservation reservation, ArrayList<Place> places, Representation representation)
    {
        this.num_achat = num_achat;
        this.date = date;
        // Statut par défaut : Valide_e
        this.statut = Statut.Valide_e;
        this.reservation = reservation;
        this.places = places;
        this.representation = representation;
    }

    /**
     * Getter
     * @return num_achat : numéro d'achat
     */
    public String getNum_achat()
    {
        return num_achat;
    }

    /**
     * Getter
     * @return date : date d'achat
     */
    public Date getDate()
    {
        return date;
    }

    /**
     * Getter
     * @return statut : statut de l'achat
     */
    public Statut getStatut()
    {
        return statut;
    }

    /**
     * Setter
     * @param statut : statut de l'achat
     */
    public void setStatut(Statut statut)
    {
        this.statut = statut;
    }

    /**
     * Getter
     * @return reservation : représente l'éventuelle réservation effectuée au préalable
     */
    public Reservation getReservation()
    {
        return reservation;
    }

    /**
     * Getter
     * @return places : représente la liste des places achetées
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
