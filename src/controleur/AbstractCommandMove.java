package controleur;

public abstract class AbstractCommandMove implements CommandMove 
{
	/**
	 * Classe qui contient l'action � effectuer sur l'echiquier
	 */
	private Move move;
	
	/**
	 * Obtient l'action � effectuer sur l'echiquier
	 * @return
	 */
	public Move getMove()
	{
		return move;
	}
	
	/**
	 * D�finit l'action � effectuer sur l'echiquier
	 * @param value action � effectuer
	 */
	protected void setMove(Move value)
	{
		move = value;
	}
}
