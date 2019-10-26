package Modele.Utilisateur;

import Modele.*;
import Modele.Billetterie.Achat;
import Modele.Billetterie.Reservation;
import Modele.Theatre.*;

import java.util.ArrayList;
import java.util.Date;

/**
 * Représente le client chez le théâtre
 */

public final class Client extends Utilisateur
{
    /**
     * Représente la liste de réservations effectuées
     */
    private ArrayList<Reservation> reservations;

    /**
     * Représente la liste d'achats effectués
     */
    private ArrayList<Achat> achats;

    /**
     * Constructeur
     *
     * @param nom    : nom de l'Utilisateur
     * @param prenom : prénom de l'Utilisateur
     * @param login  : login de l'Utilisateur
     * @param mdp    : mot de passe de l'Utilisateur
     * @param mail   : adresse mail de l'Utilisateur
     * @param tel    : numéro de téléphone de l'Utilisateur
     */
    public Client(String nom, String prenom, String login, String mdp, String mail, String tel)
    {
        super(nom, prenom, login, mdp, mail, tel);
        this.reservations = new ArrayList<Reservation>();
        this.achats = new ArrayList<Achat>();
    }

    /**
     * Getter
     * @return reservations : liste des réservations effectuées
     */
    public ArrayList<Reservation> getReservations()
    {
        return reservations;
    }

    /**
     * Getter
     * @return achats : représente la liste des achats effectués
     */
    public ArrayList<Achat> getAchats()
    {
        return achats;
    }

    /**
     * Réserve une place dans une représentation et zone données
     * @param representation : représentation à assister
     * @param zone : zone de la place
     * @param place : place de la zone
     */
    public Reservation reserverPlace(Representation representation, Zone zone, Place place)
            throws
                ExceptionRepresentationInconnue,
                ExceptionZoneInconnue,
                ExceptionPlaceInexistante,
                ExceptionPlaceReservee
    {
        Reservation reservation = null;
        boolean representation_existante = false;

        if(place.getEtat().equals(Etat.Reservee))
            throw new ExceptionPlaceReservee();
        else
        {
            // Vérification que la représentation existe
            outerloop:
            for(Spectacle tmp_spectacle : Theatre.getTHEATRE().getSpectacles())
            {
                for(Representation tmp_representation : tmp_spectacle.getRepresentations())
                {
                    if(representation.equals(tmp_representation))
                    {
                        representation_existante = true;
                        break outerloop;
                    }
                }
            }

            // Si la représentation existe
            if(representation_existante)
            {
                // Rechercher si la place existe dans la zone

                boolean place_existante = false;

                // zone Balcon
                if(zone.getCategorie() instanceof Balcon)
                {
                    // Recherche de la place
                    for(Place tmp_place : Theatre.getSalle().getZone_Balcon().getPlaces())
                    {
                        // Si la place existe, changer le flag
                        if(place.equals(tmp_place))
                        {
                            place_existante = true;
                            break;
                        }
                    }

                    // La place existe, alors on crée une réservation
                    if(place_existante)
                    {
                        place.setEtat(Etat.Reservee);
                        ArrayList<Place> places = new ArrayList<Place>();
                        places.add(place);
                        reservation = new Reservation(new Date(),places,representation);
                        reservations.add(reservation);
                        return reservation;
                    }
                    else
                    {
                        throw new ExceptionPlaceInexistante();
                    }
                }
                // zone Poulailler
                else if(zone.getCategorie() instanceof Poulailler)
                {
                    // Recherche de la place
                    for(Place tmp_place : Theatre.getSalle().getZone_Poulailler().getPlaces())
                    {
                        // Si la place existe, changer le flag
                        if(place.equals(tmp_place))
                        {
                            place_existante = true;
                            break;
                        }
                    }

                    // La place existe, alors on crée une réservation
                    if(place_existante)
                    {
                        place.setEtat(Etat.Reservee);
                        ArrayList<Place> places = new ArrayList<Place>();
                        places.add(place);
                        reservation = new Reservation(new Date(),places,representation);
                        reservations.add(reservation);
                        return reservation;
                    }
                    else
                    {
                        throw new ExceptionPlaceInexistante();
                    }
                }
                else if(zone.getCategorie() instanceof Orchestre)
                {
                    // Recherche de la place
                    for(Place tmp_place : Theatre.getSalle().getZone_Orchestre().getPlaces())
                    {
                        // Si la place existe, changer le flag
                        if(place.equals(tmp_place))
                        {
                            place_existante = true;
                            break;
                        }
                    }

                    // La place existe, alors on crée une réservation
                    if(place_existante)
                    {
                        place.setEtat(Etat.Reservee);
                        ArrayList<Place> places = new ArrayList<Place>();
                        places.add(place);
                        reservation = new Reservation(new Date(),places,representation);
                        reservations.add(reservation);
                        return reservation;
                    }
                    else
                    {
                        throw new ExceptionPlaceInexistante();
                    }
                }
                else
                {
                    throw new ExceptionZoneInconnue();
                }
            }
            else
            {
                throw new ExceptionRepresentationInconnue();
            }
        }
    }
}
