import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Calendar;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;


public class TelaVerPlanoInd extends JPanel {

	TelaPrincipal tela;
	JComboBox comboAno = new JComboBox();
	JButton btnOK = new JButton("OK");
	JComboBox comboMil = new JComboBox();
	JButton btnMil = new JButton("OK");
	
	/**
	 * Create the panel.
	 */
	public TelaVerPlanoInd(TelaPrincipal tp) {
		this.tela = tp;
		int ano = Calendar.getInstance().get(Calendar.YEAR);
		for(int i = 0; i < 10; i++){			
			comboAno.addItem(""+ano);
			ano++;
		}
		add(comboAno);		
		
		btnOK.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				btnOK.setVisible(false);
				try{	
					File caminho = new File("Plano "+comboAno.getSelectedItem());
					if(caminho.exists()){
						
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
		add(btnOK);		
		comboMil.setVisible(false);
		add(comboMil);		
		btnMil.setVisible(false);
		add(btnMil);

	}

}
