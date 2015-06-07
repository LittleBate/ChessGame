package controleur;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Cavalier;
import model.ComboboxModelPieceJouable;
import model.ComboboxModelPositionPossible;
import model.Dame;
import model.Fou;
import model.EchiquierModel;
import model.IPiece;
import model.Piece;
import model.PieceDescripteur;
import model.Pion;
import model.Position;
import model.Roi;
import model.Tour;

public class GameControleur 
{
	/**
	 * Instance unique de la classe GameControleur
	 */
	private static GameControleur instance;
	
	/**
	 * Constructeur priv� de la classe GameControleur
	 */
	private GameControleur()
	{
		pieces = new HashMap<>();
		undoList = new ArrayList<>();
		redoList = new ArrayList<>();
	}
	
	/**
	 * Obtient l'instance unique de la classe GameControleur
	 * @return instance unique de GameControleur
	 */
	public static GameControleur getInstance()
	{
		if(instance == null)
			instance = new GameControleur();
		return instance;
	}
	
	/**
	 * Liste des actions affect�es durant la partie
	 */
	private List<CommandMove> undoList;
	
	/**
	 * Liste des actions annul�es
	 */
	private List<CommandMove> redoList;
	
	/**
	 * Dictionnaire repr�sentant les pi�ces qui si trouve sur l'�chiquier.
	 * Key : la position de la piece
	 * Value : La piece
	 */
	private Map<Position, Piece> pieces;
	
	/**
	 * Couleur du joueur dont c'est le tour de jeu.
	 */
	private Color joueurCourant;
	
	/**
	 * Obtient la liste de piece que peut jouer le joueur courant
	 * @return liste de pieces jouable par le joueur courant
	 */
	public List<IPiece> getPiecesJouable()
	{
		List<IPiece> pieces = new ArrayList<>();
		for(Piece piece : this.pieces.values())
		{
			if(piece.getColor().equals(getJoueurCourant()))
				pieces.add(piece);
		}			
		return pieces;
	}
	
	/**
	 * Obtient les positions possible avec la piece selectionn� par le joueur.
	 * @return la liste des positions possible
	 */
	public List<Position> getPositionJouable()
	{
		if(ComboboxModelPieceJouable.getInstance().getSelectedItem() == null)
			return null;
		IPiece piece = ((PieceDescripteur)ComboboxModelPieceJouable.getInstance()
				.getSelectedItem()).getPiece();
		return ((Piece)piece).getPositions();
	}
	
	/**
	 * Retourn true si il y a une situation d'echec et mat.
	 * Pas encore cod�.
	 */
	public boolean isEchecEtMat()
	{
		return false;
	}
	
	/**
	 * Retourne true si il y a une situation d'�galit�.
	 * Pas encore cod�
	 */
	public boolean isEgalite()
	{
		return false;
	}
	
	/**
	 * Retourne true si il y a une situation d'echec.
	 * Pas encore cod�
	 */
	public boolean isEchec()
	{
		return false;
	}
	
	/**
	 * Annule la derni�re action de jeu
	 */
	public void undo()
	{
		if(!undoList.isEmpty())
		{
			redoList.add(undoList.get(undoList.size() - 1));
			undoList.get(undoList.size() - 1).undo();
			undoList.remove(undoList.size() - 1);
			nextJoueur();
		}
	}
	
	/**
	 * Change le joueur courant
	 */
	private void nextJoueur() 
	{
		if(getJoueurCourant() == Color.WHITE)
			setJoueurCourant(Color.BLACK);
		else 
			setJoueurCourant(Color.WHITE);
		updatePieceJouable();
	}
	
	/**
	 * Met � jour la liste des piece que peut jouer le joueur
	 */
	public void updatePieceJouable()
	{
		ComboboxModelPieceJouable.getInstance().removeAllElements();
		for(IPiece piece : getPiecesJouable())
			ComboboxModelPieceJouable.getInstance().addElement(new PieceDescripteur(piece));
		ComboboxModelPieceJouable.getInstance().setSelectedItem(null);
	}
	
	/**
	 * r�execute la derni�re action de jeu annul�
	 */
	public void redo()
	{
		if(!redoList.isEmpty())
		{
			undoList.add(redoList.get(redoList.size() - 1));
			redoList.get(redoList.size() - 1).execute();
			redoList.remove(redoList.size() - 1);
			nextJoueur();
		}
	}
	
	/**
	 * Repositionne les pieces � l'�tat de d�but de partie.
	 */
	public void newGame()
	{
		setJoueurCourant(Color.WHITE);
		EchiquierModel.getInstance().removeAllElements(pieces.keySet());
		pieces.clear();
		for(Piece piece : creerPiece())
		{
			pieces.put(piece.getPosition(), piece);
		}
		EchiquierModel.getInstance().addAllElements(pieces.values());
		updatePieceJouable();
		ComboboxModelPieceJouable.getInstance().setSelectedItem(null);
		updatePositionPossible();
	}

