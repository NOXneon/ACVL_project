package model.theater;

import model.Etat;

/**
 * Représente une place dans la salle
 *
 * @see Salle
 */

public class Place
{ /**
     * Représente le numéro de la place
     */
    private String num_place;

    /**
     * Représente le numéro du rang
     */
    private String num_rang;

    /**
     * Représente l'état de la place
     */
    private Etat etat;

    /**
     * tarif de la place dans la catégorie de zone
     * @param num_place : numéro de la place
     * @param num_rang : numéro du rang
     */
    public Place(String num_place, String num_rang)
    {
        this.num_place = num_place;
        this.num_rang = num_rang;
        // Etat par défaut : Libre
        this.etat = Etat.Libre;
    }

    /**
     * Getter
     * @return num_place : numéro de la place
     */
    public String getNum_place()
    {
        return num_place;
    }

    /**
     * Getter
     * @return num_rang : numéro du rang
     */
    public String getNum_rang()
    {
        return num_rang;
    }

    /**
     * Getter
     * @return etat : etat de la place
     */
    public Etat getEtat()
    {
        return etat;
    }
}
