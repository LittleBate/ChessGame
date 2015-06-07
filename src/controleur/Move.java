package controleur;

import java.util.List;


public interface Move 
{
	/**
	 * execute le movement sur l'echiquier
	 * @param values Liste des éléments nécessaire pour effectuer l'action
	 */
	public void move(List<Object> values);
}
