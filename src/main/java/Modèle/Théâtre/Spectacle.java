package Modèle.Théâtre;

/**
 * Représente un spectacle mis en scène par le biai de différentes représentations
 *
 * @see Represantation
 */

// TODO : lier la classe à Représentation

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
     * Constructeur paramétré
     * @param numero : numéro ID du spectacle
     * @param nom : nom du spectacle
     */
    public Spectacle(String numero, String nom)
    {
        this.numero = numero;
        this.nom = nom;
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
}
