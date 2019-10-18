package model.billetterie;

import model.Statut;

/**
 * Représente le ticket émis suite à un achat de place
 *
 * @see Achat
 * @see model.theater.Place
 * @see model.utilisateur.Client
 * @see model.utilisateur.Respo_Programmation
 */

// TODO : lier la classe à Achat

public class Ticket
{
    /**
     * Représente le numéro de série du ticket concernant l'achat de place
     */
    private String num_serie;

    /**
     * Représente la date d'émission du ticket
     */
    private String date;

    /**
     * Représente le statut du ticket
     */
    private Statut statut;

    /**
     * Constructeur
     * @param num_serie : numéro de série du ticket concernant l'achat de place
     * @param date : date d'émission du ticket
     */
    public Ticket(String num_serie, String date)
    {
        this.num_serie = num_serie;
        this.date = date;
        // Statut par défaut : Valide_e
        this.statut = Statut.Valide_e;
    }

    /**
     * Getter
     * @return num_serie : numéro de série du ticket concernant l'achat de place
     */
    public String getNum_serie()
    {
        return num_serie;
    }

    /**
     * Getter
     * @return date : date d'émission du ticket
     */
    public String getDate()
    {
        return date;
    }

    /**
     * Getter
     * @return statut : statut du ticket
     */
    public Statut getStatut()
    {
        return statut;
    }

    /**
     * Setter
     * @param statut : statut du ticket
     */
    public void setStatut(Statut statut)
    {
        this.statut = statut;
    }
}
