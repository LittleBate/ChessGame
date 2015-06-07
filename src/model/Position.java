package model;

import java.util.ArrayList;
import java.util.List;

public class Position
{
	/**
	 * Liste des identifiant de colonne
	 */
	@SuppressWarnings("serial")
	List<String> alpha = new ArrayList<String>(){{add("a"); add("b"); add("c"); add("d");
		add("e"); add("f"); add("g"); add("h");}};
	
	/**
	 * Numero de ligne
	 */
	private int row;
	/**
	 * Numero de colonne
	 */
	private int column;
	
	/**
	 * Obtient le numero de la ligne
	 * @return le numero de la ligne
	 */
	public int getRow()
	{
		return row;
	}
	
	/**
	 * Définit le numero de la ligne
	 * @param row numero de ligne
	 */
	private void setRow(int row)
	{
		this.row = row;
	}
	
	/**
	 * Obtient le numero de colonne
	 * @return numero de colonne
	 */
	public int getColumn()
	{
		return column;
	}
	
	/**
	 * Définit le numero de colonne
	 * @param column numéro de colonne
	 */
	private void setColumn(int column)
	{
		this.column = column;
	}
	
	/**
	 * Constructeur de position
	 * @param row la ligne
	 * @param column la colonne
	 */
	public Position(int row, int column)
	{
		setRow(row);
		setColumn(column);
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		try
		{
			sb.append(8 - getRow()).append(", ").append(alpha.get(getColumn()));
		}
		catch(Exception e)
		{
			System.out.println(getColumn());
		}
		return sb.toString();
	}
	
	public boolean equals(Object position)
	{
		Position pos = (Position)position;
		if(pos == null)
			return false;
		return pos.getRow() == getRow() && pos.getColumn() == getColumn();
	}
	
	public int hashCode()
	{
		return row;
	}
}
