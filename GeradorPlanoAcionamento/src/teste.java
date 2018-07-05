import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.ImageObserver;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Canvas;
import java.text.AttributedCharacterIterator;
import javax.swing.JComboBox;


public class teste extends JPanel {
	
	public void paintComponent( Graphics g )
	{
		super.paintComponent( g );
        this.setBackground( Color.WHITE );
        
		g.setColor( Color.RED );
        g.drawLine( 5, 30, 380, 30 );

	}
	
	/**
	 * Create the frame.
	 */
	public teste() {
		this.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(136, 82, 58, 2);
		this.add(separator);
		
		JButton btnImprimir = new JButton("imprimir");
		btnImprimir.setBounds(10, 28, 89, 23);
		this.add(btnImprimir);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(185, 141, 28, 20);
		add(comboBox);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(267, 103, 97, 21);
		add(menuBar);
		
		JMenu mnNewMenu = new JMenu("New menu");
		mnNewMenu.setBounds(257, 103, 107, 22);
		add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
	}
}
