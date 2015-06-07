package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Pion extends Piece 
{
	/**
	 * Obtient la description d'un pion
	 * @return description d'un pion
	 */
	public static String getDescription()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(Pion.class.getName().substring(6, 7).toUpperCase())
			.append(" - ")
			.append(Pion.class.getName().substring(6));
		return sb.toString();
	}

	/**
	 * Constructeur
	 * @param couleur couleur de la piece
	 * @param position position de la piece
	 */
	public Pion(Color couleur, Position position)
	{
		super(couleur, position);
	}

	@Override
	public List<Position> getPositions()
	{
		if(getColor() == Color.WHITE)
			return getWhitePosition();
		else
			return getBlackPosition();
	}
	
	/**
	 * Obtient les positions possible pour un pion blanc
	 * @return positions possibles
	 */
	private List<Position> getWhitePosition()
	{
		List<Position> positions = new ArrayList<>();
		positions.add(new Position(getPosition().getRow() - 1, getPosition().getColumn() - 1));
		positions.add(new Position(getPosition().getRow() - 1, getPosition().getColumn() + 1));
		positions.add(new Position(getPosition().getRow() - 1, getPosition().getColumn()));
		return positions;
	}

	/**
	 * Obtient les positions possibles pour un pion noir
	 * @return positions possibles
	 */
	private List<Position> getBlackPosition()
	{
		List<Position> positions = new ArrayList<>();
		positions.add(new Position(getPosition().getRow() + 1, getPosition().getColumn() - 1));
		positions.add(new Position(getPosition().getRow() + 1, getPosition().getColumn() + 1));
		positions.add(new Position(getPosition().getRow() + 1, getPosition().getColumn()));
		return positions;
	}
}
