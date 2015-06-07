package controleur;

import java.util.List;

import model.Piece;
import model.Position;

public class SimpleMove implements Move 
{
	/**
	 * la piece � bouger
	 */
	private Piece piece;
	
	/**
	 * Obtient la piece � bouger
	 * @return la piece � bouger
	 */
	public Piece getPiece()
	{
		return piece;
	}
	
	/**
	 * D�finit la piece � bouger
	 * @param value la piece � bouger
	 */
	private void setPiece(Piece value)
	{
		piece = value;
	}
	
	/**
	 * Constructeur
	 * @param piece la piece � bouger
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
