package Modele.Billetterie;

import java.util.Date;

import Modele.Statut;

/**
 * Représente le dossier d'achat de place(s)
 *
 * @see Reservation
 * @see Modele.Theatre.Place
 * @see Ticket
 */

// TODO : lier la classe à Reservation
// TODO : lier la classe à Place

public class Achat
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
     * Constructeur
     * @param num_achat : numéro d'achat
     * @param date : date d'achat
     */
    public Achat(String num_achat, Date date)
    {
        this.num_achat = num_achat;
        this.date = date;
        // Statut par défaut : Valide_e
        this.statut = Statut.Valide_e;
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
}
