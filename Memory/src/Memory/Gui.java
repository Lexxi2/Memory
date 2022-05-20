package Memory;


import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

    public class Gui extends JFrame implements ActionListener {

        private JPanel contentPane;

		/**
         * Create the frame.
         */
        public Gui() {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setTitle("Memory");
            setBounds(100, 100, 600, 600);
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);
            contentPane.setLayout(null);

            JButton btnNewButton = new JButton("Start");
            btnNewButton.addActionListener(this);


            btnNewButton.setBounds(241, 100, 117, 29);
            contentPane.add(btnNewButton);

            String text = "This is a memory card Game";
            JLabel description = new JLabel(text);
            description.setBounds(36, 23, 300, 50);
            contentPane.add(description);
        }

        public void actionPerformed(ActionEvent e) {
            Game frame = new Game(this);
            frame.setVisible(true);
            this.setVisible(false);

        }
    }


