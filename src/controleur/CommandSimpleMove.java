package controleur;

import java.util.ArrayList;
import java.util.List;

import model.Piece;
import model.Position;

public class CommandSimpleMove extends AbstractCommandMove
{
	/**
	 * Position de la piece avant de jouer
	 */
	private Position oldPosition;
	/**
	 * Piece qui était sur la case de destination avant de jouer
	 */
	private Piece oldPiece;
	/**
	 * La nouvelle position de la piece
	 */
	private Position newPosition;
	
	/**
	 * Obtient la nouvelle position de la piece
	 * @return
	 */
	public Position getNewPosition()
	{
		return newPosition;
	}
	
	/**
	 * Définit la nouvelle position de la piece
	 * @param value nouvelle position de la piece
	 */
	private void setNewPosition(Position value)
	{
		newPosition = value;
	}
	
	/**
	 * Obtient la position de la piece avant le mouvement
	 * @return ancienne position de la piece
	 */
	public Position getOldPosition()
	{
		return oldPosition;
	}

	/**
	 * Définit l'ancienne position de la piece
	 * @param value ancienne position de la piece
	 */
	private void setOldPosition(Position value)
	{
		oldPosition = value;
	}
	
	/**
	 * Obtient la piece qui était sur la case de destination avant le mouvement
	 * @return ancienne piece
	 */
	public Piece getOldPiece()
	{
		return oldPiece;
	}
	
	/**
	 * Définit la piece qui était sur la case de destination avant le mouvement
	 * @param value ancienne piece
	 */
	private void setOldPiece(Piece value)
	{
		oldPiece = value;
	}
	
	/**
	 * Constructeur de la command
	 * @param piece piece à bouger
	 * @param position position de destination
	 */
	public CommandSimpleMove(Piece piece, Position position) 
	{
		setOldPiece(GameControleur.getInstance().getPieceAt(position));
		setOldPosition(piece.getPosition());
		setNewPosition(position);
		setMove(new SimpleMove(piece));
	}
	
	@Override
	public void execute()
	{
		List<Object> params = new ArrayList<>();
		params.add(getNewPosition());
		getMove().move(params);
	}

	@Override
	public void undo() 
	{
		Piece piece = ((SimpleMove)getMove()).getPiece();
		GameControleur.getInstance().removePiece(piece);
		piece.setPosition(getOldPosition());
		GameControleur.getInstance().putPiece(piece);
		GameControleur.getInstance().putPiece(getOldPiece());
		
	}

}
