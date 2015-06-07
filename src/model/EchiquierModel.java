package model;

import java.util.Collection;
import java.util.Set;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class EchiquierModel extends DefaultTableModel 
{
	private static final long serialVersionUID = -36886592060746137L;

	/**
	 * instance unique du model
	 */
	private static EchiquierModel instance;
	
	/**
	 * Obtient l'instance unique du model
	 * @return instance unique du model
	 */
	public static EchiquierModel getInstance()
	{
		if(instance == null)
			instance = new EchiquierModel();
		return instance;
	}
	
	/**
	 * constructeur prive du model
	 */
	private EchiquierModel()
	{
		super();
		Vector<String> vec = new Vector<>();
		vec.add("");
		vec.add("a");
		vec.add("b");
		vec.add("c");
		vec.add("d");
		vec.add("e");
		vec.add("f");
		vec.add("g");
		vec.add("h");
		
		setColumnIdentifiers(vec);
		setRowCount(8);
		addRowHeader();
	}
	
	/**
	 * ajoute les numeros de ligne
	 */
	private void addRowHeader()
	{
		for(int i = 0; i < 8; i++)
		{
			setValueAt(8 - i, i, 0);
		}
	}
	
	/**
	 * Supprime tous les elements situé aux positions passé en parametre
	 * @param positions liste de positions
	 */
	public void removeAllElements(Set<Position> positions)
	{
		for(Position position : positions)
			setValueAt(null, position.getRow(), position.getColumn() + 1);
	}
	
	/**
	 * Ajoute au tableau les pieces passé en parametre
	 * @param pieces liste de pieces à ajouter
	 */
	public void addAllElements(Collection<Piece> pieces)
	{
		for(Piece piece : pieces)
			setValueAt(piece, piece.getPosition().getRow(), piece.getPosition().getColumn() + 1);
	}


	public boolean isCellEditable(int row, int column)
	{
		return false;
	}
}
