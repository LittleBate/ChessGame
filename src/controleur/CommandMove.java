package controleur;

public interface CommandMove 
{
	/**
	 * Permet l'execution de l'action � effectuer sur l'echiquier
	 */
	public void execute();
	
	/**
	 * Permet d'annuler l'action effectue sur l'echiquier
	 */
	public void undo();
}