	/**
	 * Obtient le joueur qui doit jouer
	 * @return couleur du joueur courant
	 */
	public Color getJoueurCourant()
	{
		return joueurCourant;
	}
	
	/**
	 * D�finit la couleur du joueur qui doit jouer
	 * @param value couleur du joueur
	 */
	public void setJoueurCourant(Color value)
	{
		joueurCourant = value;
	}
	
	/**
	 * Cr�ation de toutes le pieces de l'�chiquier 
	 * @return liste des pieces de l'�chiquier
	 */
	private List<Piece> creerPiece()
	{
		List<Piece> pieces = new ArrayList<>();
		
		pieces.addAll(creerNonPion(Color.WHITE, 7));
		pieces.addAll(creerPion(Color.WHITE, 6));
		pieces.addAll(creerNonPion(Color.BLACK, 0));
		pieces.addAll(creerPion(Color.BLACK, 1));
		
		return pieces;
	}
	
	/**
	 * Cr�ation de toutes les pi�ces d'une couleur donn�e qui ne sont pas des pions
	 * @param couleur couleur de la pi�ce (du joueur)
	 * @param row ligne de positionnement de la piece
	 * @return liste des pi�ces cr��
	 */
	private List<Piece> creerNonPion(Color couleur, int row)
	{
		List<Piece> pieces = new ArrayList<>();
		
		pieces.add(new Tour(couleur, new Position(row, 0)));
		pieces.add(new Tour(couleur, new Position(row, 7)));
		pieces.add(new Fou(couleur, new Position(row, 2)));
		pieces.add(new Fou(couleur, new Position(row, 5)));
		pieces.add(new Cavalier(couleur, new Position(row, 1)));
		pieces.add(new Cavalier(couleur, new Position(row, 6)));
		pieces.add(new Roi(couleur, new Position(row, 4)));
		pieces.add(new Dame(couleur, new Position(row, 3)));
		
		return pieces;
	}
	
	/**
	 * Cr�ation de tous les pions d'une couleur donn�e 
	 * @param couleur couleur des pions (du joueur)
	 * @param row ligne de positionnement des pions
	 * @return liste de piece cr��
	 */
	private List<Piece> creerPion(Color couleur, int row)
	{
		List<Piece> pieces = new ArrayList<>();
		
		for(int i = 0; i < 8; i++)
		{
			pieces.add(new Pion(couleur, new Position(row, i)));
		}
		
		return pieces;
	}
	
	/**
	 * Obtient la piece qui se trouve � la position pass� en param�tre
	 * @param position position cherch�
	 * @return la piece localis� � cette position
	 */
	public Piece getPieceAt(Position position)
	{
		return pieces.get(position);
	}
	
	/**
	 * Met � jour la liste des position que peut jouer le joudeur avec la piece selectionn�
	 */
	public void updatePositionPossible()
	{
		ComboboxModelPositionPossible.getInstance().removeAllElements();
		if(getPositionJouable() == null)
			return;
		for(Position position : getPositionJouable())
			ComboboxModelPositionPossible.getInstance().addElement(position);
		ComboboxModelPositionPossible.getInstance().setSelectedItem(null);
	}
	
	/**
	 * Effecctue un mouvement simple sur l'echiquier (deplacement d'une piece).
	 * Non utilisable dans le cas du roque, de la prise en passant et de 
	 * la transformation d'un pion
	 */
	public void JouerCoup()
	{
		PieceDescripteur dp = (PieceDescripteur)ComboboxModelPieceJouable.getInstance()
				.getSelectedItem();
		CommandMove move = new CommandSimpleMove(
				(Piece)dp.getPiece()
				, ((Position)ComboboxModelPositionPossible.getInstance().getSelectedItem()));
		undoList.add(move);
		move.execute();
		nextJoueur();
		updatePieceJouable();
		updatePositionPossible();
	}
	
	/**
	 * Ajoute ou modifie un piece dans le dictionnaire de piece
	 * @param piece la piece � ajouter ou � modifier
	 */
	public void putPiece(Piece piece)
	{
		pieces.put(piece.getPosition(), piece);
		

		EchiquierModel.getInstance()
			.setValueAt(piece, piece.getPosition().getRow(),
					piece.getPosition().getColumn() + 1);	
	}
	
	/**
	 * Supprime une piece du dictionnaire de piece
	 * @param piece piece � supprimer
	 */
	public void removePiece(Piece piece)
	{
		pieces.remove(piece.getPosition());

		EchiquierModel.getInstance()
			.setValueAt(null, piece.getPosition().getRow(), 
					piece.getPosition().getColumn() + 1);
	}
}
