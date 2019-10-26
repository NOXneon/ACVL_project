package Modele.Billetterie;

import java.util.ArrayList;

/**
 * Représente l'instance regroupant les différents dossiers (réservations, achat, ticket) (donc Singleton)
 */
public final class Billetterie
{
    /**
     * Représente l'instance unique non initialisée
     */
    private static Billetterie BILLETTERIE = null;

    /**
     * Représente le nom du théâtre
     */
    private static String nom = "Théâtre SAW";

    /**
     * Représente la liste de toutes les réservations
     */
    private ArrayList<Reservation> reservations;

    /**
     * Représente la liste de tous les achats
     */
    private ArrayList<Achat> achats;

    /**
     * Représente la liste de tous les tickets
     */
    private ArrayList<Ticket> tickets;

    /**
     * Constructeur
     */
    private Billetterie()
    {
        this.reservations = new ArrayList<Reservation>();
        this.achats = new ArrayList<Achat>();
        this.tickets = new ArrayList<Ticket>();
    }

    /**
     * Accès à l'instance unique de Billetterie
     * @return BILLETTERIE : instance unique de Billetterie
     */
    public static synchronized Billetterie getBILLETTERIE()
    {
        if(BILLETTERIE == null)
            BILLETTERIE = new Billetterie();

        return BILLETTERIE;
    }

    /**
     * Ajoute une réservation à la liste des réservations
     * @param reservation : réservation à ajouter
     */
    public void ajouterReservation(Reservation reservation)
    {
        this.reservations.add(reservation);
    }

    /**
     * Ajoute un achat à la liste d'achats
     * @param achat : l'achat à ajouter
     */
    public void ajouterAchat(Achat achat)
    {
        this.achats.add(achat);
    }

    /**
     * Ajoute un ticket à la liste des tickets
     * @param ticket : ticket à ajouter
     */
    public void ajouterTicket(Ticket ticket)
    {
        this.tickets.add(ticket);
    }

    /**
     * Supprime une réservation de la liste des réservations
     * @param reservation : réservation à supprimer
     */
    public void supprimerReservation(Reservation reservation)
    {
        for(Reservation tmp_reservation : reservations)
        {
            if(reservation.equals(tmp_reservation))
                reservations.remove(reservation);
        }
    }

    /**
     * Supprime un achat de la liste des achats
     * @param achat : achat à supprimer
     */
    public void supprimerAchat(Achat achat)
    {
        for(Achat tmp_achat : achats)
        {
            if(achat.equals(tmp_achat))
                achats.remove(achat);
        }
    }

    /**
     * Supprime un ticket de la liste des tickets
     * @param ticket : ticket à supprimer
     */
    public void supprimerTicket(Ticket ticket)
    {
        for(Ticket tmp_ticket : tickets)
        {
            if(ticket.equals(tmp_ticket))
                tickets.remove(ticket);
        }
    }
}
