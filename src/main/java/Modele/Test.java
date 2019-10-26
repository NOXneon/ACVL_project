package Modele;

import Modele.Theatre.Place;
import Modele.Theatre.Representation;
import Modele.Theatre.Spectacle;
import Modele.Theatre.Theatre;
import Modele.Utilisateur.Client;
import Modele.Utilisateur.Respo_Application;
import Modele.Utilisateur.Respo_Programmation;
import Modele.Utilisateur.Utilisateur;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Test
{
    public static void main(String[] args)
    {
        //-------------------------  Création du théâtre -------------------------
        Theatre theatre = Theatre.getTHEATRE();
        //-------------------------  Fin création du théâtre -------------------------

        //------------------------- Création des places -------------------------
        // Rang 1
        Place place11 = new Place("n°1","Rang n°1");
        Place place21 = new Place("n°1","Rang n°1");
        Place place31 = new Place("n°1","Rang n°1");
        // Rang 2
        Place place12 = new Place("n°1","Rang n°1");
        Place place22 = new Place("n°1","Rang n°1");
        Place place32 = new Place("n°1","Rang n°1");
        // Rang 3
        Place place13 = new Place("n°1","Rang n°1");
        Place place23 = new Place("n°1","Rang n°1");
        Place place33 = new Place("n°1","Rang n°1");
        //------------------------- Fin création des places -------------------------

        //------------------------- Attribution des places aux zones -------------------------
        // Balcon
        ArrayList<Place> places_Balcon = new ArrayList<Place>();
        places_Balcon.add(place11);
        places_Balcon.add(place21);
        places_Balcon.add(place31);
        Theatre.getSalle().getZone_Balcon().setPlaces(places_Balcon);
        // Poulailler
        ArrayList<Place> places_Poulailler = new ArrayList<Place>();
        places_Poulailler.add(place12);
        places_Poulailler.add(place22);
        places_Poulailler.add(place32);
        Theatre.getSalle().getZone_Poulailler().setPlaces(places_Poulailler);
        // Orchestre
        ArrayList<Place> places_Orchestre = new ArrayList<Place>();
        places_Orchestre.add(place13);
        places_Orchestre.add(place23);
        places_Orchestre.add(place33);
        Theatre.getSalle().getZone_Balcon().setPlaces(places_Orchestre);
        //------------------------- Fin attribution des places aux zones -------------------------

        //------------------------- Création des spectacles -------------------------
        //------ Spectacle 1 ------
        // Création des représentations
        Representation representation1 = new Representation(new Date(), 90);
        ArrayList<Representation> representations_spectacle1 = new ArrayList<Representation>();
        representations_spectacle1.add(representation1);
        Spectacle spectacle1 = new Spectacle("Spectacle n°1","Spectacle Athab",representations_spectacle1);
        //------ Fin spectacle 1 ------
        //------ Spectacle 2 ------
        // Création des représentations
        Representation representation2 = new Representation(new Date(), 120);
        ArrayList<Representation> representations_spectacle2 = new ArrayList<Representation>();
        representations_spectacle1.add(representation2);
        Spectacle spectacle2 = new Spectacle("Spectacle n°2","Spectacle SwichSwichBish",representations_spectacle2);
        //------ Fin spectacle 2 ------
        //------ Spectacle 3 ------
        // Création des représentations
        Representation representation3 = new Representation(new Date(), 90);
        ArrayList<Representation> representations_spectacle3 = new ArrayList<Representation>();
        representations_spectacle1.add(representation3);
        Spectacle spectacle3 = new Spectacle("Spectacle n°3","Spectacle neon",representations_spectacle3);
        //------ Fin spectacle 3 ------
        //------------------------- Fin création des spectacles -------------------------

        //------------------------- Attribution des spectacles -------------------------
        try
        {
            theatre.ajouterSpectacle(spectacle1);
            theatre.ajouterSpectacle(spectacle2);
            theatre.ajouterSpectacle(spectacle3);
        } catch (ExceptionChevauchement exceptionChevauchement)
        {
            exceptionChevauchement.printStackTrace();
        }
        //------------------------- Fin attribution des spectacles -------------------------

        //------------------------- Création des utilisateurs -------------------------
        Utilisateur respo_appli = new Respo_Application("BACHETARZI","Angie","SwichSwich","Bish","SwichSwichBish@gmail.com","0123456789");
        Utilisateur respo_prog = new Respo_Programmation("RIBAUT","Simon","Athab","TFT","Athab@gmail.com","9876543210");
        Utilisateur client = new Client("GRISSI","Wafi","neon","noxus","neon@gmail.com","7777777777");
        //------------------------- Fin création des utilisateurs -------------------------

        System.out.println(theatre.planningSpectacles());
    }
}
