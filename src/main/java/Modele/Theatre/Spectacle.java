package Modele.Theatre;

import java.util.ArrayList;

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
}
