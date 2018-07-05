import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.FlowLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import java.awt.GridLayout;
import javax.swing.JTextField;

import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JSeparator;
import javax.swing.JButton;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;


public class CadastrarUsuario extends JPanel implements ActionListener {
	
	//private PlanoDeAcionamento plano;
	private TelaPrincipal tela;
	private JTextField textField;
	private JTextField login;
	private JPasswordField senha;
	JLabel mensagem = new JLabel("");
	JButton btnNewButton = new JButton("Cadastrar");
	
	public void inicializar(){
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Cadastrar Usu\u00E1rio");
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Sitka Small", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_1.add(panel_2, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("Login ");
		panel_2.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		
		login = new JTextField();
		login.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				mensagem.setVisible(false);
			}
		});
		panel_2.add(login);
		login.setColumns(20);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_4.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEADING);
		panel_3.add(panel_4, BorderLayout.NORTH);
		
		JLabel lblNewLabel_2 = new JLabel("Senha");
		panel_4.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		senha = new JPasswordField();
		panel_4.add(senha);
		senha.setColumns(20);
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_6.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEADING);
		panel_5.add(panel_6, BorderLayout.NORTH);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				try{
					File caminho = new File("Usuario");				
					boolean entrou = false;
					if(!caminho.exists()){
						caminho.createNewFile();
						entrou = true;
					}				
					FileWriter fw = new FileWriter(caminho,true);
					BufferedWriter arq = new BufferedWriter(new PrintWriter(fw));
					if(!entrou){
						arq.newLine();
					}
					arq.write(login.getText()+"<>"+senha.getText());
					arq.close();
					fw.close();			
					login.setText("");
					senha.setText("");
					mensagem.setText("Usu\u00E1rio cadastrado!");
					mensagem.setVisible(true);
					/*FileReader fr = new FileReader(caminho);
					BufferedReader arq_rd = new BufferedReader(fr);
					while(arq_rd.ready()){
						System.out.println(arq_rd.readLine());
					}
					fr.close();
					arq_rd.close();*/
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(tela, "Erro ao tentar acessar o arquivo de Usu\u00E1rios Cadastrados!");
				}
			}
		});
		panel_6.add(btnNewButton);		
		
		mensagem.setVisible(false);
		mensagem.setForeground(Color.GREEN);
		panel_6.add(mensagem);
		
		senha.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==arg0.VK_ENTER){
					btnNewButton.doClick();
				}
			}
		});
		
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{login, senha, btnNewButton}));
		
		this.setVisible(true);
	}
	
	public CadastrarUsuario(TelaPrincipal sp){		
		inicializar();		
		this.tela = sp;
	}	
	
	/*public PlanoDeAcionamento getPlano() {
		return plano;
	}

	public void setPlano(PlanoDeAcionamento plano) {
		this.plano = plano;
	}*/
	
	public void actionPerformed(ActionEvent arg0) {
		tela.scrollPane.setViewportView(this);
		this.setVisible(true);
	}
}