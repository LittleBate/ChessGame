package controleur;

import model.Piece;
import model.Position;

public class CommandRoque extends AbstractCommandMove 
{
	/**
	 * Position de la tour avant le roque
	 */
	private Position oldTourPosition;
	/**
	 * Position du roi avant le roque
	 */
	private Position oldRoiPosition;
	
	/**
	 * Obtient la position de la tour avant le roque
	 * @return position de la tour avant le roque
	 */
	public Position getOldTourPosition()
	{
		return oldTourPosition;
	}
	
	/**
	 * Definit la position de la tour avant le roque
	 * @param value position de la tour avant le roque
	 */
	private void setOldTourPosition(Position value)
	{
		oldTourPosition = value;
	}
	
	/**
	 * Obtient la position du roi avant le roque
	 * @return position du roi avant le roque
	 */
	public Position getOldRoiPosition()
	{
		return oldRoiPosition;
	}
	
	/**
	 * Definit la position du roi avant le roque
	 * @param value position du roi avant le roque
	 */
	private void setOldRoiPosition(Position value)
	{
		oldRoiPosition = value;
	}
	
	/**
	 * contructeur de la commande
	 * @param roi le roi
	 * @param tour la tour
	 */
	public CommandRoque(Piece roi, Piece tour)
	{
		setOldRoiPosition(roi.getPosition());
		setOldTourPosition(tour.getPosition());
	}

	
	@Override
	public void execute() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

}
