import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.FlowLayout;


public class GridTeste extends JPanel {
	
	public JLabel pai1 = new JLabel();
	public JLabel pai2 = new JLabel();
	public JLabel pai3 = new JLabel();
	public JLabel filho1 = new JLabel();
	public JLabel filho2 = new JLabel();
	public JLabel filho3 = new JLabel();
	public JButton militar = new JButton();
	
	/**
	 * Create the panel.
	 */
	public GridTeste() {
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
				
		JPanel panel1 = new JPanel();
		panel1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel1.setLayout(layout);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;		
		gbc.fill = GridBagConstraints.BOTH;		
		add(panel1,gbc);
		
		JPanel panel2 = new JPanel();
		//add(panel2, BorderLayout.CENTER);
		//panel2.setLayout(new BorderLayout(0, 0));
		panel2.setLayout(layout);
		
		GridBagConstraints gbc2 = new GridBagConstraints();
		gbc2.gridx = 1;
		gbc2.gridy = 0;
		gbc2.gridwidth = 1;
		gbc2.weightx = 2.0;
		gbc2.weighty = 1.0;
		gbc2.fill = GridBagConstraints.BOTH;
		add(panel2, gbc2);
		
		JPanel panel3 = new JPanel();
		panel3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel3.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc3 = new GridBagConstraints();
		gbc3.gridx = 2;
		gbc3.gridy = 0;
		gbc3.gridwidth = 1;
		gbc3.weightx = 1.0;
		gbc3.weighty = 1.0;		
		gbc3.fill = GridBagConstraints.BOTH;
		gbc3.anchor = GridBagConstraints.CENTER;
		add(panel3,gbc3);
			
		GridBagConstraints gbc4 = new GridBagConstraints();
		gbc4.gridx = 0;
		gbc4.gridy = 1;
		//gbc4.fill = GridBagConstraints.BOTH;
				
		GridBagConstraints gbc5 = new GridBagConstraints();
		gbc5.gridx = 0;
		gbc5.gridy = 2;
		//gbc5.fill = GridBagConstraints.BOTH;
		
		GridBagConstraints gbc6 = new GridBagConstraints();
		gbc6.gridx = 0;
		gbc6.gridy = 0;
		
		
		panel1.add(pai1,gbc6);
		panel1.add(pai2,gbc4);
		panel1.add(pai3,gbc5);
		
		panel2.add(militar, gbc2);
		
		panel3.add(filho1,gbc6);
		panel3.add(filho2,gbc4);
		panel3.add(filho3,gbc5);
	}
}
