package model.utilisateur;

/**
 * Représente un utilisateur de l'application
 */

public abstract class Utilisateur
{
    /**
     * Représente le nom de l'utilisateur
     */
    private String nom;

    /**
     * Représente le prénom de l'utilisateur
     */
    private String prenom;

    /**
     * Représente le login de l'utilisateur
     */
    private String login;

    /**
     * Représente le mot de passe de l'utilisateur
     */
    private String mdp;

    /**
     * Représente l'adresse mail de l'utilisateur
     */
    private String mail;

    /**
     * Représente le numéro de téléphone de l'utilisateur
     */
    private String tel;

    /**
     * Constructeur
     * @param nom : nom de l'utilisateur
     * @param prenom : prénom de l'utilisateur
     * @param login : login de l'utilisateur
     * @param mdp : mot de passe de l'utilisateur
     * @param mail : adresse mail de l'utilisateur
     * @param tel : numéro de téléphone de l'utilisateur
     */
    public Utilisateur(String nom, String prenom, String login, String mdp, String mail, String tel)
    {
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.mdp = mdp;
        this.mail = mail;
        this.tel = tel;
    }

    /**
     * Getter
     * @return nom : nom de l'utilisateur
     */
    public String getNom()
    {
        return nom;
    }

    /**
     * Getter
     * @return prenom : prénom de l'utilisateur
     */
    public String getPrenom()
    {
        return prenom;
    }

    /**
     * Getter login : login de l'utilisateur
     * @return
     */
    public String getLogin()
    {
        return login;
    }

    /**
     * Getter
     * @return mdp ! mot de passe de l'utilisateur
     */
    public String getMdp()
    {
        return mdp;
    }

    /**
     * Getter
     * @return mail : adresse mail de l'utilisateur
     */
    public String getMail()
    {
        return mail;
    }

    /**
     * Getter
     * @return tel : numéro de téléphone de l'utilisateur
     */
    public String getTel()
    {
        return tel;
    }
}
