package model;

public class PieceDescripteur implements IPiece 
{
	/**
	 * La piece decrite
	 */
	private IPiece piece;
	
	/**
	 * Constructeur
	 * @param piece piece � d�crire
	 */
	public PieceDescripteur(IPiece piece)
	{
		this.piece = piece;
	}

	/**
	 * Obtient la piece d�crite
	 * @return la piece d�crite
	 */
	public IPiece getPiece()
	{
		return piece;
	}
	
	@Override
	public Position getPosition() 
	{
		return null;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(piece.getClass().getName().substring(6, 7));
		sb.append(" - ").append(piece.getPosition().toString());
		return sb.toString();
	}

}
