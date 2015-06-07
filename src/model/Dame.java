package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Dame extends Piece 
{
	/**
	 * Obtient la descrip^tion d'une dame
	 * @return la description d'une dame
	 */
	public static String getDescription()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(Dame.class.getName().substring(6, 7).toUpperCase())
			.append(" - ")
			.append(Dame.class.getName().substring(6));
		return sb.toString();
	}

	/**
	 * Constructeur
	 * @param couleur couleur de la dame
	 * @param position position de la dame
	 */
	public Dame(Color couleur, Position position)
	{
		super(couleur, position);
	}

	@Override
	public List<Position> getPositions() 
	{
		List<Position> positions = new ArrayList<>();
		positions.addAll(getFouPositions());
		positions.addAll(getTourPositions());
		return positions;
	}
	
	/**
	 * Obtient la liste des mouvement que la dame peut effectuer à la maniere d'une tour
	 * @return liste de positions possible
	 */
	private List<Position> getTourPositions()
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
	
	/**
	 * Obtient la liste des mouvement que la dame peut effectuer à la maniere d'un fou
	 * @return liste de positions possible
	 */
	private List<Position> getFouPositions()
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
