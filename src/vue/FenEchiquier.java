package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controleur.EchiquierRenderer;
import controleur.GameControleur;

import model.Cavalier;
import model.ComboboxModelPieceJouable;
import model.ComboboxModelPositionPossible;
import model.Dame;
import model.Fou;
import model.EchiquierModel;
import model.IPiece;
import model.Pion;
import model.Position;
import model.Roi;
import model.Tour;

public class FenEchiquier extends JFrame implements ActionListener
{
	private static final long serialVersionUID = -4116115584850213246L;
	
	/**
	 * Bouton pour jouer un cou
	 */
	private JButton btnJouer;
	
	/**
	 * Combobox de selection d'une piece à jouer
	 */
	private JComboBox<IPiece> cbPieceAJouer;
	/**
	 * combobox de selection de la position à jouer
	 */
	private JComboBox<Position> cbPosition;
	
	/**
	 * MenuItem permetanr de lancer une nouvelle partie
	 */
	private JMenuItem miNewGame;
	/**
	 * MenuItem permettant de quitter le jeu
	 */
	private JMenuItem miQuitter;
	/**
	 * MenuItem permettant d'annuler le dernier coup jouer
	 */
	private JMenuItem miUndo;
	/**
	 * MenuItem permettant la reexecution d'une coup annulé
	 */
	private JMenuItem miRedo;
	
	/**
	 * Constructeur
	 */
	public FenEchiquier()
	{
		super("Echec");
		
		creerTousLesComposants();
		placerTousLesComposants();
		
		GameControleur.getInstance().newGame();
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.pack();
		this.setMinimumSize(this.getPreferredSize());
	}
	
	/**
	 * Crée un bouton avec un titre passé en paramètre et un actionListener 
	 * qui est la fenetre elle même.
	 * @param titre titre de bouton
	 * @return le bouton créé
	 */
	private JButton creerBouton(String titre)
	{
		JButton bouton = new JButton(titre);
		bouton.addActionListener(this);
		return bouton;
	}
	
	/**
	 * crée un menuitem avec un titre passé en paramètre et un actionlistener
	 * qui est la fenetre elle meme.
	 * @param titre titre du menuitem
	 * @return le menuitem cree
	 */
	private JMenuItem creerMenuItem(String titre)
	{
		JMenuItem menuItem = new JMenuItem(titre);
		menuItem.addActionListener(this);
		return menuItem;
	}
	
	/**
	 * cree un menu avec un titre passé en parametre et des menuitem.
	 * @param titre titre du menu
	 * @param items liste des menuitem contenu par le menu
	 * @return le menu cree
	 */
	private JMenu creerMenu(String titre, List<JMenuItem> items)
	{
		JMenu menu = new JMenu(titre);
		for(JMenuItem item : items)
		{
			menu.add(item);
		}
		return menu;
	}
	
	/**
	 * cree un panel de type flowlayout avec des composants.
	 * @param composants liste des composants contenu dans le panel
	 * @return le panel cree
	 */
	private JPanel creerPanelLigne(List<JComponent> composants)
	{
		JPanel panel = new JPanel(new FlowLayout());
		for(JComponent composant : composants)
		{
			panel.add(composant);
		}
		return panel;
	}
	
	/**
	 * cree un panel de type gridpanel avec un nombre de lignes et de colonnes
	 *  passé en paramètre et avec ses composants 
	 * @param row nombre de lignes
	 * @param column nombre de colonnes
	 * @param composants liste des composants contenu dans le panel
	 * @return le panel cree
	 */
	private JPanel creerPanelGrille(int row, int column, List<JComponent> composants)
	{
		JPanel panel = new JPanel(new GridLayout(row, column));
		for(JComponent composant : composants)
		{
			panel.add(composant);
		}
		return panel;
	}
	
	/**
	 * cree une table scrollable et qui a pour model la classe EchiquierModel
	 * @return JscrollPane contenant la table.
	 */
	private JScrollPane creerScrollTable()
	{
		JTable table = new JTable();
		table.setModel(EchiquierModel.getInstance());
		table.setDefaultRenderer(table.getColumnClass(0), new EchiquierRenderer());
		table.setRowHeight(70);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(table.getPreferredSize());
		return scrollPane;
	}
	
