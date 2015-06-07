package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Fou extends Piece
{
	/**
	 * Obtient la description d'un fou
	 * @return description d'un fou
	 */
	public static String getDescription()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(Fou.class.getName().substring(6, 7).toUpperCase())
			.append(" - ")
			.append(Fou.class.getName().substring(6));
		return sb.toString();
	}

	/**
	 * Constructeur
	 * @param couleur couleur du fou
	 * @param position position du fou
	 */
	public Fou(Color couleur, Position position)
	{
		super(couleur, position);
	}

	@Override
	public List<Position> getPositions()
	{
		List<Position> positions = new ArrayList<>();
		for(int i = 1; i < 8; i++)
		{
			if(getPosition().getRow() - i >= 0 && getPosition().getColumn() - i >= 0
					&& getPosition().getRow() - i < 8 && getPosition().getColumn() - i < 8)
				positions.add(new Position(getPosition().getRow() - i, 
						getPosition().getColumn() - i));
			
			if(getPosition().getRow() - i >= 0 && getPosition().getColumn() + i >= 0
					&& getPosition().getRow() - i < 8 && getPosition().getColumn() + i < 8)
				positions.add(new Position(getPosition().getRow() - i, 
						getPosition().getColumn() + i));
			
			if(getPosition().getRow() + i >= 0 && getPosition().getColumn() - i >= 0
					&& getPosition().getRow() + i < 8 && getPosition().getColumn() - i < 8)
				positions.add(new Position(getPosition().getRow() + i, 
						getPosition().getColumn() - i));
			
			if(getPosition().getRow() + i >= 0 && getPosition().getColumn() + i >= 0
					&& getPosition().getRow() + i < 8 && getPosition().getColumn() + i < 8)
				positions.add(new Position(getPosition().getRow() + i, 
						getPosition().getColumn() + i));
		}
		return positions;
	}

}
