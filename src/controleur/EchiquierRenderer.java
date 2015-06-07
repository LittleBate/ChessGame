package controleur;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellRenderer;

import model.Piece;

public class EchiquierRenderer implements TableCellRenderer 
{

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column)
	{
		JTextField tf;
		if(value != null)
		{
			tf = new JTextField(value.toString());
			if(column != 0)
			{
				if(((Piece)value).getColor() == Color.WHITE)
					tf.setForeground(Color.BLUE);
				else
					tf.setForeground(Color.BLACK);
			}
		}
		else
			tf = new JTextField();
		
		return designTextField(tf, row, column);
	}

	/**
	 * Designe la case en fonction de sa position
	 * @param tf case à décorer
	 * @param row ligne de la case
	 * @param column colonne de la case
	 * @return
	 */
	private JTextField designTextField(JTextField tf, int row, int column)
	{
		if(column == 0)
			tf.setFont(new Font(tf.getFont().getName(), Font.BOLD, tf.getFont().getSize()));
		else
		{
			if((row % 2 == 0 && column % 2 == 0) || (row % 2 == 1 && column % 2 == 1))
				tf.setBackground(Color.GRAY);
			else
				tf.setBackground(Color.WHITE);	
			tf.setFont(new Font(tf.getFont().getName(), Font.BOLD, 50));
		}
		return tf;
	}
}
