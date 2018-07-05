import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;

import java.awt.Component;
import java.awt.Font;
import java.awt.FlowLayout;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Choice;
import java.awt.Button;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Random;
import java.util.Vector;

import jdk.internal.org.objectweb.asm.tree.JumpInsnNode;


public class TelaGerarPlano extends JPanel implements ActionListener{

	private TelaPrincipal tela;
	private JLabel lblGerarPlano = new JLabel("Gerar Plano");
	private Button button = new Button("OK");
	private Choice choice = new Choice();
	
	/**
	 * Create the panel.
	 */
	public TelaGerarPlano(TelaPrincipal t) {		
		this.tela = t;		
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);	
		
		lblGerarPlano.setFont(new Font("Sitka Small", Font.BOLD, 18));
		panel.add(lblGerarPlano);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblAno = new JLabel("Ano");
		lblAno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(lblAno);
		lblAno.setHorizontalAlignment(SwingConstants.LEFT);
				
		int ano = Calendar.getInstance().get(Calendar.YEAR);
		for(int i = 0; i < 10; i++){			
			choice.addItem(""+ano);
			ano++;
		}
		panel_2.add(choice);
				
		panel_2.add(button);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{					
					File caminho = new File("Plano "+choice.getSelectedItem());					
					if(!caminho.exists()){						
						File caminho2 = new File("Militares");
						if(caminho2.exists()){							
							FileReader fr2 = new FileReader(caminho2);
							BufferedReader arq_rd2 = new BufferedReader(fr2);						
							Vector militares = new Vector();						
							while(arq_rd2.ready()){
								String linha = arq_rd2.readLine();
								militares.add(new Militar(linha.substring(0, linha.indexOf("<>")),linha.substring(linha.indexOf("<>")+2)));
							}							
							if(militares.size() > 7){
								Militar[] random = new Militar[militares.size()];
								for(int i = 0; i < 4; i++){
									random[i] = (Militar)militares.elementAt(0);
									militares.removeElementAt(0);
								}
								Random r = new Random();
								int i = 4;
								while(militares.size()>0){
									int j = r.nextInt(militares.size());
									random[i] = ((Militar)militares.elementAt(j));
									militares.remove(j);
									i++;
								}
								PlanoDeAcionamento plano = new PlanoDeAcionamento(random);
								plano.gerarPlano();								
								//salvando o plano
								caminho.createNewFile();
								FileWriter fw = new FileWriter(caminho,true);
								BufferedWriter arq = new BufferedWriter(new PrintWriter(fw));
								for(int m =0; m < random.length; m++){
									if(m!=0){
										arq.newLine();
									}
									arq.write(random[m].getNomeDeGuerra()+"<>"+random[m].getPai_1()+"<>"+random[m].getPai_2()+"<>"+random[m].getPai_3()+"<>"+
											  random[m].getFilho_1()+"<>"+random[m].getFilho_2()+"<>"+random[m].getFilho_3()+"<>");
								}
								JOptionPane.showMessageDialog(tela, "Plano Gerado com sucesso!");
								arq.close();
								fw.close();							
							}
							else{								
								JOptionPane.showMessageDialog(tela, "Erro: é necessário pelo menos 8 usuários cadastrados para gerar o plano.");
							}						
							fr2.close();
							arq_rd2.close();
						}
						else{
							JOptionPane.showMessageDialog(tela, "Erro: não existe militares cadastrados!");							
						}
					}	
					else{
						int confirm = JOptionPane.showConfirmDialog(tela, "Já existe um plano de reunião para o ano escolhido, deseja excluir e gerar um novo?");
						if(confirm == JOptionPane.YES_OPTION){
							if(caminho.delete()){
								JOptionPane.showMessageDialog(tela, "Plano excluído.");
							}
							else{
								JOptionPane.showMessageDialog(tela, "Erro: não foi possível excluir o plano");
							}
						}
					}
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(tela, "Erro ao tentar acessar o arquivo de Planos de acionamento ou dos militares cadastrados!");
				}
				
			}
		});
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{choice, button}));
	}
	
	public void actionPerformed(ActionEvent arg0) {
		tela.scrollPane.setViewportView(this);
		this.setVisible(true);
	}
}
