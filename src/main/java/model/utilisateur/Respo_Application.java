package model.utilisateur;

/**
 * Représente le responsable de programmation du théâtre
 */

public class Respo_Application extends Responsable
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
    public Respo_Application(String nom, String prenom, String login, String mdp, String mail, String tel)
    {
        super(nom, prenom, login, mdp, mail, tel);
    }
}