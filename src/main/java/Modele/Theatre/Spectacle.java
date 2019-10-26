package Modele.Theatre;

import Modele.ExceptionChevauchement;

import java.util.ArrayList;
import java.util.Date;

/**
 * Représente un spectacle mis en scène par le biai de différentes représentations
 *
 * @see Representation
 */

public class Spectacle
{
    /**
     * Représete le numéro ID du spectacle
     */
    private String numero;

    /**
     * Représente le nom spectacle
     */
    private String nom;

    /**
     * Représente la liste des représentations du spectacle
     */
    private ArrayList<Representation> representations;

    /**
     * Constructeur paramétré
     * @param numero : numéro ID du spectacle
     * @param nom : nom du spectacle
     * @param representations : liste des représentations
     */
    public Spectacle(String numero, String nom, ArrayList<Representation> representations)
    {
        this.numero = numero;
        this.nom = nom;
        this.representations = representations;
    }

    /**
     * Getter
     * @return numero : numéro ID du spectacle
     */
    public String getNumero()
    {
        return numero;
    }

    /**
     * Getter
     * @return nom : nom du spectacle
     */
    public String getNom()
    {
        return nom;
    }

    /**
     * Getter
     * @return representations : liste des représentations du spectacle
     */
    public ArrayList<Representation> getRepresentations()
    {
        return representations;
    }

    /**
     * Vérifie que la représentation ne chevauche pas les autres représentations du spectacle
     * @param representation : représentation à ajouter
     * @return prog_possible : booléen représentant si la programmation de la représentation est possible
     *                       (donc sa date ne chevauche pas les dates des autres représentations du spectacle)
     */
    public boolean progPossible(Representation representation)
    {
        boolean prog_possible = true;

        for(Representation tmp_representation : representations)
        {
            Date endTime_spectacle = new Date(representation.getDate().getTime()+representation.getDuree());
            if
            (
                    // Comparaison du chevauchement au niveau de la date
                    representation.getDate().compareTo(tmp_representation.getDate()) == 0
                    ||
                    // Comparaison du chevauchement au niveau des heures début/fin
                    endTime_spectacle.compareTo(tmp_representation.getDate()) > 0
            )
            {
                prog_possible = false;
                break;
            }
        }

        return prog_possible;
    }

    /**
     *  Ajoute une représentation du spectacle
     * @param representation : représentation à ajouter
     * @throws ExceptionChevauchement : quand il y a un chevauchement de dates
     */
    public void ajouterRepresentation(Representation representation) throws ExceptionChevauchement
    {
        if(progPossible(representation))
            representations.add(representation);
        else
            throw new ExceptionChevauchement();
    }

    /**
     * Supprime une représentation du spectacle
     * @param representation : représentation à supprimer
     */
    public void supprimerRepresentation(Representation representation)
    {
        for(Representation tmp_representation : representations)
        {
            if(representation.equals(tmp_representation))
                representations.remove(representation);
        }
    }
}
