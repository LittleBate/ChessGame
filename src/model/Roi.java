package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Roi extends Piece 
{
	/**
	 * Obtient la description d'un roi
	 * @return description d'un roi
	 */
	public static String getDescription()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(Roi.class.getName().substring(6, 7).toUpperCase())
			.append(" - ")
			.append(Roi.class.getName().substring(6));
		return sb.toString();
	}

	/**
	 * constructeur
	 * @param couleur couleur de la piece
	 * @param position position de la piece
	 */
	public Roi(Color couleur, Position position)
	{
		super(couleur, position);
	}

	@Override
	public List<Position> getPositions() 
	{
		List<Position> positions = new ArrayList<>();
		
		if(getPosition().getColumn() >= 0)
			positions.add(new Position(getPosition().getRow(), getPosition().getColumn() - 1));
		else if(getPosition().getColumn() < 8)
			positions.add(new Position(getPosition().getRow(), getPosition().getColumn() + 1));
		
		if(getPosition().getRow() >= 0)
			positions.add(new Position(getPosition().getRow() - 1, getPosition().getColumn()));
		else if(getPosition().getRow() < 8)
			positions.add(new Position(getPosition().getRow() + 1, getPosition().getColumn()));
		
		return positions;
	}

}
