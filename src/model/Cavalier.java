package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Cavalier extends Piece
{
	/**
	 * Obtient la description d'un cavalier
	 * @return description d'un cavalier
	 */
	public static String getDescription()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(Cavalier.class.getName().substring(6, 7).toUpperCase())
			.append(" - ")
			.append(Cavalier.class.getName().substring(6));
		return sb.toString();
	}

	
	/**
	 * Constructeur
	 * @param couleur couleur de la piece
	 * @param position position de la piece
	 */
	public Cavalier(Color couleur, Position position) 
	{
		super(couleur, position);
	}

	@Override
	public List<Position> getPositions()
	{
		List<Position> positions = new ArrayList<>();
		for(Position position : getPositionsBase())
		{
			if(position.getRow() >= 0 && position.getRow() < 8 
					&& position.getColumn() >= 0 && position.getColumn() < 8)
				positions.add(position);
		}
		return positions;
	}

	/**
	 * Liste de toute les trajectoire que peut prendre le cavalier sans regarder si elle sont
	 * sur l'echiquier
	 * @return liste des trajectoires possibles
	 */
	private List<Position> getPositionsBase()
	{
		List<Position> positions = new ArrayList<>();
		positions.add(new Position(getPosition().getRow() - 1, getPosition().getColumn() + 2));
		positions.add(new Position(getPosition().getRow() - 1, getPosition().getColumn() - 2));
		positions.add(new Position(getPosition().getRow() + 1, getPosition().getColumn() + 2));
		positions.add(new Position(getPosition().getRow() + 1, getPosition().getColumn() - 2));
		positions.add(new Position(getPosition().getRow() - 2, getPosition().getColumn() + 1));
		positions.add(new Position(getPosition().getRow() - 2, getPosition().getColumn() - 1));
		positions.add(new Position(getPosition().getRow() + 2, getPosition().getColumn() + 1));
		positions.add(new Position(getPosition().getRow() + 2, getPosition().getColumn() - 1));
		return positions;
	}
}
