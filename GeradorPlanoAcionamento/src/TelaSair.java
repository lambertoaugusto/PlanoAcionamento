import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;


public class TelaSair implements ActionListener{

	TelaPrincipal tela;
	/**
	 * Create the panel.
	 */
	public TelaSair(TelaPrincipal tp) {
		tela = tp;
	}
	public void actionPerformed(ActionEvent arg0) {
		tela.menuMilitar.setEnabled(false);
		tela.menuPlano.setEnabled(false);
		tela.menuUsuario.setEnabled(false);
		tela.scrollPane.setViewportView(new TelaLogin(tela));
	}

}