	/**
	 * creation de tous les composants stocké
	 */
	private void creerTousLesComposants()
	{
		btnJouer = creerBouton("Jouer");
		
		miNewGame = creerMenuItem("New Game");
		miQuitter = creerMenuItem("Quitter");
		miUndo = creerMenuItem("Undo");
		miRedo = creerMenuItem("Redo");
		
		creerLesCombobox();
	}
	
	/**
	 * creation des combobox de la fenêtre
	 */
	private void creerLesCombobox()
	{
		cbPieceAJouer = new JComboBox<>();
		cbPieceAJouer.setModel(ComboboxModelPieceJouable.getInstance());
		cbPieceAJouer.setPreferredSize(new Dimension(100, 20));
		cbPieceAJouer.addActionListener(this);
		cbPosition = new JComboBox<>();
		cbPosition.setModel(ComboboxModelPositionPossible.getInstance());
		cbPosition.setPreferredSize(new Dimension(100, 20));
		cbPosition.addActionListener(this);
	}
	
	/**
	 * positionnement de tous les elements de la fenetre
	 */
	private void placerTousLesComposants()
	{
		this.getContentPane().setLayout(new BorderLayout());
		
		this.getContentPane().add(creerScrollTable(), BorderLayout.CENTER);
		
		placerMenu();
		placerPanelDescription();
		placerPieceSelector();
	}
	
	/**
	 * construit et place le panel de selection de piece
	 */
	private void placerPieceSelector()
	{
		List<JComponent> composants = new ArrayList<JComponent>();
		
		composants.add(new JLabel("Pièce à jouer : "));
		composants.add(cbPieceAJouer);
		composants.add(new JLabel("Nouvelle position : "));
		composants.add(cbPosition);
		composants.add(btnJouer);
		
		this.getContentPane().add(creerPanelLigne(composants), BorderLayout.NORTH);
	}
	
	/**
	 * Construit le menu
	 */
	private void placerMenu()
	{
		JMenuBar menuBar = new JMenuBar();
		List<JMenuItem> menuContent = new ArrayList<>();
		
		menuContent.add(miNewGame);
		menuContent.add(miQuitter);
		menuBar.add(creerMenu("Fichier", menuContent));
		
		menuContent.clear();
		menuContent.add(miUndo);
		menuContent.add(miRedo);
		menuBar.add(creerMenu("Edition", menuContent));
		
		this.setJMenuBar(menuBar);
	}
	
	/**
	 * Cree et placer le panel de description des pieces
	 */
 	private void placerPanelDescription()
	{
		JPanel panelDescripteur = new JPanel(new BorderLayout());
		List<JComponent> descripteurs = new ArrayList<JComponent>();

		descripteurs.add(new JLabel(Fou.getDescription()));
		descripteurs.add(new JLabel(Tour.getDescription()));
		descripteurs.add(new JLabel(Cavalier.getDescription()));
		descripteurs.add(new JLabel(Dame.getDescription()));
		descripteurs.add(new JLabel(Roi.getDescription()));
		descripteurs.add(new JLabel(Pion.getDescription()));
		
		panelDescripteur.add(creerPanelGrille(6, 0, descripteurs), BorderLayout.NORTH);
		
		this.getContentPane().add(panelDescripteur, BorderLayout.EAST);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == miQuitter)
			this.dispose();
		if(e.getSource() == miNewGame)
			GameControleur.getInstance().newGame();
		if(e.getSource() == miUndo)
			GameControleur.getInstance().undo();
		if(e.getSource() == miRedo)
			GameControleur.getInstance().redo();
		if(e.getSource() == cbPieceAJouer)
		{
			if(cbPieceAJouer.getSelectedItem() != null)
				GameControleur.getInstance().updatePositionPossible();
		}
		if(e.getSource() == btnJouer)
		{
			if(ComboboxModelPieceJouable.getInstance().getSelectedItem() == null
					|| ComboboxModelPositionPossible.getInstance().getSelectedItem() == null)
			{
				
			}
			else
				GameControleur.getInstance().JouerCoup();
		}
	}

}
