package model;

import java.util.List;

import javax.swing.DefaultComboBoxModel;


public class ComboboxModelPieceJouable extends DefaultComboBoxModel<IPiece> 
{
	private static final long serialVersionUID = 1L;
	
	/**
	 * Instance du model
	 */
	private static ComboboxModelPieceJouable instance;
	
	/**
	 * Constructeur prive du model
	 */
	private ComboboxModelPieceJouable()
	{}
	
	/**
	 * Obtient l'instance unique du model
	 * @return
	 */
	public static ComboboxModelPieceJouable getInstance()
	{
		if(instance == null)
			instance = new ComboboxModelPieceJouable();
		return instance;
	}
	
	/**
	 * Définit le contenu du model
	 * @param pieces liste des pieces que doit contenir le model
	 */
	public void newContent(List<IPiece> pieces)
	{
		removeAllElements();
		for(IPiece piece : pieces)
			addElement(piece);
	}

}
