import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;


public class TelaExcluirUsuario extends JPanel {

	private TelaPrincipal tela;
	JComboBox comboBox = new JComboBox();
	JLabel mensagem = new JLabel("");
	Vector listaSenha = new Vector();
	
	/**
	 * Create the panel.
	 */
	public TelaExcluirUsuario(TelaPrincipal tp) {
		tela = tp;		
		add(comboBox);
		
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
		
		
		JButton btnExcluir = new JButton("Excluir");
		add(btnExcluir);
		
		btnExcluir.addActionListener(new ActionListener() {
			
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
							if(ind != comboBox.getSelectedIndex()){
								if(ind!=0){
									arq.newLine();
								}
								arq.write(comboBox.getItemAt(ind)+"<>"+(String)listaSenha.elementAt(ind));
							}							
							ind++;
						}
						comboBox.removeItemAt(comboBox.getSelectedIndex());
						listaSenha.removeElementAt(comboBox.getSelectedIndex());
						arq.close();
						fw.close();
					}
					mensagem.setText("Usu\u00E1rio exclu\u00EDdo!");
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(tela, "Erro ao tentar acessar o arquivo de Usu\u00E1rios Cadastrados!");
				}
			}
		});
		
		mensagem.setForeground(Color.GREEN);
		add(mensagem);
		
		tela.scrollPane.setViewportView(this);
		this.setVisible(true);
	}

}
