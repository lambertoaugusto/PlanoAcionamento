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



public class TelaModMilitar extends JPanel{

	private TelaPrincipal tela;
	private JTextField nome;
	private JTextField telefone;	
	private Vector listaTel = new Vector();
	//private Vector listaNomes = new Vector();
	private JComboBox comboBox = new JComboBox();
	private JLabel mensagem = new JLabel("");
	
	/**
	 * Create the panel.
	 */
	public TelaModMilitar(TelaPrincipal tp) {
		super();
		tela = tp;
		
		try{
			File caminho = new File("Militares");
			if(caminho.exists()){
				FileReader fr = new FileReader(caminho);
				BufferedReader arq_rd = new BufferedReader(fr);				
				while(arq_rd.ready()){
					String linha = arq_rd.readLine();					
					String[] argum = linha.split("<>");
					comboBox.addItem(argum[0]);					
					listaTel.add(argum[1]);
				}
				fr.close();
				arq_rd.close();
			}
		}		
		catch(Exception e){
			JOptionPane.showMessageDialog(tela, "Erro ao tentar acessar o arquivo de Militares Cadastrados!");
		}	
		
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(arg0.getStateChange() == ItemEvent.SELECTED){					
					nome.setText((String)comboBox.getSelectedItem());
					telefone.setText((String)listaTel.elementAt(comboBox.getSelectedIndex()));	
					mensagem.setText("");
				}
			}
		});		
		add(comboBox);
		
		JLabel lblNome = new JLabel("Nome de Guerra");
		add(lblNome);
		
		nome = new JTextField();
		add(nome);
		nome.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone");
		add(lblTelefone);
		
		telefone = new JTextField();
		add(telefone);
		telefone.setColumns(10);
		
		JButton btnOk = new JButton("Modificar");
		add(btnOk);
		
		btnOk.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try{
					File caminho = new File("Militares");				
					if(caminho.exists()){
						caminho.delete();
						caminho.createNewFile();
						FileWriter fw = new FileWriter(caminho,true);
						BufferedWriter arq = new BufferedWriter(new PrintWriter(fw));
						int ind = 0;						
						while(ind < listaTel.size()){
							if(ind!=0){
								arq.newLine();
							}
							if(ind == comboBox.getSelectedIndex()){
								arq.write(nome.getText()+"<>"+telefone.getText());
								listaTel.setElementAt(telefone.getText(), ind);
								//comboBox.setSelectedItem(nome.getText());															
							}
							else{
								arq.write(comboBox.getItemAt(ind)+"<>"+(String)listaTel.elementAt(ind));
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
						mensagem.setText("Militar modificado!");
					}					
					else{
						JOptionPane.showMessageDialog(tela, "Erro ao tentar acessar o arquivo de Militares Cadastrados!");
					}
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(tela, "Erro ao tentar acessar o arquivo de Militares Cadastrados!");
				}
			}
		});
		
		nome.setText((String)comboBox.getSelectedItem());
		telefone.setText((String)listaTel.elementAt(comboBox.getSelectedIndex()));
		
		mensagem.setForeground(Color.GREEN);
		add(mensagem);
				
		tela.scrollPane.setViewportView(this);
		this.setVisible(true);	
	}	
}
