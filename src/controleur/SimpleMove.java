package controleur;

import java.util.List;

import model.Piece;
import model.Position;

public class SimpleMove implements Move 
{
	/**
	 * la piece à bouger
	 */
	private Piece piece;
	
	/**
	 * Obtient la piece à bouger
	 * @return la piece à bouger
	 */
	public Piece getPiece()
	{
		return piece;
	}
	
	/**
	 * Définit la piece à bouger
	 * @param value la piece à bouger
	 */
	private void setPiece(Piece value)
	{
		piece = value;
	}
	
	/**
	 * Constructeur
	 * @param piece la piece à bouger
	 */
	public SimpleMove(Piece piece)
	{
		setPiece(piece);
	}

	@Override
	public void move(List<Object> values)
	{
		Position position = (Position)values.get(0);
		
		GameControleur.getInstance().removePiece(getPiece());
		getPiece().setPosition(position);
		GameControleur.getInstance().putPiece(getPiece());
	}

}
