import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.SwingConstants;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Calendar;

import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;


public class TelaVerifGeral extends JPanel implements ActionListener{

	private TelaPrincipal tela;
	public JPanel areaVis = new JPanel();
	private Button button = new Button("OK");
	private Choice choice = new Choice();
	private JLabel lblNewLabel = new JLabel("Acionado por");
	private JLabel lblNewLabel_2 = new JLabel("Aciona");
	private JLabel lblNewLabel_1 = new JLabel("Militar");
	private Button imprimir = new Button("Imprimir Todos");
	/**
	 * Create the panel.
	 */
	public TelaVerifGeral(TelaPrincipal p) {
		this.tela = p;
		lblNewLabel.setVisible(false);
		lblNewLabel_2.setVisible(false);
		lblNewLabel_1.setVisible(false);
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		JLabel lblPlanoGeral = new JLabel("Plano Geral");
		lblPlanoGeral.setFont(new Font("Sitka Small", Font.BOLD, 30));
		panel.add(lblPlanoGeral);	
		
		JPanel panelEsc = new JPanel();
		panelEsc.setLayout(new BorderLayout(0,0));
		add(panelEsc, BorderLayout.CENTER);
		
		JPanel panelEsc2 = new JPanel();
		panelEsc2.setLayout(new BorderLayout(0,0));
		panelEsc.add(panelEsc2, BorderLayout.NORTH);
		
		JPanel panelLabels = new JPanel();
		panelLabels.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panelEsc2.add(panelLabels);
		JLabel lblAno = new JLabel("Ano");
		lblAno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelLabels.add(lblAno);
		lblAno.setHorizontalAlignment(SwingConstants.LEFT);	
		
		int ano = Calendar.getInstance().get(Calendar.YEAR);
		for(int i = 0; i < 10; i++){			
			choice.addItem(""+ano);
			ano++;
		}
		panelLabels.add(choice);
		panelLabels.add(button);
		panelLabels.add(imprimir);
		
		JPanel panel1 = new JPanel();
		panelEsc.add(panel1, BorderLayout.CENTER);		
		panel1.setLayout(new BorderLayout(0, 0));
		
		GridBagLayout layout = new GridBagLayout();		
		JPanel panel_2 = new JPanel();
		panel1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(layout);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(layout);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;		
		gbc.fill = GridBagConstraints.BOTH;		
		panel_2.add(panel_1, gbc);
		//panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JLabel param1 = new JLabel("abcdefghijklmnopqrstuvwxyz");
		//JLabel param4 = new JLabel("abcdefghijklmnopqrstuvwxyz");
		param1.setForeground(param1.getBackground());
		//param4.setForeground(param4.getBackground());
				
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		GridBagConstraints gbc4 = new GridBagConstraints();
		gbc4.gridx = 0;
		gbc4.gridy = 0;
		GridBagConstraints gbc5 = new GridBagConstraints();
		gbc5.gridx = 0;
		gbc5.gridy = 1;
		/*GridBagConstraints gbc6 = new GridBagConstraints();
		gbc5.gridx = 0;
		gbc5.gridy = 2;*/
		//param1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_1.add(param1,gbc4);
		panel_1.add(lblNewLabel,gbc5);
		//panel_1.add(param4,gbc6);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(layout);
		GridBagConstraints gbc2 = new GridBagConstraints();
		gbc2.gridx = 1;
		gbc2.gridy = 0;
		gbc2.gridwidth = 1;
		gbc2.weightx = 2.0;
		gbc2.weighty = 1.0;
		gbc2.fill = GridBagConstraints.BOTH;
		panel_2.add(panel_3, gbc2);
		
		JLabel param2 = new JLabel("abcdefghijklmnopqrstuvwxyz");
		param2.setForeground(param2.getBackground());
		//JLabel param5 = new JLabel("abcdefghijklmnopqrstuvwxyz");
		//param5.setForeground(param5.getBackground());
		
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		param2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_3.add(param2, gbc4);
		panel_3.add(lblNewLabel_1, gbc5);
		//panel_3.add(param5, gbc6);
		//panel_3.add(lblNewLabel_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(layout);
		GridBagConstraints gbc3 = new GridBagConstraints();
		gbc3.gridx = 2;
		gbc3.gridy = 0;
		gbc3.gridwidth = 1;
		gbc3.weightx = 1.0;
		gbc3.weighty = 1.0;		
		gbc3.fill = GridBagConstraints.BOTH;		
		panel_2.add(panel_4,gbc3);
		
		JLabel param3 = new JLabel("abcdefghijklmnopqrstuvwxyz");
		param3.setForeground(param3.getBackground());		
		//JLabel param6 = new JLabel("abcdefghijklmnopqrstuvwxyz");
		//param6.setForeground(param3.getBackground());
		
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 24));		
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		//param3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_4.add(param3,gbc4);
		panel_4.add(lblNewLabel_2,gbc5);
		//panel_4.add(param6,gbc6);
				
		panel1.add(areaVis, BorderLayout.CENTER);
		areaVis.setLayout(new BorderLayout(0, 0));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{	
					File caminho = new File("Plano "+choice.getSelectedItem());
					if(caminho.exists()){
						lblNewLabel.setVisible(true);
						lblNewLabel_2.setVisible(true);
						lblNewLabel_1.setVisible(true);
						FileReader fr2 = new FileReader(caminho);
						BufferedReader arq_rd2 = new BufferedReader(fr2);						
						JPanel ant = areaVis;
						while(arq_rd2.ready()){
							String linha = arq_rd2.readLine();
							String[] argum = linha.split("<>");
							TelaVisuMil mil = new TelaVisuMil(tela,"Plano "+choice.getSelectedItem(),argum[0],argum[1],argum[2],argum[3],argum[4],argum[5],argum[6]);
							ant.add(mil,BorderLayout.NORTH);
							JPanel prox = new JPanel();
							prox.setLayout(new BorderLayout(0, 0));
							ant.add(prox,BorderLayout.CENTER);
							ant = prox;
						}
						fr2.close();
						arq_rd2.close();
					}
					else{
						JOptionPane.showMessageDialog(tela, "Erro: não existe Plano de acionamento para o ano escolhido.");
					}
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(tela, "Erro ao tentar acessar o arquivo de Planos de acionamento ou dos militares cadastrados!");
				}
			}
		});
		imprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new TelaImprimirTodos(tela, "Plano "+choice.getSelectedItem());
			}
		});
		
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{choice, button}));		
	}
	
	public void actionPerformed(ActionEvent arg0) {
		tela.scrollPane.setViewportView(this);
		this.setVisible(true);
	}
}
