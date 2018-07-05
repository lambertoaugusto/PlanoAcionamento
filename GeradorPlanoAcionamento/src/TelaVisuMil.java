import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class TelaVisuMil extends JPanel {
	
	public JLabel pai1 = new JLabel();
	public JLabel pai2 = new JLabel();
	public JLabel pai3 = new JLabel();
	public JLabel filho1 = new JLabel();
	public JLabel filho2 = new JLabel();
	public JLabel filho3 = new JLabel();
	public JButton militar = new JButton();	
	private TelaPrincipal tela;
	String end;
	
	/**
	 * Create the panel.
	 */
	public TelaVisuMil(TelaPrincipal t, String e, String m, String p1, String p2, String p3, String f1, String f2, String f3) {
		tela = t;
		end = e;
		militar.setText(m);
		pai1.setText(p1);
		pai2.setText(p2);
		pai3.setText(p3);
		filho1.setText(f1);
		filho2.setText(f2);
		filho3.setText(f3);
		militar.setFont(new Font("Tahoma", Font.PLAIN, 24));		
		
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
		JLabel param1 = new JLabel("abcdefghijklmnopqrstuvwxyz");
		param1.setForeground(param1.getBackground());		
		JLabel param2 = new JLabel("abcdefghijklmnopqrstuvwxyz");
		param2.setForeground(param2.getBackground());
		JLabel param3 = new JLabel("abcdefghijklmnopqrstuvwxyz");
		param3.setForeground(param3.getBackground());
		param3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		JLabel param4 = new JLabel("abcdefghijklmnopqrstuvwxyz");
		param4.setForeground(param4.getBackground());		
		param4.setFont(new Font("Tahoma", Font.PLAIN, 24));
		JLabel param5 = new JLabel("abcdefghijklmnopqrstuvwxyz");
		param5.setForeground(param5.getBackground());
		JLabel param6 = new JLabel("abcdefghijklmnopqrstuvwxyz");
		param6.setForeground(param6.getBackground());
				
		JPanel panel1 = new JPanel();
		panel1.setBounds(new Rectangle(300, 300));
		panel1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));		
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
		panel3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));		
		panel3.setBounds(new Rectangle(300, 300));
		panel3.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc3 = new GridBagConstraints();
		gbc3.gridx = 2;
		gbc3.gridy = 0;
		gbc3.gridwidth = 1;
		gbc3.weightx = 1.0;
		gbc3.weighty = 1.0;		
		gbc3.fill = GridBagConstraints.BOTH;
		//gbc3.anchor = GridBagConstraints.CENTER;
		add(panel3,gbc3);
			
		GridBagConstraints gbc4 = new GridBagConstraints();
		gbc4.gridx = 0;
		gbc4.gridy = 0;
		//gbc4.fill = GridBagConstraints.BOTH;
				
		GridBagConstraints gbc5 = new GridBagConstraints();
		gbc5.gridx = 0;
		gbc5.gridy = 1;
		//gbc5.fill = GridBagConstraints.BOTH;
		
		GridBagConstraints gbc6 = new GridBagConstraints();
		gbc6.gridx = 0;
		gbc6.gridy = 2;
		
		GridBagConstraints gbc7 = new GridBagConstraints();
		gbc7.gridx = 0;
		gbc7.gridy = 3;
		
		GridBagConstraints gbc8 = new GridBagConstraints();
		gbc8.gridx = 0;
		gbc8.gridy = 4;
				
		panel1.add(param1,gbc4);
		panel1.add(pai1,gbc5);
		panel1.add(pai2,gbc6);
		panel1.add(pai3,gbc7);
		panel1.add(param2,gbc8);
		
		
		GridBagConstraints gbc9 = new GridBagConstraints();
		gbc9.gridx = 0;
		gbc9.gridy = 1;
		gbc9.gridwidth = 1;
		gbc9.weightx = 2.0;
		gbc9.weighty = 1.0;
		gbc9.fill = GridBagConstraints.BOTH;
		panel2.add(param3,gbc4);
		panel2.add(militar, gbc9);
		panel2.add(param4,gbc6);		
		
		panel3.add(param5,gbc4);
		panel3.add(filho1,gbc5);
		panel3.add(filho2,gbc6);
		panel3.add(filho3,gbc7);
		panel3.add(param6,gbc8);	
		
		militar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					File caminho = new File("Militares");					
					if(caminho.exists()){
						FileReader fr2 = new FileReader(caminho);
						BufferedReader arq_rd2 = new BufferedReader(fr2);
						boolean achou = false;
						String tel_f1 = "";
						String tel_f2 = "";
						String tel_f3 = "";
						while(!achou && arq_rd2.ready()){
							String linha = arq_rd2.readLine();
							String[] argum = linha.split("<>");
							if(argum[0].equals(filho1.getText())){
								tel_f1 = argum[1];
							}
							else if(argum[0].equals(filho2.getText())){
								tel_f2 = argum[1];
							}
							else if(argum[0].equals(filho3.getText())){
								tel_f3 = argum[1];
							}
						}
						fr2.close();
						arq_rd2.close();
						new TelaImprimir(tela, militar.getText(), filho1.getText()+"\n"+tel_f1, filho2.getText()+"\n"+tel_f2, filho3.getText()+"\n"+tel_f3,false);
					}
					else{
						JOptionPane.showMessageDialog(tela, "Erro: não foi encontrado o arquivo dos militares cadastrados!");
					}
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(tela, "Erro ao tentar acessar o arquivo dos militares cadastrados!");
				}
			}
		});
	}
}


/*import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;


public class TelaVisuMil extends JPanel {
	public JLabel pai1 = new JLabel("");
	public JLabel pai2 = new JLabel("");
	public JLabel pai3 = new JLabel("");
	public JLabel filho1 = new JLabel("");
	public JLabel filho2 = new JLabel("");
	public JLabel filho3 = new JLabel("");
	public JButton militar = new JButton("");

	public TelaVisuMil() {
		setLayout(new BorderLayout(0, 0));	
		
		JPanel panel = new JPanel();		
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		add(panel, BorderLayout.WEST);
		panel.setLayout(new BorderLayout(0, 0));		
		
		JPanel panel_3 = new JPanel();		
		panel.add(panel_3, BorderLayout.NORTH);		
		
		panel_3.add(pai1);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4, BorderLayout.CENTER);
		
		
		panel_4.add(pai2);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5, BorderLayout.SOUTH);
		
		
		panel_5.add(pai3);
		
		JPanel panel_1 = new JPanel();		
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		
		panel_1.add(militar, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		add(panel_2, BorderLayout.EAST);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_2.add(panel_6, BorderLayout.NORTH);
		
		
		panel_6.add(filho1);		
		
		JPanel panel_7 = new JPanel();
		panel_2.add(panel_7, BorderLayout.CENTER);
		
		
		panel_7.add(filho2);
		
		JPanel panel_8 = new JPanel();
		panel_2.add(panel_8, BorderLayout.SOUTH);
		
		
		panel_8.add(filho3);

		//panel.getPreferredSize().width = 150;
		//panel.setPreferredSize(new Dimension(150,panel.getHeight()));
		//panel_2.getPreferredSize().width = 150;
		//panel_2.setPreferredSize(new Dimension(150,panel_2.getHeight()));
	}

}
*/