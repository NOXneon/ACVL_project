package model.theater;

/**
 * Repésente une catégorie de zone
 *
 * @see Zone
 * @see Salle
 */

public class Orchestre extends Categorie
{

    /**
     * Concstructeur
     *
     * @param tarif : tarif de la place dans la catégorie de zone
     */
    public Orchestre(float tarif)
    {
        super(tarif);
    }
}
