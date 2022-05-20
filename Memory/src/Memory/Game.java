package Memory;


import java.lang.Math;
import java.awt.BorderLayout;
import Memory.Panela;

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
import java.awt.Panel;
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
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class Game extends JFrame implements MouseListener{
    Panela[] arr = new Panela[16];
    public int points= 0;
    public int clicks = 0;
    public int openPanels = 0;
    private JPanel contentPane;
    private JFrame gui;
    JLabel lblNewLabel_1;
    JLabel lblNewLabel_3;

    /**
     * Create the game frame.
     */
    public Game(JFrame gui) {
        this.gui = gui;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Game");
        setBounds(100, 100, 600, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Label "Points"
        JLabel lblNewLabel = new JLabel("Points:");
        lblNewLabel.setBounds(533, 30, 61, 16);
        contentPane.add(lblNewLabel);

        // Exit Button
        JButton btnNewButton = new JButton("Exit");
        btnNewButton.addMouseListener(this);
        btnNewButton.setBounds(533, 543, 61, 23);
        contentPane.add(btnNewButton);

        // Fehler zählen Button
        JLabel lblNewLabel_2 = new JLabel("Faults");
        lblNewLabel_2.setBounds(533, 112, 61, 16);
        contentPane.add(lblNewLabel_2);

        this.lblNewLabel_3 = new JLabel("" + clicks);
        lblNewLabel_3.setBounds(533, 140, 61, 16);
        contentPane.add(lblNewLabel_3);

        // Points counter
        lblNewLabel_1 = new JLabel("0");
        lblNewLabel_1.setBounds(533, 58, 61, 16);
        contentPane.add(lblNewLabel_1);

        // Panels generieren
        for(int i=0; i<4; i++) {
            for(int j=0; j<4; j++) {
                arr[i*4+j] = new Panela(this);
                arr[i*4+j].setBounds(30+130*i, 30+130*j, 100, 100);
                contentPane.add(arr[i*4+j]);
            }
        }

        /*
         *  Ruft die Funktion setRandPlace mit den gewünschten Panel Farben auf
         *  Jede Farbe 2 mal
         *  Ist etwas unschön, jedoch die einfachste Lösung
         */
        setRandPlace(Color.blue);
        setRandPlace(Color.blue);

        setRandPlace(Color.red);
        setRandPlace(Color.red);

        setRandPlace(Color.green);
        setRandPlace(Color.green);

        setRandPlace(Color.pink);
        setRandPlace(Color.pink);

        setRandPlace(Color.orange);
        setRandPlace(Color.orange);

        setRandPlace(Color.yellow);
        setRandPlace(Color.yellow);

        setRandPlace(Color.CYAN);
        setRandPlace(Color.CYAN);

        setRandPlace(Color.magenta);
        setRandPlace(Color.magenta);
    }

    /*
     * Deefiniert das mouse clicket event
     * für das "umdrehen" der Panels oder das verbergen/ausblenden
     */
    public void mouseClicked(MouseEvent e) {
        this.gui.setVisible(true);
        this.setVisible(false);
    }

    /*
     * Überprüft ob die Panels die gleiche Farbe haben, mit dem Index i
     */
    public void checker() {
        int firstIndex = -1;
        for(int i=0; i<16; i++) {
            if(arr[i].blocked || !arr[i].flipped) {
                continue;
            }
            if(firstIndex ==-1) {
                firstIndex = i;
            }
            else {
                // wenn die Farben übereinstimmen
                if(arr[i].col == arr[firstIndex].col){
                    arr[i].blocked = true;
                    arr[firstIndex].blocked = true;
                    // setzt sichtbarkeit beider Panels auf false
                    arr[i].setVisible(false);
                    arr[firstIndex].setVisible(false);
                    // die Anzahl geöffneter Panels wieder auf 0
                    this.openPanels -=2;
                    // Punkte +1
                    points++;
                    lblNewLabel_1.setText("" + this.points);
                    // bei 8 Punkte ist das Spiel gewonnen, da es 16 Panels gibt
                    if(points==8) {
                        JOptionPane.showMessageDialog(this, "Spiel gewonnen!", "Gratulation", JOptionPane.WARNING_MESSAGE);
                    }
                }
                else {
                    // erhöht die Anzahl Clicks um 1
                    clicks++;
                    lblNewLabel_3.setText("" + this.clicks);
                }
            }
        }
    }

    /*
     * Ordnet den frames eine zufällige zahl zu um dann eine Farbe
     */
    public void setRandPlace(Color col) {
        while(true) {
            int i = (int)(Math.random()*16);
            if(arr[i].col==null) {
                arr[i].col = col;
                break;
            }
        }
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

