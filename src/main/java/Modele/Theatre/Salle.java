package Modele.Theatre;

import Modele.ExceptionChevauchement;

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
    private Zone zone_Balcon;

    /**
     * Représente une des 3 zones de la salle
     */
    private Zone zone_Poulailler;

    /**
     * Représente une des 3 zones de la salle
     */
    private Zone zone_Orchestre;

    /**
     * Représente la liste des spectacles programmés dans la salle
     */
    private ArrayList<Spectacle> spectacles;

    /**
     * Constructeur
     */
    private Salle()
    {

    }

    /**
     * Constructeur
     * @param spectacles : liste des spectacles programmés dans la salle
     * @param zone_Balcon : représente la zone Balcon
     * @param zone_Poulailler : représente la zone Poulailler
     * @param zone_Orchestre : représente la zone Orchestre
     */
    private Salle(ArrayList<Spectacle> spectacles, Zone zone_Balcon, Zone zone_Poulailler, Zone zone_Orchestre)
    {
        this.zone_Balcon = zone_Balcon;
        this.zone_Poulailler = zone_Poulailler;
        this.zone_Orchestre = zone_Orchestre;
        this.spectacles = spectacles;
    }

    /**
     * Point d'accès à l'instance unique de Salle
     * @return SALLE : Salle unique
     */
    public static synchronized Salle getSALLE(ArrayList<Spectacle> spectacles, Zone zone_Balcon, Zone zone_Poulailler, Zone zone_Orchestre)
    {
        if(SALLE == null)
            SALLE = new Salle();

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
    public Zone getZone_Balcon()
    {
        return zone_Balcon;
    }

    /**
     * Getter
     * @return zone_Poulailler : représente la zone Poulailler
     */
    public Zone getZone_Poulailler()
    {
        return zone_Poulailler;
    }

    /**
     * Getter
     * @return zone_Orchestre : représente la zone Orchestre
     */
    public Zone getZone_Orchestre()
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
     * @throws ExceptionChevauchement : quand il y a un chevauchement de dates
     */
    public void ajouterSpectacle(Spectacle spectacle) throws ExceptionChevauchement
    {
        if(progPossible(spectacle))
            spectacles.add(spectacle);
        else
            throw new ExceptionChevauchement();
    }

    /**
     * Supprime un spectacle de la liste des spectacles
     * @param spectacle : spectacle à supprimer
     */
    public void supprimerSpectacle(Spectacle spectacle)
    {
        for(Spectacle tmp_spectacle : spectacles)
        {
            if(spectacle.equals(tmp_spectacle))
                spectacles.remove(spectacle);
        }
    }
}
