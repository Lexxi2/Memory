package Memory;

import javax.swing.JPanel;
import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Canvas;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextPane;
import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;
import java.awt.Button;
import javax.swing.border.TitledBorder;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JButton;


public class Panela extends JPanel implements MouseListener{
	
	public boolean blocked = false;
	private Game game;
	public Color col;
	public boolean flipped = false;

	/**
	 * Create the panel.
	 */
	public Panela(Game game) {
		super();
		this.game = game;
		this.setBackground(Color.gray);
		this.addMouseListener(this);
	}
	
	// definiert den mouseClicked event -> setzt es auf blocked
	public void mouseClicked(MouseEvent e) {
		if(blocked) {
			return;
		}	
		
		// wenn die Panels nicht offen sind sollen diese Grau bleiben
		if(flipped) {
			this.setBackground(Color.gray);
			flipped = false;
			// geöffnete panels -1 (damit die Anzahl geöffneter Panels nie 2 übersteigt
			this.game.openPanels --;
		}
		else {
			if(this.game.openPanels >= 2) {
				return;
			}
			this.setBackground(col);
			flipped = true;
			this.game.openPanels ++;
			this.game.checker();
		}
		//flipped = !flipped;
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
