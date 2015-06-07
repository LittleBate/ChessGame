package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Tour extends Piece 
{
	/**
	 * Obtient la description d'un tour
	 * @return description d'une tour
	 */
	public static String getDescription()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(Tour.class.getName().substring(6, 7).toUpperCase())
			.append(" - ")
			.append(Tour.class.getName().substring(6));
		return sb.toString();
	}

	/**
	 * constructeur
	 * @param couleur couleur de la piece
	 * @param position position de la piece
	 */
	public Tour(Color couleur, Position position)
	{
		super(couleur, position);
	}

	@Override
	public List<Position> getPositions()
	{
		List<Position> positions = new ArrayList<>();
		for(int i = 1; i < 8; i++)
		{
			if(getPosition().getColumn() - i >= 0)
				positions.add(new Position(getPosition().getRow(), 
						getPosition().getColumn() - i));
			if(getPosition().getColumn() + i < 8)
				positions.add(new Position(getPosition().getRow(), 
						getPosition().getColumn() + i));
			if(getPosition().getRow() - i >= 0)
				positions.add(new Position(getPosition().getRow() - i, 
						getPosition().getColumn()));
			if(getPosition().getRow() + i < 8)
				positions.add(new Position(getPosition().getRow() + i, 
						getPosition().getColumn()));
		}
		return positions;
	}

}
