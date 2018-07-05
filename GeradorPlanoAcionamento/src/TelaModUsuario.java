import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JPasswordField;



public class TelaModUsuario extends JPanel{

	private TelaPrincipal tela;
	private JTextField login;
	private JPasswordField senha;	
	private Vector listaSenha = new Vector();
	private JComboBox comboBox = new JComboBox();
	private JLabel mensagem = new JLabel("");
	
	/**
	 * Create the panel.
	 */
	public TelaModUsuario(TelaPrincipal tp) {
		super();
		tela = tp;
		
		try{
			File caminho = new File("Usuario");
			if(caminho.exists()){
				FileReader fr = new FileReader(caminho);
				BufferedReader arq_rd = new BufferedReader(fr);				
				while(arq_rd.ready()){
					String linha = arq_rd.readLine();					
					String[] argum = linha.split("<>");
					comboBox.addItem(argum[0]);
					listaSenha.add(argum[1]);
				}
				fr.close();
				arq_rd.close();
			}
		}		
		catch(Exception e){
			JOptionPane.showMessageDialog(tela, "Erro ao tentar acessar o arquivo de Usu\u00E1rios Cadastrados!");
		}		
		
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(arg0.getStateChange() == ItemEvent.SELECTED){
					login.setText((String)comboBox.getSelectedItem());
					senha.setText((String)listaSenha.elementAt(comboBox.getSelectedIndex()));	
					mensagem.setText("");
				}
			}
		});
		
		add(comboBox);
		
		JLabel lblLogin = new JLabel("Login");
		add(lblLogin);
		
		login = new JTextField();
		add(login);
		login.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		add(lblSenha);
		
		senha = new JPasswordField();
		add(senha);
		senha.setColumns(10);
		
		JButton btnOk = new JButton("Modificar");
		add(btnOk);
		
		btnOk.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try{
					File caminho = new File("Usuario");				
					if(caminho.exists()){
						caminho.delete();
						caminho.createNewFile();
						FileWriter fw = new FileWriter(caminho,true);
						BufferedWriter arq = new BufferedWriter(new PrintWriter(fw));
						int ind = 0;						
						while(ind < listaSenha.size()){
							if(ind!=0){
								arq.newLine();
							}
							if(ind == comboBox.getSelectedIndex()){
								arq.write(login.getText()+"<>"+senha.getText());
								listaSenha.setElementAt(senha.getText(), ind);
								comboBox.setSelectedItem(login.getText());
							}
							else{
								arq.write(comboBox.getItemAt(ind)+"<>"+(String)listaSenha.elementAt(ind));
							}
							ind++;
						}
						arq.close();
						fw.close();
						//remove os elementos do combo box
						comboBox.removeAllItems();
						FileReader fr = new FileReader(caminho);
						BufferedReader arq_rd = new BufferedReader(fr);				
						while(arq_rd.ready()){
							String linha = arq_rd.readLine();					
							String[] argum = linha.split("<>");
							comboBox.addItem(argum[0]);							
						}
						fr.close();
						arq_rd.close();
						mensagem.setText("Usu\u00E1rio modificado!");
					}
					else{
						JOptionPane.showMessageDialog(tela, "Erro ao tentar acessar o arquivo de Usu\u00E1rios Cadastrados!");
					}
					
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(tela, "Erro ao tentar acessar o arquivo de Usu\u00E1rios Cadastrados!");
				}
			}
		});
		
		login.setText((String)comboBox.getSelectedItem());
		senha.setText((String)listaSenha.elementAt(comboBox.getSelectedIndex()));
		
		mensagem.setForeground(Color.GREEN);
		add(mensagem);
				
		tela.scrollPane.setViewportView(this);
		this.setVisible(true);	
	}	
}
