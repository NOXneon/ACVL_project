package Modèle.Utilisateur;

/**
 * Représente un responsable
 */

public abstract class Responsable extends Utilisateur
{
    /**
     * Constructeur
     *
     * @param nom    : nom de l'utilisateur
     * @param prenom : prénom de l'utilisateur
     * @param login  : login de l'utilisateur
     * @param mdp    : mot de passe de l'utilisateur
     * @param mail   : adresse mail de l'utilisateur
     * @param tel    : numéro de téléphone de l'utilisateur
     */
    public Responsable(String nom, String prenom, String login, String mdp, String mail, String tel)
    {
        super(nom, prenom, login, mdp, mail, tel);
    }
}
