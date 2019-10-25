package Modele.Theatre;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Représente la salle du théâtre (donc en Singleton)
 */

public final class Salle
{
    /**
     * Instance unique non initialisée
     */
    private static Salle SALLE = null;

	/**
     * Représente le nombre de places dans la salle
     */
    private static int nb_places = 300;

    /**
     * Représente une des 3 zones de la salle
     */
    private Balcon zone_Balcon;

    /**
     * Représente une des 3 zones de la salle
     */
    private Poulailler zone_Poulailler;

    /**
     * Représente une des 3 zones de la salle
     */
    private Orchestre zone_Orchestre;

    /**
     * Représente la liste des spectacles programmés dans la salle
     */
    private ArrayList<Spectacle> spectacles;

    /**
     * Constructeur
     * @param nb_places : nombre de places dans la salle
     * @param spectacles : liste des spectacles programmés dans la salle
     */
    private Salle(int nb_places, ArrayList<Spectacle> spectacles)
    {
        this.nb_places = nb_places;
        this.zone_Balcon = Balcon.getBALCON();
        this.zone_Poulailler = Poulailler.getPOULAILLER();
        this.zone_Orchestre = Orchestre.getORCHESTRE();
        this.spectacles = spectacles;
    }

    /**
     * Point d'accès à l'instance unique de Salle
     * @param spectacles : liste des spectacles programmés dans la salle
     * @return SALLE : Salle unique
     */
    public static synchronized Salle getSALLE(ArrayList<Spectacle> spectacles)
    {
        if(SALLE == null)
            SALLE = new Salle(nb_places, spectacles);

        return SALLE;
    }

    /**
     * Getter
     * @return nb_places : nombre de places dans la salle
     */
    public int getNb_places()
    {
        return nb_places;
    }


    /**
     * Getter
     * @return zone_Balcon : représente la zone Balcon
     */
    public Balcon getZone_Balcon()
    {
        return zone_Balcon;
    }

    /**
     * Getter
     * @return zone_Poulailler : représente la zone Poulailler
     */
    public Poulailler getZone_Poulailler()
    {
        return zone_Poulailler;
    }

    /**
     * Getter
     * @return zone_Orchestre : représente la zone Orchestre
     */
    public Orchestre getZone_Orchestre()
    {
        return zone_Orchestre;
    }

    /**
     * Getter
     * @return spectacles : représente la liste des spectacles programmés dans la salle
     */
    public ArrayList<Spectacle> getSpectacles()
    {
        return spectacles;
    }

    /**
     * Vérifie que les représentations du spectacle choisie ne chevauchent pas celles des autres spectacles existants
     * @param spectacle : spectacle choisi
     * @return prog_possible : booléen représentant si la programmation du spectacle est possible
     *         (donc toutes ses représentations ne chevauchent aucune autre représentation)
     */
    public boolean progPossible(Spectacle spectacle)
    {
        boolean prog_possible = true;

        for(Representation tmp_representation : spectacle.getRepresentations())
        {
            for(Spectacle tmp_spectacle : spectacles)
            {
                for(Representation tmp_representation1 : tmp_spectacle.getRepresentations())
                {
                    // Calcul de la Date fin du premier spectacle
                    Date endTime_tmp_spectacle = new Date(tmp_representation.getDate().getTime()+tmp_representation.getDuree());
                    if(
                            // Comparaison du chevauchement au niveau de la date
                            tmp_representation.getDate().compareTo(tmp_representation1.getDate()) == 0
                            ||
                            // Comparaison du chevauchement au niveau des heures début/fin
                            endTime_tmp_spectacle.compareTo(tmp_representation1.getDate()) > 0
                    )
                    {
                        prog_possible = false;
                        break;
                    }
                }
            }
        }

        return prog_possible;
    }

    /**
     * Ajoute un spectacle à la liste des spectacles
     * @param spectacle : spectacle à ajouter
     * @assert Les représentations du spectacle à ajouter ne chevauchent pas les représentations des autres spectacles
     */
    public void ajouterSpectacle(Spectacle spectacle)
    {
        assert(progPossible(spectacle));
        spectacles.add(spectacle);
    }
}
