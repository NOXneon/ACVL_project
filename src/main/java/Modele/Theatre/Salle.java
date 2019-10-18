package Modele.Theatre;

/**
 * Représente la salle du théâtre
 */

// TODO : lier la classe à Zone

public class Salle
{
	/**
     * Représente le nombre de places dans la salle
     */
    private int nb_places;

    /**
     * Constructeur
     * @param nb_places : nombre de places dans la salle
     */
    public Salle(int nb_places)
    {
        this.nb_places = nb_places;
    }

    /**
     * Getter
     * @return nb_places : nombre de places dans la salle
     */
    public int getNb_places()
    {
        return nb_places;
    }
}
