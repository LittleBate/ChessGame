package model;

import java.awt.Color;
import java.util.List;

public abstract class Piece  implements IPiece
{
	/**
	 * couleur de la piece
	 */
	private Color couleur;
	/**
	 * position de la piece
	 */
	private Position position;
	
	/**
	 * Obtient la couleur de la piece
	 * @return couleur de la piece
	 */
	public Color getColor()
	{
		return couleur;
	}
	
	/**
	 * Definit la couleur de la piece
	 * @param couleur couleur de la piece
	 */
	private void setColor(Color couleur)
	{
		this.couleur = couleur;
	}
	
	/**
	 * Obtient la position de la piece
	 */
	public Position getPosition()
	{
		return position;
	}
	
	/**
	 * Définit la position de la piece
	 * @param position position de la piece
	 */
	public void setPosition(Position position)
	{
		this.position = position;
	}
	
	/**
	 * Constructeur
	 * @param couleur couleur de la piece
	 * @param position position de la piece
	 */
	public Piece(Color couleur, Position position)
	{
		setPosition(position);
		setColor(couleur);
	}
	
	/**
	 * Obtient la liste des case ou peut bouger la piece
	 * @return liste de positions possible
	 */
	public abstract List<Position> getPositions();
	
	public String toString()
	{
		return this.getClass().getName().substring(6, 7).toUpperCase();
	}
}