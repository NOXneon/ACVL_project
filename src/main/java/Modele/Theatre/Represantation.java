package Modele.Theatre;

import java.util.Date;

import Modele.Statut;

/**
 * Représente une séance d'un spectacle se déroulant dans le théâtre
 *
 * @see Spectacle
 * @see Salle
 */

// TODO : relier la classe à Salle

public class Represantation
{
    /**
     * Représente la date et heure de la représentation
     */
    private Date date;

    /**
     * Représente la durée de la représentation
     */
    private String duree;

    /**
     * Représente le statut de la représentation
     */
    private Statut statut;

    /**
     * Constructeur
     * @param date : date et heure de la représentation
     * @param duree : durée de la représentation
     */
    public Represantation(Date date, String duree)
    {
        this.date = date;
        this.duree = duree;
        // Statut par défaut : Valide_e
        this.statut = Statut.Valide_e;
    }

    /**
     * >> Getter
     * @return date : date et heure de la représentation
     */
    public Date getDate()
    {
        return date;
    }

    /**
     * Getter
     * @return duree : durée de la représentation
     */
    public String getDuree()
    {
        return duree;
    }

    /**
     * Getter
     * @return statut : statut de la représentation
     */
    public Statut getStatut()
    {
        return statut;
    }

    /**
     * Setter
     * @param statut : statut de la représentation
     */
    public void setStatut(Statut statut)
    {
        this.statut = statut;
    }
}
