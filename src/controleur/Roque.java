package controleur;

import java.util.List;

import model.Piece;

public class Roque implements Move 
{
	/**
	 * la tour
	 */
	private Piece tour;
	/**
	 * le roi
	 */
	private Piece roi;
	
	/**
	 * Obtient la tour
	 * @return la tour
	 */
	public Piece getTour()
	{
		return tour;
	}
	
	/**
	 * Définit la tour
	 * @param value la tour
	 */
	private void setTour(Piece value)
	{
		tour = value;
	}
	
	/**
	 * Obtient le roi
	 * @return le roi
	 */
	public Piece getRoi()
	{
		return roi;
	}
	
	/**
	 * Définit le roi
	 * @param value le roi
	 */
	private void setRoi(Piece value)
	{
		roi = value;
	}
	
	/**
	 * Constructeur
	 * @param tour la tour
	 * @param roi le roi
	 */
	public Roque(Piece tour, Piece roi)
	{
		setRoi(roi);
		setTour(tour);
	}

	@Override
	public void move(List<Object> values)
	{
		// TODO Auto-generated method stub
		
	}

}
