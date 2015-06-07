package controleur;

import java.util.List;


public interface Move 
{
	/**
	 * execute le movement sur l'echiquier
	 * @param values Liste des �l�ments n�cessaire pour effectuer l'action
	 */
	public void move(List<Object> values);
}
