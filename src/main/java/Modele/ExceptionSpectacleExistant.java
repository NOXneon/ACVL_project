package Modele;

public class ExceptionSpectacleExistant extends Exception {
	    public ExceptionSpectacleExistant()
	    {
	        super("Spectacle deja existant ; Veuillez vérifier vos informations.");
	    }
}
