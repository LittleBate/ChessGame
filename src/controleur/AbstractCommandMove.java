package controleur;

public abstract class AbstractCommandMove implements CommandMove 
{
	/**
	 * Classe qui contient l'action à effectuer sur l'echiquier
	 */
	private Move move;
	
	/**
	 * Obtient l'action à effectuer sur l'echiquier
	 * @return
	 */
	public Move getMove()
	{
		return move;
	}
	
	/**
	 * Définit l'action à effectuer sur l'echiquier
	 * @param value action à effectuer
	 */
	protected void setMove(Move value)
	{
		move = value;
	}
}
