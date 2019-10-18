package model.billetterie;

import java.util.Date;

import model.Statut;

/**
 * Représente la réservation de place(s)
 *
 * @see model.theater.Place
 * @see model.utilisateur.Client
 * @see model.utilisateur.Respo_Programmation
 */

// TODO : lier la classe à Place

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
     * Constructeur
     * @param num_res : numéro de réservation
     * @param date : date de réservation
     */
    public Reservation(String num_res, Date date)
    {
        this.num_res = num_res;
        this.date = date;
        // Statut par défaut : Valide_e
        this.statut = Statut.Valide_e;
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
}
