import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.eclipse.wb.swing.FocusTraversalOnArray;


public class TelaLoginTeste extends JPanel implements ActionListener{

	private TelaPrincipal tela;	
	private JTextField login;
	private JPasswordField senha;
	private JButton btnNewButton = new JButton("OK");
	/**
	 * Create the panel.
	 */
	public TelaLoginTeste(TelaPrincipal sp) {
		tela=sp;
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
		
		JLabel lbl_loginTit = new JLabel("Login");
		lbl_loginTit.setFont(new Font("Sitka Small", Font.BOLD, 18));
		lbl_loginTit.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lbl_login = new JLabel("Login ");		
		lbl_login.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_login.setHorizontalAlignment(SwingConstants.RIGHT);
		
		login = new JTextField();		
		login.setColumns(20);
		
		JLabel lbl_senha = new JLabel("Senha");
		lbl_senha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		senha = new JPasswordField();		
		senha.setColumns(20);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 5;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;		
		gbc.fill = GridBagConstraints.BOTH;		
		
		GridBagConstraints gbc_1 = new GridBagConstraints();
		gbc_1.gridx = 0;
		gbc_1.gridy = 1;
		gbc_1.gridwidth = 1;
		gbc_1.weightx = 1.0;
		gbc_1.weighty = 1.0;		
		gbc_1.fill = GridBagConstraints.BOTH;
		
		GridBagConstraints gbc_2 = new GridBagConstraints();
		gbc_2.gridx = 1;
		gbc_2.gridy = 1;
		gbc_2.gridwidth = 1;
		gbc_2.weightx = 1.0;
		gbc_2.weighty = 1.0;		
		gbc_2.fill = GridBagConstraints.BOTH;
		//gbc_2.anchor = GridBagConstraints.EAST;
		
		GridBagConstraints gbc_3 = new GridBagConstraints();
		gbc_3.gridx = 2;
		gbc_3.gridy = 1;
		gbc_3.gridwidth = GridBagConstraints.RELATIVE;
		gbc_3.weightx = 1.0;
		gbc_3.weighty = 1.0;		
		gbc_3.fill = GridBagConstraints.NONE;
		//gbc_2.anchor = GridBagConstraints.WEST;
		
		GridBagConstraints gbc_4 = new GridBagConstraints();
		gbc_4.gridx = 3;
		gbc_4.gridy = 1;
		gbc_4.gridwidth = 1;
		gbc_4.weightx = 1.0;
		gbc_4.weighty = 1.0;		
		gbc_4.fill = GridBagConstraints.BOTH;
		
		GridBagConstraints gbc_5 = new GridBagConstraints();
		gbc_5.gridx = 0;
		gbc_5.gridy = 2;
		gbc_5.gridwidth = 1;
		gbc_5.weightx = 1.0;
		gbc_5.weighty = 1.0;		
		gbc_5.fill = GridBagConstraints.BOTH;
		
		GridBagConstraints gbc_6 = new GridBagConstraints();
		gbc_6.gridx = 1;
		gbc_6.gridy = 2;
		gbc_6.gridwidth = 1;
		gbc_6.weightx = 1.0;
		gbc_6.weighty = 1.0;		
		gbc_6.fill = GridBagConstraints.NONE;
		//gbc_6.anchor = GridBagConstraints.EAST;
		
		GridBagConstraints gbc_7 = new GridBagConstraints();
		gbc_7.gridx = 2;
		gbc_7.gridy = 2;
		gbc_7.gridwidth = 1;
		gbc_7.weightx = 1.0;
		gbc_7.weighty = 1.0;		
		gbc_7.fill = GridBagConstraints.NONE;
		//gbc_6.anchor = GridBagConstraints.WEST;
		
		GridBagConstraints gbc_8 = new GridBagConstraints();
		gbc_8.gridx = 3;
		gbc_8.gridy = 2;
		gbc_8.gridwidth = 1;
		gbc_8.weightx = 1.0;
		gbc_8.weighty = 1.0;		
		gbc_8.fill = GridBagConstraints.BOTH;
		
		GridBagConstraints gbc_9 = new GridBagConstraints();
		gbc_9.gridx = 1;
		gbc_9.gridy = 3;
		gbc_9.gridwidth = 1;
		gbc_9.weightx = 1.0;
		gbc_9.weighty = 1.0;		
		gbc_9.fill = GridBagConstraints.NONE;
		
		add(lbl_loginTit,gbc);
		add(new JPanel(),gbc_1);
		add(lbl_login, gbc_2);
		add(login, gbc_3);
		add(new JPanel(),gbc_4);
		add(new JPanel(),gbc_5);
		add(lbl_senha, gbc_6);
		add(senha, gbc_7);
		add(new JPanel(),gbc_8);
		add(btnNewButton, gbc_9);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{					
					File caminho = new File("Usuario");					
					if(!caminho.exists()){					
						if(login.getText().equals("fab")&&new String(senha.getPassword()).equals("fab")){
							tela.menuUsuario.setEnabled(true);
						}
						else{	
							login.setText("");
							senha.setText("");
							JOptionPane.showMessageDialog(tela, "Entre com o login de administrador.");
						}
					}
					else{						
						FileReader fr = new FileReader(caminho);
						BufferedReader arq_rd = new BufferedReader(fr);
						boolean sair = false;
						while(arq_rd.ready()&&!sair){							
							String linha = arq_rd.readLine();
							if(login.getText().equals(linha.substring(0, linha.indexOf("<>")))){
								if(new String(senha.getPassword()).equals(linha.substring(linha.indexOf("<>")+2))){
									tela.menuMilitar.setEnabled(true);
									tela.menuUsuario.setEnabled(true);
									tela.menuPlano.setEnabled(true);
									tela.scrollPane.setViewportView(null);
									sair = true;
								}
								else{
									JOptionPane.showMessageDialog(tela, "Senha incorreta!");
								}
							}
							else{
								JOptionPane.showMessageDialog(tela, "Usu\u00E1rio não cadastrado!");								
							}
						}
						fr.close();
						arq_rd.close();
					}
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(tela, "Erro ao tentar acessar o arquivo de Usu\u00E1rios Cadastrados!");
				}
			}
		});	
		
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{login, senha, btnNewButton}));
	}
	
	public void actionPerformed(ActionEvent arg0) {
		tela.scrollPane.setViewportView(this);
		this.setVisible(true);
	}

}
