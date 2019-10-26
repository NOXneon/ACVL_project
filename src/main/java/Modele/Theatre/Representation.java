package Modele.Theatre;

import java.util.Date;

import Modele.Statut;

/**
 * Représente une séance d'un spectacle se déroulant dans le théâtre
 *
 * @see Spectacle
 * @see Salle
 */

public final class Representation
{
    /**
     * Représente la date et heure de la représentation
     */
    private Date date;

    /**
     * Représente la durée (en minutes) de la représentation
     */
    private long duree;

    /**
     * Représente le statut de la représentation
     */
    private Statut statut;

    /**
     * Constructeur
     * @param date : date et heure de la représentation
     * @param duree : durée de la représentation
     */
    public Representation(Date date, long duree)
    {
        this.date = date;
        this.duree = duree;
        // Statut par défaut : Valide_e
        this.statut = Statut.Valide_e;
    }

    /**
     * Getter
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
    public long getDuree()
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

    /**
     * Retourne un string contenant les valeurs des attributs de la représentation
     * @return affiche : affiche de la représentation
     */
    public String getAffiche()
    {
        String affiche = "";

        affiche += "Date : " + this.getDate() + "\n"
                + "Duree : " +this.getDuree() + "\n"
                + "Statut : " + this.getStatut() + "\n";
        return affiche;
    }

    /**
     * Vérifie si deux représentations sont les mêmes
     * @param obj : deuxième représentation
     * @return vrai si les différents attributs sont égaux
     */
    @Override
    public boolean equals(Object obj)
    {
        Representation representation = (Representation) obj;

        return this.getDate() == representation.getDate()
                && this.getDuree() == representation.getDuree()
                && this.getStatut() == representation.getStatut();
    }
}
