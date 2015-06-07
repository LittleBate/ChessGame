package model;

import java.util.List;

import javax.swing.DefaultComboBoxModel;


public class ComboboxModelPositionPossible extends DefaultComboBoxModel<Position> 
{
	private static final long serialVersionUID = 6073216607780705890L;

	/**
	 * instance unique du model
	 */
	private static ComboboxModelPositionPossible instance;
	
	/**
	 * constructeur prive du model
	 */
	private ComboboxModelPositionPossible()
	{}
	
	/**
	 * obtient l'instance unique du model
	 * @return instance unqiue du model
	 */
	public static ComboboxModelPositionPossible getInstance()
	{
		if(instance == null)
			instance = new ComboboxModelPositionPossible();
		return instance;
	}
	
	/**
	 * Définit le nouveau contenu du model
	 * @param positions liste de positions que doit contenir le model
	 */
	public void newConent(List<Position> positions)
	{
		removeAllElements();
		for(Position position : positions)
			addElement(position);
	}
}
